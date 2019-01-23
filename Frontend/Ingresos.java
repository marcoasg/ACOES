package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Backend.Gasto;
import Backend.Ingreso;
import Backend.ProyectoLocal;
import Backend.Socio;
import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingresos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tCantidad;
	private JTextField tProcedencia;
	private JTextField tFecha;
	private Usuario user;
	private Ingreso seleccionado;
	private Date fInicio;
	private Date fFinal;
	private ProyectoLocal proyecto;
	
	public Ingresos(Usuario u, ProyectoLocal pr, Date fIni, Date fF) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = u;
		proyecto = pr;
		fInicio = fIni;
		fFinal = fF;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 762, 302);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "PROCEDENCIA", "CANTIDAD", "FECHA"
			}
		));
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		table.setRowSelectionAllowed(true);
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() != -1) {
					int i = table.getSelectedRow();
					TableModel modeloSeleccion = table.getModel();
					seleccionado = new Ingreso((int)modeloSeleccion.getValueAt(i, 0));
					
					tProcedencia.setText(Integer.toString(seleccionado.getSocio().getNumSocio()));
					tCantidad.setText(Double.toString(seleccionado.getCantidad()));
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
					String fecha = formatoDelTexto.format(seleccionado.getFecha());
					tFecha.setText(fecha);
				}
			}
		});
		
		try {
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			if(fInicio == null) fInicio= formatoDelTexto.parse("1492-01-01");
			if(fFinal == null) fFinal = new Date();
			for(Ingreso i:Ingreso.ListaIngresos(proyecto, fInicio, fFinal)) {
				addIngreso(i);
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(42, 347, 71, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblProcedencia = new JLabel("Procedencia:");
		lblProcedencia.setBounds(42, 385, 71, 14);
		contentPane.add(lblProcedencia);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(42, 424, 71, 14);
		contentPane.add(lblFecha);
		
		tCantidad = new JTextField();
		tCantidad.setBounds(123, 344, 277, 20);
		contentPane.add(tCantidad);
		tCantidad.setColumns(10);
		
		tProcedencia = new JTextField();
		tProcedencia.setColumns(10);
		tProcedencia.setBounds(123, 382, 277, 20);
		contentPane.add(tProcedencia);
		
		tFecha = new JTextField();
		tFecha.setColumns(10);
		tFecha.setBounds(123, 421, 277, 20);
		contentPane.add(tFecha);
		
		
		JButton btnRegistrarIngreso = new JButton("Registrar ingreso");
		btnRegistrarIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Object[] row = new Object[5];
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
				
					Date fecha = formatoDelTexto.parse(tFecha.getText());
					Ingreso nuevo = new Ingreso(Float.parseFloat(tCantidad.getText()), new Socio(Integer.parseInt(tProcedencia.getText()))
					, proyecto, fecha);
					addIngreso(nuevo);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnRegistrarIngreso.setBounds(523, 343, 137, 23);
		contentPane.add(btnRegistrarIngreso);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Balance ventana = new Balance(proyecto, user);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(523, 381, 137, 23);
		contentPane.add(btnVolver);
	}

	private void addIngreso(Ingreso i) {
		int numCols = table.getModel().getColumnCount();
		
		Object[] fila = new Object[numCols];
		fila[0] = i.getCodigo();
		fila[1] = i.getSocio();
		fila[2] = i.getCantidad();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = formatoDelTexto.format(i.getFecha());
		fila[3] = fecha;
		((DefaultTableModel) table.getModel()).addRow(fila);
	}
}

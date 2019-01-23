package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Backend.Gasto;
import Backend.ProyectoLocal;
import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gastos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tCantidad;
	private JTextField tBeneficiario;
	private JTextField tFecha;
	private Usuario user;
	private Gasto seleccionado;
	private ProyectoLocal proyecto;
	
	public Gastos(Usuario u, ProyectoLocal pr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = u;
		proyecto = pr;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 762, 302);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BENEFICIARIO", "CANTIDAD", "FECHA", "ESTADO"
			}
		));
		scrollPane.setViewportView(table);
		
		for(Gasto g:Gasto.ListaGastos(proyecto)) {
			rellenarTabla(g);
		}
		
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(42, 347, 71, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblBeneficiario = new JLabel("Beneficiario:");
		lblBeneficiario.setBounds(42, 385, 71, 14);
		contentPane.add(lblBeneficiario);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(42, 424, 71, 14);
		contentPane.add(lblFecha);
		
		tCantidad = new JTextField();
		tCantidad.setBounds(123, 344, 277, 20);
		contentPane.add(tCantidad);
		tCantidad.setColumns(10);
		
		tBeneficiario = new JTextField();
		tBeneficiario.setColumns(10);
		tBeneficiario.setBounds(123, 382, 277, 20);
		contentPane.add(tBeneficiario);
		
		tFecha = new JTextField();
		tFecha.setColumns(10);
		tFecha.setBounds(123, 421, 277, 20);
		contentPane.add(tFecha);
		
		JButton btnRegistrarGasto = new JButton("Registrar gasto");
		btnRegistrarGasto.setBounds(523, 343, 137, 23);
		contentPane.add(btnRegistrarGasto);
		
		JButton btnValidarGastos = new JButton("Validar gastos");
		btnValidarGastos.setBounds(523, 420, 137, 23);
		contentPane.add(btnValidarGastos);
		if(user.getRol().getRolName().equals("Coordinador local")) {
			btnValidarGastos.setVisible(true);
		}else {
			btnValidarGastos.setVisible(false);
		}
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(523, 381, 137, 23);
		contentPane.add(btnVolver);
	}

	private void rellenarTabla(Gasto g) {
		int numCols = table.getModel().getColumnCount();
		
		Object[] fila = new Object[numCols];
		fila[0] = g.getBeneficiario();
		fila[1] = g.getCantidad();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = formatoDelTexto.format(g.getFecha());
		fila[2] = fecha;
		if(g.getEstado() == false) {
			fila[3] = "Pendiente";
		}else {
			fila[3] = "Aceptado";
		}
		((DefaultTableModel) table.getModel()).addRow(fila);
	}
}

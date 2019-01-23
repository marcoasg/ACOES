package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Backend.Gasto;
import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ValidarGastos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Usuario usuario;
	private Gasto seleccionado;

	public ValidarGastos(Usuario u) {
		setTitle("Validar Gastos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 545, 302);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "BENEFICIARIO", "CANTIDAD", "FECHA"
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
					seleccionado = new Gasto((int)modeloSeleccion.getValueAt(i, 0));
					
					
				}
			}
		});
		for(Gasto g:Gasto.ListaGastos()) {
			addGasto(g);
		}
		scrollPane.setViewportView(table);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionado.validarGasto();
				ValidarGastos vg = new ValidarGastos(u);
				vg.setVisible(true);
				dispose();
			}
		});
		btnValidar.setBounds(43, 365, 108, 44);
		contentPane.add(btnValidar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionado.eliminarGasto();;
				ValidarGastos vg = new ValidarGastos(u);
				vg.setVisible(true);
				dispose();
			}
		});
		btnEliminar.setBounds(208, 365, 108, 44);
		contentPane.add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioHonduras g = new InicioHonduras(u);
				g.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(377, 365, 108, 44);
		contentPane.add(btnVolver);
	}
	private void addGasto(Gasto g) {
		int numCols = table.getModel().getColumnCount();
		
		Object[] fila = new Object[numCols];
		fila[0] = g.getCodigo();
		fila[1] = g.getBeneficiario();
		fila[2] = g.getCantidad();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = formatoDelTexto.format(g.getFecha());
		fila[3] = fecha;
		((DefaultTableModel) table.getModel()).addRow(fila);
	}
}

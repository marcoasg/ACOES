package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Gastos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tCantidad;
	private JTextField tBeneficiario;
	private JTextField tFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gastos frame = new Gastos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gastos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 762, 302);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PROYECTO", "BENEFICIARIO", "CANTIDAD", "FECHA"
			}
		));
		scrollPane.setViewportView(table);
		
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
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(523, 381, 137, 23);
		contentPane.add(btnVolver);
	}
}

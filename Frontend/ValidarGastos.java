package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ValidarGastos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Usuario usuario;

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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PROYECTO", "BENEFICIARIO", "CANTIDAD", "FECHA", "ESTADO"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.setBounds(43, 365, 108, 44);
		contentPane.add(btnValidar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(208, 365, 108, 44);
		contentPane.add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(377, 365, 108, 44);
		contentPane.add(btnVolver);
	}
}

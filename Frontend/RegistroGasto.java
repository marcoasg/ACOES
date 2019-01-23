package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Gasto;
import Backend.ProyectoLocal;
import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class RegistroGasto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public RegistroGasto(Usuario user, ProyectoLocal pr) {
		setTitle("Registro de gastos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setBounds(10, 33, 90, 14);
		contentPane.add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(124, 30, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBeneficiario = new JLabel("Beneficiario:");
		lblBeneficiario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBeneficiario.setBounds(10, 83, 112, 14);
		contentPane.add(lblBeneficiario);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 80, 168, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(10, 137, 96, 14);
		contentPane.add(lblFecha);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 134, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				Gasto g = new Gasto(Float.parseFloat(textField.getText()),textField_1.getText(),pr,formato.parse(textField_2.getText()));
				JOptionPane.showMessageDialog(null, "Gasto registrado con éxito.");
				Gastos gs = new Gastos(user,pr);
				gs.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(90, 206, 103, 32);
		contentPane.add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gastos g = new Gastos(user,pr);
				g.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(231, 212, 89, 23);
		contentPane.add(btnVolver);
	}
}

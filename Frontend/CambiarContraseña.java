package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambiarContraseña extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the frame.
	 */
	public CambiarContraseña(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContraseaAntigua = new JLabel("Contrase\u00F1a antigua:");
		lblContraseaAntigua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContraseaAntigua.setBounds(152, 32, 126, 14);
		contentPane.add(lblContraseaAntigua);
		
		JLabel lblContraseaNueva = new JLabel("Contrase\u00F1a nueva:");
		lblContraseaNueva.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContraseaNueva.setBounds(152, 93, 126, 14);
		contentPane.add(lblContraseaNueva);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(106, 57, 219, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(106, 118, 219, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblRepitaSuContrasea = new JLabel("Repita su contrase\u00F1a nueva:");
		lblRepitaSuContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRepitaSuContrasea.setBounds(133, 149, 179, 14);
		contentPane.add(lblRepitaSuContrasea);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(106, 174, 219, 20);
		contentPane.add(passwordField_2);
		
		JButton btnCambiarContrasea = new JButton("Cambiar contrase\u00F1a");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (new String(passwordField.getPassword()).equals(user.getPassword()) && new String(passwordField_1.getPassword()).equals(new String(passwordField_2.getPassword()))) {
						user.setPassword(new String(passwordField_1.getPassword()));
						JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito.");
						dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña antigua incorrecta o la nueva no coincide.");
				}
			}
		});
		btnCambiarContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCambiarContrasea.setBounds(142, 211, 149, 39);
		contentPane.add(btnCambiarContrasea);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}

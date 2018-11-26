package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.*;
import Backend.Error;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static JPasswordField passwordField;

	public Login() {
		setTitle("Inicio de sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setBounds(168, 171, 186, 16);
		contentPane.add(label_1);
		
		JLabel lblAcoes = new JLabel("ACOES");
		lblAcoes.setBounds(194, 30, 74, 19);
		lblAcoes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblAcoes);
		
		JLabel user_1 = new JLabel("Usuario:");
		user_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		user_1.setBounds(52, 83, 86, 29);
		contentPane.add(user_1);
		
		textField = new JTextField();
		textField.setBounds(168, 89, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel password = new JLabel("Contrase\u00F1a:");
		password.setFont(new Font("Tahoma", Font.BOLD, 15));
		password.setBounds(52, 134, 96, 29);
		contentPane.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 140, 122, 20);
		contentPane.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEntrar.setBounds(194, 221, 76, 29);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Usuario user = new Usuario(textField.getText(),passwordField.getPassword().toString());
				} catch (Error e) {
					// TODO Auto-generated catch block
					label_1.setText(e.getMessage());
				}
			}
		});
		contentPane.add(btnEntrar);
		
	}
}

package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static JPasswordField passwordField;

	public Login() {
		setTitle("Inicio de sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user = new JLabel("Usuario:");
		user.setBounds(78, 83, 62, 14);
		contentPane.add(user);
		
		JLabel password = new JLabel("Contrase\u00F1a:");
		password.setBounds(78, 154, 77, 14);
		contentPane.add(password);
		
		textField = new JTextField();
		textField.setBounds(162, 80, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnEntrar.setBounds(159, 205, 89, 23);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 151, 86, 20);
		contentPane.add(passwordField);
		
		JLabel lblAcoes = new JLabel("ACOES");
		lblAcoes.setBounds(183, 31, 46, 14);
		contentPane.add(lblAcoes);
	}
}

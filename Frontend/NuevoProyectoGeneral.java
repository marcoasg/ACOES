package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.ProyectoGeneral;
import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoProyectoGeneral extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Usuario user;

	/**
	 * Create the frame.
	 */
	public NuevoProyectoGeneral(Usuario u) {
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 30, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 131, 64, 14);
		contentPane.add(lblDescripcin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 226, 46, 14);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(10, 55, 195, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 156, 195, 52);
		contentPane.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 261, 195, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRegistrarProyecto = new JButton("Registrar proyecto");
		btnRegistrarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ProyectoGeneral pg = new ProyectoGeneral(textField.getText(),new Usuario(textField_1.getText()));
		pg.setDescripcion(textArea.getText());
					ProyectosGenerales p = new ProyectosGenerales(user);				
					
					

					p.setVisible(true);
					dispose();
				}catch(Error err) {
					JOptionPane.showMessageDialog(null,err.getMessage());
				}
			}
		});
		btnRegistrarProyecto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrarProyecto.setBounds(327, 145, 162, 45);
		contentPane.add(btnRegistrarProyecto);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProyectosGenerales p = new ProyectosGenerales(user);
				p.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(415, 11, 89, 23);
		contentPane.add(btnVolver);
	}
}

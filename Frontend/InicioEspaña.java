package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;

import Backend.Usuario;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class InicioEspaña extends JFrame {

	Usuario user;
	
	public InicioEspaña(Usuario u) {
		this.user = u;
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("ACOES España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 250);
		
		JLabel label = new JLabel("");
		label.setBounds(109, 55, 315, 14);
		getContentPane().add(label);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(69, 126, 89, 23);
		getContentPane().add(btnUsuarios);

		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					Usuarios usuarios = new Usuarios(user);
					usuarios.setVisible(true);
					dispose();
			}
		});
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.setBounds(205, 11, 128, 23);
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnCerrarSesin);
		if (user.getRol().getNivel() >= 2) getContentPane().add(btnUsuarios);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Perfil p = new Perfil(user);
				p.setVisible(true);
				dispose();
			}
		});
		btnPerfil.setBounds(69, 92, 89, 23);
		getContentPane().add(btnPerfil);
		
		JLabel lblMenu = new JLabel("Men\u00FA");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMenu.setBounds(91, 34, 46, 14);
		getContentPane().add(lblMenu);
		
		JButton btnSocios = new JButton("Socios");
		btnSocios.setBounds(69, 162, 89, 23);
		btnSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socios socios = new Socios(user);
				socios.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnSocios);
		
	}
}

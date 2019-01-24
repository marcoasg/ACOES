package Frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Usuario;

public class InicioAdmin extends JFrame {


	Usuario user;
	
	public InicioAdmin(Usuario u) {
		this.user = u;
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("ACOES (Administrador)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 261);
		
		JLabel label = new JLabel("");
		label.setBounds(109, 55, 315, 14);
		getContentPane().add(label);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(109, 131, 89, 23);
		getContentPane().add(btnUsuarios);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					Usuarios usuarios = new Usuarios(user);
					usuarios.setVisible(true);
					dispose();
			}
		});
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.setBounds(186, 11, 128, 23);
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
		btnPerfil.setBounds(109, 97, 89, 23);
		getContentPane().add(btnPerfil);
		
		JLabel lblMenu = new JLabel("Men\u00FA");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMenu.setBounds(130, 41, 46, 14);
		getContentPane().add(lblMenu);
		
	}

}

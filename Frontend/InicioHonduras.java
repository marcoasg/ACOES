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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Usuario;

public class InicioHonduras extends JFrame {


	Usuario user;
	
	public InicioHonduras(Usuario u) {
		this.user = u;
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("ACOES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("");
		label.setBounds(109, 55, 315, 14);
		getContentPane().add(label);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(10, 41, 89, 23);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					Usuarios usuarios = new Usuarios(user);
					usuarios.setVisible(true);
					dispose();
			}
		});
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.setBounds(295, 7, 128, 23);
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
		btnPerfil.setBounds(196, 7, 89, 23);
		getContentPane().add(btnPerfil);
		
		JLabel lblMenu = new JLabel("Men\u00FA");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMenu.setBounds(21, 16, 46, 14);
		getContentPane().add(lblMenu);
		
		JButton btnP = new JButton("Proyectos");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						ProyectosGenerales pr = new ProyectosGenerales(user);
						pr.setVisible(true);
						dispose();


			}
		});
		btnP.setBounds(158, 93, 104, 23);
		getContentPane().add(btnP);
		
		JButton btnNios = new JButton("Ni\u00F1os");
		btnNios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Niños n = new Niños(user);
				n.setVisible(true);
				dispose();
			}
		});
		btnNios.setBounds(158, 131, 104, 23);
		getContentPane().add(btnNios);
		
	}
}

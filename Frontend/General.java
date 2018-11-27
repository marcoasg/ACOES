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

public class General extends JFrame {

	
	public General() {
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("ACOES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.BOLD, 14));
		btnSalir.setBounds(335, 11, 89, 23);
		getContentPane().add(btnSalir);
		
		JButton btnConsultarUsuarios = new JButton("Consultar usuarios");
		btnConsultarUsuarios.setBounds(140, 176, 169, 23);
		getContentPane().add(btnConsultarUsuarios);
		
		JButton btnAadirUsuarios = new JButton("A\u00F1adir usuarios");
		btnAadirUsuarios.setBounds(140, 115, 169, 23);
		getContentPane().add(btnAadirUsuarios);
		
		JButton btnConsultarInformacionPropia = new JButton("Consultar perfil");
		btnConsultarInformacionPropia.setBounds(10, 12, 136, 23);
		getContentPane().add(btnConsultarInformacionPropia);
	}
}

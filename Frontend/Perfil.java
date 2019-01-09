package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Usuario;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Perfil extends JFrame {

	private JPanel contentPane;
	private Usuario user;
	private JTable table;
	private JLabel lblNombre;
	private JLabel label_2;
	private JLabel lblApellidos;
	private JLabel label_3;
	private JLabel lblNif;
	private JLabel label_4;
	private JLabel lblDireccin;
	private JLabel label_5;
	private JLabel lblProvincia;
	private JLabel label_6;
	private JLabel lblCdigoPostal;
	private JLabel label_7;
	private JLabel lblTelfonoFijo;
	private JLabel label_8;
	private JLabel lblTelfonoMvil;
	private JLabel label_9;
	private JLabel lblEmail;
	private JLabel label_10;
	private JButton btnNewButton;
	private JButton btnCambiarContrasea;
	
	public Perfil(Usuario u) {
		setTitle("Perfil");
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 248, 414, -237);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(167, 11, 159, 14);
		contentPane.add(label);
		label.setText(user.getUsuario());
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 57, 100, 14);
		contentPane.add(lblNombre);
		
		label_2 = new JLabel("");
		label_2.setBounds(168, 58, 257, 14);
		contentPane.add(label_2);
		label_2.setText(user.getNombre());
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(10, 82, 100, 14);
		contentPane.add(lblApellidos);
		
		label_3 = new JLabel("");
		label_3.setBounds(168, 83, 257, 14);
		contentPane.add(label_3);
		label_3.setText(user.getApellidos());
		
		lblNif = new JLabel("NIF:");
		lblNif.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNif.setBounds(10, 107, 100, 14);
		contentPane.add(lblNif);
		
		label_4 = new JLabel("");
		label_4.setBounds(168, 108, 257, 14);
		contentPane.add(label_4);
		label_4.setText(user.getNif());
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccin.setBounds(10, 132, 100, 14);
		contentPane.add(lblDireccin);
		
		label_5 = new JLabel("");
		label_5.setBounds(168, 133, 257, 14);
		contentPane.add(label_5);
		label_5.setText(user.getDireccion());
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProvincia.setBounds(10, 157, 100, 14);
		contentPane.add(lblProvincia);
		
		label_6 = new JLabel("");
		label_6.setBounds(168, 158, 257, 14);
		contentPane.add(label_6);
		label_6.setText(user.getProvincia());
		
		lblCdigoPostal = new JLabel("C\u00F3digo postal:");
		lblCdigoPostal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigoPostal.setBounds(10, 182, 100, 14);
		contentPane.add(lblCdigoPostal);
		
		label_7 = new JLabel("");
		label_7.setBounds(168, 183, 257, 14);
		contentPane.add(label_7);
		label_7.setText(""+user.getCodigoPostal());
		if (label_7.getText().charAt(0) == '-') {
			label_7.setText("");
		}
		
		lblTelfonoFijo = new JLabel("Tel\u00E9fono fijo:");
		lblTelfonoFijo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelfonoFijo.setBounds(11, 208, 100, 14);
		contentPane.add(lblTelfonoFijo);
		
		label_8 = new JLabel("");
		label_8.setBounds(168, 208, 257, 14);
		contentPane.add(label_8);
		label_8.setText(user.getTelefonoFijo());
		
		lblTelfonoMvil = new JLabel("Tel\u00E9fono m\u00F3vil:");
		lblTelfonoMvil.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelfonoMvil.setBounds(11, 233, 100, 14);
		contentPane.add(lblTelfonoMvil);
		
		label_9 = new JLabel("");
		label_9.setBounds(168, 233, 257, 14);
		contentPane.add(label_9);
		label_9.setText(user.getTelefonoMovil());
		
		lblEmail = new JLabel("e-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 257, 100, 14);
		contentPane.add(lblEmail);
		
		label_10 = new JLabel("");
		label_10.setBounds(168, 258, 257, 14);
		contentPane.add(label_10);
		label_10.setText(user.getEmail());
		
		btnNewButton = new JButton("Volver al men\u00FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame hall;
				
				if (user.getRol().getPais() == "ESP") {
					hall = new InicioEspaña(user);
				} else if (user.getRol().getPais() == "HON") {
					hall = new InicioHonduras(user);
				} else {
					hall = new InicioAdmin(user);
				}
				hall.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(332, 11, 112, 34);
		contentPane.add(btnNewButton);
		
		btnCambiarContrasea = new JButton("Cambiar contrase\u00F1a");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CambiarContraseña ventana = new CambiarContraseña(user);
				ventana.setVisible(true);
			}
		});
		btnCambiarContrasea.setBounds(10, 30, 175, 23);
		contentPane.add(btnCambiarContrasea);
	}
}

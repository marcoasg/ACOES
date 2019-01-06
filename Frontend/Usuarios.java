package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.Usuario;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	Usuario user;
	
	public Usuarios(Usuario u) {
		
		JSpinner spinner = new JSpinner();
		getContentPane().add(spinner, BorderLayout.NORTH);
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Usuario[] lista = Usuario.ListaUsuarios();
		String[] usuarios = new String[lista.length];
		int i = 0;
		for (Usuario us : lista) {
			usuarios[i] = us.getUsuario();
			i++;
		}
		contentPane.setLayout(null);
		
		JList list = new JList(usuarios);
		list.setBounds(10, 11, 794, 103);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		contentPane.add(list);
		
		JLabel label_1 = new JLabel("Datos del usuario ");
		label_1.setBounds(10, 125, 132, 14);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(label_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 162, 132, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(136, 125, 172, 14);
		lblNewLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(105, 162, 320, 14);
		contentPane.add(label);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(10, 187, 79, 14);
		contentPane.add(lblApellidos);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(105, 187, 320, 14);
		contentPane.add(label_2);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRol.setBounds(10, 212, 46, 14);
		contentPane.add(lblRol);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(105, 212, 322, 14);
		contentPane.add(label_4);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(10, 237, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(105, 237, 322, 14);
		contentPane.add(label_5);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNif.setBounds(10, 262, 46, 14);
		contentPane.add(lblNif);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(10, 287, 79, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCodigoPostal = new JLabel("Codigo Postal:");
		lblCodigoPostal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoPostal.setBounds(10, 312, 79, 14);
		contentPane.add(lblCodigoPostal);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProvincia.setBounds(10, 337, 79, 14);
		contentPane.add(lblProvincia);
		
		JLabel lblTelefonoFijomovil = new JLabel("Telefono Fijo/Movil:");
		lblTelefonoFijomovil.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefonoFijomovil.setBounds(10, 362, 132, 14);
		contentPane.add(lblTelefonoFijomovil);
		
		JLabel lblEmail = new JLabel("E_mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 387, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCertificado = new JLabel("Certificado:");
		lblCertificado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCertificado.setBounds(435, 162, 95, 14);
		contentPane.add(lblCertificado);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSector.setBounds(435, 190, 46, 14);
		contentPane.add(lblSector);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta:");
		lblFechaDeAlta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeAlta.setBounds(435, 215, 95, 14);
		contentPane.add(lblFechaDeAlta);
		
		JLabel lblFechaDeBaja = new JLabel("Fecha de Baja:");
		lblFechaDeBaja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeBaja.setBounds(435, 240, 95, 14);
		contentPane.add(lblFechaDeBaja);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObservaciones.setBounds(435, 265, 95, 14);
		contentPane.add(lblObservaciones);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(105, 262, 320, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(105, 287, 320, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(105, 312, 320, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(105, 337, 320, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(136, 362, 132, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(288, 390, 137, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(105, 387, 320, 14);
		contentPane.add(label_12);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(524, 162, 267, 14);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(524, 190, 267, 14);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(524, 215, 267, 14);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(524, 240, 267, 14);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(435, 283, 334, 53);
		contentPane.add(label_18);
		
		JButton btnRegistrarNuevoUsuario = new JButton("Registrar nuevo usuario");
		btnRegistrarNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrarNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro reg = new Registro(user);
				reg.setVisible(true);
				dispose();
			}
		});
		btnRegistrarNuevoUsuario.setBounds(435, 352, 172, 49);
		contentPane.add(btnRegistrarNuevoUsuario);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.setBounds(715, 420, 89, 23);
		contentPane.add(btnMen);
		
		JButton btnBorrarUsuario = new JButton("Desactivar usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario usuario = new Usuario((String) list.getSelectedValue());
				usuario.desactivaUsuario();
				label_17.setText(usuario.getFechaBaja().toString());
				JOptionPane.showMessageDialog(null, "Se ha dado de baja al usuario.");
			}
		});
		btnBorrarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrarUsuario.setBounds(435, 420, 172, 23);
		contentPane.add(btnBorrarUsuario);
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				General gen = new General(user);
				gen.setVisible(true);
				dispose();
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Usuario usuario = new Usuario((String) list.getSelectedValue());
				if (user.getRol().getNivel() >= usuario.getRol().getNivel()) {
					lblNewLabel.setText(usuario.getUsuario());
					label.setText(usuario.getNombre());
					label_2.setText(usuario.getApellidos());
					label_4.setText(usuario.getRol().getRolName());
					label_5.setText(usuario.getEstado());
					label_6.setText(usuario.getNif());
					label_7.setText(usuario.getDireccion());
					label_8.setText("" + usuario.getCodigoPostal());
					label_9.setText(usuario.getProvincia());
					label_10.setText(usuario.getTelefonoFijo());
					label_11.setText(usuario.getTelefonoMovil());
					label_12.setText(usuario.getEmail());
					label_14.setText(usuario.isCertificado() ? "Sí" : "No");
					label_15.setText(usuario.getSector());
					
					if (usuario.getFechaAlta() == null) {
						label_16.setText("");
					} else {
						label_16.setText(usuario.getFechaAlta().toString());
					}
					
					if (usuario.getFechaBaja() == null) {
						label_17.setText("");
					} else {
						label_17.setText(usuario.getFechaBaja().toString());

					}
					label_18.setText(usuario.getObservaciones());
				}
				
			}
		});

	}
}

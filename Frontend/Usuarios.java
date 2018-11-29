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
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

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
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		lblApellidos.setBounds(10, 187, 172, 14);
		contentPane.add(lblApellidos);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(105, 187, 320, 14);
		contentPane.add(label_2);
		
		JLabel lblNSocio = new JLabel("N\u00BA Socio:");
		lblNSocio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNSocio.setBounds(10, 215, 79, 14);
		contentPane.add(lblNSocio);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(105, 215, 322, 14);
		contentPane.add(label_3);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRol.setBounds(10, 240, 46, 14);
		contentPane.add(lblRol);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(105, 240, 322, 14);
		contentPane.add(label_4);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(10, 265, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(105, 265, 322, 14);
		contentPane.add(label_5);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNif.setBounds(10, 290, 46, 14);
		contentPane.add(lblNif);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(10, 315, 79, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCodigoPostal = new JLabel("Codigo Postal:");
		lblCodigoPostal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoPostal.setBounds(10, 340, 79, 14);
		contentPane.add(lblCodigoPostal);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProvincia.setBounds(10, 365, 79, 14);
		contentPane.add(lblProvincia);
		
		JLabel lblTelefonoFijomovil = new JLabel("Telefono Fijo/Movil:");
		lblTelefonoFijomovil.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefonoFijomovil.setBounds(10, 390, 132, 14);
		contentPane.add(lblTelefonoFijomovil);
		
		JLabel lblEmail = new JLabel("E_mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 415, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblRelacin = new JLabel("Relaci\u00F3n:");
		lblRelacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelacin.setBounds(435, 162, 79, 14);
		contentPane.add(lblRelacin);
		
		JLabel lblCertificado = new JLabel("Certificado:");
		lblCertificado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCertificado.setBounds(435, 187, 95, 14);
		contentPane.add(lblCertificado);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSector.setBounds(435, 215, 46, 14);
		contentPane.add(lblSector);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta:");
		lblFechaDeAlta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeAlta.setBounds(435, 240, 95, 14);
		contentPane.add(lblFechaDeAlta);
		
		JLabel lblFechaDeBaja = new JLabel("Fecha de Baja:");
		lblFechaDeBaja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeBaja.setBounds(435, 265, 95, 14);
		contentPane.add(lblFechaDeBaja);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObservaciones.setBounds(435, 290, 95, 14);
		contentPane.add(lblObservaciones);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(105, 290, 320, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(105, 315, 320, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(105, 340, 320, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(105, 365, 320, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(136, 390, 132, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(288, 390, 137, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(105, 415, 320, 14);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(524, 162, 267, 14);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(524, 187, 267, 14);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(524, 215, 267, 14);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(524, 240, 267, 14);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(524, 265, 267, 14);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(435, 308, 334, 53);
		contentPane.add(label_18);
		
		JButton btnRegistrarNuevoUsuario = new JButton("Registrar usuario");
		btnRegistrarNuevoUsuario.setBounds(441, 386, 150, 34);
		contentPane.add(btnRegistrarNuevoUsuario);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Usuario usuario = new Usuario((String) list.getSelectedValue());
				if (user.getRol().getNivel() >= usuario.getRol().getNivel()) {
					lblNewLabel.setText(usuario.getUsuario());
					label.setText(usuario.getNombre());
					label_2.setText(usuario.getApellidos());
					label_3.setText("" + usuario.getNumSocio());
					label_4.setText(usuario.getRol().getRolName());
					label_5.setText(usuario.getEstado());
					label_6.setText(usuario.getNif());
					label_7.setText(usuario.getDireccion());
					label_8.setText("" + usuario.getCodigoPostal());
					label_9.setText(usuario.getProvincia());
					label_10.setText(usuario.getTelefonoFijo());
					label_11.setText(usuario.getTelefonoMovil());
					label_12.setText(usuario.getEmail());
					label_13.setText(usuario.getRelacion());
					label_14.setText(usuario.isCertificado() ? "Sí" : "No");
					label_15.setText(usuario.getSector());
					label_16.setText(usuario.getFechaAlta().toString());
					label_17.setText(usuario.getFechaBaja().toString());
					label_18.setText(usuario.getObservaciones());
				}
				
			}
		});

	}
}

package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	Usuario user;
	Usuario seleccionado;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEstado;
	private JTextField textNIF;
	private JTextField textDireccion;
	private JTextField textCP;
	private JTextField textProvincia;
	private JTextField textTelefonoFijo;
	private JTextField textEmail;
	private JTextField textCertificado;
	private JTextField textSector;
	private JTextField textFechaAlta;
	private JTextField textFechaBaja;
	private JTextField textObservaciones;
	private JTextField textRol;
	private JTextField textTelfMovil;
	private JLabel lblNewLabel;
	private JTextField textBuscar;
	private JList list;
	private JScrollPane panel;
	
	private void actualizarVista(Usuario seleccionado) {
		if (user.getRol().getNivel() >= seleccionado.getRol().getNivel()) {
			lblNewLabel.setText(seleccionado.getUsuario());
			textNombre.setText(seleccionado.getNombre());
			textApellidos.setText(seleccionado.getApellidos());
			textRol.setText(seleccionado.getRol().getRolName());
			textEstado.setText(seleccionado.getEstado());
			textNIF.setText(seleccionado.getNif());
			textDireccion.setText(seleccionado.getDireccion());
			textCP.setText("" + seleccionado.getCodigoPostal());
			textProvincia.setText(seleccionado.getProvincia());
			textTelefonoFijo.setText(seleccionado.getTelefonoFijo());
			textTelfMovil.setText(seleccionado.getTelefonoMovil());
			textEmail.setText(seleccionado.getEmail());
			textCertificado.setText(seleccionado.isCertificado() ? "Sí" : "No");
			textSector.setText(seleccionado.getSector());
			
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			
			if (seleccionado.getFechaAlta() == null) {
				textFechaAlta.setText("");
			} else {
				String strFechaAlta = formatoDelTexto.format(seleccionado.getFechaAlta());
				textFechaAlta.setText(strFechaAlta);
			}
			
			if (seleccionado.getFechaBaja() == null) {
				textFechaBaja.setText("");
			} else {
				String strFechaBaja = formatoDelTexto.format(seleccionado.getFechaBaja());
				textFechaBaja.setText(strFechaBaja);

			}
			textObservaciones.setText(seleccionado.getObservaciones());
		}
		
	
	}
	
	public Usuarios(Usuario u) {
		
		JSpinner spinner = new JSpinner();
		seleccionado = null;
		getContentPane().add(spinner, BorderLayout.NORTH);
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Usuario[] lista = Usuario.ListaUsuarios();
		String[] usuarios = new String[lista.length];
		int i = 0;
		for (Usuario us : lista) {
			if (user.getRol().getRolName().equals("Administrador") || us.getRol().getPais().equals(user.getRol().getPais()))
				usuarios[i] = us.getUsuario();
			i++;
		}

		
		list = new JList(usuarios);
		list.setBounds(285, 11, 474, 103);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		panel = new JScrollPane(list);
		panel.setBounds(285,11,474,103);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Datos del usuario ");
		label_1.setBounds(10, 125, 132, 14);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(label_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 162, 132, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNombre);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(136, 125, 172, 14);
		lblNewLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		contentPane.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(10, 187, 79, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRol.setBounds(10, 212, 46, 14);
		contentPane.add(lblRol);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(10, 237, 46, 14);
		contentPane.add(lblEstado);
		
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
		
		JButton btnRegistrarNuevoUsuario = new JButton("Registrar nuevo usuario");
		btnRegistrarNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrarNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro reg = new Registro(user);
				reg.setVisible(true);
				dispose();
			}
		});
		btnRegistrarNuevoUsuario.setBounds(500, 418, 191, 24);
		contentPane.add(btnRegistrarNuevoUsuario);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.setBounds(715, 420, 89, 23);
		contentPane.add(btnMen);
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame hall;
				
				if (user.getRol().getPais().equals("ESP")) {
					hall = new InicioEspaña(user);
				} else if (user.getRol().getPais().equals("HON")) {
					hall = new InicioHonduras(user);
				} else {
					hall = new InicioAdmin(user);
				}
				hall.setVisible(true);
				dispose();
			}
		});
		
		JButton btnBorrarUsuario = new JButton("Desactivar usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionado.desactivaUsuario();
				JOptionPane.showMessageDialog(null, "Se ha dado de baja al usuario.");
				actualizarVista(seleccionado);
			}
		});
		btnBorrarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrarUsuario.setBounds(285, 419, 172, 23);
		contentPane.add(btnBorrarUsuario);
		
		textNombre = new JTextField();
		textNombre.setBounds(135, 159, 239, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(136, 184, 238, 20);
		contentPane.add(textApellidos);
		textApellidos.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setBounds(136, 234, 238, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		textNIF = new JTextField();
		textNIF.setBounds(135, 259, 239, 20);
		contentPane.add(textNIF);
		textNIF.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(136, 284, 238, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textCP = new JTextField();
		textCP.setBounds(136, 309, 239, 20);
		contentPane.add(textCP);
		textCP.setColumns(10);
		
		textProvincia = new JTextField();
		textProvincia.setBounds(136, 334, 239, 20);
		contentPane.add(textProvincia);
		textProvincia.setColumns(10);
		
		textTelefonoFijo = new JTextField();
		textTelefonoFijo.setBounds(136, 359, 86, 20);
		contentPane.add(textTelefonoFijo);
		textTelefonoFijo.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(135, 387, 239, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textCertificado = new JTextField();
		textCertificado.setBounds(521, 159, 86, 20);
		contentPane.add(textCertificado);
		textCertificado.setColumns(10);
		
		textSector = new JTextField();
		textSector.setBounds(521, 184, 86, 20);
		contentPane.add(textSector);
		textSector.setColumns(10);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setBounds(524, 209, 86, 20);
		contentPane.add(textFechaAlta);
		textFechaAlta.setColumns(10);
		
		textFechaBaja = new JTextField();
		textFechaBaja.setBounds(521, 234, 86, 20);
		contentPane.add(textFechaBaja);
		textFechaBaja.setColumns(10);
		
		textObservaciones = new JTextField();
		textObservaciones.setBounds(435, 284, 256, 57);
		contentPane.add(textObservaciones);
		textObservaciones.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(seleccionado == null) {
					
				}else {
					if(!textNombre.getText().equals(seleccionado.getNombre())) {
						seleccionado.setNombre(textNombre.getText());
					}
					if(!textApellidos.getText().equals(seleccionado.getApellidos())) {
						seleccionado.setApellidos(textApellidos.getText());
					}
					if(Rol.rolValido(textRol.getText(),seleccionado.getRol().getPais())) {
							user.ModiRol(seleccionado, new Rol(textRol.getText(),seleccionado.getRol().getPais()));
					} else {
						JOptionPane.showMessageDialog(null, "Rol no válido o no compatible en su país.");
					}
					
					if(!textEstado.getText().equals(seleccionado.getEstado())) {
						seleccionado.setEstado(textEstado.getText());
					}
					if(!textNIF.getText().equals(seleccionado.getNif())) {
						seleccionado.setNif(textNIF.getText());
					}
					if(!textDireccion.getText().equals(seleccionado.getDireccion())) {
						seleccionado.setDireccion(textDireccion.getText());
					}
					if(Integer.parseInt(textCP.getText()) != seleccionado.getCodigoPostal()) {
						seleccionado.setCodigoPostal(Integer.parseInt(textCP.getText()));
					}
					if(!textProvincia.getText().equals(seleccionado.getProvincia())) {
						seleccionado.setProvincia(textProvincia.getText());
					}
					if(!textTelefonoFijo.getText().equals(seleccionado.getTelefonoFijo())) {
						seleccionado.setTelefonoFijo(textTelefonoFijo.getText());
					}
					if(!textTelfMovil.getText().equals(seleccionado.getTelefonoMovil())) {
						seleccionado.setTelefonoMovil(textTelfMovil.getText());
					}
					if(!textEmail.getText().equals(seleccionado.getEmail())) {
						seleccionado.setEmail(textEmail.getText());
					}
					if(seleccionado.isCertificado() && textCertificado.getText().equals("No")) {
						seleccionado.setCertificado(false);
					}
					if(!seleccionado.isCertificado() && textCertificado.getText().equals("Sí")) {
						seleccionado.setCertificado(true);
					}
					if(!textSector.getText().equals(seleccionado.getSector())) {
						seleccionado.setSector(textSector.getText());
					}
					if(seleccionado.getFechaAlta() == null || (!textFechaAlta.getText().equals("") && !textFechaAlta.getText().equals(seleccionado.getFechaAlta().toString())) ) {
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String strFecha = textFechaAlta.getText();
						Date fechaAlta = null;
						try {
							fechaAlta = formatoDelTexto.parse(strFecha);
						} catch (ParseException e) {
							if (strFecha.length() != 0 || strFecha.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es válida.");
						}
						seleccionado.setFechaAlta(fechaAlta);
					}
					if(!textObservaciones.getText().equals(seleccionado.getObservaciones())) {
						seleccionado.setObservaciones(textObservaciones.getText());
					}
					
					JOptionPane.showMessageDialog(null, "Se ha actualizado el usuario.");
					actualizarVista(seleccionado);
					
				}
				
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizar.setBounds(445, 352, 172, 49);
		contentPane.add(btnActualizar);
		
		textRol = new JTextField();
		textRol.setBounds(136, 209, 238, 20);
		contentPane.add(textRol);
		textRol.setColumns(10);
		
		textTelfMovil = new JTextField();
		textTelfMovil.setBounds(232, 359, 86, 20);
		contentPane.add(textTelfMovil);
		textTelfMovil.setColumns(10);
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de usuarios:");
		lblListaDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeUsuarios.setBounds(164, 12, 111, 14);
		contentPane.add(lblListaDeUsuarios);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario[] lista = Usuario.ListaUsuarios();
				DefaultListModel<String> modelo = new DefaultListModel<>();
				int i = 0;
				for (Usuario us : lista) {
					if (user.getRol().getRolName().equals("Administrador") || us.getRol().getPais().equals(user.getRol().getPais())) {
						if (us.getUsuario().contains(textBuscar.getText()))
							modelo.addElement(us.getUsuario());
					}
					i++;
				}
				
				list.setModel(modelo);
			}
		});
		btnBuscar.setBounds(88, 91, 89, 23);
		contentPane.add(btnBuscar);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(43, 60, 179, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Usuario((String) list.getSelectedValue());
				actualizarVista(seleccionado);
			}
		});

	}
}

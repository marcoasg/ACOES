package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Socios extends JFrame {

	private JPanel contentPane;
	Usuario user;
	Socio seleccionado;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEstado;
	private JTextField textNIF;
	private JTextField textDireccion;
	private JTextField textCP;
	private JTextField textProvincia;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textCertificado;
	private JTextField textSector;
	private JTextField textFechaAlta;
	private JTextField textFechaBaja;
	private JTextField textObservaciones;
	private JTextField textRelacion;
	private JTextField textAgente;
	private JTextField textMovil;
	
	public Socios(Usuario u) {
		
		JSpinner spinner = new JSpinner();
		seleccionado = null;
		getContentPane().add(spinner, BorderLayout.NORTH);
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Socio[] lista = Socio.ListaSocios();
		String[] socios = new String[lista.length];
		int i = 0;
		for (Socio so : lista) {
			socios[i] = Integer.toString(so.getNumSocio());
			i++;
		}
		contentPane.setLayout(null);
		
		JList list = new JList(socios);
		list.setBounds(10, 11, 794, 103);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		contentPane.add(list);
		
		JLabel lblDatosDelSocio = new JLabel("Datos del socio");
		lblDatosDelSocio.setBounds(10, 114, 132, 14);
		lblDatosDelSocio.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDatosDelSocio);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 187, 132, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(136, 139, 172, 14);
		lblNewLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		contentPane.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(10, 212, 79, 14);
		contentPane.add(lblApellidos);
		
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
		
		JButton btnRegistrarNuevoSocio = new JButton("Registrar nuevo socio");
		btnRegistrarNuevoSocio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrarNuevoSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroSocio reg = new RegistroSocio(user);
				reg.setVisible(true);
				dispose();
			}
		});
		btnRegistrarNuevoSocio.setBounds(500, 418, 191, 24);
		contentPane.add(btnRegistrarNuevoSocio);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.setBounds(715, 420, 89, 23);
		contentPane.add(btnMen);
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				General gen = new General(user);
				gen.setVisible(true);
				dispose();
			}
		});
		
		JButton btnBorrarSocio = new JButton("Desactivar socio");
		btnBorrarSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socio socio = new Socio( Integer.parseInt((String) list.getSelectedValue()));
				socio.desactivaSocio();
				textFechaBaja.setText(socio.getFechaBaja().toString());
				JOptionPane.showMessageDialog(null, "Se ha dado de baja al socio.");
			}
		});
		btnBorrarSocio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrarSocio.setBounds(285, 419, 172, 23);
		contentPane.add(btnBorrarSocio);
		
		textNombre = new JTextField();
		textNombre.setBounds(136, 184, 239, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(136, 209, 238, 20);
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
		
		textTelefono = new JTextField();
		textTelefono.setBounds(136, 359, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
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
					if(textAgente.getText() != seleccionado.getAgente()) {
						seleccionado.setAgente(textAgente.getText());
					}if(textRelacion.getText() != seleccionado.getRelacion()) {
						seleccionado.setRelacion(textRelacion.getText());
					}
					if(textNombre.getText() != seleccionado.getNombre()) {
						seleccionado.setNombre(textNombre.getText());
					}
					if(textApellidos.getText() != seleccionado.getApellidos()) {
						seleccionado.setApellidos(textApellidos.getText());
					}
					if(textEstado.getText() != seleccionado.getEstado()) {
						seleccionado.setEstado(textEstado.getText());
					}
					if(textNIF.getText() != seleccionado.getNif()) {
						seleccionado.setNif(textNIF.getText());
					}
					if(textDireccion.getText() != seleccionado.getDireccion()) {
						seleccionado.setDireccion(textDireccion.getText());
					}
					if(Integer.parseInt(textCP.getText()) != seleccionado.getCodigoPostal()) {
						seleccionado.setCodigoPostal(Integer.parseInt(textCP.getText()));
					}
					if(textProvincia.getText() != seleccionado.getProvincia()) {
						seleccionado.setProvincia(textProvincia.getText());
					}
					if(textTelefono.getText() != seleccionado.getTelefonoFijo()) {
						seleccionado.setTelefonoFijo(textTelefono.getText());
					}
					if(textEmail.getText() != seleccionado.getEmail()) {
						seleccionado.setEmail(textEmail.getText());
					}
					if(seleccionado.isCertificado() && textCertificado.getText() == "No") {
						seleccionado.setCertificado(false);
					}
					if(!seleccionado.isCertificado() && textCertificado.getText() == "Si") {
						seleccionado.setCertificado(true);
					}
					if(textSector.getText() != seleccionado.getSector()) {
						seleccionado.setSector(textSector.getText());
					}
					if(textFechaAlta.getText() != seleccionado.getFechaAlta().toString() && textFechaAlta.getText() != "") {
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String strFecha = textFechaAlta.getText();
						Date fechaAlta = null;
						try {
							fechaAlta = formatoDelTexto.parse(strFecha);
						} catch (ParseException e) {
							if (strFecha.length() != 0 || strFecha.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es v�lida.");
						}
						u.setFechaAlta(fechaAlta);
					}
					if(textObservaciones.getText() != seleccionado.getObservaciones()) {
						seleccionado.setObservaciones(textObservaciones.getText());
					}
					
					JOptionPane.showMessageDialog(null, "Se ha actualizado el usuario.");
					
				}
				
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizar.setBounds(445, 352, 172, 49);
		contentPane.add(btnActualizar);
		
		JLabel lblAgente = new JLabel("Agente:");
		lblAgente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAgente.setBounds(10, 139, 46, 14);
		contentPane.add(lblAgente);
		
		JLabel lblRelacion = new JLabel("Relacion:");
		lblRelacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelacion.setBounds(10, 165, 63, 14);
		contentPane.add(lblRelacion);
		
		textRelacion = new JTextField();
		textRelacion.setBounds(136, 164, 238, 20);
		contentPane.add(textRelacion);
		textRelacion.setColumns(10);
		
		textAgente = new JTextField();
		textAgente.setBounds(136, 139, 238, 20);
		contentPane.add(textAgente);
		textAgente.setColumns(10);
		
		textMovil = new JTextField();
		textMovil.setBounds(252, 359, 86, 20);
		contentPane.add(textMovil);
		textMovil.setColumns(10);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Socio(Integer.parseInt((String) list.getSelectedValue()) );
					textAgente.setText(seleccionado.getAgente());
					textRelacion.setText(seleccionado.getRelacion());
					textNombre.setText(seleccionado.getNombre());
					textApellidos.setText(seleccionado.getApellidos());
					textEstado.setText(seleccionado.getEstado());
					textNIF.setText(seleccionado.getNif());
					textDireccion.setText(seleccionado.getDireccion());
					textCP.setText("" + seleccionado.getCodigoPostal());
					textProvincia.setText(seleccionado.getProvincia());
					textTelefono.setText(seleccionado.getTelefonoFijo());
					textMovil.setText(seleccionado.getTelefonoMovil());
					textEmail.setText(seleccionado.getEmail());
					textCertificado.setText(seleccionado.isCertificado() ? "S�" : "No");
					textSector.setText(seleccionado.getSector());
					
					if (seleccionado.getFechaAlta() == null) {
						textFechaAlta.setText("");
					} else {
						textFechaAlta.setText(seleccionado.getFechaAlta().toString());
					}
					
					if (seleccionado.getFechaBaja() == null) {
						textFechaBaja.setText("");
					} else {
						textFechaBaja.setText(seleccionado.getFechaBaja().toString());

					}
					textObservaciones.setText(seleccionado.getObservaciones());
				
				
			}
		});

	}
}
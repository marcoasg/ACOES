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

public class Niños extends JFrame {

	private JPanel contentPane;
	Usuario user;
	Niño seleccionado;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textCodigo;
	private JTextField textEstado;
	private JTextField textBeca;
	private JTextField textCP;
	private JTextField textProvincia;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textCertificado;
	private JTextField textSector;
	private JTextField textFechaAlta;
	private JTextField textFechaBaja;
	private JTextField textObservaciones;
	private JTextField textPadrino;
	private JTextField textMovil;
	
	public Niños(Usuario u) {
		
		JSpinner spinner = new JSpinner();
		seleccionado = null;
		getContentPane().add(spinner, BorderLayout.NORTH);
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Niño[] lista = Niño.ListaNiños();
		String[] niños = new String[lista.length];
		int i = 0;
		for (Niño n : lista) {
			niños[i] = Integer.toString(n.getCodigo());
			i++;
		}
		contentPane.setLayout(null);
		
		JList list = new JList(niños);
		list.setBounds(10, 11, 794, 103);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		contentPane.add(list);
		
		JLabel lblDatosDelNiño = new JLabel("Datos del niño");
		lblDatosDelNiño.setBounds(10, 114, 132, 14);
		lblDatosDelNiño.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblDatosDelNiño);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 139, 132, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(10, 164, 79, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(10, 237, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(10, 262, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblBeca = new JLabel("Beca:");
		lblBeca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBeca.setBounds(10, 287, 79, 14);
		contentPane.add(lblBeca);
		
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
		textNombre.setBounds(136, 136, 239, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(135, 161, 238, 20);
		contentPane.add(textApellidos);
		textApellidos.setColumns(10);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(136, 234, 238, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setBounds(135, 259, 239, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		textBeca = new JTextField();
		textBeca.setBounds(136, 284, 238, 20);
		contentPane.add(textBeca);
		textBeca.setColumns(10);
		
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
				
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizar.setBounds(445, 352, 172, 49);
		contentPane.add(btnActualizar);
		
		JLabel lblPadrino = new JLabel("Padrino:");
		lblPadrino.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPadrino.setBounds(10, 195, 63, 14);
		contentPane.add(lblPadrino);
		
		textPadrino = new JTextField();
		textPadrino.setBounds(136, 192, 238, 20);
		contentPane.add(textPadrino);
		textPadrino.setColumns(10);
		
		textMovil = new JTextField();
		textMovil.setBounds(252, 359, 86, 20);
		contentPane.add(textMovil);
		textMovil.setColumns(10);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Niño(Integer.parseInt((String) list.getSelectedValue()) );
					}
		});

	}
}

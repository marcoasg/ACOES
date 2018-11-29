package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Rol;
import Backend.Usuario;
import Backend.Error;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	Usuario user;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	
	public Registro(Usuario u) {
		setTitle("Registro");
		user = u;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelleneLosSiguientes = new JLabel("Rellene los siguientes campos con la informaci\u00F3n del nuevo usuario:");
		lblRelleneLosSiguientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelleneLosSiguientes.setBounds(121, 28, 389, 14);
		contentPane.add(lblRelleneLosSiguientes);
		
		JLabel lblUsuario = new JLabel("*Usuario:");
		lblUsuario.setBounds(33, 71, 89, 14);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(144, 68, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("*Contrase\u00F1a:");
		lblContrasea.setBounds(33, 96, 89, 14);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 93, 160, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRol = new JLabel("*Rol:");
		lblRol.setBounds(33, 121, 89, 14);
		contentPane.add(lblRol);
		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 118, 160, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(33, 146, 89, 14);
		contentPane.add(lblNombre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(144, 143, 160, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(33, 171, 89, 14);
		contentPane.add(lblApellidos);
		
		textField_4 = new JTextField();
		textField_4.setBounds(144, 168, 160, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(33, 196, 89, 14);
		contentPane.add(lblEstado);
		
		textField_5 = new JTextField();
		textField_5.setBounds(144, 193, 160, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setBounds(33, 221, 89, 14);
		contentPane.add(lblNif);
		
		textField_6 = new JTextField();
		textField_6.setBounds(144, 218, 160, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(33, 246, 89, 14);
		contentPane.add(lblDireccin);
		
		textField_7 = new JTextField();
		textField_7.setBounds(144, 243, 160, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo postal:");
		lblCdigoPostal.setBounds(33, 271, 89, 14);
		contentPane.add(lblCdigoPostal);
		
		textField_8 = new JTextField();
		textField_8.setBounds(144, 268, 160, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(33, 296, 89, 14);
		contentPane.add(lblProvincia);
		
		textField_9 = new JTextField();
		textField_9.setBounds(144, 293, 160, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblTelfonoFijo = new JLabel("Tel\u00E9fono fijo:");
		lblTelfonoFijo.setBounds(33, 321, 89, 14);
		contentPane.add(lblTelfonoFijo);
		
		textField_10 = new JTextField();
		textField_10.setBounds(144, 318, 160, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblTelfonoMvil = new JLabel("Tel\u00E9fono m\u00F3vil:");
		lblTelfonoMvil.setBounds(33, 346, 89, 14);
		contentPane.add(lblTelfonoMvil);
		
		textField_11 = new JTextField();
		textField_11.setBounds(144, 343, 160, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setBounds(348, 71, 89, 14);
		contentPane.add(lblEmail);
		
		textField_12 = new JTextField();
		textField_12.setBounds(447, 68, 160, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblRelacin = new JLabel("Relaci\u00F3n:");
		lblRelacin.setBounds(348, 96, 89, 14);
		contentPane.add(lblRelacin);
		
		textField_13 = new JTextField();
		textField_13.setBounds(447, 93, 160, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblCertificadosn = new JLabel("Certificado(S/N):");
		lblCertificadosn.setBounds(348, 121, 89, 14);
		contentPane.add(lblCertificadosn);
		
		textField_14 = new JTextField();
		textField_14.setBounds(447, 118, 160, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setBounds(348, 146, 89, 14);
		contentPane.add(lblSector);
		
		textField_15 = new JTextField();
		textField_15.setBounds(447, 143, 160, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblFechaAltayyyymmdd = new JLabel("Fecha alta (YYYY-MM-DD):");
		lblFechaAltayyyymmdd.setBounds(348, 171, 138, 14);
		contentPane.add(lblFechaAltayyyymmdd);
		
		textField_16 = new JTextField();
		textField_16.setBounds(496, 168, 111, 20);
		contentPane.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblFechaBajayyyymmdd = new JLabel("Fecha baja (YYYY-MM-DD):");
		lblFechaBajayyyymmdd.setBounds(348, 196, 138, 14);
		contentPane.add(lblFechaBajayyyymmdd);
		
		textField_17 = new JTextField();
		textField_17.setBounds(496, 193, 111, 20);
		contentPane.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(348, 221, 89, 14);
		contentPane.add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(348, 246, 259, 113);
		contentPane.add(textPane);
		
		JLabel lbllosCamposMarcados = new JLabel("*Los campos marcados con asterisco son obligatorios.");
		lbllosCamposMarcados.setBounds(144, 374, 265, 14);
		contentPane.add(lbllosCamposMarcados);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Rol r = new Rol(textField_2.getText());
					if (user.getRol().getNivel() <= r.getNivel()) {
						JOptionPane.showMessageDialog(null, "No puede registrar un usuario con un rol superior al suyo.");
					} else {
						Usuario u = new Usuario(textField.getText(),textField_1.getText(),r);
						u.setNombre(textField_3.getText());
						u.setApellidos(textField_4.getText());
						u.setEstado(textField_5.getText());
						u.setNif(textField_6.getText());
						u.setDireccion(textField_7.getText());
						u.setCodigoPostal(Integer.parseInt(textField_8.getText()));
						u.setProvincia(textField_9.getText());
						u.setTelefonoFijo(textField_10.getText());
						u.setTelefonoMovil(textField_11.getText());
						u.setEmail(textField_12.getText());
						u.setRelacion(textField_12.getText());
						boolean c = textField_13.getText() == "S" ? true : false;
						u.setCertificado(c);
						u.setSector(textField_14.getText());
						u.setFechaAlta(new Date(textField_15.getText()));
						u.setFechaBaja(new Date(textField_16.getText()));
						u.setObservaciones(textField_17.getText());
					 }
				} catch (Error e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton.setBounds(447, 370, 160, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblValoresParaRol = new JLabel("Valores para rol: Admin,CoordGen,CoordLoc,Agt");
		lblValoresParaRol.setBounds(144, 399, 259, 14);
		contentPane.add(lblValoresParaRol);
	}
}

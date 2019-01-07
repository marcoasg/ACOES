package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Rol;
import Backend.Usuario;
import Backend.Socio;
import Backend.Error;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistroSocio extends JFrame {

	private JPanel contentPane;
	Usuario user;
	private JTextField textField;
	private JTextField textField_1;
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
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	
	public RegistroSocio(Usuario u) {
		setTitle("Registrar un Socio");
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelleneLosSiguientes = new JLabel("Rellene los siguientes campos con la informaci\u00F3n del nuevo socio:");
		lblRelleneLosSiguientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelleneLosSiguientes.setBounds(121, 28, 389, 14);
		contentPane.add(lblRelleneLosSiguientes);
		
		JLabel lblUsuario = new JLabel("Agente");
		lblUsuario.setBounds(33, 71, 89, 14);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(144, 68, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Relaci\u00F3n");
		lblContrasea.setBounds(33, 96, 89, 14);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 93, 160, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(33, 124, 89, 14);
		contentPane.add(lblNombre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(144, 121, 160, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(33, 149, 89, 14);
		contentPane.add(lblApellidos);
		
		textField_4 = new JTextField();
		textField_4.setBounds(144, 146, 160, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(33, 174, 89, 14);
		contentPane.add(lblEstado);
		
		textField_5 = new JTextField();
		textField_5.setBounds(144, 171, 160, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setBounds(33, 199, 89, 14);
		contentPane.add(lblNif);
		
		textField_6 = new JTextField();
		textField_6.setBounds(144, 196, 160, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(33, 224, 89, 14);
		contentPane.add(lblDireccin);
		
		textField_7 = new JTextField();
		textField_7.setBounds(144, 221, 160, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo postal:");
		lblCdigoPostal.setBounds(33, 249, 89, 14);
		contentPane.add(lblCdigoPostal);
		
		textField_8 = new JTextField();
		textField_8.setBounds(144, 246, 160, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(33, 274, 89, 14);
		contentPane.add(lblProvincia);
		
		textField_9 = new JTextField();
		textField_9.setBounds(144, 271, 160, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblTelfonoFijo = new JLabel("Tel\u00E9fono fijo:");
		lblTelfonoFijo.setBounds(33, 299, 89, 14);
		contentPane.add(lblTelfonoFijo);
		
		textField_10 = new JTextField();
		textField_10.setBounds(144, 296, 160, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblTelfonoMvil = new JLabel("Tel\u00E9fono m\u00F3vil:");
		lblTelfonoMvil.setBounds(33, 324, 89, 14);
		contentPane.add(lblTelfonoMvil);
		
		textField_11 = new JTextField();
		textField_11.setBounds(144, 321, 160, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setBounds(348, 71, 89, 14);
		contentPane.add(lblEmail);
		
		textField_12 = new JTextField();
		textField_12.setBounds(447, 68, 160, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblCertificadosn = new JLabel("Certificado(S/N):");
		lblCertificadosn.setBounds(348, 99, 99, 14);
		contentPane.add(lblCertificadosn);
		
		textField_14 = new JTextField();
		textField_14.setBounds(447, 96, 160, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setBounds(348, 124, 89, 14);
		contentPane.add(lblSector);
		
		textField_15 = new JTextField();
		textField_15.setBounds(447, 121, 160, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblFechaAltayyyymmdd = new JLabel("Fecha alta (YYYY-MM-DD):");
		lblFechaAltayyyymmdd.setBounds(348, 149, 138, 14);
		contentPane.add(lblFechaAltayyyymmdd);
		
		textField_16 = new JTextField();
		textField_16.setBounds(496, 146, 111, 20);
		contentPane.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(348, 196, 99, 14);
		contentPane.add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(348, 221, 259, 99);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText()== "") {
					JOptionPane.showMessageDialog(null, "Introduzca un agente");
				}  else {
				try {
					
						Socio u = new Socio(textField.getText());
						u.setRelacion(textField_1.getText());
						u.setNombre(textField_3.getText());
						u.setApellidos(textField_4.getText());
						u.setEstado(textField_5.getText());
						u.setNif(textField_6.getText());
						u.setDireccion(textField_7.getText());
						if (textField_8.getText().length() != 0) u.setCodigoPostal(Integer.parseInt(textField_8.getText()));
						u.setProvincia(textField_9.getText());
						u.setTelefonoFijo(textField_10.getText());
						u.setTelefonoMovil(textField_11.getText());
						u.setEmail(textField_12.getText());
						boolean c = textField_14.getText() == "S" ? true : false;
						u.setCertificado(c);
						u.setSector(textField_15.getText());
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String strFecha = textField_16.getText();
						Date fechaAlta = null;
						try {
							fechaAlta = formatoDelTexto.parse(strFecha);
						} catch (ParseException e) {
							if (strFecha.length() != 0 || strFecha.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es válida.");
						}
						u.setFechaAlta(fechaAlta);
						u.setObservaciones(textPane.getText());
						
						
						
					
				} catch (Error e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}  finally {
					JOptionPane.showMessageDialog(null, "Se ha registrado al socio con éxito.");
					Socios us = new Socios(user);
					us.setVisible(true);
					dispose();
				}
			}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton.setBounds(447, 346, 160, 54);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socios u = new Socios(user);
				u.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(10, 388, 89, 23);
		contentPane.add(btnCancelar);
		

	}
}

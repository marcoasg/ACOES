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
import Backend.Niño;

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

public class RegistroNiños extends JFrame {

	private JPanel contentPane;
	Usuario user;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEstado;
	private JTextField textBeca;
	private JTextField textSexo;
	private JTextField textFechaEntrada;
	private JTextField textFechaNacimiento;
	private JTextField textFechaSalida;
	private JTextField textCurso;
	private JTextField textColoniaProcedencia;
	private JTextField textField_14;
	
	public RegistroNiños(Usuario u) {
		setTitle("Registrar un Socio");
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelleneLosSiguientes = new JLabel("Rellene los siguientes campos con la informaci\u00F3n del nuevo niño:");
		lblRelleneLosSiguientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelleneLosSiguientes.setBounds(121, 28, 389, 14);
		contentPane.add(lblRelleneLosSiguientes);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(33, 71, 89, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(144, 68, 160, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(33, 96, 89, 14);
		contentPane.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(144, 93, 160, 20);
		contentPane.add(textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(33, 135, 89, 14);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setBounds(144, 135, 160, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblBeca = new JLabel("Beca:");
		lblBeca.setBounds(33, 193, 89, 14);
		contentPane.add(lblBeca);
		
		textBeca = new JTextField();
		textBeca.setBounds(144, 190, 160, 20);
		contentPane.add(textBeca);
		textBeca.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(33, 224, 89, 14);
		contentPane.add(lblSexo);
		
		textSexo = new JTextField();
		textSexo.setBounds(144, 221, 160, 20);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel lblFechaEntrada = new JLabel("Fecha de entrada:");
		lblFechaEntrada.setBounds(33, 274, 101, 14);
		contentPane.add(lblFechaEntrada);
		
		textFechaEntrada = new JTextField();
		textFechaEntrada.setBounds(144, 271, 160, 20);
		contentPane.add(textFechaEntrada);
		textFechaEntrada.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setBounds(33, 249, 111, 14);
		contentPane.add(lblFechaNacimiento);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(144, 246, 160, 20);
		contentPane.add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		JLabel lblFechaSalida = new JLabel("FechaSalida:");
		lblFechaSalida.setBounds(33, 299, 89, 14);
		contentPane.add(lblFechaSalida);
		
		textFechaSalida = new JTextField();
		textFechaSalida.setBounds(144, 296, 160, 20);
		contentPane.add(textFechaSalida);
		textFechaSalida.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(33, 324, 89, 14);
		contentPane.add(lblCurso);
		
		textCurso = new JTextField();
		textCurso.setBounds(144, 321, 160, 20);
		contentPane.add(textCurso);
		textCurso.setColumns(10);
		
		JLabel lblColoniaProcedencia = new JLabel("Colonia de procedencia:");
		lblColoniaProcedencia.setBounds(348, 71, 120, 14);
		contentPane.add(lblColoniaProcedencia);
		
		textColoniaProcedencia = new JTextField();
		textColoniaProcedencia.setBounds(478, 68, 160, 20);
		contentPane.add(textColoniaProcedencia);
		textColoniaProcedencia.setColumns(10);
		
		JLabel lblColoniaResidencia = new JLabel("Colonia de residencia:");
		lblColoniaResidencia.setBounds(348, 99, 120, 14);
		contentPane.add(lblColoniaResidencia);
		
		textField_14 = new JTextField();
		textField_14.setBounds(478, 96, 160, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(348, 135, 99, 14);
		contentPane.add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(348, 160, 279, 128);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
						Niño n = new Niño();
						n.setNombre(textNombre.getText());
						n.setApellidos(textApellidos.getText());
						n.setEstado(textEstado.getText());
						n.setBeca(textBeca.getText());
						n.setSexo(textSexo.getText());
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String strFechaNacimiento = textFechaNacimiento.getText();
						Date fechaNacimiento = null;
						try {
							fechaNacimiento = formatoDelTexto.parse(strFechaNacimiento);
						} catch (ParseException e) {
							if (strFechaNacimiento.length() != 0 || strFechaNacimiento.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es válida.");
						}
						n.setFechaNacimiento(fechaNacimiento);
						u.setObservaciones(textPane.getText());
						
						String strFechaEntrada = textFechaEntrada.getText();
						Date fechaEntrada = null;
						try {
							fechaEntrada = formatoDelTexto.parse(strFechaEntrada);
						} catch (ParseException e) {
							if (strFechaEntrada.length() != 0 || strFechaEntrada.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es válida.");
						}
						n.setFechaNacimiento(fechaEntrada);
						
						String strFechaSalida = textFechaSalida.getText();
						Date fechaSalida = null;
						try {
							fechaSalida = formatoDelTexto.parse(strFechaSalida);
						} catch (ParseException e) {
							if (strFechaSalida.length() != 0 || strFechaSalida.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es válida.");
						}
						n.setFechaNacimiento(fechaSalida);
						u.setObservaciones(textPane.getText());
						
						
					
				} catch (Error e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}  finally {
					JOptionPane.showMessageDialog(null, "Se ha registrado al niño con éxito.");
					Niños n = new Niños(user);
					n.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton.setBounds(447, 346, 160, 54);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Niños n = new Niños(user);
				n.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(10, 388, 89, 23);
		contentPane.add(btnCancelar);
		

	}
}

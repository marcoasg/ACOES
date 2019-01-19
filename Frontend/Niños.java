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

public class Niños extends JFrame {
	
	private static String BD_SERVER = "localhost";
	private static String BD_NAME = "ACOES";
	private JPanel contentPane;
	private Usuario user;
	private Niño seleccionado;
	private Integer[] codigos;
	private JList list;
	private JScrollPane panel;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textCodigo;
	private JTextField textEstado;
	private JTextField textBeca;
	private JTextField textSexo;
	private JTextField textFechaNacimiento;
	private JTextField textFechaEntrada;
	private JTextField textFechaSalida;
	private JTextField textCurso;
	private JTextField textColoniaProcedencia;
	private JTextField textColoniaResidencia;
	private JTextField textObservaciones;
	private JTextField textBuscar;
	
	private void actualizarVista(Niño seleccionado) {
		if (user.getRol().getNivel() >= 2) {
			
			textNombre.setText(seleccionado.getNombre());
			textApellidos.setText(seleccionado.getApellidos());
			textCodigo.setText(Integer.toString(seleccionado.getCodigo()));
			textEstado.setText(seleccionado.getEstado());
			textBeca.setText(seleccionado.getBeca());
			textSexo.setText(seleccionado.getSexo());
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			
			if (seleccionado.getFechaNacimiento() == null) {
				textFechaNacimiento.setText("");
			} else {
				String strFechaNacimiento = formatoDelTexto.format(seleccionado.getFechaNacimiento());
				textFechaNacimiento.setText(strFechaNacimiento);
			}
			
			if (seleccionado.getFechaEntrada() == null) {
				textFechaEntrada.setText("");
			} else {
				String strFechaEntrada = formatoDelTexto.format(seleccionado.getFechaEntrada());
				textFechaEntrada.setText(strFechaEntrada);

			}
			if (seleccionado.getFechaSalida() == null) {
				textFechaSalida.setText("");
			} else {
				String strFechaSalida = formatoDelTexto.format(seleccionado.getFechaSalida());
				textFechaSalida.setText(strFechaSalida);

			}
			textCurso.setText(seleccionado.getCurso());
			textColoniaProcedencia.setText(seleccionado.getColoniaProcedencia());
			textColoniaResidencia.setText(seleccionado.getColoniaResidencia());
			
			textObservaciones.setText(seleccionado.getObservaciones());
		}
		
	
	}
	
	
	
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
		codigos = new Integer[lista.length];
		int i = 0;
		for (Niño n : lista) {
			codigos[i] = n.getCodigo();
			niños[i] = n.getNombre() + " " + n.getApellidos();
			i++;
		}
		contentPane.setLayout(null);
		
		list = new JList(niños);
		panel = new JScrollPane(list);
		list.setBounds(285, 11, 474, 103);
		panel.setBounds(285,11,474,103);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		contentPane.add(panel);
		
		
		
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
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setBounds(10, 312, 79, 14);
		contentPane.add(lblSexo);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNacimiento.setBounds(10, 337, 132, 14);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblFechaEntrada = new JLabel("Fecha de entrada:");
		lblFechaEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaEntrada.setBounds(10, 362, 132, 14);
		contentPane.add(lblFechaEntrada);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCurso.setBounds(435, 162, 95, 14);
		contentPane.add(lblCurso);
		
		JLabel lblColoniaProcedencia = new JLabel("Colonia de procedencia:");
		lblColoniaProcedencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColoniaProcedencia.setBounds(435, 190, 142, 14);
		contentPane.add(lblColoniaProcedencia);
		
		JLabel lblColoniaResidencia = new JLabel("Colonia de residencia:");
		lblColoniaResidencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColoniaResidencia.setBounds(435, 215, 142, 14);
		contentPane.add(lblColoniaResidencia);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObservaciones.setBounds(435, 265, 95, 14);
		contentPane.add(lblObservaciones);
		
		JButton btnRegistrarNuevoSocio = new JButton("Registrar nuevo ni\u00F1o");
		btnRegistrarNuevoSocio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrarNuevoSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroNiños reg = new RegistroNiños(user);
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
		
		JButton btnBorrarNiño = new JButton("Dar de baja ni\u00F1o");
		btnBorrarNiño.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Niño niño = new Niño( Integer.parseInt((String) list.getSelectedValue()));
				niño.desactivaNiño();
				textFechaSalida.setText(niño.getFechaSalida().toString());
				JOptionPane.showMessageDialog(null, "Se ha dado de baja al niño.");
			}
		});
		btnBorrarNiño.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrarNiño.setBounds(285, 419, 172, 23);
		contentPane.add(btnBorrarNiño);
		
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
		
		textSexo = new JTextField();
		textSexo.setBounds(136, 309, 239, 20);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(136, 334, 122, 20);
		contentPane.add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		textFechaEntrada = new JTextField();
		textFechaEntrada.setBounds(136, 359, 122, 20);
		contentPane.add(textFechaEntrada);
		textFechaEntrada.setColumns(10);
		
		textFechaSalida = new JTextField();
		textFechaSalida.setBounds(135, 387, 122, 20);
		contentPane.add(textFechaSalida);
		textFechaSalida.setColumns(10);
		
		textCurso = new JTextField();
		textCurso.setBounds(521, 159, 86, 20);
		contentPane.add(textCurso);
		textCurso.setColumns(10);
		
		textColoniaProcedencia = new JTextField();
		textColoniaProcedencia.setBounds(587, 187, 86, 20);
		contentPane.add(textColoniaProcedencia);
		textColoniaProcedencia.setColumns(10);
		
		textColoniaResidencia = new JTextField();
		textColoniaResidencia.setBounds(587, 212, 86, 20);
		contentPane.add(textColoniaResidencia);
		textColoniaResidencia.setColumns(10);
		
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
					if(!textEstado.getText().equals(seleccionado.getEstado())) {
						seleccionado.setEstado(textEstado.getText());
					}
					if(!textBeca.getText().equals(seleccionado.getBeca())) {
						seleccionado.setBeca(textBeca.getText());
					}
					if(!textSexo.getText().equals(seleccionado.getSexo())) {
						seleccionado.setSexo(textSexo.getText());
					}
					if(textFechaNacimiento.getText().length() > 0 && (seleccionado.getFechaNacimiento() == null || (!textFechaNacimiento.getText().equals("") && !textFechaNacimiento.getText().equals(seleccionado.getFechaNacimiento().toString()))) ) {
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String strFecha = textFechaNacimiento.getText();
						Date fechaNacimiento = null;
						try {
							fechaNacimiento = formatoDelTexto.parse(strFecha);
						} catch (ParseException e) {
							if (strFecha.length() != 0 || strFecha.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es válida.");
						}
						seleccionado.setFechaNacimiento(fechaNacimiento);
					}
					if(textFechaEntrada.getText().length() > 0 && (seleccionado.getFechaEntrada() == null || (!textFechaEntrada.getText().equals("") && !textFechaEntrada.getText().equals(seleccionado.getFechaEntrada().toString()))) ) {
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String strFecha = textFechaEntrada.getText();
						Date fechaEntrada = null;
						try {
							fechaEntrada = formatoDelTexto.parse(strFecha);
						} catch (ParseException e) {
							if (strFecha.length() != 0 || strFecha.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es válida.");
						}
						seleccionado.setFechaEntrada(fechaEntrada);
					}
					if(textFechaSalida.getText().length() > 0 && (seleccionado.getFechaSalida() == null || (!textFechaSalida.getText().equals("") && !textFechaSalida.getText().equals(seleccionado.getFechaSalida().toString()))) ) {
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String strFecha = textFechaSalida.getText();
						Date fechaSalida = null;
						try {
							fechaSalida = formatoDelTexto.parse(strFecha);
						} catch (ParseException e) {
							if (strFecha.length() != 0 || strFecha.length() != 0)JOptionPane.showMessageDialog(null, "La fecha no es válida.");
						}
						seleccionado.setFechaSalida(fechaSalida);
					}
					if(!textCurso.getText().equals(seleccionado.getCurso())) {
						seleccionado.setCurso(textCurso.getText());
					}
					if(!textColoniaProcedencia.getText().equals(seleccionado.getColoniaProcedencia())) {
						seleccionado.setColoniaProcedencia(textColoniaProcedencia.getText());
					}
					if(!textColoniaResidencia.getText().equals(seleccionado.getColoniaResidencia())) {
						seleccionado.setColoniaResidencia(textColoniaResidencia.getText());
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
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeSalida.setBounds(10, 387, 95, 14);
		contentPane.add(lblFechaDeSalida);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigos = new Integer[codigos.length];
				DefaultListModel<String> modelo = new DefaultListModel<>();
				int i = 0;
				for (Niño n : lista) {
						if ((n.getNombre() + " " + n.getApellidos()).toLowerCase().contains(textBuscar.getText().toLowerCase())) {
							modelo.addElement(n.getNombre() + " " + n.getApellidos());
							codigos[i] = n.getCodigo();
							i++;
						}
				}
				
				list.setModel(modelo);
			}
		});
		btnBuscar.setBounds(87, 80, 89, 23);
		contentPane.add(btnBuscar);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(32, 49, 182, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		JLabel lblListaDeNios = new JLabel("Lista de ni\u00F1os");
		lblListaDeNios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeNios.setBounds(156, 13, 102, 14);
		contentPane.add(lblListaDeNios);
		
		JLabel lblNiñoSeleccionado = new JLabel("");
		lblNiñoSeleccionado.setBounds(136, 116, 158, 14);
		contentPane.add(lblNiñoSeleccionado);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Niño(codigos[list.getSelectedIndex()]);
				actualizarVista(seleccionado);
					}
		});

	}
}

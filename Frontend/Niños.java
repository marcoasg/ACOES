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
	private JTextField textPadrino;
	private JTextField textField;
	
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
		
		JButton btnBorrarNiño = new JButton("Desactivar ni\u00F1o");
		btnBorrarNiño.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Niño niño = new Niño( Integer.parseInt((String) list.getSelectedValue()));
				niño.desactivaNiño();
				textFechaSalida.setText(niño.getFechaSalida().toString());
				JOptionPane.showMessageDialog(null, "Se ha dado de baja al socio.");
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
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaDeSalida.setBounds(10, 387, 95, 14);
		contentPane.add(lblFechaDeSalida);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(87, 80, 89, 23);
		contentPane.add(btnBuscar);
		
		textField = new JTextField();
		textField.setBounds(32, 49, 182, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblListaDeNios = new JLabel("Lista de ni\u00F1os");
		lblListaDeNios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeNios.setBounds(156, 13, 102, 14);
		contentPane.add(lblListaDeNios);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Niño(Integer.parseInt((String) list.getSelectedValue()) );
					}
		});

	}
}

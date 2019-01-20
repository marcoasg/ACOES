package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.Estancia;
import Backend.Ni�o;
import Backend.ProyectoLocal;
import Backend.Usuario;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class A�adirEstancia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;
	private JScrollPane panel;
	private Ni�o seleccionado;
	private JButton btnBuscar;
	private JLabel lblFechaDeNacimiento;
	private JLabel labelFecha;
	private JLabel lblColoniaDeProcedencia;
	private JLabel labelColonia;
	private JLabel lblCdigo;
	private JLabel labelCodigo;
	private Integer[] codigos;
	
	private void actualizarVista(Ni�o n) {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String strFecha = n.getFechaNacimiento() == null ? "No consta" : formatoDelTexto.format(n.getFechaNacimiento());
		labelFecha.setText(strFecha);
		labelColonia.setText(n.getColoniaProcedencia());
		labelCodigo.setText(""+n.getCodigo());
	}

	public A�adirEstancia(ProyectoLocal pl, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Ni�o[] lista = Ni�o.ListaNi�os();
		String[] ni�os = new String[lista.length];
		codigos = new Integer[lista.length];
		int i = 0;
		for (Ni�o n : lista) {
			codigos[i] = n.getCodigo();
			ni�os[i] = n.getNombre() + " " + n.getApellidos();
			i++;
		}
		
		list = new JList(ni�os);
		panel = new JScrollPane(list);
		panel.setBounds(63, 92, 618, 167);
		list.setBounds(63, 92, 618, 167);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(63, 50, 346, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBuscarNio = new JLabel("Buscar ni\u00F1o:");
		lblBuscarNio.setBounds(63, 16, 88, 20);
		contentPane.add(lblBuscarNio);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(54, 364, 59, -4);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "cancelado");
				DatosProyectoLocal p = new DatosProyectoLocal(pl,user);
				p.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(359, 364, 115, 29);
		contentPane.add(btnCancelar);
		
		JButton btnAadirNio = new JButton("A\u00F1adir ni\u00F1o");
		btnAadirNio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seleccionado == null) {
					JOptionPane.showMessageDialog(null, "Seleccione un ni�o.");
				}else {
					Estancia est = new Estancia(seleccionado,pl,new Date());
					JOptionPane.showMessageDialog(null, "Ni�o a�adido.");
					DatosProyectoLocal p = new DatosProyectoLocal(pl,user);
					p.setVisible(true);
					dispose();
				}
			}
		});
		btnAadirNio.setBounds(63, 364, 115, 29);
		contentPane.add(btnAadirNio);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigos = new Integer[codigos.length];
				DefaultListModel<String> modelo = new DefaultListModel<>();
				int i = 0;
				for (Ni�o n : lista) {
						if ((n.getNombre() + " " + n.getApellidos()).toLowerCase().contains(textField.getText().toLowerCase())) {
							modelo.addElement(n.getNombre() + " " + n.getApellidos());
							codigos[i] = n.getCodigo();
							i++;
						}
				}
				
				list.setModel(modelo);
			}
		});
		btnBuscar.setBounds(482, 49, 115, 29);
		contentPane.add(btnBuscar);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(63, 270, 102, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		labelFecha = new JLabel("");
		labelFecha.setBounds(63, 295, 102, 14);
		contentPane.add(labelFecha);
		
		lblColoniaDeProcedencia = new JLabel("Colonia de procedencia:");
		lblColoniaDeProcedencia.setBounds(225, 270, 123, 14);
		contentPane.add(lblColoniaDeProcedencia);
		
		labelColonia = new JLabel("");
		labelColonia.setBounds(225, 295, 123, 14);
		contentPane.add(labelColonia);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(413, 270, 46, 14);
		contentPane.add(lblCdigo);
		
		labelCodigo = new JLabel("");
		labelCodigo.setBounds(413, 295, 46, 14);
		contentPane.add(labelCodigo);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					seleccionado = new Ni�o(codigos[list.getSelectedIndex()]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
				actualizarVista(seleccionado);
			}
		});
		
	}
}

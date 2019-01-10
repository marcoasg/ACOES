package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.Estancia;
import Backend.Ni�o;
import Backend.ProyectoGeneral;
import Backend.ProyectoLocal;
import Backend.Usuario;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class DatosProyectoLocal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Ni�o seleccionado;
	private JList list;
	private JScrollPane panel;
	private JTextPane textPane;
	
	private void actualizarVista(Ni�o n) {
		textPane.setText(n.getNombre() + " " +n.getApellidos());
	}
	
	public DatosProyectoLocal(ProyectoLocal proyectoLocal, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(53, 42, 585, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Estancia[] estancias = Estancia.listaEstancias(proyectoLocal);
		String[] ni�os = new String[estancias.length];
		int i = 0;
		for(Estancia e : estancias) {
			if(!e.estanciaTerminada()) {
			ni�os[i] = Integer.toString(e.getNi�o().getCodigo());
			}
			i++;
		}
		textField.setText("Proyecto con codigo " + proyectoLocal.getCodigo());
		panel = new JScrollPane(list);
		panel.setBounds(53, 106, 688, 165);
		list = new JList();
		list.setBounds(53, 121, 688, 165);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Ni\u00F1os del proyecto");
		lblNewLabel.setBounds(53, 84, 140, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnEliminarNi�o = new JButton("Eliminar ni\u00F1o");
		btnEliminarNi�o.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEliminarNi�o.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Estancia[] estancias = Estancia.listaEstancias(proyectoLocal);
			for(Estancia e : estancias) {
				if(e.getNi�o().getCodigo() == seleccionado.getCodigo()) {
					e.setFechaBaja(new Date());
				}
			}
			}
		});
		btnEliminarNi�o.setBounds(53, 337, 172, 29);
		contentPane.add(btnEliminarNi�o);
		
		JButton btnNewButton = new JButton("agregar ni\u00F1o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A�adirEstancia est = new A�adirEstancia(proyectoLocal, user);
				est.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(53, 382, 172, 29);
		contentPane.add(btnNewButton);
		
		textPane = new JTextPane();
		
		textPane.setBounds(53, 302, 526, 26);
		contentPane.add(textPane);
		
		JLabel lblDatosNio = new JLabel("datos ni\u00F1o:");
		lblDatosNio.setBounds(53, 275, 97, 20);
		contentPane.add(lblDatosNio);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Ni�o((Integer)list.getSelectedValue());
				actualizarVista(seleccionado);
			}
		});
	}
}

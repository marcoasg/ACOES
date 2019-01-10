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
import Backend.Niño;
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
	private Niño seleccionado;
	private JList list;
	private JScrollPane panel;
	private JTextPane textPane;
	
	private void actualizarVista(Niño n) {
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
		String[] niños = new String[estancias.length];
		int i = 0;
		for(Estancia e : estancias) {
			if(!e.estanciaTerminada()) {
			niños[i] = Integer.toString(e.getNiño().getCodigo());
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
		
		JButton btnEliminarNiño = new JButton("Eliminar ni\u00F1o");
		btnEliminarNiño.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEliminarNiño.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Estancia[] estancias = Estancia.listaEstancias(proyectoLocal);
			for(Estancia e : estancias) {
				if(e.getNiño().getCodigo() == seleccionado.getCodigo()) {
					e.setFechaBaja(new Date());
				}
			}
			}
		});
		btnEliminarNiño.setBounds(53, 337, 172, 29);
		contentPane.add(btnEliminarNiño);
		
		JButton btnNewButton = new JButton("agregar ni\u00F1o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirEstancia est = new AñadirEstancia(proyectoLocal, user);
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
				seleccionado = new Niño((Integer)list.getSelectedValue());
				actualizarVista(seleccionado);
			}
		});
	}
}

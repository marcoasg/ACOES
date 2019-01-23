package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class DatosProyectoLocal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Niño seleccionado;
	private JList list;
	private JScrollPane panel;
	private Integer codigos[];
	JLabel labelCodigo;
	JLabel labelFecha;
	
	private void actualizarVista(Niño n) {
		labelCodigo.setText(""+n.getCodigo());
	}
	
	public DatosProyectoLocal(ProyectoLocal proyectoLocal, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(53, 42, 585, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("Proyecto "+ proyectoLocal.getProyecto().getNombre() + " en "+ proyectoLocal.getLocalizacion()+ ".");
		
		Estancia[] estancias = Estancia.listaEstancias(proyectoLocal);
		String[] niños = new String[estancias.length];
		codigos = new Integer[estancias.length];
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		int i = 0;
		for(Estancia e : estancias) {
			if(!e.estanciaTerminada()) {
			codigos[i] = e.getNiño().getCodigo();
			String strFecha = formatoDelTexto.format(e.getFechaAlta());
			niños[i] = e.getNiño().getNombre() + " " + e.getNiño().getApellidos() + ", desde "+ strFecha;
			i++;
			}
		}
		
		list = new JList(niños);
		list.setBounds(53, 121, 688, 165);
		panel = new JScrollPane(list);
		panel.setBounds(53, 106, 688, 165);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Ni\u00F1os del proyecto");
		lblNewLabel.setBounds(53, 84, 140, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnEliminarNiño = new JButton("Quitar ni\u00F1o");
		btnEliminarNiño.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminarNiño.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Estancia[] estancias = Estancia.listaEstancias(proyectoLocal);
			for(Estancia e : estancias) {
				if(e.getNiño().getCodigo() == seleccionado.getCodigo() && !e.estanciaTerminada()) {
					e.setFechaBaja(new Date());
					JOptionPane.showMessageDialog(null, "Niño quitado del proyecto.");
				}
			}
			}
		});
		btnEliminarNiño.setBounds(262, 369, 172, 29);
		contentPane.add(btnEliminarNiño);
		
		JButton btnNewButton = new JButton("Agregar ni\u00F1o");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirEstancia est = new AñadirEstancia(proyectoLocal, user);
				est.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(53, 369, 172, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblDatosNio = new JLabel("Código:");
		lblDatosNio.setBounds(53, 275, 97, 20);
		contentPane.add(lblDatosNio);
		
		labelCodigo = new JLabel("");
		labelCodigo.setBounds(53, 311, 97, 14);
		contentPane.add(labelCodigo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProyectosLocales pl = new ProyectosLocales(proyectoLocal.getProyecto(),user);
				pl.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(652, 373, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Balance b = new Balance(proyectoLocal, user);
				b.setVisible(true);
				dispose();
			}
		});
		btnBalance.setBounds(457, 368, 140, 29);
		contentPane.add(btnBalance);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					seleccionado = new Niño(codigos[list.getSelectedIndex()]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
				actualizarVista(seleccionado);
			}
		});
	}
}

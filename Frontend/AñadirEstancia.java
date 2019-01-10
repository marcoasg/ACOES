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
import Backend.Niño;
import Backend.ProyectoLocal;
import Backend.Usuario;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AñadirEstancia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JList list;
	private JScrollPane panel;
	private Niño seleccionado;
	private JButton btnBuscar;
	
	private void actualizarVista(Niño n) {
		textField_1.setText(n.getNombre() +" "+n.getApellidos());
	}

	public AñadirEstancia(ProyectoLocal pl, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
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
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(63, 305, 405, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ni\u00F1o seleccionado:");
		lblNewLabel.setBounds(63, 275, 138, 20);
		contentPane.add(lblNewLabel);
		
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
					JOptionPane.showMessageDialog(null, "Seleccione un Niño");
				}else {
					Estancia est = new Estancia(seleccionado,pl,new Date());
					JOptionPane.showMessageDialog(null, "niño añadido");
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
				String b = textField.getText();
				Niño[] niños = Niño.ListaNiños();
				String[] lista = new String[niños.length];
				int i = 0;
				for(Niño n : niños) {
					if((n.getNombre().contains(b))||(n.getApellidos().contains(b))) {
						lista[i]=Integer.toString(n.getCodigo());
					}
					i++;
				}
				list = new JList(lista);
			}
		});
		btnBuscar.setBounds(516, 49, 115, 29);
		contentPane.add(btnBuscar);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Niño((int)list.getSelectedValue());
				actualizarVista(seleccionado);
			}
		});
		
	}
}

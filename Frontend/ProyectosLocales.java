package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.ProyectoGeneral;
import Backend.ProyectoLocal;
import Backend.Usuario;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ProyectosLocales extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JScrollPane panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ProyectoLocal seleccionado;
	private JTextField textField_3;
	
	private void actualizarVista(ProyectoLocal p) {
		textField.setText(p.getCoordinador().getUsuario());
		textField_1.setText(p.getLocalizacion());
		textField_2.setText(Integer.toString(p.getCodigo()));
		
	}



	public ProyectosLocales(ProyectoGeneral p, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_3.setText(p.getNombre());
		
		ProyectoLocal[] proyectos = ProyectoLocal.ListaProyectosLocales(p);
		String[] pro = new String[proyectos.length];
		int i = 0;
		for(ProyectoLocal pr : proyectos) {
			pro[i] = Integer.toString(pr.getCodigo());
			i++;
		}
		list = new JList(pro);
		panel = new JScrollPane(list);
		panel.setBounds(36, 61, 570, 160);
		list.setBounds(36, 61, 570, 160);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Coordinador");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.getRol().getNivel() >= 2) {
					try {
						Usuario u = new Usuario(textField.getText());
						if (u.getRol().getRolName().equals("CoordinadorProyectoH")) {
							seleccionado.setCoordinador(u);
						}
					} catch (Error err) {
						JOptionPane.showMessageDialog(null, err.getMessage());
					} 
				}
			}
		});
		btnNewButton.setBounds(410, 337, 144, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoProyectoLocal pr = new NuevoProyectoLocal(p,user);
				pr.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setBounds(410, 292, 144, 29);
		contentPane.add(btnRegistrar);
		
		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosProyectoLocal d = new DatosProyectoLocal(new ProyectoLocal(Integer.parseInt(textField_2.getText())), user);
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(410, 247, 144, 29);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel = new JLabel("localizaci\u00F3n:");
		lblNewLabel.setBounds(36, 296, 101, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(36, 368, 69, 20);
		contentPane.add(lblCodigo);
		
		JLabel lblCoordinador = new JLabel("Coordinador:");
		lblCoordinador.setBounds(36, 251, 101, 20);
		contentPane.add(lblCoordinador);
		
		textField = new JTextField();
		textField.setBounds(36, 271, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(36, 327, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(36, 390, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(36, 16, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new ProyectoLocal((int) list.getSelectedValue());
				actualizarVista(seleccionado);
			}
		});
	}
}

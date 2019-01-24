package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class NuevoProyectoLocal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JList list;
	private JScrollPane panel;
	private Usuario seleccionado;
	private ProyectoLocal pl;

	public NuevoProyectoLocal(ProyectoGeneral pg, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setText("Añadir proyecto local al proyecto " + pg.getNombre());
		
		textField = new JTextField();
		textField.setBounds(49, 378, 300, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introducir localizaci\u00F3n:");
		lblNewLabel.setBounds(49, 331, 166, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblIntroducir = new JLabel("Elegir coordinador:");
		lblIntroducir.setBounds(49, 107, 166, 20);
		contentPane.add(lblIntroducir);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seleccionado==null) {
					JOptionPane.showMessageDialog(null, "Seleccione un coordinador");
				}else {
					try {
						pl = new ProyectoLocal(pg,seleccionado);
						pl.setLocalizacion(textField.getText());
						ProyectosLocales prl= new ProyectosLocales(pg, user);				
						prl.setVisible(true);
						dispose();
					} catch (Backend.Error e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Este coordinador ya coordina otro proyecto.");
					}
				}
			}
		});
		btnAceptar.setBounds(381, 375, 115, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelarr = new JButton("Cancelar");
		btnCancelarr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProyectosLocales pl = new ProyectosLocales(pg,user);
				pl.setVisible(true);
				dispose();
			}
		});

		btnCancelarr.setBounds(574, 375, 115, 29);
		contentPane.add(btnCancelarr);
		
		Usuario[] us = Usuario.ListaUsuarios();
		String[] coor = new String[us.length];
		int i = 0;
		for(Usuario u : us) {
			if(u.getRol().getRolName().equals("CoordinadorLocalH")) {
				coor[i]=u.getUsuario();
			}
			i++;
		}
		
		list = new JList(coor);
		panel = new JScrollPane(list);
		panel.setBounds(49, 143, 720, 158);
		list.setBounds(49, 143, 720, 158);
		contentPane.add(panel);
		
		textField_1.setEditable(false);
		textField_1.setBounds(49, 36, 344, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Usuario((String)list.getSelectedValue());
			}
		});
	}
}

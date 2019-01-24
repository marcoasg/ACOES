package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.ProyectoGeneral;
import Backend.ProyectoLocal;
import Backend.Usuario;

public class NuevoProyectoGeneralBien extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtDes;
	private JTextField textField_1;
	private JList list;
	private JScrollPane panel;
	private Usuario seleccionado;
	private ProyectoGeneral pl;
	private Usuario user;
	

	public NuevoProyectoGeneralBien(Usuario u) {
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setText("Añadir proyecto General ");
		
		txtNom = new JTextField();
		txtNom.setBounds(335, 278, 300, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introducir nombre del proyecto:");
		lblNewLabel.setBounds(49, 281, 271, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblIntroducir = new JLabel("Elegir coordinador:");
		lblIntroducir.setBounds(49, 78, 166, 20);
		contentPane.add(lblIntroducir);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seleccionado==null) {
					JOptionPane.showMessageDialog(null, "Seleccione un coordinador.");
				}else if(txtNom.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "Escriba un nombre para el proyecto.");
				}else {
					pl = new ProyectoGeneral(txtNom.getText(), seleccionado);
					pl.setDescripcion(txtDes.getText());
					ProyectosGenerales prg = new ProyectosGenerales(user);				
					prg.setVisible(true);
					dispose();
				}
			}
		});
		btnAceptar.setBounds(49, 398, 115, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelarr = new JButton("Cancelar");
		btnCancelarr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProyectosGenerales prg = new ProyectosGenerales(user);				
				prg.setVisible(true);
				dispose();
			}
		});

		btnCancelarr.setBounds(335, 398, 115, 29);
		contentPane.add(btnCancelarr);
		
		Usuario[] us = Usuario.ListaUsuarios();
		String[] coor = new String[us.length];
		int i = 0;
		for(Usuario u1 : us) {
			if(u1.getRol().getRolName().equalsIgnoreCase("CoordinadorGeneralH")) {
				coor[i]=u1.getUsuario();
			}
			i++;
		}
		panel = new JScrollPane();
		panel.setBounds(49, 109, 718, 156);
		contentPane.add(panel);
		
		textField_1.setEditable(false);
		textField_1.setBounds(49, 36, 212, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		list = new JList(coor);
		contentPane.add(list);
		list.setBounds(49, 109, 718, 156);
		
		JLabel lblIntroducirDescripcionDel = new JLabel("Introducir descripci\u00F3n del proyecto:");
		lblIntroducirDescripcionDel.setBounds(49, 317, 271, 20);
		contentPane.add(lblIntroducirDescripcionDel);
		
		txtDes = new JTextField();
		txtDes.setColumns(10);
		txtDes.setBounds(335, 314, 300, 78);
		contentPane.add(txtDes);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Usuario((String)list.getSelectedValue());
			}
		});
	}
}

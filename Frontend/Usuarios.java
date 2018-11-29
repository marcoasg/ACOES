package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.Usuario;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	Usuario user;
	public Usuarios(Usuario u) {
		
		JSpinner spinner = new JSpinner();
		getContentPane().add(spinner, BorderLayout.NORTH);
		user = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Usuario[] lista = Usuario.ListaUsuarios();
		String[] usuarios = new String[lista.length];
		int i = 0;
		for (Usuario us : lista) {
			usuarios[i] = us.getUsuario();
			i++;
		}
		contentPane.setLayout(null);
		
		JList list = new JList(usuarios);
		list.setBounds(10, 11, 794, 96);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);
		
		JLabel label_1 = new JLabel("Datos del usuario ");
		label_1.setBounds(10, 118, 132, 14);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(label_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 162, 132, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(136, 118, 46, 14);
		lblNewLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(152, 162, 362, 14);
		contentPane.add(label);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(10, 187, 172, 14);
		contentPane.add(lblApellidos);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(192, 187, 322, 14);
		contentPane.add(label_2);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Usuario usuario = new Usuario((String) list.getSelectedValue());
				if (user.getRol().getNivel() >= usuario.getRol().getNivel()) {
					lblNewLabel.setText(usuario.getUsuario());
					label.setText(usuario.getNombre());
					label_2.setText(usuario.getApellidos());
				}
				
			}
		});

	}
}

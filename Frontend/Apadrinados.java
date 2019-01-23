package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.Apadrinamiento;
import Backend.Envio;
import Backend.Niño;
import Backend.Socio;
import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Apadrinados extends JFrame {

	private JPanel contentPane;
	private Niño seleccionado;

	/**
	 * Create the frame.
	 */
	public Apadrinados(Usuario user, Socio s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblApadrinados = new JLabel("Apadrinados:");
		lblApadrinados.setBounds(10, 11, 90, 14);
		contentPane.add(lblApadrinados);
		
		
		Apadrinamiento[] lista = Apadrinamiento.ListaApadrinamientos();
		Integer[] niños = new Integer[lista.length];
		int i = 0;
		for (Apadrinamiento ap : lista) {
			if (ap.getSocio().getNumSocio() == s.getNumSocio() && ap.getFechaBaja() == null)
				niños[i] = ap.getNiño().getCodigo();
			i++;
		}
		JList list = new JList(niños);
		list.setBounds(110, 10, 253, 66);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		JScrollPane panel = new JScrollPane(list);
		panel.setBounds(110, 10, 253, 66);
		contentPane.add(panel);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Niño((Integer)list.getSelectedValue());
			}
		});
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(110, 129, 253, 78);
		contentPane.add(textArea);
		
		JLabel lblContenido = new JLabel("Contenido:");
		lblContenido.setBounds(10, 134, 75, 14);
		contentPane.add(lblContenido);
		
		JButton btnRegistrarEnvo = new JButton("Registrar env\u00EDo");
		btnRegistrarEnvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (seleccionado != null) {
					Envio envio = new Envio(new Apadrinamiento(s,seleccionado));
					envio.setDescripcion(textArea.getText());
					JOptionPane.showMessageDialog(null, "Envío registrado.");
					Socios socios = new Socios(user);
					socios.setVisible(true);
					dispose();
				}
				
			}
		});
		btnRegistrarEnvo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrarEnvo.setBounds(164, 221, 128, 29);
		contentPane.add(btnRegistrarEnvo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socios socios = new Socios(user);
				socios.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(335, 224, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCancelarApadrinamiento = new JButton("Cancelar apadrinamiento");
		btnCancelarApadrinamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(seleccionado == null) throw new Backend.Error("Seleccione un niño");
					Apadrinamiento a = new Apadrinamiento(s,seleccionado);
					a.darDeBajaApadrinamiento();
					DefaultListModel<String> modelo = new DefaultListModel<>();
					int i = 0;

					
					list.setModel(modelo);
			}
		});
		btnCancelarApadrinamiento.setBounds(110, 83, 254, 35);
		contentPane.add(btnCancelarApadrinamiento);
	}
}

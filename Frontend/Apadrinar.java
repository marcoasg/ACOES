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
import Backend.BD;
import Backend.Niño;
import Backend.Socio;
import Backend.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apadrinar extends JFrame {

    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "ACOES";
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Integer[] codigos;
	Niño seleccionado;

	/**
	 * Create the frame.
	 */
	public Apadrinar(Usuario u, Socio s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Donaci\u00F3n:");
		label.setBounds(37, 166, 61, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(108, 163, 86, 20);
		contentPane.add(textField);
		
		JLabel lblCuotaMensual = new JLabel("Cuota mensual:");
		lblCuotaMensual.setBounds(228, 166, 86, 14);
		contentPane.add(lblCuotaMensual);
		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 163, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNiosParaApadrinar = new JLabel("Ni\u00F1os para apadrinar");
		lblNiosParaApadrinar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNiosParaApadrinar.setBounds(146, 11, 126, 14);
		contentPane.add(lblNiosParaApadrinar);
		
		BD miBD = new BD(BD_SERVER,BD_NAME);
		List<Object[]> lista = miBD.Select("SELECT * from tNiño where codigo not in (select niño from tApadrinamiento);");
		
		String[] niños = new String[lista.size()];
		codigos = new Integer[lista.size()];

		int i = 0;
		for (Object[] tupla : lista) {
			codigos[i] = (Integer)tupla[1];
			String apellidos = tupla[2] == null ? "" : (String)tupla[2];
			niños[i] = (String)tupla[0] + " "+ apellidos;
			i++;
		}
		
		JList list = new JList(niños);
		list.setBounds(80, 32, 253, 93);
		JScrollPane panel = new JScrollPane(list);
		panel.setBounds(80, 32, 253, 93);
		contentPane.add(panel);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				seleccionado = new Niño(codigos[list.getSelectedIndex()]);
			}
		});
		
		JButton btnApadrinar = new JButton("Apadrinar");
		btnApadrinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (seleccionado == null) throw new Error("Seleccione un niño.");
					Apadrinamiento ap = new Apadrinamiento(s,seleccionado,Integer.parseInt(textField.getText()));
					ap.setCuotaMensual(Integer.parseInt(textField_1.getText()));
					JOptionPane.showMessageDialog(null, "¡" + (String)list.getSelectedValue() + " apadrinado!");
					Socios s = new Socios(u);
					s.setVisible(true);
					dispose();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "La donación ha de ser un número.");
				} catch (Backend.Error e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnApadrinar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnApadrinar.setBounds(146, 213, 126, 37);
		contentPane.add(btnApadrinar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socios s = new Socios(u);
				s.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(335, 221, 89, 23);
		contentPane.add(btnCancelar);
		
	}
}

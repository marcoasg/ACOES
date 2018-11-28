package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Backend.Usuario;

import javax.swing.JComboBox;
import net.miginfocom.swing.MigLayout;
import javax.swing.DefaultComboBoxModel;

public class General extends JFrame {

	Usuario user;
	
	public General(Usuario u) {
		this.user = u;
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("ACOES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][][grow]", "[][]"));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Perfil", "Cerrar sesi\u00F3n"}));
		getContentPane().add(comboBox, "cell 11 0,growx");
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (user.AccesoPantalla("Usuarios")) {
					
				}
			}
		});
		getContentPane().add(btnUsuarios, "cell 0 1");
	}
}

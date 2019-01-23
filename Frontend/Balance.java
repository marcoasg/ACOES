package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Gasto;
import Backend.Ingreso;
import Backend.ProyectoLocal;
import Backend.Usuario;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Balance extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextField txtIngresos;
	private JTextField txtGastos;
	private JTextField txtBalance;
	private Date fechaInicio;
	private Date fechaFin;
	private float totalIngresos;
	private float totalGastos;
	private ProyectoLocal proyecto;
	private Usuario user;

	public Balance(ProyectoLocal p, Usuario u) {
		proyecto = p;
		user = u;
		totalIngresos = 0;
		totalGastos = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ingresos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
					if(fechaInicio == null) fechaInicio= formatoDelTexto.parse("1492-01-01");
					if(fechaFin == null) fechaFin = new Date();
					Ingresos i = new Ingresos(user, proyecto, fechaInicio, fechaFin);
					i.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(53, 290, 109, 42);
		contentPane.add(btnNewButton);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(53, 54, 146, 26);
		contentPane.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(345, 54, 146, 26);
		contentPane.add(txtFechaFin);
		
		JButton btnGastos = new JButton("Gastos");
		btnGastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
					if(fechaInicio == null) fechaInicio= formatoDelTexto.parse("1492-01-01");
					if(fechaFin == null) fechaFin = new Date();
					Gastos g = new Gastos(user, proyecto, fechaInicio, fechaFin);
					g.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGastos.setBounds(217, 290, 109, 42);
		contentPane.add(btnGastos);
		
		
		
		JLabel lblTotalIngresos = new JLabel("Total ingresos:");
		lblTotalIngresos.setBounds(53, 96, 146, 26);
		contentPane.add(lblTotalIngresos);
		
		JLabel lblTotalGastos = new JLabel("Total gastos:");
		lblTotalGastos.setBounds(53, 143, 146, 26);
		contentPane.add(lblTotalGastos);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(53, 196, 146, 26);
		contentPane.add(lblBalance);
		
		txtIngresos = new JTextField();
		txtIngresos.setEditable(false);
		txtIngresos.setBounds(194, 96, 146, 26);
		contentPane.add(txtIngresos);
		txtIngresos.setColumns(10);
		
		txtGastos = new JTextField();
		txtGastos.setEditable(false);
		txtGastos.setColumns(10);
		txtGastos.setBounds(194, 143, 146, 26);
		contentPane.add(txtGastos);
		
		txtBalance = new JTextField();
		txtBalance.setEditable(false);
		txtBalance.setColumns(10);
		txtBalance.setBounds(194, 196, 146, 26);
		contentPane.add(txtBalance);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(53, 29, 146, 26);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(345, 32, 146, 26);
		contentPane.add(lblFechaFin);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
				try {
					
					if(txtFechaInicio.getText().length() == 0) fechaInicio= formatoDelTexto.parse("1492-01-01"); else fechaInicio = formatoDelTexto.parse(txtFechaInicio.getText());
					if(txtFechaFin.getText().length() == 0) fechaFin = new Date(); else fechaFin = formatoDelTexto.parse(txtFechaFin.getText());


					if(fechaInicio.compareTo(fechaFin) > 0) {
						throw new Backend.Error("Fecha fin debe ser posterior a fecha inicio");
					}
					for(Ingreso i: Ingreso.ListaIngresos(proyecto, fechaInicio, fechaFin)){
						totalIngresos += i.getCantidad();
					}
					for(Gasto g: Gasto.ListaGastos(proyecto, fechaInicio, fechaFin)){
						totalGastos += g.getCantidad();
					}
					actualizarVista();
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Formato de fechas incorrectos");
					}catch(Backend.Error e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());

					}
				
			}
		});
		btnCalcular.setBounds(392, 180, 109, 42);
		contentPane.add(btnCalcular);
		
		JLabel lblYyyymmdd = new JLabel("yyyy-MM-dd");
		lblYyyymmdd.setBounds(226, 57, 104, 20);
		contentPane.add(lblYyyymmdd);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosProyectoLocal pl = new DatosProyectoLocal(proyecto, user);
				pl.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(392, 290, 109, 42);
		contentPane.add(btnVolver);
	}
	
	private void actualizarVista() {
		txtIngresos.setText(Double.toString(totalIngresos));
		txtGastos.setText(Double.toString(totalGastos));
		txtBalance.setText(Double.toString(totalIngresos-totalGastos));
	}
}

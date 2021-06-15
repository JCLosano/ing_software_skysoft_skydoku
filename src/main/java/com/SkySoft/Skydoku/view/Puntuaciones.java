package com.SkySoft.Skydoku.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Puntuaciones {
	
	private JPanel panelPuntuaciones;
	private JScrollPane mibarra1, mibarra2;
	private JTable mitabla1, mitabla2;
	private JFrame ventanaPuntuaciones;
	
	public Puntuaciones() {

		ventanaPuntuaciones = new JFrame();
		
		mibarra1 = new JScrollPane();
		mibarra1.setBounds(0, 0, 400, 190);
		crearTablaActual();

		mibarra2 = new JScrollPane();
		mibarra2.setBounds(0, 50, 585, 190);
		crearTabla();
		
		ventanaPuntuaciones.add(mibarra2, BorderLayout.CENTER);
		ventanaPuntuaciones.add(mibarra1, BorderLayout.CENTER);
		ventanaPuntuaciones.setSize(600, 320);
		ventanaPuntuaciones.setTitle("Tabla de Puntuaciones");
		ventanaPuntuaciones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaPuntuaciones.setVisible(true);		
	}
	
	public void crearTablaActual() {
		DefaultTableModel model;

		String columnas[] = { "","Nombre Actual", "Puntuación Actual", "Tiempo", "Total", "Dificultad"};

		model = new DefaultTableModel(null, columnas);
		//model.addRow(aux);

		mitabla1 = new JTable(model);
		mitabla1.setEnabled(false);
		mitabla1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		mibarra1.setViewportView(mitabla1);
	}
	
	public void crearTabla() {
		DefaultTableModel model;
		String[] columnas = {"Posición", "Nombre", "Puntuación", "Tiempo", "Total", "Dificultad"};
		model = new DefaultTableModel(null, columnas);

		for(int i = 1; i<=10; i++) {
			Object[] aux = {i + ""};
			model.addRow(aux);
		}
		
		mitabla2 = new JTable(model);// creamos la instancia de la tabla
		mitabla2.setEnabled(false);
		mitabla2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		mibarra2.setViewportView(mitabla2);
	}
	
	public JPanel getPanelPuntuaciones() {
		return panelPuntuaciones;
	}
}

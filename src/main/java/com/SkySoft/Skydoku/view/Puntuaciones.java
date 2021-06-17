package com.SkySoft.Skydoku.view;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.SkySoft.Skydoku.Model.DBPuntuaciones;


public class Puntuaciones implements Observer{

	private JScrollPane mibarra1, mibarra2;
	private JTable mitabla1, mitabla2;
	private static JFrame ventanaPuntuaciones;

	//private static Puntuaciones puntuaciones;
	DefaultTableModel model1;
	DefaultTableModel model2;
	private String aux[] = {" ", " ", " ", " ", " ", " "};
	private DBPuntuaciones db_puntuaciones;

	
	public Puntuaciones(DBPuntuaciones db_puntuaciones) {
		ventanaPuntuaciones = new JFrame();
		
		this.db_puntuaciones = db_puntuaciones;
		db_puntuaciones.registerObserver(this);
		
		
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
		
		String columnas[] = { "","Nombre Actual", "Puntuación Actual", "Tiempo", "Total", "Dificultad"};
		
		model1 = new DefaultTableModel(null, columnas);
		/*if (db_puntuaciones.getCampos() != null) {
			for(int i = 0; i <= db_puntuaciones.getCampos().size(); i++) {
				if(i != 0)
					aux[i] = db_puntuaciones.getCampos().get(i-1);
			}
			model1.addRow(aux);
		}*/
		//aux[1] = db_puntuaciones.getNombreActual();
		//aux[2] = db_puntuaciones.getPuntuacion() + "";
		//aux[1] = db_puntuaciones.getTiempo() + "";
		
		model1.insertRow(0, aux);

		mitabla1 = new JTable(model1);
		mitabla1.setEnabled(false);
		//mitabla1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		mibarra1.setViewportView(mitabla1);
	}
	
	public void crearTabla() {
		
		String[] columnas = {"Posición", "Nombre", "Puntuación", "Tiempo", "Total", "Dificultad"};
		model2 = new DefaultTableModel(null, columnas);

		for(int i = 1; i<=10; i++) {
			Object[] aux = {i + ""};
			model2.addRow(aux);
		}
		
		mitabla2 = new JTable(model2);// creamos la instancia de la tabla
		mitabla2.setEnabled(false);
		//mitabla2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		mibarra2.setViewportView(mitabla2);
	}


	public JTable getMitabla2() {
		return mitabla2;
	}

	@Override
	public void update(int tiempo, int puntuacion) {
		// TODO Auto-generated method stub
		int puntuacionTotal = ((puntuacion/tiempo)*100);
		String aux2[] = {" ", db_puntuaciones.getNombreActual(), puntuacion + "", tiempo + "", puntuacionTotal + "", db_puntuaciones.getDificultad()};
		model1.removeRow(0);
		model1.insertRow(0, aux2);
		/*tiempo.setText(segundos + "");
		puntuaciones.setText(puntuacion + "");*/
	}
}

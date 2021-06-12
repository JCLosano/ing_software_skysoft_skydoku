package com.SkySoft.Skydoku.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.SkySoft.Skydoku.controller.ControladorCentral;

public class Activa extends JPanel{
	public JPanel panelActiva = new JPanel();
	public JPanel pnlAlign = new JPanel();
	private JPanel[][] casillaGrande;
	private Casilla[][] casillaChica;
	
	JButton btnNew;
	
	public Activa(ControladorCentral controladorCentral) {
		TitledBorder border;
	    border = crearBorder();

        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.X_AXIS));
	    
	    JPanel panelTiempoPuntuaciones = new JPanel();

        panelTiempoPuntuaciones.setBorder(BorderFactory.createTitledBorder("Tiempo y Puntuaciones"));
        
        JTextArea tiempo = new JTextArea();
        tiempo.setWrapStyleWord(false);
        tiempo.setRows(1);
		tiempo.setText("HOLA JUANCITO");
		tiempo.setEditable(false);
		panelTiempoPuntuaciones.add(tiempo);
		
        JTextArea puntuaciones = new JTextArea();
        puntuaciones.setWrapStyleWord(false);
        puntuaciones.setRows(1);
        puntuaciones.setText("HOLA JUANCITO");
        puntuaciones.setEditable(false);
		panelTiempoPuntuaciones.add(puntuaciones);
		
		//JPanel panelBotones = new JPanel();
		panelTiempoPuntuaciones.setLayout(new BoxLayout(panelTiempoPuntuaciones, BoxLayout.Y_AXIS));
		
		JButton boton_puntuaciones = agregarBoton("Puntuaciones", panelTiempoPuntuaciones);
		boton_puntuaciones.addActionListener(controladorCentral);
		
		panelTiempoPuntuaciones.add(Box.createVerticalStrut(10));
        
		JButton boton_menuPrincipal = agregarBoton("Menu Principal", panelTiempoPuntuaciones);
		boton_menuPrincipal.addActionListener(controladorCentral);
		
		pnlAlign.add(panelTiempoPuntuaciones);
		//pnlAlign.add(panelBotones);
		pnlAlign.add(panelActiva);
		

        crearGrilla(4,4);
        
        pnlAlign.setPreferredSize(new Dimension(800,700));
        
        //pnlAlign.add(panelActiva);
        
	}

	private TitledBorder crearBorder() {
		return BorderFactory.createTitledBorder("Activa");
	}
	
	public void crearGrilla(int filas, int columnas) {
        GridLayout grilla = new GridLayout(filas, columnas);
        
        casillaGrande = new JPanel[filas][columnas];
        for (int y = 0; y < columnas; y++) {
            for (int x = 0; x < filas; x++) {
                casillaGrande[y][x] = new JPanel(grilla);
                casillaGrande[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                panelActiva.add(casillaGrande[y][x]);
            }
        }
        
        casillaChica = new Casilla[filas*filas][columnas*columnas];
        for(int y = 0; y < columnas*columnas; y++) {
        	for(int x = 0; x < filas*filas; x++) {
        		casillaChica[y][x] = new Casilla(x, y);
        		casillaGrande[y/columnas][x/filas].add(casillaChica[y][x]);
        	}
        }
	}
	
    private JButton agregarBoton (String nombre_boton, JPanel panel) {
        JButton boton = new JButton(nombre_boton);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(boton);
        return boton;
    }
}



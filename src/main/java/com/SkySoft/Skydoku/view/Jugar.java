package com.SkySoft.Skydoku.view;

import com.SkySoft.Skydoku.controller.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Jugar {
	public JPanel panelJugar = new JPanel();
	
	public Jugar(ControladorCentral controladorCentral) 
	{
		TitledBorder border;
        border = crearBorder();

        panelJugar.setBorder(border);
        panelJugar.setLayout(new BoxLayout(panelJugar, BoxLayout.Y_AXIS));
        panelJugar.setPreferredSize(new Dimension(640, 480));
        
        //panelJugar.add(Box.createVerticalStrut(150));
        
        JButton boton_facil = botonFacil();
        boton_facil.addActionListener(controladorCentral);
        
        JButton boton_normal = botonNormal();
        boton_normal.addActionListener(controladorCentral);
        
        JButton boton_dificil = botonDificil();
        boton_dificil.addActionListener(controladorCentral);
        
        JButton boton_atras = botonAtras();
        boton_atras.addActionListener(controladorCentral);
        boton_atras.setActionCommand("AtrasJugar");
	}
	
	public JButton botonFacil() {
		panelJugar.add(Box.createVerticalStrut(150));
        return agregarBoton("Facil", panelJugar);
	}
	
	public JButton botonNormal() {
		panelJugar.add(Box.createVerticalStrut(10));
        return agregarBoton("Normal", panelJugar);
	}
	
	public JButton botonDificil() {
		panelJugar.add(Box.createVerticalStrut(10));
        return agregarBoton("Dificil", panelJugar);
	}
	
	public JButton botonAtras() {
		panelJugar.add(Box.createVerticalStrut(150));
        return agregarBoton("Atras", panelJugar);
	}

	private TitledBorder crearBorder() {
		return BorderFactory.createTitledBorder("Jugar");
	}
	
    private JButton agregarBoton (String nombre_boton, JPanel panel) {
        JButton boton = new JButton(nombre_boton);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(boton);
        return boton;
    }
}

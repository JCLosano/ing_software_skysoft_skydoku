package com.SkySoft.Skydoku.view;

import com.SkySoft.Skydoku.controller.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Jugar {
	public JPanel panelJugar = new JPanel();
	public JPanel panelNombre = new JPanel();
	public JFrame frameNombre = new JFrame();
	public JTextField textField = new JTextField();
	
	public Jugar(ControladorCentral controladorCentral) 
	{
		TitledBorder border;
        border = crearBorder();

        panelJugar.setBorder(border);
        panelJugar.setLayout(new BoxLayout(panelJugar, BoxLayout.Y_AXIS));
        panelJugar.setPreferredSize(new Dimension(640, 480));
        
        JButton boton_facil = botonFacil();
        boton_facil.addActionListener(controladorCentral);
        
        JButton boton_normal = botonNormal();
        boton_normal.addActionListener(controladorCentral);
        
        JButton boton_dificil = botonDificil();
        boton_dificil.addActionListener(controladorCentral);
        
        JButton boton_atras = botonAtras();
        boton_atras.addActionListener(controladorCentral);
        boton_atras.setActionCommand("AtrasJugar");
        
        crearFrameNombre(controladorCentral);
	}
	
	private void crearFrameNombre(ControladorCentral controladorCentral) {
		frameNombre.setBounds(100, 100, 306, 163);
		
		frameNombre.getContentPane().add(panelNombre, BorderLayout.CENTER);
		
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panelNombre.add(textField);
		textField.setColumns(10);
		
		JButton boton_registrar = new JButton("Registrar");
		boton_registrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton_registrar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelNombre.add(boton_registrar);
		
		boton_registrar.addActionListener(controladorCentral);
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

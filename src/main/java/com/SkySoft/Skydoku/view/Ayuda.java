package com.SkySoft.Skydoku.view;

import com.SkySoft.Skydoku.controller.ControladorCentral;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Ayuda{

    public JPanel panelAyuda = new JPanel();

    public Ayuda(ControladorCentral controladorCentral) {
        
        TitledBorder border;
        border = crearBorder();
        
        panelAyuda.setBorder(border);
        panelAyuda.setLayout(new BoxLayout(panelAyuda, BoxLayout.Y_AXIS));
        panelAyuda.setPreferredSize(new Dimension(640, 480));
        
        JTextArea txtSudoku = textoAyuda();
		panelAyuda.add(txtSudoku);
        
        JButton boton_atras = botonAtras();
        boton_atras.addActionListener(controladorCentral);
        boton_atras.setActionCommand("AtrasAyuda");
        
        
    }
    
    public TitledBorder crearBorder() {
        return BorderFactory.createTitledBorder("Ayuda");
    }
    
    public JTextArea textoAyuda() {
    	JTextArea texto = new JTextArea();
    	texto.setWrapStyleWord(false);
		texto.setRows(10);
		texto.setText("Este juego está compuesto por una cuadrícula de 4x4 casillas"
				+ "\r\n"
				+ "en dificultad fácil, 9x9 casillas en dificultad normal y 16x16 casillas\r\nen dificultad dificil "
				+ "dividida en regiones de 2x2, 3x3 o 4x4 casillas\r\nrespectivamente."
				+ "\r\n"
				+ "Partiendo de algunos números ya dispuestos en algunas de las casillas, "
				+ "\r\nhay que completar las casillas vacías con dígitos del 1 al 4, del 1 al 9\r\ny del 1 al 16 según la dificultad elegidasin que se repitan por fila, columna\r\no región.\r\n"
				+ "\r\n"
				+ "Reglas:\r\n"
				+ "\r\n"
				+ "Regla 1: hay que completar las casillas vacías con un solo número.\r\n"
				+ "\r\n"
				+ "Regla 2: en una misma fila no puede haber números repetidos.\r\n"
				+ "\r\n"
				+ "Regla 3: en una misma columna no puede haber números repetidos.\r\n"
				+ "\r\n"
				+ "Regla 4: en una misma región no puede haber números repetidos.\r\n"
				+ "\r\n"
				+ "Regla 5: la solución de un sudoku es única.");
		texto.setEditable(false);
    	return texto;
    }
    
    public JButton botonAtras() {
    	panelAyuda.add(Box.createVerticalStrut(10));
        return agregarBoton("Atras", panelAyuda);
    }
    
    private JButton agregarBoton (String nombre_boton, JPanel panel) {
        JButton boton = new JButton(nombre_boton);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(boton);
        return boton;
    }
}

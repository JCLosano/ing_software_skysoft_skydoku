package com.SkySoft.Skydoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Casilla extends JLabel{
    private int fila;
    private int columna;
    
    public Casilla(int fila, int columna) {
    	super("", CENTER);
        this.fila = fila;
        this.columna = columna;

        setPreferredSize(new Dimension(40, 40));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        setOpaque(true);
    }
    
    public int getFila() {
    	return fila;
    }
    
    public int getColumna() {
    	return columna;
    }
}

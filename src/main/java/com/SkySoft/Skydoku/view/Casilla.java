package com.SkySoft.Skydoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class Casilla extends JLabel {
    private int fila;
    private int columna;
    int numeroIngresado;
    
    public Casilla(int fila, int columna) {
    	super("", CENTER);
        this.fila = fila;
        this.columna = columna;

        setPreferredSize(new Dimension(63, 50));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        setOpaque(true);
        setFocusable(true);
    }
    
    public int getFila() {
    	return fila;
    }
    
    public int getColumna() {
    	return columna;
    }
    
    public void setNumber(int number, boolean userInput) {
    	numeroIngresado = number;
        setForeground(userInput ? Color.BLUE : Color.BLACK);
        setText(number > 0 && number < 17 ? number + "" : "");
    }

}

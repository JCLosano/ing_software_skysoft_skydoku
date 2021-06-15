package com.SkySoft.Skydoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Casilla extends JLabel {
    private int fila;
    private int columna;
    private JTextField numero;
    
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
        setForeground(userInput ? Color.BLUE : Color.BLACK);
        setText(number > 0 ? number + "" : "");
    }
}

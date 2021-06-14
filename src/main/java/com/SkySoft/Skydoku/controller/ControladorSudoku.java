package com.SkySoft.Skydoku.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.SkySoft.Skydoku.Model.Tablero;
import com.SkySoft.Skydoku.view.Casilla;

public class ControladorSudoku implements MouseListener, KeyListener{

	ControladorCentral controladorCentral;
	Tablero tablero;
	int teclaPresionada;
	JPanel[][] casillaGrande;
	Casilla casillaAnterior;
	
	public ControladorSudoku(ControladorCentral controladorCentral, Tablero tablero) {
		this.controladorCentral = controladorCentral;
		this.tablero = tablero;
		agregarMouseListener();
		agregarKeyListener();
	}
	
	private void agregarMouseListener() {
		casillaGrande = controladorCentral.getActiva().getCasillaGrande();//panelActiva.addMouseListener(this);
		for(int y = 0; y < tablero.getTamanio(); y++) {
			for(int x = 0; x < tablero.getTamanio(); x++) {
				casillaGrande[y][x].addMouseListener(this);
			}
		}
	}
	
	private void agregarKeyListener() {
		casillaGrande = controladorCentral.getActiva().getCasillaGrande();//panelActiva.addMouseListener(this);
		for(int y = 0; y < tablero.getTamanio(); y++) {
			for(int x = 0; x < tablero.getTamanio(); x++) {
				casillaGrande[y][x].addKeyListener(this);
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		//System.out.println("hola");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JPanel panel = (JPanel)e.getSource();
        Component component = panel.getComponentAt(e.getPoint());
        if (component instanceof Casilla) {
            Casilla casilla = (Casilla)component;
            int x = casilla.getFila();
            int y = casilla.getColumna();

            if (e.getButton() == MouseEvent.BUTTON1 && (tablero.getDificultad().getNumero(x, y) == 0)) {
            	if (casillaAnterior != null)
            		casillaAnterior.setBackground(null);
            	casilla.setBackground(Color.BLUE);
            	casillaAnterior = casilla;
                /*int number = 1;
            	if (number == -1)
                    return;
                tablero.getDificultad().setNumber(x, y, number);
                casilla.setNumber(number, true);*/
            } else if (e.getButton() == MouseEvent.BUTTON3 && !casilla.getForeground().equals(Color.BLACK)) {
            	tablero.getDificultad().setNumber(x, y, 0);
                casilla.setNumber(0, false);
            }
        }
}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("hofofoasds");
		teclaPresionada = Character.getNumericValue(e.getKeyChar());
		System.out.println(teclaPresionada);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hofofoasds");
		teclaPresionada = Character.getNumericValue(e.getKeyChar());
		System.out.println(teclaPresionada);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("hofofoasds");
		teclaPresionada = Character.getNumericValue(e.getKeyChar());
		System.out.println(teclaPresionada);
		
	}
	
}

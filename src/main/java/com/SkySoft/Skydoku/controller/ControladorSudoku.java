package com.SkySoft.Skydoku.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


import javax.swing.JPanel;

import com.SkySoft.Skydoku.Model.DBPuntuaciones;
import com.SkySoft.Skydoku.Model.Tablero;
import com.SkySoft.Skydoku.view.Casilla;

public class ControladorSudoku implements MouseListener, KeyListener{

	ControladorCentral controladorCentral;
	Tablero tablero;
	int teclaPresionada;
	JPanel[][] casillaGrande;
	Casilla[][] casillaChica;
	Casilla casillaAnterior;
	ArrayList<String> string;
	DBPuntuaciones db_puntuaciones;
	int flagCeros;
	
	public ControladorSudoku(ControladorCentral controladorCentral, Tablero tablero, DBPuntuaciones db_puntuaciones) {
		this.controladorCentral = controladorCentral;
		this.tablero = tablero;
		this.db_puntuaciones = db_puntuaciones;
		string = new ArrayList<String>();
		agregarNumeros();
		agregarMouseListener();
		agregarKeyListener();
		flagCeros = 0;
	}
	
	private void agregarMouseListener() {
		casillaGrande = controladorCentral.getActiva().getCasillaGrande();
		for(int y = 0; y < tablero.getTamanio(); y++) {
			for(int x = 0; x < tablero.getTamanio(); x++) {
				casillaGrande[y][x].addMouseListener(this);
			}
		}
	}
	
	private void agregarKeyListener() {
		controladorCentral.getActiva().getTextField().addKeyListener(this);
	}
	
	public void mouseClicked(MouseEvent e) {
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
		controladorCentral.getFrame().requestFocusInWindow();
		JPanel panel = (JPanel)e.getSource();
        Component component = panel.getComponentAt(e.getPoint());
        if (component instanceof Casilla) {
            Casilla casilla = (Casilla)component;
            int x = casilla.getFila();
            int y = casilla.getColumna();

            if (e.getButton() == MouseEvent.BUTTON1 && (tablero.getDificultad().getNumero(x, y) == 0)) {
            	System.out.println("numero resuelto: " + tablero.getDificultad().getNumerosResueltos(x, y));
            	if (casillaAnterior != null)
            		casillaAnterior.setBackground(null);
            	casilla.setBackground(Color.LIGHT_GRAY);
            	casillaAnterior = casilla;
            } else if (e.getButton() == MouseEvent.BUTTON3 && !casilla.getForeground().equals(Color.BLACK)) {
            	tablero.getDificultad().setNumber(x, y, 0);
                casilla.setNumber(0, false);
                db_puntuaciones.descontarPuntos();
                flagCeros--;
            }
        }
}
	
	/*
	 * 4 1 3 2
	   3 2 4 1
       2 3 1 4
       1 4 2 3

	 * 
	 * */
	
	public boolean chequearTablero() {
		int aux = 0;
		for(int i = 0; i < tablero.getTamanio()*tablero.getTamanio(); i++) {
        	for(int j = 0; j < tablero.getTamanio()*tablero.getTamanio(); j++) {
        		if(tablero.getDificultad().getNumerosResueltos(i, j) == tablero.getDificultad().getNumero(i, j)) {
        			aux++;
        			System.out.println("aux vale: " + aux);
        			/*System.out.println("Numero resuelto: " + tablero.getDificultad().getNumerosResueltos(i, j));
        			System.out.println("Numero ingresado: " + tablero.getDificultad().getNumero(i, j));*/
        			
        		}
        	}
        }
		if(aux == tablero.getTamanio()*tablero.getTamanio()*tablero.getTamanio()*tablero.getTamanio()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char[] numero = {' ', ' '};
		String Numero;
		String texto;
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			texto = controladorCentral.getActiva().getTextField().getText();
			if(!texto.isEmpty() && string.contains(texto) && !(casillaAnterior.getForeground().equals(Color.BLUE))) {
				for(int i = 0; i < controladorCentral.getActiva().getTextField().getText().length(); i++) {
					char ch = controladorCentral.getActiva().getTextField().getText().charAt(i);
						numero[i] = ch;
				}
				Numero = new String(numero).trim();
				casillaAnterior.setNumber(Integer.parseInt(Numero), true);
				flagCeros++;
			}
			if(flagCeros == tablero.getDificultad().getCantidadCeros()) {
            	if(chequearTablero()) {
            		System.out.println("termine el sudoku");
            	}
            	else {
            		System.out.println("lleno mal el tablero");
            	}
            }
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	private void agregarNumeros() {
		for(int i = 1; i < 17; i++) {
			string.add(i + "");
		}
	}
}

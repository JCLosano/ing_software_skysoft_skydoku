package com.SkySoft.Skydoku.controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import com.SkySoft.Skydoku.App;
import com.SkySoft.Skydoku.Model.Tablero;

public class ControladorCentral implements ActionListener {
	JFrame frame;
	App app;
	Tablero tablero;
	
    public ControladorCentral(JFrame frame, Tablero tablero) {
    	this.frame = frame;
    	this.tablero = tablero;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jugar":
        		frame.remove(App.menuPrincipal.panelMenuPrincipal);
        		frame.add(App.jugar.panelJugar);
        		break;
            case "AtrasJugar":
        		frame.remove(App.jugar.panelJugar);
        		frame.add(App.menuPrincipal.panelMenuPrincipal);
        		break;
            case "Ayuda": 
            	frame.remove(App.menuPrincipal.panelMenuPrincipal);
            	frame.add(App.ayuda.panelAyuda);
            	break;
            case "AtrasAyuda":
            	frame.remove(App.ayuda.panelAyuda);
            	frame.add(App.menuPrincipal.panelMenuPrincipal);
            	break;
            case "Facil":
            	App.jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	App.activa.crearGrilla(tablero.getTamanio(),tablero.getTamanio());
            	//LLAMAR LLENAR TABLERO.
            	App.activa.pnlAlign.setPreferredSize(new Dimension(300,200));
            	frame.remove(App.jugar.panelJugar);
            	frame.add(App.activa.pnlAlign);
            	break;
            case "Normal":
            	App.jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	App.activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
            	//LLAMAR LLENAR TABLERO.
            	App.activa.pnlAlign.setPreferredSize(new Dimension(600,400));
            	frame.remove(App.jugar.panelJugar);
            	frame.add(App.activa.pnlAlign);
            	break;
            case "Dificil":
            	App.jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	App.activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
            	//LLAMAR LLENAR TABLERO.
            	App.activa.pnlAlign.setPreferredSize(new Dimension(800,700));
            	frame.remove(App.jugar.panelJugar);
            	frame.add(App.activa.pnlAlign);
            	break;
            case "Registrar":
            	chequearNombre();
            	//App.jugar.frameNombre.setVisible(false);
            	break;
            case "MenuPrincipal":
            	frame.remove(App.activa.pnlAlign);
            	frame.add(App.menuPrincipal.panelMenuPrincipal);
            	break;
            default:
            	break;
        }
        frame.pack();
        frame.setVisible(true);
        frame.repaint();
    }
    
    private void chequearNombre() {
    	String nombre;
    	JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	JTextArea texto = new JTextArea();
    	
    	nombre = App.jugar.textField.getText().trim();
    	String caracteresEspeciales = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
    	if (!(nombre.isEmpty()) || nombre.length() < 20) {
			
    		for (int i=0; i < nombre.length() ; i++)
    		{
    			char ch = nombre.charAt(i);
    			if(caracteresEspeciales.contains(Character.toString(ch))) {
    	    		frame.setBounds(100, 100, 400, 200);
    				frame.getContentPane().add(panel, BorderLayout.CENTER);
    				
    		    	texto.setWrapStyleWord(false);
    				texto.setRows(2);
    				texto.setText("Ingrese un nombre sin caracteres especiales \n (!@#$%&*()'+,-./:;<=>?[]^_`{|}).");
    				texto.setEditable(false);
    				
    				frame.setVisible(true);
    				
    				panel.add(texto);
    				
    				break;
    			}
    			else {
    				//Guardar el nombre en la DB
    				App.jugar.frameNombre.setVisible(false);
    			}
    		}
    	}
    	App.jugar.textField.setText("");
    	
    }
}

package com.SkySoft.Skydoku.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.SkySoft.Skydoku.App;
import com.SkySoft.Skydoku.Model.Tablero;
import com.SkySoft.Skydoku.view.Activa;
import com.SkySoft.Skydoku.view.Ayuda;
import com.SkySoft.Skydoku.view.Jugar;
import com.SkySoft.Skydoku.view.MenuPrincipal;

public class ControladorCentral implements ActionListener {
	JFrame frame;
	MenuPrincipal menuPrincipal;
	Tablero tablero;
	Ayuda ayuda;
	Jugar jugar;
	Activa activa;
	//int[][] numerosTablero;
	
    public ControladorCentral() {
    	frame = new JFrame("SKYDOKU");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuPrincipal = new MenuPrincipal(frame, this);
    	tablero = new Tablero();

		frame.add(menuPrincipal.panelMenuPrincipal);
		frame.pack();
		frame.setVisible(true);

    	ayuda = new Ayuda(this);
    	jugar = new Jugar(this);
    	activa = new Activa(this, tablero);


    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jugar":
        		frame.remove(menuPrincipal.panelMenuPrincipal);
        		frame.add(jugar.panelJugar);
        		break;
            case "AtrasJugar":
        		frame.remove(jugar.panelJugar);
        		frame.add(menuPrincipal.panelMenuPrincipal);
        		break;
            case "Ayuda": 
            	frame.remove(menuPrincipal.panelMenuPrincipal);
            	frame.add(ayuda.panelAyuda);
            	break;
            case "AtrasAyuda":
            	frame.remove(ayuda.panelAyuda);
            	frame.add(menuPrincipal.panelMenuPrincipal);
            	break;
            case "Facil":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	activa.crearGrilla(tablero.getTamanio(),tablero.getTamanio());
            	//LLAMAR LLENAR TABLERO.
				activa.pnlAlign.setPreferredSize(new Dimension(300,200));
/*            	frame.remove(jugar.panelJugar);
            	frame.add(activa.pnlAlign);*/
            	break;
            case "Normal":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
            	//LLAMAR LLENAR TABLERO.
            	activa.pnlAlign.setPreferredSize(new Dimension(600,400));
/*            	frame.remove(jugar.panelJugar);
            	frame.add(activa.pnlAlign);*/
            	break;
            case "Dificil":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
            	//activa.
            	//LLAMAR LLENAR TABLERO.
            	activa.pnlAlign.setPreferredSize(new Dimension(800,700));
/*            	frame.remove(jugar.panelJugar);
            	frame.add(activa.pnlAlign);*/
            	break;
            case "Registrar":
            	if(chequearNombre()) {
					frame.remove(jugar.panelJugar);
					frame.add(activa.pnlAlign);
					jugar.frameNombre.setVisible(false);
				}
            	break;
            case "Menu Principal":
            	frame.remove(activa.pnlAlign);
            	frame.add(menuPrincipal.panelMenuPrincipal);
            	break;
            default:
            	break;
        }
        frame.pack();
        frame.setVisible(true);
        frame.repaint();
    }
    
    private boolean chequearNombre() {
    	String nombre;
    	JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	JTextArea texto = new JTextArea();
    	
    	nombre = jugar.textField.getText().trim();
    	String caracteresEspeciales = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
    	if (!(nombre.isEmpty()) || nombre.length() < 20) {
			
    		for (int i=0; i < nombre.length() ; i++) {
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
    				
    				return false;
    			}
    			else {
    				//Guardar el nombre en la DB
    				//jugar.frameNombre.setVisible(false);
					jugar.textField.setText("");
    				return true;
    			}
    		}
    	}
		else {
			return false;
		}
    	return false;
    }

    public JFrame getFrame() {
    	return frame;
	}

	public MenuPrincipal getMenuPrincipal() {
    	return menuPrincipal;
	}

	public Activa getActiva(){
    	return activa;
	}

	public Ayuda getAyuda() {
    	return ayuda;
	}

	public Jugar getJugar(){
    	return jugar;
	}
}

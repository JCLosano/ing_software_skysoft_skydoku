package com.SkySoft.Skydoku.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.SkySoft.Skydoku.Model.DBUsuarios;
import com.SkySoft.Skydoku.Model.Tablero;
import com.SkySoft.Skydoku.view.Activa;
import com.SkySoft.Skydoku.view.Ayuda;
import com.SkySoft.Skydoku.view.Jugar;
import com.SkySoft.Skydoku.view.MenuPrincipal;
import com.SkySoft.Skydoku.view.Puntuaciones;

public class ControladorCentral implements ActionListener {
	JFrame frame;
	MenuPrincipal menuPrincipal;
	Tablero tablero;
	Ayuda ayuda;
	Jugar jugar;
	Activa activa;
	Puntuaciones puntuaciones;
	DBUsuarios dbUsuarios;
	ControladorSudoku controladorSudoku;
	String nombre;

	int[][] numerosTablero;

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
    	dbUsuarios = new DBUsuarios();
    	//puntuaciones = new Puntuaciones();

    }
    
    public void mouseClicked(MouseEvent e) {
    	System.out.println(e.toString());
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
            case "PuntuacionesMenu":
            	puntuaciones = new Puntuaciones();
            	//frame.remove(menuPrincipal.panelMenuPrincipal);
            	//frame.add(puntuaciones.getPanelPuntuaciones());
            	break;
            case "Facil":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	
				crearActiva();
				activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
				activa.cargarTablero();
				controladorSudoku = new ControladorSudoku(this, tablero);

            	//LLAMAR LLENAR TABLERO.
				activa.pnlAlign.setPreferredSize(new Dimension(400,300));
            	break;
            case "Normal":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());

				crearActiva();
				activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
				activa.cargarTablero();


            	//LLAMAR LLENAR TABLERO.
            	activa.pnlAlign.setPreferredSize(new Dimension(800,600));
            	break;
            case "Dificil":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());

				crearActiva();
				activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
				activa.cargarTablero();


            	//LLAMAR LLENAR TABLERO.
            	activa.pnlAlign.setPreferredSize(new Dimension(1366,900));
            	break;
            case "Registrar":
            	if(chequearNombre()) {
            		dbUsuarios.guardarNombre(nombre);
					frame.remove(jugar.panelJugar);
					frame.add(activa.pnlAlign);
					jugar.frameNombre.setVisible(false);
				}
            	break;
            case "Menu Principal":
            	frame.remove(activa.pnlAlign);
            	borrarActiva();
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

	public void crearActiva() {
    	activa = new Activa(this, tablero);
	}

	private void borrarActiva() {
    	activa = null;
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

package com.SkySoft.Skydoku.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.SkySoft.Skydoku.Model.DBPuntuaciones;
import com.SkySoft.Skydoku.Model.Tablero;
import com.SkySoft.Skydoku.view.*;

public class ControladorCentral implements ActionListener {
	private JFrame frame;
	private MenuPrincipal menuPrincipal;
	private Tablero tablero;
	private Ayuda ayuda;
	private Jugar jugar;
	private Activa activa;
	private Puntuaciones puntuaciones;
	private DBPuntuaciones dbPuntuaciones;
	private ControladorSudoku controladorSudoku;
	private String nombre;

    public ControladorCentral() {
    	frame = new JFrame("SKYDOKU");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuPrincipal = new MenuPrincipal(frame, this);
    	tablero = Tablero.getInstance();

		frame.add(menuPrincipal.panelMenuPrincipal);
		frame.pack();
		frame.setVisible(true);

    	ayuda = new Ayuda(this);
    	jugar = new Jugar(this);
    	dbPuntuaciones = DBPuntuaciones.getInstance();

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
            	break;
			case "Puntuaciones":
				puntuaciones = new Puntuaciones(); 
				break;
            case "Facil":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	
				crearActiva();
				activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
				activa.cargarTablero();
				
				activa.pnlAlign.setPreferredSize(new Dimension(600, 300));
            	break;
            case "Normal":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());

				crearActiva();
				activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
				activa.cargarTablero();

            	activa.pnlAlign.setPreferredSize(new Dimension(900,600));
            	break;
            case "Dificil":
            	jugar.frameNombre.setVisible(true);
            	tablero.crearTablero(e.getActionCommand());
            	
				crearActiva();
				activa.crearGrilla(tablero.getTamanio(), tablero.getTamanio());
				activa.cargarTablero();

            	activa.pnlAlign.setPreferredSize(new Dimension(1500,900));
            	break;
            case "Registrar":
            	if(chequearNombre()) {
            		controladorSudoku = new ControladorSudoku(this);
            		dbPuntuaciones.setPuntuacion(1000);
            		dbPuntuaciones.guardarNombre(nombre);
					frame.remove(jugar.panelJugar);
					frame.add(activa.pnlAlign);
					dbPuntuaciones.getTimer().start();
					jugar.frameNombre.setVisible(false);
				}
            	break;
            case "Menu Principal":
            	frame.remove(activa.pnlAlign);
            	dbPuntuaciones.removeObserver(puntuaciones);
            	borrarActiva();
            	frame.add(menuPrincipal.panelMenuPrincipal);
            	break;

			case "Salir":
				getActiva().getFramePerdio().setVisible(false);
				frame.remove(activa.pnlAlign);
				dbPuntuaciones.removeObserver(puntuaciones);
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
    	activa = new Activa(this);
	}

	private void borrarActiva() {
		dbPuntuaciones.getTimer().stop();
		dbPuntuaciones.removeObserver(activa);
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

	public Puntuaciones getPuntuaciones() { return puntuaciones;}

}

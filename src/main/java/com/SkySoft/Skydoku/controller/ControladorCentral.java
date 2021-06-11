package com.SkySoft.Skydoku.controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.SkySoft.Skydoku.App;

public class ControladorCentral implements ActionListener {
	JFrame frame;
	App app;
	
    public ControladorCentral(JFrame frame) {
    	this.frame = frame;
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
            default:
            	break;
        }
        frame.pack();
        frame.setVisible(true);
        frame.repaint();
    }
}

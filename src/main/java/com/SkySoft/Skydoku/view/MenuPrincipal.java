package com.SkySoft.Skydoku.view;

import com.SkySoft.Skydoku.controller.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MenuPrincipal {
    public JPanel panelMenuPrincipal = new JPanel();
    private JButton boton_jugar;

    public MenuPrincipal(JFrame frame, ControladorCentral controladorCentral) {

        TitledBorder border;
        border = crearBorder();

        panelMenuPrincipal.setBorder(border);
        panelMenuPrincipal.setLayout(new BoxLayout(panelMenuPrincipal, BoxLayout.Y_AXIS));
        panelMenuPrincipal.setPreferredSize(new Dimension(640, 480));
        //frame.add(panelMenuPrincipal);

        panelMenuPrincipal.add(Box.createVerticalStrut(150));
        
        boton_jugar = botonJugar();
        boton_jugar.addActionListener(controladorCentral);
        
        JButton boton_ayuda = botonAyuda();
        boton_ayuda.addActionListener(controladorCentral);
        
        JButton boton_puntuaciones = botonPuntuaciones();
        boton_puntuaciones.addActionListener(controladorCentral);
        
        //frame.pack();
        //frame.setVisible(true);
    }
    
    public JButton getBotonJugar() {
    	return boton_jugar;
    }

    public TitledBorder crearBorder() {
        return BorderFactory.createTitledBorder("Menu Principal");
    }
    
    public JButton botonJugar() {
    	panelMenuPrincipal.add(Box.createVerticalStrut(10));
        return agregarBoton("Jugar", panelMenuPrincipal);
    }

    public JButton botonAyuda() {
        panelMenuPrincipal.add(Box.createVerticalStrut(10));
        return agregarBoton("Ayuda", panelMenuPrincipal);
    }
    
    public JButton botonPuntuaciones() {
        panelMenuPrincipal.add(Box.createVerticalStrut(10));
        return agregarBoton("Puntuaciones", panelMenuPrincipal);
    }
    
    private JButton agregarBoton (String nombre_boton, JPanel panel) {
        JButton boton = new JButton(nombre_boton);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(boton);
        return boton;
    }
    

}
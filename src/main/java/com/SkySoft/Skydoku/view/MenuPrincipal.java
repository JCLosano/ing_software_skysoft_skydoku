package com.SkySoft.Skydoku.view;

import com.SkySoft.Skydoku.controller.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MenuPrincipal {
    public JPanel panelMenuPrincipal = new JPanel();
    private JButton boton_jugar, boton_puntuaciones, boton_ayuda;
    TitledBorder border;

    public MenuPrincipal(JFrame frame, ControladorCentral controladorCentral) {
        border = crearBorder();

        panelMenuPrincipal.setBorder(border);
        panelMenuPrincipal.setLayout(new BoxLayout(panelMenuPrincipal, BoxLayout.Y_AXIS));
        panelMenuPrincipal.setPreferredSize(new Dimension(640, 480));
        //frame.add(panelMenuPrincipal);

        panelMenuPrincipal.add(Box.createVerticalStrut(150));
        
        boton_jugar = botonJugar();
        boton_jugar.addActionListener(controladorCentral);
        
        boton_ayuda = botonAyuda();
        boton_ayuda.addActionListener(controladorCentral);
        
        boton_puntuaciones = botonPuntuaciones();
        boton_puntuaciones.addActionListener(controladorCentral);
        boton_puntuaciones.setActionCommand("PuntuacionesMenu");
        
        //frame.pack();
        //frame.setVisible(true);
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

    public JButton getBotonJugar() {
        return boton_jugar;
    }

    public JButton getBotonPuntuaciones() {
        return boton_puntuaciones;
    }

    public JButton getBotonAyuda() {
        return boton_ayuda;
    }

    public TitledBorder getTitledBorder() {
        return border;
    }
    

}
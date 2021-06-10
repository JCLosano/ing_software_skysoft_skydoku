package com.SkySoft.Skydoku.view;

import com.SkySoft.Skydoku.controller.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    JPanel panelMenuPrincipal = new JPanel();

    public MenuPrincipal() {
        super ("Skydoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        TitledBorder border;
        border = crearBorder();

        panelMenuPrincipal.setBorder(border);
        panelMenuPrincipal.setLayout(new BoxLayout(panelMenuPrincipal, BoxLayout.Y_AXIS));
        panelMenuPrincipal.setPreferredSize(new Dimension(640, 480));
        add(panelMenuPrincipal);

        ControladorCentral controladorCentral = new ControladorCentral();

        JButton boton_jugar = agregarBoton("Jugar", panelMenuPrincipal);
        boton_jugar.addActionListener(controladorCentral);

        setVisible(true);
    }

    public TitledBorder crearBorder() {
        return BorderFactory.createTitledBorder("Menu Principal");
    }

    private JButton agregarBoton (String nombre_boton, JPanel panel) {
        JButton boton = new JButton(nombre_boton);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(boton);
        panel.add(Box.createHorizontalStrut(10));
        return boton;
    }

}
package com.SkySoft.Skydoku;

import com.SkySoft.Skydoku.Model.Tablero;
import com.SkySoft.Skydoku.controller.ControladorCentral;
import com.SkySoft.Skydoku.view.*;
import javax.swing.*;
//import java.awt.*;

public class App {
	public static Tablero tablero;
	public static MenuPrincipal menuPrincipal;
	public static Ayuda ayuda;
	public static Jugar jugar;
	public static Activa activa;
	
    public static void main( String[] args )
    {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ex) { ex.printStackTrace(); }
/*        JFrame frame = new JFrame("SKYDOKU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablero = new Tablero();*/
        
        ControladorCentral controladorCentral = new ControladorCentral();
/*
        menuPrincipal = new MenuPrincipal(frame, controladorCentral);
        
        frame.add(menuPrincipal.panelMenuPrincipal);
        frame.pack();
        frame.setVisible(true);
        ayuda = new Ayuda(controladorCentral);
        jugar = new Jugar(controladorCentral);
        activa = new Activa(controladorCentral, tablero);*/
        
    }
}

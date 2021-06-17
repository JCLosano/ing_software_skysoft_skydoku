package com.SkySoft.Skydoku;

import com.SkySoft.Skydoku.controller.ControladorCentral;
import javax.swing.*;

public class App {
	
    public static void main( String[] args )
    {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ex) { ex.printStackTrace(); }
        
        new ControladorCentral();
        
    }
}

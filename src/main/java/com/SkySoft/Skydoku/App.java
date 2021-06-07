package com.SkySoft.Skydoku;

import com.SkySoft.Skydoku.view.*;
import javax.swing.*;
import java.awt.*;

public class App {
    public static void main( String[] args )
    {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ex) { ex.printStackTrace(); }
        new MenuPrincipal();
    }
}

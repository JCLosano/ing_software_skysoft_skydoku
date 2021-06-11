package com.SkySoft.Skydoku;

import static org.junit.Assert.*;

import com.SkySoft.Skydoku.controller.ControladorCentral;
import com.SkySoft.Skydoku.view.Ayuda;
import com.SkySoft.Skydoku.view.Jugar;
import com.SkySoft.Skydoku.view.MenuPrincipal;
import org.junit.Test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Unit test for simple App.
 */
public class UnitTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void textoMenuPrincipal_vMenuPrincipal()
    {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
        MenuPrincipal menuPrincipal = new MenuPrincipal(frame, controladorCentral);
        TitledBorder border = menuPrincipal.crearBorder();
        assertEquals("Menu Principal", border.getTitle());
    }
    
    @Test
    public void botonJugar_vMenuPrincipal() 
    {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
    	MenuPrincipal menuPrincipal = new MenuPrincipal(frame, controladorCentral);
    	JButton jugar = menuPrincipal.botonJugar();
    	assertEquals("JButton", jugar.getClass().getSimpleName());
    	assertEquals("Jugar", jugar.getText());
    }
    
    @Test
    public void botonPuntuaciones_vMenuPrincipal() 
    {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
    	MenuPrincipal menuPrincipal = new MenuPrincipal(frame, controladorCentral);
    	JButton puntuaciones = menuPrincipal.botonPuntuaciones();
    	assertEquals("JButton", puntuaciones.getClass().getSimpleName());
    	assertEquals("Puntuaciones", puntuaciones.getText());
    }
    
    @Test
    public void botonAyuda_vMenuPrincipal()
    {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
    	MenuPrincipal menuPrincipal = new MenuPrincipal(frame, controladorCentral);
    	JButton ayuda = menuPrincipal.botonAyuda();
    	assertEquals("JButton", ayuda.getClass().getSimpleName());
    	assertEquals("Ayuda", ayuda.getText());
    }
    
    @Test
    public void textoAyuda_vAyuda() {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
    	Ayuda ayuda = new Ayuda(controladorCentral);
    	JTextArea textoAyuda = ayuda.textoAyuda();
    	assertEquals(false, textoAyuda.getText().isEmpty());
    }
    
    @Test
    public void botonFacil_vJugar() {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
    	Jugar jugar = new Jugar(controladorCentral);
    	JButton facil = jugar.botonFacil();
    	assertEquals("JButton", facil.getClass().getSimpleName());
    	assertEquals("Facil", facil.getText());
    }
    
    @Test
    public void botonNormal_vJugar() {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
    	Jugar jugar = new Jugar(controladorCentral);
    	JButton normal = jugar.botonNormal();
    	assertEquals("JButton", normal.getClass().getSimpleName());
    	assertEquals("Normal", normal.getText());
    }
    
    @Test
    public void botonDificil_vJugar() {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
    	Jugar jugar = new Jugar(controladorCentral);
    	JButton dificil = jugar.botonDificil();
    	assertEquals("JButton", dificil.getClass().getSimpleName());
    	assertEquals("Dificil", dificil.getText());
    }
    
    @Test
    public void botonAtras_vJugar() {
    	JFrame frame = new JFrame();
    	ControladorCentral controladorCentral = new ControladorCentral(frame);
    	Jugar jugar = new Jugar(controladorCentral);
    	JButton atras = jugar.botonAtras();
    	assertEquals("JButton", atras.getClass().getSimpleName());
    	assertEquals("Atras", atras.getText());
    }
    
}

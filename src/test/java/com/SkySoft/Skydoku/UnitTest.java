package com.SkySoft.Skydoku;

import static org.junit.Assert.*;

import com.SkySoft.Skydoku.Model.DBPuntuaciones;
import com.SkySoft.Skydoku.Model.Dificultad;
import com.SkySoft.Skydoku.Model.Facil;
import com.SkySoft.Skydoku.Model.Tablero;
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
    	ControladorCentral controladorCentral = new ControladorCentral();

        assertEquals("Menu Principal"
                    , controladorCentral.getMenuPrincipal().getTitledBorder().getTitle());
    }
    
    @Test
    public void botonJugar_vMenuPrincipal() 
    {
    	ControladorCentral controladorCentral = new ControladorCentral();

        assertEquals("JButton"
                    , controladorCentral.getMenuPrincipal().getBotonJugar().getClass().getSimpleName());
    	assertEquals("Jugar"
                    , controladorCentral.getMenuPrincipal().getBotonJugar().getText());
    }
    
    @Test
    public void botonPuntuaciones_vMenuPrincipal() 
    {

    	ControladorCentral controladorCentral = new ControladorCentral();

        assertEquals("JButton"
                    , controladorCentral.getMenuPrincipal().getBotonPuntuaciones().getClass().getSimpleName());
    	assertEquals("Puntuaciones"
                    , controladorCentral.getMenuPrincipal().getBotonPuntuaciones().getText());
    }
    
    @Test
    public void botonAyuda_vMenuPrincipal()
    {
    	ControladorCentral controladorCentral = new ControladorCentral();

        assertEquals("JButton"
                , controladorCentral.getMenuPrincipal().getBotonAyuda().getClass().getSimpleName());
        assertEquals("Ayuda"
                , controladorCentral.getMenuPrincipal().getBotonAyuda().getText());
    }
    
    @Test
    public void textoAyuda_vAyuda() {
    	ControladorCentral controladorCentral = new ControladorCentral();

    	assertFalse(controladorCentral.getAyuda().textoAyuda().getText().isEmpty());
    }
    
    @Test
    public void botonFacil_vJugar() {

    	ControladorCentral controladorCentral = new ControladorCentral();

        assertEquals("JButton"
                    , controladorCentral.getJugar().getBotonFacil().getClass().getSimpleName());
        assertEquals("Facil", controladorCentral.getJugar().getBotonFacil().getText());

    }
    
    @Test
    public void botonNormal_vJugar() {
        ControladorCentral controladorCentral = new ControladorCentral();

        assertEquals("JButton"
                    , controladorCentral.getJugar().getBotonNormal().getClass().getSimpleName());
        assertEquals("Normal", controladorCentral.getJugar().getBotonNormal().getText());
    }
    
    @Test
    public void botonDificil_vJugar() {
        ControladorCentral controladorCentral = new ControladorCentral();

        assertEquals("JButton"
                    , controladorCentral.getJugar().getBotonDificil().getClass().getSimpleName());
        assertEquals("Dificil", controladorCentral.getJugar().getBotonDificil().getText());
    }
    
    @Test
    public void botonAtras_vJugar() {
        ControladorCentral controladorCentral = new ControladorCentral();

        assertEquals("JButton"
                    , controladorCentral.getJugar().getBotonAtras().getClass().getSimpleName());
        assertEquals("Atras", controladorCentral.getJugar().getBotonAtras().getText());
    }

    @Test
    public void botonMenuPrincipal_vActiva() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.crearActiva();

        assertEquals("JButton"
                    , controladorCentral.getActiva().getBotonMenuPrincipal().getClass().getSimpleName());
        assertEquals("Menu Principal"
                    , controladorCentral.getActiva().getBotonMenuPrincipal().getText());
    }

    @Test
    public void test_guardarNombre() {

        Tablero tablero = new Tablero();
        DBPuntuaciones dbPuntuaciones = DBPuntuaciones.getInstance(tablero);
        dbPuntuaciones.guardarNombre("Juan");

        assertEquals("Juan", dbPuntuaciones.getNombreActual());
    }
}

package com.SkySoft.Skydoku;

import com.SkySoft.Skydoku.controller.ControladorCentral;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class VistasUnitTest {
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
}

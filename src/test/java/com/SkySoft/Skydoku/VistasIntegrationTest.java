package com.SkySoft.Skydoku;

import com.SkySoft.Skydoku.controller.ControladorCentral;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VistasIntegrationTest {

    @Test
    public void Jugar_vMenuPrincipal() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.getMenuPrincipal().getBotonJugar().doClick();

        assertTrue(controladorCentral.getJugar().panelJugar.isShowing());
    }

    @Test
    public void puntuaciones_vMenuPrincipal() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.getMenuPrincipal().getBotonPuntuaciones().doClick();

        assertTrue(controladorCentral.getPuntuaciones().getMitabla2().isShowing());
    }

    @Test
    public void seleccionarFacil_vJugar() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.getJugar().getBotonFacil().doClick();

        controladorCentral.getJugar().getTextField().setText("oscar");

        controladorCentral.getJugar().getBotonRegistrar().doClick();

        assertEquals(4,controladorCentral.getActiva().getTamanioTablero());
    }

    @Test
    public void seleccionarNormal_vJugar() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.getJugar().getBotonNormal().doClick();

        controladorCentral.getJugar().getTextField().setText("oscar");

        controladorCentral.getJugar().getBotonRegistrar().doClick();

        assertEquals(9,controladorCentral.getActiva().getTamanioTablero());
    }

    @Test
    public void seleccionarDificil_vJugar() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.getJugar().getBotonDificil().doClick();

        controladorCentral.getJugar().getTextField().setText("oscar");

        controladorCentral.getJugar().getBotonRegistrar().doClick();

        assertEquals(16,controladorCentral.getActiva().getTamanioTablero());
    }

    @Test
    public void puntuaciones_vActiva() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.getJugar().getBotonFacil().doClick();

        controladorCentral.getJugar().getTextField().setText("pedro");

        controladorCentral.getJugar().getBotonRegistrar().doClick();

        controladorCentral.getActiva().getBotonPuntuaciones().doClick();

        assertTrue(controladorCentral.getPuntuaciones().getMitabla2().isShowing());
    }

    @Test
    public void menuPrincipal_vActiva() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.crearActiva();

        controladorCentral.getActiva().getBotonMenuPrincipal().doClick();

        assertTrue(controladorCentral.getMenuPrincipal().panelMenuPrincipal.isShowing());
    }

    @Test
    public void puntajeCero_vActiva() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.getJugar().getBotonDificil().doClick();

        controladorCentral.getJugar().getTextField().setText("oscar");

        controladorCentral.getJugar().getBotonRegistrar().doClick();

        controladorCentral.getActiva().getDBPuntuaciones().setPuntuacion(0);

        assertTrue(controladorCentral.getActiva().getFramePerdio().isShowing());
    }
}

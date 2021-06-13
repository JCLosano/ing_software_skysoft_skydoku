package com.SkySoft.Skydoku;

import com.SkySoft.Skydoku.Model.Tablero;
import org.junit.Test;

import com.SkySoft.Skydoku.controller.ControladorCentral;
import com.SkySoft.Skydoku.view.Jugar;
import com.SkySoft.Skydoku.view.MenuPrincipal;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IntegrationTest {
	
	@Test
	public void Jugar_vMenuPrincipal() {
        ControladorCentral controladorCentral = new ControladorCentral();

        controladorCentral.getMenuPrincipal().getBotonJugar().doClick();
        
        assertTrue(controladorCentral.getJugar().panelJugar.isShowing());
	}

	@Test
	public void menuPrincipal_vActiva() {
	    ControladorCentral controladorCentral = new ControladorCentral();

	    controladorCentral.getActiva().getBotonMenuPrincipal().doClick();

	    assertTrue(controladorCentral.getMenuPrincipal().panelMenuPrincipal.isShowing());
    }

/*    @Test
	public void seleccionarFacil_vJugar() {
		ControladorCentral controladorCentral = new ControladorCentral();

		controladorCentral.getJugar().getBotonFacil().doClick();

		controladorCentral.getJugar().getTextField().setText("oscar");

		controladorCentral.getJugar().getBotonRegistrar().doClick();

		assertTrue(controladorCentral.getActiva().);
		//CHEQUEAR QUE SE ARME EL TABLERO DE TAMANIO 2
	}*/
}

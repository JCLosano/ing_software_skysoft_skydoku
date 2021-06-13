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
        
        assertEquals(true, controladorCentral.getJugar().panelJugar.isShowing());
	}
}

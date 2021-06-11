package com.SkySoft.Skydoku;

import static org.junit.Assert.*;

import com.SkySoft.Skydoku.view.MenuPrincipal;
import org.junit.Test;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

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
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        TitledBorder border = menuPrincipal.crearBorder();
        assertEquals("Menu Principal", border.getTitle());
    }
}

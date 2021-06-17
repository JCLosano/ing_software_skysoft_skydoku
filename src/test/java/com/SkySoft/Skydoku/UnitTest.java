package com.SkySoft.Skydoku;

import static org.junit.Assert.*;

import com.SkySoft.Skydoku.Model.DBPuntuaciones;
import com.SkySoft.Skydoku.Model.Tablero;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class UnitTest
{
    @Test
    public void test_guardarNombre() {

        Tablero tablero = Tablero.getInstance();
        DBPuntuaciones dbPuntuaciones = DBPuntuaciones.getInstance(tablero);
        dbPuntuaciones.guardarNombre("Juan");

        assertEquals("Juan", dbPuntuaciones.getNombreActual());
    }
}

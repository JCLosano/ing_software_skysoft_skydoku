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
        DBPuntuaciones dbPuntuaciones = DBPuntuaciones.getInstance();
        dbPuntuaciones.guardarNombre("Juan");

        assertEquals("Juan", dbPuntuaciones.getNombreActual());
    }

    @Test
    public void test_singletoDBPuntuaciones() {
        DBPuntuaciones db1 = DBPuntuaciones.getInstance();
        DBPuntuaciones db2 = DBPuntuaciones.getInstance();

        assertEquals(db1,db2);
    }

    @Test
    public void test_singletonTablero() {
        Tablero t1 = Tablero.getInstance();
        Tablero t2 = Tablero.getInstance();

        assertEquals(t1, t2);
    }

}

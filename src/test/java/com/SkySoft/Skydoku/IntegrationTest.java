package com.SkySoft.Skydoku;

import com.SkySoft.Skydoku.Model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegrationTest {

	@Test
	public void test_getTamanioTableroFacil() {
		Tablero t = Tablero.getInstance();
		Dificultad facil = new Facil();

		t.crearTablero(facil.getClass().getSimpleName());
		int tamanio_tablero = facil.tamanioTablero();

		assertEquals(tamanio_tablero, t.getTamanio());
	}

	@Test
	public void test_getTamanioTableroNormal() {
		Tablero t = Tablero.getInstance();
		Dificultad normal = new Normal();

		t.crearTablero(normal.getClass().getSimpleName());
		int tamanio_tablero = normal.tamanioTablero();

		assertEquals(tamanio_tablero, t.getTamanio());
	}

	@Test
	public void test_getTamanioTableroDificil() {
		Tablero t = Tablero.getInstance();
		Dificultad dificil = new Dificil();

		t.crearTablero(dificil.getClass().getSimpleName());
		int tamanio_tablero = dificil.tamanioTablero();

		assertEquals(tamanio_tablero, t.getTamanio());
	}

}

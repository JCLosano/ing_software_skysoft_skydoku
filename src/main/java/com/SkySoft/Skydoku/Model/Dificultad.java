package com.SkySoft.Skydoku.Model;

public interface Dificultad {
	public int tamanioTablero();
	public int[][] llenarTablero();
	public int getNumero(int x, int y);
	public int getCantidadCeros();
	public int getNumerosResueltos(int x, int y);
	public int setNumber(int x, int y, int number);
}

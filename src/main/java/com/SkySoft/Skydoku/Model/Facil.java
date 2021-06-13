package com.SkySoft.Skydoku.Model;

public class Facil implements Dificultad{
	
	private final int tamanio = 2;
//	private int[][] numerosTablero;
	
	public Facil() {
//		numerosTablero = new int[tamanio*tamanio][tamanio*tamanio];
	}
	
	public int tamanioTablero() {
		return tamanio;
	}
	
	public int[][] llenarTablero() {
		int [][] numerosTablero = 
		{{4, 0, 3, 0,},
		 {0, 2, 0, 0,},
		 {0, 0, 1, 0,},
		 {0, 4, 0, 3,}
		};
		
		return numerosTablero;
	}
}

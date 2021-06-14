package com.SkySoft.Skydoku.Model;

public class Normal implements Dificultad{
	
	private final int tamanio = 3;
	
	public int tamanioTablero() {
		return tamanio;
	}
	
	public int[][] llenarTablero() {
		int [][] numerosTablero = 
		{{0, 3, 0, 2, 0, 1, 9, 0, 5,},
		 {0, 0, 0, 0, 6, 0, 0, 0, 1,},
		 {0, 2, 0, 4, 0, 9, 0, 0, 0,},
		 {2, 8, 0, 6, 0, 0, 4, 0, 0,},
		 {6, 0, 5, 0, 4, 0, 1, 0, 8,},
		 {0, 0, 1, 0, 0, 5, 0, 7, 6,},
		 {0, 0, 0, 7, 0, 2, 0, 1, 0,},
		 {8, 0, 0, 0, 3, 0, 0, 0, 0,},
		 {7, 0, 2, 5, 0, 4, 0, 8, 0,},
		};
		
		return numerosTablero;
	}
}

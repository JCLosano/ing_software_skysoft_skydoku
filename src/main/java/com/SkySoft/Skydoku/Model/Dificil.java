package com.SkySoft.Skydoku.Model;

public class Dificil implements Dificultad{
	
	private final int tamanio = 4;
	
	public Dificil() {
	}
	
	public int tamanioTablero() {
		return tamanio;
	}
	
	public int [][] llenarTablero() {
		int [][] numerosTablero = 
		{{0, 13, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 2, 0,},
		 {3, 0, 0, 14, 0, 0, 0, 13, 7, 0, 0, 0, 11, 0, 0, 10,},
		 {12, 0, 0, 15, 10, 11, 2, 0, 0, 4, 16, 13, 5, 0, 0, 1,},
		 {0, 2, 1, 11, 6, 0, 0, 12, 8, 0, 0, 3, 13, 9, 16, 0,},
		 {0, 0, 11, 16, 3, 0, 14, 9, 4, 5, 0, 2, 15, 7, 0, 0,},
		 {0, 0, 12, 0, 0, 4, 10, 0, 0, 11, 14, 0, 0, 16, 0, 0,},
		 {0, 0, 2, 0, 7, 13, 0, 0, 0, 0, 3, 6, 0, 4, 0, 0,},
		 {0, 3, 0, 1, 8, 0, 0, 2, 15, 0, 0, 9, 10, 0, 11, 0,},
		 {0, 8, 0, 6, 2, 0, 0, 14, 9, 0, 0, 5, 12, 0, 4, 0,},
		 {0, 0, 14, 0, 11, 5, 0, 0, 0, 0, 8, 12, 0, 2, 0, 0,},
		 {0, 0, 5, 0, 0, 10, 13, 0, 0, 1, 4, 0, 0, 11, 0, 0,},
		 {0, 0, 10, 4, 9, 0, 12, 8, 6, 14, 0, 16, 7, 5, 0, 0,},
		 {0, 11, 15, 5, 1, 0, 0, 16, 3, 0, 0, 4, 2, 10, 14, 0,},
		 {16, 0, 0, 12, 13, 9, 4, 0, 0, 6, 2, 15, 1, 0, 0, 5,},
		 {1, 0, 0, 2, 0, 0, 0, 11, 5, 0, 0, 0, 16, 0, 0, 7,},
		 {0, 10, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 6, 0,},
		};
		
		return numerosTablero;
	}
}

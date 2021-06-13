package com.SkySoft.Skydoku.Model;

public class Normal implements Dificultad{
	
	private final int tamanio = 3;
	
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

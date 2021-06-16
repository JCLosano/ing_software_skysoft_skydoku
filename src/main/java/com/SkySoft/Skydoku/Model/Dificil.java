package com.SkySoft.Skydoku.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dificil implements Dificultad{
	
	private final int tamanio = 4;
	private int [][] numerosTablero;
	
	public Dificil() {
	}
	
	public int tamanioTablero() {
		return tamanio;
	}
	
	public int [][] llenarTablero() {
		numerosTablero = new int[tamanio*tamanio][tamanio*tamanio]; 
		
		int numero;
		
		File f = new File("./tableros/dificil_1.txt");
		
		try  (Scanner entrada = new Scanner(f)) {
    		while (entrada.hasNextInt()) {
                for(int i = 0; i < tamanio*tamanio; i++) {
                	for(int j = 0; j < tamanio*tamanio; j++) {
                		numero = entrada.nextInt();
                		numerosTablero[i][j] = numero;
                	}
                }
    		}
        }
		
		catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo indicado.");
		}
		
		return numerosTablero;
	}
	
	public int getNumero(int x, int y) {
		return numerosTablero[y][x];
	}
	
	public int setNumber(int x, int y, int number) {
		return numerosTablero[y][x] = number;
	}

	@Override
	public int getCantidadCeros() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumerosResueltos(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}
}

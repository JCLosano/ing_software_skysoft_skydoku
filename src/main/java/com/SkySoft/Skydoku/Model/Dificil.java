package com.SkySoft.Skydoku.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dificil implements Dificultad{
	
	private final int tamanio = 4;
	private int [][] numerosTablero;
	private int[][] numerosTableroResuelto;
	private int cantidadCeros;
	
	public Dificil() {
		cantidadCeros = 0;
		llenarTableroResuelto();
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
			System.out.println("No se encontrĂ³ el archivo indicado.");
		}
		
		return numerosTablero;
	}
	
	private void llenarTableroResuelto() {
		numerosTableroResuelto = new int[tamanio*tamanio][tamanio*tamanio]; 
		
		int numero;
		
		File f = new File("./tableros/dificil_1_resuelto.txt");
		
		try  (Scanner entrada = new Scanner(f)) {
    		while (entrada.hasNextInt()) {
                for(int i = 0; i < tamanio*tamanio; i++) {
                	for(int j = 0; j < tamanio*tamanio; j++) {
                		numero = entrada.nextInt();
                		numerosTableroResuelto[i][j] = numero;
                		if(numero == 0) {
                			cantidadCeros++;
                		}
                	}
                }
    		}
        }
		
		catch (FileNotFoundException e) {
			System.out.println("No se encontrĂ³ el archivo indicado.");
		}
		
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
		return cantidadCeros;
	}

	@Override
	public int getNumerosResueltos(int x, int y) {
		// TODO Auto-generated method stub
		return numerosTableroResuelto[y][x];
	}
}

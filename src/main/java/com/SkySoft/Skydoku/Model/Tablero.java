package com.SkySoft.Skydoku.Model;

public class Tablero {

    private static Tablero tablero;
    Dificultad dificultad;
    private int tamanio;
    
    private int numerosTablero[][];
    
    private Tablero () {
    }

    public static Tablero getInstance() {
        if (tablero == null) {
            return tablero = new Tablero();
        }
        else {
            return tablero;
        }
    }


    public void crearTablero(String dificultad) {
        switch (dificultad) {
            case "Facil":
                this.dificultad = new Facil();
                numerosTablero = this.dificultad.llenarTablero();
                break;
            case "Normal":
                this.dificultad = new Normal();
                numerosTablero = this.dificultad.llenarTablero();
                break;
            case "Dificil":
                this.dificultad = new Dificil();
                numerosTablero = this.dificultad.llenarTablero();
                break;
            default:
            	break;
        }
        tamanio = this.dificultad.tamanioTablero();
    }
    
    public int getTamanio() {
    	return tamanio;
    }
    
    public int[][] getNumerosTablero(){
    	return numerosTablero;
    }
    
    public Dificultad getDificultad() {
    	return dificultad;
    }
    
}

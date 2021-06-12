package com.SkySoft.Skydoku.Model;

public class Tablero {
    Dificultad dificultad;
    private int tamanio;
    
    public Tablero () {


    }

    public void crearTablero(String dificultad) {
        switch (dificultad) {
            case "Facil":
                this.dificultad = new Facil();
                break;
            case "Normal":
                this.dificultad = new Normal();
                break;
            case "Dificil":
                this.dificultad = new Dificil();
                break;
            default:
            	break;
        }
        tamanio = this.dificultad.tamanioTablero();
    }
    
    public int getTamanio() {
    	return tamanio;
    }
    
}

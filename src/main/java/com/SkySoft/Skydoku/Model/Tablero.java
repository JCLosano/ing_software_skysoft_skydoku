package com.SkySoft.Skydoku.Model;

public class Tablero {
    Dificultad dificultad;

    public Tablero () {


    }

    public void crearTablero(int x) {
        switch (x) {
            case 0:
                dificultad = new Facil();
                break;
            case 1:
                dificultad = new Normal();
                break;
            case 2:
                dificultad = new Dificil();
                break;
        }
    }
}

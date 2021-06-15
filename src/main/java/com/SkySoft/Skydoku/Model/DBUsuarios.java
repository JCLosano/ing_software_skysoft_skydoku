package com.SkySoft.Skydoku.Model;


import java.util.ArrayList;
import java.util.List;

public class DBUsuarios {

    String nombreActual;
    ArrayList<String> nombres;
    int posicionUltimoNombreIngresado;

    public DBUsuarios() {
        nombres = new ArrayList<>();
        posicionUltimoNombreIngresado = 0;
    }

    public void guardarNombre(String nombre) {
        nombreActual = nombre;
        guardarNombreEnArray();
    }

    private void guardarNombreEnArray() {
        if (posicionUltimoNombreIngresado == 10) {
            nombres.remove(posicionUltimoNombreIngresado);
            posicionUltimoNombreIngresado = 0;
        }

        nombres.add(posicionUltimoNombreIngresado, nombreActual);
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i));
        }
        System.out.print("\n");
        posicionUltimoNombreIngresado++;
    }
}

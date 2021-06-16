package com.SkySoft.Skydoku.Model;


import java.util.ArrayList;
import java.util.List;

public class DBPuntuaciones {

    String nombreActual;
    ArrayList<ArrayList<String>> puntuaciones;
    ArrayList<String> campos;
    int posicionUltimoNombreIngresado;

    public DBPuntuaciones() {
        //nombres = new ArrayList<>();
        posicionUltimoNombreIngresado = 0;
        puntuaciones = new ArrayList<ArrayList<String>>();
    }

    public void guardarNombre(String nombre) {
        nombreActual = nombre;
        guardarNombreEnArray();
    }

    private void guardarNombreEnArray() {
        campos = new ArrayList<String>();
        campos.add(nombreActual);
        campos.add("1000");
        campos.add("02:00");
        campos.add("100000");
        campos.add("Facil");
        puntuaciones.add(campos);

        for (int i = 0; i < puntuaciones.size(); i++) {
            System.out.println(puntuaciones.get(i).toString());
            System.out.println(puntuaciones.get(i).get(0));
        }
        System.out.println();

    }
}

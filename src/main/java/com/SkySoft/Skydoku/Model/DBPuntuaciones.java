package com.SkySoft.Skydoku.Model;


import com.SkySoft.Skydoku.view.Observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.Timer;

public class DBPuntuaciones implements Subject{

    private String nombreActual;
    private Vector<Vector<String>> puntuaciones;
    private Vector<String> campos;
    private List<Observer> observers;
	private Timer timer;
	private int segundos;
	private int puntuacion;
	private ActionListener tarea;
	private Tablero tablero;

	private static DBPuntuaciones dbPuntuaciones;

    private DBPuntuaciones() {
        //nombres = new ArrayList<>();
    	this.tablero = Tablero.getInstance();
        puntuaciones = new Vector<Vector<String>>();
        observers = new ArrayList<Observer>();
        
        segundos = 0;
		tarea = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				segundos++;
				notifyObservers();
			}
		};
		
		timer = new Timer(1000 ,tarea);
		timer.setRepeats(true);
		
    }

    public static DBPuntuaciones getInstance() {
    	if (dbPuntuaciones == null) {
    		return dbPuntuaciones = new DBPuntuaciones();
		}
    	else {
    		return dbPuntuaciones;
		}

	}

    public void guardarNombre(String nombre) {
        nombreActual = nombre;
        guardarNombreEnArray();
    }

    private void guardarNombreEnArray() {
        campos = new Vector<String>();
        campos.add(nombreActual);
        campos.add("1000");
        campos.add("02:00");
        campos.add("100000");
        campos.add("Facil");
        puntuaciones.add(campos);

        /*for (int i = 0; i < puntuaciones.size(); i++) {
            System.out.println(puntuaciones.get(i).toString());
            System.out.println(puntuaciones.get(i).get(0));
        }
        System.out.println();*/

    }
    
	public Timer getTimer() {
		return timer;
	}
	
	public String getNombreActual() {
		return nombreActual;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public int getTiempo() {
		return segundos;
	}
	
	public int getPuntuacionTotal() {
		return ((puntuacion/segundos)*100);
	}
	
	public String getDificultad() {
		return tablero.getDificultad().getClass().getSimpleName();
	}

	
	public void descontarPuntos() {
		puntuacion -= 10;
	}
	
	public void setPuntuacion(int puntos) {
		puntuacion = puntos;
		notifyObservers();
	}

    @Override
    public void registerObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) {
    	observers.remove(o);
    	segundos = 0;
    }

    @Override
    public void notifyObservers() {
    	for (Observer observer : observers) {
            observer.update(segundos, puntuacion);
        }
    }
}

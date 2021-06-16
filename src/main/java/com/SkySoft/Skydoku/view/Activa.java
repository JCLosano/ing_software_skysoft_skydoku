package com.SkySoft.Skydoku.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.SkySoft.Skydoku.Model.Tablero;
import com.SkySoft.Skydoku.controller.ControladorCentral;


public class Activa extends JPanel implements Observer{

	private JTextField text;
	public JPanel panelActiva = new JPanel();
	public JPanel pnlAlign = new JPanel();
	private JPanel[][] casillaGrande;
	private Casilla[][] casillaChica;
	private int tamanioTablero;
	private Tablero tablero;
	private boolean estado_grilla;
	private int[][] numerosTablero;

	JButton boton_menuPrincipal, boton_puntuaciones;

	public Activa(ControladorCentral controladorCentral, Tablero tablero) {
		TitledBorder border;
		border = crearBorder();

		this.tablero = tablero;

		estado_grilla = false;

		pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.X_AXIS));

		JPanel panelTiempoPuntuaciones = new JPanel();

		panelTiempoPuntuaciones.setBorder(BorderFactory.createTitledBorder("Tiempo y Puntuaciones"));

		JTextArea tiempo = new JTextArea();
		tiempo.setWrapStyleWord(false);
		tiempo.setRows(1);
		tiempo.setText(" ");
		tiempo.setEditable(false);
		panelTiempoPuntuaciones.add(tiempo);

		JTextArea puntuaciones = new JTextArea();
		puntuaciones.setWrapStyleWord(false);
		puntuaciones.setRows(1);
		puntuaciones.setText(" ");
		puntuaciones.setEditable(false);
		panelTiempoPuntuaciones.add(puntuaciones);

		JLabel label = new JLabel();
		label.setText("Inserte el número a ingresar en el tablero");

		panelTiempoPuntuaciones.add(label);

		panelTiempoPuntuaciones.add(Box.createVerticalStrut(5));

		text = new JTextField();

		//JPanel panelBotones = new JPanel();
		panelTiempoPuntuaciones.setLayout(new BoxLayout(panelTiempoPuntuaciones, BoxLayout.Y_AXIS));

		panelTiempoPuntuaciones.add(Box.createVerticalStrut(10));

		panelTiempoPuntuaciones.add(text);

		panelTiempoPuntuaciones.add(Box.createVerticalStrut(10));

		boton_puntuaciones = agregarBoton("Puntuaciones", panelTiempoPuntuaciones);
		boton_puntuaciones.addActionListener(controladorCentral);

		boton_menuPrincipal = agregarBoton("Menu Principal", panelTiempoPuntuaciones);
		boton_menuPrincipal.addActionListener(controladorCentral);


		pnlAlign.add(panelTiempoPuntuaciones);
		//pnlAlign.add(panelBotones);
		pnlAlign.add(panelActiva);

		//tamanioTablero = this.tablero.getTamanio();

		//crearGrilla(tamanioTablero, tamanioTablero);

		//pnlAlign.add(panelActiva);

	}

	private TitledBorder crearBorder() {
		return BorderFactory.createTitledBorder("Activa");
	}

	public void crearGrilla(int filas, int columnas) {
		GridLayout grilla = new GridLayout(filas, columnas);

		casillaGrande = new JPanel[filas][columnas];

		for (int y = 0; y < columnas; y++) {
			for (int x = 0; x < filas; x++) {
				casillaGrande[y][x] = new JPanel(grilla);
				casillaGrande[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
				//casillaGrande[y][x].setPreferredSize(new Dimension(filas*63, columnas*63));
				panelActiva.add(casillaGrande[y][x]);
			}
		}

		casillaChica = new Casilla[filas * filas][columnas * columnas];
		for (int y = 0; y < columnas * columnas; y++) {
			for (int x = 0; x < filas * filas; x++) {
				casillaChica[y][x] = new Casilla(x, y);
				casillaGrande[y / columnas][x / filas].add(casillaChica[y][x]);
			}
		}
		estado_grilla = true;
		tamanioTablero = filas * columnas;
	}

	private JButton agregarBoton(String nombre_boton, JPanel panel) {
		JButton boton = new JButton(nombre_boton);
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(boton);
		return boton;
	}

	public JButton getBotonMenuPrincipal() {
		return boton_menuPrincipal;
	}

	public void cargarTablero() {

		numerosTablero = tablero.getNumerosTablero();

		for (int y = 0; y < tamanioTablero; y++) {
			for (int x = 0; x < tamanioTablero; x++) {
				if (numerosTablero[x][y] > 0) {
					casillaChica[x][y].setBackground(Color.WHITE);
					casillaChica[x][y].setText(numerosTablero[x][y] + "");
				} else {
					casillaChica[x][y].setText("");
				}
			}
		}
	}

	public int getTamanioTablero() {
		return tamanioTablero;
	}

	public boolean getEstadoGrilla() {
		return estado_grilla;
	}

	public JPanel[][] getCasillaGrande() {
		return casillaGrande;
	}

	public void setEstadoGrilla(boolean estado) {
		estado_grilla = estado;
	}

	public JTextField getTextField() {
		return text;
	}

	@Override
	public void update() {
		//TODO
	}
}



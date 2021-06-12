package com.SkySoft.Skydoku.view;

import com.SkySoft.Skydoku.controller.ControladorCentral;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Ayuda{

    public JPanel panelAyuda = new JPanel();

    public Ayuda(ControladorCentral controladorCentral) {
        
        TitledBorder border;
        border = crearBorder();
        
        panelAyuda.setBorder(border);
        panelAyuda.setLayout(new BoxLayout(panelAyuda, BoxLayout.Y_AXIS));
        panelAyuda.setPreferredSize(new Dimension(640, 480));
        
        JTextArea txtSudoku = textoAyuda();
		panelAyuda.add(txtSudoku);
        
        JButton boton_atras = botonAtras();
        boton_atras.addActionListener(controladorCentral);
        boton_atras.setActionCommand("AtrasAyuda");
        
        
    }
    
    public TitledBorder crearBorder() {
        return BorderFactory.createTitledBorder("Ayuda");
    }
    
    public JTextArea textoAyuda() {
    	JTextArea texto = new JTextArea();
    	texto.setWrapStyleWord(false);
		texto.setRows(10);
		texto.setText("Sudoku (\u6570\u72EC, s\u016Bdoku, digit-single) \r\nis a logic-based,[2][3] combinatorial[4] number-placement puzzle.\r\nIn classic sudoku, the objective is to fill a 9\u00D79 grid with \r\ndigits so that each column, each row, and each of the \r\nnine 3\u00D73 subgrids that compose the grid (also called \r\n\"boxes\", \"blocks\", or \"regions\") contains all of the digits from 1 to 9. \r\nThe puzzle setter provides a partially completed grid, \r\nwhich for a well-posed puzzle has a si");
		texto.setEditable(false);
    	return texto;
    }
    
    public JButton botonAtras() {
    	panelAyuda.add(Box.createVerticalStrut(10));
        return agregarBoton("Atras", panelAyuda);
    }
    
    private JButton agregarBoton (String nombre_boton, JPanel panel) {
        JButton boton = new JButton(nombre_boton);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(boton);
        return boton;
    }
}

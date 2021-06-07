package com.SkySoft.Skydoku.controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.SkySoft.Skydoku.view.*;

public class ControladorCentral implements ActionListener {
    public ControladorCentral() {

    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Ayuda": new Ayuda();
        }
    }
}

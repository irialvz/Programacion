/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD8.ejemplos;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author Alumno
 */
public class prueba3 {
    
    private static JLabel label = new JLabel("--");
    private static JButton btnlimpia = new JButton("Limpia");
    private static JButton btnescribe = new JButton("Escribe");
    
    public static void acciones(ActionEvent e) {
        Object o = e.getSource();
        if (o == btnlimpia) {
            label.setText("");
        }
        if (o == btnescribe) {
            label.setText("Hola Mundo");
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Controlador evantos");
        btnlimpia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acciones(e);
            }
        });
        btnescribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acciones(e);
            }
        });
        
        frame.add(label);
        frame.add(btnlimpia);
        frame.add(btnescribe);
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        frame.setLayout(new GridLayout(0, 1)); // filas y columnas
        frame.pack();
        frame.setVisible(true);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD8.ejemplos;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Alumno
 */
public class prueba2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana Hola Mundo");
        JPanel panel = new JPanel (new BorderLayout());
        //JPanel panel = new JPanel (new GridLayout());
        //JPanel panel = new JPanel (new FrowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //acaba el programa cuando se cierra la venta
        JLabel label1 = new JLabel("etiqueta 1");
        JLabel label2 = new JLabel("etiqueta 2");
        JLabel label3 = new JLabel("etiqueta 3");
        panel.add("South",label1);
        panel.add("North",label2);
        panel.add("East",label3);
        frame.add(panel);
        frame.pack(); //Hace que la ventana se redimensione al texto introducido
        frame.setLocationRelativeTo(null); //centra la ventana en la pantalla
        frame.setVisible(true); //Hace visible la ventana
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD8.ejemplos;
import javax.swing.*;
/**
 *
 * @author Alumno
 */
public class prueba {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana Hola Mundo");
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //acaba el programa cuando se cierra la venta
        JLabel label = new JLabel("Hola mundo");
        frame.add(label);
        frame.pack(); //Hace que la ventana se redimensione al texto introducido
        frame.setLocationRelativeTo(null); //centra la ventana en la pantalla
        frame.setVisible(true); //Hace visible la ventana
    }
    
}

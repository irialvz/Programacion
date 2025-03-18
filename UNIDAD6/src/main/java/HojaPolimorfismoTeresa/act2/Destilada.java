/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act2;
import java.util.Random;
/**
 *
 * @author iriia
 */
public class Destilada extends Alcoholica {

    private static final String[] NOMBRES = {
        "anis", 
        "pacharan", 
        "ginebra", 
        "cognac", 
        "rona",
        "vodka",
        "whisky",
        "tequila"
    };
    
    private static String generarNombres(){
        int i = new Random().nextInt(NOMBRES.length);
        return NOMBRES[i];
    }
    private static double generarGraduacion(){
        return new Random().nextDouble() * ((45.0 - 15.0) + 15.0);
    }

    public Destilada() {
        super(generarNombres(), generarGraduacion());
    }

    @Override
    public double calcularPrecio() {
        return 12 + (gradoAlc / 10);
    }

    @Override
    public String toString() {
        return "Destilada{" + super.toString()
                + "graduacion=" + String.format("%.2f", gradoAlc)
                + '}';
    }

}

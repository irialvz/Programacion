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
public class Fermentada extends Alcoholica {
        private static final String[] NOMBRES = {
            "sidra",
            "cerveza",
            "vino",
            "sake",
            "hidromiel"
        };

        private static String generarNombres() {
            int i = new Random().nextInt(NOMBRES.length);
            return NOMBRES[i];
        }

        private static double generarGraduacion() {
            return new Random().nextDouble() * ((15.0 - 3.5) + 3.5);
        }

        public Fermentada() {
            super(generarNombres(), generarGraduacion());
        }

        @Override
        public double calcularPrecio() {
            return 5 + (gradoAlc / 10);

        }

        @Override
        public String toString() {
            return "Fermentada{" + super.toString()
                    + "graduacion=" + String.format("%.2f", gradoAlc) + '}';
        }

    }

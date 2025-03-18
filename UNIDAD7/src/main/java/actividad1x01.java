/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iriia
 */
public class actividad1x01 {

    public static String solicitarCadena(String mensaje) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String frase = "";
        System.out.println(mensaje);
        frase = teclado.readLine();

        return frase;
    }

    public static short solicitarEnteroCorto(String mensaje, int numMaxErrores) throws IOException {
        int numErrores = 0;
        boolean error = true;
        while (error && numErrores < numMaxErrores) {
            try {
                String entrada = solicitarCadena(mensaje);
                short num = Short.parseShort(entrada);
                error = false;
                return num;
            } catch (NumberFormatException nfe){
                numErrores++;
                System.out.println("“El dato introducido no tiene formato de número entero corto. "+ nfe.getMessage() + " " + (numMaxErrores - numErrores) + " intentos restantes");
                error = true;
            }

        }
        System.out.println("Se ha alcanzado el max de intentos");
        return 0;
    }

    public static void main(String[] args) {
        try {
            final int MAXERRORES = 3;
            short dividendo,divisor;
            dividendo = solicitarEnteroCorto("Dividendo? ",MAXERRORES);
            divisor = solicitarEnteroCorto("Divisor? ",MAXERRORES);
            
            int resto = dividendo % divisor;
            int cociente = dividendo / divisor;
            
            if (resto == 0){
                System.out.println(dividendo + " es divisible entre " + divisor);
                System.out.print("Cociente: " + cociente + " ");
                System.out.print("Resto: " + resto);
            } else {
                System.out.println(dividendo + " no es divisible entre " + divisor);
                System.out.print("Cociente: " + cociente + " ");
                System.out.print("Resto: " + resto);
                
            }
            
        } catch (IOException ex) {
            System.out.println("Se ha producido un error de entrada/salida. " + ex.getMessage());
        } catch (ArithmeticException ae){
            System.out.println("Se ha producido un error aritmetico " + ae.getMessage());
        }
        
    }
}

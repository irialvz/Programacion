/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.ejercicios03.ejercicioCiudadano;

import java.util.Random;

/**
 *
 * @author iriia
 */
public class Sociedad {
    public static int numSolteros (Ciudadano[] sociedad){
        int contadorSolteros = 0;
        for (int i = 0; i < sociedad.length;i++){
            if(!sociedad[i].isCasado()){
                contadorSolteros++;
            }
        }
        return contadorSolteros;
    }
    
    public static Ciudadano menorDNI (Ciudadano[] colectivo){
        Ciudadano menor = colectivo[0];
        for (int i= 1; i < colectivo.length;i++){
            if (colectivo[i].getDni() < menor.getDni()){
                menor = colectivo[i];
            }
        }
        return menor;
    }
    public static void main(String[] args) {
        Ciudadano[] ciudadanos = new Ciudadano[10];
        Random aleatorio = new Random();
        for (int i=0; i < ciudadanos.length;i++){
            String nombre = "Nombre" + (i+1);
            String apellido = "Apellido" + (i+1);
            int dni = aleatorio.nextInt(90000000) + 10000000;
            char letra = (char) (aleatorio.nextInt(26) + 'A');
            boolean casado = aleatorio.nextBoolean();
            ciudadanos[i] = new Ciudadano(nombre,apellido,dni,letra,casado);
        }
        System.out.println("LISTADO DE CIUDADANOS");
        for (int i = 0;i < ciudadanos.length;i++){
            Ciudadano c = ciudadanos[i];
            System.out.println("[Nombre: " + c.getNombre() + " " + c.getApellidos() 
                    + " DNI " + c.getDni() + c.getLetra() + " Casado " + 
                    (c.isCasado() ? "Si" : "No"));
            
        }
        int solteros = numSolteros(ciudadanos);
        System.out.println("numero de ciudadanos solteros: " + solteros);
        
        Ciudadano menorDniCiudadano = menorDNI(ciudadanos);
        System.out.println("El ciudadano con el menor dni es:");
        System.out.println("[Nombre " + menorDniCiudadano.getNombre() + " " + menorDniCiudadano.getApellidos() +
                " DNI: " + menorDniCiudadano.getDni() + menorDniCiudadano.getLetra() + ", Casado " + (menorDniCiudadano.isCasado() ? "Si" : "No"));
    }
}
 
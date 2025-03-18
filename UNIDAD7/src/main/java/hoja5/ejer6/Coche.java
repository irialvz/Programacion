/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer6;

import ejercicios.UNIDAD7.hoja5.ejer6.excepciones.error_km;
import ejercicios.UNIDAD7.hoja5.ejer6.excepciones.error_matricula;
import ejercicios.UNIDAD7.hoja5.ejer6.excepciones.error_modelo;

/**
 *
 * @author Alumno
 */
public class Coche {

    private String modelo;
    private String matricula;
    private long km;

    public Coche(String modelo, String matricula, long km) throws error_modelo, error_matricula, error_km {
        if (modelo.length() < 5 || modelo.length() > 30) {
            throw new error_modelo(error_modelo.ERROR_MODELO);
        }
        if (!validarMatricula(matricula)) {
            throw new error_matricula(error_matricula.ERROR_MATRICULA);
        }
        if (km < 0) {
            throw new error_km(error_km.ERROR_KM);
        }
        
        this.modelo = modelo;
        this.matricula = matricula;
        this.km = km;
    }

    public static boolean validarMatricula(String matricula) {
        if (matricula.length() < 7) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            char caracter = matricula.charAt(i);
            if (caracter < '0' || caracter > '9') {
                return false;
            }
        }
        for (int i = 4; i < 7; i++) {
            char caracter = matricula.charAt(i);
            if (caracter < 'A' || (caracter > 'Z' && caracter < 'a') || caracter > 'z') {
                return false;
            }
        }
        return true;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public long getKm() {
        return km;
    }

    public void setKm(long km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Coche{" + "modelo=" + modelo + ", matricula=" + matricula + ", km=" + km + '}';
    }
    
}

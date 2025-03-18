/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer9;

import ejercicios.UNIDAD7.hoja5.ejer9.excepciones.fechaExcepcion;

/**
 *
 * @author Alumno
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anyo;

    public Fecha(int dia, int mes, int anyo) throws fechaExcepcion {
        if (dia < 0 || dia > 31) {
            throw new fechaExcepcion("El dia debe estar en un rango de 1 a 31");
        }
        if (mes < 0 || mes > 31) {
            throw new fechaExcepcion("El mes debe estar en un rango de 1 a 31");
        }
        if (anyo < 1980 || anyo > 2025) {
            throw new fechaExcepcion("El año debe estar en un rango de 1980 a 2025");
        }
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    private String getMesLetras(int mes) {
        switch (mes) {
            case 1:
                return "enero";
            case 2:
                return "febrero";
            case 3:
                return "marzo";
            case 4:
                return "abril";
            case 5:
                return "mayo";
            case 6:
                return "junio";
            case 7:
                return "julio";
            case 8:
                return "agosto";
            case 9:
                return "septiembre";
            case 10:
                return "octubre";
            case 11:
                return "noviembre";
            case 12:
                return "diciembre";
            default:
                return null;
        }
    }

    private boolean esBisiesto(int año) {
        if (año % 4 == 0) {
            return true;
        }
        return false;
    }

    private int getDiaMes(int mes, int anyo) {
        int dias = 0;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dias = 30;
                break;
            case 2:
                if (esBisiesto(anyo)) {
                    dias = 29;
                } else {
                    dias = 28;
                }
                break;
        }
        return dias;
    }

    public boolean esCorrecta(int dia, int mes, int año) {
        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && año >= 1950) {
            return true;
        }
        return false;
    }

    public String toString() {
        return dia + " de " + getMesLetras(mes) + " de " + anyo;
    }
}

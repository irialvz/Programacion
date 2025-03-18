/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act1;

/**
 *
 * @author iriia
 */
public class Oficinista extends Empleado {

    private String titulacion;
    private String turno;

    public Oficinista(String nif, String nombreComp, String fechaNac, String direccion, String numTlf, String correoElec, String titulacion, String turno) {
        super(nif, nombreComp, fechaNac, direccion, numTlf, correoElec);
        this.titulacion = titulacion;
        this.turno = turno;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString() + " titulacion= " + titulacion + " ,Turno=" + turno;
    }

}

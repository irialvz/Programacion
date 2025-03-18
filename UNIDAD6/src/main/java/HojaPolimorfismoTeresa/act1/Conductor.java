/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act1;

/**
 *
 * @author iriia
 */
public class Conductor extends Empleado {

    private int carnets = 0;
    private String fechaObtencionCAP;

    public Conductor(String nif, String nombreComp, String fechaNac, String direccion, String numTlf, String correoElec, int carnets, String fechaObtencionCAP) {
        super(nif, nombreComp, fechaNac, direccion, numTlf, correoElec);
        if (carnets < 15) {
            this.carnets = carnets;
        }
        this.fechaObtencionCAP = fechaObtencionCAP;
    }

    public int getCarnets() {
        return carnets;
    }

    public String getFechaObtencionCAP() {
        return fechaObtencionCAP;
    }

    public void setCarnets(int carnets) {
        this.carnets = carnets;
    }

    public void setFechaObtencionCAP(String fechaObtencionCAP) {
        this.fechaObtencionCAP = fechaObtencionCAP;
    }

    @Override
    public String toString() {
        return super.toString() + " Carnets= " + carnets + " ,fecha obtencion CAP=" + fechaObtencionCAP;
    }

}

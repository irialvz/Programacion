/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act1;

/**
 *
 * @author iriia
 */
public class Limpiador extends Empleado {

    private boolean LimpiaOficina;
    private boolean LimpiaAutobuses;
    private boolean LimpiaGarajes;

    public Limpiador(String nif, String nombreComp, String fechaNac, String direccion, String numTlf, String correoElec, boolean LimpiaOficinas,boolean LimpiaAutobuses,boolean LimpiaGarajes) {
        super(nif, nombreComp, fechaNac, direccion, numTlf, correoElec);
        this.LimpiaGarajes = LimpiaGarajes;
        this.LimpiaAutobuses = LimpiaAutobuses;
        this.LimpiaGarajes = false;
    }

    public boolean isLimpiaOficina() {
        return LimpiaOficina;
    }

    public boolean isLimpiaAutobuses() {
        return LimpiaAutobuses;
    }

    public boolean isLimpiaGarajes() {
        return LimpiaGarajes;
    }

    public void setLimpiaGarajes(boolean LimpiaGarajes) {
        this.LimpiaGarajes = LimpiaGarajes;
    }


    public String toString() {
        return super.toString() + " Limpia Oficinas= " + LimpiaOficina + " ,Limpia Autobuses=" + LimpiaAutobuses + ",Limpia Garajes" + LimpiaGarajes;
    }
}

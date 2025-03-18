/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act1;

/**
 *
 * @author iriia
 */
public class Empleado {

    private String nif;
    private String nombreComp;
    private String fechaNac;
    private String direccion;
    private String numTlf;
    private String correoElec;

    public Empleado(String nif, String nombreComp, String fechaNac,
            String direccion, String numTlf, String correoElec) {
        this.nif = nif;
        this.nombreComp = nombreComp;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        
        if (numTlf.length() == 9) {
            this.numTlf = numTlf;
        } 
        this.correoElec = correoElec;
    }

    public String getNif() {
        return nif;
    }

    public String getNombreComp() {
        return nombreComp;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumTlf() {
        return numTlf;
    }

    public String getCorreoElec() {
        return correoElec;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumTlf(String numTlf) {
        this.numTlf = numTlf;
    }
    
    @Override
    public String toString(){
        return "NIF= " + nif + " ,Nombre=" + nombreComp + ",fecha nacimiento= " + fechaNac + ",Direccion= " + direccion + ",Telefono= " + numTlf + ",Correo= " + correoElec;
    }

}

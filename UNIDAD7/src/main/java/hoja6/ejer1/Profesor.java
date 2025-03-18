/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer1;

import ejercicios.UNIDAD7.hoja6.ejer1.excepciones.caracteresExcepcion;

/**
 *
 * @author Alumno
 */
public class Profesor extends Persona{
    private int numeroDocente;
    private String departamento;
    private float sueldo;
    
    public Profesor(String nombre, String apellido, int edad, String ciudad,String departamento,int numeroDocente,float sueldo)throws caracteresExcepcion {
        super(nombre, apellido, edad, ciudad);
        this.numeroDocente = 0;
        if (departamento.isBlank()){
            throw new caracteresExcepcion("El departamento debe tener mas de 1 caracter");
        }
        if (sueldo <= 0){
            throw new caracteresExcepcion("El salario no puede ser igual o menor a 0");
        }
        this.sueldo = sueldo;       
        this.departamento = departamento;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    

    public int getNumeroDocente() {
        return numeroDocente;
    }

    public void setNumeroDocente(int numeroDocente) {
        this.numeroDocente = numeroDocente + 1;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Profesor{" + super.toString() + "numeroDocente=" + numeroDocente + ", departamento=" + departamento + '}';
    }

    @Override
    public void prosperar(float cantidad) {
        this.sueldo += cantidad;
        System.out.println(nombre + " ahora tiene un salario de " + sueldo + " ya que se han añadido " + cantidad + " euros a su sueldo");
    }
    
    
    
    
    
}

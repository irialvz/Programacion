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
public class Alumno extends Persona{
    private int numeroAlumno;
    private String curso;
    private float nota;
    
    public Alumno(String nombre, String apellido, int edad, String ciudad,String curso,int numeroAlumno,float nota) throws caracteresExcepcion {
        super(nombre, apellido, edad,ciudad);
        this.numeroAlumno = 0;
        if (curso.isBlank()){
            throw new caracteresExcepcion("El curso debe tener mas de 1 caracter");
        }
        if (nota <= 0){
            throw new caracteresExcepcion("El valor de la nota no puede ser igual o menos a cero");
        }
        this.nota = nota;
        this.curso = curso;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    
    public int getNumeroAlumno() {
        return numeroAlumno;
    }

    public void setNumeroAlumno(int numeroAlumno) {
        this.numeroAlumno = numeroAlumno + 1;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" + super.toString() + "numeroAlumno=" + numeroAlumno + ", curso=" + curso + ",nota= " + nota + '}';
    }

    @Override
    public void prosperar(float cantidad) {
        this.nota += cantidad;
        if (this.nota > 10){
            this.nota = 10;
        }
        System.out.println(nombre + " ahora tiene una calificacion de " + nota + " ya que se ha sumado " + cantidad + " puntos a la nota");
    }
        
    
    
}

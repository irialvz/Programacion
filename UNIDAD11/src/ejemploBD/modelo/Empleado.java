package ejemploBD.modelo;

import java.util.List;

public class Empleado {
	
	private int codigo;
	private String nombre;
	private String fechaAlta;
	private double salario;
	// Cuidado con el traslado de claves en java - traslado el objeto entero
	private Departamento departamento;
	
	/**
	 * 
	 * @param codigo
	 * @param nombre
	 * @param fechaAlta
	 * @param salario
	 * @param departamento
	 */
	public Empleado(int codigo, String nombre, String fechaAlta, double salario, Departamento departamento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.departamento = departamento;
	}
	
	//CONSULTAR EMPLEADO POR CODIGO
	//BORRAR EMPLEADO

		
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + ", salario=" + salario
				+ ", departamento=" + departamento + "]";
	}
		
}

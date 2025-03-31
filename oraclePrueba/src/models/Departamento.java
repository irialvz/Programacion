package models;

public class Departamento {

	private int codigo;
	private String nombre;
	private String ubicacion;

	public Departamento(int codigo, String nombre, String ubicacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	public Departamento(int codigo) {
		super();
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Departamento [Código = " + this.codigo + ", Nombre = " + this.nombre + ", Ubicación = " + this.ubicacion
				+ "]";
	}

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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}

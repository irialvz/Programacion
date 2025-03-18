package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio1x03;

public class Libro {
	private String titulo;
	private int numEjemplares;
	private double precio;
	
	public Libro (String titulo,int numEjemplares,double precio) {
		this.titulo = titulo;
		this.numEjemplares = numEjemplares;
		this.precio = precio;
	}
	
	public String toString() {
		return "[ Estado: precio:" + precio + "]";
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getNumEjemplares() {
		return numEjemplares;
	}

	public double getPrecio() {
		return precio;
	}
	
}

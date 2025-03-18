package ejercicios.UNIDAD6.ejerciciosTeresa.ejercicio1x01;

/**
 *
 * @author iriia
 */

// Clases en mayúscula la primera y atributos en minúscula
public class Videojuego {
    private String nombre;
    private String desarrollador;
    private int año;
    private int maxJugadores;

    /**
     * Constructor con todos los parámetros
     * 
     * @param nombre_
     * @param desarrollador_
     * @param año_
     * @param maxJugadores_
     */
    public Videojuego(String nombre_, String desarrollador_, int año_, int maxJugadores_) {
        nombre = nombre_;
        desarrollador = desarrollador_;
        año = año_;
        maxJugadores = maxJugadores_;
    }

    /**
     * Constructor que inicializa maxJugadores con un valor por defecto de 1
     * 
     * @param nombre_
     * @param desarrollador_
     * @param año_
     */
    public Videojuego(String nombre_, String desarrollador_, int año_) {
        this(nombre_, desarrollador_, año_, 1);
    }

    /**
     * Constructor que inicializa año con un valor por defecto de 2021 y maxJugadores con 1
     * 
     * @param nombre_
     * @param desarrollador_
     */
    public Videojuego(String nombre_, String desarrollador_) {
        this(nombre_, desarrollador_, 2021, 1);
    }

    /**
     * Método para obtener el estado del videojuego
     * 
     * @return Una cadena con los detalles del videojuego
     */
    public String getEstado() {
        return "Videojuego [nombre: " + nombre + ", desarrollador: " + desarrollador + ", año: " + año
                + ", número máximo de jugadores: " + maxJugadores + "]";
    }
}

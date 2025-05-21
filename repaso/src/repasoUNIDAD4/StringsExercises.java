package repasoUNIDAD4;

/*
Clase 3 - Strings, Condicionales y Arrays (17/04/2025)
Vídeo: https://www.twitch.tv/videos/2436086584
*/

public class StringsExercises {

    public static void main(String[] args) {
    	String nombre = "Iria",apellido = " Alvarez";

        // 1. Concatena dos cadenas de texto.
    	System.out.println("La variable nombre es: " + nombre);
    	System.out.println("La variable apellido es " + apellido);
    	String resultado = nombre.concat(apellido) + "       solis";
    	System.out.println("La cadena concatenada es: " + resultado);

        // 2. Muestra la longitud de una cadena de texto.
    	System.out.println("La longitud de la cadena concatenada es de: " + resultado.length() + " caracteres");
        // 3. Muestra el primer y último carácter de un string.
    	System.out.println("El primer caracter es: " + nombre.charAt(0) + " El ultimo caracter es: "+ nombre.charAt(nombre.length()-1));
        // 4. Convierte a mayúsculas y minúsculas un string.
    	System.out.println(nombre.toUpperCase());
    	System.out.println(nombre.toLowerCase());
        // 5. Comprueba si una cadena de texto contiene una palabra concreta.
    	if (nombre.contentEquals("ria")) {
    		System.out.println("exito");
    	}else {
    		System.out.println("nop");
    	}
        // 6. Formatea un string con un entero.
    	
        // 7. Elimina los espacios en blanco al principio y final de un string.

        // 8. Sustituye todos los espacios en blanco de un string por un guión (-).
    	String formateado = resultado.replace(' ', '-');
    	System.out.println(formateado);
        // 9. Comprueba si dos strings son iguales.
    	if(nombre.equals(formateado)) {
    		System.out.println("son iguales");
    	}else {
    		System.out.println("no son iguales");
    	}
        // 10. Comprueba si dos strings tienen la misma longitud.
    	if (nombre.length() == apellido.length()) {
    		System.out.println("tienen la misma longitud");
    	}else {
    		System.out.println("no tienen la misma longitud");
    	}
    }
}

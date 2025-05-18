package interfaz;

public class Validaciones {
	private static boolean validarDni(String documentoIdentidad) throws BDException {
	    if (documentoIdentidad == null || documentoIdentidad.isEmpty()) {
	        throw new BDException("El DNI no puede estar vacío");
	    }

	    if (documentoIdentidad.length() != 9) {
	        throw new BDException("El DNI debe tener exactamente 9 caracteres");
	    }

	    // Validar los primeros 8 caracteres como dígitos
	    for (int i = 0; i < 8; i++) {
	        char caracter = documentoIdentidad.charAt(i);
	        if (!Character.isDigit(caracter)) {
	            throw new BDException("El DNI debe contener 8 dígitos numéricos al principio");
	        }
	    }

	    // Validar la última letra (posición 8)
	    char letra = documentoIdentidad.charAt(8);
	    if (letra < 'A' || letra > 'Z') {
	        throw new BDException("El DNI debe terminar con una letra mayúscula");
	    }

	    return true;
	}
	private static boolean validarNumTelefono(String numero) throws BDException {
	    if (numero == null || numero.isEmpty()) {
	        throw new BDException("El número de teléfono no puede estar vacío");
	    }

	    if (!numero.matches("[6789]\\d{8}")) {
	        throw new BDException("El número de teléfono debe tener 9 dígitos y comenzar por 6, 7, 8 o 9");
	    }

	    return true;
	}
	private static boolean validarEmail(String email) throws BDException {
	    if (email == null || email.trim().isEmpty()) {
	        throw new BDException("El email no puede estar vacío");
	    }

	    if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
	        throw new BDException("El formato del email no es válido");
	    }

	    return true;
	}


}

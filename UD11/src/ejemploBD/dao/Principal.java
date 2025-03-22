package ejemploBD.dao;

import java.util.List;

import ejemploBD.excepciones.BDException;
import ejemploBD.modelo.Departamento;
import ejemploBD.modelo.Empleado;
import entrada.Teclado;

public class Principal {

	public static void escribirMenuOpciones() {
		System.out.println("0) Salir del programa.");
		System.out.println("1) Consultar el departamento por código");
		System.out.println("2) Modificar la ubicación de un departamento");
		System.out.println("3) Borrar un departamento por código");
		System.out.println("4) Consultar todos los departamentos ordenados por nombre");

	}

	public static void main(String[] args) {

		boolean exit = false;

		while (!exit) {
			escribirMenuOpciones();

			int opcion = Teclado.leerEntero("Opción: ");
			try {
				switch (opcion) {

				case 0:
					exit = true;
					System.out.println("Saliendo del programa...");
					break;

				case 1:
					// Consulta los departamentos de la base de datos con la misma ubicación1 y
					// ordenados por nombre de forma ascendente.

					String ubicacion = Teclado.leerCadena("Ubicación? ");
					List<Departamento> departamentos;
					departamentos = AccesoDepartamento.consultarDepartamentos2(ubicacion);

					if (departamentos.size() == 0) {
						System.out.println(
								"No se ha encontrado ningún departamento con esa ubicación en la base de datos.");
					} else {
						for (Departamento departamento : departamentos) {
							System.out.println(departamento.toString());
						}
						System.out.println(
								"Se han consultado " + departamentos.size() + " departamentos de la base de datos.");
					}
					break;

					
					//Modificar la ubicación de un departamento
				case 2:

					float salario = (float) Teclado.leerReal("Salario? ");
					List<Empleado> empleados;
					empleados = AccesoEmpleado.consultarEmpleados(salario);

					if (empleados.size() == 0) {
						System.out.println(
								"No se ha encontrado ningún empleado con esa ubicación en la base de datos.");
					} else {
						for (Empleado empleado : empleados) {
							System.out.println(empleado.toString());
						}
						System.out.println(
								"Se han consultado " + empleados.size() + " empleado de la base de datos.");
					}
					break;
					//Borrar un departamento por código
				case 3:
					break;
					//Consultar todos los departamentos ordenados por nombre
				case 4:
					break;
				}
			} catch (BDException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
package dao;

import java.util.ArrayList;
import java.util.List;

import entrada.Teclado;
import exceptions.BDException;
import models.Departamento;

public class Principal {

	public static void escribirMenuOpciones() {
		System.out.println("0) Salir del programa.");
		System.out.println("1) Consultar el departamento por ubicacion");
		System.out.println("2) Consultar empleado por salario");
		System.out.println("3) Borrar un departamento por código");
		System.out.println("4) Modificar ubicacion de un departamento");
		System.out.println("5) Consultar departamento por codigo");
		System.out.println("6) Agregar departamento");
		System.out.println("7) Cambiar departamento a un empleado");
		System.out.println("8) Consultar informaticos en la empresa");
		System.out.println("9) Consultar todos los departamentos ordenados por nombre");
		System.out.println("10) Exportar empleamos a fichero CSV");
		System.out.println("11) Importar fichero CSV");



	}

	public static void main(String[] args) throws Exception {

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

				case 3:
					int codigo = Teclado.leerEntero("Codigo? ");
					boolean departamento;
					departamento = AccesoDepartamento.eliminarDepartamento(codigo);

					if (departamento) {
						System.out.println("Se ha eliminado correctamento");
					} else {
						System.out.println("No se ha encontrado el departamento");
					}

					break;
				// Borrar un departamento por código

				case 4:
					// "4) Modificar ubicacion de un departamento
					String nuevaUbi = Teclado.leerCadena("Ubicacion nueva?");
					int codDep = Teclado.leerEntero("Codigo del departamento?");
					boolean modificado = AccesoDepartamento.modificarDepartamento(nuevaUbi, codDep);
					if (!modificado) {
						System.out.println("No se ha encontrado ningun departamento con ese codigo");
					}else {
						System.out.println("Se ha modificado correctamento");
						Departamento dp = AccesoDepartamento.consultarDepartamento(codDep);
						System.out.println(dp.toString());
					}
					break;
				case 5:
					// 5) Consultar departamento por codigo
					int codDep5 = Teclado.leerEntero("Codigo del departamento");
					Departamento dep5 = AccesoDepartamento.consultarDepartamento(codDep5);
					if (dep5 != null) {
						System.out.println(dep5.toString());
					} else {
						System.out.println("No existe ningun departamento con ese codigo");
					}
					break;
				case 6:
					// agregar departamento
					String nuevoNombre6 = Teclado.leerCadena("Nombre del nuevo departamento?");
					String nuevaUbi6 = Teclado.leerCadena("Ubicacion del nuevo departamento?");
					boolean agregado6 = AccesoDepartamento.agregarDepartamento(nuevoNombre6, nuevaUbi6);
					if (agregado6) {
						System.out.println("Se ha agregado correctamento");
						Departamento ultDep = AccesoDepartamento.listarDepartamentos().getLast();
						System.out.println(ultDep.toString());
					} else {
						System.out.println("El departamento no se ha podido agregar");
					}
					break;

				case 9:
					List<Departamento> departamentosAll;
					departamentosAll = AccesoDepartamento.listarDepartamentos();
					if (departamentosAll.isEmpty()) {
						System.out.println("La lista esta vacia, no hay departamentos");
					} else {
						for (Departamento e : departamentosAll) {
							System.out.println(e.toString());
						}
					}
				}
					
			} catch (BDException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
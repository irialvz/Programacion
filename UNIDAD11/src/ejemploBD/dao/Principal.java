package ejemploBD.dao;

import java.util.List;
import java.util.Scanner;

import ejemploBD.excepciones.BDException;
import ejemploBD.modelo.Departamento;
import entrada.Teclado;
import hoja6.ejer2.Asalariado;
import hoja6.ejer2.Personal;
import hoja6.ejer2.Voluntario;
import hoja6.ejer2.caracteresExcepcion;

public class Principal {
    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int resultado;
        System.out.println("(1) Modificar Ubicacion por departamento");
        System.out.println("(2) Eliminar departamento por codigo");
        System.out.println("(3) Consultar departamento por ubicacion");
        System.out.println("(4) Consultar departamento por codigo");
        System.out.println("(5) Consultar empleado segun salario");
        System.out.println("(6) Consultar empleado por Departamento");
        System.out.println("(0) Fin");
        System.out.println("Opcion? ");
        resultado = teclado.nextInt();
        //teclado.nextLine();
        return resultado;
    }

	// Consulta los departamentos de la base de datos con la misma ubicaci�n y
	// ordenados por nombre de forma ascendente.
	public static void main(String[] args) {
		// Realiza la consulta
		Scanner teclado = new Scanner(); 

        try{
        	int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo....");
                    break;
                case 1:
                	List<Departamento> departamentos = new ArrayList<Departamento>();
                	System.out.println("Nueva ubicacion?");
                	String ubicacion = teclado.nextLine();
                	System.out.println("Codigo del departamento?");
                	int codDepartamento = teclado.nextInt();
                	departamentos = AccesoDepartamento.modificarUbicacionDepartamento(codDepartamento,ubicacion);
                	System.out.println(departamentos);
                	break;
                	
                case 2: 
                	List<Departamento> departamentos = new ArrayList<Departamento>();
                	System.out.println("Nueva ubicacion?");
                	String ubicacion = teclado.nextLine();
                	System.out.println("Codigo del departamento?");
                	int codDepartamento = teclado.nextInt();
                	
                	departamentos = AccesoDepartamento.modificarUbicacionDepartamento(codDepartamento,ubicacion);
                	System.out.println(departamentos);
                    break;
                case 3:
                	List<Departamento> departamentos = new ArrayList<Departamento>();
                	System.out.println("Ubicacion del departamento?");
                	String ubicacion = teclado.nextLine();
                	departamentos = AccesoDepartamento.consultarDepartamentos2(ubicacion);
                    System.out.println(departamentos);
                    break;
                case 4:
                	List<Departamento> departamentos = new ArrayList<Departamento>();
                	System.out.println("Codigo del departamento?");
                	int codigo = teclado.nextInt();
                	departamentos = AccesoDepartamento.consultarDepartamento(codigo);
                    System.out.println(departamentos);
                    break;
                case 5:
                	List<Empleado> empleados = new ArrayList<Empleado>();
                	System.out.println("Salario?");
                	double salario = teclado.nextDouble();
                	empleados = AccesoEmpleado.consultarEmpleados(salario);
                	System.out.println(empleados);
                	break;
                case 6:
                	List<Empleado> empleados = new ArrayList<Empleado>();
                	System.out.println("Salario?");
                	double salario = teclado.nextDouble();
                	empleados = AccesoEmpleado.consultarEmpleadosDepartamento(salario);
                	System.out.println(empleados);
                	break;
            }
        } while (opcion != 0);
        } catch (BDException ex) {
        	System.out.println(ex.getMessage());
        }
	}
}
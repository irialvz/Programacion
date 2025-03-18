/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja6.ejer3.model;

import ejercicios.UNIDAD7.hoja6.ejer3.excepciones.MiExcepcion;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Vivienda.validarCodProp;
import static ejercicios.UNIDAD7.hoja6.ejer3.model.Vivienda.validarCodVivienda;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Adosado extends Unifamiliar {
    private int numCasa;
    private static ArrayList<Adosado> ListaAdosados = new ArrayList<>();
    
    public Adosado(String cod_vivienda, String cod_propietario, String direccion, double precio, boolean alquiler, int metrosJardin,int numCasa) throws MiExcepcion {
        super(cod_vivienda, cod_propietario, direccion, precio, alquiler, metrosJardin);
        if (numCasa <= 0){
            throw new MiExcepcion("El numero de casa no puede ser menor o igual que cero");
        }
        this.numCasa = numCasa;
    }

   public static void AltaAdosado() throws MiExcepcion{
               Scanner teclado = new Scanner(System.in);

        System.out.println("Codigo de vivienda?");
        String cod_vivienda = teclado.nextLine();
        if (cod_vivienda.length() != 10 || !validarCodVivienda(cod_vivienda)) {
            throw new MiExcepcion("El codigo de vivienda debe ser de 10 digitos en total \n 4 numero,un guion,una letra,un guion y tres numeros");
        }
        System.out.println("Codigo propietario? Ejemplo: A001");
        String cod_propietario = teclado.nextLine();
        if (cod_propietario.length() != 4 || !validarCodProp(cod_propietario)) {
            throw new MiExcepcion("El codigo de propietario debe ser de 1 letra y 3 numeros");
        }

        System.out.println("Direccion? ");
        String direccion = teclado.nextLine();
        if (direccion.isBlank()) {
            throw new MiExcepcion("La direccion no puede estar vacio");
        }

        double precio;
        do {
            System.out.println("Precio? (minimo 100 euros)");
            precio = teclado.nextDouble();
            if (precio < 100) {
                throw new MiExcepcion("El precio tiene que ser superior a 100 euros");
            }
        } while (precio < 100);
        teclado.nextLine();

        boolean alquiler;
        if (precio >= 5000) {
            alquiler = false;
        } else {
            alquiler = true;
        }
        System.out.println("Metros cuadrados del jardin? ");
        int metrosJardin = teclado.nextInt();
        if (metrosJardin < 0) {
            throw new MiExcepcion("Los metros del jardin no pueden ser menos que cero ni nulo");
        }
        System.out.println("Numero de casa? ");
        int numCasa = teclado.nextInt();
        if (numCasa <= 0) {
            throw new MiExcepcion("El numero de casa no puede ser menor o igual a cero");
        }
        
        Adosado nuevoAdosado = new Adosado(cod_vivienda,cod_propietario,direccion,precio,alquiler,metrosJardin,numCasa);
        ListaAdosados.add(nuevoAdosado);

   }
   public static void ListadoAdosados() throws MiExcepcion{
       if (ListaAdosados.isEmpty()){
           throw new MiExcepcion("El listado de Adosados esta vacio");
       }
       for (int i = 0; i<ListaAdosados.size();i++){
           System.out.println(ListaAdosados.get(i).toString());
       }
   }
    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public static ArrayList<Adosado> getListaAdosados() {
        return ListaAdosados;
    }

    public static void setListaAdosados(ArrayList<Adosado> ListaAdosados) {
        Adosado.ListaAdosados = ListaAdosados;
    }
    
    
}

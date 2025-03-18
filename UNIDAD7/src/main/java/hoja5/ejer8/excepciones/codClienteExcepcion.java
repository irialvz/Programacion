/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja5.ejer8.excepciones;

/**
 *
 * @author iriia
 */
public class codClienteExcepcion extends Exception{
    public codClienteExcepcion(){
        
    }
    public codClienteExcepcion(String mensaje){
        super(mensaje);
    }
    public static final String ERRORCOD = "El Código del cliente, tiene que empezar con una letra, seguida de 4 números.Ej.- A0001";
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD7.hoja7.ejer10;

import ejercicios.UNIDAD7.hoja7.ejer10.excepcion.exisitenteExcepcion;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Diccionario {
    Map <String,String> diccionarioEspEng = new HashMap<>();

 void agregarValor(String clave,String valor) throws exisitenteExcepcion{
        if (diccionarioEspEng.containsKey(clave) || diccionarioEspEng.containsValue(valor)){
            throw new exisitenteExcepcion(exisitenteExcepcion.VALORCLAVE_EXISTENTE);
        }
        diccionarioEspEng.put(clave, valor);
    }

    
}

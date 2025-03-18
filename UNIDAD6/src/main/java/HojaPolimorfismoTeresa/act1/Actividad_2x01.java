/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.UNIDAD6.HojaPolimorfismoTeresa.act1;

/**
 *
 * @author iriia
 */
public class Actividad_2x01 {

    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[10];

        empleados[0] = new Empleado("12345678A", "Juan Pasamar", "12/12/2006", "La Joyosa", "123456789", "juan@gmail.com");
        empleados[1] = new Empleado("78945612Q", "Xiomara Ratto", "12/2/2005", "Utebo", "987456324", "xio@gmail.com");
        empleados[2] = new Conductor("85214796W", "Dan Bolocan", "06/06/2006", "Zaragoza", "85236974", "dan@gmail.com", 1, "2/8/2020");
        empleados[3] = new Oficinista("36985214P", "Ismael Garcia", "14/9/2005", "Zaragoza", "45698712", "isma@gmail.com", "Administrativo", "Diurno");
        empleados[4] = new Oficinista("65478932E", "Daniel Gracia", "6/6/2006", "Zaragoza", "78945632", "dani@gmail.com", "Administrativo", "Diurno");
        empleados[5] = new Limpiador("8745629A", "Iria Alvarez", "29/01/2006", "Utebo", "680554776", "iria@gmail.com", true, false, false);

        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] != null){
                System.out.println("Tipo: " + empleados[i].getClass().getSimpleName()); 
                System.out.println(empleados[i].toString());
            }

        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudioFlotilla;
import javax.swing.JOptionPane;
import java.time.LocalDate;
/**
 *
 * @author shey
 */
public class FormMantenimiento {
    public static Mantenimiento crearMantenimiento() {

        int vehiculoId = Utilidades.leerEntero("ID del carrp:");
        String tipo = JOptionPane.showInputDialog("Tipo de mantenimiento (aceite, frenos, etc.):");
        LocalDate fecha = Utilidades.leerFecha("Fecha del mantenimiento");
        int km = Utilidades.leerEntero("Kilometraje al momento del mantenimiento:");

        return new Mantenimiento(vehiculoId, tipo, fecha, km);
    }
}


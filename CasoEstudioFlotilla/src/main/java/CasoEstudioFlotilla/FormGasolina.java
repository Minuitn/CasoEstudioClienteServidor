/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudioFlotilla;
import javax.swing.JOptionPane;
import java.time.LocalDate;
/**
 *
 * @author sebas
 */
public class FormGasolina {
    public static Combustible crearRegistroGasolina() {

        int vehiculoId = Utilidades.leerEntero("ID del carro:");
        LocalDate fecha = Utilidades.leerFecha("Fecha de carga");
        double litros = Utilidades.leerDouble("Litros cargados:");
        double costo = Utilidades.leerDouble("Costo total (₡):");

        return new Combustible(vehiculoId, fecha, litros, costo);
    }
}

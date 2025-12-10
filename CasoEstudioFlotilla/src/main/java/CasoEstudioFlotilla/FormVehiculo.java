/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudioFlotilla;
import javax.swing.JOptionPane;

/**
 *
 * @author shey
 */
public class FormVehiculo {

    public static Vehiculo crearVehiculo() {

        String placa = JOptionPane.showInputDialog("Ingrese la placa del carro:");
        String marca = JOptionPane.showInputDialog("Marca del carro:");
        String modelo = JOptionPane.showInputDialog("Modelo del carro:");
        int km = Utilidades.leerEntero("Kilometraje actual:");

        return new Vehiculo(placa, marca, modelo, km);
    }
}
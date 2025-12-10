/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudioFlotilla;
import java.time.LocalDate;

/**
 *
 * @author shey
 */
public class Utilidades {

    public static Integer leerEntero(String msg) {
        while (true) {
            try {
                String entrada = javax.swing.JOptionPane.showInputDialog(msg);
                if (entrada == null) return null;
                return Integer.parseInt(entrada.trim());
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Debe digitar un numero entero valido.");
            }
        }
    }

    public static Double leerDouble(String msg) {
        while (true) {
            try {
                String entrada = javax.swing.JOptionPane.showInputDialog(msg);
                if (entrada == null) return null;
                return Double.parseDouble(entrada.trim());
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Debe digitar un numero decimal valido.");
            }
        }
    }

    public static LocalDate leerFecha(String msg) {
        while (true) {
            try {
                String entrada = javax.swing.JOptionPane.showInputDialog(msg + "\nFormato: YYYY-MM-DD");
                if (entrada == null) return null;
                return LocalDate.parse(entrada.trim());
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Formato invalido. Intentelo de nuevo.");
            }
        }
    }

    public static void mensaje(String msg) {
        javax.swing.JOptionPane.showMessageDialog(null, msg);
    }
}


package CasoEstudioFlotilla;

// @autor Angel

import javax.swing.*;
import java.time.LocalDate;

public class Utilidades {

    public static Integer leerEntero(String msg) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(msg);
                if (entrada == null) {
                    return null;
                }
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                mostrarError("Debe ingresar un número entero válido.");
            } catch (Exception e) {
                mostrarError("Error inesperado: " + e.getMessage());
            }
        }
    }

    public static Double leerDouble(String msg) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(msg);
                if (entrada == null) {
                    return null;
                }
                return Double.parseDouble(entrada.trim());
            } catch (NumberFormatException e) {
                mostrarError("Debe digitar un número decimal válido.");
            } catch (Exception e) {
                mostrarError("Error inesperado: " + e.getMessage());
            }
        }
    }

    // Leer Fecha 
    public static LocalDate leerFecha(String msg) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(msg + "\nFormato: YYYY-MM-DD");
                if (entrada == null) {
                    return null;
                }
                return LocalDate.parse(entrada.trim());
            } catch (Exception e) {
                mostrarError("Formato de fecha inválido. Debe usar YYYY-MM-DD.");
            }
        }
    }

    // Mensaje Informativo 
    public static void mensaje(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    // Manejo de Errores 
    public static void mostrarError(String msg) {
        JOptionPane.showMessageDialog(null,
                msg,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

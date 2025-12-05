package CasoEstudioFlotilla;

import javax.swing.JOptionPane;

public class AppFlotilla {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "=== SISTEMA FLOTILLA XYZ ===\nControl de Vehículos, Mantenimientos y Combustible",
                "Flotilla XYZ", JOptionPane.INFORMATION_MESSAGE);

        // Menú principal
        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "1. Gestionar Vehículos\n2. Registrar Mantenimiento\n3. Registrar Combustible\n4. Consultar Reportes\n0. Salir",
                    "Flotilla XYZ", JOptionPane.QUESTION_MESSAGE);

            if (opcion == null) {
                break; // Usuario cierra diálogo
            }
            switch (opcion) {
                case "1":
                    JOptionPane.showMessageDialog(null, "🚗 Gestión de Vehículos - Conecta con sockets aquí",
                            "Flotilla XYZ", JOptionPane.INFORMATION_MESSAGE);
                    // Llamar ControladorVehiculo.gestionar();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "🔧 Registrar Mantenimiento - Conecta con sockets",
                            "Flotilla XYZ", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "⛽ Registrar Combustible - Conecta con sockets",
                            "Flotilla XYZ", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "📊 Reportes - km total, costos combustible",
                            "Flotilla XYZ", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar Flotilla XYZ!",
                            "Flotilla XYZ", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intenta de nuevo.",
                            "Flotilla XYZ", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

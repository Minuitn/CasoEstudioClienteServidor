package CasoEstudioFlotilla;

import javax.swing.JOptionPane;

public class AppFlotilla {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "=== SISTEMA FLOTILLA XYZ ===\nControl de Vehículos, Mantenimientos y Combustible",
                "Flotilla XYZ", JOptionPane.INFORMATION_MESSAGE);

        // menu principal
        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "1. Gestionar Vehículos\n"
                    + "2. Registrar Mantenimiento\n"
                    + "3. Registrar Combustible\n"
                    + "4. Consultar Reportes\n"
                    + "0. Salir",
                    "Flotilla XYZ", JOptionPane.QUESTION_MESSAGE);

            if (opcion == null) {
                break; // Usuario cierra dialogbox
            }

            switch (opcion) {

                case "1":
                    //  FORMULARIO VEHÍCULO 
                    Vehiculo vehiculo = FormVehiculo.crearVehiculo();
                    JOptionPane.showMessageDialog(null,
                            "Vehículo creado:\n" + vehiculo,
                            "Registro de Vehículo",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "2":
                    // === FORMULARIO MANTENIMIENTO ===
                    Mantenimiento mant = FormMantenimiento.crearMantenimiento();
                    JOptionPane.showMessageDialog(null,
                            "Mantenimiento registrado:\n" + mant,
                            "Registro de Mantenimiento",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "3":
                    // FORMULARIO COMBUSTIBLE (GASOLINA) 
                    Combustible gas = FormGasolina.crearRegistroGasolina();
                    JOptionPane.showMessageDialog(null,
                            "Combustible registrado:\n" + gas,
                            "Registro de Combustible",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null,
                            "📊 Reportes - km total, costos combustible",
                            "Reportes",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "0":
                    JOptionPane.showMessageDialog(null,
                            "¡Gracias por usar Flotilla XYZ!",
                            "Flotilla XYZ", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción inválida. Intenta de nuevo.",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}


package CasoEstudioFlotilla;

import javax.swing.*;
import java.awt.*;
import servidor.dao.VehiculoDAO;
import servidor.dao.MantenimientoDAO;
import servidor.dao.CombustibleDAO;

public class AppFlotilla extends JFrame {

    // DAO instanciados una sola vez
    private VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private MantenimientoDAO mantDAO = new MantenimientoDAO();
    private CombustibleDAO combDAO = new CombustibleDAO();

    public AppFlotilla() {

        setTitle("Flotilla XYZ");
        setSize(420, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // ----- ENCABEZADO -----
        JPanel header = new JPanel();
        header.setBackground(new Color(45, 70, 110));
        header.setPreferredSize(new Dimension(420, 55));

        JLabel titulo = new JLabel("Flotilla XYZ");
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        header.add(titulo);

        add(header, BorderLayout.NORTH);

        // ----- PANEL CENTRAL -----
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(4, 1, 10, 10));
        centro.setBackground(new Color(245, 245, 250));
        centro.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton btnVehiculos = crearBoton("Registrar Vehículos");
        JButton btnMant = crearBoton("Registrar Mantenimiento");
        JButton btnComb = crearBoton("Registrar Combustible");
        JButton btnReportes = crearBoton("Reportes");

        centro.add(btnVehiculos);
        centro.add(btnMant);
        centro.add(btnComb);
        centro.add(btnReportes);

        add(centro, BorderLayout.CENTER);

        // EVENTOS 
 

        // GUARDAR VEHÍCULO 
        btnVehiculos.addActionListener(e -> {
            try {
                Vehiculo v = FormVehiculo.crearVehiculo();
                if (v != null) {

                    boolean ok = vehiculoDAO.insertarVehiculo(v);

                    if (ok) {
                        JOptionPane.showMessageDialog(this,
                                "Vehículo guardado correctamente:\n" + v,
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Utilidades.mostrarError("No se pudo guardar el vehículo.");
                    }
                }
            } catch (Exception ex) {
                Utilidades.mostrarError("Error al registrar vehículo: " + ex.getMessage());
            }
        });

        // GUARDAR MANTENIMIENTO
        btnMant.addActionListener(e -> {
            try {
                Mantenimiento m = FormMantenimiento.crearMantenimiento();
                if (m != null) {

                    boolean ok = mantDAO.insertarMantenimiento(m);

                    if (ok) {
                        JOptionPane.showMessageDialog(this,
                                "Mantenimiento guardado:\n" + m,
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Utilidades.mostrarError("No se pudo guardar el mantenimiento.");
                    }
                }
            } catch (Exception ex) {
                Utilidades.mostrarError("Error al registrar mantenimiento: " + ex.getMessage());
            }
        });

              // GUARDAR COMBUSTIBLE 
        btnComb.addActionListener(e -> {
            try {
                Combustible c = FormGasolina.crearRegistroGasolina();
                if (c != null) {

                    boolean ok = combDAO.insertarCombustible(c);

                    if (ok) {
                        JOptionPane.showMessageDialog(this,
                                "Combustible registrado:\n" + c,
                                "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Utilidades.mostrarError("No se pudo guardar la carga de combustible.");
                    }
                }
            } catch (Exception ex) {
                Utilidades.mostrarError("Error al registrar combustible: " + ex.getMessage());
            }
        }); // ✔ AHORA SÍ CIERRA BIEN


        // REPORTES (
        btnReportes.addActionListener(e -> {
            new VentanaReportes().setVisible(true);
        });


        //  PIE DE PÁGINA 
        JPanel footer = new JPanel();
        footer.setBackground(new Color(220, 220, 230));
        footer.setPreferredSize(new Dimension(420, 35));

        JLabel pie = new JLabel("© 2025 Flotilla XYZ");
        pie.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footer.add(pie);

        add(footer, BorderLayout.SOUTH);
    }

    private JButton crearBoton(String texto) {
        JButton b = new JButton(texto);
        b.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        b.setBackground(new Color(220, 225, 240));
        b.setForeground(new Color(40, 40, 60));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(new Color(160, 160, 180)));
        return b;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppFlotilla().setVisible(true);
        });
    }
}




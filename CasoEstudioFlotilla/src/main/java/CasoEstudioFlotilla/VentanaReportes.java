package CasoEstudioFlotilla;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import servidor.dao.VehiculoDAO;
import servidor.dao.MantenimientoDAO;
import servidor.dao.CombustibleDAO;


public class VentanaReportes extends JFrame {

    private JTable tablaVehiculos, tablaMantenimientos, tablaCombustible;
    private JLabel lblTotalLitros, lblTotalCosto, lblTotalMant;
    private JButton btnVolver;
    private VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private MantenimientoDAO mantDAO = new MantenimientoDAO();
    private CombustibleDAO combDAO = new CombustibleDAO();

public VentanaReportes() {

    setTitle("Reportes - Flotilla XYZ");
    setSize(700, 600);
    setLocationRelativeTo(null);
    setResizable(false);

    // Usamos BorderLayout en el contenido
    getContentPane().setLayout(new BorderLayout());

    JTabbedPane tabs = new JTabbedPane();

    // TAB 1 - VEHICULOS
    JPanel panelVeh = new JPanel(new BorderLayout());
    tablaVehiculos = new JTable();
    panelVeh.add(new JScrollPane(tablaVehiculos), BorderLayout.CENTER);
    tabs.addTab("Vehículos", panelVeh);

    // TAB 2 - MANTENIMIENTO
    JPanel panelMant = new JPanel(new BorderLayout());
    tablaMantenimientos = new JTable();
    panelMant.add(new JScrollPane(tablaMantenimientos), BorderLayout.CENTER);
    tabs.addTab("Mantenimientos", panelMant);

    // TAB 3 - COMBUSTIBLE
    JPanel panelComb = new JPanel(new BorderLayout());
    tablaCombustible = new JTable();
    panelComb.add(new JScrollPane(tablaCombustible), BorderLayout.CENTER);

    // Totales debajo del combustible
    JPanel panelTotales = new JPanel(new GridLayout(3, 1));
    lblTotalLitros = new JLabel("Total litros: 0");
    lblTotalCosto = new JLabel("Total costo combustible: ₡0");
    lblTotalMant = new JLabel("Cantidad mantenimientos: 0");

    lblTotalLitros.setFont(new Font("Segoe UI", Font.BOLD, 14));
    lblTotalCosto.setFont(new Font("Segoe UI", Font.BOLD, 14));
    lblTotalMant.setFont(new Font("Segoe UI", Font.BOLD, 14));

    panelTotales.add(lblTotalLitros);
    panelTotales.add(lblTotalCosto);
    panelTotales.add(lblTotalMant);

    panelComb.add(panelTotales, BorderLayout.SOUTH);
    tabs.addTab("Combustible", panelComb);

    // Agregamos las pestañas al centro
    getContentPane().add(tabs, BorderLayout.CENTER);

    // Panel inferior con botón "Volver al menú"
    JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    btnVolver = new JButton("Volver al menú");
    panelBoton.add(btnVolver);
    getContentPane().add(panelBoton, BorderLayout.SOUTH);

    // Acción del botón
    btnVolver.addActionListener(e -> {
        // Si tu menú principal es un JFrame, lo podrías abrir aquí.
        // Si solo quieres cerrar esta ventana y nada más:
        this.dispose();
        // Si tienes una ventana principal tipo FormPrincipal, podrías hacer:
        // new FormPrincipal().setVisible(true);
    });

    cargarDatos();
}


    // CARGA DE DATOS DESDE LA BASE DE DATOS
    private void cargarDatos() {

        //  VEHICULOS 
        try {
            List<Vehiculo> listaVeh = vehiculoDAO.listarVehiculos();
            DefaultTableModel modelVeh = new DefaultTableModel(
                    new String[]{"ID", "Placa", "Marca", "Modelo", "Kilometraje"}, 0);

            for (Vehiculo v : listaVeh) {
                modelVeh.addRow(new Object[]{
                    v.getId(), v.getPlaca(), v.getMarca(), v.getModelo(), v.getKilometraje()
                });
            }
            tablaVehiculos.setModel(modelVeh);

        } catch (Exception e) {
            Utilidades.mostrarError("Error cargando vehículos: " + e.getMessage());
        }

        //  MANTENIMIENTOS
        try {
            List<Mantenimiento> listaMant = mantDAO.listarMantenimientos();
            DefaultTableModel modelMant = new DefaultTableModel(
                    new String[]{"ID", "Vehículo", "Tipo", "Fecha", "Kilometraje"}, 0);

            for (Mantenimiento m : listaMant) {
                modelMant.addRow(new Object[]{
                    m.getId(), m.getVehiculoid(), m.getTipo(),
                    m.getFecha(), m.getKilometraje()
                });
            }
            tablaMantenimientos.setModel(modelMant);

            lblTotalMant.setText("Cantidad mantenimientos: " + listaMant.size());

        } catch (Exception e) {
            Utilidades.mostrarError("Error cargando mantenimientos: " + e.getMessage());
        }

        // COMBUSTIBLE 
        try {
            List<Combustible> listaComb = combDAO.listarCombustible();
            DefaultTableModel modelComb = new DefaultTableModel(
                    new String[]{"ID", "Vehículo", "Fecha", "Litros", "Costo"}, 0);

            double totalLitros = 0;
            double totalCosto = 0;

            for (Combustible c : listaComb) {
                modelComb.addRow(new Object[]{
                    c.getId(), c.getVehiculoid(), c.getFecha(),
                    c.getLitros(), c.getCosto()
                });
                totalLitros += c.getLitros();
                totalCosto += c.getCosto();
            }

            tablaCombustible.setModel(modelComb);

            // mostrar totales
            lblTotalLitros.setText("Total litros: " + totalLitros);
            lblTotalCosto.setText("Total costo combustible: ₡" + totalCosto);

        } catch (Exception e) {
            Utilidades.mostrarError("Error cargando combustibles: " + e.getMessage());
        }
    }
}

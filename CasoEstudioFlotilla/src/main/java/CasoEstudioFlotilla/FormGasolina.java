
package CasoEstudioFlotilla;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class FormGasolina extends JDialog {

    private JTextField txtVehiculoId, txtFecha, txtLitros, txtCosto;
    private boolean ok = false;

    public FormGasolina() {
        setTitle("Registro de Combustible");
        setSize(400, 380);
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 245, 230));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Registro de Combustible", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(180, 120, 20));
        panel.add(titulo, BorderLayout.NORTH);

        JPanel datos = new JPanel(new GridLayout(4, 2, 10, 10));
        datos.setBackground(new Color(255, 245, 230));

        datos.add(new JLabel("ID Vehículo:", SwingConstants.RIGHT));
        txtVehiculoId = new JTextField();
        datos.add(txtVehiculoId);

        datos.add(new JLabel("Fecha (YYYY-MM-DD):", SwingConstants.RIGHT));
        txtFecha = new JTextField();
        datos.add(txtFecha);

        datos.add(new JLabel("Litros:", SwingConstants.RIGHT));
        txtLitros = new JTextField();
        datos.add(txtLitros);

        datos.add(new JLabel("Costo (₡):", SwingConstants.RIGHT));
        txtCosto = new JTextField();
        datos.add(txtCosto);

        panel.add(datos, BorderLayout.CENTER);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(200, 140, 50));
        btnGuardar.setForeground(Color.white);
        btnGuardar.addActionListener(e -> {
            ok = true;
            dispose();
        });

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JPanel botones = new JPanel();
        botones.add(btnGuardar);
        botones.add(btnCancelar);

        panel.add(botones, BorderLayout.SOUTH);

        add(panel);
    }

    public static Combustible crearRegistroGasolina() {
        FormGasolina f = new FormGasolina();
        f.setVisible(true);

        if (!f.ok) return null;

        int vehiculo;
        double litros, costo;
        LocalDate fecha;

        try {
            vehiculo = Integer.parseInt(f.txtVehiculoId.getText().trim());
            litros = Double.parseDouble(f.txtLitros.getText().trim());
            costo = Double.parseDouble(f.txtCosto.getText().trim());
            fecha = LocalDate.parse(f.txtFecha.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos inválidos.");
            return null;
        }

        return new Combustible(vehiculo, fecha, litros, costo);
    }
}


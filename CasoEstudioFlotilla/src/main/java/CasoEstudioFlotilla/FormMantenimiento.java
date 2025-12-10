
package CasoEstudioFlotilla;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class FormMantenimiento extends JDialog {

    private JTextField txtVehiculoId, txtTipo, txtFecha, txtKm;
    private boolean ok = false;

    public FormMantenimiento() {
        setTitle("Registrar Mantenimiento");
        setSize(400, 380);
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 235, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Registro de Mantenimiento", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(85, 20, 140));
        panel.add(titulo, BorderLayout.NORTH);

        JPanel datos = new JPanel(new GridLayout(4, 2, 10, 10));
        datos.setBackground(new Color(240, 235, 255));

        datos.add(new JLabel("ID Vehículo:", SwingConstants.RIGHT));
        txtVehiculoId = new JTextField();
        datos.add(txtVehiculoId);

        datos.add(new JLabel("Tipo:", SwingConstants.RIGHT));
        txtTipo = new JTextField();
        datos.add(txtTipo);

        datos.add(new JLabel("Fecha (YYYY-MM-DD):", SwingConstants.RIGHT));
        txtFecha = new JTextField();
        datos.add(txtFecha);

        datos.add(new JLabel("Kilometraje:", SwingConstants.RIGHT));
        txtKm = new JTextField();
        datos.add(txtKm);

        panel.add(datos, BorderLayout.CENTER);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(120, 60, 180));
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

    public static Mantenimiento crearMantenimiento() {
        FormMantenimiento f = new FormMantenimiento();
        f.setVisible(true);

        if (!f.ok) return null;

        int id;
        int km;
        LocalDate fecha;

        try {
            id = Integer.parseInt(f.txtVehiculoId.getText().trim());
            km = Integer.parseInt(f.txtKm.getText().trim());
            fecha = LocalDate.parse(f.txtFecha.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos inválidos.");
            return null;
        }

        String tipo = f.txtTipo.getText().trim();

        return new Mantenimiento(id, tipo, fecha, km);
    }
}




package CasoEstudioFlotilla;

import javax.swing.*;
import java.awt.*;

public class FormVehiculo extends JDialog {

    private JTextField txtPlaca, txtMarca, txtModelo, txtKm;
    private boolean confirmado = false;

    public FormVehiculo() {
        setTitle("Registrar Vehículo");
        setSize(400, 350);
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(230, 240, 255)); // Celeste claro
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Título
        JLabel titulo = new JLabel("Registro de Vehículo", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(60, 90, 160));
        panel.add(titulo, BorderLayout.NORTH);

        // Panel datos
        JPanel datos = new JPanel(new GridLayout(4, 2, 10, 10));
        datos.setBackground(new Color(230, 240, 255));

        datos.add(new JLabel("Placa:", SwingConstants.RIGHT));
        txtPlaca = new JTextField();
        datos.add(txtPlaca);

        datos.add(new JLabel("Marca:", SwingConstants.RIGHT));
        txtMarca = new JTextField();
        datos.add(txtMarca);

        datos.add(new JLabel("Modelo:", SwingConstants.RIGHT));
        txtModelo = new JTextField();
        datos.add(txtModelo);

        datos.add(new JLabel("Kilometraje:", SwingConstants.RIGHT));
        txtKm = new JTextField();
        datos.add(txtKm);

        panel.add(datos, BorderLayout.CENTER);

        // Botones
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(70, 130, 180));
        btnGuardar.setForeground(Color.white);

        btnGuardar.addActionListener(e -> {
            confirmado = true;
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

    public static Vehiculo crearVehiculo() {
        FormVehiculo f = new FormVehiculo();
        f.setVisible(true);

        if (!f.confirmado) return null;

        // Validaciones
        String placa = f.txtPlaca.getText().trim();
        String marca = f.txtMarca.getText().trim();
        String modelo = f.txtModelo.getText().trim();

        int km;
        try {
            km = Integer.parseInt(f.txtKm.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kilometraje inválido.");
            return null;
        }

        return new Vehiculo(placa, marca, modelo, km);
    }
}

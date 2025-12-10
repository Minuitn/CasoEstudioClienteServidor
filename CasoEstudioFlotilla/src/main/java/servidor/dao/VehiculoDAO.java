
package servidor.dao;

import CasoEstudioFlotilla.ConexionDB;
import CasoEstudioFlotilla.Vehiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    public boolean insertarVehiculo(Vehiculo v) throws SQLException {
        String sql = "INSERT INTO vehiculo (placa, marca, modelo, kilometraje) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getMarca());
            ps.setString(3, v.getModelo());
            ps.setInt(4, v.getKilometraje());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Vehiculo> listarVehiculos() throws SQLException {
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vehiculo v = new Vehiculo(
                    rs.getString("placa"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("kilometraje")
                );
                v.setId(rs.getInt("id"));
                lista.add(v);
            }
        }
        return lista;
    }

    public Vehiculo buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM vehiculo WHERE id = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vehiculo v = new Vehiculo(
                    rs.getString("placa"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("kilometraje")
                );
                v.setId(rs.getInt("id"));
                return v;
            }
        }
        return null;
    }
}



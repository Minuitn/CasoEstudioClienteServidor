package servidor.dao;

import CasoEstudioFlotilla.ConexionDB;
import CasoEstudioFlotilla.Mantenimiento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MantenimientoDAO {

    public boolean insertarMantenimiento(Mantenimiento m) throws SQLException {
        String sql = "INSERT INTO mantenimiento (vehiculo_id, tipo, fecha, kilometraje) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getVehiculoid());
            ps.setString(2, m.getTipo());
            ps.setDate(3, Date.valueOf(m.getFecha()));
            ps.setInt(4, m.getKilometraje());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Mantenimiento> listarMantenimientos() throws SQLException {
        List<Mantenimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM mantenimiento";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mantenimiento m = new Mantenimiento(
                    rs.getInt("vehiculo_id"),
                    rs.getString("tipo"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getInt("kilometraje")
                );
                m.setId(rs.getInt("id"));
                lista.add(m);
            }
        }
        return lista;
    }
}

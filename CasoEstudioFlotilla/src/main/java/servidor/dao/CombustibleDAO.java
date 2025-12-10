
package servidor.dao;

import CasoEstudioFlotilla.ConexionDB;
import CasoEstudioFlotilla.Combustible;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CombustibleDAO {

    public boolean insertarCombustible(Combustible c) throws SQLException {
        String sql = "INSERT INTO combustible (vehiculo_id, fecha, litros, costo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getVehiculoid());
            ps.setDate(2, Date.valueOf(c.getFecha()));
            ps.setDouble(3, c.getLitros());
            ps.setDouble(4, c.getCosto());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Combustible> listarCombustible() throws SQLException {
        List<Combustible> lista = new ArrayList<>();
        String sql = "SELECT * FROM combustible";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Combustible c = new Combustible(
                    rs.getInt("vehiculo_id"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getDouble("litros"),
                    rs.getDouble("costo")
                );
                c.setId(rs.getInt("id"));
                lista.add(c);
            }
        }
        return lista;
    }
}



package Modelo.seguridad;

import Controlador.seguridad.Marca; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO {

    private static final String SQL_SELECT = "SELECT codigo_marca, nombre_marca, estatus_marca FROM marca";
    private static final String SQL_INSERT = "INSERT INTO marca(codigo_marca, nombre_marca, estatus_marca) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE marca SET nombre_marca=?, estatus_marca=? WHERE codigo_marca = ?";
    private static final String SQL_DELETE = "DELETE FROM marca WHERE codigo_marca=?";
    private static final String SQL_QUERY  = "SELECT codigo_marca, nombre_marca, estatus_marca FROM marca WHERE codigo_marca = ?";

    public List<Marca> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setCodigo_marca(rs.getString("codigo_marca"));
                marca.setNombre_marca(rs.getString("nombre_marca"));
                marca.setEstatus_marca(rs.getString("estatus_marca"));
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return marcas;
    }

    public int insert(Marca marca) { 
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, marca.getCodigo_marca());
            stmt.setString(2, marca.getNombre_marca());
            stmt.setString(3, marca.getEstatus_marca());

            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros insertados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Marca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, marca.getNombre_marca());
            stmt.setString(2, marca.getEstatus_marca());
            stmt.setString(3, marca.getCodigo_marca());

            System.out.println("Ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Marca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, marca.getCodigo_marca());

            System.out.println("Ejecutando query: " + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Marca query(Marca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, marca.getCodigo_marca());
            rs = stmt.executeQuery();

            if (rs.next()) {
                marca.setNombre_marca(rs.getString("nombre_marca"));
                marca.setEstatus_marca(rs.getString("estatus_marca"));
            } else {
                marca = null; // No encontrado
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return marca;
    }
}

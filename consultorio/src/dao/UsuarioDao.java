package dao;

import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDao {

    /**
     * Crea un nueva instancia de la clase usuario
     */
    public UsuarioDao() {
    }

    public Usuario verificarUsuario(String rut, String tipo) {
        Usuario u = null;
        Connection cn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            ConectionDao c = new ConectionDao();
            cn = c.getConnection();
            String sql = "SELECT * FROM MEDICO WHERE rut=? AND tipo=?";
            pr = cn.prepareStatement(sql);
            pr.setString(1, rut);
            pr.setString(2, tipo);
            rs = pr.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setRut(rs.getString("rut"));
                u.setTipo(rs.getString("tipo"));
                u.setNombre(rs.getString("nombre"));

                //u.setPaterno(rs.getString("paterno"));
                //u.setMaterno(rs.getString("materno"));
                //u.setDireccion(rs.getString("direccion"));
                //u.setTelefono(rs.getString("telefono"));
                //u.setClave(rs.getString("clave"));
                //u.setCargo(rs.getInt("idcargo"));
                break;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            u = null;
        } finally {
            try {
                rs.close();
                pr.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        try {
            ConectionDao c = new ConectionDao();
            cn = c.getConnection();
            String sql = "SELECT * FROM PACIENTE WHERE rut=? AND tipo=?";
            pr = cn.prepareStatement(sql);
            pr.setString(1, rut);
            pr.setString(2, tipo);
            rs = pr.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setRut(rs.getString("rut"));
                u.setTipo(rs.getString("tipo"));
                u.setNombre(rs.getString("nombre"));

                //u.setPaterno(rs.getString("paterno"));
                //u.setMaterno(rs.getString("materno"));
                //u.setDireccion(rs.getString("direccion"));
                //u.setTelefono(rs.getString("telefono"));
                //u.setClave(rs.getString("clave"));
                //u.setCargo(rs.getInt("idcargo"));
                break;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            u = null;
        } finally {
            try {
                rs.close();
                pr.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return u;
    }

}

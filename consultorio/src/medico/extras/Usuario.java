package medico.extras;

import java.sql.*;
import javax.swing.JOptionPane;



public class Usuario{
	private String rut;
	private String nombre;
	//private String paterno;
	//private String materno;
                    //private String direccion;
                    //private String telefono;
	//private String clave;
                    //private String nouser;
	//private int cargo;

	/** Crea un nueva instancia de la clase usuario */
	public Usuario(){
        }
        public Usuario verificarUsuario(String rut, String nombre){
        Usuario u=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            conectate c=new conectate();
            cn=c.getConnection();
            String sql="SELECT * FROM MEDICO WHERE rut=? AND nombre=?";   
            pr=cn.prepareStatement(sql);                                                                        
            pr.setString(1, rut);
            pr.setString(2, nombre);
            rs=pr.executeQuery();
            while(rs.next()){
                u=new Usuario();
                u.setRut(rs.getString("rut"));                    
                u.setNombre(rs.getString("nombre"));       
                //u.setPaterno(rs.getString("paterno"));
                //u.setMaterno(rs.getString("materno"));
                //u.setDireccion(rs.getString("direccion"));
                //u.setTelefono(rs.getString("telefono"));
               //u.setClave(rs.getString("clave"));
                //u.setCargo(rs.getInt("idcargo"));
                break;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            u=null;
        }finally{
            try{
                rs.close();
                pr.close();
                rs.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return u;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

   
}
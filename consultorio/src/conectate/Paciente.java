package conectate;
import java.sql.*;

/**

 */
public class Paciente {
  conectate con;
  
  public Paciente (){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/
   public void NuevoCliente(String Rut, String Nombre, String Direccion, String Comuna, String Tipificacion, String lactual, String lanterior){
            try{
                try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                        "cliente (Rut, Nombre, Direccion, Comuna, Tipificacion, lactual, lanterior) " +
                        " values (?,?,?,?,?,?,?)")) {
                    pstm.setString(1, Rut);
                    pstm.setString(2, Nombre);
                    pstm.setString(3, Direccion);
                    pstm.setString(4, Comuna);
                    pstm.setString(5, Tipificacion);
                    pstm.setString(6, lactual);
                    pstm.setString(7, lanterior);
                    pstm.execute();
                }            
         }catch(SQLException e){
         System.out.println(e);
      }
   }


   
   
        // actualiza el registro
   
     public void updateCliente(String Id, String Rut, String Nombre, String Direccion, String Comuna, String Tipificacion, String lactual, String lanterior){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("update cliente " +
                   "set Rut = ? ," +
                   "Nombre = ? ," +
                   "Direccion = ? ," +
                   "Comuna = ?, " +
                   "Tipificacion = ?, " +
                   "lactual = ?, " +
                   "lanterior = ? " +   // el penultimo siempre sin coma
                   "where Id = ? ")) {
               pstm.setString(1, Rut);
               pstm.setString(2, Nombre);
               pstm.setString(3, Direccion);
               pstm.setString(4, Comuna);
               pstm.setString(5, Tipificacion);
               pstm.setString(6, lactual);
               pstm.setString(7, lanterior);
               pstm.setString(8, String.valueOf(Id));
            pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void deleteCliente(String Id){  
            try {                
                try (PreparedStatement pstm = con.getConnection().prepareStatement("delete from cliente "
                        + "where Id = ?")) {
                    pstm.setString(1, Id);
                    pstm.execute();
                }            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }


    
 /*obtenemos todos los datos de la tabla*/
 public Object [][] getDatos(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM CONSULTA_MEDICA"); 
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][3];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " FECHA_CONSULTA, DIAGNOSTICO, TRATAMIENTO "  +
            " FROM CONSULTA_MEDICA " ); // " ORDER BY  FECHA_CONSULTA "
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estFecha = res.getString("FECHA_CONSULTA");
                  String estDiagnostico = res.getString("DIAGNOSTICO");
                  String estTratamiento = res.getString("TRATAMIENTO");
                  data[i][0] = estFecha;
                  data[i][1] = estDiagnostico;    
                  data[i][2] = estTratamiento;
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    
 }    
    
 } 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 


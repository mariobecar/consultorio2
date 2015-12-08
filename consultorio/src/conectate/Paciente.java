package conectate;
import java.sql.*;
import paciente.BuscarPaciente;
import paciente.historialPaciente;

/**
 
 */
public class Paciente {
  conectate con;
    
  
  public Paciente (){
    con = new conectate();
  } 
    

// matriz de la tabla, no modificar "   
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
             " FROM CONSULTA_MEDICA WHERE RUT_PACIENTE='"+BuscarPaciente.RUT.getText()+"' ORDER BY CODIGO_CONSULTA DESC FETCH NEXT 3 ROWS ONLY " );
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
 
 // obtiene de tabla consulta_medica
  public Object [][] getInfoPaciente(){
     
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM CONSULTA_MEDICA "); 
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] dato = new String[registros][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT * FROM CONSULTA_MEDICA "   
                 + "WHERE RUT_PACIENTE='"+BuscarPaciente.RUT.getText()+"' ORDER BY CODIGO_CONSULTA DESC FETCH FIRST ROW ONLY"); 
             try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estNombre = res.getString("RUT_PACIENTE");
                  String estApellido = res.getString("RUT_PACIENTE");
                  
                  String estCodigo = res.getString("CODIGO_CONSULTA");
                  String estObservaciones = res.getString("OBSERVACIONES");
                  String estDiagnostico = res.getString("DIAGNOSTICO");
                  String estTratamiento = res.getString("TRATAMIENTO");                
                  String estRut = res.getString("RUT_MEDICO");                
                  String estFecha = res.getString("FECHA_CONSULTA");                
                  String estTipo = res.getString("TIPO_CONSULTA");
                  
                  dato[i][0] = estNombre;
                  dato[i][1] = estApellido;  
                  
                  historialPaciente.Obs.setText(estObservaciones);
                  historialPaciente.Diag.setText(estDiagnostico);
                  historialPaciente.Trat.setText(estTratamiento);
                  historialPaciente.mm.setText(estRut);
                  historialPaciente.Fecha.setText(estFecha);
                  historialPaciente.jTipo.setText(estTipo);
                  historialPaciente.codigo.setText(estCodigo);
                  
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
 
 // obtiene desde la tabla paciente
  public Object [][] getNombrePaciente(){
     
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM PACIENTE "); 
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] dato = new String[registros][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT * FROM PACIENTE "   
                 + "WHERE RUT='"+BuscarPaciente.RUT.getText()+"' "); 
             try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estNombre = res.getString("NOMBRE");
                  String estApellido = res.getString("APELLIDO");  
                  dato[i][0] = estNombre;
                  dato[i][1] = estApellido;  
                  historialPaciente.Paciente.setText(estNombre +" "+estApellido);
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
    return dato;
 }  
 
 // obtiene desde tabla medico
 public Object [][] getNombreMedico(){
     
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM MEDICO "); 
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] dato = new String[registros][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT * FROM MEDICO "   
                 + "WHERE RUT='"+historialPaciente.mm.getText()   +"' ");   
             try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estNombre = res.getString("NOMBRE");
                  String estApellido = res.getString("APELLIDO");
                  dato[i][0] = estNombre;
                  dato[i][1] = estApellido;  
                  historialPaciente.med.setText(estNombre +" "+estApellido);
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
    return dato;
 }  
 
 
 
 public Object [][] getExamenes(){
     
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM DETALLE_CONSULTA "); 
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] dato = new String[registros][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT * FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA='"+ historialPaciente.codigo.getText()+"' "); 
             try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  String estDos = res.getString("SOLICITADO");
                  String estTres = res.getString("SOLICITADO");
                  String estCuatro = res.getString("SOLICITADO");
                  String estCinco = res.getString("SOLICITADO");
                  String estSeis = res.getString("SOLICITADO");
                  String estSiete = res.getString("SOLICITADO");
                  String estOcho = res.getString("SOLICITADO");
                  String estNueve = res.getString("SOLICITADO");
                  String estDiez = res.getString("SOLICITADO");
                  String estOnce = res.getString("SOLICITADO");
                  String estDoce = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  dato[i][1] = estDos;  
                  
                  historialPaciente.uno.setText(estUno);
                  historialPaciente.dos.setText(estDos);
                  historialPaciente.tres.setText(estTres);
                  historialPaciente.cuatro.setText(estCuatro);
                  historialPaciente.cinco.setText(estCinco);
                  historialPaciente.seis.setText(estSeis);
                  historialPaciente.siete.setText(estSiete);
                  historialPaciente.ocho.setText(estOcho);
                  historialPaciente.nueve.setText(estNueve);
                  historialPaciente.diez.setText(estDiez);
                  historialPaciente.once.setText(estOnce);
                  historialPaciente.doce.setText(estDoce);
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
 
 
 
 
 
 
 

}
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
 
 
 // Principales
 public Object [][] getExamen1(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=1  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.pBio.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
 
  public Object [][] getExamen2(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=2  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.pOri.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  public Object [][] getExamen3(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=3  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.pHec.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  public Object [][] getExamen4(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=4  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.pGlu.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  // RMagnetica
  public Object [][] getExamen5(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=5  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.rTor.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  public Object [][] getExamen6(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=6  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.rCol.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  public Object [][] getExamen7(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=7  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.rCab.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  public Object [][] getExamen8(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=8  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.rAbd.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  //Eco
  
  public Object [][] getExamen9(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=9  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.eCab.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  public Object [][] getExamen10(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=10  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.eTor.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  public Object [][] getExamen11(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=11  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.eAbd.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  public Object [][] getExamen12(){
     
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
      
    Object[][] dato = new String[registros][1];  
      try{ 
         PreparedStatement pstm = con.getConnection().prepareStatement(" SELECT SOLICITADO FROM DETALLE_CONSULTA "   
                 + "WHERE CODIGO_CONSULTA="+ historialPaciente.codigo.getText()+" AND CODIGO_EXAMEN=12  "); 
         
          try (ResultSet res = pstm.executeQuery()) {
              int i = 0;
              while(res.next()){
                  String estUno = res.getString("SOLICITADO");
                  
                  dato[i][0] = estUno;
                  
                  
                  historialPaciente.eBra.setText(estUno);
                 
                  i++;
                  
              }}
          }catch(SQLException e){
         System.out.println(e);
    }
      
      
    return dato;
 }  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
                  
 
                   
 
}
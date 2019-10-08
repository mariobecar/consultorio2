/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mariobecar
 */
public class ConectionDao {
   static String bd = "Consultorio1";//nombre de la base de datos que esta en mysql
   static String login = "consultorio";// usuario
   static String password ="java123";// contraseña
   static String url = "jdbc:derby://localhost:1527/"+bd;

   
   
   Connection conn = null;

   /** Constructor de DbConnection */
   public ConectionDao() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conección a base de datos "+bd+". listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
   
   
   
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
      System.out.println("La conexion a la  base de datos "+bd+" a terminado");
   }

}
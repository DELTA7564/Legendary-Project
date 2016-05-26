/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legendary.project;
import java.sql.*;
/**
 *
 * @author Home
 */
public class DbConnection {
    /**Parametros de conexion*/
   static String bd = "universidad";                                            //nombre de la base de datos
   static String login = "root";                                                //nombre del usuario
   static String password = "gabriele7564";                                     //contraseña del usuario
   static String url = "jdbc:mysql://localhost/"+bd;                            //direccion de la base de datos
 
   Connection connection = null;
 
   /** Constructor de DbConnection */
   public DbConnection() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");                                
         //obtenemos la conexión
         connection = DriverManager.getConnection(url,login,password);          //se realiza la conexion a la BD con mySQL
 
         if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");         //si se realiza exitosamente se imprime en consola
         }
      }
      catch(SQLException e){                                                    //cualquier error, se atrapa su exception y se imprime el error
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){                                           //se devuelve un objeto de tipo connection
      return connection;
   }
 
   public void desconectar(){                                                   //se desconecta
      connection = null;
   }
}

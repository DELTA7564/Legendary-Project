/*
 * Esta clase se encarga de ingresar o consultar los valores hacia la BD
 */
package legendary.project;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Home
 */
public class UsuarioDAO { 
    public void registrarUsuario(UsuarioVO usuario){ //se encarga de ingresar usuarios a la base de datos, recibe un objeto de tipo UsuarioVO como parametro
        DbConnection conex = new DbConnection(); //se establece un objeto para la conexion
        try{
           Statement instruccion = conex.getConnection().createStatement(); //se realiza la conexion
           //se ingresan los valores con una sentencia de tipo SQL y se ejecuta la sentencia
           instruccion.executeUpdate("INSERT INTO USUARIOS VALUES ('"+usuario.getCarne()+"', '"+usuario.getContraseña()+"', '"+usuario.getNombre()+"', '"+usuario.getApellido()+"', '"+usuario.getCorreo()+"')");
           JOptionPane.showMessageDialog(null, "Ingresado", "Informacion", JOptionPane.INFORMATION_MESSAGE); //se despliega un mensaje de ingresado
           instruccion.close(); //se termina la sentancia
           conex.desconectar(); //se desconecta de la BD
        }catch(SQLException e){
            System.out.println(e.getMessage()); //cualquier error se imprime
            JOptionPane.showMessageDialog(null, "Error", "Informacion", JOptionPane.INFORMATION_MESSAGE); //se despliega un mensaje de error
        }
    }
    
    public UsuarioVO consultaUsuario(int carne){ //se encarga de hacer las consultas a la BD posee carne como parametro (int)
        UsuarioVO miUser = new UsuarioVO(); //se crea un objeto UsuarioVO para devolver los datos
        DbConnection conex= new DbConnection(); //se conecta a la BD
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT Contraseña FROM USUARIOS where carne = ?"); //se prepara la sentencia SQL
            consulta.setInt(1, carne);
            ResultSet res = consulta.executeQuery(); //se ejecuta dicha sentancia
            if(res.next()){
                miUser.setContraseña(res.getString("contraseña")); //encuentra el valor deseado y se ingresa en el objeto
            }
            res.close();
            consulta.close(); //se desconecta de la BD
            conex.desconectar();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: Usuario no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE); //si hay un error se imprime
        }
        
        
        return miUser; //se retorna el objeto con los datos ingresados
    }
}
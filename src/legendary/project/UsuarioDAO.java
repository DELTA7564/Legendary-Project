/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legendary.project;

/**
 *
 * @author Home
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    public void RegistrarUsuario(UsuarioVO usuario){
        DbConnection conex = new DbConnection();
        try{
            Statement instruccion = conex.getConnection().createStatement();
            instruccion.executeUpdate("INSERT INTO Usuario VALUES ('"+usuario.getCarne()+"', '"+usuario.getContraseña()+"', '"+usuario.getNombre()+"', '"+usuario.getApellido()+"', '"+usuario.getCorreo()+"'");
            JOptionPane.showMessageDialog(null, "Registrado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            instruccion.close();
            conex.desconectar();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo ingresar el usuario");
        }
    }   
}

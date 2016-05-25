/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public void registrarUsuario(UsuarioVO usuario){
        DbConnection conex = new DbConnection();
        try{
           Statement instruccion = conex.getConnection().createStatement();
           instruccion.executeUpdate("INSERT INTO USUARIOS VALUES ('"+usuario.getCarne()+"', '"+usuario.getContraseña()+"', '"+usuario.getNombre()+"', '"+usuario.getApellido()+"', '"+usuario.getCorreo()+"')");
           JOptionPane.showMessageDialog(null, "Ingresado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
           instruccion.close();
           conex.desconectar();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    } 
}
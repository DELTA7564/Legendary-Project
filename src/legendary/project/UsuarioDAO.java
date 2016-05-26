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
           instruccion.executeUpdate("INSERT INTO USUARIO VALUES ('"+usuario.getCarne()+"', '"+usuario.getContraseña()+"', '"+usuario.getNombre()+"', '"+usuario.getApellido()+"', '"+usuario.getCorreo()+"')");
           JOptionPane.showMessageDialog(null, "Ingresado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
           instruccion.close();
           conex.desconectar();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public UsuarioVO consultaUsuario(int carne){
        UsuarioVO miUser = new UsuarioVO();
        DbConnection conex= new DbConnection();
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT Contraseña FROM USUARIO where carne = ?");
            consulta.setInt(1, carne);
            ResultSet res = consulta.executeQuery();
            if(res.next()){
                miUser.setContraseña(res.getString("contraseña"));
            }
            res.close();
            consulta.close();
            conex.desconectar();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: Usuario no encontrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        return miUser;
    }
}
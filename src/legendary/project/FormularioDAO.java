/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legendary.project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cristobal
 */
public class FormularioDAO {
     public void registrarPersona(FormularioVO Formulario) 
 {
  DbConnection conex= new DbConnection();
  try {
   Statement instruccion = conex.getConnection().createStatement();
   instruccion.executeUpdate("INSERT INTO FORMULARIO VALUES ('"+Formulario.getId()+"', '"
     +Formulario.getHora()+"', '"+Formulario.getDescripcion()+"', '"
     +Formulario.getCarne());
   JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
   instruccion.close();
   conex.desconectar();
    
  } catch (SQLException e) {
            System.out.println(e.getMessage());
   JOptionPane.showMessageDialog(null, "No se Registro la persona");
  }
 }
     
     public ArrayList< FormularioVO> listaDeFormularios() {
  ArrayList< FormularioVO> miFormulario = new ArrayList< FormularioVO>();
  DbConnection conex= new DbConnection();
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona");
   ResultSet res = consulta.executeQuery();
   while(res.next()){
    FormularioVO formulario= new FormularioVO();
    formulario.setId(Integer.parseInt(res.getString("Id")));
    formulario.setHora(Integer.parseInt(res.getString("Hora")));
    formulario.setDescripcion(res.getString("Descripcion"));
    miFormulario.add(formulario);
          }
          res.close();
          consulta.close();
          conex.desconectar();
    
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
  }
  return miFormulario;
 }
 
}


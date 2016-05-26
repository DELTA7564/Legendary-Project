/*
 * Realiza el ingreso de datos y consultas de la tabla formularios
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
     public void registrarFormulario(FormularioVO Formulario) //funcion que se encarga de ingresar formularios, resive un objeto Formulario como entrada
 {
  DbConnection conex= new DbConnection(); //se crea un objeto para la conexion
  try {
   Statement instruccion = conex.getConnection().createStatement(); //se realiza la conexion
   instruccion.executeUpdate("INSERT INTO FORMULARIO VALUES ('"+Formulario.getId()+"', '"
     +Formulario.getHora()+"', '"+Formulario.getDescripcion()+"', '"
     +Formulario.getCarne()+"')"); //se escribe la sentancia para el ingreso de datos y se ejecuta
   JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE); //se despliega un mensaje de ingreso
   instruccion.close();
   conex.desconectar(); //se cierra la conexion
    
  } catch (SQLException e) {
            System.out.println(e.getMessage());
   JOptionPane.showMessageDialog(null, "No se Registro la persona"); //si existe un error se hace un mensaje
  }
 }
     
     public ArrayList< FormularioVO> listaDeFormularios(int carne) { //devuelve una lista de formularios
  ArrayList<FormularioVO> miFormulario = new ArrayList< FormularioVO>(); //se crea una lista de objeto formularioVO
  DbConnection conex= new DbConnection(); //se crea un objeto para la conexion
     
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM FORMULARIO WHERE carne = ?"); //se realiza la sentencia de consulta
   consulta.setInt(1, carne);
   ResultSet res = consulta.executeQuery(); //se ejecuta la sentencia
   while(res.next()){ //y se llena la lista de datos mientras existan valores en la tabla que cumplan con la sentencia 
    FormularioVO formulario= new FormularioVO();
    formulario.setId(Integer.parseInt(res.getString("Id")));
    
    formulario.setHora(Integer.parseInt(res.getString("Hora")));
    
    formulario.setDescripcion(res.getString("Descripcion"));
   
    miFormulario.add(formulario); //se agregan los objetos a la lista
    
          }
          res.close();
          consulta.close();
          conex.desconectar(); //se desconecta
    
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
  }
  return miFormulario; //se devuelve la lista
 }
 
}


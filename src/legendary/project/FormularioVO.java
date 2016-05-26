/*
 * Esta clase tiene como objetivo llenar los datos para formulario
 */
package legendary.project;

/**
 *
 * @author cristobal
 */
public class FormularioVO{
 //encapsulación de las variables
 private Integer Id;
 private Integer Hora;
 private String Descripcion;
 private Integer Carne;
  
 /**
  * @return the idPersona
  */
 public Integer getId() {
  return Id;
 }
 /**
  * @param idPersona the idPersona to set
  */
 public void setId(Integer Id) {
  this.Id = Id;
 }
 /**
  * @return the nombrePersona
  */
 public Integer getHora() {
  return Hora;
 }
 /**
  * @param nombrePersona the nombrePersona to set
  */
 public void setHora(Integer Hora) {
  this.Hora = Hora;
 }
 /**
  * @return the edadPersona
  */
 public String getDescripcion() {
  return Descripcion;
 }
 /**
  * @param edadPersona the edadPersona to set
  */
 public void setDescripcion(String Descripcion) {
  this.Descripcion = Descripcion;
 }
 /**
  * @return the profesionPersona
  */
 public Integer getCarne() {
  return Carne;
 }
 /**
  * @param profesionPersona the profesionPersona to set
  */
 public void setCarne(Integer Carne) {
  this.Carne = Carne;
 }
 /**
  * @return the telefonoPersona
  */
 
}

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
public class UsuarioVO {
    
    private int carne;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String correo;
    
    public int getCarne(){
        return carne;
    }
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return nombre;
    }
    
    public String getContraseña(){
        return nombre;
    }
    
    public String getCorreo(){
        return nombre;
    }
    
    public void setCarne(int carne){
        this.carne = carne;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
}

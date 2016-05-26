/*
 * Esta clase tiene como objeto llenar la informacion para usuario y que sea de
 * facil acceso
 */
package legendary.project;

/**
 *
 * @author Home
 */
public class UsuarioVO {
    //ecapsulacion
    private int carne;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String correo;
    
    //getters
    public int getCarne(){
        return carne;
    }
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    //setters
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

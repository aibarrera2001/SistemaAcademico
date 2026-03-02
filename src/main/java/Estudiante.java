/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademico;
/**
 *
 * @author Andrés
 */
public class Estudiante {
    
    private String codigo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    public Estudiante(String codigo, String nombre, String apellido, String email, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    @Override
    public String toString() {
        return "┌─ Estudiante ─────────────────────────\n"
             + "│  Código   : " + codigo + "\n"
             + "│  Nombre   : " + nombre + " " + apellido + "\n"
             + "│  Email    : " + email + "\n"
             + "│  Teléfono : " + telefono + "\n"
             + "└───────────────────────────────────────";
    }
}

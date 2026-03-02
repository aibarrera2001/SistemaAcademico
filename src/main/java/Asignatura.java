/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademico;
/**
 *
 * @author Andrés
 */
public class Asignatura {
     private String codigo;
    private String nombre;
    private int creditos;
    private String docente;
    
    // Constructor
    public Asignatura(String codigo, String nombre, int creditos, String docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
    public String getDocente() { return docente; }

    // Setters
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public void setDocente(String docente) { this.docente = docente; }

    // toString
    @Override
    public String toString() {
        return "┌─ Asignatura ─────────────────────────\n"
             + "│  Código   : " + codigo + "\n"
             + "│  Nombre   : " + nombre + "\n"
             + "│  Créditos : " + creditos + "\n"
             + "│  Docente  : " + docente + "\n"
             + "└───────────────────────────────────────";
    }
}

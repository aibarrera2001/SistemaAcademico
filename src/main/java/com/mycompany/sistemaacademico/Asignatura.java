package com.mycompany.sistemaacademico;

public class Asignatura {

    private String codigo;
    private String nombre;
    private int creditos;
    private String docente;

    public Asignatura(String codigo, String nombre, int creditos, String docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
    public String getDocente() { return docente; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public void setDocente(String docente) { this.docente = docente; }

    @Override
    public String toString() {
        return "┌─ Asignatura ─────────────────────────\n"
             + "│  Codigo   : " + codigo + "\n"
             + "│  Nombre   : " + nombre + "\n"
             + "│  Creditos : " + creditos + "\n"
             + "│  Docente  : " + docente + "\n"
             + "└───────────────────────────────────────";
    }
}
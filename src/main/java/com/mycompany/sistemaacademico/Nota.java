package com.mycompany.sistemaacademico;

public class Nota {

    private int id;
    private String codigoEstudiante;
    private String codigoAsignatura;
    private double nota1;
    private double nota2;
    private double nota3;
    private double definitiva;

    public Nota(int id, String codigoEstudiante, String codigoAsignatura,
                double nota1, double nota2, double nota3) {
        this.id = id;
        this.codigoEstudiante = codigoEstudiante;
        this.codigoAsignatura = codigoAsignatura;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.definitiva = calcularDefinitiva();
    }

    private double calcularDefinitiva() {
        return (nota1 + nota2 + nota3) / 3;
    }

    private void recalcular() {
        this.definitiva = calcularDefinitiva();
    }

    public int getId() { return id; }
    public String getCodigoEstudiante() { return codigoEstudiante; }
    public String getCodigoAsignatura() { return codigoAsignatura; }
    public double getNota1() { return nota1; }
    public double getNota2() { return nota2; }
    public double getNota3() { return nota3; }
    public double getDefinitiva() { return definitiva; }

    public void setId(int id) { this.id = id; }
    public void setCodigoEstudiante(String cod) { this.codigoEstudiante = cod; }
    public void setCodigoAsignatura(String cod) { this.codigoAsignatura = cod; }
    public void setNota1(double nota1) { this.nota1 = nota1; recalcular(); }
    public void setNota2(double nota2) { this.nota2 = nota2; recalcular(); }
    public void setNota3(double nota3) { this.nota3 = nota3; recalcular(); }

    @Override
    public String toString() {
        String estado = definitiva >= 3.0 ? "APROBADO" : "REPROBADO";
        return "┌─ Nota ────────────────────────────────\n"
             + "│  ID           : " + id + "\n"
             + "│  Estudiante   : " + codigoEstudiante + "\n"
             + "│  Asignatura   : " + codigoAsignatura + "\n"
             + "│  Nota 1       : " + String.format("%.1f", nota1) + "\n"
             + "│  Nota 2       : " + String.format("%.1f", nota2) + "\n"
             + "│  Nota 3       : " + String.format("%.1f", nota3) + "\n"
             + "│  Definitiva   : " + String.format("%.2f", definitiva) + "\n"
             + "│  Estado       : " + estado + "\n"
             + "└───────────────────────────────────────";
    }
}
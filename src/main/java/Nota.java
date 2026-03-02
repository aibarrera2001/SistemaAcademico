/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademico;
/**
 *
 * @author Andrés
 */
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

    // Calcula automáticamente el promedio
    private double calcularDefinitiva() {
        return (nota1 + nota2 + nota3) / 3;
    }

    // Getters
    public int getId() { return id; }
    public String getCodigoEstudiante() { return codigoEstudiante; }
    public String getCodigoAsignatura() { return codigoAsignatura; }
    public double getNota1() { return nota1; }
    public double getNota2() { return nota2; }
    public double getNota3() { return nota3; }
    public double getDefinitiva() { return definitiva; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setCodigoEstudiante(String codigoEstudiante) { this.codigoEstudiante = codigoEstudiante; }
    public void setCodigoAsignatura(String codigoAsignatura) { this.codigoAsignatura = codigoAsignatura; }
    public void setNota1(double nota1) { this.nota1 = nota1; recalcular(); }
    public void setNota2(double nota2) { this.nota2 = nota2; recalcular(); }
    public void setNota3(double nota3) { this.nota3 = nota3; recalcular(); }

    private void recalcular() {
        this.definitiva = calcularDefinitiva();
}
    
    // ══════════════════════════════════════════════════════════════════════════
    //  CRUD NOTA
    // ══════════════════════════════════════════════════════════════════════════

    public static void registrarNota() {
        System.out.println("\n── Registrar Nota ────────────────────────");
        System.out.print("  Código del estudiante  : "); String codEst = sc.nextLine().trim();
        if (!existeEstudiante(codEst)) {
            System.out.println("  ✖ Estudiante no encontrado.");
            return;
        }
        System.out.print("  Código de la asignatura: "); String codAsig = sc.nextLine().trim();
        if (!existeAsignatura(codAsig)) {
            System.out.println("  ✖ Asignatura no encontrada.");
            return;
        }
        System.out.print("  Nota 1 (0.0 - 5.0): "); double n1 = leerDouble();
        System.out.print("  Nota 2 (0.0 - 5.0): "); double n2 = leerDouble();
        System.out.print("  Nota 3 (0.0 - 5.0): "); double n3 = leerDouble();

        Nota nueva = new Nota(contadorNotas++, codEst, codAsig, n1, n2, n3);
        notas.add(nueva);
        System.out.println("  ✔ Nota registrada. Definitiva: " + String.format("%.2f", nueva.getDefinitiva()));
    }
    
        public static void listarNotas() {
        System.out.println("\n── Lista de Notas ────────────────────────");
        if (notas.isEmpty()) {
            System.out.println("  No hay notas registradas.");
            return;
        }
        for (Nota n : notas) {
            System.out.println(n);
        }
        System.out.println("  Total: " + notas.size() + " nota(s).");
    }

    public static void buscarNota() {
        System.out.println("\n── Buscar Nota ───────────────────────────");
        System.out.print("  ID de la nota: ");
        int id = leerEntero("");
        Nota n = obtenerNota(id);
        if (n != null) {
            System.out.println(n);
        } else {
            System.out.println("  ✖ Nota no encontrada.");
        }
    }
    
        public static void actualizarNota() {
        System.out.println("\n── Actualizar Nota ───────────────────────");
        System.out.print("  ID de la nota a actualizar: ");
        int id = leerEntero("");
        Nota n = obtenerNota(id);
        if (n == null) {
            System.out.println("  ✖ Nota no encontrada.");
            return;
        }
        System.out.println("  (Enter para mantener el valor actual)");
        System.out.print("  Nueva Nota 1 [" + n.getNota1() + "]: ");
        String s1 = sc.nextLine().trim();
        System.out.print("  Nueva Nota 2 [" + n.getNota2() + "]: ");
        String s2 = sc.nextLine().trim();
        System.out.print("  Nueva Nota 3 [" + n.getNota3() + "]: ");
        String s3 = sc.nextLine().trim();

        if (!s1.isEmpty()) n.setNota1(Double.parseDouble(s1));
        if (!s2.isEmpty()) n.setNota2(Double.parseDouble(s2));
        if (!s3.isEmpty()) n.setNota3(Double.parseDouble(s3));

        System.out.println("  ✔ Nota actualizada. Nueva definitiva: " + String.format("%.2f", n.getDefinitiva()));
    }
}

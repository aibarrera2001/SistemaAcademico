package com.mycompany.sistemaacademico;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static ArrayList<Nota>       notas       = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int contadorNotas = 1;

    // ══════════════════════════════════════════════════════════════════════════
    //  MAIN
    // ══════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1:  registrarEstudiante();   break;
                case 2:  listarEstudiantes();     break;
                case 3:  buscarEstudiante();      break;
                case 4:  actualizarEstudiante();  break;
                case 5:  eliminarEstudiante();    break;
                case 6:  registrarAsignatura();   break;
                case 7:  listarAsignaturas();     break;
                case 8:  buscarAsignatura();      break;
                case 9:  actualizarAsignatura();  break;
                case 10: eliminarAsignatura();    break;
                case 11: registrarNota();         break;
                case 12: listarNotas();           break;
                case 13: buscarNota();            break;
                case 14: actualizarNota();        break;
                case 15: eliminarNota();          break;
                case 0:
                    System.out.println("\n  Hasta luego! Sistema cerrado.\n");
                    break;
                default:
                    System.out.println("  Opcion no valida.");
            }
        } while (opcion != 0);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENU
    // ══════════════════════════════════════════════════════════════════════════
    public static void mostrarMenu() {
        System.out.println("\n==========================================");
        System.out.println("       SISTEMA ACADEMICO - UPC");
        System.out.println("==========================================");
        System.out.println("  -- ESTUDIANTES --");
        System.out.println("   1. Registrar estudiante");
        System.out.println("   2. Listar estudiantes");
        System.out.println("   3. Buscar estudiante");
        System.out.println("   4. Actualizar estudiante");
        System.out.println("   5. Eliminar estudiante");
        System.out.println("  -- ASIGNATURAS --");
        System.out.println("   6. Registrar asignatura");
        System.out.println("   7. Listar asignaturas");
        System.out.println("   8. Buscar asignatura");
        System.out.println("   9. Actualizar asignatura");
        System.out.println("  10. Eliminar asignatura");
        System.out.println("  -- NOTAS --");
        System.out.println("  11. Registrar nota");
        System.out.println("  12. Listar notas");
        System.out.println("  13. Buscar nota");
        System.out.println("  14. Actualizar nota");
        System.out.println("  15. Eliminar nota");
        System.out.println("==========================================");
        System.out.println("   0. Salir");
        System.out.println("==========================================");
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  CRUD ESTUDIANTE
    // ══════════════════════════════════════════════════════════════════════════
    public static void registrarEstudiante() {
        System.out.println("\n-- Registrar Estudiante --");
        System.out.print("  Codigo   : "); String codigo = sc.nextLine().trim();
        if (existeEstudiante(codigo)) {
            System.out.println("  Ya existe un estudiante con ese codigo.");
            return;
        }
        System.out.print("  Nombre   : "); String nombre = sc.nextLine().trim();
        System.out.print("  Apellido : "); String apellido = sc.nextLine().trim();
        System.out.print("  Email    : "); String email = sc.nextLine().trim();
        System.out.print("  Telefono : "); String telefono = sc.nextLine().trim();
        estudiantes.add(new Estudiante(codigo, nombre, apellido, email, telefono));
        System.out.println("  Estudiante registrado exitosamente.");
    }

    public static void listarEstudiantes() {
        System.out.println("\n-- Lista de Estudiantes --");
        if (estudiantes.isEmpty()) { System.out.println("  No hay estudiantes registrados."); return; }
        for (Estudiante e : estudiantes) System.out.println(e);
        System.out.println("  Total: " + estudiantes.size() + " estudiante(s).");
    }

    public static void buscarEstudiante() {
        System.out.println("\n-- Buscar Estudiante --");
        System.out.print("  Codigo: "); String codigo = sc.nextLine().trim();
        Estudiante e = obtenerEstudiante(codigo);
        if (e != null) System.out.println(e);
        else System.out.println("  Estudiante no encontrado.");
    }

    public static void actualizarEstudiante() {
        System.out.println("\n-- Actualizar Estudiante --");
        System.out.print("  Codigo del estudiante: "); String codigo = sc.nextLine().trim();
        Estudiante e = obtenerEstudiante(codigo);
        if (e == null) { System.out.println("  Estudiante no encontrado."); return; }
        System.out.println("  (Enter para mantener el valor actual)");
        System.out.print("  Nuevo nombre [" + e.getNombre() + "]: "); String nombre = sc.nextLine().trim();
        System.out.print("  Nuevo apellido [" + e.getApellido() + "]: "); String apellido = sc.nextLine().trim();
        System.out.print("  Nuevo email [" + e.getEmail() + "]: "); String email = sc.nextLine().trim();
        System.out.print("  Nuevo telefono [" + e.getTelefono() + "]: "); String telefono = sc.nextLine().trim();
        if (!nombre.isEmpty())   e.setNombre(nombre);
        if (!apellido.isEmpty()) e.setApellido(apellido);
        if (!email.isEmpty())    e.setEmail(email);
        if (!telefono.isEmpty()) e.setTelefono(telefono);
        System.out.println("  Estudiante actualizado exitosamente.");
    }

    public static void eliminarEstudiante() {
        System.out.println("\n-- Eliminar Estudiante --");
        System.out.print("  Codigo: "); String codigo = sc.nextLine().trim();
        Estudiante e = obtenerEstudiante(codigo);
        if (e == null) { System.out.println("  Estudiante no encontrado."); return; }
        System.out.print("  Confirmar eliminacion de " + e.getNombre() + "? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            estudiantes.remove(e);
            System.out.println("  Estudiante eliminado.");
        } else System.out.println("  Operacion cancelada.");
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  CRUD ASIGNATURA
    // ══════════════════════════════════════════════════════════════════════════
    public static void registrarAsignatura() {
        System.out.println("\n-- Registrar Asignatura --");
        System.out.print("  Codigo   : "); String codigo = sc.nextLine().trim();
        if (existeAsignatura(codigo)) { System.out.println("  Ya existe esa asignatura."); return; }
        System.out.print("  Nombre   : "); String nombre = sc.nextLine().trim();
        System.out.print("  Creditos : "); int creditos = leerEntero("");
        System.out.print("  Docente  : "); String docente = sc.nextLine().trim();
        asignaturas.add(new Asignatura(codigo, nombre, creditos, docente));
        System.out.println("  Asignatura registrada exitosamente.");
    }

    public static void listarAsignaturas() {
        System.out.println("\n-- Lista de Asignaturas --");
        if (asignaturas.isEmpty()) { System.out.println("  No hay asignaturas registradas."); return; }
        for (Asignatura a : asignaturas) System.out.println(a);
        System.out.println("  Total: " + asignaturas.size() + " asignatura(s).");
    }

    public static void buscarAsignatura() {
        System.out.println("\n-- Buscar Asignatura --");
        System.out.print("  Codigo: "); String codigo = sc.nextLine().trim();
        Asignatura a = obtenerAsignatura(codigo);
        if (a != null) System.out.println(a);
        else System.out.println("  Asignatura no encontrada.");
    }

    public static void actualizarAsignatura() {
        System.out.println("\n-- Actualizar Asignatura --");
        System.out.print("  Codigo: "); String codigo = sc.nextLine().trim();
        Asignatura a = obtenerAsignatura(codigo);
        if (a == null) { System.out.println("  Asignatura no encontrada."); return; }
        System.out.println("  (Enter para mantener el valor actual)");
        System.out.print("  Nuevo nombre [" + a.getNombre() + "]: "); String nombre = sc.nextLine().trim();
        System.out.print("  Nuevos creditos [" + a.getCreditos() + "]: "); String cred = sc.nextLine().trim();
        System.out.print("  Nuevo docente [" + a.getDocente() + "]: "); String docente = sc.nextLine().trim();
        if (!nombre.isEmpty())  a.setNombre(nombre);
        if (!cred.isEmpty())    a.setCreditos(Integer.parseInt(cred));
        if (!docente.isEmpty()) a.setDocente(docente);
        System.out.println("  Asignatura actualizada exitosamente.");
    }

    public static void eliminarAsignatura() {
        System.out.println("\n-- Eliminar Asignatura --");
        System.out.print("  Codigo: "); String codigo = sc.nextLine().trim();
        Asignatura a = obtenerAsignatura(codigo);
        if (a == null) { System.out.println("  Asignatura no encontrada."); return; }
        System.out.print("  Confirmar eliminacion de " + a.getNombre() + "? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            asignaturas.remove(a);
            System.out.println("  Asignatura eliminada.");
        } else System.out.println("  Operacion cancelada.");
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  CRUD NOTA
    // ══════════════════════════════════════════════════════════════════════════
    public static void registrarNota() {
        System.out.println("\n-- Registrar Nota --");
        System.out.print("  Codigo estudiante  : "); String codEst = sc.nextLine().trim();
        if (!existeEstudiante(codEst)) { System.out.println("  Estudiante no encontrado."); return; }
        System.out.print("  Codigo asignatura  : "); String codAsig = sc.nextLine().trim();
        if (!existeAsignatura(codAsig)) { System.out.println("  Asignatura no encontrada."); return; }
        System.out.print("  Nota 1 (0.0-5.0): "); double n1 = leerDouble();
        System.out.print("  Nota 2 (0.0-5.0): "); double n2 = leerDouble();
        System.out.print("  Nota 3 (0.0-5.0): "); double n3 = leerDouble();
        Nota nueva = new Nota(contadorNotas++, codEst, codAsig, n1, n2, n3);
        notas.add(nueva);
        System.out.println("  Nota registrada. Definitiva: " + String.format("%.2f", nueva.getDefinitiva()));
    }

    public static void listarNotas() {
        System.out.println("\n-- Lista de Notas --");
        if (notas.isEmpty()) { System.out.println("  No hay notas registradas."); return; }
        for (Nota n : notas) System.out.println(n);
        System.out.println("  Total: " + notas.size() + " nota(s).");
    }

    public static void buscarNota() {
        System.out.println("\n-- Buscar Nota --");
        System.out.print("  ID de la nota: "); int id = leerEntero("");
        Nota n = obtenerNota(id);
        if (n != null) System.out.println(n);
        else System.out.println("  Nota no encontrada.");
    }

    public static void actualizarNota() {
        System.out.println("\n-- Actualizar Nota --");
        System.out.print("  ID de la nota: "); int id = leerEntero("");
        Nota n = obtenerNota(id);
        if (n == null) { System.out.println("  Nota no encontrada."); return; }
        System.out.println("  (Enter para mantener el valor actual)");
        System.out.print("  Nueva Nota 1 [" + n.getNota1() + "]: "); String s1 = sc.nextLine().trim();
        System.out.print("  Nueva Nota 2 [" + n.getNota2() + "]: "); String s2 = sc.nextLine().trim();
        System.out.print("  Nueva Nota 3 [" + n.getNota3() + "]: "); String s3 = sc.nextLine().trim();
        if (!s1.isEmpty()) n.setNota1(Double.parseDouble(s1));
        if (!s2.isEmpty()) n.setNota2(Double.parseDouble(s2));
        if (!s3.isEmpty()) n.setNota3(Double.parseDouble(s3));
        System.out.println("  Nota actualizada. Definitiva: " + String.format("%.2f", n.getDefinitiva()));
    }

    public static void eliminarNota() {
        System.out.println("\n-- Eliminar Nota --");
        System.out.print("  ID de la nota: "); int id = leerEntero("");
        Nota n = obtenerNota(id);
        if (n == null) { System.out.println("  Nota no encontrada."); return; }
        System.out.print("  Confirmar eliminacion de nota ID " + id + "? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            notas.remove(n);
            System.out.println("  Nota eliminada.");
        } else System.out.println("  Operacion cancelada.");
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  AUXILIARES
    // ══════════════════════════════════════════════════════════════════════════
    private static boolean existeEstudiante(String codigo) { return obtenerEstudiante(codigo) != null; }
    private static boolean existeAsignatura(String codigo) { return obtenerAsignatura(codigo) != null; }

    private static Estudiante obtenerEstudiante(String codigo) {
        for (Estudiante e : estudiantes)
            if (e.getCodigo().equalsIgnoreCase(codigo)) return e;
        return null;
    }

    private static Asignatura obtenerAsignatura(String codigo) {
        for (Asignatura a : asignaturas)
            if (a.getCodigo().equalsIgnoreCase(codigo)) return a;
        return null;
    }

    private static Nota obtenerNota(int id) {
        for (Nota n : notas)
            if (n.getId() == id) return n;
        return null;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                if (!mensaje.isEmpty()) System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("  Ingrese un numero entero valido: ");
            }
        }
    }

    private static double leerDouble() {
        while (true) {
            try {
                double v = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
                if (v < 0.0 || v > 5.0) System.out.print("  Debe estar entre 0.0 y 5.0: ");
                else return v;
            } catch (NumberFormatException e) {
                System.out.print("  Numero invalido (ej: 3.5): ");
            }
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaacademico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andrés
 */
public class SistemaAcademico {

// ─── ArrayLists globales ───────────────────────────────────────────────────
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static ArrayList<Nota>       notas       = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int contadorNotas = 1;
    public static void main(String[] args) {
        System.out.println("Hello World!");

    // ══════════════════════════════════════════════════════════════════════════
    //  CRUD ASIGNATURA
    // ══════════════════════════════════════════════════════════════════════════

    public static void registrarAsignatura() {
        System.out.println("\n── Registrar Asignatura ──────────────────");
        System.out.print("  Código     : "); String codigo = sc.nextLine().trim();
        if (existeAsignatura(codigo)) {
            System.out.println("  ✖ Ya existe una asignatura con ese código.");
            return;
        }
        System.out.print("  Nombre     : "); String nombre = sc.nextLine().trim();
        System.out.print("  Créditos   : "); int creditos = leerEntero("");
        System.out.print("  Docente    : "); String docente = sc.nextLine().trim();

        asignaturas.add(new Asignatura(codigo, nombre, creditos, docente));
        System.out.println("  ✔ Asignatura registrada exitosamente.");
    }
    
     public static void listarAsignaturas() {
        System.out.println("\n── Lista de Asignaturas ──────────────────");
        if (asignaturas.isEmpty()) {
            System.out.println("  No hay asignaturas registradas.");
            return;
        }
        for (Asignatura a : asignaturas) {
            System.out.println(a);
        }
        System.out.println("  Total: " + asignaturas.size() + " asignatura(s).");
    }

    public static void buscarAsignatura() {
        System.out.println("\n── Buscar Asignatura ─────────────────────");
        System.out.print("  Código de la asignatura: ");
        String codigo = sc.nextLine().trim();
        Asignatura a = obtenerAsignatura(codigo);
        if (a != null) {
            System.out.println(a);
        } else {
            System.out.println("  ✖ Asignatura no encontrada.");
        }
    }
    
        public static void actualizarAsignatura() {
        System.out.println("\n── Actualizar Asignatura ─────────────────");
        System.out.print("  Código de la asignatura a actualizar: ");
        String codigo = sc.nextLine().trim();
        Asignatura a = obtenerAsignatura(codigo);
        if (a == null) {
            System.out.println("  ✖ Asignatura no encontrada.");
            return;
        }
        System.out.println("  (Enter para mantener el valor actual)");
        System.out.print("  Nuevo nombre [" + a.getNombre() + "]: ");
        String nombre = sc.nextLine().trim();
        System.out.print("  Nuevos créditos [" + a.getCreditos() + "]: ");
        String cred = sc.nextLine().trim();
        System.out.print("  Nuevo docente [" + a.getDocente() + "]: ");
        String docente = sc.nextLine().trim();

        if (!nombre.isEmpty())  a.setNombre(nombre);
        if (!cred.isEmpty())    a.setCreditos(Integer.parseInt(cred));
        if (!docente.isEmpty()) a.setDocente(docente);

        System.out.println("  ✔ Asignatura actualizada exitosamente.");
    }
        
         public static void eliminarAsignatura() {
        System.out.println("\n── Eliminar Asignatura ───────────────────");
        System.out.print("  Código de la asignatura a eliminar: ");
        String codigo = sc.nextLine().trim();
        Asignatura a = obtenerAsignatura(codigo);
        if (a == null) {
            System.out.println("  ✖ Asignatura no encontrada.");
            return;
        }
        System.out.print("  ¿Confirmar eliminación de " + a.getNombre() + "? (s/n): ");
        String conf = sc.nextLine().trim();
        if (conf.equalsIgnoreCase("s")) {
            asignaturas.remove(a);
            System.out.println("  ✔ Asignatura eliminada exitosamente.");
        } else {
            System.out.println("  Operación cancelada.");
        }
    }

    }

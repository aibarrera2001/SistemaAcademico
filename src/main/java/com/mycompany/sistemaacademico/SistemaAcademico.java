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
    
    public class main{
        
       
    
    
    // ─── ArrayLists globales ───────────────────────────────────────────────────
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static ArrayList<Nota>       notas       = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int contadorNotas = 1;
    
    

    public static void main(String[] args) {
         int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                // ── ESTUDIANTES ──────────────────────────────────────────────
                case 1:  registrarEstudiante();   break;
                case 2:  listarEstudiantes();     break;
                case 3:  buscarEstudiante();      break;
                case 4:  actualizarEstudiante();  break;
                case 5:  eliminarEstudiante();    break;
                // ── ASIGNATURAS ──────────────────────────────────────────────
                case 6:  registrarAsignatura();   break;
                case 7:  listarAsignaturas();     break;
                case 8:  buscarAsignatura();      break;
                case 9:  actualizarAsignatura();  break;
                case 10: eliminarAsignatura();    break;
                // ── NOTAS ────────────────────────────────────────────────────
                case 11: registrarNota();         break;
                case 12: listarNotas();           break;
                case 13: buscarNota();            break;
                case 14: actualizarNota();        break;
                case 15: eliminarNota();          break;
                // ── SALIR ────────────────────────────────────────────────────
                case 0:
                    System.out.println("\n  ¡Hasta luego! Sistema cerrado.\n");
                    break;
                default:
                    System.out.println("  ✖ Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENÚ PRINCIPAL
    // ══════════════════════════════════════════════════════════════════════════
    public static void mostrarMenu() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║      SISTEMA ACADÉMICO - UPC             ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  ── ESTUDIANTES ─────────────────────── ║");
        System.out.println("║   1. Registrar estudiante                ║");
        System.out.println("║   2. Listar estudiantes                  ║");
        System.out.println("║   3. Buscar estudiante                   ║");
        System.out.println("║   4. Actualizar estudiante               ║");
        System.out.println("║   5. Eliminar estudiante                 ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  ── ASIGNATURAS ─────────────────────── ║");
        System.out.println("║   6. Registrar asignatura                ║");
        System.out.println("║   7. Listar asignaturas                  ║");
        System.out.println("║   8. Buscar asignatura                   ║");
        System.out.println("║   9. Actualizar asignatura               ║");
        System.out.println("║  10. Eliminar asignatura                 ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  ── NOTAS ───────────────────────────── ║");
        System.out.println("║  11. Registrar nota                      ║");
        System.out.println("║  12. Listar notas                        ║");
        System.out.println("║  13. Buscar nota                         ║");
        System.out.println("║  14. Actualizar nota                     ║");
        System.out.println("║  15. Eliminar nota                       ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║   0. Salir                               ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
    // ══════════════════════════════════════════════════════════════════════════
    //  CRUD ESTUDIANTE
    // ══════════════════════════════════════════════════════════════════════════

    public static void registrarEstudiante() {
        System.out.println("\n── Registrar Estudiante ──────────────────");
        System.out.print("  Código     : "); String codigo = sc.nextLine().trim();
        if (existeEstudiante(codigo)) {
            System.out.println("  ✖ Ya existe un estudiante con ese código.");
            return;
        }
        System.out.print("  Nombre     : "); String nombre = sc.nextLine().trim();
        System.out.print("  Apellido   : "); String apellido = sc.nextLine().trim();
        System.out.print("  Email      : "); String email = sc.nextLine().trim();
        System.out.print("  Teléfono   : "); String telefono = sc.nextLine().trim();

        estudiantes.add(new Estudiante(codigo, nombre, apellido, email, telefono));
        System.out.println("  ✔ Estudiante registrado exitosamente.");
    }
 public static void listarEstudiantes() {
        System.out.println("\n── Lista de Estudiantes ──────────────────");
        if (estudiantes.isEmpty()) {
            System.out.println("  No hay estudiantes registrados.");
            return;
        }
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
        System.out.println("  Total: " + estudiantes.size() + " estudiante(s).");
    }

    public static void buscarEstudiante() {
        System.out.println("\n── Buscar Estudiante ─────────────────────");
        System.out.print("  Código del estudiante: ");
        String codigo = sc.nextLine().trim();
        Estudiante e = obtenerEstudiante(codigo);
        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("  ✖ Estudiante no encontrado.");
        }
    }
 public static void actualizarEstudiante() {
        System.out.println("\n── Actualizar Estudiante ─────────────────");
        System.out.print("  Código del estudiante a actualizar: ");
        String codigo = sc.nextLine().trim();
        Estudiante e = obtenerEstudiante(codigo);
        if (e == null) {
            System.out.println("  ✖ Estudiante no encontrado.");
            return;
        }
        System.out.println("  (Enter para mantener el valor actual)");
        System.out.print("  Nuevo nombre [" + e.getNombre() + "]: ");
        String nombre = sc.nextLine().trim();
        System.out.print("  Nuevo apellido [" + e.getApellido() + "]: ");
        String apellido = sc.nextLine().trim();
        System.out.print("  Nuevo email [" + e.getEmail() + "]: ");
        String email = sc.nextLine().trim();
        System.out.print("  Nuevo teléfono [" + e.getTelefono() + "]: ");
        String telefono = sc.nextLine().trim();

        if (!nombre.isEmpty())   e.setNombre(nombre);
        if (!apellido.isEmpty()) e.setApellido(apellido);
        if (!email.isEmpty())    e.setEmail(email);
        if (!telefono.isEmpty()) e.setTelefono(telefono);

        System.out.println("  ✔ Estudiante actualizado exitosamente.");
    }

  public static void eliminarEstudiante() {
        System.out.println("\n── Eliminar Estudiante ───────────────────");
        System.out.print("  Código del estudiante a eliminar: ");
        String codigo = sc.nextLine().trim();
        Estudiante e = obtenerEstudiante(codigo);
        if (e == null) {
            System.out.println("  ✖ Estudiante no encontrado.");
            return;
        }
        System.out.print("  ¿Confirmar eliminación de " + e.getNombre() + " " + e.getApellido() + "? (s/n): ");
        String conf = sc.nextLine().trim();
        if (conf.equalsIgnoreCase("s")) {
            estudiantes.remove(e);
            System.out.println("  ✔ Estudiante eliminado exitosamente.");
        } else {
            System.out.println("  Operación cancelada.");
        }
    }

  
    
    }
    }


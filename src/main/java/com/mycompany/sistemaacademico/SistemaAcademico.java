/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaacademico;

/**
 *
 * @author Andrés
 */
public class SistemaAcademico {
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
    }

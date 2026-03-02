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
    }
}

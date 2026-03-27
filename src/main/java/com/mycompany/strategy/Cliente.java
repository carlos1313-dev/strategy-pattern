/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.strategy;

import com.mycompany.strategy.model.Ruta;
import com.mycompany.strategy.strategy.EstrategiaBicicleta;
import com.mycompany.strategy.strategy.EstrategiaCaminata;
import com.mycompany.strategy.strategy.EstrategiaDeCarretera;
import com.mycompany.strategy.strategy.EstrategiaTransportePublico;
import com.mycompany.strategy.strategy.EstrategiaTuristica;
import java.util.Scanner;

/**
 * Cliente: Punto de entrada de la aplicación de navegación.
 *
 * El cliente es el único lugar donde se crean las estrategias concretas
 * y se inyectan en el Navegador. Esto respeta el principio abierto/cerrado:
 * añadir un nuevo modo de transporte sólo requiere crear una nueva clase
 * que implemente EstrategiaDeRuta y registrarla aquí.
 */
public class Cliente {

    // Constantes de menú
    private static final int MODO_CARRETERA          = 1;
    private static final int MODO_CAMINATA           = 2;
    private static final int MODO_TRANSPORTE_PUBLICO = 3;
    private static final int MODO_BICICLETA          = 4;
    private static final int MODO_TURISTICO          = 5;
    private static final int CALCULAR_RUTA           = 6;
    private static final int SALIR                   = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        imprimirBienvenida();

        // ── Configuración inicial: Navegador con estrategia por defecto ──────
        Navegador navegador = new Navegador(new EstrategiaDeCarretera());
        String modoActual = "🚗  Carretera";

        boolean ejecutando = true;

        while (ejecutando) {
            imprimirMenu(modoActual);
            int opcion = leerOpcion(scanner);

            switch (opcion) {
                case MODO_CARRETERA -> {
                    navegador.setEstrategiaDeRuta(new EstrategiaDeCarretera());
                    modoActual = " Carretera";
                }
                case MODO_CAMINATA -> {
                    navegador.setEstrategiaDeRuta(new EstrategiaCaminata());
                    modoActual = " A pie";
                }
                case MODO_TRANSPORTE_PUBLICO -> {
                    navegador.setEstrategiaDeRuta(new EstrategiaTransportePublico());
                    modoActual = " Transporte Público";
                }
                case MODO_BICICLETA -> {
                    navegador.setEstrategiaDeRuta(new EstrategiaBicicleta());
                    modoActual = " Bicicleta";
                }
                case MODO_TURISTICO -> {
                    navegador.setEstrategiaDeRuta(new EstrategiaTuristica());
                    modoActual = " Turística";
                }
                case CALCULAR_RUTA -> {
                    calcularYMostrarRuta(scanner, navegador);
                }
                case SALIR -> {
                    System.out.println("\n👋 ¡Hasta pronto! Que tengas buen viaje.\n");
                    ejecutando = false;
                }
                default -> System.out.println("⚠  Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }

    // ─── Métodos auxiliares ───────────────────────────────────────────────────

    private static void calcularYMostrarRuta(Scanner scanner, Navegador navegador) {
        System.out.print("\n   Ingresa el origen  : ");
        String origen = scanner.nextLine().trim();

        System.out.print("  Ingresa el destino : ");
        String destino = scanner.nextLine().trim();

        if (origen.isEmpty() || destino.isEmpty()) {
            System.out.println("  Origen y destino no pueden estar vacíos.\n");
            return;
        }

        System.out.println();
        try {
            Ruta ruta = navegador.buildRuta(origen, destino);
            System.out.println(ruta);
        } catch (Exception e) {
            System.out.println("  Error al calcular la ruta: " + e.getMessage());
        }
        System.out.println();
    }

    private static void imprimirBienvenida() {
        System.out.println(" NAVEGADOR INTELIGENTE");
    }

    private static void imprimirMenu(String modoActual) {
        System.out.println("---------------------------------------");
        System.out.println("  Modo actual: " + modoActual);
        System.out.println("---------------------------------------");
        System.out.println("  Selecciona modo de transporte:");
        System.out.println("  [1]   Carretera");
        System.out.println("  [2]   A pie (Caminata)");
        System.out.println("  [3]   Transporte Público");
        System.out.println("  [4]   Bicicleta");
        System.out.println("  [5] ️  Ruta Turística");
        System.out.println("---------------------------------------");
        System.out.println("  [6]   Calcular ruta");
        System.out.println("  [0]   Salir");
        System.out.println("---------------------------------------");
        System.out.print("  Opción: ");
    }

    private static int leerOpcion(Scanner scanner) {
        try {
            String linea = scanner.nextLine().trim();
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategy;

import com.mycompany.strategy.model.Ruta;
import com.mycompany.strategy.strategy.EstrategiaDeRuta;

/**
 * Navegador : clase contexto del patrón Strategy.
 *
 * Mantiene una referencia a la estrategia activa y delega en ella
 * el cálculo de la ruta. El Navegador NO conoce los detalles de
 * ningún algoritmo concreto; simplemente invoca la interfaz.
 *
 * Esto permite:
 * Añadir nuevos algoritmos sin tocar esta clase.
 * Cambiar la estrategia en tiempo de ejecución.
 * Que distintos equipos trabajen en paralelo sobre estrategias distintas.
 */
public class Navegador {

    /** Estrategia actualmente seleccionada por el usuario. */
    private EstrategiaDeRuta estrategiaDeRuta;

    // Constructor

    /**
     * Crea un Navegador con una estrategia inicial.
     *
     * @param estrategiaInicial Estrategia que se usará por defecto.
     */
    public Navegador(EstrategiaDeRuta estrategiaInicial) {
        this.estrategiaDeRuta = estrategiaInicial;
    }

    // Setter de estrategia (intercambio en caliente)

    /**
     * Permite al usuario (o al sistema) cambiar el modo de transporte
     * en cualquier momento sin reiniciar la aplicación.
     *
     * @param estrategia La nueva estrategia de enrutamiento.
     */
    public void setEstrategiaDeRuta(EstrategiaDeRuta estrategia) {
        this.estrategiaDeRuta = estrategia;
        System.out.println("Modo de transporte actualizado.");
    }

    // Método principal

    /**
     * Solicita a la estrategia activa que construya la ruta y la retorna.
     *
     * @param origen   Punto de partida introducido por el usuario.
     * @param destino  Punto de llegada introducido por el usuario.
     * @return         La ruta calculada por la estrategia actual.
     * @throws IllegalStateException si no hay ninguna estrategia configurada.
     */
    public Ruta buildRuta(String origen, String destino) {
        if (estrategiaDeRuta == null) {
            throw new IllegalStateException("No hay ninguna estrategia de ruta configurada.");
        }
        if (origen == null || origen.isBlank() || destino == null || destino.isBlank()) {
            throw new IllegalArgumentException("El origen y el destino no pueden estar vacíos.");
        }
        return estrategiaDeRuta.buildRuta(origen.trim(), destino.trim());
    }

    //  Getter informativo

    /**
     * Retorna el nombre legible de la estrategia actualmente configurada.
     * Elimina la necesidad de mantener un string duplicado en el Cliente.
     *
     * @return Nombre del modo de transporte activo.
     */
    public String getNombreEstrategia() {
        return estrategiaDeRuta != null ? estrategiaDeRuta.getNombre() : "Sin configurar";
    }
}
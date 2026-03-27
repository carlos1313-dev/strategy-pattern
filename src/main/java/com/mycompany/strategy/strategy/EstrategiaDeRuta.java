/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategy.strategy;

import com.mycompany.strategy.model.Ruta;

/**
 * Interfaz EstrategiaDeRuta — define el contrato para todos los algoritmos de enrutamiento.
 * Cada algoritmo concreto implementa su propia lógica de cálculo de ruta.
 */
public interface EstrategiaDeRuta {

    /**
     * Construye y retorna la ruta más adecuada entre dos puntos.
     *
     * @param origen      Dirección o nombre del punto de partida.
     * @param destino     Dirección o nombre del punto de llegada.
     * @return            Un objeto Ruta con la información calculada.
     */
    Ruta buildRuta(String origen, String destino);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategy.strategy;

import com.mycompany.strategy.model.Ruta;

/**
 * EstrategiaTuristica — traza rutas que pasan por atracciones turísticas de la ciudad.
 * Sacrifica velocidad para enriquecer la experiencia del viajero.
 */
public class EstrategiaTuristica implements EstrategiaDeRuta {

    @Override
    public Ruta buildRuta(String origen, String destino) {
        System.out.println("[Turística] Trazando ruta por atracciones de la ciudad...");

        double distancia = simularDistancia(origen, destino);
        // Ruta más larga porque rodea por puntos turísticos
        int tiempo = (int) (distancia / 4.0 * 60) + 30; // lenta + tiempo de visita

        return new Ruta(
            origen, destino,
            " Ruta Turística",
            distancia,
            tiempo,
            "Pasa por los principales monumentos y puntos de interés. ¡Lleva la cámara!"
        );
    }

    private double simularDistancia(String origen, String destino) {
        // Distancia aumentada por el desvío turístico
        return Math.round((origen.length() + destino.length()) * 1.3 * 10.0) / 10.0;
    }
}

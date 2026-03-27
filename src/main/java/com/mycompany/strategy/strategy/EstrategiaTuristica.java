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

        // La ruta turística es un 30% más larga porque rodea por puntos de interés
        double distanciaBase = distanciaBase(origen, destino);
        double distancia     = Math.round(distanciaBase * 1.3 * 10.0) / 10.0;
        int tiempo = (int) (distancia / 4.0 * 60) + 30; // lenta + tiempo de visita

        return new Ruta(
                origen, destino,
                getNombre(),
                distancia,
                tiempo,
                "Pasa por los principales monumentos y puntos de interés. ¡Lleva la cámara!"
        );
    }

    @Override
    public String getNombre() {
        return "Ruta Turística";
    }

    private double distanciaBase(String origen, String destino) {
        int hash = Math.abs((origen.toLowerCase() + destino.toLowerCase()).hashCode());
        double base = 2.0 + (hash % 480) / 10.0;
        return Math.round(base * 10.0) / 10.0;
    }
}
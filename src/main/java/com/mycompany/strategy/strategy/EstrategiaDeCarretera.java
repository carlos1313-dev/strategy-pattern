/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategy.strategy;

import com.mycompany.strategy.model.Ruta;

/**
 * EstrategiaDeCarretera — calcula la ruta más rápida usando vías principales.
 * Prioriza autopistas y avenidas de alta velocidad.
 */
public class EstrategiaDeCarretera implements EstrategiaDeRuta {

    @Override
    public Ruta buildRuta(String origen, String destino) {
        System.out.println("[Carretera] Calculando ruta por vías principales...");

        // Simulación del algoritmo de ruta por carretera
        double distancia = simularDistancia(origen, destino, 1.0);
        int tiempo = (int) (distancia / 60.0 * 60); // ~60 km/h promedio

        return new Ruta(
            origen, destino,
            "🚗  Carretera",
            distancia,
            tiempo,
            "Ruta por autopistas y vías rápidas. Mínimo de semáforos."
        );
    }

    private double simularDistancia(String origen, String destino, double factor) {
        // Simulación basada en longitud de nombres (demo)
        return Math.round((origen.length() + destino.length()) * factor * 0.8 * 10.0) / 10.0;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategy.strategy;

import com.mycompany.strategy.model.Ruta;

/**
 * EstrategiaTransportePublico — calcula rutas combinando metro, bus y tren.
 * Optimiza el número de transbordos y tiempo de espera.
 */
public class EstrategiaTransportePublico implements EstrategiaDeRuta {

    @Override
    public Ruta buildRuta(String origen, String destino) {
        System.out.println("[Transporte Público] Calculando combinación de líneas...");

        double distancia = simularDistancia(origen, destino);
        int tiempo = (int) (distancia / 25.0 * 60) + 10; // ~25 km/h + 10 min espera

        return new Ruta(
            origen, destino,
            "Transporte Público",
            distancia,
            tiempo,
            "Combina bus y metro. Incluye tiempo de espera. Económico y ecológico."
        );
    }

    private double simularDistancia(String origen, String destino) {
        return Math.round((origen.length() + destino.length()) * 0.65 * 10.0) / 10.0;
    }
}
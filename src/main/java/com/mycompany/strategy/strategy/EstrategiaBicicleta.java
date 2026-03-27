/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategy.strategy;

import com.mycompany.strategy.model.Ruta;

/**
 * EstrategiaBicicleta — genera rutas optimizadas para ciclistas.
 * Prioriza ciclovías, rutas con poco tráfico y terreno llano.
 */
public class EstrategiaBicicleta implements EstrategiaDeRuta {

    @Override
    public Ruta buildRuta(String origen, String destino) {
        System.out.println("[Bicicleta] Calculando ruta ciclista...");

        double distancia = simularDistancia(origen, destino);
        int tiempo = (int) (distancia / 15.0 * 60); // ~15 km/h en bici

        return new Ruta(
            origen, destino,
            "Bicicleta",
            distancia,
            tiempo,
            "Ruta por ciclovías y calles de bajo tráfico. Saludable y sin atascos."
        );
    }

    private double simularDistancia(String origen, String destino) {
        return Math.round((origen.length() + destino.length()) * 0.55 * 10.0) / 10.0;
    }
}

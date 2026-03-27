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

        double distancia = distanciaBase(origen, destino);
        int tiempo = (int) (distancia / 15.0 * 60); // ~15 km/h en bici

        return new Ruta(
                origen, destino,
                getNombre(),
                distancia,
                tiempo,
                "Ruta por ciclovías y calles de bajo tráfico. Saludable y sin atascos."
        );
    }

    @Override
    public String getNombre() {
        return "Bicicleta";
    }

    private double distanciaBase(String origen, String destino) {
        int hash = Math.abs((origen.toLowerCase() + destino.toLowerCase()).hashCode());
        double base = 2.0 + (hash % 480) / 10.0;
        return Math.round(base * 10.0) / 10.0;
    }
}
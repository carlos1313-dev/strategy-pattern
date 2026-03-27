/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategy.strategy;

import com.mycompany.strategy.model.Ruta;

/**
 * EstrategiaCaminata — genera rutas pensadas para peatones.
 * Prioriza aceras, parques y zonas seguras peatonales.
 */
public class EstrategiaCaminata implements EstrategiaDeRuta {

    @Override
    public Ruta buildRuta(String origen, String destino) {
        System.out.println("[Caminata] Calculando ruta peatonal...");

        double distancia = simularDistancia(origen, destino);
        int tiempo = (int) (distancia / 5.0 * 60); // ~5 km/h caminando

        return new Ruta(
            origen, destino,
            " A pie",
            distancia,
            tiempo,
            "Ruta peatonal por aceras y senderos seguros. Ideal para distancias cortas."
        );
    }

    private double simularDistancia(String origen, String destino) {
        return Math.round((origen.length() + destino.length()) * 0.5 * 10.0) / 10.0;
    }
}

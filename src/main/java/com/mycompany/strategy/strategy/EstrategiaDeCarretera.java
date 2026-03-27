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

        double distancia = distanciaBase(origen, destino);
        int tiempo = (int) (distancia / 60.0 * 60); // ~60 km/h en autopista

        return new Ruta(
                origen, destino,
                getNombre(),
                distancia,
                tiempo,
                "Ruta por autopistas y vías rápidas. Mínimo de semáforos."
        );
    }

    @Override
    public String getNombre() {
        return "Carretera";
    }

    /**
     * Distancia base simulada compartida: misma distancia geográfica
     * independientemente del modo de transporte.
     * Usa un hash estable de los nombres para producir un valor consistente.
     */
    private double distanciaBase(String origen, String destino) {
        int hash = Math.abs((origen.toLowerCase() + destino.toLowerCase()).hashCode());
        double base = 2.0 + (hash % 480) / 10.0; // rango: 2.0 – 50.0 km
        return Math.round(base * 10.0) / 10.0;
    }
}
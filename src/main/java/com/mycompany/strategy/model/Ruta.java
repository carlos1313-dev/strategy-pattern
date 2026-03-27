/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategy.model;

/**
 * Modelo que representa la información de una ruta calculada.
 */
public class Ruta {

    private final String origen;
    private final String destino;
    private final String tipoTransporte;
    private final double distanciaKm;
    private final int tiempoEstimadoMin;
    private final String descripcion;

    public Ruta(String origen, String destino, String tipoTransporte,
                double distanciaKm, int tiempoEstimadoMin, String descripcion) {
        this.origen = origen;
        this.destino = destino;
        this.tipoTransporte = tipoTransporte;
        this.distanciaKm = distanciaKm;
        this.tiempoEstimadoMin = tiempoEstimadoMin;
        this.descripcion = descripcion;
    }

    public String getOrigen()              { return origen; }
    public String getDestino()             { return destino; }
    public String getTipoTransporte()      { return tipoTransporte; }
    public double getDistanciaKm()         { return distanciaKm; }
    public int    getTiempoEstimadoMin()   { return tiempoEstimadoMin; }
    public String getDescripcion()         { return descripcion; }

    @Override
    public String toString() {
        return String.format(
            "┌─────────────────────────────────────────┐%n" +
            "│  RUTA CALCULADA                         │%n" +
            "├─────────────────────────────────────────┤%n" +
            "│  Modo       : %-26s│%n" +
            "│  Origen     : %-26s│%n" +
            "│  Destino    : %-26s│%n" +
            "│  Distancia  : %-22.1f km │%n" +
            "│  Tiempo est.: %-23d min│%n" +
            "├─────────────────────────────────────────┤%n" +
            "│  %s%n" +
            "└─────────────────────────────────────────┘",
            tipoTransporte, origen, destino,
            distanciaKm, tiempoEstimadoMin, descripcion
        );
    }
}

package com.desarrolloar.conversor.modelo;

public class Conversor {

    private final double dolarAEuro = 0.87;
    private final double euroADolar= 1.15;

    private double convertirADolares(double euros){
            return euros * euroADolar;
    }

    private double convertirAEuros(double dolares){
            return dolares * dolarAEuro;
    }
}

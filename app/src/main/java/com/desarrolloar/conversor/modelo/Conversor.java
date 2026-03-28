package com.desarrolloar.conversor.modelo;

public class Conversor {

    private double dolarPorEuro;

    public Conversor(double dolarPorEuro) {
        this.dolarPorEuro = dolarPorEuro;
    }

    public double getDolarPorEuro() {
        return dolarPorEuro;
    }

    public void setDolarPorEuro(double dolarPorEuro) {
        this.dolarPorEuro = dolarPorEuro;
    }

    public double convertirADolares(double euros){
            return euros / dolarPorEuro;
    }

    public double convertirAEuros(double dolares){
            return dolares * dolarPorEuro;
    }
}

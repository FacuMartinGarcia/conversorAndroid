package com.desarrolloar.conversor.modelo;

public class Conversor {

    private double valorDolar;

    public Conversor(double valorDolar) {
        this.valorDolar = valorDolar;
    }

    public Conversor(){}

        public double getValorDolar() {
        return valorDolar;
    }

    public void setValorDolar(double valorDolar) {
        this.valorDolar = valorDolar;
    }
}

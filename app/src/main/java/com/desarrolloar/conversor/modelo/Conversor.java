package com.desarrolloar.conversor.modelo;

public class Conversor {

    private double cotizacion;

    public Conversor(double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public double convertirADolares(double euros){
            return euros / cotizacion;
    }

    public double convertirAEuros(double dolares){
            return dolares * cotizacion;
    }
}

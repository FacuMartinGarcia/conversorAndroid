package com.desarrolloar.conversor;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.desarrolloar.conversor.modelo.Conversor;

import java.util.Locale;


public class MainActivityViewModel extends AndroidViewModel {

    //private MutableLiveData<Conversor>conversorMutableLiveData;
    private MutableLiveData<Boolean> mostrarEuros = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> mostrarDolares = new MutableLiveData<>(false);
    private MutableLiveData<String> mensajeToast = new MutableLiveData<>();
    private MutableLiveData<String> resultadoEuros = new MutableLiveData<>("");
    private MutableLiveData<String> resultadoDolares = new MutableLiveData<>("");
    private static final int nadaSeleccionado = 0;
    private static final int dolares = 1;
    private static final int euros = 2;
    private final MutableLiveData<Integer> tipoConversion = new MutableLiveData<>(nadaSeleccionado);

    private Conversor conversor;



    public MainActivityViewModel(@NonNull Application application) {

        super(application);
        //Establecemos un valor standard de X dolares por Euros

        conversor = new Conversor(0.87);


    }

    // El liveData lo iniciamos con el valor de 0.87
   /* public LiveData<Conversor> getValorDolarPorEuro() {
        if (conversorMutableLiveData == null) {
            conversorMutableLiveData = new MutableLiveData<>();
            conversorMutableLiveData.setValue(conversor);
        }
        return conversorMutableLiveData;
    }*/

    public LiveData<Boolean> getMostrarEuros() {
        return mostrarEuros;
    }
    public LiveData<Boolean> getMostrarDolares() {
        return mostrarDolares;
    }
    public LiveData<String> getResultadoEuros() {
        return resultadoEuros;
    }
    public LiveData<String> getResultadoDolares() {
        return resultadoDolares;
    }
    public LiveData<String> getMensajeToast() {
        return mensajeToast;
    }
    public String getCotizacionActual() {
        return formatear(conversor.getCotizacion());
    }
    private String formatear(double valor) {
        return String.format(Locale.getDefault(), "%.2f", valor);
    }


    /*public void setSeleccionMoneda(int id, int idDolares) {

        if (id == idDolares) {
            mostrarEuros.setValue(true);
            mostrarDolares.setValue(false);
        } else {
            mostrarEuros.setValue(false);
            mostrarDolares.setValue(true);
        }
    }*/

    // Metodo para decir que tipo de conversion hacer, en base a la seleccion del usuario.
    // En tipoConversion se guarda la seleccion para poder usarse en el metodo convertir.
    public void setSeleccionMoneda(int checkedId, int idDolares, int idEuros) {
        if (checkedId == idDolares) {
            tipoConversion.setValue(dolares);
            mostrarEuros.setValue(true);
            mostrarDolares.setValue(false);
        } else if (checkedId == idEuros) {
            tipoConversion.setValue(euros);
            mostrarEuros.setValue(false);
            mostrarDolares.setValue(true);
        } else {
            tipoConversion.setValue(nadaSeleccionado);
            mostrarEuros.setValue(false);
            mostrarDolares.setValue(false);
        }
    }
    // Metodo para cambiar la cotizacion ingresada por el usuario.
    // Se actualiza la cotizacion para realizar la conversion.
    public void cambiarCotizacion(String textoCotizacion) {
        Double valor = parseNumero(textoCotizacion);

        if (valor == null || valor <= 0.0) {
            mensajeToast.setValue("Ingrese una cotización válida");
            return;
        }

        conversor.setCotizacion(valor);
        mensajeToast.setValue("Cotización actualizada");
    }
    // Metodo para verificar cual opcion se selecciono y ejecutar el metodo
    // correspondiente de la clase Conversor.
    public void convertir(String textoEuros, String textoDolares) {

        Integer tipo = tipoConversion.getValue();

        if (tipo == null || tipo == nadaSeleccionado) {
            mensajeToast.setValue("Seleccioná una opción");
            return;
        }

        if (tipo == dolares) {

            Double euros = parseNumero(textoEuros);
            if (euros == null) {
                mensajeToast.setValue("Ingrese un valor válido en euros");
                return;
            }

            double dolares = conversor.convertirADolares(euros);

            resultadoDolares.setValue(formatear(dolares));
            resultadoEuros.setValue(""); // limpiar

        } else if (tipo == euros) {

            Double dolares = parseNumero(textoDolares);
            if (dolares == null) {
                mensajeToast.setValue("Ingrese un valor válido en dólares");
                return;
            }

            double euros = conversor.convertirAEuros(dolares);

            resultadoEuros.setValue(formatear(euros));
            resultadoDolares.setValue(""); // limpiar
        }
    }

    private Double parseNumero(String texto) {
        if (texto == null) {
            return null;
        }

        String limpio = texto.trim().replace(',', '.');
        if (limpio.isEmpty()) {
            return null;
        }

        try {
            return Double.parseDouble(limpio);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}


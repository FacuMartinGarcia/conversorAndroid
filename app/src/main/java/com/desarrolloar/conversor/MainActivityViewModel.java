package com.desarrolloar.conversor;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.desarrolloar.conversor.modelo.Conversor;


public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Conversor>conversorMutableLiveData;
    private MutableLiveData<Boolean> mostrarEuros = new MutableLiveData<>(true);
    private MutableLiveData<Boolean> mostrarDolares = new MutableLiveData<>(false);
    private MutableLiveData<String> mensajeToast = new MutableLiveData<>();

    private Conversor conversor;



    public MainActivityViewModel(@NonNull Application application) {

        super(application);
        //Establecemos un valor standard de X dolares por Euros

        conversor = new Conversor(0.87);


    }

    // El liveData lo iniciamos con el valor de 0.87
    public LiveData<Conversor> getValorDolarPorEuro() {
        if (conversorMutableLiveData == null) {
            conversorMutableLiveData = new MutableLiveData<>();
            conversorMutableLiveData.setValue(conversor);
        }
        return conversorMutableLiveData;
    }

    public LiveData<Boolean> getMostrarEuros() {
        return mostrarEuros;
    }
    public LiveData<Boolean> getMostrarDolares() {
        return mostrarDolares;
    }

    public LiveData<String> getMensajeToast() {
        return mensajeToast;
    }

    public void setSeleccionMoneda(int id, int idDolares) {

        if (id == idDolares) {
            mostrarEuros.setValue(true);
            mostrarDolares.setValue(false);
        } else {
            mostrarEuros.setValue(false);
            mostrarDolares.setValue(true);
        }
    }



    public void setValorDolarPorEuro(double valor) {
        if (valor > 0.0) {
            conversor.setDolarPorEuro(valor);
        } else {
            //Si no trae valor valido de cotizacion, le asignamos el inicial
            conversor.setDolarPorEuro(0.87);
        }
        conversorMutableLiveData.setValue(conversor);
    }

    public void setCambiarADolar(double valor) {
        if (valor > 0.0) {
            conversor.convertirAEuros(valor);
        } else {
            conversor.setDolarPorEuro(0.0);
            importeInvalido();
        }
        conversorMutableLiveData.setValue(conversor);
        //este valor

    }

    public void importeInvalido() {
        mensajeToast.setValue("Ingrese un valor válido para convertir");
    }


}


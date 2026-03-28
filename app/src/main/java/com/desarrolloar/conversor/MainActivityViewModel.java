package com.desarrolloar.conversor;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.desarrolloar.conversor.modelo.Conversor;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Conversor>conversorMutableLiveData;
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

    public void setValorDolarPorEuro(double valor) {
        if (valor > 0.0) {
            conversor.setDolarPorEuro(valor);
        } else {
            //Si no trae valor valido de cotizacion, le asignamos el inicial
            conversor.setDolarPorEuro(0.87);
        }
        conversorMutableLiveData.setValue(conversor);
    }


}


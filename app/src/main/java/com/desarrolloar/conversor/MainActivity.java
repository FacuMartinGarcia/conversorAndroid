package com.desarrolloar.conversor;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.desarrolloar.conversor.databinding.ActivityMainBinding;
import com.desarrolloar.conversor.modelo.Conversor;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding b;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        vm= new ViewModelProvider(this).get(MainActivityViewModel.class);

        setSupportActionBar(b.toolbar);

        // Mostrar cotización inicial
        b.etCambio.setText(vm.getCotizacionActual());


        // Captura la seleccion de la opcion Convertir a dolares/ Euros
        b.seleccionRadio.setOnCheckedChangeListener((group, checkedId) -> {
            vm.setSeleccionMoneda(checkedId, b.rbDolares.getId(), b.rbEuros.getId());

            b.etEuros.setText("");
            b.etDolares.setText("");
        });

        // Despues de caputurar la seleccion, se habilita el campo correspondiente
        vm.getMostrarEuros().observe(this, habilitar -> {
            b.etEuros.setEnabled(habilitar);
            b.tvEuros.setEnabled(habilitar);
        });

        vm.getMostrarDolares().observe(this, habilitar -> {
            b.etDolares.setEnabled(habilitar);
            b.tvDolares.setEnabled(habilitar);
        });

        // Al hacer click en "Cambiar valor" se llama al metodo del VM y
        // capura lo que hay en etCambio, es decir, la nueva cotizacion.
        b.btCambValor.setOnClickListener(v ->
                vm.cambiarCotizacion(b.etCambio.getText().toString())
        );

        vm.getMensajeToast().observe(this, msg -> {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });

        // Al hacer click en "Convertir" se llama al metodo del VM y
        // captura lo que hay en etEuros/etDolares, es decir, el monto
        // para hacer la conversion.
        b.btConvertir.setOnClickListener(v ->
                vm.convertir(
                        b.etEuros.getText().toString(),
                        b.etDolares.getText().toString()
                )
        );

        // Se muestran los resultados en los campos correspondintes
        vm.getResultadoEuros().observe(this, res -> {
            b.etEuros.setText(res);
        });

        vm.getResultadoDolares().observe(this, res -> {
            b.etDolares.setText(res);
        });

        //Empieza con la opcion para convertir euros a dólares por defecto
        inicializarPorDefecto();

        vm.getLimpiarCampos().observe(this, limpiar -> {
            if (limpiar) {
                b.etEuros.setText("");
                b.etDolares.setText("");
            }
        });

    }

    public void inicializarPorDefecto() {
        b.rbEuros.setChecked(true);
        vm.setSeleccionMoneda(
                b.rbEuros.getId(),
                b.rbDolares.getId(),
                b.rbEuros.getId()
        );
    }



    }
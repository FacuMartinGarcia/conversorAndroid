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

        //b.etDolares.setVisibility(View.GONE);
        //b.tvDolares.setVisibility(View.GONE);

        vm= new ViewModelProvider(this).get(MainActivityViewModel.class);

        b.etEuros.setEnabled(false);
        b.etDolares.setEnabled(false);

        // Captura la seleccion de la opcion Convertir a dolares/ Euros
        b.seleccionRadio.setOnCheckedChangeListener((group, checkedId) ->
                vm.setSeleccionMoneda(checkedId, b.rbDolares.getId(), b.rbEuros.getId())
        );

        // Despues de caputurar la seleccion, se habilita el campo correspondiente
        vm.getMostrarEuros().observe(this, habilitar -> {
            b.etEuros.setEnabled(habilitar);
        });

        vm.getMostrarDolares().observe(this, habilitar -> {
            b.etDolares.setEnabled(habilitar);
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


        /*b.btConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aca hay que tener en cuenta que metodo usar
                //de acuerdo a la seleccion del radioGroup
                //los métodos de abajo
            }
        });*/

        //vm.setCambiarADolar();
        //vm.setCambiarAEuro();

        /* vm.getValorDolarPorEuro().observe(this, new Observer<Conversor>() {
            @Override
            public void onChanged(Conversor conversor) {
                b.etCambio.setText(String.valueOf(conversor.getCotizacion()));
            }
        });/*

        /*
        b.seleccionRadio.setOnCheckedChangeListener((group, seleccion) -> {
            if (seleccion != -1) {
                vm.setSeleccionMoneda(seleccion);
            }
        });

         */


        /*vm.getMostrarEuros().observe(this, mostrar -> {
            b.etEuros.setVisibility(mostrar ? View.VISIBLE : View.GONE);
            b.tvEuros.setVisibility(mostrar ? View.VISIBLE : View.GONE);

        });
        vm.getMostrarDolares().observe(this, mostrar -> {
            b.etDolares.setVisibility(mostrar ? View.VISIBLE : View.GONE);
            b.tvDolares.setVisibility(mostrar ? View.VISIBLE : View.GONE);

        });

        vm.getMensajeToast().observe(this, mensaje -> {
            if (mensaje != null) {
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });/*

        /*
        b.seleccionRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int seleccion) {
                if (seleccion == -1) {
                    // nada seleccionado
                    return;
                }
                //Se podría establecer las coordenadas para que queden en el mismo lugar
                if (seleccion == b.rbDolares.getId()) {
                    b.etDolares.setVisibility(View.GONE);
                    b.tvDolares.setVisibility(View.GONE);

                    b.etEuros.setVisibility(View.VISIBLE);
                    b.tvEuros.setVisibility(View.VISIBLE);
                    b.etEuros.setText("");
                } else if (seleccion == b.rbEuros.getId()) {

                    b.etDolares.setVisibility(View.VISIBLE);
                    b.tvDolares.setVisibility(View.VISIBLE);
                    b.etDolares.setText("");

                    b.etEuros.setVisibility(View.GONE);
                    b.tvEuros.setVisibility(View.GONE);
                }
                }
            }
        );

         */


    }

    }
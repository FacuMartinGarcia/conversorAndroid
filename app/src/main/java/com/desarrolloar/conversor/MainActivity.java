package com.desarrolloar.conversor;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
        b.etDolares.setVisibility(View.GONE);
        b.tvDolares.setVisibility(View.GONE);


        vm= new ViewModelProvider(this).get(MainActivityViewModel.class);


        vm.getValorDolarPorEuro().observe(this, new Observer<Conversor>() {
            @Override
            public void onChanged(Conversor conversor) {
                b.etCambio.setText(String.valueOf(conversor.getDolarPorEuro()));
            }
        });


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


    }

    }
package com.example.taller1_compumovil;

importandroidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taller1_compumovil.databinding.ActivityCountryBinding;
import com.example.taller1_compumovil.databinding.ActivityGameBinding;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private ActivityGameBinding binding;
    private int numero;
    private EditText numeroIngresado;
    private Button botonAdivinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        numeroIngresado = findViewById(R.id.editTextNumberSigned);
        botonAdivinar = findViewById(R.id.button);
        botonAdivinar.setOnClickListener(v -> {
            adivinar(v);
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        numero = new Random().nextInt(100);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @SuppressLint("SetTextI18n")
    public void adivinar(View view){
        int numeroIng = Integer.parseInt(numeroIngresado.getText().toString());
        numeroIngresado.setText("");
        if(numeroIng == numero) {
            binding.textoguia.setText("Adivino el numero 🎉");
            numero = new Random().nextInt(100);
        } else {
            if(numeroIng < numero)
                binding.textoguia.setText("El numero es mayor ⬆");
            else if (numeroIng > numero)
                binding.textoguia.setText("El numero es menor ⬇");
        }
    }
}
package com.example.taller1_compumovil;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1_compumovil.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Integer clickJugar = 0;
    private Integer clickPaises = 0;

    private Date dateJugar = new Date();
    private Date datePaises = new Date();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button1.setOnClickListener(v -> {
            clickJugar ++;
            dateJugar = new Date();
            mostrarInfo();
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });

        binding.button2.setOnClickListener(v -> {
            clickPaises ++;
            datePaises = new Date();
            mostrarInfo();
            Intent intent = new Intent(this, CountryActivity.class);
            startActivity(intent);
        });

    }
    public void mostrarInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM dd,yyyy");
        binding.boton1Info.setText(String.format("El boton Jugar a sido clickeado %d veces", clickJugar));
        binding.boton2Info1.setText(String.format("El boton paises a sido clickeado %d veces", clickPaises));
        binding.boton1Info2.setText(String.format("Ultima vez clickeado %s", sdf.format(dateJugar)));
        binding.boton2Info2.setText(String.format("Ultima vez clickeado %s", sdf.format(datePaises)));
    }
}
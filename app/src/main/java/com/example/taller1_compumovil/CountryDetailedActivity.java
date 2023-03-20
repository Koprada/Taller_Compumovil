package com.example.taller1_compumovil;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.taller1_compumovil.databinding.ActivityCountryDetailedActivityBinding;
import com.example.taller1_compumovil.model.Pais;

import java.util.List;

public class CountryDetailedActivity extends AppCompatActivity {
    private ActivityCountryDetailedActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryDetailedActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Pais miPais = (Pais) intent.getSerializableExtra("KEY_COUNTRY");
        Uri uri = Uri.parse(miPais.getFlag());
        Glide.with(getApplicationContext()).load(uri).into(binding.Imagen);


        binding.paistext.setText(miPais.getName());
        binding.continente.setText(miPais.getSubRegion());
        binding.nombreInt.setText(miPais.getName());
        binding.sigla.setText(miPais.getAlpha2Code());

    }
}
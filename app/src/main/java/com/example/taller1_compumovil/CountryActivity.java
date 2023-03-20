package com.example.taller1_compumovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.taller1_compumovil.Service.PaisesInfoJsonService;
import com.example.taller1_compumovil.databinding.ActivityCountryBinding;
import com.example.taller1_compumovil.databinding.ActivityMainBinding;
import com.example.taller1_compumovil.model.Pais;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity {
    private ActivityCountryBinding binding;
    private PaisesInfoJsonService archivo = new PaisesInfoJsonService();
    private List<String> pais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            archivo.loadCountriesByJson(getAssets().open(PaisesInfoJsonService.COUNTRIES_FILE));

            for (int i = 0; i < archivo.getSize(); i++) {
                pais.add(archivo.getCountries().getJSONObject(i).getString("NativeName"));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pais);
            binding.listapais.setAdapter(adapter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        binding.listapais.setOnItemClickListener(((adapterView, view, i, l) -> {
            String nombre = adapterView.getItemAtPosition(i).toString();
            Pais paisSelect =  searchCountry(nombre);
            Intent intent = new Intent(this, CountryDetailedActivity.class);
            intent.putExtra("KEY_COUNTRY", paisSelect);
            startActivity(intent);
        }));

    }
    public Pais searchCountry (String nombre) {
        for (int i = 0; i < archivo.getSize(); i++) {
            String nombreTemp = null;
            try {
                nombreTemp = archivo.getCountries().getJSONObject(i).getString("NativeName");
                if (nombreTemp.equals(nombre)){
                    String subRegion = archivo.getCountries().getJSONObject(i).getString("SubRegion");
                    String alpha2Code = archivo.getCountries().getJSONObject(i).getString("Alpha2Code");
                    String flag = archivo.getCountries().getJSONObject(i).getString("FlagPng");

                    return new Pais(nombre, subRegion, alpha2Code, flag);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}

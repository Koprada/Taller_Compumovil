package com.example.taller1_compumovil.Service;

import android.content.Context;
import android.util.Log;

import com.example.taller1_compumovil.model.Pais;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PaisesInfoJsonService {
    public static final String COUNTRIES_FILE = "paises.json";
    private JSONArray countries;
    private int size;

    public JSONArray getCountries() {
        return countries;
    }

    public int getSize() {
        return size;
    }

    public String loadJSONFromAsset(InputStream is){
        String json = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void loadCountriesByJson(InputStream is) throws JSONException {
        countries = new JSONObject(loadJSONFromAsset(is)).getJSONArray("Countries");
        size = countries.length();
    }
}


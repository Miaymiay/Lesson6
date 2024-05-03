package com.mirea.pershinadv.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mirea.pershinadv.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String group;
    private Integer number;
    private String film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    public void onClicked(View view){
        group = binding.editTextGroup.getText().toString();
        number = Integer.parseInt(binding.editTextNumber.getText().toString());
        film = binding.editTextFilm.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        SharedPreferences.Editor editor	= sharedPref.edit();
        editor.putString("GROUP", group);
        editor.putInt("NUMBER", number);
        editor.putString("FILM/SERIES", film);
        editor.apply();
        Toast.makeText(this, "Saved settings", Toast.LENGTH_SHORT).show();
    }
}
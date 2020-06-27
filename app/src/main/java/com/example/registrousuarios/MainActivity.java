package com.example.registrousuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonRegistro;
    Button buttonInicioSesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRegistro=findViewById(R.id.buttonRegistro_main);
        buttonInicioSesion=findViewById(R.id.buttonInicioSesion_main);
        buttonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionRegistro(v);
            }
        });
        buttonInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionInicioSesion(v);
            }
        });
    }

    public void funcionRegistro(View v){
        //Toast.makeText(this, getString(R.string.click_Registro), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void funcionInicioSesion(View v){
        //Toast.makeText(this, getString(R.string.click_Registro), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,InicioSesionActivity.class);
        startActivity(intent);
    }


}




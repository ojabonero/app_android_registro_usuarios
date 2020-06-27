package com.example.registrousuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText nombre;
    EditText apellido;
    EditText nombreUsuario;
    EditText contraseña;
    EditText email;
    Button enviarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nombre=findViewById(R.id.nombre_register);
        apellido=findViewById(R.id.apellido_register);
        nombreUsuario=findViewById(R.id.nombre_usuario_register);
        contraseña=findViewById(R.id.contraseña_register);
        email=findViewById(R.id.mail_register);
        enviarDatos=findViewById(R.id.button_enviar_datos);
        enviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
                pasoInicioSesion();
            }
        });
    }

    //Registramos el usuario y nos muestra los usuarios registrados
    private void registrarUsuario(){
        BaseDeDatos bd = new BaseDeDatos(this, "android",null,1);
        bd.insertData(nombre.getText().toString(), apellido.getText().toString(), nombreUsuario.getText().toString(),
                contraseña.getText().toString(), email.getText().toString());
        bd.recuperarDatos();
    }

    private void pasoInicioSesion(){
        Intent intent = new Intent(RegisterActivity.this, InicioSesionActivity.class);
        startActivity(intent);
    }
}

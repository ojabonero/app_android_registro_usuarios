package com.example.registrousuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfoUsuarioActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private Button botonSonidoPlay;
    private Button botonSonidoStop;
    TextView nombre, apellidos, nombreUsuario, contraseña, email;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_usuario);

        //Creamos un objeto bundle para recibir los diferentes strings cada uno en su textview
        Bundle extras=getIntent().getExtras();

        nombreUsuario=findViewById(R.id.nombre_usuario_informacion);
        nombreUsuario.setText(extras.getString("usuario"));

        contraseña=findViewById(R.id.contraseña_informacion);
        contraseña.setText(extras.getString("contraseña"));

        nombre=findViewById(R.id.nombre_informacion);
        nombre.setText(extras.getString("nombre"));

        apellidos=findViewById(R.id.apellido_informacion);
        apellidos.setText(extras.getString("apellidos"));

        email=findViewById(R.id.mail_informacion);
        email.setText(extras.getString("mail"));

        //Referenciamos los botones
        botonSonidoPlay=findViewById(R.id.button_play);
        botonSonidoStop=findViewById(R.id.button_stop);
        botonSonidoPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=MediaPlayer.create(InfoUsuarioActivity.this,R.raw.sonido);
                mp.start();
            }
        });

        botonSonidoStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }
}

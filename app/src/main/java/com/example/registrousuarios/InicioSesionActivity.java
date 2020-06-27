package com.example.registrousuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InicioSesionActivity extends AppCompatActivity {

    Button buttonEntrar;
    BaseDeDatos bdInicio = new BaseDeDatos(this,"android",null,1);
    BaseDeDatos usuario = new BaseDeDatos(this, "android",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        buttonEntrar=findViewById(R.id.buttonEntrar_inicio_sesion);
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            EditText user = (EditText)findViewById(R.id.nombre_usuario_inicio_sesion);
            EditText pass = (EditText)findViewById(R.id.contraseña_inicio_sesion);

            @Override
            public void onClick(View v) {

                //Comprobamos que la pareja de valores usuario-password existe en la base de datos
                if (bdInicio.consultarUsuarioPass(user.getText().toString(),pass.getText().toString())){

                    String accesoAdmitido=getResources().getString(R.string.toast_usuario_registrado);
                    Toast.makeText(getApplicationContext(),accesoAdmitido,Toast.LENGTH_LONG).show();
                    Usuario usuarioAdmitido = new Usuario();

                    //Recuperamos los datos del usuario logueado
                    usuarioAdmitido=bdInicio.recuperarUsuario(user.getText().toString(),pass.getText().toString());

                    String nombre=usuarioAdmitido.getNombre();
                    String apellidos=usuarioAdmitido.getApellido();
                    String nombreUsuario=usuarioAdmitido.getNombreUsuario();
                    String password=usuarioAdmitido.getContraseña();
                    String email=usuarioAdmitido.getEmail();

                    //Pasamos los datos a la activity que muestra los datos
                    Intent intent = new Intent(InicioSesionActivity.this, InfoUsuarioActivity.class);

                    intent.putExtra("nombre",nombre);
                    intent.putExtra("apellidos",apellidos);
                    intent.putExtra("usuario", nombreUsuario);
                    intent.putExtra("contraseña",password);
                    intent.putExtra("mail", email);

                    startActivity(intent);

                }else{
                    String accesoNoAdmitido=getResources().getString(R.string.toast_usuario_no_registrado);
                    Toast.makeText(getApplicationContext(),accesoNoAdmitido,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

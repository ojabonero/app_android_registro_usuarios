package com.example.registrousuarios;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseDeDatos extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public BaseDeDatos(@Nullable Context context,
                       @Nullable String name,
                       @Nullable SQLiteDatabase.CursorFactory factory,
                       int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "apellido TEXT," +
                "nombreUsuario TEXT," +
                "contraseña TEXT," +
                "email TEXT);";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(String nombre, String apellido, String nombreUsuario, String contraseña,
                           String email) {
        SQLiteDatabase escritura = getWritableDatabase();
        String insert = "INSERT INTO usuarios (nombre, apellido, nombreUsuario, contraseña, email) " +
                "VALUES(\"" + nombre + "\",\"" + apellido + "\"" + ",\"" + nombreUsuario + "\"" + ",\"" + contraseña + "\"" + ",\"" + email + "\");";
        escritura.execSQL(insert);
        escritura.close();
    }

    //Muestra por consola los usuarios de la base de datos
    public void recuperarDatos() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase lectura = getReadableDatabase();
        String sql = "SELECT * FROM usuarios";
        Cursor cursor = lectura.rawQuery(sql, null);
        cursor.moveToFirst();
        do {
            usuarios.add(new Usuario(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)));
        } while (cursor.moveToNext());
        Iterator iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        lectura.close();
    }

    //Controla el paso del usuario a la siguiente activity
    public boolean consultarUsuarioPass(String usuario, String password) {
        SQLiteDatabase lectura = this.getReadableDatabase();
        String sql = "SELECT nombreUsuario, contraseña FROM usuarios WHERE nombreUsuario=? AND contraseña=?";
        Cursor cursor = lectura.rawQuery(sql, new String[]{usuario, password});
        if(cursor.getCount()>0){
            return true;
        }
        return false;
    }

    public Usuario recuperarUsuario(String usuario, String password) {
        SQLiteDatabase lectura = this.getReadableDatabase();
        //Hacemos la consulta para recoger toda la fila del usuario que ha podido acceder con el usuario-password correctos
        String sql = "SELECT id, nombre, apellido, nombreUsuario, contraseña, email FROM usuarios WHERE nombreUsuario=? AND contraseña=?";
        Cursor cursor = lectura.rawQuery(sql, new String[]{usuario, password});

        Usuario usuarioLogueado=new Usuario();

        cursor.moveToFirst();
        do{
            usuarioLogueado.setId(cursor.getInt(0));
            usuarioLogueado.setNombre(cursor.getString(1));
            usuarioLogueado.setApellido(cursor.getString(2));
            usuarioLogueado.setNombreUsuario(cursor.getString(3));
            usuarioLogueado.setContraseña(cursor.getString(4));
            usuarioLogueado.setEmail(cursor.getString(5));
        }while(cursor.moveToNext());

        return usuarioLogueado;
    }
}








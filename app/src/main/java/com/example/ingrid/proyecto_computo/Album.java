package com.example.ingrid.proyecto_computo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Album extends Activity {

    private EditText et1, et2, et4;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_album);

        // proviene del layout, son los campos de texto
        et1 = (EditText) findViewById(R.id.editText3);
        et2 = (EditText) findViewById(R.id.editText5);
        et4 = (EditText) findViewById(R.id.editText2);

    }

    // Damos de alta los usuarios en nuestra aplicación
    public void alta(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,

                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String id = et1.getText().toString();
        String nombre = et2.getText().toString();
        String numero = et4.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("id", id);
        registro.put("nombre", nombre);
        registro.put("numero", numero);

        // los inserto en la base de datos
        bd.insert("usuario", null, registro);

        bd.close();

        // ponemos los campos a vacío para insertar el siguiente usuario
        et1.setText(""); et2.setText(""); et4.setText("");

        Toast.makeText(this, "Datos del usuario cargados", Toast.LENGTH_SHORT).show();

    }

    // Hacemos búsqueda de usuario por DNI
    public void consulta(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,

                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String id = et1.getText().toString();

        Cursor fila = bd.rawQuery(

                "select nombre, numero from usuario where id=" + id, null);

        if (fila.moveToFirst()) {

            et2
                    .setText(fila.getString(1));
            et4.setText(fila.getString(2));

        } else

            Toast.makeText(this, "No existe ningún usuario con ese dni",

                    Toast.LENGTH_SHORT).show();

        bd.close();

    }


    /* Método para dar de baja al usuario insertado*/
    public void baja(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,

                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String id = et1.getText().toString();

        // aquí borro la base de datos del usuario por el dni
        int cant = bd.delete("usuario", "id=" + id, null);

        bd.close();

        et1.setText(""); et2.setText(""); et4.setText("");

        if (cant == 1)

            Toast.makeText(this, "Usuario eliminado",

                    Toast.LENGTH_SHORT).show();

        else

            Toast.makeText(this, "No existe usuario",

                    Toast.LENGTH_SHORT).show();
    }


    // Método para modificar la información del usuario
    public void modificacion(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,

                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String id = et1.getText().toString();
        String numero = et4.getText().toString();
        ContentValues registro = new ContentValues();

        // actualizamos con los nuevos datos, la información cambiada
        registro.put("numero", numero);

        int cant = bd.update("usuario", registro, "id=" + id, null);

        bd.close();

        if (cant == 1)

            Toast.makeText(this, "Datos modificados con éxito", Toast.LENGTH_SHORT)

                    .show();

        else

            Toast.makeText(this, "No existe usuario",

                    Toast.LENGTH_SHORT).show();

    }

    /* fin del programa */

}
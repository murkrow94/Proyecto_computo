package com.example.ingrid.proyecto_computo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button siguiente;
    Button siguiente1;
    Button siguiente2;
    Button siguiente3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        siguiente= (Button)findViewById(R.id.btnalbum);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,VistaAlbum.class));
            }
        });

        siguiente1= (Button)findViewById(R.id.btnavance);
        siguiente1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Avance.class));
            }
        });

        siguiente2= (Button)findViewById(R.id.btncomprar);
        siguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Comprar.class));
            }
        });
        siguiente3= (Button)findViewById(R.id.btnrepetidas);
        siguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Intercambiar.class));
            }
        });

    }
}

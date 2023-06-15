package com.example.temas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView TV;
    private ListView LV;
    private String infop[] = {
            " es de color marron y esta mas cerca del sol",
            " es el planeta brillante, porque cuando se mira a Venus desde la Tierra se le ve brillar como una estrella.",
            " es el único planeta conocido sobre el que hay agua líquida y vida.",
            " tiene una atmosfera delgada formada por dioxido de carbono, y 2 satelites: Fobos y Deimos.",
            " es el planeta más grande. Es una gigantesca bola de gas con grandes tempestades en su interior. ",
            " es el segundo planeta por su tamaño. Tiene anillos formados por rocas y hielo. También tiene muchas lunas, la más importante se llama Titán.",
            " es el planeta más frío del Sistema Solar. Gira muy inclinado sobre si mismo.",
            " hay vientos muy violentos. Es el planeta más alejado de la Tierra, ya que Plutón no se considera un planeta por su pequeño tamaño."
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String TemaSeleccionado = intent.getStringExtra("Tema");

        if (TemaSeleccionado != null) {
            if (TemaSeleccionado.equals("Claro")) {
                setTheme(R.style.Theme_Temas);
            } else if (TemaSeleccionado.equals("Oscuro")) {
                setTheme(R.style.Oscuro);
            } else if (TemaSeleccionado.equals("Personalizado")) {
                setTheme(R.style.MiTema);
            }
        }


        setContentView(R.layout.activity_main);

        Spinner TM = (Spinner) findViewById(R.id.Spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Temas, android.R.layout.simple_spinner_item);

        TM.setAdapter(adapter);
        TM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                if (position>0){
                    String TemaSeleccionado = parent.getItemAtPosition(position).toString();
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    intent.putExtra("Tema", TemaSeleccionado);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        LV = (ListView) findViewById(R.id.LV);
        TV = (TextView) findViewById(R.id.TV);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this, R.array.Planetas, android.R.layout.simple_list_item_1);

        LV.setAdapter(adapter1);
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Planeta Seleccionado: "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                TV.setText(LV.getItemAtPosition(position).toString() + infop[position]);
            }
        });

}

/*
    private void getTema1() {
        Bundle extras = getIntent().getExtras();
        tvUsuario.setText(extras.get("Tema1").toString());
    }
    private void getTema2() {
        Bundle extras = getIntent().getExtras();
        tvContraseña.setText(extras.get("Tema2").toString());
    }
    private void getTema3() {
        Bundle extras = getIntent().getExtras();
        tvContraseña.setText(extras.get("Tema3").toString());
    }

 */

}
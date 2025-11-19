package com.pife.peliculas;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {
      ListView lv2;
      ArrayList<Integer> listaMarcadas;
      ArrayList<Pelicula> peliculas;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main6);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                  return insets;
            });

          listaMarcadas = getIntent().getIntegerArrayListExtra("marcadas");
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);

            lv2 = findViewById(R.id.lv2);
            ArrayList<Integer> seleccionadas;

            // Obtener posiciones seleccionadas desde MainActivity
            seleccionadas = getIntent().getIntegerArrayListExtra("seleccionadas");

            // Obtener todas las películas
            peliculas = new MainActivity().rellenaPeliculas();

            // Crear lista solo con las seleccionadas
            ArrayList<String> titulosSeleccionados = new ArrayList<>();
            if(seleccionadas != null) {
                  for(int pos : seleccionadas){
                        titulosSeleccionados.add(peliculas.get(pos).getTitulo());
                  }
            }

            // Mostrar en ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, titulosSeleccionados);
            lv2.setAdapter(adapter);

      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            if(item.getItemId()==android.R.id.home){
                  getOnBackPressedDispatcher().onBackPressed();
            }

            return super.onOptionsItemSelected(item);
      }
}
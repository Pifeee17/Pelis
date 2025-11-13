package com.pife.peliculas;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
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

public class MainActivity4 extends AppCompatActivity {
ArrayList<Pelicula> peliculas;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main4);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                  return insets;
            });


            peliculas = new MainActivity().rellenaPeliculas();
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Peliculas");
            actionBar.setDisplayHomeAsUpEnabled(true);
            ArrayList<String> titulos = new ArrayList<>();
            for (Pelicula pelicula : peliculas) {
                  titulos.add(pelicula.getTitulo() + "\n" + pelicula.getDirector());
            }
            ListView lv = findViewById(R.id.lv);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked,titulos);
            lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
            lv.setAdapter(adapter);
            lv.setItemChecked(2,true);

      }

      @Override
      public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.like,menu);
            return true;
      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home){
                  getOnBackPressedDispatcher().onBackPressed();
            }

            return super.onOptionsItemSelected(item);
      }
}
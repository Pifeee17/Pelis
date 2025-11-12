package com.pife.peliculas;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
      ArrayList<Pelicula> peliculas;
      GridLayoutManager gridLayoutManager;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main2);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                  return insets;
            });
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Peliculas");

            RecyclerView rv = findViewById(R.id.rv);
            peliculas = new MainActivity().rellenaPeliculas();
            Adaptador2 ada2 = new Adaptador2(peliculas, new Adaptador2.OnItemClickListener() {
                  @Override
                  public void onItemClick(Pelicula pelicula) {

                  }
            });
            rv.setAdapter(ada2);
            gridLayoutManager = new GridLayoutManager(this,1);
            rv.setLayoutManager(gridLayoutManager);

      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home) {
                  getOnBackPressedDispatcher().onBackPressed();
            }
            return super.onOptionsItemSelected(item);
      }
}
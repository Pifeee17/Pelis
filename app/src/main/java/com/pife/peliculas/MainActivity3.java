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

public class MainActivity3 extends AppCompatActivity {

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main3);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                  return insets;
            });
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Pelicula");
            actionBar.setDisplayHomeAsUpEnabled(true);
      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home){
                  getOnBackPressedDispatcher().onBackPressed();
            }
            return super.onOptionsItemSelected(item);
      }
}
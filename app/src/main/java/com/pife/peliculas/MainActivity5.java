package com.pife.peliculas;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main5);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                  return insets;
            });
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Nueva película");
            actionBar.setDisplayHomeAsUpEnabled(true);

            String[] salas={"Gran via","Travesía", "Plaza eliptica", "Vialia", "Multicines Norte"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, salas);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            Spinner spinner = findViewById(R.id.spinner);
            spinner.setAdapter(adapter);

      }

      @Override
      public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.like, menu);
            return true;
      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home){
                  getOnBackPressedDispatcher().onBackPressed();
            }else if(item.getItemId()==R.id.mGuardar){
                  EditText etTitulo = findViewById(R.id.editTextText);
                  EditText etDirecor = findViewById(R.id.editTextText2);
                  EditText etDuracion = findViewById(R.id.editTextText3);
            }

            return super.onOptionsItemSelected(item);
      }
}
package com.pife.peliculas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Date;

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
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));

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
                  EditText etDirector = findViewById(R.id.editTextText2);
                  EditText etDuracion = findViewById(R.id.editTextText3);
                  Spinner spinner = findViewById(R.id.spinner);
                  int imagenSeleccionada = 0;
                  RadioGroup radioGroup = findViewById(R.id.radioGroup);
                  if (radioGroup.getCheckedRadioButtonId()==R.id.radioButton){
                       imagenSeleccionada = R.drawable.g;
                  } else if (radioGroup.getCheckedRadioButtonId()==R.id.radioButton2) {
                       imagenSeleccionada = R.drawable.pg;
                  } else if (radioGroup.getCheckedRadioButtonId()==R.id.radioButton3) {
                        imagenSeleccionada = R.drawable.r;
                  } else if (radioGroup.getCheckedRadioButtonId()==R.id.radioButton4) {
                        imagenSeleccionada = R.drawable.pg13;
                  }else if (radioGroup.getCheckedRadioButtonId()==R.id.radioButton5){
                        imagenSeleccionada = R.drawable.nc17;
                  }

                  String titulo = etTitulo.getText().toString();
                  String director = etDirector.getText().toString();
                  Integer duracion = Integer.parseInt(etDuracion.getText().toString());
                  String sala = spinner.getSelectedItem().toString();


                  Pelicula nueva = new Pelicula(titulo,director, duracion,new Date(),sala, imagenSeleccionada, 0);

                  Intent intent = new Intent();
                  intent.putExtra("nuevaPeli", nueva);
                  setResult(RESULT_OK,intent);
                  finish();
            }

            return super.onOptionsItemSelected(item);
      }
}
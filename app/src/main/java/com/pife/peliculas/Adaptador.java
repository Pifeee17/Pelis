package com.pife.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MiCelda>{
      ArrayList<Pelicula> peliculas;

      public Adaptador(ArrayList<Pelicula> peliculas) {
            this.peliculas = peliculas;
      }

      @NonNull
      @Override
      public MiCelda onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celdas, parent, false);
            MiCelda celdavh = new MiCelda(celda);
            return celdavh;
      }

      @Override
      public void onBindViewHolder(@NonNull MiCelda holder, int position) {
      Pelicula pelis = peliculas.get(position);
      holder.nombre.setText(pelis.getTitulo());
      holder.caratula.setImageResource(pelis.getPortada());
      holder.director.setText(pelis.getDirector());
      holder.tipo.setImageResource(pelis.getClasi());

      }

      @Override
      public int getItemCount() {
            return peliculas.size();
      }

      public class MiCelda extends RecyclerView.ViewHolder{

            TextView nombre, director;
            ImageView caratula, tipo;

            public MiCelda(@NonNull View itemView) {
                  super(itemView);

                  this.nombre=itemView.findViewById(R.id.tvNombre);
                  this.caratula=itemView.findViewById(R.id.ivCaratula);
                  this.director=itemView.findViewById(R.id.tvDirector);
                  this.tipo=itemView.findViewById(R.id.ivTipo);
            }
      }
}

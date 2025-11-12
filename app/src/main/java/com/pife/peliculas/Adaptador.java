package com.pife.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MiCelda> {

      ArrayList<Pelicula> peliculas;
      private int num_colum;

      //Asegúrate de tener esto dentro de la clase Adaptador
      public interface OnItemClickListener {
            void onItemClick(Pelicula pelicula);
      }

      private OnItemClickListener listener;

      //Constructor que recibe la lista y el listener
      public Adaptador(ArrayList<Pelicula> peliculas, OnItemClickListener listener) {
            this.peliculas = peliculas;
            this.listener = listener;
      }

      @NonNull
      @Override
      public MiCelda onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celdas, parent, false);
            return new MiCelda(celda);
      }

      @Override
      public void onBindViewHolder(@NonNull MiCelda holder, int position) {
            Pelicula pelis = peliculas.get(position);
            holder.nombre.setText(pelis.getTitulo());
            holder.caratula.setImageResource(pelis.getPortada());
            holder.director.setText(pelis.getDirector());
            holder.tipo.setImageResource(pelis.getClasi());

            if (num_colum == 2) {
                  holder.nombre.setTextSize(14);
                  holder.director.setTextSize(10);
                  holder.caratula.getLayoutParams().height = 300;
                  holder.caratula.getLayoutParams().width = 200;
            }

            //Esto llama al listener cuando se pulsa una celda
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                        if (listener != null) listener.onItemClick(pelis);
                  }
            });
      }

      @Override
      public int getItemCount() {
            return peliculas.size();
      }

      public class MiCelda extends RecyclerView.ViewHolder {
            TextView nombre, director;
            ImageView caratula, tipo;

            public MiCelda(@NonNull View itemView) {
                  super(itemView);
                  nombre = itemView.findViewById(R.id.tvNombre);
                  caratula = itemView.findViewById(R.id.ivCaratula);
                  director = itemView.findViewById(R.id.tvDirector);
                  tipo = itemView.findViewById(R.id.ivTipo);
            }
      }
}

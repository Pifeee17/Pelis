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
      int pos;

      public int getPos() {
            return pos;
      }

      public void setPos(int posPulsada) {
            if(this.pos == posPulsada){
                  this.pos=RecyclerView.NO_POSITION;
                  notifyItemChanged(posPulsada);
            }else{
                  notifyItemChanged(this.pos);
                  this.pos=posPulsada;
                  notifyItemChanged(this.pos);
            }
      }

      private int num_colum=2;

      public int getNum_colum() {
            return num_colum;
      }

      public void setNum_colum(int num_colum) {
            this.num_colum = num_colum;
      }

      //      public interface OnItemClickListener {
//            void onItemClick(Pelicula pelicula);
//      }

//      private OnItemClickListener listener;

      //Constructor que recibe la lista y el listener
//      public Adaptador(ArrayList<Pelicula> peliculas, OnItemClickListener listener) {
//            this.peliculas = peliculas;
//            this.listener = listener;
//      }
      public Adaptador(ArrayList<Pelicula> peliculas) {
            this.peliculas = peliculas;
//            this.listener = listener;
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

            if(position==this.pos){
                  holder.itemView.setBackgroundResource(R.color.marcado);
            }else {
                  holder.itemView.setBackgroundResource(R.color.nomarcado);
            }

            if (num_colum == 2) {
                  holder.nombre.setTextSize(14);
                  holder.director.setTextSize(10);
                  holder.caratula.getLayoutParams().height = 300;
                  holder.caratula.getLayoutParams().width = 200;
                  holder.tipo.getLayoutParams().height=50;
                  holder.tipo.getLayoutParams().width=50;
            }else {

                  if (num_colum == 1) {
                        holder.nombre.setTextSize(24);
                        holder.director.setTextSize(20);
                        holder.caratula.getLayoutParams().height = 400;
                        holder.caratula.getLayoutParams().width = 300;
                        holder.tipo.getLayoutParams().height=150;
                        holder.tipo.getLayoutParams().width=150;
                  }
            }

//            //Esto llama al listener cuando se pulsa una celda
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                  @Override
//                  public void onClick(View v) {
//                        if (listener != null) listener.onItemClick(pelis);
//                  }
//            });
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
                  itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                              int pos=getAbsoluteAdapterPosition();
                              setPos(pos);
                              TextView tv=((MainActivity)itemView.getContext()).findViewById(R.id.tvDesc);
                                      tv.setText(peliculas.get(pos).getTitulo());
                        }
                  });
            }
      }
}

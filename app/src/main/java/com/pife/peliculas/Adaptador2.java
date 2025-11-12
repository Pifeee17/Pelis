package com.pife.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Adaptador2 extends RecyclerView.Adapter<Adaptador2.MiCelda2>{
      ArrayList<Pelicula> peliculas;

      public interface OnItemClickListener {
            void onItemClick(Pelicula pelicula);
      }

      private OnItemClickListener listener;


      public Adaptador2(ArrayList<Pelicula> peliculas, OnItemClickListener listener) {
            this.peliculas = peliculas;
            this.listener = listener;
      }


      @NonNull
      @Override
      public MiCelda2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda2,parent,false);
            return new MiCelda2(celda);
      }

      @Override
      public void onBindViewHolder(@NonNull MiCelda2 holder, int position) {
      Pelicula pelicula = peliculas.get(position);
      holder.tvTitulo.setText(pelicula.getTitulo());
      holder.tvDir.setText(pelicula.getDirector());
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
      holder.tvFec.setText(sdf.format(pelicula.getFecha()));
      holder.tvDur.setText(String.valueOf(pelicula.getDuracion()));
      holder.ivPort.setImageResource(pelicula.getPortada());
      holder.ivTip.setImageResource(pelicula.getClasi());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(listener!=null) listener.onItemClick(pelicula);
            }
      });

      }

      @Override
      public int getItemCount() {
            return peliculas.size();
      }

      public class MiCelda2 extends  RecyclerView.ViewHolder {
          ImageView ivPort, ivTip;
          TextView tvTitulo, tvDir, tvFec, tvDur, tvSala;
            public MiCelda2(@NonNull View itemView) {
                  super(itemView);
                  ivPort=itemView.findViewById(R.id.ivPort);
                  ivTip=itemView.findViewById(R.id.ivTip);
                  tvTitulo=itemView.findViewById(R.id.tvTitulo);
                  tvDir=itemView.findViewById(R.id.tvDir);
                  tvFec=itemView.findViewById(R.id.tvFec);
                  tvDur=itemView.findViewById(R.id.tvDur);
                  tvSala=itemView.findViewById(R.id.tvSala);
            }
      }
}

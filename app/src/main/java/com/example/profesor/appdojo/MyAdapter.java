package com.example.profesor.appdojo;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by profesor on 17/09/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Noticias> myList;
    private Handler h;

    public MyAdapter(List<Noticias> myList, Handler h)
    {
        this.myList = myList;
        this.h = h;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
        View v = li.inflate(R.layout.layoutitem, null);

        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Noticias not = myList.get(i);
        myViewHolder.getTxtTitulo().setText(not.getTitulo() + " " + not.getFecha());
        myViewHolder.getTxtDesc().setText(not.getDescripcion());
        //otra opcion: lanzo thread por esta etapa
        //Esto hay que corregirlo-> Lanzo muchos threads para buscar la misma imagen si vuelvo en el scroll y todavia no llegó la img
        //Se arregla con un atributo a persona , un flag que nos dice si se esta bajando la imagen
        //aca ponego flag= true
        //agrego la validacion en el if



    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}

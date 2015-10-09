package com.example.profesor.appdojo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by profesor on 17/09/2015.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView txtTitulo;
    private TextView txtDesc;
    private ImageView img;

    public MyViewHolder(View view){
        super(view);
        txtTitulo = (TextView) view.findViewById(R.id.txtNombre);
        txtDesc= (TextView) view.findViewById(R.id.txtTelefono);
        img = (ImageView) view.findViewById(R.id.imageView);

    }

    public TextView getTxtTitulo() {
        return txtTitulo;
    }

    public TextView getTxtDesc() {
        return txtDesc;
    }

    public ImageView getImg() {
        return img;
    }
}

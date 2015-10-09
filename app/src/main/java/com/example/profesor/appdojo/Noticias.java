package com.example.profesor.appdojo;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 *@author Alumnos
 * @version 1.0
 */
public class Noticias {

    private String titulo;
    private String descripcion;
    private String fecha;
    private String url;
    private Bitmap img;

    public Noticias() {
    }
    //arraybytes # bitmap
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }


    public Noticias(String titulo,String descripcion, String fecha,String url,Bitmap bImagen)
    {
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.img=bImagen;
        this.url=url;
        this.fecha=fecha;
    }

    public static List<Noticias> obtenerListaPersona(String persona)
    {
        List<Noticias> lista = new ArrayList<Noticias>();

        String[] lineas = persona.split("\\\n");

        for (String linea: lineas)
        {
            String[] datos = linea.split(";");

            Noticias unaPersona = new Noticias(datos[0],datos[1],datos[2], datos[3], null );

            lista.add(unaPersona);
        }


        return lista;
    }



}

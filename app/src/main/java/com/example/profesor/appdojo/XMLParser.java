package com.example.profesor.appdojo;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 01/10/2015.
 */
public class XMLParser {

    private String xml;

    public XMLParser(String xml)
    {
        this.xml = xml;
    }

    public List<Noticias> parser(){

        XmlPullParser parser = Xml.newPullParser();
        List<Noticias> noticias = new ArrayList<Noticias>();
        Noticias not;
        try {
            parser.setInput(new StringReader(xml));
            int event = parser.getEventType();

            while (event!=XmlPullParser.END_DOCUMENT){
                switch (event){



                    //Especie de eventos que van ocurriendo
                    case XmlPullParser.START_TAG:{
                        String tag = parser.getName();
                        not = new Noticias();
                        if (tag.equals("title")){
                           not.setTitulo(parser.getAttributeValue(null, "title"));
                        if (tag.equals("description"))
                           not.setDescripcion(parser.getAttributeValue(null, "description"));
                        if(tag.equals("image"))
                            //not.setUrl(parser.getAttributeValue(null, "image"));
                            //Porque es un valor y no un atributo
                            try {
                                not.setDescripcion(parser.nextText());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            noticias.add(not);
                            //el del RSS tiene tags anidados, hayq ue preguntar por los nombres de los tags
                            //Teniendo en cuenta que tag va a leer primero
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:{

                        break;
                    }


                }

                try {
                    event = parser.next();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return noticias;
    }

}

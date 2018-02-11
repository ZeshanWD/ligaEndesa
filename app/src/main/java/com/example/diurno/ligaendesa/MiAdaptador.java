package com.example.diurno.ligaendesa;

/**
 * Created by zeeshan on 28/10/2017.
 */
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by zeeshan on 24/10/2017.
 */

public class MiAdaptador extends BaseAdapter {

    // Declare Variables
    private Context context;
    private int layout;
    private List<Equipo> list;

    public MiAdaptador(Context context, int layout, List<Equipo> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Equipo getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * En este caso vamos a implementar el patron ViewHolder
         * para mejorar el rendimiento.
         */

        View row = convertView;

        if(convertView == null){
            /**
             * Va acceder aqui solo la primera vez, ya que va a ser nulo.
             * Cuando acceda aqui inflamos la vista y adjuntamos las referencias del layout
             * en una nueva instancia de nuestro ViewHolde, y la insertamos dentro del converview
             * para reciclar su uso.
             */
            row = LayoutInflater.from(parent.getContext()).inflate(layout, null);

            TextView titulo = (TextView) row.findViewById(R.id.list_item_nombre);
            TextView desc = (TextView) row.findViewById(R.id.list_item_lugar);
            ImageView imagen = (ImageView) row.findViewById(R.id.list_item_img);


            ViewHolder holder = new ViewHolder(titulo, desc, imagen);
            row.setTag(holder);


        } else {
            /**
             * Obtenemos la referencia que anteriormente pusimos dentro del convertview
             * Y asi, recilamos su uso sin necesidad de buscar de nuevo.
             */
            row = convertView;
        }

        // cogo el ViewHolder con el metodo getTag, ya que antes metimos con el setTag()
        ViewHolder holder = (ViewHolder) row.getTag();

        final Equipo equipoActual = getItem(position);

        holder.titulo.setText(equipoActual.getNombre());
        String descripcion = equipoActual.getLugar();
        holder.desc.setText(descripcion);
        holder.imagen.setImageResource(equipoActual.getImagen());

        return row;
    }

    static class ViewHolder{
        private TextView titulo;
        private TextView desc;
        private ImageView imagen;

        ViewHolder(TextView titulo, TextView desc, ImageView imagen){
            this.titulo = titulo;
            this.desc = desc;
            this.imagen = imagen;
        }
    }
}

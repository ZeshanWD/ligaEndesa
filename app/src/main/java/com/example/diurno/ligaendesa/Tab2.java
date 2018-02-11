package com.example.diurno.ligaendesa;

/**
 * Created by zeeshan on 27/10/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeeshan on 27/10/2017.
 */

public class Tab2 extends Fragment {

    private List<Equipo> listaDeEquipos;
    private MiAdaptador adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Esta es la forma de integrar un listview en un fragment que sea una tab
     * Es una forma muy interesante de hacer las cosas.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.tab2, container, false);

        // ListView
        listaDeEquipos = new ArrayList<Equipo>();
        listaDeEquipos = getAllEquipos();
        final ListView lista = (ListView) view.findViewById(R.id.listaEquiposEndesa);

        // ListView
        adapter = new MiAdaptador(getActivity(), R.layout.list_item, listaDeEquipos);
        lista.setAdapter(adapter);


        // item listener
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long l) {
                String nombre = listaDeEquipos.get(position).getNombre();
                String lugar = listaDeEquipos.get(position).getLugar();
                int imagen = listaDeEquipos.get(position).getImagen();
                String estadio = listaDeEquipos.get(position).getEstadio();
                String presidente = listaDeEquipos.get(position).getPresidente();
                String web = listaDeEquipos.get(position).getWeb();

                Intent intent = new Intent(getContext(), AcercaEquipo.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("lugar", lugar);
                intent.putExtra("imagen", imagen);
                intent.putExtra("estadio", estadio);
                intent.putExtra("presidente", presidente);
                intent.putExtra("web", web);
                startActivity(intent);
            }
        });

        return view;
    }

    private List<Equipo> getAllEquipos() {
        List<Equipo> lista = new ArrayList<Equipo>(){{
            add(new Equipo(R.drawable.madrid, "Real Madrid", "Madrid", "Palacio de Deportes de la Comunidad de Madrid", "Florentino Perez Rodriguez", "http://www.realmadrid.com/baloncesto"));
            add(new Equipo( R.drawable.baskonia_oficial, "Baskonia", "Vitoria", "Fernando Buesa Arena", "José Antonio Querejeta", "http://www.baskonia.com/"));
            add(new Equipo(R.drawable.unicaja, "Unicaja Baloncesto", "Malaga", "Palacio de Deportes José María Martín Carpena", "Eduardo García López", "https://www.unicajabaloncesto.com/"));
            add(new Equipo(R.drawable.barsa, "Futbol Club Barcelona", "Barcelona", "Palau Blaugrana", "Sito Alonso", "https://www.fcbarcelona.es/secciones/baloncesto"));
            add(new Equipo(R.drawable.valencia, "Valencia Basket", "Valencia", "Pabellón Fuente de San Luis", "Vicente Solà", "http://www.valenciabasket.com/?r=1&A=1366"));
            add(new Equipo(R.drawable.zaragoza, "Basket Zaragoza", "Zaragoza", "Pabellón Príncipe Felipe", "Reynaldo Benito", "http://www.basketzaragoza.net/"));
            add(new Equipo(R.drawable.bilbao, "Bilbao Basket", "Bilbao", "Bilbao Arena", "Koldo Mauraza", "http://www.bilbaobasket.biz/es/inicio.html"));
            add(new Equipo(R.drawable.sevilla, "Club Baloncesto Sevilla", "Sevilla", "Palacio de los Deportes de Sevilla", "Fernando Moral Alcaraz", "http://www.realbetisbaloncesto.com/"));
            add(new Equipo(R.drawable.fuenlabrada, "Baloncesto Fuenlabrada", "Fuenlabrada", "Polideportivo Fernando Martín", "josé Quintana Viar", "http://www.baloncestofuenlabrada.com/Landing"));
            add(new Equipo(R.drawable.canarias, "Club Baloncesto Canarias", "San cristobal de la laguna", "Pabellón Insular Santiago Martín", "Félix Hernández", "http://www.cbcanarias.net/front"));
            add(new Equipo(R.drawable.murcia, "Club Baloncesto Murcia", "Murcia", "Palacio de Deportes de Murcia", "José Luis Mendoza Pérez", "http://www.ucamdeportes.com/ucamcb/"));
            add(new Equipo(R.drawable.menorca, "Menorca Bàsquet", "Menorca", "Pabellón Menorca", "Benito Reynés", "http://basquetmenorca.com/"));
        }};
        return lista;
    }
}
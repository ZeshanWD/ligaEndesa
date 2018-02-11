package com.example.diurno.ligaendesa;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AcercaEquipo extends AppCompatActivity {

    private TextView nombreEquipo;
    private TextView lugarEquipo;
    private ImageView imagenEquipo;
    private TextView estadioEquipo;
    private TextView presidenteEquipo;
    private String webUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_equipo);

        // Cogemos todas las referencias
        nombreEquipo = (TextView) findViewById(R.id.nombre_equipo);
        lugarEquipo = (TextView) findViewById(R.id.ciudad_equipo);
        imagenEquipo = (ImageView) findViewById(R.id.logo_equipo);
        estadioEquipo = (TextView) findViewById(R.id.estadio_equipo);
        presidenteEquipo = (TextView)findViewById(R.id.presidente_equipò);

        // Cogemos la informacion del intent
        Bundle intent = getIntent().getExtras();
        if (intent != null){
            // Ahora vamos a inflar la vista con la informacion que nos a llegado.
            String nombre = intent.getString("nombre");
            String lugar = intent.getString("lugar");
            int imagen = intent.getInt("imagen");
            String estadio = intent.getString("estadio");
            String presidente = intent.getString("presidente");
            webUrl = intent.getString("web");

            nombreEquipo.setText(nombre);
            lugarEquipo.setText("ciudad: " + lugar);
            imagenEquipo.setImageResource(imagen);
            estadioEquipo.setText("Estadio: " + estadio);
            presidenteEquipo.setText("Presidente: " + presidente);

        }
    }

    public void pulsarBotonWeb(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
        startActivity(browserIntent);
    }
}

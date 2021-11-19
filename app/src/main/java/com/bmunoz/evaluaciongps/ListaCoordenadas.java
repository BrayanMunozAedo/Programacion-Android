package com.bmunoz.evaluaciongps;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaCoordenadas extends AppCompatActivity{
    BaseDeDatos miDB;
    ListView listac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_coordenadas);
        listac = (ListView) findViewById(R.id.lv_coordenadas);
        miDB = new BaseDeDatos(this);
        listac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = (listac.getItemAtPosition(position)).toString();

                String[] partes = texto.split(" ");
                String lat = partes[partes.length - 2 ];
                String lon = partes[partes.length - 1 ];

                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:" + lat + "," + lon));
                Intent chooser = Intent.createChooser(i, "Ir al mapa");
                startActivity(chooser);
            }
        });


        ArrayList<String>Listados = new ArrayList<>();
        Cursor data = miDB.getListaContenidos();
        if (data.getCount() == 0 ){
            Toast.makeText(this,"No hay lista que mostrar", Toast.LENGTH_LONG).show();
        }else{
            while (data.moveToNext()){
                Listados.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(
                        this, android.R.layout.simple_list_item_1,Listados);
                listac.setAdapter(listAdapter);

            }
        }



    }
}

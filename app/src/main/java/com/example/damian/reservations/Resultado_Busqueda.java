package com.example.damian.reservations;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Resultado_Busqueda extends AppCompatActivity implements AdaptadorCanchas.OnCanchaClickListener {
    private RecyclerView listado;
    private ArrayList<Cancha_Establecimiento> canchas;
    private Resources res;
    private AdaptadorCanchas adapter;
    private LinearLayoutManager llm;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado__busqueda);
        res = this.getResources();
        listado = (RecyclerView) findViewById(R.id.opciones);
        canchas = Buscar_Cancha.canchas;
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new AdaptadorCanchas(getApplicationContext(),canchas,this);

        listado.setLayoutManager(llm);
        listado.setAdapter(adapter);



    }


    @Override
    public void onCanchaClick(Cancha_Establecimiento p) {

        Intent i = new Intent(Resultado_Busqueda.this,Agregar_Reserva.class);
        Bundle b = new Bundle();
        b.putString("id_establecimiento",p.getId_establecimiento());
        b.putString("id_cancha",p.getId_cacha());
        b.putIntegerArrayList("programacion",p.getProgramacion());
        i.putExtra("datos",b);
        startActivity(i);

    }
}

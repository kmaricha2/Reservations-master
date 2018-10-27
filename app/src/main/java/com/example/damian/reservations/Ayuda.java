package com.example.damian.reservations;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Ayuda extends AppCompatActivity {
    private LinearLayout Liner_inicio,liner_buscar,liner_resultado,liner_fecha,liner_hora,liner_reserva,liner_mireserva,liner_detaller,liner_cancelar,liner_calificar;
   Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        res=this.getResources();
        Liner_inicio = (LinearLayout)findViewById(R.id.lay_inicio);
        liner_buscar = (LinearLayout)findViewById(R.id.lay_buscar);
        liner_resultado = (LinearLayout)findViewById(R.id.lay_Resultados);
        liner_fecha = (LinearLayout)findViewById(R.id.lay_fecha);
        liner_hora = (LinearLayout)findViewById(R.id.lay_hora);
        liner_reserva = (LinearLayout)findViewById(R.id.lay_compl_reserva);
        liner_mireserva = (LinearLayout)findViewById(R.id.lay_prin_detaller);
        liner_detaller = (LinearLayout)findViewById(R.id.lay_Detaller);
        liner_cancelar = (LinearLayout)findViewById(R.id.lay_eliminar);
        liner_calificar = (LinearLayout)findViewById(R.id.lay_favoritos);
        if (Liner_inicio.getVisibility() == View.GONE)
        {
            Metodos.animar(true,Liner_inicio);

        }
    }
    @Override
    public void onBackPressed() {
        Intent r = new Intent(Ayuda.this,Principal.class);
        startActivity(r);
        finish();
    }

    public void inicio(View v){
        liner_calificar.setBackground(null);
        Liner_inicio.setBackground(res.getDrawable(R.drawable.principalayuda,null));
        if (liner_calificar.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_calificar);
        }

            if (Liner_inicio.getVisibility() == View.GONE)
            {
                Metodos.animar(true,Liner_inicio);
        }
    }
    public void buscar(View v){
        Liner_inicio.setBackground(null);
        liner_buscar.setBackground(res.getDrawable(R.drawable.principalbusqueda,null));
        if (Liner_inicio.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,Liner_inicio);
        }
        if (liner_buscar.getVisibility() == View.GONE) {
            Metodos.animar(true,liner_buscar);
        }
    }
    public void resultado(View v){
        liner_buscar.setBackground(null);
        liner_resultado.setBackground(res.getDrawable(R.drawable.principalresultados,null));
        if (liner_buscar.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_buscar);
        }
        if (liner_resultado.getVisibility() == View.GONE)
        {
            Metodos.animar(true,liner_resultado);

        }
    }
    public void fecha(View v){
        liner_resultado.setBackground(null);
        liner_fecha.setBackground(res.getDrawable(R.drawable.principalfecha,null));
        if (liner_resultado.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_resultado);
        }
        if (liner_fecha.getVisibility() == View.GONE)
        {
            Metodos.animar(true,liner_fecha);

        }
    }
    public void hora(View v){
        liner_fecha.setBackground(null);
        liner_hora.setBackground(res.getDrawable(R.drawable.principalhoras,null));
        if (liner_fecha.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_fecha);
        }
        if (liner_hora.getVisibility() == View.GONE)
        {
            Metodos.animar(true,liner_hora);

        }
    }
    public void reserva(View v){
        liner_hora.setBackground(null);
        liner_reserva.setBackground(res.getDrawable(R.drawable.principalcompletar,null));
        if (liner_hora.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_hora);
        }
        if (liner_reserva.getVisibility() == View.GONE)
        {
            Metodos.animar(true,liner_reserva);

        }
    }
    public void mireserva(View v){
        liner_reserva.setBackground(null);
        liner_mireserva.setBackground(res.getDrawable(R.drawable.principalmireserva,null));
        if (liner_reserva.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_reserva);
        }
        if (liner_mireserva.getVisibility() == View.GONE)
        {
            Metodos.animar(true,liner_mireserva);

        }
    }
    public void detalle(View v){
        liner_mireserva.setBackground(null);
        liner_detaller.setBackground(res.getDrawable(R.drawable.principaldetallereserva,null));
        if (liner_mireserva.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_mireserva);
        }
        if (liner_detaller.getVisibility() == View.GONE)
        {
            Metodos.animar(true,liner_detaller);

        }
    }
    public void cancelar(View v){
        liner_detaller.setBackground(null);
        liner_cancelar.setBackground(res.getDrawable(R.drawable.principalcancelar,null));
        if (liner_detaller.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_detaller);
        }
        if (liner_cancelar.getVisibility() == View.GONE)
        {
            Metodos.animar(true,liner_cancelar);

        }
    }
    public void calificar(View v){
        liner_cancelar.setBackground(null);
        liner_calificar.setBackground(res.getDrawable(R.drawable.principalcalificar,null));
        if (liner_cancelar.getVisibility() == View.VISIBLE)
        {
            Metodos.animar(false,liner_cancelar);
        }
        if (liner_calificar.getVisibility() == View.GONE)
        {
            Metodos.animar(true,liner_calificar);

        }
    }
}

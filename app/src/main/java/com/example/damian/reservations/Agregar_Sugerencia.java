package com.example.damian.reservations;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Agregar_Sugerencia extends AppCompatActivity {
    private Resources res;
    private LinearLayout LinerSugerencia;
    private String id_user = "";
    private EditText tema,descripcion;
    private   String fechaSelecionada="";
    private int icon_warning =0;
    private int icon_good =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__sugerencia);
        res=this.getResources();
        icon_warning =R.drawable.milky_25;
        icon_good =R.drawable.icono_ok;
        LinerSugerencia = (LinearLayout)findViewById(R.id.laysugerencia);
        tema = (EditText) findViewById(R.id.txttema);
        descripcion = (EditText) findViewById(R.id.txtdescripcion);

        TraerId_sesion();
        Mostrar_Liner();
    }

    public void Guardar(View v){
        if (Metodos.ValidarCampo(tema)){
          Mensaje(R.string.ingrese_tema,icon_warning);
        }else  if (Metodos.ValidarCampo(descripcion)){
            Mensaje(R.string.ingrese_descripcion,icon_warning);
        }else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date date = new Date();
            fechaSelecionada = dateFormat.format(date);
            Sugerencias a = new Sugerencias("1",id_user,tema.getText().toString(),descripcion.getText().toString(),fechaSelecionada,false);
            Model_Sugerencias.GuardarSugerencia(a);
            Mensaje(R.string.sugerencia_guardada,icon_good);
            tema.setText("");
            descripcion.setText("");
            tema.requestFocus();
        }
    }
    public void Cancelar(View v){
        String positivo,negativo;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.titulo_cancelar));
        builder.setMessage(res.getString(R.string.cancelar_sugerencia));
        positivo = res.getString(R.string.si_cancelar);
        negativo = res.getString(R.string.no_cancelar);



        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onBackPressed();

            }
        });
        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();



    }
    public void TraerId_sesion(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            id_user=  user.getUid();
        }

    }
    @Override
    public void onBackPressed(){

        startActivity(new Intent(getBaseContext(), Principal.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();
    }

    public void Mostrar_Liner(){
        if (LinerSugerencia.getVisibility() == View.GONE)
        {
            Metodos.animar(true,LinerSugerencia);

        }
    }

    public void Mensaje(int mensaje,int img){
        //Toast.makeText(Login.this, mensaje, Toast.LENGTH_LONG).show();
        Toast toast3 = new Toast(getApplicationContext());

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.lytLayout));
        TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
        ImageView icon =(ImageView)layout.findViewById(R.id.iconomensaje);
        icon.setImageResource(img);
        txtMsg.setText(mensaje);
        toast3.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast3.setDuration(Toast.LENGTH_SHORT);
        toast3.setView(layout);
        toast3.show();

    }
}

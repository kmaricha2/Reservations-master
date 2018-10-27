package com.example.damian.reservations;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Calificar_Establecimiento extends AppCompatActivity {
    private RatingBar ratingBar;
    private float cal=2;
    private String uid_usuario="";
    private String id_reserva;
    private Bundle bundle;
    private Resources res;
    private Intent i;
    private int icon_warning =0;
    private int icon_good =0;
    private LinearLayout Linercal;
    float cal_actual=0;
    static float nueva_cal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar__establecimiento);
        res = this.getResources();

        i = getIntent();
        bundle = i.getBundleExtra("datos");
        id_reserva=bundle.getString("id");
        icon_warning =R.drawable.milky_25;
        icon_good =R.drawable.icono_ok;
        Linercal = (LinearLayout)findViewById(R.id.laycalificar);
        Mostrar_Liner();
        addListenerOnRatingBar();
        TraerId_sesion();

    }
    public void addListenerOnRatingBar() {
        cal_actual=Model_Favoritos.ObtenerCalificacion(id_reserva);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(res.getColor(R.color.amarillo,null), PorterDuff.Mode.SRC_ATOP);
        ratingBar.setRating(cal_actual);
        cal=cal_actual;
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) { cal=rating;  }
        });
    }
public static  void SetearValor(){
    nueva_cal=0;
    System.out.println(nueva_cal+"set");
}
    public boolean TraerId_sesion(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid_usuario = user.getUid();
            return  true;

        }
        return false;
    }
    public void Calificar(View v){
        if (cal==cal_actual){
            Mensaje(R.string.misma_calificacion, icon_warning);
        }else {
            nueva_cal=cal;
            Favoritos a = new Favoritos("1", uid_usuario, id_reserva, cal);
            Model_Favoritos.GuardarFavorito(a);
            Mensaje(R.string.calificacion_ok, icon_good);
            Model_Favoritos.TraerFavoritos(uid_usuario);
            onBackPressed();
        }
    }
    public void Cancelar(View v){

        String positivo,negativo;

        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.titulo_cancelar));
        builder.setMessage(res.getString(R.string.texto_cancelar_favoritos));
        positivo = res.getString(R.string.si_cancelar);
        negativo = res.getString(R.string.no_cancelar);



        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent x = new Intent(Calificar_Establecimiento.this,Detaller_Reserva.class);
                x.putExtra("datos",bundle);
                startActivity(x);
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
    @Override
    public void onBackPressed() {
        Intent x = new Intent(Calificar_Establecimiento.this,Detaller_Reserva.class);
        x.putExtra("datos",bundle);
        startActivity(x);
        finish();
    }

    public void Mostrar_Liner(){
        if (Linercal.getVisibility() == View.GONE){
            Metodos.animar(true,Linercal);

        }

    }
}

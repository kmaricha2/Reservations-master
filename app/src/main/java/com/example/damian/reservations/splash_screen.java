package com.example.damian.reservations;

import android.app.LauncherActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.SQLOutput;
import java.util.Timer;
import java.util.TimerTask;

public class splash_screen extends AppCompatActivity {
    private static final long SPLASH_SCREEN_DELAY = 2000;
    private static final long SPLASH_SCREEN_DELAY2 = 8000;
    private Bundle bundle;
    private String uid_usuario="",email="";
    private String uid;
    private Intent i;
    Resources res;
    TimerTask task,task2;
    private int icon_warning =0;
    private int icon_good =0;
     static boolean error=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res=this.getResources();
        error=false;
        i = getIntent();
        icon_warning =R.drawable.milky_25;
        icon_good =R.drawable.icono_ok;
        Traer();
        setContentView(R.layout.activity_splash_screen);
        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);

         task = new TimerTask() {
            @Override
            public void run() {

                if (!Moldel_Reservas.isEstado_cargue()){

                    Timer timer = new Timer();
                    timer.schedule(task2, SPLASH_SCREEN_DELAY2);

                }else {

                    startActivity(new Intent(getBaseContext(), Principal.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP ));
                    finish();
                    finish();

                }
            }
        };
          task2 = new TimerTask() {
            @Override
            public void run() {


                if (!Moldel_Reservas.isEstado_cargue()){
                    error=true;
                    startActivity(new Intent(getBaseContext(), Login.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    finish();

                }else {

                    startActivity(new Intent(getBaseContext(), Principal.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP ));
                    finish();
                    finish();

                }
            }
        };
        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    public void CompletarRegistroPersonaID_USUARIO(){
        bundle = i.getBundleExtra("datos");
        uid = bundle.getString("id");
        if (uid.length()!=0) {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {

                uid_usuario = user.getUid();
                Model_usuarios.ModificarLlaveID(uid, uid_usuario);


            }
        }
    }
    public boolean TraerId_sesion(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid_usuario = user.getUid();
            email=user.getEmail();

            return  true;

        }
        return false;
    }

    public  void Traer(){
        boolean en_session= TraerId_sesion();
        System.out.println(en_session+ "");
        if(en_session) {

            Model_usuarios.TraerInfo(uid_usuario);
            Model_Estableciminetos.CargarEstablecimientos(uid_usuario);
            Model_Favoritos.TraerFavoritos(uid_usuario);
            CompletarRegistroPersonaID_USUARIO();
            Model_usuarios.setEmanil_sesion(email);

        }else{
            System.out.println("error en sesion");
        }
    }

    @Override
    public void onBackPressed(){
        Toast.makeText(this,res.getString(R.string.espere_porfavor),Toast.LENGTH_SHORT).show();
    }

    }


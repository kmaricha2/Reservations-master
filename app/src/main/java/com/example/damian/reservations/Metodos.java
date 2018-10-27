package com.example.damian.reservations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by DAMIAN on 1/11/2017.
 */

public class Metodos {

    public static void animar(boolean mostrar,LinearLayout layoutAnimado)
    {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar)
        {
            //desde la esquina inferior derecha a la superior izquierda
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }
        else
        {    //desde la esquina superior izquierda a la esquina inferior derecha
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        }
        //duración en milisegundos
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        layoutAnimado.setLayoutAnimation(controller);
        layoutAnimado.startAnimation(animation);
        if (mostrar){
            layoutAnimado.setVisibility(View.VISIBLE);
        }else{
            layoutAnimado.setVisibility(View.GONE);
        }
    }
    public static boolean ValidarCampo(EditText campo){
        if (campo.getText().toString().length()==0){
            campo.requestFocus();
            return true;
        }
        return false;
    }
    public  static Integer  TraducirMensaje(String mensaje){
        if (mensaje.equalsIgnoreCase("The email address is badly formatted.")){
            //Toast.makeText(Agrega_Usuario.this, R.string.email_errado, Toast.LENGTH_LONG).show();
            return R.string.email_errado;
        }else if ((mensaje.equalsIgnoreCase("The given password is invalid. [ Password should be at least 6 characters ]"))){
            //Toast.makeText(Agrega_Usuario.this, R.string.contrasena_errado, Toast.LENGTH_LONG).show();
            return R.string.contrasena_errado;
        }else if ((mensaje.equalsIgnoreCase("An internal error has occurred. [ WEAK_PASSWORD  ]"))){
            //Toast.makeText(Agrega_Usuario.this, R.string.contrasena_errado, Toast.LENGTH_LONG).show();
            return R.string.contrasena_errado;
        }else if ((mensaje.equalsIgnoreCase("The email address is already in use by another account."))){
            //  Toast.makeText(Agrega_Usuario.this, R.string.cuenta_exite, Toast.LENGTH_LONG).show();
            return R.string.cuenta_exite;
        }else if ((mensaje.equalsIgnoreCase("There is no user record corresponding to this identifier. The user may have been deleted."))){
            //  Toast.makeText(Agrega_Usuario.this, R.string.cuenta_exite, Toast.LENGTH_LONG).show();
            return R.string.error_logear1;
        }else if ((mensaje.equalsIgnoreCase("The password is invalid or the user does not have a password."))){
            //  Toast.makeText(Agrega_Usuario.this, R.string.cuenta_exite, Toast.LENGTH_LONG).show();
            return R.string.error_logear2;
        }else{
            //Toast.makeText(Agrega_Usuario.this, mensaje, Toast.LENGTH_LONG).show();
            return -1;
        }

    }

 public static void CrearModeloTablas() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference DetallePersona = database.getReference("DetallePersona");
        DetallePersona.setValue("");

        DatabaseReference Favoritos = database.getReference("Favoritos");
        Favoritos.setValue("");

        DatabaseReference Canchas = database.getReference("Canchas");
        Canchas.setValue("");

        DatabaseReference Establecimientos = database.getReference("Establecimientos");
        Establecimientos.setValue("");

        DatabaseReference Reservas = database.getReference("Reservas");
        Reservas.setValue("");
    }

    public static String ConvertirHora(int x){
        if (x==12){
            return  "12 PM";
        }
        if (x==24){
            return  "12 AM";
        }
        if (x>12){
            return (x-12) + " PM";
        }
        return x+" AM";
    }

}

package com.example.damian.reservations;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Login extends AppCompatActivity {
    private LinearLayout LinerLogin;
    private Resources res;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private EditText email;
    private EditText password;
    private ProgressDialog progressDialog;
    private int icon_warning =0;
    private int icon_good =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        res=this.getResources();
        icon_warning =R.drawable.milky_25;
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
            }
        };
        if (TraerId_sesion() && splash_screen.error!=true){
            Intent i = new Intent(Login.this,splash_screen.class);
            Bundle b = new Bundle();
            b.putString("id","");
            i.putExtra("datos",b);
            startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP ));
            finish();
        }
        if (splash_screen.error==true){
            Mensaje(R.string.error_dba,icon_warning);
            splash_screen.error=false;
        }
        progressDialog= new ProgressDialog(this);
        System.out.println("cargo solo");
        LinerLogin = (LinearLayout)findViewById(R.id.layalogin);
        Mostrar_Liner();
        email= (EditText)findViewById(R.id.txtemaillogin);
        password = (EditText)findViewById(R.id.txtcontrasenalogin);
        email.setText("damian@gmail.com");
        password.setText("12345678");



    }

    public void Logear(View v){
        if (Metodos.ValidarCampo(email)){

             Mensaje(R.string.ingrese_usuario, icon_warning);
        }else  if (Metodos.ValidarCampo(password)){
            Mensaje(R.string.ingrese_contrasena, icon_warning);
        }else{
        signIn(email.getText().toString(),password.getText().toString());
    }
    }
    public void signIn(String email, String password){
          //agregas un mensaje en el ProgressDialog
          progressDialog.setMessage("Iniciado sesión");
            //muestras el ProgressDialog
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {

                    Intent i = new Intent(Login.this,splash_screen.class);
                    Bundle b = new Bundle();
                    b.putString("id","");
                    i.putExtra("datos",b);
                    progressDialog.dismiss();
                    startActivity(i);
                    finish();

                }else{
                    progressDialog.dismiss();
                    String m =task.getException().getMessage();

                    int res=  Metodos.TraducirMensaje(m);
                    if (res>0)Mensaje(res, icon_warning);
                    else Toast.makeText(Login.this, m, Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    public void Nuevo_usuario(View v){
        Intent i = new Intent(Login.this,Agrega_Usuario.class);startActivity(i);

    }
    public void Mostrar_Liner(){
        if (LinerLogin.getVisibility() == View.GONE){
            Metodos.animar(true,LinerLogin);

        }

    }
    public void Mostrar_Liner(View button)
    {
        Mostrar_Liner();
    }
    public void Mensaje(int mensaje,int img){
        //Toast.makeText(Login.this, mensaje, Toast.LENGTH_LONG).show();
        Toast toast3 = new Toast(getApplicationContext());

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup ) findViewById(R.id.lytLayout));
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
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authStateListener != null) {
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }
    public boolean TraerId_sesion(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            return  true;
        }
        return false;
    }
}

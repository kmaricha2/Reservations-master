package com.example.damian.reservations;

import android.app.ProgressDialog;
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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Modificar_Usuario extends AppCompatActivity {
    private Resources res;
    private LinearLayout LinerPersonas;
    private Spinner sexo;
    private ArrayAdapter<String> adapter;
    private String[] opc;
    private EditText txtCelular;
    private EditText txtNombre;
    private EditText txtApellido,txtnacimiento,txtcorreo;
    private ProgressDialog progressDialog;
    String uid = "";
    private int icon_warning =0;
    private int icon_good =0;
    private Bundle bundle;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar__usuario);
        res=this.getResources();
        i = getIntent();
        bundle = i.getBundleExtra("datos");
        uid=bundle.getString("id");
        icon_warning =R.drawable.milky_25;
        icon_good =R.drawable.milky_25;
        progressDialog= new ProgressDialog(this);
        LinerPersonas = (LinearLayout)findViewById(R.id.laydatospersona_modi);
        txtCelular = (EditText)findViewById(R.id.txtcelular_modi);
        txtNombre = (EditText)findViewById(R.id.txtnombre_modi);
        txtApellido=(EditText)findViewById(R.id.txtapellidos_modi);
        txtcorreo=(EditText)findViewById(R.id.txtcorreo_modi);
        txtnacimiento=(EditText)findViewById(R.id.txtnacimiento_modi);
        sexo = (Spinner)findViewById(R.id.cbxsexo_modi);
        opc = res.getStringArray(R.array.sexo);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        sexo.setAdapter(adapter);

        txtNombre.setText(bundle.getString("nombres"));
        txtApellido.setText(bundle.getString("apellidos"));
        txtCelular.setText(bundle.getString("celular"));
        txtcorreo.setText(bundle.getString("correo"));
        txtnacimiento.setText(bundle.getString("nacimiento"));
        sexo.setSelection(bundle.getInt("sexo"));


        Mostrar_Liner();
    }

    public void Mostrar_Liner(){

        if (LinerPersonas.getVisibility() == View.GONE)
        {
            Metodos.animar(true,LinerPersonas);

        }
    }
    public void Cancelar_modificar(View v){
        String positivo,negativo;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.titulo_cancelar));
        builder.setMessage(res.getString(R.string.texto_cancelar_modificar_usuario));
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

    public void ModificarPersona(View v) {
        if (Metodos.ValidarCampo(txtNombre)) {
            Mensaje(R.string.errado_nombre,icon_warning);
        } else if (Metodos.ValidarCampo(txtApellido)) {
            Mensaje(R.string.errado_apellidos,icon_warning);
        }else if (Metodos.ValidarCampo(txtCelular)) {
            Mensaje(R.string.errado_celular,icon_warning);
        }else if (Metodos.ValidarCampo(txtcorreo)) {
            Mensaje(R.string.errado_correo,icon_warning);
        }else if (Metodos.ValidarCampo(txtnacimiento)) {
            Mensaje(R.string.errado_nacimiento,icon_warning);
        }else {
            if (uid.toString().length() == 0) {
                Mensaje(R.string.error_cargar_detaller_eprsona, icon_warning);
            } else {
                detalle_usuarios d = new detalle_usuarios(txtNombre.getText().toString(), txtApellido.getText().toString(), txtCelular.getText().toString(), txtcorreo.getText().toString(), txtnacimiento.getText().toString(), sexo.getSelectedItemPosition(), uid, 0);
                System.out.println("id d" + uid);
                Model_usuarios.ModificarDetalleUsuario(d);
                Mensaje(R.string.detaller_modificado,icon_good);
                onBackPressed();
               }
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

    @Override
    public void onBackPressed() {
        Intent r = new Intent(Modificar_Usuario.this,Principal.class);
        startActivity(r);
        finish();
    }

}

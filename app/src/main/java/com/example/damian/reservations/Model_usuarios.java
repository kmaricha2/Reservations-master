package com.example.damian.reservations;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by android on 02/11/2017.
 */

public class Model_usuarios {
    static FirebaseDatabase  database = FirebaseDatabase.getInstance();
    static DatabaseReference  tabla = database.getReference("DetallePersona");
    //static ArrayList<detalle_usuarios> detalle = new ArrayList<detalle_usuarios>();
     static detalle_usuarios detalle_persona ;
    static String emanil_sesion="";

    public Model_usuarios() {
    }

    public static String getEmanil_sesion() {
        return emanil_sesion;
    }

    public static void setEmanil_sesion(String emanil_sesion) {
        Model_usuarios.emanil_sesion = emanil_sesion;
    }

    public static detalle_usuarios getDetalle_persona() {
        return detalle_persona;
    }

    public static void setDetalle_persona(detalle_usuarios detalle_persona) {
        Model_usuarios.detalle_persona = detalle_persona;
    }

    public static detalle_usuarios ObtenerDetallerPersona(){

        return detalle_persona;
    }
    public static  void SetDetalle(){
        detalle_persona=null;
    }

    public  static void GuardarDetalleUsuario(detalle_usuarios detalle) {
        detalle.setId(tabla.push().getKey());
        tabla.child(detalle.getId()).setValue(detalle);

    }
    public  static void ModificarDetalleUsuario(detalle_usuarios detalle) {
        tabla.child(detalle.getId()).child("nombres").setValue(detalle.getNombres());
        tabla.child(detalle.getId()).child("apellidos").setValue(detalle.getApellidos());
        tabla.child(detalle.getId()).child("celular").setValue(detalle.getCelular());
        tabla.child(detalle.getId()).child("correo").setValue(detalle.getCorreo());
        tabla.child(detalle.getId()).child("fecha_nacimiento").setValue(detalle.getFecha_nacimiento());
        tabla.child(detalle.getId()).child("sexo").setValue(detalle.getSexo());
        tabla.child(detalle.getId()).child("tipo").setValue(detalle.getTipo());

    }
    public static String  GenereLlave(){
      return  tabla.push().getKey();
    }

    public static void ModificarLlaveID(String id_detalle,String id_usuario) {
        tabla.child(id_detalle).child("id_usuarios").setValue(id_usuario);
    }

public static void TraerInfo(final String id_usuario){


    tabla.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()){
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                  //  System.out.println(snapshot.getValue()+"valor");
                    detalle_usuarios user = snapshot.getValue(detalle_usuarios.class);
                 if (user.getId_usuarios().toString().equals(id_usuario.toString())){
                    detalle_persona =user;
                    // detalle.add(user);

                  }


                }
            }


        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

            System.out.println("error" + databaseError.toException());
        }
    });


}


}

package com.example.damian.reservations;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by android on 15/11/2017.
 */

public class Model_Favoritos {
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference tabla = database.getReference("Favoritos");
    static ArrayList<Favoritos> misfavoritos = new ArrayList<>();
    static ArrayList<Favoritos> favoritosGenral = new ArrayList<>();
    public  static void GuardarFavorito(Favoritos f) {
        String obte=ObtenerId_Calificacion(f.getId_reserva());
        if (obte.toString().length()==0) {
            f.setId(tabla.push().getKey());
            tabla.child(f.getId()).setValue(f);
        }else{
            tabla.child(obte).child("calificacion").setValue(f.getCalificacion());
}
    }
    public static void TraerFavoritos(final String id_usuario){
        misfavoritos = new ArrayList<>();
        favoritosGenral = new ArrayList<>();
        tabla.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Favoritos f = snapshot.getValue(Favoritos.class);
                        favoritosGenral.add(f);
                        if (f.getId_usuario().toString().equals(id_usuario.toString())){
                            misfavoritos.add(f);
                        }
                        System.out.println(f.getId()+" val" + f.getId_usuario());

                    }
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                System.out.println("error" + databaseError.toException());
            }
        });


    }


    public static float ObtenerCalificacion(String reserva){
        for (int i = 0; i < misfavoritos.size() ; i++) {
            if (misfavoritos.get(i).getId_reserva().equals(reserva)){
                return misfavoritos.get(i).getCalificacion();
            }
        }
        return 0;
    }
    public static String ObtenerId_Calificacion(String reserva){
        for (int i = 0; i < misfavoritos.size() ; i++) {
            if (misfavoritos.get(i).getId_reserva().equals(reserva)){
                return misfavoritos.get(i).getId();
            }
        }
        return "";
    }
    public static double RaitingEstablecimiento_cancha(String id_establecimiento,String id_cancha){
        int num_total=0;
        double suma=0;
        for (int i = 0; i < favoritosGenral.size() ; i++) {
        Reservas x = Moldel_Reservas.TraerReservaBuscada(favoritosGenral.get(i).getId_reserva());
            if (x!=null){
                if (x.getId_establecimiento().equals(id_establecimiento) && x.getId_cancha().equals(id_cancha)){
                num_total++;
                suma=suma+favoritosGenral.get(i).getCalificacion();
                }
            }
        }
        if (num_total!=0){
            return suma/num_total;
        }
        return 0;
    }
}

package com.example.damian.reservations;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by DAMIAN on 4/11/2017.
 */

public class Moldel_Reservas {
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference tabla = database.getReference("Reservas");
    private static ArrayList<Cancha_Reserva> reservas = new ArrayList<Cancha_Reserva>();
    private static ArrayList<Reservas> reservasgeneral = new ArrayList<Reservas>();
    private static boolean estado_cargue=false;
    static int d=0;
    public static ArrayList<Cancha_Reserva> getReservas() {
        return reservas;
    }

    public static boolean isEstado_cargue() {
        return estado_cargue;
    }

    public static void setEstado_cargue(boolean estado_cargue) {
        Moldel_Reservas.estado_cargue = estado_cargue;
    }

    public static void setReservas() {
        reservas.clear();
    }

    public  static void GuardarReserva(Reservas r) {
        setReservas();
        r.setId(tabla.push().getKey());
        tabla.child(r.getId()).setValue(r);

    }
    public static void Cancelarreserva(String id_reserva) {
        setReservas();
        tabla.child(id_reserva).removeValue();


    }

    public static void TraerReservas(final String id_usuario){
        System.out.println("llamoooooooo" + d);
        d++;
        reservas.clear();
        reservasgeneral.clear();
        tabla.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Reservas r = snapshot.getValue(Reservas.class);
                        reservasgeneral.add(r);
                        if (r.getId_usuario().equals(id_usuario.toString())){
                            ArrayList<String> nombre_establecimiento = Model_Estableciminetos.BuscarDatosEstablecimiento(r.getId_establecimiento());
                            Cancha_Reserva a1 = new Cancha_Reserva(r.getId(),nombre_establecimiento.get(0),Model_Estableciminetos.BuscarNumCanchaId(r.getId_cancha(),r.getId_establecimiento()),r.getFecha(),r.getHora(),nombre_establecimiento.get(2),nombre_establecimiento.get(1),r.isEstado(),r.getId_establecimiento(),nombre_establecimiento.get(3));
                            reservas.add(a1);
                        }


                    }
                }

                 setEstado_cargue(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                System.out.println("error" + databaseError.toException());
            }
        });


    }


    public static boolean ValidarHora(String fecha,int hora,String Establecimiento,String id_cancha){
        for (int i = 0; i < reservasgeneral.size(); i++) {
            Reservas f=reservasgeneral.get(i);

        if (f.getFecha().equals(fecha) && f.getId_establecimiento().equals(Establecimiento) && f.getId_cancha().equals(id_cancha)){
            for (int j = 0; j < f.getHora().size(); j++) {
                if (f.getHora().get(j)==hora){
                    return  true;
                }
            }
        }
        }
        return false;

    }

    public static Reservas TraerReservaBuscada(String id){
        for (int i = 0; i < reservasgeneral.size(); i++) {
            if (reservasgeneral.get(i).getId().equals(id)){
                return reservasgeneral.get(i);
            }
        }
    return null;
    }
}

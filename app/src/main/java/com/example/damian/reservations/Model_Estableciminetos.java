package com.example.damian.reservations;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by DAMIAN on 5/11/2017.
 */

public class Model_Estableciminetos {
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference tabla = database.getReference("Establecimientos");
    static ArrayList<Establecimientos> establecimientos ;

    public  static void GuardarEstablecimientos(Establecimientos establecimientos) {
        establecimientos.setId(tabla.push().getKey());
        ArrayList<Canchas> ce = establecimientos.getCanchas();
        for (int i = 0; i <ce.size() ; i++) {
            ce.get(i).setId_establecimiento(establecimientos.getId());
            ce.get(i).setId(i+"");
        }
        tabla.child(establecimientos.getId()).setValue(establecimientos);


    }


    public static ArrayList<Establecimientos> getEstablecimientos() {
        return establecimientos;
    }

    public static void setEstablecimientos() {
        Model_Estableciminetos.establecimientos = new ArrayList<>();
    }

  /* public static void GuardarManual(){
        ArrayList<Integer> programacion = new ArrayList<>();
        for (int i = 8; i <22 ; i++) {
            programacion.add(i);
        }
        Canchas a = new Canchas("1","",1,8,"2",programacion);
        Canchas a1 = new Canchas("1","",2,6,"2",programacion);
        Canchas a2 = new Canchas("1","",3,7,"2",programacion);
        Canchas a3 = new Canchas("1","",1,6,"2",programacion);
        Canchas a4 = new Canchas("1","",2,9,"2",programacion);
        Canchas a5 = new Canchas("1","",1,8,"2",programacion);
        Canchas a6 = new Canchas("1","",2,8,"2",programacion);
        Canchas a7 = new Canchas("1","",1,6,"2",programacion);
        Canchas a8 = new Canchas("1","",1,9,"2",programacion);

        ArrayList<Canchas> ce = new ArrayList<>();
        ce.add(a);
        ce.add(a1);
        ArrayList<Canchas> ce1 = new ArrayList<>();
        ce1.add(a3);
        ce1.add(a4);
        ArrayList<Canchas> ce2 = new ArrayList<>();
        ce2.add(a5);
        ce2.add(a6);
        ArrayList<Canchas> ce3 = new ArrayList<>();
        ce3.add(a7);
        ce3.add(a8);
        ArrayList<Canchas> ce4 = new ArrayList<>();
        ce4.add(a2);



        Establecimientos e = new Establecimientos("1","El Tiburon","Murillo Toro #36 - 36","325689541",ce);
        Establecimientos e1 = new Establecimientos("12","La Bombonera","Olaya Herrera #67 - 23","325689541",ce1);
        Establecimientos e2 = new Establecimientos("13","La Patiada","Cra 20 #301","325689541",ce2);
        Establecimientos e3 = new Establecimientos("11","La Masia","Parque el Bosque, CI. 94#54","325689541",ce3);
        Establecimientos e4 = new Establecimientos("12","El Monumental","88, Cra 48#31","325689541",ce4);

        GuardarEstablecimientos(e);
        GuardarEstablecimientos(e1);
        GuardarEstablecimientos(e2);
        GuardarEstablecimientos(e3);
        GuardarEstablecimientos(e4);
    }
*/
    public static void CargarEstablecimientos(final String uid_usuario){

        establecimientos = new ArrayList<Establecimientos>();
        tabla.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Establecimientos c = snapshot.getValue(Establecimientos.class);
                        establecimientos.add(c);

                    }
                }

             Moldel_Reservas.TraerReservas(uid_usuario);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                System.out.println("error" + databaseError.toException());
            }
        });


    }

    public  static ArrayList<String> BuscarDatosEstablecimiento(String bus){


        ArrayList<String> x = new ArrayList<>();

        for (int i = 0; i <establecimientos.size() ; i++) {

            if (establecimientos.get(i).getId().equals(bus)){
                x.add(establecimientos.get(i).getNombre());
                x.add(establecimientos.get(i).getDireccion());
                x.add(establecimientos.get(i).getCelular());
                x.add(establecimientos.get(i).getFoto());
                return x;
            }

        }


        return x;
    }
    public  static String BuscarIDEstablecimiento(String bus){


        ArrayList<String> x = new ArrayList<>();

        for (int i = 0; i <establecimientos.size() ; i++) {

            if (establecimientos.get(i).getNombre().equalsIgnoreCase(bus)){
              return establecimientos.get(i).getId();
            }

        }


        return "";
    }
    public  static String BuscarNumCanchaId(String id,String stablecimiento){


        ArrayList<Canchas> x;

        for (int i = 0; i <establecimientos.size() ; i++) {

            if (establecimientos.get(i).getId().equalsIgnoreCase(stablecimiento)){
                x = establecimientos.get(i).getCanchas();
                for (int j = 0; j < x.size(); j++) {
                    int f= Integer.parseInt(id);
                    if (j==f){
                        return x.get(j).getNumCancha()+"";
                    }
                }
            }

        }


        return "";
    }
    public static ArrayList<Cancha_Establecimiento>  BuscarCanchas(String buscar,int metodo){
        ArrayList<Cancha_Establecimiento>   canchas_bus = new ArrayList<>();


        for (int i = 0; i <establecimientos.size() ; i++) {

            if (metodo==1) {

        if (establecimientos.get(i).getNombre().equalsIgnoreCase(buscar)){
            ArrayList<Canchas> canchas_estab=establecimientos.get(i).getCanchas();

            for (int j = 0; j <canchas_estab.size() ; j++) {

                Cancha_Establecimiento a = new Cancha_Establecimiento(canchas_estab.get(j).getId(),establecimientos.get(i).getNombre(),establecimientos.get(i).getDireccion(),establecimientos.get(i).getCelular(),"Num: "+canchas_estab.get(j).getTamano()+"",canchas_estab.get(j).getProgramacion(),establecimientos.get(i).getId(),establecimientos.get(i).getFoto());
                canchas_bus.add(a);
            }

        }

            }else  if (metodo==2) {
                int d = Integer.parseInt(buscar);
                ArrayList<Canchas> canchas_estab=establecimientos.get(i).getCanchas();
                for (int j = 0; j <canchas_estab.size() ; j++) {
                    if (canchas_estab.get(j).getTamano()==d) {
                        Cancha_Establecimiento a = new Cancha_Establecimiento(canchas_estab.get(j).getId(),establecimientos.get(i).getNombre(),establecimientos.get(i).getDireccion(),establecimientos.get(i).getCelular(),"Num: "+canchas_estab.get(j).getTamano()+"",canchas_estab.get(j).getProgramacion(),establecimientos.get(i).getId(),establecimientos.get(i).getFoto());
                        canchas_bus.add(a);
                    }

                }

            }else  if (metodo==3) {
                int d = Integer.parseInt(buscar);
                ArrayList<Canchas> canchas_estab=establecimientos.get(i).getCanchas();
                for (int j = 0; j <canchas_estab.size() ; j++) {
                    int re= (int) Model_Favoritos.RaitingEstablecimiento_cancha(establecimientos.get(i).getId(),canchas_estab.get(j).getId());
                    if (d==re) {
                        Cancha_Establecimiento a = new Cancha_Establecimiento(canchas_estab.get(j).getId(),establecimientos.get(i).getNombre(),establecimientos.get(i).getDireccion(),establecimientos.get(i).getCelular(),"Num: "+canchas_estab.get(j).getTamano()+"",canchas_estab.get(j).getProgramacion(),establecimientos.get(i).getId(),establecimientos.get(i).getFoto());
                        canchas_bus.add(a);
                    }

                }

            }

        }
        return canchas_bus;
    }
}

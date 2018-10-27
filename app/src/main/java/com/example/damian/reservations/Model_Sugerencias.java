package com.example.damian.reservations;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by android on 21/11/2017.
 */

public class Model_Sugerencias {
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference tabla = database.getReference("Sugerencias");

    public  static void GuardarSugerencia(Sugerencias r) {
        r.setId(tabla.push().getKey());
        tabla.child(r.getId()).setValue(r);
    }

}

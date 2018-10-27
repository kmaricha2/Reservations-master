package com.example.damian.reservations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
    }
    @Override
    public void onBackPressed() {
        Intent r = new Intent(informacion.this,Principal.class);
        startActivity(r);
        finish();
    }
}

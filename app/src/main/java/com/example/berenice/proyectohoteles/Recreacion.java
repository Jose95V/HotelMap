package com.example.berenice.proyectohoteles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Berenice on 28/04/2017.
 */

public class Recreacion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recreacion);

    }
    public void onPiscinaButton(View v) {
        Intent intent = new Intent(this,Piscina.class);
        startActivity(intent);
    }

    public void onBarButton(View v) {
        Intent intent = new Intent(this,Bar.class);
        startActivity(intent);
    }

    public void onPinButton(View v) {
        Intent intent = new Intent(this,Ping.class);
        startActivity(intent);
    }

    public void onJardinButton(View v) {
        Intent intent = new Intent(this,Jardin.class);
        startActivity(intent);
    }
}

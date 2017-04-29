package com.example.berenice.proyectohoteles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Berenice on 28/04/2017.
 */

public class Restaurante extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

    }
    public void onDesayunoButton(View v) {
        Intent intent = new Intent(this,Desayunos.class);
        startActivity(intent);
    }

    public void onStartComidasButton(View v) {
        Intent intent = new Intent(this,Comidas.class);
        startActivity(intent);
    }

    public void onStartBebidasButton(View v) {
        Intent intent = new Intent(this,Bebidas.class);
        startActivity(intent);
    }

}

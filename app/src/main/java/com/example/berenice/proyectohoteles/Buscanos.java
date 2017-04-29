package com.example.berenice.proyectohoteles;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Berenice on 28/04/2017.
 */

public class Buscanos extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscanos);
    }

    public void onFaceButton(View v) {
        Uri uri = Uri.parse("https://www.facebook.com/Hotel-Antigua-Comayagua-228635776409/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void onInstagranButton(View v) {
        Uri uri = Uri.parse("https://www.instagram.com/hotelantiguac/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onWebButton(View v) {
        Uri uri = Uri.parse("http://www.hotelantiguacomayagua.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }



}

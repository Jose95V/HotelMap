package com.example.berenice.proyectohoteles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Berenice on 08/04/2017.
 */

public class DetalleActivity extends AppCompatActivity {
    String jsonString;
    String video="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_activity);
        setTitle("Habitación");
        NetworkImageView niv= (NetworkImageView)findViewById(R.id.imagenDetalle);
        jsonString = getIntent().getStringExtra("imagen");
        try {
            JSONObject json = new JSONObject(jsonString);
            String url=json.getString("imagen");
           // ((TextView) findViewById(R.id._nombre)).setText(json.getString("precio"));
            ((TextView) findViewById(R.id._descripcion)).setText(json.getString("precio"));
            ((TextView) findViewById(R.id._direccion)).setText(json.getString("personas"));
            ((TextView) findViewById(R.id._correo)).setText(json.getString("descripcion"));
            niv.setImageUrl(url,MySingleton.getInstance(MainActivity.mContext).getImageLoader());

        } catch (JSONException excepcion) {

        } catch (Exception excepcion) {

            Log.d("DetalleActivity", excepcion.getMessage());
        }

        Log.d("DetalleActivity", "Terminar de crear actividad");
    }
    public void onStartReserva(View v) {
        Intent intent = new Intent(this,Reservacion.class);
        startActivity(intent);
    }
    protected void on (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_activity);
    }
}

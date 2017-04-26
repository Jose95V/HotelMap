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
 * Created by Berenice on 25/04/2017.
 */

public class DetalleInformacion extends AppCompatActivity {
    String jsonString;
    String video="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_informacion);
        setTitle("Detalle de Hotel");
        NetworkImageView niv= (NetworkImageView)findViewById(R.id.imagenDetalleI);
        jsonString = getIntent().getStringExtra("hotel");
        // JSONArray loans=response.getJSONArray("pelicula");
        try {
            JSONObject json = new JSONObject(jsonString);
            String url=json.getString("imagen");
            ((TextView) findViewById(R.id._nombreI)).setText(json.getString("nombrehotel"));
            ((TextView) findViewById(R.id._descripcionI)).setText(json.getString("descripcion"));
            ((TextView) findViewById(R.id._direccionI)).setText(json.getString("direccion"));
            ((TextView) findViewById(R.id._correoI)).setText(json.getString("correo"));
            niv.setImageUrl(url,MySingleton.getInstance(MainActivity.mContext).getImageLoader());

        } catch (JSONException excepcion) {

        } catch (Exception excepcion) {

             Log.d("DetalleInformacion", excepcion.getMessage());
        }

        Log.d("DetalleInformacion", "Terminar de crear actividad");
    }
    public void onStartReserva(View v) {
        Intent intent = new Intent(this,CeldaAdaptadorReserva.class);
        startActivity(intent);
    }
    protected void on (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_informacion);
    }
}

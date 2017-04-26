package com.example.berenice.proyectohoteles;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Berenice on 25/04/2017.
 */

public class Reservacion extends AppCompatActivity implements View.OnClickListener {


    Button insertar;
    EditText nombreR;
    EditText apellidoR;
    EditText correoR;
    EditText personasR;
    EditText llegadaR;
    EditText salidaR;
    Context context=null;


    //Ip de url
    String IP = "http://hotelmap.esy.es";

    // Rutas de los Web Services
    String INSERT = IP + "/InsertarHotel.php";

    ObtenerWebService hiloconexion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("Reservacion");

        context=this;
        // Enlaces con elementos visuales del XML

        nombreR= (EditText)findViewById(R.id.nombreR);
        apellidoR= (EditText)findViewById(R.id.apqllidoR);
        correoR = (EditText)findViewById(R.id.correoR);
        llegadaR = (EditText)findViewById(R.id.llegadaR);
        salidaR = (EditText)findViewById(R.id.salidaR);
        personasR= (EditText)findViewById(R.id.personasR);
        insertar = (Button)findViewById(R.id.reserva);

        insertar.setOnClickListener(this);


    }


    public void onClick(View v) {
        hiloconexion = new ObtenerWebService();
        hiloconexion.execute(INSERT,"1",nombreR.getText().toString(),apellidoR.getText().toString(),correoR.getText().toString(),llegadaR.getText().toString(),salidaR.getText().toString(),personasR.toString());   // Parámetros que recibe doInBackground

        nombreR.setText("");
        apellidoR.setText("");
        correoR.setText("");
        llegadaR.setText("");
        salidaR.setText("");
        personasR.setText("");
    }

    public class ObtenerWebService extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String cadena = params[0];
            URL url = null; // Url de donde queremos obtener información
            String devuelve = "";

            if (params[1] == "1") {    // Ingresar

                try {
                    HttpURLConnection urlConn;

                    DataOutputStream printout;
                    DataInputStream input;
                    url = new URL(cadena);
                    urlConn = (HttpURLConnection) url.openConnection();
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    urlConn.setRequestProperty("Accept", "application/json");
                    urlConn.connect();
                    //Creo el Objeto JSON
                    JSONObject jsonParam = new JSONObject();

                    jsonParam.put("nombrehotel", params[2]);
                    jsonParam.put("direccion", params[3]);
                    jsonParam.put("descripcion", params[4]);
                    jsonParam.put("ciudad", params[5]);
                    jsonParam.put("correo", params[6]);
                    jsonParam.put("personas", params[7]);

                    // Envio los parámetros post.
                    OutputStream os = urlConn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(jsonParam.toString());
                    writer.flush();
                    writer.close();

                    int respuesta = urlConn.getResponseCode();

                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK) {

                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                        while ((line = br.readLine()) != null) {
                            result.append(line);
                            //response+=line;
                        }

                        //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                        JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                        //Accedemos al vector de resultados

                        String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON
                        if (resultJSON == "1") {      // hay un Maestro que mostrar
                            devuelve = "Reserva agregada";


                        } else if (resultJSON == "2") {
                            devuelve = "Reserva no agregada";
                        }

                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return devuelve;


            }
            return null;
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }



    public void onStartAtras(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}



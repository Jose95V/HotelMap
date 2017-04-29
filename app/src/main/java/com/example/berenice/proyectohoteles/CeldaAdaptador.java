package com.example.berenice.proyectohoteles;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Berenice on 08/04/2017.
 */

public class CeldaAdaptador extends ArrayAdapter<JSONObject> {
    public CeldaAdaptador (Context context, int textViewResourseId){
        super(context, textViewResourseId);
    }
    public CeldaAdaptador(Context context, int resourse, List<JSONObject> items){
        super(context,resourse,items);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View celda = convertView;

        if (celda==null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            celda= layoutInflater.inflate(R.layout.celda_adaptador,null);
        }
        //Video video;


      /*  TextView descripcion=(TextView) celda.findViewById(R.id.descripcion);
        TextView genero=(TextView) celda.findViewById(R.id.genero);
        TextView clasificacion=(TextView) celda.findViewById(R.id.clasificasion);
*/
        NetworkImageView niv= (NetworkImageView)celda.findViewById(R.id.imagen);

        JSONObject elemento=this.getItem(position);
        try {

            String url=elemento.getString("imagen");

           /* descripcion.setText(elemento.getString("descripcion"));
            genero.setText("Genero: "+elemento.getString("genero"));
            clasificacion.setText("Clasificación: "+elemento.getString("clasificacion"));
*/

            niv.setImageUrl(url,MySingleton.getInstance(MainActivity.mContext).getImageLoader());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        celda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetalleInformacion.class);
                intent.putExtra("hotel", getItem(position).toString());
                getContext().startActivity(intent);
            }
        });


        return celda;
    }
}

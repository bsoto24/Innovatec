package com.codelab.innovatec.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codelab.innovatec.R;
import com.codelab.innovatec.entities.Centro;
import com.codelab.innovatec.entities.Deporte;

import java.util.ArrayList;

/**
 * Created by ALEXIS on 2/09/2017.
 */

public class CentroAdapter extends RecyclerView.Adapter<CentroAdapter.CentroViewHolder> {

    ArrayList<Centro> datos;
    Context context;

    public CentroAdapter(ArrayList<Centro> datos, Context context) {
        this.datos = datos;
        this.context = context;
    }

    @Override
    public CentroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CentroViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_centro, parent, false));
    }

    @Override
    public void onBindViewHolder(CentroViewHolder holder, int position) {

        Centro centro = datos.get(position);
        holder.imgCentro.setImageResource(centro.getImagen());
        holder.tvCentro.setText(centro.getNombre());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class CentroViewHolder extends RecyclerView.ViewHolder{

        TextView tvCentro;
        ImageView imgCentro;

        public CentroViewHolder(View itemView) {
            super(itemView);

            tvCentro = (TextView) itemView.findViewById(R.id.tv_centro);
            imgCentro= (ImageView) itemView.findViewById(R.id.img_centro);

        }
    }
}

package com.codelab.innovatec.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codelab.innovatec.R;
import com.codelab.innovatec.entities.Deporte;
import com.codelab.innovatec.entities.Locale;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ALEXIS on 2/09/2017.
 */

public class DeporteAdapter extends RecyclerView.Adapter<DeporteAdapter.DeporteViewHolder> {

    ArrayList<Deporte> datos;
    Context context;

    public DeporteAdapter(ArrayList<Deporte> datos, Context context) {
        this.datos = datos;
        this.context = context;
    }

    @Override
    public DeporteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeporteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deporte, parent, false));
    }

    @Override
    public void onBindViewHolder(DeporteViewHolder holder, int position) {

        Deporte deporte = datos.get(position);
        holder.imgDeporte.setImageResource(deporte.getImagen());
        holder.tvDeporte.setText(deporte.getDeporte());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class DeporteViewHolder extends RecyclerView.ViewHolder{

        TextView tvDeporte;
        ImageView imgDeporte;

        public DeporteViewHolder(View itemView) {
            super(itemView);

            tvDeporte = (TextView) itemView.findViewById(R.id.tv_deporte);
            imgDeporte= (ImageView) itemView.findViewById(R.id.img_deporte);

        }
    }
}

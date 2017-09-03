package com.codelab.innovatec.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codelab.innovatec.R;
import com.codelab.innovatec.activity.DetalleEventoActivity;
import com.codelab.innovatec.entities.Torneo;

import java.util.ArrayList;

/**
 * Created by Bryam Soto on 02/09/2017.
 */

public class TorneoAdapter extends RecyclerView.Adapter<TorneoAdapter.TorneoVH> {

    private Context context;
    private ArrayList<Torneo> data;

    public TorneoAdapter(Context context, ArrayList<Torneo> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public TorneoVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TorneoVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_torneo, parent, false));
    }

    @Override
    public void onBindViewHolder(TorneoVH holder, int position) {
        final Torneo torneo = data.get(position);
        holder.imgTorneo.setImageResource(torneo.getImagen());
        holder.tvTitulo.setText(torneo.getTitulo());
        holder.tvDeporte.setText(torneo.getDeporte());
        holder.tvFecha.setText(torneo.getFecha());
        holder.tvHora.setText(torneo.getHora());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetalleEventoActivity.class);
                intent.putExtra("torneo", torneo);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TorneoVH extends RecyclerView.ViewHolder {

        ImageView imgTorneo;
        TextView tvTitulo;
        TextView tvDeporte;
        TextView tvFecha;
        TextView tvHora;
        View itemView;

        public TorneoVH(View itemView) {
            super(itemView);

            this.itemView = itemView;
            imgTorneo = (ImageView) itemView.findViewById(R.id.img_torneo);
            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo);
            tvDeporte = (TextView) itemView.findViewById(R.id.tv_deporte);
            tvFecha = (TextView) itemView.findViewById(R.id.tv_fecha);
            tvHora = (TextView) itemView.findViewById(R.id.tv_hora);
        }
    }
}

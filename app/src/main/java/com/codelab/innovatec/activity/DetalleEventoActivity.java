package com.codelab.innovatec.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.codelab.innovatec.R;
import com.codelab.innovatec.entities.Torneo;

public class DetalleEventoActivity extends AppCompatActivity {

    private TextView tvTitulo;
    private TextView tvDireccion;
    private TextView tvFecha;
    private TextView tvDeporte;

    private ImageView imagen;

    private FloatingActionButton fabCalificar;

    private Torneo torneo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        torneo = (Torneo) getIntent().getSerializableExtra("torneo");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        fabCalificar = (FloatingActionButton) findViewById(R.id.fab_calificar);
        CollapsingToolbarLayout collapsing = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        tvDireccion = (TextView) findViewById(R.id.tv_direccion);
        tvFecha = (TextView) findViewById(R.id.tv_fecha);
        tvDeporte = (TextView) findViewById(R.id.tv_deporte);
        tvTitulo = (TextView) findViewById(R.id.tv_titulo);

        imagen = (ImageView) findViewById(R.id.image);
        imagen.setImageResource(torneo.getImagen());

        tvTitulo.setText(torneo.getTitulo());
        tvFecha.setText(torneo.getFecha() + "   " + torneo.getHora());
        tvDireccion.setText(torneo.getDirección());
        tvDeporte.setText(torneo.getDeporte());

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        collapsing.setTitle(" ");

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

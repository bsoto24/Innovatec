package com.codelab.innovatec.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.codelab.innovatec.R;
import com.codelab.innovatec.adapter.TorneoAdapter;
import com.codelab.innovatec.entities.Torneo;

import java.util.ArrayList;

public class EventosActivity extends AppCompatActivity {

    private RecyclerView rvTorneos;
    private FloatingActionButton btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torneos);
        showToolbar("Torneos Deportivos", true);

        rvTorneos = (RecyclerView) findViewById(R.id.rv_torneos);
        rvTorneos.setLayoutManager(new LinearLayoutManager(this));
        rvTorneos.setAdapter(new TorneoAdapter(this, getData()));

        btnCrear = (FloatingActionButton) findViewById(R.id.btn_crear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventosActivity.this, CrearEventoActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private ArrayList<Torneo> getData() {
        ArrayList<Torneo> data = new ArrayList<>();
        data.add(new Torneo("1er Campeonato de Voley MUNI", "Voley", "Sep 05", "Martes 9:00 AM", "Coliseo Dibos", R.drawable.voley));
        data.add(new Torneo("Torneo GOTENIS 2da Edición", "Tenis", "Sep 14", "Jueves 2:00 PM", "Campo de Marte", R.drawable.tenis));
        data.add(new Torneo("Concurso infantil de natación", "Natación", "Sep 25", "Lunes 10:00 AM", "AELU", R.drawable.natacion));
        return data;
    }
}

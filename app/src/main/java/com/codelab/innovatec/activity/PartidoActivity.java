package com.codelab.innovatec.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.codelab.innovatec.R;
import com.codelab.innovatec.adapter.TorneoAdapter;
import com.codelab.innovatec.entities.Torneo;

import java.util.ArrayList;

public class PartidoActivity extends AppCompatActivity {

    private RecyclerView rvTorneos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido);
        showToolbar("Mis partidos", true);


        rvTorneos = (RecyclerView) findViewById(R.id.rv_torneos);
        rvTorneos.setLayoutManager(new LinearLayoutManager(this));
        rvTorneos.setAdapter(new TorneoAdapter(this, getData()));
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
        data.add(new Torneo("Torneo GOTENIS 2da Edición", "Tenis", "Sep 14", "Jueves 2:00 PM", "Campo de Marte", R.drawable.tenis));
        return data;
    }
}

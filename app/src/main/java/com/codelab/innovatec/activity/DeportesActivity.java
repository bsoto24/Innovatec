package com.codelab.innovatec.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.codelab.innovatec.R;
import com.codelab.innovatec.adapter.DeporteAdapter;
import com.codelab.innovatec.entities.Deporte;

import java.util.ArrayList;

/**
 * Created by ALEXIS on 2/09/2017.
 */

public class DeportesActivity extends AppCompatActivity {

    private RecyclerView rvDeportes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deportes);
        showToolbar("Deportes", true);

        rvDeportes = (RecyclerView) findViewById(R.id.rv_deportes);
        rvDeportes.setLayoutManager(new GridLayoutManager(this, 2));
        rvDeportes.setAdapter(new DeporteAdapter(getData(), this));
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


    private ArrayList<Deporte> getData() {
        ArrayList<Deporte> datos = new ArrayList<>();
        datos.add(new Deporte("Futbol", R.drawable.futbol));
        datos.add(new Deporte("Basketball", R.drawable.basketball));
        datos.add(new Deporte("Tenis", R.drawable.tenis));
        datos.add(new Deporte("Fulbito", R.drawable.fulbito));
        datos.add(new Deporte("Karate", R.drawable.karate));
        datos.add(new Deporte("Judo", R.drawable.judo));
        datos.add(new Deporte("Boxeo", R.drawable.boxeo));
        datos.add(new Deporte("Atletismo", R.drawable.atletismo));
        datos.add(new Deporte("Natacion", R.drawable.natacion));
        datos.add(new Deporte("Voleyball", R.drawable.voley));
        datos.add(new Deporte("Badminton", R.drawable.badminton));
        return datos;
    }

}

package com.codelab.innovatec.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.codelab.innovatec.R;
import com.codelab.innovatec.adapter.CentroAdapter;
import com.codelab.innovatec.entities.Centro;

import java.util.ArrayList;

/**
 * Created by ALEXIS on 2/09/2017.
 */

public class CentrosActivity extends AppCompatActivity {

    private RecyclerView rvCentros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros);
        showToolbar("Centros deportivos", true);

        rvCentros = (RecyclerView) findViewById(R.id.rv_centros);
        rvCentros.setLayoutManager(new GridLayoutManager(this, 2));
        rvCentros.setAdapter(new CentroAdapter(getData(), this));
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


    private ArrayList<Centro> getData() {
        ArrayList<Centro> datos = new ArrayList<>();
        datos.add(new Centro("Club Regatas", R.drawable.clubregatas));
        datos.add(new Centro("Club Terrazas de Miraflores", R.drawable.clubterrazas));
        datos.add(new Centro("Federacion Peruana de Gimnasia", R.drawable.fpg));
        datos.add(new Centro("Tenis Peru", R.drawable.tenisjm));
        datos.add(new Centro("Futbol", R.drawable.cantolao));
        datos.add(new Centro("Basketball", R.drawable.portada));
        return datos;
    }

}

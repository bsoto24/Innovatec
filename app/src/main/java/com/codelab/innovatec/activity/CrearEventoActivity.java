package com.codelab.innovatec.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.innovatec.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class CrearEventoActivity extends AppCompatActivity {

    private SearchableSpinner spnDeporte, spnLugares;
    private Button btnPublica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);
        showToolbar("Crea tu evento", true);

        spnDeporte = (SearchableSpinner) findViewById(R.id.spn_deporte);
        spnLugares = (SearchableSpinner) findViewById(R.id.spn_lugares);

        btnPublica = (Button) findViewById(R.id.btn_publicar);

        btnPublica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage(view, "Tu evento ha sido publicado");
            }
        });

        List<String> deportes = new ArrayList<>();
        deportes.add("Futbol");
        deportes.add("Basket");
        deportes.add("Tenis");
        deportes.add("Fulbito");
        deportes.add("Karate");
        deportes.add("Judo");
        deportes.add("Boxeo");
        deportes.add("Atletismo");
        deportes.add("Natacion");
        deportes.add("Voleyball");
        deportes.add("Badminton");


        List<String> lugares = new ArrayList<>();
        lugares.add("Coliseo Dibos");
        lugares.add("Club Regatas");
        lugares.add("Circolo Deportivo");
        lugares.add("La Videna");
        lugares.add("IPD");
        lugares.add("UNMSM");
        lugares.add("Campo de Marte");


        spnLugares.setTitle("Selecciona un lugar");
        spnLugares.setPositiveButton("OK");

        spnDeporte.setTitle("Selecciona un deporte");
        spnDeporte.setPositiveButton("OK");

        ArrayAdapter<String> deporteAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, deportes);
        deporteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDeporte.setAdapter(deporteAdapter);

        ArrayAdapter<String> lugaresAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, lugares);
        lugaresAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnLugares.setAdapter(lugaresAdapter);

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

    public void showMessage(View view, String texto) {
        final Snackbar snackbar = Snackbar.make(view, texto, Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    }
                });

        //ACTION
        snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
        View snackBarView = snackbar.getView();
        //MESSAGE
        TextView tv = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(getResources().getColor(R.color.white));

        snackbar.show();
    }
}

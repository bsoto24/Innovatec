package com.codelab.innovatec.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.codelab.innovatec.R;
import com.codelab.innovatec.adapter.PreguntasAdapter;
import com.codelab.innovatec.entities.PreguntaTO;

import java.util.ArrayList;

public class PreguntaActivity extends AppCompatActivity {

    private RecyclerView rvPreguntas;
    private LinearLayoutManager llm;
    private PreguntasAdapter adapter;
    private FloatingActionButton btnMore;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Preguntas Frecuentes");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        btnMore = (FloatingActionButton) findViewById(R.id.btn_more);
        rvPreguntas = (RecyclerView) findViewById(R.id.rv_preguntas);
        llm = new LinearLayoutManager(this);
        rvPreguntas.setLayoutManager(llm);
        adapter = new PreguntasAdapter(getData(), this);
        rvPreguntas.setAdapter(adapter);

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private ArrayList<PreguntaTO> getData() {

        ArrayList<PreguntaTO> preguntas = new ArrayList<>();
        preguntas.add(new PreguntaTO("1. Quien puede ver mi informacion?", "Su informacion es totalmente privada pero si usted desea puede hacerla publica para usarla como datos estadisticos"));
        preguntas.add(new PreguntaTO("2. Puedo generar mas de 1 cupon a la vez?", "Solo puedes generar un cupon, luego de consumirlo nuevamente podras generar otros"));
        preguntas.add(new PreguntaTO("3. Quien puede ver mi informacion?", "Su informacion es totalmente privada pero si usted desea puede hacerla publica para usarla como datos estadisticos"));
        preguntas.add(new PreguntaTO("4. Puedo generar mas de 1 cupon a la vez?", "Solo puedes generar un cupon, luego de consumirlo nuevamente podras generar otros"));
        preguntas.add(new PreguntaTO("5. Quien puede ver mi informacion?", "Su informacion es totalmente privada pero si usted desea puede hacerla publica para usarla como datos estadisticos"));
        preguntas.add(new PreguntaTO("6. Puedo generar mas de 1 cupon a la vez?", "Solo puedes generar un cupon, luego de consumirlo nuevamente podras generar otros"));

        return preguntas;
    }
}

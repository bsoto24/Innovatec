package com.codelab.innovatec.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.codelab.innovatec.R;
import com.codelab.innovatec.entities.Locale;

public class LocaleActivity extends AppCompatActivity {

    private TextView tvDireccion;
    private TextView tvTelefono;
    private FloatingActionButton fabCalificar;

    private Locale locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locale);

        locale = (Locale) getIntent().getSerializableExtra("locale");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        fabCalificar = (FloatingActionButton) findViewById(R.id.fab_calificar);
        CollapsingToolbarLayout collapsing = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        tvDireccion = (TextView) findViewById(R.id.tv_direccion);
        tvTelefono = (TextView) findViewById(R.id.tv_telefono);

        tvTelefono.setText(locale.getLocalTaller());
        tvDireccion.setText(locale.getLocalDireccion());

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        collapsing.setTitle(locale.getLocalNombre());
        collapsing.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsing.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

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
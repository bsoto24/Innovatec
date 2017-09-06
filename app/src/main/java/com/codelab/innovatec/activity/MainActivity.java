package com.codelab.innovatec.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.codelab.innovatec.R;
import com.codelab.innovatec.fragment.LocaleFragment;
import com.codelab.innovatec.util.ActivityUtils;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FloatingActionButton btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SportFast");

        btnBuscar = (FloatingActionButton) findViewById(R.id.btn_buscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FiltroActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        LocaleFragment fragment = (LocaleFragment) getSupportFragmentManager().findFragmentById(R.id.body_local);
        if (fragment == null) {
            fragment = LocaleFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.body_local);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Intent intent = null;
        boolean flag = false;
        switch (id) {
            case R.id.nav_zona_deportiva:
                intent = new Intent(MainActivity.this, CentrosActivity.class);
                flag = true;
                break;
            case R.id.nav_deportes:
                intent = new Intent(MainActivity.this, DeportesActivity.class);

                flag = true;
                break;
            case R.id.nav_torneos:
                intent = new Intent(MainActivity.this, EventosActivity.class);
                flag = true;
                break;
            case R.id.nav_partidos:
                intent = new Intent(MainActivity.this, PartidoActivity.class);
                flag = true;
                break;
            case R.id.nav_salir:
                flag = false;
                this.finish();
                break;
            case R.id.nav_configurar:
                intent = new Intent(MainActivity.this, ConfiguracionActivity.class);
                flag = true;
                break;
            case R.id.nav_preguntas:
                intent = new Intent(MainActivity.this, PreguntaActivity.class);
                flag = true;
                break;

            default:
                flag = false;
                break;
        }
        if (flag) {
            drawer.closeDrawer(GravityCompat.START);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }
}

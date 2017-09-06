package com.codelab.innovatec.activity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.codelab.innovatec.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class FiltroActivity extends AppCompatActivity {


    private SearchableSpinner spnDeporte, spnLugares;
    private Button btnPublica;
    private SwitchCompat swDiscapacidad;
    private int NOTIFICATION_ID = 465023;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        spnDeporte = (SearchableSpinner) findViewById(R.id.spn_deporte);
        spnLugares = (SearchableSpinner) findViewById(R.id.spn_lugares);
        swDiscapacidad = (SwitchCompat) findViewById(R.id.sw_discapacidad);

        swDiscapacidad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    notification();
                }
            }
        });

        btnPublica = (Button) findViewById(R.id.btn_publicar);

        btnPublica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void notification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext());

        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle(getBaseContext().getString(R.string.app_name));
        String text = "Hoy partido de basket a las 10:00 AM ¿Te Apuntas?";
        builder.setContentText(text);

        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(notificationSound);
        builder.setAutoCancel(true);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        android.support.v4.app.TaskStackBuilder stackBuilder = android.support.v4.app.TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(notificationIntent);
        stackBuilder.addNextIntent(new Intent());

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();
        NotificationManagerCompat.from(getBaseContext()).notify(NOTIFICATION_ID + 3, notification);
    }

}

package com.codelab.innovatec.presenter;

import android.content.Context;
import android.widget.Toast;

import com.codelab.innovatec.contract.LocaleContract;
import com.codelab.innovatec.entities.Locale;
import com.codelab.innovatec.fragment.LocaleFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.List;

public class LocalePresenter implements LocaleContract {

    private GoogleMap mMap;
    private ClusterManager mClusterManager;
    private Context context;
    private LocaleFragment fragment;

    public LocalePresenter(GoogleMap mMap, Context context, LocaleFragment fragment) {
        this.mMap = mMap;
        this.context = context;
        this.fragment = fragment;
    }

    protected void showMarkers(ArrayList<Locale> items) {

        mClusterManager = new ClusterManager<>(context, mMap);
        mClusterManager.setRenderer(new StoreRenderer(context, fragment, mMap, mClusterManager));
        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterClickListener(fragment);
        mClusterManager.setOnClusterItemClickListener(fragment);

        addItems(items);
        mClusterManager.cluster();
    }

    @Override
    public void mostrarLocales() {
        ArrayList<Locale> datos = new ArrayList<>();
        datos.add(new Locale("1", "Cantolao", "Campo de Marte", "-12.0700534", "-77.0417081", "Academia de Futbol"));
        datos.add(new Locale("2", "Sporting Cristal", "Rimac", "-12.0593718", "-77.045644", "Academia de Futbol"));
        datos.add(new Locale("3", "Alianza Lima", "Estadio Matute", "-12.0690113", "-77.0271513", "Academia de Futbol"));
        showMarkers(datos);
    }

    private void addItems(ArrayList<Locale> items) {
        mClusterManager.addItems(items);
    }

}

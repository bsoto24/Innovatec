package com.codelab.innovatec.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.codelab.innovatec.R;
import com.codelab.innovatec.cardview.CardPagerAdapter;
import com.codelab.innovatec.cardview.ShadowTransformer;
import com.codelab.innovatec.entities.Deporte;


public class EncuestaActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        btnNext = (Button) findViewById(R.id.btn_next);

        mCardAdapter = new CardPagerAdapter();

        mCardAdapter.addCardItem(new Deporte("Futbol", R.drawable.futbol));
        mCardAdapter.addCardItem(new Deporte("Basket", R.drawable.basket));
        mCardAdapter.addCardItem(new Deporte("Tenis", R.drawable.tenis));
        mCardAdapter.addCardItem(new Deporte("Fulbito", R.drawable.fulbito));
        mCardAdapter.addCardItem(new Deporte("Karate", R.drawable.karate));
        mCardAdapter.addCardItem(new Deporte("Judo", R.drawable.judo));
        mCardAdapter.addCardItem(new Deporte("Boxeo", R.drawable.boxeo));
        mCardAdapter.addCardItem(new Deporte("Atletismo", R.drawable.atletismo));
        mCardAdapter.addCardItem(new Deporte("Natación", R.drawable.natacion));
        mCardAdapter.addCardItem(new Deporte("Voley", R.drawable.voley));
        mCardAdapter.addCardItem(new Deporte("Badminton", R.drawable.badminton));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}

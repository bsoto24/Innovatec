package com.codelab.innovatec.cardview;

import android.graphics.PorterDuff;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.codelab.innovatec.R;
import com.codelab.innovatec.entities.Deporte;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<Deporte> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        
    }

    public void addCardItem(Deporte item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_encuesta, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(final Deporte item, View view) {
        TextView tv_deporte = (TextView) view.findViewById(R.id.titleTextView);
        ImageView img_deporte = (ImageView) view.findViewById(R.id.img_card);
        final ImageView shadow = (ImageView) view.findViewById(R.id.shadow);

        tv_deporte.setText(item.getDeporte());
        img_deporte.setImageResource(item.getImagen());

        if(item.isSelected()){
            shadow.setVisibility(View.VISIBLE);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.isSelected()){
                    item.setSelected(false);
                    shadow.setVisibility(View.GONE);
                }else{
                    item.setSelected(true);
                    shadow.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}

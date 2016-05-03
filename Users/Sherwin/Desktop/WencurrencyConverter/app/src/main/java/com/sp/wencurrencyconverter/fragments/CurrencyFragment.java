package com.sp.wencurrencyconverter.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import com.sp.wencurrencyconverter.R;
import com.sp.wencurrencyconverter.adapters.CurrencyAdapter;
import com.sp.wencurrencyconverter.models.CurrencyEntity;

import java.util.ArrayList;

/**
 * Created by Sherwin on 4/29/2016.
 */
public class CurrencyFragment extends Fragment {

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager sglm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_currencies,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.fragment_curr_recyclerview);
        recyclerView.setHasFixedSize(true);
        sglm = new StaggeredGridLayoutManager(2,1);
        CurrencyEntity entity = new CurrencyEntity("AUD","1.0221","Australia",R.drawable.aus);
        CurrencyEntity entity1 = new CurrencyEntity("URU","49.50","Uruguay",R.drawable.uruguay);
        CurrencyEntity entity2 = new CurrencyEntity("TOG","12.0221","Togo",R.drawable.togo);
        CurrencyEntity entity3 = new CurrencyEntity("AFR","419.50","Africa",R.drawable.africa);
        ArrayList<CurrencyEntity> currencyEntities = new ArrayList<>();
        currencyEntities.add(entity);
        currencyEntities.add(entity1);
        currencyEntities.add(entity2);
        currencyEntities.add(entity3);
        recyclerView.setAdapter(new CurrencyAdapter(getContext(),currencyEntities));
        sglm.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sglm);

        return v;
    }

    public static CurrencyFragment getInstance() {
        CurrencyFragment sf = new CurrencyFragment();

        return sf;
    }
}

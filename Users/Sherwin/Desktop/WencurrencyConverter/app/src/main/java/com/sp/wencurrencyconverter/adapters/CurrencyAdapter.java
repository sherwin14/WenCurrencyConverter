package com.sp.wencurrencyconverter.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.AppCompatSpinner;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.sp.wencurrencyconverter.R;
import com.sp.wencurrencyconverter.Utilities;
import com.sp.wencurrencyconverter.enums.CurrencyCode;
import com.sp.wencurrencyconverter.models.CurrencyEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sherwin on 4/29/2016.
 */
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    private List<CurrencyEntity> currencyEntities;
    private Context context;
    public CurrencyAdapter(Context context,List<CurrencyEntity> currencyEntities) {
        this.context = context;
        this.currencyEntities = currencyEntities;
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.currency_card_view, parent, false);
        return new CurrencyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        CurrencyEntity currencyEntity = currencyEntities.get(position);
        holder.mCountrythumb.setImageResource(currencyEntity.getCountryThumb());

        Utilities.scaleImage(holder.mCountrythumb,context);
        holder.mCurrencySymbol.setText(currencyEntity.getCurrencySymbol());
        holder.mCurrencyValue.setText(currencyEntity.getCurrencyValue());
        holder.mCountry.setText(currencyEntity.getCountry());
        ArrayList<String> arrayList = new ArrayList<>();

        for (CurrencyCode c:CurrencyCode.values()) {
            arrayList.add(c.toString());
        }
        holder.mSpinner.setAdapter(new ArrayAdapter(context, android.R.layout.simple_spinner_item,arrayList));
        holder.mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT
                ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return currencyEntities.size();
    }

    public class CurrencyViewHolder extends RecyclerView.ViewHolder {
        protected TextView mCurrencySymbol;
        protected TextView mCurrencyValue;
        protected TextView mCountry;
        protected AppCompatSpinner mSpinner;
        protected ImageButton mImageButton;
        protected ImageView mCountrythumb;

        public CurrencyViewHolder(View itemView) {
            super(itemView);

            mCurrencySymbol = (TextView) itemView.findViewById(R.id.frag_currency_symbol);
            mCurrencyValue = (TextView) itemView.findViewById(R.id.frag_currency_value);
            mCountry = (TextView) itemView.findViewById(R.id.frag_currency_country);
            mSpinner = (AppCompatSpinner) itemView.findViewById(R.id.frag_currency_spinner);
            mImageButton = (ImageButton)  itemView.findViewById(R.id.frag_currency_more);
            mCountrythumb = (ImageView)  itemView.findViewById(R.id.frag_currency_thumb);

            mImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu pop = new PopupMenu(context,v);
                    pop.setOnDismissListener(new PopupMenu.OnDismissListener() {
                        @Override
                        public void onDismiss(PopupMenu menu) {

                        }
                    });

                    pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            return false;
                        }
                    });

                    pop.inflate(R.menu.pop_up);
                    pop.show();
                }

            });
        }
    }
}

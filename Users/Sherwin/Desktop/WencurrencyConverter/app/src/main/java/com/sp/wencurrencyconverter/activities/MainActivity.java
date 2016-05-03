package com.sp.wencurrencyconverter.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.sp.wencurrencyconverter.R;
import com.sp.wencurrencyconverter.ViewFindUtils;
import com.sp.wencurrencyconverter.fragments.CurrencyFragment;
import com.sp.wencurrencyconverter.fragments.SimpleCardFragment;
import com.sp.wencurrencyconverter.models.TabEntity;

import java.util.ArrayList;

/**
 * Created by Sherwin on 4/26/2016.
 */
public class MainActivity extends AppCompatActivity {
    private Context mContext = this;
    private TextView titleHead;
    private CommonTabLayout mTabLayout;
    private View mDecorView;
    private String[] mTitles = {"Currencies","Converter","Graph","Settings"};

    private int[] mIconUnSelected = {
      R.drawable.ic_local_atm_grey, R.drawable.ic_cached_grey,
            R.drawable.ic_equalizer_grey, R.drawable.ic_settings_grey
    };

    private int[] mIconSelected = {
            R.drawable.ic_local_atm_green, R.drawable.ic_cached_green,
            R.drawable.ic_equalizer_green, R.drawable.ic_settings_green
    };

    private ArrayList<CustomTabEntity> entities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        for(String title: mTitles){
            if(title == "Currencies"){
                mFragments.add(CurrencyFragment.getInstance());
            }else {
                mFragments.add(SimpleCardFragment.getInstance(title));
            }
        }

        for(int i=0; i< mTitles.length; i++){
            entities.add(new TabEntity(mTitles[i],mIconSelected[i],mIconUnSelected[i]));
        }
        mDecorView = getWindow().getDecorView();
        mTabLayout = ViewFindUtils.find(mDecorView, R.id.tl_2);


        mTabLayout.setTabData(entities, this, R.id.fl_change, mFragments);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mTabLayout.setCurrentTab(1);
        mTabLayout.showMsg(0, 55);
        mTabLayout.setMsgMargin(0, -5, 5);

        titleHead = (TextView) findViewById(R.id.appTitle);
        titleHead.setText("Wen Currency Converter");
        titleHead.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

       if(id == R.id.sync){
            Toast.makeText(this,"Syncing currency...",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    protected int dp2px(float dp) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}

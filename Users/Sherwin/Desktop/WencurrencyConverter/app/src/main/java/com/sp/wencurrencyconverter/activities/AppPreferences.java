package com.sp.wencurrencyconverter.activities;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import com.sp.wencurrencyconverter.R;

/**
 * Created by Sherwin on 4/27/2016.
 */
public class AppPreferences extends PreferenceActivity {

    private static int prefs = R.xml.preferences;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       try {
           getClass().getMethod("getFragmentManager");
           AddResourceApi11AndGreater();
       }catch (NoSuchMethodException e){
           AddResourceApiLessThan11();
       }
    }

    @SuppressWarnings("deprecation")
    protected void AddResourceApiLessThan11(){
        addPreferencesFromResource(prefs);
    }
    @TargetApi(11)
    protected void AddResourceApi11AndGreater(){
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PF()).commit();
    }

    @TargetApi(11)
    public static class PF extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(AppPreferences.prefs);
        }
    }
}

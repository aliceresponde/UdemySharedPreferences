package com.example.alice.udemysharedpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by alice on 10/28/16.
 * Blank Activity  without layout
 */
public class MyPreferencesAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SP())
                .commit();
    }

    /**
     * SharedPreference Fragment with an xml file for safe preferences
     */
    public static class SP extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //set xml
            addPreferencesFromResource(R.xml.my_preferences);
        }
    }
}

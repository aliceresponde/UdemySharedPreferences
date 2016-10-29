package com.example.alice.udemysharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    public static final String KEY_USERNAME = "username";
    public static final String MY_PEFS = "MyPefs";
    EditText etUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText) findViewById(R.id.etUserName);

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PEFS, MODE_PRIVATE);
        etUserName.setText(sharedPreferences.getString(KEY_USERNAME,""));
    }

    /**
     * Save data into Shared Preferences
     * @param view
     */
    public void safeUserName(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PEFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String strUserName = etUserName.getText().toString();
        editor.putString(KEY_USERNAME, strUserName);
        editor.commit();
    }

    /**
     * update color
     */
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences options = PreferenceManager.getDefaultSharedPreferences(this);
        boolean red = options.getBoolean("red",false);
        boolean green = options.getBoolean("green",false);
        boolean blue = options.getBoolean("blue",false);

        StringBuffer stringBufferColor = new StringBuffer();
        stringBufferColor.append("#");

        stringBufferColor.append( red? "FF":"00");
        stringBufferColor.append( green? "FF":"00");
        stringBufferColor.append( blue? "FF":"00");

        View rootView = (View) findViewById(R.id.root_view);
        rootView.setBackgroundColor(Color.parseColor(stringBufferColor.toString()));


    }

    /**
     * Open Shared Preferences Activity for options
     * @param view
     */
    public void lunchOptionActivity(View view) {
        Intent intent = new Intent( this, MyPreferencesAct.class);
        startActivity(intent);
    }
}

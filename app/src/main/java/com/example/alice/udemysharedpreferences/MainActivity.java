package com.example.alice.udemysharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
}

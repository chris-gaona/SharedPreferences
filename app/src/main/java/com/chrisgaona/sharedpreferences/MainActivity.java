package com.chrisgaona.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_FILE = "com.chrisgaona.sharedpreferences.preferences";
    private static final String KEY_EDITTEXT = "KEY_EDITTEXT";
    private EditText mEditText;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        // gets shared preferences ready to edit
        mEditor = mSharedPreferences.edit();

        // retrieve string from shared preferences
        // empty string for default value
        String editTextString = mSharedPreferences.getString(KEY_EDITTEXT, "");
        mEditText.setText(editTextString);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mEditor.putString(KEY_EDITTEXT, mEditText.getText().toString());
        // apply() saves it to shared preferences
        mEditor.apply();
    }
}

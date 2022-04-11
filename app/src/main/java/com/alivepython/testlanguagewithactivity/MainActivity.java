package com.alivepython.testlanguagewithactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go_to_with_bangla(View view) {

        SharedPreferences sharedPreferences= getSharedPreferences("language_select", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", "bn");
        editor.apply();

        startActivity(new Intent(getApplicationContext(),FirstActivity.class));
    }

    public void go_to_with_english(View view) {
        SharedPreferences sharedPreferences= getSharedPreferences("language_select", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", "en");
        editor.apply();

        startActivity(new Intent(getApplicationContext(),FirstActivity.class));
    }

    public void go_to_with_dutch(View view) {
        SharedPreferences sharedPreferences= getSharedPreferences("language_select", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", "de");
        editor.apply();

        startActivity(new Intent(getApplicationContext(),FirstActivity.class));
    }




    private void setApplicationLocale(String locale) {
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(new Locale(locale.toLowerCase()));
        }
        resources.updateConfiguration(config, dm);
    }


}
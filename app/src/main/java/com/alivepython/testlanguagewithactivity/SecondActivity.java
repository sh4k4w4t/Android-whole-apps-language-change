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
import android.widget.TextView;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    TextView textView6,textView7,textView8,textView9,textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences= getSharedPreferences("language_select", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("language")){
            String boolean_value = sharedPreferences.getString("language", "Data not found");
            setApplicationLocale(boolean_value);
        }
        setContentView(R.layout.activity_second);

        textView6= findViewById(R.id.textView6);
        textView7= findViewById(R.id.textView7);
        textView8= findViewById(R.id.textView8);
        textView9= findViewById(R.id.textView9);
        textView10= findViewById(R.id.textView10);


        textView6.setText(R.string.test5);
        textView7.setText(R.string.test4);
        textView8.setText(R.string.test3);
        textView9.setText(R.string.test2);
        textView10.setText(R.string.test1);



    }

    public void goto_first_activity(View view) {
        startActivity(new Intent(this,FirstActivity.class));
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

    public void goto_second_activity(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }

    public void convertedToEnglish(View view) {
        SharedPreferences sharedPreferences= getSharedPreferences("language_select", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", "de");
        editor.apply();

        finish();
        startActivity(getIntent());
    }
}
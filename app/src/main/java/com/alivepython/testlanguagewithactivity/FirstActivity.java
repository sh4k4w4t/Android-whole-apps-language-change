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

public class FirstActivity extends AppCompatActivity {

    TextView textView,textView2,textView3,textView4,textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences= getSharedPreferences("language_select", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("language")){
            String boolean_value = sharedPreferences.getString("language", "Data not found");
            setApplicationLocale(boolean_value);
        }
        setContentView(R.layout.activity_first);

        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);

        textView.setText(R.string.test1);
        textView2.setText(R.string.test2);
        textView3.setText(R.string.test3);
        textView4.setText(R.string.test4);
        textView5.setText(R.string.test5);

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
}
package com.example.androidarshinsky151;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String morningURI = "http://morning";
    public static final String dayURI = "http://afternoon";
    public static final String nightURI = "http://evening";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        final Button synchBut = findViewById(R.id.synchButton);

        synchBut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SYNC);
                DateFormat timeFormat = new SimpleDateFormat("HH", Locale.getDefault());
                String timeStr = timeFormat.format(Calendar.getInstance().getTime());
                int hour = Integer.parseInt(timeStr);


                if ((hour >= 6) & (hour < 13)) {

                    intent.setData(Uri.parse(morningURI));

                } else if (hour <= 14) {

                    intent.setData(Uri.parse(dayURI));
                } else {

                    intent.setData(Uri.parse(nightURI));
                }
                startActivity(intent);
            }
        });
    }
}

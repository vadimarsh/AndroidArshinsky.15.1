package com.example.androidarshinsky151;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class EveningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);
        init();
    }

    private void init() {
        setTitle(getString(R.string.evening));
        TextView timeTv = findViewById(R.id.timeTv);
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        String timeStr = hour+":"+minutes;
        timeTv.setText(timeStr);
    }
}

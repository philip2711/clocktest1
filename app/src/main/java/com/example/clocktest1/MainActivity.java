package com.example.clocktest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView textView = findViewById(R.id.date);
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                String currentDateandTime = sdf.format(new Date());
                                textView.setText(currentDateandTime);

                                TextView LosAngeles = findViewById(R.id.LosAngeles);
                                SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
                                String LADateandTime = df.format(new Date());
                                LosAngeles.setText(LADateandTime);

                                TextView London = findViewById(R.id.London);
                                SimpleDateFormat ldf = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                ldf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
                                String LondonDateandTime = ldf.format(new Date());
                                London.setText(LondonDateandTime);

                                TextView Tokyo = findViewById(R.id.Tokyo);
                                SimpleDateFormat tdf = new SimpleDateFormat("MMM dd yyyy\nh:mm:ss a");
                                tdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
                                String TokyoDateandTime = tdf.format(new Date());
                                Tokyo.setText(TokyoDateandTime);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();

    }
}
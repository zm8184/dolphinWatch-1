package com.example.dolphinwatch;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

public class WatchingActivity extends AppCompatActivity {
    public long startWatchingTime;
    Handler handler;
    TextView watchingTime, date, observerName;
    public static Vector sightings, bigEyesObservations;
    static RecyclerView sightingsRecView, bigEyesRecView;
    Button addNewSightingButton, addNewBigEyesObservationButton, endWatchingButton;
    int sightingsSize, bigEyesObservationsSize;
    public static LocalTime endOfWatching, startOfWatching;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watching);

        sightings = new Vector();
        bigEyesObservations = new Vector();
        bigEyesObservationsSize = 0;
        sightingsSize = 0;
        sightingsRecView = findViewById(R.id.sightingsRecView);
        bigEyesRecView = findViewById(R.id.bigEyesRecView);
        addNewSightingButton = findViewById(R.id.addNewSightingButton);
        startOfWatching = LocalTime.now();

        sightings = new Vector(); // inicializacija tabele sightings. V njej so zapisi iz razreda SightingForm

        // prva tri polja: Time observed, Date, Observer Name
        startTimer();
        date = findViewById(R.id.date);
        date.setText(LocalDate.now().getDayOfMonth() + ". " + LocalDate.now().getMonthValue() + ". " + LocalDate.now().getYear());
        observerName = findViewById(R.id.observerName);
        observerName.setText(MainActivity.observerName);

        addNewSightingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WatchingActivity.this, AddNewSightingActivity.class));
            }
        });

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (sightingsSize != sightings.size()) {
                                    initsightingsRecView();
                                    sightingsSize++;
                                }
                                if (bigEyesObservationsSize != bigEyesObservations.size()) {
                                    bigEyesObservationRecView();
                                    bigEyesObservationsSize++;
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

        addNewBigEyesObservationButton = findViewById(R.id.addNewBigEyesObservationButton);
        addNewBigEyesObservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WatchingActivity.this, AddNewBigEyesObservationActivity.class));
            }
        });

        endWatchingButton = findViewById(R.id.endWatchingButton);
        endWatchingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endOfWatching = LocalTime.now();
                startActivity(new Intent(WatchingActivity.this, EndWatchingActivity.class));
            }
        });

    }


    void startTimer() {
        handler = new Handler();
        watchingTime = findViewById(R.id.watchingTime);
        startWatchingTime = SystemClock.uptimeMillis();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                long milliseconds;
                int seconds, minutes, hours;

                milliseconds = SystemClock.uptimeMillis() - startWatchingTime;
                seconds = (int) milliseconds / 1000;
                minutes = seconds / 60;
                hours = minutes / 60;
                minutes %= 60;
                seconds %= 60;

                if (hours == 0)
                    watchingTime.setText(minutes + ":" + String.format("%02d", seconds));
                else
                    watchingTime.setText(hours + ":" + String.format("%02d",minutes) + ":" + String.format("%02d", seconds));

                handler.postDelayed(this, 0);
            }
        };

        handler.postDelayed(runnable, 0);

    }

    private void initsightingsRecView() {
        SightingsRecViewAdapter adapter = new SightingsRecViewAdapter(sightings, this);
        sightingsRecView.setAdapter(adapter);
        sightingsRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void bigEyesObservationRecView() {
        BigEyeObservationsRecViewAdapter adapter = new BigEyeObservationsRecViewAdapter(bigEyesObservations, this);
        bigEyesRecView.setAdapter(adapter);
        bigEyesRecView.setLayoutManager(new LinearLayoutManager(this));
    }
}

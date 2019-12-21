package com.example.dolphinwatch;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {
    public static long startedWatching = 0;
    public static String observerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startWatching = findViewById(R.id.startWatchButton);
        final EditText nameEditText = findViewById(R.id.nameEditText);

        startWatching.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                observerName = nameEditText.getText().toString();
                if (observerName.matches("")) {
                    Toast.makeText(getApplicationContext(), "You have to enter a name", Toast.LENGTH_SHORT).show();
                } else {
                    startedWatching = System.currentTimeMillis();
                    Intent intent = new Intent(MainActivity.this, WatchingActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

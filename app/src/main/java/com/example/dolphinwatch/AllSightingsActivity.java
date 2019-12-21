package com.example.dolphinwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AllSightingsActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sightings);
        recyclerView = findViewById(R.id.allSightingsRecView);
        initRecView();
    }

    private void initRecView() {
        AllSightingsRecViewAdapter adapter = new AllSightingsRecViewAdapter(WatchingActivity.sightings, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

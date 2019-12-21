package com.example.dolphinwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AllObservationsActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_observations);
        recyclerView = findViewById(R.id.allObservationsRecView);
        initRecView();
    }

    private void initRecView() {
        AllObservationsRecViewAdapter adapter = new AllObservationsRecViewAdapter(WatchingActivity.bigEyesObservations, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

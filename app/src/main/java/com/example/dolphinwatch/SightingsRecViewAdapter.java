package com.example.dolphinwatch;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;

public class SightingsRecViewAdapter extends RecyclerView.Adapter<SightingsRecViewAdapter.ViewHolder> {

    private Vector sightings = new Vector();
    private Context mContext;

    public SightingsRecViewAdapter(Vector sightings, Context mContext) {
        this.sightings = sightings;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sighting_rec_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        try {
            SightingForm sf = (SightingForm) sightings.get(i);
            viewHolder.dolphinLocationTextView.setText("Location: " + sf.getDolphinLocation());
            viewHolder.timeTextView.setText(String.format("%02d:%02d", sf.getTime().getHour(), sf.getTime().getMinute()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return sightings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dolphinLocationTextView, timeTextView;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dolphinLocationTextView = itemView.findViewById(R.id.dolphinLocationTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}

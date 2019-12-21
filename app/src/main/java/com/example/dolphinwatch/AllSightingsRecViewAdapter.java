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

public class AllSightingsRecViewAdapter extends RecyclerView.Adapter<AllSightingsRecViewAdapter.ViewHolder> {
    private Vector sightings;
    private Context mContext;

    public AllSightingsRecViewAdapter(Vector sightings, Context mContext) {
        this.sightings = sightings;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_sightings_rec_view, parent, false);
        AllSightingsRecViewAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SightingForm sf = (SightingForm) sightings.get(i);
        viewHolder.timeTextView.setText(String.format("%02d:%02d", sf.getTime().getHour(), sf.getTime().getMinute()));
        viewHolder.dataTextView.setText("Azimuth: " + sf.getAzimuth() + "\n" +
                                        "Reticules from horizon: " + sf.getReticulesFromHorizon() + "\n" +
                                        "Dolphin location (descriptive): " + sf.getDolphinLocation() + "\n" +
                                        "Minimum group size: " + sf.getMinGroupSize() + "\n" +
                                        "Estimated group size: " + sf.getEstimatedGroupSize() + "\n" +
                                        "Calves: " + (sf.isCalves() ? "Yes" : "No") + "\n" +
                                        "Behavioural state: " + sf.getBehaviouralState() + "\n" +
                                        "Behavioural event: " + sf.getBehaviouralEvent() + "\n" +
                                        "Sea state: " + sf.getSeaState() + "\n" +
                                        "Notes: " + sf.getNotes());
    }

    @Override
    public int getItemCount() {
        return sightings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView timeTextView, dataTextView;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            dataTextView = itemView.findViewById(R.id.dataTextView);
            parentLayout = itemView.findViewById(R.id.item_all_sightings_parent_layout);
        }
    }
}

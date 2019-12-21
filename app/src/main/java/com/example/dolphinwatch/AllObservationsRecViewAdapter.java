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

public class AllObservationsRecViewAdapter extends RecyclerView.Adapter<AllObservationsRecViewAdapter.ViewHolder> {
    private Vector observations;
    private Context mContext;

    public AllObservationsRecViewAdapter(Vector observations, Context mContext) {
        this.observations = observations;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_sightings_rec_view, parent, false);
        AllObservationsRecViewAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BigEyesForm bef = (BigEyesForm) observations.get(i);
        viewHolder.timeTextView.setText(String.format("%02d:%02d - %02d:%02d", bef.getStartTime().getHour(), bef.getStartTime().getMinute(), bef.getStopTime().getHour(), bef.getStopTime().getMinute()));
        viewHolder.dataTextView.setText("Place: " + bef.getPlace() + "\n" +
                "Observing area: " + bef.getObservingArea() + "\n" +
                "Equipment: " + bef.getEquipment() + "\n" +
                "Sea state: " + bef.getSeaState() + "\n" +
                "Visibility: " + bef.getVisibility() + "\n" +
                "Vessel: " + bef.getVessel() + "\n" +
                "Trawler: " + bef.getTrawler() + "\n" +
                "Sighting location: " + bef.getSightingLocation() + "\n" +
                "Distance estimated: " + bef.getDistanceEst() + "\n" +
                "Notes: " + bef.getNotes());
    }

    @Override
    public int getItemCount() {
        return observations.size();
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

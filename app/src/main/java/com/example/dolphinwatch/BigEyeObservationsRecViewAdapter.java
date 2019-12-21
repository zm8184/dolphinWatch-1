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

public class BigEyeObservationsRecViewAdapter extends RecyclerView.Adapter<BigEyeObservationsRecViewAdapter.ViewHolder> {
    private static final String TAG = "BigEyeObservationsRec";
    
    private Vector observations;
    private Context mContext;

    public BigEyeObservationsRecViewAdapter(Vector bigEyesObservations, WatchingActivity context) {
        this.observations = bigEyesObservations;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bigeyes_observtion_rec_view, parent, false);
        BigEyeObservationsRecViewAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BigEyesForm bef = (BigEyesForm) observations.get(i);
        viewHolder.place.setText("Place: " + bef.getPlace());
        viewHolder.timeOfObservation.setText(String.format("%02d:%02d - %02d:%02d", bef.getStartTime().getHour(), bef.getStartTime().getMinute(), bef.getStopTime().getHour(), bef.getStopTime().getMinute()));
    }

    @Override
    public int getItemCount() {
        return observations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView place, timeOfObservation;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            place = itemView.findViewById(R.id.placeTextView);
            timeOfObservation = itemView.findViewById(R.id.timeOfObservationTextView);
            parentLayout = itemView.findViewById(R.id.bigeyes_parent_layout);
        }
    }
}

package com.example.practica2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.SensorViewHolder> {

    private final List<String> sensorList;

    public SensorAdapter(List<String> sensorList) {
        this.sensorList = sensorList;
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sensors, parent, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        holder.txtText.setText(sensorList.get(position));
    }

    @Override
    public int getItemCount() {
        return sensorList != null ? sensorList.size() : 0;
    }

    public static class SensorViewHolder extends RecyclerView.ViewHolder {
        TextView txtText;

        public SensorViewHolder(@NonNull View itemView) {
            super(itemView);
            txtText = itemView.findViewById(R.id.txtText);
        }
    }
}
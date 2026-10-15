package com.example.practica2;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerSensors;
    private SensorManager gestionSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerSensors = findViewById(R.id.recyclerSensors);
        gestionSensors = (SensorManager) getSystemService(SENSOR_SERVICE);

        chargeSensors();
    }

    private void chargeSensors() {
        List<Sensor> list = gestionSensors.getSensorList(Sensor.TYPE_ALL);
        List<String> nameSensors = new ArrayList<>();

        for (Sensor sensor : list) {
            nameSensors.add(sensor.getName());
        }

        SensorAdapter adapter = new SensorAdapter(nameSensors);
        recyclerSensors.setAdapter(adapter);
    }
}
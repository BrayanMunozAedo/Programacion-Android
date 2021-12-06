package com.Bmunoz.sensores;


import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView txtSensores;
    private TextView txtAcce;
    private TextView txtLinear;

    private SensorManager sensorManager;
    private List<Sensor> sensores;

    private Sensor sensorA, sensorL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSensores=(TextView) findViewById(R.id.txt_sensores);
        txtAcce=(TextView) findViewById(R.id.txt_Acce);
        txtLinear=(TextView) findViewById(R.id.txt_Linear);

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensores=sensorManager.getSensorList(Sensor.TYPE_ALL);

        int i=1;
        for (Iterator<Sensor> it=sensores.iterator();it.hasNext();i++){
            Sensor sensor = it.next();
            txtSensores.append(String.format("%d:%s,%d, %s\n",i,sensor.getName(), sensor.getType(), sensor.getVendor()));
        }

        sensorA=(Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensorA , SensorManager.SENSOR_DELAY_NORMAL);

        sensorL=(Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorManager.registerListener(this, sensorL , SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()){
            case Sensor.TYPE_LINEAR_ACCELERATION:
                txtLinear.setText(String.format("%f",sensorEvent.values[0]));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                txtAcce.setText(String.format("%f",sensorEvent.values[0]));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
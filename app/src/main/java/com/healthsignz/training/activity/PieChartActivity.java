package com.healthsignz.training.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.healthsignz.training.R;
import com.healthsignz.training.widget.PieChart;

public class PieChartActivity extends AppCompatActivity {

    LinearLayout lv1;
    float values[] = { 120, 180, 500, 321, 123 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        lv1 = (LinearLayout) findViewById(R.id.linear);

        values = calculateData(values);
        PieChart pieChart = new PieChart(this, values);
        lv1.addView(pieChart);
    }

    private float[] calculateData(float[] data) {
        float total = 0;
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = 360 * (data[i] / total);
        }
        return data;
    }


}

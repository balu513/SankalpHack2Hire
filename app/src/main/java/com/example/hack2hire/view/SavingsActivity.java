package com.example.hack2hire.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hack2hire.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class SavingsActivity extends AppCompatActivity {

    private BarChart barChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);
        barChat = (BarChart)findViewById(R.id.barchar_savings);
        showBarChart();
        showSavingsList();
    }

    private void showSavingsList() {

    }

    private void showBarChart() {
        ArrayList<BarEntry> BarEntry = new ArrayList<>();
        BarEntry.add(new BarEntry(5000, 0));
        BarEntry.add(new BarEntry(1000, 1));
        BarEntry.add(new BarEntry(100, 2));
        BarEntry.add(new BarEntry(80, 3));
        BarEntry.add(new BarEntry(390, 4));
        BarEntry.add(new BarEntry(700, 5));

        BarDataSet dataSet = new BarDataSet(BarEntry, "Transactions");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        BarData data = new BarData(labels, dataSet);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChat.setData(data);
        barChat.setDescription("No of Projects");
    }
}

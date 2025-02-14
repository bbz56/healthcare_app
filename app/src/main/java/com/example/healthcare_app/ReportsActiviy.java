package com.example.healthcare_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReportsActiviy extends AppCompatActivity {

    private RecyclerView recyclerView;
    private com.example.healthcare.ReportsAdapter reportsAdapter;
    private List<com.example.healthcare.HealthReport> reportsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_activiy);

        recyclerView = findViewById(R.id.recyclerViewReports);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reportsList = new ArrayList<>();
        reportsList.add(new com.example.healthcare.HealthReport("1", "Blood Test", "2025-02-10"));
        reportsList.add(new com.example.healthcare.HealthReport("2", "X-Ray Report", "2025-02-08"));
        reportsList.add(new com.example.healthcare.HealthReport("3", "MRI Scan", "2025-02-05"));

        reportsAdapter = new com.example.healthcare.ReportsAdapter(reportsList);
        recyclerView.setAdapter(reportsAdapter);
    }
}

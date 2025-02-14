package com.example.healthcare_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PharmacyListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PharmacyAdapter pharmacyAdapter;
    private List<Pharmacy> pharmacyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_list);

        recyclerView = findViewById(R.id.recyclerViewPharmacy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample Data
        pharmacyList = new ArrayList<>();
        pharmacyList.add(new Pharmacy("1", "City Pharmacy", "Main Street"));
        pharmacyList.add(new Pharmacy("2", "HealthPlus Pharmacy", "Downtown"));
        pharmacyList.add(new Pharmacy("3", "MediCare Pharmacy", "Uptown"));

        pharmacyAdapter = new PharmacyAdapter(pharmacyList);
        recyclerView.setAdapter(pharmacyAdapter);
    }
}

package com.example.healthcare_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DoctorList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> doctorList = new ArrayList<>();
        doctorList.add(new Item("Dr. Ethan White", "Cardiologist", R.drawable.doctor1));
        doctorList.add(new Item("Dr. Liam Anderson", "Dermatologist", R.drawable.doctor2));
        doctorList.add(new Item("Dr. Alex Brown", "Endocrinologist", R.drawable.doctor3));
        doctorList.add(new Item("Dr. John Carter", " Pediatrician", R.drawable.doctor4));
        doctorList.add(new Item("Dr. Sophia Hernandez ", "Oncologist", R.drawable.doctor5));
        doctorList.add(new Item("Dr. Isabella Clark ", "Ophthalmologist", R.drawable.doctor6));
        doctorList.add(new Item("Dr. Sarah Smith", "Neurologist", R.drawable.doctor7));

        recyclerView.setAdapter(new MyAdapter(this, doctorList));
    }
}

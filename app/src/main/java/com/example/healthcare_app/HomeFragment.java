package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        Button btnBookAppointment = view.findViewById(R.id.btnBookAppointment);
        Button btnHealthTips = view.findViewById(R.id.btnHealthTips);
        ImageView imgDoctor = view.findViewById(R.id.imgDoctor);
        ImageView imgReports = view.findViewById(R.id.imgReports);
        ImageView imgPharmacy= view.findViewById(R.id.imgPharmacy);


        btnBookAppointment.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), Appointment.class);
            startActivity(intent);
        });

        btnHealthTips.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), HealthTips.class);
            startActivity(intent);
        });

        imgDoctor.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DoctorList.class);
            startActivity(intent);
        });

        imgReports.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ReportsActiviy.class);
            startActivity(intent);
        });

        imgPharmacy.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), PharmacyListActivity.class);
            startActivity(intent);
        });


        return view;
    }
}

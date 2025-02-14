package com.example.healthcare_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.PharmacyViewHolder> {

    private List<Pharmacy> pharmacyList;

    public PharmacyAdapter(List<Pharmacy> pharmacyList) {
        this.pharmacyList = pharmacyList;
    }

    @NonNull
    @Override
    public PharmacyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pharmacy, parent, false);
        return new PharmacyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PharmacyViewHolder holder, int position) {
        Pharmacy pharmacy = pharmacyList.get(position);
        holder.textViewName.setText(pharmacy.getName());
        holder.textViewLocation.setText("Location: " + pharmacy.getLocation());
    }

    @Override
    public int getItemCount() {
        return pharmacyList.size();
    }

    static class PharmacyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewLocation;

        public PharmacyViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewPharmacyName);
            textViewLocation = itemView.findViewById(R.id.textViewPharmacyLocation);
        }
    }
}

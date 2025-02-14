package com.example.healthcare_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.ReportViewHolder> {

    private List<com.example.healthcare.HealthReport> reportsList;

    public ReportsAdapter(List<com.example.healthcare.HealthReport> reportsList) {
        this.reportsList = reportsList;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report, parent, false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        com.example.healthcare.HealthReport report = reportsList.get(position);
        holder.textViewTitle.setText(report.getTitle());
        holder.textViewDate.setText("Date: " + report.getDate());
    }

    @Override
    public int getItemCount() {
        return reportsList.size();
    }

    static class ReportViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDate;

        public ReportViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
        }
    }
}

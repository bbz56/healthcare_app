package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<com.example.healthcare.MyViewHolder> {
    Context context;
    List<com.example.healthcare.Item> items;

    public MyAdapter(Context context, List<com.example.healthcare.Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public com.example.healthcare.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new com.example.healthcare.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.healthcare.MyViewHolder holder, int position) {
        com.example.healthcare.Item item = items.get(position);
        holder.nameView.setText(item.getName());
        holder.tvSpeciality.setText(item.getSpeciality());
        holder.imageView.setImageResource(item.getImageResId());

        holder.bookButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, Appointment.class);
            intent.putExtra("doctorName", item.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}


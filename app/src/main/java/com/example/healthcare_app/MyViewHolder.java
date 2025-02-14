package com.example.healthcare;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nameView, tvSpeciality;
    ImageView imageView;
    Button bookButton;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.tvDoctorName);
        tvSpeciality = itemView.findViewById(R.id.tvSpeciality);
        imageView = itemView.findViewById(R.id.imgDoctor);
        bookButton = itemView.findViewById(R.id.btnBook);
    }
}

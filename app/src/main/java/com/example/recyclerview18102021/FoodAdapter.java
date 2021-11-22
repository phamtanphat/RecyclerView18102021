package com.example.recyclerview18102021;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvName, tvAddress, tvBusinessType, tvDistance, tvRate;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            // findViewById : chỉ được gọi từ view
            img = itemView.findViewById(R.id.imageViewFood);
            tvName = itemView.findViewById(R.id.textViewName);
            tvAddress = itemView.findViewById(R.id.textViewAddress);
            tvBusinessType = itemView.findViewById(R.id.textViewCategory);
            tvDistance = itemView.findViewById(R.id.textViewDistance);
            tvRate = itemView.findViewById(R.id.textViewRating);
        }
    }
}

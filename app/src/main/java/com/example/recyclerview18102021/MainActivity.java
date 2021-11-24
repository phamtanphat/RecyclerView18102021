package com.example.recyclerview18102021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRcvFood;
    List<FoodModel> mListFood;
    FoodAdapter mFoodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRcvFood = findViewById(R.id.recyclerViewFood);


        mListFood = FoodModel.getMock();

        mFoodAdapter = new FoodAdapter(mListFood,MainActivity.this);

        // Tính toán trước cái kích thước của item để hiển thị nhanh hơn
        mRcvFood.setHasFixedSize(true);
        mRcvFood.setAdapter(mFoodAdapter);
        

        mFoodAdapter.bindOnItemFoodClickListener(new OnItemFoodClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, mListFood.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}


package com.example.recyclerview18102021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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


        mListFood = new ArrayList<>();
        mListFood.addAll(FoodModel.getMock());

        mFoodAdapter = new FoodAdapter(mListFood, MainActivity.this);

        // Tính toán trước cái kích thước của item để hiển thị nhanh hơn
        mRcvFood.setHasFixedSize(true);
        mRcvFood.setAdapter(mFoodAdapter);


        mFoodAdapter.bindOnItemFoodClickListener(new OnItemFoodClickListener() {
            @Override
            public void onClick(int position) {
//                Toast.makeText(MainActivity.this, "Xóa " + mListFood.get(position).getName(), Toast.LENGTH_SHORT).show();
                Log.d("BBB",mListFood.size() + "");
                mListFood.remove(position);
                mFoodAdapter.notifyItemRemoved(position);
            }
        });
    }


}


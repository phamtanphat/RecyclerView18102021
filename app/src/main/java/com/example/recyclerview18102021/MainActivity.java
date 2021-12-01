package com.example.recyclerview18102021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRcvFood;
    List<FoodModel> mListFood;
    FoodAdapter mFoodAdapter;
    int mCurrentPage = 1;
    int mTotalPage = 10;
    boolean mIsLoading =  false;
    boolean mIsLastPage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRcvFood = findViewById(R.id.recyclerViewFood);


        mListFood = new ArrayList<>();
        mListFood.addAll(FoodModel.getMock());

        mFoodAdapter = new FoodAdapter(mListFood, MainActivity.this);
        mFoodAdapter.addFooterLoading();
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

        mRcvFood.addOnScrollListener(new PaginationScrollListener((LinearLayoutManager) mRcvFood.getLayoutManager()) {
            @Override
            public void loadMore() {
                mIsLoading = true;
                mCurrentPage += 1;
                loadNextPage();
            }

            @Override
            public boolean isLoading() {
                return mIsLoading;
            }

            @Override
            public boolean isLastPage() {
                return mIsLastPage;
            }
        });
    }

    private void loadNextPage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mFoodAdapter.removeFooterLoading();
                int position = mListFood.size() - 1;
                List<FoodModel> foodModels = FoodModel.getMock();
                mListFood.addAll(foodModels);
                mFoodAdapter.notifyItemRangeChanged(position,foodModels.size());
                foodModels = null;
                mIsLoading = false;

                if (mCurrentPage < mTotalPage){
                    mFoodAdapter.addFooterLoading();
                }else{
                    mIsLastPage = true;
                }

            }
        },2000);
    }


}


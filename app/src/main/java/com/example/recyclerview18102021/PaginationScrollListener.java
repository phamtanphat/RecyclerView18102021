package com.example.recyclerview18102021;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (isLoading() || isLastPage()){
            return;
        }
    }

    abstract public boolean isLoading();
    abstract public boolean isLastPage();
}

package com.example.recyclerview18102021;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

    LinearLayoutManager linearLayoutManager;

    public PaginationScrollListener(LinearLayoutManager linearLayoutManager){
        this.linearLayoutManager = linearLayoutManager;
    }


    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
        int totalItem = linearLayoutManager.getItemCount();
        int visibleItem = linearLayoutManager.getChildCount();

        if (isLoading() || isLastPage()){
            return;
        }

        if (firstVisiblePosition >= 0 && (visibleItem + firstVisiblePosition) >= totalItem){
            loadMore();
        }
    }

    abstract public void loadMore();
    abstract public boolean isLoading();
    abstract public boolean isLastPage();
}

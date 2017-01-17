package com.chniccs.coco.ui.category;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chniccs.coco.R;
import com.chniccs.coco.adapter.CategoryAdapter;
import com.chniccs.coco.base.BaseFragment;
import com.chniccs.coco.base.IBasePresenter;
import com.chniccs.coco.entity.CategoryEntity;
import com.chniccs.coco.widget.Divider;

import butterknife.BindView;

public class CategoryFragment extends BaseFragment<CategoryPresenter> implements ICategoryContract.IView {
    private CategoryAdapter mCategoryAdapter;
    private String mCategoryName;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    public static CategoryFragment newInstance(String paramString) {
        CategoryFragment localCategoryFragment = new CategoryFragment();
        Bundle localBundle = new Bundle();
        localBundle.putString("categoryName", paramString);
        localCategoryFragment.setArguments(localBundle);
        return localCategoryFragment;
    }

    public void addItem(CategoryEntity paramCategoryEntity) {
        this.mCategoryAdapter.addData(paramCategoryEntity);
        this.mCategoryAdapter.notifyDataSetChanged();
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    protected int getLayout() {
        return R.layout.fragment_category;
    }

    @NonNull
    protected IBasePresenter getPresenter() {
        return new CategoryPresenter(this);
    }

    @Override
    protected void init() {
        mPresenter.getItems();
    }

    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mCategoryAdapter = new CategoryAdapter();
        mRecyclerView.setAdapter(this.mCategoryAdapter);
        mRecyclerView.addItemDecoration(new Divider(getContext(), LinearLayoutManager.HORIZONTAL));
        mRefreshLayout.setColorSchemeColors(getResources().getIntArray(R.array.refresh_colors));
        mPresenter.setOnItemClick(this.mCategoryAdapter);
        mPresenter.setLoadMore(this.mCategoryAdapter);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                mPresenter.refresh();
            }
        });
    }

    public void onCreate(@Nullable Bundle paramBundle) {
        super.onCreate(paramBundle);
        mCategoryName = getArguments().getString("categoryName");
    }

    public void refreshDone() {
        this.mRefreshLayout.setRefreshing(false);
    }

    public void setItem(CategoryEntity paramCategoryEntity) {
        mCategoryAdapter.setData(paramCategoryEntity);
        mCategoryAdapter.notifyDataSetChanged();
    }
}

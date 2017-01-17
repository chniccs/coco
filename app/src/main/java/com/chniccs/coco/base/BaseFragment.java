package com.chniccs.coco.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by ccs on 17/1/6.
 * 基类fragment
 */

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment {
    protected T mPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        ButterKnife.bind(this,view);
        mPresenter= (T) getPresenter();
        mPresenter.subscribe();
        initView();
        init();
        return view;
    }

    protected abstract void initView();
    protected void  init(){};

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            mPresenter.unsubscribe();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
    protected abstract @LayoutRes
    int getLayout();
    protected abstract @NonNull
    IBasePresenter getPresenter();
}

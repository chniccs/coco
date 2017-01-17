package com.chniccs.coco.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ccs on 17/1/6.
 * 基类activity
 */

public abstract class BaseActivity<T extends IBasePresenter> extends AppCompatActivity {
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mPresenter= (T) getPresenter();
        mPresenter.subscribe();
        initView();
        init();
    }

    protected abstract void initView();
    protected void  init(){};

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            mPresenter.unsubscribe();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
    protected abstract @LayoutRes int getLayout();
    protected abstract @NonNull IBasePresenter getPresenter();
}

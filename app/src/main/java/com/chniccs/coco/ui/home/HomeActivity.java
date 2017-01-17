package com.chniccs.coco.ui.home;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.chniccs.coco.R;
import com.chniccs.coco.adapter.CommonFragmentAdapter;
import com.chniccs.coco.base.BaseActivity;
import com.chniccs.coco.base.IBasePresenter;

import butterknife.BindView;

public class HomeActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {
    String[] titles = {"App", "Android", "iOS", "前端", "瞎推荐", "拓展资源"};
    @BindView(R.id.banner)
    AppCompatImageView mIvBanner;
    @BindView(R.id.home_vp)
    ViewPager mVpCategory;
    @BindView(R.id.home_tl_category)
    TabLayout mTableLayout;

    @Override
    protected void initView() {
        CommonFragmentAdapter commonFragmentAdapter = new CommonFragmentAdapter(getSupportFragmentManager());
        commonFragmentAdapter.setData(titles);
        mVpCategory.setAdapter(commonFragmentAdapter);
        mTableLayout.setupWithViewPager(mVpCategory);
        mTableLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }
    public void setMeiziImg(String paramString)
    {
        Glide.with(this).load(paramString).into(this.mIvBanner);
    }
    protected void init()
    {
        ((HomePresenter)this.mPresenter).getMeiziImg();
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @NonNull
    @Override
    protected IBasePresenter getPresenter() {
        return new HomePresenter(this);
    }
}

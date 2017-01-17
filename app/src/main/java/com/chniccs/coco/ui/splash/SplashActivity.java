


package com.chniccs.coco.ui.splash;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.chniccs.coco.R;
import com.chniccs.coco.base.BaseActivity;
import com.chniccs.coco.base.IBasePresenter;
import com.chniccs.coco.ui.home.HomeActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity<SplashPresenter> implements ISplashContract.IView, Animation.AnimationListener {
    @BindView(R.id.activity_splash)
    RelativeLayout mRlBg;

    @Override
    protected void initView() {
        mRlBg.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.showAnim();
            }
        },0);
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @NonNull
    protected IBasePresenter getPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    public void showAnim() {
        Animation localAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_10_12);
        localAnimation.setAnimationListener(this);
        localAnimation.setStartOffset(500L);
        mRlBg.startAnimation(localAnimation);
    }

    @Override
    public void toHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mPresenter.toHome();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}


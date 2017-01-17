package com.chniccs.coco.ui.splash;

import com.chniccs.coco.base.IBaseView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ccs on 17/1/6.
 */

public class SplashPresenter extends ISplashContract.Presenter {


    public SplashPresenter(IBaseView view) {
        super(view);
    }

    @Override
    void showAnim() {
        mView.showAnim();
    }

    @Override
    void toHome() {
        Observable.just(null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delaySubscription(2000, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        mView.toHome();
                    }
                });
    }

    @Override
    public void subscribe() {

    }
}

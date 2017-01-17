package com.chniccs.coco.ui.home;

import com.chniccs.coco.base.IBaseView;
import com.chniccs.coco.entity.CategoryEntity;
import com.chniccs.coco.helper.RxSchedulersHelper;
import com.chniccs.coco.protocal.CategoryProtocal;

import rx.Observer;
import rx.Subscription;

public class HomePresenter
        extends IHomeContract.Presenter {
    public HomePresenter(IBaseView paramIBaseView) {
        super(paramIBaseView);
    }

    void getMeiziImg() {

        Subscription subscribe = new CategoryProtocal().getApi()
                .getRandomBeauties(1)
                .compose(RxSchedulersHelper.<CategoryEntity>io_main())
                .subscribe(new Observer<CategoryEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CategoryEntity categoryEntity) {
                        if (categoryEntity != null && categoryEntity.results != null && categoryEntity.results.size() > 0 && categoryEntity.results.get(0).url != null) {
                            (HomePresenter.this.mView).setMeiziImg(categoryEntity.results.get(0).url);
                        }
                    }
                });
        addSubscription(subscribe);
    }

    public void subscribe() {
    }
}

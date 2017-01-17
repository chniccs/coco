package com.chniccs.coco.ui.splash;

import com.chniccs.coco.base.BasePresenter;
import com.chniccs.coco.base.IBaseView;

interface ISplashContract {
    interface IView extends IBaseView {
        void showAnim();

        void toHome();
    }

    abstract class Presenter extends BasePresenter<ISplashContract.IView> {
        Presenter(IBaseView paramIBaseView) {
            super(paramIBaseView);
        }

        abstract void showAnim();

        abstract void toHome();
    }
}

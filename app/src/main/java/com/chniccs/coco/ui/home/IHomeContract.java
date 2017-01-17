package com.chniccs.coco.ui.home;

import com.chniccs.coco.base.BasePresenter;
import com.chniccs.coco.base.IBaseView;

interface IHomeContract {
    interface IView extends IBaseView {
        void setMeiziImg(String paramString);
    }

    abstract class Presenter extends BasePresenter<IHomeContract.IView> {
        Presenter(IBaseView paramIBaseView) {
            super(paramIBaseView);
        }

        abstract void getMeiziImg();
    }
}

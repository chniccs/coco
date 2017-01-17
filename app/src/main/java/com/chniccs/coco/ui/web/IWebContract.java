package com.chniccs.coco.ui.web;

import com.chniccs.coco.base.BasePresenter;
import com.chniccs.coco.base.IBaseView;

public abstract interface IWebContract
{
    public static abstract interface IView
            extends IBaseView
    {
        public abstract void loadUrl(String paramString);

        public abstract void setTitle(String paramString);
    }

    public static abstract class Presenter
            extends BasePresenter<IWebContract.IView>
    {
        Presenter(IBaseView paramIBaseView)
        {
            super(paramIBaseView);
        }

        abstract void initData();
    }
}

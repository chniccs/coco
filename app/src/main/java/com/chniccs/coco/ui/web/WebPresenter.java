package com.chniccs.coco.ui.web;

import com.chniccs.coco.base.IBaseView;

public class WebPresenter
        extends IWebContract.Presenter {
    WebPresenter(IBaseView paramIBaseView) {
        super(paramIBaseView);
    }

    void initData() {
        String str1 = this.mContext.getIntent().getStringExtra("web_url");
        String str2 = this.mContext.getIntent().getStringExtra("web_title");
        mView.loadUrl(str1);
        mView.setTitle(str2);
    }

    public void subscribe() {
    }
}

package com.chniccs.coco.ui.web;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.AppCompatTextView;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.chniccs.coco.R;
import com.chniccs.coco.base.BaseActivity;
import com.chniccs.coco.base.IBasePresenter;
import com.chniccs.coco.utils.DisplayUtil;

import butterknife.BindView;

public class WebActivity extends BaseActivity<WebPresenter> implements IWebContract.IView {
    @BindView(R.id.web_appbar)
    AppBarLayout mAppBar;
    @BindView(R.id.web_progressbar)
    ProgressBar mPb;
    @BindView(R.id.web_tv_title)
    AppCompatTextView mTvTitle;
    @BindView(R.id.web_wv)
    WebView mWebView;

    protected int getLayout() {
        return R.layout.activity_web;
    }

    @NonNull
    protected IBasePresenter getPresenter() {
        return new WebPresenter(this);
    }

    protected void init() {
        mPresenter.initData();
    }

    protected void initView() {
        WebSettings localWebSettings = this.mWebView.getSettings();
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setAppCacheEnabled(true);
        localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        localWebSettings.setSupportZoom(true);

        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt) {
                mPb.setProgress(paramAnonymousInt);
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = 21)
            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest) {
                return (Build.VERSION.SDK_INT < 21) || (shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest.getUrl().toString()));
            }

            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                paramAnonymousWebView.loadUrl(paramAnonymousString);
                return true;
            }
        });
        mAppBar.setPadding(mAppBar.getPaddingLeft(), mAppBar.getPaddingTop() + DisplayUtil.getStatusBarHeight(this), mAppBar.getPaddingRight(), mAppBar.getPaddingBottom());
    }

    public void loadUrl(String paramString) {
        this.mWebView.loadUrl(paramString);
    }

    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return;
        }
        super.onBackPressed();
    }

    public void setTitle(String paramString) {
        this.mTvTitle.setText(paramString);
    }
}

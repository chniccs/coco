package com.chniccs.coco.ui.category;

import android.view.View;

import com.chniccs.coco.adapter.CategoryAdapter;
import com.chniccs.coco.base.IBaseView;
import com.chniccs.coco.entity.CategoryEntity;
import com.chniccs.coco.helper.RxSchedulersHelper;
import com.chniccs.coco.listener.ILoadMore;
import com.chniccs.coco.listener.ItemClickListener;
import com.chniccs.coco.protocal.CategoryProtocal;
import com.chniccs.coco.utils.ToastUtil;

import rx.Observer;
import rx.Subscription;

public class CategoryPresenter extends ICategoryContract.Presenter {
    private static final int mLimit = 10;
    private int mPage = 1;

    public CategoryPresenter(IBaseView paramIBaseView) {
        super(paramIBaseView);
    }

    private void getItems(final boolean loadMore) {
        int page=loadMore?mPage+1:mPage;

        Subscription subscribe = new CategoryProtocal()
                .getApi()
                .getCategoryDate(mView.getCategoryName(), mLimit, page)
                .compose(RxSchedulersHelper.<CategoryEntity>io_main())
                .subscribe(new Observer<CategoryEntity>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.refreshDone();
                    }

                    @Override
                    public void onNext(CategoryEntity categoryEntity) {
                        if (loadMore) {
                            if ((categoryEntity != null) && (categoryEntity.results != null) && (categoryEntity.results.size() > 0)) {
                                mView.addItem(categoryEntity);
                                mPage++;
                                return;
                            }
                            ToastUtil.show("无更多数据");
                            return;
                        }
                        mView.setItem(categoryEntity);
                        mView.refreshDone();
                    }
                });
        addSubscription(subscribe);
    }


    void getItems() {
        this.mPage = 1;
        getItems(false);
    }

    void refresh() {
        getItems();
    }

    void setLoadMore(CategoryAdapter paramCategoryAdapter) {
        paramCategoryAdapter.setILoadMore(new ILoadMore() {
            public void loadMore() {
                getItems(true);
            }
        });
    }

    void setOnItemClick(CategoryAdapter paramCategoryAdapter) {
        paramCategoryAdapter.setOnItemClickListener(new ItemClickListener() {
            public void onClick(View paramAnonymousView, int paramAnonymousInt) {
            }
        });
    }

    public void subscribe() {
    }
}

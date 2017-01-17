package com.chniccs.coco.ui.category;

import com.chniccs.coco.adapter.CategoryAdapter;
import com.chniccs.coco.base.BasePresenter;
import com.chniccs.coco.base.IBaseView;
import com.chniccs.coco.entity.CategoryEntity;

interface ICategoryContract {
    interface IView extends IBaseView {
        void addItem(CategoryEntity paramCategoryEntity);

        String getCategoryName();

        void refreshDone();

        void setItem(CategoryEntity paramCategoryEntity);
    }

    abstract class Presenter extends BasePresenter<ICategoryContract.IView> {
        Presenter(IBaseView paramIBaseView) {
            super(paramIBaseView);
        }

        abstract void getItems();

        abstract void refresh();

        abstract void setLoadMore(CategoryAdapter paramCategoryAdapter);

        abstract void setOnItemClick(CategoryAdapter paramCategoryAdapter);
    }
}

package com.chniccs.coco.factory;

import android.util.SparseArray;


import com.chniccs.coco.ui.category.CategoryFragment;

import java.lang.ref.WeakReference;

/**
 * Created by ccs on 17/1/6.
 */

public class CategoryFragmentFactory {
    private SparseArray<WeakReference<CategoryFragment>> mSparseArray;

    public CategoryFragmentFactory() {
        mSparseArray = new SparseArray<>();
    }

    private void add(CategoryFragment fragment, int position) {
        WeakReference<CategoryFragment> categoryFragmentWeakReference = new WeakReference<CategoryFragment>(fragment);
        mSparseArray.put(position, categoryFragmentWeakReference);
    }

    public CategoryFragment getFragment(int position, String category) {
        CategoryFragment categoryFragment;
        if (mSparseArray.get(position) == null || mSparseArray.get(position).get() == null) {
            categoryFragment = CategoryFragment.newInstance(category);
            add(categoryFragment, position);
        }else {
            categoryFragment = mSparseArray.get(position).get();
        }

        return categoryFragment;
    }
}

package com.chniccs.coco.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.chniccs.coco.factory.CategoryFragmentFactory;

public class CommonFragmentAdapter
        extends FragmentPagerAdapter
{
    private final CategoryFragmentFactory mFragmentFactory = new CategoryFragmentFactory();
    private String[] mStrs;

    public CommonFragmentAdapter(FragmentManager paramFragmentManager)
    {
        super(paramFragmentManager);
    }

    public int getCount()
    {
        if (this.mStrs == null) {
            return 0;
        }
        return this.mStrs.length;
    }

    public Fragment getItem(int paramInt)
    {
        return this.mFragmentFactory.getFragment(paramInt, this.mStrs[paramInt]);
    }

    public CharSequence getPageTitle(int paramInt)
    {
        return this.mStrs[paramInt];
    }

    public void setData(String[] paramArrayOfString)
    {
        this.mStrs = paramArrayOfString;
    }
}

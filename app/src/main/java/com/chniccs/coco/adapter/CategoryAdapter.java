package com.chniccs.coco.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chniccs.coco.R;
import com.chniccs.coco.adapter.base.BaseRCAdapter;
import com.chniccs.coco.entity.CategoryEntity;
import com.chniccs.coco.holder.CategoryHolder;
import com.chniccs.coco.holder.base.BaseRCHolder;
import java.util.List;

public class CategoryAdapter
        extends BaseRCAdapter<CategoryEntity>
{
    public void addData(CategoryEntity paramCategoryEntity)
    {
        ((CategoryEntity)this.mData).results.addAll(paramCategoryEntity.results);
    }

    public int getItemCount()
    {
        if (this.mData == null) {
            return 0;
        }
        return ((CategoryEntity)this.mData).results.size();
    }

    public BaseRCHolder getItemHolder(ViewGroup paramViewGroup, int paramInt)
    {
        return new CategoryHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.item, null));
    }

    protected void setItemData(BaseRCHolder paramBaseRCHolder, int paramInt)
    {
        paramBaseRCHolder.setData(((CategoryEntity)this.mData).results.get(paramInt));
    }
}

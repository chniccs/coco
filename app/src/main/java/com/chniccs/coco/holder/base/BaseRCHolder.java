package com.chniccs.coco.holder.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import butterknife.ButterKnife;
import com.chniccs.coco.listener.ItemClickListener;
import com.chniccs.coco.listener.ItemLongClickListener;

public abstract class BaseRCHolder<T>
        extends RecyclerView.ViewHolder
        implements View.OnClickListener, View.OnLongClickListener
{
    protected Context mContext;
    protected T mData;
    private ItemClickListener mItemClickListener;
    private ItemLongClickListener mItemLongClickListener;

    public BaseRCHolder(@NonNull View paramView)
    {
        super(paramView);
        this.mContext = paramView.getContext();
        ButterKnife.bind(this, paramView);
        paramView.setOnClickListener(this);
        paramView.setOnLongClickListener(this);
    }

    public abstract void bindViewHolder(int paramInt);

    public void onClick(View paramView)
    {
        if (this.mItemLongClickListener != null) {
            this.mItemClickListener.onClick(paramView, getAdapterPosition());
        }
    }

    public boolean onLongClick(View paramView)
    {
        if (this.mItemLongClickListener != null)
        {
            this.mItemLongClickListener.onLongClick(paramView, getAdapterPosition());
            return true;
        }
        return false;
    }

    public void setData(T paramObject)
    {
        this.mData = paramObject;
    }

    public void setOnClickListener(ItemClickListener paramItemClickListener)
    {
        this.mItemClickListener = paramItemClickListener;
    }

    public void setOnLongClickListener(ItemLongClickListener paramItemLongClickListener)
    {
        this.mItemLongClickListener = paramItemLongClickListener;
    }
}

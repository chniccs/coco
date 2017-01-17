package com.chniccs.coco.holder;

import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;

import com.bumptech.glide.Glide;
import com.chniccs.coco.R;
import com.chniccs.coco.entity.CategoryEntity;
import com.chniccs.coco.holder.base.BaseRCHolder;
import com.chniccs.coco.ui.web.WebActivity;
import com.chniccs.coco.utils.DateUtil;


public class CategoryHolder extends BaseRCHolder<CategoryEntity.ResultsBean> {
    @BindView(R.id.iv_item_img)
    ImageView mIvImg;
    @BindView(R.id.tv_item_publisher)
    AppCompatTextView mTvAuthor;
    @BindView(R.id.tv_item_time)
    AppCompatTextView mTvTime;
    @BindView(R.id.tv_item_title)
    AppCompatTextView mTvTitle;

    public CategoryHolder(View paramView) {
        super(paramView);
    }

    public void bindViewHolder(int paramInt) {
        this.mTvTitle.setText(mData.desc);
        this.mTvAuthor.setText(((CategoryEntity.ResultsBean) this.mData).who);
        AppCompatTextView localAppCompatTextView = this.mTvTime;
        if (TextUtils.isEmpty(((CategoryEntity.ResultsBean) this.mData).createdAt)) {
        }
        for (String str = ""; ; str = DateUtil.dateFormat(((CategoryEntity.ResultsBean) this.mData).createdAt)) {
            localAppCompatTextView.setText(str);
            if ((((CategoryEntity.ResultsBean) this.mData).images == null) || (((CategoryEntity.ResultsBean) this.mData).images.size() <= 0)) {
                break;
            }
            this.mIvImg.setVisibility(0);
            Glide.with(this.mContext).load((String) ((CategoryEntity.ResultsBean) this.mData).images.get(0) + "?imageView2/0/w/200").into(this.mIvImg);
            return;
        }
        this.mIvImg.setVisibility(8);
    }

    public void onClick(View paramView) {
        Intent localIntent = new Intent(this.mContext, WebActivity.class);
        localIntent.putExtra("web_url", ((CategoryEntity.ResultsBean) this.mData).url);
        localIntent.putExtra("web_title", ((CategoryEntity.ResultsBean) this.mData).desc);
        this.mContext.startActivity(localIntent);
    }
}

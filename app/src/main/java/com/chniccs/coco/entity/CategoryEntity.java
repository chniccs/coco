package com.chniccs.coco.entity;

import com.chniccs.coco.base.BaseEntity;
import java.util.List;

public class CategoryEntity
        extends BaseEntity
{
    public List<ResultsBean> results;

    public static class ResultsBean
    {
        public String _id;
        public String createdAt;
        public String desc;
        public List<String> images;
        public String publishedAt;
        public String source;
        public String type;
        public String url;
        public boolean used;
        public String who;
    }
}

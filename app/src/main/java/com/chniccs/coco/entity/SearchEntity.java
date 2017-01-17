package com.chniccs.coco.entity;

import com.chniccs.coco.base.BaseEntity;
import java.util.List;

public class SearchEntity
        extends BaseEntity
{
    public int count;
    public List<ResultsBean> results;

    public static class ResultsBean
    {
        public String desc;
        public String ganhuo_id;
        public String publishedAt;
        public String readability;
        public String type;
        public String url;
        public String who;
    }
}

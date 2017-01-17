package com.chniccs.coco.protocal;

import com.chniccs.coco.protocal.api.GankApi;
import com.chniccs.coco.protocal.base.BaseProtocal;

public class CategoryProtocal extends BaseProtocal<GankApi>
{
    protected Class<GankApi> getApiClass()
    {
        return GankApi.class;
    }
}

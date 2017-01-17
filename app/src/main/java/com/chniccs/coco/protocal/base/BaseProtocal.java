package com.chniccs.coco.protocal.base;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseProtocal<T>
{
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private T api;

    protected static String getBaseUrl()
    {
        return "http://gank.io/api/";
    }

    public T getApi()
    {
        if (this.api == null) {
            this.api = new Retrofit.Builder().client(okHttpClient).baseUrl(getBaseUrl()).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(rxJavaCallAdapterFactory).build().create(getApiClass());
        }
        return (T)this.api;
    }

    protected abstract Class<T> getApiClass();
}

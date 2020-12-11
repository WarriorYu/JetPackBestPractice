package com.yu.libnetwork;

import java.util.Map;

import okhttp3.FormBody;

/**
 * @author :   yuxibing
 * @date :   2020/12/10
 * Describe : 封装请求参数的Post请求
 */
public class PostRequest<T> extends Request<T,PostRequest>{

    public PostRequest(String url) {
        super(url);
    }

    @Override
    protected okhttp3.Request generateRequest(okhttp3.Request.Builder builder) {
        FormBody.Builder bodyBuiler = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            bodyBuiler.add(entry.getKey(), String.valueOf(entry.getValue()));
        }

        okhttp3.Request request = builder.url(mUrl).post(bodyBuiler.build()).build();
        return request;
    }
}

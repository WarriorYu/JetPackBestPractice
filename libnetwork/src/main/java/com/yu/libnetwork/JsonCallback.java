package com.yu.libnetwork;

/**
 * @author :   yuxibing
 * @date :   2020/12/10
 * Describe :
 */
public abstract class JsonCallback<T> {
    public void onSuccess(ApiResponse<T> response) {

    }

    public void onError(ApiResponse<T> response) {

    }

    public void onCacheSuccess(ApiResponse<T> response) {

    }
}

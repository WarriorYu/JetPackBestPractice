package com.yu.libnetwork;

/**
 * @author :   yuxibing
 * @date :   2020/12/10
 * Describe :
 */
public class ApiResponse<T> {
    public boolean success;
    public int status;
    public String message;
    public T body;
}

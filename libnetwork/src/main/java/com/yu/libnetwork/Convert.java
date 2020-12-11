package com.yu.libnetwork;

import java.lang.reflect.Type;

/**
 * @author :   yuxibing
 * @date :   2020/12/10
 * Describe :
 */
public interface Convert<T> {
    T convert(String response, Type type);
}

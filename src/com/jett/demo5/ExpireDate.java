package com.jett.demo5;

import java.util.Date;

/**
 * 接口里的属性都是 public static final
 * 方法都是 public abstract
 */
public interface ExpireDate {

    int id = 0;

    boolean noExp(Date time);

    default String getYourName() {
        return "ssss";
    };

}

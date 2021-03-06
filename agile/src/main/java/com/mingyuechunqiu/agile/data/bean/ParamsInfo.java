package com.mingyuechunqiu.agile.data.bean;

import androidx.annotation.NonNull;

/**
 * <pre>
 *     author : xyj
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/05/17
 *     desc   : 所有请求参数的基类
 *     version: 1.0
 * </pre>
 */
public class ParamsInfo {

    @NonNull
    private RequestCategory requestCategory = RequestCategory.CATEGORY_NETWORK;//请求分类（默认为联网类型）
    private int requestType;//请求类型

    @NonNull
    public RequestCategory getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(@NonNull RequestCategory requestCategory) {
        this.requestCategory = requestCategory;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    /**
     * 请求分类
     */
    public enum RequestCategory {

        //未设置，离线，网络
        CATEGORY_NOT_SET, CATEGORY_OFFLINE, CATEGORY_NETWORK
    }
}

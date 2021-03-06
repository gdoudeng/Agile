package com.mingyuechunqiu.agile.base.model.dao.operation;

/**
 * <pre>
 *     author : xyj
 *     Github : https://github.com/MingYueChunQiu
 *     e-mail : xiyujieit@163.com
 *     time   : 2019/6/26
 *     desc   : Dao层操作的父接口
 *     version: 1.0
 * </pre>
 */
public interface IBaseDaoOperation<T> {

    /**
     * 释放资源
     */
    void releaseOnDetach();
}

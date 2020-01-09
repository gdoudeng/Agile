package com.mingyuechunqiu.agileproject.feature.main;

import com.mingyuechunqiu.agile.data.bean.BaseParamsInfo;

import java.util.Map;

/**
 * <pre>
 *     author : xyj
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/11/8
 *     desc   : 主界面模型层
 *              继承自MainContract.Model
 *     version: 1.0
 * </pre>
 */
class MainModel extends MainContract.Model<MainContract.Listener> {

    private MainParamsInfo mInfo;

    MainModel(MainContract.Listener listener) {
        super(listener);
    }

    @Override
    protected void releaseNetworkResources() {

    }

    @Override
    protected void doRequest(BaseParamsInfo info) {

    }

    @Override
    protected void redoRequest(Map<String, String> paramMap) {

    }

    @Override
    public void release() {

    }
}

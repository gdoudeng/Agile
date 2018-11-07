package com.mingyuechunqiu.agilemvpframe.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mingyuechunqiu.agilemvpframe.base.presenter.BaseDialogPresenter;
import com.mingyuechunqiu.agilemvpframe.base.view.BaseDialogView;

/**
 * <pre>
 *     author : xyj
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/05/12
 *     desc   : 所有MVP层界面的基类
 *              继承自BaseFullScreenActivity
 *     version: 1.0
 * </pre>
 */
public abstract class BasePresenterActivity<V extends BaseDialogView<P>, P extends BaseDialogPresenter> extends BaseFullImmerseScreenActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    /**
     * 添加Present相关
     */
    protected void attachPresenter() {
        ((V) this).setPresenter(initPresenter());
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    protected abstract P initPresenter();

}

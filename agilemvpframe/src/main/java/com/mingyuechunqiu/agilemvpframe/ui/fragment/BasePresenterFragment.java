package com.mingyuechunqiu.agilemvpframe.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mingyuechunqiu.agilemvpframe.base.presenter.BaseDialogPresenter;
import com.mingyuechunqiu.agilemvpframe.base.view.BaseDialogView;

/**
 * <pre>
 *     author : xyj
 *     e-mail : yujie.xi@ehailuo.com
 *     time   : 2018/05/16
 *     desc   : 所有MVP层Fragment的基类
 *              继承自BaseFragment
 *     version: 1.0
 * </pre>
 */
public abstract class BasePresenterFragment<V extends BaseDialogView<P>, P extends BaseDialogPresenter> extends BaseFragment {

    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        attachPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //不能放在onDestroyView中执行，因为像输入框失去焦点这种事件会在onDestroyView之后才被调用
        mPresenter = null;
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

package com.mingyuechunqiu.agilemvpframe.base.presenter;

import com.mingyuechunqiu.agilemvpframe.base.model.BaseNetModel;
import com.mingyuechunqiu.agilemvpframe.base.view.BaseDialogView;

/**
 * <pre>
 *     author : xyj
 *     e-mail : yujie.xi@ehailuo.com
 *     time   : 2018/05/12
 *     desc   : 所有带对话框功能的Presenter的基类
 *              继承自BaseNetPresenter
 *     version: 1.0
 * </pre>
 */
public abstract class BaseDialogPresenter<V extends BaseDialogView, M extends BaseNetModel> extends BaseNetPresenter<V, M> {

    /**
     * 关闭加载对话框
     */
    protected void disappearDialog() {
        if (mViewRef.get() != null) {
            mViewRef.get().disappearLoadingDialog();
        }
    }

    /**
     * 显示提示信息并关闭加载对话框
     *
     * @param hint 提示文本
     */
    protected void showToastAndDisappearDialog(String hint) {
        if (mViewRef.get() != null) {
            mViewRef.get().showToast(hint);
            mViewRef.get().disappearLoadingDialog();
        }
    }

    /**
     * 显示提示信息并关闭加载对话框
     *
     * @param stringResourceId 提示文本资源ID
     */
    protected void showToastAndDisappearDialog(int stringResourceId) {
        if (mViewRef.get() != null) {
            mViewRef.get().showToast(stringResourceId);
            mViewRef.get().disappearLoadingDialog();
        }
    }

}

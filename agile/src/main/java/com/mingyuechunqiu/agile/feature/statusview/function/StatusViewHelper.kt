package com.mingyuechunqiu.agile.feature.statusview.function

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import com.mingyuechunqiu.agile.feature.statusview.bean.StatusViewConfigure
import com.mingyuechunqiu.agile.feature.statusview.bean.StatusViewOption
import com.mingyuechunqiu.agile.feature.statusview.constants.StatusViewConstants
import com.mingyuechunqiu.agile.feature.statusview.ui.IStatusView
import com.mingyuechunqiu.agile.feature.statusview.ui.StatusViewDialogFragment

/**
 * <pre>
 *      Project:    Agile
 *
 *      Author:     xiyujie
 *      Github:     https://github.com/MingYueChunQiu
 *      Email:      xiyujieit@163.com
 *      Time:       2019-11-30 15:27
 *      Desc:       状态视图辅助接口
 *                  实现IStatusViewHelper
 *      Version:    1.0
 * </pre>
 */
internal class StatusViewHelper : IStatusViewHelper {

    private var mStatusView: IStatusView? = null
    private var mConfigure: StatusViewConfigure? = null

    override fun applyStatusViewConfigure(configure: StatusViewConfigure) {
        mConfigure = configure
    }

    override fun getStatusViewConfigure(): StatusViewConfigure? {
        return mConfigure
    }

    override fun setStatusView(statusView: IStatusView) {
        mStatusView = statusView
    }

    override fun getStatusView(): IStatusView? {
        return mStatusView
    }

    override fun showStatusView(type: StatusViewConstants.StatusType, manager: FragmentManager, option: StatusViewOption?) {
        checkOrCreateStatusView(type, option)
        mStatusView?.showStatusView(type, manager)
    }

    override fun showStatusView(type: StatusViewConstants.StatusType, manager: FragmentManager, @IdRes containerId: Int, option: StatusViewOption?) {
        checkOrCreateStatusView(type, option)
        mStatusView?.showStatusView(type, manager, containerId)
    }

    override fun dismissStatusView(allowStateLoss: Boolean) {
        mStatusView?.dismissStatusView(allowStateLoss)
        mStatusView = null
    }

    override fun getModeType(): StatusViewConstants.ModeType {
        return mStatusView?.getModeType() ?: StatusViewConstants.ModeType.TYPE_INVALID
    }

    override fun getStatusMode(): StatusViewConstants.StatusType {
        return mStatusView?.getStatusMode() ?: StatusViewConstants.StatusType.TYPE_LOADING
    }

    private fun checkOrCreateStatusView(type: StatusViewConstants.StatusType, option: StatusViewOption?) {
        if (mStatusView != null) {
            return
        }
        val statusViewOption = option
                ?: StatusViewHandler.getStatusViewOptionByType(mConfigure, type, false)
        mStatusView = StatusViewDialogFragment.newInstance(statusViewOption
                ?: StatusViewHandler.getGlobalStatusViewOptionByType(type))
    }
}
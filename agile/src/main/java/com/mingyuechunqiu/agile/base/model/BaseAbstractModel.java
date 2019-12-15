package com.mingyuechunqiu.agile.base.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mingyuechunqiu.agile.base.framework.IBaseListener;
import com.mingyuechunqiu.agile.base.model.part.IBaseModelPart;
import com.mingyuechunqiu.agile.base.model.part.dao.IBaseDao;
import com.mingyuechunqiu.agile.data.bean.BaseParamsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : xyj
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/11/19
 *     desc   : 所有Model层的抽象基类
 *              实现BaseModel
 *     version: 1.0
 * </pre>
 */
public abstract class BaseAbstractModel<I extends IBaseListener> implements IBaseModel<I> {

    protected final String TAG = getClass().getSimpleName();//日志标签
    protected final String TAG_FAILURE = getClass().getSimpleName() + " failure";//打印错误日志标签

    protected I mListener;
    private List<IBaseModelPart> mModelPartList;
    private List<IBaseDao> mDaoList;

    public BaseAbstractModel(@NonNull I listener) {
        attachListener(listener);
    }

    @Override
    public void attachListener(@NonNull I listener) {
        mListener = listener;
        onAttachListener(listener);
    }

    @Override
    public void start() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    /**
     * 设置网络请求参数对象，进行网络请求
     *
     * @param info 网络请求参数对象
     */
    @Override
    public void requestWithParamsInfo(@NonNull BaseParamsInfo info) {
        if (mListener == null) {
            throw new IllegalArgumentException("Listener has not been set!");
        }
        doRequest(info);
    }

    /**
     * 释放资源方法
     */
    @Override
    public void release() {
        destroy();
        mListener = null;
        if (mModelPartList != null) {
            for (IBaseModelPart part : mModelPartList) {
                if (part != null) {
                    part.release();
                }
            }
            mModelPartList.clear();
            mModelPartList = null;
        }
        if (mDaoList != null) {
            for (IBaseDao dao : mDaoList) {
                if (dao != null) {
                    dao.release();
                }
            }
            mDaoList.clear();
            mDaoList = null;
        }
    }

    /**
     * 添加模型层part单元
     *
     * @param part part单元模块
     * @return 如果添加成功返回true，否则返回false
     */
    protected boolean addModelPart(@Nullable IBaseModelPart part) {
        if (part == null) {
            return false;
        }
        if (mModelPartList == null) {
            mModelPartList = new ArrayList<>();
        }
        return mModelPartList.add(part);
    }

    /**
     * 删除指定的模型层part单元
     *
     * @param part part单元模块
     * @return 如果删除成功返回true，否则返回false
     */
    protected boolean removeModelPart(@Nullable IBaseModelPart part) {
        if (part == null || mModelPartList == null) {
            return false;
        }
        return mModelPartList.remove(part);
    }

    /**
     * 添加Dao层单元
     *
     * @param dao dao单元
     * @return 如果添加成功返回true，否则返回false
     */
    protected boolean addDao(@Nullable IBaseDao dao) {
        if (dao == null) {
            return false;
        }
        if (mDaoList == null) {
            mDaoList = new ArrayList<>();
        }
        return mDaoList.add(dao);
    }

    /**
     * 删除dao单元
     *
     * @param dao dao单元
     * @return 如果删除成功返回true，否则返回false
     */
    protected boolean removeDao(@Nullable IBaseDao dao) {
        if (dao == null || mDaoList == null) {
            return false;
        }
        return mDaoList.remove(dao);
    }

    /**
     * 当和监听器关联时回调
     *
     * @param listener 监听器
     */
    protected void onAttachListener(@NonNull I listener) {
    }

    /**
     * 将参数转成对应参数类型
     *
     * @param info 参数基本类型
     * @param <T>  转换成类型
     * @return 返回转换后的类型（如果类型错误，会抛出ClassCastException）
     */
    @SuppressWarnings("unchecked")
    @NonNull
    protected <T extends BaseParamsInfo> T asParamsInfo(@NonNull BaseParamsInfo info) {
        return (T) info;
    }

    /**
     * 由子类重写进行网络请求
     *
     * @param info 网络请求参数对象
     */
    protected abstract void doRequest(@NonNull BaseParamsInfo info);

    /**
     * 销毁资源
     */
    protected abstract void destroy();
}

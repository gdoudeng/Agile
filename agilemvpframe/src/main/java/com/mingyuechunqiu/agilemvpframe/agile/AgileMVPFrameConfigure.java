package com.mingyuechunqiu.agilemvpframe.agile;

import com.mingyuechunqiu.agilemvpframe.data.remote.retrofit.controller.BaseRetrofitManager;

/**
 * <pre>
 *     author : xyj
 *     e-mail : xiyujieit@163.com
 *     time   : 2018/11/7
 *     desc   : 框架配置类
 *     version: 1.0
 * </pre>
 */
public class AgileMVPFrameConfigure {

    private int connectNetTimeout;//网络连接超时时间(秒数)
    private int readNetTimeout;//网络读取超时时间(秒数)
    private int writeNetTimeout;//网络写入超时时间(秒数)

    public AgileMVPFrameConfigure() {
        //设置默认配置
        connectNetTimeout = readNetTimeout = writeNetTimeout = BaseRetrofitManager.DEFAULT_TIMEOUT;
    }

    public int getConnectNetTimeout() {
        return connectNetTimeout;
    }

    public void setConnectNetTimeout(int connectNetTimeout) {
        this.connectNetTimeout = connectNetTimeout;
    }

    public int getReadNetTimeout() {
        return readNetTimeout;
    }

    public void setReadNetTimeout(int readNetTimeout) {
        this.readNetTimeout = readNetTimeout;
    }

    public int getWriteNetTimeout() {
        return writeNetTimeout;
    }

    public void setWriteNetTimeout(int writeNetTimeout) {
        this.writeNetTimeout = writeNetTimeout;
    }

    /**
     * 链式调用
     */
    public static class Builder {

        private AgileMVPFrameConfigure mConfigure;

        public Builder() {
            mConfigure = new AgileMVPFrameConfigure();
        }

        public AgileMVPFrameConfigure build() {
            return mConfigure;
        }

        public int getConnectNetTimeout() {
            return mConfigure.connectNetTimeout;
        }

        public Builder setConnectNetTimeout(int connectNetTimeout) {
            mConfigure.connectNetTimeout = connectNetTimeout;
            return this;
        }

        public int getReadNetTimeout() {
            return mConfigure.readNetTimeout;
        }

        public Builder setReadNetTimeout(int readNetTimeout) {
            mConfigure.readNetTimeout = readNetTimeout;
            return this;
        }

        public int getWriteNetTimeout() {
            return mConfigure.writeNetTimeout;
        }

        public Builder setWriteNetTimeout(int writeNetTimeout) {
            mConfigure.writeNetTimeout = writeNetTimeout;
            return this;
        }
    }
}

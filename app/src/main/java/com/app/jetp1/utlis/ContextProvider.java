package com.app.jetp1.utlis;

import android.app.Application;
import android.content.Context;

/**
 * @author:create by ys
 * 时间:2021/5/14 10
 * 邮箱 894417048@qq.com
 */
public class ContextProvider {

    public static ContextProvider instance;
    private Context mContext;

    private ContextProvider(Context context) {
        mContext = context;
    }

    public static ContextProvider getInstance(){
        if (instance == null){
            Context context = ApplicationContextProvider.mContext;
            if (context == null) {
                throw new IllegalStateException("context == null");
            }
            instance = new ContextProvider(context);
        }
        return instance;
    }

    /**
     * 获取上下文
     */
    public Context getContext() {
        return mContext;
    }

    public Application getApplication() {
        return (Application) mContext.getApplicationContext();
    }

}

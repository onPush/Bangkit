package com.android.zhangtao.Bangkit.unitUtils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by zhangtao on 16/5/14.
 */
public class NContext {
    private static Context gContext;
    // 不能拿去跳转页面
    public static Context GetAppContext(){
        if (gContext==null) {
            try {
                // TODO(hyangah): check proguard rule.
                Application appl = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
                gContext = appl.getApplicationContext();
            } catch (Exception e) {
                Log.e("error", "context not found: " + e);
            }
        }
        return gContext;
    }
}

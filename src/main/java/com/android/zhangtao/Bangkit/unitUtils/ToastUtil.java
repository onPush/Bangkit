package com.android.zhangtao.Bangkit.unitUtils;

import android.support.annotation.StringRes;
import android.widget.Toast;


public class ToastUtil {

    private ToastUtil() {
    }

    public static void show(CharSequence text) {
            Toast.makeText(NContext.GetAppContext(), text, Toast.LENGTH_SHORT).show();
    }

    public static void show(@StringRes int resId) {
        show(NContext.GetAppContext().getString(resId));
    }

    public static void devShow(CharSequence text){
//        if (BuildConfig.DEBUG){
//            show(text);
//        }
    }

}
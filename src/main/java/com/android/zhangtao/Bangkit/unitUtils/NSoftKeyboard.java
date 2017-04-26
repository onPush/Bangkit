package com.android.zhangtao.Bangkit.unitUtils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by zhangtao on 17/4/17.
 */

public class NSoftKeyboard {

    public static void hideSoftInput(View view){
        InputMethodManager imm = (InputMethodManager) NContext.GetAppContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
    }
    public static void toggleSoftInput(){
        InputMethodManager imm = (InputMethodManager) NContext.GetAppContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}

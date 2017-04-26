package com.android.zhangtao.Bangkit.unitUtils;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;

import java.lang.reflect.Field;

/**
 * Created by zhangtao on 17/4/18.
 * Handle Keyboard problems in fullscreen mode,your activity inherit from activity，not AppCompatActivity.
 */

public class AndroidBug5497Workaround {

    // For more information, see https://code.google.com/p/android/issues/detail?id=5497
    // To use this class, simply invoke assistActivity() on an Activity that already has its content view set.
    public static final String TAG="log.dev.params";
    public static void assistActivity (Activity activity) {
        new AndroidBug5497Workaround(activity);
    }

    private View mChildOfContent;
    private int usableHeightPrevious;
    private FrameLayout.LayoutParams frameLayoutParams;

    private AndroidBug5497Workaround(final Activity activity) {
        FrameLayout content = (FrameLayout) activity.findViewById(android.R.id.content);
        mChildOfContent = content.getChildAt(0);
        mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                possiblyResizeChildOfContent(activity);
            }
        });
        frameLayoutParams = (FrameLayout.LayoutParams) mChildOfContent.getLayoutParams();
    }

    private void possiblyResizeChildOfContent(Activity activity) {
        int usableHeightNow = computeUsableHeight(activity);
        if (usableHeightNow != usableHeightPrevious) {
            int usableHeightSansKeyboard = mChildOfContent.getRootView().getHeight();
            int heightDifference = usableHeightSansKeyboard - usableHeightNow;
            Log.d(TAG,usableHeightSansKeyboard+"usableHeightSansKeyboard------->usableHeightNow"+usableHeightNow);
            if (heightDifference > (usableHeightSansKeyboard/4)) {
                // keyboard probably just became visible
                frameLayoutParams.height = usableHeightSansKeyboard - heightDifference;
            } else {
                // keyboard probably just became hidden
                frameLayoutParams.height = usableHeightSansKeyboard;
            }
            mChildOfContent.requestLayout();
            usableHeightPrevious = usableHeightNow;
        }
    }

    private int computeUsableHeight(Activity activity) {
        Rect r = new Rect();
        mChildOfContent.getWindowVisibleDisplayFrame(r);
        if(r.top==0){
            r.top=getStatusBarHeight();//状态栏目的高度
        }
        Log.d(TAG,r.bottom+"----->"+r.top);
        Log.d(TAG,activity.getWindow().getAttributes().flags+"====>"+WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if ((activity.getWindow().getAttributes().flags&WindowManager.LayoutParams.FLAG_FULLSCREEN)== WindowManager.LayoutParams.FLAG_FULLSCREEN){
            return r.bottom;
        }else {
            return (r.bottom - r.top);
        }
    }
    private int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return NContext.GetAppContext().getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

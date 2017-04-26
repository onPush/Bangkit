package com.android.zhangtao.Bangkit.unitUtils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by zhangtao on 16/4/28.
 */
public class NScreen {
    /**
     * @param activity
     * @return 判断当前手机是否是全屏
     */
    public static boolean isFullScreen(Activity activity) {
        int flag = activity.getWindow().getAttributes().flags;
        if((flag & WindowManager.LayoutParams.FLAG_FULLSCREEN)
                == WindowManager.LayoutParams.FLAG_FULLSCREEN) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断当前屏幕是否是横屏
     * @param activity
     * @return
     */
    public static boolean isVerticalScreen(Activity activity) {
        int flag = activity.getResources().getConfiguration().orientation;
        if (flag == 0) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * 在setContentView前面运行
     * @param activity
     */
    public static void setFullScreen(Activity activity){
        if (!NScreen.isFullScreen(activity)){
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
    /**
     * 在setContentView前面运行
     * @param activity
     */
    public static void cancleFullScreen(Activity activity){
        if (NScreen.isFullScreen(activity)){
            activity.getWindow().clearFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
    public static DisplayMetrics initDisplayMetrics(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }
    public static Display initDisplay(Context context){
        WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return  windowManager.getDefaultDisplay();
    }
    public static int getWidth(Context context){
        return initDisplay(context).getWidth();
    }
    public static int getHeight(Context context){
        return initDisplay(context).getHeight();
    }
    public static float getScreenDensity(Activity activity) {
        return initDisplayMetrics(activity).density;
    }

    public static int getScreenHeightPixels(Activity activity) {
        return initDisplayMetrics(activity).heightPixels;
    }

    public static int getScreenWidthPixels(Activity activity) {
        return initDisplayMetrics(activity).widthPixels;
    }

    public static int getScreenDPWidth(Activity activity) {
        return (int) (getScreenWidthPixels(activity) / getScreenDensity(activity));
    }

    public static int getScreenDPHeight(Activity activity) {
        return (int) (getScreenHeightPixels(activity) / getScreenDensity(activity));
    }


    public static int px2dip(float pxValue, Context context) {
        return (int) (pxValue
                / context.getResources().getDisplayMetrics().density + 0.5f);
    }

    public static int dip2px(Context context, float dipValue) {
        return (int) (dipValue
                * context.getResources().getDisplayMetrics().density + 0.5f);
    }

}

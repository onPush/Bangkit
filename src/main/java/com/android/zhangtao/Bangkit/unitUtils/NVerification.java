package com.android.zhangtao.Bangkit.unitUtils;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * Created by zhangtao on 17/3/16.
 */

public class NVerification {
    TextView getVerificationView;
    public NVerification(TextView getVerificationView){
        this.getVerificationView=getVerificationView;
    }
    public static final int TIME_MSG = 0;

    private Handler handler = new Handler() {
        int time = 59;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TIME_MSG:
                    if (time == 0) {
                        getVerificationView.setText("重新发送");
                        getVerificationView.setClickable(true);
                        time = 59;
                        return;
                    }
                    getVerificationView.setText("重新发送(" + String.valueOf(time) + ")s");
                    time--;
                    break;
            }
        }
    };
    public void startTime(){
        if (getVerificationView==null){
            throw new NullPointerException("TextView is nil");
        }
        new TimeThread().start();
    }
    public class TimeThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 60; i++) {
                try {
                    Thread.sleep(1000);
                    Message message = new Message();
                    message.what = TIME_MSG;
                    handler.sendMessage(message);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

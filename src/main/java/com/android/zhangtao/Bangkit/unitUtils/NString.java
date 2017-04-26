package com.android.zhangtao.Bangkit.unitUtils;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NString {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static byte[] StringToArrayByte(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes(UTF_8);
    }

    public static String ArrayByteToString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return new String(bytes, UTF_8);
    }

    static public boolean IsEmailValid(String EmailStr) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,10}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(EmailStr);
        return m.matches();
    }

    static public boolean IsPhoneFormatValid(String PhoneStr) {
        String str = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(PhoneStr);
        return m.matches();
    }

    static public  boolean allNum(String string) {
        char num[] = string.toCharArray();
        StringBuilder numStringBuilder = new StringBuilder();
        for(int i=0;i<num.length;i++){
            if(Character.isDigit(num[i])){
                numStringBuilder.append(num[i]);
            }
        }
        if(numStringBuilder.toString().length()==string.length()){
            return  true;
        }else{
            return false;
        }
    }

    static public boolean isToNumLength(String num){
        return num.length()==11;
    }

    static public boolean IsPhoneValid(String num){
        if (TextUtils.isEmpty(num)){
            ToastUtil.show("请输入手机号码！");
            return false;
        }else if (!isToNumLength(num)||!allNum(num)||!IsPhoneFormatValid(num)){
            ToastUtil.show("输入的手机号无效！");
            return false;
        }else {
            return true;
        }
    }

    static public String ByteToUnitString(long byteTransfer) {
        double transfer = (new Long(byteTransfer)).doubleValue();
        if (byteTransfer >= 1024L * 1024 * 1024 * 1024 || byteTransfer <= -1024L * 1024 * 1024 * 1024) {
            return GetTwoDecimal(transfer / (1024L * 1024 * 1024 * 1024)) + "TB";
        } else if (byteTransfer >= 1024L * 1024 * 1024 || byteTransfer <= -1024L * 1024 * 1024) {
            return GetTwoDecimal(transfer / (1024L * 1024 * 1024)) + "GB";
        } else if (byteTransfer >= 1024 * 1024 || byteTransfer <= -1024L * 1024) {
            return GetTwoDecimal(transfer / (1024 * 1024)) + "MB";
        } else if (byteTransfer >= 1024 || byteTransfer <= -1024L) {
            return GetTwoDecimal(transfer / 1024) + "KB";
        } else {
            return Double.toString(transfer) + "B";
        }
    }

    // Data num
    static public String ByteToUnitString_num(long byteTransfer) {
        double transfer = (new Long(byteTransfer)).doubleValue();
        if (byteTransfer >= 1024L * 1024 * 1024 * 1024 || byteTransfer <= -1024L * 1024 * 1024 * 1024) {
            return GetTwoDecimal(transfer / (1024L * 1024 * 1024 * 1024));
        } else if (byteTransfer >= 1024L * 1024 * 1024 || byteTransfer <= -1024L * 1024 * 1024) {
            return GetTwoDecimal(transfer / (1024L * 1024 * 1024));
        } else if (byteTransfer >= 1024 * 1024 || byteTransfer <= -1024L * 1024) {
            return GetTwoDecimal(transfer / (1024 * 1024));
        } else if (byteTransfer >= 1024 || byteTransfer <= -1024L) {
            return GetTwoDecimal(transfer / 1024);
        } else {
            return Double.toString(transfer);
        }
    }

    //Data unit
    static public String ByteToUnitString_unit(long byteTransfer) {
        if (byteTransfer >= 1024L * 1024 * 1024 * 1024 || byteTransfer <= -1024L * 1024 * 1024 * 1024) {
            return "TB";
        } else if (byteTransfer >= 1024L * 1024 * 1024 || byteTransfer <= -1024L * 1024 * 1024) {
            return "GB";
        } else if (byteTransfer >= 1024 * 1024 || byteTransfer <= -1024L * 1024) {
            return "MB";
        } else if (byteTransfer >= 1024 || byteTransfer <= -1024L) {
            return "KB";
        } else {
            return "B";
        }
    }

    static public String GetTwoDecimal(double input) {
        if (input == 0) {
            return "0";
        }
        BigDecimal b = new BigDecimal(input);
        Double d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return Double.toString(d);
    }

//    static public boolean CheckInputEmpty(Context context, String inputStr, String name) {
//        if (inputStr.isEmpty()) {
//            SVProgressHUD.showInfoWithStatus(context, name + "不能为空");
//            return false;
//        }
//        return true;
//    }

    static public String IntToString(int input) {
        return Integer.toString(input);
    }

    public static String IonvertISToString(InputStream inputStream) {
        StringBuffer string = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                string.append(line + "\n");
            }
        } catch (IOException e) {
        }
        return string.toString();
    }

    public static boolean isNullOrEmpty(final List<?> c) {
        return c == null || c.isEmpty();
    }

    public static boolean IsEmpty(String str) {
        return !"".equals(str);
    }

    public static void insertStr(EditText editText, String str) {
        int index = editText.getSelectionStart();//获取光标所在位置
        Editable edit = editText.getEditableText();//获取EditText的文字
        if (index < 0 || index >= edit.length()) {
            edit.append(str);
        } else {
            edit.insert(index, str);//光标所在位置插入文字
        }
    }

//    public static SpannableStringBuilder changeFontColor(String str, String targetStr) {
//        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
//
//        List<Integer> list = getIndexList(str, targetStr);
//
//        if (IsOutOfRange(list)) return spannableStringBuilder;
//        setSpan(spannableStringBuilder, list);
//        return spannableStringBuilder;
//    }
//
//    public static SpannableStringBuilder changeFontColor(String str, String targetStr,String args) {
//        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
//
//        List<Integer> list = getIndexList(str, targetStr);
//        List<Integer> list1=getIndexList(str,args);
//        if (IsOutOfRange(list)&&IsOutOfRange(list1)) {
//            return spannableStringBuilder;
//        }else if (IsOutOfRange(list)) {
//            setSpan(spannableStringBuilder,list1);
//        }else if (IsOutOfRange(list1)){
//            setSpan(spannableStringBuilder,list);
//        }else {
//            list.addAll(list1);
//            setSpan(spannableStringBuilder, list);
//        }
//        return spannableStringBuilder;
//    }
//
//    public static SpannableStringBuilder changeFontColor(String str, String targetStr,String args,String args01) {
//        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
//
//        List<Integer> list = getIndexList(str, targetStr);
//        List<Integer> list1=getIndexList(str,args);
//        List<Integer> list2=getIndexList(str,args01);
//        if (IsOutOfRange(list)&&IsOutOfRange(list1)&&IsOutOfRange(list2)) {
//            return spannableStringBuilder;
//        }else if (IsOutOfRange(list)&&IsOutOfRange(list2)) {
//            setSpan(spannableStringBuilder,list1);
//        }else if (IsOutOfRange(list1)&&IsOutOfRange(list2)){
//            setSpan(spannableStringBuilder,list);
//        }else if (IsOutOfRange(list)&&IsOutOfRange(list1)){
//            setSpan(spannableStringBuilder,list2);
//        }else if (IsOutOfRange(list)){
//            list2.addAll(list1);
//            setSpan(spannableStringBuilder,list2);
//        }else if(IsOutOfRange(list1)){
//            list2.addAll(list);
//            setSpan(spannableStringBuilder,list2);
//        }else if(IsOutOfRange(list2)){
//            list1.addAll(list);
//            setSpan(spannableStringBuilder,list1);
//        }else {
//            list.addAll(list1);
//            list.addAll(list2);
//            setSpan(spannableStringBuilder, list);
//        }
//        return spannableStringBuilder;
//    }

//    private static void setSpan(SpannableStringBuilder spannableStringBuilder, List<Integer> list) {
//        for (int i = 0; i < list.size(); i = i + 2) {
//            spannableStringBuilder.setSpan(new MyClickText(), list.get(i), list.get(i + 1), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        }
//    }
    private static boolean IsOutOfRange(List<Integer> list) {
        for (int k : list) {
            if (k == -1) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    private static List<Integer> getIndexList(String str, String targetStr) {
        List<Integer> list = new ArrayList();

        int firstIndex = str.indexOf(targetStr);
        int i = firstIndex + targetStr.length();
        list.add(firstIndex);
        list.add(i);
        while (true) {
            if (i < str.length()) {
                int index = str.substring(i).indexOf(targetStr);
                if (index == -1) {
                    return list;
                }
                list.add(i + index);
                list.add(i + index + targetStr.length());
                i = i + index + targetStr.length();
            } else {
                return list;
            }
        }
    }


    public static SpannableString matcherSearchTitle(int color, CharSequence text,
                                                     List<String> keyword) {
        SpannableString s = new SpannableString(text);
        for (int i = 0; i < keyword.size(); i++) {
            Pattern p = Pattern.compile(keyword.get(i));
            Matcher m = p.matcher(s);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                s.setSpan(new ForegroundColorSpan(color), start, end,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return s;
    }
    public static SpannableString matcherSearchTitle(int color, CharSequence text,
                                                     String[] keyword) {
        SpannableString s = new SpannableString(text);
        for (int i = 0; i < keyword.length; i++) {
            Pattern p = Pattern.compile(keyword[i]);
            Matcher m = p.matcher(s);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                s.setSpan(new ForegroundColorSpan(color), start, end,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return s;
    }
    public static SpannableString matcherSearchTitle(int color, String text,
                                                     List<String> keyword, ClickableSpan clickableSpan) {
        SpannableString s = new SpannableString(text);
        for (int i = 0; i < keyword.size(); i++) {
            Pattern p = Pattern.compile(keyword.get(i));
            Matcher m = p.matcher(s);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                s.setSpan(clickableSpan, start, end,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return s;
    }


}


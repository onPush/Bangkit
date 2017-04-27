package com.android.zhangtao.Bangkit.handleImg;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.android.zhangtao.Bangkit.unitUtils.NContext;
import com.android.zhangtao.Bangkit.unitUtils.NString;
import com.bumptech.glide.Glide;
import java.io.File;


/**
 * Created by zhangtao on 17/3/23.
 */

public class NImg {
    public static void asNameToSetImgInMipmap(ImageView imageView, Context context, String imgName){
//        "lv_" + feed.userGrade + "_ic"
        imageView.setImageResource(context.getResources().getIdentifier(imgName, "mipmap", context.getPackageName()));
    }

    /**
     * 设置图片的方法
     * @param context
     * @param imgUrl
     * @param imgView
     * 当context为activity的时候，glide加载的生命周期和activity一致,比如onPause Glide会暂停加载。
     */
    public static void setImgtoImageView(Activity context, String imgUrl, ImageView imgView){
        Glide
                .with(context)
                .load(imgUrl)
//                .placeholder(R.mipmap.defalut) //设置占位图
//                .error(R.mipmap.error) //设置错误图片
                .crossFade() //设置淡入淡出效果，默认300ms，可以传参
//                .dontAnimate() //不显示动画效果
                .into(imgView);
    }
    public static void setImgtoImageView(String imgUrl, ImageView imgView){
        Glide.with(NContext.GetAppContext()).load(imgUrl).into(imgView);
    }
    public static void setImgtoImageView(Fragment context, String imgUrl, ImageView imgView){
        Glide.with(context).load(imgUrl).into(imgView);
    }

    public static long getImgCacheSize(){
        Glide.get(NContext.GetAppContext())
                .clearDiskCache();
        File cacheFile=Glide.getPhotoCacheDir(NContext.GetAppContext());
        if (cacheFile.exists()&&cacheFile.isFile()){
            return cacheFile.length();
        }
        return -1;
    }
    //格式化缓存大小
    public static String getImgCacheFormatSize(){
        return NString.ByteToUnitString(getImgCacheSize());
    }

    public static void clearImgCache(){
        Glide.get(NContext.GetAppContext())
                .clearDiskCache();
        Glide.get(NContext.GetAppContext())
                .clearMemory();
    }
    /**
     * 九宫格lib特定的方法
     * @param
     * @return
     */
//    @NonNull
//    public static ArrayList<ImageInfo> GetImageInfos(FeedHome.FeedHomeT.Feed feed) {
//        ArrayList<ImageInfo> imageInfo = new ArrayList<>();
//
//        if (feed.resList != null) {
//            for (FeedHome.FeedHomeT.Feed.ResListBean resList : feed.resList) {
//                ImageInfo info = new ImageInfo();
//                info.setThumbnailUrl(resList.content);
//                info.setBigImageUrl(resList.content);
//                imageInfo.add(info);
//            }
//        }

//        return imageInfo;
//    }
//    public static void setNineGridView(Context context, NineGridView contentImg, FeedHome.FeedHomeT.Feed feed){
//        contentImg.setAdapter(new NineGridViewClickAdapter(context, GetImageInfos(feed)));
//    }
}

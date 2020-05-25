package com.xdynamics.share.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @ProjectName: ShareDemo
 * @Package: com.xdynamics.share.webview
 * @ClassName: WebViewSetting
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/16 16:43
 * @UpdateUser:
 * @UpdateDate: 2020/5/16 16:43
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShareIWebViewSetting implements IWebViewSetting {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    public void setting(WebView view) {

        if (view == null) return;

        Context context = view.getContext();

//        view.clearCache(true);
//        view.clearFormData();
//        view.clearHistory();
//        view.clearSslPreferences();

//        view.setRendererPriorityPolicy(WebView.RENDERER_PRIORITY_BOUND, true);

//        view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//声明WebSettings子类
        WebSettings webSettings = view.getSettings();
//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
////设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
////缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
////其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webSettings.setMediaPlaybackRequiresUserGesture(true);
//        webSettings.setLoadWithOverviewMode(true);

//      开启Application Cache存储机制
//        String cacheDirPath = context.getFilesDir().getAbsolutePath() + "cache/";
//        webSettings.setAppCachePath(cacheDirPath);
//        webSettings.setAppCacheEnabled(true);
//      开启DOM storage
        webSettings.setDomStorageEnabled(true);
//      开启数据库存储机制
        webSettings.setDatabaseEnabled(true);

//        cookie
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.acceptThirdPartyCookies(view);
        cookieManager.flush();

    }
}

package com.xdynamics.share;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.orhanobut.logger.Logger;

/**
 * @ProjectName: ShareDemo
 * @Package: com.xdynamics.share.webview
 * @ClassName: ShareWebViewClient
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/16 16:47
 * @UpdateUser:
 * @UpdateDate: 2020/5/16 16:47
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShareWebViewClient extends com.just.agentweb.WebViewClient {

    private OnPageLoadingListener onPageLoadingListener;

    public OnPageLoadingListener getOnPageLoadingListener() {
        return onPageLoadingListener;
    }

    public void setOnPageLoadingListener(OnPageLoadingListener onPageLoadingListener) {
        this.onPageLoadingListener = onPageLoadingListener;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

        Logger.d("shouldOverrideUrlLoading");

//        view.loadUrl(request.getUrl().getPath());

        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {

        Logger.d("shouldOverrideKeyEvent");

        return super.shouldOverrideKeyEvent(view, event);
    }

    @Nullable
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {

        Logger.d("shouldInterceptRequest---- Method: %s \n log: %s", request.getMethod(), request.getUrl());

        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Logger.d("onPageStarted");

        if (onPageLoadingListener != null)
            onPageLoadingListener.onPageStarted(view, url, favicon);
    }


    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

        Logger.d("onPageFinished");

        if (onPageLoadingListener != null)
            onPageLoadingListener.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        Logger.d("----onLoadResource----> url: %s", url);
    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
        super.onPageCommitVisible(view, url);
        Logger.d("onPageCommitVisible, \n url: %s", url);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);

        Logger.d("onReceivedError, URL: %s \n ErrorCode: %d, \n Description: %s", request.getUrl().getPath(), error.getErrorCode(), error.getDescription());
    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        Logger.d("onReceivedHttpError");
    }

    @Override
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        super.onFormResubmission(view, dontResend, resend);
        Logger.d("onFormResubmission");
    }

    @Override
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
        Logger.d("doUpdateVisitedHistory");
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
        Logger.d("onReceivedSslError");
    }

    @Override
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        super.onReceivedClientCertRequest(view, request);
        Logger.d("onReceivedClientCertRequest");
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
        Logger.d("onReceivedHttpAuthRequest");
    }

    @Override
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        super.onUnhandledKeyEvent(view, event);
        Logger.d("onUnhandledKeyEvent");
    }

    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
        Logger.d("onScaleChanged");
    }

    @Override
    public void onReceivedLoginRequest(WebView view, String realm, @Nullable String account, String args) {
        super.onReceivedLoginRequest(view, realm, account, args);
        Logger.d("onReceivedLoginRequest");
    }

    @Override
    public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType, SafeBrowsingResponse callback) {
        super.onSafeBrowsingHit(view, request, threatType, callback);
        Logger.d("onSafeBrowsingHit");
    }


    public interface OnPageLoadingListener {

        void onPageStarted(WebView view, String url, Bitmap favicon);

        void onPageFinished(WebView view, String url);
    }

}

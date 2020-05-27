package com.xdynamics.share.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.webkit.WebView;

import com.just.agentweb.IWebLayout;
import com.xdynamics.share.R;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.widget
 * @ClassName: WebLayout
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/27 16:57
 * @UpdateUser:
 * @UpdateDate: 2020/5/27 16:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public class WebLayout implements IWebLayout<WebView, SwipeRefreshLayout> {

    private WebView mWebView;

    private SwipeRefreshLayout mRefresh;

    public WebLayout(@NonNull Context context) {

        mRefresh = (SwipeRefreshLayout) View.inflate(context, R.layout.widget_share_web, null);

        mWebView = mRefresh.findViewById(R.id.web_view);
    }

    @NonNull
    @Override
    public SwipeRefreshLayout getLayout() {

        return mRefresh;
    }

    @Nullable
    @Override
    public WebView getWebView() {

        return mWebView;
    }


}

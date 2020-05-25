package com.xdynamics.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;

import com.xdynamics.share.platform.SharePlatform;


/**
 * @ProjectName: ShareDemo
 * @Package: com.xdynamics.share.webview
 * @ClassName: ShareWebFragment
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 9:40
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 9:40
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShareWebFragment extends Fragment {

    private WebView mWebView;

    private SwipeRefreshLayout mSwipeRefresh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_share_web, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mWebView = view.findViewById(R.id.web_view);

        mSwipeRefresh = view.findViewById(R.id.refresh);

        mSwipeRefresh.setOnRefreshListener(() -> {

            if (mWebView != null)
                mWebView.reload();

        });

        mWebView.setOnKeyListener((v, keyCode, event) -> {

            if (keyCode == KeyEvent.KEYCODE_BACK) {

                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
            }
            return false;
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (mWebView == null) return;

        SharePlatform platform = ShareManager.getInstance().platform();

        platform.client().setOnPageLoadingListener(new ShareWebViewClient.OnPageLoadingListener() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                if (mSwipeRefresh != null)
                    mSwipeRefresh.setRefreshing(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                if (mSwipeRefresh != null)
                    mSwipeRefresh.setRefreshing(false);
            }
        });

        platform.webViewSetting().setting(mWebView);
        mWebView.setWebChromeClient(platform.chromeClient());
        mWebView.setWebViewClient(platform.client());

        WebView.setWebContentsDebuggingEnabled(true);
//        WebView.enableSlowWholeDocumentDraw();
//        WebView.clearClientCertPreferences(() -> {
//        });

        mWebView.loadUrl(platform.index());

    }

    @Override
    public void onPause() {
        super.onPause();

        if (mWebView != null) {
            mWebView.onPause();
            mWebView.pauseTimers();
        }
    }


    @Override
    public void onResume() {
        super.onResume();

        if (mWebView != null) {
            mWebView.onResume();
            mWebView.resumeTimers();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mWebView != null && mSwipeRefresh != null) {
            mWebView.removeAllViews();
            mSwipeRefresh.removeView(mWebView);
            mWebView.destroy();
        }
    }
}

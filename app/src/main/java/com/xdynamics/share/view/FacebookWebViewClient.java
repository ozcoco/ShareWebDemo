package com.xdynamics.share.view;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import com.xdynamics.share.ShareWebViewClient;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.view
 * @ClassName: FacebookWebViewClient
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 15:42
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 15:42
 * @UpdateRemark:
 * @Version: 1.0
 */
public class FacebookWebViewClient extends ShareWebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }
}

package com.xdynamics.share.platform;

import com.xdynamics.share.ShareWebChromeClient;
import com.xdynamics.share.ShareWebViewClient;
import com.xdynamics.share.view.IWebViewSetting;
import com.xdynamics.share.view.ShareIWebViewSetting;
import com.xdynamics.share.view.InstagramWebChromeClient;
import com.xdynamics.share.view.InstagramWebViewClient;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.platform
 * @ClassName: Facebook
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 14:46
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 14:46
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Instagram extends BasePlatform implements SharePlatform {

    public Instagram(String index) {
        super(index, new InstagramWebViewClient(), new InstagramWebChromeClient(), new ShareIWebViewSetting());
    }

    @Override
    public String index() {
        return getIndex();
    }

    @Override
    public ShareWebViewClient client() {
        return getClient();
    }

    @Override
    public ShareWebChromeClient chromeClient() {
        return getChromeClient();
    }

    @Override
    public IWebViewSetting webViewSetting() {
        return getSetting();
    }

}

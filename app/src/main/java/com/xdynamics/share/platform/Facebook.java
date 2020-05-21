package com.xdynamics.share.platform;

import com.xdynamics.share.ShareWebChromeClient;
import com.xdynamics.share.ShareWebViewClient;
import com.xdynamics.share.view.FacebookWebChromeClient;
import com.xdynamics.share.view.FacebookWebViewClient;
import com.xdynamics.share.view.IWebViewSetting;
import com.xdynamics.share.view.ShareIWebViewSetting;

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
public class Facebook extends BasePlatform implements SharePlatform {

    public Facebook(String index) {
        super(index, new FacebookWebViewClient(), new FacebookWebChromeClient(), new ShareIWebViewSetting());
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

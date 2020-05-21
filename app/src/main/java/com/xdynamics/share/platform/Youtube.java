package com.xdynamics.share.platform;

import com.xdynamics.share.ShareWebChromeClient;
import com.xdynamics.share.ShareWebViewClient;
import com.xdynamics.share.view.IWebViewSetting;
import com.xdynamics.share.view.ShareIWebViewSetting;
import com.xdynamics.share.view.YoutubeWebChromeClient;
import com.xdynamics.share.view.YoutubeWebViewClient;

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
public class Youtube extends BasePlatform implements SharePlatform {

    public Youtube(String index) {
        super(index, new YoutubeWebViewClient(), new YoutubeWebChromeClient(), new ShareIWebViewSetting());
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

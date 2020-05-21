package com.xdynamics.share.platform;

import com.xdynamics.share.ShareWebChromeClient;
import com.xdynamics.share.ShareWebViewClient;
import com.xdynamics.share.view.IWebViewSetting;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.platform
 * @ClassName: BasePlatform
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 14:49
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 14:49
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BasePlatform {

    private String index;

    private ShareWebViewClient client;

    private ShareWebChromeClient chromeClient;

    private IWebViewSetting setting;

    public BasePlatform(String index, ShareWebViewClient client, ShareWebChromeClient chromeClient, IWebViewSetting setting) {
        this.index = index;
        this.client = client;
        this.chromeClient = chromeClient;
        this.setting = setting;
    }


    public String getIndex() {
        return index;
    }

    public ShareWebViewClient getClient() {
        return client;
    }

    public ShareWebChromeClient getChromeClient() {
        return chromeClient;
    }

    public IWebViewSetting getSetting() {
        return setting;
    }
}

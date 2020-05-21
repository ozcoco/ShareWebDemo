package com.xdynamics.share.platform;

import com.xdynamics.share.ShareWebChromeClient;
import com.xdynamics.share.ShareWebViewClient;
import com.xdynamics.share.view.IWebViewSetting;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share
 * @ClassName: SharePlatform
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 14:19
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 14:19
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface SharePlatform {

    String index();

    ShareWebViewClient client();

    ShareWebChromeClient chromeClient();

    IWebViewSetting webViewSetting();
}

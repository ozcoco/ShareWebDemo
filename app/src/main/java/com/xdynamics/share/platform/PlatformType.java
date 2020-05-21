package com.xdynamics.share.platform;

import com.xdynamics.share.ShareConfig;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.platform
 * @ClassName: PlatformType
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 15:31
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 15:31
 * @UpdateRemark:
 * @Version: 1.0
 */
public enum PlatformType {
    FACEBOOK(ShareConfig.INDEX_FACEBOOK),
    TWITTER(ShareConfig.INDEX_TWITTER),
    INSTAGRAM(ShareConfig.INDEX_INSTAGRAM),
    YOUTUBE(ShareConfig.INDEX_YOUTUBE);

    private String index;

    PlatformType(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }
}

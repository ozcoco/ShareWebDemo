package com.xdynamics.share;

import com.xdynamics.share.platform.PlatformType;
import com.xdynamics.share.platform.SharePlatform;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share
 * @ClassName: ShareManager
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 15:07
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 15:07
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShareManager implements IShareManager {

    @Override
    public void initPlatform(PlatformType type) {
        Singleton.INSTANCE.initPlatform(type);
    }

    @Override
    public SharePlatform platform() {
        return Singleton.INSTANCE.platform();
    }

    private final static class Singleton {
        private static IShareManager INSTANCE = new ShareManagerImpl();
    }

    public static IShareManager getInstance() {
        return Singleton.INSTANCE;
    }

}

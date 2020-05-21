package com.xdynamics.share;

import com.xdynamics.share.platform.PlatformType;
import com.xdynamics.share.platform.SharePlatform;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share
 * @ClassName: IShareManager
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 15:08
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 15:08
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IShareManager {

    void initPlatform(PlatformType type);

    SharePlatform platform();

}

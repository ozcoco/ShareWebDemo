package com.xdynamics.share.p2p;

import android.content.Context;

import com.xdynamics.share.p2p.server.IServer;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p
 * @ClassName: IServerManager
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/29 10:07
 * @UpdateUser:
 * @UpdateDate: 2020/5/29 10:07
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IServerManager extends IServer {

    void init(Context context);

    void destroy();
}

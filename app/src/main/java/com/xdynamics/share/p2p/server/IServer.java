package com.xdynamics.share.p2p.server;

import java.io.IOException;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server
 * @ClassName: Serverable
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/25 14:04
 * @UpdateUser:
 * @UpdateDate: 2020/5/25 14:04
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IServer {

    void start() throws IOException;

    void stop();

    boolean isAlive();

    String getHostname();

    int getPort();
}

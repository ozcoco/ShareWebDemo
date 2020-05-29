package com.xdynamics.share.p2p.server;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server
 * @ClassName: HttpServer
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/25 14:05
 * @UpdateUser:
 * @UpdateDate: 2020/5/25 14:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BaseServer extends NanoHTTPD implements IServer {

    public BaseServer(int port) {
        super(port);
    }

    public BaseServer(String hostname, int port) {
        super(hostname, port);

    }

    @Override
    public void start() throws IOException {
        super.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
    }

    @Override
    public int getPort() {
        return super.getListeningPort();
    }

}

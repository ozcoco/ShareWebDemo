package com.xdynamics.share.p2p;

import android.content.Context;

import java.io.IOException;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p
 * @ClassName: ServerManager
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/29 10:03
 * @UpdateUser:
 * @UpdateDate: 2020/5/29 10:03
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ServerManager implements IServerManager {

    private ServerManager() {
    }


    @Override
    public void start() throws IOException {
        Singleton.INSTANCE.start();
    }

    @Override
    public void stop() {
        Singleton.INSTANCE.stop();
    }

    @Override
    public boolean isAlive() {
        return Singleton.INSTANCE.isAlive();
    }

    @Override
    public String getHostname() {
        return Singleton.INSTANCE.getHostname();
    }

    @Override
    public int getPort() {
        return Singleton.INSTANCE.getPort();
    }

    public static IServerManager getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public void init(Context context) {
        Singleton.INSTANCE.init(context);
    }

    @Override
    public void destroy() {
        Singleton.INSTANCE.destroy();
    }

    private final static class Singleton {
        private static IServerManager INSTANCE = new ServerManagerImpl();
    }
}

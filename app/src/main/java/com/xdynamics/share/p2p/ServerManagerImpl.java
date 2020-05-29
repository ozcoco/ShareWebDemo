package com.xdynamics.share.p2p;

import android.content.Context;

import com.google.gson.Gson;
import com.xdynamics.share.p2p.bean.ServerConfig;
import com.xdynamics.share.p2p.server.HttpServer;
import com.xdynamics.share.p2p.server.IServer;
import com.xdynamics.share.p2p.server.res.ResourceManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p
 * @ClassName: ServerManagerImpl
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/29 10:09
 * @UpdateUser:
 * @UpdateDate: 2020/5/29 10:09
 * @UpdateRemark:
 * @Version: 1.0
 */
class ServerManagerImpl implements IServerManager {

    public final static String SERVER_CONFIG = "server/server_config.json";

    private IServer server;

    @Override
    public void start() throws IOException {

        try {
            if (server != null && !server.isAlive())
                server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {
        if (server != null && server.isAlive())
            server.stop();
    }

    @Override
    public boolean isAlive() {
        return server != null && server.isAlive();
    }

    @Override
    public String getHostname() {
        if (server != null && server.isAlive())
            return server.getHostname();
        return null;
    }

    @Override
    public int getPort() {
        return server != null ? server.getPort() : 0;
    }

    @Override
    public void init(Context context) {

        /* 加载资源 */
        ResourceManager.getInstance().init(context);

        /* 初始化服务器 */
        StringBuilder buff = new StringBuilder();

        try (InputStream open = context.getAssets().open(SERVER_CONFIG)) {

            int ch;

            for (; (ch = open.read()) != -1; ) {
                buff.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ServerConfig config = new Gson().fromJson(buff.toString(), ServerConfig.class);

        server = new HttpServer(config.getPort());

    }

    @Override
    public void destroy() {
        server = null;
        ResourceManager.getInstance().destroy();
    }
}

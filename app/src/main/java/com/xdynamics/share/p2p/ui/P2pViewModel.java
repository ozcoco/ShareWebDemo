package com.xdynamics.share.p2p.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.xdynamics.share.p2p.server.HttpServer;
import com.xdynamics.share.p2p.server.IServer;

import java.io.IOException;

public class P2pViewModel extends AndroidViewModel {

    public final int SERVER_PORT = 8080;

    private IServer server;

    public P2pViewModel(@NonNull Application application) {
        super(application);

        server = new HttpServer(SERVER_PORT);

    }

    public void startServer() {
        try {
            if (server != null && !server.isAlive())
                server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        if (server != null && server.isAlive())
            server.stop();
    }


    public String getHostname() {
        if (server != null && server.isAlive())
            return server.getHostname();
        return null;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        stopServer();

    }
}

package com.xdynamics.share.p2p.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.xdynamics.share.p2p.IServerManager;
import com.xdynamics.share.p2p.ServerManager;

import java.io.IOException;

public class P2pViewModel extends AndroidViewModel {

    private final IServerManager mServerManager;

    public P2pViewModel(@NonNull Application application) {
        super(application);

        mServerManager = ServerManager.getInstance();
        mServerManager.init(application);

    }

    public void startServer() {

        try {

            mServerManager.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopServer() {

        mServerManager.stop();

    }


    public String getHostname() {

        return mServerManager.getHostname();
    }

    public int getPort() {

        return mServerManager.getPort();
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        mServerManager.destroy();

    }
}

package com.xdynamics.share.p2p.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.RemoteException;
import android.support.annotation.NonNull;

import com.xdynamics.App;

public class P2pViewModel extends AndroidViewModel {

    private final App app;

    public P2pViewModel(@NonNull Application application) {
        super(application);

        app = (App) application;

        app.bindXShare();

    }

    public void startServer() {

        try {
            if (app.getRemoteServerManager() != null)
                app.getRemoteServerManager().startHttpServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public void stopServer() {
        try {
            if (app.getRemoteServerManager() != null)
                app.getRemoteServerManager().stopHttpServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public String getHostname() {
        try {
            if (app.getRemoteServerManager() != null)
                return app.getRemoteServerManager().getHostname();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getPort() {

        try {
            if (app.getRemoteServerManager() != null)
                return app.getRemoteServerManager().getPort();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        app.unbindXShare();

    }
}

package com.xdynamics.share.p2p;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.xdynamics.share.p2p.aidl.IRemoteServerManager;

import java.io.IOException;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p
 * @ClassName: RemoteServerManagerService
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/6/8 11:31
 * @UpdateUser:
 * @UpdateDate: 2020/6/8 11:31
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RemoteServerManagerService extends Service {

    private final static String TAG = RemoteServerManagerService.class.getCanonicalName();

    private P2pBinder mP2pBinder;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "------> RemoteServerManagerService.onCreate()");

        ServerManager.getInstance().init(this);

        try {
            ServerManager.getInstance().start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class P2pBinder extends IRemoteServerManager.Stub {

        private final IServerManager mServerManager;

        public P2pBinder(IServerManager serverManager) {

            Log.d(TAG, "------> RemoteServerManagerService------> P2pBinder");

            mServerManager = serverManager;

        }

        @Override
        public void startHttpServer() throws RemoteException {

            Log.d(TAG, "------> RemoteServerManagerService-----> startHttpServer()");

            try {
                mServerManager.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void stopHttpServer() throws RemoteException {

            Log.d(TAG, "------> RemoteServerManagerService-----> stopHttpServer()");
            mServerManager.stop();
        }

        @Override
        public boolean isAlive() throws RemoteException {

            Log.d(TAG, "------> RemoteServerManagerService-----> isAlive()");
            return mServerManager.isAlive();
        }

        @Override
        public String getHostname() throws RemoteException {

            Log.d(TAG, "------> RemoteServerManagerService-----> getHostname()");

            return mServerManager.getHostname();
        }

        @Override
        public int getPort() throws RemoteException {

            Log.d(TAG, "------> RemoteServerManagerService-----> getPort()");

            return mServerManager.getPort();
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "------> RemoteServerManagerService.onBind");

        return mP2pBinder == null ? mP2pBinder = new P2pBinder(ServerManager.getInstance()) : mP2pBinder;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        ServerManager.getInstance().stop();

        ServerManager.getInstance().destroy();

    }
}

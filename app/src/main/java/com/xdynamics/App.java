package com.xdynamics;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.xdynamics.share.p2p.RemoteServerManagerService;
import com.xdynamics.share.p2p.aidl.IRemoteServerManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics
 * @ClassName: App
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 17:27
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 17:27
 * @UpdateRemark:
 * @Version: 1.0
 */
public class App extends Application {

    private final static String TAG = App.class.getCanonicalName();

    private IRemoteServerManager remoteServerManager;

    private ServiceConnection mServiceConnection;

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.addLogAdapter(new AndroidLogAdapter());

        String processName = getProcessName();
        //判断进程名，保证只有主进程运行
        if (processName != null && processName.equals(getPackageName())) {
            //main process
            Log.d(TAG, "----main process-----> App.onCreate()");
//            bindXShare();

            startXShare();
        }

    }

    public IRemoteServerManager getRemoteServerManager() {
        return remoteServerManager;
    }

    public void startXShare() {

        Intent intent = new Intent(this, RemoteServerManagerService.class);

        startService(intent);

    }

    public void bindXShare() {

        Intent intent = new Intent(this, RemoteServerManagerService.class);
        bindService(intent, mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                Log.d(TAG, "----bindXShare-----> onServiceConnected");

                remoteServerManager = IRemoteServerManager.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

                Log.d(TAG, "----bindXShare-----> onServiceDisconnected");
            }
        }, BIND_AUTO_CREATE);
    }


    public void unbindXShare() {

        if (mServiceConnection != null)
            unbindService(mServiceConnection);

    }


    public static String getProcessName() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

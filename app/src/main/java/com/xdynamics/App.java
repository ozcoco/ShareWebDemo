package com.xdynamics;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

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

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}

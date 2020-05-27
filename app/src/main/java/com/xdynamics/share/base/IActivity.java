package com.xdynamics.share.base;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.base
 * @ClassName: IActivity
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/27 15:55
 * @UpdateUser:
 * @UpdateDate: 2020/5/27 15:55
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IActivity {

    public void setSupportActionBar(Toolbar toolbar);

    public ActionBar getSupportActionBar();
}

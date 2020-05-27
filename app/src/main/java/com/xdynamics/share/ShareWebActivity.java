package com.xdynamics.share;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

import com.xdynamics.share.base.BaseActivity;
import com.xdynamics.share.base.IOnKeyDown;


/**
 * @ProjectName: ShareDemo
 * @Package: com.xdynamics.share.webview
 * @ClassName: ShareWebActivity
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 10:03
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 10:03
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShareWebActivity extends BaseActivity {


    IOnKeyDown mOnKeyDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_share_web);

        ShareAgentWebFragment fragment = new ShareAgentWebFragment();

        mOnKeyDown = fragment;

        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commitNow();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mOnKeyDown.onKeyDown(keyCode, event))
            return true;

        return super.onKeyDown(keyCode, event);
    }
}

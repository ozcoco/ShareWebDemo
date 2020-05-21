package com.xdynamics.share;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xdynamics.share.R;


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
public class ShareWebActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_share_web);

        getSupportFragmentManager().beginTransaction().add(R.id.container, new ShareWebFragment()).commitNow();

    }
}

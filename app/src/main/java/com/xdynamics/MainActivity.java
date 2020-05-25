package com.xdynamics;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xdynamics.share.R;
import com.xdynamics.share.ShareManager;
import com.xdynamics.share.ShareWebActivity;
import com.xdynamics.share.p2p.P2pActivity;
import com.xdynamics.share.platform.PlatformType;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.BLUETOOTH,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_COARSE_LOCATION
        }, 101);

    }

    @SuppressLint("SdCardPath")
    Uri[] images = new Uri[]{
            Uri.fromFile(new File("/sdcard/test.jpg")),
            Uri.fromFile(new File("/sdcard/test2.jpg")),
    };

    @SuppressLint("SdCardPath")
    Uri[] videos = new Uri[]{
            Uri.fromFile(new File("/sdcard/v.mp4")),
            Uri.fromFile(new File("/sdcard/vtest.mp4")),
    };

    public void goFacebook(View view) {

        ShareManager.getInstance().initPlatform(PlatformType.FACEBOOK);

        ShareManager.getInstance().setImages(images);
        ShareManager.getInstance().setVideos(videos);

        ContextCompat.startActivity(this, new Intent(this, ShareWebActivity.class), null);

    }

    public void goTwitter(View view) {

        ShareManager.getInstance().initPlatform(PlatformType.TWITTER);

        ShareManager.getInstance().setImages(images);
        ShareManager.getInstance().setVideos(videos);

        ContextCompat.startActivity(this, new Intent(this, ShareWebActivity.class), null);
    }

    public void goIns(View view) {

        ShareManager.getInstance().initPlatform(PlatformType.INSTAGRAM);

        ShareManager.getInstance().setImages(images);
        ShareManager.getInstance().setVideos(videos);

        ContextCompat.startActivity(this, new Intent(this, ShareWebActivity.class), null);
    }

    public void goYoutube(View view) {

        ShareManager.getInstance().initPlatform(PlatformType.YOUTUBE);

        ShareManager.getInstance().setImages(images);
        ShareManager.getInstance().setVideos(videos);

        ContextCompat.startActivity(this, new Intent(this, ShareWebActivity.class), null);
    }

    public void goP2P(View view) {

        ContextCompat.startActivity(this, new Intent(this, P2pActivity.class), null);
    }
}

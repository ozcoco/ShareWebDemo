package com.xdynamics.share;

import android.net.Uri;
import android.support.annotation.Nullable;

import com.xdynamics.share.platform.Facebook;
import com.xdynamics.share.platform.Instagram;
import com.xdynamics.share.platform.PlatformType;
import com.xdynamics.share.platform.SharePlatform;
import com.xdynamics.share.platform.Twitter;
import com.xdynamics.share.platform.Youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share
 * @ClassName: ShareManagerImpl
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/21 15:21
 * @UpdateUser:
 * @UpdateDate: 2020/5/21 15:21
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShareManagerImpl implements IShareManager {

    private PlatformType mPlatformType;

    private List<Uri> images;

    private List<Uri> videos;

    @Override
    public void initPlatform(PlatformType type) {
        mPlatformType = type;
    }

    @Override
    public SharePlatform platform() {

        SharePlatform platform = null;

        switch (mPlatformType) {
            case FACEBOOK:
                platform = new Facebook(mPlatformType.getIndex());
                break;
            case TWITTER:
                platform = new Twitter(mPlatformType.getIndex());
                break;
            case INSTAGRAM:
                platform = new Instagram(mPlatformType.getIndex());
                break;
            case YOUTUBE:
                platform = new Youtube(mPlatformType.getIndex());
                break;
        }

        return platform;
    }

    @Override
    public void setImages(Uri[] uris) {

        if (images == null)
            images = new ArrayList<>();

        images.addAll(Arrays.asList(uris));

    }

    @Override
    public void setVideos(Uri[] uris) {

        if (videos == null)
            videos = new ArrayList<>();

        videos.addAll(Arrays.asList(uris));
    }

    @Override
    public Uri[] getImages() {
        if (images == null) return null;

        Uri[] uris = new Uri[images.size()];

        for (int i = 0; i < uris.length; i++) {
            uris[i] = images.get(i);
        }

        return uris;
    }

    @Nullable
    @Override
    public Uri[] getVideos() {

        if (videos == null) return null;

        Uri[] uris = new Uri[videos.size()];

        for (int i = 0; i < uris.length; i++) {
            uris[i] = videos.get(i);
        }

        return uris;
    }
}

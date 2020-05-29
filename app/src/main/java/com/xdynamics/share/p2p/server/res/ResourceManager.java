package com.xdynamics.share.p2p.server.res;

import android.content.Context;

import com.xdynamics.share.p2p.server.res.bean.IResourceFile;

import java.io.InputStream;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server
 * @ClassName: ResourceManager
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/28 17:39
 * @UpdateUser:
 * @UpdateDate: 2020/5/28 17:39
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ResourceManager implements IResourceManager {

    private ResourceManager() {
    }

    @Override
    public void init(Context context) {
        Singleton.INSTANCE.init(context);
    }

    @Override
    public void reload() {
        Singleton.INSTANCE.reload();
    }

    @Override
    public void destroy() {
        Singleton.INSTANCE.destroy();
    }

    @Override
    public InputStream getImage(String filename) {
        return Singleton.INSTANCE.getImage(filename);
    }

    @Override
    public InputStream getVideo(String filename) {
        return Singleton.INSTANCE.getVideo(filename);
    }

    @Override
    public InputStream getStatic(String filename) {
        return Singleton.INSTANCE.getStatic(filename);
    }

    @Override
    public IResourceFile getImageFile(String filename) {
        return Singleton.INSTANCE.getImageFile(filename);
    }

    @Override
    public IResourceFile getVideoFile(String filename) {
        return Singleton.INSTANCE.getVideoFile(filename);
    }

    @Override
    public IResourceFile getStaticFile(String filename) {
        return Singleton.INSTANCE.getStaticFile(filename);
    }

    public static IResourceManager getInstance() {
        return Singleton.INSTANCE;
    }

    private final static class Singleton {
        private static IResourceManager INSTANCE = new ResourceManagerImpl();
    }

}

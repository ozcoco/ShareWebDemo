package com.xdynamics.share.p2p.server.res;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.xdynamics.share.base.ResourceConfig;
import com.xdynamics.share.p2p.server.res.bean.HtmlFile;
import com.xdynamics.share.p2p.server.res.bean.IResourceFile;
import com.xdynamics.share.p2p.server.res.bean.ImageFile;
import com.xdynamics.share.p2p.server.res.bean.VideoFile;
import com.xdynamics.share.p2p.utils.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server.res
 * @ClassName: ResourceManagerImpl
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/28 18:05
 * @UpdateUser:
 * @UpdateDate: 2020/5/28 18:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ResourceManagerImpl implements IResourceManager {

    public final static String RESOURCE_CONFIG = "server/resource_config.json";

    private final ArrayMap<String, IResourceFile> mImageMap = new ArrayMap<>();
    private final ArrayMap<String, IResourceFile> mVideoMap = new ArrayMap<>();
    private final ArrayMap<String, IResourceFile> mStaticMap = new ArrayMap<>();

    private AssetManager mAssets;

    private boolean isInit = false;

    @Override
    public void init(Context context) {

        mAssets = context.getAssets();

        if (!isInit) {

            load();

            isInit = true;

        }

    }

    private void load() {

        if (mAssets == null) return;

        StringBuilder buff = new StringBuilder();

        try (InputStream open = mAssets.open(RESOURCE_CONFIG)) {

            int ch;

            for (; (ch = open.read()) != -1; ) {
                buff.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResourceConfig config = new Gson().fromJson(buff.toString(), ResourceConfig.class);

        loadImage(config.getImage_dirs());
        loadVideo(config.getVideo_dirs());
        loadStatic(config.getStatic_dirs());
    }

    @Override
    public void reload() {

        load();
    }

    @Override
    public void destroy() {

        if (mAssets != null) {
            mAssets.close();
            mAssets = null;
        }

        mImageMap.clear();
        mVideoMap.clear();
        mStaticMap.clear();

    }

    private void loadImage(String[] dirs) {

        final List<File> list = ResourceUtils.getFiles(dirs, (dir, name) -> name.endsWith(".jpg")
                || name.endsWith(".jpeg")
                || name.endsWith(".svg")
                || name.endsWith(".png"));

        for (File file : list) {

            ImageFile res = new ImageFile();
            res.setName(file.getName());
            res.setPath(file.getAbsolutePath());
            res.setSize(file.length());

            if (file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")) {
                res.setMimeType("image/jpeg");
            } else if (file.getName().endsWith(".gif")) {
                res.setMimeType("image/gif");
            } else if (file.getName().endsWith(".png")) {
                res.setMimeType("image/png");
            } else if (file.getName().endsWith(".svg")) {
                res.setMimeType("image/svg+xml");
            }

            mImageMap.put(file.getName(), res);
        }

        Logger.d("-------loadImage------> %s", mImageMap.toString());

    }

    private void loadVideo(String[] dirs) {

        final List<File> list = ResourceUtils.getFiles(dirs, (dir, name) -> name.endsWith(".mp4")
                || name.endsWith(".ogv")
                || name.endsWith(".flv")
                || name.endsWith(".ts")
                || name.endsWith(".mkv")
                || name.endsWith(".mov"));

        for (File file : list) {

            VideoFile res = new VideoFile();
            res.setName(file.getName());
            res.setPath(file.getAbsolutePath());
            res.setSize(file.length());

            if (file.getName().endsWith(".mp4")) {
                res.setMimeType("video/mp4");
            } else if (file.getName().endsWith(".ogv")) {
                res.setMimeType("video/ogg");
            } else if (file.getName().endsWith(".flv")) {
                res.setMimeType("video/x-flv");
            } else if (file.getName().endsWith(".mov")) {
                res.setMimeType("video/quicktime");
            } else if (file.getName().endsWith(".ts")) {
                res.setMimeType("video/mp2t");
            } else if (file.getName().endsWith(".mkv")) {
                res.setMimeType("video/mkv");
            }

            mVideoMap.put(file.getName(), res);
        }

        Logger.d("-------loadVideo------> %s", mVideoMap.toString());

    }

    private void loadStatic(String[] assetDirs) {

        Logger.d("-------loadStatic------> assetDirs: %s", Arrays.toString(assetDirs));

        for (String dir : assetDirs) {

            List<String> list = ResourceUtils.getAssetFiles(mAssets, dir);

            Logger.d("-------loadStatic------> list: %s", list.toString());

            for (String filename : list) {

                HtmlFile res = new HtmlFile();
                res.setName(filename);
                res.setPath(dir + "/" + filename);

                if (filename.endsWith(".css")) {
                    res.setMimeType("text/css");
                } else if (filename.endsWith(".htm")
                        || filename.endsWith(".html")) {
                    res.setMimeType("text/html");
                } else if (filename.endsWith(".xml")) {
                    res.setMimeType("text/xml");
                } else if (filename.endsWith(".java")) {
                    res.setMimeType("ttext/x-java-source, text/java");
                } else if (filename.endsWith(".md")
                        || filename.endsWith(".txt")
                        || filename.endsWith(".asc")) {
                    res.setMimeType("text/plain");
                } else if (filename.endsWith(".ico")) {
                    res.setMimeType("image/ico");
                }

                mStaticMap.put(filename, res);
            }
        }


        Logger.d("-------loadStatic------> %s", mStaticMap.toString());
    }

    @Override
    public InputStream getImage(String filename) {

        IResourceFile res = mImageMap.get(filename);

        if (res == null) return null;

        return toStream(res.getPath());
    }


    @Override
    public InputStream getVideo(String filename) {

        IResourceFile res = mVideoMap.get(filename);

        if (res == null) return null;

        return toStream(res.getPath());
    }

    @Override
    public InputStream getStatic(String filename) {

        IResourceFile res = mStaticMap.get(filename);

        if (res == null) return null;

        return toAssetStream(res.getPath());
    }

    @Override
    public IResourceFile getImageFile(String filename) {
        return mImageMap.get(filename);
    }

    @Override
    public IResourceFile getVideoFile(String filename) {
        return mVideoMap.get(filename);
    }

    @Override
    public IResourceFile getStaticFile(String filename) {
        return mStaticMap.get(filename);
    }


    private InputStream toAssetStream(@NonNull String path) {

        InputStream is = null;

        try {
            is = mAssets.open(path);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return is;

    }


    private InputStream toStream(@NonNull String path) {

        InputStream is = null;

        try {
            is = new FileInputStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return is;

    }

}

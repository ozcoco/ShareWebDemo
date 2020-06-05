package com.xdynamics.share.p2p.server.res;

import android.content.Context;

import com.xdynamics.share.p2p.server.res.bean.IResourceFile;
import com.xdynamics.share.p2p.server.res.bean.ImageFile;
import com.xdynamics.share.p2p.server.res.bean.VideoFile;

import java.io.InputStream;
import java.util.List;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server.res
 * @ClassName: IResourceManager
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/28 17:41
 * @UpdateUser:
 * @UpdateDate: 2020/5/28 17:41
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IResourceManager {

    public void init(Context context);

    public void reload();

    public void destroy();

    public InputStream getImage(String filename);

    public InputStream getVideo(String filename);

    public InputStream getStatic(String filename);

    public IResourceFile getImageFile(String filename);

    public IResourceFile getVideoFile(String filename);

    public IResourceFile getStaticFile(String filename);

    List<ImageFile> getImageAll();

    List<VideoFile> getVideoAll();

    List<ImageFile> getImageAll(int size, int index);

    List<VideoFile> getVideoAll(int size, int index);

}

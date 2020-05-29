package com.xdynamics.share.p2p.server.res.bean;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server.res.bean
 * @ClassName: ImageFile
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/28 18:29
 * @UpdateUser:
 * @UpdateDate: 2020/5/28 18:29
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ImageFile implements IResourceFile {

    public final static String MINE_TYPE = "image/";
    private String name;
    private String path;
    private long size;
    private String mimeType;

    public ImageFile() {
    }

    public ImageFile(String name, String path, long size, String mimeType) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.mimeType = mimeType;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        return "ImageFile{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }
}

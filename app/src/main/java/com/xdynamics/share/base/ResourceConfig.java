package com.xdynamics.share.base;

import java.io.Serializable;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.base
 * @ClassName: ResourceConfig
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/28 18:55
 * @UpdateUser:
 * @UpdateDate: 2020/5/28 18:55
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ResourceConfig implements Serializable {

    private String[] image_dirs;
    private String[] video_dirs;
    private String[] static_dirs;

    public String[] getImage_dirs() {
        return image_dirs;
    }

    public void setImage_dirs(String[] image_dirs) {
        this.image_dirs = image_dirs;
    }

    public String[] getVideo_dirs() {
        return video_dirs;
    }

    public void setVideo_dirs(String[] video_dirs) {
        this.video_dirs = video_dirs;
    }

    public String[] getStatic_dirs() {
        return static_dirs;
    }

    public void setStatic_dirs(String[] static_dirs) {
        this.static_dirs = static_dirs;
    }
}

package com.xdynamics.share.p2p.server.res.bean;

import java.io.Serializable;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server.res
 * @ClassName: IResourceFile
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/28 18:25
 * @UpdateUser:
 * @UpdateDate: 2020/5/28 18:25
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IResourceFile extends Serializable {

    public String getName();

    public String getPath();

    public long getSize();

    public String getMimeType();

    public String toString();

}

package com.xdynamics.share.p2p.server.service;

import com.xdynamics.share.p2p.server.res.bean.ImageFile;
import com.xdynamics.share.p2p.server.res.bean.VideoFile;

import java.util.List;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server.service
 * @ClassName: IStationService
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/6/4 11:22
 * @UpdateUser:
 * @UpdateDate: 2020/6/4 11:22
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IStationService {

    List<ImageFile> imageList(int size, int page);

    List<VideoFile> videoList(int size, int page);

}

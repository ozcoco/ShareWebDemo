package com.xdynamics.share.p2p.server.service;

import com.xdynamics.share.p2p.server.annotation.GET;
import com.xdynamics.share.p2p.server.res.ResourceManager;
import com.xdynamics.share.p2p.server.res.bean.ImageFile;
import com.xdynamics.share.p2p.server.res.bean.VideoFile;

import java.util.List;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server.service
 * @ClassName: StationService
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/6/4 11:21
 * @UpdateUser:
 * @UpdateDate: 2020/6/4 11:21
 * @UpdateRemark:
 * @Version: 1.0
 */
public class StationService implements IStationService {

    private final IStationService stationService;

    public StationService() {
        stationService = new StationServiceImpl(ResourceManager.getInstance());
    }

    @GET("/api/image/list")
    @Override
    public List<ImageFile> imageList(int size, int page) {
        return stationService.imageList(size, page);
    }

    @GET("/api/video/list")
    @Override
    public List<VideoFile> videoList(int size, int page) {
        return stationService.videoList(size, page);
    }

    @GET("/api/ok")
    @Override
    public int ok() {
        return stationService.ok();
    }

}

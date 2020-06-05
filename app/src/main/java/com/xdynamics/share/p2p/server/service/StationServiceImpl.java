package com.xdynamics.share.p2p.server.service;

import com.xdynamics.share.p2p.server.res.IResourceManager;
import com.xdynamics.share.p2p.server.res.bean.ImageFile;
import com.xdynamics.share.p2p.server.res.bean.VideoFile;

import java.util.List;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server.service
 * @ClassName: StationServiceImpl
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/6/4 11:23
 * @UpdateUser:
 * @UpdateDate: 2020/6/4 11:23
 * @UpdateRemark:
 * @Version: 1.0
 */
class StationServiceImpl implements IStationService {

    private final IResourceManager mResource;

    public StationServiceImpl(IResourceManager resource) {
        mResource = resource;
    }


    @Override
    public List<ImageFile> imageList(int size, int page) {

        return mResource.getImageAll(size, size * page);
    }


    @Override
    public List<VideoFile> videoList(int size, int page) {


        return mResource.getVideoAll(size, size * page);
    }
}

package com.xdynamics.share.p2p.server.api;

import com.orhanobut.logger.Logger;
import com.xdynamics.share.p2p.server.res.bean.Message;
import com.xdynamics.share.p2p.server.service.IStationService;
import com.xdynamics.share.p2p.server.service.StationService;
import com.xdynamics.share.p2p.utils.GsonUtils;

import fi.iki.elonen.NanoHTTPD;

/**
 * @ProjectName: XShare
 * @Package: com.xd.share.net.parser
 * @ClassName: ApiParser
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/6/4 11:34
 * @UpdateUser:
 * @UpdateDate: 2020/6/4 11:34
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ApiGallery {

    private final IStationService mStationService;

    public ApiGallery(StationService service) {

        mStationService = service;

    }

    public NanoHTTPD.Response api(NanoHTTPD.IHTTPSession session) {

        switch (session.getMethod()) {
            case GET:
                return get(session);

            case POST:
                return post(session);
        }

        return NanoHTTPD.newFixedLengthResponse(
                NanoHTTPD.Response.Status.NOT_FOUND,
                "application/json;charset=utf-8",
                GsonUtils.toJson(Message.NO()));

    }

    private NanoHTTPD.Response get(NanoHTTPD.IHTTPSession session) {

        if (session.getUri().matches("/api/image/list")) {

            String strSize = session.getHeaders().get("size");
            String strPage = session.getHeaders().get("page");

            int size = strSize == null ? 20 : Integer.parseInt(strSize);
            int page = strPage == null ? 0 : Integer.parseInt(strPage);

            Logger.d("------> size : %d \n page : %d", size, page);

            return NanoHTTPD.newFixedLengthResponse(
                    NanoHTTPD.Response.Status.OK,
                    "application/json;charset=utf-8",
                    GsonUtils.toJson(Message.OK(mStationService.imageList(size, page))));

        } else if (session.getUri().matches("/api/video/list")) {


            String strSize = session.getHeaders().get("size");
            String strPage = session.getHeaders().get("page");

            int size = strSize == null ? 20 : Integer.parseInt(strSize);
            int page = strPage == null ? 0 : Integer.parseInt(strPage);

            Logger.d("-------> size : %d \n page : %d", size, page);

            return NanoHTTPD.newFixedLengthResponse(
                    NanoHTTPD.Response.Status.OK,
                    "application/json;charset=utf-8",
                    GsonUtils.toJson(Message.OK(mStationService.videoList(size, page))));

        }

        return NanoHTTPD.newFixedLengthResponse(
                NanoHTTPD.Response.Status.OK,
                "application/json;charset=utf-8",
                GsonUtils.toJson(Message.NO()));
    }

    private NanoHTTPD.Response post(NanoHTTPD.IHTTPSession session) {

        if (session.getUri().matches("/api/image/list")) {


        } else if (session.getUri().matches("/api/video/list")) {


        }

        return NanoHTTPD.newFixedLengthResponse(
                NanoHTTPD.Response.Status.NOT_FOUND,
                "application/json;charset=utf-8",
                GsonUtils.toJson(Message.NO()));
    }

}

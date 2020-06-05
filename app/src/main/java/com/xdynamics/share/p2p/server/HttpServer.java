package com.xdynamics.share.p2p.server;

import android.text.TextUtils;

import com.orhanobut.logger.Logger;
import com.xdynamics.share.p2p.server.api.ApiGallery;
import com.xdynamics.share.p2p.server.res.IResourceManager;
import com.xdynamics.share.p2p.server.res.ResourceManager;
import com.xdynamics.share.p2p.server.service.StationService;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server
 * @ClassName: HttpServer
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/25 14:12
 * @UpdateUser:
 * @UpdateDate: 2020/5/25 14:12
 * @UpdateRemark:
 * @Version: 1.0
 */
public class HttpServer extends BaseServer {

    private final IResourceManager mResource = ResourceManager.getInstance();

    private ApiGallery mApi;

    public HttpServer(int port) {
        super(port);
    }

    public HttpServer(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    public Response serve(IHTTPSession session) {

        String uri = session.getUri();

        Logger.d("---------> URI :  %s ", uri);

        if (TextUtils.isEmpty(session.getUri())
                || TextUtils.equals(session.getUri(), "/")
                || TextUtils.equals(session.getUri(), "/index.html")
                || TextUtils.equals(session.getUri(), "/index.htm")
                || TextUtils.equals(session.getUri(), "/index")) {

            return welcome();

        } else if (uri.startsWith("/img/")) {

            return img(uri.replaceFirst("/img/", ""));

        } else if (uri.startsWith("/video/")) {

            return video(uri.replaceFirst("/video/", ""));

        } else if (uri.startsWith("/api/")) {

            if (mApi == null) mApi = new ApiGallery(new StationService());

            return mApi.api(session);

        } else {

            String[] split = uri.split("/");

            if (split.length > 0)
                return other(split[split.length - 1]);

        }

        return super.serve(session);

    }


    private Response welcome() {

        final String uri = "index.html";

        try {

            InputStream is = mResource.getStatic(uri);

            return newFixedLengthResponse(Response.Status.OK,
                    mResource.getStaticFile(uri).getMimeType(),
                    is,
                    is.available()
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newFixedLengthResponse("Not Found!");
    }

    private Response img(String uri) {

        return newChunkedResponse(Response.Status.OK,
                mResource.getImageFile(uri).getMimeType(),
                mResource.getImage(uri));

    }

    private Response video(String uri) {

        return newChunkedResponse(Response.Status.OK,
                mResource.getVideoFile(uri).getMimeType(),
                mResource.getVideo(uri));
    }

    private Response other(String uri) {

        try {

            InputStream is = mResource.getStatic(uri);

            return newFixedLengthResponse(Response.Status.OK,
                    mResource.getStaticFile(uri).getMimeType(),
                    is,
                    is.available()
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newFixedLengthResponse("Not Found!");
    }

}

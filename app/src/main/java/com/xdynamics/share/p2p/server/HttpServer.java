package com.xdynamics.share.p2p.server;

import android.text.TextUtils;

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
    public HttpServer(int port) {
        super(port);
    }

    public HttpServer(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    public Response serve(IHTTPSession session) {

        if (TextUtils.isEmpty(session.getUri())
                || TextUtils.equals(session.getUri(), "/")
                || TextUtils.equals(session.getUri(), "/index.html")
                || TextUtils.equals(session.getUri(), "/index.htm")
                || TextUtils.equals(session.getUri(), "/index")) {
            return home(session);
        }

        return super.serve(session);
    }


    private Response home(IHTTPSession session) {

        return newFixedLengthResponse("<!DOCTYPE html>" +
                "<html>" +
                "<head>Share</head>" +
                "<body>" +
                "Hello, Share server" +
                "</body>" +
                "</html>");
    }

}

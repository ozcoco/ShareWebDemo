package com.xdynamics.share.p2p.server.res.bean;

/**
 * @ProjectName: XShare
 * @Package: com.xd.share.po
 * @ClassName: Message
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/6/1 18:08
 * @UpdateUser:
 * @UpdateDate: 2020/6/1 18:08
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Message2 {

    private int code;

    private String msg;

    private String data;

    public Message2() {
    }

    public Message2(int code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static Message2 OK(String data) {

        return new Message2(0, "ok", data);
    }

    public static Message2 NO() {

        return new Message2(1, "no", null);
    }


}

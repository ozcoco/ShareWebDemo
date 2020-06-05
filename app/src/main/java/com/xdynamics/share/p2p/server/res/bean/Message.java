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
public class Message<T> {

    private int code;

    private String msg;

    private T data;

    public Message() {
    }

    public Message(int code, String msg, T data) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Message<T> OK(T data) {

        return new Message<>(0, "ok", data);
    }

    public static Message<Object> NO() {

        return new Message<>(1, "no", null);
    }


}

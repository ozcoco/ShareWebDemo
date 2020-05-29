package com.xdynamics.share.p2p.utils;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.utils
 * @ClassName: IOUtils
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/29 16:53
 * @UpdateUser:
 * @UpdateDate: 2020/5/29 16:53
 * @UpdateRemark:
 * @Version: 1.0
 */
public class IOUtils {

    public static String toString(@NonNull InputStream is) throws IOException {

        StringBuilder buff = new StringBuilder();

        int ch;

        for (; (ch = is.read()) != -1; ) {

            buff.append((char) ch);

        }

        return buff.toString();
    }

    public byte[] toByteArray(@NonNull InputStream is) throws IOException {

        return toString().getBytes();
    }

}

package com.xdynamics.share.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.utils
 * @ClassName: NetworkUtils
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/25 16:33
 * @UpdateUser:
 * @UpdateDate: 2020/5/25 16:33
 * @UpdateRemark:
 * @Version: 1.0
 */
public class NetworkUtils {

    public static String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> enNetI = NetworkInterface.getNetworkInterfaces(); enNetI
                    .hasMoreElements(); ) {
                NetworkInterface netI = enNetI.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = netI.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }

}

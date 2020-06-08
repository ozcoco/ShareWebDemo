// IRemoteServerManager.aidl
package com.xdynamics.share.p2p.aidl;

// Declare any non-default types here with import statements

interface IRemoteServerManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);

    void startHttpServer();

    void stopHttpServer();

    boolean isAlive();

    String getHostname();

    int getPort();

}

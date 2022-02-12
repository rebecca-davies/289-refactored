package com.runescape.collection;

public class CacheableNode extends Node {

    public static boolean aBoolean1362;
    public boolean aBoolean1359;
    public CacheableNode aClass44_Sub3_1360;
    public CacheableNode aClass44_Sub3_1361;

    public CacheableNode() {
        aBoolean1359 = false;
    }

    public void method405() {
        if (aClass44_Sub3_1361 == null) {
            return;
        } else {
            aClass44_Sub3_1361.aClass44_Sub3_1360 = aClass44_Sub3_1360;
            aClass44_Sub3_1360.aClass44_Sub3_1361 = aClass44_Sub3_1361;
            aClass44_Sub3_1360 = null;
            aClass44_Sub3_1361 = null;
            return;
        }
    }
}

package com.runescape.collection;

import com.runescape.util.SignLink;

public class Cache {

    public boolean aBoolean688;
    public boolean aBoolean689;
    public int anInt690;
    public int anInt691;
    public CacheableNode aClass44_Sub3_692;
    public int anInt693;
    public int anInt694;
    public HashTable aClass42_695;
    public Queue aClass31_696;

    public Cache(byte byte0, int i) {
        aBoolean688 = true;
        aBoolean689 = false;
        aClass44_Sub3_692 = new CacheableNode();
        aClass31_696 = new Queue(9);
        try {
            if (byte0 == 7) {
                byte0 = 0;
            } else {
                aBoolean688 = !aBoolean688;
            }
            anInt693 = i;
            anInt694 = i;
            aClass42_695 = new HashTable(1024, (byte) 124);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("86782, " + byte0 + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public CacheableNode method339(long l) {
        CacheableNode class44_sub3 = (CacheableNode) aClass42_695.method380(l);
        if (class44_sub3 != null) {
            aClass31_696.method264(class44_sub3);
            anInt691++;
        } else {
            anInt690++;
        }
        return class44_sub3;
    }

    public void method340(long l, byte byte0, CacheableNode class44_sub3) {
        try {
            if (byte0 != 76) {
                return;
            }
            if (anInt694 == 0) {
                CacheableNode class44_sub3_1 = aClass31_696.method265();
                class44_sub3_1.remove();
                class44_sub3_1.method405();
                if (class44_sub3_1 == aClass44_Sub3_692) {
                    CacheableNode class44_sub3_2 = aClass31_696.method265();
                    class44_sub3_2.remove();
                    class44_sub3_2.method405();
                }
            } else {
                anInt694--;
            }
            aClass42_695.method381(false, class44_sub3, l);
            aClass31_696.method264(class44_sub3);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("63377, " + l + ", " + byte0 + ", " + class44_sub3 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method341() {
        do {
            CacheableNode class44_sub3 = aClass31_696.method265();
            if (class44_sub3 != null) {
                class44_sub3.remove();
                class44_sub3.method405();
            } else {
                anInt694 = anInt693;
                return;
            }
        } while (true);
    }
}

package com.runescape.scene;

import com.runescape.type.FloType;
import com.runescape.type.LocType;
import com.runescape.cache.request.OnDemandRequester;
import com.runescape.graphic.Model;
import com.runescape.graphic.Draw3D;
import com.runescape.net.Buffer;
import com.runescape.renderable.GameObject;
import com.runescape.renderable.Renderable;
import com.runescape.util.SignLink;

public class regionCached {

    public static int anInt61 = 30967;
    public static boolean aBoolean64 = true;
    public static int plane;
    public static int[] anIntArray82 = {1, 2, 4, 8};
    public static int[] anIntArray83 = {16, 32, 64, 128};
    public static int[] anIntArray84 = {1, 0, -1, 0};
    public static int[] anIntArray85 = {0, -1, 0, 1};
    public static int anInt86 = (int) (Math.random() * 17D) - 8;
    public static int anInt87 = (int) (Math.random() * 33D) - 16;
    public int anInt60;
    public boolean aBoolean62;
    public boolean aBoolean63;
    public int anInt66;
    public int anInt67;
    public int[][][] anIntArrayArrayArray68;
    public byte[][][] aByteArrayArrayArray69;
    public byte[][][] aByteArrayArrayArray70;
    public byte[][][] aByteArrayArrayArray71;
    public byte[][][] aByteArrayArrayArray72;
    public byte[][][] aByteArrayArrayArray73;
    public byte[][][] aByteArrayArrayArray74;
    public int[][] anIntArrayArray75;
    public int[] anIntArray76;
    public int[] anIntArray77;
    public int[] anIntArray78;
    public int[] anIntArray79;
    public int[] anIntArray80;
    public int[][][] anIntArrayArrayArray81;

    public regionCached(int[][][] ai, int i, byte byte0, byte[][][] abyte0, int j) {
        anInt60 = 101;
        aBoolean62 = false;
        aBoolean63 = true;
        try {
            anInt66 = j;
            anInt67 = i;
            anIntArrayArrayArray68 = ai;
            aByteArrayArrayArray69 = abyte0;
            aByteArrayArrayArray70 = new byte[4][anInt66][anInt67];
            aByteArrayArrayArray71 = new byte[4][anInt66][anInt67];
            aByteArrayArrayArray72 = new byte[4][anInt66][anInt67];
            aByteArrayArrayArray73 = new byte[4][anInt66][anInt67];
            anIntArrayArrayArray81 = new int[4][anInt66 + 1][anInt67 + 1];
            aByteArrayArrayArray74 = new byte[4][anInt66 + 1][anInt67 + 1];
            anIntArrayArray75 = new int[anInt66 + 1][anInt67 + 1];
            anIntArray76 = new int[anInt67];
            anIntArray77 = new int[anInt67];
            anIntArray78 = new int[anInt67];
            anIntArray79 = new int[anInt67];
            anIntArray80 = new int[anInt67];
            if (byte0 != 9) {
                aBoolean62 = !aBoolean62;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("68666, " + ai + ", " + i + ", " + byte0 + ", " + abyte0 + ", " + j + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public static boolean method159(int i, int j, int k, byte[] abyte0) {
        try {
            boolean flag = true;
            Buffer class44_sub3_sub2 = new Buffer(abyte0);
            int l = -1;
            if (i <= 0) {
                throw new NullPointerException();
            }
            while (true) {
                int i1 = class44_sub3_sub2.method496();
                if (i1 == 0) {
                    break;
                }
                l += i1;
                int j1 = 0;
                boolean flag1 = false;
                while (true) {
                    if (flag1) {
                        int k1 = class44_sub3_sub2.method496();
                        if (k1 == 0) {
                            break;
                        }
                        class44_sub3_sub2.readUnsignedByte();
                    } else {
                        int l1 = class44_sub3_sub2.method496();
                        if (l1 == 0) {
                            break;
                        }
                        j1 += l1 - 1;
                        int i2 = j1 & 0x3f;
                        int j2 = j1 >> 6 & 0x3f;
                        int k2 = class44_sub3_sub2.readUnsignedByte() >> 2;
                        int l2 = j2 + k;
                        int i3 = i2 + j;
                        if (l2 > 0 && i3 > 0 && l2 < 103 && i3 < 103) {
                            LocType class8 = LocType.method199(l);
                            if (k2 != 22 || !regionCached.aBoolean64 || class8.aBoolean226 || class8.aBoolean246) {
                                flag &= class8.method203(-593);
                                flag1 = true;
                            }
                        }
                    }
                }
            }
            return flag;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("52153, " + i + ", " + j + ", " + k + ", " + abyte0 + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public static void method160(OnDemandRequester class43_sub1, Buffer class44_sub3_sub2, int i) {
        try {
            int j;
            for (j = -1; i >= 0; ) {
                return;
            }
            do {
                int k = class44_sub3_sub2.method496();
                if (k == 0) {
                    break;
                }
                j += k;
                LocType class8 = LocType.method199(j);
                class8.method204(class43_sub1, (byte) 2);
                do {
                    int l = class44_sub3_sub2.method496();
                    if (l == 0) {
                        break;
                    }
                    class44_sub3_sub2.readUnsignedByte();
                } while (true);
            } while (true);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("6914, " + class43_sub1 + ", " + class44_sub3_sub2 + ", " + i + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public static int method165(int i, int j) {
        int k = (regionCached.method166(i + 45365, j + 0x16713, 4) - 128)
                + (regionCached.method166(i + 10294, j + 37821, 2) - 128 >> 1) + (regionCached.method166(i, j, 1) - 128 >> 2);
        k = (int) (k * 0.29999999999999999D) + 35;
        if (k < 10) {
            k = 10;
        } else if (k > 60) {
            k = 60;
        }
        return k;
    }

    public static int method166(int i, int j, int k) {
        int l = i / k;
        int i1 = i & k - 1;
        int j1 = j / k;
        int k1 = j & k - 1;
        int l1 = regionCached.method168(l, j1);
        int i2 = regionCached.method168(l + 1, j1);
        int j2 = regionCached.method168(l, j1 + 1);
        int k2 = regionCached.method168(l + 1, j1 + 1);
        int l2 = regionCached.method167(l1, i2, i1, k);
        int i3 = regionCached.method167(j2, k2, i1, k);
        return regionCached.method167(l2, i3, k1, k);
    }

    public static int method167(int i, int j, int k, int l) {
        int i1 = 0x10000 - Draw3D.cos[(k * 1024) / l] >> 1;
        return (i * (0x10000 - i1) >> 16) + (j * i1 >> 16);
    }

    public static int method168(int i, int j) {
        int k = regionCached.method169(i - 1, j - 1) + regionCached.method169(i + 1, j - 1) + regionCached.method169(i - 1, j + 1)
                + regionCached.method169(i + 1, j + 1);
        int l = regionCached.method169(i - 1, j) + regionCached.method169(i + 1, j) + regionCached.method169(i, j - 1)
                + regionCached.method169(i, j + 1);
        int i1 = regionCached.method169(i, j);
        return k / 16 + l / 8 + i1 / 4;
    }

    public static int method169(int i, int j) {
        int k = i + j * 57;
        k = k << 13 ^ k;
        int l = k * (k * k * 15731 + 0xc0ae5) + 0x5208dd0d & 0x7fffffff;
        return l >> 19 & 0xff;
    }

    public static int method170(int i, int j) {
        if (i == -1) {
            return 0xbc614e;
        }
        j = (j * (i & 0x7f)) / 128;
        if (j < 2) {
            j = 2;
        } else if (j > 126) {
            j = 126;
        }
        return (i & 0xff80) + j;
    }

    public static boolean method173(int i, int j, int k) {
        try {
            if (k <= 0) {
                for (int l = 1; l > 0; l++) {
                }
            }
            LocType class8 = LocType.method199(i);
            if (j == 11) {
                j = 10;
            }
            if (j >= 5 && j <= 8) {
                j = 4;
            }
            return class8.method202(j, 658);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("35395, " + i + ", " + j + ", " + k + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void method174(int i, int j, int k, int l, int[][][] ai, int i1, int j1, CollisionMap class18,
                                 Scene class36, int k1, int l1) {
        try {
            if (l1 != 0) {
                for (int i2 = 1; i2 > 0; i2++) {
                }
            }
            int j2 = ai[i1][j1][k];
            int k2 = ai[i1][j1 + 1][k];
            int l2 = ai[i1][j1 + 1][k + 1];
            int i3 = ai[i1][j1][k + 1];
            int j3 = j2 + k2 + l2 + i3 >> 2;
            LocType class8 = LocType.method199(k1);
            int k3 = j1 + (k << 7) + (k1 << 14) + 0x40000000;
            if (!class8.aBoolean226) {
                k3 += 0x80000000;
            }
            byte byte0 = (byte) ((i << 6) + l);
            if (l == 22) {
                Object obj;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj = class8.method205(22, i, j2, k2, l2, i3, -1);
                } else {
                    obj = new GameObject(i, k1, 22, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method284(byte0, k3, j, k, true, j3, ((Renderable) (obj)), j1);
                if (class8.aBoolean224 && class8.aBoolean226) {
                    class18.method234(j1, (byte) 0, k);
                }
                return;
            }
            if (l == 10 || l == 11) {
                Object obj1;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj1 = class8.method205(10, i, j2, k2, l2, i3, -1);
                } else {
                    obj1 = new GameObject(i, k1, 10, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                if (obj1 != null) {
                    int l5 = 0;
                    if (l == 11) {
                        l5 += 256;
                    }
                    int i5;
                    int k5;
                    if (i == 1 || i == 3) {
                        i5 = class8.anInt223;
                        k5 = class8.anInt222;
                    } else {
                        i5 = class8.anInt222;
                        k5 = class8.anInt223;
                    }
                    class36.method288(0, k, j1, j3, byte0, k3, l5, i5, j, ((Renderable) (obj1)), k5);
                }
                if (class8.aBoolean224) {
                    class18.method233(k, class8.anInt222, class8.aBoolean225, -24520, j1, class8.anInt223, i);
                }
                return;
            }
            if (l >= 12) {
                Object obj2;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj2 = class8.method205(l, i, j2, k2, l2, i3, -1);
                } else {
                    obj2 = new GameObject(i, k1, l, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method288(0, k, j1, j3, byte0, k3, 0, 1, j, ((Renderable) (obj2)), 1);
                if (class8.aBoolean224) {
                    class18.method233(k, class8.anInt222, class8.aBoolean225, -24520, j1, class8.anInt223, i);
                }
                return;
            }
            if (l == 0) {
                Object obj3;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj3 = class8.method205(0, i, j2, k2, l2, i3, -1);
                } else {
                    obj3 = new GameObject(i, k1, 0, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method286(byte0, regionCached.anIntArray82[i], j3, k3, j1, ((Renderable) (obj3)), -927, 0, null, j, k);
                if (class8.aBoolean224) {
                    class18.method232(true, i, class8.aBoolean225, l, j1, k);
                }
                return;
            }
            if (l == 1) {
                Object obj4;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj4 = class8.method205(1, i, j2, k2, l2, i3, -1);
                } else {
                    obj4 = new GameObject(i, k1, 1, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method286(byte0, regionCached.anIntArray83[i], j3, k3, j1, ((Renderable) (obj4)), -927, 0, null, j, k);
                if (class8.aBoolean224) {
                    class18.method232(true, i, class8.aBoolean225, l, j1, k);
                }
                return;
            }
            if (l == 2) {
                int l3 = i + 1 & 3;
                Object obj11;
                Object obj12;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj11 = class8.method205(2, 4 + i, j2, k2, l2, i3, -1);
                    obj12 = class8.method205(2, l3, j2, k2, l2, i3, -1);
                } else {
                    obj11 = new GameObject(4 + i, k1, 2, i3, l2, false, j2, class8.anInt230, true, k2);
                    obj12 = new GameObject(l3, k1, 2, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method286(byte0, regionCached.anIntArray82[i], j3, k3, j1, ((Renderable) (obj11)), -927,
                        regionCached.anIntArray82[l3], ((Renderable) (obj12)), j, k);
                if (class8.aBoolean224) {
                    class18.method232(true, i, class8.aBoolean225, l, j1, k);
                }
                return;
            }
            if (l == 3) {
                Object obj5;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj5 = class8.method205(3, i, j2, k2, l2, i3, -1);
                } else {
                    obj5 = new GameObject(i, k1, 3, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method286(byte0, regionCached.anIntArray83[i], j3, k3, j1, ((Renderable) (obj5)), -927, 0, null, j, k);
                if (class8.aBoolean224) {
                    class18.method232(true, i, class8.aBoolean225, l, j1, k);
                }
                return;
            }
            if (l == 9) {
                Object obj6;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj6 = class8.method205(l, i, j2, k2, l2, i3, -1);
                } else {
                    obj6 = new GameObject(i, k1, l, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method288(0, k, j1, j3, byte0, k3, 0, 1, j, ((Renderable) (obj6)), 1);
                if (class8.aBoolean224) {
                    class18.method233(k, class8.anInt222, class8.aBoolean225, -24520, j1, class8.anInt223, i);
                }
                return;
            }
            if (class8.aBoolean227) {
                if (i == 1) {
                    int i4 = i3;
                    i3 = l2;
                    l2 = k2;
                    k2 = j2;
                    j2 = i4;
                } else if (i == 2) {
                    int j4 = i3;
                    i3 = k2;
                    k2 = j4;
                    j4 = l2;
                    l2 = j2;
                    j2 = j4;
                } else if (i == 3) {
                    int k4 = i3;
                    i3 = j2;
                    j2 = k2;
                    k2 = l2;
                    l2 = k4;
                }
            }
            if (l == 4) {
                Object obj7;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj7 = class8.method205(4, 0, j2, k2, l2, i3, -1);
                } else {
                    obj7 = new GameObject(0, k1, 4, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method287(k, j, j3, ((Renderable) (obj7)), byte0, regionCached.anIntArray82[i], i * 512, k3, 0,
                        regionCached.anInt61, j1, 0);
                return;
            }
            if (l == 5) {
                int l4 = 16;
                int j5 = class36.method304(j, j1, k);
                if (j5 > 0) {
                    l4 = LocType.method199(j5 >> 14 & 0x7fff).anInt231;
                }
                Object obj13;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj13 = class8.method205(4, 0, j2, k2, l2, i3, -1);
                } else {
                    obj13 = new GameObject(0, k1, 4, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method287(k, j, j3, ((Renderable) (obj13)), byte0, regionCached.anIntArray82[i], i * 512, k3,
                        regionCached.anIntArray84[i] * l4, regionCached.anInt61, j1, regionCached.anIntArray85[i] * l4);
                return;
            }
            if (l == 6) {
                Object obj8;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj8 = class8.method205(4, 0, j2, k2, l2, i3, -1);
                } else {
                    obj8 = new GameObject(0, k1, 4, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method287(k, j, j3, ((Renderable) (obj8)), byte0, 256, i, k3, 0, regionCached.anInt61, j1, 0);
                return;
            }
            if (l == 7) {
                Object obj9;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj9 = class8.method205(4, 0, j2, k2, l2, i3, -1);
                } else {
                    obj9 = new GameObject(0, k1, 4, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method287(k, j, j3, ((Renderable) (obj9)), byte0, 512, i, k3, 0, regionCached.anInt61, j1, 0);
                return;
            }
            if (l == 8) {
                Object obj10;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj10 = class8.method205(4, 0, j2, k2, l2, i3, -1);
                } else {
                    obj10 = new GameObject(0, k1, 4, i3, l2, false, j2, class8.anInt230, true, k2);
                }
                class36.method287(k, j, j3, ((Renderable) (obj10)), byte0, 768, i, k3, 0, regionCached.anInt61, j1, 0);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("39236, " + i + ", " + j + ", " + k + ", " + l + ", " + ai + ", " + i1 + ", " + j1
                    + ", " + class18 + ", " + class36 + ", " + k1 + ", " + l1 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method157(int i, int j, int k, boolean flag, int l) {
        try {
            for (int i1 = j; i1 <= j + l; i1++) {
                for (int j1 = i; j1 <= i + k; j1++) {
                    if (j1 >= 0 && j1 < anInt66 && i1 >= 0 && i1 < anInt67) {
                        aByteArrayArrayArray74[0][j1][i1] = 127;
                        if (j1 == i && j1 > 0) {
                            anIntArrayArrayArray68[0][j1][i1] = anIntArrayArrayArray68[0][j1 - 1][i1];
                        }
                        if (j1 == i + k && j1 < anInt66 - 1) {
                            anIntArrayArrayArray68[0][j1][i1] = anIntArrayArrayArray68[0][j1 + 1][i1];
                        }
                        if (i1 == j && i1 > 0) {
                            anIntArrayArrayArray68[0][j1][i1] = anIntArrayArrayArray68[0][j1][i1 - 1];
                        }
                        if (i1 == j + l && i1 < anInt67 - 1) {
                            anIntArrayArrayArray68[0][j1][i1] = anIntArrayArrayArray68[0][j1][i1 + 1];
                        }
                    }
                }
            }
            if (!flag) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("84774, " + i + ", " + j + ", " + k + ", " + flag + ", " + l + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method158(int i, int j, byte byte0, byte[] abyte0, int k, int l) {
        try {
            Buffer class44_sub3_sub2 = new Buffer(abyte0);
            for (int i1 = 0; i1 < 4; i1++) {
                for (int j1 = 0; j1 < 64; j1++) {
                    for (int l1 = 0; l1 < 64; l1++) {
                        int i2 = j1 + l;
                        int j2 = l1 + k;
                        if (i2 >= 0 && i2 < 104 && j2 >= 0 && j2 < 104) {
                            aByteArrayArrayArray69[i1][i2][j2] = 0;
                            do {
                                int k2 = class44_sub3_sub2.readUnsignedByte();
                                if (k2 == 0) {
                                    if (i1 == 0) {
                                        anIntArrayArrayArray68[0][i2][j2] = -regionCached.method165(0xe3b7b + i2 + j, 0x87cce
                                                + j2 + i) * 8;
                                    } else {
                                        anIntArrayArrayArray68[i1][i2][j2] = anIntArrayArrayArray68[i1 - 1][i2][j2] - 240;
                                    }
                                    break;
                                }
                                if (k2 == 1) {
                                    int i3 = class44_sub3_sub2.readUnsignedByte();
                                    if (i3 == 1) {
                                        i3 = 0;
                                    }
                                    if (i1 == 0) {
                                        anIntArrayArrayArray68[0][i2][j2] = -i3 * 8;
                                    } else {
                                        anIntArrayArrayArray68[i1][i2][j2] = anIntArrayArrayArray68[i1 - 1][i2][j2]
                                                - i3 * 8;
                                    }
                                    break;
                                }
                                if (k2 <= 49) {
                                    aByteArrayArrayArray71[i1][i2][j2] = class44_sub3_sub2.readByte();
                                    aByteArrayArrayArray72[i1][i2][j2] = (byte) ((k2 - 2) / 4);
                                    aByteArrayArrayArray73[i1][i2][j2] = (byte) (k2 - 2 & 3);
                                } else if (k2 <= 81) {
                                    aByteArrayArrayArray69[i1][i2][j2] = (byte) (k2 - 49);
                                } else {
                                    aByteArrayArrayArray70[i1][i2][j2] = (byte) (k2 - 81);
                                }
                            } while (true);
                        } else {
                            do {
                                int l2 = class44_sub3_sub2.readUnsignedByte();
                                if (l2 == 0) {
                                    break;
                                }
                                if (l2 == 1) {
                                    class44_sub3_sub2.readUnsignedByte();
                                    break;
                                }
                                if (l2 <= 49) {
                                    class44_sub3_sub2.readUnsignedByte();
                                }
                            } while (true);
                        }
                    }

                }

            }
            if (byte0 != -54) {
                for (int k1 = 1; k1 > 0; k1++) {
                }
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("95853, " + i + ", " + j + ", " + byte0 + ", " + abyte0 + ", " + k + ", " + l + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method161(int i, int j, byte[] abyte0, Scene class36, byte byte0, CollisionMap[] aclass18) {
        try {
            Buffer class44_sub3_sub2 = new Buffer(abyte0);
            int k = -1;
            if (byte0 != 4) {
                for (int l = 1; l > 0; l++) {
                }
            }
            do {
                int i1 = class44_sub3_sub2.method496();
                if (i1 == 0) {
                    break;
                }
                k += i1;
                int j1 = 0;
                do {
                    int k1 = class44_sub3_sub2.method496();
                    if (k1 == 0) {
                        break;
                    }
                    j1 += k1 - 1;
                    int l1 = j1 & 0x3f;
                    int i2 = j1 >> 6 & 0x3f;
                    int j2 = j1 >> 12;
                    int k2 = class44_sub3_sub2.readUnsignedByte();
                    int l2 = k2 >> 2;
                    int i3 = k2 & 3;
                    int j3 = i2 + j;
                    int k3 = l1 + i;
                    if (j3 > 0 && k3 > 0 && j3 < 103 && k3 < 103) {
                        int l3 = j2;
                        if ((aByteArrayArrayArray69[1][j3][k3] & 2) == 2) {
                            l3--;
                        }
                        CollisionMap class18 = null;
                        if (l3 >= 0) {
                            class18 = aclass18[l3];
                        }
                        method162(l2, j3, class36, -805, i3, j2, k3, class18, k);
                    }
                } while (true);
            } while (true);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("3868, " + i + ", " + j + ", " + abyte0 + ", " + class36 + ", " + byte0 + ", "
                    + aclass18 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method162(int i, int j, Scene class36, int k, int l, int i1, int j1, CollisionMap class18, int k1) {
        try {
            if (regionCached.aBoolean64) {
                if ((aByteArrayArrayArray69[i1][j][j1] & 0x10) != 0) {
                    return;
                }
                if (method164(j1, j, 0, i1) != regionCached.plane) {
                    return;
                }
            }
            int l1 = anIntArrayArrayArray68[i1][j][j1];
            int i2 = anIntArrayArrayArray68[i1][j + 1][j1];
            int j2 = anIntArrayArrayArray68[i1][j + 1][j1 + 1];
            int k2 = anIntArrayArrayArray68[i1][j][j1 + 1];
            if (k >= 0) {
                anInt60 = 410;
            }
            int l2 = l1 + i2 + j2 + k2 >> 2;
            LocType class8 = LocType.method199(k1);
            int i3 = j + (j1 << 7) + (k1 << 14) + 0x40000000;
            if (!class8.aBoolean226) {
                i3 += 0x80000000;
            }
            byte byte0 = (byte) ((l << 6) + i);
            if (i == 22) {
                if (regionCached.aBoolean64 && !class8.aBoolean226 && !class8.aBoolean246) {
                    return;
                }
                Object obj;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj = class8.method205(22, l, l1, i2, j2, k2, -1);
                } else {
                    obj = new GameObject(l, k1, 22, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method284(byte0, i3, i1, j1, true, l2, ((Renderable) (obj)), j);
                if (class8.aBoolean224 && class8.aBoolean226 && class18 != null) {
                    class18.method234(j, (byte) 0, j1);
                }
                return;
            }
            if (i == 10 || i == 11) {
                Object obj1;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj1 = class8.method205(10, l, l1, i2, j2, k2, -1);
                } else {
                    obj1 = new GameObject(l, k1, 10, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                if (obj1 != null) {
                    int j5 = 0;
                    if (i == 11) {
                        j5 += 256;
                    }
                    int k4;
                    int i5;
                    if (l == 1 || l == 3) {
                        k4 = class8.anInt223;
                        i5 = class8.anInt222;
                    } else {
                        k4 = class8.anInt222;
                        i5 = class8.anInt223;
                    }
                    if (class36.method288(0, j1, j, l2, byte0, i3, j5, k4, i1, ((Renderable) (obj1)), i5)
                            && class8.aBoolean238) {
                        Model class44_sub3_sub4_sub4;
                        if (obj1 instanceof Model) {
                            class44_sub3_sub4_sub4 = (Model) obj1;
                        } else {
                            class44_sub3_sub4_sub4 = class8.method205(10, l, l1, i2, j2, k2, -1);
                        }
                        if (class44_sub3_sub4_sub4 != null) {
                            for (int k5 = 0; k5 <= k4; k5++) {
                                for (int l5 = 0; l5 <= i5; l5++) {
                                    int i6 = class44_sub3_sub4_sub4.anInt1559 / 4;
                                    if (i6 > 30) {
                                        i6 = 30;
                                    }
                                    if (i6 > aByteArrayArrayArray74[i1][j + k5][j1 + l5]) {
                                        aByteArrayArrayArray74[i1][j + k5][j1 + l5] = (byte) i6;
                                    }
                                }
                            }
                        }
                    }
                }
                if (class8.aBoolean224 && class18 != null) {
                    class18.method233(j1, class8.anInt222, class8.aBoolean225, -24520, j, class8.anInt223, l);
                }
                return;
            }
            if (i >= 12) {
                Object obj2;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj2 = class8.method205(i, l, l1, i2, j2, k2, -1);
                } else {
                    obj2 = new GameObject(l, k1, i, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method288(0, j1, j, l2, byte0, i3, 0, 1, i1, ((Renderable) (obj2)), 1);
                if (i >= 12 && i <= 17 && i != 13 && i1 > 0) {
                    anIntArrayArrayArray81[i1][j][j1] |= 0x924;
                }
                if (class8.aBoolean224 && class18 != null) {
                    class18.method233(j1, class8.anInt222, class8.aBoolean225, -24520, j, class8.anInt223, l);
                }
                return;
            }
            if (i == 0) {
                Object obj3;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj3 = class8.method205(0, l, l1, i2, j2, k2, -1);
                } else {
                    obj3 = new GameObject(l, k1, 0, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method286(byte0, regionCached.anIntArray82[l], l2, i3, j, ((Renderable) (obj3)), -927, 0, null, i1,
                        j1);
                if (l == 0) {
                    if (class8.aBoolean238) {
                        aByteArrayArrayArray74[i1][j][j1] = 50;
                        aByteArrayArrayArray74[i1][j][j1 + 1] = 50;
                    }
                    if (class8.aBoolean229) {
                        anIntArrayArrayArray81[i1][j][j1] |= 0x249;
                    }
                } else if (l == 1) {
                    if (class8.aBoolean238) {
                        aByteArrayArrayArray74[i1][j][j1 + 1] = 50;
                        aByteArrayArrayArray74[i1][j + 1][j1 + 1] = 50;
                    }
                    if (class8.aBoolean229) {
                        anIntArrayArrayArray81[i1][j][j1 + 1] |= 0x492;
                    }
                } else if (l == 2) {
                    if (class8.aBoolean238) {
                        aByteArrayArrayArray74[i1][j + 1][j1] = 50;
                        aByteArrayArrayArray74[i1][j + 1][j1 + 1] = 50;
                    }
                    if (class8.aBoolean229) {
                        anIntArrayArrayArray81[i1][j + 1][j1] |= 0x249;
                    }
                } else if (l == 3) {
                    if (class8.aBoolean238) {
                        aByteArrayArrayArray74[i1][j][j1] = 50;
                        aByteArrayArrayArray74[i1][j + 1][j1] = 50;
                    }
                    if (class8.aBoolean229) {
                        anIntArrayArrayArray81[i1][j][j1] |= 0x492;
                    }
                }
                if (class8.aBoolean224 && class18 != null) {
                    class18.method232(true, l, class8.aBoolean225, i, j, j1);
                }
                if (class8.anInt231 != 16) {
                    class36.method294(j1, class8.anInt231, (byte) -90, j, i1);
                }
                return;
            }
            if (i == 1) {
                Object obj4;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj4 = class8.method205(1, l, l1, i2, j2, k2, -1);
                } else {
                    obj4 = new GameObject(l, k1, 1, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method286(byte0, regionCached.anIntArray83[l], l2, i3, j, ((Renderable) (obj4)), -927, 0, null, i1,
                        j1);
                if (class8.aBoolean238) {
                    if (l == 0) {
                        aByteArrayArrayArray74[i1][j][j1 + 1] = 50;
                    } else if (l == 1) {
                        aByteArrayArrayArray74[i1][j + 1][j1 + 1] = 50;
                    } else if (l == 2) {
                        aByteArrayArrayArray74[i1][j + 1][j1] = 50;
                    } else if (l == 3) {
                        aByteArrayArrayArray74[i1][j][j1] = 50;
                    }
                }
                if (class8.aBoolean224 && class18 != null) {
                    class18.method232(true, l, class8.aBoolean225, i, j, j1);
                }
                return;
            }
            if (i == 2) {
                int j3 = l + 1 & 3;
                Object obj11;
                Object obj12;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj11 = class8.method205(2, 4 + l, l1, i2, j2, k2, -1);
                    obj12 = class8.method205(2, j3, l1, i2, j2, k2, -1);
                } else {
                    obj11 = new GameObject(4 + l, k1, 2, k2, j2, false, l1, class8.anInt230, true, i2);
                    obj12 = new GameObject(j3, k1, 2, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method286(byte0, regionCached.anIntArray82[l], l2, i3, j, ((Renderable) (obj11)), -927,
                        regionCached.anIntArray82[j3], ((Renderable) (obj12)), i1, j1);
                if (class8.aBoolean229) {
                    if (l == 0) {
                        anIntArrayArrayArray81[i1][j][j1] |= 0x249;
                        anIntArrayArrayArray81[i1][j][j1 + 1] |= 0x492;
                    } else if (l == 1) {
                        anIntArrayArrayArray81[i1][j][j1 + 1] |= 0x492;
                        anIntArrayArrayArray81[i1][j + 1][j1] |= 0x249;
                    } else if (l == 2) {
                        anIntArrayArrayArray81[i1][j + 1][j1] |= 0x249;
                        anIntArrayArrayArray81[i1][j][j1] |= 0x492;
                    } else if (l == 3) {
                        anIntArrayArrayArray81[i1][j][j1] |= 0x492;
                        anIntArrayArrayArray81[i1][j][j1] |= 0x249;
                    }
                }
                if (class8.aBoolean224 && class18 != null) {
                    class18.method232(true, l, class8.aBoolean225, i, j, j1);
                }
                if (class8.anInt231 != 16) {
                    class36.method294(j1, class8.anInt231, (byte) -90, j, i1);
                }
                return;
            }
            if (i == 3) {
                Object obj5;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj5 = class8.method205(3, l, l1, i2, j2, k2, -1);
                } else {
                    obj5 = new GameObject(l, k1, 3, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method286(byte0, regionCached.anIntArray83[l], l2, i3, j, ((Renderable) (obj5)), -927, 0, null, i1,
                        j1);
                if (class8.aBoolean238) {
                    if (l == 0) {
                        aByteArrayArrayArray74[i1][j][j1 + 1] = 50;
                    } else if (l == 1) {
                        aByteArrayArrayArray74[i1][j + 1][j1 + 1] = 50;
                    } else if (l == 2) {
                        aByteArrayArrayArray74[i1][j + 1][j1] = 50;
                    } else if (l == 3) {
                        aByteArrayArrayArray74[i1][j][j1] = 50;
                    }
                }
                if (class8.aBoolean224 && class18 != null) {
                    class18.method232(true, l, class8.aBoolean225, i, j, j1);
                }
                return;
            }
            if (i == 9) {
                Object obj6;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj6 = class8.method205(i, l, l1, i2, j2, k2, -1);
                } else {
                    obj6 = new GameObject(l, k1, i, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method288(0, j1, j, l2, byte0, i3, 0, 1, i1, ((Renderable) (obj6)), 1);
                if (class8.aBoolean224 && class18 != null) {
                    class18.method233(j1, class8.anInt222, class8.aBoolean225, -24520, j, class8.anInt223, l);
                }
                return;
            }
            if (class8.aBoolean227) {
                if (l == 1) {
                    int k3 = k2;
                    k2 = j2;
                    j2 = i2;
                    i2 = l1;
                    l1 = k3;
                } else if (l == 2) {
                    int l3 = k2;
                    k2 = i2;
                    i2 = l3;
                    l3 = j2;
                    j2 = l1;
                    l1 = l3;
                } else if (l == 3) {
                    int i4 = k2;
                    k2 = l1;
                    l1 = i2;
                    i2 = j2;
                    j2 = i4;
                }
            }
            if (i == 4) {
                Object obj7;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj7 = class8.method205(4, 0, l1, i2, j2, k2, -1);
                } else {
                    obj7 = new GameObject(0, k1, 4, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method287(j1, i1, l2, ((Renderable) (obj7)), byte0, regionCached.anIntArray82[l], l * 512, i3, 0,
                        regionCached.anInt61, j, 0);
                return;
            }
            if (i == 5) {
                int j4 = 16;
                int l4 = class36.method304(i1, j, j1);
                if (l4 > 0) {
                    j4 = LocType.method199(l4 >> 14 & 0x7fff).anInt231;
                }
                Object obj13;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj13 = class8.method205(4, 0, l1, i2, j2, k2, -1);
                } else {
                    obj13 = new GameObject(0, k1, 4, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method287(j1, i1, l2, ((Renderable) (obj13)), byte0, regionCached.anIntArray82[l], l * 512, i3,
                        regionCached.anIntArray84[l] * j4, regionCached.anInt61, j, regionCached.anIntArray85[l] * j4);
                return;
            }
            if (i == 6) {
                Object obj8;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj8 = class8.method205(4, 0, l1, i2, j2, k2, -1);
                } else {
                    obj8 = new GameObject(0, k1, 4, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method287(j1, i1, l2, ((Renderable) (obj8)), byte0, 256, l, i3, 0, regionCached.anInt61, j, 0);
                return;
            }
            if (i == 7) {
                Object obj9;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj9 = class8.method205(4, 0, l1, i2, j2, k2, -1);
                } else {
                    obj9 = new GameObject(0, k1, 4, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method287(j1, i1, l2, ((Renderable) (obj9)), byte0, 512, l, i3, 0, regionCached.anInt61, j, 0);
                return;
            }
            if (i == 8) {
                Object obj10;
                if (class8.anInt230 == -1 && class8.anIntArray250 == null) {
                    obj10 = class8.method205(4, 0, l1, i2, j2, k2, -1);
                } else {
                    obj10 = new GameObject(0, k1, 4, k2, j2, false, l1, class8.anInt230, true, i2);
                }
                class36.method287(j1, i1, l2, ((Renderable) (obj10)), byte0, 768, l, i3, 0, regionCached.anInt61, j, 0);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("66723, " + i + ", " + j + ", " + class36 + ", " + k + ", " + l + ", " + i1 + ", "
                    + j1 + ", " + class18 + ", " + k1 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method163(byte byte0, CollisionMap[] aclass18, Scene class36) {
        try {
            if (byte0 != 76) {
                aBoolean62 = !aBoolean62;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 104; j++) {
                    for (int l = 0; l < 104; l++) {
                        if ((aByteArrayArrayArray69[i][j][l] & 1) == 1) {
                            int j1 = i;
                            if ((aByteArrayArrayArray69[1][j][l] & 2) == 2) {
                                j1--;
                            }
                            if (j1 >= 0) {
                                aclass18[j1].method234(j, (byte) 0, l);
                            }
                        }
                    }
                }
            }
            regionCached.anInt86 += (int) (Math.random() * 5D) - 2;
            if (regionCached.anInt86 < -8) {
                regionCached.anInt86 = -8;
            }
            if (regionCached.anInt86 > 8) {
                regionCached.anInt86 = 8;
            }
            regionCached.anInt87 += (int) (Math.random() * 5D) - 2;
            if (regionCached.anInt87 < -16) {
                regionCached.anInt87 = -16;
            }
            if (regionCached.anInt87 > 16) {
                regionCached.anInt87 = 16;
            }
            for (int k = 0; k < 4; k++) {
                byte[][] abyte0 = aByteArrayArrayArray74[k];
                byte byte1 = 96;
                char c = '\u0300';
                byte byte2 = -50;
                byte byte3 = -10;
                byte byte4 = -50;
                int i3 = (int) Math.sqrt(byte2 * byte2 + byte3 * byte3 + byte4 * byte4);
                int k3 = c * i3 >> 8;
                for (int i4 = 1; i4 < anInt67 - 1; i4++) {
                    for (int i5 = 1; i5 < anInt66 - 1; i5++) {
                        int j6 = anIntArrayArrayArray68[k][i5 + 1][i4] - anIntArrayArrayArray68[k][i5 - 1][i4];
                        int k7 = anIntArrayArrayArray68[k][i5][i4 + 1] - anIntArrayArrayArray68[k][i5][i4 - 1];
                        int i9 = (int) Math.sqrt(j6 * j6 + 0x10000 + k7 * k7);
                        int j12 = (j6 << 8) / i9;
                        int k13 = 0x10000 / i9;
                        int i15 = (k7 << 8) / i9;
                        int i16 = byte1 + (byte2 * j12 + byte3 * k13 + byte4 * i15) / k3;
                        int i17 = (abyte0[i5 - 1][i4] >> 2) + (abyte0[i5 + 1][i4] >> 3) + (abyte0[i5][i4 - 1] >> 2)
                                + (abyte0[i5][i4 + 1] >> 3) + (abyte0[i5][i4] >> 1);
                        anIntArrayArray75[i5][i4] = i16 - i17;
                    }
                }
                for (int j5 = 0; j5 < anInt67; j5++) {
                    anIntArray76[j5] = 0;
                    anIntArray77[j5] = 0;
                    anIntArray78[j5] = 0;
                    anIntArray79[j5] = 0;
                    anIntArray80[j5] = 0;
                }
                for (int k6 = -5; k6 < anInt66 + 5; k6++) {
                    for (int l7 = 0; l7 < anInt67; l7++) {
                        int j9 = k6 + 5;
                        if (j9 >= 0 && j9 < anInt66) {
                            int k12 = aByteArrayArrayArray70[k][j9][l7] & 0xff;
                            if (k12 > 0) {
                                FloType class20 = FloType.aClass20Array430[k12 - 1];
                                anIntArray76[l7] += class20.anInt439;
                                anIntArray77[l7] += class20.anInt437;
                                anIntArray78[l7] += class20.anInt438;
                                anIntArray79[l7] += class20.anInt440;
                                anIntArray80[l7]++;
                            }
                        }
                        int l12 = k6 - 5;
                        if (l12 >= 0 && l12 < anInt66) {
                            int l13 = aByteArrayArrayArray70[k][l12][l7] & 0xff;
                            if (l13 > 0) {
                                FloType class20_1 = FloType.aClass20Array430[l13 - 1];
                                anIntArray76[l7] -= class20_1.anInt439;
                                anIntArray77[l7] -= class20_1.anInt437;
                                anIntArray78[l7] -= class20_1.anInt438;
                                anIntArray79[l7] -= class20_1.anInt440;
                                anIntArray80[l7]--;
                            }
                        }
                    }
                    if (k6 >= 1 && k6 < anInt66 - 1) {
                        int k9 = 0;
                        int i13 = 0;
                        int i14 = 0;
                        int j15 = 0;
                        int j16 = 0;
                        for (int j17 = -5; j17 < anInt67 + 5; j17++) {
                            int i18 = j17 + 5;
                            if (i18 >= 0 && i18 < anInt67) {
                                k9 += anIntArray76[i18];
                                i13 += anIntArray77[i18];
                                i14 += anIntArray78[i18];
                                j15 += anIntArray79[i18];
                                j16 += anIntArray80[i18];
                            }
                            int j18 = j17 - 5;
                            if (j18 >= 0 && j18 < anInt67) {
                                k9 -= anIntArray76[j18];
                                i13 -= anIntArray77[j18];
                                i14 -= anIntArray78[j18];
                                j15 -= anIntArray79[j18];
                                j16 -= anIntArray80[j18];
                            }
                            if (j17 >= 1
                                    && j17 < anInt67 - 1
                                    && (!regionCached.aBoolean64 || (aByteArrayArrayArray69[k][k6][j17] & 0x10) == 0
                                    && method164(j17, k6, 0, k) == regionCached.plane)) {
                                int k18 = aByteArrayArrayArray70[k][k6][j17] & 0xff;
                                int l18 = aByteArrayArrayArray71[k][k6][j17] & 0xff;
                                if (k18 > 0 || l18 > 0) {
                                    int i19 = anIntArrayArrayArray68[k][k6][j17];
                                    int j19 = anIntArrayArrayArray68[k][k6 + 1][j17];
                                    int k19 = anIntArrayArrayArray68[k][k6 + 1][j17 + 1];
                                    int l19 = anIntArrayArrayArray68[k][k6][j17 + 1];
                                    int i20 = anIntArrayArray75[k6][j17];
                                    int j20 = anIntArrayArray75[k6 + 1][j17];
                                    int k20 = anIntArrayArray75[k6 + 1][j17 + 1];
                                    int l20 = anIntArrayArray75[k6][j17 + 1];
                                    int i21 = -1;
                                    int j21 = -1;
                                    if (k18 > 0) {
                                        int k21 = (k9 * 256) / j15;
                                        int i22 = i13 / j16;
                                        int k22 = i14 / j16;
                                        i21 = method172(k21, i22, k22);
                                        k21 = k21 + regionCached.anInt86 & 0xff;
                                        k22 += regionCached.anInt87;
                                        if (k22 < 0) {
                                            k22 = 0;
                                        } else if (k22 > 255) {
                                            k22 = 255;
                                        }
                                        j21 = method172(k21, i22, k22);
                                    }
                                    if (k > 0) {
                                        boolean flag = k18 != 0 || aByteArrayArrayArray72[k][k6][j17] == 0;
                                        if (l18 > 0 && !FloType.aClass20Array430[l18 - 1].aBoolean435) {
                                            flag = false;
                                        }
                                        if (flag && i19 == j19 && i19 == k19 && i19 == l19) {
                                            anIntArrayArrayArray81[k][k6][j17] |= 0x924;
                                        }
                                    }
                                    int l21 = 0;
                                    if (i21 != -1) {
                                        l21 = Draw3D.anIntArray1439[regionCached.method170(j21, 96)];
                                    }
                                    if (l18 == 0) {
                                        class36.method283(k, k6, j17, 0, 0, -1, i19, j19, k19, l19,
                                                regionCached.method170(i21, i20), regionCached.method170(i21, j20),
                                                regionCached.method170(i21, k20), regionCached.method170(i21, l20), 0, 0, 0, 0,
                                                l21, 0);
                                    } else {
                                        int j22 = aByteArrayArrayArray72[k][k6][j17] + 1;
                                        byte byte5 = aByteArrayArrayArray73[k][k6][j17];
                                        FloType class20_2 = FloType.aClass20Array430[l18 - 1];
                                        int l22 = class20_2.anInt433;
                                        int i23;
                                        int j23;
                                        if (l22 >= 0) {
                                            j23 = Draw3D.method424(0, l22);
                                            i23 = -1;
                                        } else if (class20_2.anInt432 == 0xff00ff) {
                                            j23 = 0;
                                            i23 = -2;
                                            l22 = -1;
                                        } else {
                                            i23 = method172(class20_2.anInt436, class20_2.anInt437, class20_2.anInt438);
                                            j23 = Draw3D.anIntArray1439[method171(class20_2.anInt441, 96)];
                                        }
                                        class36.method283(k, k6, j17, j22, byte5, l22, i19, j19, k19, l19,
                                                regionCached.method170(i21, i20), regionCached.method170(i21, j20),
                                                regionCached.method170(i21, k20), regionCached.method170(i21, l20),
                                                method171(i23, i20), method171(i23, j20), method171(i23, k20),
                                                method171(i23, l20), l21, j23);
                                    }
                                }
                            }
                        }
                    }
                }
                for (int i8 = 1; i8 < anInt67 - 1; i8++) {
                    for (int l9 = 1; l9 < anInt66 - 1; l9++) {
                        class36.method282(k, l9, i8, method164(i8, l9, 0, k));
                    }
                }
            }
            class36.method309(64, 7, -50, 768, -50, -10);
            for (int i1 = 0; i1 < anInt66; i1++) {
                for (int k1 = 0; k1 < anInt67; k1++) {
                    if ((aByteArrayArrayArray69[1][i1][k1] & 2) == 2) {
                        class36.method280(true, k1, i1);
                    }
                }
            }
            int l1 = 1;
            int i2 = 2;
            int j2 = 4;
            for (int k2 = 0; k2 < 4; k2++) {
                if (k2 > 0) {
                    l1 <<= 3;
                    i2 <<= 3;
                    j2 <<= 3;
                }
                for (int l2 = 0; l2 <= k2; l2++) {
                    for (int j3 = 0; j3 <= anInt67; j3++) {
                        for (int l3 = 0; l3 <= anInt66; l3++) {
                            if ((anIntArrayArrayArray81[l2][l3][j3] & l1) != 0) {
                                int j4 = j3;
                                int k5 = j3;
                                int l6 = l2;
                                int j8 = l2;
                                for (; j4 > 0 && (anIntArrayArrayArray81[l2][l3][j4 - 1] & l1) != 0; j4--) {
                                }
                                for (; k5 < anInt67 && (anIntArrayArrayArray81[l2][l3][k5 + 1] & l1) != 0; k5++) {
                                }
                                label0:
                                for (; l6 > 0; l6--) {
                                    for (int i10 = j4; i10 <= k5; i10++) {
                                        if ((anIntArrayArrayArray81[l6 - 1][l3][i10] & l1) == 0) {
                                            break label0;
                                        }
                                    }
                                }
                                label1:
                                for (; j8 < k2; j8++) {
                                    for (int j10 = j4; j10 <= k5; j10++) {
                                        if ((anIntArrayArrayArray81[j8 + 1][l3][j10] & l1) == 0) {
                                            break label1;
                                        }
                                    }
                                }
                                int k10 = ((j8 + 1) - l6) * ((k5 - j4) + 1);
                                if (k10 >= 8) {
                                    char c1 = '\360';
                                    int j14 = anIntArrayArrayArray68[j8][l3][j4] - c1;
                                    int k15 = anIntArrayArrayArray68[l6][l3][j4];
                                    Scene.method281(j4 * 128, k2, j14, l3 * 128, l3 * 128, 1, k15, k5 * 128 + 128, 1);
                                    for (int k16 = l6; k16 <= j8; k16++) {
                                        for (int k17 = j4; k17 <= k5; k17++) {
                                            anIntArrayArrayArray81[k16][l3][k17] &= ~l1;
                                        }
                                    }
                                }
                            }
                            if ((anIntArrayArrayArray81[l2][l3][j3] & i2) != 0) {
                                int k4 = l3;
                                int l5 = l3;
                                int i7 = l2;
                                int k8 = l2;
                                for (; k4 > 0 && (anIntArrayArrayArray81[l2][k4 - 1][j3] & i2) != 0; k4--) {
                                }
                                for (; l5 < anInt66 && (anIntArrayArrayArray81[l2][l5 + 1][j3] & i2) != 0; l5++) {
                                }
                                label2:
                                for (; i7 > 0; i7--) {
                                    for (int l10 = k4; l10 <= l5; l10++) {
                                        if ((anIntArrayArrayArray81[i7 - 1][l10][j3] & i2) == 0) {
                                            break label2;
                                        }
                                    }
                                }
                                label3:
                                for (; k8 < k2; k8++) {
                                    for (int i11 = k4; i11 <= l5; i11++) {
                                        if ((anIntArrayArrayArray81[k8 + 1][i11][j3] & i2) == 0) {
                                            break label3;
                                        }
                                    }
                                }
                                int j11 = ((k8 + 1) - i7) * ((l5 - k4) + 1);
                                if (j11 >= 8) {
                                    char c2 = '\360';
                                    int k14 = anIntArrayArrayArray68[k8][k4][j3] - c2;
                                    int l15 = anIntArrayArrayArray68[i7][k4][j3];
                                    Scene.method281(j3 * 128, k2, k14, l5 * 128 + 128, k4 * 128, 1, l15, j3 * 128, 2);
                                    for (int l16 = i7; l16 <= k8; l16++) {
                                        for (int l17 = k4; l17 <= l5; l17++) {
                                            anIntArrayArrayArray81[l16][l17][j3] &= ~i2;
                                        }
                                    }
                                }
                            }
                            if ((anIntArrayArrayArray81[l2][l3][j3] & j2) != 0) {
                                int l4 = l3;
                                int i6 = l3;
                                int j7 = j3;
                                int l8 = j3;
                                for (; j7 > 0 && (anIntArrayArrayArray81[l2][l3][j7 - 1] & j2) != 0; j7--) {
                                }
                                for (; l8 < anInt67 && (anIntArrayArrayArray81[l2][l3][l8 + 1] & j2) != 0; l8++) {
                                }
                                label4:
                                for (; l4 > 0; l4--) {
                                    for (int k11 = j7; k11 <= l8; k11++) {
                                        if ((anIntArrayArrayArray81[l2][l4 - 1][k11] & j2) == 0) {
                                            break label4;
                                        }
                                    }
                                }
                                label5:
                                for (; i6 < anInt66; i6++) {
                                    for (int l11 = j7; l11 <= l8; l11++) {
                                        if ((anIntArrayArrayArray81[l2][i6 + 1][l11] & j2) == 0) {
                                            break label5;
                                        }
                                    }
                                }
                                if (((i6 - l4) + 1) * ((l8 - j7) + 1) >= 4) {
                                    int i12 = anIntArrayArrayArray68[l2][l4][j7];
                                    Scene.method281(j7 * 128, k2, i12, i6 * 128 + 128, l4 * 128, 1, i12,
                                            l8 * 128 + 128, 4);
                                    for (int j13 = l4; j13 <= i6; j13++) {
                                        for (int l14 = j7; l14 <= l8; l14++) {
                                            anIntArrayArrayArray81[l2][j13][l14] &= ~j2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("24657, " + byte0 + ", " + aclass18 + ", " + class36 + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int method164(int i, int j, int k, int l) {
        try {
            if (k != 0) {
                aBoolean63 = !aBoolean63;
            }
            if ((aByteArrayArrayArray69[l][j][i] & 8) != 0) {
                return 0;
            }
            if (l > 0 && (aByteArrayArrayArray69[1][j][i] & 2) != 0) {
                return l - 1;
            } else {
                return l;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("30913, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method171(int i, int j) {
        if (i == -2) {
            return 0xbc614e;
        }
        if (i == -1) {
            if (j < 0) {
                j = 0;
            } else if (j > 127) {
                j = 127;
            }
            j = 127 - j;
            return j;
        }
        j = (j * (i & 0x7f)) / 128;
        if (j < 2) {
            j = 2;
        } else if (j > 126) {
            j = 126;
        }
        return (i & 0xff80) + j;
    }

    public int method172(int i, int j, int k) {
        if (k > 179) {
            j /= 2;
        }
        if (k > 192) {
            j /= 2;
        }
        if (k > 217) {
            j /= 2;
        }
        if (k > 243) {
            j /= 2;
        }
        int l = (i / 4 << 10) + (j / 32 << 7) + k / 2;
        return l;
    }

}

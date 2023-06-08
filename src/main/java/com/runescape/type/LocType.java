package com.runescape.type;

import com.runescape.cache.FileArchive;
import com.runescape.cache.request.OnDemandRequester;
import com.runescape.collection.Cache;
import com.runescape.graphic.Model;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class LocType {

    public static int anInt209;
    public static int[] anIntArray210;
    public static Buffer buffer;
    public static LocType[] cache;
    public static int anInt213;
    public static Model[] aClass44_Sub3_Sub4_Sub4Array214 = new Model[4];
    public static Cache aClass39_251 = new Cache((byte) 7, 500);
    public static Cache aClass39_252 = new Cache((byte) 7, 30);
    public boolean aBoolean203;
    public int anInt204;
    public byte aByte205;
    public int anInt206;
    public int anInt207;
    public int anInt208;
    public int anInt215;
    public int[] anIntArray216;
    public int[] anIntArray217;
    public String aString218;
    public byte[] aByteArray219;
    public int[] anIntArray220;
    public int[] anIntArray221;
    public int sizeX;
    public int sizeZ;
    public boolean aBoolean224;
    public boolean aBoolean225;
    public boolean aBoolean226;
    public boolean aBoolean227;
    public boolean aBoolean228;
    public boolean aBoolean229;
    public int anInt230;
    public int anInt231;
    public byte aByte232;
    public byte aByte233;
    public String[] aStringArray234;
    public int mapFunctionIcon;
    public int mapscene;
    public boolean aBoolean237;
    public boolean aBoolean238;
    public int anInt239;
    public int anInt240;
    public int anInt241;
    public int anInt242;
    public int anInt243;
    public int anInt244;
    public int face;
    public boolean aBoolean246;
    public boolean aBoolean247;
    public int anInt248;
    public int anInt249;
    public int[] anIntArray250;

    public LocType() {
        aBoolean203 = false;
        anInt204 = 44692;
        aByte205 = 4;
        anInt207 = -139;
        anInt215 = -1;
    }

    public static void unpack(FileArchive class47) {
        LocType.buffer = new Buffer(class47.read("loc.dat"));
        Buffer class44_sub3_sub2 = new Buffer(class47.read("loc.idx"));
        LocType.anInt209 = class44_sub3_sub2.readUnsignedShort();
        LocType.anIntArray210 = new int[LocType.anInt209];
        int i = 2;
        for (int j = 0; j < LocType.anInt209; j++) {
            LocType.anIntArray210[j] = i;
            i += class44_sub3_sub2.readUnsignedShort();
        }
        LocType.cache = new LocType[20];
        for (int k = 0; k < 20; k++) {
            LocType.cache[k] = new LocType();
        }
    }

    public static void method198(byte byte0) {
        try {
            LocType.aClass39_251 = null;
            LocType.aClass39_252 = null;
            LocType.anIntArray210 = null;
            LocType.cache = null;
            LocType.buffer = null;
            if (byte0 != 42) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("19919, " + byte0 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public static LocType lookup(int i) {
        for (int j = 0; j < 20; j++) {
            if (LocType.cache[j].anInt215 == i) {
                return LocType.cache[j];
            }
        }
        LocType.anInt213 = (LocType.anInt213 + 1) % 20;
        LocType class8 = LocType.cache[LocType.anInt213];
        LocType.buffer.position = LocType.anIntArray210[i];
        class8.anInt215 = i;
        class8.method200();
        class8.method201(false, LocType.buffer);
        return class8;
    }

    public void method200() {
        anIntArray216 = null;
        anIntArray217 = null;
        aString218 = null;
        aByteArray219 = null;
        anIntArray220 = null;
        anIntArray221 = null;
        sizeX = 1;
        sizeZ = 1;
        aBoolean224 = true;
        aBoolean225 = true;
        aBoolean226 = false;
        aBoolean227 = false;
        aBoolean228 = false;
        aBoolean229 = false;
        anInt230 = -1;
        anInt231 = 16;
        aByte232 = 0;
        aByte233 = 0;
        aStringArray234 = null;
        mapFunctionIcon = -1;
        mapscene = -1;
        aBoolean237 = false;
        aBoolean238 = true;
        anInt239 = 128;
        anInt240 = 128;
        anInt241 = 128;
        face = 0;
        anInt242 = 0;
        anInt243 = 0;
        anInt244 = 0;
        aBoolean246 = false;
        aBoolean247 = false;
        anInt248 = -1;
        anInt249 = -1;
        anIntArray250 = null;
    }

    public void method201(boolean flag, Buffer class44_sub3_sub2) {
        try {
            int i = -1;
            if (flag) {
                anInt208 = -264;
            }
            label0:
            do {
                int j;
                do {
                    j = class44_sub3_sub2.readUnsignedByte();
                    if (j == 0) {
                        break label0;
                    }
                    if (j == 1) {
                        int k = class44_sub3_sub2.readUnsignedByte();
                        if (k > 0) {
                            anIntArray217 = new int[k];
                            anIntArray216 = new int[k];
                            for (int k1 = 0; k1 < k; k1++) {
                                anIntArray216[k1] = class44_sub3_sub2.readUnsignedShort();
                                anIntArray217[k1] = class44_sub3_sub2.readUnsignedByte();
                            }
                        }
                    } else if (j == 2) {
                        aString218 = class44_sub3_sub2.readString();
                    } else if (j == 3) {
                        aByteArray219 = class44_sub3_sub2.method490(anInt204);
                    } else if (j == 5) {
                        int l = class44_sub3_sub2.readUnsignedByte();
                        if (l > 0) {
                            anIntArray217 = null;
                            anIntArray216 = new int[l];
                            for (int l1 = 0; l1 < l; l1++) {
                                anIntArray216[l1] = class44_sub3_sub2.readUnsignedShort();
                            }
                        }
                    } else if (j == 14) {
                        sizeX = class44_sub3_sub2.readUnsignedByte();
                    } else if (j == 15) {
                        sizeZ = class44_sub3_sub2.readUnsignedByte();
                    } else if (j == 17) {
                        aBoolean224 = false;
                    } else if (j == 18) {
                        aBoolean225 = false;
                    } else if (j == 19) {
                        i = class44_sub3_sub2.readUnsignedByte();
                        if (i == 1) {
                            aBoolean226 = true;
                        }
                    } else if (j == 21) {
                        aBoolean227 = true;
                    } else if (j == 22) {
                        aBoolean228 = true;
                    } else if (j == 23) {
                        aBoolean229 = true;
                    } else if (j == 24) {
                        anInt230 = class44_sub3_sub2.readUnsignedShort();
                        if (anInt230 == 65535) {
                            anInt230 = -1;
                        }
                    } else if (j == 28) {
                        anInt231 = class44_sub3_sub2.readUnsignedByte();
                    } else if (j == 29) {
                        aByte232 = class44_sub3_sub2.readByte();
                    } else if (j == 39) {
                        aByte233 = class44_sub3_sub2.readByte();
                    } else if (j >= 30 && j < 39) {
                        if (aStringArray234 == null) {
                            aStringArray234 = new String[5];
                        }
                        aStringArray234[j - 30] = class44_sub3_sub2.readString();
                        if (aStringArray234[j - 30].equalsIgnoreCase("hidden")) {
                            aStringArray234[j - 30] = null;
                        }
                    } else if (j == 40) {
                        int i1 = class44_sub3_sub2.readUnsignedByte();
                        anIntArray220 = new int[i1];
                        anIntArray221 = new int[i1];
                        for (int i2 = 0; i2 < i1; i2++) {
                            anIntArray220[i2] = class44_sub3_sub2.readUnsignedShort();
                            anIntArray221[i2] = class44_sub3_sub2.readUnsignedShort();
                        }
                    } else if (j == 60) {
                        mapFunctionIcon = class44_sub3_sub2.readUnsignedShort();
                    } else if (j == 62) {
                        aBoolean237 = true;
                    } else if (j == 64) {
                        aBoolean238 = false;
                    } else if (j == 65) {
                        anInt239 = class44_sub3_sub2.readUnsignedShort();
                    } else if (j == 66) {
                        anInt240 = class44_sub3_sub2.readUnsignedShort();
                    } else if (j == 67) {
                        anInt241 = class44_sub3_sub2.readUnsignedShort();
                    } else if (j == 68) {
                        mapscene = class44_sub3_sub2.readUnsignedShort();
                    } else if (j == 69) {
                        face = class44_sub3_sub2.readUnsignedByte();
                    } else if (j == 70) {
                        anInt242 = class44_sub3_sub2.method485();
                    } else if (j == 71) {
                        anInt243 = class44_sub3_sub2.method485();
                    } else if (j == 72) {
                        anInt244 = class44_sub3_sub2.method485();
                    } else if (j == 73) {
                        aBoolean246 = true;
                    } else if (j == 74) {
                        aBoolean247 = true;
                    } else {
                        if (j != 75) {
                            continue;
                        }
                        anInt248 = class44_sub3_sub2.readUnsignedByte();
                    }
                    continue label0;
                } while (j != 77);
                anInt249 = class44_sub3_sub2.readUnsignedShort();

                int j1 = class44_sub3_sub2.readUnsignedByte();
                anIntArray250 = new int[j1 + 1];
                for (int j2 = 0; j2 <= j1; j2++) {
                    anIntArray250[j2] = class44_sub3_sub2.readUnsignedShort();
                    if (anIntArray250[j2] == 65535) {
                        anIntArray250[j2] = -1;
                    }
                }
            } while (true);
            if (i == -1) {
                aBoolean226 = anIntArray216 != null && (anIntArray217 == null || anIntArray217[0] == 10);
                if (aStringArray234 != null) {
                    aBoolean226 = true;
                }
            }
            if (aBoolean247) {
                aBoolean224 = false;
                aBoolean225 = false;
            }
            if (anInt248 == -1) {
                anInt248 = aBoolean224 ? 1 : 0;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("43978, " + flag + ", " + class44_sub3_sub2 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public boolean method202(int i, int j) {
        try {
            j = 56 / j;
            if (anIntArray217 == null) {
                if (anIntArray216 == null) {
                    return true;
                }
                if (i != 10) {
                    return true;
                }
                boolean flag = true;
                for (int l = 0; l < anIntArray216.length; l++) {
                    flag &= Model.method507(anIntArray216[l] & 0xffff);
                }
                return flag;
            }
            for (int k = 0; k < anIntArray217.length; k++) {
                if (anIntArray217[k] == i) {
                    return Model.method507(anIntArray216[k] & 0xffff);
                }
            }
            return true;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("3902, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method203(int i) {
        try {
            if (anIntArray216 == null) {
                return true;
            }
            boolean flag = true;
            for (int j = 0; j < anIntArray216.length; j++) {
                flag &= Model.method507(anIntArray216[j] & 0xffff);
            }
            while (i >= 0) {
                aBoolean203 = !aBoolean203;
            }
            return flag;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("61709, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method204(OnDemandRequester class43_sub1, byte byte0) {
        try {
            if (anIntArray216 == null) {
                return;
            }
            for (int i = 0; i < anIntArray216.length; i++) {
                class43_sub1.method397(anIntArray216[i] & 0xffff, 0, (byte) 6);
            }
            if (byte0 == 2) {
                byte0 = 0;
                return;
            }
            for (int j = 1; j > 0; j++) {
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("2074, " + class43_sub1 + ", " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Model method205(int i, int j, int k, int l, int i1, int j1, int k1) {
        Model class44_sub3_sub4_sub4 = method206((byte) -74, k1, j, i);
        if (class44_sub3_sub4_sub4 == null) {
            return null;
        }
        if (aBoolean227 || aBoolean228) {
            class44_sub3_sub4_sub4 = new Model(aBoolean228, 0, class44_sub3_sub4_sub4, aBoolean227);
        }
        if (aBoolean227) {
            int l1 = (k + l + i1 + j1) / 4;
            for (int i2 = 0; i2 < class44_sub3_sub4_sub4.anInt1535; i2++) {
                int j2 = class44_sub3_sub4_sub4.anIntArray1536[i2];
                int k2 = class44_sub3_sub4_sub4.anIntArray1538[i2];
                int l2 = k + ((l - k) * (j2 + 64)) / 128;
                int i3 = j1 + ((i1 - j1) * (j2 + 64)) / 128;
                int j3 = l2 + ((i3 - l2) * (k2 + 64)) / 128;
                class44_sub3_sub4_sub4.anIntArray1537[i2] += j3 - l1;
            }
            class44_sub3_sub4_sub4.method511(anInt207);
        }
        return class44_sub3_sub4_sub4;
    }

    public Model method206(byte byte0, int i, int j, int k) {
        try {
            Model class44_sub3_sub4_sub4 = null;
            long l;
            if (anIntArray217 == null) {
                if (k != 10) {
                    return null;
                }
                l = (anInt215 << 6) + j + ((long) (i + 1) << 32);
                Model class44_sub3_sub4_sub4_1 = (Model) LocType.aClass39_252.method339(l);
                if (class44_sub3_sub4_sub4_1 != null) {
                    return class44_sub3_sub4_sub4_1;
                }
                if (anIntArray216 == null) {
                    return null;
                }
                boolean flag1 = aBoolean237 ^ (j > 3);
                int k1 = anIntArray216.length;
                for (int l1 = 0; l1 < k1; l1++) {
                    int k2 = anIntArray216[l1];
                    if (flag1) {
                        k2 += 0x10000;
                    }
                    class44_sub3_sub4_sub4 = (Model) LocType.aClass39_251.method339(k2);
                    if (class44_sub3_sub4_sub4 == null) {
                        class44_sub3_sub4_sub4 = Model.method506(k2 & 0xffff, aByte205);
                        if (class44_sub3_sub4_sub4 == null) {
                            return null;
                        }
                        if (flag1) {
                            class44_sub3_sub4_sub4.method521(6);
                        }
                        LocType.aClass39_251.method340(k2, (byte) 76, class44_sub3_sub4_sub4);
                    }
                    if (k1 > 1) {
                        LocType.aClass44_Sub3_Sub4_Sub4Array214[l1] = class44_sub3_sub4_sub4;
                    }
                }
                if (k1 > 1) {
                    class44_sub3_sub4_sub4 = new Model(LocType.aClass44_Sub3_Sub4_Sub4Array214, k1, -33019);
                }
            } else {
                int i1 = -1;
                for (int j1 = 0; j1 < anIntArray217.length; j1++) {
                    if (anIntArray217[j1] != k) {
                        continue;
                    }
                    i1 = j1;
                    break;
                }
                if (i1 == -1) {
                    return null;
                }
                l = (anInt215 << 6) + (i1 << 3) + j + ((long) (i + 1) << 32);
                Model class44_sub3_sub4_sub4_2 = (Model) LocType.aClass39_252.method339(l);
                if (class44_sub3_sub4_sub4_2 != null) {
                    return class44_sub3_sub4_sub4_2;
                }
                int i2 = anIntArray216[i1];
                boolean flag3 = aBoolean237 ^ (j > 3);
                if (flag3) {
                    i2 += 0x10000;
                }
                class44_sub3_sub4_sub4 = (Model) LocType.aClass39_251.method339(i2);
                if (class44_sub3_sub4_sub4 == null) {
                    class44_sub3_sub4_sub4 = Model.method506(i2 & 0xffff, aByte205);
                    if (class44_sub3_sub4_sub4 == null) {
                        return null;
                    }
                    if (flag3) {
                        class44_sub3_sub4_sub4.method521(6);
                    }
                    LocType.aClass39_251.method340(i2, (byte) 76, class44_sub3_sub4_sub4);
                }
            }
            if (byte0 != -74) {
                throw new NullPointerException();
            }
            boolean flag;
            flag = anInt239 != 128 || anInt240 != 128 || anInt241 != 128;
            boolean flag2;
            flag2 = anInt242 != 0 || anInt243 != 0 || anInt244 != 0;
            Model class44_sub3_sub4_sub4_3 = new Model(class44_sub3_sub4_sub4, SeqFrame.method211(i, 0), j == 0
                    && i == -1 && !flag && !flag2, anInt206, anIntArray220 == null);
            if (i != -1) {
                class44_sub3_sub4_sub4_3.createLabelReference((byte) 3);
                class44_sub3_sub4_sub4_3.applyTransform(i, 188);
                class44_sub3_sub4_sub4_3.anIntArrayArray1567 = null;
                class44_sub3_sub4_sub4_3.anIntArrayArray1566 = null;
            }
            while (j-- > 0) {
                class44_sub3_sub4_sub4_3.method517(0);
            }
            if (anIntArray220 != null) {
                for (int j2 = 0; j2 < anIntArray220.length; j2++) {
                    class44_sub3_sub4_sub4_3.recolor(anIntArray220[j2], anIntArray221[j2]);
                }
            }
            if (flag) {
                class44_sub3_sub4_sub4_3.method522(anInt239, anInt241, anInt240, (byte) 31);
            }
            if (flag2) {
                class44_sub3_sub4_sub4_3.method519(anInt243, anInt242, (byte) 2, anInt244);
            }
            class44_sub3_sub4_sub4_3.calculateNormals(64 + aByte232, 768 + aByte233 * 5, -50, -10, -50, !aBoolean228);
            if (anInt248 == 1) {
                class44_sub3_sub4_sub4_3.anInt1563 = class44_sub3_sub4_sub4_3.anInt1412;
            }
            LocType.aClass39_252.method340(l, (byte) 76, class44_sub3_sub4_sub4_3);
            return class44_sub3_sub4_sub4_3;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("13988, " + byte0 + ", " + i + ", " + j + ", " + k + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

}

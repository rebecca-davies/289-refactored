package com.runescape.type;

import com.runescape.cache.FileArchive;
import com.runescape.collection.Cache;
import com.runescape.graphic.Image24;
import com.runescape.graphic.Model;
import com.runescape.graphic.Draw2D;
import com.runescape.graphic.Draw3D;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class ObjType {

    public static int anInt319 = 6;
    public static byte aByte320 = 1;
    public static byte aByte321 = 8;
    public static int anInt323;
    public static int[] anIntArray324;
    public static Buffer buffer;
    public static ObjType[] cache;
    public static int anInt327;
    public static boolean aBoolean328 = true;
    public static Cache aClass39_369 = new Cache((byte) 7, 50);
    public static Cache aClass39_370 = new Cache((byte) 7, 100);
    public boolean aBoolean316;
    public int anInt317;
    public byte aByte318;
    public int anInt322;
    public int anInt329;
    public int anInt330;
    public String aString331;
    public byte[] aByteArray332;
    public int[] anIntArray333;
    public int[] anIntArray334;
    public int anInt335;
    public int anInt336;
    public int anInt337;
    public int anInt338;
    public int anInt339;
    public int anInt340;
    public int anInt341;
    public boolean aBoolean342;
    public int anInt343;
    public boolean aBoolean344;
    public String[] aStringArray345;
    public String[] aStringArray346;
    public int anInt347;
    public int anInt348;
    public byte aByte349;
    public int anInt350;
    public int anInt351;
    public byte aByte352;
    public int anInt353;
    public int anInt354;
    public int anInt355;
    public int anInt356;
    public int anInt357;
    public int anInt358;
    public int[] anIntArray359;
    public int[] anIntArray360;
    public int anInt361;
    public int anInt362;
    public int anInt363;
    public int anInt364;
    public int anInt365;
    public int anInt366;
    public int anInt367;
    public int anInt368;

    public ObjType() {
        aBoolean316 = false;
        anInt317 = 44692;
        aByte318 = 4;
        anInt322 = 2;
        anInt329 = -1;
    }

    public static void method218(FileArchive class47) {
        ObjType.buffer = new Buffer(class47.method549("obj.dat", null));
        Buffer class44_sub3_sub2 = new Buffer(class47.method549("obj.idx", null));
        ObjType.anInt323 = class44_sub3_sub2.readUnsignedShort();
        ObjType.anIntArray324 = new int[ObjType.anInt323];
        int i = 2;
        for (int j = 0; j < ObjType.anInt323; j++) {
            ObjType.anIntArray324[j] = i;
            i += class44_sub3_sub2.readUnsignedShort();
        }
        ObjType.cache = new ObjType[10];
        for (int k = 0; k < 10; k++) {
            ObjType.cache[k] = new ObjType();
        }
    }

    public static void method219(byte byte0) {
        try {
            ObjType.aClass39_369 = null;
            ObjType.aClass39_370 = null;
            ObjType.anIntArray324 = null;
            ObjType.cache = null;
            ObjType.buffer = null;
            if (byte0 != 42) {
                ObjType.anInt319 = 87;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("13898, " + byte0 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public static ObjType method220(int i) {
        for (int j = 0; j < 10; j++) {
            if (ObjType.cache[j].anInt329 == i) {
                return ObjType.cache[j];
            }
        }
        ObjType.anInt327 = (ObjType.anInt327 + 1) % 10;
        ObjType class14 = ObjType.cache[ObjType.anInt327];
        ObjType.buffer.position = ObjType.anIntArray324[i];
        class14.anInt329 = i;
        class14.method221();
        class14.method222(false, ObjType.buffer);
        if (class14.anInt362 != -1) {
            class14.method223(6);
        }
        if (!ObjType.aBoolean328 && class14.aBoolean344) {
            class14.aString331 = "Members Object";
            class14.aByteArray332 = "Login to a members' server to use this object.".getBytes();
            class14.aStringArray345 = null;
            class14.aStringArray346 = null;
        }
        return class14;
    }

    public static Image24 method226(int i, int j, int k, int l) {
        try {
            if (k == 0) {
                Image24 class44_sub3_sub1_sub2 = (Image24) ObjType.aClass39_370.method339(j);
                if (class44_sub3_sub1_sub2 != null && class44_sub3_sub1_sub2.cropHeight != l
                        && class44_sub3_sub1_sub2.cropHeight != -1) {
                    class44_sub3_sub1_sub2.remove();
                    class44_sub3_sub1_sub2 = null;
                }
                if (class44_sub3_sub1_sub2 != null) {
                    return class44_sub3_sub1_sub2;
                }
            }
            ObjType class14 = ObjType.method220(j);
            if (class14.anIntArray359 == null) {
                l = -1;
            }
            if (l > 1) {
                int i1 = -1;
                for (int j1 = 0; j1 < 10; j1++) {
                    if (l >= class14.anIntArray360[j1] && class14.anIntArray360[j1] != 0) {
                        i1 = class14.anIntArray359[j1];
                    }
                }
                if (i1 != -1) {
                    class14 = ObjType.method220(i1);
                }
            }
            Model class44_sub3_sub4_sub4 = class14.method224(1);
            if (class44_sub3_sub4_sub4 == null) {
                return null;
            }
            Image24 class44_sub3_sub1_sub2_2 = null;
            if (class14.anInt362 != -1) {
                class44_sub3_sub1_sub2_2 = ObjType.method226(54, class14.anInt361, -1, 10);
                if (class44_sub3_sub1_sub2_2 == null) {
                    return null;
                }
            }
            Image24 class44_sub3_sub1_sub2_1 = new Image24(32, 32);
            int k1 = Draw3D.anInt1423;
            int l1 = Draw3D.anInt1424;
            int[] ai = Draw3D.anIntArray1429;
            int[] ai1 = Draw2D.pixels;
            int i2 = Draw2D.width;
            int j2 = Draw2D.height;
            int k2 = Draw2D.left;
            int l2 = Draw2D.right;
            int i3 = Draw2D.top;
            int j3 = Draw2D.bottom;
            Draw3D.aBoolean1421 = false;
            Draw2D.bind(class44_sub3_sub1_sub2_1.pixels, 32, 32);
            Draw2D.method411(0, 210, 0, 32, 0, 32);
            Draw3D.method419((byte) 3);
            int k3 = class14.anInt335;
            if (k == -1) {
                k3 = (int) (k3 * 1.5D);
            }
            if (k > 0) {
                k3 = (int) (k3 * 1.04D);
            }
            int l3 = Draw3D.anIntArray1427[class14.anInt336] * k3 >> 16;
            int i4 = Draw3D.anIntArray1428[class14.anInt336] * k3 >> 16;
            class44_sub3_sub4_sub4.method526(0, class14.anInt337, class14.anInt338, class14.anInt336, class14.anInt339,
                    l3 + class44_sub3_sub4_sub4.anInt1412 / 2 + class14.anInt340, i4
                            + class14.anInt340);
            for (int i5 = 31; i5 >= 0; i5--) {
                for (int j4 = 31; j4 >= 0; j4--) {
                    if (class44_sub3_sub1_sub2_1.pixels[i5 + j4 * 32] == 0) {
                        if (i5 > 0 && class44_sub3_sub1_sub2_1.pixels[(i5 - 1) + j4 * 32] > 1) {
                            class44_sub3_sub1_sub2_1.pixels[i5 + j4 * 32] = 1;
                        } else if (j4 > 0 && class44_sub3_sub1_sub2_1.pixels[i5 + (j4 - 1) * 32] > 1) {
                            class44_sub3_sub1_sub2_1.pixels[i5 + j4 * 32] = 1;
                        } else if (i5 < 31 && class44_sub3_sub1_sub2_1.pixels[i5 + 1 + j4 * 32] > 1) {
                            class44_sub3_sub1_sub2_1.pixels[i5 + j4 * 32] = 1;
                        } else if (j4 < 31 && class44_sub3_sub1_sub2_1.pixels[i5 + (j4 + 1) * 32] > 1) {
                            class44_sub3_sub1_sub2_1.pixels[i5 + j4 * 32] = 1;
                        }
                    }
                }
            }
            if (k > 0) {
                for (int j5 = 31; j5 >= 0; j5--) {
                    for (int k4 = 31; k4 >= 0; k4--) {
                        if (class44_sub3_sub1_sub2_1.pixels[j5 + k4 * 32] == 0) {
                            if (j5 > 0 && class44_sub3_sub1_sub2_1.pixels[(j5 - 1) + k4 * 32] == 1) {
                                class44_sub3_sub1_sub2_1.pixels[j5 + k4 * 32] = k;
                            } else if (k4 > 0 && class44_sub3_sub1_sub2_1.pixels[j5 + (k4 - 1) * 32] == 1) {
                                class44_sub3_sub1_sub2_1.pixels[j5 + k4 * 32] = k;
                            } else if (j5 < 31 && class44_sub3_sub1_sub2_1.pixels[j5 + 1 + k4 * 32] == 1) {
                                class44_sub3_sub1_sub2_1.pixels[j5 + k4 * 32] = k;
                            } else if (k4 < 31 && class44_sub3_sub1_sub2_1.pixels[j5 + (k4 + 1) * 32] == 1) {
                                class44_sub3_sub1_sub2_1.pixels[j5 + k4 * 32] = k;
                            }
                        }
                    }
                }
            } else if (k == 0) {
                for (int k5 = 31; k5 >= 0; k5--) {
                    for (int l4 = 31; l4 >= 0; l4--) {
                        if (class44_sub3_sub1_sub2_1.pixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0
                                && class44_sub3_sub1_sub2_1.pixels[(k5 - 1) + (l4 - 1) * 32] > 0) {
                            class44_sub3_sub1_sub2_1.pixels[k5 + l4 * 32] = 0x302020;
                        }
                    }
                }
            }
            if (class14.anInt362 != -1) {
                int l5 = class44_sub3_sub1_sub2_2.cropWidth;
                int j6 = class44_sub3_sub1_sub2_2.cropHeight;
                class44_sub3_sub1_sub2_2.cropWidth = 32;
                class44_sub3_sub1_sub2_2.cropHeight = 32;
                class44_sub3_sub1_sub2_2.method440(0, ObjType.aByte320, 0);
                class44_sub3_sub1_sub2_2.cropWidth = l5;
                class44_sub3_sub1_sub2_2.cropHeight = j6;
            }
            if (k == 0) {
                ObjType.aClass39_370.method340(j, (byte) 76, class44_sub3_sub1_sub2_1);
            }
            Draw2D.bind(ai1, i2, j2);
            Draw2D.setBounds(l2, j3, i3, k2);
            Draw3D.anInt1423 = k1;
            Draw3D.anInt1424 = l1;
            Draw3D.anIntArray1429 = ai;
            Draw3D.aBoolean1421 = true;
            if (class14.aBoolean342) {
                class44_sub3_sub1_sub2_1.cropWidth = 33;
            } else {
                class44_sub3_sub1_sub2_1.cropWidth = 32;
            }
            class44_sub3_sub1_sub2_1.cropHeight = l;
            if (i <= 0) {
                for (int i6 = 1; i6 > 0; i6++) {
                }
            }
            return class44_sub3_sub1_sub2_1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("85079, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method221() {
        anInt330 = 0;
        aString331 = null;
        aByteArray332 = null;
        anIntArray333 = null;
        anIntArray334 = null;
        anInt335 = 2000;
        anInt336 = 0;
        anInt337 = 0;
        anInt338 = 0;
        anInt339 = 0;
        anInt340 = 0;
        anInt341 = -1;
        aBoolean342 = false;
        anInt343 = 1;
        aBoolean344 = false;
        aStringArray345 = null;
        aStringArray346 = null;
        anInt347 = -1;
        anInt348 = -1;
        aByte349 = 0;
        anInt350 = -1;
        anInt351 = -1;
        aByte352 = 0;
        anInt353 = -1;
        anInt354 = -1;
        anInt355 = -1;
        anInt356 = -1;
        anInt357 = -1;
        anInt358 = -1;
        anIntArray359 = null;
        anIntArray360 = null;
        anInt361 = -1;
        anInt362 = -1;
        anInt363 = 128;
        anInt364 = 128;
        anInt365 = 128;
        anInt366 = 0;
        anInt367 = 0;
        anInt368 = 0;
    }

    public void method222(boolean flag, Buffer class44_sub3_sub2) {
        try {
            if (flag) {
                throw new NullPointerException();
            }
            do {
                int i = class44_sub3_sub2.readUnsignedByte();
                if (i == 0) {
                    return;
                }
                if (i == 1) {
                    anInt330 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 2) {
                    aString331 = class44_sub3_sub2.readString();
                } else if (i == 3) {
                    aByteArray332 = class44_sub3_sub2.method490(anInt317);
                } else if (i == 4) {
                    anInt335 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 5) {
                    anInt336 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 6) {
                    anInt337 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 7) {
                    anInt339 = class44_sub3_sub2.readUnsignedShort();
                    if (anInt339 > 32767) {
                        anInt339 -= 0x10000;
                    }
                } else if (i == 8) {
                    anInt340 = class44_sub3_sub2.readUnsignedShort();
                    if (anInt340 > 32767) {
                        anInt340 -= 0x10000;
                    }
                } else if (i == 10) {
                    anInt341 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 11) {
                    aBoolean342 = true;
                } else if (i == 12) {
                    anInt343 = class44_sub3_sub2.readInt();
                } else if (i == 16) {
                    aBoolean344 = true;
                } else if (i == 23) {
                    anInt347 = class44_sub3_sub2.readUnsignedShort();
                    aByte349 = class44_sub3_sub2.readByte();
                } else if (i == 24) {
                    anInt348 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 25) {
                    anInt350 = class44_sub3_sub2.readUnsignedShort();
                    aByte352 = class44_sub3_sub2.readByte();
                } else if (i == 26) {
                    anInt351 = class44_sub3_sub2.readUnsignedShort();
                } else if (i >= 30 && i < 35) {
                    if (aStringArray345 == null) {
                        aStringArray345 = new String[5];
                    }
                    aStringArray345[i - 30] = class44_sub3_sub2.readString();
                    if (aStringArray345[i - 30].equalsIgnoreCase("hidden")) {
                        aStringArray345[i - 30] = null;
                    }
                } else if (i >= 35 && i < 40) {
                    if (aStringArray346 == null) {
                        aStringArray346 = new String[5];
                    }
                    aStringArray346[i - 35] = class44_sub3_sub2.readString();
                } else if (i == 40) {
                    int j = class44_sub3_sub2.readUnsignedByte();
                    anIntArray333 = new int[j];
                    anIntArray334 = new int[j];
                    for (int k = 0; k < j; k++) {
                        anIntArray333[k] = class44_sub3_sub2.readUnsignedShort();
                        anIntArray334[k] = class44_sub3_sub2.readUnsignedShort();
                    }
                } else if (i == 78) {
                    anInt353 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 79) {
                    anInt354 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 90) {
                    anInt355 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 91) {
                    anInt357 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 92) {
                    anInt356 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 93) {
                    anInt358 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 95) {
                    anInt338 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 97) {
                    anInt361 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 98) {
                    anInt362 = class44_sub3_sub2.readUnsignedShort();
                } else if (i >= 100 && i < 110) {
                    if (anIntArray359 == null) {
                        anIntArray359 = new int[10];
                        anIntArray360 = new int[10];
                    }
                    anIntArray359[i - 100] = class44_sub3_sub2.readUnsignedShort();
                    anIntArray360[i - 100] = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 110) {
                    anInt363 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 111) {
                    anInt364 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 112) {
                    anInt365 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 113) {
                    anInt366 = class44_sub3_sub2.readByte();
                } else if (i == 114) {
                    anInt367 = class44_sub3_sub2.readByte() * 5;
                } else if (i == 115) {
                    anInt368 = class44_sub3_sub2.readUnsignedByte();
                }
            } while (true);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("33855, " + flag + ", " + class44_sub3_sub2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method223(int i) {
        try {
            ObjType class14 = ObjType.method220(anInt362);
            anInt330 = class14.anInt330;
            anInt335 = class14.anInt335;
            anInt336 = class14.anInt336;
            anInt337 = class14.anInt337;
            anInt338 = class14.anInt338;
            anInt339 = class14.anInt339;
            anInt340 = class14.anInt340;
            anIntArray333 = class14.anIntArray333;
            anIntArray334 = class14.anIntArray334;
            ObjType class14_1 = ObjType.method220(anInt361);
            aString331 = class14_1.aString331;
            aBoolean344 = class14_1.aBoolean344;
            anInt343 = class14_1.anInt343;
            String s = "a";
            char c = class14_1.aString331.charAt(0);
            if (i != 6) {
                anInt317 = -375;
            }
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                s = "an";
            }
            aByteArray332 = ("Swap this note at any bank for " + s + " " + class14_1.aString331 + ".").getBytes();
            aBoolean342 = true;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("48619, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Model method224(int i) {
        if (anIntArray359 != null && i > 1) {
            int j = -1;
            for (int k = 0; k < 10; k++) {
                if (i >= anIntArray360[k] && anIntArray360[k] != 0) {
                    j = anIntArray359[k];
                }
            }
            if (j != -1) {
                return ObjType.method220(j).method224(1);
            }
        }
        Model class44_sub3_sub4_sub4 = (Model) ObjType.aClass39_369.method339(anInt329);
        if (class44_sub3_sub4_sub4 != null) {
            return class44_sub3_sub4_sub4;
        }
        class44_sub3_sub4_sub4 = Model.method506(anInt330, aByte318);
        if (class44_sub3_sub4_sub4 == null) {
            return null;
        }
        if (anInt363 != 128 || anInt364 != 128 || anInt365 != 128) {
            class44_sub3_sub4_sub4.method522(anInt363, anInt365, anInt364, (byte) 31);
        }
        if (anIntArray333 != null) {
            for (int l = 0; l < anIntArray333.length; l++) {
                class44_sub3_sub4_sub4.method520(anIntArray333[l], anIntArray334[l]);
            }
        }
        class44_sub3_sub4_sub4.method523(64 + anInt366, 768 + anInt367, -50, -10, -50, true);
        class44_sub3_sub4_sub4.aBoolean1568 = true;
        ObjType.aClass39_369.method340(anInt329, (byte) 76, class44_sub3_sub4_sub4);
        return class44_sub3_sub4_sub4;
    }

    public Model method225(boolean flag, int i) {
        try {
            if (anIntArray359 != null && i > 1) {
                int j = -1;
                for (int k = 0; k < 10; k++) {
                    if (i >= anIntArray360[k] && anIntArray360[k] != 0) {
                        j = anIntArray359[k];
                    }
                }
                if (j != -1) {
                    return ObjType.method220(j).method225(true, 1);
                }
            }
            Model class44_sub3_sub4_sub4 = Model.method506(anInt330, aByte318);
            if (!flag) {
                anInt322 = 243;
            }
            if (class44_sub3_sub4_sub4 == null) {
                return null;
            }
            if (anIntArray333 != null) {
                for (int l = 0; l < anIntArray333.length; l++) {
                    class44_sub3_sub4_sub4.method520(anIntArray333[l], anIntArray334[l]);
                }
            }
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("56792, " + flag + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method227(boolean flag, int i) {
        try {
            int j = anInt347;
            int k = anInt348;
            int l = anInt353;
            if (flag) {
                throw new NullPointerException();
            }
            if (i == 1) {
                j = anInt350;
                k = anInt351;
                l = anInt354;
            }
            if (j == -1) {
                return true;
            }
            boolean flag1 = Model.method507(j);
            if (k != -1 && !Model.method507(k)) {
                flag1 = false;
            }
            if (l != -1 && !Model.method507(l)) {
                flag1 = false;
            }
            return flag1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20483, " + flag + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Model method228(int i, int j) {
        try {
            if (j != 0) {
                throw new NullPointerException();
            }
            int k = anInt347;
            int l = anInt348;
            int i1 = anInt353;
            if (i == 1) {
                k = anInt350;
                l = anInt351;
                i1 = anInt354;
            }
            if (k == -1) {
                return null;
            }
            Model class44_sub3_sub4_sub4 = Model.method506(k, aByte318);
            if (l != -1) {
                if (i1 != -1) {
                    Model class44_sub3_sub4_sub4_1 = Model.method506(l, aByte318);
                    Model class44_sub3_sub4_sub4_3 = Model.method506(i1, aByte318);
                    Model[] aclass44_sub3_sub4_sub4_1 = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_1,
                            class44_sub3_sub4_sub4_3};
                    class44_sub3_sub4_sub4 = new Model(aclass44_sub3_sub4_sub4_1, 3, -33019);
                } else {
                    Model class44_sub3_sub4_sub4_2 = Model.method506(l, aByte318);
                    Model[] aclass44_sub3_sub4_sub4 = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_2};
                    class44_sub3_sub4_sub4 = new Model(aclass44_sub3_sub4_sub4, 2, -33019);
                }
            }
            if (i == 0 && aByte349 != 0) {
                class44_sub3_sub4_sub4.method519(aByte349, 0, (byte) 2, 0);
            }
            if (i == 1 && aByte352 != 0) {
                class44_sub3_sub4_sub4.method519(aByte352, 0, (byte) 2, 0);
            }
            if (anIntArray333 != null) {
                for (int j1 = 0; j1 < anIntArray333.length; j1++) {
                    class44_sub3_sub4_sub4.method520(anIntArray333[j1], anIntArray334[j1]);
                }
            }
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("48423, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method229(boolean flag, int i) {
        try {
            if (!flag) {
                throw new NullPointerException();
            }
            int j = anInt355;
            int k = anInt356;
            if (i == 1) {
                j = anInt357;
                k = anInt358;
            }
            if (j == -1) {
                return true;
            }
            boolean flag1 = Model.method507(j);
            if (k != -1 && !Model.method507(k)) {
                flag1 = false;
            }
            return flag1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("33754, " + flag + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Model method230(int i, int j) {
        try {
            i = 52 / i;
            int k = anInt355;
            int l = anInt356;
            if (j == 1) {
                k = anInt357;
                l = anInt358;
            }
            if (k == -1) {
                return null;
            }
            Model class44_sub3_sub4_sub4 = Model.method506(k, aByte318);
            if (l != -1) {
                Model class44_sub3_sub4_sub4_1 = Model.method506(l, aByte318);
                Model[] aclass44_sub3_sub4_sub4 = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_1};
                class44_sub3_sub4_sub4 = new Model(aclass44_sub3_sub4_sub4, 2, -33019);
            }
            if (anIntArray333 != null) {
                for (int i1 = 0; i1 < anIntArray333.length; i1++) {
                    class44_sub3_sub4_sub4.method520(anIntArray333[i1], anIntArray334[i1]);
                }
            }
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("35633, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

}

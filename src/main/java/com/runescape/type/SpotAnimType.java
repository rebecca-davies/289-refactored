package com.runescape.type;

import com.runescape.cache.FileArchive;
import com.runescape.collection.Cache;
import com.runescape.graphic.Model;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class SpotAnimType {

    public static int anInt558;
    public static SpotAnimType[] cache;
    public static Cache aClass39_571 = new Cache((byte) 7, 30);
    public boolean aBoolean556;
    public byte aByte557;
    public int anInt560;
    public int anInt561;
    public int anInt562;
    public SeqType aClass26_563;
    public int[] anIntArray564;
    public int[] anIntArray565;
    public int anInt566;
    public int anInt567;
    public int anInt568;
    public int anInt569;
    public int anInt570;

    public SpotAnimType() {
        aBoolean556 = false;
        aByte557 = 4;
        anInt562 = -1;
        anIntArray564 = new int[6];
        anIntArray565 = new int[6];
        anInt566 = 128;
        anInt567 = 128;
    }

    public static void method269(boolean flag, FileArchive class47) {
        try {
            Buffer class44_sub3_sub2 = new Buffer(class47.method549("spotanim.dat", null));
            SpotAnimType.anInt558 = class44_sub3_sub2.readUnsignedShort();
            if (!flag) {
                return;
            }
            if (SpotAnimType.cache == null) {
                SpotAnimType.cache = new SpotAnimType[SpotAnimType.anInt558];
            }
            for (int i = 0; i < SpotAnimType.anInt558; i++) {
                if (SpotAnimType.cache[i] == null) {
                    SpotAnimType.cache[i] = new SpotAnimType();
                }
                SpotAnimType.cache[i].anInt560 = i;
                SpotAnimType.cache[i].method270(false, class44_sub3_sub2);
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("58052, " + flag + ", " + class47 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method270(boolean flag, Buffer class44_sub3_sub2) {
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
                    anInt561 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 2) {
                    anInt562 = class44_sub3_sub2.readUnsignedShort();
                    if (SeqType.cache != null) {
                        aClass26_563 = SeqType.cache[anInt562];
                    }
                } else if (i == 4) {
                    anInt566 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 5) {
                    anInt567 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 6) {
                    anInt568 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 7) {
                    anInt569 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 8) {
                    anInt570 = class44_sub3_sub2.readUnsignedByte();
                } else if (i >= 40 && i < 50) {
                    anIntArray564[i - 40] = class44_sub3_sub2.readUnsignedShort();
                } else if (i >= 50 && i < 60) {
                    anIntArray565[i - 50] = class44_sub3_sub2.readUnsignedShort();
                } else {
                    System.out.println("Error unrecognised spotanim config code: " + i);
                }
            } while (true);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("87905, " + flag + ", " + class44_sub3_sub2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Model method271() {
        Model class44_sub3_sub4_sub4 = (Model) SpotAnimType.aClass39_571.method339(anInt560);
        if (class44_sub3_sub4_sub4 != null) {
            return class44_sub3_sub4_sub4;
        }
        class44_sub3_sub4_sub4 = Model.method506(anInt561, aByte557);
        if (class44_sub3_sub4_sub4 == null) {
            return null;
        }
        for (int i = 0; i < 6; i++) {
            if (anIntArray564[0] != 0) {
                class44_sub3_sub4_sub4.method520(anIntArray564[i], anIntArray565[i]);
            }
        }
        SpotAnimType.aClass39_571.method340(anInt560, (byte) 76, class44_sub3_sub4_sub4);
        return class44_sub3_sub4_sub4;
    }

}

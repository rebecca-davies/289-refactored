package com.runescape.type;

import com.runescape.cache.FileArchive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class VarpType {

    public static boolean aBoolean671 = true;
    public static int anInt672 = 810;
    public static int anInt673;
    public static VarpType[] cache;
    public static int anInt675;
    public static int[] anIntArray676;
    public int anInt670;
    public String aString677;
    public int anInt678;
    public int anInt679;
    public boolean aBoolean680;
    public boolean aBoolean681;
    public int anInt682;
    public boolean aBoolean683;
    public int anInt684;
    public int anInt685;
    public boolean aBoolean686;
    public int anInt687;

    public VarpType() {
        anInt670 = -550;
        aBoolean680 = false;
        aBoolean681 = true;
        aBoolean683 = false;
        aBoolean686 = false;
        anInt687 = -1;
    }

    public static void method337(boolean flag, FileArchive class47) {
        try {
            if (!flag) {
                VarpType.aBoolean671 = !VarpType.aBoolean671;
            }
            Buffer class44_sub3_sub2 = new Buffer(class47.method549("varp.dat", null));
            VarpType.anInt675 = 0;
            VarpType.anInt673 = class44_sub3_sub2.readUnsignedShort();
            if (VarpType.cache == null) {
                VarpType.cache = new VarpType[VarpType.anInt673];
            }
            if (VarpType.anIntArray676 == null) {
                VarpType.anIntArray676 = new int[VarpType.anInt673];
            }
            for (int i = 0; i < VarpType.anInt673; i++) {
                if (VarpType.cache[i] == null) {
                    VarpType.cache[i] = new VarpType();
                }
                VarpType.cache[i].method338(VarpType.anInt672, i, class44_sub3_sub2);
            }
            if (class44_sub3_sub2.position != class44_sub3_sub2.payload.length) {
                System.out.println("varptype load mismatch");
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("51793, " + flag + ", " + class47 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method338(int i, int j, Buffer class44_sub3_sub2) {
        try {
            if (i <= 0) {
                anInt670 = 68;
            }
            do {
                int k = class44_sub3_sub2.readUnsignedByte();
                if (k == 0) {
                    return;
                }
                if (k == 1) {
                    anInt678 = class44_sub3_sub2.readUnsignedByte();
                } else if (k == 2) {
                    anInt679 = class44_sub3_sub2.readUnsignedByte();
                } else if (k == 3) {
                    aBoolean680 = true;
                    VarpType.anIntArray676[VarpType.anInt675++] = j;
                } else if (k == 4) {
                    aBoolean681 = false;
                } else if (k == 5) {
                    anInt682 = class44_sub3_sub2.readUnsignedShort();
                } else if (k == 6) {
                    aBoolean683 = true;
                } else if (k == 7) {
                    anInt684 = class44_sub3_sub2.readInt();
                } else if (k == 8) {
                    anInt685 = 1;
                    aBoolean686 = true;
                } else if (k == 10) {
                    aString677 = class44_sub3_sub2.readString();
                } else if (k == 11) {
                    aBoolean686 = true;
                } else if (k == 12) {
                    anInt687 = class44_sub3_sub2.readInt();
                } else if (k == 13) {
                    anInt685 = 2;
                } else {
                    System.out.println("Error unrecognised config code: " + k);
                }
            } while (true);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("69668, " + i + ", " + j + ", " + class44_sub3_sub2 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

}

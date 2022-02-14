package com.runescape.type;

import com.runescape.cache.FileArchive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class VarBit {

    public static int anInt588 = 810;
    public static int anInt589;
    public static VarBit[] aClass35Array590;
    public String aString591;
    public int anInt592;
    public int anInt593;
    public int anInt594;
    public boolean aBoolean595;
    public int anInt596;
    public int anInt597;

    public VarBit() {
        aBoolean595 = false;
        anInt596 = -1;
    }

    public static void unpack(FileArchive class47) {
            Buffer class44_sub3_sub2 = new Buffer(class47.read("varbit.dat"));
            VarBit.anInt589 = class44_sub3_sub2.readUnsignedShort();
            if (VarBit.aClass35Array590 == null) {
                VarBit.aClass35Array590 = new VarBit[VarBit.anInt589];
            }
            for (int i = 0; i < VarBit.anInt589; i++) {
                if (VarBit.aClass35Array590[i] == null) {
                    VarBit.aClass35Array590[i] = new VarBit();
                }
                VarBit.aClass35Array590[i].method276(VarBit.anInt588, i, class44_sub3_sub2);
                if (VarBit.aClass35Array590[i].aBoolean595) {
                    VarpType.cache[VarBit.aClass35Array590[i].anInt592].aBoolean686 = true;
                }
            }
            if (class44_sub3_sub2.position != class44_sub3_sub2.payload.length) {
                System.out.println("varbit load mismatch");
            }
    }

    public void method276(int i, int j, Buffer class44_sub3_sub2) {
        try {
            i = 55 / i;
            do {
                int k = class44_sub3_sub2.readUnsignedByte();
                if (k == 0) {
                    return;
                }
                if (k == 1) {
                    anInt592 = class44_sub3_sub2.readUnsignedShort();
                    anInt593 = class44_sub3_sub2.readUnsignedByte();
                    anInt594 = class44_sub3_sub2.readUnsignedByte();
                } else if (k == 10) {
                    aString591 = class44_sub3_sub2.readString();
                } else if (k == 2) {
                    aBoolean595 = true;
                } else if (k == 3) {
                    anInt596 = class44_sub3_sub2.readInt();
                } else if (k == 4) {
                    anInt597 = class44_sub3_sub2.readInt();
                } else {
                    System.out.println("Error unrecognised config code: " + k);
                }
            } while (true);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("19355, " + i + ", " + j + ", " + class44_sub3_sub2 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

}

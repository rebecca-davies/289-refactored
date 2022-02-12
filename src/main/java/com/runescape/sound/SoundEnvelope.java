package com.runescape.sound;

import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class SoundEnvelope {

    public static int anInt49;
    public boolean aBoolean37;
    public int anInt38;
    public int[] anIntArray39;
    public int[] anIntArray40;
    public int anInt41;
    public int anInt42;
    public int anInt43;
    public int anInt44;
    public int anInt45;
    public int anInt46;
    public int anInt47;
    public int anInt48;

    public SoundEnvelope() {
        aBoolean37 = false;
    }

    public void method148(boolean flag, Buffer buffer) {
        try {
            anInt43 = buffer.readUnsignedByte();
            anInt41 = buffer.readInt();
            anInt42 = buffer.readInt();
            if (flag) {
                for (int i = 1; i > 0; i++) {
                }
            }
            method149(0, buffer);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("71989, " + flag + ", " + buffer + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method149(int i, Buffer class44_sub3_sub2) {
        try {
            if (i != 0) {
                return;
            }
            anInt38 = class44_sub3_sub2.readUnsignedByte();
            anIntArray39 = new int[anInt38];
            anIntArray40 = new int[anInt38];
            for (int j = 0; j < anInt38; j++) {
                anIntArray39[j] = class44_sub3_sub2.readUnsignedShort();
                anIntArray40[j] = class44_sub3_sub2.readUnsignedShort();
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90209, " + i + ", " + class44_sub3_sub2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method150(int i) {
        try {
            anInt44 = 0;
            anInt45 = 0;
            anInt46 = 0;
            anInt47 = 0;
            if (i != -9520) {
                aBoolean37 = !aBoolean37;
            }
            anInt48 = 0;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("93961, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int method151(int i, int j) {
        try {
            if (anInt48 >= anInt44) {
                anInt47 = anIntArray40[anInt45++] << 15;
                if (anInt45 >= anInt38) {
                    anInt45 = anInt38 - 1;
                }
                anInt44 = (int) ((anIntArray39[anInt45] / 65536D) * j);
                if (anInt44 > anInt48) {
                    anInt46 = ((anIntArray40[anInt45] << 15) - anInt47) / (anInt44 - anInt48);
                }
            }
            anInt47 += anInt46;
            anInt48++;
            if (i != 0) {
                for (int k = 1; k > 0; k++) {
                }
            }
            return anInt47 - anInt46 >> 15;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("76406, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }
}

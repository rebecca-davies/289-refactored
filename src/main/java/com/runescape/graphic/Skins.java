package com.runescape.graphic;

import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class Skins {

    public int anInt253;
    public int[] anIntArray254;
    public int[][] anIntArrayArray255;

    public Skins(Buffer buffer, int i) {
        try {
            anInt253 = buffer.readUnsignedByte();
            anIntArray254 = new int[anInt253];
            if (i != 0) {
                throw new NullPointerException();
            }
            anIntArrayArray255 = new int[anInt253][];
            for (int j = 0; j < anInt253; j++) {
                anIntArray254[j] = buffer.readUnsignedByte();
            }
            for (int k = 0; k < anInt253; k++) {
                int l = buffer.readUnsignedByte();
                anIntArrayArray255[k] = new int[l];
                for (int i1 = 0; i1 < l; i1++) {
                    anIntArrayArray255[k][i1] = buffer.readUnsignedByte();
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27585, " + buffer + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }
}

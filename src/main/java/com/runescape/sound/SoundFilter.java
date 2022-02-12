package com.runescape.sound;

import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class SoundFilter {

    public static float aFloatArrayArray56[][] = new float[2][8];
    public static int anIntArrayArray57[][] = new int[2][8];
    public static float aFloat58;
    public static int anInt59;
    public boolean aBoolean50;
    public int anInt51;
    public int anIntArray52[];
    public int anIntArrayArrayArray53[][][];
    public int anIntArrayArrayArray54[][][];
    public int anIntArray55[];

    public SoundFilter() {
        aBoolean50 = false;
        anInt51 = 2972;
        anIntArray52 = new int[2];
        anIntArrayArrayArray53 = new int[2][2][4];
        anIntArrayArrayArray54 = new int[2][2][4];
        anIntArray55 = new int[2];
    }

    public float method152(int i, boolean flag, float f, int j) {
        try {
            float f1 = anIntArrayArrayArray54[j][0][i] + f
                    * (anIntArrayArrayArray54[j][1][i] - anIntArrayArrayArray54[j][0][i]);
            f1 *= 0.001525879F;
            if (!flag) {
                for (int k = 1; k > 0; k++) {
                }
            }
            return 1.0F - (float) Math.pow(10D, -f1 / 20F);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("9156, " + i + ", " + flag + ", " + f + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public float method153(int i, float f) {
        try {
            if (i != 2972) {
                throw new NullPointerException();
            } else {
                float f1 = 32.7032F * (float) Math.pow(2D, f);
                return (f1 * 3.141593F) / 11025F;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("10683, " + i + ", " + f + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public float method154(int i, int j, int k, float f) {
        try {
            float f1 = anIntArrayArrayArray53[i][0][j] + f
                    * (anIntArrayArrayArray53[i][1][j] - anIntArrayArrayArray53[i][0][j]);
            f1 *= 0.0001220703F;
            if (k != 9) {
                for (int l = 1; l > 0; l++) {
                }
            }
            return method153(anInt51, f1);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("38617, " + i + ", " + j + ", " + k + ", " + f + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int method155(int i, int j, float f) {
        try {
            if (i == 0) {
                float f1 = anIntArray55[0] + (anIntArray55[1] - anIntArray55[0]) * f;
                f1 *= 0.003051758F;
                SoundFilter.aFloat58 = (float) Math.pow(0.10000000000000001D, f1 / 20F);
                SoundFilter.anInt59 = (int) (SoundFilter.aFloat58 * 65536F);
            }
            if (anIntArray52[i] == 0) {
                return 0;
            }
            float f2 = method152(0, true, f, i);
            SoundFilter.aFloatArrayArray56[i][0] = -2F * f2 * (float) Math.cos(method154(i, 0, 9, f));
            if (j != 0) {
                aBoolean50 = !aBoolean50;
            }
            SoundFilter.aFloatArrayArray56[i][1] = f2 * f2;
            for (int k = 1; k < anIntArray52[i]; k++) {
                float f3 = method152(k, true, f, i);
                float f4 = -2F * f3 * (float) Math.cos(method154(i, k, 9, f));
                float f5 = f3 * f3;
                SoundFilter.aFloatArrayArray56[i][k * 2 + 1] = SoundFilter.aFloatArrayArray56[i][k * 2 - 1] * f5;
                SoundFilter.aFloatArrayArray56[i][k * 2] = SoundFilter.aFloatArrayArray56[i][k * 2 - 1] * f4
                        + SoundFilter.aFloatArrayArray56[i][k * 2 - 2] * f5;
                for (int j1 = k * 2 - 1; j1 >= 2; j1--) {
                    SoundFilter.aFloatArrayArray56[i][j1] += SoundFilter.aFloatArrayArray56[i][j1 - 1] * f4
                            + SoundFilter.aFloatArrayArray56[i][j1 - 2] * f5;
                }
                SoundFilter.aFloatArrayArray56[i][1] += SoundFilter.aFloatArrayArray56[i][0] * f4 + f5;
                SoundFilter.aFloatArrayArray56[i][0] += f4;
            }
            if (i == 0) {
                for (int l = 0; l < anIntArray52[0] * 2; l++) {
                    SoundFilter.aFloatArrayArray56[0][l] *= SoundFilter.aFloat58;
                }
            }
            for (int i1 = 0; i1 < anIntArray52[i] * 2; i1++) {
                SoundFilter.anIntArrayArray57[i][i1] = (int) (SoundFilter.aFloatArrayArray56[i][i1] * 65536F);
            }
            return anIntArray52[i] * 2;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("1468, " + i + ", " + j + ", " + f + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method156(int i, SoundEnvelope class1, Buffer class44_sub3_sub2) {
        try {
            if (i <= 0) {
                for (int j = 1; j > 0; j++) {
                }
            }
            int k = class44_sub3_sub2.readUnsignedByte();
            anIntArray52[0] = k >> 4;
            anIntArray52[1] = k & 0xf;
            if (k != 0) {
                anIntArray55[0] = class44_sub3_sub2.readUnsignedShort();
                anIntArray55[1] = class44_sub3_sub2.readUnsignedShort();
                int l = class44_sub3_sub2.readUnsignedByte();
                for (int i1 = 0; i1 < 2; i1++) {
                    for (int j1 = 0; j1 < anIntArray52[i1]; j1++) {
                        anIntArrayArrayArray53[i1][0][j1] = class44_sub3_sub2.readUnsignedShort();
                        anIntArrayArrayArray54[i1][0][j1] = class44_sub3_sub2.readUnsignedShort();
                    }
                }
                for (int k1 = 0; k1 < 2; k1++) {
                    for (int l1 = 0; l1 < anIntArray52[k1]; l1++) {
                        if ((l & 1 << k1 * 4 << l1) != 0) {
                            anIntArrayArrayArray53[k1][1][l1] = class44_sub3_sub2.readUnsignedShort();
                            anIntArrayArrayArray54[k1][1][l1] = class44_sub3_sub2.readUnsignedShort();
                        } else {
                            anIntArrayArrayArray53[k1][1][l1] = anIntArrayArrayArray53[k1][0][l1];
                            anIntArrayArrayArray54[k1][1][l1] = anIntArrayArrayArray54[k1][0][l1];
                        }
                    }
                }
                if (l != 0 || anIntArray55[1] != anIntArray55[0]) {
                    class1.method149(0, class44_sub3_sub2);
                }
                return;
            } else {
                anIntArray55[0] = anIntArray55[1] = 0;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("9723, " + i + ", " + class1 + ", " + class44_sub3_sub2 + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

}

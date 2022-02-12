package com.runescape.sound;

import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class SoundTone {

    public static int[] anIntArray184;
    public static int[] anIntArray185;
    public static int[] anIntArray186;
    public static int[] anIntArray187 = new int[5];
    public static int[] anIntArray188 = new int[5];
    public static int[] anIntArray189 = new int[5];
    public static int[] anIntArray190 = new int[5];
    public static int[] anIntArray191 = new int[5];
    public boolean aBoolean164;
    public int anInt165;
    public int anInt166;
    public SoundEnvelope aClass1_167;
    public SoundEnvelope aClass1_168;
    public SoundEnvelope aClass1_169;
    public SoundEnvelope aClass1_170;
    public SoundEnvelope aClass1_171;
    public SoundEnvelope aClass1_172;
    public SoundEnvelope aClass1_173;
    public SoundEnvelope aClass1_174;
    public int[] anIntArray175;
    public int[] anIntArray176;
    public int[] anIntArray177;
    public int anInt178;
    public int anInt179;
    public SoundFilter aClass2_180;
    public SoundEnvelope aClass1_181;
    public int anInt182;
    public int anInt183;

    public SoundTone() {
        aBoolean164 = false;
        anInt165 = 188;
        anInt166 = 810;
        anIntArray175 = new int[5];
        anIntArray176 = new int[5];
        anIntArray177 = new int[5];
        anInt179 = 100;
        anInt182 = 500;
    }

    public static void method187() {
        SoundTone.anIntArray185 = new int[32768];
        for (int i = 0; i < 32768; i++) {
            if (Math.random() > 0.5D) {
                SoundTone.anIntArray185[i] = 1;
            } else {
                SoundTone.anIntArray185[i] = -1;
            }
        }
        SoundTone.anIntArray186 = new int[32768];
        for (int j = 0; j < 32768; j++) {
            SoundTone.anIntArray186[j] = (int) (Math.sin(j / 5215.1903000000002D) * 16384D);
        }
        SoundTone.anIntArray184 = new int[0x35d54];
    }

    public int[] method188(int i, int j) {
        for (int k = 0; k < i; k++) {
            SoundTone.anIntArray184[k] = 0;
        }
        if (j < 10) {
            return SoundTone.anIntArray184;
        }
        double d = i / (j + 0.0D);
        aClass1_167.method150(-9520);
        aClass1_168.method150(-9520);
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        if (aClass1_169 != null) {
            aClass1_169.method150(-9520);
            aClass1_170.method150(-9520);
            l = (int) (((aClass1_169.anInt42 - aClass1_169.anInt41) * 32.768000000000001D) / d);
            i1 = (int) ((aClass1_169.anInt41 * 32.768000000000001D) / d);
        }
        int k1 = 0;
        int l1 = 0;
        int i2 = 0;
        if (aClass1_171 != null) {
            aClass1_171.method150(-9520);
            aClass1_172.method150(-9520);
            k1 = (int) (((aClass1_171.anInt42 - aClass1_171.anInt41) * 32.768000000000001D) / d);
            l1 = (int) ((aClass1_171.anInt41 * 32.768000000000001D) / d);
        }
        for (int j2 = 0; j2 < 5; j2++) {
            if (anIntArray175[j2] != 0) {
                SoundTone.anIntArray187[j2] = 0;
                SoundTone.anIntArray188[j2] = (int) (anIntArray177[j2] * d);
                SoundTone.anIntArray189[j2] = (anIntArray175[j2] << 14) / 100;
                SoundTone.anIntArray190[j2] = (int) (((aClass1_167.anInt42 - aClass1_167.anInt41) * 32.768000000000001D * Math
                        .pow(1.0057929410678534D, anIntArray176[j2])) / d);
                SoundTone.anIntArray191[j2] = (int) ((aClass1_167.anInt41 * 32.768000000000001D) / d);
            }
        }
        for (int k2 = 0; k2 < i; k2++) {
            int l2 = aClass1_167.method151(0, i);
            int j4 = aClass1_168.method151(0, i);
            if (aClass1_169 != null) {
                int j5 = aClass1_169.method151(0, i);
                int j6 = aClass1_170.method151(0, i);
                l2 += method189(j6, 0, j1, aClass1_169.anInt43) >> 1;
                j1 += (j5 * l >> 16) + i1;
            }
            if (aClass1_171 != null) {
                int k5 = aClass1_171.method151(0, i);
                int k6 = aClass1_172.method151(0, i);
                j4 = j4 * ((method189(k6, 0, i2, aClass1_171.anInt43) >> 1) + 32768) >> 15;
                i2 += (k5 * k1 >> 16) + l1;
            }
            for (int l5 = 0; l5 < 5; l5++) {
                if (anIntArray175[l5] != 0) {
                    int l6 = k2 + SoundTone.anIntArray188[l5];
                    if (l6 < i) {
                        SoundTone.anIntArray184[l6] += method189(
                                j4 * SoundTone.anIntArray189[l5] >> 15, 0,
                                SoundTone.anIntArray187[l5], aClass1_167.anInt43);
                        SoundTone.anIntArray187[l5] += (l2 * SoundTone.anIntArray190[l5] >> 16)
                                + SoundTone.anIntArray191[l5];
                    }
                }
            }
        }
        if (aClass1_173 != null) {
            aClass1_173.method150(-9520);
            aClass1_174.method150(-9520);
            int i3 = 0;
            boolean flag1 = true;
            for (int i7 = 0; i7 < i; i7++) {
                int k7 = aClass1_173.method151(0, i);
                int i8 = aClass1_174.method151(0, i);
                int k4;
                if (flag1) {
                    k4 = aClass1_173.anInt41 + ((aClass1_173.anInt42 - aClass1_173.anInt41) * k7 >> 8);
                } else {
                    k4 = aClass1_173.anInt41 + ((aClass1_173.anInt42 - aClass1_173.anInt41) * i8 >> 8);
                }
                if ((i3 += 256) >= k4) {
                    i3 = 0;
                    flag1 = !flag1;
                }
                if (flag1) {
                    SoundTone.anIntArray184[i7] = 0;
                }
            }
        }
        if (anInt178 > 0 && anInt179 > 0) {
            int j3 = (int) (anInt178 * d);
            for (int l4 = j3; l4 < i; l4++) {
                SoundTone.anIntArray184[l4] += (SoundTone.anIntArray184[l4 - j3] * anInt179) / 100;
            }
        }
        if (aClass2_180.anIntArray52[0] > 0 || aClass2_180.anIntArray52[1] > 0) {
            aClass1_181.method150(-9520);
            int k3 = aClass1_181.method151(0, i + 1);
            int i5 = aClass2_180.method155(0, 0, k3 / 65536F);
            int i6 = aClass2_180.method155(1, 0, k3 / 65536F);
            if (i >= i5 + i6) {
                int j7 = 0;
                int l7 = i6;
                if (l7 > i - i5) {
                    l7 = i - i5;
                }
                for (; j7 < l7; j7++) {
                    int j8 = (int) ((long) SoundTone.anIntArray184[j7 + i5] * (long) SoundFilter.anInt59 >> 16);
                    for (int k8 = 0; k8 < i5; k8++) {
                        j8 += (int) ((long) SoundTone.anIntArray184[(j7 + i5) - 1 - k8]
                                * (long) SoundFilter.anIntArrayArray57[0][k8] >> 16);
                    }
                    for (int j9 = 0; j9 < j7; j9++) {
                        j8 -= (int) ((long) SoundTone.anIntArray184[j7 - 1 - j9]
                                * (long) SoundFilter.anIntArrayArray57[1][j9] >> 16);
                    }
                    SoundTone.anIntArray184[j7] = j8;
                    k3 = aClass1_181.method151(0, i + 1);
                }
                char c = '\200';
                l7 = c;
                do {
                    if (l7 > i - i5) {
                        l7 = i - i5;
                    }
                    for (; j7 < l7; j7++) {
                        int l8 = (int) ((long) SoundTone.anIntArray184[j7 + i5] * (long) SoundFilter.anInt59 >> 16);
                        for (int k9 = 0; k9 < i5; k9++) {
                            l8 += (int) ((long) SoundTone.anIntArray184[(j7 + i5) - 1 - k9]
                                    * (long) SoundFilter.anIntArrayArray57[0][k9] >> 16);
                        }
                        for (int i10 = 0; i10 < i6; i10++) {
                            l8 -= (int) ((long) SoundTone.anIntArray184[j7 - 1 - i10]
                                    * (long) SoundFilter.anIntArrayArray57[1][i10] >> 16);
                        }
                        SoundTone.anIntArray184[j7] = l8;
                        k3 = aClass1_181.method151(0, i + 1);
                    }
                    if (j7 >= i - i5) {
                        break;
                    }
                    i5 = aClass2_180.method155(0, 0, k3 / 65536F);
                    i6 = aClass2_180.method155(1, 0, k3 / 65536F);
                    l7 += c;
                } while (true);
                for (; j7 < i; j7++) {
                    int i9 = 0;
                    for (int l9 = (j7 + i5) - i; l9 < i5; l9++) {
                        i9 += (int) ((long) SoundTone.anIntArray184[(j7 + i5) - 1 - l9]
                                * (long) SoundFilter.anIntArrayArray57[0][l9] >> 16);
                    }
                    for (int j10 = 0; j10 < i6; j10++) {
                        i9 -= (int) ((long) SoundTone.anIntArray184[j7 - 1 - j10]
                                * (long) SoundFilter.anIntArrayArray57[1][j10] >> 16);
                    }
                    SoundTone.anIntArray184[j7] = i9;
                    aClass1_181.method151(0, i + 1);
                }
            }
        }
        for (int i4 = 0; i4 < i; i4++) {
            if (SoundTone.anIntArray184[i4] < -32768) {
                SoundTone.anIntArray184[i4] = -32768;
            }
            if (SoundTone.anIntArray184[i4] > 32767) {
                SoundTone.anIntArray184[i4] = 32767;
            }
        }
        return SoundTone.anIntArray184;
    }

    public int method189(int i, int j, int k, int l) {
        try {
            if (j != 0) {
                anInt165 = 302;
            }
            if (l == 1) {
                if ((k & 0x7fff) < 16384) {
                    return i;
                } else {
                    return -i;
                }
            }
            if (l == 2) {
                return SoundTone.anIntArray186[k & 0x7fff] * i >> 14;
            }
            if (l == 3) {
                return ((k & 0x7fff) * i >> 14) - i;
            }
            if (l == 4) {
                return SoundTone.anIntArray185[k / 2607 & 0x7fff] * i;
            } else {
                return 0;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("32871, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method190(boolean flag, Buffer class44_sub3_sub2) {
        try {
            if (flag) {
                throw new NullPointerException();
            }
            aClass1_167 = new SoundEnvelope();
            aClass1_167.method148(false, class44_sub3_sub2);
            aClass1_168 = new SoundEnvelope();
            aClass1_168.method148(false, class44_sub3_sub2);
            int i = class44_sub3_sub2.readUnsignedByte();
            if (i != 0) {
                class44_sub3_sub2.position--;
                aClass1_169 = new SoundEnvelope();
                aClass1_169.method148(false, class44_sub3_sub2);
                aClass1_170 = new SoundEnvelope();
                aClass1_170.method148(false, class44_sub3_sub2);
            }
            i = class44_sub3_sub2.readUnsignedByte();
            if (i != 0) {
                class44_sub3_sub2.position--;
                aClass1_171 = new SoundEnvelope();
                aClass1_171.method148(false, class44_sub3_sub2);
                aClass1_172 = new SoundEnvelope();
                aClass1_172.method148(false, class44_sub3_sub2);
            }
            i = class44_sub3_sub2.readUnsignedByte();
            if (i != 0) {
                class44_sub3_sub2.position--;
                aClass1_173 = new SoundEnvelope();
                aClass1_173.method148(false, class44_sub3_sub2);
                aClass1_174 = new SoundEnvelope();
                aClass1_174.method148(false, class44_sub3_sub2);
            }
            for (int j = 0; j < 10; j++) {
                int k = class44_sub3_sub2.method496();
                if (k == 0) {
                    break;
                }
                anIntArray175[j] = k;
                anIntArray176[j] = class44_sub3_sub2.method495();
                anIntArray177[j] = class44_sub3_sub2.method496();
            }
            anInt178 = class44_sub3_sub2.method496();
            anInt179 = class44_sub3_sub2.method496();
            anInt182 = class44_sub3_sub2.readUnsignedShort();
            anInt183 = class44_sub3_sub2.readUnsignedShort();
            aClass2_180 = new SoundFilter();
            aClass1_181 = new SoundEnvelope();
            aClass2_180.method156(anInt166, aClass1_181, class44_sub3_sub2);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("77565, " + flag + ", " + class44_sub3_sub2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

}

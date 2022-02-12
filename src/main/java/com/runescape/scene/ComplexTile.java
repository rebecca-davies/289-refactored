package com.runescape.scene;

import com.runescape.util.SignLink;

public class ComplexTile {

    public static int anIntArray387[] = new int[6];
    public static int anIntArray388[] = new int[6];
    public static int anIntArray389[] = new int[6];
    public static int anIntArray390[] = new int[6];
    public static int anIntArray391[] = new int[6];
    public static int anIntArray392[] = {1, 0};
    public static int anIntArray393[] = {2, 1};
    public static int anIntArray394[] = {3, 3};
    public static int anIntArrayArray395[][] = {{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6},
            {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8},
            {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};
    public static int anIntArrayArray396[][] = {{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3},
            {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4},
            {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3},
            {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5},
            {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5},
            {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3},
            {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3},
            {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};
    public boolean aBoolean371;
    public int anIntArray372[];
    public int anIntArray373[];
    public int anIntArray374[];
    public int anIntArray375[];
    public int anIntArray376[];
    public int anIntArray377[];
    public int anIntArray378[];
    public int anIntArray379[];
    public int anIntArray380[];
    public int anIntArray381[];
    public boolean aBoolean382;
    public int anInt383;
    public int anInt384;
    public int anInt385;
    public int anInt386;

    public ComplexTile(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2,
                       int i3, int j3, int k3, int l3, int i4, int j4, int k4, int l4) {
        aBoolean371 = false;
        aBoolean382 = true;
        try {
            if (i2 != j || i2 != l4 || i2 != k2) {
                aBoolean382 = false;
            }
            anInt383 = j4;
            anInt384 = k3;
            anInt385 = l1;
            anInt386 = j1;
            char c = '\200';
            int i5 = c / 2;
            int j5 = c / 4;
            int k5 = (c * 3) / 4;
            int ai[] = ComplexTile.anIntArrayArray395[j4];
            int l5 = ai.length;
            anIntArray372 = new int[l5];
            anIntArray373 = new int[l5];
            anIntArray374 = new int[l5];
            int ai1[] = new int[l5];
            int ai2[] = new int[l5];
            int i6 = k * c;
            int j6 = i4 * c;
            if (j3 <= 0) {
                aBoolean371 = !aBoolean371;
            }
            for (int k6 = 0; k6 < l5; k6++) {
                int l6 = ai[k6];
                if ((l6 & 1) == 0 && l6 <= 8) {
                    l6 = (l6 - k3 - k3 - 1 & 7) + 1;
                }
                if (l6 > 8 && l6 <= 12) {
                    l6 = (l6 - 9 - k3 & 3) + 9;
                }
                if (l6 > 12 && l6 <= 16) {
                    l6 = (l6 - 13 - k3 & 3) + 13;
                }
                int i7;
                int k7;
                int i8;
                int k8;
                int j9;
                if (l6 == 1) {
                    i7 = i6;
                    k7 = j6;
                    i8 = i2;
                    k8 = l;
                    j9 = i;
                } else if (l6 == 2) {
                    i7 = i6 + i5;
                    k7 = j6;
                    i8 = i2 + j >> 1;
                    k8 = l + k4 >> 1;
                    j9 = i + l2 >> 1;
                } else if (l6 == 3) {
                    i7 = i6 + c;
                    k7 = j6;
                    i8 = j;
                    k8 = k4;
                    j9 = l2;
                } else if (l6 == 4) {
                    i7 = i6 + c;
                    k7 = j6 + i5;
                    i8 = j + l4 >> 1;
                    k8 = k4 + k1 >> 1;
                    j9 = l2 + l3 >> 1;
                } else if (l6 == 5) {
                    i7 = i6 + c;
                    k7 = j6 + c;
                    i8 = l4;
                    k8 = k1;
                    j9 = l3;
                } else if (l6 == 6) {
                    i7 = i6 + i5;
                    k7 = j6 + c;
                    i8 = l4 + k2 >> 1;
                    k8 = k1 + i1 >> 1;
                    j9 = l3 + i3 >> 1;
                } else if (l6 == 7) {
                    i7 = i6;
                    k7 = j6 + c;
                    i8 = k2;
                    k8 = i1;
                    j9 = i3;
                } else if (l6 == 8) {
                    i7 = i6;
                    k7 = j6 + i5;
                    i8 = k2 + i2 >> 1;
                    k8 = i1 + l >> 1;
                    j9 = i3 + i >> 1;
                } else if (l6 == 9) {
                    i7 = i6 + i5;
                    k7 = j6 + j5;
                    i8 = i2 + j >> 1;
                    k8 = l + k4 >> 1;
                    j9 = i + l2 >> 1;
                } else if (l6 == 10) {
                    i7 = i6 + k5;
                    k7 = j6 + i5;
                    i8 = j + l4 >> 1;
                    k8 = k4 + k1 >> 1;
                    j9 = l2 + l3 >> 1;
                } else if (l6 == 11) {
                    i7 = i6 + i5;
                    k7 = j6 + k5;
                    i8 = l4 + k2 >> 1;
                    k8 = k1 + i1 >> 1;
                    j9 = l3 + i3 >> 1;
                } else if (l6 == 12) {
                    i7 = i6 + j5;
                    k7 = j6 + i5;
                    i8 = k2 + i2 >> 1;
                    k8 = i1 + l >> 1;
                    j9 = i3 + i >> 1;
                } else if (l6 == 13) {
                    i7 = i6 + j5;
                    k7 = j6 + j5;
                    i8 = i2;
                    k8 = l;
                    j9 = i;
                } else if (l6 == 14) {
                    i7 = i6 + k5;
                    k7 = j6 + j5;
                    i8 = j;
                    k8 = k4;
                    j9 = l2;
                } else if (l6 == 15) {
                    i7 = i6 + k5;
                    k7 = j6 + k5;
                    i8 = l4;
                    k8 = k1;
                    j9 = l3;
                } else {
                    i7 = i6 + j5;
                    k7 = j6 + k5;
                    i8 = k2;
                    k8 = i1;
                    j9 = i3;
                }
                anIntArray372[k6] = i7;
                anIntArray373[k6] = i8;
                anIntArray374[k6] = k7;
                ai1[k6] = k8;
                ai2[k6] = j9;
            }
            int ai3[] = ComplexTile.anIntArrayArray396[j4];
            int j7 = ai3.length / 4;
            anIntArray378 = new int[j7];
            anIntArray379 = new int[j7];
            anIntArray380 = new int[j7];
            anIntArray375 = new int[j7];
            anIntArray376 = new int[j7];
            anIntArray377 = new int[j7];
            if (j2 != -1) {
                anIntArray381 = new int[j7];
            }
            int l7 = 0;
            for (int j8 = 0; j8 < j7; j8++) {
                int l8 = ai3[l7];
                int k9 = ai3[l7 + 1];
                int i10 = ai3[l7 + 2];
                int j10 = ai3[l7 + 3];
                l7 += 4;
                if (k9 < 4) {
                    k9 = k9 - k3 & 3;
                }
                if (i10 < 4) {
                    i10 = i10 - k3 & 3;
                }
                if (j10 < 4) {
                    j10 = j10 - k3 & 3;
                }
                anIntArray378[j8] = k9;
                anIntArray379[j8] = i10;
                anIntArray380[j8] = j10;
                if (l8 == 0) {
                    anIntArray375[j8] = ai1[k9];
                    anIntArray376[j8] = ai1[i10];
                    anIntArray377[j8] = ai1[j10];
                    if (anIntArray381 != null) {
                        anIntArray381[j8] = -1;
                    }
                } else {
                    anIntArray375[j8] = ai2[k9];
                    anIntArray376[j8] = ai2[i10];
                    anIntArray377[j8] = ai2[j10];
                    if (anIntArray381 != null) {
                        anIntArray381[j8] = j2;
                    }
                }
            }
            int i9 = i2;
            int l9 = j;
            if (j < i9) {
                i9 = j;
            }
            if (j > l9) {
                l9 = j;
            }
            if (l4 < i9) {
                i9 = l4;
            }
            if (l4 > l9) {
                l9 = l4;
            }
            if (k2 < i9) {
                i9 = k2;
            }
            if (k2 > l9) {
                l9 = k2;
            }
            i9 /= 14;
            l9 /= 14;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("80362, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", " + k1
                    + ", " + l1 + ", " + i2 + ", " + j2 + ", " + k2 + ", " + l2 + ", " + i3 + ", " + j3 + ", " + k3
                    + ", " + l3 + ", " + i4 + ", " + j4 + ", " + k4 + ", " + l4 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

}

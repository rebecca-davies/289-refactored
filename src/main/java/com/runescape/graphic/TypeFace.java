package com.runescape.graphic;

import com.runescape.cache.FileArchive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

import java.util.Random;

public class TypeFace extends Draw2D {

    public int anInt1466;
    public boolean aBoolean1467;
    public int anInt1468;
    public byte aByte1469;
    public int anInt1470;
    public boolean aBoolean1471;
    public byte[][] aByteArrayArray1472;
    public int[] anIntArray1473;
    public int[] anIntArray1474;
    public int[] anIntArray1475;
    public int[] anIntArray1476;
    public int[] anIntArray1477;
    public int anInt1478;
    public Random aRandom1479;
    public boolean aBoolean1480;

    public TypeFace(int i, String s, boolean flag, FileArchive class47) {
        anInt1466 = 784;
        aBoolean1467 = false;
        aByte1469 = 5;
        anInt1470 = 2;
        aBoolean1471 = false;
        aByteArrayArray1472 = new byte[256][];
        anIntArray1473 = new int[256];
        anIntArray1474 = new int[256];
        anIntArray1475 = new int[256];
        anIntArray1476 = new int[256];
        anIntArray1477 = new int[256];
        aRandom1479 = new Random();
        aBoolean1480 = false;
        try {
            Buffer class44_sub3_sub2 = new Buffer(class47.method549(s + ".dat", null));
            Buffer class44_sub3_sub2_1 = new Buffer(class47.method549("index.dat", null));
            class44_sub3_sub2_1.position = class44_sub3_sub2.readUnsignedShort() + 4;
            if (i != 9) {
                aBoolean1467 = !aBoolean1467;
            }
            int k = class44_sub3_sub2_1.readUnsignedByte();
            if (k > 0) {
                class44_sub3_sub2_1.position += 3 * (k - 1);
            }
            for (int l = 0; l < 256; l++) {
                anIntArray1475[l] = class44_sub3_sub2_1.readUnsignedByte();
                anIntArray1476[l] = class44_sub3_sub2_1.readUnsignedByte();
                int i1 = anIntArray1473[l] = class44_sub3_sub2_1.readUnsignedShort();
                int j1 = anIntArray1474[l] = class44_sub3_sub2_1.readUnsignedShort();
                int k1 = class44_sub3_sub2_1.readUnsignedByte();
                int l1 = i1 * j1;
                aByteArrayArray1472[l] = new byte[l1];
                if (k1 == 0) {
                    for (int i2 = 0; i2 < l1; i2++) {
                        aByteArrayArray1472[l][i2] = class44_sub3_sub2.readByte();
                    }
                } else if (k1 == 1) {
                    for (int j2 = 0; j2 < i1; j2++) {
                        for (int l2 = 0; l2 < j1; l2++) {
                            aByteArrayArray1472[l][j2 + l2 * i1] = class44_sub3_sub2.readByte();
                        }
                    }
                }
                if (j1 > anInt1478 && l < 128) {
                    anInt1478 = j1;
                }
                anIntArray1475[l] = 1;
                anIntArray1477[l] = i1 + 2;
                int k2 = 0;
                for (int i3 = j1 / 7; i3 < j1; i3++) {
                    k2 += aByteArrayArray1472[l][i3 * i1];
                }
                if (k2 <= j1 / 7) {
                    anIntArray1477[l]--;
                    anIntArray1475[l] = 0;
                }
                k2 = 0;
                for (int j3 = j1 / 7; j3 < j1; j3++) {
                    k2 += aByteArrayArray1472[l][(i1 - 1) + j3 * i1];
                }
                if (k2 <= j1 / 7) {
                    anIntArray1477[l]--;
                }
            }
            if (flag) {
                anIntArray1477[32] = anIntArray1477[73];
                return;
            } else {
                anIntArray1477[32] = anIntArray1477[105];
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("36057, " + i + ", " + s + ", " + flag + ", " + class47 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void drawStringCenter(int i, String s, int j, int k, int l) {
        try {
            method459((byte) -104, k, s, i - method458(s, -725) / 2, l);
            if (j != -31546) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("89843, " + i + ", " + s + ", " + j + ", " + k + ", " + l + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void drawStringCenter(boolean flag, int i, byte byte0, int j, String s, int k) {
        try {
            drawStringTaggable(i, 2, k, flag, j - method457(s, true) / 2, s);
            if (byte0 != -85) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("52266, " + flag + ", " + i + ", " + byte0 + ", " + j + ", " + s + ", " + k + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public int method457(String s, boolean flag) {
        try {
            if (s == null) {
                return 0;
            }
            int i = 0;
            if (!flag) {
                anInt1466 = 391;
            }
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '@' && j + 4 < s.length() && s.charAt(j + 4) == '@') {
                    j += 4;
                } else {
                    i += anIntArray1477[s.charAt(j)];
                }
            }
            return i;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("63390, " + s + ", " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method458(String s, int i) {
        try {
            while (i >= 0) {
                aBoolean1467 = !aBoolean1467;
            }
            if (s == null) {
                return 0;
            }
            int j = 0;
            for (int k = 0; k < s.length(); k++) {
                j += anIntArray1477[s.charAt(k)];
            }
            return j;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("70316, " + s + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method459(byte byte0, int i, String s, int j, int k) {
        try {
            if (s == null) {
                return;
            }
            k -= anInt1478;
            if (byte0 != -104) {
                anInt1468 = -300;
            }
            for (int l = 0; l < s.length(); l++) {
                char c = s.charAt(l);
                if (c != ' ') {
                    method466(aByteArrayArray1472[c], j + anIntArray1475[c], k + anIntArray1476[c], anIntArray1473[c],
                            anIntArray1474[c], i);
                }
                j += anIntArray1477[c];
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("88673, " + byte0 + ", " + i + ", " + s + ", " + j + ", " + k + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method460(int i, int j, byte byte0, int k, int l, String s) {
        try {
            if (s == null) {
                return;
            }
            i -= method458(s, -725) / 2;
            l -= anInt1478;
            if (byte0 != aByte1469) {
                for (int i1 = 1; i1 > 0; i1++) {
                }
            }
            for (int j1 = 0; j1 < s.length(); j1++) {
                char c = s.charAt(j1);
                if (c != ' ') {
                    method466(aByteArrayArray1472[c], i + anIntArray1475[c],
                            l + anIntArray1476[c] + (int) (Math.sin(j1 / 2D + j / 5D) * 5D), anIntArray1473[c],
                            anIntArray1474[c], k);
                }
                i += anIntArray1477[c];
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90881, " + i + ", " + j + ", " + byte0 + ", " + k + ", " + l + ", " + s + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method461(int i, String s, byte byte0, int j, int k, int l) {
        try {
            if (byte0 == 3) {
                byte0 = 0;
            } else {
                return;
            }
            if (s == null) {
                return;
            }
            j -= method458(s, -725) / 2;
            k -= anInt1478;
            for (int i1 = 0; i1 < s.length(); i1++) {
                char c = s.charAt(i1);
                if (c != ' ') {
                    method466(aByteArrayArray1472[c], j + anIntArray1475[c] + (int) (Math.sin(i1 / 5D + l / 5D) * 5D),
                            k + anIntArray1476[c] + (int) (Math.sin(i1 / 3D + l / 5D) * 5D), anIntArray1473[c],
                            anIntArray1474[c], i);
                }
                j += anIntArray1477[c];
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("17099, " + i + ", " + s + ", " + byte0 + ", " + j + ", " + k + ", " + l + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method462(String s, int i, int j, int k, int l, int i1, int j1) {
        try {
            if (s == null) {
                return;
            }
            double d = 7D - j1 / 8D;
            if (i1 != 8) {
                aBoolean1467 = !aBoolean1467;
            }
            if (d < 0.0D) {
                d = 0.0D;
            }
            i -= method458(s, -725) / 2;
            k -= anInt1478;
            for (int k1 = 0; k1 < s.length(); k1++) {
                char c = s.charAt(k1);
                if (c != ' ') {
                    method466(aByteArrayArray1472[c], i + anIntArray1475[c],
                            k + anIntArray1476[c] + (int) (Math.sin(k1 / 1.5D + j) * d), anIntArray1473[c],
                            anIntArray1474[c], l);
                }
                i += anIntArray1477[c];
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("70626, " + s + ", " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1
                    + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void drawStringTaggable(int i, int j, int k, boolean flag, int l, String s) {
        try {
            aBoolean1480 = false;
            int i1 = l;
            if (s == null) {
                return;
            }
            k -= anInt1478;
            for (int j1 = 0; j1 < s.length(); j1++) {
                if (s.charAt(j1) == '@' && j1 + 4 < s.length() && s.charAt(j1 + 4) == '@') {
                    int k1 = method465(s.substring(j1 + 1, j1 + 4), 1);
                    if (k1 != -1) {
                        i = k1;
                    }
                    j1 += 4;
                } else {
                    char c = s.charAt(j1);
                    if (c != ' ') {
                        if (flag) {
                            method466(aByteArrayArray1472[c], l + anIntArray1475[c] + 1, k + anIntArray1476[c] + 1,
                                    anIntArray1473[c], anIntArray1474[c], 0);
                        }
                        method466(aByteArrayArray1472[c], l + anIntArray1475[c], k + anIntArray1476[c],
                                anIntArray1473[c], anIntArray1474[c], i);
                    }
                    l += anIntArray1477[c];
                }
            }
            if (j < anInt1470 || j > anInt1470) {
                return;
            }
            if (aBoolean1480) {
                Draw2D.method414(l - i1, i1, 0x800000, true, k + (int) (anInt1478 * 0.69999999999999996D));
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("34312, " + i + ", " + j + ", " + k + ", " + flag + ", " + l + ", " + s + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method464(String s, boolean flag, int i, int j, int k, int l, int i1) {
        try {
            if (j != 26617) {
                for (int j1 = 1; j1 > 0; j1++) {
                }
            }
            if (s == null) {
                return;
            }
            aRandom1479.setSeed(l);
            int k1 = 192 + (aRandom1479.nextInt() & 0x1f);
            i1 -= anInt1478;
            for (int l1 = 0; l1 < s.length(); l1++) {
                if (s.charAt(l1) == '@' && l1 + 4 < s.length() && s.charAt(l1 + 4) == '@') {
                    int i2 = method465(s.substring(l1 + 1, l1 + 4), 1);
                    if (i2 != -1) {
                        i = i2;
                    }
                    l1 += 4;
                } else {
                    char c = s.charAt(l1);
                    if (c != ' ') {
                        if (flag) {
                            method468(aByteArrayArray1472[c], k + anIntArray1475[c] + 1, 0, i1 + anIntArray1476[c] + 1,
                                    anIntArray1474[c], 192, anIntArray1473[c], false);
                        }
                        method468(aByteArrayArray1472[c], k + anIntArray1475[c], i, i1 + anIntArray1476[c],
                                anIntArray1474[c], k1, anIntArray1473[c], false);
                    }
                    k += anIntArray1477[c];
                    if ((aRandom1479.nextInt() & 3) == 0) {
                        k++;
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("64640, " + s + ", " + flag + ", " + i + ", " + j + ", " + k + ", " + l + ", " + i1
                    + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method465(String s, int i) {
        try {
            if (i != 1) {
                return anInt1468;
            }
            if (s.equals("red")) {
                return 0xff0000;
            }
            if (s.equals("gre")) {
                return 65280;
            }
            if (s.equals("blu")) {
                return 255;
            }
            if (s.equals("yel")) {
                return 0xffff00;
            }
            if (s.equals("cya")) {
                return 65535;
            }
            if (s.equals("mag")) {
                return 0xff00ff;
            }
            if (s.equals("whi")) {
                return 0xffffff;
            }
            if (s.equals("bla")) {
                return 0;
            }
            if (s.equals("lre")) {
                return 0xff9040;
            }
            if (s.equals("dre")) {
                return 0x800000;
            }
            if (s.equals("dbl")) {
                return 128;
            }
            if (s.equals("or1")) {
                return 0xffb000;
            }
            if (s.equals("or2")) {
                return 0xff7000;
            }
            if (s.equals("or3")) {
                return 0xff3000;
            }
            if (s.equals("gr1")) {
                return 0xc0ff00;
            }
            if (s.equals("gr2")) {
                return 0x80ff00;
            }
            if (s.equals("gr3")) {
                return 0x40ff00;
            }
            if (s.equals("str")) {
                aBoolean1480 = true;
            }
            if (s.equals("end")) {
                aBoolean1480 = false;
            }
            return -1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("97933, " + s + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method466(byte[] abyte0, int i, int j, int k, int l, int i1) {
        int j1 = i + j * Draw2D.anInt1370;
        int k1 = Draw2D.anInt1370 - k;
        int l1 = 0;
        int i2 = 0;
        if (j < Draw2D.anInt1372) {
            int j2 = Draw2D.anInt1372 - j;
            l -= j2;
            j = Draw2D.anInt1372;
            i2 += j2 * k;
            j1 += j2 * Draw2D.anInt1370;
        }
        if (j + l >= Draw2D.anInt1373) {
            l -= ((j + l) - Draw2D.anInt1373) + 1;
        }
        if (i < Draw2D.anInt1374) {
            int k2 = Draw2D.anInt1374 - i;
            k -= k2;
            i = Draw2D.anInt1374;
            i2 += k2;
            j1 += k2;
            l1 += k2;
            k1 += k2;
        }
        if (i + k >= Draw2D.anInt1375) {
            int l2 = ((i + k) - Draw2D.anInt1375) + 1;
            k -= l2;
            l1 += l2;
            k1 += l2;
        }
        if (k <= 0 || l <= 0) {
            return;
        } else {
            method467(Draw2D.anIntArray1369, abyte0, i1, i2, j1, k, l, k1, l1);
            return;
        }
    }

    public void method467(int[] ai, byte[] abyte0, int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = -(l >> 2);
        l = -(l & 3);
        for (int i2 = -i1; i2 < 0; i2++) {
            for (int j2 = l1; j2 < 0; j2++) {
                if (abyte0[j++] != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                if (abyte0[j++] != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                if (abyte0[j++] != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                if (abyte0[j++] != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
            }
            for (int k2 = l; k2 < 0; k2++) {
                if (abyte0[j++] != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
            }
            k += j1;
            j += k1;
        }
    }

    public void method468(byte[] abyte0, int i, int j, int k, int l, int i1, int j1, boolean flag) {
        try {
            if (flag) {
                anInt1468 = 122;
            }
            int k1 = i + k * Draw2D.anInt1370;
            int l1 = Draw2D.anInt1370 - j1;
            int i2 = 0;
            int j2 = 0;
            if (k < Draw2D.anInt1372) {
                int k2 = Draw2D.anInt1372 - k;
                l -= k2;
                k = Draw2D.anInt1372;
                j2 += k2 * j1;
                k1 += k2 * Draw2D.anInt1370;
            }
            if (k + l >= Draw2D.anInt1373) {
                l -= ((k + l) - Draw2D.anInt1373) + 1;
            }
            if (i < Draw2D.anInt1374) {
                int l2 = Draw2D.anInt1374 - i;
                j1 -= l2;
                i = Draw2D.anInt1374;
                j2 += l2;
                k1 += l2;
                i2 += l2;
                l1 += l2;
            }
            if (i + j1 >= Draw2D.anInt1375) {
                int i3 = ((i + j1) - Draw2D.anInt1375) + 1;
                j1 -= i3;
                i2 += i3;
                l1 += i3;
            }
            if (j1 <= 0 || l <= 0) {
                return;
            } else {
                method469(i2, j1, j, abyte0, false, Draw2D.anIntArray1369, k1, j2, l1, i1, l);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96459, " + abyte0 + ", " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1
                    + ", " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method469(int i, int j, int k, byte[] abyte0, boolean flag, int[] ai, int l, int i1, int j1, int k1,
                          int l1) {
        try {
            if (flag) {
                for (int i2 = 1; i2 > 0; i2++) {
                }
            }
            k = ((k & 0xff00ff) * k1 & 0xff00ff00) + ((k & 0xff00) * k1 & 0xff0000) >> 8;
            k1 = 256 - k1;
            for (int j2 = -l1; j2 < 0; j2++) {
                for (int k2 = -j; k2 < 0; k2++) {
                    if (abyte0[i1++] != 0) {
                        int l2 = ai[l];
                        ai[l++] = (((l2 & 0xff00ff) * k1 & 0xff00ff00) + ((l2 & 0xff00) * k1 & 0xff0000) >> 8) + k;
                    } else {
                        l++;
                    }
                }
                l += j1;
                i1 += i;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("17490, " + i + ", " + j + ", " + k + ", " + abyte0 + ", " + flag + ", " + ai + ", "
                    + l + ", " + i1 + ", " + j1 + ", " + k1 + ", " + l1 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }
}

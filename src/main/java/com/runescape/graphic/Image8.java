package com.runescape.graphic;

import com.runescape.cache.FileArchive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class Image8 extends Draw2D {

    public boolean aBoolean1455;
    public boolean aBoolean1456;
    public int anInt1457;
    public byte[] aByteArray1458;
    public int[] anIntArray1459;
    public int width;
    public int height;
    public int anInt1462;
    public int anInt1463;
    public int anInt1464;
    public int anInt1465;

    public Image8(FileArchive class47, String s, int i) {
        aBoolean1455 = false;
        aBoolean1456 = false;
        anInt1457 = 9;
        Buffer class44_sub3_sub2 = new Buffer(class47.method549(s + ".dat", null));
        Buffer class44_sub3_sub2_1 = new Buffer(class47.method549("index.dat", null));
        class44_sub3_sub2_1.position = class44_sub3_sub2.readUnsignedShort();
        anInt1464 = class44_sub3_sub2_1.readUnsignedShort();
        anInt1465 = class44_sub3_sub2_1.readUnsignedShort();
        int j = class44_sub3_sub2_1.readUnsignedByte();
        anIntArray1459 = new int[j];
        for (int k = 0; k < j - 1; k++) {
            anIntArray1459[k + 1] = class44_sub3_sub2_1.method486();
        }
        for (int l = 0; l < i; l++) {
            class44_sub3_sub2_1.position += 2;
            class44_sub3_sub2.position += class44_sub3_sub2_1.readUnsignedShort() * class44_sub3_sub2_1.readUnsignedShort();
            class44_sub3_sub2_1.position++;
        }
        anInt1462 = class44_sub3_sub2_1.readUnsignedByte();
        anInt1463 = class44_sub3_sub2_1.readUnsignedByte();
        width = class44_sub3_sub2_1.readUnsignedShort();
        height = class44_sub3_sub2_1.readUnsignedShort();
        int i1 = class44_sub3_sub2_1.readUnsignedByte();
        int j1 = width * height;
        aByteArray1458 = new byte[j1];
        if (i1 == 0) {
            for (int k1 = 0; k1 < j1; k1++) {
                aByteArray1458[k1] = class44_sub3_sub2.readByte();
            }
            return;
        }
        if (i1 == 1) {
            for (int l1 = 0; l1 < width; l1++) {
                for (int i2 = 0; i2 < height; i2++) {
                    aByteArray1458[l1 + i2 * width] = class44_sub3_sub2.readByte();
                }
            }
        }
    }

    public void method448(int i) {
        try {
            anInt1464 /= 2;
            anInt1465 /= 2;
            byte[] abyte0 = new byte[anInt1464 * anInt1465];
            int j = 0;
            for (int k = 0; k < height; k++) {
                for (int l = 0; l < width; l++) {
                    abyte0[(l + anInt1462 >> 1) + (k + anInt1463 >> 1) * anInt1464] = aByteArray1458[j++];
                }
            }
            aByteArray1458 = abyte0;
            width = anInt1464;
            if (i != 0) {
                aBoolean1455 = !aBoolean1455;
            }
            height = anInt1465;
            anInt1462 = 0;
            anInt1463 = 0;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96890, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method449(int i) {
        try {
            if (width == anInt1464 && height == anInt1465) {
                return;
            }
            byte[] abyte0 = new byte[anInt1464 * anInt1465];
            int j = 0;
            for (int k = 0; k < height; k++) {
                for (int l = 0; l < width; l++) {
                    abyte0[l + anInt1462 + (k + anInt1463) * anInt1464] = aByteArray1458[j++];
                }
            }
            aByteArray1458 = abyte0;
            width = anInt1464;
            height = anInt1465;
            anInt1462 = 0;
            anInt1463 = 0;
            if (i < 9 || i > 9) {
                aBoolean1456 = !aBoolean1456;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("81667, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method450(int i) {
        try {
            byte[] abyte0 = new byte[width * height];
            int j = 0;
            for (int k = 0; k < height; k++) {
                for (int l = width - 1; l >= 0; l--) {
                    abyte0[j++] = aByteArray1458[l + k * width];
                }
            }
            aByteArray1458 = abyte0;
            if (i != 6) {
                anInt1457 = 352;
            }
            anInt1462 = anInt1464 - width - anInt1462;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("28636, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method451(int i) {
        try {
            byte[] abyte0 = new byte[width * height];
            int j = 0;
            for (int k = height - 1; k >= 0; k--) {
                for (int l = 0; l < width; l++) {
                    abyte0[j++] = aByteArray1458[l + k * width];
                }
            }
            if (i != 35509) {
                return;
            } else {
                aByteArray1458 = abyte0;
                anInt1463 = anInt1465 - height - anInt1463;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("83103, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method452(int i, byte byte0, int j, int k) {
        try {
            if (byte0 != 3) {
                for (int l = 1; l > 0; l++) {
                }
            }
            for (int i1 = 0; i1 < anIntArray1459.length; i1++) {
                int j1 = anIntArray1459[i1] >> 16 & 0xff;
                j1 += i;
                if (j1 < 0) {
                    j1 = 0;
                } else if (j1 > 255) {
                    j1 = 255;
                }
                int k1 = anIntArray1459[i1] >> 8 & 0xff;
                k1 += j;
                if (k1 < 0) {
                    k1 = 0;
                } else if (k1 > 255) {
                    k1 = 255;
                }
                int l1 = anIntArray1459[i1] & 0xff;
                l1 += k;
                if (l1 < 0) {
                    l1 = 0;
                } else if (l1 > 255) {
                    l1 = 255;
                }
                anIntArray1459[i1] = (j1 << 16) + (k1 << 8) + l1;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("28455, " + i + ", " + byte0 + ", " + j + ", " + k + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void blit(int i, int j) {
        try {
            j += anInt1462;
            i += anInt1463;
            int k = j + i * Draw2D.width;
            int l = 0;
            int i1 = height;
            int j1 = width;
            int k1 = Draw2D.width - j1;
            int l1 = 0;
            if (i < Draw2D.top) {
                int i2 = Draw2D.top - i;
                i1 -= i2;
                i = Draw2D.top;
                l += i2 * j1;
                k += i2 * Draw2D.width;
            }
            if (i + i1 > Draw2D.bottom) {
                i1 -= (i + i1) - Draw2D.bottom;
            }
            if (j < Draw2D.left) {
                int j2 = Draw2D.left - j;
                j1 -= j2;
                j = Draw2D.left;
                l += j2;
                k += j2;
                l1 += j2;
                k1 += j2;
            }
            if (j + j1 > Draw2D.right) {
                int k2 = (j + j1) - Draw2D.right;
                j1 -= k2;
                l1 += k2;
                k1 += k2;
            }
            if (j1 <= 0 || i1 <= 0) {
                return;
            } else {
                method454(i1, anIntArray1459, k, Draw2D.pixels, l1, k1, (byte) 34, aByteArray1458, j1, l);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("29131, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method454(int i, int[] ai, int j, int[] ai1, int k, int l, byte byte0, byte[] abyte0, int i1, int j1) {
        try {
            int k1 = -(i1 >> 2);
            i1 = -(i1 & 3);
            for (int l1 = -i; l1 < 0; l1++) {
                for (int i2 = k1; i2 < 0; i2++) {
                    byte byte1 = abyte0[j1++];
                    if (byte1 != 0) {
                        ai1[j++] = ai[byte1 & 0xff];
                    } else {
                        j++;
                    }
                    byte1 = abyte0[j1++];
                    if (byte1 != 0) {
                        ai1[j++] = ai[byte1 & 0xff];
                    } else {
                        j++;
                    }
                    byte1 = abyte0[j1++];
                    if (byte1 != 0) {
                        ai1[j++] = ai[byte1 & 0xff];
                    } else {
                        j++;
                    }
                    byte1 = abyte0[j1++];
                    if (byte1 != 0) {
                        ai1[j++] = ai[byte1 & 0xff];
                    } else {
                        j++;
                    }
                }
                for (int j2 = i1; j2 < 0; j2++) {
                    byte byte2 = abyte0[j1++];
                    if (byte2 != 0) {
                        ai1[j++] = ai[byte2 & 0xff];
                    } else {
                        j++;
                    }
                }
                j += l;
                j1 += k;
            }
            if (byte0 != 34) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("42705, " + i + ", " + ai + ", " + j + ", " + ai1 + ", " + k + ", " + l + ", " + byte0
                    + ", " + abyte0 + ", " + i1 + ", " + j1 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }
}

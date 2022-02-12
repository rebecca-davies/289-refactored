package com.runescape.graphic;

import com.runescape.cache.FileArchive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

import java.awt.*;
import java.awt.Component;
import java.awt.image.PixelGrabber;

public class Image24 extends Draw2D {

    public int anInt1441;
    public boolean aBoolean1442;
    public int anInt1443;
    public int anInt1444;
    public int anInt1445;
    public byte aByte1446;
    public boolean aBoolean1447;
    public int anIntArray1448[];
    public int anInt1449;
    public int anInt1450;
    public int anInt1451;
    public int anInt1452;
    public int anInt1453;
    public int anInt1454;

    public Image24(int i, int j) {
        aBoolean1442 = false;
        anInt1443 = 387;
        anInt1445 = 9;
        aByte1446 = 8;
        aBoolean1447 = true;
        anIntArray1448 = new int[i * j];
        anInt1449 = anInt1453 = i;
        anInt1450 = anInt1454 = j;
        anInt1451 = anInt1452 = 0;
    }

    public Image24(byte abyte0[], Component component) {
        aBoolean1442 = false;
        anInt1443 = 387;
        anInt1445 = 9;
        aByte1446 = 8;
        aBoolean1447 = true;
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(abyte0);
            MediaTracker mediatracker = new MediaTracker(component);
            mediatracker.addImage(image, 0);
            mediatracker.waitForAll();
            anInt1449 = image.getWidth(component);
            anInt1450 = image.getHeight(component);
            anInt1453 = anInt1449;
            anInt1454 = anInt1450;
            anInt1451 = 0;
            anInt1452 = 0;
            anIntArray1448 = new int[anInt1449 * anInt1450];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, anInt1449, anInt1450, anIntArray1448, 0,
                    anInt1449);
            pixelgrabber.grabPixels();
            return;
        } catch (Exception _ex) {
            System.out.println("Error converting jpg");
        }
    }

    public Image24(FileArchive class47, String s, int i) {
        aBoolean1442 = false;
        anInt1443 = 387;
        anInt1445 = 9;
        aByte1446 = 8;
        aBoolean1447 = true;
        Buffer class44_sub3_sub2 = new Buffer(class47.method549(s + ".dat", null));
        Buffer class44_sub3_sub2_1 = new Buffer(class47.method549("index.dat", null));
        class44_sub3_sub2_1.offset = class44_sub3_sub2.readUnsignedShort();
        anInt1453 = class44_sub3_sub2_1.readUnsignedShort();
        anInt1454 = class44_sub3_sub2_1.readUnsignedShort();
        int j = class44_sub3_sub2_1.readUnsignedByte();
        int ai[] = new int[j];
        for (int k = 0; k < j - 1; k++) {
            ai[k + 1] = class44_sub3_sub2_1.method486();
            if (ai[k + 1] == 0) {
                ai[k + 1] = 1;
            }
        }
        for (int l = 0; l < i; l++) {
            class44_sub3_sub2_1.offset += 2;
            class44_sub3_sub2.offset += class44_sub3_sub2_1.readUnsignedShort() * class44_sub3_sub2_1.readUnsignedShort();
            class44_sub3_sub2_1.offset++;
        }
        anInt1451 = class44_sub3_sub2_1.readUnsignedByte();
        anInt1452 = class44_sub3_sub2_1.readUnsignedByte();
        anInt1449 = class44_sub3_sub2_1.readUnsignedShort();
        anInt1450 = class44_sub3_sub2_1.readUnsignedShort();
        int i1 = class44_sub3_sub2_1.readUnsignedByte();
        int j1 = anInt1449 * anInt1450;
        anIntArray1448 = new int[j1];
        if (i1 == 0) {
            for (int k1 = 0; k1 < j1; k1++) {
                anIntArray1448[k1] = ai[class44_sub3_sub2.readUnsignedByte()];
            }
            return;
        }
        if (i1 == 1) {
            for (int l1 = 0; l1 < anInt1449; l1++) {
                for (int i2 = 0; i2 < anInt1450; i2++) {
                    anIntArray1448[l1 + i2 * anInt1449] = ai[class44_sub3_sub2.readUnsignedByte()];
                }
            }
        }
    }

    public void method435(byte byte0) {
        try {
            Draw2D.method406(-78, anIntArray1448, anInt1449, anInt1450);
            if (byte0 == 5) {
                byte0 = 0;
                return;
            } else {
                anInt1441 = 4;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("24805, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method436(int i, byte byte0, int j, int k) {
        try {
            for (int l = 0; l < anIntArray1448.length; l++) {
                int i1 = anIntArray1448[l];
                if (i1 != 0) {
                    int j1 = i1 >> 16 & 0xff;
                    j1 += i;
                    if (j1 < 1) {
                        j1 = 1;
                    } else if (j1 > 255) {
                        j1 = 255;
                    }
                    int k1 = i1 >> 8 & 0xff;
                    k1 += j;
                    if (k1 < 1) {
                        k1 = 1;
                    } else if (k1 > 255) {
                        k1 = 255;
                    }
                    int l1 = i1 & 0xff;
                    l1 += k;
                    if (l1 < 1) {
                        l1 = 1;
                    } else if (l1 > 255) {
                        l1 = 255;
                    }
                    anIntArray1448[l] = (j1 << 16) + (k1 << 8) + l1;
                }
            }
            if (byte0 == 3) {
                byte0 = 0;
                return;
            } else {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("40145, " + i + ", " + byte0 + ", " + j + ", " + k + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method437(int i) {
        try {
            int ai[] = new int[anInt1453 * anInt1454];
            for (int j = 0; j < anInt1450; j++) {
                for (int k = 0; k < anInt1449; k++) {
                    ai[(j + anInt1452) * anInt1453 + (k + anInt1451)] = anIntArray1448[j * anInt1449 + k];
                }
            }
            anIntArray1448 = ai;
            anInt1449 = anInt1453;
            anInt1450 = anInt1454;
            anInt1451 = 0;
            anInt1452 = 0;
            if (i != -15744) {
                aBoolean1442 = !aBoolean1442;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("30731, " + i + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method438(int i, int j, int k) {
        try {
            i += anInt1451;
            j += anInt1452;
            int l = i + j * Draw2D.anInt1370;
            int i1 = 0;
            int j1 = anInt1450;
            int k1 = anInt1449;
            int l1 = Draw2D.anInt1370 - k1;
            int i2 = 0;
            if (k != 8) {
                for (int j2 = 1; j2 > 0; j2++) {
                }
            }
            if (j < Draw2D.anInt1372) {
                int k2 = Draw2D.anInt1372 - j;
                j1 -= k2;
                j = Draw2D.anInt1372;
                i1 += k2 * k1;
                l += k2 * Draw2D.anInt1370;
            }
            if (j + j1 > Draw2D.anInt1373) {
                j1 -= (j + j1) - Draw2D.anInt1373;
            }
            if (i < Draw2D.anInt1374) {
                int l2 = Draw2D.anInt1374 - i;
                k1 -= l2;
                i = Draw2D.anInt1374;
                i1 += l2;
                l += l2;
                i2 += l2;
                l1 += l2;
            }
            if (i + k1 > Draw2D.anInt1375) {
                int i3 = (i + k1) - Draw2D.anInt1375;
                k1 -= i3;
                i2 += i3;
                l1 += i3;
            }
            if (k1 <= 0 || j1 <= 0) {
                return;
            } else {
                method439(i1, Draw2D.anIntArray1369, anIntArray1448, l, k1, j1, true, l1, i2);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("29381, " + i + ", " + j + ", " + k + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method439(int i, int ai[], int ai1[], int j, int k, int l, boolean flag, int i1, int j1) {
        try {
            int k1 = -(k >> 2);
            k = -(k & 3);
            if (!flag) {
                for (int l1 = 1; l1 > 0; l1++) {
                }
            }
            for (int i2 = -l; i2 < 0; i2++) {
                for (int j2 = k1; j2 < 0; j2++) {
                    ai[j++] = ai1[i++];
                    ai[j++] = ai1[i++];
                    ai[j++] = ai1[i++];
                    ai[j++] = ai1[i++];
                }
                for (int k2 = k; k2 < 0; k2++) {
                    ai[j++] = ai1[i++];
                }
                j += i1;
                i += j1;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("72719, " + i + ", " + ai + ", " + ai1 + ", " + j + ", " + k + ", " + l + ", " + flag
                    + ", " + i1 + ", " + j1 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method440(int i, byte byte0, int j) {
        try {
            j += anInt1451;
            i += anInt1452;
            int k = j + i * Draw2D.anInt1370;
            int l = 0;
            int i1 = anInt1450;
            int j1 = anInt1449;
            int k1 = Draw2D.anInt1370 - j1;
            int l1 = 0;
            if (byte0 != 1) {
                return;
            }
            if (i < Draw2D.anInt1372) {
                int i2 = Draw2D.anInt1372 - i;
                i1 -= i2;
                i = Draw2D.anInt1372;
                l += i2 * j1;
                k += i2 * Draw2D.anInt1370;
            }
            if (i + i1 > Draw2D.anInt1373) {
                i1 -= (i + i1) - Draw2D.anInt1373;
            }
            if (j < Draw2D.anInt1374) {
                int j2 = Draw2D.anInt1374 - j;
                j1 -= j2;
                j = Draw2D.anInt1374;
                l += j2;
                k += j2;
                l1 += j2;
                k1 += j2;
            }
            if (j + j1 > Draw2D.anInt1375) {
                int k2 = (j + j1) - Draw2D.anInt1375;
                j1 -= k2;
                l1 += k2;
                k1 += k2;
            }
            if (j1 <= 0 || i1 <= 0) {
                return;
            } else {
                method441(Draw2D.anIntArray1369, anIntArray1448, 0, l, k, j1, i1, k1, l1);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("37524, " + i + ", " + byte0 + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method441(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = -(l >> 2);
        l = -(l & 3);
        for (int i2 = -i1; i2 < 0; i2++) {
            for (int j2 = l1; j2 < 0; j2++) {
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
            }
            for (int k2 = l; k2 < 0; k2++) {
                i = ai1[j++];
                if (i != 0) {
                    ai[k++] = i;
                } else {
                    k++;
                }
            }
            k += j1;
            j += k1;
        }
    }

    public void method442(int i, int j, int k, int l) {
        try {
            l += anInt1451;
            j = 15 / j;
            k += anInt1452;
            int i1 = l + k * Draw2D.anInt1370;
            int j1 = 0;
            int k1 = anInt1450;
            int l1 = anInt1449;
            int i2 = Draw2D.anInt1370 - l1;
            int j2 = 0;
            if (k < Draw2D.anInt1372) {
                int k2 = Draw2D.anInt1372 - k;
                k1 -= k2;
                k = Draw2D.anInt1372;
                j1 += k2 * l1;
                i1 += k2 * Draw2D.anInt1370;
            }
            if (k + k1 > Draw2D.anInt1373) {
                k1 -= (k + k1) - Draw2D.anInt1373;
            }
            if (l < Draw2D.anInt1374) {
                int l2 = Draw2D.anInt1374 - l;
                l1 -= l2;
                l = Draw2D.anInt1374;
                j1 += l2;
                i1 += l2;
                j2 += l2;
                i2 += l2;
            }
            if (l + l1 > Draw2D.anInt1375) {
                int i3 = (l + l1) - Draw2D.anInt1375;
                l1 -= i3;
                j2 += i3;
                i2 += i3;
            }
            if (l1 <= 0 || k1 <= 0) {
                return;
            } else {
                method443(j1, i, i1, k1, Draw2D.anIntArray1369, anIntArray1448, i2, j2, 0, l1, false);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("12746, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method443(int i, int j, int k, int l, int ai[], int ai1[], int i1, int j1, int k1, int l1, boolean flag) {
        try {
            if (flag) {
                return;
            }
            int i2 = 256 - j;
            for (int j2 = -l; j2 < 0; j2++) {
                for (int k2 = -l1; k2 < 0; k2++) {
                    k1 = ai1[i++];
                    if (k1 != 0) {
                        int l2 = ai[k];
                        ai[k++] = ((k1 & 0xff00ff) * j + (l2 & 0xff00ff) * i2 & 0xff00ff00)
                                + ((k1 & 0xff00) * j + (l2 & 0xff00) * i2 & 0xff0000) >> 8;
                    } else {
                        k++;
                    }
                }
                k += i1;
                i += j1;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("94839, " + i + ", " + j + ", " + k + ", " + l + ", " + ai + ", " + ai1 + ", " + i1
                    + ", " + j1 + ", " + k1 + ", " + l1 + ", " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method444(int ai[], int i, int j, int k, int l, int i1, int ai1[], int j1, int k1, int l1, int i2) {
        try {
            while (k1 >= 0) {
                return;
            }
            try {
                int j2 = -j1 / 2;
                int k2 = -i1 / 2;
                int l2 = (int) (Math.sin(l / 326.11000000000001D) * 65536D);
                int i3 = (int) (Math.cos(l / 326.11000000000001D) * 65536D);
                l2 = l2 * k >> 8;
                i3 = i3 * k >> 8;
                int j3 = (l1 << 16) + (k2 * l2 + j2 * i3);
                int k3 = (j << 16) + (k2 * i3 - j2 * l2);
                int l3 = i2 + i * Draw2D.anInt1370;
                for (i = 0; i < i1; i++) {
                    int i4 = ai[i];
                    int j4 = l3 + i4;
                    int k4 = j3 + i3 * i4;
                    int l4 = k3 - l2 * i4;
                    for (i2 = -ai1[i]; i2 < 0; i2++) {
                        Draw2D.anIntArray1369[j4++] = anIntArray1448[(k4 >> 16) + (l4 >> 16) * anInt1449];
                        k4 += i3;
                        l4 -= l2;
                    }
                    j3 += l2;
                    k3 += i3;
                    l3 += Draw2D.anInt1370;
                }
                return;
            } catch (Exception _ex) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("82769, " + ai + ", " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + ai1
                    + ", " + j1 + ", " + k1 + ", " + l1 + ", " + i2 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method445(int i, double d, int j, int k, int l, int i1, byte byte0, int j1, int k1) {
        try {
            if (byte0 == aByte1446) {
                byte0 = 0;
            } else {
                anInt1444 = -392;
            }
            try {
                int l1 = -j / 2;
                int i2 = -j1 / 2;
                int j2 = (int) (Math.sin(d) * 65536D);
                int k2 = (int) (Math.cos(d) * 65536D);
                j2 = j2 * k >> 8;
                k2 = k2 * k >> 8;
                int l2 = (i << 16) + (i2 * j2 + l1 * k2);
                int i3 = (l << 16) + (i2 * k2 - l1 * j2);
                int j3 = i1 + k1 * Draw2D.anInt1370;
                for (k1 = 0; k1 < j1; k1++) {
                    int k3 = j3;
                    int l3 = l2;
                    int i4 = i3;
                    for (i1 = -j; i1 < 0; i1++) {
                        int j4 = anIntArray1448[(l3 >> 16) + (i4 >> 16) * anInt1449];
                        if (j4 != 0) {
                            Draw2D.anIntArray1369[k3++] = j4;
                        } else {
                            k3++;
                        }
                        l3 += k2;
                        i4 -= j2;
                    }
                    l2 += j2;
                    i3 += k2;
                    j3 += Draw2D.anInt1370;
                }
                return;
            } catch (Exception _ex) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("35641, " + i + ", " + d + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + byte0
                    + ", " + j1 + ", " + k1 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method446(int i, Image8 class44_sub3_sub1_sub3, boolean flag, int j) {
        try {
            i += anInt1451;
            j += anInt1452;
            int k = i + j * Draw2D.anInt1370;
            int l = 0;
            int i1 = anInt1450;
            int j1 = anInt1449;
            int k1 = Draw2D.anInt1370 - j1;
            int l1 = 0;
            if (!flag) {
                aBoolean1447 = !aBoolean1447;
            }
            if (j < Draw2D.anInt1372) {
                int i2 = Draw2D.anInt1372 - j;
                i1 -= i2;
                j = Draw2D.anInt1372;
                l += i2 * j1;
                k += i2 * Draw2D.anInt1370;
            }
            if (j + i1 > Draw2D.anInt1373) {
                i1 -= (j + i1) - Draw2D.anInt1373;
            }
            if (i < Draw2D.anInt1374) {
                int j2 = Draw2D.anInt1374 - i;
                j1 -= j2;
                i = Draw2D.anInt1374;
                l += j2;
                k += j2;
                l1 += j2;
                k1 += j2;
            }
            if (i + j1 > Draw2D.anInt1375) {
                int k2 = (i + j1) - Draw2D.anInt1375;
                j1 -= k2;
                l1 += k2;
                k1 += k2;
            }
            if (j1 <= 0 || i1 <= 0) {
                return;
            } else {
                method447(l, k, l1, class44_sub3_sub1_sub3.aByteArray1458, j1, k1, 0, i1, anIntArray1448, true,
                        Draw2D.anIntArray1369);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("46753, " + i + ", " + class44_sub3_sub1_sub3 + ", " + flag + ", " + j + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method447(int i, int j, int k, byte abyte0[], int l, int i1, int j1, int k1, int ai[], boolean flag,
                          int ai1[]) {
        try {
            if (!flag) {
                anInt1445 = 207;
            }
            int l1 = -(l >> 2);
            l = -(l & 3);
            for (int i2 = -k1; i2 < 0; i2++) {
                for (int j2 = l1; j2 < 0; j2++) {
                    j1 = ai[i++];
                    if (j1 != 0 && abyte0[j] == 0) {
                        ai1[j++] = j1;
                    } else {
                        j++;
                    }
                    j1 = ai[i++];
                    if (j1 != 0 && abyte0[j] == 0) {
                        ai1[j++] = j1;
                    } else {
                        j++;
                    }
                    j1 = ai[i++];
                    if (j1 != 0 && abyte0[j] == 0) {
                        ai1[j++] = j1;
                    } else {
                        j++;
                    }
                    j1 = ai[i++];
                    if (j1 != 0 && abyte0[j] == 0) {
                        ai1[j++] = j1;
                    } else {
                        j++;
                    }
                }
                for (int k2 = l; k2 < 0; k2++) {
                    j1 = ai[i++];
                    if (j1 != 0 && abyte0[j] == 0) {
                        ai1[j++] = j1;
                    } else {
                        j++;
                    }
                }
                j += i1;
                i += k;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("52031, " + i + ", " + j + ", " + k + ", " + abyte0 + ", " + l + ", " + i1 + ", " + j1
                    + ", " + k1 + ", " + ai + ", " + flag + ", " + ai1 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}

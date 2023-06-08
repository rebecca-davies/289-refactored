package com.runescape.graphic;

import com.runescape.collection.CacheableNode;
import com.runescape.util.SignLink;

public class Draw2D extends CacheableNode {

    public static int anInt1363 = 1623;
    public static boolean aBoolean1364;
    public static boolean aBoolean1365 = true;
    public static byte aByte1366 = 8;
    public static int anInt1367 = 1;
    public static byte aByte1368 = 35;
    public static int[] pixels;
    public static int width;
    public static int height;
    public static int top;
    public static int bottom;
    public static int left;
    public static int right;
    public static int boundX;
    public static int centerX;
    public static int anInt1378;
    public static int anInt1379;

    public Draw2D() {
    }

    public static void bind(int[] pixels, int width, int height) {
            Draw2D.pixels = pixels;
            Draw2D.width = width;
            Draw2D.height = height;
            Draw2D.setBounds(width, height, 0, 0);
    }

    public static void resetBounds() {
            Draw2D.left = 0;
            Draw2D.top = 0;
            Draw2D.right = Draw2D.width;
            Draw2D.bottom = Draw2D.height;
            Draw2D.boundX = Draw2D.right - 1;
            Draw2D.centerX = Draw2D.right / 2;
    }

    public static void setBounds(int j, int i, int k, int l) {
        try {
            if (l < 0) {
                l = 0;
            }
            if (k < 0) {
                k = 0;
            }
            if (j > Draw2D.width) {
                j = Draw2D.width;
            }
            if (i > Draw2D.height) {
                i = Draw2D.height;
            }
            Draw2D.left = l;
            Draw2D.top = k;
            Draw2D.right = j;
            Draw2D.bottom = i;
            Draw2D.boundX = Draw2D.right - 1;
            Draw2D.centerX = Draw2D.right / 2;
            Draw2D.anInt1378 = Draw2D.bottom / 2;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("52567, " + i + ", " + j + ", " + k + ", " + l + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static void clear(byte byte0) {
        try {
            if (byte0 != 127) {
                return;
            }
            int i = Draw2D.width * Draw2D.height;
            for (int j = 0; j < i; j++) {
                Draw2D.pixels[j] = 0;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("10068, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void fillRect(int i, int j, int k, int l, int i1, int j1, boolean flag) {
        try {
            if (j1 < Draw2D.left) {
                i1 -= Draw2D.left - j1;
                j1 = Draw2D.left;
            }
            if (i < Draw2D.top) {
                j -= Draw2D.top - i;
                i = Draw2D.top;
            }
            if (j1 + i1 > Draw2D.right) {
                i1 = Draw2D.right - j1;
            }
            if (i + j > Draw2D.bottom) {
                j = Draw2D.bottom - i;
            }
            int k1 = 256 - k;
            int l1 = (l >> 16 & 0xff) * k;
            int i2 = (l >> 8 & 0xff) * k;
            int j2 = (l & 0xff) * k;
            if (flag) {
                Draw2D.anInt1363 = 122;
            }
            int j3 = Draw2D.width - i1;
            int k3 = j1 + i * Draw2D.width;
            for (int l3 = 0; l3 < j; l3++) {
                for (int i4 = -i1; i4 < 0; i4++) {
                    int k2 = (Draw2D.pixels[k3] >> 16 & 0xff) * k1;
                    int l2 = (Draw2D.pixels[k3] >> 8 & 0xff) * k1;
                    int i3 = (Draw2D.pixels[k3] & 0xff) * k1;
                    int j4 = ((l1 + k2 >> 8) << 16) + ((i2 + l2 >> 8) << 8) + (j2 + i3 >> 8);
                    Draw2D.pixels[k3++] = j4;
                }
                k3 += j3;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("68601, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", " + flag
                    + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void fillRect(int x, int y, int width, int height, int colour, int j) {
        try {
            if (x < Draw2D.left) {
                width -= Draw2D.left - x;
                x = Draw2D.left;
            }
            if (y < Draw2D.top) {
                height -= Draw2D.top - y;
                y = Draw2D.top;
            }
            if (x + width > Draw2D.right) {
                width = Draw2D.right - x;
            }
            if (y + height > Draw2D.bottom) {
                height = Draw2D.bottom - y;
            }
            int k1 = Draw2D.width - width;
            j = 83 / j;
            int l1 = x + y * Draw2D.width;
            for (int i2 = -height; i2 < 0; i2++) {
                for (int j2 = -width; j2 < 0; j2++) {
                    Draw2D.pixels[l1++] = colour;
                }
                l1 += k1;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("43392, " + colour + ", " + j + ", " + y + ", " + height + ", " + x + ", " + width + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void drawRect(int x, int y, int width, int height, int colour, int i) {
        try {
            Draw2D.drawLineX(width, x, colour, true, y);
            Draw2D.drawLineX(width, x, colour, true, (y + height) - 1);
            Draw2D.method416(y, x, colour, height, 0);
            if (i < Draw2D.anInt1367 || i > Draw2D.anInt1367) {
                Draw2D.aBoolean1364 = !Draw2D.aBoolean1364;
            }
            Draw2D.method416(y, (x + width) - 1, colour, height, 0);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("9711, " + i + ", " + x + ", " + width + ", " + colour + ", " + y + ", " + height + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void drawRect(int i, int j, int k, int l, int i1, int j1, int k1) {
        try {
            Draw2D.method415(-985, k, j, i1, j1, l);
            Draw2D.method415(-985, k, j, i1, (j1 + i) - 1, l);
            if (k1 != 0) {
                Draw2D.anInt1363 = -232;
            }
            if (i >= 3) {
                Draw2D.method417(i - 2, j, j1 + 1, i1, 454, k);
                Draw2D.method417(i - 2, j, j1 + 1, i1, 454, (k + l) - 1);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90957, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", " + k1
                    + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public static void drawLineX(int i, int j, int k, boolean flag, int l) {
        try {
            if (!flag) {
                return;
            }
            if (l < Draw2D.top || l >= Draw2D.bottom) {
                return;
            }
            if (j < Draw2D.left) {
                i -= Draw2D.left - j;
                j = Draw2D.left;
            }
            if (j + i > Draw2D.right) {
                i = Draw2D.right - j;
            }
            int i1 = j + l * Draw2D.width;
            for (int j1 = 0; j1 < i; j1++) {
                Draw2D.pixels[i1 + j1] = k;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("26422, " + i + ", " + j + ", " + k + ", " + flag + ", " + l + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void method415(int i, int j, int k, int l, int i1, int j1) {
        try {
            if (i1 < Draw2D.top || i1 >= Draw2D.bottom) {
                return;
            }
            if (j < Draw2D.left) {
                j1 -= Draw2D.left - j;
                j = Draw2D.left;
            }
            if (j + j1 > Draw2D.right) {
                j1 = Draw2D.right - j;
            }
            int k1 = 256 - l;
            while (i >= 0) {
                for (int l1 = 1; l1 > 0; l1++) {
                }
            }
            int i2 = (k >> 16 & 0xff) * l;
            int j2 = (k >> 8 & 0xff) * l;
            int k2 = (k & 0xff) * l;
            int k3 = j + i1 * Draw2D.width;
            for (int l3 = 0; l3 < j1; l3++) {
                int l2 = (Draw2D.pixels[k3] >> 16 & 0xff) * k1;
                int i3 = (Draw2D.pixels[k3] >> 8 & 0xff) * k1;
                int j3 = (Draw2D.pixels[k3] & 0xff) * k1;
                int i4 = ((i2 + l2 >> 8) << 16) + ((j2 + i3 >> 8) << 8) + (k2 + j3 >> 8);
                Draw2D.pixels[k3++] = i4;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("78053, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void method416(int i, int j, int k, int l, int i1) {
        try {
            if (i1 != 0) {
                Draw2D.aBoolean1365 = !Draw2D.aBoolean1365;
            }
            if (j < Draw2D.left || j >= Draw2D.right) {
                return;
            }
            if (i < Draw2D.top) {
                l -= Draw2D.top - i;
                i = Draw2D.top;
            }
            if (i + l > Draw2D.bottom) {
                l = Draw2D.bottom - i;
            }
            int j1 = j + i * Draw2D.width;
            for (int k1 = 0; k1 < l; k1++) {
                Draw2D.pixels[j1 + k1 * Draw2D.width] = k;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("94910, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void method417(int i, int j, int k, int l, int i1, int j1) {
        try {
            if (j1 < Draw2D.left || j1 >= Draw2D.right) {
                return;
            }
            if (k < Draw2D.top) {
                i -= Draw2D.top - k;
                k = Draw2D.top;
            }
            if (k + i > Draw2D.bottom) {
                i = Draw2D.bottom - k;
            }
            int k1 = 256 - l;
            i1 = 37 / i1;
            int l1 = (j >> 16 & 0xff) * l;
            int i2 = (j >> 8 & 0xff) * l;
            int j2 = (j & 0xff) * l;
            int j3 = j1 + k * Draw2D.width;
            for (int k3 = 0; k3 < i; k3++) {
                int k2 = (Draw2D.pixels[j3] >> 16 & 0xff) * k1;
                int l2 = (Draw2D.pixels[j3] >> 8 & 0xff) * k1;
                int i3 = (Draw2D.pixels[j3] & 0xff) * k1;
                int l3 = ((l1 + k2 >> 8) << 16) + ((i2 + l2 >> 8) << 8) + (j2 + i3 >> 8);
                Draw2D.pixels[j3] = l3;
                j3 += Draw2D.width;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("35599, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

}

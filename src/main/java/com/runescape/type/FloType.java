package com.runescape.type;

import com.runescape.cache.FileArchive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class FloType {

    public static boolean aBoolean428 = true;
    public static int anInt429;
    public static FloType[] aClass20Array430;
    public boolean aBoolean427;
    public String aString431;
    public int anInt432;
    public int anInt433;
    public boolean aBoolean434;
    public boolean aBoolean435;
    public int anInt436;
    public int anInt437;
    public int anInt438;
    public int anInt439;
    public int anInt440;
    public int anInt441;

    public FloType() {
        aBoolean427 = false;
        anInt433 = -1;
        aBoolean434 = false;
        aBoolean435 = true;
    }

    public static void method243(boolean flag, FileArchive class47) {
        try {
            Buffer class44_sub3_sub2 = new Buffer(class47.method549("flo.dat", null));
            FloType.anInt429 = class44_sub3_sub2.readUnsignedShort();
            if (FloType.aClass20Array430 == null) {
                FloType.aClass20Array430 = new FloType[FloType.anInt429];
            }
            for (int i = 0; i < FloType.anInt429; i++) {
                if (FloType.aClass20Array430[i] == null) {
                    FloType.aClass20Array430[i] = new FloType();
                }
                FloType.aClass20Array430[i].method244(false, class44_sub3_sub2);
            }
            if (!flag) {
                FloType.aBoolean428 = !FloType.aBoolean428;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("30324, " + flag + ", " + class47 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method244(boolean flag, Buffer class44_sub3_sub2) {
        try {
            if (flag) {
                for (int i = 1; i > 0; i++) {
                }
            }
            do {
                int j = class44_sub3_sub2.readUnsignedByte();
                if (j == 0) {
                    return;
                }
                if (j == 1) {
                    anInt432 = class44_sub3_sub2.method486();
                    method245(anInt432, true);
                } else if (j == 2) {
                    anInt433 = class44_sub3_sub2.readUnsignedByte();
                } else if (j == 3) {
                    aBoolean434 = true;
                } else if (j == 5) {
                    aBoolean435 = false;
                } else if (j == 6) {
                    aString431 = class44_sub3_sub2.readString();
                } else {
                    System.out.println("Error unrecognised config code: " + j);
                }
            } while (true);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("32967, " + flag + ", " + class44_sub3_sub2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method245(int i, boolean flag) {
        try {
            double d = (i >> 16 & 0xff) / 256D;
            double d1 = (i >> 8 & 0xff) / 256D;
            double d2 = (i & 0xff) / 256D;
            double d3 = d;
            if (d1 < d3) {
                d3 = d1;
            }
            if (d2 < d3) {
                d3 = d2;
            }
            double d4 = d;
            if (d1 > d4) {
                d4 = d1;
            }
            if (d2 > d4) {
                d4 = d2;
            }
            double d5 = 0.0D;
            double d6 = 0.0D;
            double d7 = (d3 + d4) / 2D;
            if (d3 != d4) {
                if (d7 < 0.5D) {
                    d6 = (d4 - d3) / (d4 + d3);
                }
                if (d7 >= 0.5D) {
                    d6 = (d4 - d3) / (2D - d4 - d3);
                }
                if (d == d4) {
                    d5 = (d1 - d2) / (d4 - d3);
                } else if (d1 == d4) {
                    d5 = 2D + (d2 - d) / (d4 - d3);
                } else if (d2 == d4) {
                    d5 = 4D + (d - d1) / (d4 - d3);
                }
            }
            d5 /= 6D;
            anInt436 = (int) (d5 * 256D);
            if (!flag) {
                return;
            }
            anInt437 = (int) (d6 * 256D);
            anInt438 = (int) (d7 * 256D);
            if (anInt437 < 0) {
                anInt437 = 0;
            } else if (anInt437 > 255) {
                anInt437 = 255;
            }
            if (anInt438 < 0) {
                anInt438 = 0;
            } else if (anInt438 > 255) {
                anInt438 = 255;
            }
            if (d7 > 0.5D) {
                anInt440 = (int) ((1.0D - d7) * d6 * 512D);
            } else {
                anInt440 = (int) (d7 * d6 * 512D);
            }
            if (anInt440 < 1) {
                anInt440 = 1;
            }
            anInt439 = (int) (d5 * anInt440);
            int j = (anInt436 + (int) (Math.random() * 16D)) - 8;
            if (j < 0) {
                j = 0;
            } else if (j > 255) {
                j = 255;
            }
            int k = (anInt437 + (int) (Math.random() * 48D)) - 24;
            if (k < 0) {
                k = 0;
            } else if (k > 255) {
                k = 255;
            }
            int l = (anInt438 + (int) (Math.random() * 48D)) - 24;
            if (l < 0) {
                l = 0;
            } else if (l > 255) {
                l = 255;
            }
            anInt441 = method246(j, k, l);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("3110, " + i + ", " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method246(int i, int j, int k) {
        if (k > 179) {
            j /= 2;
        }
        if (k > 192) {
            j /= 2;
        }
        if (k > 217) {
            j /= 2;
        }
        if (k > 243) {
            j /= 2;
        }
        int l = (i / 4 << 10) + (j / 32 << 7) + k / 2;
        return l;
    }

}

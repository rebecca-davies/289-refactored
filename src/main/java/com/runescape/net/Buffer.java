package com.runescape.net;

import com.runescape.collection.CacheableNode;
import com.runescape.collection.LinkedList;
import com.runescape.util.SignLink;

import java.math.BigInteger;

public class Buffer extends CacheableNode {

    public static int anInt1390 = 8;
    public static int anIntArray1394[];
    public static int anIntArray1395[] = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767,
            65535, 0x1ffff, 0x3ffff, 0x7ffff, 0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff,
            0x7ffffff, 0xfffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, -1};
    public static int anInt1397;
    public static int anInt1398;
    public static int anInt1399;
    public static LinkedList aClass28_1400 = new LinkedList(-199);
    public static LinkedList aClass28_1401 = new LinkedList(-199);
    public static LinkedList aClass28_1402 = new LinkedList(-199);
    public static char aCharArray1403[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '+', '/'};
    public static int anInt1404;

    static {
        Buffer.anIntArray1394 = new int[256];
        for (int j = 0; j < 256; j++) {
            int i = j;
            for (int k = 0; k < 8; k++) {
                if ((i & 1) == 1) {
                    i = i >>> 1 ^ 0xedb88320;
                } else {
                    i >>>= 1;
                }
            }
            Buffer.anIntArray1394[j] = i;
        }
    }

    public int anInt1380;
    public byte aByte1381;
    public int anInt1382;
    public int anInt1383;
    public int anInt1384;
    public boolean aBoolean1385;
    public int anInt1386;
    public int anInt1387;
    public boolean aBoolean1388;
    public boolean aBoolean1389;
    public byte payload[];
    public int offset;
    public int anInt1393;
    public ISAACCipher aClass46_1396;

    public Buffer(byte byte0) {
        aByte1381 = 95;
        anInt1382 = -731;
        anInt1383 = 1623;
        anInt1384 = 772;
        aBoolean1385 = false;
        anInt1386 = -139;
        anInt1387 = 1;
        aBoolean1388 = false;
        aBoolean1389 = false;
        try {
            if (byte0 == 8) {
                byte0 = 0;
                return;
            } else {
                anInt1386 = 133;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("23990, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public Buffer(byte abyte0[]) {
        aByte1381 = 95;
        anInt1382 = -731;
        anInt1383 = 1623;
        anInt1384 = 772;
        aBoolean1385 = false;
        anInt1386 = -139;
        anInt1387 = 1;
        aBoolean1388 = false;
        aBoolean1389 = false;
        try {
            payload = abyte0;
            offset = 0;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("15004, " + abyte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static Buffer method470(int i, int j) {
        try {
            synchronized (Buffer.aClass28_1401) {
                Buffer class44_sub3_sub2_2 = null;
                if (j == 0 && Buffer.anInt1397 > 0) {
                    Buffer.anInt1397--;
                    class44_sub3_sub2_2 = (Buffer) Buffer.aClass28_1400.method258();
                } else if (j == 1 && Buffer.anInt1398 > 0) {
                    Buffer.anInt1398--;
                    class44_sub3_sub2_2 = (Buffer) Buffer.aClass28_1401.method258();
                } else if (j == 2 && Buffer.anInt1399 > 0) {
                    Buffer.anInt1399--;
                    class44_sub3_sub2_2 = (Buffer) Buffer.aClass28_1402.method258();
                }
                if (class44_sub3_sub2_2 != null) {
                    class44_sub3_sub2_2.offset = 0;
                    Buffer class44_sub3_sub2 = class44_sub3_sub2_2;
                    return class44_sub3_sub2;
                }
            }
            if (i >= 0) {
                Buffer.anInt1390 = -400;
            }
            Buffer class44_sub3_sub2_1 = new Buffer((byte) 8);
            class44_sub3_sub2_1.offset = 0;
            if (j == 0) {
                class44_sub3_sub2_1.payload = new byte[100];
            } else if (j == 1) {
                class44_sub3_sub2_1.payload = new byte[5000];
            } else {
                class44_sub3_sub2_1.payload = new byte[30000];
            }
            return class44_sub3_sub2_1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("924, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void writePacket(int packetId) {
        System.out.println("Sending packet " + packetId);
        try {
            payload[offset++] = (byte) (packetId + aClass46_1396.method545());

        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("86638, " + packetId + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void writeByte(int i) {
        payload[offset++] = (byte) i;
    }

    public void writeShort(int i) {
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
    }

    public void putLEShort(int i, boolean flag) {
        try {
            payload[offset++] = (byte) i;
            payload[offset++] = (byte) (i >> 8);
            if (flag) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("86335, " + i + ", " + flag + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method475(int i) {
        payload[offset++] = (byte) (i >> 16);
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
    }

    public void putInt(int i) {
        payload[offset++] = (byte) (i >> 24);
        payload[offset++] = (byte) (i >> 16);
        payload[offset++] = (byte) (i >> 8);
        payload[offset++] = (byte) i;
    }

    public void putLEInt(int i, int j) {
        try {
            payload[offset++] = (byte) j;
            payload[offset++] = (byte) (j >> 8);
            if (i != 26965) {
                return;
            } else {
                payload[offset++] = (byte) (j >> 16);
                payload[offset++] = (byte) (j >> 24);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("41231, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method478(long l, boolean flag) {
        try {
            payload[offset++] = (byte) (int) (l >> 56);
            payload[offset++] = (byte) (int) (l >> 48);
            payload[offset++] = (byte) (int) (l >> 40);
            payload[offset++] = (byte) (int) (l >> 32);
            payload[offset++] = (byte) (int) (l >> 24);
            payload[offset++] = (byte) (int) (l >> 16);
            if (!flag) {
                return;
            }
            payload[offset++] = (byte) (int) (l >> 8);
            payload[offset++] = (byte) (int) l;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("85019, " + l + ", " + flag + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void putString(String value) {
        System.arraycopy(value.getBytes(), 0, payload, offset, value.length());
        offset += value.length();
        payload[offset++] = 10;
    }

    public void method480(byte abyte0[], int i, int j, boolean flag) {
        try {
            if (!flag) {
                anInt1386 = 371;
            }
            for (int k = j; k < j + i; k++) {
                payload[offset++] = abyte0[k];
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("73937, " + abyte0 + ", " + i + ", " + j + ", " + flag + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method481(int i, int j) {
        try {
            if (j != 0) {
                for (int k = 1; k > 0; k++) {
                }
            }
            payload[offset - i - 1] = (byte) i;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("97780, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int readUnsignedByte() {
        return payload[offset++] & 0xff;
    }

    public byte readByte() {
        return payload[offset++];
    }

    public int readUnsignedShort() {
        offset += 2;
        return ((payload[offset - 2] & 0xff) << 8) + (payload[offset - 1] & 0xff);
    }

    public int method485() {
        offset += 2;
        int i = ((payload[offset - 2] & 0xff) << 8) + (payload[offset - 1] & 0xff);
        if (i > 32767) {
            i -= 0x10000;
        }
        return i;
    }

    public int method486() {
        offset += 3;
        return ((payload[offset - 3] & 0xff) << 16) + ((payload[offset - 2] & 0xff) << 8)
                + (payload[offset - 1] & 0xff);
    }

    public int readInt() {
        offset += 4;
        return ((payload[offset - 4] & 0xff) << 24) + ((payload[offset - 3] & 0xff) << 16)
                + ((payload[offset - 2] & 0xff) << 8) + (payload[offset - 1] & 0xff);
    }

    public long readLong(boolean flag) {
        try {
            if (!flag) {
                anInt1380 = 183;
            }
            long l = readInt() & 0xffffffffL;
            long l1 = readInt() & 0xffffffffL;
            return (l << 32) + l1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("82572, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public String readString() {
        int i = offset;
        while (payload[offset++] != 10) {
            ;
        }
        return new String(payload, i, offset - i - 1);
    }

    public byte[] method490(int i) {
        try {
            if (i != 44692) {
                Buffer.anInt1390 = 448;
            }
            int j = offset;
            while (payload[offset++] != 10) {
                ;
            }
            byte abyte0[] = new byte[offset - j - 1];
            for (int k = j; k < offset - 1; k++) {
                abyte0[k - j] = payload[k];
            }
            return abyte0;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("67289, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method491(byte byte0, byte abyte0[], int i, int j) {
        try {
            if (byte0 != aByte1381) {
                anInt1387 = -447;
            }
            for (int k = i; k < i + j; k++) {
                abyte0[k] = payload[offset++];
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("99457, " + byte0 + ", " + abyte0 + ", " + i + ", " + j + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method492(byte byte0) {
        try {
            if (byte0 != -51) {
                aBoolean1389 = !aBoolean1389;
            }
            anInt1393 = offset * 8;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96920, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int method493(int i, boolean flag) {
        try {
            if (flag) {
                aBoolean1389 = !aBoolean1389;
            }
            int j = anInt1393 >> 3;
            int k = 8 - (anInt1393 & 7);
            int l = 0;
            anInt1393 += i;
            for (; i > k; k = 8) {
                l += (payload[j++] & Buffer.anIntArray1395[k]) << i - k;
                i -= k;
            }
            if (i == k) {
                l += payload[j] & Buffer.anIntArray1395[k];
            } else {
                l += payload[j] >> k - i & Buffer.anIntArray1395[i];
            }
            return l;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("75102, " + i + ", " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method494(byte byte0) {
        try {
            offset = (anInt1393 + 7) / 8;
            if (byte0 != 4) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("49000, " + byte0 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public int method495() {
        int i = payload[offset] & 0xff;
        if (i < 128) {
            return readUnsignedByte() - 64;
        } else {
            return readUnsignedShort() - 49152;
        }
    }

    public int method496() {
        int i = payload[offset] & 0xff;
        if (i < 128) {
            return readUnsignedByte();
        } else {
            return readUnsignedShort() - 32768;
        }
    }

    public void method497(BigInteger biginteger, BigInteger biginteger1, int i) {
        try {
            int j = offset;
            offset = 0;
            byte abyte0[] = new byte[j];
            method491((byte) 95, abyte0, 0, j);
            BigInteger biginteger2 = new BigInteger(abyte0);
            BigInteger biginteger3 = biginteger2.modPow(biginteger1, biginteger);
            byte abyte1[] = biginteger3.toByteArray();
            offset = 0;
            writeByte(abyte1.length);
            method480(abyte1, abyte1.length, 0, true);
            if (i < 0 || i > 0) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("81066, " + biginteger + ", " + biginteger1 + ", " + i + ", "
                    + runtimeexception.toString());
            throw new RuntimeException();
        }
    }
}

package com.runescape.util;

public class TextUtils {

    public static int anInt798 = 101;
    public static byte aByte799 = 5;
    public static int anInt800 = 218;
    public static boolean aBoolean801;
    public static int anInt802 = 783;
    public static boolean aBoolean803 = true;
    public static int anInt804 = -940;
    public static char[] aCharArray805 = {'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9'};

    public static long encodeBase37(String s) {
        long l = 0L;
        for (int i = 0; i < s.length() && i < 12; i++) {
            char c = s.charAt(i);
            l *= 37L;
            if (c >= 'A' && c <= 'Z') {
                l += (1 + c) - 65;
            } else if (c >= 'a' && c <= 'z') {
                l += (1 + c) - 97;
            } else if (c >= '0' && c <= '9') {
                l += (27 + c) - 48;
            }
        }
        for (; l % 37L == 0L && l != 0L; l /= 37L) {
        }
        return l;
    }

    public static String longToName(long l) {
            if (l <= 0L || l >= 0x5b5b57f8a98a5dd1L) {
                return "invalid_name";
            }
            if (l % 37L == 0L) {
                return "invalid_name";
            }
            int i = 0;
            char[] ac = new char[12];
            while (l != 0L) {
                long l1 = l;
                l /= 37L;
                ac[11 - i++] = TextUtils.aCharArray805[(int) (l1 - l * 37L)];
            }
            return new String(ac, 12 - i, i);
    }

    public static long method552(int i, String s) {
        try {
            s = s.toUpperCase();
            long l = 0L;
            if (i != -5562) {
                TextUtils.anInt802 = -496;
            }
            for (int j = 0; j < s.length(); j++) {
                l = (l * 61L + s.charAt(j)) - 32L;
                l = l + (l >> 56) & 0xffffffffffffffL;
            }
            return l;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("8420, " + i + ", " + s + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static String method553(int i, byte byte0) {
        try {
            if (byte0 != 1) {
                for (int j = 1; j > 0; j++) {
                }
            }
            return (i >> 24 & 0xff) + "." + (i >> 16 & 0xff) + "." + (i >> 8 & 0xff) + "." + (i & 0xff);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("43699, " + i + ", " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static String formatName(String s) {
            if (s.length() > 0) {
                char[] ac = s.toCharArray();
                for (int i = 0; i < ac.length; i++) {
                    if (ac[i] == '_') {
                        ac[i] = ' ';
                        if (i + 1 < ac.length && ac[i + 1] >= 'a' && ac[i + 1] <= 'z') {
                            ac[i + 1] = (char) ((ac[i + 1] + 65) - 97);
                        }
                    }
                }
                if (ac[0] >= 'a' && ac[0] <= 'z') {
                    ac[0] = (char) ((ac[0] + 65) - 97);
                }
                return new String(ac);
            } else {
                return s;
            }
    }

    public static String toAsterisks(String s) {
        try {
            StringBuffer stringbuffer = new StringBuffer();
            for (int j = 0; j < s.length(); j++) {
                stringbuffer.append("*");
            }
            return stringbuffer.toString();
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("15483, " + s + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

}

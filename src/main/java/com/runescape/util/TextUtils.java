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

    public static String longToName(long encoded) {
            if (encoded <= 0L || encoded >= 0x5b5b57f8a98a5dd1L) {
                return "invalid_name";
            }
            if (encoded % 37L == 0L) {
                return "invalid_name";
            }
            int i = 0;
            char[] chars = new char[12];
            while (encoded != 0L) {
                long l1 = encoded;
                encoded /= 37L;
                chars[11 - i++] = TextUtils.aCharArray805[(int) (l1 - encoded * 37L)];
            }
            return new String(chars, 12 - i, i);
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

    public static String formatName(String name) {
            if (name.length() > 0) {
                char[] chars = name.toCharArray();
                for (int index = 0; index < chars.length; index++) {
                    if (chars[index] == '_') {
                        chars[index] = ' ';
                        if (index + 1 < chars.length && chars[index + 1] >= 'a' && chars[index + 1] <= 'z') {
                            chars[index + 1] = (char) ((chars[index + 1] + 65) - 97);
                        }
                    }
                }
                if (chars[0] >= 'a' && chars[0] <= 'z') {
                    chars[0] = (char) ((chars[0] + 65) - 97);
                }
                return new String(chars);
            } else {
                return name;
            }
    }

    public static String toAsterisks(String string) {
            StringBuffer censor = new StringBuffer();
            for (int index = 0; index < censor.length(); index++) {
                censor.append("*");
            }
            return censor.toString();
    }

}

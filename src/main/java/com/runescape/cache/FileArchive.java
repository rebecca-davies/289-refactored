package com.runescape.cache;

import com.runescape.cache.bzip.BZip2Decompressor;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class FileArchive {

    public int anInt789;
    public int anInt790;
    public byte aByteArray791[];
    public int anInt792;
    public int anIntArray793[];
    public int anIntArray794[];
    public int anIntArray795[];
    public int anIntArray796[];
    public boolean aBoolean797;

    public FileArchive(byte abyte0[], int i) {
        anInt789 = -550;
        anInt790 = 30967;
        try {
            method548((byte) 9, abyte0);
            if (i != 0) {
                for (int j = 1; j > 0; j++) {
                }
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("71105, " + abyte0 + ", " + i + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method548(byte byte0, byte abyte0[]) {
        try {
            Buffer class44_sub3_sub2 = new Buffer(abyte0);
            int i = class44_sub3_sub2.method486();
            int j = class44_sub3_sub2.method486();
            if (j != i) {
                byte abyte1[] = new byte[i];
                BZip2Decompressor.method329(abyte1, i, abyte0, j, 6);
                aByteArray791 = abyte1;
                class44_sub3_sub2 = new Buffer(aByteArray791);
                aBoolean797 = true;
            } else {
                aByteArray791 = abyte0;
                aBoolean797 = false;
            }
            anInt792 = class44_sub3_sub2.readUnsignedShort();
            anIntArray793 = new int[anInt792];
            if (byte0 == 9) {
                byte0 = 0;
            } else {
                return;
            }
            anIntArray794 = new int[anInt792];
            anIntArray795 = new int[anInt792];
            anIntArray796 = new int[anInt792];
            int k = class44_sub3_sub2.offset + anInt792 * 10;
            for (int l = 0; l < anInt792; l++) {
                anIntArray793[l] = class44_sub3_sub2.readInt();
                anIntArray794[l] = class44_sub3_sub2.method486();
                anIntArray795[l] = class44_sub3_sub2.method486();
                anIntArray796[l] = k;
                k += anIntArray795[l];
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("9624, " + byte0 + ", " + abyte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public byte[] method549(String s, byte abyte0[]) {
        int i = 0;
        s = s.toUpperCase();
        for (int j = 0; j < s.length(); j++) {
            i = (i * 61 + s.charAt(j)) - 32;
        }
        for (int k = 0; k < anInt792; k++) {
            if (anIntArray793[k] == i) {
                if (abyte0 == null) {
                    abyte0 = new byte[anIntArray794[k]];
                }
                if (!aBoolean797) {
                    BZip2Decompressor.method329(abyte0, anIntArray794[k], aByteArray791, anIntArray795[k],
                            anIntArray796[k]);
                } else {
                    for (int l = 0; l < anIntArray794[k]; l++) {
                        abyte0[l] = aByteArray791[anIntArray796[k] + l];
                    }
                }
                return abyte0;
            }
        }
        return null;
    }
}

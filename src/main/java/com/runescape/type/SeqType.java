package com.runescape.type;

import com.runescape.cache.FileArchive;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

public class SeqType {

    public static boolean aBoolean506 = true;
    public static int anInt507;
    public static SeqType[] instances;
    public static int anInt524;
    public boolean aBoolean504;
    public byte aByte505;
    public int anInt509;
    public int[] primaryFrames;
    public int[] secondaryFrames;
    public int[] anIntArray512;
    public int anInt513;
    public int[] anIntArray514;
    public boolean aBoolean515;
    public int anInt516;
    public int anInt517;
    public int anInt518;
    public int anInt519;
    public int anInt520;
    public int anInt521;
    public int anInt522;
    public int anInt523;

    public SeqType() {
        aBoolean504 = false;
        aByte505 = 4;
        anInt513 = -1;
        aBoolean515 = false;
        anInt516 = 5;
        anInt517 = -1;
        anInt518 = -1;
        anInt519 = 99;
        anInt520 = -1;
        anInt521 = -1;
    }

    public static void method253(boolean flag, FileArchive class47) {
        try {
            Buffer class44_sub3_sub2 = new Buffer(class47.method549("seq.dat", null));
            SeqType.anInt507 = class44_sub3_sub2.readUnsignedShort();
            if (SeqType.instances == null) {
                SeqType.instances = new SeqType[SeqType.anInt507];
            }
            for (int i = 0; i < SeqType.anInt507; i++) {
                if (SeqType.instances[i] == null) {
                    SeqType.instances[i] = new SeqType();
                }
                SeqType.instances[i].method255(false, class44_sub3_sub2);
            }
            if (!flag) {
                SeqType.aBoolean506 = !SeqType.aBoolean506;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90750, " + flag + ", " + class47 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public int method254(int i, int j) {
        try {
            if (j != 24425) {
                for (int k = 1; k > 0; k++) {
                }
            }
            int l = anIntArray512[i];
            if (l == 0) {
                SeqFrame class11 = SeqFrame.method210(primaryFrames[i], aByte505);
                if (class11 != null) {
                    l = anIntArray512[i] = class11.anInt265;
                }
            }
            if (l == 0) {
                l = 1;
            }
            return l;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("17518, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method255(boolean flag, Buffer class44_sub3_sub2) {
        try {
            if (flag) {
                throw new NullPointerException();
            }
            do {
                int i = class44_sub3_sub2.readUnsignedByte();
                if (i == 0) {
                    break;
                }
                if (i == 1) {
                    anInt509 = class44_sub3_sub2.readUnsignedByte();
                    primaryFrames = new int[anInt509];
                    secondaryFrames = new int[anInt509];
                    anIntArray512 = new int[anInt509];
                    for (int j = 0; j < anInt509; j++) {
                        primaryFrames[j] = class44_sub3_sub2.readUnsignedShort();
                        secondaryFrames[j] = class44_sub3_sub2.readUnsignedShort();
                        if (secondaryFrames[j] == 65535) {
                            secondaryFrames[j] = -1;
                        }
                        anIntArray512[j] = class44_sub3_sub2.readUnsignedShort();
                    }
                } else if (i == 2) {
                    anInt513 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 3) {
                    int k = class44_sub3_sub2.readUnsignedByte();
                    anIntArray514 = new int[k + 1];
                    for (int l = 0; l < k; l++) {
                        anIntArray514[l] = class44_sub3_sub2.readUnsignedByte();
                    }
                    anIntArray514[k] = 0x98967f;
                } else if (i == 4) {
                    aBoolean515 = true;
                } else if (i == 5) {
                    anInt516 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 6) {
                    anInt517 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 7) {
                    anInt518 = class44_sub3_sub2.readUnsignedShort();
                } else if (i == 8) {
                    anInt519 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 9) {
                    anInt520 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 10) {
                    anInt521 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 11) {
                    anInt522 = class44_sub3_sub2.readUnsignedByte();
                } else if (i == 12) {
                    anInt523 = class44_sub3_sub2.readInt();
                } else {
                    System.out.println("Error unrecognised seq config code: " + i);
                }
            } while (true);
            if (anInt509 == 0) {
                anInt509 = 1;
                primaryFrames = new int[1];
                primaryFrames[0] = -1;
                secondaryFrames = new int[1];
                secondaryFrames[0] = -1;
                anIntArray512 = new int[1];
                anIntArray512[0] = -1;
            }
            if (anInt520 == -1) {
                if (anIntArray514 != null) {
                    anInt520 = 2;
                } else {
                    anInt520 = 0;
                }
            }
            if (anInt521 == -1) {
                if (anIntArray514 != null) {
                    anInt521 = 2;
                    return;
                } else {
                    anInt521 = 0;
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("13368, " + flag + ", " + class44_sub3_sub2 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

}

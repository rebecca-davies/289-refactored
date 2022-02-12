package com.runescape.renderable;

import com.runescape.Game;
import com.runescape.collection.Cache;
import com.runescape.graphic.Model;
import com.runescape.net.Buffer;
import com.runescape.type.*;
import com.runescape.util.SignLink;
import com.runescape.util.TextUtils;

public class Player extends Actor {

    public static Cache aClass39_1696 = new Cache((byte) 7, 260);
    public int anInt1670;
    public boolean aBoolean1671;
    public String aString1672;
    public boolean aBoolean1673;
    public int anInt1674;
    public int anInt1675;
    public int anIntArray1676[];
    public int anIntArray1677[];
    public int anInt1678;
    public int anInt1679;
    public long aLong1680;
    public int anInt1681;
    public int anInt1682;
    public int anInt1683;
    public int anInt1684;
    public int anInt1685;
    public int anInt1686;
    public Model aClass44_Sub3_Sub4_Sub4_1687;
    public int anInt1688;
    public int anInt1689;
    public int anInt1690;
    public int anInt1691;
    public boolean aBoolean1692;
    public long aLong1693;
    public NpcType aClass12_1694;
    public int anInt1695;

    public Player() {
        aBoolean1671 = false;
        aBoolean1673 = false;
        anIntArray1676 = new int[12];
        anIntArray1677 = new int[5];
        aBoolean1692 = false;
        aLong1693 = -1L;
    }

    public void method537(boolean flag, Buffer class44_sub3_sub2) {
        try {
            if (flag) {
                aBoolean1671 = !aBoolean1671;
            }
            class44_sub3_sub2.offset = 0;
            anInt1674 = class44_sub3_sub2.readUnsignedByte();
            anInt1675 = class44_sub3_sub2.readUnsignedByte();
            aClass12_1694 = null;
            anInt1695 = 0;
            for (int i = 0; i < 12; i++) {
                int j = class44_sub3_sub2.readUnsignedByte();
                if (j == 0) {
                    anIntArray1676[i] = 0;
                    continue;
                }
                int l = class44_sub3_sub2.readUnsignedByte();
                anIntArray1676[i] = (j << 8) + l;
                if (i == 0 && anIntArray1676[0] == 65535) {
                    aClass12_1694 = NpcType.method214(class44_sub3_sub2.readUnsignedShort());
                    break;
                }
                if (anIntArray1676[i] >= 512 && anIntArray1676[i] - 512 < ObjType.anInt323) {
                    int k1 = ObjType.method220(anIntArray1676[i] - 512).anInt368;
                    if (k1 != 0) {
                        anInt1695 = k1;
                    }
                }
            }
            for (int k = 0; k < 5; k++) {
                int i1 = class44_sub3_sub2.readUnsignedByte();
                if (i1 < 0 || i1 >= Game.anIntArrayArray1073[k].length) {
                    i1 = 0;
                }
                anIntArray1677[k] = i1;
            }
            super.anInt1620 = class44_sub3_sub2.readUnsignedShort();
            if (super.anInt1620 == 65535) {
                super.anInt1620 = -1;
            }
            super.anInt1621 = class44_sub3_sub2.readUnsignedShort();
            if (super.anInt1621 == 65535) {
                super.anInt1621 = -1;
            }
            super.anInt1622 = class44_sub3_sub2.readUnsignedShort();
            if (super.anInt1622 == 65535) {
                super.anInt1622 = -1;
            }
            super.anInt1623 = class44_sub3_sub2.readUnsignedShort();
            if (super.anInt1623 == 65535) {
                super.anInt1623 = -1;
            }
            super.anInt1624 = class44_sub3_sub2.readUnsignedShort();
            if (super.anInt1624 == 65535) {
                super.anInt1624 = -1;
            }
            super.anInt1625 = class44_sub3_sub2.readUnsignedShort();
            if (super.anInt1625 == 65535) {
                super.anInt1625 = -1;
            }
            super.anInt1626 = class44_sub3_sub2.readUnsignedShort();
            if (super.anInt1626 == 65535) {
                super.anInt1626 = -1;
            }
            aString1672 = TextUtils.method554(TextUtils.method551(class44_sub3_sub2.readLong(true), true), true);
            anInt1678 = class44_sub3_sub2.readUnsignedByte();
            anInt1679 = class44_sub3_sub2.readUnsignedShort();
            aBoolean1673 = true;
            aLong1680 = 0L;
            for (int j1 = 0; j1 < 12; j1++) {
                aLong1680 <<= 4;
                if (anIntArray1676[j1] >= 256) {
                    aLong1680 += anIntArray1676[j1] - 256;
                }
            }
            if (anIntArray1676[0] >= 256) {
                aLong1680 += anIntArray1676[0] - 256 >> 4;
            }
            if (anIntArray1676[1] >= 256) {
                aLong1680 += anIntArray1676[1] - 256 >> 8;
            }
            for (int l1 = 0; l1 < 5; l1++) {
                aLong1680 <<= 3;
                aLong1680 += anIntArray1677[l1];
            }
            aLong1680 <<= 1;
            aLong1680 += anInt1674;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("26459, " + flag + ", " + class44_sub3_sub2 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public Model getRotatedModel(int i) {
        try {
            if (!aBoolean1673) {
                return null;
            }
            Model class44_sub3_sub4_sub4 = method538(false);
            if (i != -37770) {
                throw new NullPointerException();
            }
            if (class44_sub3_sub4_sub4 == null) {
                return null;
            }
            super.anInt1661 = ((Renderable) (class44_sub3_sub4_sub4)).anInt1412;
            class44_sub3_sub4_sub4.aBoolean1568 = true;
            if (aBoolean1692) {
                return class44_sub3_sub4_sub4;
            }
            if (super.anInt1648 != -1 && super.anInt1649 != -1) {
                SpotAnimType class32 = SpotAnimType.cache[super.anInt1648];
                Model class44_sub3_sub4_sub4_2 = class32.method271();
                if (class44_sub3_sub4_sub4_2 != null) {
                    Model class44_sub3_sub4_sub4_3 = new Model(class44_sub3_sub4_sub4_2, SeqFrame.method211(
                            super.anInt1649, 0), false, anInt1670, true);
                    class44_sub3_sub4_sub4_3.method519(-super.anInt1652, 0, (byte) 2, 0);
                    class44_sub3_sub4_sub4_3.method513((byte) 3);
                    class44_sub3_sub4_sub4_3.method514(class32.aClass26_563.anIntArray510[super.anInt1649], 188);
                    class44_sub3_sub4_sub4_3.anIntArrayArray1567 = null;
                    class44_sub3_sub4_sub4_3.anIntArrayArray1566 = null;
                    if (class32.anInt566 != 128 || class32.anInt567 != 128) {
                        class44_sub3_sub4_sub4_3.method522(class32.anInt566, class32.anInt566, class32.anInt567,
                                (byte) 31);
                    }
                    class44_sub3_sub4_sub4_3.method523(64 + class32.anInt569, 850 + class32.anInt570, -30, -50, -30,
                            true);
                    Model aclass44_sub3_sub4_sub4_1[] = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_3};
                    class44_sub3_sub4_sub4 = new Model(true, 0, aclass44_sub3_sub4_sub4_1, 2);
                }
            }
            if (aClass44_Sub3_Sub4_Sub4_1687 != null) {
                if (Game.anInt1240 >= anInt1683) {
                    aClass44_Sub3_Sub4_Sub4_1687 = null;
                }
                if (Game.anInt1240 >= anInt1682 && Game.anInt1240 < anInt1683) {
                    Model class44_sub3_sub4_sub4_1 = aClass44_Sub3_Sub4_Sub4_1687;
                    class44_sub3_sub4_sub4_1.method519(anInt1685 - anInt1681, anInt1684 - super.x, (byte) 2,
                            anInt1686 - super.z);
                    if (super.anInt1662 == 512) {
                        class44_sub3_sub4_sub4_1.method517(0);
                        class44_sub3_sub4_sub4_1.method517(0);
                        class44_sub3_sub4_sub4_1.method517(0);
                    } else if (super.anInt1662 == 1024) {
                        class44_sub3_sub4_sub4_1.method517(0);
                        class44_sub3_sub4_sub4_1.method517(0);
                    } else if (super.anInt1662 == 1536) {
                        class44_sub3_sub4_sub4_1.method517(0);
                    }
                    Model aclass44_sub3_sub4_sub4[] = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_1};
                    class44_sub3_sub4_sub4 = new Model(true, 0, aclass44_sub3_sub4_sub4, 2);
                    if (super.anInt1662 == 512) {
                        class44_sub3_sub4_sub4_1.method517(0);
                    } else if (super.anInt1662 == 1024) {
                        class44_sub3_sub4_sub4_1.method517(0);
                        class44_sub3_sub4_sub4_1.method517(0);
                    } else if (super.anInt1662 == 1536) {
                        class44_sub3_sub4_sub4_1.method517(0);
                        class44_sub3_sub4_sub4_1.method517(0);
                        class44_sub3_sub4_sub4_1.method517(0);
                    }
                    class44_sub3_sub4_sub4_1.method519(anInt1681 - anInt1685, super.x - anInt1684, (byte) 2,
                            super.z - anInt1686);
                }
            }
            class44_sub3_sub4_sub4.aBoolean1568 = true;
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("67533, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public Model method538(boolean flag) {
        try {
            if (aClass12_1694 != null) {
                int i = -1;
                if (super.anInt1643 >= 0 && super.anInt1646 == 0) {
                    i = SeqType.cache[super.anInt1643].anIntArray510[super.anInt1644];
                } else if (super.anInt1640 >= 0) {
                    i = SeqType.cache[super.anInt1640].anIntArray510[super.anInt1641];
                }
                Model class44_sub3_sub4_sub4 = aClass12_1694.method216(0, -1, i, null);
                return class44_sub3_sub4_sub4;
            }
            long l = aLong1680;
            int j = -1;
            int k = -1;
            int i1 = -1;
            int j1 = -1;
            if (super.anInt1643 >= 0 && super.anInt1646 == 0) {
                SeqType class26 = SeqType.cache[super.anInt1643];
                j = class26.anIntArray510[super.anInt1644];
                if (super.anInt1640 >= 0 && super.anInt1640 != super.anInt1620) {
                    k = SeqType.cache[super.anInt1640].anIntArray510[super.anInt1641];
                }
                if (class26.anInt517 >= 0) {
                    i1 = class26.anInt517;
                    l += i1 - anIntArray1676[5] << 40;
                }
                if (class26.anInt518 >= 0) {
                    j1 = class26.anInt518;
                    l += j1 - anIntArray1676[3] << 48;
                }
            } else if (super.anInt1640 >= 0) {
                j = SeqType.cache[super.anInt1640].anIntArray510[super.anInt1641];
            }
            Model class44_sub3_sub4_sub4_1 = (Model) Player.aClass39_1696.method339(l);
            if (flag) {
                aBoolean1671 = !aBoolean1671;
            }
            if (class44_sub3_sub4_sub4_1 == null) {
                boolean flag1 = false;
                for (int k1 = 0; k1 < 12; k1++) {
                    int i2 = anIntArray1676[k1];
                    if (j1 >= 0 && k1 == 3) {
                        i2 = j1;
                    }
                    if (i1 >= 0 && k1 == 5) {
                        i2 = i1;
                    }
                    if (i2 >= 256 && i2 < 512 && !IDKType.cache[i2 - 256].method249(9)) {
                        flag1 = true;
                    }
                    if (i2 >= 512 && !ObjType.method220(i2 - 512).method227(false, anInt1674)) {
                        flag1 = true;
                    }
                }
                if (flag1) {
                    if (aLong1693 != -1L) {
                        class44_sub3_sub4_sub4_1 = (Model) Player.aClass39_1696.method339(aLong1693);
                    }
                    if (class44_sub3_sub4_sub4_1 == null) {
                        return null;
                    }
                }
            }
            if (class44_sub3_sub4_sub4_1 == null) {
                Model aclass44_sub3_sub4_sub4[] = new Model[12];
                int l1 = 0;
                for (int j2 = 0; j2 < 12; j2++) {
                    int k2 = anIntArray1676[j2];
                    if (j1 >= 0 && j2 == 3) {
                        k2 = j1;
                    }
                    if (i1 >= 0 && j2 == 5) {
                        k2 = i1;
                    }
                    if (k2 >= 256 && k2 < 512) {
                        Model class44_sub3_sub4_sub4_3 = IDKType.cache[k2 - 256].method250(0);
                        if (class44_sub3_sub4_sub4_3 != null) {
                            aclass44_sub3_sub4_sub4[l1++] = class44_sub3_sub4_sub4_3;
                        }
                    }
                    if (k2 >= 512) {
                        Model class44_sub3_sub4_sub4_4 = ObjType.method220(k2 - 512).method228(anInt1674, 0);
                        if (class44_sub3_sub4_sub4_4 != null) {
                            aclass44_sub3_sub4_sub4[l1++] = class44_sub3_sub4_sub4_4;
                        }
                    }
                }
                class44_sub3_sub4_sub4_1 = new Model(aclass44_sub3_sub4_sub4, l1, -33019);
                for (int l2 = 0; l2 < 5; l2++) {
                    if (anIntArray1677[l2] != 0) {
                        class44_sub3_sub4_sub4_1.method520(Game.anIntArrayArray1073[l2][0],
                                Game.anIntArrayArray1073[l2][anIntArray1677[l2]]);
                        if (l2 == 1) {
                            class44_sub3_sub4_sub4_1.method520(Game.anIntArray1043[0],
                                    Game.anIntArray1043[anIntArray1677[l2]]);
                        }
                    }
                }
                class44_sub3_sub4_sub4_1.method513((byte) 3);
                class44_sub3_sub4_sub4_1.method523(64, 850, -30, -50, -30, true);
                Player.aClass39_1696.method340(l, (byte) 76, class44_sub3_sub4_sub4_1);
                aLong1693 = l;
            }
            if (aBoolean1692) {
                return class44_sub3_sub4_sub4_1;
            }
            Model class44_sub3_sub4_sub4_2 = Model.aClass44_Sub3_Sub4_Sub4_1530;
            class44_sub3_sub4_sub4_2.method508(SeqFrame.method211(j, 0) & SeqFrame.method211(k, 0),
                    class44_sub3_sub4_sub4_1, 0);
            if (j != -1 && k != -1) {
                class44_sub3_sub4_sub4_2.method515(j, true, k, SeqType.cache[super.anInt1643].anIntArray514);
            } else if (j != -1) {
                class44_sub3_sub4_sub4_2.method514(j, 188);
            }
            class44_sub3_sub4_sub4_2.method510(-18258);
            class44_sub3_sub4_sub4_2.anIntArrayArray1567 = null;
            class44_sub3_sub4_sub4_2.anIntArrayArray1566 = null;
            return class44_sub3_sub4_sub4_2;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("33523, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public Model method539(boolean flag) {
        try {
            if (flag) {
                for (int i = 1; i > 0; i++) {
                }
            }
            if (!aBoolean1673) {
                return null;
            }
            if (aClass12_1694 != null) {
                return aClass12_1694.method217((byte) 105);
            }
            boolean flag1 = false;
            for (int j = 0; j < 12; j++) {
                int k = anIntArray1676[j];
                if (k >= 256 && k < 512 && !IDKType.cache[k - 256].method251((byte) 0)) {
                    flag1 = true;
                }
                if (k >= 512 && !ObjType.method220(k - 512).method229(true, anInt1674)) {
                    flag1 = true;
                }
            }
            if (flag1) {
                return null;
            }
            Model aclass44_sub3_sub4_sub4[] = new Model[12];
            int l = 0;
            for (int i1 = 0; i1 < 12; i1++) {
                int j1 = anIntArray1676[i1];
                if (j1 >= 256 && j1 < 512) {
                    Model class44_sub3_sub4_sub4_1 = IDKType.cache[j1 - 256].method252((byte) -45);
                    if (class44_sub3_sub4_sub4_1 != null) {
                        aclass44_sub3_sub4_sub4[l++] = class44_sub3_sub4_sub4_1;
                    }
                }
                if (j1 >= 512) {
                    Model class44_sub3_sub4_sub4_2 = ObjType.method220(j1 - 512).method230(481, anInt1674);
                    if (class44_sub3_sub4_sub4_2 != null) {
                        aclass44_sub3_sub4_sub4[l++] = class44_sub3_sub4_sub4_2;
                    }
                }
            }
            Model class44_sub3_sub4_sub4 = new Model(aclass44_sub3_sub4_sub4, l, -33019);
            for (int k1 = 0; k1 < 5; k1++) {
                if (anIntArray1677[k1] != 0) {
                    class44_sub3_sub4_sub4.method520(Game.anIntArrayArray1073[k1][0],
                            Game.anIntArrayArray1073[k1][anIntArray1677[k1]]);
                    if (k1 == 1) {
                        class44_sub3_sub4_sub4.method520(Game.anIntArray1043[0],
                                Game.anIntArray1043[anIntArray1677[k1]]);
                    }
                }
            }
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96228, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public boolean method535(boolean flag) {
        try {
            if (!flag) {
                throw new NullPointerException();
            }
            return aBoolean1673;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("52910, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

}

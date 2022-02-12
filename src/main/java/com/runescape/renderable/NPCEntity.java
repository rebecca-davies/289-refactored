package com.runescape.renderable;

import com.runescape.type.NpcType;
import com.runescape.type.SeqFrame;
import com.runescape.type.SeqType;
import com.runescape.type.SpotAnimType;
import com.runescape.graphic.Model;
import com.runescape.util.SignLink;

public class NPCEntity extends Actor {

    public int anInt1697;
    public int anInt1698;
    public boolean aBoolean1699;
    public NpcType aClass12_1700;

    public NPCEntity() {
        anInt1698 = 8;
        aBoolean1699 = true;
    }

    @Override
    public Model getRotatedModel(int i) {
        try {
            if (aClass12_1700 == null) {
                return null;
            }
            Model class44_sub3_sub4_sub4 = method540(false);
            if (i != -37770) {
                throw new NullPointerException();
            }
            if (class44_sub3_sub4_sub4 == null) {
                return null;
            }
            super.anInt1661 = ((Renderable) (class44_sub3_sub4_sub4)).anInt1412;
            if (super.anInt1648 != -1 && super.anInt1649 != -1) {
                SpotAnimType class32 = SpotAnimType.cache[super.anInt1648];
                Model class44_sub3_sub4_sub4_1 = class32.method271();
                if (class44_sub3_sub4_sub4_1 != null) {
                    int j = class32.aClass26_563.anIntArray510[super.anInt1649];
                    Model class44_sub3_sub4_sub4_2 = new Model(class44_sub3_sub4_sub4_1, SeqFrame.method211(j, 0),
                            false, anInt1697, true);
                    class44_sub3_sub4_sub4_2.method519(-super.anInt1652, 0, (byte) 2, 0);
                    class44_sub3_sub4_sub4_2.method513((byte) 3);
                    class44_sub3_sub4_sub4_2.method514(j, 188);
                    class44_sub3_sub4_sub4_2.anIntArrayArray1567 = null;
                    class44_sub3_sub4_sub4_2.anIntArrayArray1566 = null;
                    if (class32.anInt566 != 128 || class32.anInt567 != 128) {
                        class44_sub3_sub4_sub4_2.method522(class32.anInt566, class32.anInt566, class32.anInt567,
                                (byte) 31);
                    }
                    class44_sub3_sub4_sub4_2.method523(64 + class32.anInt569, 850 + class32.anInt570, -30, -50, -30,
                            true);
                    Model aclass44_sub3_sub4_sub4[] = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_2};
                    class44_sub3_sub4_sub4 = new Model(true, 0, aclass44_sub3_sub4_sub4, 2);
                }
            }
            if (aClass12_1700.aByte284 == 1) {
                class44_sub3_sub4_sub4.aBoolean1568 = true;
            }
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("15988, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public Model method540(boolean flag) {
        try {
            if (flag) {
                aBoolean1699 = !aBoolean1699;
            }
            if (super.anInt1643 >= 0 && super.anInt1646 == 0) {
                int i = SeqType.cache[super.anInt1643].anIntArray510[super.anInt1644];
                int k = -1;
                if (super.anInt1640 >= 0 && super.anInt1640 != super.anInt1620) {
                    k = SeqType.cache[super.anInt1640].anIntArray510[super.anInt1641];
                }
                return aClass12_1700.method216(0, k, i, SeqType.cache[super.anInt1643].anIntArray514);
            }
            int j = -1;
            if (super.anInt1640 >= 0) {
                j = SeqType.cache[super.anInt1640].anIntArray510[super.anInt1641];
            }
            return aClass12_1700.method216(0, -1, j, null);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("99332, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public boolean method535(boolean flag) {
        try {
            if (!flag) {
                anInt1698 = -80;
            }
            return aClass12_1700 != null;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("4937, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}

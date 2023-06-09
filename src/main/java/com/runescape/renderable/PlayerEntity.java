package com.runescape.renderable;

import com.runescape.Game;
import com.runescape.collection.Cache;
import com.runescape.graphic.Model;
import com.runescape.net.Buffer;
import com.runescape.type.*;
import com.runescape.util.SignLink;
import com.runescape.util.TextUtils;

public class PlayerEntity extends Actor {

    public static Cache aClass39_1696 = new Cache((byte) 7, 260);
    public int anInt1670;
    public boolean aBoolean1671;
    public String name;
    public boolean visible;
    public int gender;
    public int headIcon;
    public int[] appearance;
    public int[] bodyPartColour;
    public int combatLevel;
    public int skillLevel;
    public long appearanceOffset;
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
    public NpcType npcAppearance;
    public int team;

    public PlayerEntity() {
        aBoolean1671 = false;
        visible = false;
        appearance = new int[12];
        bodyPartColour = new int[5];
        aBoolean1692 = false;
        aLong1693 = -1L;
    }

    public void updateAppearanceData(Buffer in) {
            in.position = 0;
            gender = in.readUnsignedByte();
            headIcon = in.readUnsignedByte();
            npcAppearance = null;
            team = 0;
            for (int slot = 0; slot < 12; slot++) {
                int objId = in.readUnsignedByte();
                if (objId == 0) {
                    appearance[slot] = 0;
                    continue;
                }
                int _objId = in.readUnsignedByte();
                appearance[slot] = (objId << 8) + _objId;
                if (slot == 0 && appearance[0] == 65535) {
                    npcAppearance = NpcType.lookup(in.readUnsignedShort());
                    break;
                }
                if (appearance[slot] >= 512 && appearance[slot] - 512 < ObjType.total) {
                    int team = ObjType.lookup(appearance[slot] - 512).teamId;
                    if (team != 0) {
                        this.team = team;
                    }
                }
            }
            for (int bodyPart = 0; bodyPart < 5; bodyPart++) {
                int colour = in.readUnsignedByte();
                if (colour < 0 || colour >= Game.APPEARANCE_COLOURS[bodyPart].length) {
                    colour = 0;
                }
                bodyPartColour[bodyPart] = colour;
            }
            super.standSeqId = in.readUnsignedShort();
            if (super.standSeqId == 65535) {
                super.standSeqId = -1;
            }
            super.standTurnSeqId = in.readUnsignedShort();
            if (super.standTurnSeqId == 65535) {
                super.standTurnSeqId = -1;
            }
            super.walkSeqId = in.readUnsignedShort();
            if (super.walkSeqId == 65535) {
                super.walkSeqId = -1;
            }
            super.turnSeqId = in.readUnsignedShort();
            if (super.turnSeqId == 65535) {
                super.turnSeqId = -1;
            }
            super.turnRightSeqId = in.readUnsignedShort();
            if (super.turnRightSeqId == 65535) {
                super.turnRightSeqId = -1;
            }
            super.turnLeftSeqId = in.readUnsignedShort();
            if (super.turnLeftSeqId == 65535) {
                super.turnLeftSeqId = -1;
            }
            super.runSeqId = in.readUnsignedShort();
            if (super.runSeqId == 65535) {
                super.runSeqId = -1;
            }
            name = TextUtils.formatName(TextUtils.longToName(in.readLong()));
            combatLevel = in.readUnsignedByte();
            skillLevel = in.readUnsignedShort();
            visible = true;
            appearanceOffset = 0L;
            for (int slot = 0; slot < 12; slot++) {
                appearanceOffset <<= 4;
                if (appearance[slot] >= 256) {
                    appearanceOffset += appearance[slot] - 256;
                }
            }
            if (appearance[0] >= 256) {
                appearanceOffset += appearance[0] - 256 >> 4;
            }
            if (appearance[1] >= 256) {
                appearanceOffset += appearance[1] - 256 >> 8;
            }
            for (int bodyPart = 0; bodyPart < 5; bodyPart++) {
                appearanceOffset <<= 3;
                appearanceOffset += bodyPartColour[bodyPart];
            }
            appearanceOffset <<= 1;
            appearanceOffset += gender;
    }

    @Override
    public Model getRotatedModel(int i) {
        try {
            if (!visible) {
                return null;
            }
            Model class44_sub3_sub4_sub4 = method538(false);
            if (i != -37770) {
                throw new NullPointerException();
            }
            if (class44_sub3_sub4_sub4 == null) {
                return null;
            }
            super.anInt1661 = class44_sub3_sub4_sub4.anInt1412;
            class44_sub3_sub4_sub4.aBoolean1568 = true;
            if (aBoolean1692) {
                return class44_sub3_sub4_sub4;
            }
            if (super.spotAnimId != -1 && super.currentSeqId != -1) {
                SpotAnimType class32 = SpotAnimType.cache[super.spotAnimId];
                Model class44_sub3_sub4_sub4_2 = class32.method271();
                if (class44_sub3_sub4_sub4_2 != null) {
                    Model class44_sub3_sub4_sub4_3 = new Model(class44_sub3_sub4_sub4_2, SeqFrame.method211(
                            super.currentSeqId, 0), false, anInt1670, true);
                    class44_sub3_sub4_sub4_3.method519(-super.spotAnimHeight, 0, (byte) 2, 0);
                    class44_sub3_sub4_sub4_3.createLabelReference((byte) 3);
                    class44_sub3_sub4_sub4_3.applyTransform(class32.aClass26_563.primaryFrames[super.currentSeqId], 188);
                    class44_sub3_sub4_sub4_3.anIntArrayArray1567 = null;
                    class44_sub3_sub4_sub4_3.anIntArrayArray1566 = null;
                    if (class32.anInt566 != 128 || class32.anInt567 != 128) {
                        class44_sub3_sub4_sub4_3.method522(class32.anInt566, class32.anInt566, class32.anInt567,
                                (byte) 31);
                    }
                    class44_sub3_sub4_sub4_3.calculateNormals(64 + class32.anInt569, 850 + class32.anInt570, -30, -50, -30,
                            true);
                    Model[] aclass44_sub3_sub4_sub4_1 = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_3};
                    class44_sub3_sub4_sub4 = new Model(true, 0, aclass44_sub3_sub4_sub4_1, 2);
                }
            }
            if (aClass44_Sub3_Sub4_Sub4_1687 != null) {
                if (Game.loopCycle >= anInt1683) {
                    aClass44_Sub3_Sub4_Sub4_1687 = null;
                }
                if (Game.loopCycle >= anInt1682 && Game.loopCycle < anInt1683) {
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
                    Model[] aclass44_sub3_sub4_sub4 = {class44_sub3_sub4_sub4, class44_sub3_sub4_sub4_1};
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
            SignLink.reporterror("67533, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Model method538(boolean flag) {
        try {
            if (npcAppearance != null) {
                int i = -1;
                if (super.primarySeq >= 0 && super.primarySeqDelays == 0) {
                    i = SeqType.cache[super.primarySeq].primaryFrames[super.currentSeqFrame];
                } else if (super.anInt1640 >= 0) {
                    i = SeqType.cache[super.anInt1640].primaryFrames[super.anInt1641];
                }
                Model class44_sub3_sub4_sub4 = npcAppearance.method216(0, -1, i, null);
                return class44_sub3_sub4_sub4;
            }
            long l = appearanceOffset;
            int j = -1;
            int k = -1;
            int i1 = -1;
            int j1 = -1;
            if (super.primarySeq >= 0 && super.primarySeqDelays == 0) {
                SeqType class26 = SeqType.cache[super.primarySeq];
                j = class26.primaryFrames[super.currentSeqFrame];
                if (super.anInt1640 >= 0 && super.anInt1640 != super.standSeqId) {
                    k = SeqType.cache[super.anInt1640].primaryFrames[super.anInt1641];
                }
                if (class26.anInt517 >= 0) {
                    i1 = class26.anInt517;
                    l += i1 - appearance[5] << 40;
                }
                if (class26.anInt518 >= 0) {
                    j1 = class26.anInt518;
                    l += j1 - appearance[3] << 48;
                }
            } else if (super.anInt1640 >= 0) {
                j = SeqType.cache[super.anInt1640].primaryFrames[super.anInt1641];
            }
            Model class44_sub3_sub4_sub4_1 = (Model) PlayerEntity.aClass39_1696.method339(l);
            if (flag) {
                aBoolean1671 = !aBoolean1671;
            }
            if (class44_sub3_sub4_sub4_1 == null) {
                boolean flag1 = false;
                for (int k1 = 0; k1 < 12; k1++) {
                    int i2 = appearance[k1];
                    if (j1 >= 0 && k1 == 3) {
                        i2 = j1;
                    }
                    if (i1 >= 0 && k1 == 5) {
                        i2 = i1;
                    }
                    if (i2 >= 256 && i2 < 512 && !IdkType.cache[i2 - 256].validateModel(9)) {
                        flag1 = true;
                    }
                    if (i2 >= 512 && !ObjType.lookup(i2 - 512).method227(false, gender)) {
                        flag1 = true;
                    }
                }
                if (flag1) {
                    if (aLong1693 != -1L) {
                        class44_sub3_sub4_sub4_1 = (Model) PlayerEntity.aClass39_1696.method339(aLong1693);
                    }
                    if (class44_sub3_sub4_sub4_1 == null) {
                        return null;
                    }
                }
            }
            if (class44_sub3_sub4_sub4_1 == null) {
                Model[] aclass44_sub3_sub4_sub4 = new Model[12];
                int l1 = 0;
                for (int j2 = 0; j2 < 12; j2++) {
                    int k2 = appearance[j2];
                    if (j1 >= 0 && j2 == 3) {
                        k2 = j1;
                    }
                    if (i1 >= 0 && j2 == 5) {
                        k2 = i1;
                    }
                    if (k2 >= 256 && k2 < 512) {
                        Model class44_sub3_sub4_sub4_3 = IdkType.cache[k2 - 256].getModel(0);
                        if (class44_sub3_sub4_sub4_3 != null) {
                            aclass44_sub3_sub4_sub4[l1++] = class44_sub3_sub4_sub4_3;
                        }
                    }
                    if (k2 >= 512) {
                        Model class44_sub3_sub4_sub4_4 = ObjType.lookup(k2 - 512).method228(gender, 0);
                        if (class44_sub3_sub4_sub4_4 != null) {
                            aclass44_sub3_sub4_sub4[l1++] = class44_sub3_sub4_sub4_4;
                        }
                    }
                }
                class44_sub3_sub4_sub4_1 = new Model(aclass44_sub3_sub4_sub4, l1, -33019);
                for (int l2 = 0; l2 < 5; l2++) {
                    if (bodyPartColour[l2] != 0) {
                        class44_sub3_sub4_sub4_1.recolor(Game.APPEARANCE_COLOURS[l2][0],
                                Game.APPEARANCE_COLOURS[l2][bodyPartColour[l2]]);
                        if (l2 == 1) {
                            class44_sub3_sub4_sub4_1.recolor(Game.BEARD_COLOURS[0],
                                    Game.BEARD_COLOURS[bodyPartColour[l2]]);
                        }
                    }
                }
                class44_sub3_sub4_sub4_1.createLabelReference((byte) 3);
                class44_sub3_sub4_sub4_1.calculateNormals(64, 850, -30, -50, -30, true);
                PlayerEntity.aClass39_1696.method340(l, (byte) 76, class44_sub3_sub4_sub4_1);
                aLong1693 = l;
            }
            if (aBoolean1692) {
                return class44_sub3_sub4_sub4_1;
            }
            Model class44_sub3_sub4_sub4_2 = Model.aClass44_Sub3_Sub4_Sub4_1530;
            class44_sub3_sub4_sub4_2.method508(SeqFrame.method211(j, 0) & SeqFrame.method211(k, 0),
                    class44_sub3_sub4_sub4_1, 0);
            if (j != -1 && k != -1) {
                class44_sub3_sub4_sub4_2.method515(j, true, k, SeqType.cache[super.primarySeq].anIntArray514);
            } else if (j != -1) {
                class44_sub3_sub4_sub4_2.applyTransform(j, 188);
            }
            class44_sub3_sub4_sub4_2.method510(-18258);
            class44_sub3_sub4_sub4_2.anIntArrayArray1567 = null;
            class44_sub3_sub4_sub4_2.anIntArrayArray1566 = null;
            return class44_sub3_sub4_sub4_2;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("33523, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Model method539(boolean flag) {
        try {
            if (flag) {
                for (int i = 1; i > 0; i++) {
                }
            }
            if (!visible) {
                return null;
            }
            if (npcAppearance != null) {
                return npcAppearance.method217((byte) 105);
            }
            boolean flag1 = false;
            for (int j = 0; j < 12; j++) {
                int k = appearance[j];
                if (k >= 256 && k < 512 && !IdkType.cache[k - 256].method251((byte) 0)) {
                    flag1 = true;
                }
                if (k >= 512 && !ObjType.lookup(k - 512).method229(true, gender)) {
                    flag1 = true;
                }
            }
            if (flag1) {
                return null;
            }
            Model[] aclass44_sub3_sub4_sub4 = new Model[12];
            int l = 0;
            for (int i1 = 0; i1 < 12; i1++) {
                int j1 = appearance[i1];
                if (j1 >= 256 && j1 < 512) {
                    Model class44_sub3_sub4_sub4_1 = IdkType.cache[j1 - 256].method252((byte) -45);
                    if (class44_sub3_sub4_sub4_1 != null) {
                        aclass44_sub3_sub4_sub4[l++] = class44_sub3_sub4_sub4_1;
                    }
                }
                if (j1 >= 512) {
                    Model class44_sub3_sub4_sub4_2 = ObjType.lookup(j1 - 512).method230(481, gender);
                    if (class44_sub3_sub4_sub4_2 != null) {
                        aclass44_sub3_sub4_sub4[l++] = class44_sub3_sub4_sub4_2;
                    }
                }
            }
            Model class44_sub3_sub4_sub4 = new Model(aclass44_sub3_sub4_sub4, l, -33019);
            for (int k1 = 0; k1 < 5; k1++) {
                if (bodyPartColour[k1] != 0) {
                    class44_sub3_sub4_sub4.recolor(Game.APPEARANCE_COLOURS[k1][0],
                            Game.APPEARANCE_COLOURS[k1][bodyPartColour[k1]]);
                    if (k1 == 1) {
                        class44_sub3_sub4_sub4.recolor(Game.BEARD_COLOURS[0],
                                Game.BEARD_COLOURS[bodyPartColour[k1]]);
                    }
                }
            }
            return class44_sub3_sub4_sub4;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96228, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public boolean isVisible(boolean flag) {
        try {
            if (!flag) {
                throw new NullPointerException();
            }
            return visible;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("52910, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

}

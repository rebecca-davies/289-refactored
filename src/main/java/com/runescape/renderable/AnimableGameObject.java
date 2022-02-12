package com.runescape.renderable;

import com.runescape.type.SeqFrame;
import com.runescape.type.SpotAnimType;
import com.runescape.graphic.Model;
import com.runescape.util.SignLink;

public class AnimableGameObject extends Renderable {

    public int anInt1602;
    public int anInt1603;
    public SpotAnimType aClass32_1604;
    public int anInt1605;
    public int anInt1606;
    public int anInt1607;
    public int anInt1608;
    public int anInt1609;
    public int anInt1610;
    public int anInt1611;
    public boolean aBoolean1612;

    public AnimableGameObject(int i, int j, int k, int l, boolean flag, int i1, int j1, int k1) {
        anInt1603 = 393;
        aBoolean1612 = false;
        try {
            aClass32_1604 = SpotAnimType.cache[j1];
            if (!flag) {
                anInt1603 = 385;
            }
            anInt1606 = j;
            anInt1607 = i;
            anInt1608 = i1;
            anInt1609 = k;
            anInt1605 = k1 + l;
            aBoolean1612 = false;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("81124, " + i + ", " + j + ", " + k + ", " + l + ", " + flag + ", " + i1 + ", " + j1
                    + ", " + k1 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method531(int i, int j) {
        try {
            if (i <= 0) {
                return;
            }
            for (anInt1611 += j; anInt1611 > aClass32_1604.aClass26_563.method254(anInt1610, 24425); ) {
                anInt1611 -= aClass32_1604.aClass26_563.method254(anInt1610, 24425) + 1;
                anInt1610++;
                if (anInt1610 >= aClass32_1604.aClass26_563.anInt509
                        && (anInt1610 < 0 || anInt1610 >= aClass32_1604.aClass26_563.anInt509)) {
                    anInt1610 = 0;
                    aBoolean1612 = true;
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("93520, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public Model getRotatedModel(int i) {
        try {
            if (i != -37770) {
                for (int j = 1; j > 0; j++) {
                }
            }
            Model class44_sub3_sub4_sub4 = aClass32_1604.method271();
            if (class44_sub3_sub4_sub4 == null) {
                return null;
            }
            int k = aClass32_1604.aClass26_563.anIntArray510[anInt1610];
            Model model = new Model(class44_sub3_sub4_sub4, SeqFrame.method211(k, 0), false, anInt1602, true);
            if (!aBoolean1612) {
                model.method513((byte) 3);
                model.method514(k, 188);
                model.anIntArrayArray1567 = null;
                model.anIntArrayArray1566 = null;
            }
            if (aClass32_1604.anInt566 != 128 || aClass32_1604.anInt567 != 128) {
                model.method522(aClass32_1604.anInt566, aClass32_1604.anInt566, aClass32_1604.anInt567, (byte) 31);
            }
            if (aClass32_1604.anInt568 != 0) {
                if (aClass32_1604.anInt568 == 90) {
                    model.method517(0);
                }
                if (aClass32_1604.anInt568 == 180) {
                    model.method517(0);
                    model.method517(0);
                }
                if (aClass32_1604.anInt568 == 270) {
                    model.method517(0);
                    model.method517(0);
                    model.method517(0);
                }
            }
            model.method523(64 + aClass32_1604.anInt569, 850 + aClass32_1604.anInt570, -30, -50, -30, true);
            return model;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("834, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}

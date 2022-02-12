package com.runescape.renderable;

import com.runescape.collection.CacheableNode;
import com.runescape.graphic.Model;
import com.runescape.graphic.VertexNormal;
import com.runescape.util.SignLink;

public class Renderable extends CacheableNode {

    public static boolean aBoolean1413;
    public int anInt1410;
    public VertexNormal aClass25Array1411[];
    public int anInt1412;

    public Renderable() {
        anInt1410 = 772;
        anInt1412 = 1000;
    }

    public void method498(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2) {
        Model class44_sub3_sub4_sub4 = getRotatedModel(-37770);
        if (class44_sub3_sub4_sub4 != null) {
            anInt1412 = ((Renderable) (class44_sub3_sub4_sub4)).anInt1412;
            class44_sub3_sub4_sub4.method498(i, j, k, l, i1, j1, k1, l1, i2);
        }
    }

    public Model getRotatedModel(int i) {
        try {
            if (i != -37770) {
                anInt1410 = 414;
            }
            return null;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("59009, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}

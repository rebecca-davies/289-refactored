package com.runescape.renderable;

import com.runescape.type.ObjType;
import com.runescape.graphic.Model;
import com.runescape.util.SignLink;

public class ObjStackEntity extends Renderable {

    public boolean aBoolean1494;
    public int anInt1495;
    public int anInt1496;

    public ObjStackEntity() {
        aBoolean1494 = true;
    }

    @Override
    public Model getRotatedModel(int i) {
        try {
            ObjType class14 = ObjType.method220(anInt1495);
            if (i != -37770) {
                aBoolean1494 = !aBoolean1494;
            }
            return class14.method224(anInt1496);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("51746, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}

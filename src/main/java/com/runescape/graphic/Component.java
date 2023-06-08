package com.runescape.graphic;

import com.runescape.Game;
import com.runescape.cache.FileArchive;
import com.runescape.type.NpcType;
import com.runescape.type.SeqFrame;
import com.runescape.type.ObjType;
import com.runescape.collection.Cache;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;
import com.runescape.util.TextUtils;

public class Component {

    public static Component[] instances;
    public static Cache aClass39_162 = new Cache((byte) 7, 30);
    public static Cache spriteCache;
    public byte aByte98;
    public int anInt99;
    public int[] containerObjId;
    public int[] containerItemAmount;
    public int seqFrame;
    public int anInt104;
    public int id;
    public int anInt106;
    public int type;
    public int optionType;
    public int contentType;
    public int width;
    public int height;
    public byte transparency;
    public int x;
    public int y;
    public int[][] anIntArrayArray115;
    public int[] scriptComparator;
    public int[] anIntArray117;
    public int delegateHover;
    public int scrollHeight;
    public int scrollY;
    public boolean hidden;
    public int[] child;
    public int[] childX;
    public int[] childY;
    public int anInt125;
    public boolean aBoolean126;
    public boolean aBoolean127;
    public boolean container;
    public boolean usableContainer;
    public boolean aBoolean130;
    public int invMarginX;
    public int invMarginY;
    public Image24[] invSlotImage;
    public int[] invSlotX;
    public int[] invSlotY;
    public String[] actions;
    public boolean fill;
    public boolean center;
    public boolean shadow;
    public BitmapFont font;
    public String text;
    public String activeText;
    public int colour;
    public int activeColour;
    public int hoverColour;
    public int activeHoverColour;
    public Image24 image;
    public Image24 activeImage;
    public int modelType;
    public int modelTypeId;
    public int anInt151;
    public int anInt152;
    public int seqId;
    public int activeSeqId;
    public int modelZoom;
    public int modelEyePitch;
    public int modelYaw;
    public String spellAction;
    public String spellName;
    public int anInt160;
    public String option;

    public Component() {
        aByte98 = 4;
    }

    public static void unpack(BitmapFont[] aclass44_sub3_sub1_sub4, FileArchive mediaArchive, FileArchive widgetArchive) {
            Component.spriteCache = new Cache((byte) 7, 50000);
            Buffer class44_sub3_sub2 = new Buffer(widgetArchive.read("data"));
            int j = -1;
            int k = class44_sub3_sub2.readUnsignedShort();
            Component.instances = new Component[k];
            while (class44_sub3_sub2.position < class44_sub3_sub2.payload.length) {
                int l = class44_sub3_sub2.readUnsignedShort();
                if (l == 65535) {
                    j = class44_sub3_sub2.readUnsignedShort();
                    l = class44_sub3_sub2.readUnsignedShort();
                }
                Component class5 = Component.instances[l] = new Component();
                class5.id = l;
                class5.anInt106 = j;
                class5.type = class44_sub3_sub2.readUnsignedByte();
                class5.optionType = class44_sub3_sub2.readUnsignedByte();
                class5.contentType = class44_sub3_sub2.readUnsignedShort();
                class5.width = class44_sub3_sub2.readUnsignedShort();
                class5.height = class44_sub3_sub2.readUnsignedShort();
                class5.transparency = (byte) class44_sub3_sub2.readUnsignedByte();
                class5.delegateHover = class44_sub3_sub2.readUnsignedByte();
                if (class5.delegateHover != 0) {
                    class5.delegateHover = (class5.delegateHover - 1 << 8) + class44_sub3_sub2.readUnsignedByte();
                } else {
                    class5.delegateHover = -1;
                }
                int j1 = class44_sub3_sub2.readUnsignedByte();
                if (j1 > 0) {
                    class5.scriptComparator = new int[j1];
                    class5.anIntArray117 = new int[j1];
                    for (int k1 = 0; k1 < j1; k1++) {
                        class5.scriptComparator[k1] = class44_sub3_sub2.readUnsignedByte();
                        class5.anIntArray117[k1] = class44_sub3_sub2.readUnsignedShort();
                    }
                }
                int l1 = class44_sub3_sub2.readUnsignedByte();
                if (l1 > 0) {
                    class5.anIntArrayArray115 = new int[l1][];
                    for (int i2 = 0; i2 < l1; i2++) {
                        int j3 = class44_sub3_sub2.readUnsignedShort();
                        class5.anIntArrayArray115[i2] = new int[j3];
                        for (int i5 = 0; i5 < j3; i5++) {
                            class5.anIntArrayArray115[i2][i5] = class44_sub3_sub2.readUnsignedShort();
                        }
                    }
                }
                if (class5.type == 0) {
                    class5.scrollHeight = class44_sub3_sub2.readUnsignedShort();
                    class5.hidden = class44_sub3_sub2.readUnsignedByte() == 1;
                    int j2 = class44_sub3_sub2.readUnsignedShort();
                    class5.child = new int[j2];
                    class5.childX = new int[j2];
                    class5.childY = new int[j2];
                    for (int k3 = 0; k3 < j2; k3++) {
                        class5.child[k3] = class44_sub3_sub2.readUnsignedShort();
                        class5.childX[k3] = class44_sub3_sub2.method485();
                        class5.childY[k3] = class44_sub3_sub2.method485();
                    }
                }
                if (class5.type == 1) {
                    class5.anInt125 = class44_sub3_sub2.readUnsignedShort();
                    class5.aBoolean126 = class44_sub3_sub2.readUnsignedByte() == 1;
                }
                if (class5.type == 2) {
                    class5.containerObjId = new int[class5.width * class5.height];
                    class5.containerItemAmount = new int[class5.width * class5.height];
                    class5.aBoolean127 = class44_sub3_sub2.readUnsignedByte() == 1;
                    class5.container = class44_sub3_sub2.readUnsignedByte() == 1;
                    class5.usableContainer = class44_sub3_sub2.readUnsignedByte() == 1;
                    class5.aBoolean130 = class44_sub3_sub2.readUnsignedByte() == 1;
                    class5.invMarginX = class44_sub3_sub2.readUnsignedByte();
                    class5.invMarginY = class44_sub3_sub2.readUnsignedByte();
                    class5.invSlotX = new int[20];
                    class5.invSlotY = new int[20];
                    class5.invSlotImage = new Image24[20];
                    for (int k2 = 0; k2 < 20; k2++) {
                        int l3 = class44_sub3_sub2.readUnsignedByte();
                        if (l3 == 1) {
                            class5.invSlotX[k2] = class44_sub3_sub2.method485();
                            class5.invSlotY[k2] = class44_sub3_sub2.method485();
                            String s1 = class44_sub3_sub2.readString();
                            if (mediaArchive != null && s1.length() > 0) {
                                int j5 = s1.lastIndexOf(",");
                                class5.invSlotImage[k2] = Component.method186(false,
                                        Integer.parseInt(s1.substring(j5 + 1)), mediaArchive, s1.substring(0, j5));
                            }
                        }
                    }
                    class5.actions = new String[5];
                    for (int i4 = 0; i4 < 5; i4++) {
                        class5.actions[i4] = class44_sub3_sub2.readString();
                        if (class5.actions[i4].length() == 0) {
                            class5.actions[i4] = null;
                        }
                    }
                }
                if (class5.type == 3) {
                    class5.fill = class44_sub3_sub2.readUnsignedByte() == 1;
                }
                if (class5.type == 4 || class5.type == 1) {
                    class5.center = class44_sub3_sub2.readUnsignedByte() == 1;
                    int l2 = class44_sub3_sub2.readUnsignedByte();
                    if (aclass44_sub3_sub1_sub4 != null) {
                        class5.font = aclass44_sub3_sub1_sub4[l2];
                    }
                    class5.shadow = class44_sub3_sub2.readUnsignedByte() == 1;
                }
                if (class5.type == 4) {
                    class5.text = class44_sub3_sub2.readString();
                    class5.activeText = class44_sub3_sub2.readString();
                }
                if (class5.type == 1 || class5.type == 3 || class5.type == 4) {
                    class5.colour = class44_sub3_sub2.readInt();
                }
                if (class5.type == 3 || class5.type == 4) {
                    class5.activeColour = class44_sub3_sub2.readInt();
                    class5.hoverColour = class44_sub3_sub2.readInt();
                    class5.activeHoverColour = class44_sub3_sub2.readInt();
                }
                if (class5.type == 5) {
                    String s = class44_sub3_sub2.readString();
                    if (mediaArchive != null && s.length() > 0) {
                        int j4 = s.lastIndexOf(",");
                        class5.image = Component.method186(false,
                                Integer.parseInt(s.substring(j4 + 1)), mediaArchive, s.substring(0, j4));
                    }
                    s = class44_sub3_sub2.readString();
                    if (mediaArchive != null && s.length() > 0) {
                        int k4 = s.lastIndexOf(",");
                        class5.activeImage = Component.method186(false,
                                Integer.parseInt(s.substring(k4 + 1)), mediaArchive, s.substring(0, k4));
                    }
                }
                if (class5.type == 6) {
                    int i1 = class44_sub3_sub2.readUnsignedByte();
                    if (i1 != 0) {
                        class5.modelType = 1;
                        class5.modelTypeId = (i1 - 1 << 8) + class44_sub3_sub2.readUnsignedByte();
                    }
                    i1 = class44_sub3_sub2.readUnsignedByte();
                    if (i1 != 0) {
                        class5.anInt151 = 1;
                        class5.anInt152 = (i1 - 1 << 8) + class44_sub3_sub2.readUnsignedByte();
                    }
                    i1 = class44_sub3_sub2.readUnsignedByte();
                    if (i1 != 0) {
                        class5.seqId = (i1 - 1 << 8) + class44_sub3_sub2.readUnsignedByte();
                    } else {
                        class5.seqId = -1;
                    }
                    i1 = class44_sub3_sub2.readUnsignedByte();
                    if (i1 != 0) {
                        class5.activeSeqId = (i1 - 1 << 8) + class44_sub3_sub2.readUnsignedByte();
                    } else {
                        class5.activeSeqId = -1;
                    }
                    class5.modelZoom = class44_sub3_sub2.readUnsignedShort();
                    class5.modelEyePitch = class44_sub3_sub2.readUnsignedShort();
                    class5.modelYaw = class44_sub3_sub2.readUnsignedShort();
                }
                if (class5.type == 7) {
                    class5.containerObjId = new int[class5.width * class5.height];
                    class5.containerItemAmount = new int[class5.width * class5.height];
                    class5.center = class44_sub3_sub2.readUnsignedByte() == 1;
                    int i3 = class44_sub3_sub2.readUnsignedByte();
                    if (aclass44_sub3_sub1_sub4 != null) {
                        class5.font = aclass44_sub3_sub1_sub4[i3];
                    }
                    class5.shadow = class44_sub3_sub2.readUnsignedByte() == 1;
                    class5.colour = class44_sub3_sub2.readInt();
                    class5.invMarginX = class44_sub3_sub2.method485();
                    class5.invMarginY = class44_sub3_sub2.method485();
                    class5.container = class44_sub3_sub2.readUnsignedByte() == 1;
                    class5.actions = new String[5];
                    for (int l4 = 0; l4 < 5; l4++) {
                        class5.actions[l4] = class44_sub3_sub2.readString();
                        if (class5.actions[l4].length() == 0) {
                            class5.actions[l4] = null;
                        }
                    }
                }
                if (class5.optionType == 2 || class5.type == 2) {
                    class5.spellAction = class44_sub3_sub2.readString();
                    class5.spellName = class44_sub3_sub2.readString();
                    class5.anInt160 = class44_sub3_sub2.readUnsignedShort();
                }
                if (class5.optionType == 1 || class5.optionType == 4 || class5.optionType == 5 || class5.optionType == 6) {
                    class5.option = class44_sub3_sub2.readString();
                    if (class5.option.length() == 0) {
                        if (class5.optionType == 1) {
                            class5.option = "Ok";
                        }
                        if (class5.optionType == 4) {
                            class5.option = "Select";
                        }
                        if (class5.optionType == 5) {
                            class5.option = "Select";
                        }
                        if (class5.optionType == 6) {
                            class5.option = "Continue";
                        }
                    }
                }
            }
            Component.spriteCache = null;
    }

    public static void cacheModel(int i, Model class44_sub3_sub4_sub4, int j, int k) {
        try {
            Component.aClass39_162.method341();
            if (j != 9) {
                for (int l = 1; l > 0; l++) {
                }
            }
            if (class44_sub3_sub4_sub4 != null && i != 4) {
                Component.aClass39_162.method340((i << 16) + k, (byte) 76, class44_sub3_sub4_sub4);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27428, " + i + ", " + class44_sub3_sub4_sub4 + ", " + j + ", " + k + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public static Image24 method186(boolean flag, int i, FileArchive class47, String s) {
        try {
            if (flag) {
                throw new NullPointerException();
            }
            long l = (TextUtils.method552(-5562, s) << 8) + i;
            Image24 class44_sub3_sub1_sub2 = (Image24) Component.spriteCache.method339(l);
            if (class44_sub3_sub1_sub2 != null) {
                return class44_sub3_sub1_sub2;
            }
            try {
                class44_sub3_sub1_sub2 = new Image24(class47, s, i);
                Component.spriteCache.method340(l, (byte) 76, class44_sub3_sub1_sub2);
            } catch (Exception _ex) {
                return null;
            }
            return class44_sub3_sub1_sub2;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90047, " + flag + ", " + i + ", " + class47 + ", " + s + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method182(int i, int j, int k) {
        try {
            int l = containerObjId[k];
            containerObjId[k] = containerObjId[j];
            if (i < 0 || i > 0) {
                return;
            } else {
                containerObjId[j] = l;
                l = containerItemAmount[k];
                containerItemAmount[k] = containerItemAmount[j];
                containerItemAmount[j] = l;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("35687, " + i + ", " + j + ", " + k + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Model getModel(int j, int k, boolean flag) {
            Model class44_sub3_sub4_sub4;
            if (flag) {
                class44_sub3_sub4_sub4 = method184(anInt151, anInt152);
            } else {
                class44_sub3_sub4_sub4 = method184(modelType, modelTypeId);
            }
            if (class44_sub3_sub4_sub4 == null) {
                return null;
            }
            if (k == -1 && j == -1 && class44_sub3_sub4_sub4.anIntArray1549 == null) {
                return class44_sub3_sub4_sub4;
            }
            Model class44_sub3_sub4_sub4_1 = new Model(class44_sub3_sub4_sub4, SeqFrame.method211(k, 0)
                    & SeqFrame.method211(j, 0), false, anInt99, true);
            if (k != -1 || j != -1) {
                class44_sub3_sub4_sub4_1.createLabelReference((byte) 3);
            }
            if (k != -1) {
                class44_sub3_sub4_sub4_1.applyTransform(k, 188);
            }
            if (j != -1) {
                class44_sub3_sub4_sub4_1.applyTransform(j, 188);
            }
            class44_sub3_sub4_sub4_1.calculateNormals(64, 768, -50, -10, -50, true);
            return class44_sub3_sub4_sub4_1;
    }

    public Model method184(int i, int j) {
        Model class44_sub3_sub4_sub4 = (Model) Component.aClass39_162.method339((i << 16) + j);
        if (class44_sub3_sub4_sub4 != null) {
            return class44_sub3_sub4_sub4;
        }
        if (i == 1) {
            class44_sub3_sub4_sub4 = Model.method506(j, aByte98);
        }
        if (i == 2) {
            class44_sub3_sub4_sub4 = NpcType.lookup(j).method217((byte) 105);
        }
        if (i == 3) {
            class44_sub3_sub4_sub4 = Game.localPlayer.method539(false);
        }
        if (i == 4) {
            class44_sub3_sub4_sub4 = ObjType.lookup(j).method225(true, 50);
        }
        if (i == 5) {
            class44_sub3_sub4_sub4 = null;
        }
        if (class44_sub3_sub4_sub4 != null) {
            Component.aClass39_162.method340((i << 16) + j, (byte) 76, class44_sub3_sub4_sub4);
        }
        return class44_sub3_sub4_sub4;
    }

}

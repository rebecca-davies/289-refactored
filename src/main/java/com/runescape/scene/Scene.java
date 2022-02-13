package com.runescape.scene;

import com.runescape.collection.LinkedList;
import com.runescape.graphic.Model;
import com.runescape.graphic.Draw2D;
import com.runescape.graphic.Draw3D;
import com.runescape.graphic.VertexNormal;
import com.runescape.renderable.Renderable;
import com.runescape.util.SignLink;

public class Scene {

    public static boolean aBoolean599;
    public static boolean aBoolean606 = true;
    public static int anInt616;
    public static int anInt617;
    public static int anInt618;
    public static int anInt619;
    public static int anInt620;
    public static int anInt621;
    public static int anInt622;
    public static int anInt623;
    public static int anInt624;
    public static int anInt625;
    public static int anInt626;
    public static int anInt627;
    public static int anInt628;
    public static int anInt629;
    public static int anInt630;
    public static int anInt631;
    public static SceneSpawnRequest[] aClass30Array632 = new SceneSpawnRequest[100];
    public static int[] anIntArray633 = {53, -53, -53, 53};
    public static int[] anIntArray634 = {-53, -53, 53, 53};
    public static int[] anIntArray635 = {-45, 45, 45, -45};
    public static int[] anIntArray636 = {45, 45, -45, -45};
    public static boolean aBoolean637;
    public static int anInt638;
    public static int anInt639;
    public static int anInt640 = -1;
    public static int anInt641 = -1;
    public static int anInt642;
    public static int[] anIntArray643;
    public static SceneCluster[][] aClass23ArrayArray644;
    public static int anInt645;
    public static SceneCluster[] aClass23Array646 = new SceneCluster[500];
    public static LinkedList aClass28_647 = new LinkedList(-199);
    public static int[] anIntArray648 = {19, 55, 38, 155, 255, 110, 137, 205, 76};
    public static int[] anIntArray649 = {160, 192, 80, 96, 0, 144, 80, 48, 160};
    public static int[] anIntArray650 = {76, 8, 137, 4, 0, 1, 38, 2, 19};
    public static int[] anIntArray651 = {0, 0, 2, 0, 0, 2, 1, 1, 0};
    public static int[] anIntArray652 = {2, 0, 0, 2, 0, 0, 0, 4, 4};
    public static int[] anIntArray653 = {0, 4, 4, 8, 0, 0, 8, 0, 0};
    public static int[] anIntArray654 = {1, 1, 0, 0, 0, 8, 0, 0, 8};
    public static int[] anIntArray655 = {41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 43086, 41,
            41, 41, 41, 41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41, 41, 5056, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41,
            41, 41, 41, 41, 3131, 41, 41, 41};
    public static boolean[][][][] aBooleanArrayArrayArrayArray661 = new boolean[8][32][51][51];
    public static boolean[][] aBooleanArrayArray662;
    public static int anInt663;
    public static int anInt664;
    public static int anInt665;
    public static int anInt666;
    public static int anInt667;
    public static int anInt668;

    static {
        Scene.anInt642 = 4;
        Scene.anIntArray643 = new int[Scene.anInt642];
        Scene.aClass23ArrayArray644 = new SceneCluster[Scene.anInt642][500];
    }

    public int anInt598;
    public int anInt600;
    public int anInt601;
    public byte aByte602;
    public int anInt603;
    public int anInt604;
    public int anInt605;
    public int anInt607;
    public int anInt608;
    public int anInt609;
    public int[][][] anIntArrayArrayArray610;
    public SceneTile[][][] tiles;
    public int anInt612;
    public int anInt613;
    public SceneSpawnRequest[] aClass30Array614;
    public int[][][] anIntArrayArrayArray615;
    public int[] anIntArray656;
    public int[] anIntArray657;
    public int anInt658;
    public int[][] anIntArrayArray659 = {new int[16], {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
    public int[][] anIntArrayArray660 = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3},
            {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
            {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};

    public Scene(int i, int j, int[][][] ai, int k, int l) {
        anInt598 = 195;
        anInt601 = 6;
        aByte602 = -90;
        anInt603 = 7;
        anInt604 = 5;
        anInt605 = 8;
        aClass30Array614 = new SceneSpawnRequest[5000];
        anIntArray656 = new int[10000];
        anIntArray657 = new int[10000];
        try {
            anInt607 = j;
            anInt608 = i;
            anInt609 = k;
            tiles = new SceneTile[j][i][k];
            anIntArrayArrayArray615 = new int[j][i + 1][k + 1];
            anIntArrayArrayArray610 = ai;
            if (l <= 0) {
                anInt598 = 181;
            }
            method278(true);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("88220, " + i + ", " + j + ", " + ai + ", " + k + ", " + l + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public static void method277(byte byte0) {
        try {
            if (byte0 != 42) {
                return;
            } else {
                Scene.aClass30Array632 = null;
                Scene.anIntArray643 = null;
                Scene.aClass23ArrayArray644 = null;
                Scene.aClass28_647 = null;
                Scene.aBooleanArrayArrayArrayArray661 = null;
                Scene.aBooleanArrayArray662 = null;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("68391, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static void method281(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2) {
        try {
            SceneCluster class23 = new SceneCluster();
            class23.anInt471 = i1 / 128;
            class23.anInt472 = l / 128;
            class23.anInt473 = i / 128;
            class23.anInt474 = l1 / 128;
            class23.anInt475 = i2;
            class23.anInt476 = i1;
            class23.anInt477 = l;
            class23.anInt478 = i;
            class23.anInt479 = l1;
            class23.anInt480 = k;
            if (j1 != 1) {
                Scene.aBoolean599 = !Scene.aBoolean599;
            }
            class23.anInt481 = k1;
            Scene.aClass23ArrayArray644[j][Scene.anIntArray643[j]++] = class23;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("53475, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", " + k1
                    + ", " + l1 + ", " + i2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void method314(int[] ai, int i, int j, int k, int l, int i1) {
        try {
            if (k != 3) {
                return;
            }
            Scene.anInt665 = 0;
            Scene.anInt666 = 0;
            Scene.anInt667 = i1;
            Scene.anInt668 = j;
            Scene.anInt663 = i1 / 2;
            Scene.anInt664 = j / 2;
            boolean[][][][] aflag = new boolean[9][32][53][53];
            for (int j1 = 128; j1 <= 384; j1 += 32) {
                for (int k1 = 0; k1 < 2048; k1 += 64) {
                    Scene.anInt628 = Model.SINE[j1];
                    Scene.anInt629 = Model.COSINE[j1];
                    Scene.anInt630 = Model.SINE[k1];
                    Scene.anInt631 = Model.COSINE[k1];
                    int i2 = (j1 - 128) / 32;
                    int k2 = k1 / 64;
                    for (int i3 = -26; i3 <= 26; i3++) {
                        for (int k3 = -26; k3 <= 26; k3++) {
                            int l3 = i3 * 128;
                            int j4 = k3 * 128;
                            boolean flag1 = false;
                            for (int l4 = -i; l4 <= l; l4 += 128) {
                                if (!Scene.method315(ai[i2] + l4, 437, j4, l3)) {
                                    continue;
                                }
                                flag1 = true;
                                break;
                            }
                            aflag[i2][k2][i3 + 25 + 1][k3 + 25 + 1] = flag1;
                        }
                    }
                }
            }
            for (int l1 = 0; l1 < 8; l1++) {
                for (int j2 = 0; j2 < 32; j2++) {
                    for (int l2 = -25; l2 < 25; l2++) {
                        for (int j3 = -25; j3 < 25; j3++) {
                            boolean flag = false;
                            label0:
                            for (int i4 = -1; i4 <= 1; i4++) {
                                for (int k4 = -1; k4 <= 1; k4++) {
                                    if (aflag[l1][j2][l2 + i4 + 25 + 1][j3 + k4 + 25 + 1]) {
                                        flag = true;
                                    } else if (aflag[l1][(j2 + 1) % 31][l2 + i4 + 25 + 1][j3 + k4 + 25 + 1]) {
                                        flag = true;
                                    } else if (aflag[l1 + 1][j2][l2 + i4 + 25 + 1][j3 + k4 + 25 + 1]) {
                                        flag = true;
                                    } else {
                                        if (!aflag[l1 + 1][(j2 + 1) % 31][l2 + i4 + 25 + 1][j3 + k4 + 25 + 1]) {
                                            continue;
                                        }
                                        flag = true;
                                    }
                                    break label0;
                                }
                            }
                            Scene.aBooleanArrayArrayArrayArray661[l1][j2][l2 + 25][j3 + 25] = flag;
                        }
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("75601, " + ai + ", " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static boolean method315(int i, int j, int k, int l) {
        try {
            if (j <= 0) {
                for (int i1 = 1; i1 > 0; i1++) {
                }
            }
            int j1 = k * Scene.anInt630 + l * Scene.anInt631 >> 16;
            int k1 = k * Scene.anInt631 - l * Scene.anInt630 >> 16;
            int l1 = i * Scene.anInt628 + k1 * Scene.anInt629 >> 16;
            int i2 = i * Scene.anInt629 - k1 * Scene.anInt628 >> 16;
            if (l1 < 50 || l1 > 3500) {
                return false;
            }
            int j2 = Scene.anInt663 + (j1 << 9) / l1;
            int k2 = Scene.anInt664 + (i2 << 9) / l1;
            return j2 >= Scene.anInt665 && j2 <= Scene.anInt667 && k2 >= Scene.anInt666 && k2 <= Scene.anInt668;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("70999, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method278(boolean flag) {
        try {
            for (int i = 0; i < anInt607; i++) {
                for (int j = 0; j < anInt608; j++) {
                    for (int l = 0; l < anInt609; l++) {
                        tiles[i][j][l] = null;
                    }
                }
            }
            for (int k = 0; k < Scene.anInt642; k++) {
                for (int i1 = 0; i1 < Scene.anIntArray643[k]; i1++) {
                    Scene.aClass23ArrayArray644[k][i1] = null;
                }
                Scene.anIntArray643[k] = 0;
            }
            for (int j1 = 0; j1 < anInt613; j1++) {
                aClass30Array614[j1] = null;
            }
            anInt613 = 0;
            if (!flag) {
                anInt598 = 178;
            }
            for (int k1 = 0; k1 < Scene.aClass30Array632.length; k1++) {
                Scene.aClass30Array632[k1] = null;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("97735, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method279(byte byte0, int i) {
        try {
            anInt612 = i;
            for (int j = 0; j < anInt608; j++) {
                for (int k = 0; k < anInt609; k++) {
                    tiles[i][j][k] = new SceneTile(i, j, k);
                }
            }
            if (byte0 != 7) {
                Scene.aBoolean599 = !Scene.aBoolean599;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("62223, " + byte0 + ", " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method280(boolean flag, int i, int j) {
        try {
            SceneTile class44_sub2 = tiles[0][j][i];
            for (int k = 0; k < 3; k++) {
                SceneTile class44_sub2_1 = tiles[k][j][i] = tiles[k + 1][j][i];
                if (class44_sub2_1 != null) {
                    class44_sub2_1.anInt1336--;
                    for (int i1 = 0; i1 < class44_sub2_1.anInt1346; i1++) {
                        SceneSpawnRequest class30 = class44_sub2_1.aClass30Array1347[i1];
                        if ((class30.anInt551 >> 29 & 3) == 2 && class30.anInt545 == j && class30.anInt547 == i) {
                            class30.anInt539--;
                        }
                    }
                }
            }
            if (tiles[0][j][i] == null) {
                tiles[0][j][i] = new SceneTile(0, j, i);
            }
            tiles[0][j][i].aClass44_Sub2_1358 = class44_sub2;
            if (!flag) {
                for (int l = 1; l > 0; l++) {
                }
            }
            tiles[3][j][i] = null;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90520, " + flag + ", " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method282(int i, int j, int k, int l) {
        SceneTile class44_sub2 = tiles[i][j][k];
        if (class44_sub2 == null) {
            return;
        } else {
            tiles[i][j][k].anInt1350 = l;
            return;
        }
    }

    public void method283(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2,
                          int i3, int j3, int k3, int l3, int i4, int j4, int k4, int l4) {
        if (l == 0) {
            GenericTile class27 = new GenericTile(k2, l2, i3, j3, -1, k4, false);
            for (int i5 = i; i5 >= 0; i5--) {
                if (tiles[i5][j][k] == null) {
                    tiles[i5][j][k] = new SceneTile(i5, j, k);
                }
            }
            tiles[i][j][k].aClass27_1340 = class27;
            return;
        }
        if (l == 1) {
            GenericTile class27_1 = new GenericTile(k3, l3, i4, j4, j1, l4, k1 == l1 && k1 == i2 && k1 == j2);
            for (int j5 = i; j5 >= 0; j5--) {
                if (tiles[j5][j][k] == null) {
                    tiles[j5][j][k] = new SceneTile(j5, j, k);
                }
            }
            tiles[i][j][k].aClass27_1340 = class27_1;
            return;
        }
        ComplexTile class15 = new ComplexTile(k3, l1, j, k2, j3, l4, i3, k4, k1, j1, j2, l3, j4, 356, i1, i4, k, l, l2,
                i2);
        for (int k5 = i; k5 >= 0; k5--) {
            if (tiles[k5][j][k] == null) {
                tiles[k5][j][k] = new SceneTile(k5, j, k);
            }
        }
        tiles[i][j][k].aClass15_1341 = class15;
    }

    public void method284(byte byte0, int i, int j, int k, boolean flag, int l, Renderable class44_sub3_sub4, int i1) {
        try {
            if (class44_sub3_sub4 == null) {
                return;
            }
            FloorDecoration class17 = new FloorDecoration();
            class17.aClass44_Sub3_Sub4_402 = class44_sub3_sub4;
            class17.anInt400 = i1 * 128 + 64;
            class17.anInt401 = k * 128 + 64;
            class17.anInt399 = l;
            if (!flag) {
                return;
            }
            class17.anInt403 = i;
            class17.aByte404 = byte0;
            if (tiles[j][i1][k] == null) {
                tiles[j][i1][k] = new SceneTile(j, i1, k);
            }
            tiles[j][i1][k].aClass17_1344 = class17;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("17484, " + byte0 + ", " + i + ", " + j + ", " + k + ", " + flag + ", " + l + ", "
                    + class44_sub3_sub4 + ", " + i1 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method285(int i, int j, Renderable class44_sub3_sub4, int k, byte byte0,
                          Renderable class44_sub3_sub4_1, int l, int i1, Renderable class44_sub3_sub4_2) {
        try {
            CameraAngle class19 = new CameraAngle();
            class19.aClass44_Sub3_Sub4_422 = class44_sub3_sub4_2;
            class19.anInt420 = k * 128 + 64;
            class19.anInt421 = i * 128 + 64;
            if (byte0 != 2) {
                return;
            }
            class19.anInt419 = i1;
            class19.anInt425 = j;
            class19.aClass44_Sub3_Sub4_423 = class44_sub3_sub4;
            class19.aClass44_Sub3_Sub4_424 = class44_sub3_sub4_1;
            int j1 = 0;
            SceneTile class44_sub2 = tiles[l][k][i];
            if (class44_sub2 != null) {
                for (int k1 = 0; k1 < class44_sub2.anInt1346; k1++) {
                    if (class44_sub2.aClass30Array1347[k1].aClass44_Sub3_Sub4_543 instanceof Model) {
                        int l1 = ((Model) class44_sub2.aClass30Array1347[k1].aClass44_Sub3_Sub4_543).anInt1563;
                        if (l1 > j1) {
                            j1 = l1;
                        }
                    }
                }
            }
            class19.anInt426 = j1;
            if (tiles[l][k][i] == null) {
                tiles[l][k][i] = new SceneTile(l, k, i);
            }
            tiles[l][k][i].aClass19_1345 = class19;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("37559, " + i + ", " + j + ", " + class44_sub3_sub4 + ", " + k + ", " + byte0 + ", "
                    + class44_sub3_sub4_1 + ", " + l + ", " + i1 + ", " + class44_sub3_sub4_2 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method286(byte byte0, int i, int j, int k, int l, Renderable class44_sub3_sub4, int i1, int j1,
                          Renderable class44_sub3_sub4_1, int k1, int l1) {
        try {
            while (i1 >= 0) {
                anInt605 = 306;
            }
            if (class44_sub3_sub4 == null && class44_sub3_sub4_1 == null) {
                return;
            }
            Wall class33 = new Wall();
            class33.anInt579 = k;
            class33.aByte580 = byte0;
            class33.anInt573 = l * 128 + 64;
            class33.anInt574 = l1 * 128 + 64;
            class33.anInt572 = j;
            class33.aClass44_Sub3_Sub4_577 = class44_sub3_sub4;
            class33.aClass44_Sub3_Sub4_578 = class44_sub3_sub4_1;
            class33.anInt575 = i;
            class33.anInt576 = j1;
            for (int i2 = k1; i2 >= 0; i2--) {
                if (tiles[i2][l][l1] == null) {
                    tiles[i2][l][l1] = new SceneTile(i2, l, l1);
                }
            }
            tiles[k1][l][l1].aClass33_1342 = class33;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("76425, " + byte0 + ", " + i + ", " + j + ", " + k + ", " + l + ", "
                    + class44_sub3_sub4 + ", " + i1 + ", " + j1 + ", " + class44_sub3_sub4_1 + ", " + k1 + ", " + l1
                    + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method287(int i, int j, int k, Renderable class44_sub3_sub4, byte byte0, int l, int i1, int j1, int k1,
                          int l1, int i2, int j2) {
        try {
            if (class44_sub3_sub4 == null) {
                return;
            }
            WallDecoration class13 = new WallDecoration();
            class13.anInt314 = j1;
            class13.aByte315 = byte0;
            class13.anInt309 = i2 * 128 + 64 + k1;
            class13.anInt310 = i * 128 + 64 + j2;
            class13.anInt308 = k;
            if (l1 != 30967) {
                return;
            }
            class13.aClass44_Sub3_Sub4_313 = class44_sub3_sub4;
            class13.anInt311 = l;
            class13.anInt312 = i1;
            for (int k2 = j; k2 >= 0; k2--) {
                if (tiles[k2][i2][i] == null) {
                    tiles[k2][i2][i] = new SceneTile(k2, i2, i);
                }
            }
            tiles[j][i2][i].aClass13_1343 = class13;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("5872, " + i + ", " + j + ", " + k + ", " + class44_sub3_sub4 + ", " + byte0 + ", "
                    + l + ", " + i1 + ", " + j1 + ", " + k1 + ", " + l1 + ", " + i2 + ", " + j2 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method288(int i, int j, int k, int l, byte byte0, int i1, int j1, int k1, int l1,
                             Renderable class44_sub3_sub4, int i2) {
        try {
            if (i != 0) {
                anInt600 = 216;
            }
            if (class44_sub3_sub4 == null) {
                return true;
            } else {
                int j2 = k * 128 + 64 * k1;
                int k2 = j * 128 + 64 * i2;
                return method291(l1, k, j, k1, i2, j2, k2, l, class44_sub3_sub4, j1, false, i1, byte0);
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("61682, " + i + ", " + j + ", " + k + ", " + l + ", " + byte0 + ", " + i1 + ", " + j1
                    + ", " + k1 + ", " + l1 + ", " + class44_sub3_sub4 + ", " + i2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method289(int i, int j, int k, int l, int i1, Renderable class44_sub3_sub4, int j1, boolean flag,
                             int k1, int l1) {
        try {
            if (class44_sub3_sub4 == null) {
                return true;
            }
            int i2 = l - i;
            int j2 = k1 - i;
            int k2 = l + i;
            int l2 = k1 + i;
            if (flag) {
                if (j1 > 640 && j1 < 1408) {
                    l2 += 128;
                }
                if (j1 > 1152 && j1 < 1920) {
                    k2 += 128;
                }
                if (j1 > 1664 || j1 < 384) {
                    j2 -= 128;
                }
                if (j1 > 128 && j1 < 896) {
                    i2 -= 128;
                }
            }
            i2 /= 128;
            j2 /= 128;
            k2 /= 128;
            i1 = 50 / i1;
            l2 /= 128;
            return method291(l1, i2, j2, (k2 - i2) + 1, (l2 - j2) + 1, l, k1, k, class44_sub3_sub4, j1, true, j,
                    (byte) 0);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("35176, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + class44_sub3_sub4
                    + ", " + j1 + ", " + flag + ", " + k1 + ", " + l1 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method290(int i, int j, boolean flag, int k, int l, int i1, int j1, Renderable class44_sub3_sub4,
                             int k1, int l1, int i2, int j2, int k2) {
        try {
            if (!flag) {
                anInt598 = 52;
            }
            if (class44_sub3_sub4 == null) {
                return true;
            } else {
                return method291(l1, j2, k, (l - j2) + 1, (j1 - k) + 1, i1, k1, i2, class44_sub3_sub4, k2, true, j,
                        (byte) 0);
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("59171, " + i + ", " + j + ", " + flag + ", " + k + ", " + l + ", " + i1 + ", " + j1
                    + ", " + class44_sub3_sub4 + ", " + k1 + ", " + l1 + ", " + i2 + ", " + j2 + ", " + k2 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method291(int i, int j, int k, int l, int i1, int j1, int k1, int l1, Renderable class44_sub3_sub4,
                             int i2, boolean flag, int j2, byte byte0) {
        for (int k2 = j; k2 < j + l; k2++) {
            for (int l2 = k; l2 < k + i1; l2++) {
                if (k2 < 0 || l2 < 0 || k2 >= anInt608 || l2 >= anInt609) {
                    return false;
                }
                SceneTile class44_sub2 = tiles[i][k2][l2];
                if (class44_sub2 != null && class44_sub2.anInt1346 >= 5) {
                    return false;
                }
            }
        }
        SceneSpawnRequest class30 = new SceneSpawnRequest();
        class30.anInt551 = j2;
        class30.aByte552 = byte0;
        class30.anInt539 = i;
        class30.anInt541 = j1;
        class30.anInt542 = k1;
        class30.anInt540 = l1;
        class30.aClass44_Sub3_Sub4_543 = class44_sub3_sub4;
        class30.anInt544 = i2;
        class30.anInt545 = j;
        class30.anInt547 = k;
        class30.anInt546 = (j + l) - 1;
        class30.anInt548 = (k + i1) - 1;
        for (int i3 = j; i3 < j + l; i3++) {
            for (int j3 = k; j3 < k + i1; j3++) {
                int k3 = 0;
                if (i3 > j) {
                    k3++;
                }
                if (i3 < (j + l) - 1) {
                    k3 += 4;
                }
                if (j3 > k) {
                    k3 += 8;
                }
                if (j3 < (k + i1) - 1) {
                    k3 += 2;
                }
                for (int l3 = i; l3 >= 0; l3--) {
                    if (tiles[l3][i3][j3] == null) {
                        tiles[l3][i3][j3] = new SceneTile(l3, i3, j3);
                    }
                }
                SceneTile class44_sub2_1 = tiles[i][i3][j3];
                class44_sub2_1.aClass30Array1347[class44_sub2_1.anInt1346] = class30;
                class44_sub2_1.anIntArray1348[class44_sub2_1.anInt1346] = k3;
                class44_sub2_1.anInt1349 |= k3;
                class44_sub2_1.anInt1346++;
            }
        }
        if (flag) {
            aClass30Array614[anInt613++] = class30;
        }
        return true;
    }

    public void method292(boolean flag) {
        try {
            for (int i = 0; i < anInt613; i++) {
                SceneSpawnRequest class30 = aClass30Array614[i];
                method293(6, class30);
                aClass30Array614[i] = null;
            }
            anInt613 = 0;
            if (!flag) {
                anInt605 = -18;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("98891, " + flag + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method293(int i, SceneSpawnRequest class30) {
        try {
            for (int j = class30.anInt545; j <= class30.anInt546; j++) {
                for (int k = class30.anInt547; k <= class30.anInt548; k++) {
                    SceneTile class44_sub2 = tiles[class30.anInt539][j][k];
                    if (class44_sub2 != null) {
                        for (int l = 0; l < class44_sub2.anInt1346; l++) {
                            if (class44_sub2.aClass30Array1347[l] != class30) {
                                continue;
                            }
                            class44_sub2.anInt1346--;
                            for (int i1 = l; i1 < class44_sub2.anInt1346; i1++) {
                                class44_sub2.aClass30Array1347[i1] = class44_sub2.aClass30Array1347[i1 + 1];
                                class44_sub2.anIntArray1348[i1] = class44_sub2.anIntArray1348[i1 + 1];
                            }
                            class44_sub2.aClass30Array1347[class44_sub2.anInt1346] = null;
                            break;
                        }
                        class44_sub2.anInt1349 = 0;
                        for (int j1 = 0; j1 < class44_sub2.anInt1346; j1++) {
                            class44_sub2.anInt1349 |= class44_sub2.anIntArray1348[j1];
                        }
                    }
                }
            }
            if (i != anInt601) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("97599, " + i + ", " + class30 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method294(int i, int j, byte byte0, int k, int l) {
        try {
            SceneTile class44_sub2 = tiles[l][k][i];
            if (class44_sub2 == null) {
                return;
            }
            WallDecoration class13 = class44_sub2.aClass13_1343;
            if (class13 == null) {
                return;
            }
            int i1 = k * 128 + 64;
            int j1 = i * 128 + 64;
            class13.anInt309 = i1 + ((class13.anInt309 - i1) * j) / 16;
            class13.anInt310 = j1 + ((class13.anInt310 - j1) * j) / 16;
            if (byte0 != aByte602) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("98774, " + i + ", " + j + ", " + byte0 + ", " + k + ", " + l + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method295(int i, int j, byte byte0, int k) {
        try {
            if (byte0 == 7) {
                byte0 = 0;
            } else {
                Scene.aBoolean599 = !Scene.aBoolean599;
            }
            SceneTile class44_sub2 = tiles[k][j][i];
            if (class44_sub2 == null) {
                return;
            } else {
                class44_sub2.aClass33_1342 = null;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("92449, " + i + ", " + j + ", " + byte0 + ", " + k + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method296(int i, int j, int k, int l) {
        try {
            SceneTile class44_sub2 = tiles[j][l][k];
            if (i <= 0) {
                for (int i1 = 1; i1 > 0; i1++) {
                }
            }
            if (class44_sub2 == null) {
                return;
            } else {
                class44_sub2.aClass13_1343 = null;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96930, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method297(int i, int j, int k, int l) {
        try {
            SceneTile class44_sub2 = tiles[j][l][k];
            if (i < 2 || i > 2) {
                anInt605 = -437;
            }
            if (class44_sub2 == null) {
                return;
            }
            for (int i1 = 0; i1 < class44_sub2.anInt1346; i1++) {
                SceneSpawnRequest class30 = class44_sub2.aClass30Array1347[i1];
                if ((class30.anInt551 >> 29 & 3) == 2 && class30.anInt545 == l && class30.anInt547 == k) {
                    method293(6, class30);
                    return;
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("37282, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method298(int i, int j, int k, int l) {
        try {
            SceneTile class44_sub2 = tiles[l][i][j];
            if (k < 3 || k > 3) {
                return;
            }
            if (class44_sub2 == null) {
                return;
            } else {
                class44_sub2.aClass17_1344 = null;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("45213, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method299(int i, int j, int k) {
        SceneTile class44_sub2 = tiles[i][j][k];
        if (class44_sub2 == null) {
            return;
        } else {
            class44_sub2.aClass19_1345 = null;
            return;
        }
    }

    public Wall method300(int i, boolean flag, int j, int k) {
        try {
            if (flag) {
                for (int l = 1; l > 0; l++) {
                }
            }
            SceneTile class44_sub2 = tiles[i][j][k];
            if (class44_sub2 == null) {
                return null;
            } else {
                return class44_sub2.aClass33_1342;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("53461, " + i + ", " + flag + ", " + j + ", " + k + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public WallDecoration method301(int i, int j, int k, int l) {
        try {
            if (j != 0) {
                throw new NullPointerException();
            }
            SceneTile class44_sub2 = tiles[k][l][i];
            if (class44_sub2 == null) {
                return null;
            } else {
                return class44_sub2.aClass13_1343;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("75079, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public SceneSpawnRequest method302(int i, int j, int k, int l) {
        try {
            SceneTile class44_sub2 = tiles[l][i][k];
            if (class44_sub2 == null) {
                return null;
            }
            for (int i1 = 0; i1 < class44_sub2.anInt1346; i1++) {
                SceneSpawnRequest class30 = class44_sub2.aClass30Array1347[i1];
                if ((class30.anInt551 >> 29 & 3) == 2 && class30.anInt545 == i && class30.anInt547 == k) {
                    return class30;
                }
            }
            if (j != 0) {
                throw new NullPointerException();
            } else {
                return null;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("4664, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public FloorDecoration method303(int i, int j, int k, int l) {
        try {
            SceneTile class44_sub2 = tiles[i][l][k];
            if (j != 0) {
                for (int i1 = 1; i1 > 0; i1++) {
                }
            }
            if (class44_sub2 == null || class44_sub2.aClass17_1344 == null) {
                return null;
            } else {
                return class44_sub2.aClass17_1344;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("68888, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method304(int i, int j, int k) {
        SceneTile class44_sub2 = tiles[i][j][k];
        if (class44_sub2 == null || class44_sub2.aClass33_1342 == null) {
            return 0;
        } else {
            return class44_sub2.aClass33_1342.anInt579;
        }
    }

    public int method305(int i, int j, int k, int l) {
        try {
            if (j != 7) {
                return 3;
            }
            SceneTile class44_sub2 = tiles[k][l][i];
            if (class44_sub2 == null || class44_sub2.aClass13_1343 == null) {
                return 0;
            } else {
                return class44_sub2.aClass13_1343.anInt314;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("89186, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method306(int i, int j, int k) {
        SceneTile class44_sub2 = tiles[i][j][k];
        if (class44_sub2 == null) {
            return 0;
        }
        for (int l = 0; l < class44_sub2.anInt1346; l++) {
            SceneSpawnRequest class30 = class44_sub2.aClass30Array1347[l];
            if ((class30.anInt551 >> 29 & 3) == 2 && class30.anInt545 == j && class30.anInt547 == k) {
                return class30.anInt551;
            }
        }
        return 0;
    }

    public int method307(int i, int j, int k) {
        SceneTile class44_sub2 = tiles[i][j][k];
        if (class44_sub2 == null || class44_sub2.aClass17_1344 == null) {
            return 0;
        } else {
            return class44_sub2.aClass17_1344.anInt403;
        }
    }

    public int method308(int i, int j, int k, int l) {
        SceneTile class44_sub2 = tiles[i][j][k];
        if (class44_sub2 == null) {
            return -1;
        }
        if (class44_sub2.aClass33_1342 != null && class44_sub2.aClass33_1342.anInt579 == l) {
            return class44_sub2.aClass33_1342.aByte580 & 0xff;
        }
        if (class44_sub2.aClass13_1343 != null && class44_sub2.aClass13_1343.anInt314 == l) {
            return class44_sub2.aClass13_1343.aByte315 & 0xff;
        }
        if (class44_sub2.aClass17_1344 != null && class44_sub2.aClass17_1344.anInt403 == l) {
            return class44_sub2.aClass17_1344.aByte404 & 0xff;
        }
        for (int i1 = 0; i1 < class44_sub2.anInt1346; i1++) {
            if (class44_sub2.aClass30Array1347[i1].anInt551 == l) {
                return class44_sub2.aClass30Array1347[i1].aByte552 & 0xff;
            }
        }
        return -1;
    }

    public void method309(int i, int j, int k, int l, int i1, int j1) {
        try {
            int k1 = (int) Math.sqrt(i1 * i1 + j1 * j1 + k * k);
            int l1 = l * k1 >> 8;
            for (int i2 = 0; i2 < anInt607; i2++) {
                for (int j2 = 0; j2 < anInt608; j2++) {
                    for (int k2 = 0; k2 < anInt609; k2++) {
                        SceneTile class44_sub2 = tiles[i2][j2][k2];
                        if (class44_sub2 != null) {
                            Wall class33 = class44_sub2.aClass33_1342;
                            if (class33 != null && class33.aClass44_Sub3_Sub4_577 != null
                                    && class33.aClass44_Sub3_Sub4_577.aClass25Array1411 != null) {
                                method311(j2, 1, 1, k2, i2, 5, (Model) class33.aClass44_Sub3_Sub4_577);
                                if (class33.aClass44_Sub3_Sub4_578 != null
                                        && class33.aClass44_Sub3_Sub4_578.aClass25Array1411 != null) {
                                    method311(j2, 1, 1, k2, i2, 5, (Model) class33.aClass44_Sub3_Sub4_578);
                                    method312((Model) class33.aClass44_Sub3_Sub4_577,
                                            (Model) class33.aClass44_Sub3_Sub4_578, 0, 0, 0, false);
                                    ((Model) class33.aClass44_Sub3_Sub4_578).method524(i, l1, i1, j1, k);
                                }
                                ((Model) class33.aClass44_Sub3_Sub4_577).method524(i, l1, i1, j1, k);
                            }
                            for (int l2 = 0; l2 < class44_sub2.anInt1346; l2++) {
                                SceneSpawnRequest class30 = class44_sub2.aClass30Array1347[l2];
                                if (class30 != null && class30.aClass44_Sub3_Sub4_543 != null
                                        && class30.aClass44_Sub3_Sub4_543.aClass25Array1411 != null) {
                                    method311(j2, (class30.anInt546 - class30.anInt545) + 1,
                                            (class30.anInt548 - class30.anInt547) + 1, k2, i2, 5,
                                            (Model) class30.aClass44_Sub3_Sub4_543);
                                    ((Model) class30.aClass44_Sub3_Sub4_543).method524(i, l1, i1, j1, k);
                                }
                            }
                            FloorDecoration class17 = class44_sub2.aClass17_1344;
                            if (class17 != null && class17.aClass44_Sub3_Sub4_402.aClass25Array1411 != null) {
                                method310(i2, true, k2, j2, (Model) class17.aClass44_Sub3_Sub4_402);
                                ((Model) class17.aClass44_Sub3_Sub4_402).method524(i, l1, i1, j1, k);
                            }
                        }
                    }
                }
            }
            if (j < 7 || j > 7) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("99141, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method310(int i, boolean flag, int j, int k, Model class44_sub3_sub4_sub4) {
        try {
            if (!flag) {
                anInt600 = 80;
            }
            if (k < anInt608) {
                SceneTile class44_sub2 = tiles[i][k + 1][j];
                if (class44_sub2 != null && class44_sub2.aClass17_1344 != null
                        && class44_sub2.aClass17_1344.aClass44_Sub3_Sub4_402.aClass25Array1411 != null) {
                    method312(class44_sub3_sub4_sub4, (Model) class44_sub2.aClass17_1344.aClass44_Sub3_Sub4_402, 128,
                            0, 0, true);
                }
            }
            if (j < anInt608) {
                SceneTile class44_sub2_1 = tiles[i][k][j + 1];
                if (class44_sub2_1 != null && class44_sub2_1.aClass17_1344 != null
                        && class44_sub2_1.aClass17_1344.aClass44_Sub3_Sub4_402.aClass25Array1411 != null) {
                    method312(class44_sub3_sub4_sub4, (Model) class44_sub2_1.aClass17_1344.aClass44_Sub3_Sub4_402, 0,
                            0, 128, true);
                }
            }
            if (k < anInt608 && j < anInt609) {
                SceneTile class44_sub2_2 = tiles[i][k + 1][j + 1];
                if (class44_sub2_2 != null && class44_sub2_2.aClass17_1344 != null
                        && class44_sub2_2.aClass17_1344.aClass44_Sub3_Sub4_402.aClass25Array1411 != null) {
                    method312(class44_sub3_sub4_sub4, (Model) class44_sub2_2.aClass17_1344.aClass44_Sub3_Sub4_402, 128,
                            0, 128, true);
                }
            }
            if (k < anInt608 && j > 0) {
                SceneTile class44_sub2_3 = tiles[i][k + 1][j - 1];
                if (class44_sub2_3 != null && class44_sub2_3.aClass17_1344 != null
                        && class44_sub2_3.aClass17_1344.aClass44_Sub3_Sub4_402.aClass25Array1411 != null) {
                    method312(class44_sub3_sub4_sub4, (Model) class44_sub2_3.aClass17_1344.aClass44_Sub3_Sub4_402, 128,
                            0, -128, true);
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("24584, " + i + ", " + flag + ", " + j + ", " + k + ", " + class44_sub3_sub4_sub4
                    + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method311(int i, int j, int k, int l, int i1, int j1, Model class44_sub3_sub4_sub4) {
        try {
            boolean flag = true;
            int k1 = i;
            int l1 = i + j;
            int i2 = l - 1;
            int j2 = l + k;
            if (j1 < 5 || j1 > 5) {
                return;
            }
            for (int k2 = i1; k2 <= i1 + 1; k2++) {
                if (k2 != anInt607) {
                    for (int l2 = k1; l2 <= l1; l2++) {
                        if (l2 >= 0 && l2 < anInt608) {
                            for (int i3 = i2; i3 <= j2; i3++) {
                                if (i3 >= 0 && i3 < anInt609 && (!flag || l2 >= l1 || i3 >= j2 || i3 < l && l2 != i)) {
                                    SceneTile class44_sub2 = tiles[k2][l2][i3];
                                    if (class44_sub2 != null) {
                                        int j3 = (anIntArrayArrayArray610[k2][l2][i3]
                                                + anIntArrayArrayArray610[k2][l2 + 1][i3]
                                                + anIntArrayArrayArray610[k2][l2][i3 + 1] + anIntArrayArrayArray610[k2][l2 + 1][i3 + 1])
                                                / 4
                                                - (anIntArrayArrayArray610[i1][i][l]
                                                + anIntArrayArrayArray610[i1][i + 1][l]
                                                + anIntArrayArrayArray610[i1][i][l + 1] + anIntArrayArrayArray610[i1][i + 1][l + 1])
                                                / 4;
                                        Wall class33 = class44_sub2.aClass33_1342;
                                        if (class33 != null && class33.aClass44_Sub3_Sub4_577 != null
                                                && class33.aClass44_Sub3_Sub4_577.aClass25Array1411 != null) {
                                            method312(class44_sub3_sub4_sub4, (Model) class33.aClass44_Sub3_Sub4_577,
                                                    (l2 - i) * 128 + (1 - j) * 64, j3, (i3 - l) * 128 + (1 - k) * 64,
                                                    flag);
                                        }
                                        if (class33 != null && class33.aClass44_Sub3_Sub4_578 != null
                                                && class33.aClass44_Sub3_Sub4_578.aClass25Array1411 != null) {
                                            method312(class44_sub3_sub4_sub4, (Model) class33.aClass44_Sub3_Sub4_578,
                                                    (l2 - i) * 128 + (1 - j) * 64, j3, (i3 - l) * 128 + (1 - k) * 64,
                                                    flag);
                                        }
                                        for (int k3 = 0; k3 < class44_sub2.anInt1346; k3++) {
                                            SceneSpawnRequest class30 = class44_sub2.aClass30Array1347[k3];
                                            if (class30 != null && class30.aClass44_Sub3_Sub4_543 != null
                                                    && class30.aClass44_Sub3_Sub4_543.aClass25Array1411 != null) {
                                                int l3 = (class30.anInt546 - class30.anInt545) + 1;
                                                int i4 = (class30.anInt548 - class30.anInt547) + 1;
                                                method312(class44_sub3_sub4_sub4,
                                                        (Model) class30.aClass44_Sub3_Sub4_543, (class30.anInt545 - i)
                                                                * 128 + (l3 - j) * 64, j3, (class30.anInt547 - l) * 128
                                                                + (i4 - k) * 64, flag);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    k1--;
                    flag = false;
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("36060, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", "
                    + class44_sub3_sub4_sub4 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method312(Model class44_sub3_sub4_sub4, Model class44_sub3_sub4_sub4_1, int i, int j, int k,
                          boolean flag) {
        anInt658++;
        int l = 0;
        int[] ai = class44_sub3_sub4_sub4_1.anIntArray1536;
        int i1 = class44_sub3_sub4_sub4_1.anInt1535;
        for (int j1 = 0; j1 < class44_sub3_sub4_sub4.anInt1535; j1++) {
            VertexNormal class25 = class44_sub3_sub4_sub4.aClass25Array1411[j1];
            VertexNormal class25_1 = class44_sub3_sub4_sub4.aClass25Array1569[j1];
            if (class25_1.anInt503 != 0) {
                int i2 = class44_sub3_sub4_sub4.anIntArray1537[j1] - j;
                if (i2 <= class44_sub3_sub4_sub4_1.anInt1560) {
                    int j2 = class44_sub3_sub4_sub4.anIntArray1536[j1] - i;
                    if (j2 >= class44_sub3_sub4_sub4_1.anInt1555 && j2 <= class44_sub3_sub4_sub4_1.anInt1556) {
                        int k2 = class44_sub3_sub4_sub4.anIntArray1538[j1] - k;
                        if (k2 >= class44_sub3_sub4_sub4_1.anInt1558 && k2 <= class44_sub3_sub4_sub4_1.anInt1557) {
                            for (int l2 = 0; l2 < i1; l2++) {
                                VertexNormal class25_2 = class44_sub3_sub4_sub4_1.aClass25Array1411[l2];
                                VertexNormal class25_3 = class44_sub3_sub4_sub4_1.aClass25Array1569[l2];
                                if (j2 == ai[l2] && k2 == class44_sub3_sub4_sub4_1.anIntArray1538[l2]
                                        && i2 == class44_sub3_sub4_sub4_1.anIntArray1537[l2] && class25_3.anInt503 != 0) {
                                    class25.anInt500 += class25_3.anInt500;
                                    class25.anInt501 += class25_3.anInt501;
                                    class25.anInt502 += class25_3.anInt502;
                                    class25.anInt503 += class25_3.anInt503;
                                    class25_2.anInt500 += class25_1.anInt500;
                                    class25_2.anInt501 += class25_1.anInt501;
                                    class25_2.anInt502 += class25_1.anInt502;
                                    class25_2.anInt503 += class25_1.anInt503;
                                    l++;
                                    anIntArray656[j1] = anInt658;
                                    anIntArray657[l2] = anInt658;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (l < 3 || !flag) {
            return;
        }
        for (int k1 = 0; k1 < class44_sub3_sub4_sub4.anInt1539; k1++) {
            if (anIntArray656[class44_sub3_sub4_sub4.anIntArray1540[k1]] == anInt658
                    && anIntArray656[class44_sub3_sub4_sub4.anIntArray1541[k1]] == anInt658
                    && anIntArray656[class44_sub3_sub4_sub4.anIntArray1542[k1]] == anInt658) {
                class44_sub3_sub4_sub4.anIntArray1546[k1] = -1;
            }
        }
        for (int l1 = 0; l1 < class44_sub3_sub4_sub4_1.anInt1539; l1++) {
            if (anIntArray657[class44_sub3_sub4_sub4_1.anIntArray1540[l1]] == anInt658
                    && anIntArray657[class44_sub3_sub4_sub4_1.anIntArray1541[l1]] == anInt658
                    && anIntArray657[class44_sub3_sub4_sub4_1.anIntArray1542[l1]] == anInt658) {
                class44_sub3_sub4_sub4_1.anIntArray1546[l1] = -1;
            }
        }
    }

    public void method313(int[] ai, int i, int j, int k, int l, int i1) {
        SceneTile class44_sub2 = tiles[k][l][i1];
        if (class44_sub2 == null) {
            return;
        }
        GenericTile class27 = class44_sub2.aClass27_1340;
        if (class27 != null) {
            int j1 = class27.anInt531;
            if (j1 == 0) {
                return;
            }
            for (int k1 = 0; k1 < 4; k1++) {
                ai[i] = j1;
                ai[i + 1] = j1;
                ai[i + 2] = j1;
                ai[i + 3] = j1;
                i += j;
            }
            return;
        }
        ComplexTile class15 = class44_sub2.aClass15_1341;
        if (class15 == null) {
            return;
        }
        int l1 = class15.anInt383;
        int i2 = class15.anInt384;
        int j2 = class15.anInt385;
        int k2 = class15.anInt386;
        int[] ai1 = anIntArrayArray659[l1];
        int[] ai2 = anIntArrayArray660[i2];
        int l2 = 0;
        if (j2 != 0) {
            for (int i3 = 0; i3 < 4; i3++) {
                ai[i] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                ai[i + 1] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                ai[i + 2] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                ai[i + 3] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                i += j;
            }
            return;
        }
        for (int j3 = 0; j3 < 4; j3++) {
            if (ai1[ai2[l2++]] != 0) {
                ai[i] = k2;
            }
            if (ai1[ai2[l2++]] != 0) {
                ai[i + 1] = k2;
            }
            if (ai1[ai2[l2++]] != 0) {
                ai[i + 2] = k2;
            }
            if (ai1[ai2[l2++]] != 0) {
                ai[i + 3] = k2;
            }
            i += j;
        }
    }

    public void method316(int i, int k) {
        try {
            Scene.aBoolean637 = true;
            Scene.anInt638 = k;
            Scene.anInt639 = i;
            Scene.anInt640 = -1;
            Scene.anInt641 = -1;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("21782, " + i + ", " + k + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method317(int i, int j, int k, int l, int i1, int j1, int k1) {
        try {
            if (i < 0) {
                i = 0;
            } else if (i >= anInt608 * 128) {
                i = anInt608 * 128 - 1;
            }
            if (l < 0) {
                l = 0;
            } else if (l >= anInt609 * 128) {
                l = anInt609 * 128 - 1;
            }
            Scene.anInt618++;
            Scene.anInt628 = Model.SINE[k];
            Scene.anInt629 = Model.COSINE[k];
            Scene.anInt630 = Model.SINE[k1];
            Scene.anInt631 = Model.COSINE[k1];
            Scene.aBooleanArrayArray662 = Scene.aBooleanArrayArrayArrayArray661[(k - 128) / 32][k1 / 64];
            Scene.anInt625 = i;
            if (j < anInt603 || j > anInt603) {
                anInt603 = -370;
            }
            Scene.anInt626 = j1;
            Scene.anInt627 = l;
            Scene.anInt623 = i / 128;
            Scene.anInt624 = l / 128;
            Scene.anInt617 = i1;
            Scene.anInt619 = Scene.anInt623 - 25;
            if (Scene.anInt619 < 0) {
                Scene.anInt619 = 0;
            }
            Scene.anInt621 = Scene.anInt624 - 25;
            if (Scene.anInt621 < 0) {
                Scene.anInt621 = 0;
            }
            Scene.anInt620 = Scene.anInt623 + 25;
            if (Scene.anInt620 > anInt608) {
                Scene.anInt620 = anInt608;
            }
            Scene.anInt622 = Scene.anInt624 + 25;
            if (Scene.anInt622 > anInt609) {
                Scene.anInt622 = anInt609;
            }
            method323(309);
            Scene.anInt616 = 0;
            for (int l1 = anInt612; l1 < anInt607; l1++) {
                SceneTile[][] aclass44_sub2 = tiles[l1];
                for (int j2 = Scene.anInt619; j2 < Scene.anInt620; j2++) {
                    for (int l2 = Scene.anInt621; l2 < Scene.anInt622; l2++) {
                        SceneTile class44_sub2 = aclass44_sub2[j2][l2];
                        if (class44_sub2 != null) {
                            if (class44_sub2.anInt1350 > i1
                                    || !Scene.aBooleanArrayArray662[(j2 - Scene.anInt623) + 25][(l2 - Scene.anInt624) + 25]
                                    && anIntArrayArrayArray610[l1][j2][l2] - j1 < 2000) {
                                class44_sub2.aBoolean1351 = false;
                                class44_sub2.aBoolean1352 = false;
                                class44_sub2.anInt1354 = 0;
                            } else {
                                class44_sub2.aBoolean1351 = true;
                                class44_sub2.aBoolean1352 = true;
                                class44_sub2.aBoolean1353 = class44_sub2.anInt1346 > 0;
                                Scene.anInt616++;
                            }
                        }
                    }
                }
            }
            for (int i2 = anInt612; i2 < anInt607; i2++) {
                SceneTile[][] aclass44_sub2_1 = tiles[i2];
                for (int i3 = -25; i3 <= 0; i3++) {
                    int j3 = Scene.anInt623 + i3;
                    int l3 = Scene.anInt623 - i3;
                    if (j3 >= Scene.anInt619 || l3 < Scene.anInt620) {
                        for (int j4 = -25; j4 <= 0; j4++) {
                            int l4 = Scene.anInt624 + j4;
                            int j5 = Scene.anInt624 - j4;
                            if (j3 >= Scene.anInt619) {
                                if (l4 >= Scene.anInt621) {
                                    SceneTile class44_sub2_1 = aclass44_sub2_1[j3][l4];
                                    if (class44_sub2_1 != null && class44_sub2_1.aBoolean1351) {
                                        method318(class44_sub2_1, true);
                                    }
                                }
                                if (j5 < Scene.anInt622) {
                                    SceneTile class44_sub2_2 = aclass44_sub2_1[j3][j5];
                                    if (class44_sub2_2 != null && class44_sub2_2.aBoolean1351) {
                                        method318(class44_sub2_2, true);
                                    }
                                }
                            }
                            if (l3 < Scene.anInt620) {
                                if (l4 >= Scene.anInt621) {
                                    SceneTile class44_sub2_3 = aclass44_sub2_1[l3][l4];
                                    if (class44_sub2_3 != null && class44_sub2_3.aBoolean1351) {
                                        method318(class44_sub2_3, true);
                                    }
                                }
                                if (j5 < Scene.anInt622) {
                                    SceneTile class44_sub2_4 = aclass44_sub2_1[l3][j5];
                                    if (class44_sub2_4 != null && class44_sub2_4.aBoolean1351) {
                                        method318(class44_sub2_4, true);
                                    }
                                }
                            }
                            if (Scene.anInt616 == 0) {
                                Scene.aBoolean637 = false;
                                return;
                            }
                        }
                    }
                }
            }
            for (int k2 = anInt612; k2 < anInt607; k2++) {
                SceneTile[][] aclass44_sub2_2 = tiles[k2];
                for (int k3 = -25; k3 <= 0; k3++) {
                    int i4 = Scene.anInt623 + k3;
                    int k4 = Scene.anInt623 - k3;
                    if (i4 >= Scene.anInt619 || k4 < Scene.anInt620) {
                        for (int i5 = -25; i5 <= 0; i5++) {
                            int k5 = Scene.anInt624 + i5;
                            int l5 = Scene.anInt624 - i5;
                            if (i4 >= Scene.anInt619) {
                                if (k5 >= Scene.anInt621) {
                                    SceneTile class44_sub2_5 = aclass44_sub2_2[i4][k5];
                                    if (class44_sub2_5 != null && class44_sub2_5.aBoolean1351) {
                                        method318(class44_sub2_5, false);
                                    }
                                }
                                if (l5 < Scene.anInt622) {
                                    SceneTile class44_sub2_6 = aclass44_sub2_2[i4][l5];
                                    if (class44_sub2_6 != null && class44_sub2_6.aBoolean1351) {
                                        method318(class44_sub2_6, false);
                                    }
                                }
                            }
                            if (k4 < Scene.anInt620) {
                                if (k5 >= Scene.anInt621) {
                                    SceneTile class44_sub2_7 = aclass44_sub2_2[k4][k5];
                                    if (class44_sub2_7 != null && class44_sub2_7.aBoolean1351) {
                                        method318(class44_sub2_7, false);
                                    }
                                }
                                if (l5 < Scene.anInt622) {
                                    SceneTile class44_sub2_8 = aclass44_sub2_2[k4][l5];
                                    if (class44_sub2_8 != null && class44_sub2_8.aBoolean1351) {
                                        method318(class44_sub2_8, false);
                                    }
                                }
                            }
                            if (Scene.anInt616 == 0) {
                                Scene.aBoolean637 = false;
                                return;
                            }
                        }
                    }
                }
            }
            Scene.aBoolean637 = false;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("81634, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", " + k1
                    + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method318(SceneTile class44_sub2, boolean flag) {
        Scene.aClass28_647.method256(class44_sub2);
        do {
            SceneTile class44_sub2_1;
            do {
                class44_sub2_1 = (SceneTile) Scene.aClass28_647.method258();
                if (class44_sub2_1 == null) {
                    return;
                }
            } while (!class44_sub2_1.aBoolean1352);
            int i = class44_sub2_1.anInt1337;
            int j = class44_sub2_1.anInt1338;
            int k = class44_sub2_1.anInt1336;
            int l = class44_sub2_1.anInt1339;
            SceneTile[][] aclass44_sub2 = tiles[k];
            if (class44_sub2_1.aBoolean1351) {
                if (flag) {
                    if (k > 0) {
                        SceneTile class44_sub2_2 = tiles[k - 1][i][j];
                        if (class44_sub2_2 != null && class44_sub2_2.aBoolean1352) {
                            continue;
                        }
                    }
                    if (i <= Scene.anInt623 && i > Scene.anInt619) {
                        SceneTile class44_sub2_3 = aclass44_sub2[i - 1][j];
                        if (class44_sub2_3 != null && class44_sub2_3.aBoolean1352
                                && (class44_sub2_3.aBoolean1351 || (class44_sub2_1.anInt1349 & 1) == 0)) {
                            continue;
                        }
                    }
                    if (i >= Scene.anInt623 && i < Scene.anInt620 - 1) {
                        SceneTile class44_sub2_4 = aclass44_sub2[i + 1][j];
                        if (class44_sub2_4 != null && class44_sub2_4.aBoolean1352
                                && (class44_sub2_4.aBoolean1351 || (class44_sub2_1.anInt1349 & 4) == 0)) {
                            continue;
                        }
                    }
                    if (j <= Scene.anInt624 && j > Scene.anInt621) {
                        SceneTile class44_sub2_5 = aclass44_sub2[i][j - 1];
                        if (class44_sub2_5 != null && class44_sub2_5.aBoolean1352
                                && (class44_sub2_5.aBoolean1351 || (class44_sub2_1.anInt1349 & 8) == 0)) {
                            continue;
                        }
                    }
                    if (j >= Scene.anInt624 && j < Scene.anInt622 - 1) {
                        SceneTile class44_sub2_6 = aclass44_sub2[i][j + 1];
                        if (class44_sub2_6 != null && class44_sub2_6.aBoolean1352
                                && (class44_sub2_6.aBoolean1351 || (class44_sub2_1.anInt1349 & 2) == 0)) {
                            continue;
                        }
                    }
                } else {
                    flag = true;
                }
                class44_sub2_1.aBoolean1351 = false;
                if (class44_sub2_1.aClass44_Sub2_1358 != null) {
                    SceneTile class44_sub2_7 = class44_sub2_1.aClass44_Sub2_1358;
                    if (class44_sub2_7.aClass27_1340 != null) {
                        if (!method324(0, i, j)) {
                            method319(class44_sub2_7.aClass27_1340, 0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                    Scene.anInt631, i, j);
                        }
                    } else if (class44_sub2_7.aClass15_1341 != null && !method324(0, i, j)) {
                        method320(i, Scene.anInt630, (byte) -89, j, Scene.anInt628, class44_sub2_7.aClass15_1341,
                                Scene.anInt631, Scene.anInt629);
                    }
                    Wall class33 = class44_sub2_7.aClass33_1342;
                    if (class33 != null) {
                        class33.aClass44_Sub3_Sub4_577.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                Scene.anInt631, class33.anInt573 - Scene.anInt625, class33.anInt572 - Scene.anInt626,
                                class33.anInt574 - Scene.anInt627, class33.anInt579);
                    }
                    for (int i2 = 0; i2 < class44_sub2_7.anInt1346; i2++) {
                        SceneSpawnRequest class30 = class44_sub2_7.aClass30Array1347[i2];
                        if (class30 != null) {
                            class30.aClass44_Sub3_Sub4_543.method498(class30.anInt544, Scene.anInt628, Scene.anInt629,
                                    Scene.anInt630, Scene.anInt631, class30.anInt541 - Scene.anInt625, class30.anInt540
                                            - Scene.anInt626, class30.anInt542 - Scene.anInt627, class30.anInt551);
                        }
                    }
                }
                boolean flag1 = false;
                if (class44_sub2_1.aClass27_1340 != null) {
                    if (!method324(l, i, j)) {
                        flag1 = true;
                        method319(class44_sub2_1.aClass27_1340, l, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                Scene.anInt631, i, j);
                    }
                } else if (class44_sub2_1.aClass15_1341 != null && !method324(l, i, j)) {
                    flag1 = true;
                    method320(i, Scene.anInt630, (byte) -89, j, Scene.anInt628, class44_sub2_1.aClass15_1341,
                            Scene.anInt631, Scene.anInt629);
                }
                int j1 = 0;
                int j2 = 0;
                Wall class33_3 = class44_sub2_1.aClass33_1342;
                WallDecoration class13_1 = class44_sub2_1.aClass13_1343;
                if (class33_3 != null || class13_1 != null) {
                    if (Scene.anInt623 == i) {
                        j1++;
                    } else if (Scene.anInt623 < i) {
                        j1 += 2;
                    }
                    if (Scene.anInt624 == j) {
                        j1 += 3;
                    } else if (Scene.anInt624 > j) {
                        j1 += 6;
                    }
                    j2 = Scene.anIntArray648[j1];
                    class44_sub2_1.anInt1357 = Scene.anIntArray650[j1];
                }
                if (class33_3 != null) {
                    if ((class33_3.anInt575 & Scene.anIntArray649[j1]) != 0) {
                        if (class33_3.anInt575 == 16) {
                            class44_sub2_1.anInt1354 = 3;
                            class44_sub2_1.anInt1355 = Scene.anIntArray651[j1];
                            class44_sub2_1.anInt1356 = 3 - class44_sub2_1.anInt1355;
                        } else if (class33_3.anInt575 == 32) {
                            class44_sub2_1.anInt1354 = 6;
                            class44_sub2_1.anInt1355 = Scene.anIntArray652[j1];
                            class44_sub2_1.anInt1356 = 6 - class44_sub2_1.anInt1355;
                        } else if (class33_3.anInt575 == 64) {
                            class44_sub2_1.anInt1354 = 12;
                            class44_sub2_1.anInt1355 = Scene.anIntArray653[j1];
                            class44_sub2_1.anInt1356 = 12 - class44_sub2_1.anInt1355;
                        } else {
                            class44_sub2_1.anInt1354 = 9;
                            class44_sub2_1.anInt1355 = Scene.anIntArray654[j1];
                            class44_sub2_1.anInt1356 = 9 - class44_sub2_1.anInt1355;
                        }
                    } else {
                        class44_sub2_1.anInt1354 = 0;
                    }
                    if ((class33_3.anInt575 & j2) != 0 && !method325(l, i, j, class33_3.anInt575)) {
                        class33_3.aClass44_Sub3_Sub4_577.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                Scene.anInt631, class33_3.anInt573 - Scene.anInt625, class33_3.anInt572
                                        - Scene.anInt626, class33_3.anInt574 - Scene.anInt627, class33_3.anInt579);
                    }
                    if ((class33_3.anInt576 & j2) != 0 && !method325(l, i, j, class33_3.anInt576)) {
                        class33_3.aClass44_Sub3_Sub4_578.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                Scene.anInt631, class33_3.anInt573 - Scene.anInt625, class33_3.anInt572
                                        - Scene.anInt626, class33_3.anInt574 - Scene.anInt627, class33_3.anInt579);
                    }
                }
                if (class13_1 != null && !method326(l, i, j, class13_1.aClass44_Sub3_Sub4_313.anInt1412)) {
                    if ((class13_1.anInt311 & j2) != 0) {
                        class13_1.aClass44_Sub3_Sub4_313.method498(class13_1.anInt312, Scene.anInt628, Scene.anInt629,
                                Scene.anInt630, Scene.anInt631, class13_1.anInt309 - Scene.anInt625, class13_1.anInt308
                                        - Scene.anInt626, class13_1.anInt310 - Scene.anInt627, class13_1.anInt314);
                    } else if ((class13_1.anInt311 & 0x300) != 0) {
                        int j4 = class13_1.anInt309 - Scene.anInt625;
                        int l5 = class13_1.anInt308 - Scene.anInt626;
                        int k6 = class13_1.anInt310 - Scene.anInt627;
                        int i8 = class13_1.anInt312;
                        int k9;
                        if (i8 == 1 || i8 == 2) {
                            k9 = -j4;
                        } else {
                            k9 = j4;
                        }
                        int k10;
                        if (i8 == 2 || i8 == 3) {
                            k10 = -k6;
                        } else {
                            k10 = k6;
                        }
                        if ((class13_1.anInt311 & 0x100) != 0 && k10 < k9) {
                            int i11 = j4 + Scene.anIntArray633[i8];
                            int k11 = k6 + Scene.anIntArray634[i8];
                            class13_1.aClass44_Sub3_Sub4_313.method498(i8 * 512 + 256, Scene.anInt628, Scene.anInt629,
                                    Scene.anInt630, Scene.anInt631, i11, l5, k11, class13_1.anInt314);
                        }
                        if ((class13_1.anInt311 & 0x200) != 0 && k10 > k9) {
                            int j11 = j4 + Scene.anIntArray635[i8];
                            int l11 = k6 + Scene.anIntArray636[i8];
                            class13_1.aClass44_Sub3_Sub4_313.method498(i8 * 512 + 1280 & 0x7ff, Scene.anInt628,
                                    Scene.anInt629, Scene.anInt630, Scene.anInt631, j11, l5, l11, class13_1.anInt314);
                        }
                    }
                }
                if (flag1) {
                    FloorDecoration class17 = class44_sub2_1.aClass17_1344;
                    if (class17 != null) {
                        class17.aClass44_Sub3_Sub4_402.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                Scene.anInt631, class17.anInt400 - Scene.anInt625, class17.anInt399 - Scene.anInt626,
                                class17.anInt401 - Scene.anInt627, class17.anInt403);
                    }
                    CameraAngle class19_1 = class44_sub2_1.aClass19_1345;
                    if (class19_1 != null && class19_1.anInt426 == 0) {
                        if (class19_1.aClass44_Sub3_Sub4_423 != null) {
                            class19_1.aClass44_Sub3_Sub4_423.method498(0, Scene.anInt628, Scene.anInt629,
                                    Scene.anInt630, Scene.anInt631, class19_1.anInt420 - Scene.anInt625,
                                    class19_1.anInt419 - Scene.anInt626, class19_1.anInt421 - Scene.anInt627,
                                    class19_1.anInt425);
                        }
                        if (class19_1.aClass44_Sub3_Sub4_424 != null) {
                            class19_1.aClass44_Sub3_Sub4_424.method498(0, Scene.anInt628, Scene.anInt629,
                                    Scene.anInt630, Scene.anInt631, class19_1.anInt420 - Scene.anInt625,
                                    class19_1.anInt419 - Scene.anInt626, class19_1.anInt421 - Scene.anInt627,
                                    class19_1.anInt425);
                        }
                        if (class19_1.aClass44_Sub3_Sub4_422 != null) {
                            class19_1.aClass44_Sub3_Sub4_422.method498(0, Scene.anInt628, Scene.anInt629,
                                    Scene.anInt630, Scene.anInt631, class19_1.anInt420 - Scene.anInt625,
                                    class19_1.anInt419 - Scene.anInt626, class19_1.anInt421 - Scene.anInt627,
                                    class19_1.anInt425);
                        }
                    }
                }
                int k4 = class44_sub2_1.anInt1349;
                if (k4 != 0) {
                    if (i < Scene.anInt623 && (k4 & 4) != 0) {
                        SceneTile class44_sub2_17 = aclass44_sub2[i + 1][j];
                        if (class44_sub2_17 != null && class44_sub2_17.aBoolean1352) {
                            Scene.aClass28_647.method256(class44_sub2_17);
                        }
                    }
                    if (j < Scene.anInt624 && (k4 & 2) != 0) {
                        SceneTile class44_sub2_18 = aclass44_sub2[i][j + 1];
                        if (class44_sub2_18 != null && class44_sub2_18.aBoolean1352) {
                            Scene.aClass28_647.method256(class44_sub2_18);
                        }
                    }
                    if (i > Scene.anInt623 && (k4 & 1) != 0) {
                        SceneTile class44_sub2_19 = aclass44_sub2[i - 1][j];
                        if (class44_sub2_19 != null && class44_sub2_19.aBoolean1352) {
                            Scene.aClass28_647.method256(class44_sub2_19);
                        }
                    }
                    if (j > Scene.anInt624 && (k4 & 8) != 0) {
                        SceneTile class44_sub2_20 = aclass44_sub2[i][j - 1];
                        if (class44_sub2_20 != null && class44_sub2_20.aBoolean1352) {
                            Scene.aClass28_647.method256(class44_sub2_20);
                        }
                    }
                }
            }
            if (class44_sub2_1.anInt1354 != 0) {
                boolean flag2 = true;
                for (int k1 = 0; k1 < class44_sub2_1.anInt1346; k1++) {
                    if (class44_sub2_1.aClass30Array1347[k1].anInt550 == Scene.anInt618
                            || (class44_sub2_1.anIntArray1348[k1] & class44_sub2_1.anInt1354) != class44_sub2_1.anInt1355) {
                        continue;
                    }
                    flag2 = false;
                    break;
                }
                if (flag2) {
                    Wall class33_1 = class44_sub2_1.aClass33_1342;
                    if (!method325(l, i, j, class33_1.anInt575)) {
                        class33_1.aClass44_Sub3_Sub4_577.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                Scene.anInt631, class33_1.anInt573 - Scene.anInt625, class33_1.anInt572
                                        - Scene.anInt626, class33_1.anInt574 - Scene.anInt627, class33_1.anInt579);
                    }
                    class44_sub2_1.anInt1354 = 0;
                }
            }
            if (class44_sub2_1.aBoolean1353) {
                try {
                    int i1 = class44_sub2_1.anInt1346;
                    class44_sub2_1.aBoolean1353 = false;
                    int l1 = 0;
                    label0:
                    for (int k2 = 0; k2 < i1; k2++) {
                        SceneSpawnRequest class30_1 = class44_sub2_1.aClass30Array1347[k2];
                        if (class30_1.anInt550 == Scene.anInt618) {
                            continue;
                        }
                        for (int k3 = class30_1.anInt545; k3 <= class30_1.anInt546; k3++) {
                            for (int l4 = class30_1.anInt547; l4 <= class30_1.anInt548; l4++) {
                                SceneTile class44_sub2_21 = aclass44_sub2[k3][l4];
                                if (class44_sub2_21.aBoolean1351) {
                                    class44_sub2_1.aBoolean1353 = true;
                                } else {
                                    if (class44_sub2_21.anInt1354 == 0) {
                                        continue;
                                    }
                                    int l6 = 0;
                                    if (k3 > class30_1.anInt545) {
                                        l6++;
                                    }
                                    if (k3 < class30_1.anInt546) {
                                        l6 += 4;
                                    }
                                    if (l4 > class30_1.anInt547) {
                                        l6 += 8;
                                    }
                                    if (l4 < class30_1.anInt548) {
                                        l6 += 2;
                                    }
                                    if ((l6 & class44_sub2_21.anInt1354) != class44_sub2_1.anInt1356) {
                                        continue;
                                    }
                                    class44_sub2_1.aBoolean1353 = true;
                                }
                                continue label0;
                            }
                        }
                        Scene.aClass30Array632[l1++] = class30_1;
                        int i5 = Scene.anInt623 - class30_1.anInt545;
                        int i6 = class30_1.anInt546 - Scene.anInt623;
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        int i7 = Scene.anInt624 - class30_1.anInt547;
                        int j8 = class30_1.anInt548 - Scene.anInt624;
                        if (j8 > i7) {
                            class30_1.anInt549 = i5 + j8;
                        } else {
                            class30_1.anInt549 = i5 + i7;
                        }
                    }
                    while (l1 > 0) {
                        int i3 = -50;
                        int l3 = -1;
                        for (int j5 = 0; j5 < l1; j5++) {
                            SceneSpawnRequest class30_2 = Scene.aClass30Array632[j5];
                            if (class30_2.anInt550 != Scene.anInt618) {
                                if (class30_2.anInt549 > i3) {
                                    i3 = class30_2.anInt549;
                                    l3 = j5;
                                } else if (class30_2.anInt549 == i3) {
                                    int j7 = class30_2.anInt541 - Scene.anInt625;
                                    int k8 = class30_2.anInt542 - Scene.anInt627;
                                    int l9 = Scene.aClass30Array632[l3].anInt541 - Scene.anInt625;
                                    int l10 = Scene.aClass30Array632[l3].anInt542 - Scene.anInt627;
                                    if (j7 * j7 + k8 * k8 > l9 * l9 + l10 * l10) {
                                        l3 = j5;
                                    }
                                }
                            }
                        }
                        if (l3 == -1) {
                            break;
                        }
                        SceneSpawnRequest class30_3 = Scene.aClass30Array632[l3];
                        class30_3.anInt550 = Scene.anInt618;
                        if (!method327(l, class30_3.anInt545, class30_3.anInt546, class30_3.anInt547,
                                class30_3.anInt548, class30_3.aClass44_Sub3_Sub4_543.anInt1412)) {
                            class30_3.aClass44_Sub3_Sub4_543.method498(class30_3.anInt544, Scene.anInt628,
                                    Scene.anInt629, Scene.anInt630, Scene.anInt631,
                                    class30_3.anInt541 - Scene.anInt625, class30_3.anInt540 - Scene.anInt626,
                                    class30_3.anInt542 - Scene.anInt627, class30_3.anInt551);
                        }
                        for (int k7 = class30_3.anInt545; k7 <= class30_3.anInt546; k7++) {
                            for (int l8 = class30_3.anInt547; l8 <= class30_3.anInt548; l8++) {
                                SceneTile class44_sub2_22 = aclass44_sub2[k7][l8];
                                if (class44_sub2_22.anInt1354 != 0) {
                                    Scene.aClass28_647.method256(class44_sub2_22);
                                } else if ((k7 != i || l8 != j) && class44_sub2_22.aBoolean1352) {
                                    Scene.aClass28_647.method256(class44_sub2_22);
                                }
                            }
                        }
                    }
                    if (class44_sub2_1.aBoolean1353) {
                        continue;
                    }
                } catch (Exception _ex) {
                    class44_sub2_1.aBoolean1353 = false;
                }
            }
            if (!class44_sub2_1.aBoolean1352 || class44_sub2_1.anInt1354 != 0) {
                continue;
            }
            if (i <= Scene.anInt623 && i > Scene.anInt619) {
                SceneTile class44_sub2_8 = aclass44_sub2[i - 1][j];
                if (class44_sub2_8 != null && class44_sub2_8.aBoolean1352) {
                    continue;
                }
            }
            if (i >= Scene.anInt623 && i < Scene.anInt620 - 1) {
                SceneTile class44_sub2_9 = aclass44_sub2[i + 1][j];
                if (class44_sub2_9 != null && class44_sub2_9.aBoolean1352) {
                    continue;
                }
            }
            if (j <= Scene.anInt624 && j > Scene.anInt621) {
                SceneTile class44_sub2_10 = aclass44_sub2[i][j - 1];
                if (class44_sub2_10 != null && class44_sub2_10.aBoolean1352) {
                    continue;
                }
            }
            if (j >= Scene.anInt624 && j < Scene.anInt622 - 1) {
                SceneTile class44_sub2_11 = aclass44_sub2[i][j + 1];
                if (class44_sub2_11 != null && class44_sub2_11.aBoolean1352) {
                    continue;
                }
            }
            class44_sub2_1.aBoolean1352 = false;
            Scene.anInt616--;
            CameraAngle class19 = class44_sub2_1.aClass19_1345;
            if (class19 != null && class19.anInt426 != 0) {
                if (class19.aClass44_Sub3_Sub4_423 != null) {
                    class19.aClass44_Sub3_Sub4_423.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                            Scene.anInt631, class19.anInt420 - Scene.anInt625, class19.anInt419 - Scene.anInt626
                                    - class19.anInt426, class19.anInt421 - Scene.anInt627, class19.anInt425);
                }
                if (class19.aClass44_Sub3_Sub4_424 != null) {
                    class19.aClass44_Sub3_Sub4_424.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                            Scene.anInt631, class19.anInt420 - Scene.anInt625, class19.anInt419 - Scene.anInt626
                                    - class19.anInt426, class19.anInt421 - Scene.anInt627, class19.anInt425);
                }
                if (class19.aClass44_Sub3_Sub4_422 != null) {
                    class19.aClass44_Sub3_Sub4_422.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                            Scene.anInt631, class19.anInt420 - Scene.anInt625, class19.anInt419 - Scene.anInt626
                                    - class19.anInt426, class19.anInt421 - Scene.anInt627, class19.anInt425);
                }
            }
            if (class44_sub2_1.anInt1357 != 0) {
                WallDecoration class13 = class44_sub2_1.aClass13_1343;
                if (class13 != null && !method326(l, i, j, class13.aClass44_Sub3_Sub4_313.anInt1412)) {
                    if ((class13.anInt311 & class44_sub2_1.anInt1357) != 0) {
                        class13.aClass44_Sub3_Sub4_313.method498(class13.anInt312, Scene.anInt628, Scene.anInt629,
                                Scene.anInt630, Scene.anInt631, class13.anInt309 - Scene.anInt625, class13.anInt308
                                        - Scene.anInt626, class13.anInt310 - Scene.anInt627, class13.anInt314);
                    } else if ((class13.anInt311 & 0x300) != 0) {
                        int l2 = class13.anInt309 - Scene.anInt625;
                        int j3 = class13.anInt308 - Scene.anInt626;
                        int i4 = class13.anInt310 - Scene.anInt627;
                        int k5 = class13.anInt312;
                        int j6;
                        if (k5 == 1 || k5 == 2) {
                            j6 = -l2;
                        } else {
                            j6 = l2;
                        }
                        int l7;
                        if (k5 == 2 || k5 == 3) {
                            l7 = -i4;
                        } else {
                            l7 = i4;
                        }
                        if ((class13.anInt311 & 0x100) != 0 && l7 >= j6) {
                            int i9 = l2 + Scene.anIntArray633[k5];
                            int i10 = i4 + Scene.anIntArray634[k5];
                            class13.aClass44_Sub3_Sub4_313.method498(k5 * 512 + 256, Scene.anInt628, Scene.anInt629,
                                    Scene.anInt630, Scene.anInt631, i9, j3, i10, class13.anInt314);
                        }
                        if ((class13.anInt311 & 0x200) != 0 && l7 <= j6) {
                            int j9 = l2 + Scene.anIntArray635[k5];
                            int j10 = i4 + Scene.anIntArray636[k5];
                            class13.aClass44_Sub3_Sub4_313.method498(k5 * 512 + 1280 & 0x7ff, Scene.anInt628,
                                    Scene.anInt629, Scene.anInt630, Scene.anInt631, j9, j3, j10, class13.anInt314);
                        }
                    }
                }
                Wall class33_2 = class44_sub2_1.aClass33_1342;
                if (class33_2 != null) {
                    if ((class33_2.anInt576 & class44_sub2_1.anInt1357) != 0 && !method325(l, i, j, class33_2.anInt576)) {
                        class33_2.aClass44_Sub3_Sub4_578.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                Scene.anInt631, class33_2.anInt573 - Scene.anInt625, class33_2.anInt572
                                        - Scene.anInt626, class33_2.anInt574 - Scene.anInt627, class33_2.anInt579);
                    }
                    if ((class33_2.anInt575 & class44_sub2_1.anInt1357) != 0 && !method325(l, i, j, class33_2.anInt575)) {
                        class33_2.aClass44_Sub3_Sub4_577.method498(0, Scene.anInt628, Scene.anInt629, Scene.anInt630,
                                Scene.anInt631, class33_2.anInt573 - Scene.anInt625, class33_2.anInt572
                                        - Scene.anInt626, class33_2.anInt574 - Scene.anInt627, class33_2.anInt579);
                    }
                }
            }
            if (k < anInt607 - 1) {
                SceneTile class44_sub2_12 = tiles[k + 1][i][j];
                if (class44_sub2_12 != null && class44_sub2_12.aBoolean1352) {
                    Scene.aClass28_647.method256(class44_sub2_12);
                }
            }
            if (i < Scene.anInt623) {
                SceneTile class44_sub2_13 = aclass44_sub2[i + 1][j];
                if (class44_sub2_13 != null && class44_sub2_13.aBoolean1352) {
                    Scene.aClass28_647.method256(class44_sub2_13);
                }
            }
            if (j < Scene.anInt624) {
                SceneTile class44_sub2_14 = aclass44_sub2[i][j + 1];
                if (class44_sub2_14 != null && class44_sub2_14.aBoolean1352) {
                    Scene.aClass28_647.method256(class44_sub2_14);
                }
            }
            if (i > Scene.anInt623) {
                SceneTile class44_sub2_15 = aclass44_sub2[i - 1][j];
                if (class44_sub2_15 != null && class44_sub2_15.aBoolean1352) {
                    Scene.aClass28_647.method256(class44_sub2_15);
                }
            }
            if (j > Scene.anInt624) {
                SceneTile class44_sub2_16 = aclass44_sub2[i][j - 1];
                if (class44_sub2_16 != null && class44_sub2_16.aBoolean1352) {
                    Scene.aClass28_647.method256(class44_sub2_16);
                }
            }
        } while (true);
    }

    public void method319(GenericTile class27, int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1;
        int i2 = l1 = (j1 << 7) - Scene.anInt625;
        int j2;
        int k2 = j2 = (k1 << 7) - Scene.anInt627;
        int l2;
        int i3 = l2 = i2 + 128;
        int j3;
        int k3 = j3 = k2 + 128;
        int l3 = anIntArrayArrayArray610[i][j1][k1] - Scene.anInt626;
        int i4 = anIntArrayArrayArray610[i][j1 + 1][k1] - Scene.anInt626;
        int j4 = anIntArrayArrayArray610[i][j1 + 1][k1 + 1] - Scene.anInt626;
        int k4 = anIntArrayArrayArray610[i][j1][k1 + 1] - Scene.anInt626;
        int l4 = k2 * l + i2 * i1 >> 16;
        k2 = k2 * i1 - i2 * l >> 16;
        i2 = l4;
        l4 = l3 * k - k2 * j >> 16;
        k2 = l3 * j + k2 * k >> 16;
        l3 = l4;
        if (k2 < 50) {
            return;
        }
        l4 = j2 * l + i3 * i1 >> 16;
        j2 = j2 * i1 - i3 * l >> 16;
        i3 = l4;
        l4 = i4 * k - j2 * j >> 16;
        j2 = i4 * j + j2 * k >> 16;
        i4 = l4;
        if (j2 < 50) {
            return;
        }
        l4 = k3 * l + l2 * i1 >> 16;
        k3 = k3 * i1 - l2 * l >> 16;
        l2 = l4;
        l4 = j4 * k - k3 * j >> 16;
        k3 = j4 * j + k3 * k >> 16;
        j4 = l4;
        if (k3 < 50) {
            return;
        }
        l4 = j3 * l + l1 * i1 >> 16;
        j3 = j3 * i1 - l1 * l >> 16;
        l1 = l4;
        l4 = k4 * k - j3 * j >> 16;
        j3 = k4 * j + j3 * k >> 16;
        k4 = l4;
        if (j3 < 50) {
            return;
        }
        int i5 = Draw3D.centerX + (i2 << 9) / k2;
        int j5 = Draw3D.centerY + (l3 << 9) / k2;
        int k5 = Draw3D.centerX + (i3 << 9) / j2;
        int l5 = Draw3D.centerY + (i4 << 9) / j2;
        int i6 = Draw3D.centerX + (l2 << 9) / k3;
        int j6 = Draw3D.centerY + (j4 << 9) / k3;
        int k6 = Draw3D.centerX + (l1 << 9) / j3;
        int l6 = Draw3D.centerY + (k4 << 9) / j3;
        Draw3D.anInt1422 = 0;
        if ((i6 - k6) * (l5 - l6) - (j6 - l6) * (k5 - k6) > 0) {
            Draw3D.aBoolean1419 = i6 < 0 || k6 < 0 || k5 < 0 || i6 > Draw2D.boundX || k6 > Draw2D.boundX
                    || k5 > Draw2D.boundX;
            if (Scene.aBoolean637 && method322(Scene.anInt638, Scene.anInt639, j6, l6, l5, i6, k6, k5)) {
                Scene.anInt640 = j1;
                Scene.anInt641 = k1;
            }
            if (class27.anInt529 == -1) {
                if (class27.anInt527 != 0xbc614e) {
                    Draw3D
                            .method429(j6, l6, l5, i6, k6, k5, class27.anInt527, class27.anInt528, class27.anInt526);
                }
            } else if (!Scene.aBoolean606) {
                if (class27.aBoolean530) {
                    Draw3D.method433(j6, l6, l5, i6, k6, k5, class27.anInt527, class27.anInt528,
                            class27.anInt526, i2, i3, l1, l3, i4, k4, k2, j2, j3, class27.anInt529);
                } else {
                    Draw3D.method433(j6, l6, l5, i6, k6, k5, class27.anInt527, class27.anInt528,
                            class27.anInt526, l2, l1, i3, j4, k4, i4, k3, j3, j2, class27.anInt529);
                }
            } else {
                int i7 = Scene.anIntArray655[class27.anInt529];
                Draw3D.method429(j6, l6, l5, i6, k6, k5, method321(class27.anInt527, i7, anInt604),
                        method321(class27.anInt528, i7, anInt604), method321(class27.anInt526, i7, anInt604));
            }
        }
        if ((i5 - k5) * (l6 - l5) - (j5 - l5) * (k6 - k5) > 0) {
            Draw3D.aBoolean1419 = i5 < 0 || k5 < 0 || k6 < 0 || i5 > Draw2D.boundX || k5 > Draw2D.boundX
                    || k6 > Draw2D.boundX;
            if (Scene.aBoolean637 && method322(Scene.anInt638, Scene.anInt639, j5, l5, l6, i5, k5, k6)) {
                Scene.anInt640 = j1;
                Scene.anInt641 = k1;
            }
            if (class27.anInt529 == -1) {
                if (class27.anInt525 != 0xbc614e) {
                    Draw3D
                            .method429(j5, l5, l6, i5, k5, k6, class27.anInt525, class27.anInt526, class27.anInt528);
                    return;
                }
            } else {
                if (!Scene.aBoolean606) {
                    Draw3D.method433(j5, l5, l6, i5, k5, k6, class27.anInt525, class27.anInt526,
                            class27.anInt528, i2, i3, l1, l3, i4, k4, k2, j2, j3, class27.anInt529);
                    return;
                }
                int j7 = Scene.anIntArray655[class27.anInt529];
                Draw3D.method429(j5, l5, l6, i5, k5, k6, method321(class27.anInt525, j7, anInt604),
                        method321(class27.anInt526, j7, anInt604), method321(class27.anInt528, j7, anInt604));
            }
        }
    }

    public void method320(int i, int j, byte byte0, int k, int l, ComplexTile class15, int i1, int j1) {
        try {
            int k1 = class15.anIntArray372.length;
            if (byte0 != -89) {
                return;
            }
            for (int l1 = 0; l1 < k1; l1++) {
                int i2 = class15.anIntArray372[l1] - Scene.anInt625;
                int k2 = class15.anIntArray373[l1] - Scene.anInt626;
                int i3 = class15.anIntArray374[l1] - Scene.anInt627;
                int k3 = i3 * j + i2 * i1 >> 16;
                i3 = i3 * i1 - i2 * j >> 16;
                i2 = k3;
                k3 = k2 * j1 - i3 * l >> 16;
                i3 = k2 * l + i3 * j1 >> 16;
                k2 = k3;
                if (i3 < 50) {
                    return;
                }
                if (class15.anIntArray381 != null) {
                    ComplexTile.anIntArray389[l1] = i2;
                    ComplexTile.anIntArray390[l1] = k2;
                    ComplexTile.anIntArray391[l1] = i3;
                }
                ComplexTile.anIntArray387[l1] = Draw3D.centerX + (i2 << 9) / i3;
                ComplexTile.anIntArray388[l1] = Draw3D.centerY + (k2 << 9) / i3;
            }
            Draw3D.anInt1422 = 0;
            k1 = class15.anIntArray378.length;
            for (int j2 = 0; j2 < k1; j2++) {
                int l2 = class15.anIntArray378[j2];
                int j3 = class15.anIntArray379[j2];
                int l3 = class15.anIntArray380[j2];
                int i4 = ComplexTile.anIntArray387[l2];
                int j4 = ComplexTile.anIntArray387[j3];
                int k4 = ComplexTile.anIntArray387[l3];
                int l4 = ComplexTile.anIntArray388[l2];
                int i5 = ComplexTile.anIntArray388[j3];
                int j5 = ComplexTile.anIntArray388[l3];
                if ((i4 - j4) * (j5 - i5) - (l4 - i5) * (k4 - j4) > 0) {
                    Draw3D.aBoolean1419 = i4 < 0 || j4 < 0 || k4 < 0 || i4 > Draw2D.boundX || j4 > Draw2D.boundX
                            || k4 > Draw2D.boundX;
                    if (Scene.aBoolean637 && method322(Scene.anInt638, Scene.anInt639, l4, i5, j5, i4, j4, k4)) {
                        Scene.anInt640 = i;
                        Scene.anInt641 = k;
                    }
                    if (class15.anIntArray381 == null || class15.anIntArray381[j2] == -1) {
                        if (class15.anIntArray375[j2] != 0xbc614e) {
                            Draw3D.method429(l4, i5, j5, i4, j4, k4, class15.anIntArray375[j2],
                                    class15.anIntArray376[j2], class15.anIntArray377[j2]);
                        }
                    } else if (!Scene.aBoolean606) {
                        if (class15.aBoolean382) {
                            Draw3D.method433(l4, i5, j5, i4, j4, k4, class15.anIntArray375[j2],
                                    class15.anIntArray376[j2], class15.anIntArray377[j2], ComplexTile.anIntArray389[0],
                                    ComplexTile.anIntArray389[1], ComplexTile.anIntArray389[3],
                                    ComplexTile.anIntArray390[0], ComplexTile.anIntArray390[1],
                                    ComplexTile.anIntArray390[3], ComplexTile.anIntArray391[0],
                                    ComplexTile.anIntArray391[1], ComplexTile.anIntArray391[3],
                                    class15.anIntArray381[j2]);
                        } else {
                            Draw3D.method433(l4, i5, j5, i4, j4, k4, class15.anIntArray375[j2],
                                    class15.anIntArray376[j2], class15.anIntArray377[j2],
                                    ComplexTile.anIntArray389[l2], ComplexTile.anIntArray389[j3],
                                    ComplexTile.anIntArray389[l3], ComplexTile.anIntArray390[l2],
                                    ComplexTile.anIntArray390[j3], ComplexTile.anIntArray390[l3],
                                    ComplexTile.anIntArray391[l2], ComplexTile.anIntArray391[j3],
                                    ComplexTile.anIntArray391[l3], class15.anIntArray381[j2]);
                        }
                    } else {
                        int k5 = Scene.anIntArray655[class15.anIntArray381[j2]];
                        Draw3D.method429(l4, i5, j5, i4, j4, k4,
                                method321(class15.anIntArray375[j2], k5, anInt604),
                                method321(class15.anIntArray376[j2], k5, anInt604),
                                method321(class15.anIntArray377[j2], k5, anInt604));
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("98500, " + i + ", " + j + ", " + byte0 + ", " + k + ", " + l + ", " + class15 + ", "
                    + i1 + ", " + j1 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method321(int i, int j, int k) {
        try {
            i = 127 - i;
            i = (i * (j & 0x7f)) / 160;
            if (k != 5) {
                for (int l = 1; l > 0; l++) {
                }
            }
            if (i < 2) {
                i = 2;
            } else if (i > 126) {
                i = 126;
            }
            return (j & 0xff80) + i;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("54179, " + i + ", " + j + ", " + k + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public boolean method322(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
        if (j < k && j < l && j < i1) {
            return false;
        }
        if (j > k && j > l && j > i1) {
            return false;
        }
        if (i < j1 && i < k1 && i < l1) {
            return false;
        }
        if (i > j1 && i > k1 && i > l1) {
            return false;
        }
        int i2 = (j - k) * (k1 - j1) - (i - j1) * (l - k);
        int j2 = (j - i1) * (j1 - l1) - (i - l1) * (k - i1);
        int k2 = (j - l) * (l1 - k1) - (i - k1) * (i1 - l);
        return i2 * k2 > 0 && k2 * j2 > 0;
    }

    public void method323(int i) {
        try {
            i = 89 / i;
            int j = Scene.anIntArray643[Scene.anInt617];
            SceneCluster[] aclass23 = Scene.aClass23ArrayArray644[Scene.anInt617];
            Scene.anInt645 = 0;
            for (int k = 0; k < j; k++) {
                SceneCluster class23 = aclass23[k];
                if (class23.anInt475 == 1) {
                    int l = (class23.anInt471 - Scene.anInt623) + 25;
                    if (l < 0 || l > 50) {
                        continue;
                    }
                    int k1 = (class23.anInt473 - Scene.anInt624) + 25;
                    if (k1 < 0) {
                        k1 = 0;
                    }
                    int j2 = (class23.anInt474 - Scene.anInt624) + 25;
                    if (j2 > 50) {
                        j2 = 50;
                    }
                    boolean flag = false;
                    while (k1 <= j2) {
                        if (Scene.aBooleanArrayArray662[l][k1++]) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    int j3 = Scene.anInt625 - class23.anInt476;
                    if (j3 > 32) {
                        class23.anInt482 = 1;
                    } else {
                        if (j3 >= -32) {
                            continue;
                        }
                        class23.anInt482 = 2;
                        j3 = -j3;
                    }
                    class23.anInt485 = (class23.anInt478 - Scene.anInt627 << 8) / j3;
                    class23.anInt486 = (class23.anInt479 - Scene.anInt627 << 8) / j3;
                    class23.anInt487 = (class23.anInt480 - Scene.anInt626 << 8) / j3;
                    class23.anInt488 = (class23.anInt481 - Scene.anInt626 << 8) / j3;
                    Scene.aClass23Array646[Scene.anInt645++] = class23;
                    continue;
                }
                if (class23.anInt475 == 2) {
                    int i1 = (class23.anInt473 - Scene.anInt624) + 25;
                    if (i1 < 0 || i1 > 50) {
                        continue;
                    }
                    int l1 = (class23.anInt471 - Scene.anInt623) + 25;
                    if (l1 < 0) {
                        l1 = 0;
                    }
                    int k2 = (class23.anInt472 - Scene.anInt623) + 25;
                    if (k2 > 50) {
                        k2 = 50;
                    }
                    boolean flag1 = false;
                    while (l1 <= k2) {
                        if (Scene.aBooleanArrayArray662[l1++][i1]) {
                            flag1 = true;
                            break;
                        }
                    }
                    if (!flag1) {
                        continue;
                    }
                    int k3 = Scene.anInt627 - class23.anInt478;
                    if (k3 > 32) {
                        class23.anInt482 = 3;
                    } else {
                        if (k3 >= -32) {
                            continue;
                        }
                        class23.anInt482 = 4;
                        k3 = -k3;
                    }
                    class23.anInt483 = (class23.anInt476 - Scene.anInt625 << 8) / k3;
                    class23.anInt484 = (class23.anInt477 - Scene.anInt625 << 8) / k3;
                    class23.anInt487 = (class23.anInt480 - Scene.anInt626 << 8) / k3;
                    class23.anInt488 = (class23.anInt481 - Scene.anInt626 << 8) / k3;
                    Scene.aClass23Array646[Scene.anInt645++] = class23;
                } else if (class23.anInt475 == 4) {
                    int j1 = class23.anInt480 - Scene.anInt626;
                    if (j1 > 128) {
                        int i2 = (class23.anInt473 - Scene.anInt624) + 25;
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        int l2 = (class23.anInt474 - Scene.anInt624) + 25;
                        if (l2 > 50) {
                            l2 = 50;
                        }
                        if (i2 <= l2) {
                            int i3 = (class23.anInt471 - Scene.anInt623) + 25;
                            if (i3 < 0) {
                                i3 = 0;
                            }
                            int l3 = (class23.anInt472 - Scene.anInt623) + 25;
                            if (l3 > 50) {
                                l3 = 50;
                            }
                            boolean flag2 = false;
                            label0:
                            for (int i4 = i3; i4 <= l3; i4++) {
                                for (int j4 = i2; j4 <= l2; j4++) {
                                    if (!Scene.aBooleanArrayArray662[i4][j4]) {
                                        continue;
                                    }
                                    flag2 = true;
                                    break label0;
                                }
                            }
                            if (flag2) {
                                class23.anInt482 = 5;
                                class23.anInt483 = (class23.anInt476 - Scene.anInt625 << 8) / j1;
                                class23.anInt484 = (class23.anInt477 - Scene.anInt625 << 8) / j1;
                                class23.anInt485 = (class23.anInt478 - Scene.anInt627 << 8) / j1;
                                class23.anInt486 = (class23.anInt479 - Scene.anInt627 << 8) / j1;
                                Scene.aClass23Array646[Scene.anInt645++] = class23;
                            }
                        }
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90061, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method324(int i, int j, int k) {
        int l = anIntArrayArrayArray615[i][j][k];
        if (l == -Scene.anInt618) {
            return false;
        }
        if (l == Scene.anInt618) {
            return true;
        }
        int i1 = j << 7;
        int j1 = k << 7;
        if (method328(i1 + 1, anIntArrayArrayArray610[i][j][k], j1 + 1)
                && method328((i1 + 128) - 1, anIntArrayArrayArray610[i][j + 1][k], j1 + 1)
                && method328((i1 + 128) - 1, anIntArrayArrayArray610[i][j + 1][k + 1], (j1 + 128) - 1)
                && method328(i1 + 1, anIntArrayArrayArray610[i][j][k + 1], (j1 + 128) - 1)) {
            anIntArrayArrayArray615[i][j][k] = Scene.anInt618;
            return true;
        } else {
            anIntArrayArrayArray615[i][j][k] = -Scene.anInt618;
            return false;
        }
    }

    public boolean method325(int i, int j, int k, int l) {
        if (!method324(i, j, k)) {
            return false;
        }
        int i1 = j << 7;
        int j1 = k << 7;
        int k1 = anIntArrayArrayArray610[i][j][k] - 1;
        int l1 = k1 - 120;
        int i2 = k1 - 230;
        int j2 = k1 - 238;
        if (l < 16) {
            if (l == 1) {
                if (i1 > Scene.anInt625) {
                    if (!method328(i1, k1, j1)) {
                        return false;
                    }
                    if (!method328(i1, k1, j1 + 128)) {
                        return false;
                    }
                }
                if (i > 0) {
                    if (!method328(i1, l1, j1)) {
                        return false;
                    }
                    if (!method328(i1, l1, j1 + 128)) {
                        return false;
                    }
                }
                if (!method328(i1, i2, j1)) {
                    return false;
                }
                return method328(i1, i2, j1 + 128);
            }
            if (l == 2) {
                if (j1 < Scene.anInt627) {
                    if (!method328(i1, k1, j1 + 128)) {
                        return false;
                    }
                    if (!method328(i1 + 128, k1, j1 + 128)) {
                        return false;
                    }
                }
                if (i > 0) {
                    if (!method328(i1, l1, j1 + 128)) {
                        return false;
                    }
                    if (!method328(i1 + 128, l1, j1 + 128)) {
                        return false;
                    }
                }
                if (!method328(i1, i2, j1 + 128)) {
                    return false;
                }
                return method328(i1 + 128, i2, j1 + 128);
            }
            if (l == 4) {
                if (i1 < Scene.anInt625) {
                    if (!method328(i1 + 128, k1, j1)) {
                        return false;
                    }
                    if (!method328(i1 + 128, k1, j1 + 128)) {
                        return false;
                    }
                }
                if (i > 0) {
                    if (!method328(i1 + 128, l1, j1)) {
                        return false;
                    }
                    if (!method328(i1 + 128, l1, j1 + 128)) {
                        return false;
                    }
                }
                if (!method328(i1 + 128, i2, j1)) {
                    return false;
                }
                return method328(i1 + 128, i2, j1 + 128);
            }
            if (l == 8) {
                if (j1 > Scene.anInt627) {
                    if (!method328(i1, k1, j1)) {
                        return false;
                    }
                    if (!method328(i1 + 128, k1, j1)) {
                        return false;
                    }
                }
                if (i > 0) {
                    if (!method328(i1, l1, j1)) {
                        return false;
                    }
                    if (!method328(i1 + 128, l1, j1)) {
                        return false;
                    }
                }
                if (!method328(i1, i2, j1)) {
                    return false;
                }
                return method328(i1 + 128, i2, j1);
            }
        }
        if (!method328(i1 + 64, j2, j1 + 64)) {
            return false;
        }
        if (l == 16) {
            return method328(i1, i2, j1 + 128);
        }
        if (l == 32) {
            return method328(i1 + 128, i2, j1 + 128);
        }
        if (l == 64) {
            return method328(i1 + 128, i2, j1);
        }
        if (l == 128) {
            return method328(i1, i2, j1);
        } else {
            System.out.println("Warning unsupported wall type");
            return true;
        }
    }

    public boolean method326(int i, int j, int k, int l) {
        if (!method324(i, j, k)) {
            return false;
        }
        int i1 = j << 7;
        int j1 = k << 7;
        return method328(i1 + 1, anIntArrayArrayArray610[i][j][k] - l, j1 + 1)
                && method328((i1 + 128) - 1, anIntArrayArrayArray610[i][j + 1][k] - l, j1 + 1)
                && method328((i1 + 128) - 1, anIntArrayArrayArray610[i][j + 1][k + 1] - l, (j1 + 128) - 1)
                && method328(i1 + 1, anIntArrayArrayArray610[i][j][k + 1] - l, (j1 + 128) - 1);
    }

    public boolean method327(int i, int j, int k, int l, int i1, int j1) {
        if (j == k && l == i1) {
            if (!method324(i, j, l)) {
                return false;
            }
            int k1 = j << 7;
            int i2 = l << 7;
            return method328(k1 + 1, anIntArrayArrayArray610[i][j][l] - j1, i2 + 1)
                    && method328((k1 + 128) - 1, anIntArrayArrayArray610[i][j + 1][l] - j1, i2 + 1)
                    && method328((k1 + 128) - 1, anIntArrayArrayArray610[i][j + 1][l + 1] - j1, (i2 + 128) - 1)
                    && method328(k1 + 1, anIntArrayArrayArray610[i][j][l + 1] - j1, (i2 + 128) - 1);
        }
        for (int l1 = j; l1 <= k; l1++) {
            for (int j2 = l; j2 <= i1; j2++) {
                if (anIntArrayArrayArray615[i][l1][j2] == -Scene.anInt618) {
                    return false;
                }
            }
        }
        int k2 = (j << 7) + 1;
        int l2 = (l << 7) + 2;
        int i3 = anIntArrayArrayArray610[i][j][l] - j1;
        if (!method328(k2, i3, l2)) {
            return false;
        }
        int j3 = (k << 7) - 1;
        if (!method328(j3, i3, l2)) {
            return false;
        }
        int k3 = (i1 << 7) - 1;
        if (!method328(k2, i3, k3)) {
            return false;
        }
        return method328(j3, i3, k3);
    }

    public boolean method328(int i, int j, int k) {
        for (int l = 0; l < Scene.anInt645; l++) {
            SceneCluster class23 = Scene.aClass23Array646[l];
            if (class23.anInt482 == 1) {
                int i1 = class23.anInt476 - i;
                if (i1 > 0) {
                    int j2 = class23.anInt478 + (class23.anInt485 * i1 >> 8);
                    int k3 = class23.anInt479 + (class23.anInt486 * i1 >> 8);
                    int l4 = class23.anInt480 + (class23.anInt487 * i1 >> 8);
                    int i6 = class23.anInt481 + (class23.anInt488 * i1 >> 8);
                    if (k >= j2 && k <= k3 && j >= l4 && j <= i6) {
                        return true;
                    }
                }
            } else if (class23.anInt482 == 2) {
                int j1 = i - class23.anInt476;
                if (j1 > 0) {
                    int k2 = class23.anInt478 + (class23.anInt485 * j1 >> 8);
                    int l3 = class23.anInt479 + (class23.anInt486 * j1 >> 8);
                    int i5 = class23.anInt480 + (class23.anInt487 * j1 >> 8);
                    int j6 = class23.anInt481 + (class23.anInt488 * j1 >> 8);
                    if (k >= k2 && k <= l3 && j >= i5 && j <= j6) {
                        return true;
                    }
                }
            } else if (class23.anInt482 == 3) {
                int k1 = class23.anInt478 - k;
                if (k1 > 0) {
                    int l2 = class23.anInt476 + (class23.anInt483 * k1 >> 8);
                    int i4 = class23.anInt477 + (class23.anInt484 * k1 >> 8);
                    int j5 = class23.anInt480 + (class23.anInt487 * k1 >> 8);
                    int k6 = class23.anInt481 + (class23.anInt488 * k1 >> 8);
                    if (i >= l2 && i <= i4 && j >= j5 && j <= k6) {
                        return true;
                    }
                }
            } else if (class23.anInt482 == 4) {
                int l1 = k - class23.anInt478;
                if (l1 > 0) {
                    int i3 = class23.anInt476 + (class23.anInt483 * l1 >> 8);
                    int j4 = class23.anInt477 + (class23.anInt484 * l1 >> 8);
                    int k5 = class23.anInt480 + (class23.anInt487 * l1 >> 8);
                    int l6 = class23.anInt481 + (class23.anInt488 * l1 >> 8);
                    if (i >= i3 && i <= j4 && j >= k5 && j <= l6) {
                        return true;
                    }
                }
            } else if (class23.anInt482 == 5) {
                int i2 = j - class23.anInt480;
                if (i2 > 0) {
                    int j3 = class23.anInt476 + (class23.anInt483 * i2 >> 8);
                    int k4 = class23.anInt477 + (class23.anInt484 * i2 >> 8);
                    int l5 = class23.anInt478 + (class23.anInt485 * i2 >> 8);
                    int i7 = class23.anInt479 + (class23.anInt486 * i2 >> 8);
                    if (i >= j3 && i <= k4 && k >= l5 && k <= i7) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

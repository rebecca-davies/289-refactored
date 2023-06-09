package com.runescape.renderable;

import com.runescape.type.SeqType;
import com.runescape.util.SignLink;

public class Actor extends Renderable {

    public boolean aBoolean1613;
    public boolean aBoolean1614;
    public int x;
    public int z;
    public int yaw;
    public boolean needsForwardDrawPadding;
    public int size;
    public int standSeqId;
    public int standTurnSeqId;
    public int walkSeqId;
    public int turnSeqId;
    public int turnRightSeqId;
    public int turnLeftSeqId;
    public int runSeqId;
    public String spoken;
    public int spokenLife;
    public int spokenColour;
    public int spokenEffect;
    public int[] anIntArray1631;
    public int[] anIntArray1632;
    public int[] anIntArray1633;
    public int lastCombatCycle;
    public int currentHealth;
    public int maxHealth;
    public int targetEntitiy;
    public int focusX;
    public int focusZ;
    public int anInt1640;
    public int anInt1641;
    public int anInt1642;
    public int primarySeq;
    public int currentSeqFrame;
    public int currentSeqDelay;
    public int primarySeqDelays;
    public int primarySeqPlays;
    public int spotAnimId;
    public int currentSeqId;
    public int currentSeqDurationRemaining;
    public int spotAnimEndCycle;
    public int spotAnimHeight;
    public int srcTileX;
    public int dstTileX;
    public int srcTileZ;
    public int dstTileZ;
    public int firstMoveCycle;
    public int lastMoveCycle;
    public int faceDirection;
    public int anInt1660;
    public int anInt1661;
    public int anInt1662;
    public int anInt1663;
    public int anInt1664;
    public int[] pathTileX;
    public int[] pathTileZ;
    public boolean[] aBooleanArray1667;
    public int anInt1668;
    public int anInt1669;

    public Actor() {
        aBoolean1613 = false;
        aBoolean1614 = false;
        needsForwardDrawPadding = false;
        size = 1;
        standSeqId = -1;
        standTurnSeqId = -1;
        walkSeqId = -1;
        turnSeqId = -1;
        turnRightSeqId = -1;
        turnLeftSeqId = -1;
        runSeqId = -1;
        spokenLife = 100;
        anIntArray1631 = new int[4];
        anIntArray1632 = new int[4];
        anIntArray1633 = new int[4];
        lastCombatCycle = -1000;
        targetEntitiy = -1;
        anInt1640 = -1;
        primarySeq = -1;
        spotAnimId = -1;
        anInt1661 = 200;
        anInt1663 = 32;
        pathTileX = new int[10];
        pathTileZ = new int[10];
        aBooleanArray1667 = new boolean[10];
    }

    public void method532(int i, boolean flag, int j, byte byte0) {
        try {
            if (primarySeq != -1 && SeqType.cache[primarySeq].anInt521 == 1) {
                primarySeq = -1;
            }
            if (!flag) {
                int k = i - pathTileX[0];
                int l = j - pathTileZ[0];
                if (k >= -8 && k <= 8 && l >= -8 && l <= 8) {
                    if (anInt1664 < 9) {
                        anInt1664++;
                    }
                    for (int i1 = anInt1664; i1 > 0; i1--) {
                        pathTileX[i1] = pathTileX[i1 - 1];
                        pathTileZ[i1] = pathTileZ[i1 - 1];
                        aBooleanArray1667[i1] = aBooleanArray1667[i1 - 1];
                    }
                    pathTileX[0] = i;
                    pathTileZ[0] = j;
                    aBooleanArray1667[0] = false;
                    return;
                }
            }
            anInt1664 = 0;
            anInt1669 = 0;
            anInt1668 = 0;
            pathTileX[0] = i;
            pathTileZ[0] = j;
            x = pathTileX[0] * 128 + size * 64;
            if (byte0 == 1) {
                byte0 = 0;
            } else {
                aBoolean1613 = !aBoolean1613;
            }
            z = pathTileZ[0] * 128 + size * 64;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("61882, " + i + ", " + flag + ", " + j + ", " + byte0 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method533(boolean flag, int i, int j) {
        try {
            int k = pathTileX[0];
            int l = pathTileZ[0];
            if (i == 0) {
                k--;
                l++;
            }
            if (i == 1) {
                l++;
            }
            if (i == 2) {
                k++;
                l++;
            }
            if (i == 3) {
                k--;
            }
            if (i == 4) {
                k++;
            }
            if (i == 5) {
                k--;
                l--;
            }
            if (i == 6) {
                l--;
            }
            if (i == 7) {
                k++;
                l--;
            }
            if (primarySeq != -1 && SeqType.cache[primarySeq].anInt521 == 1) {
                primarySeq = -1;
            }
            if (anInt1664 < 9) {
                anInt1664++;
            }
            for (int i1 = anInt1664; i1 > 0; i1--) {
                pathTileX[i1] = pathTileX[i1 - 1];
                pathTileZ[i1] = pathTileZ[i1 - 1];
                aBooleanArray1667[i1] = aBooleanArray1667[i1 - 1];
            }
            pathTileX[0] = k;
            pathTileZ[0] = l;
            aBooleanArray1667[0] = flag;
            if (j != -6002) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("37957, " + flag + ", " + i + ", " + j + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method534(boolean flag) {
        try {
            if (flag) {
                aBoolean1614 = !aBoolean1614;
            }
            anInt1664 = 0;
            anInt1669 = 0;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("39799, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public boolean isVisible(boolean flag) {
        try {
            if (!flag) {
                throw new NullPointerException();
            } else {
                return false;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("30413, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void updateHitData(int i, int j, int k, boolean flag) {
        try {
            if (flag) {
                return;
            }
            for (int l = 0; l < 4; l++) {
                if (anIntArray1633[l] <= j) {
                    anIntArray1631[l] = k;
                    anIntArray1632[l] = i;
                    anIntArray1633[l] = j + 70;
                    return;
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("15311, " + i + ", " + j + ", " + k + ", " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }
}

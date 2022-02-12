package com.runescape.collection;

import com.runescape.util.SignLink;

public class HashTable {

    public boolean aBoolean764;
    public boolean aBoolean765;
    public int anInt766;
    public int anInt767;
    public Node aClass44Array768[];

    public HashTable(int i, byte byte0) {
        aBoolean764 = false;
        aBoolean765 = false;
        anInt766 = 8;
        try {
            anInt767 = i;
            aClass44Array768 = new Node[i];
            for (int j = 0; j < i; j++) {
                Node class44 = aClass44Array768[j] = new Node();
                class44.previousNode = class44;
                class44.nextNode = class44;
            }
            if (byte0 != 124) {
                for (int k = 1; k > 0; k++) {
                }
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("10752, " + i + ", " + byte0 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public Node method380(long l) {
        Node class44 = aClass44Array768[(int) (l & anInt767 - 1)];
        for (Node class44_1 = class44.previousNode; class44_1 != class44; class44_1 = class44_1.previousNode) {
            if (class44_1.nodeId == l) {
                return class44_1;
            }
        }
        return null;
    }

    public void method381(boolean flag, Node class44, long l) {
        try {
            if (class44.nextNode != null) {
                class44.remove();
            }
            Node class44_1 = aClass44Array768[(int) (l & anInt767 - 1)];
            class44.nextNode = class44_1.nextNode;
            if (flag) {
                aBoolean764 = !aBoolean764;
            }
            class44.previousNode = class44_1;
            class44.nextNode.previousNode = class44;
            class44.previousNode.nextNode = class44;
            class44.nodeId = l;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("44360, " + flag + ", " + class44 + ", " + l + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }
}

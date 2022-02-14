package com.runescape.collection;

import com.runescape.util.SignLink;

public class LinkedList {

    public int anInt532;
    public boolean aBoolean533;
    public Node head;
    public Node current;

    public LinkedList(int i) {
        anInt532 = 9;
        aBoolean533 = true;
        head = new Node();
        try {
            head.previousNode = head;
            if (i >= 0) {
                for (int j = 1; j > 0; j++) {
                }
            }
            head.nextNode = head;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20960, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void pushBack(Node class44) {
        if (class44.nextNode != null) {
            class44.remove();
        }
        class44.nextNode = head.nextNode;
        class44.previousNode = head;
        class44.nextNode.previousNode = class44;
        class44.previousNode.nextNode = class44;
    }

    public void method257(Node class44, int i) {
        try {
            if (class44.nextNode != null) {
                class44.remove();
            }
            class44.nextNode = head;
            class44.previousNode = head.previousNode;
            class44.nextNode.previousNode = class44;
            class44.previousNode.nextNode = class44;
            if (i != -12925) {
                aBoolean533 = !aBoolean533;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("22708, " + class44 + ", " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public Node method258() {
        Node class44 = head.previousNode;
        if (class44 == head) {
            return null;
        } else {
            class44.remove();
            return class44;
        }
    }

    public Node peekFront() {
        Node class44 = head.previousNode;
        if (class44 == head) {
            current = null;
            return null;
        } else {
            current = class44.previousNode;
            return class44;
        }
    }

    public Node method260(int i) {
        try {
            Node class44 = head.nextNode;
            if (class44 == head) {
                current = null;
                return null;
            }
            current = class44.nextNode;
            if (i != 0) {
                aBoolean533 = !aBoolean533;
            }
            return class44;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("18269, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Node prev(boolean flag) {
        try {
            Node class44 = current;
            if (flag) {
                throw new NullPointerException();
            }
            if (class44 == head) {
                current = null;
                return null;
            } else {
                current = class44.previousNode;
                return class44;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("49472, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Node method262(int i) {
        try {
            Node class44 = current;
            if (i != -20683) {
                throw new NullPointerException();
            }
            if (class44 == head) {
                current = null;
                return null;
            } else {
                current = class44.nextNode;
                return class44;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("30725, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method263() {
        if (head.previousNode == head) {
            return;
        }
        do {
            Node class44 = head.previousNode;
            if (class44 == head) {
                return;
            }
            class44.remove();
        } while (true);
    }
}

package com.runescape.collection;

public class Node {

    public long nodeId;
    public Node previousNode;
    public Node nextNode;

    public Node() {
    }

    public void remove() {
        if (nextNode != null) {
            nextNode.previousNode = previousNode;
            previousNode.nextNode = nextNode;
            previousNode = null;
            nextNode = null;
        }
    }
}

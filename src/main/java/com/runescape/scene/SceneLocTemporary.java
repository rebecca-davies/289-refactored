package com.runescape.scene;

import com.runescape.collection.Node;

public class SceneLocTemporary extends Node {

    public int plane;
    public int locType;
    public int sceneTileX;
    public int sceneTileZ;
    public int previousId;
    public int id;
    public int previousType;
    public int id2;
    public int face2;
    public int type2;
    public int delayUntilSpawn;
    public int delayUntilRespawn;

    public SceneLocTemporary() {
        delayUntilRespawn = -1;
    }
}

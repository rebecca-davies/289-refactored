package com.runescape.util;

import com.runescape.Game;
import com.runescape.GameShell;

public class MouseCapturer implements Runnable {

    public Game aClient256;
    public boolean aBoolean257;
    public Object anObject258;
    public int coordinatesIndex;
    public int[] anIntArray260;
    public int[] anIntArray261;

    public MouseCapturer(int i, Game client1) {
        aBoolean257 = true;
        anObject258 = new Object();
        anIntArray260 = new int[500];
        anIntArray261 = new int[500];
        try {
            i = 31 / i;
            aClient256 = client1;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("34650, " + i + ", " + client1 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void run() {
        while (aBoolean257) {
            synchronized (anObject258) {
                if (coordinatesIndex < 500) {
                    anIntArray260[coordinatesIndex] = aClient256.anInt21;
                    anIntArray261[coordinatesIndex] = aClient256.anInt22;
                    coordinatesIndex++;
                }
            }
            try {
                Thread.sleep(50L);
            } catch (Exception _ex) {
            }
        }
    }
}

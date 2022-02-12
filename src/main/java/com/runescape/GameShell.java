package com.runescape;

import com.runescape.graphic.Image24;
import com.runescape.graphic.ProducingGraphicsBuffer;
import com.runescape.util.SignLink;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameShell extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener,
        FocusListener, WindowListener {

    public static boolean aBoolean35;
    public boolean aBoolean1;
    public int anInt2;
    public int anInt3;
    public int anInt4;
    public int anInt5;
    public int anInt6;
    public int anInt7;
    public long aLongArray8[];
    public int anInt9;
    public boolean aBoolean10;
    public int anInt11;
    public int anInt12;
    public Graphics graphics;
    public ProducingGraphicsBuffer aClass34_14;
    public Image24 aClass44_Sub3_Sub1_Sub2Array15[];
    public GameFrame aFrame_Sub1_16;
    public boolean aBoolean17;
    public boolean aBoolean18;
    public int anInt19;
    public int mouseButton;
    public int anInt21;
    public int anInt22;
    public int anInt23;
    public int anInt24;
    public int anInt25;
    public long aLong26;
    public int clickType;
    public int anInt28;
    public int anInt29;
    public long aLong30;
    public int anIntArray31[];
    public int anIntArray32[];
    public int anInt33;
    public int anInt34;

    public GameShell() {
        aBoolean1 = false;
        anInt2 = -128;
        anInt3 = 37395;
        anInt4 = -6002;
        anInt6 = 20;
        anInt7 = 1;
        aLongArray8 = new long[10];
        aBoolean10 = false;
        aClass44_Sub3_Sub1_Sub2Array15 = new Image24[6];
        aBoolean17 = true;
        aBoolean18 = true;
        anIntArray31 = new int[128];
        anIntArray32 = new int[128];
    }

    public void method1(int i, int j, int k) {
        try {
            anInt11 = j;
            anInt12 = i;
            aFrame_Sub1_16 = new GameFrame(anInt11, anInt12, this);
            graphics = method11(7).getGraphics();
            if (k != 0) {
                anInt4 = -480;
            }
            aClass34_14 = new ProducingGraphicsBuffer(method11(7), anInt11, anInt12, 2);
            method12(this, 1);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("84735, " + i + ", " + j + ", " + k + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method2(boolean flag, int i, int j) {
        try {
            anInt11 = i;
            if (!flag) {
                anInt3 = 4;
            }
            anInt12 = j;
            graphics = method11(7).getGraphics();
            aClass34_14 = new ProducingGraphicsBuffer(method11(7), anInt11, anInt12, 2);
            method12(this, 1);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("72806, " + flag + ", " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public void run() {
        method11(7).addMouseListener(this);
        method11(7).addMouseMotionListener(this);
        method11(7).addKeyListener(this);
        method11(7).addFocusListener(this);
        if (aFrame_Sub1_16 != null) {
            aFrame_Sub1_16.addWindowListener(this);
        }
        method13(false, 0, "Loading...");
        method6();
        int i = 0;
        int j = 256;
        int k = 1;
        int i1 = 0;
        int j1 = 0;
        for (int k1 = 0; k1 < 10; k1++) {
            aLongArray8[k1] = System.currentTimeMillis();
        }
        System.currentTimeMillis();
        while (anInt5 >= 0) {
            if (anInt5 > 0) {
                anInt5--;
                if (anInt5 == 0) {
                    method3(0);
                    return;
                }
            }
            int i2 = j;
            int j2 = k;
            j = 300;
            k = 1;
            long l1 = System.currentTimeMillis();
            if (aLongArray8[i] == 0L) {
                j = i2;
                k = j2;
            } else if (l1 > aLongArray8[i]) {
                j = (int) (2560 * anInt6 / (l1 - aLongArray8[i]));
            }
            if (j < 25) {
                j = 25;
            }
            if (j > 256) {
                j = 256;
                k = (int) (anInt6 - (l1 - aLongArray8[i]) / 10L);
            }
            if (k > anInt6) {
                k = anInt6;
            }
            aLongArray8[i] = l1;
            i = (i + 1) % 10;
            if (k > 1) {
                for (int k2 = 0; k2 < 10; k2++) {
                    if (aLongArray8[k2] != 0L) {
                        aLongArray8[k2] += k;
                    }
                }
            }
            if (k < anInt7) {
                k = anInt7;
            }
            try {
                Thread.sleep(k);
            } catch (InterruptedException _ex) {
                j1++;
            }
            for (; i1 < 256; i1 += j) {
                clickType = anInt23;
                anInt28 = anInt24;
                anInt29 = anInt25;
                aLong30 = aLong26;
                anInt23 = 0;
                method7(9);
                anInt33 = anInt34;
            }
            i1 &= 0xff;
            if (anInt6 > 0) {
                anInt9 = (1000 * j) / (anInt6 * 256);
            }
            method9((byte) 1);
            if (aBoolean10) {
                System.out.println("ntime:" + l1);
                for (int l2 = 0; l2 < 10; l2++) {
                    int i3 = ((i - l2 - 1) + 20) % 10;
                    System.out.println("otim" + i3 + ":" + aLongArray8[i3]);
                }
                System.out.println("fps:" + anInt9 + " ratio:" + j + " count:" + i1);
                System.out.println("del:" + k + " deltime:" + anInt6 + " mindel:" + anInt7);
                System.out.println("intex:" + j1 + " opos:" + i);
                aBoolean10 = false;
                j1 = 0;
            }
        }
        if (anInt5 == -1) {
            method3(0);
        }
    }

    public void method3(int i) {
        try {
            anInt5 = -2;
            method8(874);
            if (i != 0) {
                return;
            }
            if (aFrame_Sub1_16 != null) {
                try {
                    Thread.sleep(1000L);
                } catch (Exception _ex) {
                }
                try {
                    System.exit(0);
                    return;
                } catch (Throwable _ex) {
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("66676, " + i + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method4(int i, int j) {
        try {
            if (j <= 0) {
                return;
            } else {
                anInt6 = 1000 / i;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("19917, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public void start() {
        if (anInt5 >= 0) {
            anInt5 = 0;
        }
    }

    @Override
    public void stop() {
        if (anInt5 >= 0) {
            anInt5 = 4000 / anInt6;
        }
    }

    @Override
    public void destroy() {
        anInt5 = -1;
        try {
            Thread.sleep(5000L);
        } catch (Exception _ex) {
        }
        if (anInt5 == -1) {
            method3(0);
        }
    }

    @Override
    public void update(Graphics g) {
        if (graphics == null) {
            graphics = g;
        }
        aBoolean17 = true;
        method10(false);
    }

    @Override
    public void paint(Graphics g) {
        if (graphics == null) {
            graphics = g;
        }
        aBoolean17 = true;
        method10(false);
    }

    @Override
    public void mousePressed(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if (aFrame_Sub1_16 != null) {
            i -= 4;
            j -= 22;
        }
        anInt19 = 0;
        anInt24 = i;
        anInt25 = j;
        aLong26 = System.currentTimeMillis();
        if (mouseevent.isMetaDown()) {
            anInt23 = 2;
            mouseButton = 2;
            return;
        } else {
            anInt23 = 1;
            mouseButton = 1;
            return;
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseevent) {
        anInt19 = 0;
        mouseButton = 0;
    }

    @Override
    public void mouseClicked(MouseEvent mouseevent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseevent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseevent) {
        anInt19 = 0;
        anInt21 = -1;
        anInt22 = -1;
    }

    @Override
    public void mouseDragged(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if (aFrame_Sub1_16 != null) {
            i -= 4;
            j -= 22;
        }
        anInt19 = 0;
        anInt21 = i;
        anInt22 = j;
    }

    @Override
    public void mouseMoved(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if (aFrame_Sub1_16 != null) {
            i -= 4;
            j -= 22;
        }
        anInt19 = 0;
        anInt21 = i;
        anInt22 = j;
    }

    @Override
    public void keyPressed(KeyEvent keyevent) {
        anInt19 = 0;
        int i = keyevent.getKeyCode();
        int j = keyevent.getKeyChar();
        if (j < 30) {
            j = 0;
        }
        if (i == 37) {
            j = 1;
        }
        if (i == 39) {
            j = 2;
        }
        if (i == 38) {
            j = 3;
        }
        if (i == 40) {
            j = 4;
        }
        if (i == 17) {
            j = 5;
        }
        if (i == 8) {
            j = 8;
        }
        if (i == 127) {
            j = 8;
        }
        if (i == 9) {
            j = 9;
        }
        if (i == 10) {
            j = 10;
        }
        if (i >= 112 && i <= 123) {
            j = (1008 + i) - 112;
        }
        if (i == 36) {
            j = 1000;
        }
        if (i == 35) {
            j = 1001;
        }
        if (i == 33) {
            j = 1002;
        }
        if (i == 34) {
            j = 1003;
        }
        if (j > 0 && j < 128) {
            anIntArray31[j] = 1;
        }
        if (j > 4) {
            anIntArray32[anInt34] = j;
            anInt34 = anInt34 + 1 & 0x7f;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyevent) {
        anInt19 = 0;
        int i = keyevent.getKeyCode();
        char c = keyevent.getKeyChar();
        if (c < '\036') {
            c = '\0';
        }
        if (i == 37) {
            c = '\001';
        }
        if (i == 39) {
            c = '\002';
        }
        if (i == 38) {
            c = '\003';
        }
        if (i == 40) {
            c = '\004';
        }
        if (i == 17) {
            c = '\005';
        }
        if (i == 8) {
            c = '\b';
        }
        if (i == 127) {
            c = '\b';
        }
        if (i == 9) {
            c = '\t';
        }
        if (i == 10) {
            c = '\n';
        }
        if (c > 0 && c < '\200') {
            anIntArray31[c] = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyevent) {
    }

    public int method5(int i) {
        try {
            int j = -1;
            if (i >= 0) {
                aBoolean1 = !aBoolean1;
            }
            if (anInt34 != anInt33) {
                j = anIntArray32[anInt33];
                anInt33 = anInt33 + 1 & 0x7f;
            }
            return j;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("9078, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public void focusGained(FocusEvent focusevent) {
        aBoolean18 = true;
        aBoolean17 = true;
        method10(false);
    }

    @Override
    public void focusLost(FocusEvent focusevent) {
        aBoolean18 = false;
        for (int i = 0; i < 128; i++) {
            anIntArray31[i] = 0;
        }
    }

    @Override
    public void windowActivated(WindowEvent windowevent) {
    }

    @Override
    public void windowClosed(WindowEvent windowevent) {
    }

    @Override
    public void windowClosing(WindowEvent windowevent) {
        destroy();
    }

    @Override
    public void windowDeactivated(WindowEvent windowevent) {
    }

    @Override
    public void windowDeiconified(WindowEvent windowevent) {
    }

    @Override
    public void windowIconified(WindowEvent windowevent) {
    }

    @Override
    public void windowOpened(WindowEvent windowevent) {
    }

    public void method6() {
    }

    public void method7(int i) {
        try {
            if (i != 9) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("72813, " + i + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method8(int i) {
        try {
            i = 38 / i;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("23302, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method9(byte byte0) {
        try {
            if (byte0 != 1) {
                aBoolean1 = !aBoolean1;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("64489, " + byte0 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method10(boolean flag) {
        try {
            if (flag) {
                anInt3 = 244;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("4586, " + flag + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public Component method11(int i) {
        try {
            if (i != 7) {
                throw new NullPointerException();
            }
            if (aFrame_Sub1_16 != null) {
                return aFrame_Sub1_16;
            } else {
                return this;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96176, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method12(Runnable runnable, int i) {
        Thread thread = new Thread(runnable);
        thread.start();
        thread.setPriority(i);
    }

    public void method13(boolean flag, int i, String s) {
        try {
            while (graphics == null) {
                graphics = method11(7).getGraphics();
                try {
                    method11(7).repaint();
                } catch (Exception _ex) {
                }
                try {
                    Thread.sleep(1000L);
                } catch (Exception _ex) {
                }
            }
            Font font = new Font("Helvetica", 1, 13);
            FontMetrics fontmetrics = method11(7).getFontMetrics(font);
            Font font1 = new Font("Helvetica", 0, 13);
            method11(7).getFontMetrics(font1);
            if (aBoolean17) {
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, anInt11, anInt12);
                aBoolean17 = false;
            }
            Color color = new Color(140, 17, 17);
            int j = anInt12 / 2 - 18;
            graphics.setColor(color);
            graphics.drawRect(anInt11 / 2 - 152, j, 304, 34);
            graphics.fillRect(anInt11 / 2 - 150, j + 2, i * 3, 30);
            graphics.setColor(Color.black);
            graphics.fillRect((anInt11 / 2 - 150) + i * 3, j + 2, 300 - i * 3, 30);
            graphics.setFont(font);
            graphics.setColor(Color.white);
            graphics.drawString(s, (anInt11 - fontmetrics.stringWidth(s)) / 2, j + 22);
            if (flag) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("88163, " + flag + ", " + i + ", " + s + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }
}

package com.runescape;

import com.runescape.graphic.Image24;
import com.runescape.graphic.DrawArea;
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
    public int state;
    public int deltaTime;
    public int mindel;
    public long[] otim;
    public int fps;
    public boolean debug;
    public int width;
    public int height;
    public Graphics graphics;
    public DrawArea aClass34_14;
    public Image24[] aClass44_Sub3_Sub1_Sub2Array15;
    public GameFrame frame;
    public boolean refresh;
    public boolean hasFocus;
    public int idleCycles;
    public int mouseButton;
    public int mouseX;
    public int mouseY;
    public int lastMouseclickType;
    public int lastMouseClickX;
    public int lastMouseClickY;
    public long lastMouseClickTime;
    public int mouseClickType;
    public int mouseClickX;
    public int mouseClickY;
    public long mouseClickTime;
    public int[] actionKey;
    public int[] keyQueue;
    public int keyQueueReadPos;
    public int keyQueueWritePos;

    public GameShell() {
        aBoolean1 = false;
        anInt2 = -128;
        anInt3 = 37395;
        anInt4 = -6002;
        deltaTime = 20;
        mindel = 1;
        otim = new long[10];
        debug = false;
        aClass44_Sub3_Sub1_Sub2Array15 = new Image24[6];
        refresh = true;
        hasFocus = true;
        actionKey = new int[128];
        keyQueue = new int[128];
    }

    public void method1(int i, int j, int k) {
        try {
            width = j;
            height = i;
            frame = new GameFrame(width, height, this);
            graphics = getFrame(7).getGraphics();
            if (k != 0) {
                anInt4 = -480;
            }
            aClass34_14 = new DrawArea(width, height);
            startThread(this, 1);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("84735, " + i + ", " + j + ", " + k + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method2(boolean flag, int i, int j) {
        try {
            width = i;
            if (!flag) {
                anInt3 = 4;
            }
            height = j;
            graphics = this.getGraphics();
            aClass34_14 = new DrawArea(width, height);
            startThread(this, 1);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("72806, " + flag + ", " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void run() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.addFocusListener(this);
        if (frame != null) {
            frame.addWindowListener(this);
        }
        showProgress(0, "Loading...");
        startUp();
        int opos = 0;
        int ratio = 256;
        int delta = 1;
        int count = 0;
        int intex = 0;
        for (int i = 0; i < 10; i++) {
            otim[i] = System.currentTimeMillis();
        }
        while (state >= 0) {
            if (state > 0) {
                state--;
                if (state == 0) {
                    shutdown(0);
                    return;
                }
            }
            int lastRatio = ratio;
            int lastDelta = delta;
            ratio = 300;
            delta = 1;
            long ntime = System.currentTimeMillis();
            if (otim[opos] == 0L) {
                ratio = lastRatio;
                delta = lastDelta;
            } else if (ntime > otim[opos]) {
                ratio = (int) (2560 * deltaTime / (ntime - otim[opos]));
            }
            if (ratio < 25) {
                ratio = 25;
            }
            if (ratio > 256) {
                ratio = 256;
                delta = (int) (deltaTime - (ntime - otim[opos]) / 10L);
            }
            if (delta > deltaTime) {
                delta = deltaTime;
            }
            otim[opos] = ntime;
            opos = (opos + 1) % 10;
            if (delta > 1) {
                for (int i = 0; i < 10; i++) {
                    if (otim[i] != 0L) {
                        otim[i] += delta;
                    }
                }
            }
            if (delta < mindel) {
                delta = mindel;
            }
            try {
                Thread.sleep(delta);
            } catch (InterruptedException _ex) {
                intex++;
            }
            for (; count < 256; count += ratio) {
                mouseClickType = lastMouseclickType;
                mouseClickX = lastMouseClickX;
                mouseClickY = lastMouseClickY;
                mouseClickTime = lastMouseClickTime;
                lastMouseclickType = 0;
                update(9);
                keyQueueReadPos = keyQueueWritePos;
            }
            count &= 0xff;
            if (deltaTime > 0) {
                fps = (1000 * ratio) / (deltaTime * 256);
            }
            draw((byte) 1);
            if (debug) {
                System.out.println("ntime:" + ntime);
                for (int l2 = 0; l2 < 10; l2++) {
                    int i3 = ((opos - l2 - 1) + 20) % 10;
                    System.out.println("otim" + i3 + ":" + otim[i3]);
                }
                System.out.println("fps:" + fps + " ratio:" + ratio + " count:" + count);
                System.out.println("del:" + delta + " deltime:" + deltaTime + " mindel:" + mindel);
                System.out.println("intex:" + intex + " opos:" + opos);
                debug = false;
                intex = 0;
            }
        }
        if (state == -1) {
            shutdown(0);
        }
    }

    public void shutdown(int i) {
        try {
            state = -2;
            unload(874);
            if (i != 0) {
                return;
            }
            if (frame != null) {
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
            SignLink.reporterror("66676, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void setFramerate(int fps, int j) {
        try {
                deltaTime = 1000 / fps;
                return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("19917, " + fps + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void start() {
        if (state >= 0) {
            state = 0;
        }
    }

    @Override
    public void stop() {
        if (state >= 0) {
            state = 4000 / deltaTime;
        }
    }

    @Override
    public void destroy() {
        state = -1;
        try {
            Thread.sleep(5000L);
        } catch (Exception _ex) {
        }
        if (state == -1) {
            shutdown(0);
        }
    }

    @Override
    public void update(Graphics g) {
        if (graphics == null) {
            graphics = g;
        }
        refresh = true;
        refresh(false);
    }

    @Override
    public void paint(Graphics g) {
        if (graphics == null) {
            graphics = g;
        }
        refresh = true;
        refresh(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (frame != null) {
            x -= 4;
            y -= 22;
        }
        idleCycles = 0;
        lastMouseClickX = x;
        lastMouseClickY = y;
        lastMouseClickTime = System.currentTimeMillis();
        if (e.isMetaDown()) {
            lastMouseclickType = 2;
            mouseButton = 2;
            return;
        } else {
            lastMouseclickType = 1;
            mouseButton = 1;
            return;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        idleCycles = 0;
        mouseButton = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        idleCycles = 0;
        mouseX = -1;
        mouseY = -1;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (frame != null) {
            x -= 4;
            y -= 22;
        }
        idleCycles = 0;
        mouseX = x;
        mouseY = y;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (frame != null) {
            x -= 4;
            y -= 22;
        }
        idleCycles = 0;
        mouseX = x;
        mouseY = y;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        idleCycles = 0;
        int code = e.getKeyCode();
        int value = e.getKeyChar();
        if (value < 30) {
            value = 0;
        }
        if (code == 37) {
            value = 1;
        }
        if (code == 39) {
            value = 2;
        }
        if (code == 38) {
            value = 3;
        }
        if (code == 40) {
            value = 4;
        }
        if (code == 17) {
            value = 5;
        }
        if (code == 8) {
            value = 8;
        }
        if (code == 127) {
            value = 8;
        }
        if (code == 9) {
            value = 9;
        }
        if (code == 10) {
            value = 10;
        }
        if (code >= 112 && code <= 123) {
            value = (1008 + code) - 112;
        }
        if (code == 36) {
            value = 1000;
        }
        if (code == 35) {
            value = 1001;
        }
        if (code == 33) {
            value = 1002;
        }
        if (code == 34) {
            value = 1003;
        }
        if (value > 0 && value < 128) {
            actionKey[value] = 1;
        }
        if (value > 4) {
            keyQueue[keyQueueWritePos] = value;
            keyQueueWritePos = keyQueueWritePos + 1 & 0x7f;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        idleCycles = 0;
        int code = e.getKeyCode();
        char value = e.getKeyChar();
        if (value < '\036') {
            value = '\0';
        }
        if (code == 37) {
            value = '\001';
        }
        if (code == 39) {
            value = '\002';
        }
        if (code == 38) {
            value = '\003';
        }
        if (code == 40) {
            value = '\004';
        }
        if (code == 17) {
            value = '\005';
        }
        if (code == 8) {
            value = '\b';
        }
        if (code == 127) {
            value = '\b';
        }
        if (code == 9) {
            value = '\t';
        }
        if (code == 10) {
            value = '\n';
        }
        if (value > 0 && value < '\200') {
            actionKey[value] = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public int pollKey(int i) {
        try {
            int key = -1;
            if (keyQueueWritePos != keyQueueReadPos) {
                key = keyQueue[keyQueueReadPos];
                keyQueueReadPos = keyQueueReadPos + 1 & 0x7f;
            }
            return key;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("9078, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void focusGained(FocusEvent e) {
        hasFocus = true;
        refresh = true;
        refresh(false);
    }

    @Override
    public void focusLost(FocusEvent e) {
        hasFocus = false;
        for (int i = 0; i < 128; i++) {
            actionKey[i] = 0;
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

    public void startUp() {
    }

    public void update(int i) {
        try {
            if (i != 9) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("72813, " + i + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void unload(int i) {
        try {
            i = 38 / i;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("23302, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void draw(byte byte0) {
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

    public void refresh(boolean flag) {
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

    public Component getFrame(int i) {
        try {
            if (i != 7) {
                throw new NullPointerException();
            }
            if (frame != null) {
                return frame;
            } else {
                return this;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96176, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void startThread(Runnable runnable, int i) {
        Thread thread = new Thread(runnable);
        thread.start();
        thread.setPriority(i);
    }

    public void showProgress(int i, String message) {
        try {
            while (graphics == null) {
                graphics = getFrame(7).getGraphics();
                try {
                    getFrame(7).repaint();
                } catch (Exception _ex) {
                }
                try {
                    Thread.sleep(1000L);
                } catch (Exception _ex) {
                }
            }
            Font helvetica = new Font("Helvetica", 1, 13);
            FontMetrics metrics = getFrame(7).getFontMetrics(helvetica);
            if (refresh) {
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, width, height);
                refresh = false;
            }
            Color color = new Color(140, 17, 17);
            int y = height / 2 - 18;
            graphics.setColor(color);
            graphics.drawRect(width / 2 - 152, y, 304, 34);
            graphics.fillRect(width / 2 - 150, y + 2, i * 3, 30);
            graphics.setColor(Color.black);
            graphics.fillRect((width / 2 - 150) + i * 3, y + 2, 300 - i * 3, 30);
            graphics.setFont(helvetica);
            graphics.setColor(Color.white);
            graphics.drawString(message, (width - metrics.stringWidth(message)) / 2, y + 22);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("88163, " + i + ", " + message + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }
}

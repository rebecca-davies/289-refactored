package com.runescape.net;

import com.runescape.GameShell;
import com.runescape.util.SignLink;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection implements Runnable {

    public boolean aBoolean192;
    public InputStream anInputStream193;
    public OutputStream anOutputStream194;
    public Socket aSocket195;
    public boolean aBoolean196;
    public GameShell anApplet_Sub1_197;
    public byte aByteArray198[];
    public int anInt199;
    public int anInt200;
    public boolean aBoolean201;
    public boolean aBoolean202;

    public Connection(Socket socket, int i, GameShell applet_sub1) throws IOException {
        aBoolean192 = false;
        aBoolean196 = false;
        aBoolean201 = false;
        aBoolean202 = false;
        try {
            anApplet_Sub1_197 = applet_sub1;
            aSocket195 = socket;
            aSocket195.setSoTimeout(30000);
            aSocket195.setTcpNoDelay(true);
            anInputStream193 = aSocket195.getInputStream();
            anOutputStream194 = aSocket195.getOutputStream();
            if (i != 32596) {
                aBoolean192 = !aBoolean192;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("498, " + socket + ", " + i + ", " + applet_sub1 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method191() {
        aBoolean196 = true;
        try {
            if (anInputStream193 != null) {
                anInputStream193.close();
            }
            if (anOutputStream194 != null) {
                anOutputStream194.close();
            }
            if (aSocket195 != null) {
                aSocket195.close();
            }
        } catch (IOException _ex) {
            System.out.println("Error closing stream");
        }
        aBoolean201 = false;
        synchronized (this) {
            notify();
        }
        aByteArray198 = null;
    }

    public int method192() throws IOException {
        if (aBoolean196) {
            return 0;
        } else {
            return anInputStream193.read();
        }
    }

    public int method193() throws IOException {
        if (aBoolean196) {
            return 0;
        } else {
            return anInputStream193.available();
        }
    }

    public void method194(byte abyte0[], int i, int j) throws IOException {
        if (aBoolean196) {
            return;
        }
        int k;
        for (; j > 0; j -= k) {
            k = anInputStream193.read(abyte0, i, j);
            if (k <= 0) {
                throw new IOException("EOF");
            }
            i += k;
        }
    }

    public void method195(int i, byte abyte0[], int j, int k) throws IOException {
        try {
            if (j < 2 || j > 2) {
                return;
            }
            if (aBoolean196) {
                return;
            }
            if (aBoolean202) {
                aBoolean202 = false;
                throw new IOException("Error in writer thread");
            }
            if (aByteArray198 == null) {
                aByteArray198 = new byte[5000];
            }
            synchronized (this) {
                for (int l = 0; l < k; l++) {
                    aByteArray198[anInt200] = abyte0[l + i];
                    anInt200 = (anInt200 + 1) % 5000;
                    if (anInt200 == (anInt199 + 4900) % 5000) {
                        throw new IOException("buffer overflow");
                    }
                }
                if (!aBoolean201) {
                    aBoolean201 = true;
                    anApplet_Sub1_197.method12(this, 3);
                }
                notify();
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("22916, " + i + ", " + abyte0 + ", " + j + ", " + k + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public void run() {
        while (aBoolean201) {
            int i;
            int j;
            synchronized (this) {
                if (anInt200 == anInt199) {
                    try {
                        wait();
                    } catch (InterruptedException _ex) {
                    }
                }
                if (!aBoolean201) {
                    return;
                }
                j = anInt199;
                if (anInt200 >= anInt199) {
                    i = anInt200 - anInt199;
                } else {
                    i = 5000 - anInt199;
                }
            }
            if (i > 0) {
                try {
                    anOutputStream194.write(aByteArray198, j, i);
                } catch (IOException _ex) {
                    aBoolean202 = true;
                }
                anInt199 = (anInt199 + i) % 5000;
                try {
                    if (anInt200 == anInt199) {
                        anOutputStream194.flush();
                    }
                } catch (IOException _ex) {
                    aBoolean202 = true;
                }
            }
        }
    }

    public void method196(byte byte0) {
        try {
            System.out.println("dummy:" + aBoolean196);
            System.out.println("tcycl:" + anInt199);
            System.out.println("tnum:" + anInt200);
            if (byte0 != -11) {
                return;
            }
            System.out.println("writer:" + aBoolean201);
            System.out.println("ioerror:" + aBoolean202);
            try {
                System.out.println("available:" + method193());
                return;
            } catch (IOException _ex) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("6333, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}

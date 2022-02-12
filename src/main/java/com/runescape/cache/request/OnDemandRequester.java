package com.runescape.cache.request;

import com.runescape.Game;
import com.runescape.cache.FileArchive;
import com.runescape.collection.LinkedList;
import com.runescape.collection.Queue;
import com.runescape.net.Buffer;
import com.runescape.util.SignLink;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;

public class OnDemandRequester extends Requester implements Runnable {

    public boolean aBoolean1280;
    public int anInt1281;
    public int anInt1282;
    public byte aByte1283;
    public int anIntArrayArray1284[][];
    public int anIntArrayArray1285[][];
    public byte aByteArrayArray1286[][];
    public int anInt1287;
    public byte aByteArray1288[];
    public int anIntArray1289[];
    public int anIntArray1290[];
    public int anIntArray1291[];
    public int anIntArray1292[];
    public int anIntArray1293[];
    public int anIntArray1294[];
    public boolean aBoolean1295;
    public Game aClient1296;
    public CRC32 aCRC32_1297;
    public boolean aBoolean1298;
    public int anInt1299;
    public int anInt1300;
    public Queue aClass31_1301;
    public LinkedList aClass28_1302;
    public LinkedList aClass28_1303;
    public LinkedList aClass28_1304;
    public LinkedList aClass28_1305;
    public LinkedList aClass28_1306;
    public String aString1307;
    public int anInt1308;
    public int anInt1309;
    public Socket aSocket1310;
    public InputStream anInputStream1311;
    public OutputStream anOutputStream1312;
    public int anInt1313;
    public OnDemandNode aClass44_Sub3_Sub3_1314;
    public int anInt1315;
    public int anInt1316;
    public byte aByteArray1317[];
    public byte aByteArray1318[];
    public int anInt1319;
    public int anInt1320;
    public long aLong1321;
    public int anInt1322;

    public OnDemandRequester() {
        aBoolean1280 = false;
        anInt1281 = -555;
        aByte1283 = 64;
        anIntArrayArray1284 = new int[4][];
        anIntArrayArray1285 = new int[4][];
        aByteArrayArray1286 = new byte[4][];
        aBoolean1295 = true;
        aCRC32_1297 = new CRC32();
        aBoolean1298 = false;
        aClass31_1301 = new Queue(9);
        aClass28_1302 = new LinkedList(-199);
        aClass28_1303 = new LinkedList(-199);
        aClass28_1304 = new LinkedList(-199);
        aClass28_1305 = new LinkedList(-199);
        aClass28_1306 = new LinkedList(-199);
        aString1307 = "";
        aByteArray1317 = new byte[500];
        aByteArray1318 = new byte[65000];
    }

    public void method383(FileArchive class47, Game client1) {
        String as[] = {"model_version", "anim_version", "midi_version", "map_version"};
        for (int i = 0; i < 4; i++) {
            byte abyte0[] = class47.method549(as[i], null);
            int j = abyte0.length / 2;
            Buffer class44_sub3_sub2 = new Buffer(abyte0);
            anIntArrayArray1284[i] = new int[j];
            aByteArrayArray1286[i] = new byte[j];
            for (int l = 0; l < j; l++) {
                anIntArrayArray1284[i][l] = class44_sub3_sub2.readUnsignedShort();
            }
        }
        String as1[] = {"model_crc", "anim_crc", "midi_crc", "map_crc"};
        for (int k = 0; k < 4; k++) {
            byte abyte1[] = class47.method549(as1[k], null);
            int i1 = abyte1.length / 4;
            Buffer class44_sub3_sub2_1 = new Buffer(abyte1);
            anIntArrayArray1285[k] = new int[i1];
            for (int l1 = 0; l1 < i1; l1++) {
                anIntArrayArray1285[k][l1] = class44_sub3_sub2_1.readInt();
            }
        }
        byte abyte2[] = class47.method549("model_index", null);
        int j1 = anIntArrayArray1284[0].length;
        aByteArray1288 = new byte[j1];
        for (int k1 = 0; k1 < j1; k1++) {
            if (k1 < abyte2.length) {
                aByteArray1288[k1] = abyte2[k1];
            } else {
                aByteArray1288[k1] = 0;
            }
        }
        abyte2 = class47.method549("map_index", null);
        Buffer class44_sub3_sub2_2 = new Buffer(abyte2);
        j1 = abyte2.length / 7;
        anIntArray1289 = new int[j1];
        anIntArray1290 = new int[j1];
        anIntArray1291 = new int[j1];
        anIntArray1292 = new int[j1];
        for (int i2 = 0; i2 < j1; i2++) {
            anIntArray1289[i2] = class44_sub3_sub2_2.readUnsignedShort();
            anIntArray1290[i2] = class44_sub3_sub2_2.readUnsignedShort();
            anIntArray1291[i2] = class44_sub3_sub2_2.readUnsignedShort();
            anIntArray1292[i2] = class44_sub3_sub2_2.readUnsignedByte();
        }
        abyte2 = class47.method549("anim_index", null);
        class44_sub3_sub2_2 = new Buffer(abyte2);
        j1 = abyte2.length / 2;
        anIntArray1293 = new int[j1];
        for (int j2 = 0; j2 < j1; j2++) {
            anIntArray1293[j2] = class44_sub3_sub2_2.readUnsignedShort();
        }
        abyte2 = class47.method549("midi_index", null);
        class44_sub3_sub2_2 = new Buffer(abyte2);
        j1 = abyte2.length;
        anIntArray1294 = new int[j1];
        for (int k2 = 0; k2 < j1; k2++) {
            anIntArray1294[k2] = class44_sub3_sub2_2.readUnsignedByte();
        }
        aClient1296 = client1;
        aBoolean1295 = true;
        aClient1296.method12(this, 2);
    }

    public void method384() {
        aBoolean1295 = false;
    }

    public int method385(int i, byte byte0) {
        try {
            if (byte0 == 7) {
                byte0 = 0;
            } else {
                return 1;
            }
            return anIntArrayArray1284[i].length;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("37225, " + i + ", " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int method386(int i) {
        try {
            if (i != 7) {
                return 1;
            } else {
                return anIntArray1293.length;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("62481, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int getMapFile(int i, int j, int k, int l) {
        try {
            int i1 = (k << 8) + i;
            for (int j1 = 0; j1 < anIntArray1289.length; j1++) {
                if (anIntArray1289[j1] == i1) {
                    if (l == 0) {
                        return anIntArray1290[j1];
                    } else {
                        return anIntArray1291[j1];
                    }
                }
            }
            if (j >= 0) {
                anInt1282 = -467;
            }
            return -1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("24222, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method388(boolean flag, boolean flag1) {
        try {
            int i = anIntArray1289.length;
            if (flag) {
                aBoolean1280 = !aBoolean1280;
            }
            for (int j = 0; j < i; j++) {
                if (flag1 || anIntArray1292[j] != 0) {
                    method395(7, 3, (byte) 2, anIntArray1291[j]);
                    method395(7, 3, (byte) 2, anIntArray1290[j]);
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("78980, " + flag + ", " + flag1 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public boolean method389(int i, int j) {
        try {
            for (int k = 0; k < anIntArray1289.length; k++) {
                if (anIntArray1291[k] == i) {
                    return true;
                }
            }
            if (j != 0) {
                for (int l = 1; l > 0; l++) {
                }
            }
            return false;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("68583, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public int method390(int i, int j) {
        try {
            while (j >= 0) {
                anInt1281 = 270;
            }
            return aByteArray1288[i] & 0xff;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("30503, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public boolean method391(int i, int j) {
        try {
            j = 93 / j;
            return anIntArray1294[i] == 1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("97829, " + i + ", " + j + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public void method382(int i) {
        request(0, i);
    }

    public void request(int i, int j) {
        if (i < 0 || i > anIntArrayArray1284.length || j < 0 || j > anIntArrayArray1284[i].length) {
            return;
        }
        if (anIntArrayArray1284[i][j] == 0) {
            return;
        }
        synchronized (aClass31_1301) {
            for (OnDemandNode class44_sub3_sub3 = (OnDemandNode) aClass31_1301.method266(); class44_sub3_sub3 != null; class44_sub3_sub3 = (OnDemandNode) aClass31_1301
                    .method267(false)) {
                if (class44_sub3_sub3.anInt1405 == i && class44_sub3_sub3.anInt1406 == j) {
                    return;
                }
            }
            OnDemandNode class44_sub3_sub3_1 = new OnDemandNode();
            class44_sub3_sub3_1.anInt1405 = i;
            class44_sub3_sub3_1.anInt1406 = j;
            class44_sub3_sub3_1.aBoolean1409 = true;
            synchronized (aClass28_1302) {
                aClass28_1302.method256(class44_sub3_sub3_1);
            }
            aClass31_1301.method264(class44_sub3_sub3_1);
        }
    }

    public int method393() {
        synchronized (aClass31_1301) {
            int i = aClass31_1301.method268();
            return i;
        }
    }

    public OnDemandNode method394() {
        OnDemandNode class44_sub3_sub3;
        synchronized (aClass28_1305) {
            class44_sub3_sub3 = (OnDemandNode) aClass28_1305.method258();
        }
        if (class44_sub3_sub3 == null) {
            return null;
        }
        synchronized (aClass31_1301) {
            class44_sub3_sub3.method405();
        }
        if (class44_sub3_sub3.aByteArray1407 == null) {
            return class44_sub3_sub3;
        }
        int i = 0;
        try {
            GZIPInputStream gzipinputstream = new GZIPInputStream(new ByteArrayInputStream(
                    class44_sub3_sub3.aByteArray1407));
            do {
                if (i == aByteArray1318.length) {
                    throw new RuntimeException("buffer overflow!");
                }
                int k = gzipinputstream.read(aByteArray1318, i, aByteArray1318.length - i);
                if (k == -1) {
                    break;
                }
                i += k;
            } while (true);
        } catch (IOException _ex) {
            throw new RuntimeException("error unzipping");
        }
        class44_sub3_sub3.aByteArray1407 = new byte[i];
        for (int j = 0; j < i; j++) {
            class44_sub3_sub3.aByteArray1407[j] = aByteArray1318[j];
        }
        return class44_sub3_sub3;
    }

    public void method395(int i, int j, byte byte0, int k) {
        try {
            if (aClient1296.aClass45Array1208[0] == null) {
                return;
            }
            if (anIntArrayArray1284[j][k] == 0) {
                return;
            }
            byte abyte0[] = aClient1296.aClass45Array1208[j + 1].method541(false, k);
            if (method402(abyte0, anIntArrayArray1284[j][k], (byte) 64, anIntArrayArray1285[j][k])) {
                return;
            }
            aByteArrayArray1286[j][k] = byte0;
            if (i < 7 || i > 7) {
                return;
            }
            if (byte0 > anInt1287) {
                anInt1287 = byte0;
            }
            anInt1309++;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("42758, " + i + ", " + j + ", " + byte0 + ", " + k + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method396(int i) {
        try {
            if (i >= 0) {
                return;
            }
            synchronized (aClass28_1306) {
                aClass28_1306.method263();
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("65651, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method397(int i, int j, byte byte0) {
        try {
            if (aClient1296.aClass45Array1208[0] == null) {
                return;
            }
            if (anIntArrayArray1284[j][i] == 0) {
                return;
            }
            if (aByteArrayArray1286[j][i] == 0) {
                return;
            }
            if (anInt1287 == 0) {
                return;
            }
            OnDemandNode class44_sub3_sub3 = new OnDemandNode();
            class44_sub3_sub3.anInt1405 = j;
            class44_sub3_sub3.anInt1406 = i;
            class44_sub3_sub3.aBoolean1409 = false;
            if (byte0 != 6) {
                return;
            }
            synchronized (aClass28_1306) {
                aClass28_1306.method256(class44_sub3_sub3);
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("69676, " + i + ", " + j + ", " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    @Override
    public void run() {
        try {
            while (aBoolean1295) {
                anInt1322++;
                int i = 20;
                if (anInt1287 == 0 && aClient1296.aClass45Array1208[0] != null) {
                    i = 50;
                }
                try {
                    Thread.sleep(i);
                } catch (Exception _ex) {
                }
                aBoolean1298 = true;
                for (int j = 0; j < 100; j++) {
                    if (!aBoolean1298) {
                        break;
                    }
                    aBoolean1298 = false;
                    method398((byte) -101);
                    method399((byte) -3);
                    if (anInt1299 == 0 && j >= 5) {
                        break;
                    }
                    method400(0);
                    if (anInputStream1311 != null) {
                        method401(200);
                    }
                }
                boolean flag = false;
                for (OnDemandNode class44_sub3_sub3 = (OnDemandNode) aClass28_1304.peekFront(); class44_sub3_sub3 != null; class44_sub3_sub3 = (OnDemandNode) aClass28_1304
                        .prev(false)) {
                    if (class44_sub3_sub3.aBoolean1409) {
                        flag = true;
                        class44_sub3_sub3.anInt1408++;
                        if (class44_sub3_sub3.anInt1408 > 50) {
                            class44_sub3_sub3.anInt1408 = 0;
                            method403(class44_sub3_sub3, 409);
                        }
                    }
                }
                if (!flag) {
                    for (OnDemandNode class44_sub3_sub3_1 = (OnDemandNode) aClass28_1304.peekFront(); class44_sub3_sub3_1 != null; class44_sub3_sub3_1 = (OnDemandNode) aClass28_1304
                            .prev(false)) {
                        flag = true;
                        class44_sub3_sub3_1.anInt1408++;
                        if (class44_sub3_sub3_1.anInt1408 > 50) {
                            class44_sub3_sub3_1.anInt1408 = 0;
                            method403(class44_sub3_sub3_1, 409);
                        }
                    }
                }
                if (flag) {
                    anInt1319++;
                    if (anInt1319 > 750) {
                        try {
                            aSocket1310.close();
                        } catch (Exception _ex) {
                        }
                        aSocket1310 = null;
                        anInputStream1311 = null;
                        anOutputStream1312 = null;
                        anInt1316 = 0;
                    }
                } else {
                    anInt1319 = 0;
                    aString1307 = "";
                }
                if (aClient1296.aBoolean863 && aSocket1310 != null && anOutputStream1312 != null
                        && (anInt1287 > 0 || aClient1296.aClass45Array1208[0] == null)) {
                    anInt1320++;
                    if (anInt1320 > 500) {
                        anInt1320 = 0;
                        aByteArray1317[0] = 0;
                        aByteArray1317[1] = 0;
                        aByteArray1317[2] = 0;
                        aByteArray1317[3] = 10;
                        try {
                            anOutputStream1312.write(aByteArray1317, 0, 4);
                        } catch (IOException _ex) {
                            anInt1319 = 5000;
                        }
                    }
                }
            }
            return;
        } catch (Exception exception) {
            SignLink.reporterror("od_ex " + exception.getMessage());
        }
    }

    public void method398(byte byte0) {
        try {
            OnDemandNode class44_sub3_sub3;
            synchronized (aClass28_1302) {
                class44_sub3_sub3 = (OnDemandNode) aClass28_1302.method258();
            }
            if (byte0 != -101) {
                return;
            }
            while (class44_sub3_sub3 != null) {
                aBoolean1298 = true;
                byte abyte0[] = null;
                if (aClient1296.aClass45Array1208[0] != null) {
                    abyte0 = aClient1296.aClass45Array1208[class44_sub3_sub3.anInt1405 + 1].method541(false,
                            class44_sub3_sub3.anInt1406);
                }
                if (!method402(abyte0, anIntArrayArray1284[class44_sub3_sub3.anInt1405][class44_sub3_sub3.anInt1406],
                        (byte) 64, anIntArrayArray1285[class44_sub3_sub3.anInt1405][class44_sub3_sub3.anInt1406])) {
                    abyte0 = null;
                }
                synchronized (aClass28_1302) {
                    if (abyte0 == null) {
                        aClass28_1303.method256(class44_sub3_sub3);
                    } else {
                        class44_sub3_sub3.aByteArray1407 = abyte0;
                        synchronized (aClass28_1305) {
                            aClass28_1305.method256(class44_sub3_sub3);
                        }
                    }
                    class44_sub3_sub3 = (OnDemandNode) aClass28_1302.method258();
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("28575, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method399(byte byte0) {
        try {
            anInt1299 = 0;
            anInt1300 = 0;
            if (byte0 != -3) {
                anInt1282 = -238;
            }
            for (OnDemandNode class44_sub3_sub3 = (OnDemandNode) aClass28_1304.peekFront(); class44_sub3_sub3 != null; class44_sub3_sub3 = (OnDemandNode) aClass28_1304
                    .prev(false)) {
                if (class44_sub3_sub3.aBoolean1409) {
                    anInt1299++;
                } else {
                    anInt1300++;
                }
            }
            while (anInt1299 < 10) {
                OnDemandNode class44_sub3_sub3_1 = (OnDemandNode) aClass28_1303.method258();
                if (class44_sub3_sub3_1 == null) {
                    break;
                }
                if (aByteArrayArray1286[class44_sub3_sub3_1.anInt1405][class44_sub3_sub3_1.anInt1406] != 0) {
                    anInt1308++;
                }
                aByteArrayArray1286[class44_sub3_sub3_1.anInt1405][class44_sub3_sub3_1.anInt1406] = 0;
                aClass28_1304.method256(class44_sub3_sub3_1);
                anInt1299++;
                method403(class44_sub3_sub3_1, 409);
                aBoolean1298 = true;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("10900, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method400(int i) {
        label0:
        while (true) {
            try {
                if (i != 0) {
                    aBoolean1280 = !aBoolean1280;
                }
                while (true) {
                    if (anInt1299 != 0) {
                        break label0;
                    }
                    if (anInt1300 >= 10) {
                        break;
                    }
                    if (anInt1287 == 0) {
                        break;
                    }
                    OnDemandNode class44_sub3_sub3;
                    synchronized (aClass28_1306) {
                        class44_sub3_sub3 = (OnDemandNode) aClass28_1306.method258();
                    }
                    while (class44_sub3_sub3 != null) {
                        if (aByteArrayArray1286[class44_sub3_sub3.anInt1405][class44_sub3_sub3.anInt1406] != 0) {
                            aByteArrayArray1286[class44_sub3_sub3.anInt1405][class44_sub3_sub3.anInt1406] = (byte) 0;
                            aClass28_1304.method256(class44_sub3_sub3);
                            method403(class44_sub3_sub3, 409);
                            aBoolean1298 = true;
                            if (anInt1308 < anInt1309) {
                                anInt1308++;
                            }
                            aString1307 = "Loading extra files - " + (anInt1308 * 100 / anInt1309) + "%";
                            anInt1300++;
                            if (anInt1300 == 10) {
                                return;
                            }
                        }
                        synchronized (aClass28_1306) {
                            class44_sub3_sub3 = ((OnDemandNode) aClass28_1306.method258());
                        }
                    }
                    for (int j = 0; j < 4; j++) {
                        byte[] abyte0 = aByteArrayArray1286[j];
                        int k = abyte0.length;
                        for (int l = 0; l < k; l++) {
                            if (abyte0[l] == anInt1287) {
                                abyte0[l] = (byte) 0;
                                class44_sub3_sub3 = new OnDemandNode();
                                class44_sub3_sub3.anInt1405 = j;
                                class44_sub3_sub3.anInt1406 = l;
                                class44_sub3_sub3.aBoolean1409 = false;
                                aClass28_1304.method256(class44_sub3_sub3);
                                method403(class44_sub3_sub3, 409);
                                aBoolean1298 = true;
                                if (anInt1308 < anInt1309) {
                                    anInt1308++;
                                }
                                aString1307 = "Loading extra files - " + (anInt1308 * 100 / anInt1309) + "%";
                                anInt1300++;
                                if (anInt1300 == 10) {
                                    return;
                                }
                            }
                        }
                    }
                    anInt1287--;
                }
            } catch (RuntimeException runtimeexception) {
                SignLink.reporterror("38119, " + i + ", " + runtimeexception.toString());
                throw new RuntimeException();
            }
            break;
        }
    }

    public void method401(int i) {
        try {
            i = 48 / i;
            try {
                int j = anInputStream1311.available();
                if (anInt1316 == 0 && j >= 6) {
                    aBoolean1298 = true;
                    for (int k = 0; k < 6; k += anInputStream1311.read(aByteArray1317, k, 6 - k)) {
                    }
                    int l = aByteArray1317[0] & 0xff;
                    int j1 = ((aByteArray1317[1] & 0xff) << 8) + (aByteArray1317[2] & 0xff);
                    int l1 = ((aByteArray1317[3] & 0xff) << 8) + (aByteArray1317[4] & 0xff);
                    int i2 = aByteArray1317[5] & 0xff;

                    aClass44_Sub3_Sub3_1314 = null;
                    for (OnDemandNode class44_sub3_sub3 = (OnDemandNode) aClass28_1304.peekFront(); class44_sub3_sub3 != null; class44_sub3_sub3 = (OnDemandNode) aClass28_1304
                            .prev(false)) {
                        if (class44_sub3_sub3.anInt1405 == l && class44_sub3_sub3.anInt1406 == j1) {
                            aClass44_Sub3_Sub3_1314 = class44_sub3_sub3;
                        }
                        if (aClass44_Sub3_Sub3_1314 != null) {
                            class44_sub3_sub3.anInt1408 = 0;
                        }
                    }
                    if (aClass44_Sub3_Sub3_1314 != null) {
                        anInt1319 = 0;
                        if (l1 == 0) {
                            SignLink.reporterror("Rej: " + l + "," + j1);
                            aClass44_Sub3_Sub3_1314.aByteArray1407 = null;
                            if (aClass44_Sub3_Sub3_1314.aBoolean1409) {
                                synchronized (aClass28_1305) {
                                    aClass28_1305.method256(aClass44_Sub3_Sub3_1314);
                                }
                            } else {
                                aClass44_Sub3_Sub3_1314.remove();
                            }
                            aClass44_Sub3_Sub3_1314 = null;
                        } else {
                            if (aClass44_Sub3_Sub3_1314.aByteArray1407 == null && i2 == 0) {
                                aClass44_Sub3_Sub3_1314.aByteArray1407 = new byte[l1];
                            }
                            if (aClass44_Sub3_Sub3_1314.aByteArray1407 == null && i2 != 0) {
                                throw new IOException("missing start of file");
                            }
                        }
                    }
                    anInt1315 = i2 * 500;
                    anInt1316 = 500;
                    if (anInt1316 > l1 - i2 * 500) {
                        anInt1316 = l1 - i2 * 500;
                    }
                }
                if (anInt1316 > 0 && j >= anInt1316) {
                    aBoolean1298 = true;
                    byte abyte0[] = aByteArray1317;
                    int i1 = 0;
                    if (aClass44_Sub3_Sub3_1314 != null) {
                        abyte0 = aClass44_Sub3_Sub3_1314.aByteArray1407;
                        i1 = anInt1315;
                    }
                    for (int k1 = 0; k1 < anInt1316; k1 += anInputStream1311.read(abyte0, k1 + i1, anInt1316 - k1)) {
                    }
                    if (anInt1316 + anInt1315 >= abyte0.length && aClass44_Sub3_Sub3_1314 != null) {
                        if (aClient1296.aClass45Array1208[0] != null) {
                            aClient1296.aClass45Array1208[aClass44_Sub3_Sub3_1314.anInt1405 + 1].method542(abyte0,
                                    (byte) 4, abyte0.length, aClass44_Sub3_Sub3_1314.anInt1406);
                        }
                        if (!aClass44_Sub3_Sub3_1314.aBoolean1409 && aClass44_Sub3_Sub3_1314.anInt1405 == 3) {
                            aClass44_Sub3_Sub3_1314.aBoolean1409 = true;
                            aClass44_Sub3_Sub3_1314.anInt1405 = 93;
                        }
                        if (aClass44_Sub3_Sub3_1314.aBoolean1409) {
                            synchronized (aClass28_1305) {
                                aClass28_1305.method256(aClass44_Sub3_Sub3_1314);
                            }
                        } else {
                            aClass44_Sub3_Sub3_1314.remove();
                        }
                    }
                    anInt1316 = 0;
                    return;
                }
            } catch (IOException ioexception) {
                try {
                    aSocket1310.close();
                } catch (Exception _ex) {
                }
                aSocket1310 = null;
                anInputStream1311 = null;
                anOutputStream1312 = null;
                anInt1316 = 0;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("67743, " + i + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public boolean method402(byte abyte0[], int i, byte byte0, int j) {
        try {
            if (abyte0 == null || abyte0.length < 2) {
                return false;
            }
            int k = abyte0.length - 2;
            int l = ((abyte0[k] & 0xff) << 8) + (abyte0[k + 1] & 0xff);
            aCRC32_1297.reset();
            if (byte0 != aByte1283) {
                throw new NullPointerException();
            }
            aCRC32_1297.update(abyte0, 0, k);
            int i1 = (int) aCRC32_1297.getValue();
            if (l != i) {
                return false;
            }
            return i1 == j;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("56096, " + abyte0 + ", " + i + ", " + byte0 + ", " + j + ", "
                    + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method403(OnDemandNode class44_sub3_sub3, int i) {
        try {
            i = 99 / i;
            try {
                if (aSocket1310 == null) {
                    long l = System.currentTimeMillis();
                    if (l - aLong1321 < 4000L) {
                        return;
                    }
                    aLong1321 = l;
                    aSocket1310 = aClient1296.method34(43594 + Game.portOffset);
                    anInputStream1311 = aSocket1310.getInputStream();
                    anOutputStream1312 = aSocket1310.getOutputStream();
                    anOutputStream1312.write(15);
                    for (int j = 0; j < 8; j++) {
                        anInputStream1311.read();
                    }
                    anInt1319 = 0;
                }
                aByteArray1317[0] = (byte) class44_sub3_sub3.anInt1405;
                aByteArray1317[1] = (byte) (class44_sub3_sub3.anInt1406 >> 8);
                aByteArray1317[2] = (byte) class44_sub3_sub3.anInt1406;
                if (class44_sub3_sub3.aBoolean1409) {
                    aByteArray1317[3] = 2;
                } else if (!aClient1296.aBoolean863) {
                    aByteArray1317[3] = 1;
                } else {
                    aByteArray1317[3] = 0;
                }
                anOutputStream1312.write(aByteArray1317, 0, 4);
                anInt1320 = 0;
                anInt1313 = -10000;
                return;
            } catch (IOException ioexception) {
            }
            try {
                aSocket1310.close();
            } catch (Exception _ex) {
            }
            aSocket1310 = null;
            anInputStream1311 = null;
            anOutputStream1312 = null;
            anInt1316 = 0;
            anInt1313++;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("57925, " + class44_sub3_sub3 + ", " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }
}

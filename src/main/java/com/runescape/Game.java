package com.runescape;

import com.runescape.cache.FileArchive;
import com.runescape.cache.FileStore;
import com.runescape.cache.request.OnDemandNode;
import com.runescape.cache.request.OnDemandRequester;
import com.runescape.chat.ChatCensor;
import com.runescape.chat.ChatCompression;
import com.runescape.collection.LinkedList;
import com.runescape.collection.Node;
import com.runescape.graphic.*;
import com.runescape.graphic.Component;
import com.runescape.net.Buffer;
import com.runescape.net.Connection;
import com.runescape.net.ISAACCipher;
import com.runescape.util.NetworkConstants;
import com.runescape.renderable.*;
import com.runescape.scene.*;
import com.runescape.sound.SoundTrack;
import com.runescape.type.*;
import com.runescape.util.*;

import java.applet.AppletContext;
import java.awt.*;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.zip.CRC32;

@SuppressWarnings("serial")
public class Game extends GameShell {

    public static int anInt821;
    public static int anInt845;
    public static int anInt870;
    public static int anInt873;
    public static boolean aBoolean896;
    public static int anInt923;
    public static boolean flagged;
    public static int anInt944;
    public static byte aByte949 = -48;
    public static int anInt958 = 1;
    public static String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public static int[] levelExperience;
    public static int anInt986;
    public static int anInt1029;
    public static final int[] BEARD_COLOURS = {9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 58654, 5027,
            1457, 16565, 34991, 25486};
    public static int anInt1046;
    public static PlayerEntity self;
    public static boolean aBoolean1061;
    public static final int[][] APPEARANCE_COLOURS = {
            {6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193},
            {8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239},
            {25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003},
            {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}};
    public static int anInt1087;
    public static int[] BITMASK;
    public static int anInt1100;
    public static int anInt1114;
    public static int anInt1167;
    public static int anInt1175;
    public static int anInt1180;
    public static byte aByte1194 = 102;
    public static int anInt1204;
    public static int anInt1207;
    public static int nodeId = 10;
    public static int portOffset;
    public static boolean membersWorld = true;
    public static boolean lowMemory;
    public static int anInt1238;
    public static int loopCycle;
    public static int anInt1246 = 604;
    public static int anInt1274;
    public static boolean aBoolean1279;

    static {
        Game.levelExperience = new int[99];
        int acc = 0;
        for (int i = 0; i < 99; i++) {
            int level = i + 1;
            int delta = (int) (level + 300D * Math.pow(2D, level / 7D));
            acc += delta;
            Game.levelExperience[i] = acc / 4;
        }
        Game.BITMASK = new int[32];
        acc = 2;
        for (int k = 0; k < 32; k++) {
            Game.BITMASK[k] = acc - 1;
            acc += acc;
        }
    }

    public boolean aBoolean812;
    public long serverSeed;
    public OnDemandRequester ondemand;
    public int crossX;
    public int crossY;
    public int crossCycle;
    public int crossMode;
    public int sameClickPositionCounter;
    public boolean aBoolean820;
    public Buffer loginBuffer;
    public String clickToContinueString;
    public int anInt824;
    public int anInt825;
    public int anInt826;
    public int[] anIntArray827;
    public int[] anIntArray828;
    public boolean cutsceneActive;
    public byte aByte830;
    public int loginInputLine;
    public int anInt832;
    public int anInt833;
    public int anInt834;
    public int anInt835;
    public Image8[] aClass44_Sub3_Sub1_Sub3Array836;
    public int[] menuParamA;
    public int[] menuParamB;
    public int[] menuAction;
    public int[] menuParamC;
    public int sceneCenterZoneX;
    public int sceneCenterZoneZ;
    public int publicChatSetting;
    public int anInt844;
    public int[] anIntArray846;
    public boolean aBoolean847;
    public int anInt848;
    public int[] anIntArray849;
    public Buffer out;
    public int[] anIntArray851;
    public Image8 aClass44_Sub3_Sub1_Sub3_852;
    public Image8 aClass44_Sub3_Sub1_Sub3_853;
    public Image8 aClass44_Sub3_Sub1_Sub3_854;
    public Image8 aClass44_Sub3_Sub1_Sub3_855;
    public Image8 aClass44_Sub3_Sub1_Sub3_856;
    public int anInt857;
    public DrawArea aClass34_858;
    public DrawArea aClass34_859;
    public DrawArea aClass34_860;
    public int anInt861;
    public int anInt862;
    public boolean ingame;
    public Image8[] aClass44_Sub3_Sub1_Sub3Array864;
    public int[][][] anIntArrayArrayArray865;
    public MouseCapturer mouseCapturer;
    public Image24[] aClass44_Sub3_Sub1_Sub2Array867;
    public int[] anIntArray868;
    public int anInt869;
    public byte[][][] planeTileFlags;
    public Image24[] aClass44_Sub3_Sub1_Sub2Array872;
    public int anInt874;
    public int cameraPositionX;
    public int cameraPositionY;
    public int cameraPositionZ;
    public int cameraVerticalRotation;
    public int anInt879;
    public int anInt880;
    public int[] anIntArray881;
    public int sceneState;
    public byte aByte883;
    public byte aByte884;
    public int[][] anIntArrayArray885;
    public boolean aBoolean886;
    public int anInt887;
    public int anInt888;
    public int anInt889;
    public int anInt890;
    public Image8 titleBox;
    public Image8 titleButton;
    public boolean aBoolean893;
    public int[] anIntArray894;
    public int privateChatSetting;
    public String[] aStringArray897;
    public boolean redrawInvBack;
    public int anInt899;
    public int anInt900;
    public int anInt901;
    public int anInt902;
    public Image8 aClass44_Sub3_Sub1_Sub3_903;
    public Image8 aClass44_Sub3_Sub1_Sub3_904;
    public Image8 aClass44_Sub3_Sub1_Sub3_905;
    public boolean withinTutorialIsland;
    public int anInt907;
    public boolean redrawTitleBackground;
    public int anInt909;
    public int[] anIntArray910;
    public int flagSceneTileX;
    public int flagSceneTileZ;
    public Image24 aClass44_Sub3_Sub1_Sub2_913;
    public int[] anIntArray914;
    public int[] anIntArray915;
    public int[] anIntArray916;
    public int anInt917;
    public LinkedList aClass28_918;
    public String[] aStringArray919;
    public boolean[] aBooleanArray920;
    public int anInt921;
    public boolean aBoolean922;
    public int anInt924;
    public byte aByte925;
    public String aString926;
    public ISAACCipher encryption;
    public int anInt928;
    public int cameraVertical;
    public int cameraHorizontal;
    public int anInt931;
    public int anInt932;
    public int anInt933;
    public boolean windowFocused;
    public boolean aBoolean935;
    public int playerEnergy;
    public int[] anIntArray938;
    public String aString939;
    public int anInt940;
    public int[] anIntArray941;
    public int anInt942;
    public int[] cameraFrequency;
    public int anInt945;
    public boolean menuVisible;
    public int anInt947;
    public int anInt948;
    public boolean aBoolean950;
    public CRC32 aCRC32_951;
    public int anInt952;
    public int anInt953;
    public int anInt954;
    public int anInt955;
    public String aString956;
    public int anInt957;
    public int anInt959;
    public int anInt960;
    public int[] anIntArray961;
    public int anInt962;
    public int anInt963;
    public int anInt964;
    public int anInt965;
    public long aLong967;
    public int anInt968;
    public int anInt969;
    public int anInt970;
    public int menuSize;
    public int anInt972;
    public byte[][] sceneMapLocData;
    public int anInt974;
    public int[][] anIntArrayArray975;
    public int[] cameraJitter;
    public byte aByte977;
    public int anInt978;
    public long[] aLongArray979;
    public boolean aBoolean980;
    public byte[][] sceneMapLandData;
    public int anInt982;
    public int anInt983;
    public boolean aBoolean985;
    public boolean aBoolean987;
    public Image24 aClass44_Sub3_Sub1_Sub2_988;
    public int anInt989;
    public int anInt990;
    public int anInt991;
    public int anInt992;
    public int anInt993;
    public int anInt994;
    public int anInt995;
    public int anInt996;
    public String aString997;
    public int systemUpdateTimer;
    public int anInt999;
    public int anInt1000;
    public int[] anIntArray1001;
    public int[] anIntArray1002;
    public String[] aStringArray1003;
    public String[] chatMessages;
    public int hintIconType;
    public int[] anIntArray1006;
    public String aString1007;
    public NPCEntity[] npcs;
    public int anInt1009;
    public int[] anIntArray1010;
    public int cameraRandomizationH;
    public int anInt1012;
    public Socket aSocket1013;
    public int loginScreenState;
    public int anInt1015 = 100;
    public int[] anIntArray1016;
    public int anInt1017;
    public int[] anIntArray1018;
    public int anInt1019;
    public int[] anIntArray1020;
    public int[] anIntArray1021;
    public CollisionMap[] aClass18Array1022;
    public int anInt1023;
    public int[] anIntArray1024;
    public Image24 aClass44_Sub3_Sub1_Sub2_1025;
    public Image24 aClass44_Sub3_Sub1_Sub2_1026;
    public int currentTab;
    public int anInt1028;
    public int anInt1030;
    public int anInt1031;
    public int anInt1032;
    public int anInt1033;
    public int anInt1034;
    public int[] anIntArray1035;
    public boolean aBoolean1036;
    public int anInt1037;
    public int anInt1038;
    public int[] sceneMapIndex;
    public int[] sceneMapLandFile;
    public int[] sceneMapLocFile;
    public byte aByte1042;
    public String[] aStringArray1044;
    public long aLong1048;
    public boolean redrawChatback;
    public boolean aBoolean1050;
    public int[] archiveCRCs;
    public Image24[] aClass44_Sub3_Sub1_Sub2Array1052;
    public byte aByte1053;
    public LinkedList aClass28_1054;
    public boolean aBoolean1055;
    public int anInt1056;
    public boolean aBoolean1057;
    public Image8 aClass44_Sub3_Sub1_Sub3_1058;
    public Image8 aClass44_Sub3_Sub1_Sub3_1059;
    public int[] tabComponentId = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public boolean redrawPrivacySettings;
    public int lastRegionId;
    public int anInt1064;
    public int anInt1065;
    public int anInt1066;
    public int firstOpcode;
    public int secondOpcode;
    public int thirdOpcode;
    public long sceneLoadStartTime;
    public String username;
    public String password;
    public int anInt1074;
    public int anInt1075;
    public int anInt1076;
    public Image24 aClass44_Sub3_Sub1_Sub2_1077;
    public Image24 aClass44_Sub3_Sub1_Sub2_1078;
    public Image24 aClass44_Sub3_Sub1_Sub2_1079;
    public Image24 aClass44_Sub3_Sub1_Sub2_1080;
    public int currentCameraPositionH;
    public int currentCameraPositionV;
    public int anInt1083;
    public boolean aBoolean1084;
    public int anInt1085;
    public byte aByte1086;
    public int isMembers;
    public int[] anIntArray1090;
    public int anInt1091;
    public String aString1092;
    public int anInt1093;
    public int anInt1094;
    public int anInt1095;
    public int anInt1096;
    public int anInt1097;
    public byte aByte1098;
    public Connection connection;
    public byte aByte1101;
    public String aString1102;
    public int anInt1103;
    public int anInt1104;
    public int anInt1105;
    public int cameraRandomisationA;
    public int anInt1107;
    public Image24[] aClass44_Sub3_Sub1_Sub2Array1108;
    public byte[] aByteArray1109;
    public String loginString0;
    public String loginString1;
    public int anInt1112;
    public int[][] anIntArrayArray1113;
    public int localPlayerIndex;
    public LinkedList listTemporaryLocs;
    public FileArchive aClass47_1117;
    public int anInt1118;
    public int anInt1119;
    public int anInt1120;
    public int anInt1121;
    public int anInt1122;
    public DrawArea aClass34_1123;
    public DrawArea aClass34_1124;
    public DrawArea aClass34_1125;
    public DrawArea aClass34_1126;
    public DrawArea aClass34_1127;
    public DrawArea aClass34_1128;
    public DrawArea aClass34_1129;
    public DrawArea aClass34_1130;
    public DrawArea aClass34_1131;
    public Buffer in;
    public int[] anIntArray1133;
    public int[] anIntArray1134;
    public Image8 aClass44_Sub3_Sub1_Sub3_1136;
    public Image8 aClass44_Sub3_Sub1_Sub3_1137;
    public Image8 aClass44_Sub3_Sub1_Sub3_1138;
    public Image8 aClass44_Sub3_Sub1_Sub3_1139;
    public Image8 aClass44_Sub3_Sub1_Sub3_1140;
    public String aString1141;
    public int[] anIntArray1142 = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    public Image8 aClass44_Sub3_Sub1_Sub3_1143;
    public Image8 aClass44_Sub3_Sub1_Sub3_1144;
    public Image8 aClass44_Sub3_Sub1_Sub3_1145;
    public LinkedList[][][] planeObjStacks;
    public boolean aBoolean1147;
    public int anInt1148;
    public int anInt1149;
    public int anInt1150;
    public int anInt1151;
    public int anInt1152;
    public int anInt1153;
    public boolean redrawSideicons;
    public int plane;
    public boolean aBoolean1156;
    public int anInt1157;
    public int anInt1158;
    public int[] anIntArray1159;
    public int[] anIntArray1160;
    public int[] anIntArray1161;
    public int[] anIntArray1162;
    public int[] anIntArray1163;
    public int[] anIntArray1164;
    public int[] anIntArray1165;
    public String[] aStringArray1166;
    public int tradeChatSetting;
    public int packetSize;
    public int packetType;
    public int timeoutCounter;
    public int anInt1172;
    public int idleLogout;
    public boolean aBoolean1174;
    public int anInt1176;
    public int anInt1177;
    public boolean aBoolean1178;
    public boolean aBoolean1179;
    public long lastClickTime;
    public byte aByte1182;
    public Image24[] aClass44_Sub3_Sub1_Sub2Array1183;
    public int sceneBaseTileX;
    public int sceneBaseTileZ;
    public int scenePrevBaseTileX;
    public int scenePrevBaseTileZ;
    public int rights;
    public int renderCycle;
    public int anInt1190;
    public boolean aBoolean1191;
    public Scene scene;
    public int[] anIntArray1193;
    public DrawArea aClass34_1195;
    public DrawArea aClass34_1196;
    public DrawArea areaViewport;
    public DrawArea aClass34_1198;
    public int anInt1199;
    public int anInt1200;
    public Component aClass5_1201;
    public int anInt1202;
    public int[] anIntArray1203 = {0xffff00, 0xff0000, 65280, 65535, 0xff00ff, 0xffffff};
    public int weightCarried;
    public int[] cameraAmplitude;
    public FileStore[] aClass45Array1208;
    public boolean[] aBooleanArray1209;
    public Image24 aClass44_Sub3_Sub1_Sub2_1210;
    public Image24 aClass44_Sub3_Sub1_Sub2_1211;
    public int anInt1212;
    public byte aByte1213;
    public int[] anIntArray1214;
    public int cameraRandomizationV;
    public int anInt1216;
    public int anInt1217;
    public int[] anIntArray1218;
    public int[] anIntArray1219;
    public int[] anIntArray1220;
    public int[] anIntArray1221;
    public boolean aBoolean1222;
    public static int MAX_PLAYER_COUNT;
    public int anInt1224;
    public PlayerEntity[] players;
    public int anInt1226;
    public int[] anIntArray1227;
    public int anInt1228;
    public int[] anIntArray1229;
    public Buffer[] aClass44_Sub3_Sub2Array1230;
    public int anInt1231;
    public boolean aBoolean1236;
    public boolean aBoolean1237;
    public int secondaryCameraVertical;
    public Image8[] aClass44_Sub3_Sub1_Sub3Array1241;
    public int anInt1242;
    public int anInt1243;
    public int anInt1244;
    public int tutorial;
    public int anInt1247;
    public int anInt1248;
    public int anInt1249;
    public int anInt1250;
    public int anInt1251;
    public int anInt1252;
    public int anInt1253;
    public long[] aLongArray1254;
    public TypeFace fontPlain;
    public TypeFace plainFont;
    public TypeFace fontBold;
    public TypeFace aClass44_Sub3_Sub1_Sub4_1258;
    public int anInt1259;
    public int anInt1260;
    public Image24 aClass44_Sub3_Sub1_Sub2_1261;
    public boolean aBoolean1262;
    public DrawArea title2;
    public DrawArea title3;
    public DrawArea title4;
    public DrawArea aClass34_1266;
    public DrawArea aClass34_1267;
    public DrawArea title5;
    public DrawArea title6;
    public DrawArea title7;
    public DrawArea title8;
    public int[] anIntArray1272;
    public int[] anIntArray1273;
    public boolean loadingMap;
    public Image8[] aClass44_Sub3_Sub1_Sub3Array1276;
    public Image24 aClass44_Sub3_Sub1_Sub2_1277;
    public Image24 aClass44_Sub3_Sub1_Sub2_1278;

    public Game() {
        aBoolean812 = false;
        aBoolean820 = false;
        loginBuffer = Buffer.method470(-929, 1);
        anIntArray827 = new int[1000];
        anIntArray828 = new int[1000];
        cutsceneActive = false;
        aByte830 = -83;
        anInt833 = -1;
        aClass44_Sub3_Sub1_Sub3Array836 = new Image8[2];
        menuParamA = new int[500];
        menuParamB = new int[500];
        menuAction = new int[500];
        menuParamC = new int[500];
        anInt844 = 0x332d25;
        anIntArray846 = new int[50];
        aBoolean847 = false;
        anIntArray849 = new int[7];
        out = Buffer.method470(-929, 1);
        anIntArray851 = new int[SkillConstants.skillCount];
        ingame = false;
        aClass44_Sub3_Sub1_Sub2Array867 = new Image24[8];
        anIntArray868 = new int[151];
        aClass44_Sub3_Sub1_Sub2Array872 = new Image24[1000];
        anInt874 = 78;
        anIntArray881 = new int[151];
        aByte883 = -127;
        aByte884 = 38;
        anIntArrayArray885 = new int[104][104];
        aBoolean886 = false;
        anInt889 = -1;
        aBoolean893 = false;
        anIntArray894 = new int[200];
        aStringArray897 = new String[500];
        redrawInvBack = false;
        anInt900 = -1;
        anInt902 = 70;
        withinTutorialIsland = false;
        redrawTitleBackground = false;
        anIntArray910 = new int[33];
        aClass28_918 = new LinkedList(-199);
        aStringArray919 = new String[5];
        aBooleanArray920 = new boolean[5];
        aBoolean922 = false;
        anInt924 = -1;
        aByte925 = 1;
        cameraVertical = 128;
        windowFocused = true;
        aBoolean935 = false;
        anIntArray938 = new int[5];
        aString939 = "";
        anIntArray941 = new int[1000];
        cameraFrequency = new int[5];
        menuVisible = false;
        anInt948 = -587;
        aBoolean950 = true;
        aCRC32_951 = new CRC32();
        anInt960 = 2;
        anIntArray961 = new int[33];
        anInt962 = 817;
        anInt963 = -1;
        anInt965 = -1;
        anInt969 = -8033;
        anInt974 = 8;
        anIntArrayArray975 = new int[104][104];
        cameraJitter = new int[5];
        aByte977 = 8;
        aLongArray979 = new long[200];
        aBoolean980 = false;
        aBoolean985 = true;
        aBoolean987 = false;
        anInt1000 = 0x23201b;
        anIntArray1001 = new int[5];
        anIntArray1002 = new int[100];
        aStringArray1003 = new String[100];
        chatMessages = new String[100];
        anIntArray1006 = new int[50];
        aString1007 = "";
        npcs = new NPCEntity[16384];
        anIntArray1010 = new int[16384];
        anInt1012 = 2;
        anInt1015 = 100;
        anIntArray1016 = new int[100];
        anIntArray1018 = new int[256];
        anInt1019 = 661;
        anIntArray1020 = new int[4000];
        anIntArray1021 = new int[4000];
        aClass18Array1022 = new CollisionMap[4];
        anIntArray1024 = new int[2000];
        currentTab = 3;
        anIntArray1035 = new int[SkillConstants.skillCount];
        aBoolean1036 = true;
        aByte1042 = -71;
        aStringArray1044 = new String[200];
        redrawChatback = false;
        aBoolean1050 = true;
        archiveCRCs = new int[9];
        aClass44_Sub3_Sub1_Sub2Array1052 = new Image24[100];
        aByte1053 = 29;
        aClass28_1054 = new LinkedList(-199);
        aBoolean1055 = false;
        anInt1056 = 513;
        aBoolean1057 = true;
        redrawPrivacySettings = false;
        lastRegionId = -1;
        anInt1064 = -1;
        anInt1065 = -1;
        username = "rebecca";
        password = "123";
        anInt1074 = -940;
        anInt1076 = 1;
        aBoolean1084 = false;
        anInt1085 = 0x766654;
        aByte1086 = 38;
        anIntArray1090 = new int[SkillConstants.skillCount];
        anInt1091 = 37395;
        aString1092 = "";
        aByte1098 = 29;
        aByte1101 = 6;
        aString1102 = "";
        anInt1107 = 1;
        aClass44_Sub3_Sub1_Sub2Array1108 = new Image24[20];
        aByteArray1109 = new byte[16384];
        loginString0 = "";
        loginString1 = "";
        anIntArrayArray1113 = new int[104][104];
        localPlayerIndex = -1;
        listTemporaryLocs = new LinkedList(-199);
        in = Buffer.method470(-929, 1);
        aString1141 = "";
        planeObjStacks = new LinkedList[4][104][104];
        aBoolean1147 = false;
        anInt1153 = -6002;
        redrawSideicons = false;
        aBoolean1156 = false;
        anInt1158 = 50;
        anIntArray1159 = new int[anInt1158];
        anIntArray1160 = new int[anInt1158];
        anIntArray1161 = new int[anInt1158];
        anIntArray1162 = new int[anInt1158];
        anIntArray1163 = new int[anInt1158];
        anIntArray1164 = new int[anInt1158];
        anIntArray1165 = new int[anInt1158];
        aStringArray1166 = new String[anInt1158];
        aBoolean1174 = false;
        anInt1177 = -1;
        aBoolean1178 = true;
        aBoolean1179 = true;
        aByte1182 = 2;
        aClass44_Sub3_Sub1_Sub2Array1183 = new Image24[20];
        aBoolean1191 = true;
        anIntArray1193 = new int[50];
        anInt1199 = -1;
        anInt1200 = 0x4d4233;
        aClass5_1201 = new Component();
        anInt1202 = 9;
        cameraAmplitude = new int[5];
        aClass45Array1208 = new FileStore[5];
        aBooleanArray1209 = new boolean[5];
        aByte1213 = 1;
        anIntArray1214 = new int[2000];
        anInt1216 = 2;
        anInt1217 = -1;
        aBoolean1222 = false;
        MAX_PLAYER_COUNT = 2048;
        anInt1224 = 2047;
        players = new PlayerEntity[MAX_PLAYER_COUNT];
        anIntArray1227 = new int[MAX_PLAYER_COUNT];
        anIntArray1229 = new int[MAX_PLAYER_COUNT];
        aClass44_Sub3_Sub2Array1230 = new Buffer[MAX_PLAYER_COUNT];
        aBoolean1236 = false;
        aBoolean1237 = false;
        aClass44_Sub3_Sub1_Sub3Array1241 = new Image8[100];
        anInt1243 = 831;
        anInt1244 = 393;
        anInt1247 = -282;
        anInt1253 = -1;
        aLongArray1254 = new long[100];
        aBoolean1262 = false;
        loadingMap = false;
        aClass44_Sub3_Sub1_Sub3Array1276 = new Image8[13];
    }

    public static void main(String[] args) {
        try {
            System.out.println("RS2 user client - release #" + 289);
            Game.nodeId = 0;
            Game.portOffset = 0;
            Game.setHighMemory(true);
            Game.membersWorld = true;
            SignLink.storeId = 0;
            SignLink.initiate(InetAddress.getLocalHost());
            Game client = new Game();
            client.method1(503, 765, 0);
            return;
        } catch (Exception exception) {
        }
    }

    public static void setHighMemory(boolean flag) {
        try {
            Scene.aBoolean606 = false;
            Draw3D.aBoolean1418 = false;
            Game.lowMemory = false;
            if (!flag) {
                Game.anInt1029 = -15;
            }
            regionCached.aBoolean64 = false;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("78522, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static String method98(int i, byte byte0) {
        try {
            String s = String.valueOf(i);
            for (int j = s.length() - 3; j > 0; j -= 3) {
                s = s.substring(0, j) + "," + s.substring(j);
            }
            if (byte0 != 5) {
                throw new NullPointerException();
            }
            if (s.length() > 8) {
                s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
            } else if (s.length() > 4) {
                s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
            }
            return " " + s;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("6522, " + i + ", " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static String method100(int i, int j) {
        try {
            if (j != 656) {
                Game.anInt958 = -353;
            }
            if (i < 0x186a0) {
                return String.valueOf(i);
            }
            if (i < 0x989680) {
                return i / 1000 + "K";
            } else {
                return i / 0xf4240 + "M";
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("1290, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public static void setLowMemory(byte byte0) {
        try {
            Scene.aBoolean606 = true;
            if (byte0 != 102) {
                for (int i = 1; i > 0; i++) {
                }
            }
            Draw3D.aBoolean1418 = true;
            Game.lowMemory = true;
            regionCached.aBoolean64 = true;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("41041, " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static String method137(int i, int j, int k) {
        try {
            if (k != -41081) {
                throw new NullPointerException();
            }
            int l = j - i;
            if (l < -9) {
                return "@red@";
            }
            if (l < -6) {
                return "@or3@";
            }
            if (l < -3) {
                return "@or2@";
            }
            if (l < 0) {
                return "@or1@";
            }
            if (l > 9) {
                return "@gre@";
            }
            if (l > 6) {
                return "@gr3@";
            }
            if (l > 3) {
                return "@gr2@";
            }
            if (l > 0) {
                return "@gr1@";
            } else {
                return "@yel@";
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90622, " + i + ", " + j + ", " + k + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void init() {
        Game.nodeId = Integer.parseInt(getParameter("nodeid"));
        Game.portOffset = Integer.parseInt(getParameter("portoff"));
        String s = getParameter("lowmem");
        if (s != null && s.equals("1")) {
            Game.setLowMemory(Game.aByte1194);
        } else {
            Game.setHighMemory(true);
        }
        String s1 = getParameter("free");
        Game.membersWorld = s1 == null || !s1.equals("1");
        method2(true, 765, 503);
    }

    @Override
    public void method7(int i) {
        try {
            if (i != 9) {
                packetType = in.readUnsignedByte();
            }
            if (aBoolean1236 || aBoolean1055 || aBoolean820) {
                return;
            }
            Game.loopCycle++;
            if (!ingame) {
                method97((byte) 122);
            } else {
                method56(anInt1056);
            }
            method93(false);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("47231, " + i + ", " + runtimeexception);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AppletContext getAppletContext() {
        if (SignLink.mainapp != null) {
            return SignLink.mainapp.getAppletContext();
        } else {
            return super.getAppletContext();
        }
    }

    public void method14(byte byte0) {
        try {
            if (byte0 != 1) {
                Game.anInt1246 = 98;
            }
            if (anInt1095 != 0) {
                return;
            }
            int i = super.clickType;
            if (anInt994 == 1 && super.mousePressX >= 516 && super.mousePressY >= 160 && super.mousePressX <= 765
                    && super.mousePressY <= 205) {
                i = 0;
            }
            if (menuVisible) {
                if (i != 1) {
                    int j = super.anInt21;
                    int i1 = super.anInt22;
                    if (anInt1030 == 0) {
                        j -= 4;
                        i1 -= 4;
                    }
                    if (anInt1030 == 1) {
                        j -= 553;
                        i1 -= 205;
                    }
                    if (anInt1030 == 2) {
                        j -= 17;
                        i1 -= 357;
                    }
                    if (j < anInt1031 - 10 || j > anInt1031 + anInt1033 + 10 || i1 < anInt1032 - 10
                            || i1 > anInt1032 + anInt1034 + 10) {
                        menuVisible = false;
                        if (anInt1030 == 1) {
                            redrawInvBack = true;
                        }
                        if (anInt1030 == 2) {
                            redrawChatback = true;
                        }
                    }
                }
                if (i == 1) {
                    int k = anInt1031;
                    int j1 = anInt1032;
                    int l1 = anInt1033;
                    int j2 = super.mousePressX;
                    int k2 = super.mousePressY;
                    if (anInt1030 == 0) {
                        j2 -= 4;
                        k2 -= 4;
                    }
                    if (anInt1030 == 1) {
                        j2 -= 553;
                        k2 -= 205;
                    }
                    if (anInt1030 == 2) {
                        j2 -= 17;
                        k2 -= 357;
                    }
                    int l2 = -1;
                    for (int i3 = 0; i3 < menuSize; i3++) {
                        int j3 = j1 + 31 + (menuSize - 1 - i3) * 15;
                        if (j2 > k && j2 < k + l1 && k2 > j3 - 13 && k2 < j3 + 3) {
                            l2 = i3;
                        }
                    }
                    if (l2 != -1) {
                        useMentuOption(l2);
                    }
                    menuVisible = false;
                    if (anInt1030 == 1) {
                        redrawInvBack = true;
                    }
                    if (anInt1030 == 2) {
                        redrawChatback = true;
                        return;
                    }
                }
            } else {
                if (i == 1 && menuSize > 0) {
                    int l = menuAction[menuSize - 1];
                    if (l == 582 || l == 113 || l == 555 || l == 331 || l == 354 || l == 694 || l == 962 || l == 795
                            || l == 681 || l == 100 || l == 102 || l == 1328) {
                        int k1 = menuParamA[menuSize - 1];
                        int i2 = menuParamB[menuSize - 1];
                        Component class5 = Component.instances[i2];
                        if (class5.aBoolean127 || class5.aBoolean130) {
                            aBoolean847 = false;
                            anInt978 = 0;
                            anInt1093 = i2;
                            anInt1094 = k1;
                            anInt1095 = 2;
                            anInt1096 = super.mousePressX;
                            anInt1097 = super.mousePressY;
                            if (Component.instances[i2].anInt106 == anInt1199) {
                                anInt1095 = 1;
                            }
                            if (Component.instances[i2].anInt106 == anInt1253) {
                                anInt1095 = 3;
                            }
                            return;
                        }
                    }
                }
                if (i == 1 && (anInt862 == 1 || method26(menuSize - 1, -40)) && menuSize > 2) {
                    i = 2;
                }
                if (i == 1 && menuSize > 0) {
                    useMentuOption(menuSize - 1);
                }
                if (i == 2 && menuSize > 0) {
                    method89(anInt899);
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("43374, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method15(int i, Image24 class44_sub3_sub1_sub2, int j, int k) {
        try {
            int l = i * i + j * j;
            if (k != 0) {
                out.writeByte(121);
            }
            if (l > 4225 && l < 0x15f90) {
                int i1 = cameraHorizontal + anInt959 & 0x7ff;
                int j1 = Model.SINE[i1];
                int k1 = Model.COSINE[i1];
                j1 = (j1 * 256) / (anInt1075 + 256);
                k1 = (k1 * 256) / (anInt1075 + 256);
                int l1 = j * j1 + i * k1 >> 16;
                int i2 = j * k1 - i * j1 >> 16;
                double d = Math.atan2(l1, i2);
                int j2 = (int) (Math.sin(d) * 63D);
                int k2 = (int) (Math.cos(d) * 57D);
                aClass44_Sub3_Sub1_Sub2_1261.method445(15, d, 20, 256, 15, (94 + j2 + 4) - 10, (byte) 8, 20,
                        83 - k2 - 20);
                return;
            } else {
                method141(i, class44_sub3_sub1_sub2, 139, j);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("6403, " + i + ", " + class44_sub3_sub1_sub2 + ", " + j + ", " + k + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method16(int i) {
        try {
            method63(-411);
            if (crossMode == 1) {
                aClass44_Sub3_Sub1_Sub2Array867[crossCycle / 100]
                        .method440(crossY - 8 - 4, aByte1213, crossX - 8 - 4);
            }
            if (crossMode == 2) {
                aClass44_Sub3_Sub1_Sub2Array867[4 + crossCycle / 100].method440(crossY - 8 - 4, aByte1213,
                        crossX - 8 - 4);
                Game.anInt923++;
                if (Game.anInt923 > 57) {
                    Game.anInt923 = 0;
                    out.writePacket(85);
                }
            }
            if (anInt924 != -1) {
                method65(anInt824, anInt924, (byte) -103);
                method37(6, 0, 0, Component.instances[anInt924], 0);
            }
            if (anInt1199 != -1) {
                method65(anInt824, anInt1199, (byte) -103);
                method37(6, 0, 0, Component.instances[anInt1199], 0);
            }
            method24((byte) -128);
            if (i != anInt969) {
                out.writeByte(186);
            }
            if (!menuVisible) {
                method54((byte) 6);
                method52(521);
            } else if (anInt1030 == 0) {
                method115(393);
            }
            if (anInt1112 == 1) {
                aClass44_Sub3_Sub1_Sub2Array1183[1].method440(296, aByte1213, 472);
            }
            if (systemUpdateTimer != 0) {
                int j = systemUpdateTimer / 50;
                int k = j / 60;
                j %= 60;
                if (j < 10) {
                    plainFont.method459((byte) -104, 0xffff00, "System update in: " + k + ":0" + j,
                            4, 329);
                    return;
                } else {
                    plainFont.method459((byte) -104, 0xffff00, "System update in: " + k + ":" + j,
                            4, 329);
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("39313, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void renderText(int i, byte byte0, String s, String s1) {
        try {
            if (i == 0 && anInt965 != -1) {
                clickToContinueString = s;
                super.clickType = 0;
            }
            if (anInt1253 == -1) {
                redrawChatback = true;
            }
            for (int j = 99; j > 0; j--) {
                anIntArray1002[j] = anIntArray1002[j - 1];
                aStringArray1003[j] = aStringArray1003[j - 1];
                chatMessages[j] = chatMessages[j - 1];
            }
            if (byte0 != -115) {
                packetType = in.readUnsignedByte();
            }
            anIntArray1002[0] = i;
            aStringArray1003[0] = s1;
            chatMessages[0] = s;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("60879, " + i + ", " + byte0 + ", " + s + ", " + s1 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method18(int i) {
        try {
            packetSize += i;
            SignLink.midifade = 0;
            SignLink.midi = "stop";
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("82229, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public boolean method19(byte byte0, Component class5) {
        try {
            if (byte0 != -16) {
                planeObjStacks = null;
            }
            int i = class5.anInt109;
            if (anInt1105 == 2) {
                if (i == 201) {
                    redrawChatback = true;
                    aBoolean980 = false;
                    aBoolean1222 = true;
                    aString1007 = "";
                    anInt880 = 1;
                    aString1102 = "Enter name of friend to add to list";
                }
                if (i == 202) {
                    redrawChatback = true;
                    aBoolean980 = false;
                    aBoolean1222 = true;
                    aString1007 = "";
                    anInt880 = 2;
                    aString1102 = "Enter name of friend to delete from list";
                }
            }
            if (i == 205) {
                idleLogout = 250;
                return true;
            }
            if (i == 501) {
                redrawChatback = true;
                aBoolean980 = false;
                aBoolean1222 = true;
                aString1007 = "";
                anInt880 = 4;
                aString1102 = "Enter name of player to add to list";
            }
            if (i == 502) {
                redrawChatback = true;
                aBoolean980 = false;
                aBoolean1222 = true;
                aString1007 = "";
                anInt880 = 5;
                aString1102 = "Enter name of player to delete from list";
            }
            if (i >= 300 && i <= 313) {
                int j = (i - 300) / 2;
                int i1 = i & 1;
                int l1 = anIntArray849[j];
                if (l1 != -1) {
                    do {
                        if (i1 == 0 && --l1 < 0) {
                            l1 = IDKType.anInt463 - 1;
                        }
                        if (i1 == 1 && ++l1 >= IDKType.anInt463) {
                            l1 = 0;
                        }
                    } while (IDKType.cache[l1].aBoolean470
                            || IDKType.cache[l1].anInt465 != j + (aBoolean1179 ? 0 : 7));
                    anIntArray849[j] = l1;
                    aBoolean812 = true;
                }
            }
            if (i >= 314 && i <= 323) {
                int k = (i - 314) / 2;
                int j1 = i & 1;
                int i2 = anIntArray938[k];
                if (j1 == 0 && --i2 < 0) {
                    i2 = Game.APPEARANCE_COLOURS[k].length - 1;
                }
                if (j1 == 1 && ++i2 >= Game.APPEARANCE_COLOURS[k].length) {
                    i2 = 0;
                }
                anIntArray938[k] = i2;
                aBoolean812 = true;
            }
            if (i == 324 && !aBoolean1179) {
                aBoolean1179 = true;
                method70(aByte883);
            }
            if (i == 325 && aBoolean1179) {
                aBoolean1179 = false;
                method70(aByte883);
            }
            if (i == 326) {
                out.writePacket(27);
                out.writeByte(aBoolean1179 ? 0 : 1);
                for (int l = 0; l < 7; l++) {
                    out.writeByte(anIntArray849[l]);
                }
                for (int k1 = 0; k1 < 5; k1++) {
                    out.writeByte(anIntArray938[k1]);
                }
                return true;
            }
            if (i == 613) {
                aBoolean987 = !aBoolean987;
            }
            if (i >= 601 && i <= 612) {
                method28(3);
                if (aString939.length() > 0) {
                    out.writePacket(94);
                    out.method478(TextUtils.encodeBase37(aString939), true);
                    out.writeByte(i - 601);
                    out.writeByte(aBoolean987 ? 1 : 0);
                }
            }
            return false;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("38005, " + byte0 + ", " + class5 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method20(int i) {
        try {
            for (int j = -1; j < anInt1226; j++) {
                int k;
                if (j == -1) {
                    k = anInt1224;
                } else {
                    k = anIntArray1227[j];
                }
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[k];
                if (class44_sub3_sub4_sub6_sub1 != null && class44_sub3_sub4_sub6_sub1.anInt1628 > 0) {
                    class44_sub3_sub4_sub6_sub1.anInt1628--;
                    if (class44_sub3_sub4_sub6_sub1.anInt1628 == 0) {
                        class44_sub3_sub4_sub6_sub1.aString1627 = null;
                    }
                }
            }
            for (int l = 0; l < anInt1009; l++) {
                int i1 = anIntArray1010[l];
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[i1];
                if (class44_sub3_sub4_sub6_sub2 != null && class44_sub3_sub4_sub6_sub2.anInt1628 > 0) {
                    class44_sub3_sub4_sub6_sub2.anInt1628--;
                    if (class44_sub3_sub4_sub6_sub2.anInt1628 == 0) {
                        class44_sub3_sub4_sub6_sub2.aString1627 = null;
                    }
                }
            }
            if (i != 0) {
                out.writeByte(252);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("41421, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method21(int i, int j, int k, int l, int i1, int j1) {
        try {
            aClass44_Sub3_Sub1_Sub3_1058.blit(i, j);
            aClass44_Sub3_Sub1_Sub3_1059.blit((i + i1) - 16, j);
            Draw2D.method411(anInt1000, 210, i + 16, i1 - 32, j, 16);
            int k1 = ((i1 - 32) * i1) / l;
            if (k1 < 8) {
                k1 = 8;
            }
            int l1 = ((i1 - 32 - k1) * k) / (l - i1);
            Draw2D.method411(anInt1200, 210, i + 16 + l1, k1, j, 16);
            Draw2D.method416(i + 16 + l1, j, anInt1085, k1, 0);
            Draw2D.method416(i + 16 + l1, j + 1, anInt1085, k1, 0);
            Draw2D.method414(16, j, anInt1085, true, i + 16 + l1);
            Draw2D.method414(16, j, anInt1085, true, i + 17 + l1);
            Draw2D.method416(i + 16 + l1, j + 15, anInt844, k1, 0);
            Draw2D.method416(i + 17 + l1, j + 14, anInt844, k1 - 1, 0);
            Draw2D.method414(16, j, anInt844, true, i + 15 + l1 + k1);
            Draw2D.method414(15, j + 1, anInt844, true, i + 14 + l1 + k1);
            if (j1 != 3) {
                planeObjStacks = null;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("34190, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method22(byte byte0) {
        try {
            try {
                if (connection != null) {
                    connection.method191();
                }
            } catch (Exception _ex) {
            }
            connection = null;
            ingame = false;
            loginScreenState = 0;
            username = "rebecca";
            password = "123";
            method76(aByte1042);
            scene.method278(true);
            if (byte0 != 25) {
                packetType = -1;
            }
            for (int i = 0; i < 4; i++) {
                aClass18Array1022[i].method231(3);
            }
            System.gc();
            method18(0);
            anInt963 = -1;
            anInt1190 = -1;
            anInt942 = 0;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("79964, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method23(int i) {
        try {
            if (i <= 0) {
                anInt962 = -451;
            }
            if (sceneState == 2) {
                for (SceneLocTemporary class44_sub1 = (SceneLocTemporary) listTemporaryLocs.peekFront(); class44_sub1 != null; class44_sub1 = (SceneLocTemporary) listTemporaryLocs
                        .prev(false)) {
                    if (class44_sub1.anInt1334 > 0) {
                        class44_sub1.anInt1334--;
                    }
                    if (class44_sub1.anInt1334 == 0) {
                        if (class44_sub1.anInt1327 < 0
                                || regionCached.method173(class44_sub1.anInt1327, class44_sub1.anInt1329, 677)) {
                            method73(class44_sub1.anInt1328, 0, class44_sub1.anInt1329, class44_sub1.anInt1323,
                                    class44_sub1.anInt1327, class44_sub1.sceneTileX, class44_sub1.anInt1324,
                                    class44_sub1.sceneTileZ);
                            class44_sub1.remove();
                        }
                    } else {
                        if (class44_sub1.anInt1333 > 0) {
                            class44_sub1.anInt1333--;
                        }
                        if (class44_sub1.anInt1333 == 0
                                && class44_sub1.sceneTileX >= 1
                                && class44_sub1.sceneTileZ >= 1
                                && class44_sub1.sceneTileX <= 102
                                && class44_sub1.sceneTileZ <= 102
                                && (class44_sub1.anInt1330 < 0 || regionCached.method173(class44_sub1.anInt1330,
                                class44_sub1.anInt1332, 677))) {
                            method73(class44_sub1.anInt1331, 0, class44_sub1.anInt1332, class44_sub1.anInt1323,
                                    class44_sub1.anInt1330, class44_sub1.sceneTileX, class44_sub1.anInt1324,
                                    class44_sub1.sceneTileZ);
                            class44_sub1.anInt1333 = -1;
                            if (class44_sub1.anInt1330 == class44_sub1.anInt1327 && class44_sub1.anInt1327 == -1) {
                                class44_sub1.remove();
                            } else if (class44_sub1.anInt1330 == class44_sub1.anInt1327
                                    && class44_sub1.anInt1331 == class44_sub1.anInt1328
                                    && class44_sub1.anInt1332 == class44_sub1.anInt1329) {
                                class44_sub1.remove();
                            }
                        }
                    }
                }
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("56217, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method24(byte byte0) {
        try {
            if (byte0 != -128) {
                anInt1247 = encryption.method545();
            }
            tutorial = 0;
            int i = (Game.self.x >> 7) + sceneBaseTileX;
            int j = (Game.self.z >> 7) + sceneBaseTileZ;
            if (i >= 3053 && i <= 3156 && j >= 3056 && j <= 3136) {
                tutorial = 1;
            }
            if (i >= 3072 && i <= 3118 && j >= 9492 && j <= 9535) {
                tutorial = 1;
            }
            if (tutorial == 1 && i >= 3139 && i <= 3199 && j >= 3008 && j <= 3062) {
                tutorial = 0;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("82905, " + byte0 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method25(int i) {
        try {
            char c = '\u0100';
            for (int j = 10; j < 117; j++) {
                int k = (int) (Math.random() * 100D);
                if (k < 50) {
                    anIntArray1272[j + (c - 2 << 7)] = 255;
                }
            }
            for (int l = 0; l < 100; l++) {
                int i1 = (int) (Math.random() * 124D) + 2;
                int k1 = (int) (Math.random() * 128D) + 128;
                int k2 = i1 + (k1 << 7);
                anIntArray1272[k2] = 192;
            }
            for (int j1 = 1; j1 < c - 1; j1++) {
                for (int l1 = 1; l1 < 127; l1++) {
                    int l2 = l1 + (j1 << 7);
                    anIntArray1273[l2] = (anIntArray1272[l2 - 1] + anIntArray1272[l2 + 1] + anIntArray1272[l2 - 128] + anIntArray1272[l2 + 128]) / 4;
                }
            }
            anInt890 += 128;
            i = 27 / i;
            if (anInt890 > anIntArray1133.length) {
                anInt890 -= anIntArray1133.length;
                int i2 = (int) (Math.random() * 12D);
                method109(aClass44_Sub3_Sub1_Sub3Array864[i2], 34809);
            }
            for (int j2 = 1; j2 < c - 1; j2++) {
                for (int i3 = 1; i3 < 127; i3++) {
                    int k3 = i3 + (j2 << 7);
                    int i4 = anIntArray1273[k3 + 128] - anIntArray1133[k3 + anInt890 & anIntArray1133.length - 1] / 5;
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    anIntArray1272[k3] = i4;
                }
            }
            for (int j3 = 0; j3 < c - 1; j3++) {
                anIntArray1018[j3] = anIntArray1018[j3 + 1];
            }
            anIntArray1018[c - 1] = (int) (Math.sin(Game.loopCycle / 14D) * 16D + Math.sin(Game.loopCycle / 15D)
                    * 14D + Math.sin(Game.loopCycle / 16D) * 12D);
            if (anInt1259 > 0) {
                anInt1259 -= 4;
            }
            if (anInt1260 > 0) {
                anInt1260 -= 4;
            }
            if (anInt1259 == 0 && anInt1260 == 0) {
                int l3 = (int) (Math.random() * 2000D);
                if (l3 == 0) {
                    anInt1259 = 1024;
                }
                if (l3 == 1) {
                    anInt1260 = 1024;
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("53446, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public boolean method26(int i, int j) {
        try {
            if (i < 0) {
                return false;
            }
            int k = menuAction[i];
            if (j >= 0) {
                anInt1242 = encryption.method545();
            }
            if (k >= 2000) {
                k -= 2000;
            }
            return k == 605;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("17125, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method27(byte byte0) {
        try {
            int i = 5;
            archiveCRCs[8] = 0;
            if (byte0 != -48) {
                packetType
                        = in.readUnsignedByte();
            }
            int j = 0;
            while (archiveCRCs[8] == 0) {
                String s = "Unknown problem";
                method13(false, 20, "Connecting to web server");
                try {
                    DataInputStream datainputstream = method77("crc" +
                            (int) (Math.random() * 99999999D) + "-" + 289);
                    Buffer
                            class44_sub3_sub2 = new Buffer(new byte[40]);
                    datainputstream.readFully(class44_sub3_sub2.payload, 0, 40);
                    datainputstream.close();
                    for (int l = 0; l < 9; l++) {
                        archiveCRCs[l] = class44_sub3_sub2.readInt();
                    }
                    int i1 =
                            class44_sub3_sub2.readInt();
                    int j1 = 1234;
                    for (int k1 = 0; k1 < 9;
                         k1++) {
                        j1 = (j1 << 1) + archiveCRCs[k1];
                    }
                    if (i1 != j1) {
                        s =
                                "checksum problem";
                        archiveCRCs[8] = 0;
                    }
                } catch (EOFException
                        _ex) {
                    s = "EOF problem";
                    archiveCRCs[8] = 0;
                } catch (IOException
                        _ex) {
                    s = "connection problem";
                    archiveCRCs[8] = 0;
                } catch (Exception _ex) {
                    _ex.printStackTrace();
                    s = "logic problem";
                    archiveCRCs[8] = 0;
                    if (!SignLink.reporterror) {
                        return;
                    }
                }
                if (archiveCRCs[8] == 0) {
                    j++;
                    for (int k = i; k > 0; k--) {
                        if (j >= 10) {
                            method13(false, 10,
                                    "Game updated - please reload page");
                            k = 10;
                        } else {
                            method13(false, 10, s + " - Will retry in " + k + " secs.");
                        }
                        try {
                            Thread.sleep(1000L);
                        } catch (Exception _ex) {
                        }
                    }
                    i *= 2;
                    if (i > 60) {
                        i = 60;
                    }
                    aBoolean922 = !aBoolean922;
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("95813, " + byte0 + ", " +
                    runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method28(int i) {
        try {
            if (i < 3 || i > 3) {
                planeObjStacks = null;
            }
            out.writePacket(93);
            if (anInt889 != -1) {
                anInt889 = -1;
                redrawInvBack = true;
                aBoolean935 = false;
                redrawSideicons = true;
            }
            if (anInt1253 != -1) {
                anInt1253 = -1;
                redrawChatback = true;
                aBoolean935 = false;
            }
            anInt1199 = -1;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("99207, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method29(byte byte0) {
        try {
            System.out.println("============");
            System.out.println("flame-cycle:" + anInt945);
            if (ondemand != null) {
                System.out.println("Od-cycle:" + ondemand.anInt1322);
            }
            System.out.println("loop-cycle:" + Game.loopCycle);
            System.out.println("draw-cycle:" + Game.anInt1175);
            System.out.println("ptype:" + packetType);
            System.out.println("psize:" + packetSize);
            if (connection != null) {
                connection.method196((byte) -11);
            }
            super.aBoolean10 = true;
            if (byte0 != -11) {
                for (int i = 1; i > 0; i++) {
                }
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("31857, " + byte0 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    @Override
    public java.awt.Component method11(int i) {
        try {
            if (i < 7 || i > 7) {
                aBoolean1178 = !aBoolean1178;
            }
            if (SignLink.mainapp != null) {
                return SignLink.mainapp;
            }
            if (super.aFrame_Sub1_16 != null) {
                return super.aFrame_Sub1_16;
            } else {
                return this;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("75072, " + i + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public void method30(int i, int j, int k, Component class5, int l, int i1, int j1) {
        try {
            if (class5.anInt107 != 0 || class5.anIntArray122 == null || class5.aBoolean121) {
                return;
            }
            if (k < i || i1 < l || k > i + class5.anInt110 || i1 > l + class5.anInt111) {
                return;
            }
            int k1 = class5.anIntArray122.length;
            if (j1 <= 0) {
                return;
            }
            for (int l1 = 0; l1 < k1; l1++) {
                int i2 = class5.anIntArray123[l1] + i;
                int j2 = (class5.anIntArray124[l1] + l) - j;
                Component class5_1 = Component.instances[class5.anIntArray122[l1]];
                i2 += class5_1.anInt113;
                j2 += class5_1.anInt114;
                if ((class5_1.anInt118 >= 0 || class5_1.anInt145 != 0) && k >= i2 && i1 >= j2
                        && k < i2 + class5_1.anInt110 && i1 < j2 + class5_1.anInt111) {
                    if (class5_1.anInt118 >= 0) {
                        anInt825 = class5_1.anInt118;
                    } else {
                        anInt825 = class5_1.anInt105;
                    }
                }
                if (class5_1.anInt107 == 0) {
                    method30(i2, class5_1.anInt120, k, class5_1, j2, i1, 792);
                    if (class5_1.anInt119 > class5_1.anInt111) {
                        method81(j2, k, class5_1, i2 + class5_1.anInt110, true, class5_1.anInt111, aByte830, i1,
                                class5_1.anInt119);
                    }
                } else {
                    if (class5_1.anInt108 == 1 && k >= i2 && i1 >= j2 && k < i2 + class5_1.anInt110
                            && i1 < j2 + class5_1.anInt111) {
                        boolean flag = false;
                        if (class5_1.anInt109 != 0) {
                            flag = method107(class5_1, true);
                        }
                        if (!flag) {
                            aStringArray897[menuSize] = class5_1.aString161;
                            menuAction[menuSize] = 231;
                            menuParamB[menuSize] = class5_1.anInt105;
                            menuSize++;
                        }
                    }
                    if (class5_1.anInt108 == 2 && anInt994 == 0 && k >= i2 && i1 >= j2 && k < i2 + class5_1.anInt110
                            && i1 < j2 + class5_1.anInt111) {
                        String s = class5_1.aString158;
                        if (s.indexOf(" ") != -1) {
                            s = s.substring(0, s.indexOf(" "));
                        }
                        aStringArray897[menuSize] = s + " @gre@" + class5_1.aString159;
                        menuAction[menuSize] = 274;
                        menuParamB[menuSize] = class5_1.anInt105;
                        menuSize++;
                    }
                    if (class5_1.anInt108 == 3 && k >= i2 && i1 >= j2 && k < i2 + class5_1.anInt110
                            && i1 < j2 + class5_1.anInt111) {
                        aStringArray897[menuSize] = "Close";
                        menuAction[menuSize] = 737;
                        menuParamB[menuSize] = class5_1.anInt105;
                        menuSize++;
                    }
                    if (class5_1.anInt108 == 4 && k >= i2 && i1 >= j2 && k < i2 + class5_1.anInt110
                            && i1 < j2 + class5_1.anInt111) {
                        aStringArray897[menuSize] = class5_1.aString161;
                        menuAction[menuSize] = 435;
                        menuParamB[menuSize] = class5_1.anInt105;
                        menuSize++;
                    }
                    if (class5_1.anInt108 == 5 && k >= i2 && i1 >= j2 && k < i2 + class5_1.anInt110
                            && i1 < j2 + class5_1.anInt111) {
                        aStringArray897[menuSize] = class5_1.aString161;
                        menuAction[menuSize] = 225;
                        menuParamB[menuSize] = class5_1.anInt105;
                        menuSize++;
                    }
                    if (class5_1.anInt108 == 6 && !aBoolean935 && k >= i2 && i1 >= j2 && k < i2 + class5_1.anInt110
                            && i1 < j2 + class5_1.anInt111) {
                        aStringArray897[menuSize] = class5_1.aString161;
                        menuAction[menuSize] = 997;
                        menuParamB[menuSize] = class5_1.anInt105;
                        menuSize++;
                    }
                    if (class5_1.anInt107 == 2) {
                        int k2 = 0;
                        for (int l2 = 0; l2 < class5_1.anInt111; l2++) {
                            for (int i3 = 0; i3 < class5_1.anInt110; i3++) {
                                int j3 = i2 + i3 * (32 + class5_1.anInt131);
                                int k3 = j2 + l2 * (32 + class5_1.anInt132);
                                if (k2 < 20) {
                                    j3 += class5_1.anIntArray134[k2];
                                    k3 += class5_1.anIntArray135[k2];
                                }
                                if (k >= j3 && i1 >= k3 && k < j3 + 32 && i1 < k3 + 32) {
                                    anInt982 = k2;
                                    anInt983 = class5_1.anInt105;
                                    if (class5_1.containerItemId[k2] > 0) {
                                        ObjType class14 = ObjType
                                                .method220(class5_1.containerItemId[k2] - 1);
                                        if (anInt952 == 1 && class5_1.aBoolean128) {
                                            if (class5_1.anInt105 != anInt954 || k2 != anInt953) {
                                                aStringArray897[menuSize] = "Use " + aString956 + " with @lre@"
                                                        + class14.aString331;
                                                menuAction[menuSize] = 398;
                                                menuParamC[menuSize] = class14.anInt329;
                                                menuParamA[menuSize] = k2;
                                                menuParamB[menuSize] = class5_1.anInt105;
                                                menuSize++;
                                            }
                                        } else if (anInt994 == 1 && class5_1.aBoolean128) {
                                            if ((anInt996 & 0x10) == 16) {
                                                aStringArray897[menuSize] = aString997 + " @lre@" + class14.aString331;
                                                menuAction[menuSize] = 563;
                                                menuParamC[menuSize] = class14.anInt329;
                                                menuParamA[menuSize] = k2;
                                                menuParamB[menuSize] = class5_1.anInt105;
                                                menuSize++;
                                            }
                                        } else {
                                            if (class5_1.aBoolean128) {
                                                for (int l3 = 4; l3 >= 3; l3--) {
                                                    if (class14.aStringArray346 != null
                                                            && class14.aStringArray346[l3] != null) {
                                                        aStringArray897[menuSize] = class14.aStringArray346[l3]
                                                                + " @lre@" + class14.aString331;
                                                        if (l3 == 3) {
                                                            menuAction[menuSize] = 681;
                                                        }
                                                        if (l3 == 4) {
                                                            menuAction[menuSize] = 100;
                                                        }
                                                        menuParamC[menuSize] = class14.anInt329;
                                                        menuParamA[menuSize] = k2;
                                                        menuParamB[menuSize] = class5_1.anInt105;
                                                        menuSize++;
                                                    } else if (l3 == 4) {
                                                        aStringArray897[menuSize] = "Drop @lre@" + class14.aString331;
                                                        menuAction[menuSize] = 100;
                                                        menuParamC[menuSize] = class14.anInt329;
                                                        menuParamA[menuSize] = k2;
                                                        menuParamB[menuSize] = class5_1.anInt105;
                                                        menuSize++;
                                                    }
                                                }
                                            }
                                            if (class5_1.aBoolean129) {
                                                aStringArray897[menuSize] = "Use @lre@" + class14.aString331;
                                                menuAction[menuSize] = 102;
                                                menuParamC[menuSize] = class14.anInt329;
                                                menuParamA[menuSize] = k2;
                                                menuParamB[menuSize] = class5_1.anInt105;
                                                menuSize++;
                                            }
                                            if (class5_1.aBoolean128 && class14.aStringArray346 != null) {
                                                for (int i4 = 2; i4 >= 0; i4--) {
                                                    if (class14.aStringArray346[i4] != null) {
                                                        aStringArray897[menuSize] = class14.aStringArray346[i4]
                                                                + " @lre@" + class14.aString331;
                                                        if (i4 == 0) {
                                                            menuAction[menuSize] = 694;
                                                        }
                                                        if (i4 == 1) {
                                                            menuAction[menuSize] = 962;
                                                        }
                                                        if (i4 == 2) {
                                                            menuAction[menuSize] = 795;
                                                        }
                                                        menuParamC[menuSize] = class14.anInt329;
                                                        menuParamA[menuSize] = k2;
                                                        menuParamB[menuSize] = class5_1.anInt105;
                                                        menuSize++;
                                                    }
                                                }
                                            }
                                            if (class5_1.aStringArray136 != null) {
                                                for (int j4 = 4; j4 >= 0; j4--) {
                                                    if (class5_1.aStringArray136[j4] != null) {
                                                        aStringArray897[menuSize] = class5_1.aStringArray136[j4]
                                                                + " @lre@" + class14.aString331;
                                                        if (j4 == 0) {
                                                            menuAction[menuSize] = 582;
                                                        }
                                                        if (j4 == 1) {
                                                            menuAction[menuSize] = 113;
                                                        }
                                                        if (j4 == 2) {
                                                            menuAction[menuSize] = 555;
                                                        }
                                                        if (j4 == 3) {
                                                            menuAction[menuSize] = 331;
                                                        }
                                                        if (j4 == 4) {
                                                            menuAction[menuSize] = 354;
                                                        }
                                                        menuParamC[menuSize] = class14.anInt329;
                                                        menuParamA[menuSize] = k2;
                                                        menuParamB[menuSize] = class5_1.anInt105;
                                                        menuSize++;
                                                    }
                                                }
                                            }
                                            aStringArray897[menuSize] = "Examine @lre@" + class14.aString331;
                                            menuAction[menuSize] = 1328;
                                            menuParamC[menuSize] = class14.anInt329;
                                            menuParamA[menuSize] = k2;
                                            menuParamB[menuSize] = class5_1.anInt105;
                                            menuSize++;
                                        }
                                    }
                                }
                                k2++;
                            }
                        }
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("12590, " + i + ", " + j + ", " + k + ", " + class5 + ", " + l + ", " + i1 + ", " + j1
                    + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method31(boolean flag) {
        try {
            ingame &= flag;
            if (connection == null) {
                return false;
            }
            try {
                int i = connection.method193();
                if (i == 0) {
                    return false;
                }
                if (packetType == -1) {
                    connection.read(in.payload, 0, 1);
                    packetType = in.payload[0] & 0xff;
                    if (encryption != null) {
                        packetType = packetType - encryption.method545() & 0xff;
                    }
                    packetSize = PacketConstants.PACKET_SIZES[packetType];
                    i--;
                }
                if (packetSize == -1) {
                    if (i > 0) {
                        connection.read(in.payload, 0, 1);
                        packetSize = in.payload[0] & 0xff;
                        i--;
                    } else {
                        return false;
                    }
                }
                if (packetSize == -2) {
                    if (i > 1) {
                        connection.read(in.payload, 0, 2);
                        in.position = 0;
                        packetSize = in.readUnsignedShort();
                        i -= 2;
                    } else {
                        return false;
                    }
                }
                if (i < packetSize) {
                    return false;
                }
                in.position = 0;
                connection.read(in.payload, 0, packetSize);
                timeoutCounter = 0;
                thirdOpcode = secondOpcode;
                secondOpcode = firstOpcode;
                firstOpcode = packetType;
                if (packetType == 55) {
                    int j = in.readUnsignedShort();
                    int l9 = in.readUnsignedShort();
                    if (anInt1253 != -1) {
                        anInt1253 = -1;
                        redrawChatback = true;
                    }
                    if (aBoolean980) {
                        aBoolean980 = false;
                        redrawChatback = true;
                    }
                    anInt1199 = j;
                    anInt889 = l9;
                    redrawInvBack = true;
                    redrawSideicons = true;
                    aBoolean935 = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.CHAT_SETTINGS) {
                    publicChatSetting = in.readUnsignedByte();
                    privateChatSetting = in.readUnsignedByte();
                    tradeChatSetting = in.readUnsignedByte();
                    redrawPrivacySettings = true;
                    redrawChatback = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.RUN_ENERGY) {
                    if (currentTab == 12) {
                        redrawInvBack = true;
                    }
                    playerEnergy = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.WEIGHT_CARRIED) {
                    if (currentTab == 12) {
                        redrawInvBack = true;
                    }
                    weightCarried = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == 59) {
                    int k = in.readUnsignedShort();
                    String s2 = in.readString();
                    Component.instances[k].aString141 = s2;
                    if (Component.instances[k].anInt106 == tabComponentId[currentTab]) {
                        redrawInvBack = true;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.RECEIVE_DETAILS) {
                    localPlayerIndex = in.readUnsignedShort();
                    isMembers = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == 79) {
                    int l = in.readUnsignedShort();
                    int i10 = in.readUnsignedByte();
                    int i15 = in.readUnsignedByte();
                    Component class5_5 = Component.instances[l];
                    class5_5.anInt113 = i10;
                    class5_5.anInt114 = i15;
                    packetType = -1;
                    return true;
                }
                if (packetType == 252) {
                    int i1 = in.readUnsignedShort();
                    method104(i1, -44196);
                    if (anInt1253 != -1) {
                        anInt1253 = -1;
                        redrawChatback = true;
                    }
                    if (aBoolean980) {
                        aBoolean980 = false;
                        redrawChatback = true;
                    }
                    anInt889 = i1;
                    redrawInvBack = true;
                    redrawSideicons = true;
                    anInt1199 = -1;
                    aBoolean935 = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.DRAW_HEAD_ICON) {
                    hintIconType = in.readUnsignedByte();
                    if (hintIconType == 1) {
                        anInt901 = in.readUnsignedShort();
                    }
                    if (hintIconType >= 2 && hintIconType <= 6) {
                        if (hintIconType == 2) {
                            anInt1251 = 64;
                            anInt1252 = 64;
                        }
                        if (hintIconType == 3) {
                            anInt1251 = 0;
                            anInt1252 = 64;
                        }
                        if (hintIconType == 4) {
                            anInt1251 = 128;
                            anInt1252 = 64;
                        }
                        if (hintIconType == 5) {
                            anInt1251 = 64;
                            anInt1252 = 0;
                        }
                        if (hintIconType == 6) {
                            anInt1251 = 64;
                            anInt1252 = 128;
                        }
                        hintIconType = 2;
                        anInt1248 = in.readUnsignedShort();
                        anInt1249 = in.readUnsignedShort();
                        anInt1250 = in.readUnsignedByte();
                    }
                    if (hintIconType == 10) {
                        anInt909 = in.readUnsignedShort();
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 211) {
                    int j1 = in.readUnsignedShort();
                    int j10 = in.readUnsignedByte();
                    Component class5_3 = Component.instances[j1];
                    class5_3.anInt153 = j10;
                    if (j10 == -1) {
                        class5_3.anInt103 = 0;
                        class5_3.anInt104 = 0;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 136) {
                    anInt848 = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == 91 || packetType == 117 || packetType == 83 || packetType == 176 || packetType == 233
                        || packetType == 87 || packetType == 71 || packetType == 60 || packetType == 106
                        || packetType == 194 || packetType == 90) {
                    method67(in, -6563, packetType);
                    packetType = -1;
                    return true;
                }
                if (packetType == 28) {
                    int k1 = in.readUnsignedShort();
                    Component class5 = Component.instances[k1];
                    for (int j15 = 0; j15 < class5.containerItemId.length; j15++) {
                        class5.containerItemId[j15] = -1;
                        class5.containerItemId[j15] = 0;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 144) {
                    anInt1037 = in.readUnsignedByte();
                    anInt1038 = in.readUnsignedByte();
                    for (int l1 = anInt1037; l1 < anInt1037 + 8; l1++) {
                        for (int k10 = anInt1038; k10 < anInt1038 + 8; k10++) {
                            if (planeObjStacks[plane][l1][k10] != null) {
                                planeObjStacks[plane][l1][k10] = null;
                                method92(l1, k10);
                            }
                        }
                    }
                    for (SceneLocTemporary class44_sub1 = (SceneLocTemporary) listTemporaryLocs.peekFront(); class44_sub1 != null; class44_sub1 = (SceneLocTemporary) listTemporaryLocs
                            .prev(false)) {
                        if (class44_sub1.sceneTileX >= anInt1037 && class44_sub1.sceneTileX < anInt1037 + 8
                                && class44_sub1.sceneTileZ >= anInt1038 && class44_sub1.sceneTileZ < anInt1038 + 8
                                && class44_sub1.anInt1323 == plane) {
                            class44_sub1.anInt1334 = 0;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 154) {
                    redrawInvBack = true;
                    int i2 = in.readUnsignedByte();
                    int l10 = in.readInt();
                    int k15 = in.readUnsignedByte();
                    anIntArray851[i2] = l10;
                    anIntArray1035[i2] = k15;
                    anIntArray1090[i2] = 1;
                    for (int k18 = 0; k18 < 98; k18++) {
                        if (l10 >= Game.levelExperience[k18]) {
                            anIntArray1090[i2] = k18 + 2;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 181) {
                    anInt833 = in.readUnsignedByte();
                    if (anInt833 == currentTab) {
                        if (anInt833 == 3) {
                            currentTab = 1;
                        } else {
                            currentTab = 3;
                        }
                        redrawInvBack = true;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 73) {
                    cutsceneActive = true;
                    anInt1118 = in.readUnsignedByte();
                    anInt1119 = in.readUnsignedByte();
                    anInt1120 = in.readUnsignedShort();
                    anInt1121 = in.readUnsignedByte();
                    anInt1122 = in.readUnsignedByte();
                    if (anInt1122 >= 100) {
                        cameraPositionX = anInt1118 * 128 + 64;
                        cameraPositionZ = anInt1119 * 128 + 64;
                        cameraPositionY = getFloorDrawHeight(false, cameraPositionZ, cameraPositionX, plane) - anInt1120;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 188) {
                    method57(packetSize, in);
                    loadingMap = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == 244) {
                    int j2 = in.readUnsignedShort();
                    int i11 = in.readUnsignedShort();
                    Component.instances[j2].modelType = 2;
                    Component.instances[j2].modelTypeId = i11;
                    packetType = -1;
                    return true;
                }
                if (packetType == 121) {
                    method22((byte) 25);
                    packetType = -1;
                    return false;
                }
                if (packetType == 119) {
                    int k2 = in.readUnsignedShort();
                    method104(k2, -44196);
                    if (anInt889 != -1) {
                        anInt889 = -1;
                        redrawInvBack = true;
                        redrawSideicons = true;
                    }
                    if (anInt1253 != -1) {
                        anInt1253 = -1;
                        redrawChatback = true;
                    }
                    if (aBoolean980) {
                        aBoolean980 = false;
                        redrawChatback = true;
                    }
                    anInt1199 = k2;
                    aBoolean935 = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == 168) {
                    long l2 = in.readLong(true);
                    int l15 = in.readUnsignedByte();
                    String s7 = TextUtils.method554(TextUtils.method551(l2, true), true);
                    for (int i21 = 0; i21 < anInt1104; i21++) {
                        if (l2 != aLongArray979[i21]) {
                            continue;
                        }
                        if (anIntArray894[i21] != l15) {
                            anIntArray894[i21] = l15;
                            redrawInvBack = true;
                            if (l15 > 0) {
                                renderText(5, (byte) -115, s7 + " has logged in.", "");
                            }
                            if (l15 == 0) {
                                renderText(5, (byte) -115, s7 + " has logged out.", "");
                            }
                        }
                        s7 = null;
                        break;
                    }
                    if (s7 != null && anInt1104 < 200) {
                        aLongArray979[anInt1104] = l2;
                        aStringArray1044[anInt1104] = s7;
                        anIntArray894[anInt1104] = l15;
                        anInt1104++;
                        redrawInvBack = true;
                    }
                    for (boolean flag6 = false; !flag6; ) {
                        flag6 = true;
                        for (int l24 = 0; l24 < anInt1104 - 1; l24++) {
                            if (anIntArray894[l24] != Game.nodeId && anIntArray894[l24 + 1] == Game.nodeId
                                    || anIntArray894[l24] == 0 && anIntArray894[l24 + 1] != 0) {
                                int i26 = anIntArray894[l24];
                                anIntArray894[l24] = anIntArray894[l24 + 1];
                                anIntArray894[l24 + 1] = i26;
                                String s10 = aStringArray1044[l24];
                                aStringArray1044[l24] = aStringArray1044[l24 + 1];
                                aStringArray1044[l24 + 1] = s10;
                                long l27 = aLongArray979[l24];
                                aLongArray979[l24] = aLongArray979[l24 + 1];
                                aLongArray979[l24 + 1] = l27;
                                redrawInvBack = true;
                                flag6 = false;
                            }
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 164) {
                    flagSceneTileX = 0;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.PRIVATE_MESSAGE) {
                    long name = in.readLong(true);
                    int messageId = in.readInt();
                    int playerRights = in.readUnsignedByte();
                    boolean flag2 = false;
                    for (int i23 = 0; i23 < 100; i23++) {
                        if (anIntArray1016[i23] != messageId) {
                            continue;
                        }
                        flag2 = true;
                        break;
                    }
                    if (playerRights <= 1) {
                        for (int i25 = 0; i25 < anInt957; i25++) {
                            if (aLongArray1254[i25] != name) {
                                continue;
                            }
                            flag2 = true;
                            break;
                        }
                    }
                    if (!flag2 && tutorial == 0) {
                        try {
                            anIntArray1016[anInt928] = messageId;
                            anInt928 = (anInt928 + 1) % 100;
                            String s8 = ChatCompression.method556((byte) -94, in, packetSize - 13);
                            s8 = ChatCensor.method352(s8, anInt1242);
                            if (playerRights == 2 || playerRights == 3) {
                                renderText(7, (byte) -115, s8,
                                        "@cr2@" + TextUtils.method554(TextUtils.method551(name, true), true));
                            } else if (playerRights == 1) {
                                renderText(7, (byte) -115, s8,
                                        "@cr1@" + TextUtils.method554(TextUtils.method551(name, true), true));
                            } else {
                                renderText(3, (byte) -115, s8, TextUtils.method554(TextUtils.method551(name, true), true));
                            }
                        } catch (Exception exception1) {
                            SignLink.reporterror("cde1");
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.CAMERA_SHAKE) {
                    int cameraId = in.readUnsignedByte();
                    int jitter = in.readUnsignedByte();
                    int amplitude = in.readUnsignedByte();
                    int frequency = in.readUnsignedByte();
                    aBooleanArray1209[cameraId] = true;
                    cameraJitter[cameraId] = jitter;
                    cameraAmplitude[cameraId] = amplitude;
                    cameraFrequency[cameraId] = frequency;
                    anIntArray1001[cameraId] = 0;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.UPDATE_ITEMS) {
                    redrawInvBack = true;
                    int id = in.readUnsignedShort();
                    Component component = Component.instances[id];
                    int itemCount = in.readUnsignedShort();
                    for (int slot = 0; slot < itemCount; slot++) {
                        component.containerItemId[slot] = in.readUnsignedShort();
                        int amount = in.readUnsignedByte();
                        if (amount == 255) {
                            amount = in.readInt();
                        }
                        component.containerItemAmount[slot] = amount;
                    }
                    for (int slot = itemCount; slot < component.containerItemId.length; slot++) {
                        component.containerItemId[slot] = 0;
                        component.containerItemAmount[slot] = 0;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 12) {
                    int k3 = in.readUnsignedByte();
                    anInt965 = k3;
                    redrawChatback = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.LOAD_MAP_REGION) {
                    int regionX = in.readUnsignedShort();
                    int regionZ = in.readUnsignedShort();
                    if (sceneCenterZoneX == regionX && sceneCenterZoneZ == regionZ && sceneState == 2) {
                        packetType = -1;
                        return true;
                    }
                    sceneCenterZoneX = regionX;
                    sceneCenterZoneZ = regionZ;
                    sceneBaseTileX = (sceneCenterZoneX - 6) * 8;
                    sceneBaseTileZ = (sceneCenterZoneZ - 6) * 8;
                    withinTutorialIsland = (sceneCenterZoneX / 8 == 48 || sceneCenterZoneX / 8 == 49) && sceneCenterZoneZ / 8 == 48;
                    if (sceneCenterZoneX / 8 == 48 && sceneCenterZoneZ / 8 == 148) {
                        withinTutorialIsland = true;
                    }
                    sceneState = 1;
                    sceneLoadStartTime = System.currentTimeMillis();
                    areaViewport.bind();
                    plainFont.drawStringCenter(257, "Loading - please wait.", -31546, 0, 151);
                    plainFont.drawStringCenter(256, "Loading - please wait.", -31546, 0xffffff, 150);
                    areaViewport.draw(super.graphics, 4, 4);
                    int mapCount = 0;
                    for (int x = (sceneCenterZoneX - 6) / 8; x <= (sceneCenterZoneX + 6) / 8; x++) {
                        for (int z = (sceneCenterZoneZ - 6) / 8; z <= (sceneCenterZoneZ + 6) / 8; z++) {
                            mapCount++;
                        }
                    }
                    sceneMapLandData = new byte[mapCount][];
                    sceneMapLocData = new byte[mapCount][];
                    sceneMapIndex = new int[mapCount];
                    sceneMapLandFile = new int[mapCount];
                    sceneMapLocFile = new int[mapCount];
                    mapCount = 0;
                    for (int mx = (sceneCenterZoneX - 6) / 8; mx <= (sceneCenterZoneX + 6) / 8; mx++) {
                        for (int mz = (sceneCenterZoneZ - 6) / 8; mz <= (sceneCenterZoneZ + 6) / 8; mz++) {
                            sceneMapIndex[mapCount] = (mx << 8) + mz;
                            if (withinTutorialIsland && (mz == 49 || mz == 149 || mz == 147 || mx == 50 || mx == 49 && mz == 47)) {
                                sceneMapLandFile[mapCount] = -1;
                                sceneMapLocFile[mapCount] = -1;
                                mapCount++;
                            } else {
                                int mapLandFile = sceneMapLandFile[mapCount] = ondemand.getMapFile(mz, -942, mx, 0);
                                if (mapLandFile != -1) {
                                    ondemand.request(3, mapLandFile);
                                }
                                int mapLocFile = sceneMapLocFile[mapCount] = ondemand.getMapFile(mz, -942, mx, 1);
                                if (mapLocFile != -1) {
                                    ondemand.request(3, mapLocFile);
                                }
                                mapCount++;
                            }
                        }
                    }
                    int dtx = sceneBaseTileX - scenePrevBaseTileX;
                    int dtz = sceneBaseTileZ - scenePrevBaseTileZ;
                    scenePrevBaseTileX = sceneBaseTileX;
                    scenePrevBaseTileZ = sceneBaseTileZ;
                    for (int index = 0; index < 16384; index++) {
                        NPCEntity npc = npcs[index];
                        if (npc != null) {
                            for (int j = 0; j < 10; j++) {
                                npc.pathTileX[j] -= dtx;
                                npc.pathTileZ[j] -= dtz;
                            }
                            npc.x -= dtx * 128;
                            npc.z -= dtz * 128;
                        }
                    }
                    for (int index = 0; index < MAX_PLAYER_COUNT; index++) {
                        PlayerEntity player = players[index];
                        if (player != null) {
                            for (int j27 = 0; j27 < 10; j27++) {
                                player.pathTileX[j27] -= dtx;
                                player.pathTileZ[j27] -= dtz;
                            }
                            player.x -= dtx * 128;
                            player.z -= dtz * 128;
                        }

                    }
                    loadingMap = true;
                    byte x0 = 0;
                    byte x1 = 104;
                    byte dirX = 1;
                    if (dtx < 0) {
                        x0 = 103;
                        x1 = -1;
                        dirX = -1;
                    }
                    byte z0 = 0;
                    byte z1 = 104;
                    byte dirZ = 1;
                    if (dtz < 0) {
                        z0 = 103;
                        z1 = -1;
                        dirZ = -1;
                    }
                    for (int x = x0; x != x1; x += dirX) {
                        for (int z = z0; z != z1; z += dirZ) {
                            int dstX = x + dtx;
                            int dstZ = z + dtz;
                            for (int plane = 0; plane < 4; plane++) {
                                if (dstX >= 0 && dstZ >= 0 && dstX < 104 && dstZ < 104) {
                                    planeObjStacks[plane][x][z] = planeObjStacks[plane][dstX][dstZ];
                                } else {
                                    planeObjStacks[plane][x][z] = null;
                                }
                            }
                        }
                    }
                    for (SceneLocTemporary loc = (SceneLocTemporary) listTemporaryLocs.peekFront(); loc != null; loc = (SceneLocTemporary) listTemporaryLocs
                            .prev(false)) {
                        loc.sceneTileX -= dtx;
                        loc.sceneTileZ -= dtz;
                        if (loc.sceneTileX < 0 || loc.sceneTileZ < 0
                                || loc.sceneTileX >= 104 || loc.sceneTileZ >= 104) {
                            loc.remove();
                        }
                    }
                    if (flagSceneTileX != 0) {
                        flagSceneTileX -= dtx;
                        flagSceneTileZ -= dtz;
                    }
                    cutsceneActive = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.INTERFACE_SIDEBAR) {
                    int j4 = in.readUnsignedShort();
                    int l11 = in.readUnsignedByte();
                    if (j4 == 65535) {
                        j4 = -1;
                    }
                    tabComponentId[l11] = j4;
                    redrawInvBack = true;
                    redrawSideicons = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == 184) {
                    int k4 = in.readUnsignedShort();
                    int i12 = in.readUnsignedShort();
                    Component class5_4 = Component.instances[k4];
                    if (class5_4 != null && class5_4.anInt107 == 0) {
                        if (i12 < 0) {
                            i12 = 0;
                        }
                        if (i12 > class5_4.anInt119 - class5_4.anInt111) {
                            i12 = class5_4.anInt119 - class5_4.anInt111;
                        }
                        class5_4.anInt120 = i12;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 204) {
                    systemUpdateTimer = in.readUnsignedShort() * 30;
                    packetType = -1;
                    return true;
                }
                if (packetType == 253) {
                    anInt1231 = in.readInt();
                    anInt947 = in.readUnsignedShort();
                    anInt869 = in.readUnsignedByte();
                    anInt1023 = in.readUnsignedShort();
                    anInt917 = in.readUnsignedByte();
                    if (anInt1231 != 0 && anInt1199 == -1) {
                        SignLink.dnslookup(TextUtils.method553(anInt1231, (byte) 1));
                        method28(3);
                        char c = '\u028A';
                        if (anInt869 != 201 || anInt917 == 1) {
                            c = '\u028F';
                        }
                        aString939 = "";
                        aBoolean987 = false;
                        for (int j12 = 0; j12 < Component.instances.length; j12++) {
                            if (Component.instances[j12] == null || Component.instances[j12].anInt109 != c) {
                                continue;
                            }
                            anInt1199 = Component.instances[j12].anInt106;
                            break;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.INTERFACE_PLAYERHEAD) {
                    int l4 = in.readUnsignedShort();
                    Component.instances[l4].modelType = 3;
                    if (Game.self.aClass12_1694 == null) {
                        Component.instances[l4].modelTypeId = (Game.self.anIntArray1677[0] << 24)
                                + (Game.self.anIntArray1677[4] << 18)
                                + (Game.self.anIntArray1676[0] << 12)
                                + (Game.self.anIntArray1676[8] << 6)
                                + Game.self.anIntArray1676[11];
                    } else {
                        Component.instances[l4].modelTypeId = (int) (0x12345678L + Game.self.aClass12_1694.uid);
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 23) {
                    if (anInt889 != -1) {
                        anInt889 = -1;
                        redrawInvBack = true;
                        redrawSideicons = true;
                    }
                    if (anInt1253 != -1) {
                        anInt1253 = -1;
                        redrawChatback = true;
                    }
                    if (aBoolean980) {
                        aBoolean980 = false;
                        redrawChatback = true;
                    }
                    anInt1199 = -1;
                    aBoolean935 = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.PLAYER_SET_ACTION) {
                    int i5 = in.readUnsignedByte();
                    int k12 = in.readUnsignedByte();
                    String s6 = in.readString();
                    if (i5 >= 1 && i5 <= 5) {
                        if (s6.equalsIgnoreCase("null")) {
                            s6 = null;
                        }
                        aStringArray919[i5 - 1] = s6;
                        aBooleanArray920[i5 - 1] = k12 == 0;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 189) {
                    currentTab = in.readUnsignedByte();
                    redrawInvBack = true;
                    redrawSideicons = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.SEND_MESSAGE) {
                    String s = in.readString();
                    if (s.endsWith(":tradereq:")) {
                        String s3 = s.substring(0, s.indexOf(":"));
                        long l17 = TextUtils.encodeBase37(s3);
                        boolean flag3 = false;
                        for (int l23 = 0; l23 < anInt957; l23++) {
                            if (aLongArray1254[l23] != l17) {
                                continue;
                            }
                            flag3 = true;
                            break;
                        }
                        if (!flag3 && tutorial == 0) {
                            renderText(4, (byte) -115, "wishes to trade with you.", s3);
                        }
                    } else if (s.endsWith(":duelreq:")) {
                        String s4 = s.substring(0, s.indexOf(":"));
                        long l18 = TextUtils.encodeBase37(s4);
                        boolean flag4 = false;
                        for (int i24 = 0; i24 < anInt957; i24++) {
                            if (aLongArray1254[i24] != l18) {
                                continue;
                            }
                            flag4 = true;
                            break;
                        }
                        if (!flag4 && tutorial == 0) {
                            renderText(8, (byte) -115, "wishes to duel with you.", s4);
                        }
                    } else if (s.endsWith(":chalreq:")) {
                        String s5 = s.substring(0, s.indexOf(":"));
                        long l19 = TextUtils.encodeBase37(s5);
                        boolean flag5 = false;
                        for (int j24 = 0; j24 < anInt957; j24++) {
                            if (aLongArray1254[j24] != l19) {
                                continue;
                            }
                            flag5 = true;
                            break;
                        }
                        if (!flag5 && tutorial == 0) {
                            String s9 = s.substring(s.indexOf(":") + 1, s.length() - 9);
                            renderText(8, (byte) -115, s9, s5);
                        }
                    } else {
                        renderText(0, (byte) -115, s, "");
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 18) {
                    int j5 = in.readUnsignedShort();
                    int l12 = in.readUnsignedShort();
                    int i17 = in.readUnsignedShort();
                    if (l12 == 65535) {
                        Component.instances[j5].modelType = 0;
                        packetType = -1;
                        return true;
                    } else {
                        ObjType class14 = ObjType.method220(l12);
                        Component.instances[j5].modelType = 4;
                        Component.instances[j5].modelTypeId = l12;
                        Component.instances[j5].anInt156 = class14.anInt336;
                        Component.instances[j5].anInt157 = class14.anInt337;
                        Component.instances[j5].anInt155 = (class14.anInt335 * 100) / i17;
                        packetType = -1;
                        return true;
                    }
                }
                if (packetType == 187) {
                    int k5 = in.readUnsignedShort();
                    if (k5 == 65535) {
                        k5 = -1;
                    }
                    if (k5 != anInt963 && aBoolean1057 && !Game.lowMemory && anInt942 == 0) {
                        anInt1190 = k5;
                        aBoolean1191 = true;
                        ondemand.request(2, anInt1190);
                    }
                    anInt963 = k5;
                    packetType = -1;
                    return true;
                }
                if (packetType == 29) {
                    int l5 = in.readUnsignedShort();
                    int i13 = in.readUnsignedShort();
                    if (aBoolean1057 && !Game.lowMemory) {
                        anInt1190 = l5;
                        aBoolean1191 = false;
                        ondemand.request(2, anInt1190);
                        anInt942 = i13;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 177) {
                    int i6 = in.readUnsignedShort();
                    int j13 = in.readUnsignedByte();
                    int j17 = in.readUnsignedShort();
                    if (aBoolean1050 && !Game.lowMemory && anInt968 < 50) {
                        anIntArray846[anInt968] = i6;
                        anIntArray1006[anInt968] = j13;
                        anIntArray1193[anInt968] = j17 + SoundTrack.anIntArray92[i6];
                        anInt968++;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 112) {
                    anInt1037 = in.readUnsignedByte();
                    anInt1038 = in.readUnsignedByte();
                    while (in.position < packetSize) {
                        int j6 = in.readUnsignedByte();
                        method67(in, -6563, j6);
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 172) {
                    for (int k6 = 0; k6 < anIntArray1214.length; k6++) {
                        if (anIntArray1214[k6] != anIntArray1024[k6]) {
                            anIntArray1214[k6] = anIntArray1024[k6];
                            method147(true, k6);
                            redrawInvBack = true;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 160) {
                    int l6 = in.readUnsignedShort();
                    int k13 = in.readUnsignedShort();
                    int k17 = k13 >> 10 & 0x1f;
                    int j20 = k13 >> 5 & 0x1f;
                    int j22 = k13 & 0x1f;
                    Component.instances[l6].anInt143 = (k17 << 19) + (j20 << 11) + (j22 << 3);
                    packetType = -1;
                    return true;
                }
                if (packetType == 47) {
                    anInt957 = packetSize / 8;
                    for (int i7 = 0; i7 < anInt957; i7++) {
                        aLongArray1254[i7] = in.readLong(true);
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 65) {
                    method105(true, packetSize, in);
                    packetType = -1;
                    return true;
                }
                if (packetType == 222) {
                    int j7 = in.readUnsignedShort();
                    int l13 = in.readUnsignedShort();
                    Component.instances[j7].modelType = 1;
                    Component.instances[j7].modelTypeId = l13;
                    packetType = -1;
                    return true;
                }
                if (packetType == 127) {
                    int k7 = in.readUnsignedByte();
                    if (k7 >= 0) {
                        method104(k7, -44196);
                    }
                    anInt924 = k7;
                    packetType = -1;
                    return true;
                }
                if (packetType == 75) {
                    int l7 = in.readUnsignedShort();
                    byte byte0 = in.readByte();
                    anIntArray1024[l7] = byte0;
                    if (anIntArray1214[l7] != byte0) {
                        anIntArray1214[l7] = byte0;
                        method147(true, l7);
                        redrawInvBack = true;
                        if (anInt965 != -1) {
                            redrawChatback = true;
                        }
                    }
                    packetType = -1;
                    return true;
                }

                if (packetType == 81) {
                    int j8 = in.readUnsignedShort();
                    method104(j8, -44196);
                    if (anInt889 != -1) {
                        anInt889 = -1;
                        redrawInvBack = true;
                        redrawSideicons = true;
                    }
                    anInt1253 = j8;
                    redrawChatback = true;
                    anInt1199 = -1;
                    aBoolean935 = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == 138) {
                    int k8 = in.readUnsignedShort();
                    boolean flag1 = in.readUnsignedByte() == 1;
                    Component.instances[k8].aBoolean121 = flag1;
                    packetType = -1;
                    return true;
                }
                if (packetType == 247) {
                    anInt1112 = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == 235) {
                    anInt1105 = in.readUnsignedByte();
                    redrawInvBack = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == 76) {
                    redrawInvBack = true;
                    int l8 = in.readUnsignedShort();
                    Component class5_2 = Component.instances[l8];
                    while (in.position < packetSize) {
                        int j18 = in.method496();
                        int l20 = in.readUnsignedShort();
                        int l22 = in.readUnsignedByte();
                        if (l22 == 255) {
                            l22 = in.readInt();
                        }
                        if (j18 >= 0 && j18 < class5_2.containerItemId.length) {
                            class5_2.containerItemId[j18] = l20;
                            class5_2.containerItemAmount[j18] = l22;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 201) {
                    for (int i9 = 0; i9 < players.length; i9++) {
                        if (players[i9] != null) {
                            players[i9].anInt1643 = -1;
                        }
                    }
                    for (int j14 = 0; j14 < npcs.length; j14++) {
                        if (npcs[j14] != null) {
                            npcs[j14].anInt1643 = -1;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 35) {
                    aBoolean1222 = false;
                    aBoolean980 = true;
                    aString1092 = "";
                    redrawChatback = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == 133) {
                    cutsceneActive = false;
                    for (int j9 = 0; j9 < 5; j9++) {
                        aBooleanArray1209[j9] = false;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 97) {
                    int k9 = in.readUnsignedShort();
                    int k14 = in.readInt();
                    anIntArray1024[k9] = k14;
                    if (anIntArray1214[k9] != k14) {
                        anIntArray1214[k9] = k14;
                        method147(true, k9);
                        redrawInvBack = true;
                        if (anInt965 != -1) {
                            redrawChatback = true;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 155) {
                    anInt1037 = in.readUnsignedByte();
                    anInt1038 = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                SignLink.reporterror("T1 - " + packetType + "," + packetSize + " - " + secondOpcode + "," + thirdOpcode);
                method22((byte) 25);
            } catch (IOException _ex) {
                method99((byte) 7);
            } catch (Exception exception) {
                exception.printStackTrace();
                String s1 = "T2 - " + packetType + "," + secondOpcode + "," + thirdOpcode + " - " + packetSize + ","
                        + (sceneBaseTileX + Game.self.pathTileX[0]) + ","
                        + (sceneBaseTileZ + Game.self.pathTileZ[0]) + " - ";
                for (int l14 = 0; l14 < packetSize && l14 < 50; l14++) {
                    s1 = s1 + in.payload[l14] + ",";
                }
                SignLink.reporterror(s1);
                method22((byte) 25);
            }
            return true;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("74182, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method32(String s) {
        System.out.println(s);
        try {
            getAppletContext().showDocument(new URL(getCodeBase(), "loaderror_" + s + ".html"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        do {
            try {
                Thread.sleep(1000L);
            } catch (Exception _ex) {
            }
        } while (true);
    }

    public void method33(byte byte0, byte[] abyte0, boolean flag) {
        try {
            if (byte0 != 27) {
                packetType = -1;
            }
            SignLink.midifade = flag ? 1 : 0;
            SignLink.midisave(abyte0, abyte0.length);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("89004, " + byte0 + ", " + abyte0 + ", " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public Socket method34(int i) throws IOException {
        if (SignLink.mainapp != null) {
            return SignLink.opensocket(i);
        } else {
            return new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        }
    }

    @Override
    public void method6() {
        method13(false, 20, "Starting up");
        if (SignLink.sunjava) {
            super.anInt7 = 5;
        }
        if (Game.aBoolean896) {
            aBoolean1236 = true;
            return;
        }
        Game.aBoolean896 = true;
        boolean flag = false;
        String s = "127.0.0.1";
        if (s.endsWith("jagex.com")) {
            flag = true;
        }
        if (s.endsWith("runescape.com")) {
            flag = true;
        }
        if (s.endsWith("192.168.1.2")) {
            flag = true;
        }
        if (s.endsWith("192.168.1.246")) {
            flag = true;
        }
        if (s.endsWith("192.168.1.247")) {
            flag = true;
        }
        if (s.endsWith("192.168.1.249")) {
            flag = true;
        }
        if (s.endsWith("192.168.1.253")) {
            flag = true;
        }
        if (s.endsWith("192.168.1.254")) {
            flag = true;
        }
        if (s.endsWith("192.168.1.242")) {
            flag = true;
        }
        if (s.endsWith("127.0.0.1")) {
            flag = true;
        }
        if (!flag) {
            aBoolean820 = true;
            return;
        }
        if (SignLink.cache_dat != null) {
            for (int i = 0; i < 5; i++) {
                aClass45Array1208[i] = new FileStore(SignLink.cache_dat, 0x7a120, SignLink.cache_idx[i], i + 1, (byte) 4);
            }
        }
        try {
            method27(Game.aByte949);
            aClass47_1117 = method125((byte) -9, "title screen", 1, "title", 25, archiveCRCs[1]);
            fontPlain = new TypeFace(9, "p11_full", false, aClass47_1117);
            plainFont = new TypeFace(9, "p12_full", false, aClass47_1117);
            fontBold = new TypeFace(9, "b12_full", false, aClass47_1117);
            aClass44_Sub3_Sub1_Sub4_1258 = new TypeFace(9, "q8_full", true, aClass47_1117);
            method68(0);
            method48(-532);
            FileArchive class47 = method125((byte) -9, "config", 2, "config", 30, archiveCRCs[2]);
            FileArchive class47_1 = method125((byte) -9, "interface", 3, "interface", 35, archiveCRCs[3]);
            FileArchive class47_2 = method125((byte) -9, "2d graphics", 4, "media", 40, archiveCRCs[4]);
            FileArchive class47_3 = method125((byte) -9, "textures", 6, "textures", 45, archiveCRCs[6]);
            FileArchive class47_4 = method125((byte) -9, "chat system", 7, "wordenc", 50, archiveCRCs[7]);
            FileArchive class47_5 = method125((byte) -9, "sound effects", 8, "sounds", 55, archiveCRCs[8]);
            planeTileFlags = new byte[4][104][104];
            anIntArrayArrayArray865 = new int[4][105][105];
            scene = new Scene(104, 4, anIntArrayArrayArray865, 104, Game.anInt1246);
            for (int j = 0; j < 4; j++) {
                aClass18Array1022[j] = new CollisionMap(99, 104, 104);
            }
            aClass44_Sub3_Sub1_Sub2_913 = new Image24(512, 512);
            FileArchive class47_6 = method125((byte) -9, "update list", 5, "versionlist", 60, archiveCRCs[5]);
            method13(false, 60, "Connecting to update server");
            ondemand = new OnDemandRequester();
            ondemand.method383(class47_6, this);
            SeqFrame.method207(ondemand.method386(7));
            Model.method503(ondemand.method385(0, (byte) 7), ondemand);
            if (!Game.lowMemory) {
                anInt1190 = 0;
                try {
                    anInt1190 = Integer.parseInt(getParameter("music"));
                } catch (Exception _ex) {
                }
                aBoolean1191 = true;
                ondemand.request(2, anInt1190);
                while (ondemand.method393() > 0) {
                    method93(false);
                    try {
                        Thread.sleep(100L);
                    } catch (Exception _ex) {
                    }
                    if (ondemand.anInt1313 > 3) {
                        method32("ondemand");
                        return;
                    }
                }
            }
            method13(false, 65, "Requesting animations");
            int k = ondemand.method385(1, (byte) 7);
            for (int i1 = 0; i1 < k; i1++) {
                ondemand.request(1, i1);
            }
            while (ondemand.method393() > 0) {
                int j1 = k - ondemand.method393();
                if (j1 > 0) {
                    method13(false, 65, "Loading animations - " + (j1 * 100) / k + "%");
                }
                method93(false);
                try {
                    Thread.sleep(100L);
                } catch (Exception _ex) {
                }
                if (ondemand.anInt1313 > 3) {
                    method32("ondemand");
                    return;
                }
            }
            method13(false, 70, "Requesting models");
            k = ondemand.method385(0, (byte) 7);
            for (int k1 = 0; k1 < k; k1++) {
                int l1 = ondemand.method390(k1, -600);
                if ((l1 & 1) != 0) {
                    ondemand.request(0, k1);
                }
            }
            k = ondemand.method393();
            while (ondemand.method393() > 0) {
                int i2 = k - ondemand.method393();
                if (i2 > 0) {
                    method13(false, 70, "Loading models - " + (i2 * 100) / k + "%");
                }
                method93(false);
                try {
                    Thread.sleep(100L);
                } catch (Exception _ex) {
                }
            }
            if (aClass45Array1208[0] != null) {
                method13(false, 75, "Requesting maps");
                ondemand.request(3, ondemand.getMapFile(48, -942, 47, 0));
                ondemand.request(3, ondemand.getMapFile(48, -942, 47, 1));
                ondemand.request(3, ondemand.getMapFile(48, -942, 48, 0));
                ondemand.request(3, ondemand.getMapFile(48, -942, 48, 1));
                ondemand.request(3, ondemand.getMapFile(48, -942, 49, 0));
                ondemand.request(3, ondemand.getMapFile(48, -942, 49, 1));
                ondemand.request(3, ondemand.getMapFile(47, -942, 47, 0));
                ondemand.request(3, ondemand.getMapFile(47, -942, 47, 1));
                ondemand.request(3, ondemand.getMapFile(47, -942, 48, 0));
                ondemand.request(3, ondemand.getMapFile(47, -942, 48, 1));
                ondemand.request(3, ondemand.getMapFile(148, -942, 48, 0));
                ondemand.request(3, ondemand.getMapFile(148, -942, 48, 1));
                k = ondemand.method393();
                while (ondemand.method393() > 0) {
                    int j2 = k - ondemand.method393();
                    if (j2 > 0) {
                        method13(false, 75, "Loading maps - " + (j2 * 100) / k + "%");
                    }
                    method93(false);
                    try {
                        Thread.sleep(100L);
                    } catch (Exception _ex) {
                    }
                }
            }
            k = ondemand.method385(0, (byte) 7);
            for (int k2 = 0; k2 < k; k2++) {
                int l2 = ondemand.method390(k2, -600);
                byte byte0 = 0;
                if ((l2 & 8) != 0) {
                    byte0 = 10;
                } else if ((l2 & 0x20) != 0) {
                    byte0 = 9;
                } else if ((l2 & 0x10) != 0) {
                    byte0 = 8;
                } else if ((l2 & 0x40) != 0) {
                    byte0 = 7;
                } else if ((l2 & 0x80) != 0) {
                    byte0 = 6;
                } else if ((l2 & 2) != 0) {
                    byte0 = 5;
                } else if ((l2 & 4) != 0) {
                    byte0 = 4;
                }
                if ((l2 & 1) != 0) {
                    byte0 = 3;
                }
                if (byte0 != 0) {
                    ondemand.method395(7, 0, byte0, k2);
                }
            }
            ondemand.method388(false, Game.membersWorld);
            if (!Game.lowMemory) {
                int l = ondemand.method385(2, (byte) 7);
                for (int i3 = 1; i3 < l; i3++) {
                    if (ondemand.method391(i3, 324)) {
                        ondemand.method395(7, 2, (byte) 1, i3);
                    }
                }
            }
            method13(false, 80, "Unpacking media");
            aClass44_Sub3_Sub1_Sub3_1143 = new Image8(class47_2, "invback", 0);
            aClass44_Sub3_Sub1_Sub3_1145 = new Image8(class47_2, "chatback", 0);
            aClass44_Sub3_Sub1_Sub3_1144 = new Image8(class47_2, "mapback", 0);
            aClass44_Sub3_Sub1_Sub3_903 = new Image8(class47_2, "backbase1", 0);
            aClass44_Sub3_Sub1_Sub3_904 = new Image8(class47_2, "backbase2", 0);
            aClass44_Sub3_Sub1_Sub3_905 = new Image8(class47_2, "backhmid1", 0);
            for (int j3 = 0; j3 < 13; j3++) {
                aClass44_Sub3_Sub1_Sub3Array1276[j3] = new Image8(class47_2, "sideicons", j3);
            }
            aClass44_Sub3_Sub1_Sub2_988 = new Image24(class47_2, "compass", 0);
            aClass44_Sub3_Sub1_Sub2_1261 = new Image24(class47_2, "mapedge", 0);
            try {
                for (int k3 = 0; k3 < 100; k3++) {
                    aClass44_Sub3_Sub1_Sub3Array1241[k3] = new Image8(class47_2, "mapscene", k3);
                }
            } catch (Exception _ex) {
            }
            try {
                for (int l3 = 0; l3 < 100; l3++) {
                    aClass44_Sub3_Sub1_Sub2Array1052[l3] = new Image24(class47_2, "mapfunction", l3);
                }
            } catch (Exception _ex) {
            }
            try {
                for (int i4 = 0; i4 < 20; i4++) {
                    aClass44_Sub3_Sub1_Sub2Array1108[i4] = new Image24(class47_2, "hitmarks", i4);
                }
            } catch (Exception _ex) {
            }
            try {
                for (int j4 = 0; j4 < 20; j4++) {
                    aClass44_Sub3_Sub1_Sub2Array1183[j4] = new Image24(class47_2, "headicons", j4);
                }
            } catch (Exception _ex) {
            }
            aClass44_Sub3_Sub1_Sub2_1210 = new Image24(class47_2, "mapmarker", 0);
            aClass44_Sub3_Sub1_Sub2_1211 = new Image24(class47_2, "mapmarker", 1);
            for (int k4 = 0; k4 < 8; k4++) {
                aClass44_Sub3_Sub1_Sub2Array867[k4] = new Image24(class47_2, "cross", k4);
            }
            aClass44_Sub3_Sub1_Sub2_1077 = new Image24(class47_2, "mapdots", 0);
            aClass44_Sub3_Sub1_Sub2_1078 = new Image24(class47_2, "mapdots", 1);
            aClass44_Sub3_Sub1_Sub2_1079 = new Image24(class47_2, "mapdots", 2);
            aClass44_Sub3_Sub1_Sub2_1080 = new Image24(class47_2, "mapdots", 3);
            aClass44_Sub3_Sub1_Sub3_1058 = new Image8(class47_2, "scrollbar", 0);
            aClass44_Sub3_Sub1_Sub3_1059 = new Image8(class47_2, "scrollbar", 1);
            aClass44_Sub3_Sub1_Sub3_1136 = new Image8(class47_2, "redstone1", 0);
            aClass44_Sub3_Sub1_Sub3_1137 = new Image8(class47_2, "redstone2", 0);
            aClass44_Sub3_Sub1_Sub3_1138 = new Image8(class47_2, "redstone3", 0);
            aClass44_Sub3_Sub1_Sub3_1139 = new Image8(class47_2, "redstone1", 0);
            aClass44_Sub3_Sub1_Sub3_1139.method450(6);
            aClass44_Sub3_Sub1_Sub3_1140 = new Image8(class47_2, "redstone2", 0);
            aClass44_Sub3_Sub1_Sub3_1140.method450(6);
            aClass44_Sub3_Sub1_Sub3_852 = new Image8(class47_2, "redstone1", 0);
            aClass44_Sub3_Sub1_Sub3_852.method451(35509);
            aClass44_Sub3_Sub1_Sub3_853 = new Image8(class47_2, "redstone2", 0);
            aClass44_Sub3_Sub1_Sub3_853.method451(35509);
            aClass44_Sub3_Sub1_Sub3_854 = new Image8(class47_2, "redstone3", 0);
            aClass44_Sub3_Sub1_Sub3_854.method451(35509);
            aClass44_Sub3_Sub1_Sub3_855 = new Image8(class47_2, "redstone1", 0);
            aClass44_Sub3_Sub1_Sub3_855.method450(6);
            aClass44_Sub3_Sub1_Sub3_855.method451(35509);
            aClass44_Sub3_Sub1_Sub3_856 = new Image8(class47_2, "redstone2", 0);
            aClass44_Sub3_Sub1_Sub3_856.method450(6);
            aClass44_Sub3_Sub1_Sub3_856.method451(35509);
            for (int l4 = 0; l4 < 2; l4++) {
                aClass44_Sub3_Sub1_Sub3Array836[l4] = new Image8(class47_2, "mod_icons", l4);
            }
            Image24 class44_sub3_sub1_sub2 = new Image24(class47_2, "backleft1", 0);
            aClass34_1123 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            class44_sub3_sub1_sub2 = new Image24(class47_2, "backleft2", 0);
            aClass34_1124 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            class44_sub3_sub1_sub2 = new Image24(class47_2, "backright1", 0);
            aClass34_1125 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            class44_sub3_sub1_sub2 = new Image24(class47_2, "backright2", 0);
            aClass34_1126 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            class44_sub3_sub1_sub2 = new Image24(class47_2, "backtop1", 0);
            aClass34_1127 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            class44_sub3_sub1_sub2 = new Image24(class47_2, "backvmid1", 0);
            aClass34_1128 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            class44_sub3_sub1_sub2 = new Image24(class47_2, "backvmid2", 0);
            aClass34_1129 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            class44_sub3_sub1_sub2 = new Image24(class47_2, "backvmid3", 0);
            aClass34_1130 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            class44_sub3_sub1_sub2 = new Image24(class47_2, "backhmid2", 0);
            aClass34_1131 = new DrawArea(class44_sub3_sub1_sub2.width,
                    class44_sub3_sub1_sub2.height);
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            int i5 = (int) (Math.random() * 21D) - 10;
            int j5 = (int) (Math.random() * 21D) - 10;
            int k5 = (int) (Math.random() * 21D) - 10;
            int l5 = (int) (Math.random() * 41D) - 20;
            for (int i6 = 0; i6 < 100; i6++) {
                if (aClass44_Sub3_Sub1_Sub2Array1052[i6] != null) {
                    aClass44_Sub3_Sub1_Sub2Array1052[i6].method436(i5 + l5, (byte) 3, j5 + l5, k5 + l5);
                }
                if (aClass44_Sub3_Sub1_Sub3Array1241[i6] != null) {
                    aClass44_Sub3_Sub1_Sub3Array1241[i6].method452(i5 + l5, (byte) 3, j5 + l5, k5 + l5);
                }
            }
            method13(false, 83, "Unpacking textures");
            Draw3D.method423(class47_3, Game.aBoolean1061);
            Draw3D.method427(0.80000000000000004D, 0);
            Draw3D.method422(1, 20);
            method13(false, 86, "Unpacking config");
            SeqType.method253(true, class47);
            LocType.method197(class47);
            FloType.method243(true, class47);
            ObjType.method218(class47);
            NpcType.method212(class47);
            IDKType.method247(true, class47);
            SpotAnimType.method269(true, class47);
            VarpType.method337(true, class47);
            VarBit.method275(true, class47);
            ObjType.aBoolean328 = Game.membersWorld;
            if (!Game.lowMemory) {
                try {
                    method13(false, 90, "Unpacking sounds");
                    byte[] abyte0 = class47_5.method549("sounds.dat", null);
                    Buffer class44_sub3_sub2 = new Buffer(abyte0);
                    SoundTrack.method175(true, class44_sub3_sub2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            method13(false, 95, "Unpacking interfaces");
            TypeFace[] aclass44_sub3_sub1_sub4 = {fontPlain, plainFont,
                    fontBold, aClass44_Sub3_Sub1_Sub4_1258};
            Component.method181(aclass44_sub3_sub1_sub4, class47_2, 0, class47_1);
            method13(false, 100, "Preparing game engine");
            for (int j6 = 0; j6 < 33; j6++) {
                int k6 = 999;
                int i7 = 0;
                for (int k7 = 0; k7 < 34; k7++) {
                    if (aClass44_Sub3_Sub1_Sub3_1144.aByteArray1458[k7 + j6 * aClass44_Sub3_Sub1_Sub3_1144.anInt1460] == 0) {
                        if (k6 == 999) {
                            k6 = k7;
                        }
                        continue;
                    }
                    if (k6 == 999) {
                        continue;
                    }
                    i7 = k7;
                    break;
                }
                anIntArray961[j6] = k6;
                anIntArray910[j6] = i7 - k6;
            }
            for (int l6 = 5; l6 < 156; l6++) {
                int j7 = 999;
                int l7 = 0;
                for (int j8 = 25; j8 < 172; j8++) {
                    if (aClass44_Sub3_Sub1_Sub3_1144.aByteArray1458[j8 + l6 * aClass44_Sub3_Sub1_Sub3_1144.anInt1460] == 0
                            && (j8 > 34 || l6 > 34)) {
                        if (j7 == 999) {
                            j7 = j8;
                        }
                        continue;
                    }
                    if (j7 == 999) {
                        continue;
                    }
                    l7 = j8;
                    break;
                }
                anIntArray881[l6 - 5] = j7 - 25;
                anIntArray868[l6 - 5] = l7 - j7;
            }
            Draw3D.method420(96, 479, 8);
            anIntArray914 = Draw3D.anIntArray1429;
            Draw3D.method420(261, 190, 8);
            anIntArray915 = Draw3D.anIntArray1429;
            Draw3D.method420(334, 512, 8);
            anIntArray916 = Draw3D.anIntArray1429;
            int[] ai = new int[9];
            for (int i8 = 0; i8 < 9; i8++) {
                int k8 = 128 + i8 * 32 + 15;
                int l8 = 600 + k8 * 3;
                int i9 = Draw3D.anIntArray1427[k8];
                ai[i8] = l8 * i9 >> 16;
            }
            Scene.method314(ai, 500, 334, 3, 800, 512);
            ChatCensor.method342(class47_4);
            mouseCapturer = new MouseCapturer(228, this);
            method12(mouseCapturer, 10);
            GameObject.aClient1481 = this;
            return;
        } catch (Exception exception) {
            SignLink.reporterror("loaderror " + aString926 + " " + anInt1176);
        }
        aBoolean1055 = true;
    }

    public void method35(boolean flag) {
        try {
            aBoolean893 = true;
            try {
                long l = System.currentTimeMillis();
                int i = 0;
                int j = 20;
                while (aBoolean1174) {
                    anInt945++;
                    method25(699);
                    method25(699);
                    method84(0);
                    if (++i > 10) {
                        long l1 = System.currentTimeMillis();
                        int k = (int) (l1 - l) / 10 - j;
                        j = 40 - k;
                        if (j < 5) {
                            j = 5;
                        }
                        i = 0;
                        l = l1;
                    }
                    try {
                        Thread.sleep(j);
                    } catch (Exception _ex) {
                    }
                }
            } catch (Exception _ex) {
            }
            aBoolean893 = false;
            if (flag) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("21026, " + flag + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method36(int i) {
        try {
            aClass34_1196.bind();
            if (anInt848 == 2) {
                byte[] abyte0 = aClass44_Sub3_Sub1_Sub3_1144.aByteArray1458;
                int[] ai = Draw2D.pixels;
                int l2 = abyte0.length;
                for (int j5 = 0; j5 < l2; j5++) {
                    if (abyte0[j5] == 0) {
                        ai[j5] = 0;
                    }
                }
                aClass44_Sub3_Sub1_Sub2_988.method444(anIntArray961, 0, 25, 256, cameraHorizontal, 33, anIntArray910, 33, -687,
                        25, 0);
                areaViewport.bind();
                return;
            }
            int j = cameraHorizontal + anInt959 & 0x7ff;
            int k = 48 + Game.self.x / 32;
            int i3 = 464 - Game.self.z / 32;
            aClass44_Sub3_Sub1_Sub2_913.method444(anIntArray881, 5, i3, 256 + anInt1075, j, 151, anIntArray868, 146,
                    -687, k, 25);
            aClass44_Sub3_Sub1_Sub2_988.method444(anIntArray961, 0, 25, 256, cameraHorizontal, 33, anIntArray910, 33, -687, 25,
                    0);
            for (int k5 = 0; k5 < anInt826; k5++) {
                int l = (anIntArray827[k5] * 4 + 2) - Game.self.x
                        / 32;
                int j3 = (anIntArray828[k5] * 4 + 2) - Game.self.z
                        / 32;
                method141(l, aClass44_Sub3_Sub1_Sub2Array872[k5], 139, j3);
            }
            for (int l5 = 0; l5 < 104; l5++) {
                for (int i6 = 0; i6 < 104; i6++) {
                    LinkedList class28 = planeObjStacks[plane][l5][i6];
                    if (class28 != null) {
                        int i1 = (l5 * 4 + 2) - Game.self.x / 32;
                        int k3 = (i6 * 4 + 2) - Game.self.z / 32;
                        method141(i1, aClass44_Sub3_Sub1_Sub2_1077, 139, k3);
                    }
                }
            }
            packetSize += i;
            for (int j6 = 0; j6 < anInt1009; j6++) {
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[anIntArray1010[j6]];
                if (class44_sub3_sub4_sub6_sub2 != null && class44_sub3_sub4_sub6_sub2.method535(true)
                        && class44_sub3_sub4_sub6_sub2.aClass12_1700.aBoolean298) {
                    int j1 = class44_sub3_sub4_sub6_sub2.x / 32
                            - Game.self.x / 32;
                    int l3 = class44_sub3_sub4_sub6_sub2.z / 32
                            - Game.self.z / 32;
                    method141(j1, aClass44_Sub3_Sub1_Sub2_1078, 139, l3);
                }
            }
            for (int k6 = 0; k6 < anInt1226; k6++) {
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[anIntArray1227[k6]];
                if (class44_sub3_sub4_sub6_sub1 != null && class44_sub3_sub4_sub6_sub1.method535(true)) {
                    int k1 = class44_sub3_sub4_sub6_sub1.x / 32
                            - Game.self.x / 32;
                    int i4 = class44_sub3_sub4_sub6_sub1.z / 32
                            - Game.self.z / 32;
                    boolean flag = false;
                    long l6 = TextUtils.encodeBase37(class44_sub3_sub4_sub6_sub1.aString1672);
                    for (int i7 = 0; i7 < anInt1104; i7++) {
                        if (l6 != aLongArray979[i7] || anIntArray894[i7] == 0) {
                            continue;
                        }
                        flag = true;
                        break;
                    }
                    if (Game.self.anInt1695 != 0
                            && class44_sub3_sub4_sub6_sub1.anInt1695 != 0) {
                        flag = Game.self.anInt1695 == class44_sub3_sub4_sub6_sub1.anInt1695;
                    }
                    if (flag) {
                        method141(k1, aClass44_Sub3_Sub1_Sub2_1080, 139, i4);
                    } else {
                        method141(k1, aClass44_Sub3_Sub1_Sub2_1079, 139, i4);
                    }
                }
            }
            if (hintIconType != 0 && Game.loopCycle % 20 < 10) {
                if (hintIconType == 1 && anInt901 >= 0 && anInt901 < npcs.length) {
                    NPCEntity class44_sub3_sub4_sub6_sub2_1 = npcs[anInt901];
                    if (class44_sub3_sub4_sub6_sub2_1 != null) {
                        int l1 = class44_sub3_sub4_sub6_sub2_1.x / 32
                                - Game.self.x / 32;
                        int j4 = class44_sub3_sub4_sub6_sub2_1.z / 32
                                - Game.self.z / 32;
                        method15(l1, aClass44_Sub3_Sub1_Sub2_1211, j4, anInt834);
                    }
                }
                if (hintIconType == 2) {
                    int i2 = ((anInt1248 - sceneBaseTileX) * 4 + 2)
                            - Game.self.x / 32;
                    int k4 = ((anInt1249 - sceneBaseTileZ) * 4 + 2)
                            - Game.self.z / 32;
                    method15(i2, aClass44_Sub3_Sub1_Sub2_1211, k4, anInt834);
                }
                if (hintIconType == 10 && anInt909 >= 0 && anInt909 < players.length) {
                    PlayerEntity class44_sub3_sub4_sub6_sub1_1 = players[anInt909];
                    if (class44_sub3_sub4_sub6_sub1_1 != null) {
                        int j2 = class44_sub3_sub4_sub6_sub1_1.x / 32
                                - Game.self.x / 32;
                        int l4 = class44_sub3_sub4_sub6_sub1_1.z / 32
                                - Game.self.z / 32;
                        method15(j2, aClass44_Sub3_Sub1_Sub2_1211, l4, anInt834);
                    }
                }
            }
            if (flagSceneTileX != 0) {
                int k2 = (flagSceneTileX * 4 + 2) - Game.self.x / 32;
                int i5 = (flagSceneTileZ * 4 + 2) - Game.self.z / 32;
                method141(k2, aClass44_Sub3_Sub1_Sub2_1210, 139, i5);
            }
            Draw2D.method411(0xffffff, 210, 78, 3, 97, 3);
            areaViewport.bind();
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("47037, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method37(int i, int j, int k, Component class5, int l) {
        try {
            if (class5.anInt107 != 0 || class5.anIntArray122 == null) {
                return;
            }
            if (class5.aBoolean121 && anInt999 != class5.anInt105 && anInt933 != class5.anInt105
                    && anInt1212 != class5.anInt105) {
                return;
            }
            int i1 = Draw2D.left;
            int j1 = Draw2D.top;
            int k1 = Draw2D.right;
            int l1 = Draw2D.bottom;
            Draw2D.setBounds(k + class5.anInt110, l + class5.anInt111, l, k);
            int i2 = class5.anIntArray122.length;
            for (int j2 = 0; j2 < i2; j2++) {
                int k2 = class5.anIntArray123[j2] + k;
                int l2 = (class5.anIntArray124[j2] + l) - j;
                Component class5_1 = Component.instances[class5.anIntArray122[j2]];
                k2 += class5_1.anInt113;
                l2 += class5_1.anInt114;
                if (class5_1.anInt109 > 0) {
                    method41(-338, class5_1);
                }
                if (class5_1.anInt107 == 0) {
                    if (class5_1.anInt120 > class5_1.anInt119 - class5_1.anInt111) {
                        class5_1.anInt120 = class5_1.anInt119 - class5_1.anInt111;
                    }
                    if (class5_1.anInt120 < 0) {
                        class5_1.anInt120 = 0;
                    }
                    method37(6, class5_1.anInt120, k2, class5_1, l2);
                    if (class5_1.anInt119 > class5_1.anInt111) {
                        method21(l2, k2 + class5_1.anInt110, class5_1.anInt120, class5_1.anInt119, class5_1.anInt111, 3);
                    }
                } else if (class5_1.anInt107 != 1) {
                    if (class5_1.anInt107 == 2) {
                        int i3 = 0;
                        for (int l3 = 0; l3 < class5_1.anInt111; l3++) {
                            for (int l4 = 0; l4 < class5_1.anInt110; l4++) {
                                int k5 = k2 + l4 * (32 + class5_1.anInt131);
                                int j6 = l2 + l3 * (32 + class5_1.anInt132);
                                if (i3 < 20) {
                                    k5 += class5_1.anIntArray134[i3];
                                    j6 += class5_1.anIntArray135[i3];
                                }
                                if (class5_1.containerItemId[i3] > 0) {
                                    int k6 = 0;
                                    int j7 = 0;
                                    int j9 = class5_1.containerItemId[i3] - 1;
                                    if (k5 > Draw2D.left - 32 && k5 < Draw2D.right
                                            && j6 > Draw2D.top - 32 && j6 < Draw2D.bottom
                                            || anInt1095 != 0 && anInt1094 == i3) {
                                        int l9 = 0;
                                        if (anInt952 == 1 && anInt953 == i3 && anInt954 == class5_1.anInt105) {
                                            l9 = 0xffffff;
                                        }
                                        Image24 class44_sub3_sub1_sub2_2 = ObjType.method226(54, j9, l9,
                                                class5_1.containerItemAmount[i3]);
                                        if (class44_sub3_sub1_sub2_2 != null) {
                                            if (anInt1095 != 0 && anInt1094 == i3 && anInt1093 == class5_1.anInt105) {
                                                k6 = super.anInt21 - anInt1096;
                                                j7 = super.anInt22 - anInt1097;
                                                if (k6 < 5 && k6 > -5) {
                                                    k6 = 0;
                                                }
                                                if (j7 < 5 && j7 > -5) {
                                                    j7 = 0;
                                                }
                                                if (anInt978 < 5) {
                                                    k6 = 0;
                                                    j7 = 0;
                                                }
                                                class44_sub3_sub1_sub2_2.method442(128, anInt902, j6 + j7, k5 + k6);
                                                if (j6 + j7 < Draw2D.top && class5.anInt120 > 0) {
                                                    int i10 = (anInt824 * (Draw2D.top - j6 - j7)) / 3;
                                                    if (i10 > anInt824 * 10) {
                                                        i10 = anInt824 * 10;
                                                    }
                                                    if (i10 > class5.anInt120) {
                                                        i10 = class5.anInt120;
                                                    }
                                                    class5.anInt120 -= i10;
                                                    anInt1097 += i10;
                                                }
                                                if (j6 + j7 + 32 > Draw2D.bottom
                                                        && class5.anInt120 < class5.anInt119 - class5.anInt111) {
                                                    int j10 = (anInt824 * ((j6 + j7 + 32) - Draw2D.bottom)) / 3;
                                                    if (j10 > anInt824 * 10) {
                                                        j10 = anInt824 * 10;
                                                    }
                                                    if (j10 > class5.anInt119 - class5.anInt111 - class5.anInt120) {
                                                        j10 = class5.anInt119 - class5.anInt111 - class5.anInt120;
                                                    }
                                                    class5.anInt120 += j10;
                                                    anInt1097 -= j10;
                                                }
                                            } else if (anInt1151 != 0 && anInt1150 == i3
                                                    && anInt1149 == class5_1.anInt105) {
                                                class44_sub3_sub1_sub2_2.method442(128, anInt902, j6, k5);
                                            } else {
                                                class44_sub3_sub1_sub2_2.method440(j6, aByte1213, k5);
                                            }
                                            if (class44_sub3_sub1_sub2_2.cropWidth == 33
                                                    || class5_1.containerItemAmount[i3] != 1) {
                                                int k10 = class5_1.containerItemAmount[i3];
                                                fontPlain.method459((byte) -104, 0,
                                                        Game.method100(k10, 656), k5 + 1 + k6, j6 + 10 + j7);
                                                fontPlain.method459((byte) -104, 0xffff00,
                                                        Game.method100(k10, 656), k5 + k6, j6 + 9 + j7);
                                            }
                                        }
                                    }
                                } else if (class5_1.aClass44_Sub3_Sub1_Sub2Array133 != null && i3 < 20) {
                                    Image24 class44_sub3_sub1_sub2_1 = class5_1.aClass44_Sub3_Sub1_Sub2Array133[i3];
                                    if (class44_sub3_sub1_sub2_1 != null) {
                                        class44_sub3_sub1_sub2_1.method440(j6, aByte1213, k5);
                                    }
                                }
                                i3++;
                            }
                        }
                    } else if (class5_1.anInt107 == 3) {
                        boolean flag = anInt1212 == class5_1.anInt105 || anInt933 == class5_1.anInt105
                                || anInt999 == class5_1.anInt105;
                        int j3;
                        if (method88(class5_1, 0)) {
                            j3 = class5_1.anInt144;
                            if (flag && class5_1.anInt146 != 0) {
                                j3 = class5_1.anInt146;
                            }
                        } else {
                            j3 = class5_1.anInt143;
                            if (flag && class5_1.anInt145 != 0) {
                                j3 = class5_1.anInt145;
                            }
                        }
                        if (class5_1.aByte112 == 0) {
                            if (class5_1.aBoolean137) {
                                Draw2D.method411(j3, 210, l2, class5_1.anInt111, k2, class5_1.anInt110);
                            } else {
                                Draw2D.method412(1, k2, class5_1.anInt110, j3, l2, class5_1.anInt111);
                            }
                        } else if (class5_1.aBoolean137) {
                            Draw2D.method410(l2, class5_1.anInt111, 256 - (class5_1.aByte112 & 0xff), j3,
                                    class5_1.anInt110, k2, false);
                        } else {
                            Draw2D.method413(class5_1.anInt111, j3, k2, class5_1.anInt110,
                                    256 - (class5_1.aByte112 & 0xff), l2, 0);
                        }
                    } else if (class5_1.anInt107 == 4) {
                        TypeFace class44_sub3_sub1_sub4 = class5_1.aClass44_Sub3_Sub1_Sub4_140;
                        String s = class5_1.aString141;
                        boolean flag1 = anInt1212 == class5_1.anInt105 || anInt933 == class5_1.anInt105
                                || anInt999 == class5_1.anInt105;
                        int i4;
                        if (method88(class5_1, 0)) {
                            i4 = class5_1.anInt144;
                            if (flag1 && class5_1.anInt146 != 0) {
                                i4 = class5_1.anInt146;
                            }
                            if (class5_1.aString142.length() > 0) {
                                s = class5_1.aString142;
                            }
                        } else {
                            i4 = class5_1.anInt143;
                            if (flag1 && class5_1.anInt145 != 0) {
                                i4 = class5_1.anInt145;
                            }
                        }
                        if (class5_1.anInt108 == 6 && aBoolean935) {
                            s = "Please wait...";
                            i4 = class5_1.anInt143;
                        }
                        if (Draw2D.width == 479) {
                            if (i4 == 0xffff00) {
                                i4 = 255;
                            }
                            if (i4 == 49152) {
                                i4 = 0xffffff;
                            }
                        }
                        for (int l6 = l2 + class44_sub3_sub1_sub4.anInt1478; s.length() > 0; l6 += class44_sub3_sub1_sub4.anInt1478) {
                            if (s.indexOf("%") != -1) {
                                do {
                                    int k7 = s.indexOf("%1");
                                    if (k7 == -1) {
                                        break;
                                    }
                                    s = s.substring(0, k7) + method72(method94(0, aByte1086, class5_1), false)
                                            + s.substring(k7 + 2);
                                } while (true);
                                do {
                                    int l7 = s.indexOf("%2");
                                    if (l7 == -1) {
                                        break;
                                    }
                                    s = s.substring(0, l7) + method72(method94(1, aByte1086, class5_1), false)
                                            + s.substring(l7 + 2);
                                } while (true);
                                do {
                                    int i8 = s.indexOf("%3");
                                    if (i8 == -1) {
                                        break;
                                    }
                                    s = s.substring(0, i8) + method72(method94(2, aByte1086, class5_1), false)
                                            + s.substring(i8 + 2);
                                } while (true);
                                do {
                                    int j8 = s.indexOf("%4");
                                    if (j8 == -1) {
                                        break;
                                    }
                                    s = s.substring(0, j8) + method72(method94(3, aByte1086, class5_1), false)
                                            + s.substring(j8 + 2);
                                } while (true);
                                do {
                                    int k8 = s.indexOf("%5");
                                    if (k8 == -1) {
                                        break;
                                    }
                                    s = s.substring(0, k8) + method72(method94(4, aByte1086, class5_1), false)
                                            + s.substring(k8 + 2);
                                } while (true);
                            }
                            int l8 = s.indexOf("\\n");
                            String s1;
                            if (l8 != -1) {
                                s1 = s.substring(0, l8);
                                s = s.substring(l8 + 2);
                            } else {
                                s1 = s;
                                s = "";
                            }
                            if (class5_1.aBoolean138) {
                                class44_sub3_sub1_sub4.drawStringCenter(class5_1.aBoolean139, i4, (byte) -85, k2
                                        + class5_1.anInt110 / 2, s1, l6);
                            } else {
                                class44_sub3_sub1_sub4.drawStringTaggable(i4, 2, l6, class5_1.aBoolean139, k2, s1);
                            }
                        }

                    } else if (class5_1.anInt107 == 5) {
                        Image24 class44_sub3_sub1_sub2;
                        if (method88(class5_1, 0)) {
                            class44_sub3_sub1_sub2 = class5_1.aClass44_Sub3_Sub1_Sub2_148;
                        } else {
                            class44_sub3_sub1_sub2 = class5_1.aClass44_Sub3_Sub1_Sub2_147;
                        }
                        if (class44_sub3_sub1_sub2 != null) {
                            class44_sub3_sub1_sub2.method440(l2, aByte1213, k2);
                        }
                    } else if (class5_1.anInt107 == 6) {
                        int k3 = Draw3D.anInt1423;
                        int j4 = Draw3D.anInt1424;
                        Draw3D.anInt1423 = k2 + class5_1.anInt110 / 2;
                        Draw3D.anInt1424 = l2 + class5_1.anInt111 / 2;
                        int i5 = Draw3D.anIntArray1427[class5_1.anInt156] * class5_1.anInt155 >> 16;
                        int l5 = Draw3D.anIntArray1428[class5_1.anInt156] * class5_1.anInt155 >> 16;
                        boolean flag2 = method88(class5_1, 0);
                        int i7;
                        if (flag2) {
                            i7 = class5_1.anInt154;
                        } else {
                            i7 = class5_1.anInt153;
                        }
                        Model class44_sub3_sub4_sub4;
                        if (i7 == -1) {
                            class44_sub3_sub4_sub4 = class5_1.method183(0, -1, -1, flag2);
                        } else {
                            SeqType class26 = SeqType.cache[i7];
                            class44_sub3_sub4_sub4 = class5_1.method183(0, class26.anIntArray511[class5_1.anInt103],
                                    class26.anIntArray510[class5_1.anInt103], flag2);
                        }
                        if (class44_sub3_sub4_sub4 != null) {
                            class44_sub3_sub4_sub4.method526(0, class5_1.anInt157, 0, class5_1.anInt156, 0, i5, l5);
                        }
                        Draw3D.anInt1423 = k3;
                        Draw3D.anInt1424 = j4;
                    } else if (class5_1.anInt107 == 7) {
                        TypeFace class44_sub3_sub1_sub4_1 = class5_1.aClass44_Sub3_Sub1_Sub4_140;
                        int k4 = 0;
                        for (int j5 = 0; j5 < class5_1.anInt111; j5++) {
                            for (int i6 = 0; i6 < class5_1.anInt110; i6++) {
                                if (class5_1.containerItemId[k4] > 0) {
                                    ObjType class14 = ObjType.method220(class5_1.containerItemId[k4] - 1);
                                    String s2 = class14.aString331;
                                    if (class14.aBoolean342 || class5_1.containerItemAmount[k4] != 1) {
                                        s2 = s2 + " x" + Game.method98(class5_1.containerItemAmount[k4], (byte) 5);
                                    }
                                    int i9 = k2 + i6 * (115 + class5_1.anInt131);
                                    int k9 = l2 + j5 * (12 + class5_1.anInt132);
                                    if (class5_1.aBoolean138) {
                                        class44_sub3_sub1_sub4_1.drawStringCenter(class5_1.aBoolean139, class5_1.anInt143,
                                                (byte) -85, i9 + class5_1.anInt110 / 2, s2, k9);
                                    } else {
                                        class44_sub3_sub1_sub4_1.drawStringTaggable(class5_1.anInt143, 2, k9,
                                                class5_1.aBoolean139, i9, s2);
                                    }
                                }
                                k4++;
                            }
                        }
                    }
                }
            }

            if (i < 6 || i > 6) {
                Game.aBoolean1061 = !Game.aBoolean1061;
            }
            Draw2D.setBounds(k1, l1, j1, i1);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("32464, " + i + ", " + j + ", " + k + ", " + class5 + ", " + l + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void loadingStages() {
        try {
            if (Game.lowMemory && sceneState == 2 && regionCached.plane != plane) {
                areaViewport.bind();
                plainFont.drawStringCenter(257, "Loading - please wait.", -31546, 0, 151);
                plainFont.drawStringCenter(256, "Loading - please wait.", -31546, 0xffffff, 150);
                areaViewport.draw(super.graphics, 4, 4);
                sceneState = 1;
                sceneLoadStartTime = System.currentTimeMillis();
            }
            if (sceneState == 1) {
                int successful = initializeRegionLoading(aByte1182);
                if (successful != 0 && System.currentTimeMillis() - sceneLoadStartTime > 0x57e40L) {
                    SignLink.reporterror(username + " glcfb " + serverSeed + "," + successful + "," + Game.lowMemory + ","
                            + aClass45Array1208[0] + "," + ondemand.method393() + "," + plane + ","
                            + sceneCenterZoneX + "," + sceneCenterZoneZ);
                    sceneLoadStartTime = System.currentTimeMillis();
                }
            }
            if (sceneState == 2 && plane != lastRegionId) {
                lastRegionId = plane;
                method40((byte) -89, plane);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("64388, " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public int initializeRegionLoading(byte byte0) {
        try {
            for (int i = 0; i < sceneMapLandData.length; i++) {
                if (sceneMapLandData[i] == null && sceneMapLandFile[i] != -1) {
                    return -1;
                }
                if (sceneMapLocData[i] == null && sceneMapLocFile[i] != -1) {
                    return -2;
                }
            }
            boolean regionsCached = true;
            for (int j = 0; j < sceneMapLandData.length; j++) {
                byte[] locs = sceneMapLocData[j];
                if (locs != null) {
                    int blockX = (sceneMapIndex[j] >> 8) * 64 - sceneBaseTileX;
                    int blockZ = (sceneMapIndex[j] & 0xff) * 64 - sceneBaseTileZ;
                    regionsCached &= regionCached.method159(576, blockZ, blockX, locs);
                }
            }
            if (!regionsCached) {
                return -3;
            }
            if (loadingMap) {
                return -4;
            }
            sceneState = 2;
            regionCached.plane = plane;
            method129(-17416);
            out.writePacket(214);
            if (byte0 == 2) {
                byte0 = 0;
            } else {
                Game.anInt1029 = 384;
            }
            return 0;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("76031, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method40(byte byte0, int i) {
        try {
            int[] ai = aClass44_Sub3_Sub1_Sub2_913.anIntArray1448;
            int j = ai.length;
            for (int k = 0; k < j; k++) {
                ai[k] = 0;
            }
            for (int l = 1; l < 103; l++) {
                int i1 = 24628 + (103 - l) * 512 * 4;
                for (int k1 = 1; k1 < 103; k1++) {
                    if ((planeTileFlags[i][k1][l] & 0x18) == 0) {
                        scene.method313(ai, i1, 512, i, k1, l);
                    }
                    if (i < 3 && (planeTileFlags[i + 1][k1][l] & 8) != 0) {
                        scene.method313(ai, i1, 512, i + 1, k1, l);
                    }
                    i1 += 4;
                }
            }
            int j1 = ((238 + (int) (Math.random() * 20D)) - 10 << 16) + ((238 + (int) (Math.random() * 20D)) - 10 << 8)
                    + ((238 + (int) (Math.random() * 20D)) - 10);
            int l1 = (238 + (int) (Math.random() * 20D)) - 10 << 16;
            aClass44_Sub3_Sub1_Sub2_913.method435((byte) 5);
            for (int i2 = 1; i2 < 103; i2++) {
                for (int j2 = 1; j2 < 103; j2++) {
                    if ((planeTileFlags[i][j2][i2] & 0x18) == 0) {
                        method86(j2, i2, j1, (byte) 5, i, l1);
                    }
                    if (i < 3 && (planeTileFlags[i + 1][j2][i2] & 8) != 0) {
                        method86(j2, i2, j1, (byte) 5, i + 1, l1);
                    }
                }
            }
            areaViewport.bind();
            anInt826 = 0;
            if (byte0 != -89) {
                Game.anInt1029 = encryption.method545();
            }
            for (int k2 = 0; k2 < 104; k2++) {
                for (int l2 = 0; l2 < 104; l2++) {
                    int i3 = scene.method307(plane, k2, l2);
                    if (i3 != 0) {
                        i3 = i3 >> 14 & 0x7fff;
                        int j3 = LocType.method199(i3).anInt235;
                        if (j3 >= 0) {
                            int k3 = k2;
                            int l3 = l2;
                            if (j3 != 22 && j3 != 29 && j3 != 34 && j3 != 36 && j3 != 46 && j3 != 47 && j3 != 48) {
                                byte byte1 = 104;
                                byte byte2 = 104;
                                int[][] ai1 = aClass18Array1022[plane].anIntArrayArray418;
                                for (int i4 = 0; i4 < 10; i4++) {
                                    int j4 = (int) (Math.random() * 4D);
                                    if (j4 == 0 && k3 > 0 && k3 > k2 - 3 && (ai1[k3 - 1][l3] & 0x280108) == 0) {
                                        k3--;
                                    }
                                    if (j4 == 1 && k3 < byte1 - 1 && k3 < k2 + 3 && (ai1[k3 + 1][l3] & 0x280180) == 0) {
                                        k3++;
                                    }
                                    if (j4 == 2 && l3 > 0 && l3 > l2 - 3 && (ai1[k3][l3 - 1] & 0x280102) == 0) {
                                        l3--;
                                    }
                                    if (j4 == 3 && l3 < byte2 - 1 && l3 < l2 + 3 && (ai1[k3][l3 + 1] & 0x280120) == 0) {
                                        l3++;
                                    }
                                }
                            }
                            aClass44_Sub3_Sub1_Sub2Array872[anInt826] = aClass44_Sub3_Sub1_Sub2Array1052[j3];
                            anIntArray827[anInt826] = k3;
                            anIntArray828[anInt826] = l3;
                            anInt826++;
                        }
                    }
                }
            }
            Game.anInt1204++;
            if (Game.anInt1204 > 112) {
                Game.anInt1204 = 0;
                out.writePacket(125);
                out.writeByte(50);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("89876, " + byte0 + ", " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method41(int i, Component class5) {
        try {
            if (i >= 0) {
                anInt1152 = encryption.method545();
            }
            int j = class5.anInt109;
            if (j >= 1 && j <= 100 || j >= 701 && j <= 800) {
                if (j == 1 && anInt1105 == 0) {
                    class5.aString141 = "Loading friend list";
                    class5.anInt108 = 0;
                    return;
                }
                if (j == 1 && anInt1105 == 1) {
                    class5.aString141 = "Connecting to friendserver";
                    class5.anInt108 = 0;
                    return;
                }
                if (j == 2 && anInt1105 != 2) {
                    class5.aString141 = "Please wait...";
                    class5.anInt108 = 0;
                    return;
                }
                int k = anInt1104;
                if (anInt1105 != 2) {
                    k = 0;
                }
                if (j > 700) {
                    j -= 601;
                } else {
                    j--;
                }
                if (j >= k) {
                    class5.aString141 = "";
                    class5.anInt108 = 0;
                    return;
                } else {
                    class5.aString141 = aStringArray1044[j];
                    class5.anInt108 = 1;
                    return;
                }
            }
            if (j >= 101 && j <= 200 || j >= 801 && j <= 900) {
                int l = anInt1104;
                if (anInt1105 != 2) {
                    l = 0;
                }
                if (j > 800) {
                    j -= 701;
                } else {
                    j -= 101;
                }
                if (j >= l) {
                    class5.aString141 = "";
                    class5.anInt108 = 0;
                    return;
                }
                if (anIntArray894[j] == 0) {
                    class5.aString141 = "@red@Offline";
                } else if (anIntArray894[j] == Game.nodeId) {
                    class5.aString141 = "@gre@World-" + (anIntArray894[j] - 9);
                } else {
                    class5.aString141 = "@yel@World-" + (anIntArray894[j] - 9);
                }
                class5.anInt108 = 1;
                return;
            }
            if (j == 203) {
                int i1 = anInt1104;
                if (anInt1105 != 2) {
                    i1 = 0;
                }
                class5.anInt119 = i1 * 15 + 20;
                if (class5.anInt119 <= class5.anInt111) {
                    class5.anInt119 = class5.anInt111 + 1;
                }
                return;
            }
            if (j >= 401 && j <= 500) {
                if ((j -= 401) == 0 && anInt1105 == 0) {
                    class5.aString141 = "Loading ignore list";
                    class5.anInt108 = 0;
                    return;
                }
                if (j == 1 && anInt1105 == 0) {
                    class5.aString141 = "Please wait...";
                    class5.anInt108 = 0;
                    return;
                }
                int j1 = anInt957;
                if (anInt1105 == 0) {
                    j1 = 0;
                }
                if (j >= j1) {
                    class5.aString141 = "";
                    class5.anInt108 = 0;
                    return;
                } else {
                    class5.aString141 = TextUtils.method554(TextUtils.method551(aLongArray1254[j], true), true);
                    class5.anInt108 = 1;
                    return;
                }
            }
            if (j == 503) {
                class5.anInt119 = anInt957 * 15 + 20;
                if (class5.anInt119 <= class5.anInt111) {
                    class5.anInt119 = class5.anInt111 + 1;
                }
                return;
            }
            if (j == 327) {
                class5.anInt156 = 150;
                class5.anInt157 = (int) (Math.sin(Game.loopCycle / 40D) * 256D) & 0x7ff;
                if (aBoolean812) {
                    for (int k1 = 0; k1 < 7; k1++) {
                        int l1 = anIntArray849[k1];
                        if (l1 >= 0 && !IDKType.cache[l1].method249(9)) {
                            return;
                        }
                    }
                    aBoolean812 = false;
                    Model[] aclass44_sub3_sub4_sub4 = new Model[7];
                    int i2 = 0;
                    for (int j2 = 0; j2 < 7; j2++) {
                        int k2 = anIntArray849[j2];
                        if (k2 >= 0) {
                            aclass44_sub3_sub4_sub4[i2++] = IDKType.cache[k2].method250(0);
                        }
                    }
                    Model class44_sub3_sub4_sub4 = new Model(aclass44_sub3_sub4_sub4, i2, -33019);
                    for (int l2 = 0; l2 < 5; l2++) {
                        if (anIntArray938[l2] != 0) {
                            class44_sub3_sub4_sub4.method520(Game.APPEARANCE_COLOURS[l2][0],
                                    Game.APPEARANCE_COLOURS[l2][anIntArray938[l2]]);
                            if (l2 == 1) {
                                class44_sub3_sub4_sub4.method520(Game.BEARD_COLOURS[0],
                                        Game.BEARD_COLOURS[anIntArray938[l2]]);
                            }
                        }
                    }
                    class44_sub3_sub4_sub4.method513((byte) 3);
                    class44_sub3_sub4_sub4
                            .method514(
                                    SeqType.cache[Game.self.anInt1620].anIntArray510[0],
                                    188);
                    class44_sub3_sub4_sub4.method523(64, 850, -30, -50, -30, true);
                    class5.modelType = 5;
                    class5.modelTypeId = 0;
                    Component.method185(5, class44_sub3_sub4_sub4, 9, 0);
                }
                return;
            }
            if (j == 324) {
                if (aClass44_Sub3_Sub1_Sub2_1025 == null) {
                    aClass44_Sub3_Sub1_Sub2_1025 = class5.aClass44_Sub3_Sub1_Sub2_147;
                    aClass44_Sub3_Sub1_Sub2_1026 = class5.aClass44_Sub3_Sub1_Sub2_148;
                }
                if (aBoolean1179) {
                    class5.aClass44_Sub3_Sub1_Sub2_147 = aClass44_Sub3_Sub1_Sub2_1026;
                    return;
                } else {
                    class5.aClass44_Sub3_Sub1_Sub2_147 = aClass44_Sub3_Sub1_Sub2_1025;
                    return;
                }
            }
            if (j == 325) {
                if (aClass44_Sub3_Sub1_Sub2_1025 == null) {
                    aClass44_Sub3_Sub1_Sub2_1025 = class5.aClass44_Sub3_Sub1_Sub2_147;
                    aClass44_Sub3_Sub1_Sub2_1026 = class5.aClass44_Sub3_Sub1_Sub2_148;
                }
                if (aBoolean1179) {
                    class5.aClass44_Sub3_Sub1_Sub2_147 = aClass44_Sub3_Sub1_Sub2_1025;
                    return;
                } else {
                    class5.aClass44_Sub3_Sub1_Sub2_147 = aClass44_Sub3_Sub1_Sub2_1026;
                    return;
                }
            }
            if (j == 600) {
                class5.aString141 = aString939;
                if (Game.loopCycle % 20 < 10) {
                    class5.aString141 += "|";
                    return;
                } else {
                    class5.aString141 += " ";
                    return;
                }
            }
            if (j == 613) {
                if (rights >= 1) {
                    if (aBoolean987) {
                        class5.anInt143 = 0xff0000;
                        class5.aString141 = "Moderator option: Mute player for 48 hours: <ON>";
                    } else {
                        class5.anInt143 = 0xffffff;
                        class5.aString141 = "Moderator option: Mute player for 48 hours: <OFF>";
                    }
                } else {
                    class5.aString141 = "";
                }
            }
            if (j == 650 || j == 655) {
                if (anInt1231 != 0) {
                    String s;
                    if (anInt947 == 0) {
                        s = "earlier today";
                    } else if (anInt947 == 1) {
                        s = "yesterday";
                    } else {
                        s = anInt947 + " days ago";
                    }
                    class5.aString141 = "You last logged in " + s + " from: " + SignLink.dns;
                } else {
                    class5.aString141 = "";
                }
            }
            if (j == 651) {
                if (anInt1023 == 0) {
                    class5.aString141 = "0 unread messages";
                    class5.anInt143 = 0xffff00;
                }
                if (anInt1023 == 1) {
                    class5.aString141 = "1 unread message";
                    class5.anInt143 = 65280;
                }
                if (anInt1023 > 1) {
                    class5.aString141 = anInt1023 + " unread messages";
                    class5.anInt143 = 65280;
                }
            }
            if (j == 652) {
                if (anInt869 == 201) {
                    if (anInt917 == 1) {
                        class5.aString141 = "@yel@This is a non-members world: @whi@Since you are a member we";
                    } else {
                        class5.aString141 = "";
                    }
                } else if (anInt869 == 200) {
                    class5.aString141 = "You have not yet set any password recovery questions.";
                } else {
                    String s1;
                    if (anInt869 == 0) {
                        s1 = "Earlier today";
                    } else if (anInt869 == 1) {
                        s1 = "Yesterday";
                    } else {
                        s1 = anInt869 + " days ago";
                    }
                    class5.aString141 = s1 + " you changed your recovery questions";
                }
            }
            if (j == 653) {
                if (anInt869 == 201) {
                    if (anInt917 == 1) {
                        class5.aString141 = "@whi@recommend you use a members world instead. You may use";
                    } else {
                        class5.aString141 = "";
                    }
                } else if (anInt869 == 200) {
                    class5.aString141 = "We strongly recommend you do so now to secure your account.";
                } else {
                    class5.aString141 = "If you do not remember making this change then cancel it immediately";
                }
            }
            if (j == 654) {
                if (anInt869 == 201) {
                    if (anInt917 == 1) {
                        class5.aString141 = "@whi@this world but member benefits are unavailable whilst here.";
                        return;
                    } else {
                        class5.aString141 = "";
                        return;
                    }
                }
                if (anInt869 == 200) {
                    class5.aString141 = "Do this from the 'account management' area on our front webpage";
                    return;
                } else {
                    class5.aString141 = "Do this from the 'account management' area on our front webpage";
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("89305, " + i + ", " + class5 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method42(byte byte0, int i, Buffer class44_sub3_sub2) {
        try {
            while (true) {
                if (class44_sub3_sub2.anInt1393 + 21 >= i * 8) {
                    break;
                }
                int j = class44_sub3_sub2.method493(14, false);
                if (j == 16383) {
                    break;
                }
                if (npcs[j] == null) {
                    npcs[j] = new NPCEntity();
                }
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[j];
                anIntArray1010[anInt1009++] = j;
                class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                class44_sub3_sub4_sub6_sub2.aClass12_1700 = NpcType.method214(class44_sub3_sub2.method493(11,
                        false));
                class44_sub3_sub4_sub6_sub2.anInt1619 = class44_sub3_sub4_sub6_sub2.aClass12_1700.aByte284;
                class44_sub3_sub4_sub6_sub2.anInt1663 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt306;
                class44_sub3_sub4_sub6_sub2.anInt1622 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt288;
                class44_sub3_sub4_sub6_sub2.anInt1623 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt289;
                class44_sub3_sub4_sub6_sub2.anInt1624 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt290;
                class44_sub3_sub4_sub6_sub2.anInt1625 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt291;
                class44_sub3_sub4_sub6_sub2.anInt1620 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt287;
                int k = class44_sub3_sub2.method493(5, false);
                if (k > 15) {
                    k -= 32;
                }
                int l = class44_sub3_sub2.method493(5, false);
                if (l > 15) {
                    l -= 32;
                }
                int i1 = class44_sub3_sub2.method493(1, false);
                class44_sub3_sub4_sub6_sub2.method532(
                        Game.self.pathTileX[0] + k, i1 == 1,
                        Game.self.pathTileZ[0] + l, aByte925);
                int j1 = class44_sub3_sub2.method493(1, false);
                if (j1 == 1) {
                    anIntArray1229[anInt1228++] = j;
                }
            }
            class44_sub3_sub2.method494((byte) 4);
            if (byte0 != -97) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("11026, " + byte0 + ", " + i + ", " + class44_sub3_sub2 + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    @Override
    public void method13(boolean flag, int i, String s) {
        try {
            anInt1176 = i;
            aString926 = s;
            resetTitleScreen();
            if (flag) {
                Game.aBoolean1061 = !Game.aBoolean1061;
            }
            if (aClass47_1117 == null) {
                super.method13(false, i, s);
                return;
            }
            title4.bind();
            char c = '\u0168';
            char c1 = '\310';
            byte byte0 = 20;
            fontBold.drawStringCenter(c / 2, "RuneScape is loading - please wait...", -31546, 0xffffff, c1
                    / 2 - 26 - byte0);
            int j = c1 / 2 - 18 - byte0;
            Draw2D.method412(1, c / 2 - 152, 304, 0x8c1111, j, 34);
            Draw2D.method412(1, c / 2 - 151, 302, 0, j + 1, 32);
            Draw2D.method411(0x8c1111, 210, j + 2, 30, c / 2 - 150, i * 3);
            Draw2D.method411(0, 210, j + 2, 30, (c / 2 - 150) + i * 3, 300 - i * 3);
            fontBold.drawStringCenter(c / 2, s, -31546, 0xffffff, (c1 / 2 + 5) - byte0);
            title4.draw(super.graphics, 202, 171);
            if (redrawTitleBackground) {
                redrawTitleBackground = false;
                if (!aBoolean1174) {
                    aClass34_1266.draw(super.graphics, 0, 0);
                    aClass34_1267.draw(super.graphics, 637, 0);
                }
                title2.draw(super.graphics, 128, 0);
                title3.draw(super.graphics, 202, 371);
                title5.draw(super.graphics, 0, 265);
                title6.draw(super.graphics, 562, 265);
                title7.draw(super.graphics, 128, 171);
                title8.draw(super.graphics, 562, 171);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("10134, " + flag + ", " + i + ", " + s + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void renderGameView(int i) {
        try {
            renderCycle++;
            renderPlayers(true, true);
            renderNPCs(false, true);
            renderPlayers(true, false);
            renderNPCs(false, false);
            renderProjectiles(aByte1098);
            method114(-249);
            if (!cutsceneActive) {
                int vertical = cameraVertical;
                if (secondaryCameraVertical / 256 > vertical) {
                    vertical = secondaryCameraVertical / 256;
                }
                if (aBooleanArray1209[4] && cameraAmplitude[4] + 128 > vertical) {
                    vertical = cameraAmplitude[4] + 128;
                }
                int horizontal = cameraHorizontal + cameraRandomisationA & 0x7ff;
                setCameraPosition(600 + vertical * 3, horizontal,getFloorDrawHeight(false, self.z, self.x, plane) - 50, currentCameraPositionV, currentCameraPositionH, vertical);
            }
            int k;
            if (!cutsceneActive) {
                k = method126();
            } else {
                k = method127((byte) 7);
            }
            int i1 = cameraPositionX;
            int j1 = cameraPositionY;
            int k1 = cameraPositionZ;
            int l1 = cameraVerticalRotation;
            int i2 = anInt879;
            for (int j2 = 0; j2 < 5; j2++) {
                if (aBooleanArray1209[j2]) {
                    int k2 = (int) ((Math.random() * (cameraJitter[j2] * 2 + 1) - cameraJitter[j2]) + Math
                            .sin(anIntArray1001[j2] * (cameraFrequency[j2] / 100D)) * cameraAmplitude[j2]);
                    if (j2 == 0) {
                        cameraPositionX += k2;
                    }
                    if (j2 == 1) {
                        cameraPositionY += k2;
                    }
                    if (j2 == 2) {
                        cameraPositionZ += k2;
                    }
                    if (j2 == 3) {
                        anInt879 = anInt879 + k2 & 0x7ff;
                    }
                    if (j2 == 4) {
                        cameraVerticalRotation += k2;
                        if (cameraVerticalRotation < 128) {
                            cameraVerticalRotation = 128;
                        }
                        if (cameraVerticalRotation > 383) {
                            cameraVerticalRotation = 383;
                        }
                    }
                }
            }
            int l2 = Draw3D.anInt1438;
            Model.aBoolean1593 = true;
            Model.anInt1596 = 0;
            if (i != 0) {
                return;
            } else {
                Model.anInt1594 = super.anInt21 - 4;
                Model.anInt1595 = super.anInt22 - 4;
                Draw2D.method409((byte) 127);
                scene.method317(cameraPositionX, 7, cameraVerticalRotation, cameraPositionZ, k, cameraPositionY, anInt879);
                scene.method292(true);
                method61(1);
                method136(anInt1019);
                method62(l2, (byte) -12);
                method16(-8033);
                areaViewport.draw(super.graphics, 4, 4);
                cameraPositionX = i1;
                cameraPositionY = j1;
                cameraPositionZ = k1;
                cameraVerticalRotation = l1;
                anInt879 = i2;
                return;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void method44(long l, int i) {
        try {
            if (i != 37517) {
                planeObjStacks = null;
            }
            if (l == 0L) {
                return;
            }
            for (int j = 0; j < anInt1104; j++) {
                if (aLongArray979[j] == l) {
                    anInt1104--;
                    redrawInvBack = true;
                    for (int k = j; k < anInt1104; k++) {
                        aStringArray1044[k] = aStringArray1044[k + 1];
                        anIntArray894[k] = anIntArray894[k + 1];
                        aLongArray979[k] = aLongArray979[k + 1];
                    }
                    out.writePacket(203);
                    out.method478(l, true);
                    return;
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("67342, " + l + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method45(int i) {
        try {
            while (i >= 0) {
                out.writeByte(139);
            }
            if (anInt1017 == 0) {
                return;
            }
            int j = 0;
            if (systemUpdateTimer != 0) {
                j = 1;
            }
            for (int k = 0; k < 100; k++) {
                if (chatMessages[k] != null) {
                    int l = anIntArray1002[k];
                    String s = aStringArray1003[k];
                    if (s != null && s.startsWith("@cr1@")) {
                        s = s.substring(5);
                    }
                    if (s != null && s.startsWith("@cr2@")) {
                        s = s.substring(5);
                    }
                    if ((l == 3 || l == 7) && (l == 7 || privateChatSetting == 0 || privateChatSetting == 1 && method80(s, 3))) {
                        int i1 = 329 - j * 13;
                        if (super.anInt21 > 4 && super.anInt22 - 4 > i1 - 10 && super.anInt22 - 4 <= i1 + 3) {
                            int j1 = plainFont.method457("From:  " + s + chatMessages[k], true) + 25;
                            if (j1 > 450) {
                                j1 = 450;
                            }
                            if (super.anInt21 < 4 + j1) {
                                if (rights >= 1) {
                                    aStringArray897[menuSize] = "Report abuse @whi@" + s;
                                    menuAction[menuSize] = 2524;
                                    menuSize++;
                                }
                                aStringArray897[menuSize] = "Add ignore @whi@" + s;
                                menuAction[menuSize] = 2047;
                                menuSize++;
                                aStringArray897[menuSize] = "Add friend @whi@" + s;
                                menuAction[menuSize] = 2605;
                                menuSize++;
                            }
                        }
                        if (++j >= 5) {
                            return;
                        }
                    }
                    if ((l == 5 || l == 6) && privateChatSetting < 2 && ++j >= 5) {
                        return;
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("41007, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public String getParameter(String s) {
        if (SignLink.mainapp != null) {
            return SignLink.mainapp.getParameter(s);
        } else {
            return super.getParameter(s);
        }
    }

    public void method46(int i, byte byte0, Buffer class44_sub3_sub2, int j, PlayerEntity class44_sub3_sub4_sub6_sub1) {
        try {
            if (byte0 != -106) {
                for (int k = 1; k > 0; k++) {
                }
            }
            if ((i & 1) == 1) {
                int l = class44_sub3_sub2.readUnsignedByte();
                byte[] abyte0 = new byte[l];
                Buffer class44_sub3_sub2_1 = new Buffer(abyte0);
                class44_sub3_sub2.method491((byte) 95, abyte0, 0, l);
                aClass44_Sub3_Sub2Array1230[j] = class44_sub3_sub2_1;
                class44_sub3_sub4_sub6_sub1.method537(false, class44_sub3_sub2_1);
            }
            if ((i & 2) == 2) {
                int i1 = class44_sub3_sub2.readUnsignedShort();
                if (i1 == 65535) {
                    i1 = -1;
                }
                if (i1 == class44_sub3_sub4_sub6_sub1.anInt1643) {
                    class44_sub3_sub4_sub6_sub1.anInt1647 = 0;
                }
                int j2 = class44_sub3_sub2.readUnsignedByte();
                if (i1 == class44_sub3_sub4_sub6_sub1.anInt1643 && i1 != -1) {
                    int j3 = SeqType.cache[i1].anInt522;
                    if (j3 == 1) {
                        class44_sub3_sub4_sub6_sub1.anInt1644 = 0;
                        class44_sub3_sub4_sub6_sub1.anInt1645 = 0;
                        class44_sub3_sub4_sub6_sub1.anInt1646 = j2;
                        class44_sub3_sub4_sub6_sub1.anInt1647 = 0;
                    }
                    if (j3 == 2) {
                        class44_sub3_sub4_sub6_sub1.anInt1647 = 0;
                    }
                } else if (i1 == -1
                        || class44_sub3_sub4_sub6_sub1.anInt1643 == -1
                        || SeqType.cache[i1].anInt516 >= SeqType.cache[class44_sub3_sub4_sub6_sub1.anInt1643].anInt516) {
                    class44_sub3_sub4_sub6_sub1.anInt1643 = i1;
                    class44_sub3_sub4_sub6_sub1.anInt1644 = 0;
                    class44_sub3_sub4_sub6_sub1.anInt1645 = 0;
                    class44_sub3_sub4_sub6_sub1.anInt1646 = j2;
                    class44_sub3_sub4_sub6_sub1.anInt1647 = 0;
                    class44_sub3_sub4_sub6_sub1.anInt1669 = class44_sub3_sub4_sub6_sub1.anInt1664;
                }
            }
            if ((i & 4) == 4) {
                class44_sub3_sub4_sub6_sub1.anInt1637 = class44_sub3_sub2.readUnsignedShort();
                if (class44_sub3_sub4_sub6_sub1.anInt1637 == 65535) {
                    class44_sub3_sub4_sub6_sub1.anInt1637 = -1;
                }
            }
            if ((i & 8) == 8) {
                class44_sub3_sub4_sub6_sub1.aString1627 = class44_sub3_sub2.readString();
                if (class44_sub3_sub4_sub6_sub1.aString1627.charAt(0) == '~') {
                    class44_sub3_sub4_sub6_sub1.aString1627 = class44_sub3_sub4_sub6_sub1.aString1627
                            .substring(1);
                    renderText(2, (byte) -115, class44_sub3_sub4_sub6_sub1.aString1627,
                            class44_sub3_sub4_sub6_sub1.aString1672);
                } else if (class44_sub3_sub4_sub6_sub1 == Game.self) {
                    renderText(2, (byte) -115, class44_sub3_sub4_sub6_sub1.aString1627,
                            class44_sub3_sub4_sub6_sub1.aString1672);
                }
                class44_sub3_sub4_sub6_sub1.anInt1629 = 0;
                class44_sub3_sub4_sub6_sub1.anInt1630 = 0;
                class44_sub3_sub4_sub6_sub1.anInt1628 = 150;
            }
            if ((i & 0x10) == 16) {
                int j1 = class44_sub3_sub2.readUnsignedByte();
                int k2 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.method536(k2, Game.loopCycle, j1, false);
                class44_sub3_sub4_sub6_sub1.anInt1634 = Game.loopCycle + 300;
                class44_sub3_sub4_sub6_sub1.anInt1635 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.anInt1636 = class44_sub3_sub2.readUnsignedByte();
            }
            if ((i & 0x20) == 32) {
                class44_sub3_sub4_sub6_sub1.anInt1638 = class44_sub3_sub2.readUnsignedShort();
                class44_sub3_sub4_sub6_sub1.anInt1639 = class44_sub3_sub2.readUnsignedShort();
            }
            if ((i & 0x40) == 64) {
                int k1 = class44_sub3_sub2.readUnsignedShort();
                int l2 = class44_sub3_sub2.readUnsignedByte();
                int k3 = class44_sub3_sub2.readUnsignedByte();
                int l3 = class44_sub3_sub2.position;
                if (class44_sub3_sub4_sub6_sub1.aString1672 != null && class44_sub3_sub4_sub6_sub1.aBoolean1673) {
                    long l4 = TextUtils.encodeBase37(class44_sub3_sub4_sub6_sub1.aString1672);
                    boolean flag = false;
                    if (l2 <= 1) {
                        for (int i4 = 0; i4 < anInt957; i4++) {
                            if (aLongArray1254[i4] != l4) {
                                continue;
                            }
                            flag = true;
                            break;
                        }
                    }
                    if (!flag && tutorial == 0) {
                        try {
                            String s = ChatCompression.method556((byte) -94, class44_sub3_sub2, k3);
                            s = ChatCensor.method352(s, anInt1242);
                            class44_sub3_sub4_sub6_sub1.aString1627 = s;
                            class44_sub3_sub4_sub6_sub1.anInt1629 = k1 >> 8;
                            class44_sub3_sub4_sub6_sub1.anInt1630 = k1 & 0xff;
                            class44_sub3_sub4_sub6_sub1.anInt1628 = 150;
                            if (l2 == 2 || l2 == 3) {
                                renderText(1, (byte) -115, s, "@cr2@" + class44_sub3_sub4_sub6_sub1.aString1672);
                            } else if (l2 == 1) {
                                renderText(1, (byte) -115, s, "@cr1@" + class44_sub3_sub4_sub6_sub1.aString1672);
                            } else {
                                renderText(2, (byte) -115, s, class44_sub3_sub4_sub6_sub1.aString1672);
                            }
                        } catch (Exception exception) {
                            SignLink.reporterror("cde2");
                        }
                    }
                }
                class44_sub3_sub2.position = l3 + k3;
            }
            if ((i & 0x100) == 256) {
                class44_sub3_sub4_sub6_sub1.anInt1648 = class44_sub3_sub2.readUnsignedShort();
                int l1 = class44_sub3_sub2.readInt();
                class44_sub3_sub4_sub6_sub1.anInt1652 = l1 >> 16;
                class44_sub3_sub4_sub6_sub1.anInt1651 = Game.loopCycle + (l1 & 0xffff);
                class44_sub3_sub4_sub6_sub1.anInt1649 = 0;
                class44_sub3_sub4_sub6_sub1.anInt1650 = 0;
                if (class44_sub3_sub4_sub6_sub1.anInt1651 > Game.loopCycle) {
                    class44_sub3_sub4_sub6_sub1.anInt1649 = -1;
                }
                if (class44_sub3_sub4_sub6_sub1.anInt1648 == 65535) {
                    class44_sub3_sub4_sub6_sub1.anInt1648 = -1;
                }
            }
            if ((i & 0x200) == 512) {
                class44_sub3_sub4_sub6_sub1.anInt1653 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.anInt1655 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.anInt1654 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.anInt1656 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.anInt1657 = class44_sub3_sub2.readUnsignedShort() + Game.loopCycle;
                class44_sub3_sub4_sub6_sub1.anInt1658 = class44_sub3_sub2.readUnsignedShort() + Game.loopCycle;
                class44_sub3_sub4_sub6_sub1.anInt1659 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.method534(false);
            }
            if ((i & 0x400) == 1024) {
                int i2 = class44_sub3_sub2.readUnsignedByte();
                int i3 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.method536(i3, Game.loopCycle, i2, false);
                class44_sub3_sub4_sub6_sub1.anInt1634 = Game.loopCycle + 300;
                class44_sub3_sub4_sub6_sub1.anInt1635 = class44_sub3_sub2.readUnsignedByte();
                class44_sub3_sub4_sub6_sub1.anInt1636 = class44_sub3_sub2.readUnsignedByte();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("71941, " + i + ", " + byte0 + ", " + class44_sub3_sub2 + ", " + j + ", "
                    + class44_sub3_sub4_sub6_sub1 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method47(int i) {
        try {
            if (i <= 0) {
                packetType = -1;
            }
            aClass34_1198.bind();
            Draw3D.anIntArray1429 = anIntArray914;
            aClass44_Sub3_Sub1_Sub3_1145.blit(0, 0);
            if (aBoolean1222) {
                fontBold.drawStringCenter(239, aString1102, -31546, 0, 40);
                fontBold.drawStringCenter(239, aString1007 + "*", -31546, 128, 60);
            } else if (aBoolean980) {
                fontBold.drawStringCenter(239, "Enter amount:", -31546, 0, 40);
                fontBold.drawStringCenter(239, aString1092 + "*", -31546, 128, 60);
            } else if (clickToContinueString != null) {
                fontBold.drawStringCenter(239, clickToContinueString, -31546, 0, 40);
                fontBold.drawStringCenter(239, "Click to continue", -31546, 128, 60);
            } else if (anInt1253 != -1) {
                method37(6, 0, 0, Component.instances[anInt1253], 0);
            } else if (anInt965 != -1) {
                method37(6, 0, 0, Component.instances[anInt965], 0);
            } else {
                TypeFace class44_sub3_sub1_sub4 = plainFont;
                int j = 0;
                Draw2D.setBounds(463, 77, 0, 0);
                for (int k = 0; k < 100; k++) {
                    if (chatMessages[k] != null) {
                        int l = anIntArray1002[k];
                        int i1 = (70 - j * 14) + anInt1103;
                        String s1 = aStringArray1003[k];
                        byte byte0 = 0;
                        if (s1 != null && s1.startsWith("@cr1@")) {
                            s1 = s1.substring(5);
                            byte0 = 1;
                        }
                        if (s1 != null && s1.startsWith("@cr2@")) {
                            s1 = s1.substring(5);
                            byte0 = 2;
                        }
                        if (l == 0) {
                            if (i1 > 0 && i1 < 110) {
                                class44_sub3_sub1_sub4.method459((byte) -104, 0, chatMessages[k], 4, i1);
                            }
                            j++;
                        }
                        if ((l == 1 || l == 2) && (l == 1 || publicChatSetting == 0 || publicChatSetting == 1 && method80(s1, 3))) {
                            if (i1 > 0 && i1 < 110) {
                                int j1 = 4;
                                if (byte0 == 1) {
                                    aClass44_Sub3_Sub1_Sub3Array836[0].blit(i1 - 12, j1);
                                    j1 += 14;
                                }
                                if (byte0 == 2) {
                                    aClass44_Sub3_Sub1_Sub3Array836[1].blit(i1 - 12, j1);
                                    j1 += 14;
                                }
                                class44_sub3_sub1_sub4.method459((byte) -104, 0, s1 + ":", j1, i1);
                                j1 += class44_sub3_sub1_sub4.method457(s1, true) + 8;
                                class44_sub3_sub1_sub4.method459((byte) -104, 255, chatMessages[k], j1, i1);
                            }
                            j++;
                        }
                        if ((l == 3 || l == 7) && anInt1017 == 0
                                && (l == 7 || privateChatSetting == 0 || privateChatSetting == 1 && method80(s1, 3))) {
                            if (i1 > 0 && i1 < 110) {
                                int k1 = 4;
                                class44_sub3_sub1_sub4.method459((byte) -104, 0, "From", k1, i1);
                                k1 += class44_sub3_sub1_sub4.method457("From ", true);
                                if (byte0 == 1) {
                                    aClass44_Sub3_Sub1_Sub3Array836[0].blit(i1 - 12, k1);
                                    k1 += 14;
                                }
                                if (byte0 == 2) {
                                    aClass44_Sub3_Sub1_Sub3Array836[1].blit(i1 - 12, k1);
                                    k1 += 14;
                                }
                                class44_sub3_sub1_sub4.method459((byte) -104, 0, s1 + ":", k1, i1);
                                k1 += class44_sub3_sub1_sub4.method457(s1, true) + 8;
                                class44_sub3_sub1_sub4.method459((byte) -104, 0x800000, chatMessages[k], k1, i1);
                            }
                            j++;
                        }
                        if (l == 4 && (tradeChatSetting == 0 || tradeChatSetting == 1 && method80(s1, 3))) {
                            if (i1 > 0 && i1 < 110) {
                                class44_sub3_sub1_sub4.method459((byte) -104, 0x800080, s1 + " " + chatMessages[k],
                                        4, i1);
                            }
                            j++;
                        }
                        if (l == 5 && anInt1017 == 0 && privateChatSetting < 2) {
                            if (i1 > 0 && i1 < 110) {
                                class44_sub3_sub1_sub4.method459((byte) -104, 0x800000, chatMessages[k], 4, i1);
                            }
                            j++;
                        }
                        if (l == 6 && anInt1017 == 0 && privateChatSetting < 2) {
                            if (i1 > 0 && i1 < 110) {
                                class44_sub3_sub1_sub4.method459((byte) -104, 0, "To " + s1 + ":", 4, i1);
                                class44_sub3_sub1_sub4.method459((byte) -104, 0x800000, chatMessages[k],
                                        12 + class44_sub3_sub1_sub4.method457("To " + s1, true), i1);
                            }
                            j++;
                        }
                        if (l == 8 && (tradeChatSetting == 0 || tradeChatSetting == 1 && method80(s1, 3))) {
                            if (i1 > 0 && i1 < 110) {
                                class44_sub3_sub1_sub4.method459((byte) -104, 0x7e3200, s1 + " " + chatMessages[k],
                                        4, i1);
                            }
                            j++;
                        }
                    }
                }
                Draw2D.resetBounds();
                anInt874 = j * 14 + 7;
                if (anInt874 < 78) {
                    anInt874 = 78;
                }
                method21(0, 463, anInt874 - anInt1103 - 77, anInt874, 77, 3);
                String s;
                if (Game.self != null
                        && Game.self.aString1672 != null) {
                    s = Game.self.aString1672;
                } else {
                    s = TextUtils.method554(username, true);
                }
                class44_sub3_sub1_sub4.method459((byte) -104, 0, s + ":", 4, 90);
                class44_sub3_sub1_sub4.method459((byte) -104, 255, aString1141 + "*",
                        6 + class44_sub3_sub1_sub4.method457(s + ": ", true), 90);
                Draw2D.method414(479, 0, 0, true, 77);
            }
            if (menuVisible && anInt1030 == 2) {
                method115(393);
            }
            aClass34_1198.draw(super.graphics, 17, 357);
            areaViewport.bind();
            Draw3D.anIntArray1429 = anIntArray916;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("21760, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method48(int i) {
        try {
            titleBox = new Image8(aClass47_1117, "titlebox", 0);
            titleButton = new Image8(aClass47_1117, "titlebutton", 0);
            aClass44_Sub3_Sub1_Sub3Array864 = new Image8[12];
            int j = 0;
            try {
                j = Integer.parseInt(getParameter("fl_icon"));
            } catch (Exception _ex) {
            }
            if (j == 0) {
                for (int k = 0; k < 12; k++) {
                    aClass44_Sub3_Sub1_Sub3Array864[k] = new Image8(aClass47_1117, "runes", k);
                }
            } else {
                for (int l = 0; l < 12; l++) {
                    aClass44_Sub3_Sub1_Sub3Array864[l] = new Image8(aClass47_1117, "runes", 12 + (l & 3));
                }
            }
            aClass44_Sub3_Sub1_Sub2_1277 = new Image24(128, 265);
            if (i >= 0) {
                return;
            }
            aClass44_Sub3_Sub1_Sub2_1278 = new Image24(128, 265);
            for (int i1 = 0; i1 < 33920; i1++) {
                aClass44_Sub3_Sub1_Sub2_1277.anIntArray1448[i1] = aClass34_1266.pixels[i1];
            }
            for (int j1 = 0; j1 < 33920; j1++) {
                aClass44_Sub3_Sub1_Sub2_1278.anIntArray1448[j1] = aClass34_1267.pixels[j1];
            }
            anIntArray1219 = new int[256];
            for (int k1 = 0; k1 < 64; k1++) {
                anIntArray1219[k1] = k1 * 0x40000;
            }
            for (int l1 = 0; l1 < 64; l1++) {
                anIntArray1219[l1 + 64] = 0xff0000 + 1024 * l1;
            }
            for (int i2 = 0; i2 < 64; i2++) {
                anIntArray1219[i2 + 128] = 0xffff00 + 4 * i2;
            }
            for (int j2 = 0; j2 < 64; j2++) {
                anIntArray1219[j2 + 192] = 0xffffff;
            }
            anIntArray1220 = new int[256];
            for (int k2 = 0; k2 < 64; k2++) {
                anIntArray1220[k2] = k2 * 1024;
            }
            for (int l2 = 0; l2 < 64; l2++) {
                anIntArray1220[l2 + 64] = 65280 + 4 * l2;
            }
            for (int i3 = 0; i3 < 64; i3++) {
                anIntArray1220[i3 + 128] = 65535 + 0x40000 * i3;
            }
            for (int j3 = 0; j3 < 64; j3++) {
                anIntArray1220[j3 + 192] = 0xffffff;
            }
            anIntArray1221 = new int[256];
            for (int k3 = 0; k3 < 64; k3++) {
                anIntArray1221[k3] = k3 * 4;
            }
            for (int l3 = 0; l3 < 64; l3++) {
                anIntArray1221[l3 + 64] = 255 + 0x40000 * l3;
            }
            for (int i4 = 0; i4 < 64; i4++) {
                anIntArray1221[i4 + 128] = 0xff00ff + 1024 * i4;
            }
            for (int j4 = 0; j4 < 64; j4++) {
                anIntArray1221[j4 + 192] = 0xffffff;
            }
            anIntArray1218 = new int[256];
            anIntArray1133 = new int[32768];
            anIntArray1134 = new int[32768];
            method109(null, 34809);
            anIntArray1272 = new int[32768];
            anIntArray1273 = new int[32768];
            method13(false, 10, "Connecting to fileserver");
            if (!aBoolean1174) {
                aBoolean886 = true;
                aBoolean1174 = true;
                method12(this, 2);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("92179, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void setStandardCameraPosition(byte byte0) {
        try {
            if (byte0 != aByte1101) {
                aBoolean1178 = !aBoolean1178;
            }
            try {
                int x = Game.self.x + cameraRandomizationH;
                int y = Game.self.z + cameraRandomizationV;
                if (currentCameraPositionH - x < -500 || currentCameraPositionH - x > 500 || currentCameraPositionV - y < -500 || currentCameraPositionV - y > 500) {
                    currentCameraPositionH = x;
                    currentCameraPositionV = y;
                }
                if (currentCameraPositionH != x) {
                    currentCameraPositionH += (x - currentCameraPositionH) / 16;
                }
                if (currentCameraPositionV != y) {
                    currentCameraPositionV += (y - currentCameraPositionV) / 16;
                }
                if (super.anIntArray31[1] == 1) {
                    anInt931 += (-24 - anInt931) / 2;
                } else if (super.anIntArray31[2] == 1) {
                    anInt931 += (24 - anInt931) / 2;
                } else {
                    anInt931 /= 2;
                }
                if (super.anIntArray31[3] == 1) {
                    anInt932 += (12 - anInt932) / 2;
                } else if (super.anIntArray31[4] == 1) {
                    anInt932 += (-12 - anInt932) / 2;
                } else {
                    anInt932 /= 2;
                }
                cameraHorizontal = cameraHorizontal + anInt931 / 2 & 0x7ff;
                cameraVertical += anInt932 / 2;
                if (cameraVertical < 128) {
                    cameraVertical = 128;
                }
                if (cameraVertical > 383) {
                    cameraVertical = 383;
                }
                int k = currentCameraPositionH >> 7;
                int l = currentCameraPositionV >> 7;
                int i1 = getFloorDrawHeight(false, currentCameraPositionV, currentCameraPositionH, plane);
                int j1 = 0;
                if (k > 3 && l > 3 && k < 100 && l < 100) {
                    for (int k1 = k - 4; k1 <= k + 4; k1++) {
                        for (int i2 = l - 4; i2 <= l + 4; i2++) {
                            int j2 = plane;
                            if (j2 < 3 && (planeTileFlags[1][k1][i2] & 2) == 2) {
                                j2++;
                            }
                            int k2 = i1 - anIntArrayArrayArray865[j2][k1][i2];
                            if (k2 > j1) {
                                j1 = k2;
                            }
                        }
                    }
                }
                int l1 = j1 * 192;
                if (l1 > 0x17f00) {
                    l1 = 0x17f00;
                }
                if (l1 < 32768) {
                    l1 = 32768;
                }
                if (l1 > secondaryCameraVertical) {
                    secondaryCameraVertical += (l1 - secondaryCameraVertical) / 24;
                    return;
                }
                if (l1 < secondaryCameraVertical) {
                    secondaryCameraVertical += (l1 - secondaryCameraVertical) / 80;
                    return;
                }
            } catch (Exception _ex) {
                SignLink.reporterror("glfc_ex " + Game.self.x + ","
                        + Game.self.z + "," + currentCameraPositionH + ","
                        + currentCameraPositionV + "," + sceneCenterZoneX + "," + sceneCenterZoneZ + "," + sceneBaseTileX + "," + sceneBaseTileZ);
                throw new RuntimeException("eek");
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96812, " + byte0 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void renderNPCs(boolean flag, boolean flag1) {
        try {
            for (int i = 0; i < anInt1009; i++) {
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[anIntArray1010[i]];
                int j = 0x20000000 + (anIntArray1010[i] << 14);
                if (class44_sub3_sub4_sub6_sub2 == null || !class44_sub3_sub4_sub6_sub2.method535(true)
                        || class44_sub3_sub4_sub6_sub2.aClass12_1700.aBoolean302 != flag1) {
                    continue;
                }
                int k = class44_sub3_sub4_sub6_sub2.x >> 7;
                int l = class44_sub3_sub4_sub6_sub2.z >> 7;
                if (k < 0 || k >= 104 || l < 0 || l >= 104) {
                    continue;
                }
                if (class44_sub3_sub4_sub6_sub2.anInt1619 == 1
                        && (class44_sub3_sub4_sub6_sub2.x & 0x7f) == 64
                        && (class44_sub3_sub4_sub6_sub2.z & 0x7f) == 64) {
                    if (anIntArrayArray885[k][l] == renderCycle) {
                        continue;
                    }
                    anIntArrayArray885[k][l] = renderCycle;
                }
                scene.method289(
                        (class44_sub3_sub4_sub6_sub2.anInt1619 - 1) * 64 + 60,
                        j,
                        getFloorDrawHeight(false, class44_sub3_sub4_sub6_sub2.z,
                                class44_sub3_sub4_sub6_sub2.x, plane),
                        class44_sub3_sub4_sub6_sub2.x, 384, class44_sub3_sub4_sub6_sub2,
                        class44_sub3_sub4_sub6_sub2.anInt1617,
                        class44_sub3_sub4_sub6_sub2.aBoolean1618,
                        class44_sub3_sub4_sub6_sub2.z, plane);
            }
            if (flag) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("10709, " + flag + ", " + flag1 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public int getFloorDrawHeight(boolean flag, int i, int j, int k) {
        try {
            int l = j >> 7;
            int i1 = i >> 7;
            if (l < 0 || i1 < 0 || l > 103 || i1 > 103) {
                return 0;
            }
            int j1 = k;
            if (j1 < 3 && (planeTileFlags[1][l][i1] & 2) == 2) {
                j1++;
            }
            int k1 = j & 0x7f;
            int l1 = i & 0x7f;
            int i2 = anIntArrayArrayArray865[j1][l][i1] * (128 - k1) + anIntArrayArrayArray865[j1][l + 1][i1] * k1 >> 7;
            if (flag) {
                return 3;
            } else {
                int j2 = anIntArrayArrayArray865[j1][l][i1 + 1] * (128 - k1)
                        + anIntArrayArrayArray865[j1][l + 1][i1 + 1] * k1 >> 7;
                return i2 * (128 - l1) + j2 * l1 >> 7;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("38676, " + flag + ", " + i + ", " + j + ", " + k + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method52(int i) {
        try {
            if (i <= 0) {
                for (int j = 1; j > 0; j++) {
                }
            }
            if (menuSize < 2 && anInt952 == 0 && anInt994 == 0) {
                return;
            }
            String s;
            if (anInt952 == 1 && menuSize < 2) {
                s = "Use " + aString956 + " with...";
            } else if (anInt994 == 1 && menuSize < 2) {
                s = aString997 + "...";
            } else {
                s = aStringArray897[menuSize - 1];
            }
            if (menuSize > 2) {
                s = s + "@whi@ / " + (menuSize - 2) + " more options";
            }
            fontBold.method464(s, true, 0xffffff, 26617, 4, Game.loopCycle / 1000, 15);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20355, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method53(int i) {
        try {
            if (i < 9 || i > 9) {
                for (int j = 1; j > 0; j++) {
                }
            }
            Graphics g = method11(7).getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 765, 503);
            method4(1, 711);
            if (aBoolean1055) {
                aBoolean1174 = false;
                g.setFont(new Font("Helvetica", 1, 16));
                g.setColor(Color.yellow);
                int k = 35;
                g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, k);
                k += 50;
                g.setColor(Color.white);
                g.drawString("To fix this try the following (in order):", 30, k);
                k += 50;
                g.setColor(Color.white);
                g.setFont(new Font("Helvetica", 1, 12));
                g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, k);
                k += 30;
                g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, k);
                k += 30;
                g.drawString("3: Try using a different game-world", 30, k);
                k += 30;
                g.drawString("4: Try rebooting your computer", 30, k);
                k += 30;
                g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, k);
            }
            if (aBoolean820) {
                aBoolean1174 = false;
                g.setFont(new Font("Helvetica", 1, 20));
                g.setColor(Color.white);
                g.drawString("Error - unable to load game!", 50, 50);
                g.drawString("To play RuneScape make sure you play from", 50, 100);
                g.drawString("http://www.runescape.com", 50, 150);
            }
            if (aBoolean1236) {
                aBoolean1174 = false;
                g.setColor(Color.yellow);
                int l = 35;
                g.drawString("Error a copy of RuneScape already appears to be loaded", 30, l);
                l += 50;
                g.setColor(Color.white);
                g.drawString("To fix this try the following (in order):", 30, l);
                l += 50;
                g.setColor(Color.white);
                g.setFont(new Font("Helvetica", 1, 12));
                g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, l);
                l += 30;
                g.drawString("2: Try rebooting your computer, and reloading", 30, l);
                l += 30;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("39122, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method54(byte byte0) {
        try {
            if (anInt1095 != 0) {
                return;
            }
            aStringArray897[0] = "Cancel";
            menuAction[0] = 1106;
            if (byte0 == 6) {
                byte0 = 0;
            } else {
                return;
            }
            menuSize = 1;
            method45(-113);
            anInt825 = 0;
            if (super.anInt21 > 4 && super.anInt22 > 4 && super.anInt21 < 516 && super.anInt22 < 338) {
                if (anInt1199 != -1) {
                    method30(4, 0, super.anInt21, Component.instances[anInt1199], 4, super.anInt22, 792);
                } else {
                    method135(true);
                }
            }
            if (anInt825 != anInt999) {
                anInt999 = anInt825;
            }
            anInt825 = 0;
            if (super.anInt21 > 553 && super.anInt22 > 205 && super.anInt21 < 743 && super.anInt22 < 466) {
                if (anInt889 != -1) {
                    method30(553, 0, super.anInt21, Component.instances[anInt889], 205, super.anInt22, 792);
                } else if (tabComponentId[currentTab] != -1) {
                    method30(553, 0, super.anInt21, Component.instances[tabComponentId[currentTab]], 205,
                            super.anInt22, 792);
                }
            }
            if (anInt825 != anInt933) {
                redrawInvBack = true;
                anInt933 = anInt825;
            }
            anInt825 = 0;
            if (super.anInt21 > 17 && super.anInt22 > 357 && super.anInt21 < 496 && super.anInt22 < 453) {
                if (anInt1253 != -1) {
                    method30(17, 0, super.anInt21, Component.instances[anInt1253], 357, super.anInt22, 792);
                } else if (super.anInt22 < 434 && super.anInt21 < 426) {
                    method111(super.anInt21 - 17, (byte) 7, super.anInt22 - 357);
                }
            }
            if (anInt1253 != -1 && anInt825 != anInt1212) {
                redrawChatback = true;
                anInt1212 = anInt825;
            }
            for (boolean flag = false; !flag; ) {
                flag = true;
                for (int i = 0; i < menuSize - 1; i++) {
                    if (menuAction[i] < 1000 && menuAction[i + 1] > 1000) {
                        String s = aStringArray897[i];
                        aStringArray897[i] = aStringArray897[i + 1];
                        aStringArray897[i + 1] = s;
                        int j = menuAction[i];
                        menuAction[i] = menuAction[i + 1];
                        menuAction[i + 1] = j;
                        j = menuParamA[i];
                        menuParamA[i] = menuParamA[i + 1];
                        menuParamA[i + 1] = j;
                        j = menuParamB[i];
                        menuParamB[i] = menuParamB[i + 1];
                        menuParamB[i + 1] = j;
                        j = menuParamC[i];
                        menuParamC[i] = menuParamC[i + 1];
                        menuParamC[i + 1] = j;
                        flag = false;
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("40244, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method55(byte byte0, long l) {
        try {
            if (l == 0L) {
                return;
            }
            if (anInt957 >= 100) {
                renderText(0, (byte) -115, "Your ignore list is full. Max of 100 hit", "");
                return;
            }
            String s = TextUtils.method554(TextUtils.method551(l, true), true);
            for (int i = 0; i < anInt957; i++) {
                if (aLongArray1254[i] == l) {
                    renderText(0, (byte) -115, s + " is already on your ignore list", "");
                    return;
                }
            }
            for (int j = 0; j < anInt1104; j++) {
                if (aLongArray979[j] == l) {
                    renderText(0, (byte) -115, "Please remove " + s + " from your friend list first", "");
                    return;
                }
            }
            aLongArray1254[anInt957++] = l;
            if (byte0 != -37) {
                out.writeByte(42);
            }
            redrawInvBack = true;
            out.writePacket(192);
            out.method478(l, true);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("6582, " + byte0 + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method56(int i) {
        try {
            if (systemUpdateTimer > 1) {
                systemUpdateTimer--;
            }
            if (idleLogout > 0) {
                idleLogout--;
            }
            for (int j = 0; j < 5; j++) {
                if (!method31(true)) {
                    break;
                }
            }
            if (!ingame) {
                return;
            }
            synchronized (mouseCapturer.anObject258) {
                if (Game.flagged) {
                    if (super.clickType != 0 || mouseCapturer.coordinatesIndex >= 40) {
                        out.writePacket(229);
                        out.writeByte(0);
                        int j2 = out.position;
                        int j3 = 0;
                        for (int j4 = 0; j4 < mouseCapturer.coordinatesIndex; j4++) {
                            if (j2 - out.position >= 240) {
                                break;
                            }
                            j3++;
                            int l4 = mouseCapturer.anIntArray261[j4];
                            if (l4 < 0) {
                                l4 = 0;
                            } else if (l4 > 502) {
                                l4 = 502;
                            }
                            int k5 = mouseCapturer.anIntArray260[j4];
                            if (k5 < 0) {
                                k5 = 0;
                            } else if (k5 > 764) {
                                k5 = 764;
                            }
                            int i6 = l4 * 765 + k5;
                            if (mouseCapturer.anIntArray261[j4] == -1 && mouseCapturer.anIntArray260[j4] == -1) {
                                k5 = -1;
                                l4 = -1;
                                i6 = 0x7ffff;
                            }
                            if (k5 == anInt887 && l4 == anInt888) {
                                if (sameClickPositionCounter < 2047) {
                                    sameClickPositionCounter++;
                                }
                            } else {
                                int j6 = k5 - anInt887;
                                anInt887 = k5;
                                int k6 = l4 - anInt888;
                                anInt888 = l4;
                                if (sameClickPositionCounter < 8 && j6 >= -32 && j6 <= 31 && k6 >= -32 && k6 <= 31) {
                                    j6 += 32;
                                    k6 += 32;
                                    out.writeShort((sameClickPositionCounter << 12) + (j6 << 6) + k6);
                                    sameClickPositionCounter = 0;
                                } else if (sameClickPositionCounter < 8) {
                                    out.method475(0x800000 + (sameClickPositionCounter << 19) + i6);
                                    sameClickPositionCounter = 0;
                                } else {
                                    out.writeInt(0xc0000000 + (sameClickPositionCounter << 19) + i6);
                                    sameClickPositionCounter = 0;
                                }
                            }
                        }
                        out.method481(out.position - j2, anInt1152);
                        if (j3 >= mouseCapturer.coordinatesIndex) {
                            mouseCapturer.coordinatesIndex = 0;
                        } else {
                            mouseCapturer.coordinatesIndex -= j3;
                            for (int i5 = 0; i5 < mouseCapturer.coordinatesIndex; i5++) {
                                mouseCapturer.anIntArray260[i5] = mouseCapturer.anIntArray260[i5 + j3];
                                mouseCapturer.anIntArray261[i5] = mouseCapturer.anIntArray261[i5 + j3];
                            }
                        }
                    }
                } else {
                    mouseCapturer.coordinatesIndex = 0;
                }
            }
            if (super.clickType != 0) {
                long l = (super.aLong30 - lastClickTime) / 50L;
                if (l > 4095L) {
                    l = 4095L;
                }
                lastClickTime = super.aLong30;
                int k2 = super.mousePressY;
                if (k2 < 0) {
                    k2 = 0;
                } else if (k2 > 502) {
                    k2 = 502;
                }
                int k3 = super.mousePressX;
                if (k3 < 0) {
                    k3 = 0;
                } else if (k3 > 764) {
                    k3 = 764;
                }
                int k4 = k2 * 765 + k3;
                int j5 = 0;
                if (super.clickType == 2) {
                    j5 = 1;
                }
                int l5 = (int) l;
                //aClass44_Sub3_Sub2_850.writePacket(PacketConstants.outgoing.MOUSE_CLICKED);
                //aClass44_Sub3_Sub2_850.putInt((l5 << 20) + (j5 << 19) + k4);
            }
            if (anInt1083 > 0) {
                anInt1083--;
            }
            if (super.anIntArray31[1] == 1 || super.anIntArray31[2] == 1 || super.anIntArray31[3] == 1
                    || super.anIntArray31[4] == 1) {
                aBoolean1084 = true;
            }
            if (aBoolean1084 && anInt1083 <= 0) {
                anInt1083 = 20;
                aBoolean1084 = false;
               /* aClass44_Sub3_Sub2_850.writePacket(193);
                aClass44_Sub3_Sub2_850.writeShort(cameraVertical);
                aClass44_Sub3_Sub2_850.writeShort(cameraHorizontal);*/
            }
            loadingStages();
            method23(845);
            method108(948);
            timeoutCounter++;
            if (timeoutCounter > 750) {
                method99((byte) 7);
            }
            method83((byte) 5);
            method116(905);
            method20(0);
            anInt824++;
            if (crossMode != 0) {
                crossCycle += 20;
                if (crossCycle >= 400) {
                    crossMode = 0;
                }
            }
            if (anInt1151 != 0) {
                anInt1148++;
                if (anInt1148 >= 15) {
                    if (anInt1151 == 2) {
                        redrawInvBack = true;
                    }
                    if (anInt1151 == 3) {
                        redrawChatback = true;
                    }
                    anInt1151 = 0;
                }
            }
            if (anInt1095 != 0) {
                anInt978++;
                if (super.anInt21 > anInt1096 + 5 || super.anInt21 < anInt1096 - 5 || super.anInt22 > anInt1097 + 5
                        || super.anInt22 < anInt1097 - 5) {
                    aBoolean847 = true;
                }
                if (super.mouseButton == 0) {
                    if (anInt1095 == 2) {
                        redrawInvBack = true;
                    }
                    if (anInt1095 == 3) {
                        redrawChatback = true;
                    }
                    anInt1095 = 0;
                    if (aBoolean847 && anInt978 >= 5) {
                        anInt983 = -1;
                        method54((byte) 6);
                        if (anInt983 == anInt1093 && anInt982 != anInt1094) {
                            Component class5 = Component.instances[anInt1093];
                            int j1 = 0;
                            if (anInt835 == 1 && class5.anInt109 == 206) {
                                j1 = 1;
                            }
                            if (class5.containerItemId[anInt982] <= 0) {
                                j1 = 0;
                            }
                            if (class5.aBoolean130) {
                                int l2 = anInt1094;
                                int l3 = anInt982;
                                class5.containerItemId[l3] = class5.containerItemId[l2];
                                class5.containerItemAmount[l3] = class5.containerItemAmount[l2];
                                class5.containerItemId[l2] = -1;
                                class5.containerItemAmount[l2] = 0;
                            } else if (j1 == 1) {
                                int i3 = anInt1094;
                                for (int i4 = anInt982; i3 != i4; ) {
                                    if (i3 > i4) {
                                        class5.method182(0, i3 - 1, i3);
                                        i3--;
                                    } else if (i3 < i4) {
                                        class5.method182(0, i3 + 1, i3);
                                        i3++;
                                    }
                                }
                            } else {
                                class5.method182(0, anInt982, anInt1094);
                            }
                            out.writePacket(253);
                            out.writeShort(anInt1093);
                            out.writeShort(anInt1094);
                            out.writeShort(anInt982);
                            out.writeByte(j1);
                        }
                    } else if ((anInt862 == 1 || method26(menuSize - 1, -40)) && menuSize > 2) {
                        method89(anInt899);
                    } else if (menuSize > 0) {
                        useMentuOption(menuSize - 1);
                    }
                    anInt1148 = 10;
                    super.clickType = 0;
                }
            }
            Game.anInt873++;

            if (Scene.anInt640 != -1) {
                int k = Scene.anInt640;
                int k1 = Scene.anInt641;
                boolean flag = tryMove(0, Game.self.pathTileX[0], 0,
                        k1, 0, 0, true, 0, 124, 0, k,
                        Game.self.pathTileZ[0]);
                Scene.anInt640 = -1;
                if (flag) {
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 1;
                    crossCycle = 0;
                }
            }
            if (super.clickType == 1 && clickToContinueString != null) {
                clickToContinueString = null;
                redrawChatback = true;
                super.clickType = 0;
            }
            method14((byte) 1);
            method143(176);
            method106(-293);
            if (i <= 0) {
                out.writeByte(98);
            }
            method145((byte) 9);
            if (super.mouseButton == 1 || super.clickType == 1) {
                anInt1066++;
            }
            if (sceneState == 2) {
                setStandardCameraPosition((byte) 6);
            }
            if (sceneState == 2 && cutsceneActive) {
                setCutsceneCamera(0);
            }
            for (int i1 = 0; i1 < 5; i1++) {
                anIntArray1001[i1]++;
            }
            method133(anInt1074);
            super.idleTime++;
            if (super.idleTime > 4500) {
                idleLogout = 250;
                super.idleTime -= 500;
                out.writePacket(PacketConstants.outgoing.IDLE_TIMER);
            }
            anInt921++;
            if (anInt921 > 500) {
                anInt921 = 0;
                int l1 = (int) (Math.random() * 8D);
                if ((l1 & 1) == 1) {
                    cameraRandomizationH += anInt1012;
                }
                if ((l1 & 2) == 2) {
                    cameraRandomizationV += anInt1216;
                }
                if ((l1 & 4) == 4) {
                    cameraRandomisationA += anInt1107;
                }
            }
            if (cameraRandomizationH < -50) {
                anInt1012 = 2;
            }
            if (cameraRandomizationH > 50) {
                anInt1012 = -2;
            }
            if (cameraRandomizationV < -55) {
                anInt1216 = 2;
            }
            if (cameraRandomizationV > 55) {
                anInt1216 = -2;
            }
            if (cameraRandomisationA < -40) {
                anInt1107 = 1;
            }
            if (cameraRandomisationA > 40) {
                anInt1107 = -1;
            }
            anInt907++;
            if (anInt907 > 500) {
                anInt907 = 0;
                int i2 = (int) (Math.random() * 8D);
                if ((i2 & 1) == 1) {
                    anInt959 += anInt960;
                }
                if ((i2 & 2) == 2) {
                    anInt1075 += anInt1076;
                }
            }
            if (anInt959 < -60) {
                anInt960 = 2;
            }
            if (anInt959 > 60) {
                anInt960 = -2;
            }
            if (anInt1075 < -20) {
                anInt1076 = 1;
            }
            if (anInt1075 > 10) {
                anInt1076 = -1;
            }
            anInt1172++;

            try {
                if (connection != null && out.position > 0) {
                    connection.write(0, out.payload, out.position);
                    out.position = 0;
                    anInt1172 = 0;
                    return;
                }
            } catch (IOException _ex) {
                method99((byte) 7);
                return;
            } catch (Exception exception) {
                method22((byte) 25);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("87308, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method57(int packetSize, Buffer class44_sub3_sub2) {
        try {
            anInt940 = 0;
            anInt1228 = 0;
            method130(packetSize, class44_sub3_sub2, false);
            method103(-752, class44_sub3_sub2, packetSize);
            method90(packetSize, class44_sub3_sub2, 0);
            method71(class44_sub3_sub2, false, packetSize);
            for (int j = 0; j < anInt940; j++) {
                int k = anIntArray941[j];
                if (players[k].anInt1660 != Game.loopCycle) {
                    players[k] = null;
                }
            }
            if (class44_sub3_sub2.position != packetSize) {
                SignLink.reporterror("Error packet size mismatch in getplayer pos:" + class44_sub3_sub2.position
                        + " psize:" + packetSize);
                throw new RuntimeException("eek"); //TODO run client again
            }
            for (int l = 0; l < anInt1226; l++) {
                if (players[anIntArray1227[l]] == null) {
                    SignLink.reporterror(username + " null entry in pl list - pos:" + l + " size:" + anInt1226);
                    throw new RuntimeException("eek");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void method58(int i, NpcType class12, int j, int k, int l) {
        try {
            k = 43 / k;
            if (menuSize >= 400) {
                return;
            }
            String s = class12.aString282;
            if (class12.anInt299 != 0) {
                s = s + Game.method137(class12.anInt299, Game.self.anInt1678, -41081)
                        + " (level-" + class12.anInt299 + ")";
            }
            if (anInt952 == 1) {
                aStringArray897[menuSize] = "Use " + aString956 + " with @yel@" + s;
                menuAction[menuSize] = 829;
                menuParamC[menuSize] = i;
                menuParamA[menuSize] = j;
                menuParamB[menuSize] = l;
                menuSize++;
                return;
            }
            if (anInt994 == 1) {
                if ((anInt996 & 2) == 2) {
                    aStringArray897[menuSize] = aString997 + " @yel@" + s;
                    menuAction[menuSize] = 240;
                    menuParamC[menuSize] = i;
                    menuParamA[menuSize] = j;
                    menuParamB[menuSize] = l;
                    menuSize++;
                    return;
                }
            } else {
                if (class12.aStringArray294 != null) {
                    for (int i1 = 4; i1 >= 0; i1--) {
                        if (class12.aStringArray294[i1] != null
                                && !class12.aStringArray294[i1].equalsIgnoreCase("attack")) {
                            aStringArray897[menuSize] = class12.aStringArray294[i1] + " @yel@" + s;
                            if (i1 == 0) {
                                menuAction[menuSize] = 242;
                            }
                            if (i1 == 1) {
                                menuAction[menuSize] = 209;
                            }
                            if (i1 == 2) {
                                menuAction[menuSize] = 309;
                            }
                            if (i1 == 3) {
                                menuAction[menuSize] = 852;
                            }
                            if (i1 == 4) {
                                menuAction[menuSize] = 793;
                            }
                            menuParamC[menuSize] = i;
                            menuParamA[menuSize] = j;
                            menuParamB[menuSize] = l;
                            menuSize++;
                        }
                    }
                }
                if (class12.aStringArray294 != null) {
                    for (int j1 = 4; j1 >= 0; j1--) {
                        if (class12.aStringArray294[j1] != null
                                && class12.aStringArray294[j1].equalsIgnoreCase("attack")) {
                            char c = '\0';
                            if (class12.anInt299 > Game.self.anInt1678) {
                                c = '\u07D0';
                            }
                            aStringArray897[menuSize] = class12.aStringArray294[j1] + " @yel@" + s;
                            if (j1 == 0) {
                                menuAction[menuSize] = 242 + c;
                            }
                            if (j1 == 1) {
                                menuAction[menuSize] = 209 + c;
                            }
                            if (j1 == 2) {
                                menuAction[menuSize] = 309 + c;
                            }
                            if (j1 == 3) {
                                menuAction[menuSize] = 852 + c;
                            }
                            if (j1 == 4) {
                                menuAction[menuSize] = 793 + c;
                            }
                            menuParamC[menuSize] = i;
                            menuParamA[menuSize] = j;
                            menuParamB[menuSize] = l;
                            menuSize++;
                        }
                    }
                }
                aStringArray897[menuSize] = "Examine @yel@" + s;
                menuAction[menuSize] = 1714;
                menuParamC[menuSize] = i;
                menuParamA[menuSize] = j;
                menuParamB[menuSize] = l;
                menuSize++;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("53238, " + i + ", " + class12 + ", " + j + ", " + k + ", " + l + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method59(boolean flag, int i, boolean flag1) {
        try {
            ingame &= flag;
            SignLink.midivol = i;
            if (flag1) {
                SignLink.midi = "voladjust";
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20099, " + flag + ", " + i + ", " + flag1 + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method60(int i) {
        try {
            if (aClass34_1198 != null) {
                return;
            }
            method128(false);
            super.aClass34_14 = null;
            title2 = null;
            title3 = null;
            title4 = null;
            aClass34_1266 = null;
            aClass34_1267 = null;
            title5 = null;
            title6 = null;
            title7 = null;
            title8 = null;
            aClass34_1198 = new DrawArea(479, 96);
            aClass34_1196 = new DrawArea(172, 156);
            Draw2D.method409((byte) 127);
            aClass44_Sub3_Sub1_Sub3_1144.blit(0, 0);
            aClass34_1195 = new DrawArea(190, 261);
            areaViewport = new DrawArea(512, 334);
            Draw2D.method409((byte) 127);
            aClass34_858 = new DrawArea(496, 50);
            aClass34_859 = new DrawArea(269, 37);
            aClass34_860 = new DrawArea(249, 45);
            redrawTitleBackground = true;
            if (i <= 0) {
                anInt962 = 175;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("97189, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method61(int i) {
        try {
            anInt1157 = 0;
            if (i < 1 || i > 1) {
                return;
            }
            for (int j = -1; j < anInt1226 + anInt1009; j++) {
                Object obj;
                if (j == -1) {
                    obj = Game.self;
                } else if (j < anInt1226) {
                    obj = players[anIntArray1227[j]];
                } else {
                    obj = npcs[anIntArray1010[j - anInt1226]];
                }
                if (obj != null && ((Actor) (obj)).method535(true)) {
                    if (j < anInt1226) {
                        int l = 30;
                        PlayerEntity class44_sub3_sub4_sub6_sub1 = (PlayerEntity) obj;
                        if (class44_sub3_sub4_sub6_sub1.anInt1675 != 0) {
                            method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                for (int i2 = 0; i2 < 8; i2++) {
                                    if ((class44_sub3_sub4_sub6_sub1.anInt1675 & 1 << i2) != 0) {
                                        aClass44_Sub3_Sub1_Sub2Array1183[i2].method440(anInt1065 - l, aByte1213,
                                                anInt1064 - 12);
                                        l -= 25;
                                    }
                                }
                            }
                        }
                        if (j >= 0 && hintIconType == 10 && anInt909 == anIntArray1227[j]) {
                            method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                aClass44_Sub3_Sub1_Sub2Array1183[7].method440(anInt1065 - l, aByte1213, anInt1064 - 12);
                            }
                        }
                    } else {
                        NpcType class12 = ((NPCEntity) obj).aClass12_1700;
                        if (class12.anInt305 >= 0 && class12.anInt305 < aClass44_Sub3_Sub1_Sub2Array1183.length) {
                            method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                aClass44_Sub3_Sub1_Sub2Array1183[class12.anInt305].method440(anInt1065 - 30, aByte1213,
                                        anInt1064 - 12);
                            }
                        }
                        if (hintIconType == 1 && anInt901 == anIntArray1010[j - anInt1226] && Game.loopCycle % 20 < 10) {
                            method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                aClass44_Sub3_Sub1_Sub2Array1183[2]
                                        .method440(anInt1065 - 28, aByte1213, anInt1064 - 12);
                            }
                        }
                    }
                    if (((Actor) (obj)).aString1627 != null
                            && (j >= anInt1226 || publicChatSetting == 0 || publicChatSetting == 3 || publicChatSetting == 1
                            && method80(((PlayerEntity) obj).aString1672, 3))) {
                        method74(((Actor) (obj)).anInt1661, ((Actor) (obj)), 0);
                        if (anInt1064 > -1 && anInt1157 < anInt1158) {
                            anIntArray1162[anInt1157] = fontBold.method458(
                                    ((Actor) (obj)).aString1627, -725) / 2;
                            anIntArray1161[anInt1157] = fontBold.anInt1478;
                            anIntArray1159[anInt1157] = anInt1064;
                            anIntArray1160[anInt1157] = anInt1065;
                            anIntArray1163[anInt1157] = ((Actor) (obj)).anInt1629;
                            anIntArray1164[anInt1157] = ((Actor) (obj)).anInt1630;
                            anIntArray1165[anInt1157] = ((Actor) (obj)).anInt1628;
                            aStringArray1166[anInt1157++] = ((Actor) (obj)).aString1627;
                            if (anInt970 == 0 && ((Actor) (obj)).anInt1630 >= 1 && ((Actor) (obj)).anInt1630 <= 3) {
                                anIntArray1161[anInt1157] += 10;
                                anIntArray1160[anInt1157] += 5;
                            }
                            if (anInt970 == 0 && ((Actor) (obj)).anInt1630 == 4) {
                                anIntArray1162[anInt1157] = 60;
                            }
                            if (anInt970 == 0 && ((Actor) (obj)).anInt1630 == 5) {
                                anIntArray1161[anInt1157] += 5;
                            }
                        }
                    }
                    if (((Actor) (obj)).anInt1634 > Game.loopCycle) {
                        method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                        if (anInt1064 > -1) {
                            int i1 = (((Actor) (obj)).anInt1635 * 30) / ((Actor) (obj)).anInt1636;
                            if (i1 > 30) {
                                i1 = 30;
                            }
                            Draw2D.method411(65280, 210, anInt1065 - 3, 5, anInt1064 - 15, i1);
                            Draw2D.method411(0xff0000, 210, anInt1065 - 3, 5, (anInt1064 - 15) + i1, 30 - i1);
                        }
                    }
                    for (int j1 = 0; j1 < 4; j1++) {
                        if (((Actor) (obj)).anIntArray1633[j1] > Game.loopCycle) {
                            method74(((Actor) (obj)).anInt1661 / 2, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                if (j1 == 1) {
                                    anInt1065 -= 20;
                                }
                                if (j1 == 2) {
                                    anInt1064 -= 15;
                                    anInt1065 -= 10;
                                }
                                if (j1 == 3) {
                                    anInt1064 += 15;
                                    anInt1065 -= 10;
                                }
                                aClass44_Sub3_Sub1_Sub2Array1108[((Actor) (obj)).anIntArray1632[j1]].method440(
                                        anInt1065 - 12, aByte1213, anInt1064 - 12);
                                fontPlain.drawStringCenter(anInt1064,
                                        String.valueOf(((Actor) (obj)).anIntArray1631[j1]), -31546, 0, anInt1065 + 4);
                                fontPlain.drawStringCenter(anInt1064 - 1,
                                        String.valueOf(((Actor) (obj)).anIntArray1631[j1]), -31546, 0xffffff,
                                        anInt1065 + 3);
                            }
                        }
                    }
                }
            }
            for (int k = 0; k < anInt1157; k++) {
                int k1 = anIntArray1159[k];
                int l1 = anIntArray1160[k];
                int j2 = anIntArray1162[k];
                int k2 = anIntArray1161[k];
                boolean flag = true;
                while (flag) {
                    flag = false;
                    for (int l2 = 0; l2 < k; l2++) {
                        if (l1 + 2 > anIntArray1160[l2] - anIntArray1161[l2] && l1 - k2 < anIntArray1160[l2] + 2
                                && k1 - j2 < anIntArray1159[l2] + anIntArray1162[l2]
                                && k1 + j2 > anIntArray1159[l2] - anIntArray1162[l2]
                                && anIntArray1160[l2] - anIntArray1161[l2] < l1) {
                            l1 = anIntArray1160[l2] - anIntArray1161[l2];
                            flag = true;
                        }
                    }
                }
                anInt1064 = anIntArray1159[k];
                anInt1065 = anIntArray1160[k] = l1;
                String s = aStringArray1166[k];
                if (anInt970 == 0) {
                    int i3 = 0xffff00;
                    if (anIntArray1163[k] < 6) {
                        i3 = anIntArray1203[anIntArray1163[k]];
                    }
                    if (anIntArray1163[k] == 6) {
                        i3 = renderCycle % 20 >= 10 ? 0xffff00 : 0xff0000;
                    }
                    if (anIntArray1163[k] == 7) {
                        i3 = renderCycle % 20 >= 10 ? 65535 : 255;
                    }
                    if (anIntArray1163[k] == 8) {
                        i3 = renderCycle % 20 >= 10 ? 0x80ff80 : 45056;
                    }
                    if (anIntArray1163[k] == 9) {
                        int j3 = 150 - anIntArray1165[k];
                        if (j3 < 50) {
                            i3 = 0xff0000 + 1280 * j3;
                        } else if (j3 < 100) {
                            i3 = 0xffff00 - 0x50000 * (j3 - 50);
                        } else if (j3 < 150) {
                            i3 = 65280 + 5 * (j3 - 100);
                        }
                    }
                    if (anIntArray1163[k] == 10) {
                        int k3 = 150 - anIntArray1165[k];
                        if (k3 < 50) {
                            i3 = 0xff0000 + 5 * k3;
                        } else if (k3 < 100) {
                            i3 = 0xff00ff - 0x50000 * (k3 - 50);
                        } else if (k3 < 150) {
                            i3 = (255 + 0x50000 * (k3 - 100)) - 5 * (k3 - 100);
                        }
                    }
                    if (anIntArray1163[k] == 11) {
                        int l3 = 150 - anIntArray1165[k];
                        if (l3 < 50) {
                            i3 = 0xffffff - 0x50005 * l3;
                        } else if (l3 < 100) {
                            i3 = 65280 + 0x50005 * (l3 - 50);
                        } else if (l3 < 150) {
                            i3 = 0xffffff - 0x50000 * (l3 - 100);
                        }
                    }
                    if (anIntArray1164[k] == 0) {
                        fontBold.drawStringCenter(anInt1064, s, -31546, 0, anInt1065 + 1);
                        fontBold.drawStringCenter(anInt1064, s, -31546, i3, anInt1065);
                    }
                    if (anIntArray1164[k] == 1) {
                        fontBold.method460(anInt1064, renderCycle, (byte) 5, 0, anInt1065 + 1, s);
                        fontBold.method460(anInt1064, renderCycle, (byte) 5, i3, anInt1065, s);
                    }
                    if (anIntArray1164[k] == 2) {
                        fontBold.method461(0, s, (byte) 3, anInt1064, anInt1065 + 1, renderCycle);
                        fontBold.method461(i3, s, (byte) 3, anInt1064, anInt1065, renderCycle);
                    }
                    if (anIntArray1164[k] == 3) {
                        fontBold.method462(s, anInt1064, renderCycle, anInt1065 + 1, 0, anInt974,
                                150 - anIntArray1165[k]);
                        fontBold.method462(s, anInt1064, renderCycle, anInt1065, i3, anInt974,
                                150 - anIntArray1165[k]);
                    }
                    if (anIntArray1164[k] == 4) {
                        int i4 = fontBold.method458(s, -725);
                        int k4 = ((150 - anIntArray1165[k]) * (i4 + 100)) / 150;
                        Draw2D.setBounds(anInt1064 + 50, 334, 0, anInt1064 - 50);
                        fontBold.method459((byte) -104, 0, s, (anInt1064 + 50) - k4, anInt1065 + 1);
                        fontBold.method459((byte) -104, i3, s, (anInt1064 + 50) - k4, anInt1065);
                        Draw2D.resetBounds();
                    }
                    if (anIntArray1164[k] == 5) {
                        int j4 = 150 - anIntArray1165[k];
                        int l4 = 0;
                        if (j4 < 25) {
                            l4 = j4 - 25;
                        } else if (j4 > 125) {
                            l4 = j4 - 125;
                        }
                        Draw2D.setBounds(512, anInt1065 + 5, anInt1065
                                - fontBold.anInt1478 - 1, 0);
                        fontBold.drawStringCenter(anInt1064, s, -31546, 0, anInt1065 + 1 + l4);
                        fontBold.drawStringCenter(anInt1064, s, -31546, i3, anInt1065 + l4);
                        Draw2D.resetBounds();
                    }
                } else {
                    fontBold.drawStringCenter(anInt1064, s, -31546, 0, anInt1065 + 1);
                    fontBold.drawStringCenter(anInt1064, s, -31546, 0xffff00, anInt1065);
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("28791, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method62(int i, byte byte0) {
        try {
            if (byte0 != -12) {
                method6();
            }
            if (!Game.lowMemory) {
                if (Draw3D.anIntArray1437[17] >= i) {
                    Image8 class44_sub3_sub1_sub3 = Draw3D.aClass44_Sub3_Sub1_Sub3Array1431[17];
                    int j = class44_sub3_sub1_sub3.anInt1460 * class44_sub3_sub1_sub3.anInt1461 - 1;
                    int l = class44_sub3_sub1_sub3.anInt1460 * anInt824 * 2;
                    byte[] abyte0 = class44_sub3_sub1_sub3.aByteArray1458;
                    byte[] abyte2 = aByteArray1109;
                    for (int j1 = 0; j1 <= j; j1++) {
                        abyte2[j1] = abyte0[j1 - l & j];
                    }
                    class44_sub3_sub1_sub3.aByteArray1458 = abyte2;
                    aByteArray1109 = abyte0;
                    Draw3D.method425(9, 17);
                }
                if (Draw3D.anIntArray1437[24] >= i) {
                    Image8 class44_sub3_sub1_sub3_1 = Draw3D.aClass44_Sub3_Sub1_Sub3Array1431[24];
                    int k = class44_sub3_sub1_sub3_1.anInt1460 * class44_sub3_sub1_sub3_1.anInt1461 - 1;
                    int i1 = class44_sub3_sub1_sub3_1.anInt1460 * anInt824 * 2;
                    byte[] abyte1 = class44_sub3_sub1_sub3_1.aByteArray1458;
                    byte[] abyte3 = aByteArray1109;
                    for (int k1 = 0; k1 <= k; k1++) {
                        abyte3[k1] = abyte1[k1 - i1 & k];
                    }
                    class44_sub3_sub1_sub3_1.aByteArray1458 = abyte3;
                    aByteArray1109 = abyte1;
                    Draw3D.method425(9, 24);
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("9303, " + i + ", " + byte0 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method63(int i) {
        try {
            if (anInt1017 == 0) {
                return;
            }
            TypeFace class44_sub3_sub1_sub4 = plainFont;
            int j = 0;
            while (i >= 0) {
                packetType = in.readUnsignedByte();
            }
            if (systemUpdateTimer != 0) {
                j = 1;
            }
            for (int k = 0; k < 100; k++) {
                if (chatMessages[k] != null) {
                    int l = anIntArray1002[k];
                    String s = aStringArray1003[k];
                    byte byte0 = 0;
                    if (s != null && s.startsWith("@cr1@")) {
                        s = s.substring(5);
                        byte0 = 1;
                    }
                    if (s != null && s.startsWith("@cr2@")) {
                        s = s.substring(5);
                        byte0 = 2;
                    }
                    if ((l == 3 || l == 7) && (l == 7 || privateChatSetting == 0 || privateChatSetting == 1 && method80(s, 3))) {
                        int i1 = 329 - j * 13;
                        int l1 = 4;
                        class44_sub3_sub1_sub4.method459((byte) -104, 0, "From", l1, i1);
                        class44_sub3_sub1_sub4.method459((byte) -104, 65535, "From", l1, i1 - 1);
                        l1 += class44_sub3_sub1_sub4.method457("From ", true);
                        if (byte0 == 1) {
                            aClass44_Sub3_Sub1_Sub3Array836[0].blit(i1 - 12, l1);
                            l1 += 14;
                        }
                        if (byte0 == 2) {
                            aClass44_Sub3_Sub1_Sub3Array836[1].blit(i1 - 12, l1);
                            l1 += 14;
                        }
                        class44_sub3_sub1_sub4.method459((byte) -104, 0, s + ": " + chatMessages[k], l1, i1);
                        class44_sub3_sub1_sub4
                                .method459((byte) -104, 65535, s + ": " + chatMessages[k], l1, i1 - 1);
                        if (++j >= 5) {
                            return;
                        }
                    }
                    if (l == 5 && privateChatSetting < 2) {
                        int j1 = 329 - j * 13;
                        class44_sub3_sub1_sub4.method459((byte) -104, 0, chatMessages[k], 4, j1);
                        class44_sub3_sub1_sub4.method459((byte) -104, 65535, chatMessages[k], 4, j1 - 1);
                        if (++j >= 5) {
                            return;
                        }
                    }
                    if (l == 6 && privateChatSetting < 2) {
                        int k1 = 329 - j * 13;
                        class44_sub3_sub1_sub4.method459((byte) -104, 0, "To " + s + ": " + chatMessages[k], 4, k1);
                        class44_sub3_sub1_sub4.method459((byte) -104, 65535, "To " + s + ": " + chatMessages[k], 4,
                                k1 - 1);
                        if (++j >= 5) {
                            return;
                        }
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("54582, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void method12(Runnable runnable, int i) {
        if (i > 10) {
            i = 10;
        }
        if (SignLink.mainapp != null) {
            SignLink.startthread(runnable, i);
            return;
        } else {
            super.method12(runnable, i);
            return;
        }
    }

    public boolean method65(int i, int j, byte byte0) {
        try {
            if (byte0 != -103) {
                planeObjStacks = null;
            }
            boolean flag = false;
            Component class5 = Component.instances[j];
            for (int k = 0; k < class5.anIntArray122.length; k++) {
                if (class5.anIntArray122[k] == -1) {
                    break;
                }
                Component class5_1 = Component.instances[class5.anIntArray122[k]];
                if (class5_1.anInt107 == 1) {
                    flag |= method65(i, class5_1.anInt105, (byte) -103);
                }
                if (class5_1.anInt107 == 6 && (class5_1.anInt153 != -1 || class5_1.anInt154 != -1)) {
                    boolean flag1 = method88(class5_1, 0);
                    int l;
                    if (flag1) {
                        l = class5_1.anInt154;
                    } else {
                        l = class5_1.anInt153;
                    }
                    if (l != -1) {
                        SeqType class26 = SeqType.cache[l];
                        for (class5_1.anInt104 += i; class5_1.anInt104 > class26.method254(class5_1.anInt103, 24425); ) {
                            class5_1.anInt104 -= class26.method254(class5_1.anInt103, 24425) + 1;
                            class5_1.anInt103++;
                            if (class5_1.anInt103 >= class26.anInt509) {
                                class5_1.anInt103 -= class26.anInt513;
                                if (class5_1.anInt103 < 0 || class5_1.anInt103 >= class26.anInt509) {
                                    class5_1.anInt103 = 0;
                                }
                            }
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("91123, " + i + ", " + j + ", " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void drawLoginScreen(boolean hideButtons) {
        try {
            resetTitleScreen();
            title4.bind();
            titleBox.blit(0, 0);
            int w = 360;
            int h = 200;
            if (loginScreenState == 0) {
                int y = h / 2 + 80;
                fontPlain.drawStringCenter(true, 0x75a9a9, (byte) -85, w / 2,
                        ondemand.message, y);
                y = h / 2 - 20;
                fontBold.drawStringCenter(true, 0xffff00, (byte) -85, w / 2, "Welcome to RuneScape", y);
                int x = w / 2 - 80;
                y = h / 2 + 20;
                titleButton.blit(y - 20, x - 73);
                fontBold.drawStringCenter(true, 0xffffff, (byte) -85, x, "New User", y + 5);
                x = w / 2 + 80;
                titleButton.blit(y - 20, x - 73);
                fontBold.drawStringCenter(true, 0xffffff, (byte) -85, x, "Existing User", y + 5);
            }
            if (loginScreenState == 2) {
                int y = h / 2 - 40;
                if (loginString0.length() > 0) {
                    fontBold.drawStringCenter(true, 0xffff00, (byte) -85, w / 2, loginString0, y - 15);
                    fontBold.drawStringCenter(true, 0xffff00, (byte) -85, w / 2, loginString1, y);
                } else {
                    fontBold.drawStringCenter(true, 0xffff00, (byte) -85, w / 2, loginString1, y - 7);
                }
                y += 30;
                fontBold.drawStringTaggable(0xffffff, 2, y, true, w / 2 - 90, "Username: " + username
                        + ((loginInputLine == 0) & (Game.loopCycle % 40 < 20) ? "@yel@|" : ""));
                y += 15;
                fontBold.drawStringTaggable(0xffffff, 2, y, true, w / 2 - 88,
                        "Password: " + TextUtils.toAsterisks(password)
                                + ((loginInputLine == 1) & (Game.loopCycle % 40 < 20) ? "@yel@|" : ""));
                y += 15;
                if (!hideButtons) {
                    int x = w / 2 - 80;
                    y = h / 2 + 50;
                    titleButton.blit(y - 20, x - 73);
                    fontBold.drawStringCenter(true, 0xffffff, (byte) -85, x, "Login", y + 5);
                    x = w / 2 + 80;
                    titleButton.blit(y - 20, x - 73);
                    fontBold.drawStringCenter(true, 0xffffff, (byte) -85, x, "Cancel", y + 5);
                }
            }
            if (loginScreenState == 3) {
                fontBold.drawStringCenter(true, 0xffff00, (byte) -85, w / 2, "Create a free account",
                        h / 2 - 60);
                int y = h / 2 - 35;
                fontBold.drawStringCenter(true, 0xffffff, (byte) -85, w / 2,
                        "To create a new account you need to", y);
                y += 15;
                fontBold.drawStringCenter(true, 0xffffff, (byte) -85, w / 2,
                        "go back to the main RuneScape webpage", y);
                y += 15;
                fontBold.drawStringCenter(true, 0xffffff, (byte) -85, w / 2,
                        "and choose the red 'create account'", y);
                y += 15;
                fontBold.drawStringCenter(true, 0xffffff, (byte) -85, w / 2,
                        "button at the top right of that page.", y);
                y += 15;
                int x = w / 2;
                y = h / 2 + 50;
                titleButton.blit(y - 20, x - 73);
                fontBold.drawStringCenter(true, 0xffffff, (byte) -85, x, "Cancel", y + 5);
            }
            title4.draw(super.graphics, 202, 171);
            if (redrawTitleBackground) {
                redrawTitleBackground = false;
                title2.draw(super.graphics, 128, 0);
                title3.draw(super.graphics, 202, 371);
                title5.draw(super.graphics, 0, 265);
                title6.draw(super.graphics, 562, 265);
                title7.draw(super.graphics, 128, 171);
                title8.draw(super.graphics, 562, 171);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("72643, " + hideButtons + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method67(Buffer in, int i, int packetType) {
        try {
            if (i != -6563) {
                for (int k = 1; k > 0; k++) {
                }
            }
            if (packetType == 90 || packetType == 194) {
                int l = in.readUnsignedByte();
                int j3 = anInt1037 + (l >> 4 & 7);
                int l5 = anInt1038 + (l & 7);
                int j8 = in.readUnsignedByte();
                int l10 = j8 >> 2;
                int i13 = j8 & 3;
                int i15 = anIntArray1142[l10];
                int j16;
                if (packetType == 194) {
                    j16 = -1;
                } else {
                    j16 = in.readUnsignedShort();
                }
                if (j3 >= 0 && l5 >= 0 && j3 < 104 && l5 < 104) {
                    method82(-23081, 0, plane, j16, l10, l5, i13, -1, i15, j3);
                }
                return;
            }
            if (packetType == 106) {
                int i1 = in.readUnsignedByte();
                int k3 = anInt1037 + (i1 >> 4 & 7);
                int i6 = anInt1038 + (i1 & 7);
                int k8 = in.readUnsignedByte();
                int i11 = k8 >> 2;
                int j13 = k8 & 3;
                int j15 = anIntArray1142[i11];
                int k16 = in.readUnsignedShort();
                if (k3 >= 0 && i6 >= 0 && k3 < 103 && i6 < 103) {
                    int j17 = anIntArrayArrayArray865[plane][k3][i6];
                    int i18 = anIntArrayArrayArray865[plane][k3 + 1][i6];
                    int l18 = anIntArrayArrayArray865[plane][k3 + 1][i6 + 1];
                    int k19 = anIntArrayArrayArray865[plane][k3][i6 + 1];
                    if (j15 == 0) {
                        Wall class33 = scene.method300(plane, false, k3, i6);
                        if (class33 != null) {
                            int j20 = class33.anInt579 >> 14 & 0x7fff;
                            if (i11 == 2) {
                                class33.aClass44_Sub3_Sub4_577 = new GameObject(4 + j13, j20, 2, k19, l18, false, j17,
                                        k16, false, i18);
                                class33.aClass44_Sub3_Sub4_578 = new GameObject(j13 + 1 & 3, j20, 2, k19, l18, false,
                                        j17, k16, false, i18);
                            } else {
                                class33.aClass44_Sub3_Sub4_577 = new GameObject(j13, j20, i11, k19, l18, false, j17,
                                        k16, false, i18);
                            }
                        }
                    }
                    if (j15 == 1) {
                        WallDecoration class13 = scene.method301(i6, 0, plane, k3);
                        if (class13 != null) {
                            class13.aClass44_Sub3_Sub4_313 = new GameObject(0, class13.anInt314 >> 14 & 0x7fff, 4, k19,
                                    l18, false, j17, k16, false, i18);
                        }
                    }
                    if (j15 == 2) {
                        SceneSpawnRequest class30 = scene.method302(k3, 0, i6, plane);
                        if (i11 == 11) {
                            i11 = 10;
                        }
                        if (class30 != null) {
                            class30.aClass44_Sub3_Sub4_543 = new GameObject(j13, class30.anInt551 >> 14 & 0x7fff, i11,
                                    k19, l18, false, j17, k16, false, i18);
                        }
                    }
                    if (j15 == 3) {
                        FloorDecoration class17 = scene.method303(plane, 0, i6, k3);
                        if (class17 != null) {
                            class17.aClass44_Sub3_Sub4_402 = new GameObject(j13, class17.anInt403 >> 14 & 0x7fff, 22,
                                    k19, l18, false, j17, k16, false, i18);
                        }
                    }
                }
                return;
            }
            if (packetType == 60) {
                int j1 = in.readUnsignedByte();
                int l3 = anInt1037 + (j1 >> 4 & 7);
                int j6 = anInt1038 + (j1 & 7);
                int l8 = in.readUnsignedShort();
                int j11 = in.readUnsignedShort();
                if (l3 >= 0 && j6 >= 0 && l3 < 104 && j6 < 104) {
                    ObjStackEntity class44_sub3_sub4_sub2 = new ObjStackEntity();
                    class44_sub3_sub4_sub2.anInt1495 = l8;
                    class44_sub3_sub4_sub2.anInt1496 = j11;
                    if (planeObjStacks[plane][l3][j6] == null) {
                        planeObjStacks[plane][l3][j6] = new LinkedList(-199);
                    }
                    planeObjStacks[plane][l3][j6].method256(class44_sub3_sub4_sub2);
                    method92(l3, j6);
                }
                return;
            }
            if (packetType == 71) {
                int k1 = in.readUnsignedByte();
                int i4 = anInt1037 + (k1 >> 4 & 7);
                int k6 = anInt1038 + (k1 & 7);
                int i9 = in.readUnsignedShort();
                if (i4 >= 0 && k6 >= 0 && i4 < 104 && k6 < 104) {
                    LinkedList class28 = planeObjStacks[plane][i4][k6];
                    if (class28 != null) {
                        for (ObjStackEntity class44_sub3_sub4_sub2_1 = (ObjStackEntity) class28.peekFront(); class44_sub3_sub4_sub2_1 != null; class44_sub3_sub4_sub2_1 = (ObjStackEntity) class28
                                .prev(false)) {
                            if (class44_sub3_sub4_sub2_1.anInt1495 != (i9 & 0x7fff)) {
                                continue;
                            }
                            class44_sub3_sub4_sub2_1.remove();
                            break;
                        }
                        if (class28.peekFront() == null) {
                            planeObjStacks[plane][i4][k6] = null;
                        }
                        method92(i4, k6);
                    }
                }
                return;
            }
            if (packetType == 87) {
                int l1 = in.readUnsignedByte();
                int j4 = anInt1037 + (l1 >> 4 & 7);
                int l6 = anInt1038 + (l1 & 7);
                int j9 = j4 + in.readByte();
                int k11 = l6 + in.readByte();
                int k13 = in.readUnsignedByte();
                int k15 = in.readUnsignedShort();
                int l16 = in.readUnsignedByte() * 4;
                int k17 = in.readUnsignedByte() * 4;
                int j18 = in.readUnsignedShort();
                int i19 = in.readUnsignedShort();
                int l19 = in.readUnsignedByte();
                int i20 = in.readUnsignedByte();
                if (j4 >= 0 && l6 >= 0 && j4 < 104 && l6 < 104 && j9 >= 0 && k11 >= 0 && j9 < 104 && k11 < 104) {
                    j4 = j4 * 128 + 64;
                    l6 = l6 * 128 + 64;
                    j9 = j9 * 128 + 64;
                    k11 = k11 * 128 + 64;
                    Projectile class44_sub3_sub4_sub3 = new Projectile(i20, getFloorDrawHeight(false, l6, j4, plane) - l16,
                            j18 + Game.loopCycle, k15, j4, k13, plane, l6, i19 + Game.loopCycle, l19, false,
                            k17);
                    class44_sub3_sub4_sub3.method500(getFloorDrawHeight(false, k11, j9, plane) - k17, true, k11, j18
                            + Game.loopCycle, j9);
                    aClass28_918.method256(class44_sub3_sub4_sub3);
                }
                return;
            }
            if (packetType == 233) {
                int i2 = in.readUnsignedByte();
                int k4 = anInt1037 + (i2 >> 4 & 7);
                int i7 = anInt1038 + (i2 & 7);
                int k9 = in.readUnsignedShort();
                int l11 = in.readUnsignedByte();
                int l13 = in.readUnsignedShort();
                if (k4 >= 0 && i7 >= 0 && k4 < 104 && i7 < 104) {
                    k4 = k4 * 128 + 64;
                    i7 = i7 * 128 + 64;
                    AnimableGameObject class44_sub3_sub4_sub5 = new AnimableGameObject(k4, plane, getFloorDrawHeight(false,
                            i7, k4, plane) - l11, l13, true, i7, k9, Game.loopCycle);
                    aClass28_1054.method256(class44_sub3_sub4_sub5);
                }
                return;
            }
            if (packetType == 176) {
                int j2 = in.readUnsignedByte();
                int l4 = anInt1037 + (j2 >> 4 & 7);
                int j7 = anInt1038 + (j2 & 7);
                int l9 = in.readUnsignedShort();
                int i12 = in.readUnsignedShort();
                int i14 = in.readUnsignedShort();
                if (l4 >= 0 && j7 >= 0 && l4 < 104 && j7 < 104 && i14 != localPlayerIndex) {
                    ObjStackEntity class44_sub3_sub4_sub2_2 = new ObjStackEntity();
                    class44_sub3_sub4_sub2_2.anInt1495 = l9;
                    class44_sub3_sub4_sub2_2.anInt1496 = i12;
                    if (planeObjStacks[plane][l4][j7] == null) {
                        planeObjStacks[plane][l4][j7] = new LinkedList(-199);
                    }
                    planeObjStacks[plane][l4][j7].method256(class44_sub3_sub4_sub2_2);
                    method92(l4, j7);
                }
                return;
            }
            if (packetType == 83) {
                int k2 = in.readUnsignedByte();
                int i5 = anInt1037 + (k2 >> 4 & 7);
                int k7 = anInt1038 + (k2 & 7);
                int i10 = in.readUnsignedByte();
                int j12 = i10 >> 2;
                int j14 = i10 & 3;
                int l15 = anIntArray1142[j12];
                int i17 = in.readUnsignedShort();
                int l17 = in.readUnsignedShort();
                int k18 = in.readUnsignedShort();
                int j19 = in.readUnsignedShort();
                byte byte0 = in.readByte();
                byte byte1 = in.readByte();
                byte byte2 = in.readByte();
                byte byte3 = in.readByte();
                PlayerEntity class44_sub3_sub4_sub6_sub1;
                if (j19 == localPlayerIndex) {
                    class44_sub3_sub4_sub6_sub1 = Game.self;
                } else {
                    class44_sub3_sub4_sub6_sub1 = players[j19];
                }
                if (class44_sub3_sub4_sub6_sub1 != null) {
                    LocType class8 = LocType.method199(i17);
                    int k20 = anIntArrayArrayArray865[plane][i5][k7];
                    int l20 = anIntArrayArrayArray865[plane][i5 + 1][k7];
                    int i21 = anIntArrayArrayArray865[plane][i5 + 1][k7 + 1];
                    int j21 = anIntArrayArrayArray865[plane][i5][k7 + 1];
                    Model class44_sub3_sub4_sub4 = class8.method205(j12, j14, k20, l20, i21, j21, -1);
                    if (class44_sub3_sub4_sub4 != null) {
                        method82(-23081, l17 + 1, plane, -1, 0, k7, 0, k18 + 1, l15, i5);
                        class44_sub3_sub4_sub6_sub1.anInt1682 = l17 + Game.loopCycle;
                        class44_sub3_sub4_sub6_sub1.anInt1683 = k18 + Game.loopCycle;
                        class44_sub3_sub4_sub6_sub1.aClass44_Sub3_Sub4_Sub4_1687 = class44_sub3_sub4_sub4;
                        int k21 = class8.anInt222;
                        int l21 = class8.anInt223;
                        if (j14 == 1 || j14 == 3) {
                            k21 = class8.anInt223;
                            l21 = class8.anInt222;
                        }
                        class44_sub3_sub4_sub6_sub1.anInt1684 = i5 * 128 + k21 * 64;
                        class44_sub3_sub4_sub6_sub1.anInt1686 = k7 * 128 + l21 * 64;
                        class44_sub3_sub4_sub6_sub1.anInt1685 = getFloorDrawHeight(false, class44_sub3_sub4_sub6_sub1.anInt1686,
                                class44_sub3_sub4_sub6_sub1.anInt1684, plane);
                        if (byte0 > byte2) {
                            byte byte4 = byte0;
                            byte0 = byte2;
                            byte2 = byte4;
                        }
                        if (byte1 > byte3) {
                            byte byte5 = byte1;
                            byte1 = byte3;
                            byte3 = byte5;
                        }
                        class44_sub3_sub4_sub6_sub1.anInt1688 = i5 + byte0;
                        class44_sub3_sub4_sub6_sub1.anInt1690 = i5 + byte2;
                        class44_sub3_sub4_sub6_sub1.anInt1689 = k7 + byte1;
                        class44_sub3_sub4_sub6_sub1.anInt1691 = k7 + byte3;
                    }
                }
            }
            if (packetType == 117) {
                int l2 = in.readUnsignedByte();
                int j5 = anInt1037 + (l2 >> 4 & 7);
                int l7 = anInt1038 + (l2 & 7);
                int j10 = in.readUnsignedShort();
                int k12 = in.readUnsignedShort();
                int k14 = in.readUnsignedShort();
                if (j5 >= 0 && l7 >= 0 && j5 < 104 && l7 < 104) {
                    LinkedList class28_1 = planeObjStacks[plane][j5][l7];
                    if (class28_1 != null) {
                        for (ObjStackEntity class44_sub3_sub4_sub2_3 = (ObjStackEntity) class28_1.peekFront(); class44_sub3_sub4_sub2_3 != null; class44_sub3_sub4_sub2_3 = (ObjStackEntity) class28_1
                                .prev(false)) {
                            if (class44_sub3_sub4_sub2_3.anInt1495 != (j10 & 0x7fff)
                                    || class44_sub3_sub4_sub2_3.anInt1496 != k12) {
                                continue;
                            }
                            class44_sub3_sub4_sub2_3.anInt1496 = k14;
                            break;
                        }
                        method92(j5, l7);
                    }
                }
                return;
            }
            if (packetType == 91) {
                int i3 = in.readUnsignedByte();
                int k5 = anInt1037 + (i3 >> 4 & 7);
                int i8 = anInt1038 + (i3 & 7);
                int k10 = in.readUnsignedShort();
                int l12 = in.readUnsignedByte();
                int l14 = l12 >> 4 & 0xf;
                int i16 = l12 & 7;
                if (Game.self.pathTileX[0] >= k5 - l14
                        && Game.self.pathTileX[0] <= k5 + l14
                        && Game.self.pathTileZ[0] >= i8 - l14
                        && Game.self.pathTileZ[0] <= i8 + l14
                        && aBoolean1050 && !Game.lowMemory && anInt968 < 50) {
                    anIntArray846[anInt968] = k10;
                    anIntArray1006[anInt968] = i16;
                    anIntArray1193[anInt968] = SoundTrack.anIntArray92[k10];
                    anInt968++;
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("80608, " + in + ", " + i + ", " + packetType + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method68(int i) {
        try {
            byte[] abyte0 = aClass47_1117.method549("title.dat", null);
            Image24 class44_sub3_sub1_sub2 = new Image24(abyte0, this);
            aClass34_1266.bind();
            class44_sub3_sub1_sub2.blitOpaque(0, 0);
            aClass34_1267.bind();
            class44_sub3_sub1_sub2.blitOpaque(-637, 0);
            title2.bind();
            class44_sub3_sub1_sub2.blitOpaque(-128, 0);
            title3.bind();
            class44_sub3_sub1_sub2.blitOpaque(-202, -371);
            title4.bind();
            class44_sub3_sub1_sub2.blitOpaque(-202, -171);
            title5.bind();
            class44_sub3_sub1_sub2.blitOpaque(0, -265);
            title6.bind();
            class44_sub3_sub1_sub2.blitOpaque(-562, -265);
            title7.bind();
            class44_sub3_sub1_sub2.blitOpaque(-128, -171);
            title8.bind();
            class44_sub3_sub1_sub2.blitOpaque(-562, -171);
            int[] ai = new int[class44_sub3_sub1_sub2.width];
            for (int j = 0; j < class44_sub3_sub1_sub2.height; j++) {
                for (int k = 0; k < class44_sub3_sub1_sub2.width; k++) {
                    ai[k] = class44_sub3_sub1_sub2.anIntArray1448[(class44_sub3_sub1_sub2.width - k - 1)
                            + class44_sub3_sub1_sub2.width * j];
                }
                for (int l = 0; l < class44_sub3_sub1_sub2.width; l++) {
                    class44_sub3_sub1_sub2.anIntArray1448[l + class44_sub3_sub1_sub2.width * j] = ai[l];
                }
            }
            aClass34_1266.bind();
            class44_sub3_sub1_sub2.blitOpaque(382, 0);
            aClass34_1267.bind();
            class44_sub3_sub1_sub2.blitOpaque(-255, 0);
            title2.bind();
            if (i != 0) {
                return;
            } else {
                class44_sub3_sub1_sub2.blitOpaque(254, 0);
                title3.bind();
                class44_sub3_sub1_sub2.blitOpaque(180, -371);
                title4.bind();
                class44_sub3_sub1_sub2.blitOpaque(180, -171);
                title5.bind();
                class44_sub3_sub1_sub2.blitOpaque(382, -265);
                title6.bind();
                class44_sub3_sub1_sub2.blitOpaque(-180, -265);
                title7.bind();
                class44_sub3_sub1_sub2.blitOpaque(254, -171);
                title8.bind();
                class44_sub3_sub1_sub2.blitOpaque(-180, -171);
                class44_sub3_sub1_sub2 = new Image24(aClass47_1117, "logo", 0);
                title2.bind();
                class44_sub3_sub1_sub2.method440(18, aByte1213, 382 - class44_sub3_sub1_sub2.width / 2 - 128);
                class44_sub3_sub1_sub2 = null;
                System.gc();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("12680, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void renderProjectiles(byte byte0) {
        try {
            for (Projectile class44_sub3_sub4_sub3 = (Projectile) aClass28_918.peekFront(); class44_sub3_sub4_sub3 != null; class44_sub3_sub4_sub3 = (Projectile) aClass28_918
                    .prev(false)) {
                if (class44_sub3_sub4_sub3.anInt1500 != plane
                        || Game.loopCycle > class44_sub3_sub4_sub3.anInt1506) {
                    class44_sub3_sub4_sub3.remove();
                } else if (Game.loopCycle >= class44_sub3_sub4_sub3.anInt1505) {
                    if (class44_sub3_sub4_sub3.anInt1509 > 0) {
                        NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[class44_sub3_sub4_sub3.anInt1509 - 1];
                        if (class44_sub3_sub4_sub6_sub2 != null
                                && class44_sub3_sub4_sub6_sub2.x >= 0
                                && class44_sub3_sub4_sub6_sub2.x < 13312
                                && class44_sub3_sub4_sub6_sub2.z >= 0
                                && class44_sub3_sub4_sub6_sub2.z < 13312) {
                            class44_sub3_sub4_sub3.method500(
                                    getFloorDrawHeight(false, class44_sub3_sub4_sub6_sub2.z,
                                            class44_sub3_sub4_sub6_sub2.x,
                                            class44_sub3_sub4_sub3.anInt1500)
                                            - class44_sub3_sub4_sub3.anInt1504, true,
                                    class44_sub3_sub4_sub6_sub2.z, Game.loopCycle,
                                    class44_sub3_sub4_sub6_sub2.x);
                        }
                    }
                    if (class44_sub3_sub4_sub3.anInt1509 < 0) {
                        int j = -class44_sub3_sub4_sub3.anInt1509 - 1;
                        PlayerEntity class44_sub3_sub4_sub6_sub1;
                        if (j == localPlayerIndex) {
                            class44_sub3_sub4_sub6_sub1 = Game.self;
                        } else {
                            class44_sub3_sub4_sub6_sub1 = players[j];
                        }
                        if (class44_sub3_sub4_sub6_sub1 != null
                                && class44_sub3_sub4_sub6_sub1.x >= 0
                                && class44_sub3_sub4_sub6_sub1.x < 13312
                                && class44_sub3_sub4_sub6_sub1.z >= 0
                                && class44_sub3_sub4_sub6_sub1.z < 13312) {
                            class44_sub3_sub4_sub3.method500(
                                    getFloorDrawHeight(false, class44_sub3_sub4_sub6_sub1.z,
                                            class44_sub3_sub4_sub6_sub1.x,
                                            class44_sub3_sub4_sub3.anInt1500)
                                            - class44_sub3_sub4_sub3.anInt1504, true,
                                    class44_sub3_sub4_sub6_sub1.z, Game.loopCycle,
                                    class44_sub3_sub4_sub6_sub1.x);
                        }
                    }
                    class44_sub3_sub4_sub3.method501(anInt824, -816);
                    scene.method289(60, -1, (int) class44_sub3_sub4_sub3.aDouble1513,
                            (int) class44_sub3_sub4_sub3.aDouble1511, 384, class44_sub3_sub4_sub3,
                            class44_sub3_sub4_sub3.anInt1519, false, (int) class44_sub3_sub4_sub3.aDouble1512,
                            plane);
                }
            }
            Game.anInt1167++;
            if (byte0 != aByte1053) {
                aBoolean1262 = !aBoolean1262;
            }

        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("60480, " + byte0 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method70(byte byte0) {
        try {
            aBoolean812 = true;
            for (int i = 0; i < 7; i++) {
                anIntArray849[i] = -1;
                for (int j = 0; j < IDKType.anInt463; j++) {
                    if (IDKType.cache[j].aBoolean470 || IDKType.cache[j].anInt465 != i + (aBoolean1179 ? 0 : 7)) {
                        continue;
                    }
                    anIntArray849[i] = j;
                    break;
                }
            }
            if (byte0 != -127) {
                packetType = in.readUnsignedByte();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("72183, " + byte0 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method71(Buffer class44_sub3_sub2, boolean flag, int i) {
        try {
            if (flag) {
                aBoolean1147 = !aBoolean1147;
            }
            for (int j = 0; j < anInt1228; j++) {
                int k = anIntArray1229[j];
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[k];
                int l = class44_sub3_sub2.readUnsignedByte();
                if ((l & 0x80) == 128) {
                    l += class44_sub3_sub2.readUnsignedByte() << 8;
                }
                method46(l, (byte) -106, class44_sub3_sub2, k, class44_sub3_sub4_sub6_sub1);
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27562, " + class44_sub3_sub2 + ", " + flag + ", " + i + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public String method72(int i, boolean flag) {
        try {
            if (flag) {
                method6();
            }
            if (i < 0x3b9ac9ff) {
                return String.valueOf(i);
            } else {
                return "*";
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("94656, " + i + ", " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method73(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
        try {
            if (j != 0) {
                out.writeByte(179);
            }
            if (j1 >= 1 && l1 >= 1 && j1 <= 102 && l1 <= 102) {
                if (Game.lowMemory && l != plane) {
                    return;
                }
                int i2 = 0;
                if (k1 == 0) {
                    i2 = scene.method304(l, j1, l1);
                }
                if (k1 == 1) {
                    i2 = scene.method305(l1, 7, l, j1);
                }
                if (k1 == 2) {
                    i2 = scene.method306(l, j1, l1);
                }
                if (k1 == 3) {
                    i2 = scene.method307(l, j1, l1);
                }
                if (i2 != 0) {
                    int i3 = scene.method308(l, j1, l1, i2);
                    int j2 = i2 >> 14 & 0x7fff;
                    int k2 = i3 & 0x1f;
                    int l2 = i3 >> 6;
                    if (k1 == 0) {
                        scene.method295(l1, j1, (byte) 7, l);
                        LocType class8 = LocType.method199(j2);
                        if (class8.aBoolean224) {
                            aClass18Array1022[l].method236(l2, k2, l1, j1, class8.aBoolean225, (byte) 3);
                        }
                    }
                    if (k1 == 1) {
                        scene.method296(537, l, l1, j1);
                    }
                    if (k1 == 2) {
                        scene.method297(2, l, l1, j1);
                        LocType class8_1 = LocType.method199(j2);
                        if (j1 + class8_1.anInt222 > 103 || l1 + class8_1.anInt222 > 103
                                || j1 + class8_1.anInt223 > 103 || l1 + class8_1.anInt223 > 103) {
                            return;
                        }
                        if (class8_1.aBoolean224) {
                            aClass18Array1022[l].method237(class8_1.anInt223, l1, j1, class8_1.aBoolean225, 8, l2,
                                    class8_1.anInt222);
                        }
                    }
                    if (k1 == 3) {
                        scene.method298(j1, l1, 3, l);
                        LocType class8_2 = LocType.method199(j2);
                        if (class8_2.aBoolean224 && class8_2.aBoolean226) {
                            aClass18Array1022[l].method239(l1, true, j1);
                        }
                    }
                }
                if (i1 >= 0) {
                    int j3 = l;
                    if (j3 < 3 && (planeTileFlags[1][j1][l1] & 2) == 2) {
                        j3++;
                    }
                    regionCached.method174(i, l, l1, k, anIntArrayArrayArray865, j3, j1, aClass18Array1022[l], scene,
                            i1, 0);
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("55555, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", " + k1
                    + ", " + l1 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method74(int i, Actor class44_sub3_sub4_sub6, int j) {
        try {
            if (j != 0) {
                anInt964 = encryption.method545();
            }
            method75(class44_sub3_sub4_sub6.x, i, (byte) -79, class44_sub3_sub4_sub6.z);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("86761, " + i + ", " + class44_sub3_sub4_sub6 + ", " + j + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method75(int i, int j, byte byte0, int k) {
        try {
            if (i < 128 || k < 128 || i > 13056 || k > 13056) {
                anInt1064 = -1;
                anInt1065 = -1;
                return;
            }
            int l = getFloorDrawHeight(false, k, i, plane) - j;
            i -= cameraPositionX;
            if (byte0 != -79) {
                out.writeByte(22);
            }
            l -= cameraPositionY;
            k -= cameraPositionZ;
            int i1 = Model.SINE[cameraVerticalRotation];
            int j1 = Model.COSINE[cameraVerticalRotation];
            int k1 = Model.SINE[anInt879];
            int l1 = Model.COSINE[anInt879];
            int i2 = k * k1 + i * l1 >> 16;
            k = k * l1 - i * k1 >> 16;
            i = i2;
            i2 = l * j1 - k * i1 >> 16;
            k = l * i1 + k * j1 >> 16;
            l = i2;
            if (k >= 50) {
                anInt1064 = Draw3D.anInt1423 + (i << 9) / k;
                anInt1065 = Draw3D.anInt1424 + (l << 9) / k;
                return;
            } else {
                anInt1064 = -1;
                anInt1065 = -1;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20782, " + i + ", " + j + ", " + byte0 + ", " + k + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method76(byte byte0) {
        try {
            LocType.aClass39_251.method341();
            LocType.aClass39_252.method341();
            if (byte0 != -71) {
                anInt1056 = encryption.method545();
            }
            NpcType.aClass39_307.method341();
            ObjType.aClass39_369.method341();
            ObjType.aClass39_370.method341();
            PlayerEntity.aClass39_1696.method341();
            SpotAnimType.aClass39_571.method341();
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("83788, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public DataInputStream method77(String s) throws IOException {
        if (!aBoolean922) {
            if (SignLink.mainapp != null) {
                return SignLink.openurl(s);
            } else {
                return new DataInputStream((new URL(getCodeBase(), s)).openStream());
            }
        }
        if (aSocket1013 != null) {
            try {
                aSocket1013.close();
            } catch (Exception _ex) {
            }
            aSocket1013 = null;
        }
        aSocket1013 = method34(43595);
        aSocket1013.setSoTimeout(10000);
        java.io.InputStream inputstream = aSocket1013.getInputStream();
        OutputStream outputstream = aSocket1013.getOutputStream();
        outputstream.write(("JAGGRAB /" + s + "\n\n").getBytes());
        return new DataInputStream(inputstream);
    }

    public boolean method78(int i, int j, boolean flag, int k, int l) {
        try {
            int i1 = i >> 14 & 0x7fff;
            int j1 = scene.method308(plane, l, k, i);
            if (j1 == -1) {
                return false;
            }
            int k1 = j1 & 0x1f;
            int l1 = j1 >> 6 & 3;
            Game.anInt1207++;
            if (Game.anInt1207 > 1086) {
                Game.anInt1207 = 0;
                out.writePacket(154);
                out.writeByte(0);
                int i2 = out.position;
                if ((int) (Math.random() * 2D) == 0) {
                    out.writeShort(16791);
                }
                out.writeByte(254);
                out.writeShort((int) (Math.random() * 65536D));
                out.writeShort(16128);
                out.writeShort(52610);
                out.writeShort((int) (Math.random() * 65536D));
                out.writeShort(55420);
                if ((int) (Math.random() * 2D) == 0) {
                    out.writeShort(35025);
                }
                out.writeShort(46628);
                out.writeByte((int) (Math.random() * 256D));
                out.method481(out.position - i2, anInt1152);
            }
            if (k1 == 10 || k1 == 11 || k1 == 22) {
                LocType class8 = LocType.method199(i1);
                int j2;
                int k2;
                if (l1 == 0 || l1 == 2) {
                    j2 = class8.anInt222;
                    k2 = class8.anInt223;
                } else {
                    j2 = class8.anInt223;
                    k2 = class8.anInt222;
                }
                int l2 = class8.anInt245;
                if (l1 != 0) {
                    l2 = (l2 << l1 & 0xf) + (l2 >> 4 - l1);
                }
                tryMove(j2, Game.self.pathTileX[0], 0, k, l2, 0,
                        false, 2, 124, k2, l, Game.self.pathTileZ[0]);
            } else {
                tryMove(0, Game.self.pathTileX[0], l1, k, 0, k1 + 1,
                        false, 2, 124, 0, l, Game.self.pathTileZ[0]);
            }
            crossX = super.mousePressX;
            if (flag) {
                Game.anInt1246 = -113;
            }
            crossY = super.mousePressY;
            crossMode = 2;
            crossCycle = 0;
            out.writePacket(j);
            out.writeShort(l + sceneBaseTileX);
            out.writeShort(k + sceneBaseTileZ);
            out.writeShort(i1);
            return true;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("86165, " + i + ", " + j + ", " + flag + ", " + k + ", " + l + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method79(byte byte0) {
        try {
            if (byte0 != 9) {
                anInt964 = -393;
            }
            return SignLink.wavereplay();
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96494, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method80(String s, int i) {
        try {
            if (i < 3 || i > 3) {
                aBoolean985 = !aBoolean985;
            }
            if (s == null) {
                return false;
            }
            for (int j = 0; j < anInt1104; j++) {
                if (s.equalsIgnoreCase(aStringArray1044[j])) {
                    return true;
                }
            }
            return s.equalsIgnoreCase(Game.self.aString1672);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("59627, " + s + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method81(int i, int j, Component class5, int k, boolean flag, int l, byte byte0, int i1, int j1) {
        try {
            if (aBoolean1156) {
                anInt832 = 32;
            } else {
                anInt832 = 0;
            }
            aBoolean1156 = false;
            if (byte0 != -83) {
                out.writeByte(103);
            }
            if (j >= k && j < k + 16 && i1 >= i && i1 < i + 16) {
                class5.anInt120 -= anInt1066 * 4;
                if (flag) {
                    redrawInvBack = true;
                    return;
                }
            } else if (j >= k && j < k + 16 && i1 >= (i + l) - 16 && i1 < i + l) {
                class5.anInt120 += anInt1066 * 4;
                if (flag) {
                    redrawInvBack = true;
                    return;
                }
            } else if (j >= k - anInt832 && j < k + 16 + anInt832 && i1 >= i + 16 && i1 < (i + l) - 16 && anInt1066 > 0) {
                int k1 = ((l - 32) * l) / j1;
                if (k1 < 8) {
                    k1 = 8;
                }
                int l1 = i1 - i - 16 - k1 / 2;
                int i2 = l - 32 - k1;
                class5.anInt120 = ((j1 - l) * l1) / i2;
                if (flag) {
                    redrawInvBack = true;
                }
                aBoolean1156 = true;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("35389, " + i + ", " + j + ", " + class5 + ", " + k + ", " + flag + ", " + l + ", "
                    + byte0 + ", " + i1 + ", " + j1 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void method10(boolean flag) {
        try {
            redrawTitleBackground = true;
            if (flag) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20297, " + flag + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void method82(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2) {
        try {
            SceneLocTemporary class44_sub1 = null;
            SceneLocTemporary class44_sub1_1 = (SceneLocTemporary) listTemporaryLocs.peekFront();
            if (i != -23081) {
                return;
            }
            for (; class44_sub1_1 != null; class44_sub1_1 = (SceneLocTemporary) listTemporaryLocs.prev(false)) {
                if (class44_sub1_1.anInt1323 != k || class44_sub1_1.sceneTileX != j2 || class44_sub1_1.sceneTileZ != j1
                        || class44_sub1_1.anInt1324 != i2) {
                    continue;
                }
                class44_sub1 = class44_sub1_1;
                break;
            }
            if (class44_sub1 == null) {
                class44_sub1 = new SceneLocTemporary();
                class44_sub1.anInt1323 = k;
                class44_sub1.anInt1324 = i2;
                class44_sub1.sceneTileX = j2;
                class44_sub1.sceneTileZ = j1;
                method139(class44_sub1, false);
                listTemporaryLocs.method256(class44_sub1);
            }
            class44_sub1.anInt1330 = l;
            class44_sub1.anInt1332 = i1;
            class44_sub1.anInt1331 = k1;
            class44_sub1.anInt1333 = j;
            class44_sub1.anInt1334 = l1;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("49827, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", " + k1
                    + ", " + l1 + ", " + i2 + ", " + j2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method83(byte byte0) {
        try {
            for (int i = -1; i < anInt1226; i++) {
                int j;
                if (i == -1) {
                    j = anInt1224;
                } else {
                    j = anIntArray1227[i];
                }
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[j];
                if (class44_sub3_sub4_sub6_sub1 != null) {
                    method117(-34028, class44_sub3_sub4_sub6_sub1, 1);
                }
            }
            if (byte0 == 5) {
                byte0 = 0;
                return;
            } else {
                method6();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("82180, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method84(int i) {
        try {
            char c = '\u0100';
            if (i != 0) {
                out.writeByte(28);
            }
            if (anInt1259 > 0) {
                for (int j = 0; j < 256; j++) {
                    if (anInt1259 > 768) {
                        anIntArray1218[j] = method91(anIntArray1219[j], anIntArray1220[j], 1024 - anInt1259, 35);
                    } else if (anInt1259 > 256) {
                        anIntArray1218[j] = anIntArray1220[j];
                    } else {
                        anIntArray1218[j] = method91(anIntArray1220[j], anIntArray1219[j], 256 - anInt1259, 35);
                    }
                }
            } else if (anInt1260 > 0) {
                for (int k = 0; k < 256; k++) {
                    if (anInt1260 > 768) {
                        anIntArray1218[k] = method91(anIntArray1219[k], anIntArray1221[k], 1024 - anInt1260, 35);
                    } else if (anInt1260 > 256) {
                        anIntArray1218[k] = anIntArray1221[k];
                    } else {
                        anIntArray1218[k] = method91(anIntArray1221[k], anIntArray1219[k], 256 - anInt1260, 35);
                    }
                }
            } else {
                for (int l = 0; l < 256; l++) {
                    anIntArray1218[l] = anIntArray1219[l];
                }
            }
            for (int i1 = 0; i1 < 33920; i1++) {
                aClass34_1266.pixels[i1] = aClass44_Sub3_Sub1_Sub2_1277.anIntArray1448[i1];
            }
            int j1 = 0;
            int k1 = 1152;
            for (int l1 = 1; l1 < c - 1; l1++) {
                int i2 = (anIntArray1018[l1] * (c - l1)) / c;
                int k2 = 22 + i2;
                if (k2 < 0) {
                    k2 = 0;
                }
                j1 += k2;
                for (int i3 = k2; i3 < 128; i3++) {
                    int k3 = anIntArray1272[j1++];
                    if (k3 != 0) {
                        int i4 = k3;
                        int k4 = 256 - k3;
                        k3 = anIntArray1218[k3];
                        int i5 = aClass34_1266.pixels[k1];
                        aClass34_1266.pixels[k1++] = ((k3 & 0xff00ff) * i4 + (i5 & 0xff00ff) * k4 & 0xff00ff00)
                                + ((k3 & 0xff00) * i4 + (i5 & 0xff00) * k4 & 0xff0000) >> 8;
                    } else {
                        k1++;
                    }
                }
                k1 += k2;
            }
            aClass34_1266.draw(super.graphics, 0, 0);
            for (int j2 = 0; j2 < 33920; j2++) {
                aClass34_1267.pixels[j2] = aClass44_Sub3_Sub1_Sub2_1278.anIntArray1448[j2];
            }
            j1 = 0;
            k1 = 1176;
            for (int l2 = 1; l2 < c - 1; l2++) {
                int j3 = (anIntArray1018[l2] * (c - l2)) / c;
                int l3 = 103 - j3;
                k1 += j3;
                for (int j4 = 0; j4 < l3; j4++) {
                    int l4 = anIntArray1272[j1++];
                    if (l4 != 0) {
                        int j5 = l4;
                        int k5 = 256 - l4;
                        l4 = anIntArray1218[l4];
                        int l5 = aClass34_1267.pixels[k1];
                        aClass34_1267.pixels[k1++] = ((l4 & 0xff00ff) * j5 + (l5 & 0xff00ff) * k5 & 0xff00ff00)
                                + ((l4 & 0xff00) * j5 + (l5 & 0xff00) * k5 & 0xff0000) >> 8;
                    } else {
                        k1++;
                    }
                }
                j1 += 128 - l3;
                k1 += 128 - l3 - j3;
            }
            aClass34_1267.draw(super.graphics, 637, 0);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27482, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public URL getCodeBase() {
        if (SignLink.mainapp != null) {
            return SignLink.mainapp.getCodeBase();
        }
        try {
            if (super.aFrame_Sub1_16 != null) {
                return new URL("http://127.0.0.1:" + (80 + Game.portOffset));
            }
        } catch (Exception _ex) {
        }
        return super.getCodeBase();
    }

    public void method85(boolean flag, int i) {
        try {
            if (!flag) {
                packetType = in.readUnsignedByte();
            }
            SignLink.wavevol = i;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("41016, " + flag + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method86(int i, int j, int k, byte byte0, int l, int i1) {
        try {
            int j1 = scene.method304(l, i, j);
            if (j1 != 0) {
                int k1 = scene.method308(l, i, j, j1);
                int j2 = k1 >> 6 & 3;
                int l2 = k1 & 0x1f;
                int j3 = k;
                if (j1 > 0) {
                    j3 = i1;
                }
                int[] ai = aClass44_Sub3_Sub1_Sub2_913.anIntArray1448;
                int j4 = 24624 + i * 4 + (103 - j) * 512 * 4;
                int l4 = j1 >> 14 & 0x7fff;
                LocType class8_2 = LocType.method199(l4);
                if (class8_2.anInt236 != -1) {
                    Image8 class44_sub3_sub1_sub3_2 = aClass44_Sub3_Sub1_Sub3Array1241[class8_2.anInt236];
                    if (class44_sub3_sub1_sub3_2 != null) {
                        int l5 = (class8_2.anInt222 * 4 - class44_sub3_sub1_sub3_2.anInt1460) / 2;
                        int i6 = (class8_2.anInt223 * 4 - class44_sub3_sub1_sub3_2.anInt1461) / 2;
                        class44_sub3_sub1_sub3_2.blit(48 + (104 - j - class8_2.anInt223) * 4 + i6, 48
                                + i * 4 + l5);
                    }
                } else {
                    if (l2 == 0 || l2 == 2) {
                        if (j2 == 0) {
                            ai[j4] = j3;
                            ai[j4 + 512] = j3;
                            ai[j4 + 1024] = j3;
                            ai[j4 + 1536] = j3;
                        } else if (j2 == 1) {
                            ai[j4] = j3;
                            ai[j4 + 1] = j3;
                            ai[j4 + 2] = j3;
                            ai[j4 + 3] = j3;
                        } else if (j2 == 2) {
                            ai[j4 + 3] = j3;
                            ai[j4 + 3 + 512] = j3;
                            ai[j4 + 3 + 1024] = j3;
                            ai[j4 + 3 + 1536] = j3;
                        } else if (j2 == 3) {
                            ai[j4 + 1536] = j3;
                            ai[j4 + 1536 + 1] = j3;
                            ai[j4 + 1536 + 2] = j3;
                            ai[j4 + 1536 + 3] = j3;
                        }
                    }
                    if (l2 == 3) {
                        if (j2 == 0) {
                            ai[j4] = j3;
                        } else if (j2 == 1) {
                            ai[j4 + 3] = j3;
                        } else if (j2 == 2) {
                            ai[j4 + 3 + 1536] = j3;
                        } else if (j2 == 3) {
                            ai[j4 + 1536] = j3;
                        }
                    }
                    if (l2 == 2) {
                        if (j2 == 3) {
                            ai[j4] = j3;
                            ai[j4 + 512] = j3;
                            ai[j4 + 1024] = j3;
                            ai[j4 + 1536] = j3;
                        } else if (j2 == 0) {
                            ai[j4] = j3;
                            ai[j4 + 1] = j3;
                            ai[j4 + 2] = j3;
                            ai[j4 + 3] = j3;
                        } else if (j2 == 1) {
                            ai[j4 + 3] = j3;
                            ai[j4 + 3 + 512] = j3;
                            ai[j4 + 3 + 1024] = j3;
                            ai[j4 + 3 + 1536] = j3;
                        } else if (j2 == 2) {
                            ai[j4 + 1536] = j3;
                            ai[j4 + 1536 + 1] = j3;
                            ai[j4 + 1536 + 2] = j3;
                            ai[j4 + 1536 + 3] = j3;
                        }
                    }
                }
            }
            j1 = scene.method306(l, i, j);
            if (j1 != 0) {
                int l1 = scene.method308(l, i, j, j1);
                int k2 = l1 >> 6 & 3;
                int i3 = l1 & 0x1f;
                int k3 = j1 >> 14 & 0x7fff;
                LocType class8_1 = LocType.method199(k3);
                if (class8_1.anInt236 != -1) {
                    Image8 class44_sub3_sub1_sub3_1 = aClass44_Sub3_Sub1_Sub3Array1241[class8_1.anInt236];
                    if (class44_sub3_sub1_sub3_1 != null) {
                        int i5 = (class8_1.anInt222 * 4 - class44_sub3_sub1_sub3_1.anInt1460) / 2;
                        int j5 = (class8_1.anInt223 * 4 - class44_sub3_sub1_sub3_1.anInt1461) / 2;
                        class44_sub3_sub1_sub3_1.blit(48 + (104 - j - class8_1.anInt223) * 4 + j5, 48
                                + i * 4 + i5);
                    }
                } else if (i3 == 9) {
                    int k4 = 0xeeeeee;
                    if (j1 > 0) {
                        k4 = 0xee0000;
                    }
                    int[] ai1 = aClass44_Sub3_Sub1_Sub2_913.anIntArray1448;
                    int k5 = 24624 + i * 4 + (103 - j) * 512 * 4;
                    if (k2 == 0 || k2 == 2) {
                        ai1[k5 + 1536] = k4;
                        ai1[k5 + 1024 + 1] = k4;
                        ai1[k5 + 512 + 2] = k4;
                        ai1[k5 + 3] = k4;
                    } else {
                        ai1[k5] = k4;
                        ai1[k5 + 512 + 1] = k4;
                        ai1[k5 + 1024 + 2] = k4;
                        ai1[k5 + 1536 + 3] = k4;
                    }
                }
            }
            j1 = scene.method307(l, i, j);
            if (byte0 == 5) {
                byte0 = 0;
            } else {
                aBoolean1262 = !aBoolean1262;
            }
            if (j1 != 0) {
                int i2 = j1 >> 14 & 0x7fff;
                LocType class8 = LocType.method199(i2);
                if (class8.anInt236 != -1) {
                    Image8 class44_sub3_sub1_sub3 = aClass44_Sub3_Sub1_Sub3Array1241[class8.anInt236];
                    if (class44_sub3_sub1_sub3 != null) {
                        int l3 = (class8.anInt222 * 4 - class44_sub3_sub1_sub3.anInt1460) / 2;
                        int i4 = (class8.anInt223 * 4 - class44_sub3_sub1_sub3.anInt1461) / 2;
                        class44_sub3_sub1_sub3.blit(48 + (104 - j - class8.anInt223) * 4 + i4, 48 + i
                                * 4 + l3);
                        return;
                    }
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("97581, " + i + ", " + j + ", " + k + ", " + byte0 + ", " + l + ", " + i1 + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void resetTitleScreen() {
        try {
            if (title2 != null) {
                return;
            }
            super.aClass34_14 = null;
            aClass34_1198 = null;
            aClass34_1196 = null;
            aClass34_1195 = null;
            areaViewport = null;
            aClass34_858 = null;
            aClass34_859 = null;
            aClass34_860 = null;
            aClass34_1266 = new DrawArea(128, 265);
            Draw2D.method409((byte) 127);
            aClass34_1267 = new DrawArea(128, 265);
            Draw2D.method409((byte) 127);
            title2 = new DrawArea(509, 171);
            Draw2D.method409((byte) 127);
            title3 = new DrawArea(360, 132);
            Draw2D.method409((byte) 127);
            title4 = new DrawArea(360, 200);
            Draw2D.method409((byte) 127);
            title5 = new DrawArea(202, 238);
            Draw2D.method409((byte) 127);
            title6 = new DrawArea(203, 238);
            Draw2D.method409((byte) 127);
            title7 = new DrawArea(74, 94);
            Draw2D.method409((byte) 127);
            title8 = new DrawArea(75, 94);
            Draw2D.method409((byte) 127);
            if (aClass47_1117 != null) {
                method68(0);
                method48(-532);
            }
            redrawTitleBackground = true;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("94767, " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public boolean method88(Component class5, int i) {
        try {
            if (i != 0) {
                throw new NullPointerException();
            }
            if (class5.anIntArray116 == null) {
                return false;
            }
            for (int j = 0; j < class5.anIntArray116.length; j++) {
                int k = method94(j, aByte1086, class5);
                int l = class5.anIntArray117[j];
                if (class5.anIntArray116[j] == 2) {
                    if (k >= l) {
                        return false;
                    }
                } else if (class5.anIntArray116[j] == 3) {
                    if (k <= l) {
                        return false;
                    }
                } else if (class5.anIntArray116[j] == 4) {
                    if (k == l) {
                        return false;
                    }
                } else if (k != l) {
                    return false;
                }
            }
            return true;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20821, " + class5 + ", " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method89(int i) {
        try {
            int j = fontBold.method457("Choose Option", true);
            for (int k = 0; k < menuSize; k++) {
                int l = fontBold.method457(aStringArray897[k], true);
                if (l > j) {
                    j = l;
                }
            }
            j += 8;
            if (i != 0) {
                aBoolean1036 = !aBoolean1036;
            }
            int i1 = 15 * menuSize + 21;
            if (super.mousePressX > 4 && super.mousePressY > 4 && super.mousePressX < 516 && super.mousePressY < 338) {
                int j1 = super.mousePressX - 4 - j / 2;
                if (j1 + j > 512) {
                    j1 = 512 - j;
                }
                if (j1 < 0) {
                    j1 = 0;
                }
                int i2 = super.mousePressY - 4;
                if (i2 + i1 > 334) {
                    i2 = 334 - i1;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                menuVisible = true;
                anInt1030 = 0;
                anInt1031 = j1;
                anInt1032 = i2;
                anInt1033 = j;
                anInt1034 = 15 * menuSize + 22;
            }
            if (super.mousePressX > 553 && super.mousePressY > 205 && super.mousePressX < 743 && super.mousePressY < 466) {
                int k1 = super.mousePressX - 553 - j / 2;
                if (k1 < 0) {
                    k1 = 0;
                } else if (k1 + j > 190) {
                    k1 = 190 - j;
                }
                int j2 = super.mousePressY - 205;
                if (j2 < 0) {
                    j2 = 0;
                } else if (j2 + i1 > 261) {
                    j2 = 261 - i1;
                }
                menuVisible = true;
                anInt1030 = 1;
                anInt1031 = k1;
                anInt1032 = j2;
                anInt1033 = j;
                anInt1034 = 15 * menuSize + 22;
            }
            if (super.mousePressX > 17 && super.mousePressY > 357 && super.mousePressX < 496 && super.mousePressY < 453) {
                int l1 = super.mousePressX - 17 - j / 2;
                if (l1 < 0) {
                    l1 = 0;
                } else if (l1 + j > 479) {
                    l1 = 479 - j;
                }
                int k2 = super.mousePressY - 357;
                if (k2 < 0) {
                    k2 = 0;
                } else if (k2 + i1 > 96) {
                    k2 = 96 - i1;
                }
                menuVisible = true;
                anInt1030 = 2;
                anInt1031 = l1;
                anInt1032 = k2;
                anInt1033 = j;
                anInt1034 = 15 * menuSize + 22;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("90690, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method90(int i, Buffer class44_sub3_sub2, int j) {
        try {
            while (true) {
                if (class44_sub3_sub2.anInt1393 + 10 >= i * 8) {
                    break;
                }
                int k = class44_sub3_sub2.method493(11, false);
                if (k == 2047) {
                    break;
                }
                if (players[k] == null) {
                    players[k] = new PlayerEntity();
                    if (aClass44_Sub3_Sub2Array1230[k] != null) {
                        players[k].method537(false, aClass44_Sub3_Sub2Array1230[k]);
                    }
                }
                anIntArray1227[anInt1226++] = k;
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[k];
                class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                int l = class44_sub3_sub2.method493(5, false);
                if (l > 15) {
                    l -= 32;
                }
                int i1 = class44_sub3_sub2.method493(5, false);
                if (i1 > 15) {
                    i1 -= 32;
                }
                int j1 = class44_sub3_sub2.method493(1, false);
                class44_sub3_sub4_sub6_sub1.method532(
                        Game.self.pathTileX[0] + l, j1 == 1,
                        Game.self.pathTileZ[0] + i1, aByte925);
                int k1 = class44_sub3_sub2.method493(1, false);
                if (k1 == 1) {
                    anIntArray1229[anInt1228++] = k;
                }
            }
            class44_sub3_sub2.method494((byte) 4);
            if (j != 0) {
                Game.anInt958 = 328;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("29713, " + i + ", " + class44_sub3_sub2 + ", " + j + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public int method91(int i, int j, int k, int l) {
        try {
            l = 95 / l;
            int i1 = 256 - k;
            return ((i & 0xff00ff) * i1 + (j & 0xff00ff) * k & 0xff00ff00)
                    + ((i & 0xff00) * i1 + (j & 0xff00) * k & 0xff0000) >> 8;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("66303, " + i + ", " + j + ", " + k + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method92(int i, int j) {
        LinkedList class28 = planeObjStacks[plane][i][j];
        if (class28 == null) {
            scene.method299(plane, i, j);
            return;
        }
        int k = 0xfa0a1f01;
        Object obj = null;
        for (ObjStackEntity class44_sub3_sub4_sub2 = (ObjStackEntity) class28.peekFront(); class44_sub3_sub4_sub2 != null; class44_sub3_sub4_sub2 = (ObjStackEntity) class28
                .prev(false)) {
            ObjType class14 = ObjType.method220(class44_sub3_sub4_sub2.anInt1495);
            int l = class14.anInt343;
            if (class14.aBoolean342) {
                l *= class44_sub3_sub4_sub2.anInt1496 + 1;
            }
            if (l > k) {
                k = l;
                obj = class44_sub3_sub4_sub2;
            }
        }
        class28.method257(((Node) (obj)), -12925);
        Object obj1 = null;
        Object obj2 = null;
        for (ObjStackEntity class44_sub3_sub4_sub2_1 = (ObjStackEntity) class28.peekFront(); class44_sub3_sub4_sub2_1 != null; class44_sub3_sub4_sub2_1 = (ObjStackEntity) class28
                .prev(false)) {
            if (class44_sub3_sub4_sub2_1.anInt1495 != ((ObjStackEntity) (obj)).anInt1495 && obj1 == null) {
                obj1 = class44_sub3_sub4_sub2_1;
            }
            if (class44_sub3_sub4_sub2_1.anInt1495 != ((ObjStackEntity) (obj)).anInt1495
                    && class44_sub3_sub4_sub2_1.anInt1495 != ((ObjStackEntity) (obj1)).anInt1495 && obj2 == null) {
                obj2 = class44_sub3_sub4_sub2_1;
            }
        }
        int i1 = i + (j << 7) + 0x60000000;
        scene.method285(j, i1, ((Renderable) (obj1)), i, (byte) 2, ((Renderable) (obj2)), plane,
                getFloorDrawHeight(false, j * 128 + 64, i * 128 + 64, plane), ((Renderable) (obj)));
    }

    public void method93(boolean flag) {
        try {
            if (flag) {
                packetType = in.readUnsignedByte();
            }
            do {
                OnDemandNode class44_sub3_sub3;
                do {
                    class44_sub3_sub3 = ondemand.method394();
                    if (class44_sub3_sub3 == null) {
                        return;
                    }
                    if (class44_sub3_sub3.anInt1405 == 0) {
                        Model.method504(class44_sub3_sub3.aByteArray1407, class44_sub3_sub3.anInt1406, (byte) 23);
                        if ((ondemand.method390(class44_sub3_sub3.anInt1406, -600) & 0x62) != 0) {
                            redrawInvBack = true;
                            if (anInt1253 != -1) {
                                redrawChatback = true;
                            }
                        }
                    }
                    if (class44_sub3_sub3.anInt1405 == 1 && class44_sub3_sub3.aByteArray1407 != null) {
                        SeqFrame.method208(2, class44_sub3_sub3.aByteArray1407);
                    }
                    if (class44_sub3_sub3.anInt1405 == 2 && class44_sub3_sub3.anInt1406 == anInt1190
                            && class44_sub3_sub3.aByteArray1407 != null) {
                        method33((byte) 27, class44_sub3_sub3.aByteArray1407, aBoolean1191);
                    }
                    if (class44_sub3_sub3.anInt1405 == 3 && sceneState == 1) {
                        for (int i = 0; i < sceneMapLandData.length; i++) {
                            if (sceneMapLandFile[i] == class44_sub3_sub3.anInt1406) {
                                sceneMapLandData[i] = class44_sub3_sub3.aByteArray1407;
                                if (class44_sub3_sub3.aByteArray1407 == null) {
                                    sceneMapLandFile[i] = -1;
                                }
                                break;
                            }
                            if (sceneMapLocFile[i] != class44_sub3_sub3.anInt1406) {
                                continue;
                            }
                            sceneMapLocData[i] = class44_sub3_sub3.aByteArray1407;
                            if (class44_sub3_sub3.aByteArray1407 == null) {
                                sceneMapLocFile[i] = -1;
                            }
                            break;
                        }
                    }
                } while (class44_sub3_sub3.anInt1405 != 93
                        || !ondemand.method389(class44_sub3_sub3.anInt1406, anInt857));
                regionCached.method160(ondemand, new Buffer(class44_sub3_sub3.aByteArray1407), anInt1247);
            } while (true);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("44515, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method94(int i, byte byte0, Component class5) {
        try {
            if (byte0 != aByte884) {
                out.writeByte(14);
            }
            if (class5.anIntArrayArray115 == null || i >= class5.anIntArrayArray115.length) {
                return -2;
            }
            try {
                int[] ai = class5.anIntArrayArray115[i];
                int j = 0;
                int k = 0;
                int l = 0;
                do {
                    int op = ai[k++];
                    int j1 = 0;
                    byte byte1 = 0;
                    if (op == 0) {
                        return j;
                    }
                    if (op == 1) {
                        j1 = anIntArray1035[ai[k++]];
                    }
                    if (op == 2) {
                        j1 = anIntArray1090[ai[k++]];
                    }
                    if (op == 3) {
                        j1 = anIntArray851[ai[k++]];
                    }
                    if (op == 4) {
                        Component class5_1 = Component.instances[ai[k++]];
                        int j2 = ai[k++];
                        if (j2 >= 0 && j2 < ObjType.anInt323
                                && (!ObjType.method220(j2).aBoolean344 || Game.membersWorld)) {
                            for (int i3 = 0; i3 < class5_1.containerItemId.length; i3++) {
                                if (class5_1.containerItemId[i3] == j2 + 1) {
                                    j1 += class5_1.containerItemAmount[i3];
                                }
                            }
                        }
                    }
                    if (op == 5) {
                        j1 = anIntArray1214[ai[k++]];
                    }
                    if (op == 6) {
                        j1 = Game.levelExperience[anIntArray1090[ai[k++]] - 1];
                    }
                    if (op == 7) {
                        j1 = (anIntArray1214[ai[k++]] * 100) / 46875;
                    }
                    if (op == 8) {
                        j1 = Game.self.anInt1678;
                    }
                    if (op == 9) {
                        for (int k1 = 0; k1 < SkillConstants.skillCount; k1++) {
                            if (SkillConstants.skillActive[k1]) {
                                j1 += anIntArray1090[k1];
                            }
                        }
                    }
                    if (op == 10) {
                        Component class5_2 = Component.instances[ai[k++]];
                        int k2 = ai[k++] + 1;
                        if (k2 >= 0 && k2 < ObjType.anInt323
                                && (!ObjType.method220(k2).aBoolean344 || Game.membersWorld)) {
                            for (int j3 = 0; j3 < class5_2.containerItemId.length; j3++) {
                                if (class5_2.containerItemId[j3] != k2) {
                                    continue;
                                }
                                j1 = 0x3b9ac9ff;
                                break;
                            }
                        }
                    }
                    if (op == 11) {
                        j1 = playerEnergy;
                    }
                    if (op == 12) {
                        j1 = weightCarried;
                    }
                    if (op == 13) {
                        int l1 = anIntArray1214[ai[k++]];
                        int l2 = ai[k++];
                        j1 = (l1 & 1 << l2) == 0 ? 0 : 1;
                    }
                    if (op == 14) {
                        int i2 = ai[k++];
                        VarBit class35 = VarBit.aClass35Array590[i2];
                        int k3 = class35.anInt592;
                        int l3 = class35.anInt593;
                        int i4 = class35.anInt594;
                        int j4 = Game.BITMASK[i4 - l3];
                        j1 = anIntArray1214[k3] >> l3 & j4;
                    }
                    if (op == 15) {
                        byte1 = 1;
                    }
                    if (op == 16) {
                        byte1 = 2;
                    }
                    if (op == 17) {
                        byte1 = 3;
                    }
                    if (op == 18) {
                        j1 = (Game.self.x >> 7) + sceneBaseTileX;
                    }
                    if (op == 19) {
                        j1 = (Game.self.z >> 7) + sceneBaseTileZ;
                    }
                    if (op == 20) {
                        j1 = ai[k++];
                    }
                    if (byte1 == 0) {
                        if (l == 0) {
                            j += j1;
                        }
                        if (l == 1) {
                            j -= j1;
                        }
                        if (l == 2 && j1 != 0) {
                            j /= j1;
                        }
                        if (l == 3) {
                            j *= j1;
                        }
                        l = 0;
                    } else {
                        l = byte1;
                    }
                } while (true);
            } catch (Exception _ex) {
                return -1;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("71115, " + i + ", " + byte0 + ", " + class5 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method95(int i, long l) {
        try {
            if (l == 0L) {
                return;
            }
            if (anInt1104 >= 100 && isMembers != 1) {
                renderText(0, (byte) -115, "Your friendlist is full. Max of 100 for free users, and 200 for members", "");
                return;
            }
            if (anInt1104 >= 200) {
                renderText(0, (byte) -115, "Your friendlist is full. Max of 100 for free users, and 200 for members", "");
                return;
            }
            String s = TextUtils.method554(TextUtils.method551(l, true), true);
            for (int j = 0; j < anInt1104; j++) {
                if (aLongArray979[j] == l) {
                    renderText(0, (byte) -115, s + " is already on your friend list", "");
                    return;
                }
            }
            for (int k = 0; k < anInt957; k++) {
                if (aLongArray1254[k] == l) {
                    renderText(0, (byte) -115, "Please remove " + s + " from your ignore list first", "");
                    return;
                }
            }
            if (s.equals(Game.self.aString1672)) {
                return;
            }
            aStringArray1044[anInt1104] = s;
            aLongArray979[anInt1104] = l;
            anIntArray894[anInt1104] = 0;
            if (i != 0) {
                for (int i1 = 1; i1 > 0; i1++) {
                }
            }
            anInt1104++;
            redrawInvBack = true;
            out.writePacket(235);
            out.method478(l, true);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("60470, " + i + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void login(String username, String password, boolean reconnecting) {
        SignLink.errorname = username;
        try {
            if (!reconnecting) {
                loginString0 = "";
                loginString1 = "Connecting to server...";
                drawLoginScreen(true);
            }
            connection = new Connection(method34(43594), 32596, this);
            long encodedUsername = TextUtils.encodeBase37(username);
            int usernameHash = (int) (encodedUsername >> 16 & 31L);
            out.position = 0;
            out.writeByte(14);
            out.writeByte(usernameHash);
            connection.write(0, out.payload, 2);
            for (int j = 0; j < 8; j++) {
                connection.read();
            }
            int response = connection.read();
            if (response == 0) {
                connection.read(in.payload, 0, 8);
                in.position = 0;
                serverSeed = in.readLong(true);
                int[] seed = new int[4];
                seed[0] = (int) (Math.random() * 99999999D);
                seed[1] = (int) (Math.random() * 99999999D);
                seed[2] = (int) (serverSeed >> 32);
                seed[3] = (int) serverSeed;
                out.position = 0;
                out.writeByte(10);
                out.writeInt(seed[0]);
                out.writeInt(seed[1]);
                out.writeInt(seed[2]);
                out.writeInt(seed[3]);
                out.writeInt(SignLink.uid);
                out.writeString(username);
                out.writeString(password);
                out.encodeRSA(NetworkConstants.RSA_MODULUS, NetworkConstants.RSA_EXPONENT);
                loginBuffer.position = 0;
                if (reconnecting) {
                    loginBuffer.writeByte(18);
                } else {
                    loginBuffer.writeByte(16);
                }
                loginBuffer.writeByte(out.position + 36 + 1 + 1 + 2);
                loginBuffer.writeByte(255);
                loginBuffer.writeShort(289);
                loginBuffer.writeByte(Game.lowMemory ? 1 : 0);
                for (int i = 0; i < 9; i++) {
                    loginBuffer.writeInt(archiveCRCs[i]);
                }
                loginBuffer.writeBytes(out.payload, out.position, 0);
                out.random = new ISAACCipher(seed);
                for (int index = 0; index < 4; index++) {
                    seed[index] += 50;
                }
                encryption = new ISAACCipher(seed);
                connection.write(0, loginBuffer.payload, loginBuffer.position);
                response = connection.read();
            }
            if (response == 1) {
                try {
                    Thread.sleep(2000L);
                } catch (Exception _ex) {
                }
                login(username, password, reconnecting);
                return;
            }
            if (response == 2) {
                rights = connection.read();
                Game.flagged = connection.read() == 1;
                lastClickTime = 0L;
                sameClickPositionCounter = 0;
                mouseCapturer.coordinatesIndex = 0;
                super.hasFocus = true;
                windowFocused = true;
                ingame = true;
                out.position = 0;
                in.position = 0;
                packetType = -1;
                firstOpcode = -1;
                secondOpcode = -1;
                thirdOpcode = -1;
                packetSize = 0;
                timeoutCounter = 0;
                systemUpdateTimer = 0;
                idleLogout = 0;
                hintIconType = 0;
                menuSize = 0;
                menuVisible = false;
                super.idleTime = 0;
                for (int mes = 0; mes < 100; mes++) {
                    chatMessages[mes] = null;
                }
                anInt952 = 0;
                anInt994 = 0;
                sceneState = 0;
                anInt968 = 0;
                cameraRandomizationH = (int) (Math.random() * 100D) - 50;
                cameraRandomizationV = (int) (Math.random() * 110D) - 55;
                cameraRandomisationA = (int) (Math.random() * 80D) - 40;
                anInt959 = (int) (Math.random() * 120D) - 60;
                anInt1075 = (int) (Math.random() * 30D) - 20;
                cameraHorizontal = (int) (Math.random() * 20D) - 10 & 0x7ff;
                anInt848 = 0;
                lastRegionId = -1;
                flagSceneTileX = 0;
                flagSceneTileZ = 0;
                anInt1226 = 0;
                anInt1009 = 0;
                for (int l1 = 0; l1 < MAX_PLAYER_COUNT; l1++) {
                    players[l1] = null;
                    aClass44_Sub3_Sub2Array1230[l1] = null;
                }
                for (int j2 = 0; j2 < 16384; j2++) {
                    npcs[j2] = null;
                }
                Game.self = players[anInt1224] = new PlayerEntity();
                aClass28_918.method263();
                aClass28_1054.method263();
                for (int k2 = 0; k2 < 4; k2++) {
                    for (int l2 = 0; l2 < 104; l2++) {
                        for (int j3 = 0; j3 < 104; j3++) {
                            planeObjStacks[k2][l2][j3] = null;
                        }
                    }
                }
                listTemporaryLocs = new LinkedList(-199);
                anInt1105 = 0;
                anInt1104 = 0;
                anInt965 = -1;
                anInt1253 = -1;
                anInt1199 = -1;
                anInt889 = -1;
                anInt924 = -1;
                aBoolean935 = false;
                currentTab = 3;
                aBoolean980 = false;
                menuVisible = false;
                aBoolean1222 = false;
                clickToContinueString = null;
                anInt1112 = 0;
                anInt833 = -1;
                aBoolean1179 = true;
                method70(aByte883);
                for (int i3 = 0; i3 < 5; i3++) {
                    anIntArray938[i3] = 0;
                }
                for (int k3 = 0; k3 < 5; k3++) {
                    aStringArray919[k3] = null;
                    aBooleanArray920[k3] = false;
                }
                Game.anInt1238 = 0;
                Game.anInt1180 = 0;
                Game.anInt986 = 0;
                Game.anInt870 = 0;
                Game.anInt821 = 0;
                Game.anInt1274 = 0;
                Game.anInt1114 = 0;
                Game.anInt1046 = 0;
                Game.anInt1100 = 0;
                Game.anInt845 = 0;
                method60(817);
                return;
            }
            if (response == 3) {
                loginString0 = "";
                loginString1 = "Invalid username or password.";
                return;
            }
            if (response == 4) {
                loginString0 = "Your account has been disabled.";
                loginString1 = "Please check your message-centre for details.";
                return;
            }
            if (response == 5) {
                loginString0 = "Your account is already logged in.";
                loginString1 = "Try again in 60 secs...";
                return;
            }
            if (response == 6) {
                loginString0 = "RuneScape has been updated!";
                loginString1 = "Please reload this page.";
                return;
            }
            if (response == 7) {
                loginString0 = "This world is full.";
                loginString1 = "Please use a different world.";
                return;
            }
            if (response == 8) {
                loginString0 = "Unable to connect.";
                loginString1 = "Login server offline.";
                return;
            }
            if (response == 9) {
                loginString0 = "Login limit exceeded.";
                loginString1 = "Too many connections from your address.";
                return;
            }
            if (response == 10) {
                loginString0 = "Unable to connect.";
                loginString1 = "Bad session id.";
                return;
            }
            if (response == 11) {
                loginString1 = "Login server rejected session.";
                loginString1 = "Please try again.";
                return;
            }
            if (response == 12) {
                loginString0 = "You need a members account to login to this world.";
                loginString1 = "Please subscribe, or use a different world.";
                return;
            }
            if (response == 13) {
                loginString0 = "Could not complete login.";
                loginString1 = "Please try using a different world.";
                return;
            }
            if (response == 14) {
                loginString0 = "The server is being updated.";
                loginString1 = "Please wait 1 minute and try again.";
                return;
            }
            if (response == 15) {
                ingame = true;
                out.position = 0;
                in.position = 0;
                packetType = -1;
                firstOpcode = -1;
                secondOpcode = -1;
                thirdOpcode = -1;
                packetSize = 0;
                timeoutCounter = 0;
                systemUpdateTimer = 0;
                menuSize = 0;
                menuVisible = false;
                sceneLoadStartTime = System.currentTimeMillis();
                return;
            }
            if (response == 16) {
                loginString0 = "Login attempts exceeded.";
                loginString1 = "Please wait 1 minute and try again.";
                return;
            }
            if (response == 17) {
                loginString0 = "You are standing in a members-only area.";
                loginString1 = "To play on this world move to a free area first";
                return;
            }
            if (response == 20) {
                loginString0 = "Invalid loginserver requested";
                loginString1 = "Please try using a different world.";
                return;
            }
            if (response == 21) {
                for (int count = connection.read(); count >= 0; count--) {
                    loginString0 = "You have only just left another world";
                    loginString1 = "Your profile will be transferred in: " + count + " seconds";
                    drawLoginScreen(true);
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception _ex) {
                    }
                }
                login(username, password, reconnecting);
                return;
            }
            if (response == -1) {
                loginString0 = "No response from server";
                loginString1 = "Please try using a different world.";
                return;
            } else {
                System.out.println("response:" + response);
                loginString0 = "Unexpected server response";
                loginString1 = "Please try using a different world.";
                return;
            }
        } catch (IOException _ex) {
            loginString0 = "";
        }
        loginString1 = "Error connecting to server.";
    }

    public void method97(byte byte0) {
        try {
            if (byte0 != 122) {
                packetType = in.readUnsignedByte();
            }
            if (loginScreenState == 0) {
                int i = super.width / 2 - 80;
                int l = super.height / 2 + 20;
                l += 20;
                if (super.clickType == 1 && super.mousePressX >= i - 75 && super.mousePressX <= i + 75 && super.mousePressY >= l - 20
                        && super.mousePressY <= l + 20) {
                    loginScreenState = 3;
                    loginInputLine = 0;
                }
                i = super.width / 2 + 80;
                if (super.clickType == 1 && super.mousePressX >= i - 75 && super.mousePressX <= i + 75 && super.mousePressY >= l - 20
                        && super.mousePressY <= l + 20) {
                    loginString0 = "";
                    loginString1 = "Enter your username & password.";
                    loginScreenState = 2;
                    loginInputLine = 0;
                    return;
                }
            } else {
                if (loginScreenState == 2) {
                    int j = super.height / 2 - 40;
                    j += 30;
                    j += 25;
                    if (super.clickType == 1 && super.mousePressY >= j - 15 && super.mousePressY < j) {
                        loginInputLine = 0;
                    }
                    j += 15;
                    if (super.clickType == 1 && super.mousePressY >= j - 15 && super.mousePressY < j) {
                        loginInputLine = 1;
                    }
                    j += 15;
                    int i1 = super.width / 2 - 80;
                    int k1 = super.height / 2 + 50;
                    k1 += 20;
                    if (super.clickType == 1 && super.mousePressX >= i1 - 75 && super.mousePressX <= i1 + 75
                            && super.mousePressY >= k1 - 20 && super.mousePressY <= k1 + 20) {
                        login(username, password, false);
                        if (ingame) {
                            return;
                        }
                    }
                    i1 = super.width / 2 + 80;
                    if (super.clickType == 1 && super.mousePressX >= i1 - 75 && super.mousePressX <= i1 + 75
                            && super.mousePressY >= k1 - 20 && super.mousePressY <= k1 + 20) {
                        loginScreenState = 0;
                        username = "rebecca";
                        password = "123";
                    }
                    do {
                        int l1 = method5(-128);
                        if (l1 == -1) {
                            break;
                        }
                        boolean flag = false;
                        for (int i2 = 0; i2 < Game.validCharacters.length(); i2++) {
                            if (l1 != Game.validCharacters.charAt(i2)) {
                                continue;
                            }
                            flag = true;
                            break;
                        }
                        if (loginInputLine == 0) {
                            if (l1 == 8 && username.length() > 0) {
                                username = username.substring(0, username.length() - 1);
                            }
                            if (l1 == 9 || l1 == 10 || l1 == 13) {
                                loginInputLine = 1;
                            }
                            if (flag) {
                                username += (char) l1;
                            }
                            if (username.length() > 12) {
                                username = username.substring(0, 12);
                            }
                        } else if (loginInputLine == 1) {
                            if (l1 == 8 && password.length() > 0) {
                                password = password.substring(0, password.length() - 1);
                            }
                            if (l1 == 9 || l1 == 10 || l1 == 13) {
                                loginInputLine = 0;
                            }
                            if (flag) {
                                password += (char) l1;
                            }
                            if (password.length() > 20) {
                                password = password.substring(0, 20);
                            }
                        }
                    } while (true);
                    return;
                }
                if (loginScreenState == 3) {
                    int k = super.width / 2;
                    int j1 = super.height / 2 + 50;
                    j1 += 20;
                    if (super.clickType == 1 && super.mousePressX >= k - 75 && super.mousePressX <= k + 75
                            && super.mousePressY >= j1 - 20 && super.mousePressY <= j1 + 20) {
                        loginScreenState = 0;
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("36554, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method99(byte byte0) {
        try {
            if (idleLogout > 0) {
                method22((byte) 25);
                return;
            }
            areaViewport.bind();
            plainFont.drawStringCenter(257, "Connection lost", -31546, 0, 144);
            plainFont.drawStringCenter(256, "Connection lost", -31546, 0xffffff, 143);
            plainFont.drawStringCenter(257, "Please wait - attempting to reestablish", -31546, 0, 159);
            plainFont.drawStringCenter(256, "Please wait - attempting to reestablish", -31546, 0xffffff,
                    158);
            areaViewport.draw(super.graphics, 4, 4);
            anInt848 = 0;
            if (byte0 != 7) {
                return;
            }
            flagSceneTileX = 0;
            Connection class7 = connection;
            ingame = false;
            login(username, password, true);
            if (!ingame) {
                method22((byte) 25);
            }
            try {
                class7.method191();
                return;
            } catch (Exception _ex) {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96492, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method101(int i) {
        try {
            if (i >= 0) {
                return;
            }
            for (SceneLocTemporary class44_sub1 = (SceneLocTemporary) listTemporaryLocs.peekFront(); class44_sub1 != null; class44_sub1 = (SceneLocTemporary) listTemporaryLocs
                    .prev(false)) {
                if (class44_sub1.anInt1334 == -1) {
                    class44_sub1.anInt1333 = 0;
                    method139(class44_sub1, false);
                } else {
                    class44_sub1.remove();
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("43758, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public String method102(int i) {
        try {
            if (i <= 0) {
                aBoolean1147 = !aBoolean1147;
            }
            if (SignLink.mainapp != null) {
                return SignLink.mainapp.getDocumentBase().getHost().toLowerCase();
            }
            if (super.aFrame_Sub1_16 != null) {
                return "runescape.com";
            } else {
                return super.getDocumentBase().getHost().toLowerCase();
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("16537, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method103(int i, Buffer class44_sub3_sub2, int j) {
        try {
            while (i >= 0) {
                return;
            }
            int k = class44_sub3_sub2.method493(8, false);
            if (k < anInt1226) {
                for (int l = k; l < anInt1226; l++) {
                    anIntArray941[anInt940++] = anIntArray1227[l];
                }
            }
            if (k > anInt1226) {
                SignLink.reporterror(username + " Too many players");
                throw new RuntimeException("eek");
            }
            anInt1226 = 0;
            for (int i1 = 0; i1 < k; i1++) {
                int j1 = anIntArray1227[i1];
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[j1];
                int k1 = class44_sub3_sub2.method493(1, false);
                if (k1 == 0) {
                    anIntArray1227[anInt1226++] = j1;
                    class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                } else {
                    int l1 = class44_sub3_sub2.method493(2, false);
                    if (l1 == 0) {
                        anIntArray1227[anInt1226++] = j1;
                        class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                        anIntArray1229[anInt1228++] = j1;
                    } else if (l1 == 1) {
                        anIntArray1227[anInt1226++] = j1;
                        class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                        int i2 = class44_sub3_sub2.method493(3, false);
                        class44_sub3_sub4_sub6_sub1.method533(false, i2, anInt1153);
                        int k2 = class44_sub3_sub2.method493(1, false);
                        if (k2 == 1) {
                            anIntArray1229[anInt1228++] = j1;
                        }
                    } else if (l1 == 2) {
                        anIntArray1227[anInt1226++] = j1;
                        class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                        int j2 = class44_sub3_sub2.method493(3, false);
                        class44_sub3_sub4_sub6_sub1.method533(true, j2, anInt1153);
                        int l2 = class44_sub3_sub2.method493(3, false);
                        class44_sub3_sub4_sub6_sub1.method533(true, l2, anInt1153);
                        int i3 = class44_sub3_sub2.method493(1, false);
                        if (i3 == 1) {
                            anIntArray1229[anInt1228++] = j1;
                        }
                    } else if (l1 == 3) {
                        anIntArray941[anInt940++] = j1;
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("48001, " + i + ", " + class44_sub3_sub2 + ", " + j + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method104(int i, int j) {
        try {
            if (j != -44196) {
                planeObjStacks = null;
            }
            Component class5 = Component.instances[i];
            for (int k = 0; k < class5.anIntArray122.length; k++) {
                if (class5.anIntArray122[k] == -1) {
                    break;
                }
                Component class5_1 = Component.instances[class5.anIntArray122[k]];
                if (class5_1.anInt107 == 1) {
                    method104(class5_1.anInt105, -44196);
                }
                class5_1.anInt103 = 0;
                class5_1.anInt104 = 0;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("3125, " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method105(boolean flag, int i, Buffer class44_sub3_sub2) {
        try {
            anInt940 = 0;
            anInt1228 = 0;
            method144(i, class44_sub3_sub2, anInt1202);
            method42((byte) -97, i, class44_sub3_sub2);
            method140(0, class44_sub3_sub2, i);
            if (!flag) {
                packetType = class44_sub3_sub2.readUnsignedByte();
            }
            for (int j = 0; j < anInt940; j++) {
                int k = anIntArray941[j];
                if (npcs[k].anInt1660 != Game.loopCycle) {
                    npcs[k].aClass12_1700 = null;
                    npcs[k] = null;
                }
            }
            if (class44_sub3_sub2.position != i) {
                SignLink.reporterror(username + " size mismatch in getnpcpos - pos:" + class44_sub3_sub2.position
                        + " psize:" + i);
                throw new RuntimeException("eek");
            }
            for (int l = 0; l < anInt1009; l++) {
                if (npcs[anIntArray1010[l]] == null) {
                    SignLink.reporterror(username + " null entry in npc list - pos:" + l + " size:" + anInt1009);
                    throw new RuntimeException("eek");
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("79159, " + flag + ", " + i + ", " + class44_sub3_sub2 + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method106(int i) {
        try {
            while (i >= 0) {
                return;
            }
            if (super.clickType == 1) {
                if (super.mousePressX >= 539 && super.mousePressX <= 573 && super.mousePressY >= 169 && super.mousePressY < 205
                        && tabComponentId[0] != -1) {
                    redrawInvBack = true;
                    currentTab = 0;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 569 && super.mousePressX <= 599 && super.mousePressY >= 168 && super.mousePressY < 205
                        && tabComponentId[1] != -1) {
                    redrawInvBack = true;
                    currentTab = 1;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 597 && super.mousePressX <= 627 && super.mousePressY >= 168 && super.mousePressY < 205
                        && tabComponentId[2] != -1) {
                    redrawInvBack = true;
                    currentTab = 2;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 625 && super.mousePressX <= 669 && super.mousePressY >= 168 && super.mousePressY < 203
                        && tabComponentId[3] != -1) {
                    redrawInvBack = true;
                    currentTab = 3;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 666 && super.mousePressX <= 696 && super.mousePressY >= 168 && super.mousePressY < 205
                        && tabComponentId[4] != -1) {
                    redrawInvBack = true;
                    currentTab = 4;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 694 && super.mousePressX <= 724 && super.mousePressY >= 168 && super.mousePressY < 205
                        && tabComponentId[5] != -1) {
                    redrawInvBack = true;
                    currentTab = 5;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 722 && super.mousePressX <= 756 && super.mousePressY >= 169 && super.mousePressY < 205
                        && tabComponentId[6] != -1) {
                    redrawInvBack = true;
                    currentTab = 6;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 540 && super.mousePressX <= 574 && super.mousePressY >= 466 && super.mousePressY < 502
                        && tabComponentId[7] != -1) {
                    redrawInvBack = true;
                    currentTab = 7;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 572 && super.mousePressX <= 602 && super.mousePressY >= 466 && super.mousePressY < 503
                        && tabComponentId[8] != -1) {
                    redrawInvBack = true;
                    currentTab = 8;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 599 && super.mousePressX <= 629 && super.mousePressY >= 466 && super.mousePressY < 503
                        && tabComponentId[9] != -1) {
                    redrawInvBack = true;
                    currentTab = 9;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 627 && super.mousePressX <= 671 && super.mousePressY >= 467 && super.mousePressY < 502
                        && tabComponentId[10] != -1) {
                    redrawInvBack = true;
                    currentTab = 10;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 669 && super.mousePressX <= 699 && super.mousePressY >= 466 && super.mousePressY < 503
                        && tabComponentId[11] != -1) {
                    redrawInvBack = true;
                    currentTab = 11;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 696 && super.mousePressX <= 726 && super.mousePressY >= 466 && super.mousePressY < 503
                        && tabComponentId[12] != -1) {
                    redrawInvBack = true;
                    currentTab = 12;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 724 && super.mousePressX <= 758 && super.mousePressY >= 466 && super.mousePressY < 502
                        && tabComponentId[13] != -1) {
                    redrawInvBack = true;
                    currentTab = 13;
                    redrawSideicons = true;
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("63058, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public boolean method107(Component class5, boolean flag) {
        try {
            ingame &= flag;
            int i = class5.anInt109;
            if (i >= 1 && i <= 200 || i >= 701 && i <= 900) {
                if (i >= 801) {
                    i -= 701;
                } else if (i >= 701) {
                    i -= 601;
                } else if (i >= 101) {
                    i -= 101;
                } else {
                    i--;
                }
                aStringArray897[menuSize] = "Remove @whi@" + aStringArray1044[i];
                menuAction[menuSize] = 513;
                menuSize++;
                aStringArray897[menuSize] = "Message @whi@" + aStringArray1044[i];
                menuAction[menuSize] = 902;
                menuSize++;
                return true;
            }
            if (i >= 401 && i <= 500) {
                aStringArray897[menuSize] = "Remove @whi@" + class5.aString141;
                menuAction[menuSize] = 884;
                menuSize++;
                return true;
            } else {
                return false;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("1354, " + class5 + ", " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method108(int i) {
        try {
            i = 32 / i;
            for (int j = 0; j < anInt968; j++) {
                if (anIntArray1193[j] <= 0) {
                    boolean flag = false;
                    try {
                        if (anIntArray846[j] == anInt900 && anIntArray1006[j] == anInt1177) {
                            if (!method79((byte) 9)) {
                                flag = true;
                            }
                        } else {
                            Buffer class44_sub3_sub2 = SoundTrack.method176(anIntArray1006[j], 7, anIntArray846[j]);
                            if (System.currentTimeMillis() + class44_sub3_sub2.position / 22 > aLong1048 + anInt1028 / 22) {
                                anInt1028 = class44_sub3_sub2.position;
                                aLong1048 = System.currentTimeMillis();
                                if (method146(class44_sub3_sub2.payload, 0, class44_sub3_sub2.position)) {
                                    anInt900 = anIntArray846[j];
                                    anInt1177 = anIntArray1006[j];
                                } else {
                                    flag = true;
                                }
                            }
                        }
                    } catch (Exception exception) {
                    }
                    if (!flag || anIntArray1193[j] == -5) {
                        anInt968--;
                        for (int k = j; k < anInt968; k++) {
                            anIntArray846[k] = anIntArray846[k + 1];
                            anIntArray1006[k] = anIntArray1006[k + 1];
                            anIntArray1193[k] = anIntArray1193[k + 1];
                        }
                        j--;
                    } else {
                        anIntArray1193[j] = -5;
                    }
                } else {
                    anIntArray1193[j]--;
                }
            }
            if (anInt942 > 0) {
                anInt942 -= 20;
                if (anInt942 < 0) {
                    anInt942 = 0;
                }
                if (anInt942 == 0 && aBoolean1057 && !Game.lowMemory) {
                    anInt1190 = anInt963;
                    aBoolean1191 = true;
                    ondemand.request(2, anInt1190);
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("64409, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method109(Image8 class44_sub3_sub1_sub3, int i) {
        try {
            int j = 256;
            for (int k = 0; k < anIntArray1133.length; k++) {
                anIntArray1133[k] = 0;
            }
            for (int l = 0; l < 5000; l++) {
                int i1 = (int) (Math.random() * 128D * j);
                anIntArray1133[i1] = (int) (Math.random() * 256D);
            }
            for (int j1 = 0; j1 < 20; j1++) {
                for (int k1 = 1; k1 < j - 1; k1++) {
                    for (int i2 = 1; i2 < 127; i2++) {
                        int k2 = i2 + (k1 << 7);
                        anIntArray1134[k2] = (anIntArray1133[k2 - 1] + anIntArray1133[k2 + 1]
                                + anIntArray1133[k2 - 128] + anIntArray1133[k2 + 128]) / 4;
                    }
                }
                int[] ai = anIntArray1133;
                anIntArray1133 = anIntArray1134;
                anIntArray1134 = ai;
            }
            if (i != 34809) {
                packetType = -1;
            }
            if (class44_sub3_sub1_sub3 != null) {
                int l1 = 0;
                for (int j2 = 0; j2 < class44_sub3_sub1_sub3.anInt1461; j2++) {
                    for (int l2 = 0; l2 < class44_sub3_sub1_sub3.anInt1460; l2++) {
                        if (class44_sub3_sub1_sub3.aByteArray1458[l1++] != 0) {
                            int i3 = l2 + 16 + class44_sub3_sub1_sub3.anInt1462;
                            int j3 = j2 + 16 + class44_sub3_sub1_sub3.anInt1463;
                            int k3 = i3 + (j3 << 7);
                            anIntArray1133[k3] = 0;
                        }
                    }
                }
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("10967, " + class44_sub3_sub1_sub3 + ", " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void renderPlayers(boolean flag, boolean flag1) {
        try {
            if (Game.self.x >> 7 == flagSceneTileX
                    && Game.self.z >> 7 == flagSceneTileZ) {
                flagSceneTileX = 0;
                Game.anInt944++;
                if (Game.anInt944 > 122) {
                    Game.anInt944 = 0;
                    out.writePacket(255);
                    out.writeByte(62);
                }
            }
            int i = anInt1226;
            if (!flag) {
                packetType = in.readUnsignedByte();
            }
            if (flag1) {
                i = 1;
            }
            for (int j = 0; j < i; j++) {
                PlayerEntity class44_sub3_sub4_sub6_sub1;
                int k;
                if (flag1) {
                    class44_sub3_sub4_sub6_sub1 = Game.self;
                    k = anInt1224 << 14;
                } else {
                    class44_sub3_sub4_sub6_sub1 = players[anIntArray1227[j]];
                    k = anIntArray1227[j] << 14;
                }
                if (class44_sub3_sub4_sub6_sub1 == null || !class44_sub3_sub4_sub6_sub1.method535(true)) {
                    continue;
                }
                class44_sub3_sub4_sub6_sub1.aBoolean1692 = (Game.lowMemory && anInt1226 > 50 || anInt1226 > 200)
                        && !flag1
                        && class44_sub3_sub4_sub6_sub1.anInt1640 == class44_sub3_sub4_sub6_sub1.anInt1620;
                int l = class44_sub3_sub4_sub6_sub1.x >> 7;
                int i1 = class44_sub3_sub4_sub6_sub1.z >> 7;
                if (l < 0 || l >= 104 || i1 < 0 || i1 >= 104) {
                    continue;
                }
                if (class44_sub3_sub4_sub6_sub1.aClass44_Sub3_Sub4_Sub4_1687 != null
                        && Game.loopCycle >= class44_sub3_sub4_sub6_sub1.anInt1682
                        && Game.loopCycle < class44_sub3_sub4_sub6_sub1.anInt1683) {
                    class44_sub3_sub4_sub6_sub1.aBoolean1692 = false;
                    class44_sub3_sub4_sub6_sub1.anInt1681 = getFloorDrawHeight(false,
                            class44_sub3_sub4_sub6_sub1.z,
                            class44_sub3_sub4_sub6_sub1.x, plane);
                    scene.method290(60, k, true, class44_sub3_sub4_sub6_sub1.anInt1689,
                            class44_sub3_sub4_sub6_sub1.anInt1690, class44_sub3_sub4_sub6_sub1.x,
                            class44_sub3_sub4_sub6_sub1.anInt1691, class44_sub3_sub4_sub6_sub1,
                            class44_sub3_sub4_sub6_sub1.z, plane,
                            class44_sub3_sub4_sub6_sub1.anInt1681, class44_sub3_sub4_sub6_sub1.anInt1688,
                            class44_sub3_sub4_sub6_sub1.anInt1617);
                    continue;
                }
                if ((class44_sub3_sub4_sub6_sub1.x & 0x7f) == 64
                        && (class44_sub3_sub4_sub6_sub1.z & 0x7f) == 64) {
                    if (anIntArrayArray885[l][i1] == renderCycle) {
                        continue;
                    }
                    anIntArrayArray885[l][i1] = renderCycle;
                }
                class44_sub3_sub4_sub6_sub1.anInt1681 = getFloorDrawHeight(false,
                        class44_sub3_sub4_sub6_sub1.z,
                        class44_sub3_sub4_sub6_sub1.x, plane);
                scene.method289(60, k, class44_sub3_sub4_sub6_sub1.anInt1681,
                        class44_sub3_sub4_sub6_sub1.x, 384, class44_sub3_sub4_sub6_sub1,
                        class44_sub3_sub4_sub6_sub1.anInt1617,
                        class44_sub3_sub4_sub6_sub1.aBoolean1618,
                        class44_sub3_sub4_sub6_sub1.z, plane);
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("61838, " + flag + ", " + flag1 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method111(int i, byte byte0, int j) {
        try {
            int k = 0;
            for (int l = 0; l < 100; l++) {
                if (chatMessages[l] == null) {
                    continue;
                }
                int i1 = anIntArray1002[l];
                int j1 = (70 - k * 14) + anInt1103 + 4;
                if (j1 < -20) {
                    break;
                }
                String s = aStringArray1003[l];
                if (s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }
                if (s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }
                if (i1 == 0) {
                    k++;
                }
                if ((i1 == 1 || i1 == 2) && (i1 == 1 || publicChatSetting == 0 || publicChatSetting == 1 && method80(s, 3))) {
                    if (j > j1 - 14 && j <= j1 && !s.equals(Game.self.aString1672)) {
                        if (rights >= 1) {
                            aStringArray897[menuSize] = "Report abuse @whi@" + s;
                            menuAction[menuSize] = 524;
                            menuSize++;
                        }
                        aStringArray897[menuSize] = "Add ignore @whi@" + s;
                        menuAction[menuSize] = 47;
                        menuSize++;
                        aStringArray897[menuSize] = "Add friend @whi@" + s;
                        menuAction[menuSize] = 605;
                        menuSize++;
                    }
                    k++;
                }
                if ((i1 == 3 || i1 == 7) && anInt1017 == 0
                        && (i1 == 7 || privateChatSetting == 0 || privateChatSetting == 1 && method80(s, 3))) {
                    if (j > j1 - 14 && j <= j1) {
                        if (rights >= 1) {
                            aStringArray897[menuSize] = "Report abuse @whi@" + s;
                            menuAction[menuSize] = 524;
                            menuSize++;
                        }
                        aStringArray897[menuSize] = "Add ignore @whi@" + s;
                        menuAction[menuSize] = 47;
                        menuSize++;
                        aStringArray897[menuSize] = "Add friend @whi@" + s;
                        menuAction[menuSize] = 605;
                        menuSize++;
                    }
                    k++;
                }
                if (i1 == 4 && (tradeChatSetting == 0 || tradeChatSetting == 1 && method80(s, 3))) {
                    if (j > j1 - 14 && j <= j1) {
                        aStringArray897[menuSize] = "Accept trade @whi@" + s;
                        menuAction[menuSize] = 507;
                        menuSize++;
                    }
                    k++;
                }
                if ((i1 == 5 || i1 == 6) && anInt1017 == 0 && privateChatSetting < 2) {
                    k++;
                }
                if (i1 == 8 && (tradeChatSetting == 0 || tradeChatSetting == 1 && method80(s, 3))) {
                    if (j > j1 - 14 && j <= j1) {
                        aStringArray897[menuSize] = "Accept challenge @whi@" + s;
                        menuAction[menuSize] = 957;
                        menuSize++;
                    }
                    k++;
                }
            }
            if (byte0 != 7) {
                method6();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("6327, " + i + ", " + byte0 + ", " + j + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method112(int i, int j, PlayerEntity class44_sub3_sub4_sub6_sub1, int k, int l) {
        try {
            if (class44_sub3_sub4_sub6_sub1 == Game.self) {
                return;
            }
            if (menuSize >= 400) {
                return;
            }
            String s;
            if (class44_sub3_sub4_sub6_sub1.anInt1679 == 0) {
                s = class44_sub3_sub4_sub6_sub1.aString1672
                        + Game.method137(class44_sub3_sub4_sub6_sub1.anInt1678,
                        Game.self.anInt1678, -41081) + " (level-"
                        + class44_sub3_sub4_sub6_sub1.anInt1678 + ")";
            } else {
                s = class44_sub3_sub4_sub6_sub1.aString1672 + " (skill-" + class44_sub3_sub4_sub6_sub1.anInt1679 + ")";
            }
            if (anInt952 == 1) {
                aStringArray897[menuSize] = "Use " + aString956 + " with @whi@" + s;
                menuAction[menuSize] = 275;
                menuParamC[menuSize] = l;
                menuParamA[menuSize] = k;
                menuParamB[menuSize] = i;
                menuSize++;
            } else if (anInt994 == 1) {
                if ((anInt996 & 8) == 8) {
                    aStringArray897[menuSize] = aString997 + " @whi@" + s;
                    menuAction[menuSize] = 131;
                    menuParamC[menuSize] = l;
                    menuParamA[menuSize] = k;
                    menuParamB[menuSize] = i;
                    menuSize++;
                }
            } else {
                for (int i1 = 4; i1 >= 0; i1--) {
                    if (aStringArray919[i1] != null) {
                        aStringArray897[menuSize] = aStringArray919[i1] + " @whi@" + s;
                        char c = '\0';
                        if (aStringArray919[i1].equalsIgnoreCase("attack")) {
                            if (class44_sub3_sub4_sub6_sub1.anInt1678 > Game.self.anInt1678) {
                                c = '\u07D0';
                            }
                            if (Game.self.anInt1695 != 0
                                    && class44_sub3_sub4_sub6_sub1.anInt1695 != 0) {
                                if (Game.self.anInt1695 == class44_sub3_sub4_sub6_sub1.anInt1695) {
                                    c = '\u07D0';
                                } else {
                                    c = '\0';
                                }
                            }
                        } else if (aBooleanArray920[i1]) {
                            c = '\u07D0';
                        }
                        if (i1 == 0) {
                            menuAction[menuSize] = 639 + c;
                        }
                        if (i1 == 1) {
                            menuAction[menuSize] = 499 + c;
                        }
                        if (i1 == 2) {
                            menuAction[menuSize] = 27 + c;
                        }
                        if (i1 == 3) {
                            menuAction[menuSize] = 387 + c;
                        }
                        if (i1 == 4) {
                            menuAction[menuSize] = 185 + c;
                        }
                        menuParamC[menuSize] = l;
                        menuParamA[menuSize] = k;
                        menuParamB[menuSize] = i;
                        menuSize++;
                    }
                }
            }
            for (int j1 = 0; j1 < menuSize; j1++) {
                if (menuAction[j1] != 718) {
                    continue;
                }
                aStringArray897[j1] = "Walk here @whi@" + s;
                break;
            }
            if (j != 705) {
                anInt857 = encryption.method545();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20699, " + i + ", " + j + ", " + class44_sub3_sub4_sub6_sub1 + ", " + k + ", " + l
                    + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method113(byte byte0) {
        try {
            aClass34_1195.bind();
            Draw3D.anIntArray1429 = anIntArray915;
            if (byte0 != 3) {
                return;
            }
            aClass44_Sub3_Sub1_Sub3_1143.blit(0, 0);
            if (anInt889 != -1) {
                method37(6, 0, 0, Component.instances[anInt889], 0);
            } else if (tabComponentId[currentTab] != -1) {
                method37(6, 0, 0, Component.instances[tabComponentId[currentTab]], 0);
            }
            if (menuVisible && anInt1030 == 1) {
                method115(393);
            }
            aClass34_1195.draw(super.graphics, 553, 205);
            areaViewport.bind();
            Draw3D.anIntArray1429 = anIntArray916;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("78878, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method114(int i) {
        try {
            AnimableGameObject class44_sub3_sub4_sub5 = (AnimableGameObject) aClass28_1054.peekFront();
            if (i >= 0) {
                out.writeByte(87);
            }
            for (; class44_sub3_sub4_sub5 != null; class44_sub3_sub4_sub5 = (AnimableGameObject) aClass28_1054
                    .prev(false)) {
                if (class44_sub3_sub4_sub5.anInt1606 != plane || class44_sub3_sub4_sub5.aBoolean1612) {
                    class44_sub3_sub4_sub5.remove();
                } else if (Game.loopCycle >= class44_sub3_sub4_sub5.anInt1605) {
                    class44_sub3_sub4_sub5.method531(922, anInt824);
                    if (class44_sub3_sub4_sub5.aBoolean1612) {
                        class44_sub3_sub4_sub5.remove();
                    } else {
                        scene.method289(60, -1, class44_sub3_sub4_sub5.anInt1609,
                                class44_sub3_sub4_sub5.anInt1607, 384, class44_sub3_sub4_sub5, 0, false,
                                class44_sub3_sub4_sub5.anInt1608, class44_sub3_sub4_sub5.anInt1606);
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("1882, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method115(int i) {
        try {
            int j = anInt1031;
            int k = anInt1032;
            int l = anInt1033;
            int i1 = anInt1034;
            int j1 = 0x5d5447;
            Draw2D.method411(j1, 210, k, i1, j, l);
            Draw2D.method411(0, 210, k + 1, 16, j + 1, l - 2);
            if (i <= 0) {
                anInt1153 = 111;
            }
            Draw2D.method412(1, j + 1, l - 2, 0, k + 18, i1 - 19);
            fontBold.method459((byte) -104, j1, "Choose Option", j + 3, k + 14);
            int k1 = super.anInt21;
            int l1 = super.anInt22;
            if (anInt1030 == 0) {
                k1 -= 4;
                l1 -= 4;
            }
            if (anInt1030 == 1) {
                k1 -= 553;
                l1 -= 205;
            }
            if (anInt1030 == 2) {
                k1 -= 17;
                l1 -= 357;
            }
            for (int i2 = 0; i2 < menuSize; i2++) {
                int j2 = k + 31 + (menuSize - 1 - i2) * 15;
                int k2 = 0xffffff;
                if (k1 > j && k1 < j + l && l1 > j2 - 13 && l1 < j2 + 3) {
                    k2 = 0xffff00;
                }
                fontBold.drawStringTaggable(k2, 2, j2, true, j + 3, aStringArray897[i2]);
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("33105, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method116(int i) {
        try {
            for (int j = 0; j < anInt1009; j++) {
                int k = anIntArray1010[j];
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[k];
                if (class44_sub3_sub4_sub6_sub2 != null) {
                    method117(-34028, class44_sub3_sub4_sub6_sub2, class44_sub3_sub4_sub6_sub2.aClass12_1700.aByte284);
                }
            }
            if (i <= 0) {
                anInt1247 = -115;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("89148, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method117(int i, Actor class44_sub3_sub4_sub6, int j) {
        try {
            if (i != -34028) {
                packetType = in.readUnsignedByte();
            }
            if (class44_sub3_sub4_sub6.x < 128 || class44_sub3_sub4_sub6.z < 128
                    || class44_sub3_sub4_sub6.x >= 13184 || class44_sub3_sub4_sub6.z >= 13184) {
                class44_sub3_sub4_sub6.anInt1643 = -1;
                class44_sub3_sub4_sub6.anInt1648 = -1;
                class44_sub3_sub4_sub6.anInt1657 = 0;
                class44_sub3_sub4_sub6.anInt1658 = 0;
                class44_sub3_sub4_sub6.x = class44_sub3_sub4_sub6.pathTileX[0] * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.z = class44_sub3_sub4_sub6.pathTileZ[0] * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.method534(false);
            }
            if (class44_sub3_sub4_sub6 == Game.self
                    && (class44_sub3_sub4_sub6.x < 1536 || class44_sub3_sub4_sub6.z < 1536
                    || class44_sub3_sub4_sub6.x >= 11776 || class44_sub3_sub4_sub6.z >= 11776)) {
                class44_sub3_sub4_sub6.anInt1643 = -1;
                class44_sub3_sub4_sub6.anInt1648 = -1;
                class44_sub3_sub4_sub6.anInt1657 = 0;
                class44_sub3_sub4_sub6.anInt1658 = 0;
                class44_sub3_sub4_sub6.x = class44_sub3_sub4_sub6.pathTileX[0] * 128
                        + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.z = class44_sub3_sub4_sub6.pathTileZ[0] * 128
                        + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.method534(false);
            }
            if (class44_sub3_sub4_sub6.anInt1657 > Game.loopCycle) {
                method118(5, class44_sub3_sub4_sub6);
            } else if (class44_sub3_sub4_sub6.anInt1658 >= Game.loopCycle) {
                method119(anInt1091, class44_sub3_sub4_sub6);
            } else {
                method120(class44_sub3_sub4_sub6, 0);
            }
            method121((byte) 2, class44_sub3_sub4_sub6);
            method122(class44_sub3_sub4_sub6, 0);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("3333, " + i + ", " + class44_sub3_sub4_sub6 + ", " + j + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method118(int i, Actor class44_sub3_sub4_sub6) {
        try {
            int j = class44_sub3_sub4_sub6.anInt1657 - Game.loopCycle;
            if (i < 5 || i > 5) {
                planeObjStacks = null;
            }
            int k = class44_sub3_sub4_sub6.anInt1653 * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
            int l = class44_sub3_sub4_sub6.anInt1655 * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
            class44_sub3_sub4_sub6.x += (k - class44_sub3_sub4_sub6.x) / j;
            class44_sub3_sub4_sub6.z += (l - class44_sub3_sub4_sub6.z) / j;
            class44_sub3_sub4_sub6.anInt1668 = 0;
            if (class44_sub3_sub4_sub6.anInt1659 == 0) {
                class44_sub3_sub4_sub6.anInt1662 = 1024;
            }
            if (class44_sub3_sub4_sub6.anInt1659 == 1) {
                class44_sub3_sub4_sub6.anInt1662 = 1536;
            }
            if (class44_sub3_sub4_sub6.anInt1659 == 2) {
                class44_sub3_sub4_sub6.anInt1662 = 0;
            }
            if (class44_sub3_sub4_sub6.anInt1659 == 3) {
                class44_sub3_sub4_sub6.anInt1662 = 512;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("29708, " + i + ", " + class44_sub3_sub4_sub6 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method119(int i, Actor class44_sub3_sub4_sub6) {
        try {
            if (class44_sub3_sub4_sub6.anInt1658 == Game.loopCycle
                    || class44_sub3_sub4_sub6.anInt1643 == -1
                    || class44_sub3_sub4_sub6.anInt1646 != 0
                    || class44_sub3_sub4_sub6.anInt1645 + 1 > SeqType.cache[class44_sub3_sub4_sub6.anInt1643]
                    .method254(class44_sub3_sub4_sub6.anInt1644, 24425)) {
                int j = class44_sub3_sub4_sub6.anInt1658 - class44_sub3_sub4_sub6.anInt1657;
                int k = Game.loopCycle - class44_sub3_sub4_sub6.anInt1657;
                int l = class44_sub3_sub4_sub6.anInt1653 * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                int i1 = class44_sub3_sub4_sub6.anInt1655 * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                int j1 = class44_sub3_sub4_sub6.anInt1654 * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                int k1 = class44_sub3_sub4_sub6.anInt1656 * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.x = (l * (j - k) + j1 * k) / j;
                class44_sub3_sub4_sub6.z = (i1 * (j - k) + k1 * k) / j;
            }
            class44_sub3_sub4_sub6.anInt1668 = 0;
            if (class44_sub3_sub4_sub6.anInt1659 == 0) {
                class44_sub3_sub4_sub6.anInt1662 = 1024;
            }
            if (class44_sub3_sub4_sub6.anInt1659 == 1) {
                class44_sub3_sub4_sub6.anInt1662 = 1536;
            }
            if (class44_sub3_sub4_sub6.anInt1659 == 2) {
                class44_sub3_sub4_sub6.anInt1662 = 0;
            }
            if (class44_sub3_sub4_sub6.anInt1659 == 3) {
                class44_sub3_sub4_sub6.anInt1662 = 512;
            }
            class44_sub3_sub4_sub6.anInt1617 = class44_sub3_sub4_sub6.anInt1662;
            if (i != 37395) {
                packetType = in.readUnsignedByte();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("74708, " + i + ", " + class44_sub3_sub4_sub6 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method120(Actor class44_sub3_sub4_sub6, int i) {
        try {
            class44_sub3_sub4_sub6.anInt1640 = class44_sub3_sub4_sub6.anInt1620;
            if (class44_sub3_sub4_sub6.anInt1664 == 0) {
                class44_sub3_sub4_sub6.anInt1668 = 0;
                return;
            }
            if (class44_sub3_sub4_sub6.anInt1643 != -1 && class44_sub3_sub4_sub6.anInt1646 == 0) {
                SeqType class26 = SeqType.cache[class44_sub3_sub4_sub6.anInt1643];
                if (class44_sub3_sub4_sub6.anInt1669 > 0 && class26.anInt520 == 0) {
                    class44_sub3_sub4_sub6.anInt1668++;
                    return;
                }
                if (class44_sub3_sub4_sub6.anInt1669 <= 0 && class26.anInt521 == 0) {
                    class44_sub3_sub4_sub6.anInt1668++;
                    return;
                }
            }
            int j = class44_sub3_sub4_sub6.x;
            int k = class44_sub3_sub4_sub6.z;
            int l = class44_sub3_sub4_sub6.pathTileX[class44_sub3_sub4_sub6.anInt1664 - 1] * 128
                    + class44_sub3_sub4_sub6.anInt1619 * 64;
            int i1 = class44_sub3_sub4_sub6.pathTileZ[class44_sub3_sub4_sub6.anInt1664 - 1] * 128
                    + class44_sub3_sub4_sub6.anInt1619 * 64;
            if (l - j > 256 || l - j < -256 || i1 - k > 256 || i1 - k < -256) {
                class44_sub3_sub4_sub6.x = l;
                class44_sub3_sub4_sub6.z = i1;
                return;
            }
            if (j < l) {
                if (k < i1) {
                    class44_sub3_sub4_sub6.anInt1662 = 1280;
                } else if (k > i1) {
                    class44_sub3_sub4_sub6.anInt1662 = 1792;
                } else {
                    class44_sub3_sub4_sub6.anInt1662 = 1536;
                }
            } else if (j > l) {
                if (k < i1) {
                    class44_sub3_sub4_sub6.anInt1662 = 768;
                } else if (k > i1) {
                    class44_sub3_sub4_sub6.anInt1662 = 256;
                } else {
                    class44_sub3_sub4_sub6.anInt1662 = 512;
                }
            } else if (k < i1) {
                class44_sub3_sub4_sub6.anInt1662 = 1024;
            } else {
                class44_sub3_sub4_sub6.anInt1662 = 0;
            }
            int j1 = class44_sub3_sub4_sub6.anInt1662 - class44_sub3_sub4_sub6.anInt1617 & 0x7ff;
            if (j1 > 1024) {
                j1 -= 2048;
            }
            int k1 = class44_sub3_sub4_sub6.anInt1623;
            packetSize += i;
            if (j1 >= -256 && j1 <= 256) {
                k1 = class44_sub3_sub4_sub6.anInt1622;
            } else if (j1 >= 256 && j1 < 768) {
                k1 = class44_sub3_sub4_sub6.anInt1625;
            } else if (j1 >= -768 && j1 <= -256) {
                k1 = class44_sub3_sub4_sub6.anInt1624;
            }
            if (k1 == -1) {
                k1 = class44_sub3_sub4_sub6.anInt1622;
            }
            class44_sub3_sub4_sub6.anInt1640 = k1;
            int l1 = 4;
            if (class44_sub3_sub4_sub6.anInt1617 != class44_sub3_sub4_sub6.anInt1662
                    && class44_sub3_sub4_sub6.anInt1637 == -1 && class44_sub3_sub4_sub6.anInt1663 != 0) {
                l1 = 2;
            }
            if (class44_sub3_sub4_sub6.anInt1664 > 2) {
                l1 = 6;
            }
            if (class44_sub3_sub4_sub6.anInt1664 > 3) {
                l1 = 8;
            }
            if (class44_sub3_sub4_sub6.anInt1668 > 0 && class44_sub3_sub4_sub6.anInt1664 > 1) {
                l1 = 8;
                class44_sub3_sub4_sub6.anInt1668--;
            }
            if (class44_sub3_sub4_sub6.aBooleanArray1667[class44_sub3_sub4_sub6.anInt1664 - 1]) {
                l1 <<= 1;
            }
            if (l1 >= 8 && class44_sub3_sub4_sub6.anInt1640 == class44_sub3_sub4_sub6.anInt1622
                    && class44_sub3_sub4_sub6.anInt1626 != -1) {
                class44_sub3_sub4_sub6.anInt1640 = class44_sub3_sub4_sub6.anInt1626;
            }
            if (j < l) {
                class44_sub3_sub4_sub6.x += l1;
                if (class44_sub3_sub4_sub6.x > l) {
                    class44_sub3_sub4_sub6.x = l;
                }
            } else if (j > l) {
                class44_sub3_sub4_sub6.x -= l1;
                if (class44_sub3_sub4_sub6.x < l) {
                    class44_sub3_sub4_sub6.x = l;
                }
            }
            if (k < i1) {
                class44_sub3_sub4_sub6.z += l1;
                if (class44_sub3_sub4_sub6.z > i1) {
                    class44_sub3_sub4_sub6.z = i1;
                }
            } else if (k > i1) {
                class44_sub3_sub4_sub6.z -= l1;
                if (class44_sub3_sub4_sub6.z < i1) {
                    class44_sub3_sub4_sub6.z = i1;
                }
            }
            if (class44_sub3_sub4_sub6.x == l && class44_sub3_sub4_sub6.z == i1) {
                class44_sub3_sub4_sub6.anInt1664--;
                if (class44_sub3_sub4_sub6.anInt1669 > 0) {
                    class44_sub3_sub4_sub6.anInt1669--;
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("29188, " + class44_sub3_sub4_sub6 + ", " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method121(byte byte0, Actor class44_sub3_sub4_sub6) {
        try {
            if (byte0 == 2) {
                byte0 = 0;
            } else {
                planeObjStacks = null;
            }
            if (class44_sub3_sub4_sub6.anInt1663 == 0) {
                return;
            }
            if (class44_sub3_sub4_sub6.anInt1637 != -1 && class44_sub3_sub4_sub6.anInt1637 < 32768) {
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[class44_sub3_sub4_sub6.anInt1637];
                if (class44_sub3_sub4_sub6_sub2 != null) {
                    int l = class44_sub3_sub4_sub6.x - class44_sub3_sub4_sub6_sub2.x;
                    int j1 = class44_sub3_sub4_sub6.z - class44_sub3_sub4_sub6_sub2.z;
                    if (l != 0 || j1 != 0) {
                        class44_sub3_sub4_sub6.anInt1662 = (int) (Math.atan2(l, j1) * 325.94900000000001D) & 0x7ff;
                    }
                }
            }
            if (class44_sub3_sub4_sub6.anInt1637 >= 32768) {
                int i = class44_sub3_sub4_sub6.anInt1637 - 32768;
                if (i == localPlayerIndex) {
                    i = anInt1224;
                }
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[i];
                if (class44_sub3_sub4_sub6_sub1 != null) {
                    int k1 = class44_sub3_sub4_sub6.x - class44_sub3_sub4_sub6_sub1.x;
                    int l1 = class44_sub3_sub4_sub6.z - class44_sub3_sub4_sub6_sub1.z;
                    if (k1 != 0 || l1 != 0) {
                        class44_sub3_sub4_sub6.anInt1662 = (int) (Math.atan2(k1, l1) * 325.94900000000001D) & 0x7ff;
                    }
                }
            }
            if ((class44_sub3_sub4_sub6.anInt1638 != 0 || class44_sub3_sub4_sub6.anInt1639 != 0)
                    && (class44_sub3_sub4_sub6.anInt1664 == 0 || class44_sub3_sub4_sub6.anInt1668 > 0)) {
                int j = class44_sub3_sub4_sub6.x - (class44_sub3_sub4_sub6.anInt1638 - sceneBaseTileX - sceneBaseTileX)
                        * 64;
                int i1 = class44_sub3_sub4_sub6.z - (class44_sub3_sub4_sub6.anInt1639 - sceneBaseTileZ - sceneBaseTileZ)
                        * 64;
                if (j != 0 || i1 != 0) {
                    class44_sub3_sub4_sub6.anInt1662 = (int) (Math.atan2(j, i1) * 325.94900000000001D) & 0x7ff;
                }
                class44_sub3_sub4_sub6.anInt1638 = 0;
                class44_sub3_sub4_sub6.anInt1639 = 0;
            }
            int k = class44_sub3_sub4_sub6.anInt1662 - class44_sub3_sub4_sub6.anInt1617 & 0x7ff;
            if (k != 0) {
                if (k < class44_sub3_sub4_sub6.anInt1663 || k > 2048 - class44_sub3_sub4_sub6.anInt1663) {
                    class44_sub3_sub4_sub6.anInt1617 = class44_sub3_sub4_sub6.anInt1662;
                } else if (k > 1024) {
                    class44_sub3_sub4_sub6.anInt1617 -= class44_sub3_sub4_sub6.anInt1663;
                } else {
                    class44_sub3_sub4_sub6.anInt1617 += class44_sub3_sub4_sub6.anInt1663;
                }
                class44_sub3_sub4_sub6.anInt1617 &= 0x7ff;
                if (class44_sub3_sub4_sub6.anInt1640 == class44_sub3_sub4_sub6.anInt1620
                        && class44_sub3_sub4_sub6.anInt1617 != class44_sub3_sub4_sub6.anInt1662) {
                    if (class44_sub3_sub4_sub6.anInt1621 != -1) {
                        class44_sub3_sub4_sub6.anInt1640 = class44_sub3_sub4_sub6.anInt1621;
                        return;
                    } else {
                        class44_sub3_sub4_sub6.anInt1640 = class44_sub3_sub4_sub6.anInt1622;
                        return;
                    }
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("53139, " + byte0 + ", " + class44_sub3_sub4_sub6 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method122(Actor class44_sub3_sub4_sub6, int i) {
        try {
            packetSize += i;
            class44_sub3_sub4_sub6.aBoolean1618 = false;
            if (class44_sub3_sub4_sub6.anInt1640 != -1) {
                SeqType class26 = SeqType.cache[class44_sub3_sub4_sub6.anInt1640];
                class44_sub3_sub4_sub6.anInt1642++;
                if (class44_sub3_sub4_sub6.anInt1641 < class26.anInt509
                        && class44_sub3_sub4_sub6.anInt1642 > class26
                        .method254(class44_sub3_sub4_sub6.anInt1641, 24425)) {
                    class44_sub3_sub4_sub6.anInt1642 = 0;
                    class44_sub3_sub4_sub6.anInt1641++;
                }
                if (class44_sub3_sub4_sub6.anInt1641 >= class26.anInt509) {
                    class44_sub3_sub4_sub6.anInt1642 = 0;
                    class44_sub3_sub4_sub6.anInt1641 = 0;
                }
            }
            if (class44_sub3_sub4_sub6.anInt1648 != -1 && Game.loopCycle >= class44_sub3_sub4_sub6.anInt1651) {
                if (class44_sub3_sub4_sub6.anInt1649 < 0) {
                    class44_sub3_sub4_sub6.anInt1649 = 0;
                }
                SeqType class26_1 = SpotAnimType.cache[class44_sub3_sub4_sub6.anInt1648].aClass26_563;
                for (class44_sub3_sub4_sub6.anInt1650++; class44_sub3_sub4_sub6.anInt1649 < class26_1.anInt509
                        && class44_sub3_sub4_sub6.anInt1650 > class26_1.method254(class44_sub3_sub4_sub6.anInt1649,
                        24425); class44_sub3_sub4_sub6.anInt1649++) {
                    class44_sub3_sub4_sub6.anInt1650 -= class26_1.method254(class44_sub3_sub4_sub6.anInt1649, 24425);
                }
                if (class44_sub3_sub4_sub6.anInt1649 >= class26_1.anInt509
                        && (class44_sub3_sub4_sub6.anInt1649 < 0 || class44_sub3_sub4_sub6.anInt1649 >= class26_1.anInt509)) {
                    class44_sub3_sub4_sub6.anInt1648 = -1;
                }
            }
            if (class44_sub3_sub4_sub6.anInt1643 != -1 && class44_sub3_sub4_sub6.anInt1646 <= 1) {
                SeqType class26_2 = SeqType.cache[class44_sub3_sub4_sub6.anInt1643];
                if (class26_2.anInt520 == 1 && class44_sub3_sub4_sub6.anInt1669 > 0
                        && class44_sub3_sub4_sub6.anInt1657 <= Game.loopCycle
                        && class44_sub3_sub4_sub6.anInt1658 < Game.loopCycle) {
                    class44_sub3_sub4_sub6.anInt1646 = 1;
                    return;
                }
            }
            if (class44_sub3_sub4_sub6.anInt1643 != -1 && class44_sub3_sub4_sub6.anInt1646 == 0) {
                SeqType class26_3 = SeqType.cache[class44_sub3_sub4_sub6.anInt1643];
                for (class44_sub3_sub4_sub6.anInt1645++; class44_sub3_sub4_sub6.anInt1644 < class26_3.anInt509
                        && class44_sub3_sub4_sub6.anInt1645 > class26_3.method254(class44_sub3_sub4_sub6.anInt1644,
                        24425); class44_sub3_sub4_sub6.anInt1644++) {
                    class44_sub3_sub4_sub6.anInt1645 -= class26_3.method254(class44_sub3_sub4_sub6.anInt1644, 24425);
                }
                if (class44_sub3_sub4_sub6.anInt1644 >= class26_3.anInt509) {
                    class44_sub3_sub4_sub6.anInt1644 -= class26_3.anInt513;
                    class44_sub3_sub4_sub6.anInt1647++;
                    if (class44_sub3_sub4_sub6.anInt1647 >= class26_3.anInt519) {
                        class44_sub3_sub4_sub6.anInt1643 = -1;
                    }
                    if (class44_sub3_sub4_sub6.anInt1644 < 0 || class44_sub3_sub4_sub6.anInt1644 >= class26_3.anInt509) {
                        class44_sub3_sub4_sub6.anInt1643 = -1;
                    }
                }
                class44_sub3_sub4_sub6.aBoolean1618 = class26_3.aBoolean515;
            }
            if (class44_sub3_sub4_sub6.anInt1646 > 0) {
                class44_sub3_sub4_sub6.anInt1646--;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("50955, " + class44_sub3_sub4_sub6 + ", " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method123(boolean flag) {
        try {
            if (flag) {
                return;
            }
            if (redrawTitleBackground) {
                redrawTitleBackground = false;
                aClass34_1123.draw(super.graphics, 0, 4);
                aClass34_1124.draw(super.graphics, 0, 357);
                aClass34_1125.draw(super.graphics, 722, 4);
                aClass34_1126.draw(super.graphics, 743, 205);
                aClass34_1127.draw(super.graphics, 0, 0);
                aClass34_1128.draw(super.graphics, 516, 4);
                aClass34_1129.draw(super.graphics, 516, 205);
                aClass34_1130.draw(super.graphics, 496, 357);
                aClass34_1131.draw(super.graphics, 0, 338);
                redrawInvBack = true;
                redrawChatback = true;
                redrawSideicons = true;
                redrawPrivacySettings = true;
                if (sceneState != 2) {
                    areaViewport.draw(super.graphics, 4, 4);
                    aClass34_1196.draw(super.graphics, 550, 4);
                }
            }
            if (sceneState == 2) {
                renderGameView(0);
            }
            if (menuVisible && anInt1030 == 1) {
                redrawInvBack = true;
            }
            if (anInt889 != -1) {
                boolean flag1 = method65(anInt824, anInt889, (byte) -103);
                if (flag1) {
                    redrawInvBack = true;
                }
            }
            if (anInt1151 == 2) {
                redrawInvBack = true;
            }
            if (anInt1095 == 2) {
                redrawInvBack = true;
            }
            if (redrawInvBack) {
                method113((byte) 3);
                redrawInvBack = false;
            }
            if (anInt1253 == -1) {
                aClass5_1201.anInt120 = anInt874 - anInt1103 - 77;
                if (super.anInt21 > 448 && super.anInt21 < 560 && super.anInt22 > 332) {
                    method81(0, super.anInt21 - 17, aClass5_1201, 463, false, 77, aByte830, super.anInt22 - 357,
                            anInt874);
                }
                int i = anInt874 - 77 - aClass5_1201.anInt120;
                if (i < 0) {
                    i = 0;
                }
                if (i > anInt874 - 77) {
                    i = anInt874 - 77;
                }
                if (anInt1103 != i) {
                    anInt1103 = i;
                    redrawChatback = true;
                }
            }
            if (anInt1253 != -1) {
                boolean flag2 = method65(anInt824, anInt1253, (byte) -103);
                if (flag2) {
                    redrawChatback = true;
                }
            }
            if (anInt1151 == 3) {
                redrawChatback = true;
            }
            if (anInt1095 == 3) {
                redrawChatback = true;
            }
            if (clickToContinueString != null) {
                redrawChatback = true;
            }
            if (menuVisible && anInt1030 == 2) {
                redrawChatback = true;
            }
            if (redrawChatback) {
                method47(311);
                redrawChatback = false;
            }
            if (sceneState == 2) {
                method36(0);
                aClass34_1196.draw(super.graphics, 550, 4);
            }
            if (anInt833 != -1) {
                redrawSideicons = true;
            }
            if (redrawSideicons) {
                if (anInt833 != -1 && anInt833 == currentTab) {
                    anInt833 = -1;
                    out.writePacket(146);
                    out.writeByte(currentTab);
                }
                redrawSideicons = false;
                aClass34_860.bind();
                aClass44_Sub3_Sub1_Sub3_905.blit(0, 0);
                if (anInt889 == -1) {
                    if (tabComponentId[currentTab] != -1) {
                        if (currentTab == 0) {
                            aClass44_Sub3_Sub1_Sub3_1136.blit(10, 22);
                        }
                        if (currentTab == 1) {
                            aClass44_Sub3_Sub1_Sub3_1137.blit(8, 54);
                        }
                        if (currentTab == 2) {
                            aClass44_Sub3_Sub1_Sub3_1137.blit(8, 82);
                        }
                        if (currentTab == 3) {
                            aClass44_Sub3_Sub1_Sub3_1138.blit(8, 110);
                        }
                        if (currentTab == 4) {
                            aClass44_Sub3_Sub1_Sub3_1140.blit(8, 153);
                        }
                        if (currentTab == 5) {
                            aClass44_Sub3_Sub1_Sub3_1140.blit(8, 181);
                        }
                        if (currentTab == 6) {
                            aClass44_Sub3_Sub1_Sub3_1139.blit(9, 209);
                        }
                    }
                    if (tabComponentId[0] != -1 && (anInt833 != 0 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[0].blit(13, 29);
                    }
                    if (tabComponentId[1] != -1 && (anInt833 != 1 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[1].blit(11, 53);
                    }
                    if (tabComponentId[2] != -1 && (anInt833 != 2 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[2].blit(11, 82);
                    }
                    if (tabComponentId[3] != -1 && (anInt833 != 3 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[3].blit(12, 115);
                    }
                    if (tabComponentId[4] != -1 && (anInt833 != 4 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[4].blit(13, 153);
                    }
                    if (tabComponentId[5] != -1 && (anInt833 != 5 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[5].blit(11, 180);
                    }
                    if (tabComponentId[6] != -1 && (anInt833 != 6 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[6].blit(13, 208);
                    }
                }
                aClass34_860.draw(super.graphics, 516, 160);
                aClass34_859.bind();
                aClass44_Sub3_Sub1_Sub3_904.blit(0, 0);
                if (anInt889 == -1) {
                    if (tabComponentId[currentTab] != -1) {
                        if (currentTab == 7) {
                            aClass44_Sub3_Sub1_Sub3_852.blit(0, 42);
                        }
                        if (currentTab == 8) {
                            aClass44_Sub3_Sub1_Sub3_853.blit(0, 74);
                        }
                        if (currentTab == 9) {
                            aClass44_Sub3_Sub1_Sub3_853.blit(0, 102);
                        }
                        if (currentTab == 10) {
                            aClass44_Sub3_Sub1_Sub3_854.blit(1, 130);
                        }
                        if (currentTab == 11) {
                            aClass44_Sub3_Sub1_Sub3_856.blit(0, 173);
                        }
                        if (currentTab == 12) {
                            aClass44_Sub3_Sub1_Sub3_856.blit(0, 201);
                        }
                        if (currentTab == 13) {
                            aClass44_Sub3_Sub1_Sub3_855.blit(0, 229);
                        }
                    }
                    if (tabComponentId[8] != -1 && (anInt833 != 8 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[7].blit(2, 74);
                    }
                    if (tabComponentId[9] != -1 && (anInt833 != 9 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[8].blit(3, 102);
                    }
                    if (tabComponentId[10] != -1 && (anInt833 != 10 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[9].blit(4, 137);
                    }
                    if (tabComponentId[11] != -1 && (anInt833 != 11 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[10].blit(2, 174);
                    }
                    if (tabComponentId[12] != -1 && (anInt833 != 12 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[11].blit(2, 201);
                    }
                    if (tabComponentId[13] != -1 && (anInt833 != 13 || Game.loopCycle % 20 < 10)) {
                        aClass44_Sub3_Sub1_Sub3Array1276[12].blit(2, 226);
                    }
                }
                aClass34_859.draw(super.graphics, 496, 466);
                areaViewport.bind();
            }
            if (redrawPrivacySettings) {
                redrawPrivacySettings = false;
                aClass34_858.bind();
                aClass44_Sub3_Sub1_Sub3_903.blit(0, 0);
                plainFont.drawStringCenter(true, 0xffffff, (byte) -85, 55, "Public chat", 28);
                if (publicChatSetting == 0) {
                    plainFont.drawStringCenter(true, 65280, (byte) -85, 55, "On", 41);
                }
                if (publicChatSetting == 1) {
                    plainFont.drawStringCenter(true, 0xffff00, (byte) -85, 55, "Friends", 41);
                }
                if (publicChatSetting == 2) {
                    plainFont.drawStringCenter(true, 0xff0000, (byte) -85, 55, "Off", 41);
                }
                if (publicChatSetting == 3) {
                    plainFont.drawStringCenter(true, 65535, (byte) -85, 55, "Hide", 41);
                }
                plainFont.drawStringCenter(true, 0xffffff, (byte) -85, 184, "Private chat", 28);
                if (privateChatSetting == 0) {
                    plainFont.drawStringCenter(true, 65280, (byte) -85, 184, "On", 41);
                }
                if (privateChatSetting == 1) {
                    plainFont.drawStringCenter(true, 0xffff00, (byte) -85, 184, "Friends", 41);
                }
                if (privateChatSetting == 2) {
                    plainFont.drawStringCenter(true, 0xff0000, (byte) -85, 184, "Off", 41);
                }
                plainFont.drawStringCenter(true, 0xffffff, (byte) -85, 324, "Trade/compete", 28);
                if (tradeChatSetting == 0) {
                    plainFont.drawStringCenter(true, 65280, (byte) -85, 324, "On", 41);
                }
                if (tradeChatSetting == 1) {
                    plainFont.drawStringCenter(true, 0xffff00, (byte) -85, 324, "Friends", 41);
                }
                if (tradeChatSetting == 2) {
                    plainFont.drawStringCenter(true, 0xff0000, (byte) -85, 324, "Off", 41);
                }
                plainFont.drawStringCenter(true, 0xffffff, (byte) -85, 458, "Report abuse", 33);
                aClass34_858.draw(super.graphics, 0, 453);
                areaViewport.bind();
            }
            anInt824 = 0;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27122, " + flag + ", " + runtimeexception);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean tryMove(int i, int j, int k, int l, int i1, int j1, boolean flag, int k1, int l1, int i2, int j2,
                           int k2) {
        try {
            byte byte0 = 104;
            byte byte1 = 104;
            for (int l2 = 0; l2 < byte0; l2++) {
                for (int i3 = 0; i3 < byte1; i3++) {
                    anIntArrayArray1113[l2][i3] = 0;
                    anIntArrayArray975[l2][i3] = 0x5f5e0ff;
                }
            }
            int j3 = j;
            int k3 = k2;
            anIntArrayArray1113[j][k2] = 99;
            anIntArrayArray975[j][k2] = 0;
            int l3 = 0;
            int i4 = 0;
            anIntArray1020[l3] = j;
            anIntArray1021[l3++] = k2;
            boolean flag1 = false;
            if (l1 <= 0) {
                anInt1091 = 304;
            }
            int j4 = anIntArray1020.length;
            int[][] ai = aClass18Array1022[plane].anIntArrayArray418;
            while (i4 != l3) {
                j3 = anIntArray1020[i4];
                k3 = anIntArray1021[i4];
                i4 = (i4 + 1) % j4;
                if (j3 == j2 && k3 == l) {
                    flag1 = true;
                    break;
                }
                if (j1 != 0) {
                    if ((j1 < 5 || j1 == 10) && aClass18Array1022[plane].method240(l, k, j1 - 1, j2, k3, j3, -628)) {
                        flag1 = true;
                        break;
                    }
                    if (j1 < 10 && aClass18Array1022[plane].method241((byte) -58, j2, k3, l, j1 - 1, k, j3)) {
                        flag1 = true;
                        break;
                    }
                }
                if (i != 0 && i2 != 0
                        && aClass18Array1022[plane].method242(i, l, k3, Game.anInt958, i2, j3, i1, j2)) {
                    flag1 = true;
                    break;
                }
                int l4 = anIntArrayArray975[j3][k3] + 1;
                if (j3 > 0 && anIntArrayArray1113[j3 - 1][k3] == 0 && (ai[j3 - 1][k3] & 0x280108) == 0) {
                    anIntArray1020[l3] = j3 - 1;
                    anIntArray1021[l3] = k3;
                    l3 = (l3 + 1) % j4;
                    anIntArrayArray1113[j3 - 1][k3] = 2;
                    anIntArrayArray975[j3 - 1][k3] = l4;
                }
                if (j3 < byte0 - 1 && anIntArrayArray1113[j3 + 1][k3] == 0 && (ai[j3 + 1][k3] & 0x280180) == 0) {
                    anIntArray1020[l3] = j3 + 1;
                    anIntArray1021[l3] = k3;
                    l3 = (l3 + 1) % j4;
                    anIntArrayArray1113[j3 + 1][k3] = 8;
                    anIntArrayArray975[j3 + 1][k3] = l4;
                }
                if (k3 > 0 && anIntArrayArray1113[j3][k3 - 1] == 0 && (ai[j3][k3 - 1] & 0x280102) == 0) {
                    anIntArray1020[l3] = j3;
                    anIntArray1021[l3] = k3 - 1;
                    l3 = (l3 + 1) % j4;
                    anIntArrayArray1113[j3][k3 - 1] = 1;
                    anIntArrayArray975[j3][k3 - 1] = l4;
                }
                if (k3 < byte1 - 1 && anIntArrayArray1113[j3][k3 + 1] == 0 && (ai[j3][k3 + 1] & 0x280120) == 0) {
                    anIntArray1020[l3] = j3;
                    anIntArray1021[l3] = k3 + 1;
                    l3 = (l3 + 1) % j4;
                    anIntArrayArray1113[j3][k3 + 1] = 4;
                    anIntArrayArray975[j3][k3 + 1] = l4;
                }
                if (j3 > 0 && k3 > 0 && anIntArrayArray1113[j3 - 1][k3 - 1] == 0
                        && (ai[j3 - 1][k3 - 1] & 0x28010e) == 0 && (ai[j3 - 1][k3] & 0x280108) == 0
                        && (ai[j3][k3 - 1] & 0x280102) == 0) {
                    anIntArray1020[l3] = j3 - 1;
                    anIntArray1021[l3] = k3 - 1;
                    l3 = (l3 + 1) % j4;
                    anIntArrayArray1113[j3 - 1][k3 - 1] = 3;
                    anIntArrayArray975[j3 - 1][k3 - 1] = l4;
                }
                if (j3 < byte0 - 1 && k3 > 0 && anIntArrayArray1113[j3 + 1][k3 - 1] == 0
                        && (ai[j3 + 1][k3 - 1] & 0x280183) == 0 && (ai[j3 + 1][k3] & 0x280180) == 0
                        && (ai[j3][k3 - 1] & 0x280102) == 0) {
                    anIntArray1020[l3] = j3 + 1;
                    anIntArray1021[l3] = k3 - 1;
                    l3 = (l3 + 1) % j4;
                    anIntArrayArray1113[j3 + 1][k3 - 1] = 9;
                    anIntArrayArray975[j3 + 1][k3 - 1] = l4;
                }
                if (j3 > 0 && k3 < byte1 - 1 && anIntArrayArray1113[j3 - 1][k3 + 1] == 0
                        && (ai[j3 - 1][k3 + 1] & 0x280138) == 0 && (ai[j3 - 1][k3] & 0x280108) == 0
                        && (ai[j3][k3 + 1] & 0x280120) == 0) {
                    anIntArray1020[l3] = j3 - 1;
                    anIntArray1021[l3] = k3 + 1;
                    l3 = (l3 + 1) % j4;
                    anIntArrayArray1113[j3 - 1][k3 + 1] = 6;
                    anIntArrayArray975[j3 - 1][k3 + 1] = l4;
                }
                if (j3 < byte0 - 1 && k3 < byte1 - 1 && anIntArrayArray1113[j3 + 1][k3 + 1] == 0
                        && (ai[j3 + 1][k3 + 1] & 0x2801e0) == 0 && (ai[j3 + 1][k3] & 0x280180) == 0
                        && (ai[j3][k3 + 1] & 0x280120) == 0) {
                    anIntArray1020[l3] = j3 + 1;
                    anIntArray1021[l3] = k3 + 1;
                    l3 = (l3 + 1) % j4;
                    anIntArrayArray1113[j3 + 1][k3 + 1] = 12;
                    anIntArrayArray975[j3 + 1][k3 + 1] = l4;
                }
            }
            anInt972 = 0;
            if (!flag1) {
                if (flag) {
                    int i5 = 100;
                    for (int k5 = 1; k5 < 2; k5++) {
                        for (int i6 = j2 - k5; i6 <= j2 + k5; i6++) {
                            for (int k6 = l - k5; k6 <= l + k5; k6++) {
                                if (i6 >= 0 && k6 >= 0 && i6 < 104 && k6 < 104 && anIntArrayArray975[i6][k6] < i5) {
                                    i5 = anIntArrayArray975[i6][k6];
                                    j3 = i6;
                                    k3 = k6;
                                    anInt972 = 1;
                                    flag1 = true;
                                }
                            }
                        }
                        if (flag1) {
                            break;
                        }
                    }
                }
                if (!flag1) {
                    return false;
                }
            }
            i4 = 0;
            anIntArray1020[i4] = j3;
            anIntArray1021[i4++] = k3;
            int l5;
            for (int j5 = l5 = anIntArrayArray1113[j3][k3]; j3 != j || k3 != k2; j5 = anIntArrayArray1113[j3][k3]) {
                if (j5 != l5) {
                    l5 = j5;
                    anIntArray1020[i4] = j3;
                    anIntArray1021[i4++] = k3;
                }
                if ((j5 & 2) != 0) {
                    j3++;
                } else if ((j5 & 8) != 0) {
                    j3--;
                }
                if ((j5 & 1) != 0) {
                    k3++;
                } else if ((j5 & 4) != 0) {
                    k3--;
                }
            }
            if (i4 > 0) {
                int k4 = i4;
                if (k4 > 25) {
                    k4 = 25;
                }
                i4--;
                int j6 = anIntArray1020[i4];
                int l6 = anIntArray1021[i4];
                if (k1 == 0) {
                    out.writePacket(234);
                    out.writeByte(k4 + k4 + 3);
                }
                if (k1 == 1) {
                    out.writePacket(236);
                    out.writeByte(k4 + k4 + 3 + 14);
                }
                if (k1 == 2) {
                    out.writePacket(67);
                    out.writeByte(k4 + k4 + 3);
                }
                if (super.anIntArray31[5] == 1) {
                    out.writeByte(1);
                } else {
                    out.writeByte(0);
                }
                out.writeShort(j6 + sceneBaseTileX);//x
                out.writeShort(l6 + sceneBaseTileZ);//y
                flagSceneTileX = anIntArray1020[0];
                flagSceneTileZ = anIntArray1021[0];
                for (int i7 = 1; i7 < k4; i7++) {
                    i4--;
                    out.writeByte(anIntArray1020[i4] - j6);//x
                    out.writeByte(anIntArray1021[i4] - l6);//y
                }
                return true;
            }
            return k1 != 1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("96354, " + i + ", " + j + ", " + k + ", " + l + ", " + i1 + ", " + j1 + ", " + flag
                    + ", " + k1 + ", " + l1 + ", " + i2 + ", " + j2 + ", " + k2 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public FileArchive method125(byte byte0, String s, int i, String s1, int j, int k) {
        try {
            byte[] abyte0 = null;
            if (byte0 != -9) {
                throw new NullPointerException();
            }
            int l = 5;
            try {
                if (aClass45Array1208[0] != null) {
                    abyte0 = aClass45Array1208[0].method541(false, i);
                }
            } catch (Exception _ex) {
            }
            if (abyte0 != null) {
                aCRC32_951.reset();
                aCRC32_951.update(abyte0);
                int i1 = (int) aCRC32_951.getValue();
                if (i1 != k) {
                    abyte0 = null;
                }
            }
            if (abyte0 != null) {
                FileArchive class47 = new FileArchive(abyte0, 0);
                return class47;
            }
            int j1 = 0;
            while (abyte0 == null) {
                String s2 = "Unknown error";
                method13(false, j, "Requesting " + s);
                try {
                    int k1 = 0;
                    DataInputStream datainputstream = method77(s1 + k);
                    byte[] abyte1 = new byte[6];
                    datainputstream.readFully(abyte1, 0, 6);
                    Buffer class44_sub3_sub2 = new Buffer(abyte1);
                    class44_sub3_sub2.position = 3;
                    int i2 = class44_sub3_sub2.method486() + 6;
                    int j2 = 6;
                    abyte0 = new byte[i2];
                    for (int k2 = 0; k2 < 6; k2++) {
                        abyte0[k2] = abyte1[k2];
                    }
                    while (j2 < i2) {
                        int l2 = i2 - j2;
                        if (l2 > 1000) {
                            l2 = 1000;
                        }
                        int j3 = datainputstream.read(abyte0, j2, l2);
                        if (j3 < 0) {
                            s2 = "Length error: " + j2 + "/" + i2;
                            throw new IOException("EOF");
                        }
                        j2 += j3;
                        int k3 = (j2 * 100) / i2;
                        if (k3 != k1) {
                            method13(false, j, "Loading " + s + " - " + k3 + "%");
                        }
                        k1 = k3;
                    }
                    datainputstream.close();
                    try {
                        if (aClass45Array1208[0] != null) {
                            aClass45Array1208[0].method542(abyte0, (byte) 4, abyte0.length, i);
                        }
                    } catch (Exception _ex) {
                        aClass45Array1208[0] = null;
                    }
                    if (abyte0 != null) {
                        aCRC32_951.reset();
                        aCRC32_951.update(abyte0);
                        int i3 = (int)
                                aCRC32_951.getValue();
                        if (i3 != k) {
                            abyte0 = null;
                            j1++;
                            s2 = "Checksum error: " + i3;
                        }
                    }
                } catch (IOException ioexception) {
                    if (s2.equals("Unknown error")) {
                        s2 = "Connection error";
                    }
                    abyte0 = null;
                } catch (NullPointerException _ex) {
                    s2 = "Null error";
                    abyte0 = null;
                    if (!SignLink.reporterror) {
                        return null;
                    }
                } catch (ArrayIndexOutOfBoundsException _ex) {
                    s2 = "Bounds error";
                    abyte0 = null;
                    if (!SignLink.reporterror) {
                        return null;
                    }
                } catch (Exception _ex) {
                    s2 = "Unexpected error";
                    abyte0 = null;
                    if (!SignLink.reporterror) {
                        return null;
                    }
                }
                if (abyte0 == null) {
                    for (int l1 = l; l1 > 0; l1--) {
                        if (j1 >= 3) {
                            method13(false, j, "Game updated - please reload page");
                            l1 = 10;
                        } else {
                            method13(false, j, s2 + " - Retrying in " + l1);
                        }
                        try {
                            Thread.sleep(1000L);
                        } catch (Exception _ex) {
                        }
                    }
                    l *= 2;
                    if (l > 60) {
                        l = 60;
                    }
                    aBoolean922 = !aBoolean922;
                }
            }
            FileArchive class47_1 = new FileArchive(abyte0, 0);
            return class47_1;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("12814, " + byte0 + ", " + s + ", " + i + ", " + s1 + ", " + j + ", " + k + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public int method126() {
        try {
            int worldPlane = 3;

            if (cameraVerticalRotation < 310) {
                int cameraX = cameraPositionX >> 7;
                int cameraZ = cameraPositionZ >> 7;
                int playerX = self.x >> 7;
                int playerZ = self.z >> 7;
                if ((planeTileFlags[this.plane][cameraX][cameraZ] & 4) != 0) {
                    worldPlane = this.plane;
                }
                int x;
                if (playerX > cameraX) {
                    x = playerX - cameraX;
                } else {
                    x = cameraX - playerX;
                }
                int z;
                if (playerZ > cameraZ) {
                    z = playerZ - cameraZ;
                } else {
                    z = cameraZ - playerZ;
                }
                if (x > z) {
                    int l1 = (z * 0x10000) / x;
                    int j2 = 32768;
                    while (cameraX != playerX) {
                        if (cameraX < playerX) {
                            cameraX++;
                        } else if (cameraX > playerX) {
                            cameraX--;
                        }
                        if ((planeTileFlags[this.plane][cameraX][cameraZ] & 4) != 0) {
                            worldPlane = this.plane;
                        }
                        j2 += l1;
                        if (j2 >= 0x10000) {
                            j2 -= 0x10000;
                            if (cameraZ < playerZ) {
                                cameraZ++;
                            } else if (cameraZ > playerZ) {
                                cameraZ--;
                            }
                            if ((planeTileFlags[this.plane][cameraX][cameraZ] & 4) != 0) {
                                worldPlane = this.plane;
                            }
                        }
                    }
                } else {
                    int i2 = (x * 0x10000) / z;
                    int k2 = 32768;
                    while (cameraZ != playerZ) {
                        if (cameraZ < playerZ) {
                            cameraZ++;
                        } else if (cameraZ > playerZ) {
                            cameraZ--;
                        }
                        if ((planeTileFlags[this.plane][cameraX][cameraZ] & 4) != 0) {
                            worldPlane = this.plane;
                        }
                        k2 += i2;
                        if (k2 >= 0x10000) {
                            k2 -= 0x10000;
                            if (cameraX < playerX) {
                                cameraX++;
                            } else if (cameraX > playerX) {
                                cameraX--;
                            }
                            if ((planeTileFlags[this.plane][cameraX][cameraZ] & 4) != 0) {
                                worldPlane = this.plane;
                            }
                        }
                    }
                }
            }
            if ((planeTileFlags[this.plane][Game.self.x >> 7][Game.self.z >> 7] & 4) != 0) {
                worldPlane = this.plane;
            }
            return worldPlane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int method127(byte byte0) {
        try {
            if (byte0 == 7) {
                byte0 = 0;
            } else {
                return 2;
            }
            int i = getFloorDrawHeight(false, cameraPositionZ, cameraPositionX, plane);
            if (i - cameraPositionY < 800 && (planeTileFlags[plane][cameraPositionX >> 7][cameraPositionZ >> 7] & 4) != 0) {
                return plane;
            } else {
                return 3;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("19764, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method128(boolean flag) {
        try {
            aBoolean1174 = false;
            while (aBoolean893) {
                aBoolean1174 = false;
                try {
                    Thread.sleep(50L);
                } catch (Exception _ex) {
                }
            }
            titleBox = null;
            titleButton = null;
            aClass44_Sub3_Sub1_Sub3Array864 = null;
            anIntArray1218 = null;
            anIntArray1219 = null;
            anIntArray1220 = null;
            anIntArray1221 = null;
            anIntArray1133 = null;
            anIntArray1134 = null;
            anIntArray1272 = null;
            if (flag) {
                out.writeByte(203);
            }
            anIntArray1273 = null;
            aClass44_Sub3_Sub1_Sub2_1277 = null;
            aClass44_Sub3_Sub1_Sub2_1278 = null;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("94958, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void run() {
        if (aBoolean886) {
            method35(false);
            return;
        } else {
            super.run();
            return;
        }
    }

    public void method129(int i) {
        try {
            try {
                lastRegionId = -1;
                aClass28_1054.method263();
                aClass28_918.method263();
                Draw3D.method421(false);
                method76(aByte1042);
                scene.method278(true);
                for (int j = 0; j < 4; j++) {
                    aClass18Array1022[j].method231(3);
                }
                System.gc();
                regionCached class3 = new regionCached(anIntArrayArrayArray865, 104, (byte) 9, planeTileFlags, 104);
                int k1 = sceneMapLandData.length;
                regionCached.aBoolean64 = Scene.aBoolean606;
                for (int j2 = 0; j2 < k1; j2++) {
                    int l2 = sceneMapIndex[j2] >> 8;
                    int k3 = sceneMapIndex[j2] & 0xff;
                    if (l2 == 33 && k3 >= 71 && k3 <= 73) {
                        regionCached.aBoolean64 = false;
                    }
                }
                if (regionCached.aBoolean64) {
                    scene.method279((byte) 7, plane);
                } else {
                    scene.method279((byte) 7, 0);
                }
                for (int i3 = 0; i3 < k1; i3++) {
                    int l3 = (sceneMapIndex[i3] >> 8) * 64 - sceneBaseTileX;
                    int k4 = (sceneMapIndex[i3] & 0xff) * 64 - sceneBaseTileZ;
                    byte[] abyte0 = sceneMapLandData[i3];
                    if (abyte0 != null) {
                        class3.method158((sceneCenterZoneZ - 6) * 8, (sceneCenterZoneX - 6) * 8, (byte) -54, abyte0, k4, l3);
                    }
                }
                for (int i4 = 0; i4 < k1; i4++) {
                    int l4 = (sceneMapIndex[i4] >> 8) * 64 - sceneBaseTileX;
                    int k5 = (sceneMapIndex[i4] & 0xff) * 64 - sceneBaseTileZ;
                    byte[] abyte2 = sceneMapLandData[i4];
                    if (abyte2 == null && sceneCenterZoneZ < 800) {
                        class3.method157(l4, k5, 64, true, 64);
                    }
                }
               // aClass44_Sub3_Sub2_850.writePacket(181);
                for (int i5 = 0; i5 < k1; i5++) {
                    byte[] abyte1 = sceneMapLocData[i5];
                    if (abyte1 != null) {
                        int j6 = (sceneMapIndex[i5] >> 8) * 64 - sceneBaseTileX;
                        int l6 = (sceneMapIndex[i5] & 0xff) * 64 - sceneBaseTileZ;
                        class3.method161(l6, j6, abyte1, scene, (byte) 4, aClass18Array1022);
                    }
                }
                //aClass44_Sub3_Sub2_850.writePacket(181);
                class3.method163((byte) 76, aClass18Array1022, scene);
                areaViewport.bind();
               // aClass44_Sub3_Sub2_850.writePacket(181);
                for (int l5 = 0; l5 < 104; l5++) {
                    for (int k6 = 0; k6 < 104; k6++) {
                        method92(l5, k6);
                    }
                }
                method101(-922);
            } catch (Exception exception) {
            }
            LocType.aClass39_251.method341();
            if (Game.lowMemory && SignLink.cache_dat != null) {
                int k = ondemand.method385(0, (byte) 7);
                for (int i1 = 0; i1 < k; i1++) {
                    int l1 = ondemand.method390(i1, -600);
                    if ((l1 & 0x79) == 0) {
                        Model.method505((byte) 63, i1);
                    }
                }
            }
            System.gc();
            Draw3D.method422(1, 20);
            if (i != -17416) {
                return;
            }
            ondemand.method396(anInt948);
            int l = (sceneCenterZoneX - 6) / 8 - 1;
            int j1 = (sceneCenterZoneX + 6) / 8 + 1;
            int i2 = (sceneCenterZoneZ - 6) / 8 - 1;
            int k2 = (sceneCenterZoneZ + 6) / 8 + 1;
            if (withinTutorialIsland) {
                l = 49;
                j1 = 50;
                i2 = 49;
                k2 = 50;
            }
            for (int j3 = l; j3 <= j1; j3++) {
                for (int j4 = i2; j4 <= k2; j4++) {
                    if (j3 == l || j3 == j1 || j4 == i2 || j4 == k2) {
                        int j5 = ondemand.getMapFile(j4, -942, j3, 0);
                        if (j5 != -1) {
                            ondemand.method397(j5, 3, (byte) 6);
                        }
                        int i6 = ondemand.getMapFile(j4, -942, j3, 1);
                        if (i6 != -1) {
                            ondemand.method397(i6, 3, (byte) 6);
                        }
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("93797, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method130(int i, Buffer class44_sub3_sub2, boolean flag) {
        try {
            class44_sub3_sub2.method492((byte) -51);
            int j = class44_sub3_sub2.method493(1, false);
            if (j == 0) {
                return;
            }
            int k = class44_sub3_sub2.method493(2, false);
            if (flag) {
                packetType = class44_sub3_sub2.readUnsignedByte();
            }
            if (k == 0) {
                anIntArray1229[anInt1228++] = anInt1224;
                return;
            }
            if (k == 1) {//walk
                int l = class44_sub3_sub2.method493(3, false);//direction
                Game.self.method533(false, l, anInt1153);
                int k1 = class44_sub3_sub2.method493(1, false);//update req
                if (k1 == 1) {
                    anIntArray1229[anInt1228++] = anInt1224;
                }
                return;
            }
            if (k == 2) {//run
                int i1 = class44_sub3_sub2.method493(3, false);//last
                Game.self.method533(true, i1, anInt1153);
                int l1 = class44_sub3_sub2.method493(3, false);//curr
                Game.self.method533(true, l1, anInt1153);
                int j2 = class44_sub3_sub2.method493(1, false);//update req
                if (j2 == 1) {
                    anIntArray1229[anInt1228++] = anInt1224;
                }
                return;
            }
            if (k == 3) {//teleport
                plane = class44_sub3_sub2.method493(2, false);//plane
                int j1 = class44_sub3_sub2.method493(7, false);//x?
                int i2 = class44_sub3_sub2.method493(7, false);//y?
                int k2 = class44_sub3_sub2.method493(1, false);//clear waypoint
                Game.self.method532(j1, k2 == 1, i2, aByte925);
                int l2 = class44_sub3_sub2.method493(1, false);//update req
                if (l2 == 1) {
                    anIntArray1229[anInt1228++] = anInt1224;
                }
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("6378, " + i + ", " + class44_sub3_sub2 + ", " + flag + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void setCutsceneCamera(int i) {
        try {
            int j = anInt1118 * 128 + 64;
            int k = anInt1119 * 128 + 64;
            int l = getFloorDrawHeight(false, k, j, plane) - anInt1120;
            if (cameraPositionX < j) {
                cameraPositionX += anInt1121 + ((j - cameraPositionX) * anInt1122) / 1000;
                if (cameraPositionX > j) {
                    cameraPositionX = j;
                }
            }
            if (cameraPositionX > j) {
                cameraPositionX -= anInt1121 + ((cameraPositionX - j) * anInt1122) / 1000;
                if (cameraPositionX < j) {
                    cameraPositionX = j;
                }
            }
            if (cameraPositionY < l) {
                cameraPositionY += anInt1121 + ((l - cameraPositionY) * anInt1122) / 1000;
                if (cameraPositionY > l) {
                    cameraPositionY = l;
                }
            }
            if (cameraPositionY > l) {
                cameraPositionY -= anInt1121 + ((cameraPositionY - l) * anInt1122) / 1000;
                if (cameraPositionY < l) {
                    cameraPositionY = l;
                }
            }
            if (cameraPositionZ < k) {
                cameraPositionZ += anInt1121 + ((k - cameraPositionZ) * anInt1122) / 1000;
                if (cameraPositionZ > k) {
                    cameraPositionZ = k;
                }
            }
            if (cameraPositionZ > k) {
                cameraPositionZ -= anInt1121 + ((cameraPositionZ - k) * anInt1122) / 1000;
                if (cameraPositionZ < k) {
                    cameraPositionZ = k;
                }
            }
            j = anInt989 * 128 + 64;
            k = anInt990 * 128 + 64;
            l = getFloorDrawHeight(false, k, j, plane) - anInt991;
            int i1 = j - cameraPositionX;
            int j1 = l - cameraPositionY;
            int k1 = k - cameraPositionZ;
            packetSize += i;
            int l1 = (int) Math.sqrt(i1 * i1 + k1 * k1);
            int i2 = (int) (Math.atan2(j1, l1) * 325.94900000000001D) & 0x7ff;
            int j2 = (int) (Math.atan2(i1, k1) * -325.94900000000001D) & 0x7ff;
            if (i2 < 128) {
                i2 = 128;
            }
            if (i2 > 383) {
                i2 = 383;
            }
            if (cameraVerticalRotation < i2) {
                cameraVerticalRotation += anInt992 + ((i2 - cameraVerticalRotation) * anInt993) / 1000;
                if (cameraVerticalRotation > i2) {
                    cameraVerticalRotation = i2;
                }
            }
            if (cameraVerticalRotation > i2) {
                cameraVerticalRotation -= anInt992 + ((cameraVerticalRotation - i2) * anInt993) / 1000;
                if (cameraVerticalRotation < i2) {
                    cameraVerticalRotation = i2;
                }
            }
            int k2 = j2 - anInt879;
            if (k2 > 1024) {
                k2 -= 2048;
            }
            if (k2 < -1024) {
                k2 += 2048;
            }
            if (k2 > 0) {
                anInt879 += anInt992 + (k2 * anInt993) / 1000;
                anInt879 &= 0x7ff;
            }
            if (k2 < 0) {
                anInt879 -= anInt992 + (-k2 * anInt993) / 1000;
                anInt879 &= 0x7ff;
            }
            int l2 = j2 - anInt879;
            if (l2 > 1024) {
                l2 -= 2048;
            }
            if (l2 < -1024) {
                l2 += 2048;
            }
            if (l2 < 0 && k2 > 0 || l2 > 0 && k2 < 0) {
                anInt879 = j2;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("37827, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method133(int i) {
        try {
            Game.anInt1087++;
            while (i >= 0) {
                anInt962 = 326;
            }
            do {
                int j = method5(-128);
                if (j == -1) {
                    break;
                }
                if (anInt1199 != -1 && anInt1199 == anInt1217) {
                    if (j == 8 && aString939.length() > 0) {
                        aString939 = aString939.substring(0, aString939.length() - 1);
                    }
                    if ((j >= 97 && j <= 122 || j >= 65 && j <= 90 || j >= 48 && j <= 57 || j == 32)
                            && aString939.length() < 12) {
                        aString939 += (char) j;
                    }
                } else if (aBoolean1222) {
                    if (j >= 32 && j <= 122 && aString1007.length() < 80) {
                        aString1007 += (char) j;
                        redrawChatback = true;
                    }
                    if (j == 8 && aString1007.length() > 0) {
                        aString1007 = aString1007.substring(0, aString1007.length() - 1);
                        redrawChatback = true;
                    }
                    if (j == 13 || j == 10) {
                        aBoolean1222 = false;
                        redrawChatback = true;
                        if (anInt880 == 1) {
                            long l = TextUtils.encodeBase37(aString1007);
                            method95(0, l);
                        }
                        if (anInt880 == 2 && anInt1104 > 0) {
                            long l1 = TextUtils.encodeBase37(aString1007);
                            method44(l1, 37517);
                        }
                        if (anInt880 == 3 && aString1007.length() > 0) {
                            out.writePacket(107);
                            out.writeByte(0);
                            int k = out.position;
                            out.method478(aLong967, true);
                            ChatCompression.method557(aString1007, out, 991);
                            out.method481(out.position - k, anInt1152);
                            aString1007 = ChatCompression.method558(aString1007, anInt1242);
                            aString1007 = ChatCensor.method352(aString1007, anInt1242);
                            renderText(6, (byte) -115, aString1007,
                                    TextUtils.method554(TextUtils.method551(aLong967, true), true));
                            if (privateChatSetting == 2) {
                                privateChatSetting = 1;
                                redrawPrivacySettings = true;
                                out.writePacket(161);
                                out.writeByte(publicChatSetting);
                                out.writeByte(privateChatSetting);
                                out.writeByte(tradeChatSetting);
                            }
                        }
                        if (anInt880 == 4 && anInt957 < 100) {
                            long l2 = TextUtils.encodeBase37(aString1007);
                            method55((byte) -37, l2);
                        }
                        if (anInt880 == 5 && anInt957 > 0) {
                            long l3 = TextUtils.encodeBase37(aString1007);
                            method142(-197, l3);
                        }
                    }
                } else if (aBoolean980) {
                    if (j >= 48 && j <= 57 && aString1092.length() < 10) {
                        aString1092 += (char) j;
                        redrawChatback = true;
                    }
                    if (j == 8 && aString1092.length() > 0) {
                        aString1092 = aString1092.substring(0, aString1092.length() - 1);
                        redrawChatback = true;
                    }
                    if (j == 13 || j == 10) {
                        if (aString1092.length() > 0) {
                            int i1 = 0;
                            try {
                                i1 = Integer.parseInt(aString1092);
                            } catch (Exception _ex) {
                            }
                            out.writePacket(180);
                            out.writeInt(i1);
                        }
                        aBoolean980 = false;
                        redrawChatback = true;
                    }
                } else if (anInt1253 == -1) {
                    if (j >= 32 && j <= 122 && aString1141.length() < 80) {
                        aString1141 += (char) j;
                        redrawChatback = true;
                    }
                    if (j == 8 && aString1141.length() > 0) {
                        aString1141 = aString1141.substring(0, aString1141.length() - 1);
                        redrawChatback = true;
                    }
                    if ((j == 13 || j == 10) && aString1141.length() > 0) {
                        if (rights == 2) {
                            if (aString1141.equals("::clientdrop")) {
                                method99((byte) 7);
                            }
                            if (aString1141.equals("::lag")) {
                                method29((byte) -11);
                            }
                            if (aString1141.equals("::prefetchmusic")) {
                                for (int j1 = 0; j1 < ondemand.method385(2, (byte) 7); j1++) {
                                    ondemand.method395(7, 2, (byte) 1, j1);
                                }
                            }
                        }
                        if (aString1141.startsWith("::")) {
                            out.writePacket(34);
                            out.writeByte(aString1141.length() - 1);
                            out.writeString(aString1141.substring(2));
                        } else {
                            String s = aString1141.toLowerCase();
                            int k1 = 0;
                            if (s.startsWith("yellow:")) {
                                k1 = 0;
                                aString1141 = aString1141.substring(7);
                            } else if (s.startsWith("red:")) {
                                k1 = 1;
                                aString1141 = aString1141.substring(4);
                            } else if (s.startsWith("green:")) {
                                k1 = 2;
                                aString1141 = aString1141.substring(6);
                            } else if (s.startsWith("cyan:")) {
                                k1 = 3;
                                aString1141 = aString1141.substring(5);
                            } else if (s.startsWith("purple:")) {
                                k1 = 4;
                                aString1141 = aString1141.substring(7);
                            } else if (s.startsWith("white:")) {
                                k1 = 5;
                                aString1141 = aString1141.substring(6);
                            } else if (s.startsWith("flash1:")) {
                                k1 = 6;
                                aString1141 = aString1141.substring(7);
                            } else if (s.startsWith("flash2:")) {
                                k1 = 7;
                                aString1141 = aString1141.substring(7);
                            } else if (s.startsWith("flash3:")) {
                                k1 = 8;
                                aString1141 = aString1141.substring(7);
                            } else if (s.startsWith("glow1:")) {
                                k1 = 9;
                                aString1141 = aString1141.substring(6);
                            } else if (s.startsWith("glow2:")) {
                                k1 = 10;
                                aString1141 = aString1141.substring(6);
                            } else if (s.startsWith("glow3:")) {
                                k1 = 11;
                                aString1141 = aString1141.substring(6);
                            }
                            s = aString1141.toLowerCase();
                            int i2 = 0;
                            if (s.startsWith("wave:")) {
                                i2 = 1;
                                aString1141 = aString1141.substring(5);
                            } else if (s.startsWith("wave2:")) {
                                i2 = 2;
                                aString1141 = aString1141.substring(6);
                            } else if (s.startsWith("shake:")) {
                                i2 = 3;
                                aString1141 = aString1141.substring(6);
                            } else if (s.startsWith("scroll:")) {
                                i2 = 4;
                                aString1141 = aString1141.substring(7);
                            } else if (s.startsWith("slide:")) {
                                i2 = 5;
                                aString1141 = aString1141.substring(6);
                            }
                            out.writePacket(156);
                            out.writeByte(0);
                            int j2 = out.position;
                            out.writeByte(k1);
                            out.writeByte(i2);
                            ChatCompression.method557(aString1141, out, 991);
                            out.method481(out.position - j2, anInt1152);
                            aString1141 = ChatCompression.method558(aString1141, anInt1242);
                            aString1141 = ChatCensor.method352(aString1141, anInt1242);
                            Game.self.aString1627 = aString1141;
                            Game.self.anInt1629 = k1;
                            Game.self.anInt1630 = i2;
                            Game.self.anInt1628 = 150;
                            if (rights == 2) {
                                renderText(2, (byte) -115,
                                        Game.self.aString1627, "@cr2@"
                                                + Game.self.aString1672);
                            } else if (rights == 1) {
                                renderText(2, (byte) -115,
                                        Game.self.aString1627, "@cr1@"
                                                + Game.self.aString1672);
                            } else {
                                renderText(2, (byte) -115,
                                        Game.self.aString1627,
                                        Game.self.aString1672);
                            }
                            if (publicChatSetting == 2) {
                                publicChatSetting = 3;
                                redrawPrivacySettings = true;
                                out.writePacket(161);
                                out.writeByte(publicChatSetting);
                                out.writeByte(privateChatSetting);
                                out.writeByte(tradeChatSetting);
                            }
                        }
                        aString1141 = "";
                        redrawChatback = true;
                    }
                }
            } while (true);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("93263, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void method9(byte byte0) {
        try {
            if (aBoolean1236 || aBoolean1055 || aBoolean820) {
                method53(9);
                return;
            }
            Game.anInt1175++;
            if (!ingame) {
                drawLoginScreen(false);
            } else {
                method123(false);
            }
            anInt1066 = 0;
            if (byte0 == 1) {
                byte0 = 0;
                return;
            } else {
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("25980, " + byte0 + ", " + runtimeexception);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void useMentuOption(int option) {
        try {
            if (option < 0) {
                return;
            }
            if (aBoolean980) {
                aBoolean980 = false;
                redrawChatback = true;
            }
            int action = menuAction[option];
            int a = menuParamA[option];
            int b = menuParamB[option];
            int c = menuParamC[option];
            if (action >= 2000) {
                action -= 2000;
            }
            if (action == 721) {
                Game.anInt1238 += b;
                if (Game.anInt1238 >= 139) {
                    out.writePacket(195);
                    out.writeInt(0);
                }
                method78(c, 45, false, b, a);
            }
            if (action == 718) {
                if (!menuVisible) {
                    scene.method316(super.mousePressY - 4, super.mousePressX - 4);
                } else {
                    scene.method316(b - 4, a - 4);
                }
            }
            if (action == 131) {
                PlayerEntity player = players[c];
                if (player != null) {
                    tryMove(1, Game.self.pathTileX[0], 0,
                            player.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            player.pathTileX[0],
                            Game.self.pathTileZ[0]);
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 2;
                    crossCycle = 0;
                    out.writePacket(138);
                    out.writeShort(c);
                    out.writeShort(anInt995);
                }
            }
            if (action == 507 || action == 957) {
                String s = aStringArray897[option];
                int l1 = s.indexOf("@whi@");
                if (l1 != -1) {
                    s = s.substring(l1 + 5).trim();
                    String s8 = TextUtils.method554(TextUtils.method551(TextUtils.encodeBase37(s), true), true);
                    boolean flag4 = false;
                    for (int k3 = 0; k3 < anInt1226; k3++) {
                        PlayerEntity class44_sub3_sub4_sub6_sub1_3 = players[anIntArray1227[k3]];
                        if (class44_sub3_sub4_sub6_sub1_3 == null || class44_sub3_sub4_sub6_sub1_3.aString1672 == null
                                || !class44_sub3_sub4_sub6_sub1_3.aString1672.equalsIgnoreCase(s8)) {
                            continue;
                        }
                        tryMove(1, Game.self.pathTileX[0], 0,
                                class44_sub3_sub4_sub6_sub1_3.pathTileZ[0], 0, 0, false, 2, 124, 1,
                                class44_sub3_sub4_sub6_sub1_3.pathTileX[0],
                                Game.self.pathTileZ[0]);
                        if (action == 507) {
                            Game.anInt821 += c;
                            if (Game.anInt821 >= 66) {
                                out.writePacket(46);
                                out.writeByte(154);
                            }
                            out.writePacket(189);
                        }
                        if (action == 957) {
                            Game.anInt870++;
                            if (Game.anInt870 >= 52) {
                                out.writePacket(49);
                                out.writeByte(131);
                            }
                            out.writePacket(220);
                        }
                        out.writeShort(anIntArray1227[k3]);
                        flag4 = true;
                        break;
                    }
                    if (!flag4) {
                        renderText(0, (byte) -115, "Unable to find " + s8, "");
                    }
                }
            }
            if (action == 625) {
                method78(c, 10, false, b, a);
            }
            if (action == 1152) {
                ObjType class14 = ObjType.method220(c);
                String s4;
                if (class14.aByteArray332 != null) {
                    s4 = new String(class14.aByteArray332);
                } else {
                    s4 = "It's a " + class14.aString331 + ".";
                }
                renderText(0, (byte) -115, s4, "");
            }
            if (action == 737) {
                method28(3);
            }
            if (action == 902) {
                String s1 = aStringArray897[option];
                int i2 = s1.indexOf("@whi@");
                if (i2 != -1) {
                    long l3 = TextUtils.encodeBase37(s1.substring(i2 + 5).trim());
                    int i4 = -1;
                    for (int j4 = 0; j4 < anInt1104; j4++) {
                        if (aLongArray979[j4] != l3) {
                            continue;
                        }
                        i4 = j4;
                        break;
                    }
                    if (i4 != -1 && anIntArray894[i4] > 0) {
                        redrawChatback = true;
                        aBoolean980 = false;
                        aBoolean1222 = true;
                        aString1007 = "";
                        anInt880 = 3;
                        aLong967 = aLongArray979[i4];
                        aString1102 = "Enter message to send to " + aStringArray1044[i4];
                    }
                }
            }
            if (action == 605 || action == 47 || action == 513 || action == 884) {
                String s2 = aStringArray897[option];
                int j2 = s2.indexOf("@whi@");
                if (j2 != -1) {
                    long l4 = TextUtils.encodeBase37(s2.substring(j2 + 5).trim());
                    if (action == 605) {
                        method95(0, l4);
                    }
                    if (action == 47) {
                        method55((byte) -37, l4);
                    }
                    if (action == 513) {
                        method44(l4, 37517);
                    }
                    if (action == 884) {
                        method142(-197, l4);
                    }
                }
            }
            if (action == 563) {
                out.writePacket(112);
                out.writeShort(c);
                out.writeShort(a);
                out.writeShort(b);
                out.writeShort(anInt995);
                anInt1148 = 0;
                anInt1149 = b;
                anInt1150 = a;
                anInt1151 = 2;
                if (Component.instances[b].anInt106 == anInt1199) {
                    anInt1151 = 1;
                }
                if (Component.instances[b].anInt106 == anInt1253) {
                    anInt1151 = 3;
                }
            }
            if (action == 274) {
                Component class5 = Component.instances[b];
                anInt994 = 1;
                anInt995 = b;
                anInt996 = class5.anInt160;
                anInt952 = 0;
                redrawInvBack = true;
                String s5 = class5.aString158;
                if (s5.indexOf(" ") != -1) {
                    s5 = s5.substring(0, s5.indexOf(" "));
                }
                String s9 = class5.aString158;
                if (s9.indexOf(" ") != -1) {
                    s9 = s9.substring(s9.indexOf(" ") + 1);
                }
                aString997 = s5 + " " + class5.aString159 + " " + s9;
                if (anInt996 == 16) {
                    redrawInvBack = true;
                    currentTab = 3;
                    redrawSideicons = true;
                }
                return;
            }
            if (action == 225) {
                out.writePacket(86);
                out.writeShort(b);
                Component class5_1 = Component.instances[b];
                if (class5_1.anIntArrayArray115 != null && class5_1.anIntArrayArray115[0][0] == 5) {
                    int k2 = class5_1.anIntArrayArray115[0][1];
                    if (anIntArray1214[k2] != class5_1.anIntArray117[0]) {
                        anIntArray1214[k2] = class5_1.anIntArray117[0];
                        method147(true, k2);
                        redrawInvBack = true;
                    }
                }
            }
            if (action == 524) {
                String s3 = aStringArray897[option];
                int l2 = s3.indexOf("@whi@");
                if (l2 != -1) {
                    if (anInt1199 == -1) {
                        method28(3);
                        aString939 = s3.substring(l2 + 5).trim();
                        aBoolean987 = false;
                        for (int j3 = 0; j3 < Component.instances.length; j3++) {
                            if (Component.instances[j3] == null || Component.instances[j3].anInt109 != 600) {
                                continue;
                            }
                            anInt1217 = anInt1199 = Component.instances[j3].anInt106;
                            break;
                        }
                    } else {
                        renderText(0, (byte) -115,
                                "Please close the interface you have open before using 'report abuse'", "");
                    }
                }
            }
            if (action == 242 || action == 209 || action == 309 || action == 852 || action == 793) {
                NPCEntity npc = npcs[c];
                if (npc != null) {
                    tryMove(1, Game.self.pathTileX[0], 0, npc.pathTileZ[0], 0, 0, false, 2, 124, 1, npc.pathTileX[0], Game.self.pathTileZ[0]);
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 2;
                    crossCycle = 0;
                    if (action == 242) {
                        out.writePacket(252);
                    }
                    if (action == 209) {
                        out.writePacket(21);
                    }
                    if (action == 793) {
                        out.writePacket(247);
                    }
                    if (action == 309) {
                        out.writePacket(178);
                    }
                    if (action == 852) {
                        out.writePacket(30);
                    }
                    out.writeShort(c);
                }
            }
            if (action == 231) {
                Component class5_2 = Component.instances[b];
                boolean flag3 = true;
                if (class5_2.anInt109 > 0) {
                    flag3 = method19((byte) -16, class5_2);
                }
                if (flag3) {
                    out.writePacket(86);
                    out.writeShort(b);
                }
            }
            if (action == 1714) {
                NPCEntity class44_sub3_sub4_sub6_sub2_1 = npcs[c];
                if (class44_sub3_sub4_sub6_sub2_1 != null) {
                    String s6;
                    if (class44_sub3_sub4_sub6_sub2_1.aClass12_1700.aByteArray283 != null) {
                        s6 = new String(class44_sub3_sub4_sub6_sub2_1.aClass12_1700.aByteArray283);
                    } else {
                        s6 = "It's a " + class44_sub3_sub4_sub6_sub2_1.aClass12_1700.aString282 + ".";
                    }
                    renderText(0, (byte) -115, s6, "");
                }
            }
            if (action == 398) {
                out.writePacket(200);
                out.writeShort(c);
                out.writeShort(a);
                out.writeShort(b);
                out.writeShort(anInt955);
                out.writeShort(anInt953);
                out.writeShort(anInt954);
                anInt1148 = 0;
                anInt1149 = b;
                anInt1150 = a;
                anInt1151 = 2;
                if (Component.instances[b].anInt106 == anInt1199) {
                    anInt1151 = 1;
                }
                if (Component.instances[b].anInt106 == anInt1253) {
                    anInt1151 = 3;
                }
            }
            if (action == 102) {
                anInt952 = 1;
                anInt953 = a;
                anInt954 = b;
                anInt955 = c;
                aString956 = ObjType.method220(c).aString331;
                anInt994 = 0;
                redrawInvBack = true;
                return;
            }
            if (action == 997 && !aBoolean935) {
                out.writePacket(PacketConstants.outgoing.CLICK_TO_CONTINUE);
                out.writeShort(b);
                aBoolean935 = true;
            }
            if (action == 899 && method78(c, 218, false, b, a)) {
                out.writeShort(anInt995);
            }
            if (action == 694 || action == 962 || action == 795 || action == 681 || action == 100) {
                if (action == 100) {
                    out.writePacket(79);
                }
                if (action == 681) {
                    Game.anInt1100++;
                    if (Game.anInt1100 >= 116) {
                        out.writePacket(88);
                        out.method475(0xc6a439);
                    }
                    out.writePacket(191);
                }
                if (action == 694) {
                    out.writePacket(76);
                }
                if (action == 795) {
                    out.writePacket(40);
                }
                if (action == 962) {
                    out.writePacket(177);
                }
                out.writeShort(c);
                out.writeShort(a);
                out.writeShort(b);
                anInt1148 = 0;
                anInt1149 = b;
                anInt1150 = a;
                anInt1151 = 2;
                if (Component.instances[b].anInt106 == anInt1199) {
                    anInt1151 = 1;
                }
                if (Component.instances[b].anInt106 == anInt1253) {
                    anInt1151 = 3;
                }
            }
            if (action == 275) {
                PlayerEntity class44_sub3_sub4_sub6_sub1_1 = players[c];
                if (class44_sub3_sub4_sub6_sub1_1 != null) {
                    tryMove(1, Game.self.pathTileX[0], 0,
                            class44_sub3_sub4_sub6_sub1_1.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            class44_sub3_sub4_sub6_sub1_1.pathTileX[0],
                            Game.self.pathTileZ[0]);
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 2;
                    crossCycle = 0;
                    out.writePacket(16);
                    out.writeShort(c);
                    out.writeShort(anInt955);
                    out.writeShort(anInt953);
                    out.writeShort(anInt954);
                }
            }
            if (action == 240) {
                NPCEntity class44_sub3_sub4_sub6_sub2_2 = npcs[c];
                if (class44_sub3_sub4_sub6_sub2_2 != null) {
                    tryMove(1, Game.self.pathTileX[0], 0,
                            class44_sub3_sub4_sub6_sub2_2.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            class44_sub3_sub4_sub6_sub2_2.pathTileX[0],
                            Game.self.pathTileZ[0]);
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 2;
                    crossCycle = 0;
                    out.writePacket(108);
                    out.writeShort(c);
                    out.writeShort(anInt995);
                }
            }
            if (action == 743) {
                Game.anInt1180++;
                if (Game.anInt1180 >= 124) {
                    out.writePacket(81);
                    out.writeShort(37954);
                }
                method78(c, 196, false, b, a);
            }
            if (action == 111) {
                boolean flag = tryMove(0, Game.self.pathTileX[0], 0,
                        b, 0, 0, false, 2, 124, 0, a,
                        Game.self.pathTileZ[0]);
                if (!flag) {
                    flag = tryMove(1, Game.self.pathTileX[0], 0, b,
                            0, 0, false, 2, 124, 1, a,
                            Game.self.pathTileZ[0]);
                }
                crossX = super.mousePressX;
                crossY = super.mousePressY;
                crossMode = 2;
                crossCycle = 0;
                out.writePacket(55);
                out.writeShort(a + sceneBaseTileX);
                out.writeShort(b + sceneBaseTileZ);
                out.writeShort(c);
                out.writeShort(anInt955);
                out.writeShort(anInt953);
                out.writeShort(anInt954);
            }
            if (action == 810 && method78(c, 184, false, b, a)) {
                out.writeShort(anInt955);
                out.writeShort(anInt953);
                out.writeShort(anInt954);
            }
            if (action == 829) {
                NPCEntity class44_sub3_sub4_sub6_sub2_3 = npcs[c];
                if (class44_sub3_sub4_sub6_sub2_3 != null) {
                    tryMove(1, Game.self.pathTileX[0], 0,
                            class44_sub3_sub4_sub6_sub2_3.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            class44_sub3_sub4_sub6_sub2_3.pathTileX[0],
                            Game.self.pathTileZ[0]);
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 2;
                    crossCycle = 0;
                    out.writePacket(160);
                    out.writeShort(c);
                    out.writeShort(anInt955);
                    out.writeShort(anInt953);
                    out.writeShort(anInt954);
                }
            }
            if (action == 1381) {
                int k1 = c >> 14 & 0x7fff;
                LocType class8 = LocType.method199(k1);
                String s10;
                if (class8.aByteArray219 != null) {
                    s10 = new String(class8.aByteArray219);
                } else {
                    s10 = "It's a " + class8.aString218 + ".";
                }
                renderText(0, (byte) -115, s10, "");
            }
            if (action == 1071) {
                method78(c, 126, false, b, a);
            }
            if (action == 139 || action == 778 || action == 617 || action == 224 || action == 662) {
                boolean flag1 = tryMove(0, Game.self.pathTileX[0], 0,
                        b, 0, 0, false, 2, 124, 0, a,
                        Game.self.pathTileZ[0]);
                if (!flag1) {
                    flag1 = tryMove(1, Game.self.pathTileX[0], 0, b,
                            0, 0, false, 2, 124, 1, a,
                            Game.self.pathTileZ[0]);
                }
                crossX = super.mousePressX;
                crossY = super.mousePressY;
                crossMode = 2;
                crossCycle = 0;
                if (action == 662) {
                    Game.anInt986 += sceneBaseTileZ;
                    if (Game.anInt986 >= 118) {
                        out.writePacket(122);
                        out.writeInt(0);
                    }
                    out.writePacket(22);
                }
                if (action == 139) {
                    if ((a & 3) == 0) {
                        Game.anInt1114++;
                    }
                    if (Game.anInt1114 >= 123) {
                        out.writePacket(133);
                        out.writeInt(0);
                    }
                    out.writePacket(97);
                }
                if (action == 778) {
                    out.writePacket(4);
                }
                if (action == 617) {
                    out.writePacket(110);
                }
                if (action == 224) {
                    Game.anInt1046 += b;
                    if (Game.anInt1046 >= 75) {
                        out.writePacket(168);
                        out.writeByte(19);
                    }
                    out.writePacket(147);
                }
                out.writeShort(a + sceneBaseTileX);
                out.writeShort(b + sceneBaseTileZ);
                out.writeShort(c);
            }
            if (action == 435) {
                out.writePacket(86);
                out.writeShort(b);
                Component class5_3 = Component.instances[b];
                if (class5_3.anIntArrayArray115 != null && class5_3.anIntArrayArray115[0][0] == 5) {
                    int i3 = class5_3.anIntArrayArray115[0][1];
                    anIntArray1214[i3] = 1 - anIntArray1214[i3];
                    method147(true, i3);
                    redrawInvBack = true;
                }
            }
            if (action == 357) {
                method78(c, 53, false, b, a);
            }
            if (action == 370) {
                boolean flag2 = tryMove(0, Game.self.pathTileX[0], 0,
                        b, 0, 0, false, 2, 124, 0, a,
                        Game.self.pathTileZ[0]);
                if (!flag2) {
                    flag2 = tryMove(1, Game.self.pathTileX[0], 0, b,
                            0, 0, false, 2, 124, 1, a,
                            Game.self.pathTileZ[0]);
                }
                crossX = super.mousePressX;
                crossY = super.mousePressY;
                crossMode = 2;
                crossCycle = 0;
                out.writePacket(241);
                out.writeShort(a + sceneBaseTileX);
                out.writeShort(b + sceneBaseTileZ);
                out.writeShort(c);
                out.writeShort(anInt995);
            }
            if (action == 639 || action == 499 || action == 27 || action == 387 || action == 185) {
                PlayerEntity class44_sub3_sub4_sub6_sub1_2 = players[c];
                if (class44_sub3_sub4_sub6_sub1_2 != null) {
                    tryMove(1, Game.self.pathTileX[0], 0,
                            class44_sub3_sub4_sub6_sub1_2.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            class44_sub3_sub4_sub6_sub1_2.pathTileX[0],
                            Game.self.pathTileZ[0]);
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 2;
                    crossCycle = 0;
                    if (action == 185) {
                        out.writePacket(69);
                    }
                    if (action == 387) {
                        Game.anInt821 += c;
                        if (Game.anInt821 >= 66) {
                            out.writePacket(46);
                            out.writeByte(154);
                        }
                        out.writePacket(189);
                    }
                    if (action == 499) {
                        out.writePacket(51);
                    }
                    if (action == 639) {
                        Game.anInt870++;
                        if (Game.anInt870 >= 52) {
                            out.writePacket(49);
                            out.writeByte(131);
                        }
                        out.writePacket(220);
                    }
                    if (action == 27) {
                        out.writePacket(13);
                    }
                    out.writeShort(c);
                }
            }
            if (action == 582 || action == 113 || action == 555 || action == 331 || action == 354) {
                if (action == 555) {
                    out.writePacket(124);
                }
                if (action == 113) {
                    out.writePacket(111);
                }
                if (action == 354) {
                    out.writePacket(227);
                }
                if (action == 582) {
                    if ((c & 3) == 0) {
                        Game.anInt1274++;
                    }
                    if (Game.anInt1274 >= 133) {
                        out.writePacket(73);
                        out.writeShort(6118);
                    }
                    out.writePacket(44);
                }
                if (action == 331) {
                    out.writePacket(248);
                }
                out.writeShort(c);
                out.writeShort(a);
                out.writeShort(b);
                anInt1148 = 0;
                anInt1149 = b;
                anInt1150 = a;
                anInt1151 = 2;
                if (Component.instances[b].anInt106 == anInt1199) {
                    anInt1151 = 1;
                }
                if (Component.instances[b].anInt106 == anInt1253) {
                    anInt1151 = 3;
                }
            }
            if (action == 1328) {
                ObjType class14_1 = ObjType.method220(c);
                Component class5_4 = Component.instances[b];
                String s7;
                if (class5_4 != null && class5_4.containerItemAmount[a] >= 0x186a0) {
                    s7 = class5_4.containerItemAmount[a] + " x " + class14_1.aString331;
                } else if (class14_1.aByteArray332 != null) {
                    s7 = new String(class14_1.aByteArray332);
                } else {
                    s7 = "It's a " + class14_1.aString331 + ".";
                }
                renderText(0, (byte) -115, s7, "");
            }
            anInt952 = 0;
            anInt994 = 0;
            redrawInvBack = true;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27672, " + option + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method135(boolean flag) {
        try {
            if (anInt952 == 0 && anInt994 == 0) {
                aStringArray897[menuSize] = "Walk here";
                menuAction[menuSize] = 718;
                menuParamA[menuSize] = super.anInt21;
                menuParamB[menuSize] = super.anInt22;
                menuSize++;
            }
            int i = -1;
            ingame &= flag;
            for (int j = 0; j < Model.anInt1596; j++) {
                int k = Model.anIntArray1597[j];
                int l = k & 0x7f;
                int i1 = k >> 7 & 0x7f;
                int j1 = k >> 29 & 3;
                int k1 = k >> 14 & 0x7fff;
                if (k == i) {
                    continue;
                }
                i = k;
                if (j1 == 2 && scene.method308(plane, l, i1, k) >= 0) {
                    LocType class8 = LocType.method199(k1);
                    if (class8.anIntArray250 != null) {
                        VarBit class35 = VarBit.aClass35Array590[class8.anInt249];
                        int k2 = class35.anInt592;
                        int j3 = class35.anInt593;
                        int l3 = class35.anInt594;
                        int i4 = Game.BITMASK[l3 - j3];
                        int j4 = anIntArray1214[k2] >> j3 & i4;
                        if (j4 < 0 || j4 >= class8.anIntArray250.length || class8.anIntArray250[j4] == -1) {
                            continue;
                        }
                        class8 = LocType.method199(class8.anIntArray250[j4]);
                    }
                    if (anInt952 == 1) {
                        aStringArray897[menuSize] = "Use " + aString956 + " with @cya@" + class8.aString218;
                        menuAction[menuSize] = 810;
                        menuParamC[menuSize] = k;
                        menuParamA[menuSize] = l;
                        menuParamB[menuSize] = i1;
                        menuSize++;
                    } else if (anInt994 == 1) {
                        if ((anInt996 & 4) == 4) {
                            aStringArray897[menuSize] = aString997 + " @cya@" + class8.aString218;
                            menuAction[menuSize] = 899;
                            menuParamC[menuSize] = k;
                            menuParamA[menuSize] = l;
                            menuParamB[menuSize] = i1;
                            menuSize++;
                        }
                    } else {
                        if (class8.aStringArray234 != null) {
                            for (int l1 = 4; l1 >= 0; l1--) {
                                if (class8.aStringArray234[l1] != null) {
                                    aStringArray897[menuSize] = class8.aStringArray234[l1] + " @cya@"
                                            + class8.aString218;
                                    if (l1 == 0) {
                                        menuAction[menuSize] = 625;
                                    }
                                    if (l1 == 1) {
                                        menuAction[menuSize] = 721;
                                    }
                                    if (l1 == 2) {
                                        menuAction[menuSize] = 743;
                                    }
                                    if (l1 == 3) {
                                        menuAction[menuSize] = 357;
                                    }
                                    if (l1 == 4) {
                                        menuAction[menuSize] = 1071;
                                    }
                                    menuParamC[menuSize] = k;
                                    menuParamA[menuSize] = l;
                                    menuParamB[menuSize] = i1;
                                    menuSize++;
                                }
                            }
                        }
                        aStringArray897[menuSize] = "Examine @cya@" + class8.aString218;
                        menuAction[menuSize] = 1381;
                        menuParamC[menuSize] = class8.anInt215 << 14;
                        menuParamA[menuSize] = l;
                        menuParamB[menuSize] = i1;
                        menuSize++;
                    }
                }
                if (j1 == 1) {
                    NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[k1];
                    if (class44_sub3_sub4_sub6_sub2.aClass12_1700.aByte284 == 1
                            && (class44_sub3_sub4_sub6_sub2.x & 0x7f) == 64
                            && (class44_sub3_sub4_sub6_sub2.z & 0x7f) == 64) {
                        for (int i2 = 0; i2 < anInt1009; i2++) {
                            NPCEntity class44_sub3_sub4_sub6_sub2_1 = npcs[anIntArray1010[i2]];
                            if (class44_sub3_sub4_sub6_sub2_1 != null
                                    && class44_sub3_sub4_sub6_sub2_1 != class44_sub3_sub4_sub6_sub2
                                    && class44_sub3_sub4_sub6_sub2_1.aClass12_1700.aByte284 == 1
                                    && class44_sub3_sub4_sub6_sub2_1.x == class44_sub3_sub4_sub6_sub2.x
                                    && class44_sub3_sub4_sub6_sub2_1.z == class44_sub3_sub4_sub6_sub2.z) {
                                method58(anIntArray1010[i2], class44_sub3_sub4_sub6_sub2_1.aClass12_1700, l, 559, i1);
                            }
                        }
                        for (int l2 = 0; l2 < anInt1226; l2++) {
                            PlayerEntity class44_sub3_sub4_sub6_sub1_1 = players[anIntArray1227[l2]];
                            if (class44_sub3_sub4_sub6_sub1_1 != null
                                    && class44_sub3_sub4_sub6_sub1_1.x == class44_sub3_sub4_sub6_sub2.x
                                    && class44_sub3_sub4_sub6_sub1_1.z == class44_sub3_sub4_sub6_sub2.z) {
                                method112(i1, 705, class44_sub3_sub4_sub6_sub1_1, l, anIntArray1227[l2]);
                            }
                        }
                    }
                    method58(k1, class44_sub3_sub4_sub6_sub2.aClass12_1700, l, 559, i1);
                }
                if (j1 == 0) {
                    PlayerEntity class44_sub3_sub4_sub6_sub1 = players[k1];
                    if ((class44_sub3_sub4_sub6_sub1.x & 0x7f) == 64
                            && (class44_sub3_sub4_sub6_sub1.z & 0x7f) == 64) {
                        for (int j2 = 0; j2 < anInt1009; j2++) {
                            NPCEntity class44_sub3_sub4_sub6_sub2_2 = npcs[anIntArray1010[j2]];
                            if (class44_sub3_sub4_sub6_sub2_2 != null
                                    && class44_sub3_sub4_sub6_sub2_2.aClass12_1700.aByte284 == 1
                                    && class44_sub3_sub4_sub6_sub2_2.x == class44_sub3_sub4_sub6_sub1.x
                                    && class44_sub3_sub4_sub6_sub2_2.z == class44_sub3_sub4_sub6_sub1.z) {
                                method58(anIntArray1010[j2], class44_sub3_sub4_sub6_sub2_2.aClass12_1700, l, 559, i1);
                            }
                        }
                        for (int i3 = 0; i3 < anInt1226; i3++) {
                            PlayerEntity class44_sub3_sub4_sub6_sub1_2 = players[anIntArray1227[i3]];
                            if (class44_sub3_sub4_sub6_sub1_2 != null
                                    && class44_sub3_sub4_sub6_sub1_2 != class44_sub3_sub4_sub6_sub1
                                    && class44_sub3_sub4_sub6_sub1_2.x == class44_sub3_sub4_sub6_sub1.x
                                    && class44_sub3_sub4_sub6_sub1_2.z == class44_sub3_sub4_sub6_sub1.z) {
                                method112(i1, 705, class44_sub3_sub4_sub6_sub1_2, l, anIntArray1227[i3]);
                            }
                        }
                    }
                    method112(i1, 705, class44_sub3_sub4_sub6_sub1, l, k1);
                }
                if (j1 == 3) {
                    LinkedList class28 = planeObjStacks[plane][l][i1];
                    if (class28 != null) {
                        for (ObjStackEntity class44_sub3_sub4_sub2 = (ObjStackEntity) class28.method260(0); class44_sub3_sub4_sub2 != null; class44_sub3_sub4_sub2 = (ObjStackEntity) class28
                                .method262(-20683)) {
                            ObjType class14 = ObjType.method220(class44_sub3_sub4_sub2.anInt1495);
                            if (anInt952 == 1) {
                                aStringArray897[menuSize] = "Use " + aString956 + " with @lre@" + class14.aString331;
                                menuAction[menuSize] = 111;
                                menuParamC[menuSize] = class44_sub3_sub4_sub2.anInt1495;
                                menuParamA[menuSize] = l;
                                menuParamB[menuSize] = i1;
                                menuSize++;
                            } else if (anInt994 == 1) {
                                if ((anInt996 & 1) == 1) {
                                    aStringArray897[menuSize] = aString997 + " @lre@" + class14.aString331;
                                    menuAction[menuSize] = 370;
                                    menuParamC[menuSize] = class44_sub3_sub4_sub2.anInt1495;
                                    menuParamA[menuSize] = l;
                                    menuParamB[menuSize] = i1;
                                    menuSize++;
                                }
                            } else {
                                for (int k3 = 4; k3 >= 0; k3--) {
                                    if (class14.aStringArray345 != null && class14.aStringArray345[k3] != null) {
                                        aStringArray897[menuSize] = class14.aStringArray345[k3] + " @lre@"
                                                + class14.aString331;
                                        if (k3 == 0) {
                                            menuAction[menuSize] = 139;
                                        }
                                        if (k3 == 1) {
                                            menuAction[menuSize] = 778;
                                        }
                                        if (k3 == 2) {
                                            menuAction[menuSize] = 617;
                                        }
                                        if (k3 == 3) {
                                            menuAction[menuSize] = 224;
                                        }
                                        if (k3 == 4) {
                                            menuAction[menuSize] = 662;
                                        }
                                        menuParamC[menuSize] = class44_sub3_sub4_sub2.anInt1495;
                                        menuParamA[menuSize] = l;
                                        menuParamB[menuSize] = i1;
                                        menuSize++;
                                    } else if (k3 == 2) {
                                        aStringArray897[menuSize] = "Take @lre@" + class14.aString331;
                                        menuAction[menuSize] = 617;
                                        menuParamC[menuSize] = class44_sub3_sub4_sub2.anInt1495;
                                        menuParamA[menuSize] = l;
                                        menuParamB[menuSize] = i1;
                                        menuSize++;
                                    }
                                }
                                aStringArray897[menuSize] = "Examine @lre@" + class14.aString331;
                                menuAction[menuSize] = 1152;
                                menuParamC[menuSize] = class44_sub3_sub4_sub2.anInt1495;
                                menuParamA[menuSize] = l;
                                menuParamB[menuSize] = i1;
                                menuSize++;
                            }
                        }
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("60112, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method136(int i) {
        try {
            if (i <= 0) {
                packetType = -1;
            }
            if (hintIconType != 2) {
                return;
            }
            method75((anInt1248 - sceneBaseTileX << 7) + anInt1251, anInt1250 * 2, (byte) -79, (anInt1249 - sceneBaseTileZ << 7)
                    + anInt1252);
            if (anInt1064 > -1 && Game.loopCycle % 20 < 10) {
                aClass44_Sub3_Sub1_Sub2Array1183[2].method440(anInt1065 - 28, aByte1213, anInt1064 - 12);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("57596, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void setCameraPosition(int i, int horizontal, int y, int z, int x, int vertical) {
        try {
            int verticalDifference = 2048 - vertical & 0x7ff;
            int horizontalDifference = 2048 - horizontal & 0x7ff;
            int offsetX = 0;
            int offsetY = 0;
            int offsetZ = i;
            if (verticalDifference != 0) {
                int sine = Model.SINE[verticalDifference];
                int cos = Model.COSINE[verticalDifference];
                int tmp = offsetY * cos - offsetZ * sine >> 16;
                offsetZ = offsetY * sine + offsetZ * cos >> 16;
                offsetY = tmp;
            }
            if (horizontalDifference != 0) {
                int sine = Model.SINE[horizontalDifference];
                int cos = Model.COSINE[horizontalDifference];
                int tmp = offsetZ * sine + offsetX * cos >> 16;
                offsetZ = offsetZ * cos - offsetX * sine >> 16;
                offsetX = tmp;
            }
            cameraPositionX = x - offsetX;
            cameraPositionY = y - offsetY;
            cameraPositionZ = z - offsetZ;
            cameraVerticalRotation = vertical;
            anInt879 = horizontal;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("24308, " + i + ", " + horizontal + ", " + y + ", " + z + ", " + x + ", " + vertical
                    + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method139(SceneLocTemporary class44_sub1, boolean flag) {
        try {
            int i = 0;
            int j = -1;
            int k = 0;
            int l = 0;
            if (flag) {
                for (int i1 = 1; i1 > 0; i1++) {
                }
            }
            if (class44_sub1.anInt1324 == 0) {
                i = scene.method304(class44_sub1.anInt1323, class44_sub1.sceneTileX, class44_sub1.sceneTileZ);
            }
            if (class44_sub1.anInt1324 == 1) {
                i = scene.method305(class44_sub1.sceneTileZ, 7, class44_sub1.anInt1323, class44_sub1.sceneTileX);
            }
            if (class44_sub1.anInt1324 == 2) {
                i = scene.method306(class44_sub1.anInt1323, class44_sub1.sceneTileX, class44_sub1.sceneTileZ);
            }
            if (class44_sub1.anInt1324 == 3) {
                i = scene.method307(class44_sub1.anInt1323, class44_sub1.sceneTileX, class44_sub1.sceneTileZ);
            }
            if (i != 0) {
                int j1 = scene.method308(class44_sub1.anInt1323, class44_sub1.sceneTileX,
                        class44_sub1.sceneTileZ, i);
                j = i >> 14 & 0x7fff;
                k = j1 & 0x1f;
                l = j1 >> 6;
            }
            class44_sub1.anInt1327 = j;
            class44_sub1.anInt1329 = k;
            class44_sub1.anInt1328 = l;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("51962, " + class44_sub1 + ", " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method140(int i, Buffer class44_sub3_sub2, int j) {
        try {
            j += i;
            for (int k = 0; k < anInt1228; k++) {
                int l = anIntArray1229[k];
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[l];
                int i1 = class44_sub3_sub2.readUnsignedByte();
                if ((i1 & 1) == 1) {
                    int j1 = class44_sub3_sub2.readUnsignedByte();
                    int j2 = class44_sub3_sub2.readUnsignedByte();
                    class44_sub3_sub4_sub6_sub2.method536(j2, Game.loopCycle, j1, false);
                    class44_sub3_sub4_sub6_sub2.anInt1634 = Game.loopCycle + 300;
                    class44_sub3_sub4_sub6_sub2.anInt1635 = class44_sub3_sub2.readUnsignedByte();
                    class44_sub3_sub4_sub6_sub2.anInt1636 = class44_sub3_sub2.readUnsignedByte();
                }
                if ((i1 & 2) == 2) {
                    int k1 = class44_sub3_sub2.readUnsignedShort();
                    if (k1 == 65535) {
                        k1 = -1;
                    }
                    if (k1 == class44_sub3_sub4_sub6_sub2.anInt1643) {
                        class44_sub3_sub4_sub6_sub2.anInt1647 = 0;
                    }
                    int k2 = class44_sub3_sub2.readUnsignedByte();
                    if (k1 == class44_sub3_sub4_sub6_sub2.anInt1643 && k1 != -1) {
                        int i3 = SeqType.cache[k1].anInt522;
                        if (i3 == 1) {
                            class44_sub3_sub4_sub6_sub2.anInt1644 = 0;
                            class44_sub3_sub4_sub6_sub2.anInt1645 = 0;
                            class44_sub3_sub4_sub6_sub2.anInt1646 = k2;
                            class44_sub3_sub4_sub6_sub2.anInt1647 = 0;
                        }
                        if (i3 == 2) {
                            class44_sub3_sub4_sub6_sub2.anInt1647 = 0;
                        }
                    } else if (k1 == -1
                            || class44_sub3_sub4_sub6_sub2.anInt1643 == -1
                            || SeqType.cache[k1].anInt516 >= SeqType.cache[class44_sub3_sub4_sub6_sub2.anInt1643].anInt516) {
                        class44_sub3_sub4_sub6_sub2.anInt1643 = k1;
                        class44_sub3_sub4_sub6_sub2.anInt1644 = 0;
                        class44_sub3_sub4_sub6_sub2.anInt1645 = 0;
                        class44_sub3_sub4_sub6_sub2.anInt1646 = k2;
                        class44_sub3_sub4_sub6_sub2.anInt1647 = 0;
                        class44_sub3_sub4_sub6_sub2.anInt1669 = class44_sub3_sub4_sub6_sub2.anInt1664;
                    }
                }
                if ((i1 & 4) == 4) {
                    class44_sub3_sub4_sub6_sub2.anInt1637 = class44_sub3_sub2.readUnsignedShort();
                    if (class44_sub3_sub4_sub6_sub2.anInt1637 == 65535) {
                        class44_sub3_sub4_sub6_sub2.anInt1637 = -1;
                    }
                }
                if ((i1 & 8) == 8) {
                    class44_sub3_sub4_sub6_sub2.aString1627 = class44_sub3_sub2.readString();
                    class44_sub3_sub4_sub6_sub2.anInt1628 = 100;
                }
                if ((i1 & 0x10) == 16) {
                    int l1 = class44_sub3_sub2.readUnsignedByte();
                    int l2 = class44_sub3_sub2.readUnsignedByte();
                    class44_sub3_sub4_sub6_sub2.method536(l2, Game.loopCycle, l1, false);
                    class44_sub3_sub4_sub6_sub2.anInt1634 = Game.loopCycle + 300;
                    class44_sub3_sub4_sub6_sub2.anInt1635 = class44_sub3_sub2.readUnsignedByte();
                    class44_sub3_sub4_sub6_sub2.anInt1636 = class44_sub3_sub2.readUnsignedByte();
                }
                if ((i1 & 0x20) == 32) {
                    class44_sub3_sub4_sub6_sub2.aClass12_1700 = NpcType
                            .method214(class44_sub3_sub2.readUnsignedShort());
                    class44_sub3_sub4_sub6_sub2.anInt1619 = class44_sub3_sub4_sub6_sub2.aClass12_1700.aByte284;
                    class44_sub3_sub4_sub6_sub2.anInt1663 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt306;
                    class44_sub3_sub4_sub6_sub2.anInt1622 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt288;
                    class44_sub3_sub4_sub6_sub2.anInt1623 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt289;
                    class44_sub3_sub4_sub6_sub2.anInt1624 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt290;
                    class44_sub3_sub4_sub6_sub2.anInt1625 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt291;
                    class44_sub3_sub4_sub6_sub2.anInt1620 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt287;
                }
                if ((i1 & 0x40) == 64) {
                    class44_sub3_sub4_sub6_sub2.anInt1648 = class44_sub3_sub2.readUnsignedShort();
                    int i2 = class44_sub3_sub2.readInt();
                    class44_sub3_sub4_sub6_sub2.anInt1652 = i2 >> 16;
                    class44_sub3_sub4_sub6_sub2.anInt1651 = Game.loopCycle + (i2 & 0xffff);
                    class44_sub3_sub4_sub6_sub2.anInt1649 = 0;
                    class44_sub3_sub4_sub6_sub2.anInt1650 = 0;
                    if (class44_sub3_sub4_sub6_sub2.anInt1651 > Game.loopCycle) {
                        class44_sub3_sub4_sub6_sub2.anInt1649 = -1;
                    }
                    if (class44_sub3_sub4_sub6_sub2.anInt1648 == 65535) {
                        class44_sub3_sub4_sub6_sub2.anInt1648 = -1;
                    }
                }
                if ((i1 & 0x80) == 128) {
                    class44_sub3_sub4_sub6_sub2.anInt1638 = class44_sub3_sub2.readUnsignedShort();
                    class44_sub3_sub4_sub6_sub2.anInt1639 = class44_sub3_sub2.readUnsignedShort();
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("44339, " + i + ", " + class44_sub3_sub2 + ", " + j + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method141(int i, Image24 class44_sub3_sub1_sub2, int j, int k) {
        try {
            int l = cameraHorizontal + anInt959 & 0x7ff;
            int i1 = i * i + k * k;
            if (i1 > 6400) {
                return;
            }
            int j1 = Model.SINE[l];
            int k1 = Model.COSINE[l];
            j1 = (j1 * 256) / (anInt1075 + 256);
            k1 = (k1 * 256) / (anInt1075 + 256);
            if (j <= 0) {
                for (int l1 = 1; l1 > 0; l1++) {
                }
            }
            int i2 = k * j1 + i * k1 >> 16;
            int j2 = k * k1 - i * j1 >> 16;
            if (i1 > 2500) {
                class44_sub3_sub1_sub2.method446(((94 + i2) - class44_sub3_sub1_sub2.cropWidth / 2) + 4,
                        aClass44_Sub3_Sub1_Sub3_1144, true, 83 - j2 - class44_sub3_sub1_sub2.cropHeight / 2 - 4);
                return;
            } else {
                class44_sub3_sub1_sub2.method440(83 - j2 - class44_sub3_sub1_sub2.cropHeight / 2 - 4, aByte1213,
                        ((94 + i2) - class44_sub3_sub1_sub2.cropWidth / 2) + 4);
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("87513, " + i + ", " + class44_sub3_sub1_sub2 + ", " + j + ", " + k + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method142(int i, long l) {
        try {
            if (i >= 0) {
                anInt1056 = -168;
            }
            if (l == 0L) {
                return;
            }
            for (int j = 0; j < anInt957; j++) {
                if (aLongArray1254[j] == l) {
                    anInt957--;
                    redrawInvBack = true;
                    for (int k = j; k < anInt957; k++) {
                        aLongArray1254[k] = aLongArray1254[k + 1];
                    }
                    out.writePacket(251);
                    out.method478(l, true);
                    return;
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("81778, " + i + ", " + l + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method143(int i) {
        try {
            if (i <= 0) {
                out.writeByte(126);
            }
            if (anInt848 != 0) {
                return;
            }
            if (super.clickType == 1) {
                int j = super.mousePressX - 25 - 550;
                int k = super.mousePressY - 5 - 4;
                if (j >= 0 && k >= 0 && j < 146 && k < 151) {
                    j -= 73;
                    k -= 75;
                    int l = cameraHorizontal + anInt959 & 0x7ff;
                    int i1 = Draw3D.anIntArray1427[l];
                    int j1 = Draw3D.anIntArray1428[l];
                    i1 = i1 * (anInt1075 + 256) >> 8;
                    j1 = j1 * (anInt1075 + 256) >> 8;
                    int k1 = k * i1 + j * j1 >> 11;
                    int l1 = k * j1 - j * i1 >> 11;
                    int i2 = Game.self.x + k1 >> 7;
                    int j2 = Game.self.z - l1 >> 7;
                    boolean flag = tryMove(0, Game.self.pathTileX[0],
                            0, j2, 0, 0, true, 1, 124, 0, i2,
                            Game.self.pathTileZ[0]);
                    if (flag) {
                        out.writeByte(j);
                        out.writeByte(k);
                        out.writeShort(cameraHorizontal);
                        out.writeByte(57);
                        out.writeByte(anInt959);
                        out.writeByte(anInt1075);
                        out.writeByte(89);
                        out
                                .writeShort(Game.self.x);
                        out
                                .writeShort(Game.self.z);
                        out.writeByte(anInt972);
                        out.writeByte(63);
                        return;
                    }
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("62107, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method144(int i, Buffer class44_sub3_sub2, int j) {
        try {
            class44_sub3_sub2.method492((byte) -51);
            int k = class44_sub3_sub2.method493(8, false);
            if (k < anInt1009) {
                for (int l = k; l < anInt1009; l++) {
                    anIntArray941[anInt940++] = anIntArray1010[l];
                }
            }
            if (k > anInt1009) {
                SignLink.reporterror(username + " Too many npcs");
                throw new RuntimeException("eek");
            }
            anInt1009 = 0;
            for (int i1 = 0; i1 < k; i1++) {
                int j1 = anIntArray1010[i1];
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[j1];
                int k1 = class44_sub3_sub2.method493(1, false);
                if (k1 == 0) {
                    anIntArray1010[anInt1009++] = j1;
                    class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                } else {
                    int l1 = class44_sub3_sub2.method493(2, false);
                    if (l1 == 0) {
                        anIntArray1010[anInt1009++] = j1;
                        class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                        anIntArray1229[anInt1228++] = j1;
                    } else if (l1 == 1) {
                        anIntArray1010[anInt1009++] = j1;
                        class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                        int i2 = class44_sub3_sub2.method493(3, false);
                        class44_sub3_sub4_sub6_sub2.method533(false, i2, anInt1153);
                        int k2 = class44_sub3_sub2.method493(1, false);
                        if (k2 == 1) {
                            anIntArray1229[anInt1228++] = j1;
                        }
                    } else if (l1 == 2) {
                        anIntArray1010[anInt1009++] = j1;
                        class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                        int j2 = class44_sub3_sub2.method493(3, false);
                        class44_sub3_sub4_sub6_sub2.method533(true, j2, anInt1153);
                        int l2 = class44_sub3_sub2.method493(3, false);
                        class44_sub3_sub4_sub6_sub2.method533(true, l2, anInt1153);
                        int i3 = class44_sub3_sub2.method493(1, false);
                        if (i3 == 1) {
                            anIntArray1229[anInt1228++] = j1;
                        }
                    } else if (l1 == 3) {
                        anIntArray941[anInt940++] = j1;
                    }
                }
            }
            if (j < 9 || j > 9) {
                packetType = -1;
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("93413, " + i + ", " + class44_sub3_sub2 + ", " + j + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void method8(int i) {
        try {
            SignLink.reporterror = false;
            try {
                if (connection != null) {
                    connection.method191();
                }
            } catch (Exception _ex) {
            }
            connection = null;
            method18(0);
            if (mouseCapturer != null) {
                mouseCapturer.aBoolean257 = false;
            }
            mouseCapturer = null;
            ondemand.method384();
            ondemand = null;
            out = null;
            loginBuffer = null;
            in = null;
            sceneMapIndex = null;
            sceneMapLandData = null;
            sceneMapLocData = null;
            sceneMapLandFile = null;
            sceneMapLocFile = null;
            anIntArrayArrayArray865 = null;
            planeTileFlags = null;
            scene = null;
            aClass18Array1022 = null;
            anIntArrayArray1113 = null;
            anIntArrayArray975 = null;
            anIntArray1020 = null;
            anIntArray1021 = null;
            aByteArray1109 = null;
            aClass34_1195 = null;
            aClass34_1196 = null;
            areaViewport = null;
            aClass34_1198 = null;
            aClass34_858 = null;
            aClass34_859 = null;
            aClass34_860 = null;
            aClass34_1123 = null;
            aClass34_1124 = null;
            aClass34_1125 = null;
            aClass34_1126 = null;
            aClass34_1127 = null;
            aClass34_1128 = null;
            aClass34_1129 = null;
            aClass34_1130 = null;
            aClass34_1131 = null;
            aClass44_Sub3_Sub1_Sub3_1143 = null;
            aClass44_Sub3_Sub1_Sub3_1144 = null;
            aClass44_Sub3_Sub1_Sub3_1145 = null;
            aClass44_Sub3_Sub1_Sub3_903 = null;
            aClass44_Sub3_Sub1_Sub3_904 = null;
            aClass44_Sub3_Sub1_Sub3_905 = null;
            aClass44_Sub3_Sub1_Sub3Array1276 = null;
            aClass44_Sub3_Sub1_Sub3_1136 = null;
            aClass44_Sub3_Sub1_Sub3_1137 = null;
            aClass44_Sub3_Sub1_Sub3_1138 = null;
            aClass44_Sub3_Sub1_Sub3_1139 = null;
            aClass44_Sub3_Sub1_Sub3_1140 = null;
            aClass44_Sub3_Sub1_Sub3_852 = null;
            aClass44_Sub3_Sub1_Sub3_853 = null;
            aClass44_Sub3_Sub1_Sub3_854 = null;
            aClass44_Sub3_Sub1_Sub3_855 = null;
            aClass44_Sub3_Sub1_Sub3_856 = null;
            aClass44_Sub3_Sub1_Sub2_988 = null;
            aClass44_Sub3_Sub1_Sub2Array1108 = null;
            aClass44_Sub3_Sub1_Sub2Array1183 = null;
            aClass44_Sub3_Sub1_Sub2Array867 = null;
            aClass44_Sub3_Sub1_Sub2_1077 = null;
            aClass44_Sub3_Sub1_Sub2_1078 = null;
            aClass44_Sub3_Sub1_Sub2_1079 = null;
            aClass44_Sub3_Sub1_Sub2_1080 = null;
            aClass44_Sub3_Sub1_Sub3Array1241 = null;
            aClass44_Sub3_Sub1_Sub2Array1052 = null;
            anIntArrayArray885 = null;
            players = null;
            anIntArray1227 = null;
            anIntArray1229 = null;
            aClass44_Sub3_Sub2Array1230 = null;
            anIntArray941 = null;
            npcs = null;
            anIntArray1010 = null;
            planeObjStacks = null;
            listTemporaryLocs = null;
            aClass28_918 = null;
            aClass28_1054 = null;
            menuParamA = null;
            menuParamB = null;
            menuAction = null;
            menuParamC = null;
            aStringArray897 = null;
            anIntArray1214 = null;
            anIntArray827 = null;
            anIntArray828 = null;
            aClass44_Sub3_Sub1_Sub2Array872 = null;
            if (i <= 0) {
                planeObjStacks = null;
            }
            aClass44_Sub3_Sub1_Sub2_913 = null;
            aStringArray1044 = null;
            aLongArray979 = null;
            anIntArray894 = null;
            aClass34_1266 = null;
            aClass34_1267 = null;
            title2 = null;
            title3 = null;
            title4 = null;
            title5 = null;
            title6 = null;
            title7 = null;
            title8 = null;
            method128(false);
            LocType.method198((byte) 42);
            NpcType.method213((byte) 42);
            ObjType.method219((byte) 42);
            FloType.aClass20Array430 = null;
            IDKType.cache = null;
            Component.instances = null;
            SeqType.cache = null;
            SpotAnimType.cache = null;
            SpotAnimType.aClass39_571 = null;
            VarpType.cache = null;
            super.aClass34_14 = null;
            PlayerEntity.aClass39_1696 = null;
            Draw3D.method418((byte) 42);
            Scene.method277((byte) 42);
            Model.method502((byte) 42);
            SeqFrame.method209((byte) 42);
            System.gc();
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("75879, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method145(byte byte0) {
        try {
            if (byte0 == 9) {
                byte0 = 0;
            } else {
                return;
            }
            if (super.clickType == 1) {
                if (super.mousePressX >= 6 && super.mousePressX <= 106 && super.mousePressY >= 467 && super.mousePressY <= 499) {
                    publicChatSetting = (publicChatSetting + 1) % 4;
                    redrawPrivacySettings = true;
                    redrawChatback = true;
                    out.writePacket(161);
                    out.writeByte(publicChatSetting);
                    out.writeByte(privateChatSetting);
                    out.writeByte(tradeChatSetting);
                }
                if (super.mousePressX >= 135 && super.mousePressX <= 235 && super.mousePressY >= 467 && super.mousePressY <= 499) {
                    privateChatSetting = (privateChatSetting + 1) % 3;
                    redrawPrivacySettings = true;
                    redrawChatback = true;
                    out.writePacket(161);
                    out.writeByte(publicChatSetting);
                    out.writeByte(privateChatSetting);
                    out.writeByte(tradeChatSetting);
                }
                if (super.mousePressX >= 273 && super.mousePressX <= 373 && super.mousePressY >= 467 && super.mousePressY <= 499) {
                    tradeChatSetting = (tradeChatSetting + 1) % 3;
                    redrawPrivacySettings = true;
                    redrawChatback = true;
                    out.writePacket(161);
                    out.writeByte(publicChatSetting);
                    out.writeByte(privateChatSetting);
                    out.writeByte(tradeChatSetting);
                }
                if (super.mousePressX >= 412 && super.mousePressX <= 512 && super.mousePressY >= 467 && super.mousePressY <= 499) {
                    if (anInt1199 == -1) {
                        method28(3);
                        aString939 = "";
                        aBoolean987 = false;
                        for (int i = 0; i < Component.instances.length; i++) {
                            if (Component.instances[i] != null && Component.instances[i].anInt109 == 600) {
                                anInt1217 = anInt1199 = Component.instances[i].anInt106;
                                return;
                            }
                        }
                        return;
                    } else {
                        renderText(0, (byte) -115,
                                "Please close the interface you have open before using 'report abuse'", "");
                        return;
                    }
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("77202, " + byte0 + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public boolean method146(byte[] abyte0, int i, int j) {
        try {
            if (i != 0) {
                throw new NullPointerException();
            }
            if (abyte0 == null) {
                return true;
            } else {
                return SignLink.wavesave(abyte0, j);
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("56223, " + abyte0 + ", " + i + ", " + j + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method147(boolean flag, int i) {
        try {
            ingame &= flag;
            int j = VarpType.cache[i].anInt682;
            if (j == 0) {
                return;
            }
            int k = anIntArray1214[i];
            if (j == 1) {
                if (k == 1) {
                    Draw3D.method427(0.90000000000000002D, 0);
                }
                if (k == 2) {
                    Draw3D.method427(0.80000000000000004D, 0);
                }
                if (k == 3) {
                    Draw3D.method427(0.69999999999999996D, 0);
                }
                if (k == 4) {
                    Draw3D.method427(0.59999999999999998D, 0);
                }
                ObjType.aClass39_370.method341();
                redrawTitleBackground = true;
            }
            if (j == 3) {
                boolean flag1 = aBoolean1057;
                if (k == 0) {
                    method59(true, 0, aBoolean1057);
                    aBoolean1057 = true;
                }
                if (k == 1) {
                    method59(true, -400, aBoolean1057);
                    aBoolean1057 = true;
                }
                if (k == 2) {
                    method59(true, -800, aBoolean1057);
                    aBoolean1057 = true;
                }
                if (k == 3) {
                    method59(true, -1200, aBoolean1057);
                    aBoolean1057 = true;
                }
                if (k == 4) {
                    aBoolean1057 = false;
                }
                if (aBoolean1057 != flag1 && !Game.lowMemory) {
                    if (aBoolean1057) {
                        anInt1190 = anInt963;
                        aBoolean1191 = true;
                        ondemand.request(2, anInt1190);
                    } else {
                        method18(0);
                    }
                    anInt942 = 0;
                }
            }
            if (j == 4) {
                if (k == 0) {
                    aBoolean1050 = true;
                    method85(aBoolean985, 0);
                }
                if (k == 1) {
                    aBoolean1050 = true;
                    method85(aBoolean985, -400);
                }
                if (k == 2) {
                    aBoolean1050 = true;
                    method85(aBoolean985, -800);
                }
                if (k == 3) {
                    aBoolean1050 = true;
                    method85(aBoolean985, -1200);
                }
                if (k == 4) {
                    aBoolean1050 = false;
                }
            }
            if (j == 5) {
                anInt862 = k;
            }
            if (j == 6) {
                anInt970 = k;
            }
            if (j == 8) {
                anInt1017 = k;
                redrawChatback = true;
            }
            if (j == 9) {
                anInt835 = k;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("33016, " + flag + ", " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }
}

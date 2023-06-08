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
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.zip.CRC32;

@SuppressWarnings("serial")
public class Game extends GameShell {

    public static int anInt821;
    public static int anInt845;
    public static int anInt870;
    public static int anInt873;
    public static boolean started;
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
    public static PlayerEntity localPlayer;
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

    public boolean updateDesignModel;
    public long serverSeed;
    public OnDemandRequester ondemand;
    public int crossX;
    public int crossY;
    public int crossCycle;
    public int crossMode;
    public int sameClickPositionCounter;
    public boolean aBoolean820;
    public Buffer loginBuffer;
    public String modalMessage;
    public int delta;
    public int lastHoveredComponentId;
    public int activeMapfunctionCount;
    public int[] activeMapfunctionsX;
    public int[] activeMapfunctionsZ;
    public boolean cutsceneActive;
    public byte aByte830;
    public int loginInputLine;
    public int scrollGripInputPadding;
    public int flashingTab;
    public int anInt834;
    public int anInt835;
    public Image8[] modicons;
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
    public int minimapState;
    public int[] designIdentityKits;
    public Buffer out;
    public int[] anIntArray851;
    public Image8 redstone5Image;
    public Image8 redstone6Image;
    public Image8 redstone7Image;
    public Image8 redstone8Image;
    public Image8 redstone9Image;
    public int anInt857;
    public DrawArea aClass34_858;
    public DrawArea aClass34_859;
    public DrawArea aClass34_860;
    public int anInt861;
    public int anInt862;
    public boolean ingame;
    public Image8[] imageRunes;
    public int[][][] planeHeightMap;
    public MouseCapturer mouseCapturer;
    public Image24[] crosses;
    public int[] minimapMaskLineLengths;
    public int daysSinceRecoveriesChanged;
    public byte[][][] planeTileFlags;
    public Image24[] activeMapfunctions;
    public int chatScrollHeight;
    public int cameraPositionX;
    public int cameraPositionZ;
    public int cameraPositionY;
    public int cameraVerticalRotation;
    public int cameraHorizontalRotation;
    public int anInt880;
    public int[] minimapMaskLineOffsets;
    public int sceneState;
    public byte aByte883;
    public byte aByte884;
    public int[][] anIntArrayArray885;
    public boolean flamesThread;
    public int anInt887;
    public int anInt888;
    public int sidebarComponentId;
    public int flameCycle0;
    public Image8 titleBox;
    public Image8 titleButton;
    public boolean aBoolean893;
    public int[] friendWorld;
    public int privateChatMode;
    public String[] menuOption;
    public boolean redrawInvback;
    public int anInt899;
    public int anInt900;
    public int anInt901;
    public int anInt902;
    public Image8 backbase1Image;
    public Image8 backbase2Image;
    public Image8 backhmid1Image;
    public boolean withinTutorialIsland;
    public int anInt907;
    public boolean redrawTitleBackground;
    public int anInt909;
    public int[] compassMaskLineLengths;
    public int flagSceneTileX;
    public int flagSceneTileZ;
    public Image24 minimap;
    public int[] areaChatbackOffsets;
    public int[] areaInvbackOffsets;
    public int[] areaViewportOffsets;
    public int warnMembersInNonmembers;
    public LinkedList projectiles;
    public String[] playerOptions;
    public boolean[] playerOptionPushDown;
    public int anInt921;
    public boolean jaggrabEnabled;
    public int viewportOverlayComponentId;
    public byte aByte925;
    public String message;
    public ISAACCipher encryption;
    public int anInt928;
    public int cameraVertical;
    public int cameraHorizontal;
    public int anInt931;
    public int anInt932;
    public int invbackHoveredComponentId;
    public boolean windowFocused;
    public boolean continuedDialogue;
    public int playerEnergy;
    public int[] designColors;
    public String reportAbuseInput;
    public int anInt940;
    public int[] anIntArray941;
    public int nextSongDelay;
    public int[] cameraFrequency;
    public int anInt945;
    public boolean menuOpen;
    public int daysSinceLastLogin;
    public int anInt948;
    public boolean aBoolean950;
    public CRC32 aCRC32_951;
    public int objSelected;
    public int lastItemSelectedSlot;
    public int moveIteminterfaceId;
    public int anInt955;
    public String selectedObjName;
    public int ignoreCount;
    public int minimapAnticheatAngle;
    public int anInt960;
    public int[] compassMaskLineOffsets;
    public int anInt962;
    public int nextSong;
    public int anInt964;
    public int chatOverlayComponentId;
    public long aLong967;
    public int waveCount;
    public int anInt969;
    public int anInt970;
    public int menuSize;
    public int anInt972;
    public byte[][] sceneMapLocData;
    public int anInt974;
    public int[][] anIntArrayArray975;
    public int[] cameraJitter;
    public byte aByte977;
    public int objDragCycles;
    public long[] aLongArray979;
    public boolean chatbackInputType;
    public byte[][] sceneMapLandData;
    public int moveItemSlotEnd;
    public int lastActiveInventoryInterface;
    public boolean aBoolean985;
    public boolean reportAbuseMuteOption;
    public Image24 compassImage;
    public int anInt989;
    public int anInt990;
    public int anInt991;
    public int anInt992;
    public int anInt993;
    public int spellSelected;
    public int anInt995;
    public int spellUsableOn;
    public String spellTooltip;
    public int systemUpdateTimer;
    public int viewportHoveredComponentId;
    public int anInt1000;
    public int[] anIntArray1001;
    public int[] chatTypes;
    public String[] chatNames;
    public String[] chatMessages;
    public int hintIconType;
    public int[] anIntArray1006;
    public String socialInput;
    public NPCEntity[] npcs;
    public int npcCount;
    public int[] anIntArray1010;
    public int cameraAnticheatOffsetX;
    public int anInt1012;
    public Socket jaggrabSocket;
    public int loginScreenState;
    public int anInt1015 = 100;
    public int[] anIntArray1016;
    public int splitPrivateChat;
    public int[] flameLineOffset;
    public int anInt1019;
    public int[] anIntArray1020;
    public int[] anIntArray1021;
    public CollisionMap[] collisions;
    public int unreadMessages;
    public int[] anIntArray1024;
    public Image24 genderButtonImage0;
    public Image24 genderButtonImage1;
    public int currentTab;
    public int anInt1028;
    public int menuScreenArea;
    public int menuOffsetX;
    public int menuOffsetY;
    public int menuWidth;
    public int menuHeight;
    public int[] anIntArray1035;
    public boolean aBoolean1036;
    public int playerX;
    public int playerZ;
    public int[] sceneMapIndex;
    public int[] sceneMapLandFile;
    public int[] sceneMapLocFile;
    public byte aByte1042;
    public String[] friendName;
    public long aLong1048;
    public boolean redrawChatback;
    public boolean aBoolean1050;
    public int[] archiveCRCs;
    public Image24[] mapfunctions;
    public byte aByte1053;
    public LinkedList spotanims;
    public boolean errorLoading;
    public int anInt1056;
    public boolean aBoolean1057;
    public Image8 scrollbar0Image;
    public Image8 scrollbar1Image;
    public int[] tabComponentId = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public boolean redrawPrivacySettings;
    public int minimapLevel;
    public int anInt1064;
    public int anInt1065;
    public int dragCycle;
    public int firstOpcode;
    public int secondOpcode;
    public int thirdOpcode;
    public long sceneLoadStartTime;
    public String username;
    public String password;
    public int anInt1074;
    public int minimapZoom;
    public int anInt1076;
    public Image24 mapdot0Image;
    public Image24 mapdot1Image;
    public Image24 mapdot2Image;
    public Image24 mapdot3Image;
    public int currentCameraPositionH;
    public int currentCameraPositionV;
    public int anInt1083;
    public boolean aBoolean1084;
    public int anInt1085;
    public byte aByte1086;
    public int isMembers;
    public int[] anIntArray1090;
    public int anInt1091;
    public String chatBackInput;
    public int objDragComponentId;
    public int objDragSlot;
    public int objDragArea;
    public int objGrabX;
    public int objGrabY;
    public byte aByte1098;
    public Connection connection;
    public byte aByte1101;
    public String socialMessage;
    public int chatScrollOffset;
    public int friendCount;
    public int friendlistStatus;
    public int cameraAnticheatAngle;
    public int anInt1107;
    public Image24[] hitmarks;
    public byte[] aByteArray1109;
    public String loginMessage0;
    public String loginMessage1;
    public int multiCombatZone;
    public int[][] anIntArrayArray1113;
    public int localPlayerIndex;
    public LinkedList listTemporaryLocs;
    public FileArchive titleArchive;
    public int anInt1118;
    public int anInt1119;
    public int anInt1120;
    public int anInt1121;
    public int anInt1122;
    public DrawArea backleft1Area;
    public DrawArea backleft2Area;
    public DrawArea backright1Area;
    public DrawArea backright2Area;
    public DrawArea backtop1Area;
    public DrawArea backvmid1Area;
    public DrawArea backvmid2Area;
    public DrawArea backvmid3Area;
    public DrawArea backhmid2Area;
    public Buffer in;
    public int[] flameBuffer0;
    public int[] flameBuffer1;
    public Image8 redstone0Image;
    public Image8 redstone1Image;
    public Image8 redstone2Image;
    public Image8 redstone3Image;
    public Image8 redstone4Image;
    public String chatTyped;
    public int[] TYPE_TO_CLASS = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    public Image8 invbackImage;
    public Image8 mapbackImage;
    public Image8 chatbackImage;
    public LinkedList[][][] planeObjStacks;
    public boolean aBoolean1147;
    public int anInt1148;
    public int containerComponentId;
    public int containerIndex;
    public int containerComponentType;
    public int anInt1152;
    public int anInt1153;
    public boolean redrawSideicons;
    public int plane;
    public boolean scrollGripHeld;
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
    public boolean flameActive;
    public int percent;
    public int anInt1177;
    public boolean aBoolean1178;
    public boolean designGenderMasc;
    public long lastClickTime;
    public byte aByte1182;
    public Image24[] headicons;
    public int sceneBaseTileX;
    public int sceneBaseTileZ;
    public int scenePrevBaseTileX;
    public int scenePrevBaseTileZ;
    public int rights;
    public int renderCycle;
    public int song;
    public boolean musicFading;
    public Scene scene;
    public int[] anIntArray1193;
    public DrawArea aClass34_1195;
    public DrawArea aClass34_1196;
    public DrawArea areaViewport;
    public DrawArea areaChatBack;
    public int viewportComponentId;
    public int anInt1200;
    public Component aClass5_1201;
    public int anInt1202;
    public int[] anIntArray1203 = {0xffff00, 0xff0000, 65280, 65535, 0xff00ff, 0xffffff};
    public int weightCarried;
    public int[] cameraAmplitude;
    public FileStore[] filestores;
    public boolean[] customCameraActive;
    public Image24 mapmarker0Image;
    public Image24 mapmarker1Image;
    public int chatbackHoveredComponentId;
    public byte aByte1213;
    public int[] anIntArray1214;
    public int cameraAnticheatOffsetZ;
    public int anInt1216;
    public int anInt1217;
    public int[] flameGradient;
    public int[] flameGradient0;
    public int[] flameGradient1;
    public int[] flameGradient2;
    public boolean showSocialInput;
    public static int MAX_PLAYER_COUNT;
    public static int MAX_NPC_COUNT;
    public int LOCAL_PLAYER_INDEX;
    public PlayerEntity[] players;
    public int playerCount;
    public int[] anIntArray1227;
    public int anInt1228;
    public int[] anIntArray1229;
    public Buffer[] appearanceBuffer;
    public int lastAddress;
    public boolean errorStarted;
    public boolean aBoolean1237;
    public int secondaryCameraVertical;
    public Image8[] mapscenes;
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
    public int chatComponentId;
    public long[] ignoreNameLong;
    public BitmapFont fontSmall;
    public BitmapFont fontPlain;
    public BitmapFont fontBold;
    public BitmapFont fontQuill;
    public int flameGradientCycle0;
    public int flameGradientCycle1;
    public Image24 mapedgeImage;
    public boolean aBoolean1262;
    public DrawArea title2;
    public DrawArea title3;
    public DrawArea title4;
    public DrawArea title0;
    public DrawArea title1;
    public DrawArea title5;
    public DrawArea title6;
    public DrawArea title7;
    public DrawArea title8;
    public int[] flameBuffer3;
    public int[] flameBuffer2;
    public boolean loadingMap;
    public Image8[] sideicons;
    public Image24 flamesLeft;
    public Image24 flameRight;

    public Game() {
        updateDesignModel = false;
        aBoolean820 = false;
        loginBuffer = Buffer.method470(-929, 1);
        activeMapfunctionsX = new int[1000];
        activeMapfunctionsZ = new int[1000];
        cutsceneActive = false;
        aByte830 = -83;
        flashingTab = -1;
        modicons = new Image8[2];
        menuParamA = new int[500];
        menuParamB = new int[500];
        menuAction = new int[500];
        menuParamC = new int[500];
        anInt844 = 0x332d25;
        anIntArray846 = new int[50];
        aBoolean847 = false;
        designIdentityKits = new int[7];
        out = Buffer.method470(-929, 1);
        anIntArray851 = new int[SkillConstants.skillCount];
        ingame = false;
        crosses = new Image24[8];
        minimapMaskLineLengths = new int[151];
        activeMapfunctions = new Image24[1000];
        chatScrollHeight = 78;
        minimapMaskLineOffsets = new int[151];
        aByte883 = -127;
        aByte884 = 38;
        anIntArrayArray885 = new int[104][104];
        flamesThread = false;
        sidebarComponentId = -1;
        aBoolean893 = false;
        friendWorld = new int[200];
        menuOption = new String[500];
        redrawInvback = false;
        anInt900 = -1;
        anInt902 = 70;
        withinTutorialIsland = false;
        redrawTitleBackground = false;
        compassMaskLineLengths = new int[33];
        projectiles = new LinkedList(-199);
        playerOptions = new String[5];
        playerOptionPushDown = new boolean[5];
        jaggrabEnabled = true;
        viewportOverlayComponentId = -1;
        aByte925 = 1;
        cameraVertical = 128;
        windowFocused = true;
        continuedDialogue = false;
        designColors = new int[5];
        reportAbuseInput = "";
        anIntArray941 = new int[1000];
        cameraFrequency = new int[5];
        menuOpen = false;
        anInt948 = -587;
        aBoolean950 = true;
        aCRC32_951 = new CRC32();
        anInt960 = 2;
        compassMaskLineOffsets = new int[33];
        anInt962 = 817;
        nextSong = -1;
        chatOverlayComponentId = -1;
        anInt969 = -8033;
        anInt974 = 8;
        anIntArrayArray975 = new int[104][104];
        cameraJitter = new int[5];
        aByte977 = 8;
        aLongArray979 = new long[200];
        chatbackInputType = false;
        aBoolean985 = true;
        reportAbuseMuteOption = false;
        anInt1000 = 0x23201b;
        anIntArray1001 = new int[5];
        chatTypes = new int[100];
        chatNames = new String[100];
        chatMessages = new String[100];
        anIntArray1006 = new int[50];
        socialInput = "";
        npcs = new NPCEntity[16384];
        anIntArray1010 = new int[16384];
        anInt1012 = 2;
        anInt1015 = 100;
        anIntArray1016 = new int[100];
        flameLineOffset = new int[256];
        anInt1019 = 661;
        anIntArray1020 = new int[4000];
        anIntArray1021 = new int[4000];
        collisions = new CollisionMap[4];
        anIntArray1024 = new int[2000];
        currentTab = 3;
        anIntArray1035 = new int[SkillConstants.skillCount];
        aBoolean1036 = true;
        aByte1042 = -71;
        friendName = new String[200];
        redrawChatback = false;
        aBoolean1050 = true;
        archiveCRCs = new int[9];
        mapfunctions = new Image24[100];
        aByte1053 = 29;
        spotanims = new LinkedList(-199);
        errorLoading = false;
        anInt1056 = 513;
        aBoolean1057 = true;
        redrawPrivacySettings = false;
        minimapLevel = -1;
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
        chatBackInput = "";
        aByte1098 = 29;
        aByte1101 = 6;
        socialMessage = "";
        anInt1107 = 1;
        hitmarks = new Image24[20];
        aByteArray1109 = new byte[16384];
        loginMessage0 = "";
        loginMessage1 = "";
        anIntArrayArray1113 = new int[104][104];
        localPlayerIndex = -1;
        listTemporaryLocs = new LinkedList(-199);
        in = Buffer.method470(-929, 1);
        chatTyped = "";
        planeObjStacks = new LinkedList[4][104][104];
        aBoolean1147 = false;
        anInt1153 = -6002;
        redrawSideicons = false;
        scrollGripHeld = false;
        anInt1158 = 50;
        anIntArray1159 = new int[anInt1158];
        anIntArray1160 = new int[anInt1158];
        anIntArray1161 = new int[anInt1158];
        anIntArray1162 = new int[anInt1158];
        anIntArray1163 = new int[anInt1158];
        anIntArray1164 = new int[anInt1158];
        anIntArray1165 = new int[anInt1158];
        aStringArray1166 = new String[anInt1158];
        flameActive = false;
        anInt1177 = -1;
        aBoolean1178 = true;
        designGenderMasc = true;
        aByte1182 = 2;
        headicons = new Image24[20];
        musicFading = true;
        anIntArray1193 = new int[50];
        viewportComponentId = -1;
        anInt1200 = 0x4d4233;
        aClass5_1201 = new Component();
        anInt1202 = 9;
        cameraAmplitude = new int[5];
        filestores = new FileStore[5];
        customCameraActive = new boolean[5];
        aByte1213 = 1;
        anIntArray1214 = new int[2000];
        anInt1216 = 2;
        anInt1217 = -1;
        showSocialInput = false;
        MAX_PLAYER_COUNT = 2048;
        MAX_NPC_COUNT = 16384;
        LOCAL_PLAYER_INDEX = 2047;
        players = new PlayerEntity[MAX_PLAYER_COUNT];
        anIntArray1227 = new int[MAX_PLAYER_COUNT];
        anIntArray1229 = new int[MAX_PLAYER_COUNT];
        appearanceBuffer = new Buffer[MAX_PLAYER_COUNT];
        errorStarted = false;
        aBoolean1237 = false;
        mapscenes = new Image8[100];
        anInt1243 = 831;
        anInt1244 = 393;
        anInt1247 = -282;
        chatComponentId = -1;
        ignoreNameLong = new long[100];
        aBoolean1262 = false;
        loadingMap = false;
        sideicons = new Image8[13];
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
            Region.aBoolean64 = false;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("78522, " + flag + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    public static String getAmountToText(int amount) {
        String s = String.valueOf(amount);
        for (int j = s.length() - 3; j > 0; j -= 3) {
            s = s.substring(0, j) + "," + s.substring(j);
        }
        if (s.length() > 8) {
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        } else if (s.length() > 4) {
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        }
        return " " + s;
    }

    public static String formatObjAmount(int amount) {
        if (amount < 0x186a0) {
            return String.valueOf(amount);
        }
        if (amount < 0x989680) {
            return amount / 1000 + "K";
        } else {
            return amount / 0xf4240 + "M";
        }
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
            Region.aBoolean64 = true;
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
            if (errorStarted || errorLoading || aBoolean820) {
                return;
            }
            Game.loopCycle++;
            if (!ingame) {
                method97((byte) 122);
            } else {
                method56(anInt1056);
            }
            handleOnDemandRequests();
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("47231, " + i + ", " + runtimeexception);
        } catch (Exception e) {
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
            if (objDragArea != 0) {
                return;
            }
            int i = super.clickType;
            if (spellSelected == 1 && super.mousePressX >= 516 && super.mousePressY >= 160 && super.mousePressX <= 765
                    && super.mousePressY <= 205) {
                i = 0;
            }
            if (menuOpen) {
                if (i != 1) {
                    int j = super.mouseX;
                    int i1 = super.mouseY;
                    if (menuScreenArea == 0) {
                        j -= 4;
                        i1 -= 4;
                    }
                    if (menuScreenArea == 1) {
                        j -= 553;
                        i1 -= 205;
                    }
                    if (menuScreenArea == 2) {
                        j -= 17;
                        i1 -= 357;
                    }
                    if (j < menuOffsetX - 10 || j > menuOffsetX + menuWidth + 10 || i1 < menuOffsetY - 10
                            || i1 > menuOffsetY + menuHeight + 10) {
                        menuOpen = false;
                        if (menuScreenArea == 1) {
                            redrawInvback = true;
                        }
                        if (menuScreenArea == 2) {
                            redrawChatback = true;
                        }
                    }
                }
                if (i == 1) {
                    int k = menuOffsetX;
                    int j1 = menuOffsetY;
                    int l1 = menuWidth;
                    int j2 = super.mousePressX;
                    int k2 = super.mousePressY;
                    if (menuScreenArea == 0) {
                        j2 -= 4;
                        k2 -= 4;
                    }
                    if (menuScreenArea == 1) {
                        j2 -= 553;
                        k2 -= 205;
                    }
                    if (menuScreenArea == 2) {
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
                    menuOpen = false;
                    if (menuScreenArea == 1) {
                        redrawInvback = true;
                    }
                    if (menuScreenArea == 2) {
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
                            objDragCycles = 0;
                            objDragComponentId = i2;
                            objDragSlot = k1;
                            objDragArea = 2;
                            objGrabX = super.mousePressX;
                            objGrabY = super.mousePressY;
                            if (Component.instances[i2].anInt106 == viewportComponentId) {
                                objDragArea = 1;
                            }
                            if (Component.instances[i2].anInt106 == chatComponentId) {
                                objDragArea = 3;
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
                    processMenuHovering();
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
                int i1 = cameraHorizontal + minimapAnticheatAngle & 0x7ff;
                int j1 = Model.SINE[i1];
                int k1 = Model.COSINE[i1];
                j1 = (j1 * 256) / (minimapZoom + 256);
                k1 = (k1 * 256) / (minimapZoom + 256);
                int l1 = j * j1 + i * k1 >> 16;
                int i2 = j * k1 - i * j1 >> 16;
                double d = Math.atan2(l1, i2);
                int j2 = (int) (Math.sin(d) * 63D);
                int k2 = (int) (Math.cos(d) * 57D);
                mapedgeImage.method445(15, d, 20, 256, 15, (94 + j2 + 4) - 10, (byte) 8, 20,
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

    public void draw3dScreen() {
        drawSplitPrivateChat();
        if (crossMode == 1) {
            crosses[crossCycle / 100].draw(crossX - 8 - 4, crossY - 8 - 4);
        }
        if (crossMode == 2) {
            crosses[4 + crossCycle / 100].draw(crossX - 8 - 4, crossY - 8 - 4);
        }
        if (viewportOverlayComponentId != -1) {
            animateComponent(delta, viewportOverlayComponentId);
            drawComponent(Component.instances[viewportOverlayComponentId], 0, 0, 0);
        }
        if (viewportComponentId != -1) {
            animateComponent(delta, viewportComponentId);
            drawComponent(Component.instances[viewportComponentId], 0, 0, 0);
        }
        checkTutorialIsland();
        if (!menuOpen) {
            processRightClick();
            drawToolTip();
        } else if (menuScreenArea == 0) {
            drawMenu();
        }
        if (multiCombatZone == 1) {
            headicons[1].draw(472, 296);
        }
        if (systemUpdateTimer != 0) {
            int seconds = systemUpdateTimer / 50;
            int minutes = seconds / 60;
            seconds %= 60;
            if (seconds < 10) {
                fontPlain.drawText("System update in: " + minutes + ":0" + seconds, 329, 4, 0xffff00);
            } else {
                fontPlain.drawText("System update in: " + minutes + ":" + seconds, 329, 4, 0xffff00);
            }
        }
    }

    public void renderText(String s1, String s, int i) {
        if (i == 0 && chatOverlayComponentId != -1) {
            modalMessage = s;
            super.clickType = 0;
        }
        if (chatComponentId == -1) {
            redrawChatback = true;
        }
        for (int j = 99; j > 0; j--) {
            chatTypes[j] = chatTypes[j - 1];
            chatNames[j] = chatNames[j - 1];
            chatMessages[j] = chatMessages[j - 1];
        }
        chatTypes[0] = i;
        chatNames[0] = s1;
        chatMessages[0] = s;
    }

    public void stopMidi(int i) {
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
            int i = class5.contentType;
            if (friendlistStatus == 2) {
                if (i == 201) {
                    redrawChatback = true;
                    chatbackInputType = false;
                    showSocialInput = true;
                    socialInput = "";
                    anInt880 = 1;
                    socialMessage = "Enter name of friend to add to list";
                }
                if (i == 202) {
                    redrawChatback = true;
                    chatbackInputType = false;
                    showSocialInput = true;
                    socialInput = "";
                    anInt880 = 2;
                    socialMessage = "Enter name of friend to delete from list";
                }
            }
            if (i == 205) {
                idleLogout = 250;
                return true;
            }
            if (i == 501) {
                redrawChatback = true;
                chatbackInputType = false;
                showSocialInput = true;
                socialInput = "";
                anInt880 = 4;
                socialMessage = "Enter name of player to add to list";
            }
            if (i == 502) {
                redrawChatback = true;
                chatbackInputType = false;
                showSocialInput = true;
                socialInput = "";
                anInt880 = 5;
                socialMessage = "Enter name of player to delete from list";
            }
            if (i >= 300 && i <= 313) {
                int j = (i - 300) / 2;
                int i1 = i & 1;
                int l1 = designIdentityKits[j];
                if (l1 != -1) {
                    do {
                        if (i1 == 0 && --l1 < 0) {
                            l1 = IdkType.anInt463 - 1;
                        }
                        if (i1 == 1 && ++l1 >= IdkType.anInt463) {
                            l1 = 0;
                        }
                    } while (IdkType.cache[l1].aBoolean470
                            || IdkType.cache[l1].anInt465 != j + (designGenderMasc ? 0 : 7));
                    designIdentityKits[j] = l1;
                    updateDesignModel = true;
                }
            }
            if (i >= 314 && i <= 323) {
                int k = (i - 314) / 2;
                int j1 = i & 1;
                int i2 = designColors[k];
                if (j1 == 0 && --i2 < 0) {
                    i2 = Game.APPEARANCE_COLOURS[k].length - 1;
                }
                if (j1 == 1 && ++i2 >= Game.APPEARANCE_COLOURS[k].length) {
                    i2 = 0;
                }
                designColors[k] = i2;
                updateDesignModel = true;
            }
            if (i == 324 && !designGenderMasc) {
                designGenderMasc = true;
                validateCharacterDesign(aByte883);
            }
            if (i == 325 && designGenderMasc) {
                designGenderMasc = false;
                validateCharacterDesign(aByte883);
            }
            if (i == 326) {
                out.writePacket(27);
                out.writeByte(designGenderMasc ? 0 : 1);
                for (int l = 0; l < 7; l++) {
                    out.writeByte(designIdentityKits[l]);
                }
                for (int k1 = 0; k1 < 5; k1++) {
                    out.writeByte(designColors[k1]);
                }
                return true;
            }
            if (i == 613) {
                reportAbuseMuteOption = !reportAbuseMuteOption;
            }
            if (i >= 601 && i <= 612) {
                method28(3);
                if (reportAbuseInput.length() > 0) {
                    out.writePacket(94);
                    out.method478(TextUtils.encodeBase37(reportAbuseInput), true);
                    out.writeByte(i - 601);
                    out.writeByte(reportAbuseMuteOption ? 1 : 0);
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
            for (int j = -1; j < playerCount; j++) {
                int k;
                if (j == -1) {
                    k = LOCAL_PLAYER_INDEX;
                } else {
                    k = anIntArray1227[j];
                }
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[k];
                if (class44_sub3_sub4_sub6_sub1 != null && class44_sub3_sub4_sub6_sub1.spokenLife > 0) {
                    class44_sub3_sub4_sub6_sub1.spokenLife--;
                    if (class44_sub3_sub4_sub6_sub1.spokenLife == 0) {
                        class44_sub3_sub4_sub6_sub1.spoken = null;
                    }
                }
            }
            for (int l = 0; l < npcCount; l++) {
                int i1 = anIntArray1010[l];
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[i1];
                if (class44_sub3_sub4_sub6_sub2 != null && class44_sub3_sub4_sub6_sub2.spokenLife > 0) {
                    class44_sub3_sub4_sub6_sub2.spokenLife--;
                    if (class44_sub3_sub4_sub6_sub2.spokenLife == 0) {
                        class44_sub3_sub4_sub6_sub2.spoken = null;
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

    public void drawScrollbar(int x, int y, int scroll, int scrollHeight, int height) {
        try {
            scrollbar0Image.blit(y, x);
            scrollbar1Image.blit((y + height) - 16, x);
            Draw2D.fillRect(x, y + 16, 16, height - 32, anInt1000, 210);
            int k1 = ((height - 32) * height) / scrollHeight;
            if (k1 < 8) {
                k1 = 8;
            }
            int l1 = ((height - 32 - k1) * scroll) / (scrollHeight - height);
            Draw2D.fillRect(x, y + 16 + l1, 16, k1, anInt1200, 210);
            Draw2D.method416(y + 16 + l1, x, anInt1085, k1, 0);
            Draw2D.method416(y + 16 + l1, x + 1, anInt1085, k1, 0);
            Draw2D.drawLineX(16, x, anInt1085, true, y + 16 + l1);
            Draw2D.drawLineX(16, x, anInt1085, true, y + 17 + l1);
            Draw2D.method416(y + 16 + l1, x + 15, anInt844, k1, 0);
            Draw2D.method416(y + 17 + l1, x + 14, anInt844, k1 - 1, 0);
            Draw2D.drawLineX(16, x, anInt844, true, y + 15 + l1 + k1);
            Draw2D.drawLineX(15, x + 1, anInt844, true, y + 14 + l1 + k1);
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("34190, " + y + ", " + x + ", " + scroll + ", " + scrollHeight + ", " + height + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void logout() {
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
            clearCaches(aByte1042);
            scene.reset(true);
            for (int i = 0; i < 4; i++) {
                collisions[i].reset(3);
            }
            System.gc();
            stopMidi(0);
            nextSong = -1;
            song = -1;
            nextSongDelay = 0;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("79964, " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void updateTemporaryLocs(int i) {
        try {
            if (i <= 0) {
                anInt962 = -451;
            }
            if (sceneState == 2) {
                for (SceneLocTemporary loc = (SceneLocTemporary) listTemporaryLocs.peekFront(); loc != null; loc = (SceneLocTemporary) listTemporaryLocs
                        .prev(false)) {
                    if (loc.delayUntilRespawn > 0) {
                        loc.delayUntilRespawn--;
                    }
                    if (loc.delayUntilRespawn == 0) {
                        if (loc.previousId < 0
                                || Region.isLocReady(loc.previousId, loc.previousType, 677)) {
                            addLoc(loc.id, 0, loc.previousType, loc.plane,
                                    loc.previousId, loc.sceneTileX, loc.locType,
                                    loc.sceneTileZ);
                            loc.remove();
                        }
                    } else {
                        if (loc.delayUntilSpawn > 0) {
                            loc.delayUntilSpawn--;
                        }
                        if (loc.delayUntilSpawn == 0
                                && loc.sceneTileX >= 1
                                && loc.sceneTileZ >= 1
                                && loc.sceneTileX <= 102
                                && loc.sceneTileZ <= 102
                                && (loc.id2 < 0 || Region.isLocReady(loc.id2,
                                loc.type2, 677))) {
                            addLoc(loc.face2, 0, loc.type2, loc.plane,
                                    loc.id2, loc.sceneTileX, loc.locType,
                                    loc.sceneTileZ);
                            loc.delayUntilSpawn = -1;
                            if (loc.id2 == loc.previousId && loc.previousId == -1) {
                                loc.remove();
                            } else if (loc.id2 == loc.previousId
                                    && loc.face2 == loc.id
                                    && loc.type2 == loc.previousType) {
                                loc.remove();
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

    public void checkTutorialIsland() {
        tutorial = 0;
        int i = (Game.localPlayer.x >> 7) + sceneBaseTileX;
        int j = (Game.localPlayer.z >> 7) + sceneBaseTileZ;
        if (i >= 3053 && i <= 3156 && j >= 3056 && j <= 3136) {
            tutorial = 1;
        }
        if (i >= 3072 && i <= 3118 && j >= 9492 && j <= 9535) {
            tutorial = 1;
        }
        if (tutorial == 1 && i >= 3139 && i <= 3199 && j >= 3008 && j <= 3062) {
            tutorial = 0;
        }
    }

    public void updateFlames(int i) {
        try {
            int height = 256;
            for (int x = 10; x < 117; x++) {
                int flickerRandom = (int) (Math.random() * 100D);
                if (flickerRandom < 50) {
                    flameBuffer3[x + (height - 2 << 7)] = 255;
                }
            }
            for (int l = 0; l < 100; l++) {
                int x = (int) (Math.random() * 124D) + 2;
                int y = (int) (Math.random() * 128D) + 128;
                flameBuffer3[x + (y << 7)] = 192;
            }
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < 127; x++) {
                    int pos = x + (y << 7);
                    flameBuffer2[pos] = (flameBuffer3[pos - 1] + flameBuffer3[pos + 1] + flameBuffer3[pos - 128] + flameBuffer3[pos + 128]) / 4;
                }
            }
            flameCycle0 += 128;
            i = 27 / i;
            if (flameCycle0 > flameBuffer0.length) {
                flameCycle0 -= flameBuffer0.length;
                updateFlameBuffer(imageRunes[(int) (Math.random() * 12D)], 34809);
            }
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < 127; x++) {
                    int pos = x + (y << 7);
                    int intensity = flameBuffer2[pos + 128] - flameBuffer0[pos + flameCycle0 & flameBuffer0.length - 1] / 5;
                    if (intensity < 0) {
                        intensity = 0;
                    }
                    flameBuffer3[pos] = intensity;
                }
            }
            for (int j3 = 0; j3 < height - 1; j3++) {
                flameLineOffset[j3] = flameLineOffset[j3 + 1];
            }
            flameLineOffset[height - 1] = (int) (Math.sin(Game.loopCycle / 14D) * 16D + Math.sin(Game.loopCycle / 15D)
                    * 14D + Math.sin(Game.loopCycle / 16D) * 12D);
            if (flameGradientCycle0 > 0) {
                flameGradientCycle0 -= 4;
            }
            if (flameGradientCycle1 > 0) {
                flameGradientCycle1 -= 4;
            }
            if (flameGradientCycle0 == 0 && flameGradientCycle1 == 0) {
                int l3 = (int) (Math.random() * 2000D);
                if (l3 == 0) {
                    flameGradientCycle0 = 1024;
                }
                if (l3 == 1) {
                    flameGradientCycle1 = 1024;
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

    public void loadArchiveChecksums() {
        int wait = 1;
        archiveCRCs[8] = 0;
        int retries = 0;
        while (archiveCRCs[8] == 0) {
            String s = "Unknown problem";
            showProgress(20, "Connecting to web server");
            try {
                DataInputStream datainputstream = openJaggrabBuffer("crc" + (int) (Math.random() * 99999999D) + "-" + 289);
                Buffer class44_sub3_sub2 = new Buffer(new byte[40]);
                datainputstream.readFully(class44_sub3_sub2.payload, 0, 40);
                datainputstream.close();
                for (int l = 0; l < 9; l++) {
                    archiveCRCs[l] = class44_sub3_sub2.readInt();
                }
                int i1 = class44_sub3_sub2.readInt();
                int j1 = 1234;
                for (int k1 = 0; k1 < 9;
                     k1++) {
                    j1 = (j1 << 1) + archiveCRCs[k1];
                }
                if (i1 != j1) {
                    s = "Checksum problem";
                    archiveCRCs[8] = 0;
                }
            } catch (EOFException _ex) {
                s = "EOF problem";
                archiveCRCs[8] = 0;
            } catch (IOException _ex) {
                s = "Connection problem";
                archiveCRCs[8] = 0;
            } catch (Exception _ex) {
                _ex.printStackTrace();
                s = "Logic problem";
                archiveCRCs[8] = 0;
                if (!SignLink.reporterror) {
                    return;
                }
            }
            if (archiveCRCs[8] == 0) {
                retries++;
                for (int k = wait; k > 0; k--) {
                    if (retries >= 10) {
                        showProgress(10, "Game updated - please reload page");
                        k = 10;
                    } else {
                        showProgress(10, s + " - Retrying...");
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception _ex) {
                    }
                }
                jaggrabEnabled = !jaggrabEnabled;
            }
        }
    }

    public void method28(int i) {
        try {
            if (i < 3 || i > 3) {
                planeObjStacks = null;
            }
            out.writePacket(93);
            if (sidebarComponentId != -1) {
                sidebarComponentId = -1;
                redrawInvback = true;
                continuedDialogue = false;
                redrawSideicons = true;
            }
            if (chatComponentId != -1) {
                chatComponentId = -1;
                redrawChatback = true;
                continuedDialogue = false;
            }
            viewportComponentId = -1;
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

    public void handleParentComponentInput(int x, int j, int mouseX, Component component, int y, int mouseY) {
        if (component.type != 0 || component.child == null || component.hidden) {
            return;
        }
        if (mouseX < x || mouseY < y || mouseX > x + component.width || mouseY > y + component.height) {
            return;
        }
        int children = component.child.length;
        for (int _child = 0; _child < children; _child++) {
            int childX = component.childX[_child] + x;
            int childY = (component.childY[_child] + y) - j;
            Component child = Component.instances[component.child[_child]];
            childX += child.x;
            childY += child.y;
            if ((child.delegateHover >= 0 || child.hoverColour != 0) && mouseX >= childX && mouseY >= childY && mouseX < childX + child.width && mouseY < childY + child.height) {
                if (child.delegateHover >= 0) {
                    lastHoveredComponentId = child.delegateHover;
                } else {
                    lastHoveredComponentId = child.id;
                }
            }
            if (child.type == 0) {
                handleParentComponentInput(childX, child.scrollY, mouseX, child, childY, mouseY);
                if (child.scrollHeight > child.height) {
                    updateScrollbar(childY, mouseX, child, childX + child.width, true, child.height, mouseY, child.scrollHeight);
                }
            } else {
                if (child.optionType == 1 && mouseX >= childX && mouseY >= childY && mouseX < childX + child.width && mouseY < childY + child.height) {
                    boolean flag = false;
                    if (child.contentType != 0) {
                        flag = method107(child, true);
                    }
                    if (!flag) {
                        menuOption[menuSize] = child.option;
                        menuAction[menuSize] = 231;
                        menuParamB[menuSize] = child.id;
                        menuSize++;
                    }
                }
                if (child.optionType == 2 && spellSelected == 0 && mouseX >= childX && mouseY >= childY && mouseX < childX + child.width && mouseY < childY + child.height) {
                    String prefix = child.spellAction;
                    if (prefix.contains(" ")) {
                        prefix = prefix.substring(0, prefix.indexOf(" "));
                    }
                    menuOption[menuSize] = prefix + " @gre@" + child.spellName;
                    menuAction[menuSize] = 274;
                    menuParamB[menuSize] = child.id;
                    menuSize++;
                }
                if (child.optionType == 3 && mouseX >= childX && mouseY >= childY && mouseX < childX + child.width && mouseY < childY + child.height) {
                    menuOption[menuSize] = "Close";
                    menuAction[menuSize] = 737;
                    menuParamB[menuSize] = child.id;
                    menuSize++;
                }
                if (child.optionType == 4 && mouseX >= childX && mouseY >= childY && mouseX < childX + child.width && mouseY < childY + child.height) {
                    menuOption[menuSize] = child.option;
                    menuAction[menuSize] = 435;
                    menuParamB[menuSize] = child.id;
                    menuSize++;
                }
                if (child.optionType == 5 && mouseX >= childX && mouseY >= childY && mouseX < childX + child.width && mouseY < childY + child.height) {
                    menuOption[menuSize] = child.option;
                    menuAction[menuSize] = 225;
                    menuParamB[menuSize] = child.id;
                    menuSize++;
                }
                if (child.optionType == 6 && !continuedDialogue && mouseX >= childX && mouseY >= childY && mouseX < childX + child.width && mouseY < childY + child.height) {
                    menuOption[menuSize] = child.option;
                    menuAction[menuSize] = 997;
                    menuParamB[menuSize] = child.id;
                    menuSize++;
                }
                if (child.type == 2) {
                    int slot = 0;
                    for (int row = 0; row < child.height; row++) {
                        for (int column = 0; column < child.width; column++) {
                            int slotLeft = childX + column * (32 + child.invMarginX);
                            int slotTop = childY + row * (32 + child.invMarginY);
                            if (slot < 20) {
                                slotLeft += child.invSlotX[slot];
                                slotTop += child.invSlotY[slot];
                            }
                            if (mouseX >= slotLeft && mouseY >= slotTop && mouseX < slotLeft + 32 && mouseY < slotTop + 32) {
                                moveItemSlotEnd = slot;
                                lastActiveInventoryInterface = child.id;
                                if (child.containerObjId[slot] > 0) {
                                    ObjType obj = ObjType.lookup(child.containerObjId[slot] - 1);
                                    if (objSelected == 1 && child.container) {
                                        if (child.id != moveIteminterfaceId || slot != lastItemSelectedSlot) {
                                            menuOption[menuSize] = "Use " + selectedObjName + " with @lre@" + obj.name;
                                            menuAction[menuSize] = 398;
                                            menuParamC[menuSize] = obj.id;
                                            menuParamA[menuSize] = slot;
                                            menuParamB[menuSize] = child.id;
                                            menuSize++;
                                        }
                                    } else if (spellSelected == 1 && child.container) {
                                        if ((spellUsableOn & 0x10) == 16) {
                                            menuOption[menuSize] = spellTooltip + " @lre@" + obj.name;
                                            menuAction[menuSize] = 563;
                                            menuParamC[menuSize] = obj.id;
                                            menuParamA[menuSize] = slot;
                                            menuParamB[menuSize] = child.id;
                                            menuSize++;
                                        }
                                    } else {
                                        if (child.container) {
                                            for (int action = 4; action >= 3; action--) {
                                                if (obj.actions != null && obj.actions[action] != null) {
                                                    menuOption[menuSize] = obj.actions[action] + " @lre@" + obj.name;
                                                    if (action == 3) {
                                                        menuAction[menuSize] = 681;
                                                    }
                                                    if (action == 4) {
                                                        menuAction[menuSize] = 100;
                                                    }
                                                    menuParamC[menuSize] = obj.id;
                                                    menuParamA[menuSize] = slot;
                                                    menuParamB[menuSize] = child.id;
                                                    menuSize++;
                                                } else if (action == 4) {
                                                    menuOption[menuSize] = "Drop @lre@" + obj.name;
                                                    menuAction[menuSize] = 100;
                                                    menuParamC[menuSize] = obj.id;
                                                    menuParamA[menuSize] = slot;
                                                    menuParamB[menuSize] = child.id;
                                                    menuSize++;
                                                }
                                            }
                                        }
                                        if (child.usableContainer) {
                                            menuOption[menuSize] = "Use @lre@" + obj.name;
                                            menuAction[menuSize] = 102;
                                            menuParamC[menuSize] = obj.id;
                                            menuParamA[menuSize] = slot;
                                            menuParamB[menuSize] = child.id;
                                            menuSize++;
                                        }
                                        if (child.container && obj.actions != null) {
                                            for (int action = 2; action >= 0; action--) {
                                                if (obj.actions[action] != null) {
                                                    menuOption[menuSize] = obj.actions[action] + " @lre@" + obj.name;
                                                    if (action == 0) {
                                                        menuAction[menuSize] = 694;
                                                    }
                                                    if (action == 1) {
                                                        menuAction[menuSize] = 962;
                                                    }
                                                    if (action == 2) {
                                                        menuAction[menuSize] = 795;
                                                    }
                                                    menuParamC[menuSize] = obj.id;
                                                    menuParamA[menuSize] = slot;
                                                    menuParamB[menuSize] = child.id;
                                                    menuSize++;
                                                }
                                            }
                                        }
                                        if (child.actions != null) {
                                            for (int action = 4; action >= 0; action--) {
                                                if (child.actions[action] != null) {
                                                    menuOption[menuSize] = child.actions[action] + " @lre@" + obj.name;
                                                    if (action == 0) {
                                                        menuAction[menuSize] = 582;
                                                    }
                                                    if (action == 1) {
                                                        menuAction[menuSize] = 113;
                                                    }
                                                    if (action == 2) {
                                                        menuAction[menuSize] = 555;
                                                    }
                                                    if (action == 3) {
                                                        menuAction[menuSize] = 331;
                                                    }
                                                    if (action == 4) {
                                                        menuAction[menuSize] = 354;
                                                    }
                                                    menuParamC[menuSize] = obj.id;
                                                    menuParamA[menuSize] = slot;
                                                    menuParamB[menuSize] = child.id;
                                                    menuSize++;
                                                }
                                            }
                                        }
                                        menuOption[menuSize] = "Examine @lre@" + obj.name;
                                        menuAction[menuSize] = 1328;
                                        menuParamC[menuSize] = obj.id;
                                        menuParamA[menuSize] = slot;
                                        menuParamB[menuSize] = child.id;
                                        menuSize++;
                                    }
                                }
                            }
                            slot++;
                        }
                    }
                }
            }
        }
    }

    public boolean processPackets(boolean flag) {
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
                    if (chatComponentId != -1) {
                        chatComponentId = -1;
                        redrawChatback = true;
                    }
                    if (chatbackInputType) {
                        chatbackInputType = false;
                        redrawChatback = true;
                    }
                    viewportComponentId = j;
                    sidebarComponentId = l9;
                    redrawInvback = true;
                    redrawSideicons = true;
                    continuedDialogue = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.CHAT_SETTINGS) {
                    publicChatSetting = in.readUnsignedByte();
                    privateChatMode = in.readUnsignedByte();
                    tradeChatSetting = in.readUnsignedByte();
                    redrawPrivacySettings = true;
                    redrawChatback = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.RUN_ENERGY) {
                    if (currentTab == 12) {
                        redrawInvback = true;
                    }
                    playerEnergy = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.WEIGHT_CARRIED) {
                    if (currentTab == 12) {
                        redrawInvback = true;
                    }
                    weightCarried = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == 59) {
                    int k = in.readUnsignedShort();
                    String s2 = in.readString();
                    Component.instances[k].text = s2;
                    if (Component.instances[k].anInt106 == tabComponentId[currentTab]) {
                        redrawInvback = true;
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
                    class5_5.x = i10;
                    class5_5.y = i15;
                    packetType = -1;
                    return true;
                }
                if (packetType == 252) {
                    int i1 = in.readUnsignedShort();
                    method104(i1, -44196);
                    if (chatComponentId != -1) {
                        chatComponentId = -1;
                        redrawChatback = true;
                    }
                    if (chatbackInputType) {
                        chatbackInputType = false;
                        redrawChatback = true;
                    }
                    sidebarComponentId = i1;
                    redrawInvback = true;
                    redrawSideicons = true;
                    viewportComponentId = -1;
                    continuedDialogue = false;
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
                    class5_3.seqId = j10;
                    if (j10 == -1) {
                        class5_3.seqFrame = 0;
                        class5_3.anInt104 = 0;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 136) {
                    minimapState = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == 91 || packetType == 117 || packetType == 83 || packetType == 176 || packetType == 233
                        || packetType == 87 || packetType == 71 || packetType == 60 || packetType == 106
                        || packetType == 194 || packetType == 90) {
                    processAreaPackets(in, packetType);
                    packetType = -1;
                    return true;
                }
                if (packetType == 28) {
                    int k1 = in.readUnsignedShort();
                    Component class5 = Component.instances[k1];
                    for (int j15 = 0; j15 < class5.containerObjId.length; j15++) {
                        class5.containerObjId[j15] = -1;
                        class5.containerObjId[j15] = 0;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 144) {
                    playerX = in.readUnsignedByte();
                    playerZ = in.readUnsignedByte();
                    for (int l1 = playerX; l1 < playerX + 8; l1++) {
                        for (int k10 = playerZ; k10 < playerZ + 8; k10++) {
                            if (planeObjStacks[plane][l1][k10] != null) {
                                planeObjStacks[plane][l1][k10] = null;
                                method92(l1, k10);
                            }
                        }
                    }
                    for (SceneLocTemporary class44_sub1 = (SceneLocTemporary) listTemporaryLocs.peekFront(); class44_sub1 != null; class44_sub1 = (SceneLocTemporary) listTemporaryLocs
                            .prev(false)) {
                        if (class44_sub1.sceneTileX >= playerX && class44_sub1.sceneTileX < playerX + 8
                                && class44_sub1.sceneTileZ >= playerZ && class44_sub1.sceneTileZ < playerZ + 8
                                && class44_sub1.plane == plane) {
                            class44_sub1.delayUntilRespawn = 0;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 154) {
                    redrawInvback = true;
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
                    flashingTab = in.readUnsignedByte();
                    if (flashingTab == currentTab) {
                        if (flashingTab == 3) {
                            currentTab = 1;
                        } else {
                            currentTab = 3;
                        }
                        redrawInvback = true;
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
                        cameraPositionY = anInt1119 * 128 + 64;
                        cameraPositionZ = getFloorDrawHeight(false, cameraPositionY, cameraPositionX, plane) - anInt1120;
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
                    logout();
                    packetType = -1;
                    return false;
                }
                if (packetType == 119) {
                    int k2 = in.readUnsignedShort();
                    method104(k2, -44196);
                    if (sidebarComponentId != -1) {
                        sidebarComponentId = -1;
                        redrawInvback = true;
                        redrawSideicons = true;
                    }
                    if (chatComponentId != -1) {
                        chatComponentId = -1;
                        redrawChatback = true;
                    }
                    if (chatbackInputType) {
                        chatbackInputType = false;
                        redrawChatback = true;
                    }
                    viewportComponentId = k2;
                    continuedDialogue = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == 168) {
                    long l2 = in.readLong();
                    int l15 = in.readUnsignedByte();
                    String s7 = TextUtils.formatName(TextUtils.longToName(l2));
                    for (int i21 = 0; i21 < friendCount; i21++) {
                        if (l2 != aLongArray979[i21]) {
                            continue;
                        }
                        if (friendWorld[i21] != l15) {
                            friendWorld[i21] = l15;
                            redrawInvback = true;
                            if (l15 > 0) {
                                renderText("", s7 + " has logged in.", 5);
                            }
                            if (l15 == 0) {
                                renderText("", s7 + " has logged out.", 5);
                            }
                        }
                        s7 = null;
                        break;
                    }
                    if (s7 != null && friendCount < 200) {
                        aLongArray979[friendCount] = l2;
                        friendName[friendCount] = s7;
                        friendWorld[friendCount] = l15;
                        friendCount++;
                        redrawInvback = true;
                    }
                    for (boolean flag6 = false; !flag6; ) {
                        flag6 = true;
                        for (int l24 = 0; l24 < friendCount - 1; l24++) {
                            if (friendWorld[l24] != Game.nodeId && friendWorld[l24 + 1] == Game.nodeId
                                    || friendWorld[l24] == 0 && friendWorld[l24 + 1] != 0) {
                                int i26 = friendWorld[l24];
                                friendWorld[l24] = friendWorld[l24 + 1];
                                friendWorld[l24 + 1] = i26;
                                String s10 = friendName[l24];
                                friendName[l24] = friendName[l24 + 1];
                                friendName[l24 + 1] = s10;
                                long l27 = aLongArray979[l24];
                                aLongArray979[l24] = aLongArray979[l24 + 1];
                                aLongArray979[l24 + 1] = l27;
                                redrawInvback = true;
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
                    long name = in.readLong();
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
                        for (int i25 = 0; i25 < ignoreCount; i25++) {
                            if (ignoreNameLong[i25] != name) {
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
                            String s8 = ChatCompression.readFromBytes((byte) -94, in, packetSize - 13);
                            s8 = ChatCensor.censor(s8);
                            if (playerRights == 2 || playerRights == 3) {
                                renderText("@cr2@" + TextUtils.formatName(TextUtils.longToName(name)), s8, 7
                                );
                            } else if (playerRights == 1) {
                                renderText("@cr1@" + TextUtils.formatName(TextUtils.longToName(name)), s8, 7
                                );
                            } else {
                                renderText(TextUtils.formatName(TextUtils.longToName(name)), s8, 3);
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
                    customCameraActive[cameraId] = true;
                    cameraJitter[cameraId] = jitter;
                    cameraAmplitude[cameraId] = amplitude;
                    cameraFrequency[cameraId] = frequency;
                    anIntArray1001[cameraId] = 0;
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.UPDATE_ITEMS) {
                    redrawInvback = true;
                    int id = in.readUnsignedShort();
                    Component component = Component.instances[id];
                    int itemCount = in.readUnsignedShort();
                    for (int slot = 0; slot < itemCount; slot++) {
                        component.containerObjId[slot] = in.readUnsignedShort();
                        int amount = in.readUnsignedByte();
                        if (amount == 255) {
                            amount = in.readInt();
                        }
                        component.containerItemAmount[slot] = amount;
                    }
                    for (int slot = itemCount; slot < component.containerObjId.length; slot++) {
                        component.containerObjId[slot] = 0;
                        component.containerItemAmount[slot] = 0;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 12) {
                    int k3 = in.readUnsignedByte();
                    chatOverlayComponentId = k3;
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
                    fontPlain.drawStringCenter(257, "Loading - please wait.", -31546, 0, 151);
                    fontPlain.drawStringCenter(256, "Loading - please wait.", -31546, 0xffffff, 150);
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
                                int mapLandFile = sceneMapLandFile[mapCount] = ondemand.getMapFile(0, mz, mx);
                                if (mapLandFile != -1) {
                                    ondemand.request(3, mapLandFile);
                                }
                                int mapLocFile = sceneMapLocFile[mapCount] = ondemand.getMapFile(1, mz, mx);
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
                    redrawInvback = true;
                    redrawSideicons = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == 184) {
                    int k4 = in.readUnsignedShort();
                    int i12 = in.readUnsignedShort();
                    Component class5_4 = Component.instances[k4];
                    if (class5_4 != null && class5_4.type == 0) {
                        if (i12 < 0) {
                            i12 = 0;
                        }
                        if (i12 > class5_4.scrollHeight - class5_4.height) {
                            i12 = class5_4.scrollHeight - class5_4.height;
                        }
                        class5_4.scrollY = i12;
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
                    lastAddress = in.readInt();
                    daysSinceLastLogin = in.readUnsignedShort();
                    daysSinceRecoveriesChanged = in.readUnsignedByte();
                    unreadMessages = in.readUnsignedShort();
                    warnMembersInNonmembers = in.readUnsignedByte();
                    if (lastAddress != 0 && viewportComponentId == -1) {
                        SignLink.dnslookup(TextUtils.method553(lastAddress, (byte) 1));
                        method28(3);
                        char c = '\u028A';
                        if (daysSinceRecoveriesChanged != 201 || warnMembersInNonmembers == 1) {
                            c = '\u028F';
                        }
                        reportAbuseInput = "";
                        reportAbuseMuteOption = false;
                        for (int j12 = 0; j12 < Component.instances.length; j12++) {
                            if (Component.instances[j12] == null || Component.instances[j12].contentType != c) {
                                continue;
                            }
                            viewportComponentId = Component.instances[j12].anInt106;
                            break;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == PacketConstants.incoming.INTERFACE_PLAYERHEAD) {
                    int l4 = in.readUnsignedShort();
                    Component.instances[l4].modelType = 3;
                    if (Game.localPlayer.npcAppearance == null) {
                        Component.instances[l4].modelTypeId = (Game.localPlayer.bodyPartColour[0] << 24)
                                + (Game.localPlayer.bodyPartColour[4] << 18)
                                + (Game.localPlayer.appearance[0] << 12)
                                + (Game.localPlayer.appearance[8] << 6)
                                + Game.localPlayer.appearance[11];
                    } else {
                        Component.instances[l4].modelTypeId = (int) (0x12345678L + Game.localPlayer.npcAppearance.uid);
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 23) {
                    if (sidebarComponentId != -1) {
                        sidebarComponentId = -1;
                        redrawInvback = true;
                        redrawSideicons = true;
                    }
                    if (chatComponentId != -1) {
                        chatComponentId = -1;
                        redrawChatback = true;
                    }
                    if (chatbackInputType) {
                        chatbackInputType = false;
                        redrawChatback = true;
                    }
                    viewportComponentId = -1;
                    continuedDialogue = false;
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
                        playerOptions[i5 - 1] = s6;
                        playerOptionPushDown[i5 - 1] = k12 == 0;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 189) {
                    currentTab = in.readUnsignedByte();
                    redrawInvback = true;
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
                        for (int l23 = 0; l23 < ignoreCount; l23++) {
                            if (ignoreNameLong[l23] != l17) {
                                continue;
                            }
                            flag3 = true;
                            break;
                        }
                        if (!flag3 && tutorial == 0) {
                            renderText(s3, "wishes to trade with you.", 4);
                        }
                    } else if (s.endsWith(":duelreq:")) {
                        String s4 = s.substring(0, s.indexOf(":"));
                        long l18 = TextUtils.encodeBase37(s4);
                        boolean flag4 = false;
                        for (int i24 = 0; i24 < ignoreCount; i24++) {
                            if (ignoreNameLong[i24] != l18) {
                                continue;
                            }
                            flag4 = true;
                            break;
                        }
                        if (!flag4 && tutorial == 0) {
                            renderText(s4, "wishes to duel with you.", 8);
                        }
                    } else if (s.endsWith(":chalreq:")) {
                        String s5 = s.substring(0, s.indexOf(":"));
                        long l19 = TextUtils.encodeBase37(s5);
                        boolean flag5 = false;
                        for (int j24 = 0; j24 < ignoreCount; j24++) {
                            if (ignoreNameLong[j24] != l19) {
                                continue;
                            }
                            flag5 = true;
                            break;
                        }
                        if (!flag5 && tutorial == 0) {
                            String s9 = s.substring(s.indexOf(":") + 1, s.length() - 9);
                            renderText(s5, s9, 8);
                        }
                    } else {
                        renderText("", s, 0);
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
                        ObjType class14 = ObjType.lookup(l12);
                        Component.instances[j5].modelType = 4;
                        Component.instances[j5].modelTypeId = l12;
                        Component.instances[j5].modelEyePitch = class14.anInt336;
                        Component.instances[j5].modelYaw = class14.anInt337;
                        Component.instances[j5].modelZoom = (class14.anInt335 * 100) / i17;
                        packetType = -1;
                        return true;
                    }
                }
                if (packetType == 187) {
                    int k5 = in.readUnsignedShort();
                    if (k5 == 65535) {
                        k5 = -1;
                    }
                    if (k5 != nextSong && aBoolean1057 && !Game.lowMemory && nextSongDelay == 0) {
                        song = k5;
                        musicFading = true;
                        ondemand.request(2, song);
                    }
                    nextSong = k5;
                    packetType = -1;
                    return true;
                }
                if (packetType == 29) {
                    int l5 = in.readUnsignedShort();
                    int i13 = in.readUnsignedShort();
                    if (aBoolean1057 && !Game.lowMemory) {
                        song = l5;
                        musicFading = false;
                        ondemand.request(2, song);
                        nextSongDelay = i13;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 177) {
                    int i6 = in.readUnsignedShort();
                    int j13 = in.readUnsignedByte();
                    int j17 = in.readUnsignedShort();
                    if (aBoolean1050 && !Game.lowMemory && waveCount < 50) {
                        anIntArray846[waveCount] = i6;
                        anIntArray1006[waveCount] = j13;
                        anIntArray1193[waveCount] = j17 + SoundTrack.anIntArray92[i6];
                        waveCount++;
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 112) {
                    playerX = in.readUnsignedByte();
                    playerZ = in.readUnsignedByte();
                    while (in.position < packetSize) {
                        int j6 = in.readUnsignedByte();
                        processAreaPackets(in, j6);
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 172) {
                    for (int k6 = 0; k6 < anIntArray1214.length; k6++) {
                        if (anIntArray1214[k6] != anIntArray1024[k6]) {
                            anIntArray1214[k6] = anIntArray1024[k6];
                            method147(true, k6);
                            redrawInvback = true;
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
                    Component.instances[l6].colour = (k17 << 19) + (j20 << 11) + (j22 << 3);
                    packetType = -1;
                    return true;
                }
                if (packetType == 47) {
                    ignoreCount = packetSize / 8;
                    for (int i7 = 0; i7 < ignoreCount; i7++) {
                        ignoreNameLong[i7] = in.readLong();
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
                    viewportOverlayComponentId = k7;
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
                        redrawInvback = true;
                        if (chatOverlayComponentId != -1) {
                            redrawChatback = true;
                        }
                    }
                    packetType = -1;
                    return true;
                }

                if (packetType == 81) {
                    int j8 = in.readUnsignedShort();
                    method104(j8, -44196);
                    if (sidebarComponentId != -1) {
                        sidebarComponentId = -1;
                        redrawInvback = true;
                        redrawSideicons = true;
                    }
                    chatComponentId = j8;
                    redrawChatback = true;
                    viewportComponentId = -1;
                    continuedDialogue = false;
                    packetType = -1;
                    return true;
                }
                if (packetType == 138) {
                    int k8 = in.readUnsignedShort();
                    boolean flag1 = in.readUnsignedByte() == 1;
                    Component.instances[k8].hidden = flag1;
                    packetType = -1;
                    return true;
                }
                if (packetType == 247) {
                    multiCombatZone = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                if (packetType == 235) {
                    friendlistStatus = in.readUnsignedByte();
                    redrawInvback = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == 76) {
                    redrawInvback = true;
                    int l8 = in.readUnsignedShort();
                    Component class5_2 = Component.instances[l8];
                    while (in.position < packetSize) {
                        int j18 = in.method496();
                        int l20 = in.readUnsignedShort();
                        int l22 = in.readUnsignedByte();
                        if (l22 == 255) {
                            l22 = in.readInt();
                        }
                        if (j18 >= 0 && j18 < class5_2.containerObjId.length) {
                            class5_2.containerObjId[j18] = l20;
                            class5_2.containerItemAmount[j18] = l22;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 201) {
                    for (int i9 = 0; i9 < players.length; i9++) {
                        if (players[i9] != null) {
                            players[i9].primarySeq = -1;
                        }
                    }
                    for (int j14 = 0; j14 < npcs.length; j14++) {
                        if (npcs[j14] != null) {
                            npcs[j14].primarySeq = -1;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 35) {
                    showSocialInput = false;
                    chatbackInputType = true;
                    chatBackInput = "";
                    redrawChatback = true;
                    packetType = -1;
                    return true;
                }
                if (packetType == 133) {
                    cutsceneActive = false;
                    for (int j9 = 0; j9 < 5; j9++) {
                        customCameraActive[j9] = false;
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
                        redrawInvback = true;
                        if (chatOverlayComponentId != -1) {
                            redrawChatback = true;
                        }
                    }
                    packetType = -1;
                    return true;
                }
                if (packetType == 155) {
                    playerX = in.readUnsignedByte();
                    playerZ = in.readUnsignedByte();
                    packetType = -1;
                    return true;
                }
                SignLink.reporterror("T1 - " + packetType + "," + packetSize + " - " + secondOpcode + "," + thirdOpcode);
                logout();
            } catch (IOException _ex) {
                attemptReconnect((byte) 7);
            } catch (Exception exception) {
                exception.printStackTrace();
                String s1 = "T2 - " + packetType + "," + secondOpcode + "," + thirdOpcode + " - " + packetSize + ","
                        + (sceneBaseTileX + Game.localPlayer.pathTileX[0]) + ","
                        + (sceneBaseTileZ + Game.localPlayer.pathTileZ[0]) + " - ";
                for (int l14 = 0; l14 < packetSize && l14 < 50; l14++) {
                    s1 = s1 + in.payload[l14] + ",";
                }
                SignLink.reporterror(s1);
                logout();
            }
            return true;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("74182, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void loadError(String s) {
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

    public Socket openSocket(int i) throws IOException {
        if (SignLink.mainapp != null) {
            return SignLink.opensocket(i);
        } else {
            return new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        }
    }

    @Override
    public void startUp() {
        showProgress(20, "Starting up");
        if (SignLink.sunjava) {
            super.mindel = 5;
        }
        if (Game.started) {
            errorStarted = true;
            return;
        }
        Game.started = true;
        boolean flag = false;
        String address = "127.0.0.1";
        if (SignLink.cache_dat != null) {
            for (int indexes = 0; indexes < 5; indexes++) {
                filestores[indexes] = new FileStore(SignLink.cache_dat, 0x7a120, SignLink.cache_idx[indexes], indexes + 1, (byte) 4);
            }
        }
        try {
            loadArchiveChecksums();
            titleArchive = loadArchive(1, "title screen", "title", archiveCRCs[1], 25);
            fontSmall = new BitmapFont(9, "p11_full", false, titleArchive);
            fontPlain = new BitmapFont(9, "p12_full", false, titleArchive);
            fontBold = new BitmapFont(9, "b12_full", false, titleArchive);
            fontQuill = new BitmapFont(9, "q8_full", true, titleArchive);
            createTitleBackground();
            loadTitleImages();
            FileArchive configArchive = loadArchive(2, "config", "config", archiveCRCs[2], 30);
            FileArchive interfaceArchive = loadArchive(3, "interface", "interface", archiveCRCs[3], 35);
            FileArchive mediaArchive = loadArchive(4, "2d graphics", "media", archiveCRCs[4], 40);
            FileArchive textureArchive = loadArchive(6, "textures", "textures", archiveCRCs[6], 45);
            FileArchive wordencArchive = loadArchive(7, "chat system", "wordenc", archiveCRCs[7], 50);
            FileArchive soundsArchive = loadArchive(8, "sound effects", "sounds", archiveCRCs[8], 55);
            planeTileFlags = new byte[4][104][104];
            planeHeightMap = new int[4][105][105];
            scene = new Scene(104, 104, 4, planeHeightMap);
            for (int plane = 0; plane < 4; plane++) {
                collisions[plane] = new CollisionMap(99, 104, 104);
            }
            minimap = new Image24(512, 512);
            FileArchive versionlistArchive = loadArchive(5, "update list", "versionlist", archiveCRCs[5], 60);
            showProgress(60, "Connecting to update server");
            ondemand = new OnDemandRequester();
            ondemand.load(versionlistArchive, this);
            SeqFrame.init(ondemand.getSeqFrameCount());
            Model.init(ondemand.getFileCount(0), ondemand);
            if (!Game.lowMemory) {
                song = 0;
                try {
                    song = Integer.parseInt(getParameter("music"));
                } catch (Exception _ex) {
                }
                musicFading = true;
                ondemand.request(2, song);
                while (ondemand.remaining() > 0) {
                    handleOnDemandRequests();
                    try {
                        Thread.sleep(100L);
                    } catch (Exception _ex) {
                    }
                    if (ondemand.failedRequests > 3) {
                        loadError("ondemand");
                        return;
                    }
                }
            }
            showProgress(65, "Requesting animations");
            int totalFiles = ondemand.getFileCount(1);
            for (int file = 0; file < totalFiles; file++) {
                ondemand.request(1, file);
            }
            while (ondemand.remaining() > 0) {
                int done = totalFiles - ondemand.remaining();
                if (done > 0) {
                    showProgress(65, "Loading animations - " + (done * 100) / totalFiles + "%");
                }
                handleOnDemandRequests();
                try {
                    Thread.sleep(100L);
                } catch (Exception _ex) {
                }
                if (ondemand.failedRequests > 3) {
                    loadError("ondemand");
                    return;
                }
            }
            showProgress(70, "Requesting models");
            totalFiles = ondemand.getFileCount(0);
            for (int file = 0; file < totalFiles; file++) {
                int flags = ondemand.getModelFlags(file);
                if ((flags & 1) != 0) {
                    ondemand.request(0, file);
                }
            }
            totalFiles = ondemand.remaining();
            while (ondemand.remaining() > 0) {
                int done = totalFiles - ondemand.remaining();
                if (done > 0) {
                    showProgress(70, "Loading models - " + (done * 100) / totalFiles + "%");
                }
                handleOnDemandRequests();
                try {
                    Thread.sleep(100L);
                } catch (Exception _ex) {
                }
            }
            if (filestores[0] != null) {
                showProgress(75, "Requesting maps");
                ondemand.request(3, ondemand.getMapFile(0, 48, 47));
                ondemand.request(3, ondemand.getMapFile(1, 48, 47));
                ondemand.request(3, ondemand.getMapFile(0, 48, 48));
                ondemand.request(3, ondemand.getMapFile(1, 48, 48));
                ondemand.request(3, ondemand.getMapFile(0, 48, 49));
                ondemand.request(3, ondemand.getMapFile(1, 48, 49));
                ondemand.request(3, ondemand.getMapFile(0, 47, 47));
                ondemand.request(3, ondemand.getMapFile(1, 47, 47));
                ondemand.request(3, ondemand.getMapFile(0, 47, 48));
                ondemand.request(3, ondemand.getMapFile(1, 47, 48));
                ondemand.request(3, ondemand.getMapFile(0, 148, 48));
                ondemand.request(3, ondemand.getMapFile(1, 148, 48));
                totalFiles = ondemand.remaining();
                while (ondemand.remaining() > 0) {
                    int done = totalFiles - ondemand.remaining();
                    if (done > 0) {
                        showProgress(75, "Loading maps - " + (done * 100) / totalFiles + "%");
                    }
                    handleOnDemandRequests();
                    try {
                        Thread.sleep(100L);
                    } catch (Exception _ex) {
                    }
                }
            }
            totalFiles = ondemand.getFileCount(0);
            for (int file = 0; file < totalFiles; file++) {
                int flags = ondemand.getModelFlags(file);
                byte priority = 0;
                if ((flags & 8) != 0) {
                    priority = 10;
                } else if ((flags & 0x20) != 0) {
                    priority = 9;
                } else if ((flags & 0x10) != 0) {
                    priority = 8;
                } else if ((flags & 0x40) != 0) {
                    priority = 7;
                } else if ((flags & 0x80) != 0) {
                    priority = 6;
                } else if ((flags & 2) != 0) {
                    priority = 5;
                } else if ((flags & 4) != 0) {
                    priority = 4;
                }
                if ((flags & 1) != 0) {
                    priority = 3;
                }
                if (priority != 0) {
                    ondemand.prefetch(priority, file, 0);
                }
            }
            ondemand.prefetchMaps(false, Game.membersWorld);
            if (!Game.lowMemory) {
                totalFiles = ondemand.getFileCount(2);
                for (int file = 1; file < totalFiles; file++) {
                    if (ondemand.exists(file)) {
                        ondemand.prefetch((byte) 1, file, 2);
                    }
                }
            }
            showProgress(80, "Unpacking media");
            invbackImage = new Image8(mediaArchive, "invback", 0);
            chatbackImage = new Image8(mediaArchive, "chatback", 0);
            mapbackImage = new Image8(mediaArchive, "mapback", 0);
            backbase1Image = new Image8(mediaArchive, "backbase1", 0);
            backbase2Image = new Image8(mediaArchive, "backbase2", 0);
            backhmid1Image = new Image8(mediaArchive, "backhmid1", 0);
            for (int i = 0; i < 13; i++) {
                sideicons[i] = new Image8(mediaArchive, "sideicons", i);
            }
            compassImage = new Image24(mediaArchive, "compass", 0);
            mapedgeImage = new Image24(mediaArchive, "mapedge", 0);
            try {
                for (int i = 0; i < 100; i++) {
                    mapscenes[i] = new Image8(mediaArchive, "mapscene", i);
                }
            } catch (Exception _ex) {
            }
            try {
                for (int i = 0; i < 100; i++) {
                    mapfunctions[i] = new Image24(mediaArchive, "mapfunction", i);
                }
            } catch (Exception _ex) {
            }
            try {
                for (int i = 0; i < 20; i++) {
                    hitmarks[i] = new Image24(mediaArchive, "hitmarks", i);
                }
            } catch (Exception _ex) {
            }
            try {
                for (int i = 0; i < 20; i++) {
                    headicons[i] = new Image24(mediaArchive, "headicons", i);
                }
            } catch (Exception _ex) {
            }
            mapmarker0Image = new Image24(mediaArchive, "mapmarker", 0);
            mapmarker1Image = new Image24(mediaArchive, "mapmarker", 1);
            for (int i = 0; i < 8; i++) {
                crosses[i] = new Image24(mediaArchive, "cross", i);
            }
            mapdot0Image = new Image24(mediaArchive, "mapdots", 0);
            mapdot1Image = new Image24(mediaArchive, "mapdots", 1);
            mapdot2Image = new Image24(mediaArchive, "mapdots", 2);
            mapdot3Image = new Image24(mediaArchive, "mapdots", 3);
            scrollbar0Image = new Image8(mediaArchive, "scrollbar", 0);
            scrollbar1Image = new Image8(mediaArchive, "scrollbar", 1);
            redstone0Image = new Image8(mediaArchive, "redstone1", 0);
            redstone1Image = new Image8(mediaArchive, "redstone2", 0);
            redstone2Image = new Image8(mediaArchive, "redstone3", 0);
            redstone3Image = new Image8(mediaArchive, "redstone1", 0);
            redstone3Image.flipH();
            redstone4Image = new Image8(mediaArchive, "redstone2", 0);
            redstone4Image.flipH();
            redstone5Image = new Image8(mediaArchive, "redstone1", 0);
            redstone5Image.flipV();
            redstone6Image = new Image8(mediaArchive, "redstone2", 0);
            redstone6Image.flipV();
            redstone7Image = new Image8(mediaArchive, "redstone3", 0);
            redstone7Image.flipV();
            redstone8Image = new Image8(mediaArchive, "redstone1", 0);
            redstone8Image.flipH();
            redstone8Image.flipV();
            redstone9Image = new Image8(mediaArchive, "redstone2", 0);
            redstone9Image.flipH();
            redstone9Image.flipV();
            for (int i = 0; i < 2; i++) {
                modicons[i] = new Image8(mediaArchive, "mod_icons", i);
            }
            Image24 backleft1Image = new Image24(mediaArchive, "backleft1", 0);
            backleft1Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            backleft1Image = new Image24(mediaArchive, "backleft2", 0);
            backleft2Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            backleft1Image = new Image24(mediaArchive, "backright1", 0);
            backright1Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            backleft1Image = new Image24(mediaArchive, "backright2", 0);
            backright2Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            backleft1Image = new Image24(mediaArchive, "backtop1", 0);
            backtop1Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            backleft1Image = new Image24(mediaArchive, "backvmid1", 0);
            backvmid1Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            backleft1Image = new Image24(mediaArchive, "backvmid2", 0);
            backvmid2Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            backleft1Image = new Image24(mediaArchive, "backvmid3", 0);
            backvmid3Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            backleft1Image = new Image24(mediaArchive, "backhmid2", 0);
            backhmid2Area = new DrawArea(backleft1Image.width, backleft1Image.height);
            backleft1Image.blitOpaque(0, 0);
            int red = (int) (Math.random() * 21D) - 10;
            int green = (int) (Math.random() * 21D) - 10;
            int blue = (int) (Math.random() * 21D) - 10;
            int value = (int) (Math.random() * 41D) - 20;
            for (int i = 0; i < 100; i++) {
                if (mapfunctions[i] != null) {
                    mapfunctions[i].translate(red + value, green + value, blue + value);
                }
                if (mapscenes[i] != null) {
                    mapscenes[i].translate(red + value, green + value, blue + value);
                }
            }
            showProgress(83, "Unpacking textures");
            Draw3D.unpackTextures(textureArchive);
            Draw3D.setBrightness(0.80000000000000004D);
            Draw3D.initPool(20);
            showProgress(86, "Unpacking config");
            SeqType.unpack(configArchive);
            LocType.unpack(configArchive);
            FloType.unpack(configArchive);
            ObjType.unpack(configArchive);
            NpcType.unpack(configArchive);
            IdkType.unpack(configArchive);
            SpotAnimType.unpack(configArchive);
            VarpType.unpack(configArchive);
            VarBit.unpack(configArchive);

            ObjType.members = Game.membersWorld;

            if (!Game.lowMemory) {
                try {
                    showProgress(90, "Unpacking sounds");
                    byte[] soundData = soundsArchive.read("sounds.dat");
                    Buffer soundsBuffer = new Buffer(soundData);
                    SoundTrack.load(soundsBuffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            showProgress(95, "Unpacking interfaces");
            BitmapFont[] fonts = {fontSmall, fontPlain,
                    fontBold, fontQuill};
            Component.unpack(fonts, mediaArchive, interfaceArchive);
            showProgress(100, "Preparing game engine");
            for (int y = 0; y < 33; y++) {
                int left = 999;
                int right = 0;
                for (int x = 0; x < 34; x++) {
                    if (mapbackImage.pixels[x + y * mapbackImage.width] == 0) {
                        if (left == 999) {
                            left = x;
                        }
                        continue;
                    }
                    if (left == 999) {
                        continue;
                    }
                    right = x;
                    break;
                }
                compassMaskLineOffsets[y] = left;
                compassMaskLineLengths[y] = right - left;
            }
            for (int y = 5; y < 156; y++) {
                int left = 999;
                int right = 0;
                for (int x = 25; x < 172; x++) {
                    if (mapbackImage.pixels[x + y * mapbackImage.width] == 0 && (x > 34 || y > 34)) {
                        if (left == 999) {
                            left = x;
                        }
                        continue;
                    }
                    if (left == 999) {
                        continue;
                    }
                    right = x;
                    break;
                }
                minimapMaskLineOffsets[y - 5] = left - 25;
                minimapMaskLineLengths[y - 5] = right - left;
            }
            Draw3D.init3D(96, 479);
            areaChatbackOffsets = Draw3D.lineOffset;
            Draw3D.init3D(261, 190);
            areaInvbackOffsets = Draw3D.lineOffset;
            Draw3D.init3D(334, 512);
            areaViewportOffsets = Draw3D.lineOffset;

            int[] pitchZ = new int[9];
            for (int n = 0; n < 9; n++) {
                int angle = 128 + n * 32 + 15;
                int zoom = 600 + angle * 3;
                int sin = Draw3D.sin[angle];
                pitchZ[n] = zoom * sin >> 16;
            }
            Scene.init(pitchZ, 500, 334, 3, 800, 512);
            ChatCensor.unpack(wordencArchive);
            mouseCapturer = new MouseCapturer(228, this);
            startThread(mouseCapturer, 10);
            GameObject.game = this;
            return;
        } catch (Exception exception) {
            SignLink.reporterror("loaderror " + message + " " + percent);
        }
        errorLoading = true;
    }

    public void method35(boolean flag) {
        try {
            aBoolean893 = true;
            try {
                long l = System.currentTimeMillis();
                int i = 0;
                int j = 20;
                while (flameActive) {
                    anInt945++;
                    updateFlames(699);
                    updateFlames(699);
                    drawFlames();
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
            if (minimapState == 2) {
                byte[] abyte0 = mapbackImage.pixels;
                int[] ai = Draw2D.pixels;
                int l2 = abyte0.length;
                for (int j5 = 0; j5 < l2; j5++) {
                    if (abyte0[j5] == 0) {
                        ai[j5] = 0;
                    }
                }
                compassImage.method444(compassMaskLineOffsets, 0, 25, 256, cameraHorizontal, 33, compassMaskLineLengths, 33, -687,
                        25, 0);
                areaViewport.bind();
                return;
            }
            int j = cameraHorizontal + minimapAnticheatAngle & 0x7ff;
            int k = 48 + Game.localPlayer.x / 32;
            int i3 = 464 - Game.localPlayer.z / 32;
            minimap.method444(minimapMaskLineOffsets, 5, i3, 256 + minimapZoom, j, 151, minimapMaskLineLengths, 146,
                    -687, k, 25);
            compassImage.method444(compassMaskLineOffsets, 0, 25, 256, cameraHorizontal, 33, compassMaskLineLengths, 33, -687, 25,
                    0);
            for (int k5 = 0; k5 < activeMapfunctionCount; k5++) {
                int l = (activeMapfunctionsX[k5] * 4 + 2) - Game.localPlayer.x
                        / 32;
                int j3 = (activeMapfunctionsZ[k5] * 4 + 2) - Game.localPlayer.z
                        / 32;
                method141(l, activeMapfunctions[k5], 139, j3);
            }
            for (int l5 = 0; l5 < 104; l5++) {
                for (int i6 = 0; i6 < 104; i6++) {
                    LinkedList class28 = planeObjStacks[plane][l5][i6];
                    if (class28 != null) {
                        int i1 = (l5 * 4 + 2) - Game.localPlayer.x / 32;
                        int k3 = (i6 * 4 + 2) - Game.localPlayer.z / 32;
                        method141(i1, mapdot0Image, 139, k3);
                    }
                }
            }
            packetSize += i;
            for (int j6 = 0; j6 < npcCount; j6++) {
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[anIntArray1010[j6]];
                if (class44_sub3_sub4_sub6_sub2 != null && class44_sub3_sub4_sub6_sub2.method535(true)
                        && class44_sub3_sub4_sub6_sub2.aClass12_1700.aBoolean298) {
                    int j1 = class44_sub3_sub4_sub6_sub2.x / 32
                            - Game.localPlayer.x / 32;
                    int l3 = class44_sub3_sub4_sub6_sub2.z / 32
                            - Game.localPlayer.z / 32;
                    method141(j1, mapdot1Image, 139, l3);
                }
            }
            for (int k6 = 0; k6 < playerCount; k6++) {
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[anIntArray1227[k6]];
                if (class44_sub3_sub4_sub6_sub1 != null && class44_sub3_sub4_sub6_sub1.method535(true)) {
                    int k1 = class44_sub3_sub4_sub6_sub1.x / 32
                            - Game.localPlayer.x / 32;
                    int i4 = class44_sub3_sub4_sub6_sub1.z / 32
                            - Game.localPlayer.z / 32;
                    boolean flag = false;
                    long l6 = TextUtils.encodeBase37(class44_sub3_sub4_sub6_sub1.name);
                    for (int i7 = 0; i7 < friendCount; i7++) {
                        if (l6 != aLongArray979[i7] || friendWorld[i7] == 0) {
                            continue;
                        }
                        flag = true;
                        break;
                    }
                    if (Game.localPlayer.team != 0
                            && class44_sub3_sub4_sub6_sub1.team != 0) {
                        flag = Game.localPlayer.team == class44_sub3_sub4_sub6_sub1.team;
                    }
                    if (flag) {
                        method141(k1, mapdot3Image, 139, i4);
                    } else {
                        method141(k1, mapdot2Image, 139, i4);
                    }
                }
            }
            if (hintIconType != 0 && Game.loopCycle % 20 < 10) {
                if (hintIconType == 1 && anInt901 >= 0 && anInt901 < npcs.length) {
                    NPCEntity class44_sub3_sub4_sub6_sub2_1 = npcs[anInt901];
                    if (class44_sub3_sub4_sub6_sub2_1 != null) {
                        int l1 = class44_sub3_sub4_sub6_sub2_1.x / 32
                                - Game.localPlayer.x / 32;
                        int j4 = class44_sub3_sub4_sub6_sub2_1.z / 32
                                - Game.localPlayer.z / 32;
                        method15(l1, mapmarker1Image, j4, anInt834);
                    }
                }
                if (hintIconType == 2) {
                    int i2 = ((anInt1248 - sceneBaseTileX) * 4 + 2)
                            - Game.localPlayer.x / 32;
                    int k4 = ((anInt1249 - sceneBaseTileZ) * 4 + 2)
                            - Game.localPlayer.z / 32;
                    method15(i2, mapmarker1Image, k4, anInt834);
                }
                if (hintIconType == 10 && anInt909 >= 0 && anInt909 < players.length) {
                    PlayerEntity class44_sub3_sub4_sub6_sub1_1 = players[anInt909];
                    if (class44_sub3_sub4_sub6_sub1_1 != null) {
                        int j2 = class44_sub3_sub4_sub6_sub1_1.x / 32
                                - Game.localPlayer.x / 32;
                        int l4 = class44_sub3_sub4_sub6_sub1_1.z / 32
                                - Game.localPlayer.z / 32;
                        method15(j2, mapmarker1Image, l4, anInt834);
                    }
                }
            }
            if (flagSceneTileX != 0) {
                int k2 = (flagSceneTileX * 4 + 2) - Game.localPlayer.x / 32;
                int i5 = (flagSceneTileZ * 4 + 2) - Game.localPlayer.z / 32;
                method141(k2, mapmarker0Image, 139, i5);
            }
            Draw2D.fillRect(97, 78, 3, 3, 0xffffff, 210);
            areaViewport.bind();
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("47037, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void drawComponent(Component parent, int k, int scrollY, int l) {
        if (parent.type != 0 || parent.child == null) {
            return;
        }
        if (parent.hidden && viewportHoveredComponentId != parent.id && invbackHoveredComponentId != parent.id && chatbackHoveredComponentId != parent.id) {
            return;
        }
        int left = Draw2D.left;
        int top = Draw2D.top;
        int right = Draw2D.right;
        int bottom = Draw2D.bottom;

        Draw2D.setBounds(k + parent.width, l + parent.height, l, k);

        int children = parent.child.length;
        for (int i = 0; i < children; i++) {
            int x = parent.childX[i] + k;
            int y = (parent.childY[i] + l) - scrollY;
            Component child = Component.instances[parent.child[i]];
            x += child.x;
            y += child.y;

            if (child.contentType > 0) {
                updateComponentContent(child);
            }
            if (child.type == 0) {
                if (child.scrollY > child.scrollHeight - child.height) {
                    child.scrollY = child.scrollHeight - child.height;
                }
                if (child.scrollY < 0) {
                    child.scrollY = 0;
                }
                drawComponent(child, x, child.scrollY, y);
                if (child.scrollHeight > child.height) {
                    drawScrollbar(x + child.width, y, child.scrollY, child.scrollHeight, child.height);
                }
            } else if (child.type != 1) {
                if (child.type == 2) {
                    int slot = 0;
                    for (int row = 0; row < child.height; row++) {
                        for (int column = 0; column < child.width; column++) {
                            int slotX = x + column * (32 + child.invMarginX);
                            int slotY = y + row * (32 + child.invMarginY);
                            if (slot < 20) {
                                slotX += child.invSlotX[slot];
                                slotY += child.invSlotY[slot];
                            }
                            if (child.containerObjId[slot] > 0) {
                                int dx = 0;
                                int dy = 0;
                                int objId = child.containerObjId[slot] - 1;
                                if (slotX > Draw2D.left - 32 && slotX < Draw2D.right && slotY > Draw2D.top - 32 && slotY < Draw2D.bottom || objDragArea != 0 && objDragSlot == slot) {
                                    int outlineColour = 0;
                                    if (objSelected == 1 && lastItemSelectedSlot == slot && moveIteminterfaceId == child.id) {
                                        outlineColour = 0xffffff;
                                    }
                                    Image24 ObjIcon = ObjType.fetchIcon(objId, outlineColour, child.containerItemAmount[slot]);
                                    if (ObjIcon != null) {
                                        if (objDragArea != 0 && objDragSlot == slot && objDragComponentId == child.id) {
                                            dx = super.mouseX - objGrabX;
                                            dy = super.mouseY - objGrabY;
                                            if (dx < 5 && dx > -5) {
                                                dx = 0;
                                            }
                                            if (dy < 5 && dy > -5) {
                                                dy = 0;
                                            }
                                            if (objDragCycles < 5) {
                                                dx = 0;
                                                dy = 0;
                                            }
                                            ObjIcon.draw(slotX + dx, slotY + dy, 128);
                                            if (slotY + dy < Draw2D.top && parent.scrollY > 0) {
                                                int scroll = (delta * (Draw2D.top - slotY - dy)) / 3;
                                                if (scroll > delta * 10) {
                                                    scroll = delta * 10;
                                                }
                                                if (scroll > parent.scrollY) {
                                                    scroll = parent.scrollY;
                                                }
                                                parent.scrollY -= scroll;
                                                objGrabY += scroll;
                                            }
                                            if (slotY + dy + 32 > Draw2D.bottom
                                                    && parent.scrollY < parent.scrollHeight - parent.height) {
                                                int scroll = (delta * ((slotY + dy + 32) - Draw2D.bottom)) / 3;
                                                if (scroll > delta * 10) {
                                                    scroll = delta * 10;
                                                }
                                                if (scroll > parent.scrollHeight - parent.height - parent.scrollY) {
                                                    scroll = parent.scrollHeight - parent.height - parent.scrollY;
                                                }
                                                parent.scrollY += scroll;
                                                objGrabY -= scroll;
                                            }
                                        } else if (containerComponentType != 0 && containerIndex == slot && containerComponentId == child.id) {
                                            ObjIcon.draw(slotX, slotY, 128);
                                        } else {
                                            ObjIcon.draw(slotX, slotY);
                                        }
                                        if (ObjIcon.cropWidth == 33 || child.containerItemAmount[slot] != 1) {
                                            int amount = child.containerItemAmount[slot];
                                            fontSmall.drawText(Game.formatObjAmount(amount), slotY + 10 + dy, slotX + 1 + dx, 0);
                                            fontSmall.drawText(Game.formatObjAmount(amount), slotY + 9 + dy, slotX + dx, 0xffff00);
                                        }
                                    }
                                }
                            } else if (child.invSlotImage != null && slot < 20) {
                                Image24 image = child.invSlotImage[slot];
                                if (image != null) {
                                    image.draw(slotX, slotY);
                                }
                            }
                            slot++;
                        }
                    }
                } else if (child.type == 3) {
                    boolean hovered = chatbackHoveredComponentId == child.id || invbackHoveredComponentId == child.id || viewportHoveredComponentId == child.id;
                    int rgb;
                    if (getComponentScriptState(child)) {
                        rgb = child.activeColour;
                        if (hovered && child.activeHoverColour != 0) {
                            rgb = child.activeHoverColour;
                        }
                    } else {
                        rgb = child.colour;
                        if (hovered && child.hoverColour != 0) {
                            rgb = child.hoverColour;
                        }
                    }
                    if (child.transparency == 0) {
                        if (child.fill) {
                            Draw2D.fillRect(x, y, child.width, child.height, rgb, 210);
                        } else {
                            Draw2D.drawRect(x, y, child.width, child.height, rgb, 1);
                        }
                    } else if (child.fill) {
                        Draw2D.fillRect(y, child.height, 256 - (child.transparency & 0xff), rgb,
                                child.width, x, false);
                    } else {
                        Draw2D.drawRect(child.height, rgb, x, child.width,
                                256 - (child.transparency & 0xff), y, 0);
                    }
                } else if (child.type == 4) {
                    BitmapFont font = child.font;
                    String text = child.text;
                    boolean hovered = chatbackHoveredComponentId == child.id || invbackHoveredComponentId == child.id || viewportHoveredComponentId == child.id;

                    int rgb;

                    if (getComponentScriptState(child)) {
                        rgb = child.activeColour;
                        if (hovered && child.activeHoverColour != 0) {
                            rgb = child.activeHoverColour;
                        }
                        if (child.activeText.length() > 0) {
                            text = child.activeText;
                        }
                    } else {
                        rgb = child.colour;
                        if (hovered && child.hoverColour != 0) {
                            rgb = child.hoverColour;
                        }
                    }
                    if (child.optionType == 6 && continuedDialogue) {
                        text = "Please wait...";
                        rgb = child.colour;
                    }
                    if (Draw2D.width == 479) {
                        if (rgb == 0xffff00) {
                            rgb = 255;
                        }
                        if (rgb == 49152) {
                            rgb = 0xffffff;
                        }
                    }
                    for (int lineY = y + font.height; text.length() > 0; lineY += font.height) {
                        if (text.contains("%")) {
                            do {
                                int opcode = text.indexOf("%1");
                                if (opcode == -1) {
                                    break;
                                }
                                text = text.substring(0, opcode) + getIntString(executeClientScript(child, 0)) + text.substring(opcode + 2);
                            } while (true);
                            do {
                                int opcode = text.indexOf("%2");
                                if (opcode == -1) {
                                    break;
                                }
                                text = text.substring(0, opcode) + getIntString(executeClientScript(child, 1)) + text.substring(opcode + 2);
                            } while (true);
                            do {
                                int opcode = text.indexOf("%3");
                                if (opcode == -1) {
                                    break;
                                }
                                text = text.substring(0, opcode) + getIntString(executeClientScript(child, 2)) + text.substring(opcode + 2);
                            } while (true);
                            do {
                                int opcode = text.indexOf("%4");
                                if (opcode == -1) {
                                    break;
                                }
                                text = text.substring(0, opcode) + getIntString(executeClientScript(child, 3)) + text.substring(opcode + 2);
                            } while (true);
                            do {
                                int opcode = text.indexOf("%5");
                                if (opcode == -1) {
                                    break;
                                }
                                text = text.substring(0, opcode) + getIntString(executeClientScript(child, 4)) + text.substring(opcode + 2);
                            } while (true);
                        }
                        int newLine = text.indexOf("\\n");
                        String split;
                        if (newLine != -1) {
                            split = text.substring(0, newLine);
                            text = text.substring(newLine + 2);
                        } else {
                            split = text;
                            text = "";
                        }
                        if (child.center) {
                            font.drawStringTaggableCenter(split, x + child.width / 2, lineY, rgb, child.shadow);
                        } else {
                            font.drawStringTaggable(split, x, lineY, rgb, child.shadow);
                        }
                    }

                } else if (child.type == 5) {
                    Image24 image;
                    if (getComponentScriptState(child)) {
                        image = child.activeImage;
                    } else {
                        image = child.image;
                    }
                    if (image != null) {
                        image.draw(x, y);
                    }
                } else if (child.type == 6) {
                    int centerX = Draw3D.centerX;
                    int centerY = Draw3D.centerY;
                    Draw3D.centerX = x + child.width / 2;
                    Draw3D.centerY = y + child.height / 2;
                    int eyeY = Draw3D.sin[child.modelEyePitch] * child.modelZoom >> 16;
                    int eyeZ = Draw3D.cos[child.modelEyePitch] * child.modelZoom >> 16;
                    boolean active = getComponentScriptState(child);
                    int seqId;
                    if (active) {
                        seqId = child.activeSeqId;
                    } else {
                        seqId = child.seqId;
                    }

                    Model model;

                    if (seqId == -1) {
                        model = child.getModel(-1, -1, active);
                    } else {
                        SeqType seq = SeqType.instances[seqId];
                        model = child.getModel(seq.secondaryFrames[child.seqFrame], seq.primaryFrames[child.seqFrame], active);
                    }
                    if (model != null) {
                        model.drawSimple(0, child.modelYaw, 0, child.modelEyePitch, 0, eyeY, eyeZ);
                    }
                    Draw3D.centerX = centerX;
                    Draw3D.centerY = centerY;
                } else if (child.type == 7) {
                    BitmapFont font = child.font;
                    int slot = 0;
                    for (int dy = 0; dy < child.height; dy++) {
                        for (int dx = 0; dx < child.width; dx++) {
                            if (child.containerObjId[slot] > 0) {
                                ObjType obj = ObjType.lookup(child.containerObjId[slot] - 1);
                                String name = obj.name;

                                if (obj.stackable || child.containerItemAmount[slot] != 1) {
                                    name = name + " x" + Game.getAmountToText(child.containerItemAmount[slot]);
                                }
                                int _x = x + dx * (115 + child.invMarginX);
                                int _y = y + dy * (12 + child.invMarginY);
                                if (child.center) {
                                    font.drawStringTaggableCenter(name, _x + child.width / 2, _y, child.colour, child.shadow);
                                } else {
                                    font.drawStringTaggable(name, _x, _y, child.colour, child.shadow);
                                }
                            }
                            slot++;
                        }
                    }
                }
            }
        }

        Draw2D.setBounds(right, bottom, top, left);
    }

    public void loadingStages() {
        if (Game.lowMemory && sceneState == 2 && Region.plane != plane) {
            areaViewport.bind();
            fontPlain.drawStringCenter(257, "Loading - please wait.", -31546, 0, 151);
            fontPlain.drawStringCenter(256, "Loading - please wait.", -31546, 0xffffff, 150);
            areaViewport.draw(super.graphics, 4, 4);
            sceneState = 1;
            sceneLoadStartTime = System.currentTimeMillis();
        }
        if (sceneState == 1) {
            int successful = initializeRegionLoading(aByte1182);
        }
        if (sceneState == 2 && plane != minimapLevel) {
            minimapLevel = plane;
            createMinimap(plane);
            return;
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
                    regionsCached &= Region.method159(576, blockZ, blockX, locs);
                }
            }
            if (!regionsCached) {
                return -3;
            }
            if (loadingMap) {
                return -4;
            }
            sceneState = 2;
            Region.plane = plane;
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

    public void createMinimap(int plane) {
        int[] pixels = minimap.pixels;
        Arrays.fill(pixels, 0);
        for (int z = 1; z < 103; z++) {
            int offset = 24628 + (103 - z) * 512 * 4;
            for (int x = 1; x < 103; x++) {
                if ((planeTileFlags[plane][x][z] & 0x18) == 0) {
                    scene.drawMinimapTile(pixels, offset, 512, plane, x, z);
                }
                if (plane < 3 && (planeTileFlags[plane + 1][x][z] & 8) != 0) {
                    scene.drawMinimapTile(pixels, offset, 512, plane + 1, x, z);
                }
                offset += 4;
            }
        }
        int wall = 0xEEEEEE;
        int door = 0xEE0000;

        minimap.bind();

        for (int z = 1; z < 103; z++) {
            for (int x = 1; x < 103; x++) {
                if ((planeTileFlags[plane][x][z] & 0x18) == 0) {
                    drawMinimapLoc(x, z, wall, plane, door);
                }
                if (plane < 3 && (planeTileFlags[plane + 1][x][z] & 8) != 0) {
                    drawMinimapLoc(x, z, wall, plane + 1, door);
                }
            }
        }
        areaViewport.bind();
        activeMapfunctionCount = 0;
        for (int x = 0; x < 104; x++) {
            for (int z = 0; z < 104; z++) {
                int bitset = scene.getGroundDecorationBitset(plane, x, z);
                if (bitset != 0) {
                    bitset = bitset >> 14 & 0x7fff;
                    int func = LocType.lookup(bitset).mapFunctionIcon;
                    if (func >= 0) {
                        int _x = x;
                        int _z = z;
                        if (func != 22 && func != 29 && func != 34 && func != 36 && func != 46 && func != 47 && func != 48) {
                            byte regionWidth = 104;
                            byte regionHeight = 104;
                            int[][] flags = collisions[plane].flags;
                            for (int off = 0; off < 10; off++) {
                                int randomDirection = (int) (Math.random() * 4D);
                                if (randomDirection == 0 && _x > 0 && _x > x - 3 && (flags[_x - 1][_z] & 0x280108) == 0) {
                                    _x--;
                                }
                                if (randomDirection == 1 && _x < regionWidth - 1 && _x < x + 3 && (flags[_x + 1][_z] & 0x280180) == 0) {
                                    _x++;
                                }
                                if (randomDirection == 2 && _z > 0 && _z > z - 3 && (flags[_x][_z - 1] & 0x280102) == 0) {
                                    _z--;
                                }
                                if (randomDirection == 3 && _z < regionHeight - 1 && _z < z + 3 && (flags[_x][_z + 1] & 0x280120) == 0) {
                                    _z++;
                                }
                            }
                        }
                        activeMapfunctions[activeMapfunctionCount] = mapfunctions[func];
                        activeMapfunctionsX[activeMapfunctionCount] = _x;
                        activeMapfunctionsZ[activeMapfunctionCount] = _z;
                        activeMapfunctionCount++;
                    }
                }
            }
        }
    }

    public void updateComponentContent(Component component) {
        try {
            int type = component.contentType;
            if (type >= 1 && type <= 100 || type >= 701 && type <= 800) {
                if (type == 1 && friendlistStatus == 0) {
                    component.text = "Loading friend list";
                    component.optionType = 0;
                    return;
                }
                if (type == 1 && friendlistStatus == 1) {
                    component.text = "Connecting to friendserver";
                    component.optionType = 0;
                    return;
                }
                if (type == 2 && friendlistStatus != 2) {
                    component.text = "Please wait...";
                    component.optionType = 0;
                    return;
                }
                int count = friendCount;
                if (friendlistStatus != 2) {
                    count = 0;
                }
                if (type > 700) {
                    type -= 601;
                } else {
                    type--;
                }
                if (type >= count) {
                    component.text = "";
                    component.optionType = 0;
                    return;
                } else {
                    component.text = friendName[type];
                    component.optionType = 1;
                    return;
                }
            }
            if (type >= 101 && type <= 200 || type >= 801 && type <= 900) {
                int count = friendCount;
                if (friendlistStatus != 2) {
                    count = 0;
                }
                if (type > 800) {
                    type -= 701;
                } else {
                    type -= 101;
                }
                if (type >= count) {
                    component.text = "";
                    component.optionType = 0;
                    return;
                }
                if (friendWorld[type] == 0) {
                    component.text = "@red@Offline";
                } else if (friendWorld[type] == Game.nodeId) {
                    component.text = "@gre@World-" + (friendWorld[type] - 9);
                } else {
                    component.text = "@yel@World-" + (friendWorld[type] - 9);
                }
                component.optionType = 1;
                return;
            }
            if (type == 203) {
                int count = friendCount;
                if (friendlistStatus != 2) {
                    count = 0;
                }
                component.scrollHeight = count * 15 + 20;
                if (component.scrollHeight <= component.height) {
                    component.scrollHeight = component.height + 1;
                }
                return;
            }
            if (type >= 401 && type <= 500) {
                if ((type -= 401) == 0 && friendlistStatus == 0) {
                    component.text = "Loading ignore list";
                    component.optionType = 0;
                    return;
                }
                if (type == 1 && friendlistStatus == 0) {
                    component.text = "Please wait...";
                    component.optionType = 0;
                    return;
                }
                int count = ignoreCount;
                if (friendlistStatus == 0) {
                    count = 0;
                }
                if (type >= count) {
                    component.text = "";
                    component.optionType = 0;
                    return;
                } else {
                    component.text = TextUtils.formatName(TextUtils.longToName(ignoreNameLong[type]));
                    component.optionType = 1;
                    return;
                }
            }
            if (type == 503) {
                component.scrollHeight = ignoreCount * 15 + 20;
                if (component.scrollHeight <= component.height) {
                    component.scrollHeight = component.height + 1;
                }
                return;
            }
            if (type == 327) {
                component.modelEyePitch = 150;
                component.modelYaw = (int) (Math.sin(Game.loopCycle / 40D) * 256D) & 0x7ff;
                if (updateDesignModel) {
                    for (int part = 0; part < 7; part++) {
                        int kit = designIdentityKits[part];
                        if (kit >= 0 && !IdkType.cache[kit].validateModel(9)) {
                            return;
                        }
                    }
                    updateDesignModel = false;
                    Model[] models = new Model[7];
                    int modelCount = 0;
                    for (int part = 0; part < 7; part++) {
                        int kit = designIdentityKits[part];
                        if (kit >= 0) {
                            models[modelCount++] = IdkType.cache[kit].getModel(0);
                        }
                    }
                    Model model = new Model(models, modelCount, -33019);
                    for (int part = 0; part < 5; part++) {
                        if (designColors[part] != 0) {
                            model.recolor(Game.APPEARANCE_COLOURS[part][0],
                                    Game.APPEARANCE_COLOURS[part][designColors[part]]);
                            if (part == 1) {
                                model.recolor(Game.BEARD_COLOURS[0],
                                        Game.BEARD_COLOURS[designColors[part]]);
                            }
                        }
                    }
                    model.createLabelReference((byte) 3);
                    model.applyTransform(SeqType.instances[Game.localPlayer.standSeqId].primaryFrames[0],
                                    188);
                    model.calculateNormals(64, 850, -30, -50, -30, true);
                    component.modelType = 5;
                    component.modelTypeId = 0;
                    Component.cacheModel(5, model, 9, 0);
                }
                return;
            }
            if (type == 324) {
                if (genderButtonImage0 == null) {
                    genderButtonImage0 = component.image;
                    genderButtonImage1 = component.activeImage;
                }
                if (designGenderMasc) {
                    component.image = genderButtonImage1;
                    return;
                } else {
                    component.image = genderButtonImage0;
                    return;
                }
            }
            if (type == 325) {
                if (genderButtonImage0 == null) {
                    genderButtonImage0 = component.image;
                    genderButtonImage1 = component.activeImage;
                }
                if (designGenderMasc) {
                    component.image = genderButtonImage0;
                    return;
                } else {
                    component.image = genderButtonImage1;
                    return;
                }
            }
            if (type == 600) {
                component.text = reportAbuseInput;
                if (Game.loopCycle % 20 < 10) {
                    component.text += "|";
                    return;
                } else {
                    component.text += " ";
                    return;
                }
            }
            if (type == 613) {
                if (rights >= 1) {
                    if (reportAbuseMuteOption) {
                        component.colour = 0xff0000;
                        component.text = "Moderator option: Mute player for 48 hours: <ON>";
                    } else {
                        component.colour = 0xffffff;
                        component.text = "Moderator option: Mute player for 48 hours: <OFF>";
                    }
                } else {
                    component.text = "";
                }
            }
            if (type == 650 || type == 655) {
                if (lastAddress != 0) {
                    String text;
                    if (daysSinceLastLogin == 0) {
                        text = "earlier today";
                    } else if (daysSinceLastLogin == 1) {
                        text = "yesterday";
                    } else {
                        text = daysSinceLastLogin + " days ago";
                    }
                    component.text = "You last logged in " + text + " from: " + SignLink.dns;
                } else {
                    component.text = "";
                }
            }
            if (type == 651) {
                if (unreadMessages == 0) {
                    component.text = "0 unread messages";
                    component.colour = 0xffff00;
                }
                if (unreadMessages == 1) {
                    component.text = "1 unread message";
                    component.colour = 65280;
                }
                if (unreadMessages > 1) {
                    component.text = unreadMessages + " unread messages";
                    component.colour = 65280;
                }
            }
            if (type == 652) {
                if (daysSinceRecoveriesChanged == 201) {
                    if (warnMembersInNonmembers == 1) {
                        component.text = "@yel@This is a non-members world: @whi@Since you are a member we";
                    } else {
                        component.text = "";
                    }
                } else if (daysSinceRecoveriesChanged == 200) {
                    component.text = "You have not yet set any password recovery questions.";
                } else {
                    String text;
                    if (daysSinceRecoveriesChanged == 0) {
                        text = "Earlier today";
                    } else if (daysSinceRecoveriesChanged == 1) {
                        text = "Yesterday";
                    } else {
                        text = daysSinceRecoveriesChanged + " days ago";
                    }
                    component.text = text + " you changed your recovery questions";
                }
            }
            if (type == 653) {
                if (daysSinceRecoveriesChanged == 201) {
                    if (warnMembersInNonmembers == 1) {
                        component.text = "@whi@recommend you use a members world instead. You may use";
                    } else {
                        component.text = "";
                    }
                } else if (daysSinceRecoveriesChanged == 200) {
                    component.text = "We strongly recommend you do so now to secure your account.";
                } else {
                    component.text = "If you do not remember making this change then cancel it immediately";
                }
            }
            if (type == 654) {
                if (daysSinceRecoveriesChanged == 201) {
                    if (warnMembersInNonmembers == 1) {
                        component.text = "@whi@this world but member benefits are unavailable whilst here.";
                        return;
                    } else {
                        component.text = "";
                        return;
                    }
                }
                if (daysSinceRecoveriesChanged == 200) {
                    component.text = "Do this from the 'account management' area on our front webpage";
                    return;
                } else {
                    component.text = "Do this from the 'account management' area on our front webpage";
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("89305, " + component + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method42(byte byte0, int i, Buffer class44_sub3_sub2) {
        try {
            while (true) {
                if (class44_sub3_sub2.bitPosition + 21 >= i * 8) {
                    break;
                }
                int j = class44_sub3_sub2.getBits(14);
                if (j == 16383) {
                    break;
                }
                if (npcs[j] == null) {
                    npcs[j] = new NPCEntity();
                }
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[j];
                anIntArray1010[npcCount++] = j;
                class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                class44_sub3_sub4_sub6_sub2.aClass12_1700 = NpcType.lookup(class44_sub3_sub2.getBits(11
                ));
                class44_sub3_sub4_sub6_sub2.anInt1619 = class44_sub3_sub4_sub6_sub2.aClass12_1700.aByte284;
                class44_sub3_sub4_sub6_sub2.anInt1663 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt306;
                class44_sub3_sub4_sub6_sub2.walkSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt288;
                class44_sub3_sub4_sub6_sub2.turnSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt289;
                class44_sub3_sub4_sub6_sub2.turnRightSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt290;
                class44_sub3_sub4_sub6_sub2.turnLeftSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt291;
                class44_sub3_sub4_sub6_sub2.standSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt287;
                int k = class44_sub3_sub2.getBits(5);
                if (k > 15) {
                    k -= 32;
                }
                int l = class44_sub3_sub2.getBits(5);
                if (l > 15) {
                    l -= 32;
                }
                int i1 = class44_sub3_sub2.getBits(1);
                class44_sub3_sub4_sub6_sub2.method532(
                        Game.localPlayer.pathTileX[0] + k, i1 == 1,
                        Game.localPlayer.pathTileZ[0] + l, aByte925);
                int j1 = class44_sub3_sub2.getBits(1);
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
    public void showProgress(int percent, String message) {
        this.percent = percent;
        this.message = message;
        resetTitleScreen();
        if (titleArchive == null) {
            super.showProgress(percent, message);
            return;
        }
        title4.bind();
        char c = '\u0168';
        char c1 = '\310';
        byte byte0 = 20;
        fontBold.drawStringCenter(c / 2, "RuneScape is loading - please wait...", -31546, 0xffffff, c1
                / 2 - 26 - byte0);
        int j = c1 / 2 - 18 - byte0;
        Draw2D.drawRect(c / 2 - 152, j, 304, 34, 0x8c1111, 1);
        Draw2D.drawRect(c / 2 - 151, j + 1, 302, 32, 0, 1);
        Draw2D.fillRect(c / 2 - 150, j + 2, percent * 3, 30, 0x8c1111, 210);
        Draw2D.fillRect((c / 2 - 150) + percent * 3, j + 2, 300 - percent * 3, 30, 0, 210);
        fontBold.drawStringCenter(c / 2, message, -31546, 0xffffff, (c1 / 2 + 5) - byte0);
        title4.draw(super.graphics, 202, 171);
        if (redrawTitleBackground) {
            redrawTitleBackground = false;
            if (!flameActive) {
                title0.draw(super.graphics, 0, 0);
                title1.draw(super.graphics, 637, 0);
            }
            title2.draw(super.graphics, 128, 0);
            title3.draw(super.graphics, 202, 371);
            title5.draw(super.graphics, 0, 265);
            title6.draw(super.graphics, 562, 265);
            title7.draw(super.graphics, 128, 171);
            title8.draw(super.graphics, 562, 171);
            return;
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
            renderStillSpotanim(-249);
            if (!cutsceneActive) {
                int vertical = cameraVertical;
                if (secondaryCameraVertical / 256 > vertical) {
                    vertical = secondaryCameraVertical / 256;
                }
                if (customCameraActive[4] && cameraAmplitude[4] + 128 > vertical) {
                    vertical = cameraAmplitude[4] + 128;
                }
                int horizontal = cameraHorizontal + cameraAnticheatAngle & 0x7ff;
                setCameraPosition(600 + vertical * 3, horizontal, getFloorDrawHeight(false, localPlayer.z, localPlayer.x, plane) - 50, currentCameraPositionV, currentCameraPositionH, vertical);
            }
            int cameraPlane;
            if (!cutsceneActive) {
                cameraPlane = getWorldDrawPlane();
            } else {
                cameraPlane = getCameraPlaneCutscene((byte) 7);
            }
            int x = cameraPositionX;
            int z = cameraPositionZ;
            int y = cameraPositionY;
            int curveY = cameraVerticalRotation;
            int curveZ = cameraHorizontalRotation;
            for (int it = 0; it < 5; it++) {
                if (customCameraActive[it]) {
                    int randomisation = (int) ((Math.random() * (cameraJitter[it] * 2 + 1) - cameraJitter[it]) + Math
                            .sin(anIntArray1001[it] * (cameraFrequency[it] / 100D)) * cameraAmplitude[it]);
                    if (it == 0) {
                        cameraPositionX += randomisation;
                    }
                    if (it == 1) {
                        cameraPositionZ += randomisation;
                    }
                    if (it == 2) {
                        cameraPositionY += randomisation;
                    }
                    if (it == 3) {
                        cameraHorizontalRotation = cameraHorizontalRotation + randomisation & 0x7ff;
                    }
                    if (it == 4) {
                        cameraVerticalRotation += randomisation;
                        if (cameraVerticalRotation < 128) {
                            cameraVerticalRotation = 128;
                        }
                        if (cameraVerticalRotation > 383) {
                            cameraVerticalRotation = 383;
                        }
                    }
                }
            }
            int textureId = Draw3D.getTexture;
            Model.aBoolean1593 = true;
            Model.resourceCount = 0;
            if (i != 0) {
                return;
            } else {
                Model.cursorX = super.mouseX - 4;
                Model.cursorY = super.mouseY - 4;
                Draw2D.clear((byte) 127);
                scene.render(cameraPositionX, 7, cameraVerticalRotation, cameraPositionY, cameraPlane, cameraPositionZ, cameraHorizontalRotation);
                scene.clearInteractiveLocCache(true);
                updateEntities(1);
                drawHeadIcon(anInt1019);
                animateTexture(textureId, (byte) -12);
                draw3dScreen();
                areaViewport.draw(super.graphics, 4, 4);
                cameraPositionX = x;
                cameraPositionZ = z;
                cameraPositionY = y;
                cameraVerticalRotation = curveY;
                cameraHorizontalRotation = curveZ;
                return;
            }
        } catch (Exception e) {
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
            for (int j = 0; j < friendCount; j++) {
                if (aLongArray979[j] == l) {
                    friendCount--;
                    redrawInvback = true;
                    for (int k = j; k < friendCount; k++) {
                        friendName[k] = friendName[k + 1];
                        friendWorld[k] = friendWorld[k + 1];
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

    public void buildSplitPrivateChatMenu() {
            if (splitPrivateChat == 0) {
                return;
            }
            int line = 0;
            if (systemUpdateTimer != 0) {
                line = 1;
            }
            for (int message = 0; message < 100; message++) {
                if (this.chatMessages[message] != null) {
                    int chatType = chatTypes[message];
                    String chatName = chatNames[message];
                    if (chatName != null && chatName.startsWith("@cr1@")) {
                        chatName = chatName.substring(5);
                    }
                    if (chatName != null && chatName.startsWith("@cr2@")) {
                        chatName = chatName.substring(5);
                    }
                    if ((chatType == 3 || chatType == 7) && (chatType == 7 || privateChatMode == 0 || privateChatMode == 1 && isFriendOrSelf(chatName))) {
                        int height = 329 - line * 13;
                        if (super.mouseX > 4 && super.mouseY - 4 > height - 10 && super.mouseY - 4 <= height + 3) {
                            int width = fontPlain.getTextDisplayedWidth("From:  " + chatName + this.chatMessages[message]) + 25;
                            if (width > 450) {
                                width = 450;
                            }
                            if (super.mouseX < 4 + width) {
                                if (rights >= 1) {
                                    menuOption[menuSize] = "Report abuse @whi@" + chatName;
                                    menuAction[menuSize] = 2524;
                                    menuSize++;
                                }
                                menuOption[menuSize] = "Add ignore @whi@" + chatName;
                                menuAction[menuSize] = 2047;
                                menuSize++;
                                menuOption[menuSize] = "Add friend @whi@" + chatName;
                                menuAction[menuSize] = 2605;
                                menuSize++;
                            }
                        }
                        if (++line >= 5) {
                            return;
                        }
                    }
                    if ((chatType == 5 || chatType == 6) && privateChatMode < 2 && ++line >= 5) {
                        return;
                    }
                }
            }
    }

    @Override
    public String getParameter(String s) {
        if (SignLink.mainapp != null) {
            return SignLink.mainapp.getParameter(s);
        } else {
            return super.getParameter(s);
        }
    }

    public void updatePlayerMasks(int mask, Buffer in, int index, PlayerEntity player) {
        try {
            if ((mask & MagicConstants.APPEARANCE_MASK) == 1) {
                int amount = in.readUnsignedByte();
                byte[] bytes = new byte[amount];
                Buffer playerAppearanceBuffer = new Buffer(bytes);
                in.readBytes(bytes, 0, amount);
                appearanceBuffer[index] = playerAppearanceBuffer;
                player.updateAppearanceData(playerAppearanceBuffer);
            }
            if ((mask & MagicConstants.ANIMATION_MASK) == 2) {
                int animIndex = in.readUnsignedShort();
                if (animIndex == 65535) {
                    animIndex = -1;
                }
                if (animIndex == player.primarySeq) {
                    player.primarySeqPlays = 0;
                }
                int delay = in.readUnsignedByte();
                if (animIndex == player.primarySeq && animIndex != -1) {
                    int replayMode = SeqType.instances[animIndex].replayMode;
                    if (replayMode == 1) {
                        player.currentSeqFrame = 0;
                        player.currentSeqDelay = 0;
                        player.primarySeqDelays = delay;
                        player.primarySeqPlays = 0;
                    }
                    if (replayMode == 2) {
                        player.primarySeqPlays = 0;
                    }
                } else if (animIndex == -1 || player.primarySeq == -1 || SeqType.instances[animIndex].priority >= SeqType.instances[player.primarySeq].priority) {
                    player.primarySeq = animIndex;
                    player.currentSeqFrame = 0;
                    player.currentSeqDelay = 0;
                    player.primarySeqDelays = delay;
                    player.primarySeqPlays = 0;
                    player.anInt1669 = player.anInt1664;
                }
            }
            if ((mask & MagicConstants.FACE_ENTITY_MASK) == 4) {
                player.targetEntitiy = in.readUnsignedShort();
                if (player.targetEntitiy == 65535) {
                    player.targetEntitiy = -1;
                }
            }
            if ((mask & MagicConstants.FORCED_CHAT_MASK) == 8) {
                player.spoken = in.readString();
                if (player.spoken.charAt(0) == '~') {
                    player.spoken = player.spoken.substring(1);
                    renderText(player.name, player.spoken, 2);
                } else if (player == Game.localPlayer) {
                    renderText(player.name, player.spoken, 2);
                }
                player.spokenColour = 0;
                player.spokenEffect = 0;
                player.spokenLife = 150;
            }
            if ((mask & MagicConstants.HIT1_MASK) == 16) {
                int damageTaken = in.readUnsignedByte();
                int damageType = in.readUnsignedByte();
                player.updateHitData(damageType, Game.loopCycle, damageTaken, false);
                player.lastCombatCycle = Game.loopCycle + 300;
                player.currentHealth = in.readUnsignedByte();
                player.maxHealth = in.readUnsignedByte();
            }
            if ((mask & MagicConstants.FACE_TILE_MASK) == 32) {
                player.focusX = in.readUnsignedShort();
                player.focusZ = in.readUnsignedShort();
            }
            if ((mask & MagicConstants.CHAT_MASK) == 64) {
                int colourAndEffect = in.readUnsignedShort();
                int rights = in.readUnsignedByte();
                int messageLength = in.readUnsignedByte();
                int originalOffset = in.position;
                if (player.name != null && player.visible) {
                    long longName = TextUtils.encodeBase37(player.name);
                    boolean ignore = false;
                    if (rights <= 1) {
                        for (int ignored = 0; ignored < ignoreCount; ignored++) {
                            if (ignoreNameLong[ignored] != longName) {
                                continue;
                            }
                            ignore = true;
                            break;
                        }
                    }
                    if (!ignore && tutorial == 0) {
                        try {
                            String text = ChatCompression.readFromBytes((byte) -94, in, messageLength);
                            text = ChatCensor.censor(text);
                            player.spoken = text;
                            player.spokenColour = colourAndEffect >> 8;
                            player.spokenEffect = colourAndEffect & 0xff;
                            player.spokenLife = 150;
                            if (rights == 2 || rights == 3) {
                                renderText("@cr2@" + player.name, text, 1);
                            } else if (rights == 1) {
                                renderText("@cr1@" + player.name, text, 1);
                            } else {
                                renderText(player.name, text, 2);
                            }
                        } catch (Exception exception) {
                            SignLink.reporterror("cde2");
                        }
                    }
                }
                in.position = originalOffset + messageLength;
            }
            if ((mask & MagicConstants.SPOTANIM_MASK) == 256) {
                player.spotAnimId = in.readUnsignedShort();
                int delay = in.readInt();
                player.spotAnimHeight = delay >> 16;
                player.spotAnimEndCycle = Game.loopCycle + (delay & 0xffff);
                player.currentSeqId = 0;
                player.currentSeqDurationRemaining = 0;
                if (player.spotAnimEndCycle > Game.loopCycle) {
                    player.currentSeqId = -1;
                }
                if (player.spotAnimId == 65535) {
                    player.spotAnimId = -1;
                }
            }
            if ((mask & MagicConstants.FORCED_MOVEMENT_MASK) == 512) {
                player.srcTileX = in.readUnsignedByte();
                player.srcTileZ = in.readUnsignedByte();
                player.dstTileX = in.readUnsignedByte();
                player.dstTileZ = in.readUnsignedByte();
                player.firstMoveCycle = in.readUnsignedShort() + Game.loopCycle;
                player.lastMoveCycle = in.readUnsignedShort() + Game.loopCycle;
                player.faceDirection = in.readUnsignedByte();
                player.method534(false);
            }
            if ((mask & MagicConstants.HIT2_MASK) == 1024) {
                int hitDamage = in.readUnsignedByte();
                int hitType = in.readUnsignedByte();
                player.updateHitData(hitType, Game.loopCycle, hitDamage, false);
                player.lastCombatCycle = Game.loopCycle + 300;
                player.currentHealth = in.readUnsignedByte();
                player.maxHealth = in.readUnsignedByte();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("71941, " + mask + ", " + in + ", " + index + ", "
                    + player + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void drawChatback(int i) {
        try {
            areaChatBack.bind();
            Draw3D.lineOffset = areaChatbackOffsets;
            chatbackImage.blit(0, 0);
            if (showSocialInput) {
                fontBold.drawStringCenter(239, socialMessage, -31546, 0, 40);
                fontBold.drawStringCenter(239, socialInput + "*", -31546, 128, 60);
            } else if (chatbackInputType) {
                fontBold.drawStringCenter(239, "Enter amount:", -31546, 0, 40);
                fontBold.drawStringCenter(239, chatBackInput + "*", -31546, 128, 60);
            } else if (modalMessage != null) {
                fontBold.drawStringCenter(239, modalMessage, -31546, 0, 40);
                fontBold.drawStringCenter(239, "Click to continue", -31546, 128, 60);
            } else if (chatComponentId != -1) {
                drawComponent(Component.instances[chatComponentId], 0, 0, 0);
            } else if (chatOverlayComponentId != -1) {
                drawComponent(Component.instances[chatOverlayComponentId], 0, 0, 0);
            } else {
                BitmapFont font = fontPlain;
                int line = 0;
                Draw2D.setBounds(463, 77, 0, 0);
                for (int i = 0; i < 100; i++) {
                    if (chatMessages[i] != null) {
                        int type = chatTypes[i];
                        int y = (70 - line * 14) + chatScrollOffset;
                        String sender = chatNames[i];
                        byte icon = 0;
                        if (sender != null && sender.startsWith("@cr1@")) {
                            sender = sender.substring(5);
                            icon = 1;
                        }
                        if (sender != null && sender.startsWith("@cr2@")) {
                            sender = sender.substring(5);
                            icon = 2;
                        }
                        if (type == 0) {
                            if (y > 0 && y < 110) {
                                font.drawText(chatMessages[i], y, 4, 0);
                            }
                            line++;
                        }
                        if ((type == 1 || type == 2) && (type == 1 || publicChatSetting == 0 || publicChatSetting == 1 && isFriendOrSelf(sender))) {
                            if (y > 0 && y < 110) {
                                int x = 4;
                                if (icon == 1) {
                                    modicons[0].blit(y - 12, x);
                                    x += 14;
                                }
                                if (icon == 2) {
                                    modicons[1].blit(y - 12, x);
                                    x += 14;
                                }
                                font.drawText(sender + ":", y, x, 0);
                                x += font.getTextDisplayedWidth(sender) + 8;
                                font.drawText(chatMessages[i], y, x, 255);
                            }
                            line++;
                        }
                        if ((type == 3 || type == 7) && splitPrivateChat == 0
                                && (type == 7 || privateChatMode == 0 || privateChatMode == 1 && isFriendOrSelf(sender))) {
                            if (y > 0 && y < 110) {
                                int x = 4;
                                font.drawText("From", y, x, 0);
                                x += font.getTextDisplayedWidth("From ");
                                if (icon == 1) {
                                    modicons[0].blit(y - 12, x);
                                    x += 14;
                                }
                                if (icon == 2) {
                                    modicons[1].blit(y - 12, x);
                                    x += 14;
                                }
                                font.drawText(sender + ":", y, x, 0);
                                x += font.getTextDisplayedWidth(sender) + 8;
                                font.drawText(chatMessages[i], y, x, 0x800000);
                            }
                            line++;
                        }
                        if (type == 4 && (tradeChatSetting == 0 || tradeChatSetting == 1 && isFriendOrSelf(sender))) {
                            if (y > 0 && y < 110) {
                                font.drawText(sender + " " + chatMessages[i], y, 4, 0x800080
                                );
                            }
                            line++;
                        }
                        if (type == 5 && splitPrivateChat == 0 && privateChatMode < 2) {
                            if (y > 0 && y < 110) {
                                font.drawText(chatMessages[i], y, 4, 0x800000);
                            }
                            line++;
                        }
                        if (type == 6 && splitPrivateChat == 0 && privateChatMode < 2) {
                            if (y > 0 && y < 110) {
                                font.drawText("To " + sender + ":", y, 4, 0);
                                font.drawText(chatMessages[i], y, 12 + font.getTextDisplayedWidth("To " + sender), 0x800000
                                );
                            }
                            line++;
                        }
                        if (type == 8 && (tradeChatSetting == 0 || tradeChatSetting == 1 && isFriendOrSelf(sender))) {
                            if (y > 0 && y < 110) {
                                font.drawText(sender + " " + chatMessages[i], y, 4, 0x7e3200
                                );
                            }
                            line++;
                        }
                    }
                }
                Draw2D.resetBounds();
                chatScrollHeight = line * 14 + 7;
                if (chatScrollHeight < 78) {
                    chatScrollHeight = 78;
                }
                drawScrollbar(463, 0, chatScrollHeight - chatScrollOffset - 77, chatScrollHeight, 77);
                String name;
                if (Game.localPlayer != null
                        && Game.localPlayer.name != null) {
                    name = Game.localPlayer.name;
                } else {
                    name = TextUtils.formatName(username);
                }
                font.drawText(name + ":", 90, 4, 0);
                font.drawText(chatTyped + "*", 90, 6 + font.getTextDisplayedWidth(name + ": "), 255
                );
                Draw2D.drawLineX(479, 0, 0, true, 77);
            }
            if (menuOpen && menuScreenArea == 2) {
                drawMenu();
            }
            areaChatBack.draw(super.graphics, 17, 357);
            areaViewport.bind();
            Draw3D.lineOffset = areaViewportOffsets;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("21760, " + i + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void loadTitleImages() {
        titleBox = new Image8(titleArchive, "titlebox", 0);
        titleButton = new Image8(titleArchive, "titlebutton", 0);
        imageRunes = new Image8[12];
        int icon = 0;
        try {
            icon = Integer.parseInt(getParameter("fl_icon"));
        } catch (Exception _ex) {
        }
        if (icon == 0) {
            for (int i = 0; i < 12; i++) {
                imageRunes[i] = new Image8(titleArchive, "runes", i);
            }
        } else {
            for (int i = 0; i < 12; i++) {
                imageRunes[i] = new Image8(titleArchive, "runes", 12 + (i & 3));
            }
        }
        flamesLeft = new Image24(128, 265);
        flameRight = new Image24(128, 265);
        System.arraycopy(title0.pixels, 0, flamesLeft.pixels, 0, 33920);
        System.arraycopy(title1.pixels, 0, flameRight.pixels, 0, 33920);
        flameGradient0 = new int[256];
        for (int i = 0; i < 64; i++) {
            flameGradient0[i] = i * 0x40000;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient0[i + 64] = 0xff0000 + 1024 * i;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient0[i + 128] = 0xffff00 + 4 * i;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient0[i + 192] = 0xffffff;
        }
        flameGradient1 = new int[256];
        for (int i = 0; i < 64; i++) {
            flameGradient1[i] = i * 1024;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient1[i + 64] = 65280 + 4 * i;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient1[i + 128] = 65535 + 0x40000 * i;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient1[i + 192] = 0xffffff;
        }
        flameGradient2 = new int[256];
        for (int i = 0; i < 64; i++) {
            flameGradient2[i] = i * 4;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient2[i + 64] = 255 + 0x40000 * i;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient2[i + 128] = 0xff00ff + 1024 * i;
        }
        for (int i = 0; i < 64; i++) {
            flameGradient2[i + 192] = 0xffffff;
        }
        flameGradient = new int[256];
        flameBuffer0 = new int[32768];
        flameBuffer1 = new int[32768];
        updateFlameBuffer(null, 34809);
        flameBuffer3 = new int[32768];
        flameBuffer2 = new int[32768];
        showProgress(10, "Connecting to fileserver");
        if (!flameActive) {
            flamesThread = true;
            flameActive = true;
            startThread(this, 2);
        }
    }

    public void setStandardCameraPosition(byte byte0) {
        try {
            if (byte0 != aByte1101) {
                aBoolean1178 = !aBoolean1178;
            }
            try {
                int x = Game.localPlayer.x + cameraAnticheatOffsetX;
                int y = Game.localPlayer.z + cameraAnticheatOffsetZ;
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
                            int k2 = i1 - planeHeightMap[j2][k1][i2];
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
                SignLink.reporterror("glfc_ex " + Game.localPlayer.x + ","
                        + Game.localPlayer.z + "," + currentCameraPositionH + ","
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
            for (int i = 0; i < npcCount; i++) {
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
            int i2 = planeHeightMap[j1][l][i1] * (128 - k1) + planeHeightMap[j1][l + 1][i1] * k1 >> 7;
            if (flag) {
                return 3;
            } else {
                int j2 = planeHeightMap[j1][l][i1 + 1] * (128 - k1)
                        + planeHeightMap[j1][l + 1][i1 + 1] * k1 >> 7;
                return i2 * (128 - l1) + j2 * l1 >> 7;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("38676, " + flag + ", " + i + ", " + j + ", " + k + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void drawToolTip() {
        try {
            if (menuSize < 2 && objSelected == 0 && spellSelected == 0) {
                return;
            }
            String s;
            if (objSelected == 1 && menuSize < 2) {
                s = "Use " + selectedObjName + " with...";
            } else if (spellSelected == 1 && menuSize < 2) {
                s = spellTooltip + "...";
            } else {
                s = menuOption[menuSize - 1];
            }
            if (menuSize > 2) {
                s = s + "@whi@ / " + (menuSize - 2) + " more options";
            }
            fontBold.method464(s, true, 0xffffff, 26617, 4, Game.loopCycle / 1000, 15);
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("20355, " + runtimeexception);
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
            if (errorLoading) {
                flameActive = false;
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
                flameActive = false;
                g.setFont(new Font("Helvetica", 1, 20));
                g.setColor(Color.white);
                g.drawString("Error - unable to load game!", 50, 50);
                g.drawString("To play RuneScape make sure you play from", 50, 100);
                g.drawString("http://www.runescape.com", 50, 150);
            }
            if (errorStarted) {
                flameActive = false;
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

    public void processRightClick() {
        try {
            if (objDragArea != 0) {
                return;
            }
            menuOption[0] = "Cancel";
            menuAction[0] = 1106;
            menuSize = 1;
            buildSplitPrivateChatMenu();
            lastHoveredComponentId = 0;
            if (super.mouseX > 4 && super.mouseY > 4 && super.mouseX < 516 && super.mouseY < 338) {
                if (viewportComponentId != -1) {
                    handleParentComponentInput(4, 0, super.mouseX, Component.instances[viewportComponentId], 4, super.mouseY);
                } else {
                    method135(true);
                }
            }
            if (lastHoveredComponentId != viewportHoveredComponentId) {
                viewportHoveredComponentId = lastHoveredComponentId;
            }
            lastHoveredComponentId = 0;
            if (super.mouseX > 553 && super.mouseY > 205 && super.mouseX < 743 && super.mouseY < 466) {
                if (sidebarComponentId != -1) {
                    handleParentComponentInput(553, 0, super.mouseX, Component.instances[sidebarComponentId], 205, super.mouseY);
                } else if (tabComponentId[currentTab] != -1) {
                    handleParentComponentInput(553, 0, super.mouseX, Component.instances[tabComponentId[currentTab]], 205,
                            super.mouseY);
                }
            }
            if (lastHoveredComponentId != invbackHoveredComponentId) {
                redrawInvback = true;
                invbackHoveredComponentId = lastHoveredComponentId;
            }
            lastHoveredComponentId = 0;
            if (super.mouseX > 17 && super.mouseY > 357 && super.mouseX < 496 && super.mouseY < 453) {
                if (chatComponentId != -1) {
                    handleParentComponentInput(17, 0, super.mouseX, Component.instances[chatComponentId], 357, super.mouseY);
                } else if (super.mouseY < 434 && super.mouseX < 426) {
                    method111(super.mouseX - 17, (byte) 7, super.mouseY - 357);
                }
            }
            if (chatComponentId != -1 && lastHoveredComponentId != chatbackHoveredComponentId) {
                redrawChatback = true;
                chatbackHoveredComponentId = lastHoveredComponentId;
            }
            for (boolean flag = false; !flag; ) {
                flag = true;
                for (int i = 0; i < menuSize - 1; i++) {
                    if (menuAction[i] < 1000 && menuAction[i + 1] > 1000) {
                        String s = menuOption[i];
                        menuOption[i] = menuOption[i + 1];
                        menuOption[i + 1] = s;
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
            SignLink.reporterror("40244, " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method55(byte byte0, long l) {
        try {
            if (l == 0L) {
                return;
            }
            if (ignoreCount >= 100) {
                renderText("", "Your ignore list is full. Max of 100 hit", 0);
                return;
            }
            String s = TextUtils.formatName(TextUtils.longToName(l));
            for (int i = 0; i < ignoreCount; i++) {
                if (ignoreNameLong[i] == l) {
                    renderText("", s + " is already on your ignore list", 0);
                    return;
                }
            }
            for (int j = 0; j < friendCount; j++) {
                if (aLongArray979[j] == l) {
                    renderText("", "Please remove " + s + " from your friend list first", 0);
                    return;
                }
            }
            ignoreNameLong[ignoreCount++] = l;
            if (byte0 != -37) {
                out.writeByte(42);
            }
            redrawInvback = true;
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
                if (!processPackets(true)) {
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
            updateTemporaryLocs(845);
            method108(948);
            timeoutCounter++;
            if (timeoutCounter > 750) {
                attemptReconnect((byte) 7);
            }
            method83((byte) 5);
            method116(905);
            method20(0);
            delta++;
            if (crossMode != 0) {
                crossCycle += 20;
                if (crossCycle >= 400) {
                    crossMode = 0;
                }
            }
            if (containerComponentType != 0) {
                anInt1148++;
                if (anInt1148 >= 15) {
                    if (containerComponentType == 2) {
                        redrawInvback = true;
                    }
                    if (containerComponentType == 3) {
                        redrawChatback = true;
                    }
                    containerComponentType = 0;
                }
            }
            if (objDragArea != 0) {
                objDragCycles++;
                if (super.mouseX > objGrabX + 5 || super.mouseX < objGrabX - 5 || super.mouseY > objGrabY + 5
                        || super.mouseY < objGrabY - 5) {
                    aBoolean847 = true;
                }
                if (super.mouseButton == 0) {
                    if (objDragArea == 2) {
                        redrawInvback = true;
                    }
                    if (objDragArea == 3) {
                        redrawChatback = true;
                    }
                    objDragArea = 0;
                    if (aBoolean847 && objDragCycles >= 5) {
                        lastActiveInventoryInterface = -1;
                        processRightClick();
                        if (lastActiveInventoryInterface == objDragComponentId && moveItemSlotEnd != objDragSlot) {
                            Component class5 = Component.instances[objDragComponentId];
                            int j1 = 0;
                            if (anInt835 == 1 && class5.contentType == 206) {
                                j1 = 1;
                            }
                            if (class5.containerObjId[moveItemSlotEnd] <= 0) {
                                j1 = 0;
                            }
                            if (class5.aBoolean130) {
                                int l2 = objDragSlot;
                                int l3 = moveItemSlotEnd;
                                class5.containerObjId[l3] = class5.containerObjId[l2];
                                class5.containerItemAmount[l3] = class5.containerItemAmount[l2];
                                class5.containerObjId[l2] = -1;
                                class5.containerItemAmount[l2] = 0;
                            } else if (j1 == 1) {
                                int i3 = objDragSlot;
                                for (int i4 = moveItemSlotEnd; i3 != i4; ) {
                                    if (i3 > i4) {
                                        class5.method182(0, i3 - 1, i3);
                                        i3--;
                                    } else if (i3 < i4) {
                                        class5.method182(0, i3 + 1, i3);
                                        i3++;
                                    }
                                }
                            } else {
                                class5.method182(0, moveItemSlotEnd, objDragSlot);
                            }
                            out.writePacket(253);
                            out.writeShort(objDragComponentId);
                            out.writeShort(objDragSlot);
                            out.writeShort(moveItemSlotEnd);
                            out.writeByte(j1);
                        }
                    } else if ((anInt862 == 1 || method26(menuSize - 1, -40)) && menuSize > 2) {
                        processMenuHovering();
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
                boolean flag = tryMove(0, Game.localPlayer.pathTileX[0], 0,
                        k1, 0, 0, true, 0, 124, 0, k,
                        Game.localPlayer.pathTileZ[0]);
                Scene.anInt640 = -1;
                if (flag) {
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 1;
                    crossCycle = 0;
                }
            }
            if (super.clickType == 1 && modalMessage != null) {
                modalMessage = null;
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
                dragCycle++;
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
                    cameraAnticheatOffsetX += anInt1012;
                }
                if ((l1 & 2) == 2) {
                    cameraAnticheatOffsetZ += anInt1216;
                }
                if ((l1 & 4) == 4) {
                    cameraAnticheatAngle += anInt1107;
                }
            }
            if (cameraAnticheatOffsetX < -50) {
                anInt1012 = 2;
            }
            if (cameraAnticheatOffsetX > 50) {
                anInt1012 = -2;
            }
            if (cameraAnticheatOffsetZ < -55) {
                anInt1216 = 2;
            }
            if (cameraAnticheatOffsetZ > 55) {
                anInt1216 = -2;
            }
            if (cameraAnticheatAngle < -40) {
                anInt1107 = 1;
            }
            if (cameraAnticheatAngle > 40) {
                anInt1107 = -1;
            }
            anInt907++;
            if (anInt907 > 500) {
                anInt907 = 0;
                int i2 = (int) (Math.random() * 8D);
                if ((i2 & 1) == 1) {
                    minimapAnticheatAngle += anInt960;
                }
                if ((i2 & 2) == 2) {
                    minimapZoom += anInt1076;
                }
            }
            if (minimapAnticheatAngle < -60) {
                anInt960 = 2;
            }
            if (minimapAnticheatAngle > 60) {
                anInt960 = -2;
            }
            if (minimapZoom < -20) {
                anInt1076 = 1;
            }
            if (minimapZoom > 10) {
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
                attemptReconnect((byte) 7);
                return;
            } catch (Exception exception) {
                logout();
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
            for (int l = 0; l < playerCount; l++) {
                if (players[anIntArray1227[l]] == null) {
                    SignLink.reporterror(username + " null entry in pl list - pos:" + l + " size:" + playerCount);
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
                s = s + Game.method137(class12.anInt299, Game.localPlayer.combatLevel, -41081)
                        + " (level-" + class12.anInt299 + ")";
            }
            if (objSelected == 1) {
                menuOption[menuSize] = "Use " + selectedObjName + " with @yel@" + s;
                menuAction[menuSize] = 829;
                menuParamC[menuSize] = i;
                menuParamA[menuSize] = j;
                menuParamB[menuSize] = l;
                menuSize++;
                return;
            }
            if (spellSelected == 1) {
                if ((spellUsableOn & 2) == 2) {
                    menuOption[menuSize] = spellTooltip + " @yel@" + s;
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
                            menuOption[menuSize] = class12.aStringArray294[i1] + " @yel@" + s;
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
                            if (class12.anInt299 > Game.localPlayer.combatLevel) {
                                c = '\u07D0';
                            }
                            menuOption[menuSize] = class12.aStringArray294[j1] + " @yel@" + s;
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
                menuOption[menuSize] = "Examine @yel@" + s;
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

    public void prepareGameScreen(int i) {
        try {
            if (areaChatBack != null) {
                return;
            }
            method128(false);
            super.aClass34_14 = null;
            title2 = null;
            title3 = null;
            title4 = null;
            title0 = null;
            title1 = null;
            title5 = null;
            title6 = null;
            title7 = null;
            title8 = null;
            areaChatBack = new DrawArea(479, 96);
            aClass34_1196 = new DrawArea(172, 156);
            Draw2D.clear((byte) 127);
            mapbackImage.blit(0, 0);
            aClass34_1195 = new DrawArea(190, 261);
            areaViewport = new DrawArea(512, 334);
            Draw2D.clear((byte) 127);
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

    public void updateEntities(int i) {
        try {
            anInt1157 = 0;
            if (i < 1 || i > 1) {
                return;
            }
            for (int j = -1; j < playerCount + npcCount; j++) {
                Object obj;
                if (j == -1) {
                    obj = Game.localPlayer;
                } else if (j < playerCount) {
                    obj = players[anIntArray1227[j]];
                } else {
                    obj = npcs[anIntArray1010[j - playerCount]];
                }
                if (obj != null && ((Actor) (obj)).method535(true)) {
                    if (j < playerCount) {
                        int l = 30;
                        PlayerEntity class44_sub3_sub4_sub6_sub1 = (PlayerEntity) obj;
                        if (class44_sub3_sub4_sub6_sub1.headIcon != 0) {
                            method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                for (int i2 = 0; i2 < 8; i2++) {
                                    if ((class44_sub3_sub4_sub6_sub1.headIcon & 1 << i2) != 0) {
                                        headicons[i2].draw(anInt1064 - 12, anInt1065 - l
                                        );
                                        l -= 25;
                                    }
                                }
                            }
                        }
                        if (j >= 0 && hintIconType == 10 && anInt909 == anIntArray1227[j]) {
                            method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                headicons[7].draw(anInt1064 - 12, anInt1065 - l);
                            }
                        }
                    } else {
                        NpcType class12 = ((NPCEntity) obj).aClass12_1700;
                        if (class12.anInt305 >= 0 && class12.anInt305 < headicons.length) {
                            method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                headicons[class12.anInt305].draw(anInt1064 - 12, anInt1065 - 30
                                );
                            }
                        }
                        if (hintIconType == 1 && anInt901 == anIntArray1010[j - playerCount] && Game.loopCycle % 20 < 10) {
                            method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                            if (anInt1064 > -1) {
                                headicons[2]
                                        .draw(anInt1064 - 12, anInt1065 - 28);
                            }
                        }
                    }
                    if (((Actor) (obj)).spoken != null
                            && (j >= playerCount || publicChatSetting == 0 || publicChatSetting == 3 || publicChatSetting == 1
                            && isFriendOrSelf(((PlayerEntity) obj).name))) {
                        method74(((Actor) (obj)).anInt1661, ((Actor) (obj)), 0);
                        if (anInt1064 > -1 && anInt1157 < anInt1158) {
                            anIntArray1162[anInt1157] = fontBold.method458(
                                    ((Actor) (obj)).spoken, -725) / 2;
                            anIntArray1161[anInt1157] = fontBold.height;
                            anIntArray1159[anInt1157] = anInt1064;
                            anIntArray1160[anInt1157] = anInt1065;
                            anIntArray1163[anInt1157] = ((Actor) (obj)).spokenColour;
                            anIntArray1164[anInt1157] = ((Actor) (obj)).spokenEffect;
                            anIntArray1165[anInt1157] = ((Actor) (obj)).spokenLife;
                            aStringArray1166[anInt1157++] = ((Actor) (obj)).spoken;
                            if (anInt970 == 0 && ((Actor) (obj)).spokenEffect >= 1 && ((Actor) (obj)).spokenEffect <= 3) {
                                anIntArray1161[anInt1157] += 10;
                                anIntArray1160[anInt1157] += 5;
                            }
                            if (anInt970 == 0 && ((Actor) (obj)).spokenEffect == 4) {
                                anIntArray1162[anInt1157] = 60;
                            }
                            if (anInt970 == 0 && ((Actor) (obj)).spokenEffect == 5) {
                                anIntArray1161[anInt1157] += 5;
                            }
                        }
                    }
                    if (((Actor) (obj)).lastCombatCycle > Game.loopCycle) {
                        method74(((Actor) (obj)).anInt1661 + 15, ((Actor) (obj)), 0);
                        if (anInt1064 > -1) {
                            int i1 = (((Actor) (obj)).currentHealth * 30) / ((Actor) (obj)).maxHealth;
                            if (i1 > 30) {
                                i1 = 30;
                            }
                            Draw2D.fillRect(anInt1064 - 15, anInt1065 - 3, i1, 5, 65280, 210);
                            Draw2D.fillRect((anInt1064 - 15) + i1, anInt1065 - 3, 30 - i1, 5, 0xff0000, 210);
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
                                hitmarks[((Actor) (obj)).anIntArray1632[j1]].draw(
                                        anInt1064 - 12, anInt1065 - 12);
                                fontSmall.drawStringCenter(anInt1064,
                                        String.valueOf(((Actor) (obj)).anIntArray1631[j1]), -31546, 0, anInt1065 + 4);
                                fontSmall.drawStringCenter(anInt1064 - 1,
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
                        fontBold.drawText(s, anInt1065 + 1, (anInt1064 + 50) - k4, 0);
                        fontBold.drawText(s, anInt1065, (anInt1064 + 50) - k4, i3);
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
                                - fontBold.height - 1, 0);
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

    public void animateTexture(int i, byte byte0) {
        try {
            if (byte0 != -12) {
                startUp();
            }
            if (!Game.lowMemory) {
                if (Draw3D.anIntArray1437[17] >= i) {
                    Image8 class44_sub3_sub1_sub3 = Draw3D.aClass44_Sub3_Sub1_Sub3Array1431[17];
                    int j = class44_sub3_sub1_sub3.width * class44_sub3_sub1_sub3.height - 1;
                    int l = class44_sub3_sub1_sub3.width * delta * 2;
                    byte[] abyte0 = class44_sub3_sub1_sub3.pixels;
                    byte[] abyte2 = aByteArray1109;
                    for (int j1 = 0; j1 <= j; j1++) {
                        abyte2[j1] = abyte0[j1 - l & j];
                    }
                    class44_sub3_sub1_sub3.pixels = abyte2;
                    aByteArray1109 = abyte0;
                    Draw3D.method425(9, 17);
                }
                if (Draw3D.anIntArray1437[24] >= i) {
                    Image8 class44_sub3_sub1_sub3_1 = Draw3D.aClass44_Sub3_Sub1_Sub3Array1431[24];
                    int k = class44_sub3_sub1_sub3_1.width * class44_sub3_sub1_sub3_1.height - 1;
                    int i1 = class44_sub3_sub1_sub3_1.width * delta * 2;
                    byte[] abyte1 = class44_sub3_sub1_sub3_1.pixels;
                    byte[] abyte3 = aByteArray1109;
                    for (int k1 = 0; k1 <= k; k1++) {
                        abyte3[k1] = abyte1[k1 - i1 & k];
                    }
                    class44_sub3_sub1_sub3_1.pixels = abyte3;
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

    public void drawSplitPrivateChat() {
        try {
            if (splitPrivateChat == 0) {
                return;
            }
            BitmapFont class44_sub3_sub1_sub4 = fontPlain;
            int j = 0;
            if (systemUpdateTimer != 0) {
                j = 1;
            }
            for (int k = 0; k < 100; k++) {
                if (chatMessages[k] != null) {
                    int l = chatTypes[k];
                    String s = chatNames[k];
                    byte byte0 = 0;
                    if (s != null && s.startsWith("@cr1@")) {
                        s = s.substring(5);
                        byte0 = 1;
                    }
                    if (s != null && s.startsWith("@cr2@")) {
                        s = s.substring(5);
                        byte0 = 2;
                    }
                    if ((l == 3 || l == 7) && (l == 7 || privateChatMode == 0 || privateChatMode == 1 && isFriendOrSelf(s))) {
                        int i1 = 329 - j * 13;
                        int l1 = 4;
                        class44_sub3_sub1_sub4.drawText("From", i1, l1, 0);
                        class44_sub3_sub1_sub4.drawText("From", i1 - 1, l1, 65535);
                        l1 += class44_sub3_sub1_sub4.getTextDisplayedWidth("From ");
                        if (byte0 == 1) {
                            modicons[0].blit(i1 - 12, l1);
                            l1 += 14;
                        }
                        if (byte0 == 2) {
                            modicons[1].blit(i1 - 12, l1);
                            l1 += 14;
                        }
                        class44_sub3_sub1_sub4.drawText(s + ": " + chatMessages[k], i1, l1, 0);
                        class44_sub3_sub1_sub4
                                .drawText(s + ": " + chatMessages[k], i1 - 1, l1, 65535);
                        if (++j >= 5) {
                            return;
                        }
                    }
                    if (l == 5 && privateChatMode < 2) {
                        int j1 = 329 - j * 13;
                        class44_sub3_sub1_sub4.drawText(chatMessages[k], j1, 4, 0);
                        class44_sub3_sub1_sub4.drawText(chatMessages[k], j1 - 1, 4, 65535);
                        if (++j >= 5) {
                            return;
                        }
                    }
                    if (l == 6 && privateChatMode < 2) {
                        int k1 = 329 - j * 13;
                        class44_sub3_sub1_sub4.drawText("To " + s + ": " + chatMessages[k], k1, 4, 0);
                        class44_sub3_sub1_sub4.drawText("To " + s + ": " + chatMessages[k], k1 - 1, 4, 65535
                        );
                        if (++j >= 5) {
                            return;
                        }
                    }
                }
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("54582, " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void startThread(Runnable runnable, int i) {
        if (i > 10) {
            i = 10;
        }
        if (SignLink.mainapp != null) {
            SignLink.startthread(runnable, i);
            return;
        } else {
            super.startThread(runnable, i);
            return;
        }
    }

    public boolean animateComponent(int delta, int componentId) {
        try {
            boolean flag = false;
            Component class5 = Component.instances[componentId];
            for (int k = 0; k < class5.child.length; k++) {
                if (class5.child[k] == -1) {
                    break;
                }
                Component class5_1 = Component.instances[class5.child[k]];
                if (class5_1.type == 1) {
                    flag |= animateComponent(delta, class5_1.id);
                }
                if (class5_1.type == 6 && (class5_1.seqId != -1 || class5_1.activeSeqId != -1)) {
                    boolean flag1 = getComponentScriptState(class5_1);
                    int l;
                    if (flag1) {
                        l = class5_1.activeSeqId;
                    } else {
                        l = class5_1.seqId;
                    }
                    if (l != -1) {
                        SeqType class26 = SeqType.instances[l];
                        for (class5_1.anInt104 += delta; class5_1.anInt104 > class26.method254(class5_1.seqFrame, 24425); ) {
                            class5_1.anInt104 -= class26.method254(class5_1.seqFrame, 24425) + 1;
                            class5_1.seqFrame++;
                            if (class5_1.seqFrame >= class26.anInt509) {
                                class5_1.seqFrame -= class26.anInt513;
                                if (class5_1.seqFrame < 0 || class5_1.seqFrame >= class26.anInt509) {
                                    class5_1.seqFrame = 0;
                                }
                            }
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("91123, " + delta + ", " + componentId + ", " + runtimeexception);
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
                fontSmall.drawStringTaggableCenter(ondemand.message, w / 2, y, 0x75a9a9, true
                );
                y = h / 2 - 20;
                fontBold.drawStringTaggableCenter("Welcome to RuneScape", w / 2, y, 0xffff00, true);
                int x = w / 2 - 80;
                y = h / 2 + 20;
                titleButton.blit(y - 20, x - 73);
                fontBold.drawStringTaggableCenter("New User", x, y + 5, 0xffffff, true);
                x = w / 2 + 80;
                titleButton.blit(y - 20, x - 73);
                fontBold.drawStringTaggableCenter("Existing User", x, y + 5, 0xffffff, true);
            }
            if (loginScreenState == 2) {
                int y = h / 2 - 40;
                if (loginMessage0.length() > 0) {
                    fontBold.drawStringTaggableCenter(loginMessage0, w / 2, y - 15, 0xffff00, true);
                    fontBold.drawStringTaggableCenter(loginMessage1, w / 2, y, 0xffff00, true);
                } else {
                    fontBold.drawStringTaggableCenter(loginMessage1, w / 2, y - 7, 0xffff00, true);
                }
                y += 30;
                fontBold.drawStringTaggable("Username: " + username
                        + ((loginInputLine == 0) & (Game.loopCycle % 40 < 20) ? "@yel@|" : ""), w / 2 - 90, y, 0xffffff, true);
                y += 15;
                fontBold.drawStringTaggable("Password: " + TextUtils.toAsterisks(password)
                        + ((loginInputLine == 1) & (Game.loopCycle % 40 < 20) ? "@yel@|" : ""), w / 2 - 88, y, 0xffffff, true
                );
                y += 15;
                if (!hideButtons) {
                    int x = w / 2 - 80;
                    y = h / 2 + 50;
                    titleButton.blit(y - 20, x - 73);
                    fontBold.drawStringTaggableCenter("Login", x, y + 5, 0xffffff, true);
                    x = w / 2 + 80;
                    titleButton.blit(y - 20, x - 73);
                    fontBold.drawStringTaggableCenter("Cancel", x, y + 5, 0xffffff, true);
                }
            }
            if (loginScreenState == 3) {
                fontBold.drawStringTaggableCenter("Create a free account", w / 2, h / 2 - 60, 0xffff00, true
                );
                int y = h / 2 - 35;
                fontBold.drawStringTaggableCenter("To create a new account you need to", w / 2, y, 0xffffff, true
                );
                y += 15;
                fontBold.drawStringTaggableCenter("go back to the main RuneScape webpage", w / 2, y, 0xffffff, true
                );
                y += 15;
                fontBold.drawStringTaggableCenter("and choose the red 'create account'", w / 2, y, 0xffffff, true
                );
                y += 15;
                fontBold.drawStringTaggableCenter("button at the top right of that page.", w / 2, y, 0xffffff, true
                );
                y += 15;
                int x = w / 2;
                y = h / 2 + 50;
                titleButton.blit(y - 20, x - 73);
                fontBold.drawStringTaggableCenter("Cancel", x, y + 5, 0xffffff, true);
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

    public void processAreaPackets(Buffer in, int packetType) {
            if (packetType == 90 || packetType == 194) {
                int positionOffset = in.readUnsignedByte();
                int x = playerX + (positionOffset >> 4 & 7);
                int z = playerZ + (positionOffset & 7);
                int locInfo = in.readUnsignedByte();
                int locType = locInfo >> 2;
                int locRotation = locInfo & 3;
                int locClass = TYPE_TO_CLASS[locType];
                int locIndex;
                if (packetType == 194) {
                    locIndex = -1;
                } else {
                    locIndex = in.readUnsignedShort();
                }
                if (x >= 0 && z >= 0 && x < 104 && z < 104) {
                    createLocSpawnRequest(0, plane, locIndex, locType, z, locRotation, -1, locClass, x);
                }
                return;
            }
            if (packetType == 106) {
                int tile = in.readUnsignedByte();
                int x = playerX + (tile >> 4 & 7);
                int z = playerZ + (tile & 7);
                int locInfo = in.readUnsignedByte();
                int locType = locInfo >> 2;
                int locRotation = locInfo & 3;
                int locClass = TYPE_TO_CLASS[locType];
                int k16 = in.readUnsignedShort();
                if (x >= 0 && z >= 0 && x < 103 && z < 103) {
                    int southwestZ = planeHeightMap[plane][x][z];
                    int southeastZ = planeHeightMap[plane][x + 1][z];
                    int northeastZ = planeHeightMap[plane][x + 1][z + 1];
                    int northwestZ = planeHeightMap[plane][x][z + 1];
                    if (locClass == 0) {
                        Wall wallLoc = scene.getWallLoc(plane, false, x, z);
                        if (wallLoc != null) {
                            int uid = wallLoc.anInt579 >> 14 & 0x7fff;
                            if (locType == 2) {
                                wallLoc.primary = new GameObject(4 + locRotation, uid, 2, northwestZ, northeastZ, false, southwestZ, k16, false, southeastZ);
                                wallLoc.secondary = new GameObject(locRotation + 1 & 3, uid, 2, northwestZ, northeastZ, false, southwestZ, k16, false, southeastZ);
                            } else {
                                wallLoc.primary = new GameObject(locRotation, uid, locType, northwestZ, northeastZ, false, southwestZ, k16, false, southeastZ);
                            }
                        }
                    }
                    if (locClass == 1) {
                        WallDecoration wallDecoration = scene.getWallDecoration(z, 0, plane, x);
                        if (wallDecoration != null) {
                            wallDecoration.renderable = new GameObject(0, wallDecoration.uid >> 14 & 0x7fff, 4, northwestZ,northeastZ, false, southwestZ, k16, false, southeastZ);
                        }
                    }
                    if (locClass == 2) {
                        InteractableLoc interactiveLoc = scene.getInteractiveLoc(x, 0, z, plane);
                        if (locType == 11) {
                            locType = 10;
                        }
                        if (interactiveLoc != null) {
                            interactiveLoc.renderable = new GameObject(locRotation, interactiveLoc.uid >> 14 & 0x7fff, locType, northwestZ, northeastZ, false, southwestZ, k16, false, southeastZ);
                        }
                    }
                    if (locClass == 3) {
                        FloorDecoration floorDecoration = scene.getFloorDecoration(plane, 0, z, x);
                        if (floorDecoration != null) {
                            floorDecoration.renderable = new GameObject(locRotation, floorDecoration.anInt403 >> 14 & 0x7fff, 22, northwestZ, northeastZ, false, southwestZ, k16, false, southeastZ);
                        }
                    }
                }
                return;
            }
            if (packetType == 60) {
                int j1 = in.readUnsignedByte();
                int l3 = playerX + (j1 >> 4 & 7);
                int j6 = playerZ + (j1 & 7);
                int l8 = in.readUnsignedShort();
                int j11 = in.readUnsignedShort();
                if (l3 >= 0 && j6 >= 0 && l3 < 104 && j6 < 104) {
                    ObjStackEntity class44_sub3_sub4_sub2 = new ObjStackEntity();
                    class44_sub3_sub4_sub2.anInt1495 = l8;
                    class44_sub3_sub4_sub2.anInt1496 = j11;
                    if (planeObjStacks[plane][l3][j6] == null) {
                        planeObjStacks[plane][l3][j6] = new LinkedList(-199);
                    }
                    planeObjStacks[plane][l3][j6].pushBack(class44_sub3_sub4_sub2);
                    method92(l3, j6);
                }
                return;
            }
            if (packetType == 71) {
                int k1 = in.readUnsignedByte();
                int i4 = playerX + (k1 >> 4 & 7);
                int k6 = playerZ + (k1 & 7);
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
                int j4 = playerX + (l1 >> 4 & 7);
                int l6 = playerZ + (l1 & 7);
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
                    projectiles.pushBack(class44_sub3_sub4_sub3);
                }
                return;
            }
            if (packetType == 233) {
                int i2 = in.readUnsignedByte();
                int k4 = playerX + (i2 >> 4 & 7);
                int i7 = playerZ + (i2 & 7);
                int k9 = in.readUnsignedShort();
                int l11 = in.readUnsignedByte();
                int l13 = in.readUnsignedShort();
                if (k4 >= 0 && i7 >= 0 && k4 < 104 && i7 < 104) {
                    k4 = k4 * 128 + 64;
                    i7 = i7 * 128 + 64;
                    AnimableGameObject class44_sub3_sub4_sub5 = new AnimableGameObject(k4, plane, getFloorDrawHeight(false,
                            i7, k4, plane) - l11, l13, true, i7, k9, Game.loopCycle);
                    spotanims.pushBack(class44_sub3_sub4_sub5);
                }
                return;
            }
            if (packetType == 176) {
                int j2 = in.readUnsignedByte();
                int l4 = playerX + (j2 >> 4 & 7);
                int j7 = playerZ + (j2 & 7);
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
                    planeObjStacks[plane][l4][j7].pushBack(class44_sub3_sub4_sub2_2);
                    method92(l4, j7);
                }
                return;
            }
            if (packetType == 83) {
                int k2 = in.readUnsignedByte();
                int i5 = playerX + (k2 >> 4 & 7);
                int k7 = playerZ + (k2 & 7);
                int i10 = in.readUnsignedByte();
                int j12 = i10 >> 2;
                int j14 = i10 & 3;
                int l15 = TYPE_TO_CLASS[j12];
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
                    class44_sub3_sub4_sub6_sub1 = Game.localPlayer;
                } else {
                    class44_sub3_sub4_sub6_sub1 = players[j19];
                }
                if (class44_sub3_sub4_sub6_sub1 != null) {
                    LocType class8 = LocType.lookup(i17);
                    int k20 = planeHeightMap[plane][i5][k7];
                    int l20 = planeHeightMap[plane][i5 + 1][k7];
                    int i21 = planeHeightMap[plane][i5 + 1][k7 + 1];
                    int j21 = planeHeightMap[plane][i5][k7 + 1];
                    Model class44_sub3_sub4_sub4 = class8.method205(j12, j14, k20, l20, i21, j21, -1);
                    if (class44_sub3_sub4_sub4 != null) {
                        createLocSpawnRequest(l17 + 1, plane, -1, 0, k7, 0, k18 + 1, l15, i5);
                        class44_sub3_sub4_sub6_sub1.anInt1682 = l17 + Game.loopCycle;
                        class44_sub3_sub4_sub6_sub1.anInt1683 = k18 + Game.loopCycle;
                        class44_sub3_sub4_sub6_sub1.aClass44_Sub3_Sub4_Sub4_1687 = class44_sub3_sub4_sub4;
                        int k21 = class8.sizeX;
                        int l21 = class8.sizeZ;
                        if (j14 == 1 || j14 == 3) {
                            k21 = class8.sizeZ;
                            l21 = class8.sizeX;
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
                int j5 = playerX + (l2 >> 4 & 7);
                int l7 = playerZ + (l2 & 7);
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
                int k5 = playerX + (i3 >> 4 & 7);
                int i8 = playerZ + (i3 & 7);
                int k10 = in.readUnsignedShort();
                int l12 = in.readUnsignedByte();
                int l14 = l12 >> 4 & 0xf;
                int i16 = l12 & 7;
                if (Game.localPlayer.pathTileX[0] >= k5 - l14
                        && Game.localPlayer.pathTileX[0] <= k5 + l14
                        && Game.localPlayer.pathTileZ[0] >= i8 - l14
                        && Game.localPlayer.pathTileZ[0] <= i8 + l14
                        && aBoolean1050 && !Game.lowMemory && waveCount < 50) {
                    anIntArray846[waveCount] = k10;
                    anIntArray1006[waveCount] = i16;
                    anIntArray1193[waveCount] = SoundTrack.anIntArray92[k10];
                    waveCount++;
                    return;
                }
            }
    }

    public void createTitleBackground() {
        byte[] titleBytes = titleArchive.read("title.dat");
        Image24 sprite = new Image24(titleBytes, this);
        title0.bind();
        sprite.blitOpaque(0, 0);
        title1.bind();
        sprite.blitOpaque(-637, 0);
        title2.bind();
        sprite.blitOpaque(-128, 0);
        title3.bind();
        sprite.blitOpaque(-202, -371);
        title4.bind();
        sprite.blitOpaque(-202, -171);
        title5.bind();
        sprite.blitOpaque(0, -265);
        title6.bind();
        sprite.blitOpaque(-562, -265);
        title7.bind();
        sprite.blitOpaque(-128, -171);
        title8.bind();
        sprite.blitOpaque(-562, -171);
        int[] line = new int[sprite.width];
        for (int y = 0; y < sprite.height; y++) {
            for (int x = 0; x < sprite.width; x++) {
                line[x] = sprite.pixels[(sprite.width - x - 1) + sprite.width * y];
            }
                System.arraycopy(line, 0, sprite.pixels, sprite.width * y, sprite.width);
        }
        title0.bind();
        sprite.blitOpaque(382, 0);
        title1.bind();
        sprite.blitOpaque(-255, 0);
        title2.bind();
        sprite.blitOpaque(254, 0);
        title3.bind();
        sprite.blitOpaque(180, -371);
        title4.bind();
        sprite.blitOpaque(180, -171);
        title5.bind();
        sprite.blitOpaque(382, -265);
        title6.bind();
        sprite.blitOpaque(-180, -265);
        title7.bind();
        sprite.blitOpaque(254, -171);
        title8.bind();
        sprite.blitOpaque(-180, -171);
        sprite = new Image24(titleArchive, "logo", 0);
        title2.bind();
        sprite.draw(382 - sprite.width / 2 - 128, 18);
        sprite = null;
        System.gc();
    }

    public void renderProjectiles(byte byte0) {
        try {
            for (Projectile class44_sub3_sub4_sub3 = (Projectile) projectiles.peekFront(); class44_sub3_sub4_sub3 != null; class44_sub3_sub4_sub3 = (Projectile) projectiles
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
                            class44_sub3_sub4_sub6_sub1 = Game.localPlayer;
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
                    class44_sub3_sub4_sub3.method501(delta, -816);
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

    public void validateCharacterDesign(byte byte0) {
        try {
            updateDesignModel = true;
            for (int i = 0; i < 7; i++) {
                designIdentityKits[i] = -1;
                for (int j = 0; j < IdkType.anInt463; j++) {
                    if (IdkType.cache[j].aBoolean470 || IdkType.cache[j].anInt465 != i + (designGenderMasc ? 0 : 7)) {
                        continue;
                    }
                    designIdentityKits[i] = j;
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
                updatePlayerMasks(l, class44_sub3_sub2, k, class44_sub3_sub4_sub6_sub1);
            }
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27562, " + class44_sub3_sub2 + ", " + flag + ", " + i + ", "
                    + runtimeexception);
        }
        throw new RuntimeException();
    }

    public String getIntString(int amount) {
        if (amount < 0x3b9ac9ff) {
            return String.valueOf(amount);
        } else {
            return "*";
        }
    }

    public void addLoc(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
        try {
            if (j != 0) {
            }
            if (j1 >= 1 && l1 >= 1 && j1 <= 102 && l1 <= 102) {
                if (Game.lowMemory && l != plane) {
                    return;
                }
                int i2 = 0;
                if (k1 == 0) {
                    i2 = scene.getWallBitset(l, j1, l1);
                }
                if (k1 == 1) {
                    i2 = scene.method305(l1, 7, l, j1);
                }
                if (k1 == 2) {
                    i2 = scene.getInteractableBitset(l, j1, l1);
                }
                if (k1 == 3) {
                    i2 = scene.getGroundDecorationBitset(l, j1, l1);
                }
                if (i2 != 0) {
                    int i3 = scene.getConfig(l, j1, l1, i2);
                    int j2 = i2 >> 14 & 0x7fff;
                    int k2 = i3 & 0x1f;
                    int l2 = i3 >> 6;
                    if (k1 == 0) {
                        scene.method295(l1, j1, (byte) 7, l);
                        LocType class8 = LocType.lookup(j2);
                        if (class8.aBoolean224) {
                            collisions[l].method236(l2, k2, l1, j1, class8.aBoolean225, (byte) 3);
                        }
                    }
                    if (k1 == 1) {
                        scene.method296(537, l, l1, j1);
                    }
                    if (k1 == 2) {
                        scene.method297(2, l, l1, j1);
                        LocType class8_1 = LocType.lookup(j2);
                        if (j1 + class8_1.sizeX > 103 || l1 + class8_1.sizeX > 103
                                || j1 + class8_1.sizeZ > 103 || l1 + class8_1.sizeZ > 103) {
                            return;
                        }
                        if (class8_1.aBoolean224) {
                            collisions[l].method237(class8_1.sizeZ, l1, j1, class8_1.aBoolean225, 8, l2,
                                    class8_1.sizeX);
                        }
                    }
                    if (k1 == 3) {
                        scene.method298(j1, l1, 3, l);
                        LocType class8_2 = LocType.lookup(j2);
                        if (class8_2.aBoolean224 && class8_2.aBoolean226) {
                            collisions[l].method239(l1, true, j1);
                        }
                    }
                }
                if (i1 >= 0) {
                    int j3 = l;
                    if (j3 < 3 && (planeTileFlags[1][j1][l1] & 2) == 2) {
                        j3++;
                    }
                    Region.method174(i, l, l1, k, planeHeightMap, j3, j1, collisions[l], scene,
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
            l -= cameraPositionZ;
            k -= cameraPositionY;
            int i1 = Model.SINE[cameraVerticalRotation];
            int j1 = Model.COSINE[cameraVerticalRotation];
            int k1 = Model.SINE[cameraHorizontalRotation];
            int l1 = Model.COSINE[cameraHorizontalRotation];
            int i2 = k * k1 + i * l1 >> 16;
            k = k * l1 - i * k1 >> 16;
            i = i2;
            i2 = l * j1 - k * i1 >> 16;
            k = l * i1 + k * j1 >> 16;
            l = i2;
            if (k >= 50) {
                anInt1064 = Draw3D.centerX + (i << 9) / k;
                anInt1065 = Draw3D.centerY + (l << 9) / k;
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

    public void clearCaches(byte byte0) {
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

    public DataInputStream openJaggrabBuffer(String s) throws IOException {
        if (!jaggrabEnabled) {
            if (SignLink.mainapp != null) {
                return SignLink.openurl(s);
            } else {
                return new DataInputStream((new URL(getCodeBase(), s)).openStream());
            }
        }
        if (jaggrabSocket != null) {
            try {
                jaggrabSocket.close();
            } catch (Exception _ex) {
            }
            jaggrabSocket = null;
        }
        jaggrabSocket = openSocket(43595);
        jaggrabSocket.setSoTimeout(10000);
        InputStream in = jaggrabSocket.getInputStream();
        OutputStream out = jaggrabSocket.getOutputStream();
        out.write(("JAGGRAB /" + s + "\n\n").getBytes());
        return new DataInputStream(in);
    }

    public boolean clickInteractiveLoc(int i, int j, boolean flag, int z, int x) {
        int locId = i >> 14 & 0x7fff;
        int config = scene.getConfig(plane, x, z, i);
        if (config == -1) {
            return false;
        }
        int type = config & 0x1f;
        int rotation = config >> 6 & 3;

        if (type == 10 || type == 11 || type == 22) {
            LocType loc = LocType.lookup(locId);
            int sizeX;
            int sizeZ;
            if (rotation == 0 || rotation == 2) {
                sizeX = loc.sizeX;
                sizeZ = loc.sizeZ;
            } else {
                sizeX = loc.sizeZ;
                sizeZ = loc.sizeX;
            }
            int surroundings = loc.face;
            if (rotation != 0) {
                surroundings = (surroundings << rotation & 0xf) + (surroundings >> 4 - rotation);
            }
            tryMove(sizeX, Game.localPlayer.pathTileX[0], 0, z, surroundings, 0, false, 2, 124, sizeZ, x, Game.localPlayer.pathTileZ[0]);
        } else {
            tryMove(0, Game.localPlayer.pathTileX[0], rotation, z, 0, type + 1, false, 2, 124, 0, x, Game.localPlayer.pathTileZ[0]);
        }
        crossX = super.mousePressX;
        crossY = super.mousePressY;
        crossMode = 2;
        crossCycle = 0;
        out.writePacket(j);
        out.writeShort(x + sceneBaseTileX);
        out.writeShort(z + sceneBaseTileZ);
        out.writeShort(locId);
        return true;
    }

    public boolean waveReplay() {
        return SignLink.wavereplay();
    }

    public boolean isFriendOrSelf(String name) {
            if (name == null) {
                return false;
            }
            for (int j = 0; j < friendCount; j++) {
                if (name.equalsIgnoreCase(friendName[j])) {
                    return true;
                }
            }
            return name.equalsIgnoreCase(Game.localPlayer.name);
    }

    public void updateScrollbar(int y, int mouseX, Component component, int x, boolean redraw, int height, int mouseY, int scrollHeight) {
        if (scrollGripHeld) {
            scrollGripInputPadding = 32;
        } else {
            scrollGripInputPadding = 0;
        }
        scrollGripHeld = false;

        if (mouseX >= x && mouseX < x + 16 && mouseY >= y && mouseY < y + 16) {
            component.scrollY -= dragCycle * 4;
            if (redraw) {
                redrawInvback = true;
                return;
            }
        } else if (mouseX >= x && mouseX < x + 16 && mouseY >= (y + height) - 16 && mouseY < y + height) {
            component.scrollY += dragCycle * 4;
            if (redraw) {
                redrawInvback = true;
            }
        } else if (mouseX >= x - scrollGripInputPadding && mouseX < x + 16 + scrollGripInputPadding && mouseY >= y + 16 && mouseY < (y + height) - 16 && dragCycle > 0) {
            int gripHeight = ((height - 32) * height) / scrollHeight;
            if (gripHeight < 8) {
                gripHeight = 8;
            }
            int gripCenterY = mouseY - y - 16 - gripHeight / 2;
            int trackHeight = height - 32 - gripHeight;
            component.scrollY = ((scrollHeight - height) * gripCenterY) / trackHeight;
            if (redraw) {
                redrawInvback = true;
            }
            scrollGripHeld = true;
        }
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

    public void createLocSpawnRequest(int spawnDelay, int y, int id2, int type2, int z, int face2, int respawnDelay, int type, int x) {
            SceneLocTemporary loc = null;
            SceneLocTemporary loc_1 = (SceneLocTemporary) listTemporaryLocs.peekFront();
            for (; loc_1 != null; loc_1 = (SceneLocTemporary) listTemporaryLocs.prev(false)) {
                if (loc_1.plane != y || loc_1.sceneTileX != x || loc_1.sceneTileZ != z
                        || loc_1.locType != type) {
                    continue;
                }
                loc = loc_1;
                break;
            }
            if (loc == null) {
                loc = new SceneLocTemporary();
                loc.plane = y;
                loc.locType = type;
                loc.sceneTileX = x;
                loc.sceneTileZ = z;
                configureSpawnRequest(loc, false);
                listTemporaryLocs.pushBack(loc);
            }
            loc.id2 = id2;
            loc.type2 = type2;
            loc.face2 = face2;
            loc.delayUntilSpawn = spawnDelay;
            loc.delayUntilRespawn = respawnDelay;
    }

    public void method83(byte byte0) {
        try {
            for (int i = -1; i < playerCount; i++) {
                int j;
                if (i == -1) {
                    j = LOCAL_PLAYER_INDEX;
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
                startUp();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("82180, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void drawFlames() {
        int height = 256;
        if (flameGradientCycle0 > 0) {
            for (int index = 0; index < 256; index++) {
                if (flameGradientCycle0 > 768) {
                    flameGradient[index] = mix(flameGradient0[index], flameGradient1[index], 1024 - flameGradientCycle0);
                } else if (flameGradientCycle0 > 256) {
                    flameGradient[index] = flameGradient1[index];
                } else {
                    flameGradient[index] = mix(flameGradient1[index], flameGradient0[index], 256 - flameGradientCycle0);
                }
            }
        } else if (flameGradientCycle1 > 0) {
            for (int index = 0; index < 256; index++) {
                if (flameGradientCycle1 > 768) {
                    flameGradient[index] = mix(flameGradient0[index], flameGradient2[index], 1024 - flameGradientCycle1);
                } else if (flameGradientCycle1 > 256) {
                    flameGradient[index] = flameGradient2[index];
                } else {
                    flameGradient[index] = mix(flameGradient2[index], flameGradient0[index], 256 - flameGradientCycle1);
                }
            }
        } else {
            System.arraycopy(flameGradient0, 0, flameGradient, 0, 256);
        }
        System.arraycopy(flamesLeft.pixels, 0, title0.pixels, 0, 33920);

        int srcOffset = 0;
        int dstOffset = 1152;

        for (int y = 1; y < height - 1; y++) {
            int offset = (flameLineOffset[y] * (height - y)) / height;
            int step = 22 + offset;
            if (step < 0) {
                step = 0;
            }
            srcOffset += step;
            for (int x = step; x < 128; x++) {
                int value = flameBuffer3[srcOffset++];
                if (value != 0) {
                    int alpha = value;
                    int invAlpha = 256 - value;
                    value = flameGradient[value];
                    int background = title0.pixels[dstOffset];
                    title0.pixels[dstOffset++] = ((value & 0xff00ff) * alpha + (background & 0xff00ff) * invAlpha & 0xff00ff00)
                            + ((value & 0xff00) * alpha + (background & 0xff00) * invAlpha & 0xff0000) >> 8;
                } else {
                    dstOffset++;
                }
            }
            dstOffset += step;
        }
        title0.draw(super.graphics, 0, 0);

        System.arraycopy(flameRight.pixels, 0, title1.pixels, 0, 33920);

        srcOffset = 0;
        dstOffset = 1176;
        for (int y = 1; y < height - 1; y++) {
            int offset = (flameLineOffset[y] * (height - y)) / height;
            int step = 103 - offset;
            dstOffset += offset;
            for (int x = 0; x < step; x++) {
                int value = flameBuffer3[srcOffset++];
                if (value != 0) {
                    int alpha = value;
                    int invAlpha = 256 - value;
                    value = flameGradient[value];
                    int background = title1.pixels[dstOffset];
                    title1.pixels[dstOffset++] = ((value & 0xff00ff) * alpha + (background & 0xff00ff) * invAlpha & 0xff00ff00)
                            + ((value & 0xff00) * alpha + (background & 0xff00) * invAlpha & 0xff0000) >> 8;
                } else {
                    dstOffset++;
                }
            }
            srcOffset += 128 - step;
            dstOffset += 128 - step - offset;
        }
        title1.draw(super.graphics, 637, 0);
        return;
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

    public void setVolume(int volume) {
        SignLink.waveVolume = volume;
    }

    public void drawMinimapLoc(int i, int j, int lineColour, int l, int interactiveColour) {
        int uid = scene.getWallBitset(l, i, j);
        if (uid != 0) {
            int config = scene.getConfig(l, i, j, uid);
            int direction = config >> 6 & 3;
            int type = config & 0x1f;
            int colour = lineColour;
            if (uid > 0) {
                colour = interactiveColour;
            }
            int[] pixels = minimap.pixels;
            int pixel = 24624 + i * 4 + (103 - j) * 512 * 4;
            int locId = uid >> 14 & 0x7fff;
            LocType loc = LocType.lookup(locId);
            if (loc.mapscene != -1) {
                Image8 mapscene = mapscenes[loc.mapscene];
                if (mapscene != null) {
                    int _x = (loc.sizeX * 4 - mapscene.width) / 2;
                    int _z = (loc.sizeZ * 4 - mapscene.height) / 2;
                    mapscene.blit(48 + (104 - j - loc.sizeZ) * 4 + _z, 48 + i * 4 + _x);
                }
            } else {
                if (type == 0 || type == 2) {
                    if (direction == 0) {
                        pixels[pixel] = colour;
                        pixels[pixel + 512] = colour;
                        pixels[pixel + 1024] = colour;
                        pixels[pixel + 1536] = colour;
                    } else if (direction == 1) {
                        pixels[pixel] = colour;
                        pixels[pixel + 1] = colour;
                        pixels[pixel + 2] = colour;
                        pixels[pixel + 3] = colour;
                    } else if (direction == 2) {
                        pixels[pixel + 3] = colour;
                        pixels[pixel + 3 + 512] = colour;
                        pixels[pixel + 3 + 1024] = colour;
                        pixels[pixel + 3 + 1536] = colour;
                    } else if (direction == 3) {
                        pixels[pixel + 1536] = colour;
                        pixels[pixel + 1536 + 1] = colour;
                        pixels[pixel + 1536 + 2] = colour;
                        pixels[pixel + 1536 + 3] = colour;
                    }
                }
                if (type == 3) {
                    if (direction == 0) {
                        pixels[pixel] = colour;
                    } else if (direction == 1) {
                        pixels[pixel + 3] = colour;
                    } else if (direction == 2) {
                        pixels[pixel + 3 + 1536] = colour;
                    } else if (direction == 3) {
                        pixels[pixel + 1536] = colour;
                    }
                }
                if (type == 2) {
                    if (direction == 3) {
                        pixels[pixel] = colour;
                        pixels[pixel + 512] = colour;
                        pixels[pixel + 1024] = colour;
                        pixels[pixel + 1536] = colour;
                    } else if (direction == 0) {
                        pixels[pixel] = colour;
                        pixels[pixel + 1] = colour;
                        pixels[pixel + 2] = colour;
                        pixels[pixel + 3] = colour;
                    } else if (direction == 1) {
                        pixels[pixel + 3] = colour;
                        pixels[pixel + 3 + 512] = colour;
                        pixels[pixel + 3 + 1024] = colour;
                        pixels[pixel + 3 + 1536] = colour;
                    } else if (direction == 2) {
                        pixels[pixel + 1536] = colour;
                        pixels[pixel + 1536 + 1] = colour;
                        pixels[pixel + 1536 + 2] = colour;
                        pixels[pixel + 1536 + 3] = colour;
                    }
                }
            }
        }
        uid = scene.getInteractableBitset(l, i, j); //TODO rethink this name
        if (uid != 0) {
            int config = scene.getConfig(l, i, j, uid);
            int direction = config >> 6 & 3;
            int type = config & 0x1f;
            int locId = uid >> 14 & 0x7fff;
            LocType loc = LocType.lookup(locId);
            if (loc.mapscene != -1) {
                Image8 mapscene = mapscenes[loc.mapscene];
                if (mapscene != null) {
                    int _x = (loc.sizeX * 4 - mapscene.width) / 2;
                    int _z = (loc.sizeZ * 4 - mapscene.height) / 2;
                    mapscene.blit(48 + (104 - j - loc.sizeZ) * 4 + _z, 48 + i * 4 + _x);
                }
            } else if (type == 9) {
                int colour = 0xeeeeee;
                if (uid > 0) {
                    colour = 0xee0000;
                }
                int[] pixels = minimap.pixels;
                int pixel = 24624 + i * 4 + (103 - j) * 512 * 4;
                if (direction == 0 || direction == 2) {
                    pixels[pixel + 1536] = colour;
                    pixels[pixel + 1024 + 1] = colour;
                    pixels[pixel + 512 + 2] = colour;
                    pixels[pixel + 3] = colour;
                } else {
                    pixels[pixel] = colour;
                    pixels[pixel + 512 + 1] = colour;
                    pixels[pixel + 1024 + 2] = colour;
                    pixels[pixel + 1536 + 3] = colour;
                }
            }
        }
        uid = scene.getGroundDecorationBitset(l, i, j);
        if (uid != 0) {
            int locId = uid >> 14 & 0x7fff;
            LocType loc = LocType.lookup(locId);
            if (loc.mapscene != -1) {
                Image8 mapscene = mapscenes[loc.mapscene];
                if (mapscene != null) {
                    int _x = (loc.sizeX * 4 - mapscene.width) / 2;
                    int _z = (loc.sizeZ * 4 - mapscene.height) / 2;
                    mapscene.blit(48 + (104 - j - loc.sizeZ) * 4 + _z, 48 + i * 4 + _x);
                }
            }
        }
    }

    public void resetTitleScreen() {
        if (title2 != null) {
            return;
        }
        super.aClass34_14 = null;
        areaChatBack = null;
        aClass34_1196 = null;
        aClass34_1195 = null;
        areaViewport = null;
        aClass34_858 = null;
        aClass34_859 = null;
        aClass34_860 = null;
        title0 = new DrawArea(128, 265);
        Draw2D.clear((byte) 127);
        title1 = new DrawArea(128, 265);
        Draw2D.clear((byte) 127);
        title2 = new DrawArea(509, 171);
        Draw2D.clear((byte) 127);
        title3 = new DrawArea(360, 132);
        Draw2D.clear((byte) 127);
        title4 = new DrawArea(360, 200);
        Draw2D.clear((byte) 127);
        title5 = new DrawArea(202, 238);
        Draw2D.clear((byte) 127);
        title6 = new DrawArea(203, 238);
        Draw2D.clear((byte) 127);
        title7 = new DrawArea(74, 94);
        Draw2D.clear((byte) 127);
        title8 = new DrawArea(75, 94);
        Draw2D.clear((byte) 127);
        if (titleArchive != null) {
            createTitleBackground();
            loadTitleImages();
        }
        redrawTitleBackground = true;
    }

    public boolean getComponentScriptState(Component component) {
        if (component.scriptComparator == null) {
            return false;
        }
        for (int scriptId = 0; scriptId < component.scriptComparator.length; scriptId++) {
            int value = executeClientScript(component, scriptId);
            int operand = component.anIntArray117[scriptId];
            if (component.scriptComparator[scriptId] == 2) {
                if (value >= operand) {
                    return false;
                }
            } else if (component.scriptComparator[scriptId] == 3) {
                if (value <= operand) {
                    return false;
                }
            } else if (component.scriptComparator[scriptId] == 4) {
                if (value == operand) {
                    return false;
                }
            } else if (value != operand) {
                return false;
            }
        }
        return true;
    }

    public void processMenuHovering() {
        int width = fontBold.getTextDisplayedWidth("Choose Option");
        for (int menuRow = 0; menuRow < menuSize; menuRow++) {
            int rowWidth = fontBold.getTextDisplayedWidth(menuOption[menuRow]);
            if (rowWidth > width) {
                width = rowWidth;
            }
        }
        width += 8;
        int height = 15 * menuSize + 21;
        if (super.mousePressX > 4 && super.mousePressY > 4 && super.mousePressX < 516 && super.mousePressY < 338) {
            int x = super.mousePressX - 4 - width / 2;
            if (x + width > 512) {
                x = 512 - width;
            }
            if (x < 0) {
                x = 0;
            }
            int y = super.mousePressY - 4;
            if (y + height > 334) {
                y = 334 - height;
            }
            if (y < 0) {
                y = 0;
            }
            menuOpen = true;
            menuScreenArea = 0;
            menuOffsetX = x;
            menuOffsetY = y;
            menuWidth = width;
            menuHeight = 15 * menuSize + 22;
        }
        if (super.mousePressX > 553 && super.mousePressY > 205 && super.mousePressX < 743 && super.mousePressY < 466) {
            int x = super.mousePressX - 553 - width / 2;
            if (x < 0) {
                x = 0;
            } else if (x + width > 190) {
                x = 190 - width;
            }
            int y = super.mousePressY - 205;
            if (y < 0) {
                y = 0;
            } else if (y + height > 261) {
                y = 261 - height;
            }
            menuOpen = true;
            menuScreenArea = 1;
            menuOffsetX = x;
            menuOffsetY = y;
            menuWidth = width;
            menuHeight = 15 * menuSize + 22;
        }
        if (super.mousePressX > 17 && super.mousePressY > 357 && super.mousePressX < 496 && super.mousePressY < 453) {
            int x = super.mousePressX - 17 - width / 2;
            if (x < 0) {
                x = 0;
            } else if (x + width > 479) {
                x = 479 - width;
            }
            int y = super.mousePressY - 357;
            if (y < 0) {
                y = 0;
            } else if (y + height > 96) {
                y = 96 - height;
            }
            menuOpen = true;
            menuScreenArea = 2;
            menuOffsetX = x;
            menuOffsetY = y;
            menuWidth = width;
            menuHeight = 15 * menuSize + 22;
        }
    }

    public void method90(int i, Buffer buffer, int j) {
        try {
            while (true) {
                if (buffer.bitPosition + 10 >= i * 8) {
                    break;
                }
                int count = buffer.getBits(11);
                if (count == 2047) {
                    break;
                }
                if (players[count] == null) {
                    players[count] = new PlayerEntity();
                    if (appearanceBuffer[count] != null) {
                        players[count].updateAppearanceData(appearanceBuffer[count]);
                    }
                }
                anIntArray1227[playerCount++] = count;
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[count];
                class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                int l = buffer.getBits(5);
                if (l > 15) {
                    l -= 32;
                }
                int i1 = buffer.getBits(5);
                if (i1 > 15) {
                    i1 -= 32;
                }
                int j1 = buffer.getBits(1);
                class44_sub3_sub4_sub6_sub1.method532(Game.localPlayer.pathTileX[0] + l, j1 == 1,Game.localPlayer.pathTileZ[0] + i1, aByte925);
                int k1 = buffer.getBits(1);
                if (k1 == 1) {
                    anIntArray1229[anInt1228++] = count;
                }
            }
            buffer.method494((byte) 4);
            if (j != 0) {
                Game.anInt958 = 328;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("29713, " + i + ", " + buffer + ", " + j + ", "
                    + runtimeexception);
            throw new RuntimeException();
        }
    }

    public int mix(int i, int j, int k) {
        try {
            int i1 = 256 - k;
            return ((i & 0xff00ff) * i1 + (j & 0xff00ff) * k & 0xff00ff00)
                    + ((i & 0xff00) * i1 + (j & 0xff00) * k & 0xff0000) >> 8;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("66303, " + i + ", " + j + ", " + k + ", " + runtimeexception);
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
            ObjType class14 = ObjType.lookup(class44_sub3_sub4_sub2.anInt1495);
            int l = class14.anInt343;
            if (class14.stackable) {
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

    public void handleOnDemandRequests() {
            do {
                OnDemandNode class44_sub3_sub3;
                do {
                    class44_sub3_sub3 = ondemand.method394();
                    if (class44_sub3_sub3 == null) {
                        return;
                    }
                    if (class44_sub3_sub3.anInt1405 == 0) {
                        Model.method504(class44_sub3_sub3.aByteArray1407, class44_sub3_sub3.anInt1406, (byte) 23);
                        if ((ondemand.getModelFlags(class44_sub3_sub3.anInt1406) & 0x62) != 0) {
                            redrawInvback = true;
                            if (chatComponentId != -1) {
                                redrawChatback = true;
                            }
                        }
                    }
                    if (class44_sub3_sub3.anInt1405 == 1 && class44_sub3_sub3.aByteArray1407 != null) {
                        SeqFrame.method208(2, class44_sub3_sub3.aByteArray1407);
                    }
                    if (class44_sub3_sub3.anInt1405 == 2 && class44_sub3_sub3.anInt1406 == song
                            && class44_sub3_sub3.aByteArray1407 != null) {
                        method33((byte) 27, class44_sub3_sub3.aByteArray1407, musicFading);
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
                Region.method160(ondemand, new Buffer(class44_sub3_sub3.aByteArray1407), anInt1247);
            } while (true);
    }

    public int executeClientScript(Component component, int scriptId) {
        if (component.anIntArrayArray115 == null || scriptId >= component.anIntArrayArray115.length) {
            return -2;
        }
        try {
            int[] ai = component.anIntArrayArray115[scriptId];
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
                    if (j2 >= 0 && j2 < ObjType.total
                            && (!ObjType.lookup(j2).aBoolean344 || Game.membersWorld)) {
                        for (int i3 = 0; i3 < class5_1.containerObjId.length; i3++) {
                            if (class5_1.containerObjId[i3] == j2 + 1) {
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
                    j1 = Game.localPlayer.combatLevel;
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
                    if (k2 >= 0 && k2 < ObjType.total
                            && (!ObjType.lookup(k2).aBoolean344 || Game.membersWorld)) {
                        for (int j3 = 0; j3 < class5_2.containerObjId.length; j3++) {
                            if (class5_2.containerObjId[j3] != k2) {
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
                    j1 = (Game.localPlayer.x >> 7) + sceneBaseTileX;
                }
                if (op == 19) {
                    j1 = (Game.localPlayer.z >> 7) + sceneBaseTileZ;
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
    }

    public void method95(int i, long l) {
        try {
            if (l == 0L) {
                return;
            }
            if (friendCount >= 100 && isMembers != 1) {
                renderText("", "Your friendlist is full. Max of 100 for free users, and 200 for members", 0);
                return;
            }
            if (friendCount >= 200) {
                renderText("", "Your friendlist is full. Max of 100 for free users, and 200 for members", 0);
                return;
            }
            String s = TextUtils.formatName(TextUtils.longToName(l));
            for (int j = 0; j < friendCount; j++) {
                if (aLongArray979[j] == l) {
                    renderText("", s + " is already on your friend list", 0);
                    return;
                }
            }
            for (int k = 0; k < ignoreCount; k++) {
                if (ignoreNameLong[k] == l) {
                    renderText("", "Please remove " + s + " from your ignore list first", 0);
                    return;
                }
            }
            if (s.equals(Game.localPlayer.name)) {
                return;
            }
            friendName[friendCount] = s;
            aLongArray979[friendCount] = l;
            friendWorld[friendCount] = 0;
            if (i != 0) {
                for (int i1 = 1; i1 > 0; i1++) {
                }
            }
            friendCount++;
            redrawInvback = true;
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
                loginMessage0 = "";
                loginMessage1 = "Connecting to server...";
                drawLoginScreen(true);
            }
            connection = new Connection(openSocket(43594), 32596, this);
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
                serverSeed = in.readLong();
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
                menuOpen = false;
                super.idleTime = 0;
                for (int mes = 0; mes < 100; mes++) {
                    chatMessages[mes] = null;
                }
                objSelected = 0;
                spellSelected = 0;
                sceneState = 0;
                waveCount = 0;
                cameraAnticheatOffsetX = (int) (Math.random() * 100D) - 50;
                cameraAnticheatOffsetZ = (int) (Math.random() * 110D) - 55;
                cameraAnticheatAngle = (int) (Math.random() * 80D) - 40;
                minimapAnticheatAngle = (int) (Math.random() * 120D) - 60;
                minimapZoom = (int) (Math.random() * 30D) - 20;
                cameraHorizontal = (int) (Math.random() * 20D) - 10 & 0x7ff;
                minimapState = 0;
                minimapLevel = -1;
                flagSceneTileX = 0;
                flagSceneTileZ = 0;
                playerCount = 0;
                npcCount = 0;
                for (int i = 0; i < MAX_PLAYER_COUNT; i++) {
                    players[i] = null;
                    appearanceBuffer[i] = null;
                }
                for (int i = 0; i < MAX_NPC_COUNT; i++) {
                    npcs[i] = null;
                }
                Game.localPlayer = players[LOCAL_PLAYER_INDEX] = new PlayerEntity();
                projectiles.clear();
                spotanims.clear();
                for (int plane = 0; plane < 4; plane++) {
                    for (int x = 0; x < 104; x++) {
                        for (int z = 0; z < 104; z++) {
                            planeObjStacks[plane][x][z] = null;
                        }
                    }
                }
                listTemporaryLocs = new LinkedList(-199);
                friendlistStatus = 0;
                friendCount = 0;
                chatOverlayComponentId = -1;
                chatComponentId = -1;
                viewportComponentId = -1;
                sidebarComponentId = -1;
                viewportOverlayComponentId = -1;
                continuedDialogue = false;
                currentTab = 3;
                chatbackInputType = false;
                menuOpen = false;
                showSocialInput = false;
                modalMessage = null;
                multiCombatZone = 0;
                flashingTab = -1;
                designGenderMasc = true;
                validateCharacterDesign(aByte883);
                for (int i = 0; i < 5; i++) {
                    designColors[i] = 0;
                }
                for (int slot = 0; slot < 5; slot++) {
                    playerOptions[slot] = null;
                    playerOptionPushDown[slot] = false;
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
                prepareGameScreen(817);
                return;
            }
            if (response == 3) {
                loginMessage0 = "";
                loginMessage1 = "Invalid username or password.";
                return;
            }
            if (response == 4) {
                loginMessage0 = "Your account has been disabled.";
                loginMessage1 = "Please check your message-centre for details.";
                return;
            }
            if (response == 5) {
                loginMessage0 = "Your account is already logged in.";
                loginMessage1 = "Try again in 60 secs...";
                return;
            }
            if (response == 6) {
                loginMessage0 = "RuneScape has been updated!";
                loginMessage1 = "Please reload this page.";
                return;
            }
            if (response == 7) {
                loginMessage0 = "This world is full.";
                loginMessage1 = "Please use a different world.";
                return;
            }
            if (response == 8) {
                loginMessage0 = "Unable to connect.";
                loginMessage1 = "Login server offline.";
                return;
            }
            if (response == 9) {
                loginMessage0 = "Login limit exceeded.";
                loginMessage1 = "Too many connections from your address.";
                return;
            }
            if (response == 10) {
                loginMessage0 = "Unable to connect.";
                loginMessage1 = "Bad session id.";
                return;
            }
            if (response == 11) {
                loginMessage1 = "Login server rejected session.";
                loginMessage1 = "Please try again.";
                return;
            }
            if (response == 12) {
                loginMessage0 = "You need a members account to login to this world.";
                loginMessage1 = "Please subscribe, or use a different world.";
                return;
            }
            if (response == 13) {
                loginMessage0 = "Could not complete login.";
                loginMessage1 = "Please try using a different world.";
                return;
            }
            if (response == 14) {
                loginMessage0 = "The server is being updated.";
                loginMessage1 = "Please wait 1 minute and try again.";
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
                menuOpen = false;
                sceneLoadStartTime = System.currentTimeMillis();
                return;
            }
            if (response == 16) {
                loginMessage0 = "Login attempts exceeded.";
                loginMessage1 = "Please wait 1 minute and try again.";
                return;
            }
            if (response == 17) {
                loginMessage0 = "You are standing in a members-only area.";
                loginMessage1 = "To play on this world move to a free area first";
                return;
            }
            if (response == 20) {
                loginMessage0 = "Invalid loginserver requested";
                loginMessage1 = "Please try using a different world.";
                return;
            }
            if (response == 21) {
                for (int count = connection.read(); count >= 0; count--) {
                    loginMessage0 = "You have only just left another world";
                    loginMessage1 = "Your profile will be transferred in: " + count + " seconds";
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
                loginMessage0 = "No response from server";
                loginMessage1 = "Please try using a different world.";
                return;
            } else {
                System.out.println("response:" + response);
                loginMessage0 = "Unexpected server response";
                loginMessage1 = "Please try using a different world.";
                return;
            }
        } catch (IOException _ex) {
            loginMessage0 = "";
        }
        loginMessage1 = "Error connecting to server.";
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
                    loginMessage0 = "";
                    loginMessage1 = "Enter your username & password.";
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

    public void attemptReconnect(byte byte0) {
        try {
            if (idleLogout > 0) {
                logout();
                return;
            }
            areaViewport.bind();
            fontPlain.drawStringCenter(257, "Connection lost", -31546, 0, 144);
            fontPlain.drawStringCenter(256, "Connection lost", -31546, 0xffffff, 143);
            fontPlain.drawStringCenter(257, "Please wait - attempting to reestablish", -31546, 0, 159);
            fontPlain.drawStringCenter(256, "Please wait - attempting to reestablish", -31546, 0xffffff,
                    158);
            areaViewport.draw(super.graphics, 4, 4);
            minimapState = 0;
            if (byte0 != 7) {
                return;
            }
            flagSceneTileX = 0;
            Connection class7 = connection;
            ingame = false;
            login(username, password, true);
            if (!ingame) {
                logout();
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
                if (class44_sub1.delayUntilRespawn == -1) {
                    class44_sub1.delayUntilSpawn = 0;
                    configureSpawnRequest(class44_sub1, false);
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
            int k = class44_sub3_sub2.getBits(8);
            if (k < playerCount) {
                for (int l = k; l < playerCount; l++) {
                    anIntArray941[anInt940++] = anIntArray1227[l];
                }
            }
            if (k > playerCount) {
                SignLink.reporterror(username + " Too many players");
                throw new RuntimeException("eek");
            }
            playerCount = 0;
            for (int i1 = 0; i1 < k; i1++) {
                int j1 = anIntArray1227[i1];
                PlayerEntity class44_sub3_sub4_sub6_sub1 = players[j1];
                int k1 = class44_sub3_sub2.getBits(1);
                if (k1 == 0) {
                    anIntArray1227[playerCount++] = j1;
                    class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                } else {
                    int l1 = class44_sub3_sub2.getBits(2);
                    if (l1 == 0) {
                        anIntArray1227[playerCount++] = j1;
                        class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                        anIntArray1229[anInt1228++] = j1;
                    } else if (l1 == 1) {
                        anIntArray1227[playerCount++] = j1;
                        class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                        int i2 = class44_sub3_sub2.getBits(3);
                        class44_sub3_sub4_sub6_sub1.method533(false, i2, anInt1153);
                        int k2 = class44_sub3_sub2.getBits(1);
                        if (k2 == 1) {
                            anIntArray1229[anInt1228++] = j1;
                        }
                    } else if (l1 == 2) {
                        anIntArray1227[playerCount++] = j1;
                        class44_sub3_sub4_sub6_sub1.anInt1660 = Game.loopCycle;
                        int j2 = class44_sub3_sub2.getBits(3);
                        class44_sub3_sub4_sub6_sub1.method533(true, j2, anInt1153);
                        int l2 = class44_sub3_sub2.getBits(3);
                        class44_sub3_sub4_sub6_sub1.method533(true, l2, anInt1153);
                        int i3 = class44_sub3_sub2.getBits(1);
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
            for (int k = 0; k < class5.child.length; k++) {
                if (class5.child[k] == -1) {
                    break;
                }
                Component class5_1 = Component.instances[class5.child[k]];
                if (class5_1.type == 1) {
                    method104(class5_1.id, -44196);
                }
                class5_1.seqFrame = 0;
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
            for (int l = 0; l < npcCount; l++) {
                if (npcs[anIntArray1010[l]] == null) {
                    SignLink.reporterror(username + " null entry in npc list - pos:" + l + " size:" + npcCount);
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
                    redrawInvback = true;
                    currentTab = 0;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 569 && super.mousePressX <= 599 && super.mousePressY >= 168 && super.mousePressY < 205
                        && tabComponentId[1] != -1) {
                    redrawInvback = true;
                    currentTab = 1;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 597 && super.mousePressX <= 627 && super.mousePressY >= 168 && super.mousePressY < 205
                        && tabComponentId[2] != -1) {
                    redrawInvback = true;
                    currentTab = 2;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 625 && super.mousePressX <= 669 && super.mousePressY >= 168 && super.mousePressY < 203
                        && tabComponentId[3] != -1) {
                    redrawInvback = true;
                    currentTab = 3;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 666 && super.mousePressX <= 696 && super.mousePressY >= 168 && super.mousePressY < 205
                        && tabComponentId[4] != -1) {
                    redrawInvback = true;
                    currentTab = 4;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 694 && super.mousePressX <= 724 && super.mousePressY >= 168 && super.mousePressY < 205
                        && tabComponentId[5] != -1) {
                    redrawInvback = true;
                    currentTab = 5;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 722 && super.mousePressX <= 756 && super.mousePressY >= 169 && super.mousePressY < 205
                        && tabComponentId[6] != -1) {
                    redrawInvback = true;
                    currentTab = 6;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 540 && super.mousePressX <= 574 && super.mousePressY >= 466 && super.mousePressY < 502
                        && tabComponentId[7] != -1) {
                    redrawInvback = true;
                    currentTab = 7;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 572 && super.mousePressX <= 602 && super.mousePressY >= 466 && super.mousePressY < 503
                        && tabComponentId[8] != -1) {
                    redrawInvback = true;
                    currentTab = 8;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 599 && super.mousePressX <= 629 && super.mousePressY >= 466 && super.mousePressY < 503
                        && tabComponentId[9] != -1) {
                    redrawInvback = true;
                    currentTab = 9;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 627 && super.mousePressX <= 671 && super.mousePressY >= 467 && super.mousePressY < 502
                        && tabComponentId[10] != -1) {
                    redrawInvback = true;
                    currentTab = 10;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 669 && super.mousePressX <= 699 && super.mousePressY >= 466 && super.mousePressY < 503
                        && tabComponentId[11] != -1) {
                    redrawInvback = true;
                    currentTab = 11;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 696 && super.mousePressX <= 726 && super.mousePressY >= 466 && super.mousePressY < 503
                        && tabComponentId[12] != -1) {
                    redrawInvback = true;
                    currentTab = 12;
                    redrawSideicons = true;
                }
                if (super.mousePressX >= 724 && super.mousePressX <= 758 && super.mousePressY >= 466 && super.mousePressY < 502
                        && tabComponentId[13] != -1) {
                    redrawInvback = true;
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
            int i = class5.contentType;
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
                menuOption[menuSize] = "Remove @whi@" + friendName[i];
                menuAction[menuSize] = 513;
                menuSize++;
                menuOption[menuSize] = "Message @whi@" + friendName[i];
                menuAction[menuSize] = 902;
                menuSize++;
                return true;
            }
            if (i >= 401 && i <= 500) {
                menuOption[menuSize] = "Remove @whi@" + class5.text;
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
            for (int j = 0; j < waveCount; j++) {
                if (anIntArray1193[j] <= 0) {
                    boolean flag = false;
                    try {
                        if (anIntArray846[j] == anInt900 && anIntArray1006[j] == anInt1177) {
                            if (!waveReplay()) {
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
                        waveCount--;
                        for (int k = j; k < waveCount; k++) {
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
            if (nextSongDelay > 0) {
                nextSongDelay -= 20;
                if (nextSongDelay < 0) {
                    nextSongDelay = 0;
                }
                if (nextSongDelay == 0 && aBoolean1057 && !Game.lowMemory) {
                    song = nextSong;
                    musicFading = true;
                    ondemand.request(2, song);
                    return;
                }
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("64409, " + i + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void updateFlameBuffer(Image8 class44_sub3_sub1_sub3, int i) {
        try {
            int j = 256;
            for (int k = 0; k < flameBuffer0.length; k++) {
                flameBuffer0[k] = 0;
            }
            for (int l = 0; l < 5000; l++) {
                int i1 = (int) (Math.random() * 128D * j);
                flameBuffer0[i1] = (int) (Math.random() * 256D);
            }
            for (int j1 = 0; j1 < 20; j1++) {
                for (int k1 = 1; k1 < j - 1; k1++) {
                    for (int i2 = 1; i2 < 127; i2++) {
                        int k2 = i2 + (k1 << 7);
                        flameBuffer1[k2] = (flameBuffer0[k2 - 1] + flameBuffer0[k2 + 1]
                                + flameBuffer0[k2 - 128] + flameBuffer0[k2 + 128]) / 4;
                    }
                }
                int[] ai = flameBuffer0;
                flameBuffer0 = flameBuffer1;
                flameBuffer1 = ai;
            }
            if (i != 34809) {
                packetType = -1;
            }
            if (class44_sub3_sub1_sub3 != null) {
                int l1 = 0;
                for (int j2 = 0; j2 < class44_sub3_sub1_sub3.height; j2++) {
                    for (int l2 = 0; l2 < class44_sub3_sub1_sub3.width; l2++) {
                        if (class44_sub3_sub1_sub3.pixels[l1++] != 0) {
                            int i3 = l2 + 16 + class44_sub3_sub1_sub3.anInt1462;
                            int j3 = j2 + 16 + class44_sub3_sub1_sub3.anInt1463;
                            int k3 = i3 + (j3 << 7);
                            flameBuffer0[k3] = 0;
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
            if (Game.localPlayer.x >> 7 == flagSceneTileX
                    && Game.localPlayer.z >> 7 == flagSceneTileZ) {
                flagSceneTileX = 0;
                Game.anInt944++;
                if (Game.anInt944 > 122) {
                    Game.anInt944 = 0;
                    out.writePacket(255);
                    out.writeByte(62);
                }
            }
            int i = playerCount;
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
                    class44_sub3_sub4_sub6_sub1 = Game.localPlayer;
                    k = LOCAL_PLAYER_INDEX << 14;
                } else {
                    class44_sub3_sub4_sub6_sub1 = players[anIntArray1227[j]];
                    k = anIntArray1227[j] << 14;
                }
                if (class44_sub3_sub4_sub6_sub1 == null || !class44_sub3_sub4_sub6_sub1.method535(true)) {
                    continue;
                }
                class44_sub3_sub4_sub6_sub1.aBoolean1692 = (Game.lowMemory && playerCount > 50 || playerCount > 200)
                        && !flag1
                        && class44_sub3_sub4_sub6_sub1.anInt1640 == class44_sub3_sub4_sub6_sub1.standSeqId;
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
                int i1 = chatTypes[l];
                int j1 = (70 - k * 14) + chatScrollOffset + 4;
                if (j1 < -20) {
                    break;
                }
                String s = chatNames[l];
                if (s != null && s.startsWith("@cr1@")) {
                    s = s.substring(5);
                }
                if (s != null && s.startsWith("@cr2@")) {
                    s = s.substring(5);
                }
                if (i1 == 0) {
                    k++;
                }
                if ((i1 == 1 || i1 == 2) && (i1 == 1 || publicChatSetting == 0 || publicChatSetting == 1 && isFriendOrSelf(s))) {
                    if (j > j1 - 14 && j <= j1 && !s.equals(Game.localPlayer.name)) {
                        if (rights >= 1) {
                            menuOption[menuSize] = "Report abuse @whi@" + s;
                            menuAction[menuSize] = 524;
                            menuSize++;
                        }
                        menuOption[menuSize] = "Add ignore @whi@" + s;
                        menuAction[menuSize] = 47;
                        menuSize++;
                        menuOption[menuSize] = "Add friend @whi@" + s;
                        menuAction[menuSize] = 605;
                        menuSize++;
                    }
                    k++;
                }
                if ((i1 == 3 || i1 == 7) && splitPrivateChat == 0
                        && (i1 == 7 || privateChatMode == 0 || privateChatMode == 1 && isFriendOrSelf(s))) {
                    if (j > j1 - 14 && j <= j1) {
                        if (rights >= 1) {
                            menuOption[menuSize] = "Report abuse @whi@" + s;
                            menuAction[menuSize] = 524;
                            menuSize++;
                        }
                        menuOption[menuSize] = "Add ignore @whi@" + s;
                        menuAction[menuSize] = 47;
                        menuSize++;
                        menuOption[menuSize] = "Add friend @whi@" + s;
                        menuAction[menuSize] = 605;
                        menuSize++;
                    }
                    k++;
                }
                if (i1 == 4 && (tradeChatSetting == 0 || tradeChatSetting == 1 && isFriendOrSelf(s))) {
                    if (j > j1 - 14 && j <= j1) {
                        menuOption[menuSize] = "Accept trade @whi@" + s;
                        menuAction[menuSize] = 507;
                        menuSize++;
                    }
                    k++;
                }
                if ((i1 == 5 || i1 == 6) && splitPrivateChat == 0 && privateChatMode < 2) {
                    k++;
                }
                if (i1 == 8 && (tradeChatSetting == 0 || tradeChatSetting == 1 && isFriendOrSelf(s))) {
                    if (j > j1 - 14 && j <= j1) {
                        menuOption[menuSize] = "Accept challenge @whi@" + s;
                        menuAction[menuSize] = 957;
                        menuSize++;
                    }
                    k++;
                }
            }
            if (byte0 != 7) {
                startUp();
                return;
            }
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("6327, " + i + ", " + byte0 + ", " + j + ", " + runtimeexception);
            throw new RuntimeException();
        }
    }

    public void method112(int i, int j, PlayerEntity class44_sub3_sub4_sub6_sub1, int k, int l) {
        try {
            if (class44_sub3_sub4_sub6_sub1 == Game.localPlayer) {
                return;
            }
            if (menuSize >= 400) {
                return;
            }
            String s;
            if (class44_sub3_sub4_sub6_sub1.skillLevel == 0) {
                s = class44_sub3_sub4_sub6_sub1.name
                        + Game.method137(class44_sub3_sub4_sub6_sub1.combatLevel,
                        Game.localPlayer.combatLevel, -41081) + " (level-"
                        + class44_sub3_sub4_sub6_sub1.combatLevel + ")";
            } else {
                s = class44_sub3_sub4_sub6_sub1.name + " (skill-" + class44_sub3_sub4_sub6_sub1.skillLevel + ")";
            }
            if (objSelected == 1) {
                menuOption[menuSize] = "Use " + selectedObjName + " with @whi@" + s;
                menuAction[menuSize] = 275;
                menuParamC[menuSize] = l;
                menuParamA[menuSize] = k;
                menuParamB[menuSize] = i;
                menuSize++;
            } else if (spellSelected == 1) {
                if ((spellUsableOn & 8) == 8) {
                    menuOption[menuSize] = spellTooltip + " @whi@" + s;
                    menuAction[menuSize] = 131;
                    menuParamC[menuSize] = l;
                    menuParamA[menuSize] = k;
                    menuParamB[menuSize] = i;
                    menuSize++;
                }
            } else {
                for (int i1 = 4; i1 >= 0; i1--) {
                    if (playerOptions[i1] != null) {
                        menuOption[menuSize] = playerOptions[i1] + " @whi@" + s;
                        char c = '\0';
                        if (playerOptions[i1].equalsIgnoreCase("attack")) {
                            if (class44_sub3_sub4_sub6_sub1.combatLevel > Game.localPlayer.combatLevel) {
                                c = '\u07D0';
                            }
                            if (Game.localPlayer.team != 0
                                    && class44_sub3_sub4_sub6_sub1.team != 0) {
                                if (Game.localPlayer.team == class44_sub3_sub4_sub6_sub1.team) {
                                    c = '\u07D0';
                                } else {
                                    c = '\0';
                                }
                            }
                        } else if (playerOptionPushDown[i1]) {
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
                menuOption[j1] = "Walk here @whi@" + s;
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
            Draw3D.lineOffset = areaInvbackOffsets;
            if (byte0 != 3) {
                return;
            }
            invbackImage.blit(0, 0);
            if (sidebarComponentId != -1) {
                drawComponent(Component.instances[sidebarComponentId], 0, 0, 0);
            } else if (tabComponentId[currentTab] != -1) {
                drawComponent(Component.instances[tabComponentId[currentTab]], 0, 0, 0);
            }
            if (menuOpen && menuScreenArea == 1) {
                drawMenu();
            }
            aClass34_1195.draw(super.graphics, 553, 205);
            areaViewport.bind();
            Draw3D.lineOffset = areaViewportOffsets;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("78878, " + byte0 + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void renderStillSpotanim(int i) {
        try {
            AnimableGameObject class44_sub3_sub4_sub5 = (AnimableGameObject) spotanims.peekFront();
            if (i >= 0) {
                out.writeByte(87);
            }
            for (; class44_sub3_sub4_sub5 != null; class44_sub3_sub4_sub5 = (AnimableGameObject) spotanims
                    .prev(false)) {
                if (class44_sub3_sub4_sub5.anInt1606 != plane || class44_sub3_sub4_sub5.aBoolean1612) {
                    class44_sub3_sub4_sub5.remove();
                } else if (Game.loopCycle >= class44_sub3_sub4_sub5.anInt1605) {
                    class44_sub3_sub4_sub5.method531(922, delta);
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

    public void drawMenu() {
        int j = menuOffsetX;
        int k = menuOffsetY;
        int l = menuWidth;
        int i1 = menuHeight;
        int j1 = 0x5d5447;
        Draw2D.fillRect(j, k, l, i1, j1, 210);
        Draw2D.fillRect(j + 1, k + 1, l - 2, 16, 0, 210);
        Draw2D.drawRect(j + 1, k + 18, l - 2, i1 - 19, 0, 1);
        fontBold.drawText("Choose Option", k + 14, j + 3, j1);
        int k1 = super.mouseX;
        int l1 = super.mouseY;
        if (menuScreenArea == 0) {
            k1 -= 4;
            l1 -= 4;
        }
        if (menuScreenArea == 1) {
            k1 -= 553;
            l1 -= 205;
        }
        if (menuScreenArea == 2) {
            k1 -= 17;
            l1 -= 357;
        }
        for (int i2 = 0; i2 < menuSize; i2++) {
            int j2 = k + 31 + (menuSize - 1 - i2) * 15;
            int k2 = 0xffffff;
            if (k1 > j && k1 < j + l && l1 > j2 - 13 && l1 < j2 + 3) {
                k2 = 0xffff00;
            }
            fontBold.drawStringTaggable(menuOption[i2], j + 3, j2, k2, true);
        }
    }

    public void method116(int i) {
        try {
            for (int j = 0; j < npcCount; j++) {
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
                class44_sub3_sub4_sub6.primarySeq = -1;
                class44_sub3_sub4_sub6.spotAnimId = -1;
                class44_sub3_sub4_sub6.firstMoveCycle = 0;
                class44_sub3_sub4_sub6.lastMoveCycle = 0;
                class44_sub3_sub4_sub6.x = class44_sub3_sub4_sub6.pathTileX[0] * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.z = class44_sub3_sub4_sub6.pathTileZ[0] * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.method534(false);
            }
            if (class44_sub3_sub4_sub6 == Game.localPlayer
                    && (class44_sub3_sub4_sub6.x < 1536 || class44_sub3_sub4_sub6.z < 1536
                    || class44_sub3_sub4_sub6.x >= 11776 || class44_sub3_sub4_sub6.z >= 11776)) {
                class44_sub3_sub4_sub6.primarySeq = -1;
                class44_sub3_sub4_sub6.spotAnimId = -1;
                class44_sub3_sub4_sub6.firstMoveCycle = 0;
                class44_sub3_sub4_sub6.lastMoveCycle = 0;
                class44_sub3_sub4_sub6.x = class44_sub3_sub4_sub6.pathTileX[0] * 128
                        + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.z = class44_sub3_sub4_sub6.pathTileZ[0] * 128
                        + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.method534(false);
            }
            if (class44_sub3_sub4_sub6.firstMoveCycle > Game.loopCycle) {
                method118(5, class44_sub3_sub4_sub6);
            } else if (class44_sub3_sub4_sub6.lastMoveCycle >= Game.loopCycle) {
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
            int j = class44_sub3_sub4_sub6.firstMoveCycle - Game.loopCycle;
            if (i < 5 || i > 5) {
                planeObjStacks = null;
            }
            int k = class44_sub3_sub4_sub6.srcTileX * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
            int l = class44_sub3_sub4_sub6.srcTileZ * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
            class44_sub3_sub4_sub6.x += (k - class44_sub3_sub4_sub6.x) / j;
            class44_sub3_sub4_sub6.z += (l - class44_sub3_sub4_sub6.z) / j;
            class44_sub3_sub4_sub6.anInt1668 = 0;
            if (class44_sub3_sub4_sub6.faceDirection == 0) {
                class44_sub3_sub4_sub6.anInt1662 = 1024;
            }
            if (class44_sub3_sub4_sub6.faceDirection == 1) {
                class44_sub3_sub4_sub6.anInt1662 = 1536;
            }
            if (class44_sub3_sub4_sub6.faceDirection == 2) {
                class44_sub3_sub4_sub6.anInt1662 = 0;
            }
            if (class44_sub3_sub4_sub6.faceDirection == 3) {
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
            if (class44_sub3_sub4_sub6.lastMoveCycle == Game.loopCycle
                    || class44_sub3_sub4_sub6.primarySeq == -1
                    || class44_sub3_sub4_sub6.primarySeqDelays != 0
                    || class44_sub3_sub4_sub6.currentSeqDelay + 1 > SeqType.instances[class44_sub3_sub4_sub6.primarySeq]
                    .method254(class44_sub3_sub4_sub6.currentSeqFrame, 24425)) {
                int j = class44_sub3_sub4_sub6.lastMoveCycle - class44_sub3_sub4_sub6.firstMoveCycle;
                int k = Game.loopCycle - class44_sub3_sub4_sub6.firstMoveCycle;
                int l = class44_sub3_sub4_sub6.srcTileX * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                int i1 = class44_sub3_sub4_sub6.srcTileZ * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                int j1 = class44_sub3_sub4_sub6.dstTileX * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                int k1 = class44_sub3_sub4_sub6.dstTileZ * 128 + class44_sub3_sub4_sub6.anInt1619 * 64;
                class44_sub3_sub4_sub6.x = (l * (j - k) + j1 * k) / j;
                class44_sub3_sub4_sub6.z = (i1 * (j - k) + k1 * k) / j;
            }
            class44_sub3_sub4_sub6.anInt1668 = 0;
            if (class44_sub3_sub4_sub6.faceDirection == 0) {
                class44_sub3_sub4_sub6.anInt1662 = 1024;
            }
            if (class44_sub3_sub4_sub6.faceDirection == 1) {
                class44_sub3_sub4_sub6.anInt1662 = 1536;
            }
            if (class44_sub3_sub4_sub6.faceDirection == 2) {
                class44_sub3_sub4_sub6.anInt1662 = 0;
            }
            if (class44_sub3_sub4_sub6.faceDirection == 3) {
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
            class44_sub3_sub4_sub6.anInt1640 = class44_sub3_sub4_sub6.standSeqId;
            if (class44_sub3_sub4_sub6.anInt1664 == 0) {
                class44_sub3_sub4_sub6.anInt1668 = 0;
                return;
            }
            if (class44_sub3_sub4_sub6.primarySeq != -1 && class44_sub3_sub4_sub6.primarySeqDelays == 0) {
                SeqType class26 = SeqType.instances[class44_sub3_sub4_sub6.primarySeq];
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
            int k1 = class44_sub3_sub4_sub6.turnSeqId;
            packetSize += i;
            if (j1 >= -256 && j1 <= 256) {
                k1 = class44_sub3_sub4_sub6.walkSeqId;
            } else if (j1 >= 256 && j1 < 768) {
                k1 = class44_sub3_sub4_sub6.turnLeftSeqId;
            } else if (j1 >= -768 && j1 <= -256) {
                k1 = class44_sub3_sub4_sub6.turnRightSeqId;
            }
            if (k1 == -1) {
                k1 = class44_sub3_sub4_sub6.walkSeqId;
            }
            class44_sub3_sub4_sub6.anInt1640 = k1;
            int l1 = 4;
            if (class44_sub3_sub4_sub6.anInt1617 != class44_sub3_sub4_sub6.anInt1662
                    && class44_sub3_sub4_sub6.targetEntitiy == -1 && class44_sub3_sub4_sub6.anInt1663 != 0) {
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
            if (l1 >= 8 && class44_sub3_sub4_sub6.anInt1640 == class44_sub3_sub4_sub6.walkSeqId
                    && class44_sub3_sub4_sub6.runSeqId != -1) {
                class44_sub3_sub4_sub6.anInt1640 = class44_sub3_sub4_sub6.runSeqId;
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
            if (class44_sub3_sub4_sub6.targetEntitiy != -1 && class44_sub3_sub4_sub6.targetEntitiy < 32768) {
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[class44_sub3_sub4_sub6.targetEntitiy];
                if (class44_sub3_sub4_sub6_sub2 != null) {
                    int l = class44_sub3_sub4_sub6.x - class44_sub3_sub4_sub6_sub2.x;
                    int j1 = class44_sub3_sub4_sub6.z - class44_sub3_sub4_sub6_sub2.z;
                    if (l != 0 || j1 != 0) {
                        class44_sub3_sub4_sub6.anInt1662 = (int) (Math.atan2(l, j1) * 325.94900000000001D) & 0x7ff;
                    }
                }
            }
            if (class44_sub3_sub4_sub6.targetEntitiy >= 32768) {
                int i = class44_sub3_sub4_sub6.targetEntitiy - 32768;
                if (i == localPlayerIndex) {
                    i = LOCAL_PLAYER_INDEX;
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
            if ((class44_sub3_sub4_sub6.focusX != 0 || class44_sub3_sub4_sub6.focusZ != 0)
                    && (class44_sub3_sub4_sub6.anInt1664 == 0 || class44_sub3_sub4_sub6.anInt1668 > 0)) {
                int j = class44_sub3_sub4_sub6.x - (class44_sub3_sub4_sub6.focusX - sceneBaseTileX - sceneBaseTileX)
                        * 64;
                int i1 = class44_sub3_sub4_sub6.z - (class44_sub3_sub4_sub6.focusZ - sceneBaseTileZ - sceneBaseTileZ)
                        * 64;
                if (j != 0 || i1 != 0) {
                    class44_sub3_sub4_sub6.anInt1662 = (int) (Math.atan2(j, i1) * 325.94900000000001D) & 0x7ff;
                }
                class44_sub3_sub4_sub6.focusX = 0;
                class44_sub3_sub4_sub6.focusZ = 0;
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
                if (class44_sub3_sub4_sub6.anInt1640 == class44_sub3_sub4_sub6.standSeqId
                        && class44_sub3_sub4_sub6.anInt1617 != class44_sub3_sub4_sub6.anInt1662) {
                    if (class44_sub3_sub4_sub6.standTurnSeqId != -1) {
                        class44_sub3_sub4_sub6.anInt1640 = class44_sub3_sub4_sub6.standTurnSeqId;
                        return;
                    } else {
                        class44_sub3_sub4_sub6.anInt1640 = class44_sub3_sub4_sub6.walkSeqId;
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
                SeqType class26 = SeqType.instances[class44_sub3_sub4_sub6.anInt1640];
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
            if (class44_sub3_sub4_sub6.spotAnimId != -1 && Game.loopCycle >= class44_sub3_sub4_sub6.spotAnimEndCycle) {
                if (class44_sub3_sub4_sub6.currentSeqId < 0) {
                    class44_sub3_sub4_sub6.currentSeqId = 0;
                }
                SeqType class26_1 = SpotAnimType.cache[class44_sub3_sub4_sub6.spotAnimId].aClass26_563;
                for (class44_sub3_sub4_sub6.currentSeqDurationRemaining++; class44_sub3_sub4_sub6.currentSeqId < class26_1.anInt509
                        && class44_sub3_sub4_sub6.currentSeqDurationRemaining > class26_1.method254(class44_sub3_sub4_sub6.currentSeqId,
                        24425); class44_sub3_sub4_sub6.currentSeqId++) {
                    class44_sub3_sub4_sub6.currentSeqDurationRemaining -= class26_1.method254(class44_sub3_sub4_sub6.currentSeqId, 24425);
                }
                if (class44_sub3_sub4_sub6.currentSeqId >= class26_1.anInt509
                        && (class44_sub3_sub4_sub6.currentSeqId < 0 || class44_sub3_sub4_sub6.currentSeqId >= class26_1.anInt509)) {
                    class44_sub3_sub4_sub6.spotAnimId = -1;
                }
            }
            if (class44_sub3_sub4_sub6.primarySeq != -1 && class44_sub3_sub4_sub6.primarySeqDelays <= 1) {
                SeqType class26_2 = SeqType.instances[class44_sub3_sub4_sub6.primarySeq];
                if (class26_2.anInt520 == 1 && class44_sub3_sub4_sub6.anInt1669 > 0
                        && class44_sub3_sub4_sub6.firstMoveCycle <= Game.loopCycle
                        && class44_sub3_sub4_sub6.lastMoveCycle < Game.loopCycle) {
                    class44_sub3_sub4_sub6.primarySeqDelays = 1;
                    return;
                }
            }
            if (class44_sub3_sub4_sub6.primarySeq != -1 && class44_sub3_sub4_sub6.primarySeqDelays == 0) {
                SeqType class26_3 = SeqType.instances[class44_sub3_sub4_sub6.primarySeq];
                for (class44_sub3_sub4_sub6.currentSeqDelay++; class44_sub3_sub4_sub6.currentSeqFrame < class26_3.anInt509
                        && class44_sub3_sub4_sub6.currentSeqDelay > class26_3.method254(class44_sub3_sub4_sub6.currentSeqFrame,
                        24425); class44_sub3_sub4_sub6.currentSeqFrame++) {
                    class44_sub3_sub4_sub6.currentSeqDelay -= class26_3.method254(class44_sub3_sub4_sub6.currentSeqFrame, 24425);
                }
                if (class44_sub3_sub4_sub6.currentSeqFrame >= class26_3.anInt509) {
                    class44_sub3_sub4_sub6.currentSeqFrame -= class26_3.anInt513;
                    class44_sub3_sub4_sub6.primarySeqPlays++;
                    if (class44_sub3_sub4_sub6.primarySeqPlays >= class26_3.anInt519) {
                        class44_sub3_sub4_sub6.primarySeq = -1;
                    }
                    if (class44_sub3_sub4_sub6.currentSeqFrame < 0 || class44_sub3_sub4_sub6.currentSeqFrame >= class26_3.anInt509) {
                        class44_sub3_sub4_sub6.primarySeq = -1;
                    }
                }
                class44_sub3_sub4_sub6.aBoolean1618 = class26_3.aBoolean515;
            }
            if (class44_sub3_sub4_sub6.primarySeqDelays > 0) {
                class44_sub3_sub4_sub6.primarySeqDelays--;
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
                backleft1Area.draw(super.graphics, 0, 4);
                backleft2Area.draw(super.graphics, 0, 357);
                backright1Area.draw(super.graphics, 722, 4);
                backright2Area.draw(super.graphics, 743, 205);
                backtop1Area.draw(super.graphics, 0, 0);
                backvmid1Area.draw(super.graphics, 516, 4);
                backvmid2Area.draw(super.graphics, 516, 205);
                backvmid3Area.draw(super.graphics, 496, 357);
                backhmid2Area.draw(super.graphics, 0, 338);
                redrawInvback = true;
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
            if (menuOpen && menuScreenArea == 1) {
                redrawInvback = true;
            }
            if (sidebarComponentId != -1) {
                boolean flag1 = animateComponent(delta, sidebarComponentId);
                if (flag1) {
                    redrawInvback = true;
                }
            }
            if (containerComponentType == 2) {
                redrawInvback = true;
            }
            if (objDragArea == 2) {
                redrawInvback = true;
            }
            if (redrawInvback) {
                method113((byte) 3);
                redrawInvback = false;
            }
            if (chatComponentId == -1) {
                aClass5_1201.scrollY = chatScrollHeight - chatScrollOffset - 77;
                if (super.mouseX > 448 && super.mouseX < 560 && super.mouseY > 332) {
                    updateScrollbar(0, super.mouseX - 17, aClass5_1201, 463, false, 77, super.mouseY - 357,
                            chatScrollHeight);
                }
                int i = chatScrollHeight - 77 - aClass5_1201.scrollY;
                if (i < 0) {
                    i = 0;
                }
                if (i > chatScrollHeight - 77) {
                    i = chatScrollHeight - 77;
                }
                if (chatScrollOffset != i) {
                    chatScrollOffset = i;
                    redrawChatback = true;
                }
            }
            if (chatComponentId != -1) {
                boolean flag2 = animateComponent(delta, chatComponentId);
                if (flag2) {
                    redrawChatback = true;
                }
            }
            if (containerComponentType == 3) {
                redrawChatback = true;
            }
            if (objDragArea == 3) {
                redrawChatback = true;
            }
            if (modalMessage != null) {
                redrawChatback = true;
            }
            if (menuOpen && menuScreenArea == 2) {
                redrawChatback = true;
            }
            if (redrawChatback) {
                drawChatback(311);
                redrawChatback = false;
            }
            if (sceneState == 2) {
                method36(0);
                aClass34_1196.draw(super.graphics, 550, 4);
            }
            if (flashingTab != -1) {
                redrawSideicons = true;
            }
            if (redrawSideicons) {
                if (flashingTab != -1 && flashingTab == currentTab) {
                    flashingTab = -1;
                    out.writePacket(146);
                    out.writeByte(currentTab);
                }
                redrawSideicons = false;
                aClass34_860.bind();
                backhmid1Image.blit(0, 0);
                if (sidebarComponentId == -1) {
                    if (tabComponentId[currentTab] != -1) {
                        if (currentTab == 0) {
                            redstone0Image.blit(10, 22);
                        }
                        if (currentTab == 1) {
                            redstone1Image.blit(8, 54);
                        }
                        if (currentTab == 2) {
                            redstone1Image.blit(8, 82);
                        }
                        if (currentTab == 3) {
                            redstone2Image.blit(8, 110);
                        }
                        if (currentTab == 4) {
                            redstone4Image.blit(8, 153);
                        }
                        if (currentTab == 5) {
                            redstone4Image.blit(8, 181);
                        }
                        if (currentTab == 6) {
                            redstone3Image.blit(9, 209);
                        }
                    }
                    if (tabComponentId[0] != -1 && (flashingTab != 0 || Game.loopCycle % 20 < 10)) {
                        sideicons[0].blit(13, 29);
                    }
                    if (tabComponentId[1] != -1 && (flashingTab != 1 || Game.loopCycle % 20 < 10)) {
                        sideicons[1].blit(11, 53);
                    }
                    if (tabComponentId[2] != -1 && (flashingTab != 2 || Game.loopCycle % 20 < 10)) {
                        sideicons[2].blit(11, 82);
                    }
                    if (tabComponentId[3] != -1 && (flashingTab != 3 || Game.loopCycle % 20 < 10)) {
                        sideicons[3].blit(12, 115);
                    }
                    if (tabComponentId[4] != -1 && (flashingTab != 4 || Game.loopCycle % 20 < 10)) {
                        sideicons[4].blit(13, 153);
                    }
                    if (tabComponentId[5] != -1 && (flashingTab != 5 || Game.loopCycle % 20 < 10)) {
                        sideicons[5].blit(11, 180);
                    }
                    if (tabComponentId[6] != -1 && (flashingTab != 6 || Game.loopCycle % 20 < 10)) {
                        sideicons[6].blit(13, 208);
                    }
                }
                aClass34_860.draw(super.graphics, 516, 160);
                aClass34_859.bind();
                backbase2Image.blit(0, 0);
                if (sidebarComponentId == -1) {
                    if (tabComponentId[currentTab] != -1) {
                        if (currentTab == 7) {
                            redstone5Image.blit(0, 42);
                        }
                        if (currentTab == 8) {
                            redstone6Image.blit(0, 74);
                        }
                        if (currentTab == 9) {
                            redstone6Image.blit(0, 102);
                        }
                        if (currentTab == 10) {
                            redstone7Image.blit(1, 130);
                        }
                        if (currentTab == 11) {
                            redstone9Image.blit(0, 173);
                        }
                        if (currentTab == 12) {
                            redstone9Image.blit(0, 201);
                        }
                        if (currentTab == 13) {
                            redstone8Image.blit(0, 229);
                        }
                    }
                    if (tabComponentId[8] != -1 && (flashingTab != 8 || Game.loopCycle % 20 < 10)) {
                        sideicons[7].blit(2, 74);
                    }
                    if (tabComponentId[9] != -1 && (flashingTab != 9 || Game.loopCycle % 20 < 10)) {
                        sideicons[8].blit(3, 102);
                    }
                    if (tabComponentId[10] != -1 && (flashingTab != 10 || Game.loopCycle % 20 < 10)) {
                        sideicons[9].blit(4, 137);
                    }
                    if (tabComponentId[11] != -1 && (flashingTab != 11 || Game.loopCycle % 20 < 10)) {
                        sideicons[10].blit(2, 174);
                    }
                    if (tabComponentId[12] != -1 && (flashingTab != 12 || Game.loopCycle % 20 < 10)) {
                        sideicons[11].blit(2, 201);
                    }
                    if (tabComponentId[13] != -1 && (flashingTab != 13 || Game.loopCycle % 20 < 10)) {
                        sideicons[12].blit(2, 226);
                    }
                }
                aClass34_859.draw(super.graphics, 496, 466);
                areaViewport.bind();
            }
            if (redrawPrivacySettings) {
                redrawPrivacySettings = false;
                aClass34_858.bind();
                backbase1Image.blit(0, 0);
                fontPlain.drawStringTaggableCenter("Public chat", 55, 28, 0xffffff, true);
                if (publicChatSetting == 0) {
                    fontPlain.drawStringTaggableCenter("On", 55, 41, 65280, true);
                }
                if (publicChatSetting == 1) {
                    fontPlain.drawStringTaggableCenter("Friends", 55, 41, 0xffff00, true);
                }
                if (publicChatSetting == 2) {
                    fontPlain.drawStringTaggableCenter("Off", 55, 41, 0xff0000, true);
                }
                if (publicChatSetting == 3) {
                    fontPlain.drawStringTaggableCenter("Hide", 55, 41, 65535, true);
                }
                fontPlain.drawStringTaggableCenter("Private chat", 184, 28, 0xffffff, true);
                if (privateChatMode == 0) {
                    fontPlain.drawStringTaggableCenter("On", 184, 41, 65280, true);
                }
                if (privateChatMode == 1) {
                    fontPlain.drawStringTaggableCenter("Friends", 184, 41, 0xffff00, true);
                }
                if (privateChatMode == 2) {
                    fontPlain.drawStringTaggableCenter("Off", 184, 41, 0xff0000, true);
                }
                fontPlain.drawStringTaggableCenter("Trade/compete", 324, 28, 0xffffff, true);
                if (tradeChatSetting == 0) {
                    fontPlain.drawStringTaggableCenter("On", 324, 41, 65280, true);
                }
                if (tradeChatSetting == 1) {
                    fontPlain.drawStringTaggableCenter("Friends", 324, 41, 0xffff00, true);
                }
                if (tradeChatSetting == 2) {
                    fontPlain.drawStringTaggableCenter("Off", 324, 41, 0xff0000, true);
                }
                fontPlain.drawStringTaggableCenter("Report abuse", 458, 33, 0xffffff, true);
                aClass34_858.draw(super.graphics, 0, 453);
                areaViewport.bind();
            }
            delta = 0;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27122, " + flag + ", " + runtimeexception);
        } catch (Exception e) {
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
            int[][] ai = collisions[plane].flags;
            while (i4 != l3) {
                j3 = anIntArray1020[i4];
                k3 = anIntArray1021[i4];
                i4 = (i4 + 1) % j4;
                if (j3 == j2 && k3 == l) {
                    flag1 = true;
                    break;
                }
                if (j1 != 0) {
                    if ((j1 < 5 || j1 == 10) && collisions[plane].method240(l, k, j1 - 1, j2, k3, j3, -628)) {
                        flag1 = true;
                        break;
                    }
                    if (j1 < 10 && collisions[plane].method241((byte) -58, j2, k3, l, j1 - 1, k, j3)) {
                        flag1 = true;
                        break;
                    }
                }
                if (i != 0 && i2 != 0
                        && collisions[plane].method242(i, l, k3, Game.anInt958, i2, j3, i1, j2)) {
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

    public FileArchive loadArchive(int i, String s, String s1, int k, int j) {
        byte[] abyte0 = null;
        int l = 5;
        try {
            if (filestores[0] != null) {
                abyte0 = filestores[0].method541(false, i);
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
            showProgress(j, "Requesting " + s);
            try {
                int k1 = 0;
                DataInputStream datainputstream = openJaggrabBuffer(s1 + k);
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
                        showProgress(j, "Loading " + s + " - " + k3 + "%");
                    }
                    k1 = k3;
                }
                datainputstream.close();
                try {
                    if (filestores[0] != null) {
                        filestores[0].method542(abyte0, (byte) 4, abyte0.length, i);
                    }
                } catch (Exception _ex) {
                    filestores[0] = null;
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
                        showProgress(j, "Game updated - please reload page");
                        l1 = 10;
                    } else {
                        showProgress(j, s2 + " - Retrying in " + l1);
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
                jaggrabEnabled = !jaggrabEnabled;
            }
        }
        FileArchive class47_1 = new FileArchive(abyte0, 0);
        return class47_1;
    }


    public int getWorldDrawPlane() {
        try {
            int worldPlane = 3;

            if (cameraVerticalRotation < 310) {
                int cameraX = cameraPositionX >> 7;
                int cameraZ = cameraPositionY >> 7;
                int playerX = localPlayer.x >> 7;
                int playerZ = localPlayer.z >> 7;
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
            if ((planeTileFlags[this.plane][Game.localPlayer.x >> 7][Game.localPlayer.z >> 7] & 4) != 0) {
                worldPlane = this.plane;
            }
            return worldPlane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getCameraPlaneCutscene(byte byte0) {
        try {
            if (byte0 == 7) {
                byte0 = 0;
            } else {
                return 2;
            }
            int i = getFloorDrawHeight(false, cameraPositionY, cameraPositionX, plane);
            if (i - cameraPositionZ < 800 && (planeTileFlags[plane][cameraPositionX >> 7][cameraPositionY >> 7] & 4) != 0) {
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
            flameActive = false;
            while (aBoolean893) {
                flameActive = false;
                try {
                    Thread.sleep(50L);
                } catch (Exception _ex) {
                }
            }
            titleBox = null;
            titleButton = null;
            imageRunes = null;
            flameGradient = null;
            flameGradient0 = null;
            flameGradient1 = null;
            flameGradient2 = null;
            flameBuffer0 = null;
            flameBuffer1 = null;
            flameBuffer3 = null;
            if (flag) {
                out.writeByte(203);
            }
            flameBuffer2 = null;
            flamesLeft = null;
            flameRight = null;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("94958, " + flag + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    @Override
    public void run() {
        if (flamesThread) {
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
                minimapLevel = -1;
                spotanims.clear();
                projectiles.clear();
                Draw3D.method421(false);
                clearCaches(aByte1042);
                scene.reset(true);
                for (int j = 0; j < 4; j++) {
                    collisions[j].reset(3);
                }
                System.gc();
                Region class3 = new Region(planeHeightMap, 104, (byte) 9, planeTileFlags, 104);
                int k1 = sceneMapLandData.length;
                Region.aBoolean64 = Scene.aBoolean606;
                for (int j2 = 0; j2 < k1; j2++) {
                    int l2 = sceneMapIndex[j2] >> 8;
                    int k3 = sceneMapIndex[j2] & 0xff;
                    if (l2 == 33 && k3 >= 71 && k3 <= 73) {
                        Region.aBoolean64 = false;
                    }
                }
                if (Region.aBoolean64) {
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
                        class3.method161(l6, j6, abyte1, scene, (byte) 4, collisions);
                    }
                }
                //aClass44_Sub3_Sub2_850.writePacket(181);
                class3.method163((byte) 76, collisions, scene);
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
                int k = ondemand.getFileCount(0);
                for (int i1 = 0; i1 < k; i1++) {
                    int l1 = ondemand.getModelFlags(i1);
                    if ((l1 & 0x79) == 0) {
                        Model.method505((byte) 63, i1);
                    }
                }
            }
            System.gc();
            Draw3D.initPool(20);
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
                        int j5 = ondemand.getMapFile(0, j4, j3);
                        if (j5 != -1) {
                            ondemand.method397(j5, 3, (byte) 6);
                        }
                        int i6 = ondemand.getMapFile(1, j4, j3);
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
            int j = class44_sub3_sub2.getBits(1);
            if (j == 0) {
                return;
            }
            int k = class44_sub3_sub2.getBits(2);
            if (flag) {
                packetType = class44_sub3_sub2.readUnsignedByte();
            }
            if (k == 0) {
                anIntArray1229[anInt1228++] = LOCAL_PLAYER_INDEX;
                return;
            }
            if (k == 1) {//walk
                int l = class44_sub3_sub2.getBits(3);//direction
                Game.localPlayer.method533(false, l, anInt1153);
                int k1 = class44_sub3_sub2.getBits(1);//update req
                if (k1 == 1) {
                    anIntArray1229[anInt1228++] = LOCAL_PLAYER_INDEX;
                }
                return;
            }
            if (k == 2) {//run
                int i1 = class44_sub3_sub2.getBits(3);//last
                Game.localPlayer.method533(true, i1, anInt1153);
                int l1 = class44_sub3_sub2.getBits(3);//curr
                Game.localPlayer.method533(true, l1, anInt1153);
                int j2 = class44_sub3_sub2.getBits(1);//update req
                if (j2 == 1) {
                    anIntArray1229[anInt1228++] = LOCAL_PLAYER_INDEX;
                }
                return;
            }
            if (k == 3) {//teleport
                plane = class44_sub3_sub2.getBits(2);//plane
                int j1 = class44_sub3_sub2.getBits(7);//x?
                int i2 = class44_sub3_sub2.getBits(7);//y?
                int k2 = class44_sub3_sub2.getBits(1);//clear waypoint
                Game.localPlayer.method532(j1, k2 == 1, i2, aByte925);
                int l2 = class44_sub3_sub2.getBits(1);//update req
                if (l2 == 1) {
                    anIntArray1229[anInt1228++] = LOCAL_PLAYER_INDEX;
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
            if (cameraPositionZ < l) {
                cameraPositionZ += anInt1121 + ((l - cameraPositionZ) * anInt1122) / 1000;
                if (cameraPositionZ > l) {
                    cameraPositionZ = l;
                }
            }
            if (cameraPositionZ > l) {
                cameraPositionZ -= anInt1121 + ((cameraPositionZ - l) * anInt1122) / 1000;
                if (cameraPositionZ < l) {
                    cameraPositionZ = l;
                }
            }
            if (cameraPositionY < k) {
                cameraPositionY += anInt1121 + ((k - cameraPositionY) * anInt1122) / 1000;
                if (cameraPositionY > k) {
                    cameraPositionY = k;
                }
            }
            if (cameraPositionY > k) {
                cameraPositionY -= anInt1121 + ((cameraPositionY - k) * anInt1122) / 1000;
                if (cameraPositionY < k) {
                    cameraPositionY = k;
                }
            }
            j = anInt989 * 128 + 64;
            k = anInt990 * 128 + 64;
            l = getFloorDrawHeight(false, k, j, plane) - anInt991;
            int i1 = j - cameraPositionX;
            int j1 = l - cameraPositionZ;
            int k1 = k - cameraPositionY;
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
            int k2 = j2 - cameraHorizontalRotation;
            if (k2 > 1024) {
                k2 -= 2048;
            }
            if (k2 < -1024) {
                k2 += 2048;
            }
            if (k2 > 0) {
                cameraHorizontalRotation += anInt992 + (k2 * anInt993) / 1000;
                cameraHorizontalRotation &= 0x7ff;
            }
            if (k2 < 0) {
                cameraHorizontalRotation -= anInt992 + (-k2 * anInt993) / 1000;
                cameraHorizontalRotation &= 0x7ff;
            }
            int l2 = j2 - cameraHorizontalRotation;
            if (l2 > 1024) {
                l2 -= 2048;
            }
            if (l2 < -1024) {
                l2 += 2048;
            }
            if (l2 < 0 && k2 > 0 || l2 > 0 && k2 < 0) {
                cameraHorizontalRotation = j2;
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
                if (viewportComponentId != -1 && viewportComponentId == anInt1217) {
                    if (j == 8 && reportAbuseInput.length() > 0) {
                        reportAbuseInput = reportAbuseInput.substring(0, reportAbuseInput.length() - 1);
                    }
                    if ((j >= 97 && j <= 122 || j >= 65 && j <= 90 || j >= 48 && j <= 57 || j == 32)
                            && reportAbuseInput.length() < 12) {
                        reportAbuseInput += (char) j;
                    }
                } else if (showSocialInput) {
                    if (j >= 32 && j <= 122 && socialInput.length() < 80) {
                        socialInput += (char) j;
                        redrawChatback = true;
                    }
                    if (j == 8 && socialInput.length() > 0) {
                        socialInput = socialInput.substring(0, socialInput.length() - 1);
                        redrawChatback = true;
                    }
                    if (j == 13 || j == 10) {
                        showSocialInput = false;
                        redrawChatback = true;
                        if (anInt880 == 1) {
                            long l = TextUtils.encodeBase37(socialInput);
                            method95(0, l);
                        }
                        if (anInt880 == 2 && friendCount > 0) {
                            long l1 = TextUtils.encodeBase37(socialInput);
                            method44(l1, 37517);
                        }
                        if (anInt880 == 3 && socialInput.length() > 0) {
                            out.writePacket(107);
                            out.writeByte(0);
                            int k = out.position;
                            out.method478(aLong967, true);
                            ChatCompression.method557(socialInput, out, 991);
                            out.method481(out.position - k, anInt1152);
                            socialInput = ChatCompression.method558(socialInput, anInt1242);
                            socialInput = ChatCensor.censor(socialInput);
                            renderText(TextUtils.formatName(TextUtils.longToName(aLong967)), socialInput, 6
                            );
                            if (privateChatMode == 2) {
                                privateChatMode = 1;
                                redrawPrivacySettings = true;
                                out.writePacket(161);
                                out.writeByte(publicChatSetting);
                                out.writeByte(privateChatMode);
                                out.writeByte(tradeChatSetting);
                            }
                        }
                        if (anInt880 == 4 && ignoreCount < 100) {
                            long l2 = TextUtils.encodeBase37(socialInput);
                            method55((byte) -37, l2);
                        }
                        if (anInt880 == 5 && ignoreCount > 0) {
                            long l3 = TextUtils.encodeBase37(socialInput);
                            method142(-197, l3);
                        }
                    }
                } else if (chatbackInputType) {
                    if (j >= 48 && j <= 57 && chatBackInput.length() < 10) {
                        chatBackInput += (char) j;
                        redrawChatback = true;
                    }
                    if (j == 8 && chatBackInput.length() > 0) {
                        chatBackInput = chatBackInput.substring(0, chatBackInput.length() - 1);
                        redrawChatback = true;
                    }
                    if (j == 13 || j == 10) {
                        if (chatBackInput.length() > 0) {
                            int i1 = 0;
                            try {
                                i1 = Integer.parseInt(chatBackInput);
                            } catch (Exception _ex) {
                            }
                            out.writePacket(180);
                            out.writeInt(i1);
                        }
                        chatbackInputType = false;
                        redrawChatback = true;
                    }
                } else if (chatComponentId == -1) {
                    if (j >= 32 && j <= 122 && chatTyped.length() < 80) {
                        chatTyped += (char) j;
                        redrawChatback = true;
                    }
                    if (j == 8 && chatTyped.length() > 0) {
                        chatTyped = chatTyped.substring(0, chatTyped.length() - 1);
                        redrawChatback = true;
                    }
                    if ((j == 13 || j == 10) && chatTyped.length() > 0) {
                        if (rights == 2) {
                            if (chatTyped.equals("::clientdrop")) {
                                attemptReconnect((byte) 7);
                            }
                            if (chatTyped.equals("::lag")) {
                                method29((byte) -11);
                            }
                            if (chatTyped.equals("::prefetchmusic")) {
                                for (int j1 = 0; j1 < ondemand.getFileCount(2); j1++) {
                                    ondemand.prefetch((byte) 1, j1, 2);
                                }
                            }
                        }
                        if (chatTyped.startsWith("::")) {
                            out.writePacket(34);
                            out.writeByte(chatTyped.length() - 1);
                            out.writeString(chatTyped.substring(2));
                        } else {
                            String s = chatTyped.toLowerCase();
                            int k1 = 0;
                            if (s.startsWith("yellow:")) {
                                k1 = 0;
                                chatTyped = chatTyped.substring(7);
                            } else if (s.startsWith("red:")) {
                                k1 = 1;
                                chatTyped = chatTyped.substring(4);
                            } else if (s.startsWith("green:")) {
                                k1 = 2;
                                chatTyped = chatTyped.substring(6);
                            } else if (s.startsWith("cyan:")) {
                                k1 = 3;
                                chatTyped = chatTyped.substring(5);
                            } else if (s.startsWith("purple:")) {
                                k1 = 4;
                                chatTyped = chatTyped.substring(7);
                            } else if (s.startsWith("white:")) {
                                k1 = 5;
                                chatTyped = chatTyped.substring(6);
                            } else if (s.startsWith("flash1:")) {
                                k1 = 6;
                                chatTyped = chatTyped.substring(7);
                            } else if (s.startsWith("flash2:")) {
                                k1 = 7;
                                chatTyped = chatTyped.substring(7);
                            } else if (s.startsWith("flash3:")) {
                                k1 = 8;
                                chatTyped = chatTyped.substring(7);
                            } else if (s.startsWith("glow1:")) {
                                k1 = 9;
                                chatTyped = chatTyped.substring(6);
                            } else if (s.startsWith("glow2:")) {
                                k1 = 10;
                                chatTyped = chatTyped.substring(6);
                            } else if (s.startsWith("glow3:")) {
                                k1 = 11;
                                chatTyped = chatTyped.substring(6);
                            }
                            s = chatTyped.toLowerCase();
                            int i2 = 0;
                            if (s.startsWith("wave:")) {
                                i2 = 1;
                                chatTyped = chatTyped.substring(5);
                            } else if (s.startsWith("wave2:")) {
                                i2 = 2;
                                chatTyped = chatTyped.substring(6);
                            } else if (s.startsWith("shake:")) {
                                i2 = 3;
                                chatTyped = chatTyped.substring(6);
                            } else if (s.startsWith("scroll:")) {
                                i2 = 4;
                                chatTyped = chatTyped.substring(7);
                            } else if (s.startsWith("slide:")) {
                                i2 = 5;
                                chatTyped = chatTyped.substring(6);
                            }
                            out.writePacket(156);
                            out.writeByte(0);
                            int j2 = out.position;
                            out.writeByte(k1);
                            out.writeByte(i2);
                            ChatCompression.method557(chatTyped, out, 991);
                            out.method481(out.position - j2, anInt1152);
                            chatTyped = ChatCompression.method558(chatTyped, anInt1242);
                            chatTyped = ChatCensor.censor(chatTyped);
                            Game.localPlayer.spoken = chatTyped;
                            Game.localPlayer.spokenColour = k1;
                            Game.localPlayer.spokenEffect = i2;
                            Game.localPlayer.spokenLife = 150;
                            if (rights == 2) {
                                renderText("@cr2@"
                                        + Game.localPlayer.name, Game.localPlayer.spoken, 2
                                );
                            } else if (rights == 1) {
                                renderText("@cr1@"
                                        + Game.localPlayer.name, Game.localPlayer.spoken, 2
                                );
                            } else {
                                renderText(Game.localPlayer.name, Game.localPlayer.spoken, 2
                                );
                            }
                            if (publicChatSetting == 2) {
                                publicChatSetting = 3;
                                redrawPrivacySettings = true;
                                out.writePacket(161);
                                out.writeByte(publicChatSetting);
                                out.writeByte(privateChatMode);
                                out.writeByte(tradeChatSetting);
                            }
                        }
                        chatTyped = "";
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
            if (errorStarted || errorLoading || aBoolean820) {
                method53(9);
                return;
            }
            Game.anInt1175++;
            if (!ingame) {
                drawLoginScreen(false);
            } else {
                method123(false);
            }
            dragCycle = 0;
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
            if (chatbackInputType) {
                chatbackInputType = false;
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
                clickInteractiveLoc(c, 45, false, b, a);
            }
            if (action == 718) {
                if (!menuOpen) {
                    scene.method316(super.mousePressY - 4, super.mousePressX - 4);
                } else {
                    scene.method316(b - 4, a - 4);
                }
            }
            if (action == 131) {
                PlayerEntity player = players[c];
                if (player != null) {
                    tryMove(1, Game.localPlayer.pathTileX[0], 0,
                            player.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            player.pathTileX[0],
                            Game.localPlayer.pathTileZ[0]);
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
                String s = menuOption[option];
                int l1 = s.indexOf("@whi@");
                if (l1 != -1) {
                    s = s.substring(l1 + 5).trim();
                    String s8 = TextUtils.formatName(TextUtils.longToName(TextUtils.encodeBase37(s)));
                    boolean flag4 = false;
                    for (int k3 = 0; k3 < playerCount; k3++) {
                        PlayerEntity class44_sub3_sub4_sub6_sub1_3 = players[anIntArray1227[k3]];
                        if (class44_sub3_sub4_sub6_sub1_3 == null || class44_sub3_sub4_sub6_sub1_3.name == null
                                || !class44_sub3_sub4_sub6_sub1_3.name.equalsIgnoreCase(s8)) {
                            continue;
                        }
                        tryMove(1, Game.localPlayer.pathTileX[0], 0,
                                class44_sub3_sub4_sub6_sub1_3.pathTileZ[0], 0, 0, false, 2, 124, 1,
                                class44_sub3_sub4_sub6_sub1_3.pathTileX[0],
                                Game.localPlayer.pathTileZ[0]);
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
                        renderText("", "Unable to find " + s8, 0);
                    }
                }
            }
            if (action == 625) {
                clickInteractiveLoc(c, 10, false, b, a);
            }
            if (action == 1152) {
                ObjType class14 = ObjType.lookup(c);
                String s4;
                if (class14.aByteArray332 != null) {
                    s4 = new String(class14.aByteArray332);
                } else {
                    s4 = "It's a " + class14.name + ".";
                }
                renderText("", s4, 0);
            }
            if (action == 737) {
                method28(3);
            }
            if (action == 902) {
                String s1 = menuOption[option];
                int i2 = s1.indexOf("@whi@");
                if (i2 != -1) {
                    long l3 = TextUtils.encodeBase37(s1.substring(i2 + 5).trim());
                    int i4 = -1;
                    for (int j4 = 0; j4 < friendCount; j4++) {
                        if (aLongArray979[j4] != l3) {
                            continue;
                        }
                        i4 = j4;
                        break;
                    }
                    if (i4 != -1 && friendWorld[i4] > 0) {
                        redrawChatback = true;
                        chatbackInputType = false;
                        showSocialInput = true;
                        socialInput = "";
                        anInt880 = 3;
                        aLong967 = aLongArray979[i4];
                        socialMessage = "Enter message to send to " + friendName[i4];
                    }
                }
            }
            if (action == 605 || action == 47 || action == 513 || action == 884) {
                String s2 = menuOption[option];
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
                containerComponentId = b;
                containerIndex = a;
                containerComponentType = 2;
                if (Component.instances[b].anInt106 == viewportComponentId) {
                    containerComponentType = 1;
                }
                if (Component.instances[b].anInt106 == chatComponentId) {
                    containerComponentType = 3;
                }
            }
            if (action == 274) {
                Component class5 = Component.instances[b];
                spellSelected = 1;
                anInt995 = b;
                spellUsableOn = class5.anInt160;
                objSelected = 0;
                redrawInvback = true;
                String s5 = class5.spellAction;
                if (s5.indexOf(" ") != -1) {
                    s5 = s5.substring(0, s5.indexOf(" "));
                }
                String s9 = class5.spellAction;
                if (s9.indexOf(" ") != -1) {
                    s9 = s9.substring(s9.indexOf(" ") + 1);
                }
                spellTooltip = s5 + " " + class5.spellName + " " + s9;
                if (spellUsableOn == 16) {
                    redrawInvback = true;
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
                        redrawInvback = true;
                    }
                }
            }
            if (action == 524) {
                String s3 = menuOption[option];
                int l2 = s3.indexOf("@whi@");
                if (l2 != -1) {
                    if (viewportComponentId == -1) {
                        method28(3);
                        reportAbuseInput = s3.substring(l2 + 5).trim();
                        reportAbuseMuteOption = false;
                        for (int j3 = 0; j3 < Component.instances.length; j3++) {
                            if (Component.instances[j3] == null || Component.instances[j3].contentType != 600) {
                                continue;
                            }
                            anInt1217 = viewportComponentId = Component.instances[j3].anInt106;
                            break;
                        }
                    } else {
                        renderText("", "Please close the interface you have open before using 'report abuse'", 0
                        );
                    }
                }
            }
            if (action == 242 || action == 209 || action == 309 || action == 852 || action == 793) {
                NPCEntity npc = npcs[c];
                if (npc != null) {
                    tryMove(1, Game.localPlayer.pathTileX[0], 0, npc.pathTileZ[0], 0, 0, false, 2, 124, 1, npc.pathTileX[0], Game.localPlayer.pathTileZ[0]);
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
                if (class5_2.contentType > 0) {
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
                    renderText("", s6, 0);
                }
            }
            if (action == 398) {
                out.writePacket(200);
                out.writeShort(c);
                out.writeShort(a);
                out.writeShort(b);
                out.writeShort(anInt955);
                out.writeShort(lastItemSelectedSlot);
                out.writeShort(moveIteminterfaceId);
                anInt1148 = 0;
                containerComponentId = b;
                containerIndex = a;
                containerComponentType = 2;
                if (Component.instances[b].anInt106 == viewportComponentId) {
                    containerComponentType = 1;
                }
                if (Component.instances[b].anInt106 == chatComponentId) {
                    containerComponentType = 3;
                }
            }
            if (action == 102) {
                objSelected = 1;
                lastItemSelectedSlot = a;
                moveIteminterfaceId = b;
                anInt955 = c;
                selectedObjName = ObjType.lookup(c).name;
                spellSelected = 0;
                redrawInvback = true;
                return;
            }
            if (action == 997 && !continuedDialogue) {
                out.writePacket(PacketConstants.outgoing.CLICK_TO_CONTINUE);
                out.writeShort(b);
                continuedDialogue = true;
            }
            if (action == 899 && clickInteractiveLoc(c, 218, false, b, a)) {
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
                containerComponentId = b;
                containerIndex = a;
                containerComponentType = 2;
                if (Component.instances[b].anInt106 == viewportComponentId) {
                    containerComponentType = 1;
                }
                if (Component.instances[b].anInt106 == chatComponentId) {
                    containerComponentType = 3;
                }
            }
            if (action == 275) {
                PlayerEntity class44_sub3_sub4_sub6_sub1_1 = players[c];
                if (class44_sub3_sub4_sub6_sub1_1 != null) {
                    tryMove(1, Game.localPlayer.pathTileX[0], 0,
                            class44_sub3_sub4_sub6_sub1_1.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            class44_sub3_sub4_sub6_sub1_1.pathTileX[0],
                            Game.localPlayer.pathTileZ[0]);
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 2;
                    crossCycle = 0;
                    out.writePacket(16);
                    out.writeShort(c);
                    out.writeShort(anInt955);
                    out.writeShort(lastItemSelectedSlot);
                    out.writeShort(moveIteminterfaceId);
                }
            }
            if (action == 240) {
                NPCEntity class44_sub3_sub4_sub6_sub2_2 = npcs[c];
                if (class44_sub3_sub4_sub6_sub2_2 != null) {
                    tryMove(1, Game.localPlayer.pathTileX[0], 0,
                            class44_sub3_sub4_sub6_sub2_2.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            class44_sub3_sub4_sub6_sub2_2.pathTileX[0],
                            Game.localPlayer.pathTileZ[0]);
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
                clickInteractiveLoc(c, 196, false, b, a);
            }
            if (action == 111) {
                boolean flag = tryMove(0, Game.localPlayer.pathTileX[0], 0,
                        b, 0, 0, false, 2, 124, 0, a,
                        Game.localPlayer.pathTileZ[0]);
                if (!flag) {
                    flag = tryMove(1, Game.localPlayer.pathTileX[0], 0, b,
                            0, 0, false, 2, 124, 1, a,
                            Game.localPlayer.pathTileZ[0]);
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
                out.writeShort(lastItemSelectedSlot);
                out.writeShort(moveIteminterfaceId);
            }
            if (action == 810 && clickInteractiveLoc(c, 184, false, b, a)) {
                out.writeShort(anInt955);
                out.writeShort(lastItemSelectedSlot);
                out.writeShort(moveIteminterfaceId);
            }
            if (action == 829) {
                NPCEntity class44_sub3_sub4_sub6_sub2_3 = npcs[c];
                if (class44_sub3_sub4_sub6_sub2_3 != null) {
                    tryMove(1, Game.localPlayer.pathTileX[0], 0,
                            class44_sub3_sub4_sub6_sub2_3.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            class44_sub3_sub4_sub6_sub2_3.pathTileX[0],
                            Game.localPlayer.pathTileZ[0]);
                    crossX = super.mousePressX;
                    crossY = super.mousePressY;
                    crossMode = 2;
                    crossCycle = 0;
                    out.writePacket(160);
                    out.writeShort(c);
                    out.writeShort(anInt955);
                    out.writeShort(lastItemSelectedSlot);
                    out.writeShort(moveIteminterfaceId);
                }
            }
            if (action == 1381) {
                int k1 = c >> 14 & 0x7fff;
                LocType class8 = LocType.lookup(k1);
                String s10;
                if (class8.aByteArray219 != null) {
                    s10 = new String(class8.aByteArray219);
                } else {
                    s10 = "It's a " + class8.aString218 + ".";
                }
                renderText("", s10, 0);
            }
            if (action == 1071) {
                clickInteractiveLoc(c, 126, false, b, a);
            }
            if (action == 139 || action == 778 || action == 617 || action == 224 || action == 662) {
                boolean flag1 = tryMove(0, Game.localPlayer.pathTileX[0], 0,
                        b, 0, 0, false, 2, 124, 0, a,
                        Game.localPlayer.pathTileZ[0]);
                if (!flag1) {
                    flag1 = tryMove(1, Game.localPlayer.pathTileX[0], 0, b,
                            0, 0, false, 2, 124, 1, a,
                            Game.localPlayer.pathTileZ[0]);
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
                    redrawInvback = true;
                }
            }
            if (action == 357) {
                clickInteractiveLoc(c, 53, false, b, a);
            }
            if (action == 370) {
                boolean flag2 = tryMove(0, Game.localPlayer.pathTileX[0], 0,
                        b, 0, 0, false, 2, 124, 0, a,
                        Game.localPlayer.pathTileZ[0]);
                if (!flag2) {
                    flag2 = tryMove(1, Game.localPlayer.pathTileX[0], 0, b,
                            0, 0, false, 2, 124, 1, a,
                            Game.localPlayer.pathTileZ[0]);
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
                    tryMove(1, Game.localPlayer.pathTileX[0], 0,
                            class44_sub3_sub4_sub6_sub1_2.pathTileZ[0], 0, 0, false, 2, 124, 1,
                            class44_sub3_sub4_sub6_sub1_2.pathTileX[0],
                            Game.localPlayer.pathTileZ[0]);
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
                containerComponentId = b;
                containerIndex = a;
                containerComponentType = 2;
                if (Component.instances[b].anInt106 == viewportComponentId) {
                    containerComponentType = 1;
                }
                if (Component.instances[b].anInt106 == chatComponentId) {
                    containerComponentType = 3;
                }
            }
            if (action == 1328) {
                ObjType class14_1 = ObjType.lookup(c);
                Component class5_4 = Component.instances[b];
                String s7;
                if (class5_4 != null && class5_4.containerItemAmount[a] >= 0x186a0) {
                    s7 = class5_4.containerItemAmount[a] + " x " + class14_1.name;
                } else if (class14_1.aByteArray332 != null) {
                    s7 = new String(class14_1.aByteArray332);
                } else {
                    s7 = "It's a " + class14_1.name + ".";
                }
                renderText("", s7, 0);
            }
            objSelected = 0;
            spellSelected = 0;
            redrawInvback = true;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("27672, " + option + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void method135(boolean flag) {
        try {
            if (objSelected == 0 && spellSelected == 0) {
                menuOption[menuSize] = "Walk here";
                menuAction[menuSize] = 718;
                menuParamA[menuSize] = super.mouseX;
                menuParamB[menuSize] = super.mouseY;
                menuSize++;
            }
            int i = -1;
            ingame &= flag;
            for (int j = 0; j < Model.resourceCount; j++) {
                int k = Model.anIntArray1597[j];
                int l = k & 0x7f;
                int i1 = k >> 7 & 0x7f;
                int j1 = k >> 29 & 3;
                int k1 = k >> 14 & 0x7fff;
                if (k == i) {
                    continue;
                }
                i = k;
                if (j1 == 2 && scene.getConfig(plane, l, i1, k) >= 0) {
                    LocType class8 = LocType.lookup(k1);
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
                        class8 = LocType.lookup(class8.anIntArray250[j4]);
                    }
                    if (objSelected == 1) {
                        menuOption[menuSize] = "Use " + selectedObjName + " with @cya@" + class8.aString218;
                        menuAction[menuSize] = 810;
                        menuParamC[menuSize] = k;
                        menuParamA[menuSize] = l;
                        menuParamB[menuSize] = i1;
                        menuSize++;
                    } else if (spellSelected == 1) {
                        if ((spellUsableOn & 4) == 4) {
                            menuOption[menuSize] = spellTooltip + " @cya@" + class8.aString218;
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
                                    menuOption[menuSize] = class8.aStringArray234[l1] + " @cya@"
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
                        menuOption[menuSize] = "Examine @cya@" + class8.aString218;
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
                        for (int i2 = 0; i2 < npcCount; i2++) {
                            NPCEntity class44_sub3_sub4_sub6_sub2_1 = npcs[anIntArray1010[i2]];
                            if (class44_sub3_sub4_sub6_sub2_1 != null
                                    && class44_sub3_sub4_sub6_sub2_1 != class44_sub3_sub4_sub6_sub2
                                    && class44_sub3_sub4_sub6_sub2_1.aClass12_1700.aByte284 == 1
                                    && class44_sub3_sub4_sub6_sub2_1.x == class44_sub3_sub4_sub6_sub2.x
                                    && class44_sub3_sub4_sub6_sub2_1.z == class44_sub3_sub4_sub6_sub2.z) {
                                method58(anIntArray1010[i2], class44_sub3_sub4_sub6_sub2_1.aClass12_1700, l, 559, i1);
                            }
                        }
                        for (int l2 = 0; l2 < playerCount; l2++) {
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
                        for (int j2 = 0; j2 < npcCount; j2++) {
                            NPCEntity class44_sub3_sub4_sub6_sub2_2 = npcs[anIntArray1010[j2]];
                            if (class44_sub3_sub4_sub6_sub2_2 != null
                                    && class44_sub3_sub4_sub6_sub2_2.aClass12_1700.aByte284 == 1
                                    && class44_sub3_sub4_sub6_sub2_2.x == class44_sub3_sub4_sub6_sub1.x
                                    && class44_sub3_sub4_sub6_sub2_2.z == class44_sub3_sub4_sub6_sub1.z) {
                                method58(anIntArray1010[j2], class44_sub3_sub4_sub6_sub2_2.aClass12_1700, l, 559, i1);
                            }
                        }
                        for (int i3 = 0; i3 < playerCount; i3++) {
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
                            ObjType class14 = ObjType.lookup(class44_sub3_sub4_sub2.anInt1495);
                            if (objSelected == 1) {
                                menuOption[menuSize] = "Use " + selectedObjName + " with @lre@" + class14.name;
                                menuAction[menuSize] = 111;
                                menuParamC[menuSize] = class44_sub3_sub4_sub2.anInt1495;
                                menuParamA[menuSize] = l;
                                menuParamB[menuSize] = i1;
                                menuSize++;
                            } else if (spellSelected == 1) {
                                if ((spellUsableOn & 1) == 1) {
                                    menuOption[menuSize] = spellTooltip + " @lre@" + class14.name;
                                    menuAction[menuSize] = 370;
                                    menuParamC[menuSize] = class44_sub3_sub4_sub2.anInt1495;
                                    menuParamA[menuSize] = l;
                                    menuParamB[menuSize] = i1;
                                    menuSize++;
                                }
                            } else {
                                for (int k3 = 4; k3 >= 0; k3--) {
                                    if (class14.aStringArray345 != null && class14.aStringArray345[k3] != null) {
                                        menuOption[menuSize] = class14.aStringArray345[k3] + " @lre@"
                                                + class14.name;
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
                                        menuOption[menuSize] = "Take @lre@" + class14.name;
                                        menuAction[menuSize] = 617;
                                        menuParamC[menuSize] = class44_sub3_sub4_sub2.anInt1495;
                                        menuParamA[menuSize] = l;
                                        menuParamB[menuSize] = i1;
                                        menuSize++;
                                    }
                                }
                                menuOption[menuSize] = "Examine @lre@" + class14.name;
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

    public void drawHeadIcon(int i) {
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
                headicons[2].draw(anInt1064 - 12, anInt1065 - 28);
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
            cameraPositionZ = y - offsetY;
            cameraPositionY = z - offsetZ;
            cameraVerticalRotation = vertical;
            cameraHorizontalRotation = horizontal;
            return;
        } catch (RuntimeException runtimeexception) {
            SignLink.reporterror("24308, " + i + ", " + horizontal + ", " + y + ", " + z + ", " + x + ", " + vertical
                    + ", " + runtimeexception);
        }
        throw new RuntimeException();
    }

    public void configureSpawnRequest(SceneLocTemporary class44_sub1, boolean flag) {
        try {
            int i = 0;
            int j = -1;
            int k = 0;
            int l = 0;
            if (flag) {
                for (int i1 = 1; i1 > 0; i1++) {
                }
            }
            if (class44_sub1.locType == 0) {
                i = scene.getWallBitset(class44_sub1.plane, class44_sub1.sceneTileX, class44_sub1.sceneTileZ);
            }
            if (class44_sub1.locType == 1) {
                i = scene.method305(class44_sub1.sceneTileZ, 7, class44_sub1.plane, class44_sub1.sceneTileX);
            }
            if (class44_sub1.locType == 2) {
                i = scene.getInteractableBitset(class44_sub1.plane, class44_sub1.sceneTileX, class44_sub1.sceneTileZ);
            }
            if (class44_sub1.locType == 3) {
                i = scene.getGroundDecorationBitset(class44_sub1.plane, class44_sub1.sceneTileX, class44_sub1.sceneTileZ);
            }
            if (i != 0) {
                int j1 = scene.getConfig(class44_sub1.plane, class44_sub1.sceneTileX,
                        class44_sub1.sceneTileZ, i);
                j = i >> 14 & 0x7fff;
                k = j1 & 0x1f;
                l = j1 >> 6;
            }
            class44_sub1.previousId = j;
            class44_sub1.previousType = k;
            class44_sub1.id = l;
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
                    class44_sub3_sub4_sub6_sub2.updateHitData(j2, Game.loopCycle, j1, false);
                    class44_sub3_sub4_sub6_sub2.lastCombatCycle = Game.loopCycle + 300;
                    class44_sub3_sub4_sub6_sub2.currentHealth = class44_sub3_sub2.readUnsignedByte();
                    class44_sub3_sub4_sub6_sub2.maxHealth = class44_sub3_sub2.readUnsignedByte();
                }
                if ((i1 & 2) == 2) {
                    int k1 = class44_sub3_sub2.readUnsignedShort();
                    if (k1 == 65535) {
                        k1 = -1;
                    }
                    if (k1 == class44_sub3_sub4_sub6_sub2.primarySeq) {
                        class44_sub3_sub4_sub6_sub2.primarySeqPlays = 0;
                    }
                    int k2 = class44_sub3_sub2.readUnsignedByte();
                    if (k1 == class44_sub3_sub4_sub6_sub2.primarySeq && k1 != -1) {
                        int i3 = SeqType.instances[k1].replayMode;
                        if (i3 == 1) {
                            class44_sub3_sub4_sub6_sub2.currentSeqFrame = 0;
                            class44_sub3_sub4_sub6_sub2.currentSeqDelay = 0;
                            class44_sub3_sub4_sub6_sub2.primarySeqDelays = k2;
                            class44_sub3_sub4_sub6_sub2.primarySeqPlays = 0;
                        }
                        if (i3 == 2) {
                            class44_sub3_sub4_sub6_sub2.primarySeqPlays = 0;
                        }
                    } else if (k1 == -1
                            || class44_sub3_sub4_sub6_sub2.primarySeq == -1
                            || SeqType.instances[k1].priority >= SeqType.instances[class44_sub3_sub4_sub6_sub2.primarySeq].priority) {
                        class44_sub3_sub4_sub6_sub2.primarySeq = k1;
                        class44_sub3_sub4_sub6_sub2.currentSeqFrame = 0;
                        class44_sub3_sub4_sub6_sub2.currentSeqDelay = 0;
                        class44_sub3_sub4_sub6_sub2.primarySeqDelays = k2;
                        class44_sub3_sub4_sub6_sub2.primarySeqPlays = 0;
                        class44_sub3_sub4_sub6_sub2.anInt1669 = class44_sub3_sub4_sub6_sub2.anInt1664;
                    }
                }
                if ((i1 & 4) == 4) {
                    class44_sub3_sub4_sub6_sub2.targetEntitiy = class44_sub3_sub2.readUnsignedShort();
                    if (class44_sub3_sub4_sub6_sub2.targetEntitiy == 65535) {
                        class44_sub3_sub4_sub6_sub2.targetEntitiy = -1;
                    }
                }
                if ((i1 & 8) == 8) {
                    class44_sub3_sub4_sub6_sub2.spoken = class44_sub3_sub2.readString();
                    class44_sub3_sub4_sub6_sub2.spokenLife = 100;
                }
                if ((i1 & 0x10) == 16) {
                    int l1 = class44_sub3_sub2.readUnsignedByte();
                    int l2 = class44_sub3_sub2.readUnsignedByte();
                    class44_sub3_sub4_sub6_sub2.updateHitData(l2, Game.loopCycle, l1, false);
                    class44_sub3_sub4_sub6_sub2.lastCombatCycle = Game.loopCycle + 300;
                    class44_sub3_sub4_sub6_sub2.currentHealth = class44_sub3_sub2.readUnsignedByte();
                    class44_sub3_sub4_sub6_sub2.maxHealth = class44_sub3_sub2.readUnsignedByte();
                }
                if ((i1 & 0x20) == 32) {
                    class44_sub3_sub4_sub6_sub2.aClass12_1700 = NpcType
                            .lookup(class44_sub3_sub2.readUnsignedShort());
                    class44_sub3_sub4_sub6_sub2.anInt1619 = class44_sub3_sub4_sub6_sub2.aClass12_1700.aByte284;
                    class44_sub3_sub4_sub6_sub2.anInt1663 = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt306;
                    class44_sub3_sub4_sub6_sub2.walkSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt288;
                    class44_sub3_sub4_sub6_sub2.turnSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt289;
                    class44_sub3_sub4_sub6_sub2.turnRightSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt290;
                    class44_sub3_sub4_sub6_sub2.turnLeftSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt291;
                    class44_sub3_sub4_sub6_sub2.standSeqId = class44_sub3_sub4_sub6_sub2.aClass12_1700.anInt287;
                }
                if ((i1 & 0x40) == 64) {
                    class44_sub3_sub4_sub6_sub2.spotAnimId = class44_sub3_sub2.readUnsignedShort();
                    int i2 = class44_sub3_sub2.readInt();
                    class44_sub3_sub4_sub6_sub2.spotAnimHeight = i2 >> 16;
                    class44_sub3_sub4_sub6_sub2.spotAnimEndCycle = Game.loopCycle + (i2 & 0xffff);
                    class44_sub3_sub4_sub6_sub2.currentSeqId = 0;
                    class44_sub3_sub4_sub6_sub2.currentSeqDurationRemaining = 0;
                    if (class44_sub3_sub4_sub6_sub2.spotAnimEndCycle > Game.loopCycle) {
                        class44_sub3_sub4_sub6_sub2.currentSeqId = -1;
                    }
                    if (class44_sub3_sub4_sub6_sub2.spotAnimId == 65535) {
                        class44_sub3_sub4_sub6_sub2.spotAnimId = -1;
                    }
                }
                if ((i1 & 0x80) == 128) {
                    class44_sub3_sub4_sub6_sub2.focusX = class44_sub3_sub2.readUnsignedShort();
                    class44_sub3_sub4_sub6_sub2.focusZ = class44_sub3_sub2.readUnsignedShort();
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
            int l = cameraHorizontal + minimapAnticheatAngle & 0x7ff;
            int i1 = i * i + k * k;
            if (i1 > 6400) {
                return;
            }
            int j1 = Model.SINE[l];
            int k1 = Model.COSINE[l];
            j1 = (j1 * 256) / (minimapZoom + 256);
            k1 = (k1 * 256) / (minimapZoom + 256);
            if (j <= 0) {
                for (int l1 = 1; l1 > 0; l1++) {
                }
            }
            int i2 = k * j1 + i * k1 >> 16;
            int j2 = k * k1 - i * j1 >> 16;
            if (i1 > 2500) {
                class44_sub3_sub1_sub2.method446(((94 + i2) - class44_sub3_sub1_sub2.cropWidth / 2) + 4,
                        mapbackImage, true, 83 - j2 - class44_sub3_sub1_sub2.cropHeight / 2 - 4);
                return;
            } else {
                class44_sub3_sub1_sub2.draw(((94 + i2) - class44_sub3_sub1_sub2.cropWidth / 2) + 4, 83 - j2 - class44_sub3_sub1_sub2.cropHeight / 2 - 4
                );
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
            for (int j = 0; j < ignoreCount; j++) {
                if (ignoreNameLong[j] == l) {
                    ignoreCount--;
                    redrawInvback = true;
                    for (int k = j; k < ignoreCount; k++) {
                        ignoreNameLong[k] = ignoreNameLong[k + 1];
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
            if (minimapState != 0) {
                return;
            }
            if (super.clickType == 1) {
                int j = super.mousePressX - 25 - 550;
                int k = super.mousePressY - 5 - 4;
                if (j >= 0 && k >= 0 && j < 146 && k < 151) {
                    j -= 73;
                    k -= 75;
                    int l = cameraHorizontal + minimapAnticheatAngle & 0x7ff;
                    int i1 = Draw3D.sin[l];
                    int j1 = Draw3D.cos[l];
                    i1 = i1 * (minimapZoom + 256) >> 8;
                    j1 = j1 * (minimapZoom + 256) >> 8;
                    int k1 = k * i1 + j * j1 >> 11;
                    int l1 = k * j1 - j * i1 >> 11;
                    int i2 = Game.localPlayer.x + k1 >> 7;
                    int j2 = Game.localPlayer.z - l1 >> 7;
                    boolean flag = tryMove(0, Game.localPlayer.pathTileX[0],
                            0, j2, 0, 0, true, 1, 124, 0, i2,
                            Game.localPlayer.pathTileZ[0]);
                    if (flag) {
                        out.writeByte(j);
                        out.writeByte(k);
                        out.writeShort(cameraHorizontal);
                        out.writeByte(57);
                        out.writeByte(minimapAnticheatAngle);
                        out.writeByte(minimapZoom);
                        out.writeByte(89);
                        out
                                .writeShort(Game.localPlayer.x);
                        out
                                .writeShort(Game.localPlayer.z);
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
            int k = class44_sub3_sub2.getBits(8);
            if (k < npcCount) {
                for (int l = k; l < npcCount; l++) {
                    anIntArray941[anInt940++] = anIntArray1010[l];
                }
            }
            if (k > npcCount) {
                SignLink.reporterror(username + " Too many npcs");
                throw new RuntimeException("eek");
            }
            npcCount = 0;
            for (int i1 = 0; i1 < k; i1++) {
                int j1 = anIntArray1010[i1];
                NPCEntity class44_sub3_sub4_sub6_sub2 = npcs[j1];
                int k1 = class44_sub3_sub2.getBits(1);
                if (k1 == 0) {
                    anIntArray1010[npcCount++] = j1;
                    class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                } else {
                    int l1 = class44_sub3_sub2.getBits(2);
                    if (l1 == 0) {
                        anIntArray1010[npcCount++] = j1;
                        class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                        anIntArray1229[anInt1228++] = j1;
                    } else if (l1 == 1) {
                        anIntArray1010[npcCount++] = j1;
                        class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                        int i2 = class44_sub3_sub2.getBits(3);
                        class44_sub3_sub4_sub6_sub2.method533(false, i2, anInt1153);
                        int k2 = class44_sub3_sub2.getBits(1);
                        if (k2 == 1) {
                            anIntArray1229[anInt1228++] = j1;
                        }
                    } else if (l1 == 2) {
                        anIntArray1010[npcCount++] = j1;
                        class44_sub3_sub4_sub6_sub2.anInt1660 = Game.loopCycle;
                        int j2 = class44_sub3_sub2.getBits(3);
                        class44_sub3_sub4_sub6_sub2.method533(true, j2, anInt1153);
                        int l2 = class44_sub3_sub2.getBits(3);
                        class44_sub3_sub4_sub6_sub2.method533(true, l2, anInt1153);
                        int i3 = class44_sub3_sub2.getBits(1);
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
            stopMidi(0);
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
            planeHeightMap = null;
            planeTileFlags = null;
            scene = null;
            collisions = null;
            anIntArrayArray1113 = null;
            anIntArrayArray975 = null;
            anIntArray1020 = null;
            anIntArray1021 = null;
            aByteArray1109 = null;
            aClass34_1195 = null;
            aClass34_1196 = null;
            areaViewport = null;
            areaChatBack = null;
            aClass34_858 = null;
            aClass34_859 = null;
            aClass34_860 = null;
            backleft1Area = null;
            backleft2Area = null;
            backright1Area = null;
            backright2Area = null;
            backtop1Area = null;
            backvmid1Area = null;
            backvmid2Area = null;
            backvmid3Area = null;
            backhmid2Area = null;
            invbackImage = null;
            mapbackImage = null;
            chatbackImage = null;
            backbase1Image = null;
            backbase2Image = null;
            backhmid1Image = null;
            sideicons = null;
            redstone0Image = null;
            redstone1Image = null;
            redstone2Image = null;
            redstone3Image = null;
            redstone4Image = null;
            redstone5Image = null;
            redstone6Image = null;
            redstone7Image = null;
            redstone8Image = null;
            redstone9Image = null;
            compassImage = null;
            hitmarks = null;
            headicons = null;
            crosses = null;
            mapdot0Image = null;
            mapdot1Image = null;
            mapdot2Image = null;
            mapdot3Image = null;
            mapscenes = null;
            mapfunctions = null;
            anIntArrayArray885 = null;
            players = null;
            anIntArray1227 = null;
            anIntArray1229 = null;
            appearanceBuffer = null;
            anIntArray941 = null;
            npcs = null;
            anIntArray1010 = null;
            planeObjStacks = null;
            listTemporaryLocs = null;
            projectiles = null;
            spotanims = null;
            menuParamA = null;
            menuParamB = null;
            menuAction = null;
            menuParamC = null;
            menuOption = null;
            anIntArray1214 = null;
            activeMapfunctionsX = null;
            activeMapfunctionsZ = null;
            activeMapfunctions = null;
            if (i <= 0) {
                planeObjStacks = null;
            }
            minimap = null;
            friendName = null;
            aLongArray979 = null;
            friendWorld = null;
            title0 = null;
            title1 = null;
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
            IdkType.cache = null;
            Component.instances = null;
            SeqType.instances = null;
            SpotAnimType.cache = null;
            SpotAnimType.aClass39_571 = null;
            VarpType.cache = null;
            super.aClass34_14 = null;
            PlayerEntity.aClass39_1696 = null;
            Draw3D.method418((byte) 42);
            Scene.method277();
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
                    out.writeByte(privateChatMode);
                    out.writeByte(tradeChatSetting);
                }
                if (super.mousePressX >= 135 && super.mousePressX <= 235 && super.mousePressY >= 467 && super.mousePressY <= 499) {
                    privateChatMode = (privateChatMode + 1) % 3;
                    redrawPrivacySettings = true;
                    redrawChatback = true;
                    out.writePacket(161);
                    out.writeByte(publicChatSetting);
                    out.writeByte(privateChatMode);
                    out.writeByte(tradeChatSetting);
                }
                if (super.mousePressX >= 273 && super.mousePressX <= 373 && super.mousePressY >= 467 && super.mousePressY <= 499) {
                    tradeChatSetting = (tradeChatSetting + 1) % 3;
                    redrawPrivacySettings = true;
                    redrawChatback = true;
                    out.writePacket(161);
                    out.writeByte(publicChatSetting);
                    out.writeByte(privateChatMode);
                    out.writeByte(tradeChatSetting);
                }
                if (super.mousePressX >= 412 && super.mousePressX <= 512 && super.mousePressY >= 467 && super.mousePressY <= 499) {
                    if (viewportComponentId == -1) {
                        method28(3);
                        reportAbuseInput = "";
                        reportAbuseMuteOption = false;
                        for (int i = 0; i < Component.instances.length; i++) {
                            if (Component.instances[i] != null && Component.instances[i].contentType == 600) {
                                anInt1217 = viewportComponentId = Component.instances[i].anInt106;
                                return;
                            }
                        }
                        return;
                    } else {
                        renderText("", "Please close the interface you have open before using 'report abuse'", 0
                        );
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
                    Draw3D.setBrightness(0.90000000000000002D);
                }
                if (k == 2) {
                    Draw3D.setBrightness(0.80000000000000004D);
                }
                if (k == 3) {
                    Draw3D.setBrightness(0.69999999999999996D);
                }
                if (k == 4) {
                    Draw3D.setBrightness(0.59999999999999998D);
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
                        song = nextSong;
                        musicFading = true;
                        ondemand.request(2, song);
                    } else {
                        stopMidi(0);
                    }
                    nextSongDelay = 0;
                }
            }
            if (j == 4) {
                if (k == 0) {
                    aBoolean1050 = true;
                    setVolume(0);
                }
                if (k == 1) {
                    aBoolean1050 = true;
                    setVolume(-400);
                }
                if (k == 2) {
                    aBoolean1050 = true;
                    setVolume(-800);
                }
                if (k == 3) {
                    aBoolean1050 = true;
                    setVolume(-1200);
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
                splitPrivateChat = k;
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

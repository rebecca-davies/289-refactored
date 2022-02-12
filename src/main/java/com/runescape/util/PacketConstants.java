package com.runescape.util;

public class PacketConstants {

    public static int[] PACKET_SIZES =
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 0
             0, 0, 2, 3, 0, 0, 0, 0, 6, 0, // 10
             0, -1, 0, 0, 0, 0, 0, 0, 2, 4, // 20
             2, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 30
             0, 0, 0, 0, 0, 0, 2, -2, 0, 0, // 40
             0, 0, 0, 0, 0, 4, 0, 0, 0, -2, // 50
             5, 0, 0, 3, 0, -2, 0, 0, 0, 0, // 60
             0, 3, 0, 6, 0, 3, -2, 0, 0, 6, // 70
             0, 2, 6, 14, 0, 0, 0, 15, 0, 0, // 80
             4, 4, 0, 0, 0, 0, 0, 6, 0, 0, // 90
             0, 0, 0, 0, 0, 0, 4, -2, 0, 0, // 100
             0, 0, -2, 0, 0, 6, 0, 7, 0, 2, // 110
             3, 0, 6, 0, 0, 0, 0, 2, 0, 0, // 120
             0, 0, 0, 0, 0, 0, 1, 0, 3, 0, // 130
             0, 0, 0, 0, 2, 0, 0, 0, 0, 0, // 140
             0, 0, 0, 0, 6, 2, 0, 0, 0, 0, // 150
             4, 0, 0, 0, 0, 0, 0, 0, 9, 0, // 160
             0, 0, 0, 0, 0, 0, 7, 5, 0, 0, // 170
             0, 1, 0, 0, 4, 0, 0, 2, -2, 1, // 180
             0, 0, 0, 0, 2, 1, -1, 0, 0, 0, // 190
             0, 0, 0, 0, 2, 0, 0, 0, 4, 0, // 200
             0, 4, 0, 0, 0, 0, 0, 0, 0, 4, // 210
             0, 0, 4, 0, 0, 0, 0, 0, 0, 0, // 220
             0, 0, 0, 6, 0, 1, 0, 0, 0, 0, // 230
             0, 0, 0, -1, 4, 0, 0, 1, 0, 0, // 240
              0, 0, 2, 10, 0, 0, 0}; // 250

    public static class incoming {

        public final static int SEND_MESSAGE = 196;

        public final static int PLAYER_SET_ACTION = 21;

        public final static int INTERFACE_PLAYERHEAD = 30;

        public final static int INTERFACE_SIDEBAR = 63;

        public final static int CAMERA_SHAKE = 208;

        public final static int PRIVATE_MESSAGE = 243;

        public final static int DRAW_HEAD_ICON = 115;

        public final static int WEIGHT_CARRIED = 46;

        public final static int RUN_ENERGY = 195;

        public final static int CHAT_SETTINGS = 13;

        public final static int LOAD_MAP_REGION = 219;

        public final static int RECEIVE_DETAILS = 120;

        public final static int UPDATE_ITEMS = 107;
    }

    public static class outgoing {

        public final static int KEEP_ALIVE = 181;

        public final static int CLICK_TO_CONTINUE = 166;

        public final static int MOUSE_CLICKED = 224;

        public final static int IDLE_TIMER = 145;


    }

}

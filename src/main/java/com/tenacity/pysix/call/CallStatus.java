package com.tenacity.pysix.call;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 7/16/13
 * Time: 2:58 PM
 * Represents the possible status of a call
 */
public enum CallStatus {
    /**
     * The channel is down
     */
    DOWN,
    /**
     * The channel is reserved
     */
    RESERVED,
    /**
     * the channel is off hook
     */
    OFF_HOOK,
    /**
     * The channel is dialing
     */
    DIALING,
    /**
     * the channel is ringing
     */
    RINGING,
    /**
     * The channel is in conversation
     */
    UP,
    /**
     * The channel is busy
     */
    BUSY,
    /**
     * The channel is bridged to another
     */
    LINKED,
    /**
     * The channel is now unlinked from a previous bridged channel
     */
    UNLINKED,
    /**
     * The channel sent a disconnection to the PBX
     */
    HUNG_UP,
    /**
     * The channel disconnected in response to a disconnection by the other party
     */
    CLEARED,
    /**
     * The channel was removed because was seen as not active by the test routine
     */
    REMOVED,
    /**
     * The channel state is Unknown
     */
    UNKNOWN;


    public static final int AST_STATE_DOWN = 0;
    public static final int AST_STATE_RESERVED = 1;
    public static final int AST_STATE_OFF_HOOK = 2;
    public static final int AST_STATE_DIALING = 3;
    public static final int AST_STATE_RING = 4;
    public static final int AST_STATE_RINGING = 5;
    public static final int AST_STATE_UP = 6;
    public static final int AST_STATE_BUSY = 7;

    public static final String AST_DIAL_SUB_EVENT_BEGIN = "Begin";
    public static final String AST_DIAL_SUB_EVENT_END = "End";
    public static final String AST_BRIDGE_STATE_LINK = "Link";
    public static final String AST_BRIDGE_STATE_UNLINK = "Unlink";


    public static CallStatus fromAsteriskStatus(int asteriskStatus) {
        switch (asteriskStatus) {
            case AST_STATE_DOWN:
                return DOWN;
            case AST_STATE_RESERVED:
                return RESERVED;
            case AST_STATE_OFF_HOOK:
                return OFF_HOOK;
            case AST_STATE_DIALING:
                return DIALING;
            case AST_STATE_RING:
                return RINGING;
            case AST_STATE_RINGING:
                return RINGING;
            case AST_STATE_UP:
                return UP;
            case AST_STATE_BUSY:
                return BUSY;
            default: {
                LOGGER.error("Unknown Connection Status, please verify the library version...");
                return UNKNOWN;
            }
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(com.tenacity.pysix.pbx.call.CallStatus.class);
}

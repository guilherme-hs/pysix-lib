package com.tenacity.pysix.call;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 7/15/13
 * Time: 10:07 AM
 *
 * Represents the possible disposition of a call
 */
public enum CallDisposition {
    /**
     * The call is in progress
     */
    IN_PROGRESS,
    /**
     * The call was Answered normally
     */
    ANSWERED,
    /**
     * The call was not Answered
     */
    NOT_ANSWERED,
    /**
     * The destination was busy
     */
    BUSY,
    /**
     * There was no channel available to make the call
     */
    CHANNEL_UNAVAILABLE,
    /**
     * The number was not found
     */
    NUMBER_NOT_FOUND,
    /**
     * An unknown error has occurred
     */
    UNKNOWN;

    public static final int AST_CAUSE_ACCESS_INFO_DISCARDED = 43;
    public static final int AST_CAUSE_BEARER_CAPABILITY_NOT_AUTH = 57;
    public static final int AST_CAUSE_BEARER_CAPABILITY_NOT_AVAIL = 58;
    public static final int AST_CAUSE_BEARER_CAPABILITY_NOT_IMPL = 65;
    public static final int AST_CAUSE_CALL_AWARDED_DELIVERED = 7;
    public static final int AST_CAUSE_CALL_REJECTED = 21;
    public static final int AST_CAUSE_CHAN_NOT_IMPLEMENTED = 66;
    public static final int AST_CAUSE_CHANNEL_UNACCEPTABLE = 6;
    public static final int AST_CAUSE_DESTINATION_OUT_OF_ORDER = 27;
    public static final int AST_CAUSE_FACILITY_NOT_IMPLEMENTED = 69;
    public static final int AST_CAUSE_FACILITY_NOT_SUBSCRIBED = 50;
    public static final int AST_CAUSE_FACILITY_REJECTED = 29;
    public static final int AST_CAUSE_IE_NON_EXIST = 99;
    public static final int AST_CAUSE_INCOMING_CALL_BARRED = 54;
    public static final int AST_CAUSE_INCOMPATIBLE_DESTINATION = 88;
    public static final int AST_CAUSE_INTER_WORKING = 127;
    public static final int AST_CAUSE_INVALID_CALL_REFERENCE = 81;
    public static final int AST_CAUSE_INVALID_IE_CONTENTS = 100;
    public static final int AST_CAUSE_INVALID_MSG_UNSPECIFIED = 95;
    public static final int AST_CAUSE_INVALID_NUMBER_FORMAT = 28;
    public static final int AST_CAUSE_MANDATORY_IE_LENGTH_ERROR = 103;
    public static final int AST_CAUSE_MANDATORY_IE_MISSING = 96;
    public static final int AST_CAUSE_MESSAGE_TYPE_NON_EXIST = 97;
    public static final int AST_CAUSE_NETWORK_OUT_OF_ORDER = 38;
    public static final int AST_CAUSE_NO_ANSWER = 19;
    public static final int AST_CAUSE_NO_ROUTE_DESTINATION = 3;
    public static final int AST_CAUSE_NO_ROUTE_TRANSIT_NET = 2;
    public static final int AST_CAUSE_NO_USER_RESPONSE = 18;
    public static final int AST_CAUSE_NORMAL_CIRCUIT_CONGESTION = 34;
    public static final int AST_CAUSE_NORMAL_CLEARING = 16;
    public static final int AST_CAUSE_NORMAL_TEMPORARY_FAILURE = 41;
    public static final int AST_CAUSE_NORMAL_UNSPECIFIED = 31;
    public static final int AST_CAUSE_NOT_DEFINED = 0;
    public static final int AST_CAUSE_NUMBER_CHANGED = 22;
    public static final int AST_CAUSE_OUTGOING_CALL_BARRED = 52;
    public static final int AST_CAUSE_PRE_EMPTIED = 45;
    public static final int AST_CAUSE_PROTOCOL_ERROR = 111;
    public static final int AST_CAUSE_RECOVERY_ON_TIMER_EXPIRE = 102;
    public static final int AST_CAUSE_REQUESTED_CHAN_UNAVAILABLE = 44;
    public static final int AST_CAUSE_RESPONSE_TO_STATUS_ENQUIRY = 30;
    public static final int AST_CAUSE_SUBSCRIBER_ABSENT = 20;
    public static final int AST_CAUSE_SWITCH_CONGESTION = 42;
    public static final int AST_CAUSE_UNALLOCATED = 1;
    public static final int AST_CAUSE_USER_BUSY = 17;
    public static final int AST_CAUSE_WRONG_CALL_STATE = 101;
    public static final int AST_CAUSE_WRONG_MESSAGE = 98;
}

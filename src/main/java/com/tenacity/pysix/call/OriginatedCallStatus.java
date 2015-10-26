package com.tenacity.pysix.call;

/**
 * Represents the status of an originated call
 */
public enum OriginatedCallStatus {

    /**
     * The call is waiting the response from the server of the originate action
     */
    WAITING,

    /**
     * The call is being dialed
     */
    DIALING,

    /**
     * The call is ringing
     */
    RINGING,

    /**
     * The call was answered
     */
    ANSWERED,

    /**
     * The call was not answered
     */
    NOT_ANSWERED,

    /**
     * The call was rejected
     */
    REJECTED,

    /**
     * The destination was unavailable
     */
    UNAVAILABLE,

    /**
     * The destination does not exist
     */
    NON_EXISTENT,


    /**
     * The destination is busy
     */
    BUSY,

    /**
     * There is no free channels to call the destination
     */
    NO_FREE_CHANNEL,


    /**
     * Unknown status
     */
    UNKNOWN

}

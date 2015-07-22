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
     * The call is ringing
     */
    RINGING,

    /**
     * The call was answered
     */
    ANSWERED,

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
     * Unknown status
     */
    UNKNOWN

}

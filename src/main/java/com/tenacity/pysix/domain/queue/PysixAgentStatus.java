package com.tenacity.pysix.domain.queue;

/**
 * Represents the status of Pysix Agent
 */
public enum PysixAgentStatus {
    /**
     * Device is valid but the state is Unknown
     */
    DEVICE_UNKNOWN,

    /**
     * Device is not being used
     */
    DEVICE_NOT_IN_USE,

    /**
     * Device is being used
     */
    DEVICE_IN_USE,

    /**
     * Device is busy
     */
    DEVICE_BUSY,

    /**
     * Device is invalid
     */
    DEVICE_INVALID,

    /**
     * Device is unavailable
     */
    DEVICE_UNAVAILABLE,

    /**
     * Device is ringing
     */
    DEVICE_RINGING,

    /**
     * Device is ringing and in use
     */
    DEVICE_RING_IN_USE,

    /**
     * Device is on hold
     */
    DEVICE_ON_HOLD;

    public static PysixAgentStatus fromAsteriskStatus(int asteriskStatus) {
        switch (asteriskStatus){
            case 0:
                return PysixAgentStatus.DEVICE_UNKNOWN;
            case 1:
                return PysixAgentStatus.DEVICE_NOT_IN_USE;
            case 2:
                return PysixAgentStatus.DEVICE_IN_USE;
            case 3:
                return PysixAgentStatus.DEVICE_BUSY;
            case 4:
                return PysixAgentStatus.DEVICE_INVALID;
            case 5:
                return PysixAgentStatus.DEVICE_UNAVAILABLE;
            case 6:
                return PysixAgentStatus.DEVICE_RINGING;
            case 7:
                return PysixAgentStatus.DEVICE_RING_IN_USE;
            case 8:
                return PysixAgentStatus.DEVICE_ON_HOLD;
            default:
                return PysixAgentStatus.DEVICE_UNKNOWN;
        }
    }
}

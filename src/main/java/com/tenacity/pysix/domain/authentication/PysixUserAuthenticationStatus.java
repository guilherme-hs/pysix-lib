package com.tenacity.pysix.domain.authentication;

/**
 * Represents the Authentication Status of a Pysix User
 */
public enum PysixUserAuthenticationStatus {
    AUTHENTICATED,
    PAUSED,
    NOT_AUTHENTICATED,
    LOGGED_OUT,
    CHALLENGE_ERROR,
    EXPIRED,
    NOT_LICENSED,
    UNKNOWN_ERROR
}

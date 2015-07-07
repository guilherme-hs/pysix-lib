package com.tenacity.pysix.domain.authentication;

/**
 * Represents the possible roles of a {@link com.tenacity.pysix.domain.authentication.PysixUser}
 */
public enum PysixUserRole {
    /**
     * Enables the guest access
     */
    ROLE_GUEST,
    /**
     * Enables all possible access
     */
    ROLE_ROOT,
    /**
     * Enables the administration of users
     */
    ROLE_USER_ADMINISTRATOR,
    /**
     * Enables read configurations from PBX_API
     */
    ROLE_PBX_API_CONFIG_READ

}

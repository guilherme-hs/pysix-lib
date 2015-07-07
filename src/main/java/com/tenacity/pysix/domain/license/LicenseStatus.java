package com.tenacity.pysix.domain.license;

/**
 * Represents the state of a license
 */
public enum LicenseStatus {
    /**
     * Not Licensed
     */
    UNLICENSED,
    /**
     * Licensed
     */
    LICENSED,
    /**
     * The license is disabled
     */
    DISABLED
}

package com.tenacity.pysix.domain.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import com.tenacity.pysix.domain.PhoneNumber;
import com.tenacity.pysix.domain.license.LicenseStatus;
import com.tenacity.pysix.security.cryptography.Cryptographer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Pysix User
 */
public class PysixUser {


    private static final int EXPECTED_TOKENS = 3;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * User email used as ID
     */
    private String username;

    /**
     * Customer ID
     */
    private String customerId;

    /**
     * Hashed password of the user
     */
    @JsonIgnore
    private String password;

    /**
     * Name of the user
     */
    private String name;

    /**
     *Business role of the user
     */
    private String businessRole;

    /**
     * User Roles
     */
    private final Set<PysixUserRole> roles = new HashSet<>();

    /**
     * User Phones
     */
    Set<PhoneNumber> phones = new HashSet<>();

    /**
     * Indicates if the account has expired
     * True - not expired
     * False - expired
     */
    private boolean accountNonExpired = true;

    /**
     * Indicates if the account is locked
     * True - unlocked
     * False - locked
     */
    private boolean accountNonLocked = true;

    /**
     * Indicates if the password is expired
     * True - not expired
     * False - expired
     */
    private boolean credentialsNonExpired = true;

    /**
     * Indicates if the user is enabled
     * True - enabled
     * False - not enabled
     */
    private boolean enabled = true;

    /**
     * Indicates the user licenseStatus
     */
    private LicenseStatus licenseStatus = LicenseStatus.LICENSED;

    public PysixUser() {
    }

    public PysixUser(String name, String username, String password) {
        this.setName(name);
        this.setUsername(username);
        this.setPassword(password);
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    public final String getPassword() {
        try {
            //searches and splits the password components
            String result = Cryptographer.decrypt(this.password);
            String[] tokens = result.split(":");
            if (tokens.length != EXPECTED_TOKENS) {
                logger.warn("Unexpected number of password tokens!:" + tokens.length);
                return null;
            }
            if (!tokens[0].equals(username)) {
                logger.warn("Wrong username on password token!");
                return null;
            }
            if (!tokens[1].equals("com.tenacity.pysix")) {
                logger.warn("Incorrect salt on password token!");
                return null;
            }

            return tokens[2];
        } catch (GeneralSecurityException e) {
            logger.warn("Error getting password", e);
        }
        return null;
    }

    public final void setPassword(String password) {
        try {
            this.password = Cryptographer.encrypt(username + ":" + "com.tenacity.pysix" + ":" + password);
        } catch (GeneralSecurityException e) {
            logger.warn("Error in Cryptographer!!!", e);
        }
    }

    public final String getRawPassword(){
        return this.password;
    }

    public final void setRawPassword(String password){
        this.password = password;
    }

    public final Set<PysixUserRole> getRoles() {
        return roles;
    }

    public final void addRole(PysixUserRole pysixUserRole) {
        roles.add(pysixUserRole);
    }

    public final Set<PhoneNumber> getPhones() {
        return phones;
    }

    public final void addPhone(PhoneNumber phoneNumber) {
        phones.add(phoneNumber);
    }

    public final boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public final void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public final boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public final void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public final boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public final void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public final boolean isEnabled() {
        return enabled;
    }

    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public final LicenseStatus getLicenseStatus() {
        return licenseStatus;
    }

    public final void setLicenseStatus(LicenseStatus licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public final String getBusinessRole() {
        return businessRole;
    }

    public final void setBusinessRole(String businessRole) {
        this.businessRole = businessRole;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PysixUser that = (PysixUser) o;

        return Objects.equal(this.username, that.username) &&
                Objects.equal(this.customerId, that.customerId) &&
                Objects.equal(this.password, that.password) &&
                Objects.equal(this.name, that.name) &&
                Objects.equal(this.businessRole, that.businessRole) &&
                Objects.equal(this.roles, that.roles) &&
                Objects.equal(this.phones, that.phones) &&
                Objects.equal(this.accountNonExpired, that.accountNonExpired) &&
                Objects.equal(this.accountNonLocked, that.accountNonLocked) &&
                Objects.equal(this.credentialsNonExpired, that.credentialsNonExpired) &&
                Objects.equal(this.enabled, that.enabled) &&
                Objects.equal(this.licenseStatus, that.licenseStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, customerId, password, name,
                businessRole, roles, phones, accountNonExpired, accountNonLocked,
                credentialsNonExpired, enabled, licenseStatus);
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("username", username)
                .add("customerId", customerId)
                .add("password", password)
                .add("name", name)
                .add("businessRole", businessRole)
                .add("roles", roles)
                .add("phones", phones)
                .add("accountNonExpired", accountNonExpired)
                .add("accountNonLocked", accountNonLocked)
                .add("credentialsNonExpired", credentialsNonExpired)
                .add("enabled", enabled)
                .add("licenseStatus", licenseStatus)
                .toString();
    }
}

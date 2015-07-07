package com.tenacity.pysix.domain.authentication;

import com.google.common.base.Objects;

import java.util.Date;

/**
 * Created by guilherme on 2/14/14.
 * Represents a PysixAuthenticationTry used to save the authentication tries
 */
public class PysixAuthenticationRegistry {

    /**
     * Id of the user trying to authenticate
     */
    private String username;

    /**
     * PysixUserDomain user domain
     */
    private PysixUserDomain pysixUserDomain;

    /**
     * Date that received the first call
     */
    private Date receivedDate;

    /**
     * Browser User Agent
     */
    private String userAgent;

    /**
     * User remoteAddress
     */
    private String remoteAddress;

    /**
     * User remotePort
     */
    private int remotePort;

    /**
     * Generated token
     */
    private String token;

    /**
     * Status of the authentication
     */
    private PysixUserAuthenticationStatus authenticationStatus;

    /**
     * Last Time the user was seen
     */
    private Date lastSeen;

    /**
     * Time the user loggedOut
     */
    private Date loggedOut;

    public PysixAuthenticationRegistry(String username, String realm, PysixUserDomain pysixUserDomain,
                                       Date receivedDate, String userAgent, String remoteAddress, int remotePort){
        this.username = username;
        this.receivedDate = new Date(receivedDate.getTime());
        this.userAgent = userAgent;
        this.remoteAddress = remoteAddress;
        this.remotePort = remotePort;

    }

    public PysixAuthenticationRegistry(){}

    public final String getUsername() {
        return username;
    }

    public final void setPysixUserDomain(PysixUserDomain pysixUserDomain) {
        this.pysixUserDomain = pysixUserDomain;
    }

    public final PysixUserDomain getPysixUserDomain() {
        return pysixUserDomain;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    public final Date getReceivedDate() {
        return new Date(receivedDate.getTime());
    }

    public final void setReceivedDate(Date receivedDate) {
        this.receivedDate = new Date(receivedDate.getTime());
    }

    public final String getUserAgent() {
        return userAgent;
    }

    public final void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public final String getRemoteAddress() {
        return remoteAddress;
    }

    public final void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public final int getRemotePort() {
        return remotePort;
    }

    public final void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    public final String getToken() {
        return token;
    }

    public final void setToken(String token) {
        this.token = token;
    }

    public final PysixUserAuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public final void setAuthenticationStatus(PysixUserAuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public final Date getLastSeen() {
        return new Date(lastSeen.getTime());
    }

    public final void setLastSeen(Date lastSeen) {
        this.lastSeen = new Date(lastSeen.getTime());
    }

    public final Date getLoggedOut() {
        if (loggedOut != null) {
            return new Date(loggedOut.getTime());
        }else{
            return null;
        }
    }

    public final void setLoggedOut(Date loggedOut) {
        if (loggedOut != null) {
            this.loggedOut = new Date(loggedOut.getTime());
        }else{
            this.loggedOut = null;
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PysixAuthenticationRegistry that = (PysixAuthenticationRegistry) o;

        return Objects.equal(this.username, that.username) &&
                Objects.equal(this.pysixUserDomain, that.pysixUserDomain) &&
                Objects.equal(this.receivedDate, that.receivedDate) &&
                Objects.equal(this.userAgent, that.userAgent) &&
                Objects.equal(this.remoteAddress, that.remoteAddress) &&
                Objects.equal(this.remotePort, that.remotePort) &&
                Objects.equal(this.token, that.token) &&
                Objects.equal(this.authenticationStatus, that.authenticationStatus) &&
                Objects.equal(this.lastSeen, that.lastSeen) &&
                Objects.equal(this.loggedOut, that.loggedOut);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, pysixUserDomain, receivedDate, userAgent, remoteAddress, remotePort,
                token, authenticationStatus, lastSeen, loggedOut);
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("username", username)
                .add("pysixUserDomain", pysixUserDomain)
                .add("receivedDate", receivedDate)
                .add("userAgent", userAgent)
                .add("remoteAddress", remoteAddress)
                .add("remotePort", remotePort)
                .add("token", token)
                .add("authenticationStatus", authenticationStatus)
                .add("lastSeen", lastSeen)
                .add("loggedOut", loggedOut)
                .toString();
    }
}

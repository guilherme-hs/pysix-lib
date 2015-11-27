package com.tenacity.pysix.domain.system;

import lombok.Data;

/**
 * Represents a Server
 */
@Data
public class Server {

    /**
     * Server identification
     */
    protected String id;

    /**
     * Server name
     */
    protected String name;

    /**
     * Server protocol
     */
    protected String protocol;

    /**
     * Server hostname
     */
    protected String hostname;

    /**
     * Server port
     */
    protected int port=0;

    /**
     * pbx_api path
     */
    protected String pbxApiPath="";

    /**
     * latency to the server in ms
     */
    protected int latency;

    /**
     * version of the server
     */
    protected String version;

    /**
     * username used to connect in the server
     */
    protected String username;
    /**
     * password used to connect in the server
     */
    protected String password;

}

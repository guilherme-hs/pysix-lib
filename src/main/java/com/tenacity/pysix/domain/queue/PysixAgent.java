package com.tenacity.pysix.domain.queue;

import lombok.Data;

/**
 * Represents a pysixAgent
 */
@Data
public class PysixAgent {

    /**
     * Agent name
     */
    protected String name;

    /**
     * Is the member paused on the queue
     */
    protected boolean paused;

    /**
     * Interface used by the agent
     */
    protected String location;

    /**
     * Penalty of the agent on the queue
     */
    protected int penalty;

    /**
     * Queue of the agent
     */
    protected String queue;

    /**
     * Type of membership(static,dynamic)
     */
    protected String membership;

    /**
     * Calls taken by the agent
     */
    protected int callsTaken;

    /**
     * Time of the last successful call to the agent
     */
    protected long lastCall;

    /**
     * alternative interface to determine the state of the agent
     */
    protected String stateInterface;

}

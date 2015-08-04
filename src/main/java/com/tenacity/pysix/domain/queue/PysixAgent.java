package com.tenacity.pysix.domain.queue;

import lombok.Data;
import org.asteriskjava.manager.event.QueueMemberEvent;

/**
 * Represents a pysixAgent
 */
@Data
public class PysixAgent {

    public PysixAgent(QueueMemberEvent queueMemberEvent){
        this.name = queueMemberEvent.getName();
        this.paused = queueMemberEvent.getPaused();
        this.status = PysixAgentStatus.fromAsteriskStatus(queueMemberEvent.getStatus());
        this.location = queueMemberEvent.getLocation();
        this.penalty = queueMemberEvent.getPenalty();
        this.queue = queueMemberEvent.getQueue();
        this.membership = queueMemberEvent.getMembership();
        this.callsTaken = queueMemberEvent.getCallsTaken();
        this.lastCall = queueMemberEvent.getLastCall();
        this.stateInterface = queueMemberEvent.getStateinterface();
    }

    public PysixAgent(){}

    /**
     * Agent name
     */
    protected String name;

    /**
     * Is the member paused on the queue
     */
    protected boolean paused;

    /**
     * Pysix Agent Status
     */
    protected PysixAgentStatus status;

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

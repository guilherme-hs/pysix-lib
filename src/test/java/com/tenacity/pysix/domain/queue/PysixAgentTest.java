package com.tenacity.pysix.domain.queue;

import org.asteriskjava.manager.event.QueueMemberAddedEvent;
import org.asteriskjava.manager.event.QueueMemberEvent;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PysixAgentTest {

    public static final int CALLS_TAKEN = 10;
    public static final long LAST_CALL = 100000L;
    public static final String LOCATION = "SIP/1000";
    public static final String AGENT = "Agent";
    public static final String STATIC = "static";
    public static final boolean PAUSED = false;
    public static final int PENALTY = 10;
    public static final String ATIVO = "ativo";
    public static final String STATEINTERFACE = "SIP/1001";

    @Test
    public void fullConstructorTest(){
        QueueMemberEvent queueMemberEvent = new QueueMemberEvent(new Object());
        queueMemberEvent.setCallsTaken(CALLS_TAKEN);
        queueMemberEvent.setLastCall(LAST_CALL);
        queueMemberEvent.setLocation(LOCATION);
        queueMemberEvent.setName(AGENT);
        queueMemberEvent.setMembership(STATIC);
        queueMemberEvent.setPaused(PAUSED);
        queueMemberEvent.setPenalty(PENALTY);
        queueMemberEvent.setQueue(ATIVO);
        queueMemberEvent.setStateinterface(STATEINTERFACE);
        queueMemberEvent.setStatus(1);
        PysixAgent pysixAgent = new PysixAgent(queueMemberEvent);
        assertThat(pysixAgent.getCallsTaken(), equalTo(CALLS_TAKEN));
        assertThat(pysixAgent.getLastCall(), equalTo(LAST_CALL));
        assertThat(pysixAgent.getLocation(), equalTo(LOCATION));
        assertThat(pysixAgent.getName(), equalTo(AGENT));
        assertThat(pysixAgent.getMembership(), equalTo(STATIC));
        assertThat(pysixAgent.isPaused(), equalTo(PAUSED));
        assertThat(pysixAgent.getPenalty(), equalTo(PENALTY));
        assertThat(pysixAgent.getQueue(), equalTo(ATIVO));
        assertThat(pysixAgent.getStateInterface(), equalTo(STATEINTERFACE));
        assertThat(pysixAgent.getStatus(), equalTo(PysixAgentStatus.DEVICE_NOT_IN_USE));
    }


}
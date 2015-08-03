package com.tenacity.pysix.domain.queue;


import lombok.Data;
import org.asteriskjava.manager.event.QueueParamsEvent;

/**
 * Represents a Pysix Queue
 */
@Data
public class PysixQueue {


    public PysixQueue(QueueParamsEvent  queueParamsEvent){
        this.queue = queueParamsEvent.getQueue();
        this.strategy = queueParamsEvent.getStrategy();
        this.weight = queueParamsEvent.getWeight();
        this.calls = queueParamsEvent.getCalls();
        this.completed = queueParamsEvent.getCompleted();
        this.holdTime = queueParamsEvent.getHoldTime();
        this.talkTime = queueParamsEvent.getTalkTime();
        this.max = queueParamsEvent.getMax();
        this.serviceLevel = queueParamsEvent.getServiceLevel();
        this.serviceLevelPerf = queueParamsEvent.getServiceLevelPerf();
    }

    /**
     * name of the queue
     */
    protected String queue;

    /**
     * strategy of the queue
     */
    protected String strategy;

    /**
     * weight of the queue
     */
    protected int weight;

    /**
     * number of calls currently waiting in the queue
     */
    protected int calls;

    /**
     * number of completed calls
     */
    protected int completed;

    /**
     * average holdTime for the queue
     */
    protected int holdTime;

    /**
     * average talk time based on exponential average
     */
    protected int talkTime;

    /**
     * Maximum number of people waiting in the queue
     */
    protected int max;

    /**
     * Service level defined in the queues.conf
     */
    protected int serviceLevel;

    /**
     * Percentage of the calls answered in the specified service level
     */
    protected double serviceLevelPerf;

}

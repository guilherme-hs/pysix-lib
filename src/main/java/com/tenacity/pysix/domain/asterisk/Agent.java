package com.tenacity.pysix.domain.asterisk;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Represents an Agent
 */
@Entity
@Table(catalog = "correiodb",name = "queue_member_table")
public class Agent {
    @Id
    @Column(name="uniqueid")
    private int uniqueId;

    @Column(name = "membername")
    private String memberName;

    @Column(name = "queue_name")
    private String queueName;

    @Column(name = "interface")
    private String interfaceName;

    @Column(name = "penalty")
    private int penalty;

    @Column(name = "paused")
    private int paused;

    @Column(name = "status")
    private String status;

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getPaused() {
        return paused;
    }

    public void setPaused(int paused) {
        this.paused = paused;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agent)) return false;

        Agent agent = (Agent) o;
        return Objects.equal(getUniqueId(), agent.getUniqueId()) &&
                Objects.equal(getPenalty(), agent.getPenalty()) &&
                Objects.equal(getPaused(), agent.getPaused()) &&
                Objects.equal(getMemberName(), agent.getMemberName()) &&
                Objects.equal(getQueueName(), agent.getQueueName()) &&
                Objects.equal(getInterfaceName(), agent.getInterfaceName()) &&
                Objects.equal(getStatus(), agent.getStatus());
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(getUniqueId(), getMemberName(), getQueueName(), getInterfaceName(), getPenalty(), getPaused(), getStatus());
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("uniqueId", uniqueId)
                .add("memberName", memberName)
                .add("queueName", queueName)
                .add("interfaceName", interfaceName)
                .add("penalty", penalty)
                .add("paused", paused)
                .add("status", status)
                .toString();
    }
}
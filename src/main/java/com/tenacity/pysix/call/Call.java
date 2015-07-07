package com.tenacity.pysix.call;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 7/15/13
 * Time: 9:26 AM
 * Represents a Call
 */
@Entity
public class Call {

    /**
     * Unique String that identifies every call made
     * Set on the creation of the object
     */
    @Id
    private String id;

    /**
     * CallerId of the call
     */
    private String callerIdNumber;
    private String callerIdName;

    /**
     * Represents the current status of a call
     */
    @Enumerated(EnumType.STRING)
    private CallStatus status;

    /**
     * Represents the Disposition of a finalized call
     */
    @Enumerated(EnumType.STRING)
    private CallDisposition disposition;

    /**
     * Represents the moment the call was started until it was ringing
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    /**
     * Represents the moment the call was reported ringing
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date ring;

    /**
     * Represents the moment the call was answered
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date answer;

    /**
     * Represents the moment the call ended
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date ended;

    /**
     * Represents the channel used by the call
     */
    private String channel;

    /**
     * Represents the number dialed by the call
     */
    private String extension;

    /**
     * Represents the context used to make the call
     */
    private String context;

    /**
     * Represents the originator of the current channel
     * If the sourceId equals the current Id, it means this channel originated the call
     * Else it links to the original call
     */
    private String sourceId;

    /**
     * Represents the originator of the current channel
     * If the sourceId equals the current Id, it means this channel originated the call
     * Else it links to the original call
     */
    private String destinationId;


    /**
     * Represents the hangup cause of the current channel
     * Normally represents the PRI disconnect cause
     */
    private int hangupCause;

    /**
     * Represents the id of the customer if it was ever set
     * in the variable customerId
     */
    private String customerId;

    /**
     * Represents the custom variables that can be setted on the call
     */
    @ElementCollection
    protected Map<String,String> customVars = new HashMap<String, String>();

    /**
     * Static factory
     *
     * @param id - id of the call
     * @return clean call with the id set
     */
    public static Call getInstance(String id) {
        return (new CallBuilder(id)).build();
    }

    public Call() {
    }

    private Call(CallBuilder callBuilder) {
        if (callBuilder.callerId != null) {
            this.callerIdNumber = callBuilder.callerId.getNumber();
            this.callerIdName = callBuilder.callerId.getName();
        }
        this.id = callBuilder.id;
        this.status = callBuilder.status;
        this.disposition = callBuilder.disposition;
        this.start = callBuilder.start;
        this.ring = callBuilder.ring;
        this.answer = callBuilder.answer;
        this.ended = callBuilder.ended;
        this.channel = callBuilder.channel;
        this.extension = callBuilder.extension;
        this.context = callBuilder.context;
        this.sourceId = callBuilder.sourceId;
        this.destinationId = callBuilder.destinationId;
        this.hangupCause = callBuilder.hangupCause;
        this.customerId = callBuilder.customerId;
    }


    public final String getId() {
        return id;
    }

    public final CallerId getCallerId() {
        return CallerId.getInstance(callerIdNumber, callerIdName);
    }

    public final CallStatus getStatus() {
        return status;
    }

    public final CallDisposition getDisposition() {
        return disposition;
    }

    public final Date getStart() {
        if (start != null) {
            return new Date(start.getTime());
        } else {
            return null;
        }
    }

    public final Date getRing() {
        if (ring != null) {
            return new Date(ring.getTime());
        } else {
            return null;
        }
    }

    public final Date getAnswer() {
        if (answer != null) {
            return new Date(answer.getTime());
        } else {
            return null;
        }
    }

    public final Date getEnded() {
        if (ended != null) {
            return new Date(ended.getTime());
        } else {
            return null;
        }
    }

    public final String getChannel() {
        return channel;
    }

    public final String getExtension() {
        return extension;
    }

    public final String getContext() {
        return context;
    }

    public final String getSourceId() {
        return sourceId;
    }

    public final String getDestinationId() {
        return destinationId;
    }

    public final int getHangupCause() {
        return hangupCause;
    }

    public final String getCustomerId(){
        return customerId;
    }

    public final void setCustomVariable(String variable, String value){
        customVars.put(variable,value);
    }
    public final String getCustomVariable(String variable){
        return customVars.get(variable);
    }

    public final Set<Map.Entry<String,String>> getCustomVars(){
    return customVars.entrySet();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(id, callerIdNumber, callerIdName, status, disposition, start, ring, answer, ended,
                channel, extension, context, sourceId, destinationId, hangupCause, customerId);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Call other = (Call) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.callerIdNumber, other.callerIdNumber) &&
                Objects.equal(this.callerIdName, other.callerIdName) && Objects.equal(this.status, other.status) &&
                Objects.equal(this.disposition, other.disposition) && Objects.equal(this.start, other.start) &&
                Objects.equal(this.ring, other.ring) && Objects.equal(this.answer, other.answer) &&
                Objects.equal(this.ended, other.ended) && Objects.equal(this.channel, other.channel) &&
                Objects.equal(this.extension, other.extension) && Objects.equal(this.context, other.context) &&
                Objects.equal(this.sourceId, other.sourceId) && Objects.equal(this.destinationId, other.destinationId) &&
                Objects.equal(this.hangupCause, other.hangupCause) && Objects.equal(this.customerId, other.customerId);
    }

    @Override
    public final String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("callerIdNum", callerIdNumber)
                .add("callerIdName", callerIdName)
                .add("status", status)
                .add("disposition", disposition)
                .add("start", start)
                .add("ring", ring)
                .add("answer", answer)
                .add("ended", ended)
                .add("channel", channel)
                .add("extension", extension)
                .add("context", context)
                .add("sourceId", sourceId)
                .add("destinationId", destinationId)
                .add("hangupCause", hangupCause)
                .add("customerId", customerId)
                .toString();
    }

    public static final class CallBuilder {
        //Required Parameters
        private final String id;
        private CallerId callerId;
        private CallStatus status = null;
        private CallDisposition disposition = CallDisposition.IN_PROGRESS;
        private Date start = null;
        private Date ring = null;
        private Date answer = null;
        private Date ended = null;
        private String channel = null;
        private String extension = null;
        private String context = null;
        private String sourceId = null;
        private String destinationId = null;
        private int hangupCause = 0;
        private String customerId = null;

        public CallBuilder(String id) {
            checkNotNull(id);
            this.id = id;
        }

        public CallBuilder(Call call) {
            this.id = call.getId();
            this.status = call.getStatus();
            this.callerId = call.getCallerId();
            this.disposition = call.getDisposition();
            if (call.getStart() != null) {
                this.start = new Date(call.getStart().getTime());
            }
            if (call.getRing() != null) {
                this.ring = new Date(call.getRing().getTime());
            }
            if (call.getAnswer() != null) {
                this.answer = new Date(call.getAnswer().getTime());
            }
            if (call.getEnded() != null) {
                this.ended = new Date(call.getEnded().getTime());
            }
            this.channel = call.getChannel();
            this.extension = call.getExtension();
            this.context = call.getContext();
            this.sourceId = call.getSourceId();
            this.destinationId = call.getDestinationId();
            this.hangupCause = call.getHangupCause();
            this.customerId = call.getCustomerId();
        }

        public CallBuilder status(CallStatus status) {
            this.status = status;
            return this;
        }

        public CallBuilder callerId(CallerId callerId) {
            this.callerId = callerId;
            return this;
        }

        public CallBuilder disposition(CallDisposition disposition) {
            this.disposition = disposition;
            return this;
        }

        public CallBuilder start(Date start) {
            if (start == null) {
                this.start = null;
            } else {
                this.start = new Date(start.getTime());
            }
            return this;
        }

        public CallBuilder ring(Date ring) {
            if (ring == null) {
                this.ring = null;
            } else {
                this.ring = new Date(ring.getTime());
            }
            return this;
        }

        public CallBuilder answer(Date answer) {
            if (answer == null) {
                this.answer = null;
            } else {
                this.answer = new Date(answer.getTime());
            }
            return this;
        }

        public CallBuilder ended(Date ended) {
            if (ended == null) {
                this.ended = null;
            } else {
                this.ended = new Date(ended.getTime());
            }
            return this;
        }

        public CallBuilder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public CallBuilder extension(String extension) {
            this.extension = extension;
            return this;
        }

        public CallBuilder context(String context) {
            this.context = context;
            return this;
        }

        public CallBuilder sourceId(String sourceId) {
            this.sourceId = sourceId;
            return this;
        }

        public CallBuilder destinationId(String destinationId) {
            this.destinationId = destinationId;
            return this;
        }

        public CallBuilder hangupCause(int hangupCause) {
            this.hangupCause = hangupCause;
            return this;
        }

        public CallBuilder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Call build() {
            return new Call(this);
        }

    }
}

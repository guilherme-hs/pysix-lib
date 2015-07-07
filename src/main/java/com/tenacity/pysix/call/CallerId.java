package com.tenacity.pysix.call;

import com.google.common.base.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 7/15/13
 * Time: 4:19 PM
 * Represents a CallerId of a call
 */
public final class CallerId {
    /**
     * Number part of the callerId
     */
    private final String number;
    /**
     * Name part of the callerId
     */
    private final String name;


    /**
     * Caller Id Factory
     *
     * @param number - Number part of the callerId
     * @param name   - Name part of the callerId
     * @return Caller Id
     */
    public static CallerId getInstance(String number, String name) {
        return new CallerId(number, name);
    }

    private CallerId(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("number", number)
                .add("name", name)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CallerId other = (CallerId) obj;
        return Objects.equal(this.number, other.number) && Objects.equal(this.name, other.name);
    }
}

package com.tenacity.pysix.domain.license;

import com.google.common.base.Objects;

/**
 * Represents an license
 */
public class License {
    public License(String name, long validUntil, int quantity) {
        this.name = name;
        this.validUntil = validUntil;
        this.quantity = quantity;
    }

    protected String name;

    protected long validUntil;

    protected int quantity;

    public String getName() {
        return name;
    }

    public long getValidUntil() {
        return validUntil;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof License)) return false;
        License license = (License) o;
        return getValidUntil() == license.getValidUntil() &&
                getQuantity() == license.getQuantity() &&
                Objects.equal(getName(), license.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getValidUntil(), getQuantity());
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("validUntil", validUntil)
                .add("quantity", quantity)
                .toString();
    }
}

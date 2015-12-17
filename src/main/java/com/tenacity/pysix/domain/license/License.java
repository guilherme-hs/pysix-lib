package com.tenacity.pysix.domain.license;

import lombok.Data;

/**
 * Represents an license
 */
@Data
public class License {
    public License(String name, int quantity) {
        this.name = name;
        this.validUntil = 0;
        this.quantity = quantity;
    }

    public License(String name, int quantity, long validUntil) {
        this.name = name;
        this.validUntil = validUntil;
        this.quantity = quantity;
    }

    protected String name;

    protected long validUntil;

    protected int quantity;
}

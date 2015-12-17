package com.tenacity.pysix.domain;

import com.tenacity.pysix.domain.license.License;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Customer
 */
@Data
public class Customer {

    protected String id;

    protected String name;

    protected Map<String,License> licenses = new HashMap<>();

    protected boolean hasLicense(String licenseName){
        return licenses.containsKey(licenseName);
    }

    protected License getLicense(String licenseName){
        return licenses.get(licenseName);
    }

    protected Customer addLicense(License license){
        this.licenses.put(license.getName(),license);
        return this;
    }

}

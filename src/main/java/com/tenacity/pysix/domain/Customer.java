package com.tenacity.pysix.domain;

import com.tenacity.pysix.domain.license.License;

import java.util.Map;

/**
 * Represents a Customer
 */
public class Customer {

    protected String id;

    protected String name;

    protected Map<String,License> licenses;

}

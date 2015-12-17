package com.tenacity.pysix.domain;

import com.tenacity.pysix.domain.license.License;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CustomerTest {

    public static final String DEFAULT_LICENSE = "default license";
    public static final String DEFAULT_LICENSE1 = "default license 1";
    public static final String NON_EXISTENT_LICENSE = "non existent license";

    @Test
    public void addNewLicenseTest(){
        Customer customer = new Customer();
        License license = new License(DEFAULT_LICENSE,1);
        customer.addLicense(license);
        assertThat(customer.licenses.get(DEFAULT_LICENSE), equalTo(license));
    }

    @Test
    public void addAnotherLicenseTest(){
        Customer customer = new Customer();
        License license = new License(DEFAULT_LICENSE,1);
        License license1 = new License(DEFAULT_LICENSE1,2);
        customer.addLicense(license);
        customer.addLicense(license1);
        assertThat(customer.licenses.get(DEFAULT_LICENSE), equalTo(license));
        assertThat(customer.licenses.get(DEFAULT_LICENSE1), equalTo(license1));
    }

    @Test
    public void replaceLicenseTest(){
        Customer customer = new Customer();
        License license = new License(DEFAULT_LICENSE,1);
        License license1 = new License(DEFAULT_LICENSE1,2);
        License license2 = new License(DEFAULT_LICENSE,3);
        customer.addLicense(license);
        customer.addLicense(license1);
        customer.addLicense(license2);
        assertThat(customer.licenses.get(DEFAULT_LICENSE), equalTo(license2));
        assertThat(customer.licenses.get(DEFAULT_LICENSE1), equalTo(license1));
    }


    @Test
    public void hasLicenseTest(){
        Customer customer = new Customer();
        License license = new License(DEFAULT_LICENSE,1);
        License license1 = new License(DEFAULT_LICENSE1,2);
        customer.addLicense(license);
        customer.addLicense(license1);
        assertThat(customer.hasLicense(DEFAULT_LICENSE), equalTo(true));
        assertThat(customer.hasLicense(DEFAULT_LICENSE1), equalTo(true));
        assertThat(customer.hasLicense(NON_EXISTENT_LICENSE), equalTo(false));
    }

}
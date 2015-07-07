package com.tenacity.pysix.domain;

import com.google.common.base.Objects;

/**
 * Represents a Phone Number
 */
public class PhoneNumber {
    String countryCode;
    String areaCode;
    String prefix;
    String extension;
    String description;

    public PhoneNumber(){}
    public PhoneNumber(String countryCode, String areaCode, String prefix, String extension, String description){
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.extension = extension;
        this.description = description;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        return Objects.equal(this.countryCode, that.countryCode) &&
                Objects.equal(this.areaCode, that.areaCode) &&
                Objects.equal(this.prefix, that.prefix) &&
                Objects.equal(this.extension, that.extension) &&
                Objects.equal(this.description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(countryCode, areaCode, prefix, extension, description);
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("countryCode", countryCode)
                .add("areaCode", areaCode)
                .add("prefix", prefix)
                .add("extension", extension)
                .add("description", description)
                .toString();
    }
}

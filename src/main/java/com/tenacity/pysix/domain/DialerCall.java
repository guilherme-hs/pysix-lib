package com.tenacity.pysix.domain;


import com.tenacity.pysix.call.OriginatedCall;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.Map;

/**
 * Represents a call to the destination
 */
@Data
@Log4j
public class DialerCall {

    /**
     * Id of the call
     */
    String id;

    /**
     * Number to be called
     */
    PhoneNumber number;

    /**
     * User destination to be called
     */
    String destination;

    /**
     * Originated Calls Status
     */
    Map<String,String> originatedCallStatus;


    /**
     * Options to be used on the call
     */
    Map<String,String> options;

}

package com.tenacity.pysix.call;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CallerIdTest {

    private static final String CALLERID_NUM = "1000";
    private static final String CALLERID_NAME = "Test CallerId";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void ConstructorTest(){
        CallerId callerId = CallerId.getInstance(CALLERID_NUM, CALLERID_NAME);
        assertThat(callerId.getNumber(),equalTo(CALLERID_NUM));
        assertThat(callerId.getName(),equalTo(CALLERID_NAME));
        logger.debug(callerId.toString()+callerId.hashCode());
    }
}
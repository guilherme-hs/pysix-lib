package com.tenacity.pysix.call;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OriginatedCallTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String ORIGIN = "212";
    private static final String ORIGIN_CONTEXT = "origin_context";
    private static final String DESTINATION = "#9932179200";
    private static final String DESTINATION_CONTEXT = "destination_context";
    private static final long TIMEOUT = 30;
    private static final String ORIGINAL_CALL_ID = "1234567890";
    //private static final String DESTINATION_CALL_ID = "1111111111";
    private static final String ID_FIELD = "id";
    private static final int ID_VALUE = 1;
    private static final String DEFAULT_CONTEXT = "default";
    private static final long DEFAULT_TIMEOUT = 30;

    @Test
    public void SimpleConstructorTest(){
        OriginatedCall originatedCall = (new OriginatedCall.OriginatedCallBuilder(ORIGIN,ORIGIN_CONTEXT, DESTINATION, DESTINATION_CONTEXT, TIMEOUT)).build();
        assertThat(originatedCall.getOrigin(),equalTo(ORIGIN));
        assertThat(originatedCall.getOriginContext(),equalTo(ORIGIN_CONTEXT));
        assertThat(originatedCall.getDestination(),equalTo(DESTINATION));
        assertThat(originatedCall.getDestinationContext(),equalTo(DESTINATION_CONTEXT));
        assertThat(originatedCall.getTimeout(),equalTo(TIMEOUT));
        OriginatedCall staticOriginatedCall = OriginatedCall.getInstance(ORIGIN,ORIGIN_CONTEXT,DESTINATION, DESTINATION_CONTEXT,TIMEOUT);
        assertThat(staticOriginatedCall.getOrigin(),equalTo(ORIGIN));
        assertThat(staticOriginatedCall.getOriginContext(),equalTo(ORIGIN_CONTEXT));
        assertThat(staticOriginatedCall.getDestination(),equalTo(DESTINATION));
        assertThat(staticOriginatedCall.getDestinationContext(),equalTo(DESTINATION_CONTEXT));
        assertThat(staticOriginatedCall.getTimeout(),equalTo(TIMEOUT));
        logger.debug(originatedCall.toString()+originatedCall.hashCode());
    }

    @Test
    public void FullConstructorTest(){
        OriginatedCall originatedCall = (new OriginatedCall.OriginatedCallBuilder(ORIGIN,ORIGIN_CONTEXT,DESTINATION, DESTINATION_CONTEXT,TIMEOUT)
                .originalCallId(ORIGINAL_CALL_ID)).build();
        assertThat(originatedCall.getOrigin(),equalTo(ORIGIN));
        assertThat(originatedCall.getOriginContext(),equalTo(ORIGIN_CONTEXT));
        assertThat(originatedCall.getDestination(),equalTo(DESTINATION));
        assertThat(originatedCall.getDestinationContext(),equalTo(DESTINATION_CONTEXT));
        assertThat(originatedCall.getTimeout(),equalTo(TIMEOUT));
        assertThat(originatedCall.getOriginalCallId(),equalTo(ORIGINAL_CALL_ID));
        //assertThat(originatedCall.getDestinationCallId(),equalTo(DESTINATION_CALL_ID));
    }

    @Test
    public void ObjectConstructorTest(){
        OriginatedCall sampleOriginatedCall = (new OriginatedCall.OriginatedCallBuilder(ORIGIN,ORIGIN_CONTEXT,DESTINATION, DESTINATION_CONTEXT,TIMEOUT))
                .originalCallId(ORIGINAL_CALL_ID).build();
        ReflectionTestUtils.setField(sampleOriginatedCall, ID_FIELD, ID_VALUE);
        OriginatedCall originatedCall = (new OriginatedCall.OriginatedCallBuilder(sampleOriginatedCall)).build();
        assertThat(originatedCall,equalTo(sampleOriginatedCall));
    }

    @Test
    public void defaultValuesTest(){
        OriginatedCall originatedCall = (new OriginatedCall.OriginatedCallBuilder(ORIGIN,null, DESTINATION, null, 0)).build();
        assertThat(originatedCall.getOrigin(),equalTo(ORIGIN));
        assertThat(originatedCall.getOriginContext(),equalTo(null));
        assertThat(originatedCall.getDestination(),equalTo(DESTINATION));
        assertThat(originatedCall.getDestinationContext(),equalTo(DEFAULT_CONTEXT));
        assertThat(originatedCall.getTimeout(),equalTo(DEFAULT_TIMEOUT));
    }

}
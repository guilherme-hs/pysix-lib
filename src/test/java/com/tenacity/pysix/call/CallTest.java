package com.tenacity.pysix.call;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CallTest {

    private static final String TEST_ID = "TestId";
    private static final String CALLER_ID_NUM = "1000";
    private static final String CALLER_ID_NAME = "TestCallerId";
    private static final String DESTINATION_EXTENSION = "#8893138110";
    private static final String DESTINATION_CONTEXT = "INTERNOSIP";
    public static final String SOME_VAR = "someVar";
    public static final String SOME_VALUE = "someValue";
    public static final String ANOTHER_VAR = "anotherVar";
    public static final String ANOTHER_VALUE = "anotherValue";
    private final CallerId callerId = CallerId.getInstance(CALLER_ID_NUM, CALLER_ID_NAME);
    private static final String CHANNEL = "Test/Channel";
    private static final String DESTINATION_ID = "DestinationId";
    private Calendar start;
    private Calendar ring;
    private Calendar answer;
    private Calendar end;

    @Before
    public void setup(){
        start = Calendar.getInstance();
        start.set(2013,Calendar.JANUARY,1,8,0,0);
        ring = Calendar.getInstance();
        ring.set(2013,Calendar.JANUARY,1,8,0,2);
        answer = Calendar.getInstance();
        answer.set(2013,Calendar.JANUARY,1,8,0,10);
        end = Calendar.getInstance();
        end.set(2013, Calendar.JANUARY, 1, 8, 0, 30);
    }

    @Test
    public void SimpleConstructorTest(){
        Call testCallBuilder = new Call.CallBuilder(TEST_ID).build();
        assertThat(testCallBuilder.getId(),equalTo(TEST_ID));
        assertThat(testCallBuilder.getDisposition(),equalTo(CallDisposition.IN_PROGRESS));
        Call testCallStaticFactory = Call.getInstance(TEST_ID);
        assertThat(testCallStaticFactory.getId(),equalTo(TEST_ID));
        assertThat(testCallStaticFactory.getDisposition(),equalTo(CallDisposition.IN_PROGRESS));
    }

    @Test
    public void FullConstructorTest(){
        Call testCall = new Call.CallBuilder(TEST_ID).status(CallStatus.RINGING).callerId(callerId).disposition(CallDisposition.ANSWERED).
                start(start.getTime()).ring(ring.getTime()).answer(answer.getTime()).ended(end.getTime()).channel(CHANNEL).
                extension(DESTINATION_EXTENSION).context(DESTINATION_CONTEXT).sourceId(TEST_ID).
                destinationId(DESTINATION_ID).hangupCause(CallDisposition.AST_CAUSE_NORMAL_CLEARING).build();
        assertThat(testCall.getId(),equalTo(TEST_ID));
        assertThat(testCall.getStatus(),equalTo(CallStatus.RINGING));
        assertThat(testCall.getCallerId(),equalTo(callerId));
        assertThat(testCall.getDisposition(),equalTo(CallDisposition.ANSWERED));
        assertThat(testCall.getStart(),equalTo(start.getTime()));
        assertThat(testCall.getRing(),equalTo(ring.getTime()));
        assertThat(testCall.getAnswer(),equalTo(answer.getTime()));
        assertThat(testCall.getEnded(),equalTo(end.getTime()));
        assertThat(testCall.getChannel(),equalTo(CHANNEL));
        assertThat(testCall.getExtension(),equalTo(DESTINATION_EXTENSION));
        assertThat(testCall.getContext(),equalTo(DESTINATION_CONTEXT));
        assertThat(testCall.getSourceId(),equalTo(TEST_ID));
        assertThat(testCall.getDestinationId(),equalTo(DESTINATION_ID));
        assertThat(testCall.getHangupCause(),equalTo(CallDisposition.AST_CAUSE_NORMAL_CLEARING));
        System.out.println(testCall);
    }

    @Test
    public void CallConstructorTest(){
        Call patternCall = new Call.CallBuilder(TEST_ID).status(CallStatus.RINGING)
                .callerId(callerId).disposition(CallDisposition.ANSWERED).
                        start(start.getTime()).ring(ring.getTime()).answer(answer.getTime()).ended(end.getTime()).
                        channel(CHANNEL).extension(DESTINATION_EXTENSION).context(DESTINATION_CONTEXT).sourceId(TEST_ID).
                        destinationId(DESTINATION_ID).hangupCause(CallDisposition.AST_CAUSE_NORMAL_CLEARING).build();
        Call testCall = new Call.CallBuilder(patternCall).build();
        assertThat(testCall.getId(),equalTo(TEST_ID));
        assertThat(testCall.getStatus(),equalTo(CallStatus.RINGING));
        assertThat(testCall.getCallerId(),equalTo(callerId));
        assertThat(testCall.getDisposition(),equalTo(CallDisposition.ANSWERED));
        assertThat(testCall.getStart(),equalTo(start.getTime()));
        assertThat(testCall.getRing(),equalTo(ring.getTime()));
        assertThat(testCall.getAnswer(),equalTo(answer.getTime()));
        assertThat(testCall.getEnded(),equalTo(end.getTime()));
        assertThat(testCall.getChannel(),equalTo(CHANNEL));
        assertThat(testCall.getExtension(),equalTo(DESTINATION_EXTENSION));
        assertThat(testCall.getContext(),equalTo(DESTINATION_CONTEXT));
        assertThat(testCall.getSourceId(),equalTo(TEST_ID));
        assertThat(testCall.getDestinationId(),equalTo(DESTINATION_ID));
        assertThat(testCall.getHangupCause(),equalTo(CallDisposition.AST_CAUSE_NORMAL_CLEARING));
        System.out.println(testCall);
    }

    @Test
    public void CustomVariablesTest(){
        Call patternCall = new Call.CallBuilder(TEST_ID).status(CallStatus.RINGING)
                .callerId(callerId).disposition(CallDisposition.ANSWERED).
                        start(start.getTime()).ring(ring.getTime()).answer(answer.getTime()).ended(end.getTime()).
                        channel(CHANNEL).extension(DESTINATION_EXTENSION).context(DESTINATION_CONTEXT).sourceId(TEST_ID).
                        destinationId(DESTINATION_ID).hangupCause(CallDisposition.AST_CAUSE_NORMAL_CLEARING).build();
        Call testCall = new Call.CallBuilder(patternCall).build();
        testCall.setCustomVariable(SOME_VAR, SOME_VALUE);
        testCall.setCustomVariable(ANOTHER_VAR, ANOTHER_VALUE);
        assertThat(testCall.getCustomVars().size(), equalTo(2));
        assertThat(testCall.getCustomVariable(SOME_VAR), equalTo(SOME_VALUE));
        assertThat(testCall.getCustomVariable(ANOTHER_VAR), equalTo(ANOTHER_VALUE));
    }


}
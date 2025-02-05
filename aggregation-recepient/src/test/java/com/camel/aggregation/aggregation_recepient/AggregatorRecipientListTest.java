package com.camel.aggregation.aggregation_recepient;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AggregatorRecipientListTest extends CamelTestSupport {

    

    @Test
    public void testAggregationWithRecipientList() throws Exception {
        MockEndpoint mockResult = getMockEndpoint("mock:result");
        mockResult.expectedMessageCount(1);

        template.sendBody("direct:start", "Test Request");

        mockResult.assertIsSatisfied();
        String response = mockResult.getReceivedExchanges().get(0).getIn().getBody(String.class);

        String expectedResponse = "{\"service1\":\"Response from Service 1\",\"service2\":\"Response from Service 2\"}";

        assertEquals(expectedResponse, response);
    }
}

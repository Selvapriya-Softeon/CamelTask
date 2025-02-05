package com.camel.aggregation.aggregation_recepient;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;

public class MyAggregationStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);
        
        String aggregated = oldBody + " | " + newBody;
        oldExchange.getIn().setBody(aggregated);
        
        return oldExchange;
    }
}

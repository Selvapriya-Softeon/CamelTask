package com.camel.aggregation.aggregation_recepient;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String... args) throws Exception {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
        CamelContext camelContext = context.getBean(CamelContext.class);

        camelContext.start();
        
        ProducerTemplate producer = camelContext.createProducerTemplate();
        producer.sendBody("direct:start", "Message 1");
        producer.sendBody("direct:start", "Message 2");

        Thread.sleep(6000);

        camelContext.stop();
        context.close();
    }

}


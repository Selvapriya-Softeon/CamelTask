package NettyTcpClient1;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyMessageProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String message = exchange.getIn().getBody(String.class);
        System.out.println("Received message: " + message);
        exchange.getIn().setBody("Processed " + message);
    }
}

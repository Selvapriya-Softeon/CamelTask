package quartzJob;

import org.apache.camel.CamelContext;
import org.apache.camel.Processor;

public class StopRouteProcessor implements Processor {
    private final CamelContext camelContext;

    public StopRouteProcessor(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @Override
    public void process(org.apache.camel.Exchange exchange) throws Exception {
        camelContext.getRouteController().stopRoute("quartz-job-route");
        System.out.println("Route 'quartz-job-route' stopped successfully.");
    }
}

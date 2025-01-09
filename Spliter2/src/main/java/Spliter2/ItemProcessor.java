package Spliter2;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ItemProcessor implements Processor {
    private final Set<String> uniqueIds = Collections.newSetFromMap(new ConcurrentHashMap<>());

    @Override
    public void process(Exchange exchange) throws Exception {
        Map<String, Object> item = exchange.getIn().getBody(Map.class);

        if (item != null && item.containsKey("workListId")) {
            String workListId = (String) item.get("workListId");
            exchange.getIn().setBody(workListId);
            addUniqueId(workListId);
        } else {
            throw new IllegalArgumentException("workListId not found in item: " + item);
        }
    }

    public void addUniqueId(String id) {
        if (id != null) {
            uniqueIds.add(id);
        }
    }

    public Set<String> getUniqueIds() {
        return uniqueIds;
    }
}

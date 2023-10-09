package inflearn.advanced.app.v5;

import inflearn.advanced.trace.callback.TraceCallback;
import inflearn.advanced.trace.callback.TraceTemplate;
import inflearn.advanced.trace.logtrace.LogTrace;
import inflearn.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
         template.execute("OrderService.orderItem()", () -> {
             orderRepository.save(itemId);
             return null;
         });
    }
}

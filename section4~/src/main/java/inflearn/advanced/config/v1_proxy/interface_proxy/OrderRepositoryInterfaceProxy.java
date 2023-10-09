package inflearn.advanced.config.v1_proxy.interface_proxy;

import inflearn.advanced.app.v1.OrderRepositoryV1;
import inflearn.advanced.app.v1.OrderRepositoryV1Impl;
import inflearn.advanced.trace.TraceStatus;
import inflearn.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;
    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderRepository.save()");
            // target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }
}

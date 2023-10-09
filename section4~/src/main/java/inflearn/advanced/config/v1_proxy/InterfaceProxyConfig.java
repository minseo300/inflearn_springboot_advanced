package inflearn.advanced.config.v1_proxy;

import inflearn.advanced.app.v1.*;
import inflearn.advanced.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import inflearn.advanced.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import inflearn.advanced.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import inflearn.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1 controllerImpl = new OrderControllerV1Impl(orderService(logTrace  ));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1 serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1 repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}

package inflearn.advanced;

import inflearn.advanced.config.AppV1Config;
import inflearn.advanced.config.AppV2Config;
import inflearn.advanced.config.v1_proxy.ConcreteProxyConfig;
import inflearn.advanced.config.v1_proxy.InterfaceProxyConfig;
import inflearn.advanced.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import inflearn.advanced.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import inflearn.advanced.trace.logtrace.LogTrace;
import inflearn.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

// config package 안에 있는 클래스는
// component scan이 되지 않게 하기 위해서 설정 -> scanBasePackages 설정을 통해 app 하위에 있는 클래스들만 component scan 대상이 됨.
// @Configuration 안에 @Component가 있기 때문에 이 어노테이션이 있으면 component scan 대상이 되는데 config 디렉토리의 클래스들은 component scan 대상이 되는 것을 원치 않음.
// Import를 사용해서 해당 클래스만 빈으로 등록됨. Import에 설정된 클래스에 의해 빈들이 수동 등록됨.



//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config .class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
@Import(DynamicProxyFilterConfig.class)

@SpringBootApplication(scanBasePackages = "inflearn.advanced.app")

public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
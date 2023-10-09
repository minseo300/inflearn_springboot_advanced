 package inflearn.advanced;

import inflearn.advanced.trace.logtrace.LogTrace;
import inflearn.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
         return new ThreadLocalLogTrace() ;
    }
}

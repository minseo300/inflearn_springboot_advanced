package inflearn.advanced.trace.strategy;

import inflearn.advanced.trace.strategy.code.strategy.ContextV2;
import inflearn.advanced.trace.strategy.code.strategy.Strategy;
import inflearn.advanced.trace.strategy.code.strategy.StrategyLogic1;
import inflearn.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1() {
        ContextV2 context1 = new ContextV2();
        context1.execute(new StrategyLogic1());
        context1.execute(new StrategyLogic2());

    }
    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context1 = new ContextV2();
        context1.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        context1.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });

    }

    /**
     * 전략 패턴 람다
     */
    @Test
    void strategyV3() {
        ContextV2 context1 = new ContextV2();
        context1.execute(() -> log.info("비즈니스 로직 1 실행"));
        context1.execute(() -> log.info("비즈니스 로직 2 실행"));

    }
}

package inflearn.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0  {
    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("EXCEPTION");
        }
        sleep(1000);

    }

    private void sleep(int millis) {
         try{
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    }
}

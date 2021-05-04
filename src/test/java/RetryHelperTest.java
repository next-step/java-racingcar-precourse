import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RetryHelperTest {
    @Test
    void name() throws Exception {
        RetryableCommand retryableCommand = new RetryableCommand();
        RetryHelper<Boolean, Integer> retryHelper = new RetryHelper<>(retryableCommand);
        assertThrows(Exception.class, () -> {
            retryHelper.executeWithRetry(true);
        });
        assertEquals(retryHelper.executeWithRetry(false), 1);

    }

    static class RetryableCommand implements Retryable<Boolean, Integer> {

        @Override
        public Integer execute(Boolean isError) throws Exception {
            if (isError) throw new Exception();
            return 1;
        }

        @Override
        public void onError(Exception e) {
            e.printStackTrace();
        }
    }
}

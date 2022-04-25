package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mockStatic;

public class Assertions {
    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    public static <T> void assertRandomTest(
            final MockedStatic.Verification verification,
            final Executable executable,
            final Integer value
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(value);
                executable.execute();
            }
        });
    }


    public static <T> void assertRandomTest(
            final MockedStatic.Verification verification,
            final Executable executable,
            final Integer value,
            final Integer[] values
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(value, values);
                executable.execute();
            }
        });
    }
}

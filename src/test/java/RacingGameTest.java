import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    RacingGame racingGame ;
    @BeforeEach
    public void setup(){
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @MethodSource("checkLengthParameters")
    void checkLengthOfNames(String[] names, boolean expected){
        assertEquals(racingGame.checkLengthOfNames(names),expected);
    }
    public static Stream<Arguments> checkLengthParameters(){
        String[] test_names1 = {"John", "Jane", "Google"};
        String[] test_names2 = {"John", "Jane", "Googi"};
        return Stream.of(
                Arguments.of(test_names1, true),
                Arguments.of(test_names2, true));
    }
}
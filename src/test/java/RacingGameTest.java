import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    RacingGame racingGame ;
    @BeforeEach
    public void setup(){
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @MethodSource("splitStringParameters")
    public void splitString(String str, Integer expected) {
        List<RacingCar> res = racingGame.splitString(str);
        assertEquals((res!=null)?res.size():0,expected);
    }
    public static Stream<Arguments> splitStringParameters(){
        String str1 = "John,Jane,Google";
        String str2 = "John,Jane,Googi";
        return Stream.of(
                Arguments.of(str1,0),
                Arguments.of(str2,3));
    }

    @ParameterizedTest
    @MethodSource("checkLengthParameters")
    public void checkLengthOfNames(String[] names, boolean expected){
        assertEquals(racingGame.checkLengthOfNames(names),expected);
    }
    public static Stream<Arguments> checkLengthParameters(){
        String[] test_names1 = {"John", "Jane", "Google"};
        String[] test_names2 = {"John", "Jane", "Googi"};
        return Stream.of(
                Arguments.of(test_names1, false),
                Arguments.of(test_names2, true));
    }
}
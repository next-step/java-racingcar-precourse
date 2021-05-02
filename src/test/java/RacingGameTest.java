import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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
    @MethodSource("getWinnersParameters")
    public void getWinners(List<RacingCar> cars, String expected){
        assertEquals(racingGame.getWinners(cars).toString(),expected);
    }
    public static Stream<Arguments> getWinnersParameters(){
        List<RacingCar> winners1 = new ArrayList<>();
        RacingCar car1 = new RacingCar("TEST1");
        car1.setCount(1);
        winners1.add(car1);

        List<RacingCar> winners2 = new ArrayList<>();
        RacingCar car2 = new RacingCar("TEST2");
        car2.setCount(3);
        RacingCar car3 = new RacingCar("TEST3");
        car3.setCount(2);
        winners2.add(car2);
        winners2.add(car3);

        List<RacingCar> winners3 = new ArrayList<>();
        RacingCar car4 = new RacingCar("TEST4");
        car4.setCount(3);
        RacingCar car5 = new RacingCar("TEST5");
        car5.setCount(4);
        RacingCar car6 = new RacingCar("TEST6");
        car6.setCount(4);
        winners3.add(car4);
        winners3.add(car5);
        winners3.add(car6);
        RacingCar car;
        return Stream.of(
                Arguments.of(winners1,"[이름: TEST1, 전진횟수: 1]"),
                Arguments.of(winners2,"[이름: TEST2, 전진횟수: 3]"),
                Arguments.of(winners3,"[이름: TEST5, 전진횟수: 4, 이름: TEST6, 전진횟수: 4]")
        );
    }

    @ParameterizedTest
    @MethodSource("printResultParameters")
    public void printResult(List<RacingCar> winners, String expected){
        assertEquals(racingGame.printResult(winners),expected);
    }
    public static Stream<Arguments> printResultParameters(){
        List<RacingCar> winners1 = new ArrayList<>();
        winners1.add(new RacingCar("TEST1"));
        List<RacingCar> winners2 = new ArrayList<>();
        winners2.add(new RacingCar("TEST2"));
        winners2.add(new RacingCar("TEST3"));
        List<RacingCar> winners3 = new ArrayList<>();
        winners3.add(new RacingCar("TEST4"));
        winners3.add(new RacingCar("TEST5"));
        winners3.add(new RacingCar("TEST6"));
        RacingCar car;
        return Stream.of(
                Arguments.of(winners1,"TEST1가 최종 우승했습니다."),
                Arguments.of(winners2,"TEST2, TEST3가 최종 우승했습니다."),
                Arguments.of(winners3,"TEST4, TEST5, TEST6가 최종 우승했습니다.")
        );
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
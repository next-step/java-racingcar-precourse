package racingcar.UI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.CarObject;
import racingcar.domain.RacingCarExeception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarUITest {
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    private static List<Arguments> parseNamesTestArguments(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of("James,Tommy,John",
                Arrays.asList("James", "Tommy", "John")));
        arguments.add(Arguments.of("car1,car2,car3,car4,car5",
                Arrays.asList("car1", "car2", "car3", "car4", "car5")));
        return arguments;
    }

    @DisplayName("이름 파싱 테스트")
    @ParameterizedTest
    @MethodSource("parseNamesTestArguments")
    void parseNamesTest(String inputStr, List<String> expected){
        RacingCarUI  racingCarUI = new RacingCarUI();
        assertThat(racingCarUI.parseNames(inputStr)).isEqualTo(expected);
    }

    private static List<Arguments> parseNameExceptionTestArgument(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of("car1", IllegalArgumentException.class, RacingCarExeception.LACK_NUMBER_OF_CARS_ERROR));
        arguments.add(Arguments.of("car1,exceedname", IllegalArgumentException.class, RacingCarExeception.EXCEED_LENGTH_OF_NAME_ERROR));
        return arguments;
    }
    @DisplayName("상황에 따른 이름 파싱 Exception 테스트")
    @ParameterizedTest
    @MethodSource("parseNameExceptionTestArgument")
    void parseNameExceptionTest(String inputStr, Class expectedClass, String expectedMessage){
        RacingCarUI  racingCarUI = new RacingCarUI();
        assertThatThrownBy(()->racingCarUI.parseNames(inputStr))
                .isInstanceOf(expectedClass)
                .hasMessage(expectedMessage);
    }

    private static List<Arguments> parseNumberTestArguments(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of("1",1));
        arguments.add(Arguments.of("12",12));
        arguments.add(Arguments.of("123",123));
        arguments.add(Arguments.of("1234",1234));
        arguments.add(Arguments.of("12345",12345));
        return arguments;
    }
    @DisplayName("숫자 파싱 테스트")
    @ParameterizedTest
    @MethodSource("parseNumberTestArguments")
    void parseNumberTest(String inputStr, Integer expected){
        RacingCarUI  racingCarUI = new RacingCarUI();
        assertThat(racingCarUI.parseNumber(inputStr)).isEqualTo(expected);
    }

    private static List<Arguments> parseNumberExceptionTestArguments(){
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of("wrongInput", IllegalArgumentException.class, RacingCarExeception.INPUT_WRONG_NUMBER_ERROR));
        arguments.add(Arguments.of("0", IllegalArgumentException.class, RacingCarExeception.INPUT_WRONG_RANGE_ERROR));
        arguments.add(Arguments.of("-12", IllegalArgumentException.class, RacingCarExeception.INPUT_WRONG_RANGE_ERROR));
        return arguments;
    }
    @DisplayName("상황에 따른 숫자 파싱 Exception 테스트")
    @ParameterizedTest
    @MethodSource("parseNumberExceptionTestArguments")
    void parseNumberExceptionTest(String inputStr, Class expectedClass, String expectedMessage){
        RacingCarUI  racingCarUI = new RacingCarUI();
        assertThatThrownBy(()->racingCarUI.parseNumber(inputStr))
                .isInstanceOf(expectedClass)
                .hasMessage(expectedMessage);
    }

    private static List<Arguments> printCurrentRoundTestArguments(){
        List<Arguments> result = new ArrayList<>();
        List<CarObject> carObjectList1 = new ArrayList<>();
        CarObject car1 = new CarObject("test1");
        car1.setForwardCount(1);
        carObjectList1.add(car1);
        CarObject car2 = new CarObject("test2");
        car2.setForwardCount(2);
        carObjectList1.add(car2);
        CarObject car3 = new CarObject("test3");
        car3.setForwardCount(3);
        carObjectList1.add(car3);
        result.add(Arguments.of(carObjectList1,
                "test1 : -\r\n"
                        + "test2 : --\r\n"
                        + "test3 : ---\r\n\r\n"));

        return result;
    }

    @DisplayName("현재 라운드 결과 출력 테스트")
    @ParameterizedTest
    @MethodSource("printCurrentRoundTestArguments")
    void printCurrentRoundTest(List<CarObject> inputList, String expected){
        RacingCarUI  racingCarUI = new RacingCarUI();
        racingCarUI.printCurrentRound(inputList);
        assertThat(outContent.toString()).isEqualTo(expected);
    }
}

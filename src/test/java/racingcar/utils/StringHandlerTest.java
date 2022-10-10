package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringHandlerTest{

    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;

    @BeforeEach
    void initTest() {
        car1 = new Car(1, "BOMI");
        car2 = new Car(3, "SUBINI");
        car3 = new Car(2, "DARAMI");
        car4 = new Car(3, "SUJINI");
    }

    public static NamesInput INPUT_STRING_TRUE_CASE = null;

    @BeforeEach
    void setUp() {
        INPUT_STRING_TRUE_CASE = new NamesInput("pobi,crong,honux");
    }

    @DisplayName("입력된 String값으로 이름들을 받는 기능 테스트")
    @Test
    void getNamesFromUserInputTest() {
        assertThat(Arrays.equals(INPUT_STRING_TRUE_CASE.getNames(), new String[]{"pobi", "crong", "honux"})).isTrue();
//        assertThatThrownBy(() -> inputStringFalseCase.getNames())
//                .isInstanceOf(IllegalArgumentException.class);
//        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> { throw new IOException("이름 구분을 쉼표(,)로 입력해주세요"); })
//                .withMessage("이름 구분을 쉼표(,)로 입력해주세요"); ;
    }

    @DisplayName("입력된 String값으로 이름들을 받는 기능 Exception 테스트")
    @Test
    void getNamesFromUserInputExceptionTest() {
        assertThrows(NoSuchElementException.class, () -> new NamesInput(""));
    }
    @DisplayName("입력된 이름이 하나일때 (COMMA가 없는) 하나로만 계속할것인지 확인하는 테스트")
    @Test
    void isGameProceedWithOneCarTest() {
        assertThrows(NoSuchElementException.class, () -> new IsGameProceedWithOneCar("4"));
    }

    @DisplayName("입력된 String 값으로 자동차 객체를 생성하는 테스트")
    @Test
    void createCarsByUserInputTest() {
        ArrayList<Car> cars = INPUT_STRING_TRUE_CASE.constructCars();

        assertThat(Arrays.equals(new String[]{cars.get(0).getName(), cars.get(1).getName(), cars.get(2).getName()}, new String[]{"pobi", "crong", "honux"})).isTrue();

    }

    @DisplayName("공동 우승자가 있을 때 이름들 사이에 ,를 삽입하는 기능")
    @Test
    void insertCommaBetweenWinnersNameTest() {
        Game game = new Game();
        StringHandler stringHandler = new StringHandler();
        ArrayList<Car> winnerCars = game.pickWinnerCars(Arrays.asList(car1, car2, car3, car4));
        assertThat(stringHandler.insertCommaBetweenWinnersName(winnerCars).equals("SUBINI, SUJINI")).isTrue();

    }
    @DisplayName("우승자가 한 명 있을 때 이름들 사이에 ,를 삽입하는 기능이 동작하지 않고 넘어가는지 확인하는 테스트")
    @Test
    void insertCommaBetweenWinnerNameTest() {
        Game game = new Game();
        StringHandler stringHandler = new StringHandler();
        ArrayList<Car> winnerCars = game.pickWinnerCars(Arrays.asList(car1, car2, car3));
        assertThat(stringHandler.insertCommaBetweenWinnersName(winnerCars).equals("SUBINI")).isTrue();

    }
}
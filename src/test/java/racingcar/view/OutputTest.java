package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarEngine;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class OutputTest {

    private Output output;

    @BeforeEach
    void setUp() {
        output = Output.getInstance();
    }

    @Test
    @DisplayName("output 싱글톤 생성 테스트")
    void outputTest() {
        Output outputSecond = Output.getInstance();
        assertThat(output).isEqualTo(outputSecond);
    }

    @Test
    @DisplayName("자동차 이름 request 출력 테스트")
    void printCarNameRequestTest() {
        output.printCarNameRequest();
    }

    @Test
    @DisplayName("시도 횟수 request 출력 테스트")
    void printRoundRequestTest() {
        output.printRoundRequest();
    }

    @Test
    @DisplayName("중간결과 시작 출력 테스트")
    void printProcessStartTest() {
        output.printProcessStart();
    }

    @Test
    @DisplayName("자동차 경주 실행 결과 출력 테스트")
    void printProcessTest() {
        Car javaCar = Car.create("java");
        Car poniCar = Car.create("poni");
        output.printProcess(Arrays.asList(javaCar,poniCar));
        javaCar.move(CarEngine.charge(CarEngine.MINIMUM_MOVE_ENERGY));
        output.printProcess(Arrays.asList(javaCar,poniCar));
    }

    @Test
    void printResultTest() {
        output.printResult(Arrays.asList("java","poni"));
    }
}
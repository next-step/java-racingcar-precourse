package racingcar.judge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.attendgroup.AttendGroup;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class JudgeTest {
    @ParameterizedTest
    @DisplayName("심판 참가자동차리스트 생성 테스트")
    @ValueSource(strings = {"car1", "car1,car2,car3", "car1,car2,car3,car4"})
    void 심판_참가자동차리스트_생성_테스트(String input) {
        List<Car> cars = new ArrayList<>();
        String[] inputList = input.split(",");
        for (String name : inputList) {
            cars.add(new Car(name));
        }
        Judge judge = new Judge(new AttendGroup(cars));
        assertThat(judge.getAttendGroup().getAttendCarList().size()).isNotEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("심판 경주 1회 시작")
    @ValueSource(strings = {"car1", "car2"})
    void 심판_1회_경주_시작(String input) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(input));
        Judge judge = new Judge(new AttendGroup(cars));
        assertThat(judge.playRace()).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("심판 경주 집계 생성 테스트")
    @ValueSource(strings = {"car1,car2,car3"})
    void 심판_경주_집계_생성_정상_테스트(String input) {
        List<Car> cars = new ArrayList<>();
        String[] inputList = input.split(",");
        for (String name : inputList) {
            cars.add(new Car(name));
        }
        Judge judge = new Judge(new AttendGroup(cars));
        judge.playRace();
        System.out.println(judge.getRaceResult());
        assertThat(judge.getRaceResult().split("\n").length).isEqualTo(inputList.length);
    }

    @ParameterizedTest
    @DisplayName("심판 최종 우승자 판별")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 심판_최종_우승자_판별_테스트(int input) {
        List<Car> cars = new ArrayList<>();
        String[] inputList = "car1,car2,car3".split(",");
        for (String name : inputList) {
            cars.add(new Car(name));
        }
        Judge judge = new Judge(new AttendGroup(cars));
        while (input-- > 0) {
            judge.playRace();
        }
        System.out.println(judge.getRaceWinner());
        assertThat(judge.getRaceWinner().split(",")).containsAnyOf(inputList);
    }
}

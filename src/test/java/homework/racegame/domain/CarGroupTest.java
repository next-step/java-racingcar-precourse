package homework.racegame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {

    private String[] carNames;

    private List<Car> carList;

    @BeforeEach
    public void beforeEach() {
        carNames = new String[5];
        carNames[0] = "hello";
        carNames[1] = "java";
        carNames[2] = "car";
        carNames[3] = "racing";
        carNames[4] = "world";
        carList = new ArrayList<>();
        carList.add(new Car(carNames[0], new StringBuffer("---")));
        carList.add(new Car(carNames[1], new StringBuffer("----")));
        carList.add(new Car(carNames[2], new StringBuffer("--")));
        carList.add(new Car(carNames[3], new StringBuffer("----")));
        carList.add(new Car(carNames[4], new StringBuffer("-")));
    }

    @Test
    @DisplayName("moveOrStop 메소드 테스트")
    public void moveOrStopCarsTest() {
        int n = 5;
        CarGroup carGroup = new CarGroup(carNames);
        for (int index = 0; index < n; index++) {
            System.out.println(index + " times");
            carGroup.moveOrStopCars();
            carGroup.printCarsProgress();
        }
        System.out.println(carGroup);
    }

    @Test
    @DisplayName("최장 거리 이동 구하는 메소드 테스트")
    public void getMaximumMoveProgressValueInGroupTest() {
        CarGroup carGroup = new CarGroup(carList);
        assertThat(carGroup.getMaximumMoveProgressValueInGroup()).isEqualTo(4);
    }

    @Test
    @DisplayName("Predicate 함수형 인터페이스에 대해 정상 동작하는지 확인하는 테스트")
    public void setCarIntoListCheckWithPredicateTest() {
        CarGroup carGroup = new CarGroup(carList);
        List<Car> result = new ArrayList<>();
        Predicate<Car> predicate = car -> car.getMoveProgressValue() >= 3;
        int size = carList.size();
        for (int index = 0; index < size; index++) {
            carGroup.setCarIntoListCheckWithPredicate(carList.get(index), result, predicate);
        }
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("승리한 차량을 반환하는 메소드 테스트")
    public void getWinnersTest() {
        CarGroup carGroup = new CarGroup(carList);
        List<Car> result = carGroup.getWinners();
        assertThat(result.size()).isEqualTo(2);
    }
}

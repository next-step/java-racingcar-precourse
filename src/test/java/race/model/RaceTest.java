package race.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Test
    @DisplayName("자동차의 Position이 정상적으로 앞으로 이동하는지 테스트")
    public void test_proceedStep() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.add(new Car("ccc"));

        // 항상 전진하도록 설정해준다
        CustomRandom customRandom = new CustomRandom() {
            @Override
            public int nextInt(int bound) {
                return 6;
            }
        };

        // when
        Race race = new Race(carList, customRandom);
        race.proceedStep();

        // then
        assertThat(carList)
                .allMatch(car -> car.getPosition() == 1);
    }

    @Test
    @DisplayName("우승자 한 명이 정상적으로 반환되는 지 테스트")
    void test_oneWinnerList() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.add(new Car("ccc"));

        // 1번 자동차를 1등으로 만들어준다
        carList.get(0).moveForward();

        CustomRandom customRandom = new CustomRandom();

        // when, then
        Race race = new Race(carList, customRandom);

        // then
        assertThat(race.getWinnerList())
                .extracting(Car::getCarName)
                .containsExactly("aaa");
    }

    @Test
    @DisplayName("우승자 여러 명이 정상적으로 반환되는 지 테스트")
    void test_manyWinnerList() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("aaa"));
        carList.add(new Car("bbb"));
        carList.add(new Car("ccc"));

        // 1번 자동차를 1등으로 만들어준다
        carList.get(0).moveForward();
        carList.get(1).moveForward();

        CustomRandom customRandom = new CustomRandom();

        // when, then
        Race race = new Race(carList, customRandom);

        // then
        assertThat(race.getWinnerList())
                .extracting(Car::getCarName)
                .containsExactlyInAnyOrder("aaa", "bbb");
    }
}
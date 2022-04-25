package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestUtil.makeRacingCarArrayListWithFixedDistance;
import static racingcar.TestUtil.makeRacingCarArrayListWithRandomValue;
import static racingcar.TestUtil.parseCarName;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarEntriesTest {

    @Test
    @DisplayName("경주 자동차 3대 추가를 검사한다")
    void addTripleRacingCars() {
        RacingCarEntries entries = new RacingCarEntries();

        entries.addNewRacingCar(new CarName("a_car"));
        entries.addNewRacingCar(new CarName("b_car"));
        entries.addNewRacingCar(new CarName("c_car"));

        for (int i = 0; i < 3; ++i) {
            CarName name = entries.get(i).getCarName();
            assertThat(new String[]{"a_car", "b_car", "c_car"}).contains(name.toString());
        }
    }

    @Test
    @DisplayName("랜덤값 4를 가진 자동차 3대가 모두 이동하는지 검사한다")
    void moveEveryRacingCarsWithRandomNumber4() {
        String[] sample_data = {"a_car:4", "b_car:4", "c_car:4"};
        int ONE_STEP_DISTANCE = 1;
        RacingCarEntries test_entries = makeRacingCarArrayListWithRandomValue(sample_data);

        test_entries.takeALap();

        for (RacingCar car : test_entries) {
            Distance dist = car.getDistance();
            assertThat(dist.getNumericDistance()).isEqualTo(ONE_STEP_DISTANCE);
        }
    }

    @Test
    @DisplayName("랜덤값 3을 가진 자동차 3대가 모두 정지했는지 검사한다")
    void stoppedEveryRacingCarsWithRandomNumber3() {
        String[] sample_data = {"a_car:3", "b_car:3", "c_car:3"};
        int ZERO_DISTANCE = 0;
        RacingCarEntries test_entries = makeRacingCarArrayListWithRandomValue(sample_data);

        test_entries.takeALap();

        for (RacingCar car : test_entries) {
            Distance dist = car.getDistance();
            assertThat(dist.getNumericDistance()).isEqualTo(ZERO_DISTANCE);
        }
    }


    @Test
    @DisplayName("3,4,5 이동한 자동차를 멀리 이동한 순으로 정렬되는지 검사한다")
    void sorRacingCarEntriesIntoDescendingOrder() {
        String[] sample_data = {"a_car:4", "b_car:3", "c_car:5"};
        RacingCarEntries entries = makeRacingCarArrayListWithFixedDistance(sample_data);

        entries.sortReverse();

        CarName first = entries.get(0).getCarName();
        CarName second = entries.get(1).getCarName();
        CarName third = entries.get(2).getCarName();

        assertThat(first.toString()).isEqualTo("c_car");
        assertThat(second.toString()).isEqualTo("a_car");
        assertThat(third.toString()).isEqualTo("b_car");
    }

    @Test
    @DisplayName("3,5,5 이동한 자동차를 멀리 이동한 순으로 정렬되는지 검사한다")
    void sortRacingCarEntriesWithSameDistanceIntoDescendingOrder() {
        String[] sample_data = {"a_car:3", "b_car:5", "c_car:5"};
        RacingCarEntries entries = makeRacingCarArrayListWithFixedDistance(sample_data);

        entries.sortReverse();

        CarName first = entries.get(0).getCarName();
        CarName second = entries.get(1).getCarName();
        CarName third = entries.get(2).getCarName();

        assertThat(new String[] {"b_car", "c_car"}).contains(first.toString());
        assertThat(new String[] {"b_car", "c_car"}).contains(second.toString());
        assertThat(third.toString()).isEqualTo("a_car");
    }

    @Test
    @DisplayName("3,4,5 이동한 자동차 목록에서 우승자를 검사한다")
    void getWinnerNameInSoloWinner() {
        String[] sample_data = {"a_car:3", "b_car:4", "c_car:5"};
        RacingCarEntries entries = makeRacingCarArrayListWithFixedDistance(sample_data);

        CommaSeparatedCarNames winner_names = entries.getWinnerNames();

        assertThat(winner_names.toString()).isEqualTo("c_car");
    }

    @Test
    @DisplayName("3,5,5 이동한 자동차 목록에서 공동 우승자를 검사한다")
    void getWinnerNamesInJointWinners() {
        String[] sample_data = {"a_car:5", "b_car:4", "c_car:5"};
        RacingCarEntries entries = makeRacingCarArrayListWithFixedDistance(sample_data);

        CommaSeparatedCarNames winner_names = entries.getWinnerNames();

        assertThat(winner_names.toString()).isEqualTo("a_car,c_car");
    }

    @Test
    @DisplayName("5,5,5 이동한 자동차 목록에서 공동 우승자를 검사한다")
    void getWinnerNamesInAllWinners() {
        String[] sample_data = {"a_car:5", "b_car:5", "c_car:5"};
        RacingCarEntries entries = makeRacingCarArrayListWithFixedDistance(sample_data);

        CommaSeparatedCarNames winner_names = entries.getWinnerNames();

        assertThat(winner_names.toString()).isEqualTo("a_car,b_car,c_car");
    }
}

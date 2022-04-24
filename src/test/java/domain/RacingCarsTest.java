package domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static view.MessageConstant.*;

class RacingCarsTest {

    @ParameterizedTest
    @CsvSource({"'pobi'", "'pobi,woni'", "'pobi,woni,jun'", "'pobi,woni,jun,toby'", "'pobi,woni,jun,toby,jack'"})
    @DisplayName("경주용_자동차_리스트_요소_사이즈_테스트")
    public void 경주용_자동차_리스트_요소_사이즈_테스트(String names) {
        assertDoesNotThrow(() -> {
            new RacingCars(RacingCars.makeCarListFromNames(names));
        });
    }

    @Test
    @DisplayName("경주용_자동차_리스트_요소_이름_길이_테스트")
    public void 경주용_자동차_리스트_요소_이름_길이_테스트() {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars(RacingCars.makeCarListFromNames(""));
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo(EXCEED_CAR_NAME_ERROR);
    }

    @ParameterizedTest
    @CsvSource({"'pobi,woni,jun,toby,jack'"})
    @DisplayName("경주용_자동차_리스트_생성_사이즈_검증_예외")
    public void 경주용_자동차_리스트_추가_불가_검증(String names) {
        assertThrows(UnsupportedOperationException.class, () -> {
            RacingCars rcList = new RacingCars(RacingCars.makeCarListFromNames(names));
            List<Car> returnedList = rcList.getCars();
            returnedList.add(new Car("new"));
        });
    }

    @Test
    @DisplayName("중복_요소_존재_테스트")
    public void 중복_요소_존재_테스트() {
        List<Car> carList = RacingCars.makeCarListFromNames("pobi,woni,jun,toby");
        assertThat(RacingCars.validateDuplicateCar(carList)).isEqualTo(true);

        carList = RacingCars.makeCarListFromNames("pobi,pobi,jun,toby");
        assertThat(RacingCars.validateDuplicateCar(carList)).isEqualTo(false);
    }

    @Test
    @DisplayName("중복_요소_존재_예외_테스트")
    public void 중복_요소_존재_예외_테스트() {
        Throwable exceptionThrown = assertThrows(IllegalStateException.class, () -> {
            new RacingCars(RacingCars.makeCarListFromNames("pobi,pobi,jun,toby"));
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo(DUPLICATE_CAR_NAME_ERROR);
    }

    @Test
    public void 이름으로_자동차_찾기_테스트() {
        assertDoesNotThrow(() -> {
            List<Car> list = RacingCars.makeCarListFromNames("pobi,woni,jun,toby");
            RacingCars cars = new RacingCars(list);
            Car find = cars.find("jun");
            assertThat(find.getCarName()).isEqualTo("jun");
        });
    }

    @Test
    public void 이름으로_자동차_찾기_테스트_예외() {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            List<Car> list = RacingCars.makeCarListFromNames("pobi,woni,jun,toby");
            RacingCars cars = new RacingCars(list);
            cars.find("juny");
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo(NOT_EXIST_CAR_NAME_ERROR);
    }

    @Test
    @DisplayName("주행_테스트")
    public void 주행_테스트() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 0, 5, 1, 6, 2, 7, 3);
            RacingCars racingCars = new RacingCars(RacingCars.makeCarListFromNames("tom,jack"));

            racingCars.drive();
            assertThat(racingCars.find("tom").getPosition()).isEqualTo(1);
            assertThat(racingCars.find("jack").getPosition()).isEqualTo(0);

            racingCars.drive();
            assertThat(racingCars.find("tom").getPosition()).isEqualTo(2);
            assertThat(racingCars.find("jack").getPosition()).isEqualTo(0);

            racingCars.drive();
            assertThat(racingCars.find("tom").getPosition()).isEqualTo(3);
            assertThat(racingCars.find("jack").getPosition()).isEqualTo(0);

            racingCars.drive();
            assertThat(racingCars.find("tom").getPosition()).isEqualTo(4);
            assertThat(racingCars.find("jack").getPosition()).isEqualTo(0);
        }
    }

}
package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.domain.Car;
import racingcar.domain.RaceCars;
import racingcar.view.BillBoard;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RaceTest {

    @Mock
    private BillBoard billBoard;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Race가 시작되고, 5번의 출력이 실행되어야 함")
    void test1() {
        RaceCars cars = RaceCars.of(Arrays.asList(
                Car.of(UserString.of("car1")),
                Car.of(UserString.of("car2"))
        ));
        Race race = new Race(billBoard, cars, NaturalNumber.of(5));
        race.run();

        verify(billBoard, times(5)).showRace(any());
    }
}
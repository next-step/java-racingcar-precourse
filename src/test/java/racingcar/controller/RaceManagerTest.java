package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.domain.RaceCars;
import racingcar.view.BillBoard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class RaceManagerTest {

    @Mock
    private UserInput userRequest;

    @Mock
    private BillBoard billBoard;

    @InjectMocks
    private RaceManager raceManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("사용자는 레이스 횟수를 입력할 수 있음")
    void test2() {
        given(userRequest.getRaceCount()).willReturn(UserString.of("1"));

        NaturalNumber raceCount = raceManager.getRaceCount();

        assertTrue(raceCount.isSame(NaturalNumber.of(1)));
    }

    @Test
    @DisplayName("사용자는 자동차의 목록을 전달할 수 있음.")
    void test1() {
        given(userRequest.getCarNames()).willReturn(UserString.of("car1,car2"));

        RaceCars cars = raceManager.readyCars();

        assertThat(cars.getCarCount().isSame(NaturalNumber.of(2))).isTrue();
    }
}
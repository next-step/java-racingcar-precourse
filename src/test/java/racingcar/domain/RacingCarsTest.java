package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.constant.AccelRange;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class RacingCarsTest {

    private RaceCars racingCars;

    @BeforeEach
    void setUp() {
        RaceGarage garage = new RaceGarage();
        racingCars = garage.createCars(UserString.of("car1,car2,car3"));
    }

    @Test
    @DisplayName("3개의 결과가 반환됨")
    void test1() {
        try (MockedStatic<Randoms> random = mockStatic(Randoms.class)) {
            given(Randoms.pickNumberInRange(AccelRange.MIN_ACCEL_VALUE, AccelRange.MAX_ACCEL_VALUE)).willReturn(5);
            racingCars.raceOneTime();
        }

        RaceResult records = racingCars.getDriveRecords();

        assertThat(records.getRecordSize().isSame(new NaturalNumber(3))).isTrue();
    }
}
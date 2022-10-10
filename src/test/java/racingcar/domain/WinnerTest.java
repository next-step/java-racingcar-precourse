package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingService;

class WinnerTest {
    RacingService racingService = null;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
        racingService.init("a,b,c");
        for (int i = 0; i < 6; i++) {
            racingService.round();
        }
    }

    @Test
    void Position이_가장_높은_값() {
        // given
        Winner winner = new Winner();
        Car d = new Car("d");
        d.setPosition(7);
        racingService.getRacingCars().getCarList().add(d);
        // then
        winner.getWinnerCars(racingService.getRacingCars().getCarList());
        // then
        assertEquals(winner.maxPosition,7);
    }
    @Test
    void Position이_가장_높은_자동차() {
        // given
        Winner winner = new Winner();
        Car d = new Car("d");
        Car e = new Car("e");
        d.setPosition(7);
        e.setPosition(7);
        racingService.getRacingCars().getCarList().add(d);
        racingService.getRacingCars().getCarList().add(e);
        // when
        winner.getWinnerCars(racingService.getRacingCars().getCarList());
        // then
        assertEquals(winner.getWinnerCars().get(0),"d");
        assertEquals(winner.getWinnerCars().get(1),"e");
    }




}
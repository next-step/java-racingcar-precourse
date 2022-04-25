package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private final String DISTANCE_ZERO = "";
    private final String DISTANCE_ONE = "-";
    private final String DISTANCE_TWO = "--";

    Car sut;

    @BeforeEach
    void setUp() {
        sut = Car.withName("SOME_NAME");
    }

    @Test
    void 숫자_4이상을_받으면_전진한다() {

        assertThat(sut.getMovedDistance()).isEqualTo(DISTANCE_ZERO);

        sut.moveByNumber(4);
        assertThat(sut.getMovedDistance()).isEqualTo(DISTANCE_ONE);

        sut.moveByNumber(9);
        assertThat(sut.getMovedDistance()).isEqualTo(DISTANCE_TWO);
    }

    @Test
    void 숫자_3이하를_받으면_멈춘다() {

        assertThat(sut.getMovedDistance()).isEqualTo(DISTANCE_ZERO);

        sut.moveByNumber(0);
        sut.moveByNumber(3);

        assertThat(sut.getMovedDistance()).isEqualTo(DISTANCE_ZERO);
    }
}
package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car pony;
    private Car benz;

    @BeforeEach
    void setup() {
        pony = new Car("pony");
        benz = new Car("benz");
    }

    @Test
    void 포니가_벤츠를_추월() {

        pony.drive(DriveStatus.DRIVE);
        pony.drive(DriveStatus.DRIVE);
        benz.drive(DriveStatus.DRIVE);

        Assertions.assertThat(pony.compete(benz)).isEqualTo(RaceStatus.WINNE);
    }

    @Test
    void 포니가_벤츠에게_패배() {

        pony.drive(DriveStatus.DRIVE);
        pony.drive(DriveStatus.STOP);
        benz.drive(DriveStatus.DRIVE);
        benz.drive(DriveStatus.DRIVE);

        Assertions.assertThat(pony.compete(benz)).isEqualTo(RaceStatus.LOSE);
    }

}
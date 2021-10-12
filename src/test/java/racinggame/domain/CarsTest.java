package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 최고_기록이_맞는지_확인() {
        Car entryCar1 = new Car("entryCar1", 2);
        Car entryCar2 = new Car("entryCar2", 2);
        Car entryCar3 = new Car("entryCar3", 3);
        Cars actual = new Cars(Arrays.asList(entryCar1, entryCar2, entryCar3));

        Location expectedLocation = new Location(3);

        assertThat(actual.inFormFirstRecord()).isEqualTo(expectedLocation);
    }

    @Test
    void 한명의_우승자가_맞는지_확인() {
        Car entryCar1 = new Car("entryCar1", 2);
        Car entryCar2 = new Car("entryCar2", 2);
        Car entryCar3 = new Car("entryCar3", 3);
        Cars cars = new Cars(Arrays.asList(entryCar1, entryCar2, entryCar3));
        Location expectedLocation = new Location(3);

        Location actualLocation = cars.inFormFirstRecord();
        Names actualNames = cars.inFormWinners(cars.inFormFirstRecord());

        assertThat(actualLocation).isEqualTo(expectedLocation);
        assertThat(actualNames.printNames()).isEqualTo("entryCar3");
    }

    @Test
    void 두명의_우승자가_맞는지_확인() {
        Car entryCar1 = new Car("entryCar1", 2);
        Car entryCar2 = new Car("entryCar2", 2);
        Car entryCar3 = new Car("entryCar3", 1);
        Cars cars = new Cars(Arrays.asList(entryCar1, entryCar2, entryCar3));
        Location expectedLocation = new Location(2);

        Location actualLocation = cars.inFormFirstRecord();
        Names actualNames = cars.inFormWinners(cars.inFormFirstRecord());

        assertThat(actualLocation).isEqualTo(expectedLocation);
        assertThat(actualNames.printNames()).isEqualTo("entryCar1,entryCar2");
    }
}

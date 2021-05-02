package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    void start_shouldRunEachCar() {
        CarSpy spy = new CarSpy();
        CarSet carset = new CarSet(spy);
        Round round = new Round(3);
        Race race = new Race(carset, round);

        race.start();

        assertThat(spy.count).isEqualTo(3);
    }

    @Test
    void start_shouldRunEnergyGeneratorForEachCar() {
        CarSet carset = new CarSet(new Car("dummy"));
        Round round = new Round(3);
        EnergyGeneratorSpy spy = new EnergyGeneratorSpy();
        Race race = new Race(carset, round, spy);

        race.start();

        assertThat(spy.count).isEqualTo(3);
    }


}

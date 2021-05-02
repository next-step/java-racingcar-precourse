package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputProviderTest {

    @Test
    void parse_shouldReturnRoundResult() {
        CarSet carset = new CarSet(new Car("abc"), new Car("def"));
        EnergyGenerator generator = new EnergyGeneratorStub(4, 3);

        roundStep(carset, generator);
        Output output = new OutputProvider().parseCarSet(carset);

        assertThat(output).isEqualTo(new Output("abc:-\ndef:\n"));
    }

    @Test
    void parse_shouldReturnMultipleRoundResult() {
        CarSet carset = new CarSet(new Car("win1"), new Car("win2"), new Car("loose"));
        EnergyGenerator generator = new EnergyGeneratorStub(4, 4, 3);

        for (int i = 0; i < 3; i++) {
            roundStep(carset, generator);
        }
        Output output = new OutputProvider().parseCarSet(carset);

        assertThat(output).isEqualTo(new Output("win1:---\nwin2:---\nloose:\n"));
    }

    private void roundStep(CarSet carset, EnergyGenerator generator) {
        for (Car car : carset) {
            car.injectEnergy(generator.generate());
        }
    }
}

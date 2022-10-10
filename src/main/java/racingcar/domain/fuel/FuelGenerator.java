package racingcar.domain.fuel;

public class FuelGenerator {
    private final FuelGenerateStrategy strategy;

    public FuelGenerator(FuelGenerateStrategy strategy) {
        this.strategy = strategy;
    }

    public int generate() {
        return this.strategy.generate();
    }
}

package racingcar.generator.random.service.dto;

import racingcar.generator.random.domain.models.RandomNumberGenerator;

public class RandomNumberGenerateResult {

    private final int generated;

    private RandomNumberGenerateResult(int generated) {
        this.generated = generated;
    }

    public static RandomNumberGenerateResult from(RandomNumberGenerator randomNumberGenerator) {
        return new RandomNumberGenerateResult(randomNumberGenerator.getGenerated());
    }

    public int getGenerated() {
        return generated;
    }
}

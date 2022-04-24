package racingcar.generator.random.service;

import racingcar.generator.random.domain.models.RandomNumberGenerator;
import racingcar.generator.random.service.dto.RandomNumberGenerateCommand;
import racingcar.generator.random.service.dto.RandomNumberGenerateResult;

public class RandomNumberGenerateService {

    public RandomNumberGenerateResult generateNumberInRangeInclusively(RandomNumberGenerateCommand command) {
        return RandomNumberGenerateResult.from(
                RandomNumberGenerator.generateNumberInRangeInclusively(
                        command.getStartInclusive(), command.getEndInclusive()));
    }
}

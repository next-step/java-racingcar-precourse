package racingcar.car.external;

import racingcar.car.domain.external.CarMovePolicyStrategy;
import racingcar.car.domain.models.CarMovePolicy;
import racingcar.generator.random.service.RandomNumberGenerateService;
import racingcar.generator.random.service.dto.RandomNumberGenerateCommand;
import racingcar.generator.random.service.dto.RandomNumberGenerateResult;

/**
 * 1에서 9 사이의 랜덤숫자를 생성한 뒤, 그 숫자가 4 이상인 경우 움직이는 전략을 구현
 */
public class RandomCarMovePolicyStrategyImpl implements CarMovePolicyStrategy {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVE_BOUNDARY = 4;

    @Override
    public CarMovePolicy getCarMovePolicy() {
        RandomNumberGenerateService randomNumberGenerateService = new RandomNumberGenerateService();
        RandomNumberGenerateResult result = randomNumberGenerateService.generateNumberInRangeInclusively(
                new RandomNumberGenerateCommand(START_INCLUSIVE, END_INCLUSIVE));

        if (result.getGenerated() < MOVE_BOUNDARY) {
            return CarMovePolicy.STOP;
        }

        return CarMovePolicy.MOVE;
    }
}

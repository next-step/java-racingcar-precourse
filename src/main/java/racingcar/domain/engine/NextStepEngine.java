package racingcar.domain.engine;

import racingcar.config.Config;
import racingcar.config.Message;
import racingcar.generator.FuelGenerator;

public class NextStepEngine extends Engine{

    public NextStepEngine(FuelGenerator fuelGenerator){
        this.fuelGenerator = fuelGenerator;
    }

    public boolean gearShift(int value){
        if(value > Config.MAX_FUAL_VALUE || value < Config.MIN_INPUT_VALUE){
            throw new IllegalArgumentException(Message.ERROR_INVALID_RANGE);
        }
        return value >= Config.MOVE_FORWARD_FUAL_VALUE;
    }
}

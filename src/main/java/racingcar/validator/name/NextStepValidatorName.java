package racingcar.validator.name;

import racingcar.config.Config;
import racingcar.config.Message;

public class NextStepValidatorName implements ValidatorName{

    @Override
    public void validateCarsName(String carsStr) throws IllegalArgumentException{
        if(carsStr.length() > Config.MAX_NAME_LENGTH){
            throw new IllegalArgumentException(Message.ERROR_NAME_LENGTH_WRONG);
        }
    }
}

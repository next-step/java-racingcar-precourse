 package racingcar.generator;

import racingcar.config.Config;

public class NextStepFuelGenerator extends RangeFuelGenerator {

     @Override
     public int generateFuel() {
         return super.generateFuel(Config.MIN_INPUT_VALUE, Config.MAX_INPUT_VALUE);
     }
}

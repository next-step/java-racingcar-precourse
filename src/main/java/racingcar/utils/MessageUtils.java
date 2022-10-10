package racingcar.utils;

import racingcar.model.RacingCar;

public final class MessageUtils {

    public static String replcaePositionToSpecialCharacter(RacingCar racingCar, String specialCharacter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < racingCar.getPosition(); i++) {
            stringBuilder.append(specialCharacter);
        }
        return stringBuilder.toString();
    }
}

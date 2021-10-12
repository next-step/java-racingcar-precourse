package racinggame.game.model.message;

import racinggame.game.model.car.CarName;

import java.util.List;

public class RaceWinnerMessage {
    private final String message;

    public RaceWinnerMessage(List<CarName> carNames) {
        StringBuilder stringBuilder = new StringBuilder("최종 우승자는 ");
        for (CarName carName : carNames) {
            stringBuilder.append(carName.getCarName()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() -1);
        stringBuilder.append(" 입니다.");
        this.message = stringBuilder.toString();
    }

    public String getMessage() {
        return message;
    }
}

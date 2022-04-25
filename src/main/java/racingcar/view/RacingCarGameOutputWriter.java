package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class RacingCarGameOutputWriter {

    public void answer(String message) {
        System.out.println(message);
    }

    public void answerRacingCarGameResult(RacingCars racingCars) {
        StringBuilder stringBuilder = new StringBuilder();
        int winnerNumber = racingCars.getRacingCars().size();

        stringBuilder.append("최종 우승자: ");
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            stringBuilder.append(racingCar.getName() + ", ");
        }

        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
    }
}

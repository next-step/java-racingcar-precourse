package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RacingStarter {
    public static void main(String[] args) {
        RacingCars racingCars;
        RacingInputView racingInputView = new RacingInputView();
        RacingResultView racingResultView = new RacingResultView();


        racingInputView.getRacingInfo();

        String[] cars = racingInputView.getCars();
        int count = racingInputView.getEventCount();

        racingCars = new RacingCars(cars);

        racingCars.startRacing(count);
        Map<Car, List<Integer>> history = racingCars.getRacingHistory();

        int index = 0;

        for(int i=0; i< racingInputView.getEventCount(); i ++){
            for (Car car : history.keySet()){
                racingResultView.getPosition(car, history.get(car).get(i));
            }
        }


        List<String> winnerList = racingCars.getWinnerNames(history);
        racingResultView.getIntro();
        racingResultView.getWinner(winnerList);


    }
}

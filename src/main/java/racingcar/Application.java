package racingcar;

import exception.ExceptionWrapper;
import model.Car;
import service.CarRacingCompetition;
import view.CarRacingView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarRacingCompetition carRacingCompetition = getCarRacingCompetion();
        CarRacingView.showResult(startCarRacsingCompetion(carRacingCompetition));
        CarRacingView.showWinner(carRacingCompetition.getWinnerList());
    }

    public static CarRacingCompetition getCarRacingCompetion() {
        String strJoinCarList = null;
        while (true) {
            try {
                strJoinCarList = CarRacingView.readJoinCarList();
                return CarRacingCompetition.getCarRacingCompetion(strJoinCarList);
            } catch (IllegalArgumentException e) {
                ExceptionWrapper.getWrapMessage(e);
            }
        }
    }

    public static List<Car> startCarRacsingCompetion(CarRacingCompetition carRacingCompetition){
        String strAccelCount = null;
        while (true) {
            try {
                strAccelCount = (CarRacingView.readAccelCount());
                break;
            } catch (IllegalArgumentException e) {
                ExceptionWrapper.getWrapMessage(e);
            }
        }
        return carRacingCompetition.startRacing(strAccelCount);
    }
}

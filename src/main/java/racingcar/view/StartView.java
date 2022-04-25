package racingcar.view;

import racingcar.constant.RacingConstant;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;

import java.util.List;

public class StartView {



    public void showRacingGame(RacingGame racingGame) {
        System.out.println(RacingConstant.MESSAGE_EXCUTE_RESULT);
        for (int i = 0; i < racingGame.getRacingRound(); i++) {
            showRacingRound(racingGame.getRacingCars());
            System.out.println(); // 한줄 띄움
        }
        showWinner(racingGame.getRacingCars());
    }

    private void showRacingRound(RacingCars racingCars) {
        for (int i = 0; i < racingCars.getCarsCount(); i++) {
            Car car = racingCars.getCar(i);
            car.move();
            String carDash = getDashByCarPosition(car);
            System.out.println(racingCars.getCarName(i) + RacingConstant.MESSAGE_COLON + carDash);
        }
    }

    private String getDashByCarPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getCountByCarPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    private void showWinner(RacingCars racingCars) {
        System.out.println(RacingConstant.MESSAGE_WINNER + racingCars.getWinnerCarName());
    }

}

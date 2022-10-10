package racingcar.view;

import racingcar.Constans;
import racingcar.model.Car;
import racingcar.model.RacingData;

import java.util.Iterator;
import java.util.List;

public class RacingView {
    public static void viewStatusRacingCar(Car car) {
        System.out.print(car.getName()+" : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(Constans.SIMBOL_GO_STATUS.getMessage());
        }
        System.out.println();
    }

    public static void viewStatusRacing(RacingData racingData) {
        if (racingData.getTrys() < 0) {
            return;
        }
        for (Car racingCar: racingData.getRacingCarlist()) {
            RacingView.viewStatusRacingCar(racingCar);
        }
        System.out.println();
    }

    public static void viewWinners(List<Car> winners) {
        System.out.print(Constans.MESSGAE_GAME_WINNER_PREFIX.getMessage());
        Iterator<Car> iter = winners.iterator();
        Car winner = iter.next();
        System.out.print(winner.getName());
        while(iter.hasNext()) {
            System.out.print(Constans.DELEMITER.getMessage()+" ");
            winner = iter.next();
            System.out.print(winner.getName());
        }
        System.out.println();
    }
}

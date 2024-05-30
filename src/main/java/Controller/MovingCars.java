package Controller;

import Model.RacingCarsVO;
import View.RacingViews;
import java.util.*;

public class MovingCars {

    private RacingViews view;
    private Random random;

    public MovingCars(RacingViews view, Random random) {
        this.view = view;
        this.random = random;
    }

    public void movingCar(RacingCarsVO[] cars, int attempts) {
        view.displayResult("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (RacingCarsVO car : cars) {
                int move = random.nextInt(10);
                car.setMove(move);
                view.displayResult(car.toString());
            }
            System.out.println();
        }
    }
}
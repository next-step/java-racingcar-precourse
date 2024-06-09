package view;

import model.RacingCar;

import java.util.ArrayList;

public class CarRacingView {

    private static final String SHOW_WINNER_MSG = "최종 우승자 : ";
    public void displayRacingCars(ArrayList<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void displayWinners(String[] winners) {
        System.out.print(SHOW_WINNER_MSG);

        for (int i = 0; i < winners.length; i++) {
            System.out.print(winners[i]);
            if (i < winners.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

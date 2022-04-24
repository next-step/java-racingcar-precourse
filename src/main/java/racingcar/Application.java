package racingcar;

import racingcar.domain.RaceManager;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RaceManager raceManager = new RaceManager();
        raceManager.generateCars(scanner);
        raceManager.setRaceCount(scanner);
    }
}

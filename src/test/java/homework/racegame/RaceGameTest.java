package homework.racegame;

import homework.racegame.domain.Car;
import homework.racegame.domain.CarGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceGameTest {

    private String carNames;
    private String tryCount;

    @BeforeEach
    public void beforeEach() {
        carNames = "abc,235a,vdrg,22wdvss,aasdg,ddd\nabc,235a,vdrg,22wdv,aasdg,ddd";
        tryCount = "a\n3a\n\naccs\n%A12\n^a\n5";
    }

    @Test
    public void getCarNamesTest() {
        String[] names = new String[]{"abc", "235a", "vdrg", "22wdv", "aasdg", "ddd"};
        Scanner scanner = new Scanner(carNames);
        RaceGame raceGame = new RaceGame();
        String[] carNames = raceGame.getCarNames(scanner);
        for (int index = 0; index < carNames.length; index++) {
            Assertions.assertThat(names[index]).isEqualTo(carNames[index]);
        }
        scanner.close();
    }

    @Test
    public void getTryCountTest() {
        Scanner scanner = new Scanner(tryCount);
        RaceGame raceGame = new RaceGame();
        Assertions.assertThat(raceGame.getTryCount(scanner)).isEqualTo(12);
        scanner.close();
    }

    @Test
    public void printWinnersTest() {
        Scanner scanner = new Scanner(tryCount);
        RaceGame raceGame = new RaceGame();
        raceGame.printWinners(null);
        raceGame.printWinners(new ArrayList<>());
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ABC"));
        cars.add(new Car("abc"));
        raceGame.printWinners(cars);
        scanner.close();
    }

    @Test
    public void runTest() {
        Scanner carScanner = new Scanner(carNames);
        Scanner tryCountScanner = new Scanner(tryCount);
        RaceGame raceGame = new RaceGame();
        String[] carNames = raceGame.getCarNames(carScanner);
        int tryCount = raceGame.getTryCount(tryCountScanner);
        CarGroup carGroup = new CarGroup(carNames);
        for (int index = 0; index < tryCount; index++) {
            carGroup.moveOrStopCars();
            carGroup.printCarsProgress();
        }
        raceGame.printWinners(carGroup.getWinners());
        carScanner.close();
        tryCountScanner.close();
    }
}

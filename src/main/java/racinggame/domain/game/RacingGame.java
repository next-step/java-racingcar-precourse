package racinggame.domain.game;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import racinggame.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int limitCount;
    private List<Car> participationCarList = new ArrayList<>();
    private List<String> lastGameWinners = new ArrayList<>();
    private int maxLocation = 0;

    public RacingGame(String strCarNames, int limitCount) {
        String[] carNames = strCarNames.split(",");
        createCar(carNames);
        this.limitCount = limitCount;
    }

    public void gameStart() {
        if (lastGameWinners.size() > 0) lastGameWinners.clear();

        for (int i = 0; i < limitCount; i++) {
            for (Car car : participationCarList) {
                moveCarByNum(car, getRandomNumber());
                int location = car.getLocation();
                if (location > maxLocation) maxLocation = location;
            }

            logExcuteResult();
        }

        logGameWinners();
    }

    private void logExcuteResult() {
        for (Car car : participationCarList) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }


    private void logGameWinners() {
        String winners = "";
        if (maxLocation > 0) {
            for (Car car : participationCarList) {
                if (car.getLocation() == maxLocation) winners += "," + car.getCarName();
            }
        }
        winners = winners.replaceFirst(",", "");
        System.out.println("최종 우승자는 " + winners + " 입니다.");
    }

    private void createCar(String[] carNames) {
        for (String carName : carNames) {
            if (!Car.isAvailableCarName(carName)) carName = getNormalCarName(carName);

            Car car = new Car(carName);
            participationCarList.add(car);
        }
    }

    private String getNormalCarName(String carName) {
        while (!Car.isAvailableCarName(carName)) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            carName = Console.readLine();
        }
        return carName;
    }

    public static boolean isAvailableCarNames(String strCarNames) {
        String[] carNames = strCarNames.split(",");
        for (String carName : carNames) {
            if (!Car.isAvailableCarName(carName)) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
                return false;
            }
        }

        return true;
    }

    public static void moveCarByNum(Car car, int number) {
        if (Car.canMoveCarByNum(number)) {
            car.moveCar();
        }
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


    public List<Car> getParticipationCarList() {
        return participationCarList;
    }

    public List<String> getLastGameWinners() {
        return lastGameWinners;
    }
}

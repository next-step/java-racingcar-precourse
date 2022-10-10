package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarsInRace {
    private List<Car> cars;

    public CarsInRace() {
        cars = new ArrayList<>();
    }

    public CarsInRace(String carsNameString) {
        cars = new ArrayList<>();
        carList(carsNameString);
    }

    public boolean areCarsNameCollect() {
        try {
            cars.forEach(Car::isCarNameCollect);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return false;
        }

        return true;
    }

    public void allCarGoOrStop() {
        cars.forEach((car -> {
            car.goOrStop(CarStatus.stopOrGo());
            System.out.println(car.printStatusString());
        }));
    }

    public String winnerString() {
        int maxMoveDistance = winnerMoveDistance();
        String winnerString = "";

        for (Car car : cars) {
            winnerString = concatCarNameIfWinner(maxMoveDistance, winnerString, car);
        }

        return winnerString;
    }

    private String concatCarNameIfWinner(int maxMoveDistance, String winnerString, Car car) {
        if (car.getMoveDistance() == maxMoveDistance) {
            winnerString = concatCarName(winnerString, car);
        }
        return winnerString;
    }

    private String concatCarName(String winnerString, Car car) {
        if (!winnerString.equals("")) {
            winnerString += ",";
        }
        winnerString += car.getCarName();

        return winnerString;
    }

    private int winnerMoveDistance() {
        MoveDistance moveDistance = new MoveDistance();
        for (Car car : cars) {
            moveDistance.saveIfParameterValueGreater(car.getMoveDistance());
        }
        return moveDistance.getMoveDistance();
    }

    public void enterCarsName() {
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carsNameString = readLine();

            carList(carsNameString);
        } while (!areCarsNameCollect());
    }

    private void carList(String carsNameString) {
        String[] carsNameArray = carsNameString.split(",");
        for (String carName : carsNameArray) {
            Car newCar = new Car(carName);

            cars.add(newCar);
        }
    }
}

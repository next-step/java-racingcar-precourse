package racinggame;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    int maxPlace = 0;
    List<Car> winnerCars = new ArrayList<>();

    public void play() {
        int rollCount = 0;
        List<Car> cars = new ArrayList<>();
        // carClass, gameClass
        while (cars.size() < 2) {
            cars = inputToCarList();
        }
        // rollCount
        while (rollCount == 0) {
            rollCount = inputRollCount();
        }
        // moveCar, printCarsPlace
        moveCars(cars, rollCount);
        System.out.println(printCarsPlace(cars));
        // printWinner
        System.out.println("최종 우승자는 " + printWinnerResult(cars) + " 입니다. ");
        while (rollCount == 0) {
            rollCount = inputRollCount();
        }
    }

    public int inputRollCount() {
        int rollCount = 0;
        System.out.println("시도할 회수는 몇 회인가요?");
        String inputRollCountString = Console.readLine();
        try {
            if (!inputRollCountString.matches("[0-9]+")) {
                throw new IllegalArgumentException("[ERROR] 숫자 외의 문자가 입력되었습니다. 숫자를 입력해주세요.");
            }
            rollCount = Integer.parseInt(inputRollCountString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return rollCount;
    }

    // carClass
    public List<Car> inputToCarList() throws IllegalArgumentException {
        List<Car> cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
        List<String> inputList = Arrays.asList(Console.readLine().split(","));
        try {
            if (inputList.size() < 2) throw new IllegalArgumentException("[ERROR] 자동차 수가 부족합니다. ");
            inputList.forEach(s -> {
                cars.add(new Car(s));
            });
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    //moveCar
    public void moveCars(List<Car> cars, int rollCount) {
        System.out.println("프로그램 실행 결과");
        for (int i = 0; i < rollCount; i++) {
            cars.forEach(car -> car.moveCar());
            printCarsPlace(cars);
        }
    }


    //printCarPlace
    public String printCarsPlace(List<Car> cars) {
        String result = "";
        for (Car car : cars) {
            result = result + car.getPlaceToString() + "\n";
        }
        return result;
    }

    //printWinner
    public String printWinnerResult(List<Car> cars) {
        for (Car car : cars) {
            setMaxPlace(car.getPlace());
        }
        cars.forEach(car -> addWinnerCar(car));

        String winnerString = carsToString(winnerCars);
        return winnerString;
    }

    public String carsToString(List<Car> cars) {
        String winnerCarString = "";
        for (Car car : cars) {
            winnerCarString = winnerCarString + ", " + car.getName();
        }
        winnerCarString = winnerCarString.substring(2, winnerCarString.length());
        return winnerCarString;
    }


    public void setMaxPlace(int maxPlace) {
        if (this.maxPlace < maxPlace) this.maxPlace = maxPlace;
    }

    public void addWinnerCar(Car car) {
        if (car.getPlace() == this.maxPlace) winnerCars.add(car);
    }
}

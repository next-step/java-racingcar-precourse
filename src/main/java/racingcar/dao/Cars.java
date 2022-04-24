package racingcar.dao;


import racingcar.vo.Car;
import racingcar.vo.Name;
import racingcar.vo.Speed;

import java.util.*;

public class Cars {
    private List<Car> cars;
    private Set<Integer> carSet;

    public Cars() {
        cars = new ArrayList<>();
        carSet = new HashSet<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void printWinners() {
        Collections.sort(cars);
        if (isWinnerSingle()) {
            Name winner = printSingleWinner();
            System.out.println("최종 우승자: " + winner.getName());
            return;
        }
        Name winners = printMultipleWinners();
        System.out.println("최종 우승자: " + winners.getName());

    }

    // test private -> public
    private Name printSingleWinner() {
        return cars.get(0).getCarName();
    }

    private Name printMultipleWinners() {
        System.out.println("printMultipleWinners() = ");
        Name winners = new Name();
        Car firstCar = cars.get(0);
        winners.setSingleName(firstCar.getCarName().getName());
        System.out.println("winners = " + winners.getName());
        winners.setMultipleName(cars);

        for (int i = 1; i < cars.size(); i++) {
            checkWinners(winners, firstCar.getCurrentPosition().getPosition(), cars.get(i));
        }
        return winners;
    }

    private void checkWinners(Name winners, int firstPosition, Car currentCar) {
        if (currentCar.getCurrentPosition().getPosition() == firstPosition) {
            winners.setMultipleName(currentCar.getCarName().getName());
        }
    }

    private boolean isWinnerSingle() {
        boolean isWinnerSingle = true;
        Car setFirstCar = cars.get(0);
        Car setSecondCar = cars.get(0);
        if (cars.size() > 1) {
            setSecondCar = cars.get(1);
        }

        if (setFirstCar.getCurrentPosition().getPosition() == setSecondCar.getCurrentPosition().getPosition() && cars.size() > 1) {
            isWinnerSingle = false;
        }


        for (int i = 0; i < cars.size(); i++) {
            Car setCar = cars.get(i);
            carSet.add(setCar.getCurrentPosition().getPosition());
        }
        System.out.println("carSet.size() = " + carSet.size());
        System.out.println("cars = " + cars.size());

        return isWinnerSingle;
    }

    public void carFunction() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            Speed currentSpeed = new Speed();
            car.getCurrentPosition().addCurrentSpeed(currentSpeed.getForward());
            car.printCar();
        }
        System.out.println();
    }

    public void add(Car car) {
        cars.add(car);
    }
}

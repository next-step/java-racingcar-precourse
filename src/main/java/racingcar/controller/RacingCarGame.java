package racingcar.controller;

import racingcar.config.Message;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;

public class RacingCarGame {

    Cars cars;

    public RacingCarGame setCars(Cars cars) {
        this.cars = cars;
        return this;
    }

    private void checkPrepareCars(){
        if(cars == null){
            throw new IllegalStateException(Message.ERROR_CARS_NULL);
        }
    }

    public void play() {
        checkPrepareCars();

        for (Car car : cars.getCars()){
            car.move();
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public String findWinner() {
        int winnerCnt = cars.getMaxLocation();

        return addWinner(1, winnerCnt, cars.getCar(0).getName());
    }

    private String addWinner(int index, int winnerCnt, String result){
        if(cars.getCars().get(index).getLocation() == winnerCnt){
            result += Message.FORMAT_WINNER_EACH + cars.getCars().get(index).getName();
        }
        if(index + 1 >= cars.getCars().size()){
            return result;
        }
        return addWinner(++index, winnerCnt, result);
    }



}

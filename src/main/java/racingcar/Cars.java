package racingcar;

import java.util.ArrayList;
import java.util.List;



import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
    public static final String seperator = ",";

    private final List<Car_Name_Position> cars
            = new ArrayList<>();

    private static String[] inputName(){
        return Console.readLine().split(seperator);
    }

    public void makeCar(){

        String[] carName = inputName();

        try {
            for (String car : carName) {
                Car_Name_Position carNamePosi = new Car_Name_Position(car);
                cars.add(carNamePosi);
            }
        }catch (IllegalArgumentException e){
            makeCar();
        }
    }

    public void move(){
        cars.stream().forEach(Car_Name_Position::move);
    }

    public void showState(){
        cars.stream().forEach(System.out::println);
        System.out.println();
    }

    private int getPosition() {
        int goodPosition = 0;
        for (Car_Name_Position car : cars) {
            goodPosition = Math.max(goodPosition, car.getPosition());
        }
        return goodPosition;
    }

    public List<String> getWinners(){
        return cars.stream()
                .filter(car -> car.isSamePosition(getPosition()))
                .map(Car_Name_Position::getName)
                .collect(Collectors.toList());
    }

}

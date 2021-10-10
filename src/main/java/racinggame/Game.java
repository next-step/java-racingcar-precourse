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
        while(cars.size() < 2){
            cars = inputToCarList();
        }
        // rollCount
        while(rollCount == 0) {
            rollCount = inputRollCount();
        }
        // moveCar, printCarsPlace
        moveCars(cars, rollCount);
        // printWinner
        printWinnerResult(cars);
        while(rollCount == 0) {
            rollCount = inputRollCount();
        }
    }
    private int inputRollCount() {
        int rollCount =0 ;
        System.out.println("시도할 회수는 몇 회인가요?");
        String inputRollCountString = Console.readLine();
        try {
            if (!inputRollCountString.matches("[0-9]+")) {
                throw new IllegalArgumentException("[ERROR] 숫자 외의 문자가 입력되었습니다. 숫자를 입력해주세요.");
            }
            rollCount  = Integer.parseInt(inputRollCountString);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return rollCount ;
    }

    // carClass
    private List<Car> inputToCarList() throws IllegalArgumentException{
        List<Car> cars  = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
        List<String> inputList = Arrays.asList(Console.readLine().split(","));
        try{
            if (inputList.size() < 2) throw new IllegalArgumentException("[ERROR] 자동차 수가 부족합니다. ");
            inputList.forEach(s -> {
                cars.add(new Car(s));
            });
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return cars;
    }
